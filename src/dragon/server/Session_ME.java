package dragon.server;

import io.IMessageHandler;
import io.ISession;
import io.Message;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import dragon.t.ArchivementTask;
import dragon.t.Char;
import dragon.t.DuaHau;
import dragon.t.Friend;
import dragon.t.Item;
import dragon.t.Memory;
import dragon.t.Rada;
import dragon.t.SetSQL;
import dragon.t.Util;

/**
 *
 * @author Admin
 */
public class Session_ME implements ISession {
    
    private final byte[] key = "rose".getBytes();
    
    private boolean getKeyComplete = false;
    public Socket sc;
    protected DataInputStream dis;
    protected DataOutputStream dos;
    protected int id;
    Char myChar;
    private boolean connected;
    private byte curR;
    private byte curW;
    private final Sender sender;
    private Thread collectorThread;
    protected Thread sendThread;
    protected int sendByteCount;
    protected int recvByteCount;
    private final IMessageHandler controller;
    public final Service service;
    
    protected boolean isSetClient = false;
    protected byte typeClient;
    protected byte zoomLevel;
    protected boolean b;
    protected int w;
    protected int h;
    protected boolean isQwerty;
    protected boolean isTouch;
    protected String platform;
    protected String version;
    public int loginFaid;
    public int versionInt = -1;
    
    public int timeDisconnect;
    public boolean isLoad = true;
    public long l;
    public int status;
    public boolean isSave;
    private int delay;
    public boolean isLogin;
    public int userId = -1;
    public String userName = null;
    public int isLock = 0;
    public int isAdmin = 0;
    public boolean isBackup = false;
    private final long curr;
    
    private final Updater updater;
    
    private class Sender implements Runnable {

        private final ArrayList<Message> sendingMessage;

        protected Sender() {
            this.sendingMessage = new ArrayList<>();
        }

        protected void AddMessage(Message message) {
            if (isConnected()) {
                this.sendingMessage.add(message);
            }
        }

        @Override
        public void run() {
            try {
                while(isConnected()) {
                    while(!this.sendingMessage.isEmpty() && isConnected()) {
                        Message m = this.sendingMessage.remove(0);
                        if (m != null) {
                            doSendMessage(m);
                        }
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(Server.SESSION_DELAY_MILISECOND);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
            } catch (Exception e) {
            }
            disconnect();
        }
    }
    
    private class Updater extends Thread {

        private long last;
        
        private final ArrayList<Message> recevingMessage;

        protected Updater() {
            this.recevingMessage = new ArrayList<>();
            this.last = l = System.currentTimeMillis();
        }

        protected void AddMessage(Message message) {
            if (isConnected()) {
                this.recevingMessage.add(message);
            }
        }
        
        @Override
        public void run() {
            try {
                while(isConnected()) {
                    status = 0;
                    this.last = l = System.currentTimeMillis();
                    //controller
                    status = 1;
                    if (this.recevingMessage.size() > 0 && Server.start) {
                        if (this.recevingMessage.size() <= 500) {
                            Message message = this.recevingMessage.remove(0);
                            if (message != null) {
                                controller.onMessage(message);
                                message.cleanup();
                            }
                        } else {
                            disconnect();
                        }
                    }
                    //updater
                    update();
                    try {
                        TimeUnit.MILLISECONDS.sleep(Server.SESSION_DELAY_MILISECOND);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    status = 4;
                    delay = (int) (System.currentTimeMillis() - this.last);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            status = -1;
            close();
        }
    }

    private class MessageCollector implements Runnable {
        @Override
        public void run() {
            try {
                while(isConnected()) {
                    Message message = readMessage();
                    updater.AddMessage(message);
                }
            } catch(IOException ex) {
            } catch (Exception ex) {
                
            }
            disconnect();
        }
        
        private Message readMessage() throws IOException {
            byte cmd = dis.readByte();
            if (getKeyComplete) {
                cmd = readKey(cmd);
            }
            int size;
            if (getKeyComplete) {
                byte b1 = dis.readByte();
                byte b2 = dis.readByte();
                size = (readKey(b1) & 255) << 8 | readKey(b2) & 255;
            } else {
                size = dis.readUnsignedShort();
            }
            byte data[] = new byte[size];
            int len = 0;
            int byteRead = 0;
            while (len != -1 && byteRead < size) {
                len = dis.read(data, byteRead, size - byteRead);
                if (len > 0) {
                    byteRead += len;
                }
            }
            if (getKeyComplete) {
                for (int i = 0; i < data.length; i++) {
                    data[i] = readKey(data[i]);
                }
            }
            recvByteCount += 5 + size;
            Message msg = new Message(cmd, data);
            return msg;
        }
    }
    
    protected Session_ME(Socket sc, int id) throws IOException {
        this.sc = sc;
        this.id = id;
        this.dis = new DataInputStream(sc.getInputStream());
        this.dos = new DataOutputStream(sc.getOutputStream());
        this.connected = true;
        this.sendThread = new Thread(this.sender = new Sender());
        this.collectorThread = new Thread(new MessageCollector());
        this.controller = new Controller(this);
        this.service = new Service(this);
        this.timeDisconnect = 180000;
        this.updater = new Updater();
        this.isLogin = false;
        this.curr = System.currentTimeMillis();
        
        
    }
    
    public void run() {
        this.sendThread.start();
        this.collectorThread.start();
        this.updater.start();
    }
    
    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void sendMessage(Message message) {
        if (isConnected()) {
            sender.AddMessage(message);
        }
    }

    private void doSendMessage(Message message) throws IOException {
        byte[] data = message.getData();
        byte cmd = message.getCommand();
        if (data != null) {
            int size = data.length;
            if (getKeyComplete) {
                dos.writeByte(writeKey(cmd));
            } else {
                dos.writeByte(cmd);
            }
            if (cmd == -32 || cmd == -66 || cmd == 11 || cmd == -67 || cmd == -74 || cmd == -87 || cmd == 66) {
                byte num = writeKey((byte) (size));
                dos.writeByte(num - 128);
                byte num2 = writeKey((byte) (size >> 8));
                dos.writeByte(num2 - 128);
                byte num3 = writeKey((byte) (size >> 16));
                dos.writeByte(num3 - 128);
            } else {
                if (getKeyComplete) {
                    int byte1 = writeKey((byte) (size >> 8));
                    dos.writeByte(byte1);
                    int byte2 = writeKey((byte) (size & 255));
                    dos.writeByte(byte2);
                } else {
                    int byte1 = (byte) (size & 65280);
                    dos.writeByte(byte1);
                    int byte2 = (byte) (size & 255);
                    dos.writeByte(byte2);
                }
            }
            if (getKeyComplete) {
                for (int i = 0; i < size; i++) {
                    data[i] = writeKey(data[i]);
                }
            }
            dos.write(data);
            sendByteCount += 5 + data.length;
            if (Util.gI().debug) {
                Util.gI().logln("do mss "+cmd+" szie "+((sendByteCount+recvByteCount)/1024)+"."+((sendByteCount+recvByteCount)%1024/102)+" kb");
            }
        } else {
            this.sendByteCount += 5;
        }
        dos.flush();
    }

    private byte readKey(byte b) {
        byte i = (byte)((key[curR++] & 255) ^ (b & 255));
        if (curR >= key.length)
            curR %= key.length;
        return i;
    }

    private byte writeKey(byte b) {
        byte i = (byte)((key[curW++] & 255) ^ (b & 255));
        if (curW >= key.length)
            curW %= key.length;
        return i;
    }

    @Override
    public void close() {
        if (this.isLogin) {
            if (this.myCharz() != null) {
                this.myCharz().close();
                this.myCharz().myObj().petition = false;
                Server.gI().removeConn(this.myCharz().charID, this.myCharz().cName, this.myCharz().playerId);
            }
            Server.gI().removeConn(this.userId, this.userName);
        }
        Server.gI().removeConn(this);
        this.saveData();
        cleanNetwork();
    }

    private void cleanNetwork() {
        this.curR = 0;
        this.curW = 0;
        try {
            this.connected = false;
            if(this.sc != null) {
                this.sc.close();
                this.sc = null;
            }
            if (this.dos != null) {
                this.dos.close();
                this.dos = null;
            }
            if(this.dis != null) {
                this.dis.close();
                this.dis = null;
            }
            this.sendThread = null;
            this.collectorThread = null;
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Client "+this.id;
    }
    
    public void getKey() {
        try {
            Message msg = new Message(-27);
            msg.writer().writeByte(key.length);
            for (int i = 0; i < key.length; i++) {
                if (i == 0) {
                    msg.writer().writeByte(key[i]);
                } else {
                    msg.writer().writeByte(key[i] ^ key[i - 1]);
                }
            }
            msg.writer().writeUTF("username");//IP2
            msg.writer().writeInt(14445);//PORT2
            msg.writer().writeByte(0);//isConnect2
            
            doSendMessage(msg);
            msg.cleanup();
            this.getKeyComplete = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        this.connected = false;
    }
    
    public int getIntVersion() {
        if (this.versionInt == -1) {
            try {
                this.versionInt = Integer.parseInt(this.version.replace(".", "").split("\\|")[1]);
            } catch (Exception e) {
                this.versionInt = 0;
                System.out.println(this.version);
            }
        }
        return this.versionInt;
    }
    
    public Char myCharz() {
        return this.myChar;
    }
    
    private void saveData() {
        if (this.userId != -1) {
            Memory.get(this.userId).lastlogout = (int) (System.currentTimeMillis() / 1000L);
        }
        if (this.isBackup) {
            try {
                MySQL mySQL1 = MySQL.createData2();
                MySQL mySQL2 = MySQL.createData6();
                MySQL mySQL3 = MySQL.createData3();
                MySQL mySQL4 = MySQL.createData7();
                try {
                    try {
                        mySQL1.getConnection().setAutoCommit(false);
                        mySQL2.getConnection().setAutoCommit(false);
                        mySQL3.getConnection().setAutoCommit(false);
                        mySQL4.getConnection().setAutoCommit(false);
                        int playerId = -1;
                        if (this.myCharz() != null) {
                            playerId = this.myCharz().playerId;
                            //Write Skills
                            JSONArray jarr = new JSONArray();
                            for (int i = 0; i < this.myCharz().skills.size(); i++) {
                                JSONArray jarr2 = new JSONArray();
                                jarr2.add(this.myCharz().skills.get(i).skillId);
                                jarr2.add(this.myCharz().skills.get(i).lastTimeUseThisSkill);
                                if (this.myCharz().skills.get(i).template.type == 4) {
                                    jarr2.add(this.myCharz().skills.get(i).curExp);
                                }
                                jarr.add(jarr2);
                            }
                            //WRITE arrItemBag
                            JSONArray arrItemBag = new JSONArray();
                            for (int i = 0; i < this.myCharz().arrItemBag.length; i++) {
                                Item item1 = this.myCharz().arrItemBag[i];
                                if (item1 != null) {
                                    arrItemBag.add((JSONArray) JSONValue.parseWithException(item1.toString()));
                                }
                            }
                            //WRITE arrItemBox
                            JSONArray arrItemBox = new JSONArray();
                            for (int i = 0; i < this.myCharz().arrItemBox.length; i++) {
                                Item item2 = this.myCharz().arrItemBox[i];
                                if (item2 != null) {
                                    arrItemBox.add((JSONArray) JSONValue.parseWithException(item2.toString()));
                                }
                            }
                            //WRITE arrItemBody
                            JSONArray arrItemBody = new JSONArray();
                            for (int i = 0; i < this.myCharz().arrItemBody.length; i++) {
                                Item item3 = this.myCharz().arrItemBody[i];
                                if (item3 != null) {
                                    arrItemBody.add(((JSONArray)JSONValue.parseWithException(item3.toString())));
                                }
                            }
                            //WRITE KSkill
                            JSONArray KSkill = new JSONArray();
                            for (int i = 0; i < this.myCharz().KSkill.size(); i++) {
                                KSkill.add(this.myCharz().KSkill.get(i));
                            }
                            //WRITE OSkill
                            JSONArray OSkill = new JSONArray();
                            for (int i = 0; i < this.myCharz().OSkill.size(); i++) {
                                OSkill.add(this.myCharz().OSkill.get(i));
                            }
                            //WRITE KSkill
                            JSONArray CSkill = new JSONArray();
                            for (int i = 0; i < this.myCharz().CSkill.size(); i++) {
                                CSkill.add(this.myCharz().CSkill.get(i));
                            }
                            //WRITE itemTime
                            JSONArray itemTimes = new JSONArray();
                            if (!this.myCharz().isItemTime) {
                                this.myCharz().itemTime = this.myCharz().wit;
                            }
                            for (int i = 0; i < this.myCharz().itemTime.size(); i++) {
                                if (this.myCharz().itemTime.get(i).type != 0) {
                                    JSONArray itemTime = new JSONArray();
                                    itemTime.add(this.myCharz().itemTime.get(i).idIcon);
                                    itemTime.add(this.myCharz().itemTime.get(i).type);
                                    if (this.myCharz().itemTime.get(i).type == 2) {
                                        itemTime.add((((int)(System.currentTimeMillis() / 1000L)) + this.myCharz().itemTime.get(i).second));
                                    } else {
                                        itemTime.add(this.myCharz().itemTime.get(i).second);
                                    }
                                    if (this.myCharz().itemTime.get(i).item != null) {
                                        itemTime.add(-9999);
                                        itemTime.add((JSONArray) JSONValue.parseWithException(this.myCharz().itemTime.get(i).item.toString()));
                                    } else {
                                        itemTime.add(this.myCharz().itemTime.get(i).damage);
                                    }
                                    itemTimes.add(itemTime);
                                }
                            }
                            //arrAmu
                            JSONArray arrAmu = new JSONArray();
                            for (int i = 0; i < this.myCharz().arrAmu.size(); i++) {
                                JSONArray charms2 = new JSONArray();
                                charms2.add(this.myCharz().arrAmu.get(i).templateId);
                                charms2.add(this.myCharz().arrAmu.get(i).second);
                                arrAmu.add(charms2);
                            }
                            //WRITE arrItemMore
                            JSONArray arrItemMore = new JSONArray();
                            for (int i = 0; i < this.myCharz().arrItemMore.size(); i++) {
                                Item item5 = this.myCharz().arrItemMore.get(i);
                                if (item5 != null) {
                                    arrItemMore.add((JSONArray) JSONValue.parseWithException(item5.toString()));
                                }
                            }
                            for (int i = 0; i < this.myCharz().arrItemMore2.size(); i++) {
                                Item item5 = this.myCharz().arrItemMore2.get(i);
                                if (item5 != null) {
                                    arrItemMore.add((JSONArray) JSONValue.parseWithException(item5.toString()));
                                }
                            }
                            //cspeacialSkill
                            JSONArray cspeacialSkill = new JSONArray();
                            cspeacialSkill.add(this.myCharz().cspeacialSkill);
                            cspeacialSkill.add(this.myCharz().paramSpeacialSkill);
                            cspeacialSkill.add(this.myCharz().ncoinSpeacialSkill);
                            //arrFriend
                            JSONArray arrFriend = new JSONArray();
                            for (int i = 0; i < this.myCharz().arrFriend.size(); i++) {
                                Friend f = this.myCharz().arrFriend.get(i);
                                if (f != null) {
                                    JSONArray jf = new JSONArray();
                                    jf.add(f.playerId);
                                    jf.add(f.head);
                                    jf.add(f.headICON);
                                    jf.add(f.body);
                                    jf.add(f.leg);
                                    jf.add(f.bag);
                                    jf.add(f.name);
                                    jf.add(f.power);
                                    arrFriend.add(jf);
                                }
                            }
                            //WRITE items
                            JSONArray items = new JSONArray();
                            for (int i = 0; i < this.myCharz().items.size(); i++) {
                                Item item6 = this.myCharz().items.get(i);
                                if (item6 != null) {
                                    items.add((JSONArray) JSONValue.parseWithException(item6.toString()));
                                }
                            }
                            //WRITE radas
                            JSONArray radas = new JSONArray();
                            for (int i = 0; i < this.myCharz().radas.size(); i++) {
                                Rada r = this.myCharz().radas.get(i);
                                JSONArray rada = new JSONArray();
                                rada.add(r.id);
                                rada.add(r.amount);
                                rada.add(r.level);
                                rada.add(r.isUse);
                                radas.add(rada);
                            }
                            //WRITE Dua hau
                            JSONArray duahaus = new JSONArray();
                            for (int i = 0; i < this.myCharz().duahaus.size(); i++) {
                                DuaHau d = this.myCharz().duahaus.get(i);
                                JSONArray dh = new JSONArray();
                                dh.add(d.id);
                                //duahau
                                JSONArray duahau = new JSONArray();
                                int num = 0;
                                while(num < d.duahau.length) {
                                    duahau.add(d.duahau[num]);
                                    num++;
                                }
                                dh.add(duahau);
                                dh.add(d.duaHauIndex);
                                dh.add(d.last);
                                dh.add(d.second);
                                duahaus.add(dh);
                            }
                            //Push MySQL
                            SetSQL strSQL = new SetSQL("UPDATE `options` SET % WHERE `playerId` = '"+ this.myCharz().playerId +"' LIMIT 1;");
                            strSQL.addSet("head", this.myCharz().headDefault);
                            strSQL.addSet("ctaskId", this.myCharz().ctaskId);
                            strSQL.addSet("ctaskIndex", this.myCharz().ctaskIndex);
                            strSQL.addSet("ctaskCount", this.myCharz().ctaskCount);
                            strSQL.addSet("cPower", this.myCharz().cPower);
                            strSQL.addSet("cPowerLimit", this.myCharz().cPowerLimit);
                            strSQL.addSet("mapTemplateId", this.myCharz().mapTemplateId);
                            strSQL.addSet("cx", this.myCharz().cx);
                            strSQL.addSet("cy", this.myCharz().cy);
                            strSQL.addSet("nClassId", this.myCharz().nClassId);
                            strSQL.addSet("xu", this.myCharz().xu);
                            strSQL.addSet("luong", this.myCharz().luong);
                            strSQL.addSet("luongKhoa", this.myCharz().luongKhoa);
                            strSQL.addSet("cHPGoc", this.myCharz().cHPGoc);
                            strSQL.addSet("cMPGoc", this.myCharz().cMPGoc);
                            strSQL.addSet("cHP", this.myCharz().cHP);
                            strSQL.addSet("cMP", this.myCharz().cMP);
                            strSQL.addSet("cDamGoc", this.myCharz().cDamGoc);
                            strSQL.addSet("cDefGoc", this.myCharz().cDefGoc);
                            strSQL.addSet("cCriticalGoc", this.myCharz().cCriticalGoc);
                            strSQL.addSet("cTiemNang", this.myCharz().cTiemNang);
                            strSQL.addSet("skills", Util.gI().stringSQL(jarr.toJSONString()));
                            strSQL.addSet("arrItemBody", Util.gI().stringSQL(arrItemBody.toJSONString()));
                            strSQL.addSet("typeTeleport", this.myCharz().typeTeleport);
                            strSQL.addSet("KSkill", Util.gI().stringSQL(KSkill.toJSONString()));
                            strSQL.addSet("OSkill", Util.gI().stringSQL(OSkill.toJSONString()));
                            strSQL.addSet("CSkill", Util.gI().stringSQL(CSkill.toJSONString()));
                            strSQL.addSet("itemTimes", Util.gI().stringSQL(itemTimes.toJSONString()));
                            strSQL.addSet("cStamina", this.myCharz().cStamina);
                            strSQL.addSet("cMaxStamina", this.myCharz().cMaxStamina);
                            strSQL.addSet("cspeacialSkill", Util.gI().stringSQL(cspeacialSkill.toJSONString()));
                            strSQL.addSet("clanId", this.myCharz().getClanId());
                            strSQL.addSet("securityCode", this.myCharz().securityCode);
                            strSQL.addSet("timeSecurity", this.myCharz().timeSecurity);
                            strSQL.addSet("items", Util.gI().stringSQL(items.toJSONString()));
                            strSQL.addSet("lastTime", this.myCharz().lastTime);
                            strSQL.addSet("clanPoint", this.myCharz().clanPoint);
                            strSQL.addSet("pointEvent", this.myCharz().pointEvent);
                            strSQL.addSet("radas", Util.gI().stringSQL(radas.toJSONString()));
                            strSQL.addSet("totalGold", this.myCharz().totalGold);
                            strSQL.addSet("isCan", this.myCharz().isCan);
                            strSQL.addSet("yesterday", this.myCharz().yesterday);
                            strSQL.addSet("timeReceiveNamek", this.myCharz().timeReceiveNamek);
                            strSQL.addSet("pointVip", this.myCharz().pointVip);
                            strSQL.addSet("maxXu", this.myCharz().maxXu);
                            
                            mySQL2.getConnection().prepareStatement(strSQL.toSQL()).executeUpdate();
                            //Dua hau
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_DUAHAUS, Util.gI().stringSQL(duahaus.toJSONString()), this.myCharz().playerId)).executeUpdate();
                            //arrItemBag
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_ARRITEMBAGS, this.myCharz().bagcount, Util.gI().stringSQL(arrItemBag.toJSONString()), this.myCharz().playerId)).executeUpdate();
                            //arrItemBox
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_ARRITEMBOXS, this.myCharz().boxcount, Util.gI().stringSQL(arrItemBox.toJSONString()), this.myCharz().playerId)).executeUpdate();
                            //arrItemMore
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_ARRITEMMORES, Util.gI().stringSQL(arrItemMore.toJSONString()), this.myCharz().playerId)).executeUpdate();
                            //magicTree
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_MAGICTREES, this.myCharz().magicTree_level, this.myCharz().magicTree_currPeas, this.myCharz().magicTree_miliseconds, this.myCharz().magicTree_isUpdate, this.myCharz().playerId)).executeUpdate();
                            //arrFriend
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_ARRFRIENDS, Util.gI().stringSQL(arrFriend.toJSONString()), this.myCharz().playerId)).executeUpdate();
                            //arrAmu
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_ARRAMUS, Util.gI().stringSQL(arrAmu.toJSONString()), this.myCharz().playerId)).executeUpdate();
                            //Petz
                            if (this.myCharz().myPet != null) {

                                JSONArray petzarrItemBody = new JSONArray();
                                for (int i = 0; i < this.myCharz().myPet.arrItemBody.length; i++) {
                                    Item item4 = this.myCharz().myPet.arrItemBody[i];
                                    if (item4 != null) {
                                        petzarrItemBody.add((JSONArray) JSONValue.parseWithException(item4.toString()));
                                    }
                                }
                                JSONArray jarr2 = new JSONArray();
                                for (int i = 0; i < this.myCharz().myPet.skills.size(); i++) {
                                    JSONArray jarr3 = new JSONArray();
                                    jarr3.add(this.myCharz().myPet.skills.get(i).skillId);
                                    jarr3.add(this.myCharz().myPet.skills.get(i).lastTimeUseThisSkill);
                                    if (this.myCharz().myPet.skills.get(i).template.type == 4) {
                                        jarr3.add(this.myCharz().myPet.skills.get(i).curExp);
                                    }
                                    jarr2.add(jarr3);
                                }
                                mySQL3.getConnection().prepareStatement(String.format(
                                        mResources.UPDATE_PETZS,
                                        Util.gI().stringSQL(this.myCharz().myPet.cName),
                                        this.myCharz().myPet.headDefault,
                                        this.myCharz().myPet.bodyDefault,
                                        this.myCharz().myPet.legDefault,
                                        this.myCharz().myPet.cPower,
                                        this.myCharz().myPet.cPowerLimit,
                                        this.myCharz().myPet.cgender,
                                        this.myCharz().myPet.nClassId,
                                        this.myCharz().myPet.cHPGoc,
                                        this.myCharz().myPet.cMPGoc,
                                        this.myCharz().myPet.cDamGoc,
                                        this.myCharz().myPet.cDefGoc,
                                        this.myCharz().myPet.cCriticalGoc,
                                        this.myCharz().myPet.cTiemNang,
                                        this.myCharz().myPet.petStatus,
                                        this.myCharz().myPet.cHP,
                                        this.myCharz().myPet.cMP,
                                        this.myCharz().myPet.cStamina,
                                        this.myCharz().myPet.cMaxStamina,
                                        this.myCharz().myPet.timeHS,
                                        this.myCharz().myPet.timeHopThe,
                                        this.myCharz().myPet.isBaby,
                                        this.myCharz().myPet.isHopThe,
                                        Util.gI().stringSQL(petzarrItemBody.toJSONString()),
                                        Util.gI().stringSQL(jarr2.toJSONString()),
                                        this.myCharz().myPet.isMabu,
                                        this.myCharz().playerId
                                )).executeUpdate();
                            } else {
                                mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_PETZS2, this.myCharz().playerId)).executeUpdate();
                            }
                            
                            //WRITE arrTask
                            JSONArray arrTask = new JSONArray();
                            for (int i = 0; i < this.myCharz().archivements.size(); i++) {
                                ArchivementTask t = this.myCharz().archivements.get(i);
                                JSONArray tj = new JSONArray();
                                tj.add(t.id);
                                tj.add(t.count);
                                tj.add(t.isFinish);
                                tj.add(t.isRecieve);
                                arrTask.add(tj);
                            }
                            //arrTask
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_ARRTASKS, Util.gI().stringSQL(arrTask.toJSONString()), this.myCharz().playerId)).executeUpdate();
                            
                            //WRITE textTime
                            JSONArray textTimes = new JSONArray();
                            if (!this.myCharz().isTextTime) {
                                this.myCharz().textTime = this.myCharz().wtxt;
                            }
                            for (int i = 0; i < this.myCharz().textTime.size(); i++) {
                                if (this.myCharz().textTime.get(i).type != 0) {
                                    JSONArray textTime = new JSONArray();
                                    textTime.add(this.myCharz().textTime.get(i).idIcon);
                                    textTime.add(this.myCharz().textTime.get(i).text);
                                    textTime.add(this.myCharz().textTime.get(i).type);
                                    if (this.myCharz().textTime.get(i).type == 2) {
                                        textTime.add((((int)(System.currentTimeMillis() / 1000L)) + this.myCharz().textTime.get(i).second));
                                    } else {
                                        textTime.add(this.myCharz().textTime.get(i).second);
                                    }
                                    if (this.myCharz().textTime.get(i).item != null) {
                                        textTime.add(-9999);
                                        textTime.add((JSONArray) JSONValue.parseWithException(this.myCharz().textTime.get(i).item.toString()));
                                    } else {
                                        textTime.add(this.myCharz().textTime.get(i).damage);
                                    }
                                    textTimes.add(textTime);
                                }
                            }
                            mySQL3.getConnection().prepareStatement(String.format(mResources.UPDATE_ARRTEXTTIME, Util.gI().stringSQL(textTimes.toJSONString()), this.myCharz().playerId)).executeUpdate();//WRITE textTime
                            //EffChar
                            JSONArray effChar = new JSONArray();
                            for (int i = 0; i < this.myCharz().aEffChar.size(); i++) {
                                if (this.myCharz().aEffChar.get(i).isSave) {
                                    effChar.add((JSONArray) JSONValue.parseWithException(this.myCharz().aEffChar.get(i).toString()));
                                }
                            }
                            mySQL4.getConnection().prepareStatement(String.format("UPDATE `effchar` SET `arrEffect` = '%s' WHERE `playerId` = '%d' LIMIT 1", Util.gI().stringSQL(effChar.toJSONString()), this.myCharz().playerId)).executeUpdate();
                        }
                        mySQL1.getConnection().prepareStatement(String.format(mResources.UPDATE_USER, playerId, this.isLock, this.sc.getInetAddress().getHostAddress(), this.isLoad, this.userId)).executeUpdate();
                        mySQL1.getConnection().commit();
                        mySQL2.getConnection().commit();
                        mySQL3.getConnection().commit();
                        mySQL4.getConnection().commit();
                    } catch (SQLException e) {
                        mySQL1.getConnection().rollback();
                        mySQL2.getConnection().rollback();
                        mySQL3.getConnection().rollback();
                        mySQL4.getConnection().rollback();
                        e.printStackTrace();
                    }
                } finally {
                    mySQL1.close();
                    mySQL2.close();
                    mySQL3.close();
                    mySQL4.close();
                }
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void update() {
        this.status = 2;
        if (this.isSave) {
            this.isSave = false;
            this.saveData();
        }
        this.status = 3;
        //Timeout
        if (this.timeDisconnect != -1) {
            this.timeDisconnect -= this.delay;
            if (this.timeDisconnect <= 0) {
                this.timeDisconnect = 0;
                this.disconnect();
            }
        }
        if (this.myCharz() != null) {
            this.myCharz().delay = this.delay;
            this.myCharz().update();
            if (this.myCharz().myPet != null) {
                this.myCharz().myPetz().delay = this.delay;
                this.myCharz().myPetz().update();
            }
        }
//        if (System.currentTimeMillis() - this.curr > 500 && this.zoomLevel == 0) {
//            this.disconnect();
//        }
    }
    
}
