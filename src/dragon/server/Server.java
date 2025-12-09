package dragon.server;

import dragon.t.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Admin
 */
public class Server extends Thread {
    
    protected static ServerSocket server;
    public static boolean start;
    protected static int id;
    
    public final ArrayList<Session_ME> connList;
    public final HashMap<String, Session_ME> connUName;
    public final HashMap<Integer, Session_ME> connUId;
    public final HashMap<String, Session_ME> connCName;
    public final HashMap<Integer, Session_ME> connCId;
    public final HashMap<Integer, Session_ME> connPId;
    private final ArrayList<String> iscName;
    
    public final ArrayList<KhiHuyDiet> destronGas;
    public final ArrayList<KhiHuyDiet> destronGas2;
    public final ArrayList<KhoBau> khobau;
    public final ArrayList<KhoBau> khobau2;
    public final ArrayList<Instancing> phoban;
    public final ArrayList<DoanhTrai> doanhTrais;
    public final ArrayList<DoanhTrai> doanhTrais2;
    public final ArrayList<Player> playerCls;
    public final ArrayList<Clan> clans;
    public final ArrayList<Map> maps;
    public int gold_value;
    public int[] arrMapMabu = new int[]{0, 7, 14};
    public boolean isBigBoss;
    public int timeXongBigBoss;
    public boolean isButcher;
    public int timeXongButcher;
    public int hours = -1;
    public int days = -1;
    public int dayWeek = -1;
    public int maxIPConnection = 5;
    public int MoneyOpen = 1;
    private boolean isTaskHelp;
    public boolean isMabu;
    public int tMabu;
    public long lastUpdate;
    public long lastStart;
    public boolean isAutoSave;
    public int setSave;
    private int timeSave;
    public int timeBaoTri = -1;
    public int timeTangGift1;
    public int nSendFl1;
    public int gameTick;
    public int timeXHGauTuongCuop = 10;//60000;
    public NewBoss MobBoss;
    public boolean daishinkan = false;
    public int xTNSM = 5;
    
    
    public static final int SERVER_DELAY_MILISECOND = 100;
    public static final int SESSION_DELAY_MILISECOND = 35;
    
    public int delay = 0;
    
    
    protected static Server instance;
    
    public static boolean isGoKN = true;
    
    public Server() {
        this.connList = new ArrayList<>();
        this.connUName = new HashMap<>();
        this.connUId = new HashMap<>();
        this.connCName = new HashMap<>();
        this.connCId = new HashMap<>();
        this.connPId = new HashMap<>();
        destronGas = new ArrayList<>();
        destronGas2 = new ArrayList<>();
        khobau = new ArrayList<>();
        khobau2 = new ArrayList<>();
        phoban = new ArrayList<>();
        iscName = new ArrayList<>();
        gold_value = 500000000;
        doanhTrais = new ArrayList<>();
        doanhTrais2 = new ArrayList<>();
        playerCls = new ArrayList<>();
        clans = new ArrayList<>();
        maps = new ArrayList<>();
    }
    
    public static Server gI() {
        if (instance == null) {
            instance = new Server();
        }
        return instance;
    }
    
    public void addConn(Session_ME session) {
        synchronized(this.connList) {
            this.connList.add(session);
        }
    }
    
    public void addConn(Session_ME session, int userId, String userName) {
        synchronized(this.connUId) {
            this.connUId.put(userId, session);
        }
        synchronized(this.connUName) {
            this.connUName.put(userName, session);
        }
    }
    
    public void addConn(Session_ME session, int charID, String cName, int playerId) {
        synchronized(this.connCId) {
            this.connCId.put(charID, session);
        }
        synchronized(this.connCName) {
            this.connCName.put(cName, session);
        }
        synchronized(this.connPId) {
            this.connPId.put(playerId, session);
        }
    }
    
    public boolean isHavecName(String cName) {
        synchronized (this.iscName) {
            return this.iscName.contains(cName);
        }
    }
    
    public void addcName(String cName) {
        synchronized (this.iscName) {
            this.iscName.add(cName);
        }
    }
    
    public Session_ME getByUId(int userId) {
        synchronized(this.connUId) {
            return this.connUId.get(userId);
        }
    }
    
    public Session_ME getByUName(String userName) {
        synchronized(this.connUName) {
            return this.connUName.get(userName);
        }
    }
    
    public Session_ME getByCId(int charID) {
        synchronized(this.connCId) {
            return connCId.get(charID);
        }
    }
    
    public Session_ME getByCName(String cName) {
        synchronized(this.connCName) {
            return this.connCName.get(cName);
        }
    }
    
    public Session_ME getByPId(int playerId) {
        synchronized(this.connPId) {
            return this.connPId.get(playerId);
        }
    }
    
    public boolean isHaveByCName(String cName) {
        synchronized(this.connCName) {
            return this.connCName.containsKey(cName);
        }
    }
    
    public void removeConn(Session_ME session) {
        synchronized(this.connList) {
            connList.remove(session);
        }
    }
    
    public void removeConn(int userId, String userName) {
        synchronized(this.connUId) {
            connUId.remove(userId);
        }
        synchronized(this.connUName) {
            this.connUName.remove(userName);
        }
    }
    
    public void removeConn(int charID, String cName, int playerId) {
        synchronized(this.connCId) {
            this.connCId.remove(charID);
        }
        synchronized(this.connCName) {
            this.connCName.remove(cName);
        }
        synchronized(this.connPId) {
            this.connPId.remove(playerId);
        }
    }
    
    public int sizeConn() {
        int num;
        synchronized(this.connList) {
            num = this.connList.size();
        }
        return num;
    }
    
    public int sizeByUId() {
        int num;
        synchronized(this.connUId) {
            num = this.connUId.size();
        }
        return num;
    }
    
    public int sizeByUName() {
        int num;
        synchronized(this.connUName) {
            num = this.connUName.size();
        }
        return num;
    }
    
    public int sizeByCId() {
        int num;
        synchronized(this.connCId) {
            num = this.connCId.size();
        }
        return num;
    }
    
    public int sizeByCName() {
        int num;
        synchronized(this.connCName) {
            num = this.connCName.size();
        }
        return num;
    }
    
    public void Player_ChatTheGoi(Char charz, String text) {
        if (charz.getLuong() < 5) {
            charz.session.service.startOKDlg(mResources.INSUFFICIENT_GOLD_CHATTHEGIOI);
        } else {
            charz.updateLuong(-5, 2);
            this.chatTheGioi(charz, text);
        }
    }
    
    public void chatTheGioi(Char player, String chat) {
        synchronized(this.connPId) {
            Iterator<Integer> itr = this.connPId.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                this.connPId.get(key).service.chatTHEGIOI(player.cName, String.format(mResources.CHAT_PLAYER, 5, chat), player, (byte)0);
            }
        }
    }
    
    public void rongThan(int status, CallDragon dr) {
        synchronized(this.connPId) {
            for (int key : this.connPId.keySet()) {
                if (!this.connPId.get(key).myCharz().isGoiRong) {
                    if (status == 0) {
                        this.connPId.get(key).service.callDragon(dr.mapId, dr.bgId, dr.zoneId, dr.charId, mResources.EMPTY, dr.rx, dr.ry, dr.isRongNamek ? 1 : 0);
                    }
                    if (status == 1) {
                        this.connPId.get(key).service.hideDragon();
                    }
                }
            }
        }
    }
    
    public void chatVip(String text) {
        synchronized(this.connPId) {
            for (int key : this.connPId.keySet()) {
                this.connPId.get(key).service.chatVip(text);
            }
        }
    }
    
    public void openSay(int npcId, String text, int avatar) {
        synchronized(this.connPId) {
            Iterator<Integer> itr = this.connPId.keySet().iterator();
            while (itr.hasNext()) {
                int key = itr.next();
                this.connPId.get(key).service.openUISay(npcId, text, avatar);
            }
        }
    }
    
    public void bigMessage2(int npcId, String text, String p, int avatar, String caption) {
        synchronized(this.connPId) {
            for (int key : this.connPId.keySet()) {
                this.connPId.get(key).service.bigMessage2(text, avatar, p, caption);
            }
        }
    }
    
    public void log(String text) {
        synchronized(this.connPId) {
            for (int key : this.connPId.keySet()) {
                this.connPId.get(key).service.startOKDlg(text);
            }
        }
    }
    
    public void chatInfo(String text) {
        synchronized(this.connPId) {
            for (int key : this.connPId.keySet()) {
                this.connPId.get(key).service.chatTHEGIOI(mResources.EMPTY, text, null, 0);
            }
        }
    }
    
    public void addPhatQua() {
        synchronized(this.connPId) {
            for (int key : this.connPId.keySet()) {
                this.connPId.get(key).myCharz().isPhatQua = true;
            }
        }
    }
    
    public void openButcher() {
        this.isButcher = true;
        this.timeXongButcher = 1000 * 60 * 60;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (Map map : array) {
            if (map.isMapButcher()) {
                for (int j = 0; j < map.zones.size(); j++) {
                    Player boss;
                    if (map.templateId == 114) {
                        boss = Player.addBoss(77, 0, -1, -1, true, 200, 150, map.zones.get(j), -1, -1);
                        boss.changeFlag(Flag.get(520).id);
                        boss.setLive(60);
                        boss.setLiveTypePk(10, 5);
                    }
                    if (map.templateId == 115) {
                        boss = Player.addBoss(78, 5, -1, -1, true, 200, 150, map.zones.get(j), -1, -1);
                        boss.setLive(60);
                        boss.setLiveTypePk(10, 5);
                    }
                    if (map.templateId == 117) {
                        boss = Player.addBoss(83, 5, -1, -1, true, 200, 150, map.zones.get(j), -1, -1);
                        boss.setLive(60);
                        boss.setLiveTypePk(10, 5);
                    }
                    if (map.templateId == 118) {
                        boss = Player.addBoss(79, 5, -1, -1, true, 200, 150, map.zones.get(j), -1, -1);
                        boss.setLive(60);
                        boss.setLiveTypePk(10, 5);
                    }
                    if (map.templateId == 119) {
                        boss = Player.addBoss(81, 5, -1, -1, true, 200, 150, map.zones.get(j), -1, -1);
                        boss.setLive(60);
                        boss.setLiveTypePk(10, 5);
                    }
                    if (map.templateId == 120) {
                        Player.addBoss(82, 5, -1, -1, true, 200, 150, map.zones.get(j), -1, -1);

                        map.zones.get(j).isEggHatch = true;
                        map.zones.get(j).xHatch = 360;
                        map.zones.get(j).yHatch = 336;
                        map.zones.get(j).setTimeHatch(60);
                    }
                }
            }
        }
    }
    
    public void openBigBoss() {
        this.isBigBoss = true;
        this.timeXongBigBoss = 1000 * 60 * 60;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); ++i) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (int i2 = 0; i2 < array.length; ++i2) {
            if (array[i2].isMapBigBoss()) {
                for (int j = 0; j < array[i2].zones.size(); j++) {
                    array[i2].zones.get(j).bigBoss();
                }
            }
        }
    }
    
    public void openMabu() {
        this.isMabu = true;
        this.tMabu = 1000 * 60 * 60;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (Map map : array) {
            if (map.isMapMabu()) {
                for (int j = 0; j < map.zones.size(); j++) {
                    Player.addBoss(86, 5, -1, -1, true, 200, 150, map.zones.get(j), -1, -1);
                }
            }
        }
    }
    
    public void openCace23() {
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (Map map : array) {
            if (map.isMapCace23()) {
                for (int j = 0; j < map.zones.size(); j++) {
                    Player.addBoss(98, 0, -1, -1, false, 380, 264, map.zones.get(j), -1, -1);
                }
            }
        }
    }
    
    public void closeBigBoss() {
        this.isBigBoss = false;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (int i2 = 0; i2 < array.length; ++i2) {
            if (array[i2].isMapBigBoss()) {
                for (int j = 0; j < array[i2].zones.size(); j++) {
                    array[i2].zones.get(j).pushPlayers(0);
                }
            }
        }
    }
    
    public void closeButcher() {
        this.isButcher = false;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (Map map : array) {
            if (map.isMapBigBoss()) {
                for (int j = 0; j < map.zones.size(); j++) {
                    map.zones.get(j).pushPlayers(0);
                    map.zones.get(j).isEgg = false;
                    map.zones.get(j).isEggHatch = false;
                }
            }
        }
    }
    
    public void closeMabu() {
        this.isMabu = false;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (int i2 = 0; i2 < array.length; ++i2) {
            if (array[i2].isMapBigBoss()) {
                for (int j = 0; j < array[i2].zones.size(); j++) {
                    array[i2].zones.get(j).pushPlayers(0);
                }
            }
        }
    }
    
    public void closeCace23() {
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (Map map : array) {
            if (map.isMapCace23()) {
                for (int j = 0; j < map.zones.size(); j++) {
                    map.zones.get(j).pushPlayers(0);
                }
            }
        }
    }
    
    public void add(KhiHuyDiet destronGas) {
        synchronized(this.destronGas) {
            this.destronGas.add(destronGas);
        }
    }
    
    public void add(KhoBau khobau) {
        synchronized(this.khobau) {
            this.khobau.add(khobau);
        }
    }
    
    public void add(Instancing phoban) {
        synchronized(this.phoban) {
            this.phoban.add(phoban);
        }
    }
    
    public void remove(Instancing phoban) {
        synchronized(this.phoban) {
            this.phoban.remove(phoban);
        }
    }
    
    public void add(DoanhTrai dt) {
        synchronized(this.doanhTrais) {
            this.doanhTrais.add(dt);
        }
    }
    
    public void close() {
        Server.start = false;
        try {
            Server.server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i;
        BlackBall.gI().closeBlackBall();
        LuckyNumber.gI().close();
        synchronized(this.connList) {
            for (i = 0; i < this.connList.size(); i++) {
                this.connList.get(i).disconnect();
            }
        }
        System.out.println("Kick All Connection "+ i);
        
        Player.clearBot();
        
        KhiHuyDiet[] arrDes;
        i = 0;
        synchronized(destronGas) {
            arrDes = new KhiHuyDiet[destronGas.size()];
            while(!destronGas.isEmpty()) {
                arrDes[i] = destronGas.removeFirst();
                i = i + 1;
            }
        }
        System.out.println("Clear KhiHuyDiet="+ arrDes.length +"...");
        for (i = 0; i < arrDes.length; i++) {
            arrDes[i].close();
        }
        System.out.println("Clear KhiHuyDiet ok");
        
        KhoBau[] arrKhobau;
        i = 0;
        synchronized(this.khobau) {
            arrKhobau = new KhoBau[this.khobau.size()];
            while(!this.khobau.isEmpty()) {
                arrKhobau[i] = this.khobau.remove(0);
                i = i + 1;
            }
        }
        System.out.println("Clear KhoBau="+ arrKhobau.length +"...");
        for (i = 0; i < arrKhobau.length; i++) {
            arrKhobau[i].close();
        }
        System.out.println("Clear KhoBau ok");
        
        DoanhTrai[] arrDt;
        i = 0;
        synchronized(doanhTrais) {
            arrDt = new DoanhTrai[doanhTrais.size()];
            while(!doanhTrais.isEmpty()) {
                arrDt[i] = doanhTrais.removeFirst();
                i = i + 1;
            }
        }
        System.out.println("Clear DoanhTrai="+ arrDt.length +"...");
        for (i = 0; i < arrDt.length; i++) {
            arrDt[i].close();
        }
        System.out.println("Clear DoanhTrai ok");
        Instancing[] arrPhoBan;
        i = 0;
        synchronized(this.khobau) {
            arrPhoBan = new Instancing[this.phoban.size()];
            while(!this.phoban.isEmpty()) {
                arrPhoBan[i] = this.phoban.removeFirst();
                i = i + 1;
            }
        }
        System.out.println("Clear PhoBan="+ arrPhoBan.length +"...");
        for (i = 0; i < arrPhoBan.length; i++) {
            arrPhoBan[i].close();
        }
        System.out.println("Clear PhoBan ok");
        
        Map[] array1;
        synchronized (Map.MAPS) {
            array1 = new Map[Map.MAPS.size()];
            for (int i2 = 0; i2 < Map.MAPS.size(); i2++) {
                array1[i2] = Map.MAPS.get(i2);
            }
        }
        System.out.println("Clear Map="+ array1.length +"...");
        for (i = 0; i < array1.length; i++) {
            array1[i].close();
        }
        System.out.println("Clear Map ok");
        //Save all
        System.out.println("Save all data...");
        this.saveData();
        System.out.println("Save all data ok");
        //Xoa rank
        System.out.println("Clear Rank="+Rank.RANKS.size()+"...");
        Rank.RANKS.clear();
        System.out.println("Clear Rank ok");
        //Xoa item ky gui
        System.out.println("Clear ItemKyGui="+ItemKyGui.countItemKyGui()+"...");
        synchronized (ItemKyGui.SHOP_KY_GUI) {
            for (int i4 = 0; i4 < ItemKyGui.SHOP_KY_GUI.length; i4++)  {
                ItemKyGui.SHOP_KY_GUI[i4].clear();
            }
        }
        System.out.println("Clear ItemKyGui ok");
        //Xoa clan
        Clan[] arrClan;
        synchronized(Clan.CLANS) {
            arrClan = new Clan[Clan.CLANS.size()];
            for (int i2 = 0; i2 < Clan.CLANS.size(); i2++) {
                arrClan[i2] = Clan.CLANS.get(i2);
            }
        }
        System.out.println("Clear Clan="+arrClan.length+"...");
        for (i = 0; i < arrClan.length; i++) {
            Clan.removeClan(arrClan[i]);
        }
        System.out.println("Clear Clan ok");
        
        System.out.println("Save SuperRank");
        SuperRank.saveData();
        
        System.out.println("Save LuckyRound");
        //end
        LuckyRoundNew.endRound();
        //save
        LuckyRoundNew.saveData();
        //
        LuyenTap.saveData();
        
        System.out.println("Close server debug:\n\t-conn_list="+sizeConn()+"\n\t-userId_list="+this.sizeConn()+"\n\t-userName_list="+this.sizeByUName()+"\n\t-charId_list="+this.sizeByUId()+"\n\t-charName_list="+this.sizeByCName());
        System.out.println("Count Thread="+Thread.activeCount());
    }
    
    public void update() {
        this.gameTick++;
        //Hours
        Calendar cal = Calendar.getInstance();
        int hours_old = this.hours;
        this.hours = cal.get(Calendar.HOUR_OF_DAY);
        int dayWeek_old = this.dayWeek;
        this.dayWeek = cal.get(Calendar.DAY_OF_WEEK);

        //Uoc rong
        if (CallDragon.gI().timeWait > 0) {
            CallDragon.gI().timeWait -= delay;
            if (CallDragon.gI().timeWait <= 0) {
                CallDragon.gI().timeWait = 0;
            }
        }
        if (CallDragon.gI().isRongThanXuatHien) {
            CallDragon.gI().timeXuatHien -= delay;
            if (CallDragon.gI().timeXuatHien <= 0) {
                CallDragon.gI().timeXuatHien = 0;
                CallDragon.gI().hideRong();
            }
        }

        //Xuat hien boss
        for (int i1 = 0; i1 < Boss.gI().botId.length; i1++) {
            Boss.gI().botTimeHs[i1] -= this.delay;
            if (Boss.gI().botTimeHs[i1] <= 0) {
                this.clearBossByIndex(i1);
                Boss.gI().botTimeHs[i1] = Boss.gI().botSetTime[i1];
                int bossId = Boss.gI().botId[i1];
                //Set Map

                int mapId = -1;
                Player boss = null;

                if (bossId == 62) {
                    mapId = new int[]{82, 83, 79}[Util.gI().nextInt(3)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, -1, i1);
                }
                if (bossId == 61) {
                    mapId = new int[]{82, 83, 79}[Util.gI().nextInt(3)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 240, 150, null, -1, i1);
                }
                if (bossId == 60) {
                    mapId = new int[]{82, 83, 79}[Util.gI().nextInt(3)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, -1, i1);
                }
                if (bossId == 59) {
                    mapId = new int[]{82, 83, 79}[Util.gI().nextInt(3)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, -1, i1);
                }
                if (bossId == 58) {
                    mapId = new int[]{82, 83, 79}[Util.gI().nextInt(3)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, 10000, i1);
                }
                if (bossId == 63) {
                    mapId = 80;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 135, 144, null, 10000, i1);
                }
                if (bossId == 69) {
                    mapId = new int[]{93, 94, 96}[Util.gI().nextInt(3)];
                    boss = Player.addBoss(bossId, 5, -1, -1, true, 95, 150, null, 10000, i1);
                }
                if (bossId == 70) {
                    mapId = new int[]{93, 94, 96}[Util.gI().nextInt(3)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 95, 150, null, -1, i1);
                }
                if (bossId == 68) {
                    mapId = 104;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 95, 150, null, 15000, i1);
                }
                if (bossId == 67) {
                    mapId = 104;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 124, 150, null, 15000, i1);
                }
                if (bossId == 72) {
                    mapId = new int[]{97, 98}[Util.gI().nextInt(2)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 148, 150, null, -1, i1);
                }
                if (bossId == 71) {
                    mapId = new int[]{97, 98}[Util.gI().nextInt(2)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 100, 150, null, 10000, i1);
                }
                if (bossId == 73) {
                    mapId = new int[]{97, 98}[Util.gI().nextInt(2)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 196, 150, null, -1, i1);
                }
                if (bossId == 74) {
                    mapId = 100;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 135, 150, null, 10000, i1);
                }
                if (bossId == 23) {
                    mapId = 103;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, 10000, i1);
                }
                if (bossId == 4) {
                    mapId = new int[]{92, 93}[Util.gI().nextInt(2)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 200, 150, null, 10000, i1);
                }
                if (bossId == 1) {
                    mapId = 110;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 200, 150, null, 10000, i1);
                }
                if (bossId == 51) {
                    mapId = new int[]{3, 4, 6, 27, 28, 29}[Util.gI().nextInt(6)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, 10000, i1);
                }
                if (bossId == 50) {
                    mapId = new int[]{3, 4, 6, 27, 28, 29}[Util.gI().nextInt(6)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, 10000, i1);
                }
                if (bossId == 49) {
                    mapId = new int[]{3, 4, 6, 27, 28, 29}[Util.gI().nextInt(6)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, 10000, i1);
                }
                if (bossId == 48) {
                    mapId = new int[]{3, 4, 6, 27, 28, 29}[Util.gI().nextInt(6)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, 10000, i1);
                }
                if (bossId == 47) {
                    mapId = new int[]{3, 4, 6, 27, 28, 29}[Util.gI().nextInt(6)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, 10000, i1);
                }
                if (bossId == 0) {
                    mapId = 95;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, 10000, i1);
                }
                //tdst
                if (bossId == 114) {
                    mapId = new int[]{11, 12, 31, 32, 33}[Util.gI().nextInt(5)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, -1, i1);
                }
                if (bossId == 113) {
                    mapId = new int[]{11, 12, 31, 32, 33}[Util.gI().nextInt(5)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 240, 150, null, -1, i1);
                }
                if (bossId == 112) {
                    mapId = new int[]{11, 12, 31, 32, 33}[Util.gI().nextInt(5)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 250, 150, null, -1, i1);
                }
                if (bossId == 111) {
                    mapId = new int[]{11, 12, 31, 32, 33}[Util.gI().nextInt(5)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, -1, i1);
                }
                if (bossId == 110) {
                    mapId = new int[]{11, 12, 31, 32, 33}[Util.gI().nextInt(5)];
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, 10000, i1);
                }
                if (bossId == 119) {
                    mapId = 155;
                    boss = Player.addBoss(bossId, 5, -1, -1, true, 300, 150, null, -1, i1);
                }
                if (bossId == 120) {
                    mapId = 155;
                    boss = Player.addBoss(bossId, 5, -1, -1, true, 300, 150, null, -1, i1);
                }
                //htnt
                if (bossId == 130) {
                    mapId = 155;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, 10000, i1);
                }
                if (bossId == 131) {
                    mapId = 155;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, 10000, i1);
                }
                //whis
                if (bossId == 167) {
                    mapId = 95;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, 10000, i1);
                }
                if (bossId == 168) {
                    mapId = 95;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 300, 150, null, -1, i1);
                }
                if (bossId == 169) {
                    mapId = 163;
                    boss = Player.addBoss(bossId, 0, -1, -1, true, 1086 , 336 , null, 10000, i1);
                }
                if (boss != null) {
                    if (boss.zoneMap == null) {

                        //Find zone

                        Map map = Map.getMapServer(mapId);
                        while (Boss.gI().bossZone[i1] == null) {
                            try {
                                Boss.gI().bossZone[i1] = map.zones.get(Util.gI().nextInt(20));
                                break;
                            } catch (Exception e) {
                            }
                        }

                        //Doi truong give zone

                        if (bossId == 62) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 2] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 3] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 4] = Boss.gI().bossZone[i1];
                        }
                        if (bossId == 69) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                        }
                        if (bossId == 68) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                        }
                        if (bossId == 72) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 2] = Boss.gI().bossZone[i1];
                        }
                        if (bossId == 51) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 2] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 3] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 4] = Boss.gI().bossZone[i1];
                        }
                        if (bossId == 114) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 2] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 3] = Boss.gI().bossZone[i1];
                            Boss.gI().bossZone[i1 + 4] = Boss.gI().bossZone[i1];
                        }
                        if (bossId == 130) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                        }
                        if (bossId == 168) {
                            Boss.gI().bossZone[i1 + 1] = Boss.gI().bossZone[i1];
                        }
                        //Join Khu
                        Boss.gI().bossZone[i1].join(boss, 0, -1, -1);
                        Boss.gI().bossZone[i1] = null;
                    }
                    this.chatVip(String.format(mResources.BOSS_HAVE, boss.cName, boss.zoneMap.mapTemplate.mapName));
                    mLog.log("Name="+boss.cName+" zoneId="+boss.zoneMap.zoneID+" mapName="+boss.zoneMap.mapTemplate.mapName);
                }
            }
        }
        
        BlackBall.gI().delay = this.delay;
        BlackBall.gI().update();

        //Time ket thuc bigBoss
        if (this.timeXongBigBoss > 0) {
            this.timeXongBigBoss -= this.delay;
            if (this.timeXongBigBoss <= 0) {
                this.timeXongBigBoss = 0;
                this.closeBigBoss();
            }
        }

        //Time ket thuc butcher
        if (this.timeXongButcher > 0) {
            this.timeXongButcher -= this.delay;
            if (this.timeXongButcher <= 0) {
                this.timeXongButcher = 0;
                this.closeButcher();
            }
        }

        //Time ket mabu
        if (this.tMabu > 0) {
            this.tMabu -= this.delay;
            if (this.tMabu <= 0) {
                this.tMabu = 0;
                this.closeMabu();
            }
        }
        
        //Uoc rong vo cuc
        if (RongVoCuc.gI().timeRongVoCuc > 0) {
            RongVoCuc.gI().timeRongVoCuc -= this.delay;
            if (RongVoCuc.gI().timeRongVoCuc <= 0) {
                RongVoCuc.gI().endRongVoCuc();
            }
        }
        
        //Ket thuc ngoc rong vo cuc
        if (RongVoCuc.gI().timeClose > 0) {
            RongVoCuc.gI().timeClose -= this.delay;
            if (RongVoCuc.gI().timeClose <= 0) {
                RongVoCuc.gI().closeRongVoCuc();
            }
        }
        
        if (this.hours == 20 && this.hours != hours_old && !BlackBall.gI().isBlackBall) {
            BlackBall.gI().openBlackBall();
        }
        if (this.hours == 22 && this.hours != hours_old && !this.isBigBoss) {
            this.openBigBoss();
        }
        if (this.hours == 12 && this.hours != hours_old && !this.isButcher) {
            this.openButcher();
        }
        if (this.hours == 21 && this.hours != hours_old) {
            //this.createFide_Gold();
        }
        if (this.hours == 14 && this.hours != hours_old && !this.isMabu) {
            this.openMabu();
        }
        if (this.hours == RongVoCuc.hours && this.hours != hours_old && !RongVoCuc.gI().isCallRongVoCuc && this.dayWeek == 7 && hours_old != -1) {
            //RongVoCuc.gI().openRongVoCuc();
        }
        //giai nhi dong
        if ((this.hours == 8 || this.hours == 14 || this.hours == 18) && this.hours != hours_old && hours_old != -1) {
            DaiHoi.createPrize(1);
        }
        //giai sieu cap 1
        if ((this.hours == 9 || this.hours == 13 || this.hours == 19) && this.hours != hours_old && hours_old != -1) {
            DaiHoi.createPrize(2);
        }
        //giai sieu cap 2
        if ((this.hours == 10 || this.hours == 15 || this.hours == 20) && this.hours != hours_old && hours_old != -1) {
            DaiHoi.createPrize(3);
        }
        //giai sieu cap 3
        if ((this.hours == 11 || this.hours == 16 || this.hours == 21) && this.hours != hours_old && hours_old != -1) {
            DaiHoi.createPrize(4);
        }
        //giai ngoai hang
        if ((this.hours == 12 || this.hours == 17 || this.hours == 22 || this.hours == 23) && this.hours != hours_old && hours_old != -1) {
            DaiHoi.createPrize(5);
        }
        //phat qua sieu hang
        if ((this.hours == 21) && this.hours != hours_old && hours_old != -1) {
            SuperRank.phatQua();
        }
        //Boss piano
        if ((this.hours == 20 && this.hours != hours_old && hours_old != -1) && (this.dayWeek == 1 || this.dayWeek == 2 || this.dayWeek == 3 || this.dayWeek == 4 || this.dayWeek == 5 || this.dayWeek == 6 || this.dayWeek == 7)) {
            //this.appearPiano();
        }
        //Daishinkan
//        if (this.dayWeek == 7 && !this.daishinkan) {
//            this.daishinkan(true);
//        }
//        if(this.dayWeek != 7 && this.daishinkan) {
//            this.daishinkan(false);
//        }

        //UPDATE LIST DESTRONGAS
        destronGas2.clear();
        synchronized (destronGas) {
            for (int i2 = destronGas.size() - 1; i2 >= 0; --i2) {
                destronGas.get(i2).miliTime -= this.delay;
                if (destronGas.get(i2).miliTime <= 0) {
                    this.destronGas.get(i2).miliTime = 0;
                    destronGas2.add(destronGas.remove(i2));
                }
            }
        }
        for (int i3 = destronGas2.size() - 1; i3>= 0; --i3) {
            destronGas2.get(i3).close();
        }

        //UPDATE LIST KHOBAU
        this.khobau2.clear();
        synchronized (this.khobau) {
            for (int i4 = khobau.size() - 1; i4 >= 0; --i4) {
                khobau.get(i4).miliTime -= this.delay;
                if (khobau.get(i4).miliTime <= 0) {
                    this.khobau.get(i4).miliTime = 0;
                    khobau2.add(khobau.remove(i4));
                }
            }
        }
        for (int i4 = khobau2.size() - 1; i4 >= 0; --i4) {
            khobau2.get(i4).close();
        }

        //UPDATE LIST DOANHTRAI
        doanhTrais2.clear();
        synchronized (doanhTrais) {
            for (int i5 = doanhTrais.size() - 1; i5 >= 0; --i5) {
                doanhTrais.get(i5).miliTime -= this.delay;
                if (doanhTrais.get(i5).miliTime <= 0) {
                    doanhTrais.get(i5).miliTime = 0;
                    doanhTrais2.add(doanhTrais.remove(i5));
                }
            }
        }
        for (int i6 = doanhTrais2.size() - 1; i6 >= 0; --i6) {
            doanhTrais2.get(i6).close();
        }
        ItemCountAdd.update((int) this.delay);
        //Ho tro nhiem vu
        this.isTaskHelp = this.hours == 11 ||this.hours == 12 || this.hours == 13 || this.hours == 18 || this.hours == 19 || this.hours == 20|| this.hours == 21;
        //Update clan
        this.clans.clear();
        synchronized (Clan.CLANS) {
            for (int i7 = 0; i7 < Clan.CLANS.size(); i7++) {
                this.clans.add(Clan.CLANS.get(i7));
            }
        }
        for (int i8 = 0; i8 < this.clans.size(); i8++) {
            this.clans.get(i8).delays = this.delay;
            this.clans.get(i8).update();
        }
        //Update Map
        this.maps.clear();
        synchronized (Map.MAPS) {
            for (int i9 = 0; i9 < Map.MAPS.size(); i9++) {
                this.maps.add(Map.MAPS.get(i9));
            }
        }
        for (int i10 = 0; i10 < this.maps.size(); i10++) {
            this.maps.get(i10).delays = this.delay;
            this.maps.get(i10).update();
        }
        //Update Ky gui
        ItemKyGui.update();
        //Save clan, ky gui, rank
        if (Server.gI().isAutoSave) {
            Server.gI().timeSave -= this.delay;
            if (Server.gI().timeSave <= 0) {
                Server.gI().timeSave = Server.gI().setSave;
                this.saveData();
            }
        }
        //Thoi gian bao tri
        if (this.timeBaoTri != -1) {
            int sc_baotri = this.timeBaoTri / 1000;
            if (sc_baotri >= 60) {
                if (sc_baotri % 60 == 0) {
                    this.chatInfo(String.format(mResources.TIME_WAIT_BAOTRI2, Util.gI().getStrTime(this.timeBaoTri)));
                }
            } else if (sc_baotri % 5 == 0) {
                this.chatInfo(String.format(mResources.TIME_WAIT_BAOTRI1, Util.gI().getStrTime(this.timeBaoTri)));
            }
            this.timeBaoTri -= this.delay;
            if (this.timeBaoTri <= 0) {
                Server.start = false;
                this.timeBaoTri = -1;
            }
        }
        //ngoc rong namek
        NamekBall.gI().update();
        //qua tang
        if (this.timeTangGift1 > 0) {
            this.timeTangGift1 -= this.delay;
            if (this.timeTangGift1 <= 0) {
                this.timeTangGift1 = 0;
            }
        }
        //Daihoi
        DaiHoi.delay = this.delay;
        DaiHoi.update();
        //Gau tuong cuop
        if (this.timeXHGauTuongCuop > 0) {
            this.timeXHGauTuongCuop -= this.delay;
            if (this.timeXHGauTuongCuop <= 0) {
                this.timeXHGauTuongCuop = 0;
                //this.appearGauTuongCuop();
            }
        }
        BWar.delay = this.delay;
        BWar.update();
        //LuckyRound
        dragon.t.LuckyRoundNew.delay = this.delay;
        dragon.t.LuckyRoundNew.update();
        //resetTOP
        if (Util.gI().getWeekGap(LuyenTap.lastWeek) > 0) {
            LuyenTap.resetTOP();
        }

        //UPDATE PHO BAN
        Instancing array[];
        synchronized (this.phoban) {
            array = new Instancing[this.phoban.size()];
            for (int i = 0; i < this.phoban.size(); i++) {
                array[i] = this.phoban.get(i);
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            array[i].delay = this.delay;
            array[i].update();
        }
    }
    
    @Override
    public void run() {
        while (Server.start) {
            this.lastUpdate = System.currentTimeMillis();
            this.update();
            try {
                TimeUnit.MILLISECONDS.sleep(Server.SERVER_DELAY_MILISECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.delay = (int) (System.currentTimeMillis() - this.lastUpdate);
        }
        this.close();
    }
    
    public static void start(int post) {
        System.out.println("Start socket post="+post);
        try {
            server = new ServerSocket(post);
            id = 0;
            start = true;
            Server.gI().start();
//            LuckyNumber.gI().start();
            Util.gI().logln("Start server Success!");
            Server.gI().lastStart = System.currentTimeMillis();
            while(start) {
                if (isGoKN) {
                    try {
                        Socket sc = server.accept();
                        if (Server.gI().sizeIP(sc.getInetAddress().getHostAddress()) < Server.gI().maxIPConnection) {
                            Session_ME session = new Session_ME(sc, id++);
                            session.run();
                            Server.gI().addConn(session);
                        } else {
                            sc.close();
                        }
                        Util.gI().logln("Accept socket done size");
                    } catch(IOException e) {
                        if (start) {
                            e.printStackTrace();
                        } else {

                        }
                    }
                } else {
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
            Util.gI().logln("Close server!");
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public static void init() {
        try {
            MySQL mySQL1 = MySQL.createData3();
            MySQL mySQL2 = MySQL.createData6();
            try {
                //____________LOAD RANK________________//
                System.out.println("Load Rank");
                ResultSet res = mySQL1.getConnection().prepareStatement("SELECT * FROM `rank`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                while(res.next()) {
                    Rank r = new Rank();
                    r.initRank(res);
                    Rank.RANKS.add(r);
                }
                //THE END
                //____________LOAD CLAN________________//
                System.out.println("Load Clan");
                res = mySQL1.getConnection().prepareStatement("SELECT * FROM `clan`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                while(res.next()) {
                    Clan c = new Clan();
                    c.initClan(res);
                    Clan.addClan(c);
                }
                //THE END
                //____________LOAD NAME PLAYER________________//
                System.out.println("Load cName Player");
                res = mySQL2.getConnection().prepareStatement("SELECT `cName` FROM `options`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                while(res.next()) {
                    Server.gI().addcName(res.getString(1));
                }
                res.close();
                //THE END
                //____________LOAD KyGui________________//
                System.out.println("Load Kygui");
                res = mySQL1.getConnection().prepareStatement("SELECT * FROM `arrkygui`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                while(res.next()) {
                    ItemKyGui kygui = new ItemKyGui(res);
                    ItemKyGui.add(kygui);
                }
                res.close();
                //THE END
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                mySQL1.close();
                mySQL2.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
    
    public void initBroly() {
        int[] arrMap = new int[] {5, 6, 10, 13, 19, 20, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int num = 70;
        for (int i = 0; i < num; i++) {
            int bossNumber = i + 1;
            Char bot = Player.addBoss(13, 0, -1, -1, true, 120, 150, null, 10000, -1);
            bot.cName = String.format(mResources.ADD_FORMAT_D, bot.cName, bossNumber);
            bot.numberXH = bossNumber;
            bot.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map = Map.getMapServer(bot.arrInMap[Util.gI().nextInt(bot.arrInMap.length)]);
                    ZoneMap zone = map.zones.get(Util.gI().nextInt(Util.gI().nextInt(20)));
                    if (zone.countBossById(13) > 0) {
                        continue;
                    }
//                    System.out.println("MapName="+map.template.mapName+" zoneId="+zone.zoneID);
                    zone.join(bot, 0, -1, -1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void initKuku() {
        int[] arrMap = new int[] {68, 69, 70, 71, 72};
        for (int i = 0; i < 20; i++) {
            Player bot = Player.addBoss(55, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot.cName = String.format(mResources.ADD_FORMAT_D, bot.cName, i + 1);
            bot.numberXH2 = i + 1;
            bot.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map_432 = Map.getMapServer(bot.arrInMap[Util.gI().nextInt(bot.arrInMap.length)]);
                    ZoneMap zone_123 = map_432.zones.get(Util.gI().nextInt(20));
                    if (zone_123.countBossById(55) > 0) {
                        continue;
                    }
                    zone_123.join(bot, 0, -1, -1);
                    bot.setPos(150, 150, 1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void initMap_Dau_Dinh() {
        int[] arrMap = new int[] {64, 65, 63, 66, 67};
        for (int i = 0; i < 20; i++) {
            Player bot = Player.addBoss(57, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot.numberXH2 = i + 1;
            bot.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map_432 = Map.getMapServer(bot.arrInMap[Util.gI().nextInt(bot.arrInMap.length)]);
                    ZoneMap zone_123 = map_432.zones.get(Util.gI().nextInt(20));
                    if (zone_123.countBossById(57) > 0) {
                        continue;
                    }
                    zone_123.join(bot, 0, -1, -1);
                    bot.setPos(150, 150, 1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void initRambo() {
        int[] arrMap = new int[] {73, 74, 75, 76, 77};
        for (int i = 0; i < 20; i++) {
            Player bot = Player.addBoss(56, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot.numberXH2 = i + 1;
            bot.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map_432 = Map.getMapServer(bot.arrInMap[Util.gI().nextInt(bot.arrInMap.length)]);
                    ZoneMap zone_123 = map_432.zones.get(Util.gI().nextInt(20));
                    if (zone_123.countBossById(56) > 0) {
                        continue;
                    }
                    zone_123.join(bot, 0, -1, -1);
                    bot.setPos(150, 150, 1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void initBotTop() {
        if (!Rank.getRank(1).tops.isEmpty()) {
            Map map = Map.getMapServer(84);
            for (int i = 0; i < map.zones.size(); i++) {
                Char bot = Player.addBoss(15, 0, 100, 100, false, 120, 150, null, -1, -1);
                map.zones.get(i).join(bot, 0, -1, -1);
            }
        }
    }
    
    public void initMabu() {
        //Xuat hien mabu
        if (Dragon.isEvent_Mabu) {
            for (int i = 0; i < 10; i++) {
                Map map = Map.getMapServer(arrMapMabu[Util.gI().nextInt(arrMapMabu.length)]);
                int zoneId = Util.gI().nextInt(5);
                int x = Util.gI().nextInt(24, map.zones.get(zoneId).mapTemplate.pxw - 24);
                int y = map.zones.get(zoneId).mapTemplate.touchY(x, 150);
                Player.addBoss(41, 0, -1, -1, false, x, y, map.zones.get(zoneId), -1, -1);
            }
        }
    }
    
    public void clearBossByIndex(int index) {
        if (index != -1) {
            int i;
            synchronized (Player.BOTS) {
                for (i = 0; i < this.playerCls.size(); i++) {
                    Player player = this.playerCls.get(i);
                    if (player.indexXH != -1 && player.indexXH == index) {
                        player.isClear = true;
                    }
                }
            }
        }
    }
    
    public void createFide_Gold() {
        this.clearBossByIndex(-9876);
        Map map = Map.getMapServer(6);
        for (int i = 0; i < map.zones.size(); i++) {
            if (i >= 20) {
                break;
            }
            Char boss = Player.addBoss(3, 0, -1, -1, true, 120, 150, null, 10000, -9876);
            map.zones.get(i).join(boss, 0, -1, -1);
        }
        this.chatVip(String.format(mResources.BOSS_HAVE, dragon.t.CharTemplate.get(3).name, MapTemplate.arrMapTemplate[map.mapId].mapName));
    }
    
    public int sizeIP(String ip) {
        int num = 0;
        synchronized(this.connList) {
            for (int i = 0; i < this.connList.size(); i++) {
                if (this.connList.get(i).sc.getInetAddress().getHostAddress().equals(ip)) {
                    num++;
                }
            }
        }
        return num;
    }
    
    public void initEvent() {
        if (Dragon.isEvent_TrungThu) {
            initBossTrungThu();
        }
        if (Dragon.isEvent_Halloween) {
            //Boss
            initBossHalloween();
        }
        if (Dragon.isEvent_WorldCup2022) {
            //Boss
            initBossWorldCup2022();
        }
        if (Dragon.isEvent_TetNguyenDan) {
            this.initTetNguyenDan();
        }
        if (Dragon.isEvent_Girl) {
            this.initGirl();
        }
        if (Dragon.isEvent_HungVuong) {
            this.initHungVuong();
        }
        if (Dragon.isEvent_HE2023) {
            this.initSuKienHe2023();
        }
        if (Dragon.isEvent_NHS) {
            initSKNHS();
        }
        if (Dragon.isEvent_VULAN2023) {
        	initBossVuLan();
        }
    }
    
    public void initSKNHS() {
        //Lang Aru
        Map map = Map.getMapServer(0);
        for (int i = 0; i < map.zones.size(); i++) {
            ZoneMap zone = map.zones.get(i);
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 560, 432, 49, 4544));
        }
    }
    
    public void initBossTrungThu() {
        //Lang Aru
        Map map1 = Map.getMapServer(0);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
//                zone.npcs.add(new Npc(zone.npcs.size(), 1, 436, 432, 41, 1415));
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 560, 432, 66, 1415));
        }
        //Lang Mori
        map1 = Map.getMapServer(7);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
//                zone.npcs.add(new Npc(zone.npcs.size(), 1, 510, 432, 41, 1415));
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 224, 432, 66, 1415));
        }
        //Lang Kakarot
        map1 = Map.getMapServer(14);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
//                zone.npcs.add(new Npc(zone.npcs.size(), 1, 214, 408, 41, 1415));
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 315, 408, 66, 1415));
        }
        //Dao Kame
        map1 = Map.getMapServer(5);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 320, 288, 69, 4118));
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 1141, 408, 66, 1415));
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 1266, 408, 41, 1415));
        }
        //Boss
        int[] arrMap = new int[] {5, 6, 10, 13, 19, 20, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int num = 100;
        int i = 0;
        //Tho Dai Ca
        for (; i < num / 2; i++) {
            int bossNumber1 = i + 1;
            Char bot1 = Player.addBoss(96, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot1.cName = String.format(mResources.ADD_FORMAT_D, bot1.cName, bossNumber1);
            bot1.numberXH = bossNumber1;
            bot1.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map431 = Map.getMapServer(bot1.arrInMap[Util.gI().nextInt(bot1.arrInMap.length)]);
                    ZoneMap zone122 = map431.zones.get(Util.gI().nextInt(20));
                    if (zone122.countBossById(96) > 0) {
                        continue;
                    }
                    zone122.join(bot1, 0, -1, -1);
                    break;
                } catch (Exception e) {
                }
            }
        }
        //Khi Dot
        for (; i < num ; i++) {
            int bossNumber2 = i + 1;
            Char bot2 = Player.addBoss(97, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot2.cName = String.format(mResources.ADD_FORMAT_D, bot2.cName, bossNumber2);
            bot2.numberXH = bossNumber2;
            bot2.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map432 = Map.getMapServer(bot2.arrInMap[Util.gI().nextInt(bot2.arrInMap.length)]);
                    ZoneMap zone123 = map432.zones.get(Util.gI().nextInt(20));
                    if (zone123.countBossById(97) > 0) {
                        continue;
                    }
                    zone123.join(bot2, 0, -1, -1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void initBossHalloween() {
        int[] arrMap = new int[] {5, 6, 10, 13, 19, 20, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int num = 100;
        //Bi ma
        for (int i = 0; i < num; i++) {
            int bossNumber1 = i + 1;
            Char bot1 = Player.addBoss(117, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot1.cName = String.format(mResources.ADD_FORMAT_D, bot1.cName, bossNumber1);
            bot1.numberXH = bossNumber1;
            bot1.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map431 = Map.getMapServer(bot1.arrInMap[Util.gI().nextInt(bot1.arrInMap.length)]);
                    ZoneMap zone122 = map431.zones.get(Util.gI().nextInt(20));
                    if (zone122.countBossById(117) > 0) {
                        continue;
                    }
                    zone122.join(bot1, 0, -1, -1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void initBossWorldCup2022() {
        int[] arrMap = new int[] {5, 6, 10, 13, 19, 20, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int num = 100;
        int i = 0;
        //Ban do
        for (; i < num; i++) {
            int bossNumber1 = i + 1;
            Char bot1 = Player.addBoss(121, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot1.cName = String.format(mResources.ADD_FORMAT_D, bot1.cName, bossNumber1);
            bot1.numberXH = bossNumber1;
            bot1.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map431 = Map.getMapServer(bot1.arrInMap[Util.gI().nextInt(bot1.arrInMap.length)]);
                    ZoneMap zone122 = map431.zones.get(Util.gI().nextInt(20));
                    if (zone122.countBossById(121) > 0) {
                        continue;
                    }
                    zone122.join(bot1, 0, -1, -1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public void initNpc() {
        //Dao Kame
        Map map1 = Map.getMapServer(5);
        for (int i1 = 0; i1 < map1.zones.size(); i1++) {
            ZoneMap zone1 = map1.zones.get(i1);
            zone1.npcs.add(new Npc(zone1.npcs.size(), 1, 250, 288, 74, 10477));
        }
//        //Hanh tinh nguc tu
//        Map map2 = Map.getMapServer(166);
//        for (int i1 = 0; i1 < map2.zones.size(); i1++) {
//            ZoneMap zone1 = map2.zones.get(i1);
//            zone1.npcs.add(new Npc(zone1.npcs.size(), 1, 570, 600, 76, 5824));
//        }
        //Lang KKR
        Map map3 = Map.getMapServer(14);
        for (int i1 = 0; i1 < map3.zones.size(); i1++) {
            ZoneMap zone1 = map3.zones.get(i1);
            zone1.npcs.add(new Npc(zone1.npcs.size(), 1, 651, 408, 40, 10477));
        }
        //Lang aru
        Map map4 = Map.getMapServer(0);
        for (int i1 = 0; i1 < map4.zones.size(); i1++) {
            ZoneMap zone1 = map4.zones.get(i1);
            zone1.npcs.add(new Npc(zone1.npcs.size(), 1, 420, 431, 40, 10477));
        }
        //Lang mori
        Map map5 = Map.getMapServer(7);
        for (int i1 = 0; i1 < map5.zones.size(); i1++) {
            ZoneMap zone1 = map5.zones.get(i1);
            zone1.npcs.add(new Npc(zone1.npcs.size(), 1, 533, 431, 40, 10477));
        }
    }
    
    public void saveData() {
        //Save player
        Server.savePlayer();
        //Save rank
        Rank.saveRank();
        //Save kygui
        ItemKyGui.saveKyGui();
        //Save clan
        Clan.saveDataClan();
        //Save Super Rank
        SuperRank.saveData();
        //Save LuckyRoundNew
        LuckyRoundNew.saveData();
        //
        LuyenTap.saveData();
    }
    
    public static void savePlayer() {
        synchronized(Server.gI().connList) {
            for (int i1 = 0; i1 < Server.gI().connList.size(); i1++) {
                Server.gI().connList.get(i1).isSave = true;
            }
        }
    }
    
    private void initTetNguyenDan() {
        //Lang Aru
        Map map1 = Map.getMapServer(0);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 560, 432, 66, 7084));
        }
        //Lang Mori
        map1 = Map.getMapServer(7);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 224, 432, 66, 7084));
        }
        //Lang Kakarot
        map1 = Map.getMapServer(14);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 315, 408, 66, 7084));
        }
        //Dao Kame
        map1 = Map.getMapServer(5);
        for (int i = 0; i < map1.zones.size(); i++) {
            ZoneMap zone = map1.zones.get(i);
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 1141, 408, 66, 7084));
        }
        int[] arrMap = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 42, 43, 44};
        //Lan con
        for (int i = 0, num = 100; i < num; i++) {
            int bossNumber2 = i + 1;
            Char bot2 = Player.addBoss(127, 0, -1, -1, true, 120, 150, null, -1, -1);
            bot2.numberXH = bossNumber2;
            bot2.arrInMap = arrMap;
            bot2.isRego = true;
            bot2.timeRego = 30000;
            bot2.maxZoneXH = 10;
            bot2.shield = true;
            int num3 = 0;
            while(num3++ < 100) {
                try {
                    Map map432 = Map.getMapServer(bot2.arrInMap[Util.gI().nextInt(bot2.arrInMap.length)]);
                    ZoneMap zone123 = map432.zones.get(Util.gI().nextInt(bot2.maxZoneXH));
                    if (zone123.countBossById(127) > 0) {
                        continue;
                    }
                    zone123.join(bot2, 0, -1, -1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    private void initGirl() {
        int[] arrMap = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 42, 43, 44};
        //Hoa hong
        for (int i = 0, num = 200; i < num; i++) {
            int bossNumber2 = i + 1;
            Char bot2 = Player.addBoss(133, 5, -1, -1, false, 120, 150, null, -1, -1);
            bot2.numberXH = bossNumber2;
            bot2.arrInMap = arrMap;
            bot2.maxZoneXH = 10;
            int num3 = 0;
            while(num3++ < 100) {
                try {
                    Map map432 = Map.getMapServer(bot2.arrInMap[Util.gI().nextInt(bot2.arrInMap.length)]);
                    ZoneMap zone123 = map432.zones.get(Util.gI().nextInt(bot2.maxZoneXH));
                    int x = Util.gI().nextInt(50, zone123.mapTemplate.pxw - 50);
                    zone123.join(bot2, 0, x, zone123.mapTemplate.touchY(x, 150));
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
    public boolean isTangGift1() {
        return this.timeTangGift1 / 60000 > 0;
    }
    
    public void openPrize() {
        Map map = Map.getMapServer(51);
        for (int j = 0; j < map.zones.size(); j++) {
            Player.addBoss(134, 0, -1, -1, false, 385, 312, map.zones.get(j), -1, -1);
        }
        Map map2 = Map.getMapServer(52);
        for (int j = 0; j < map2.zones.size(); j++) {
            Player.addBoss(134, 0, -1, -1, false, 385, 336, map2.zones.get(j), -1, -1).isspeechWar = true;
        }
    }
    
    public void appearGauTuongCuop() {
        //Xuat hien lai sau 2h
        this.timeXHGauTuongCuop = 3600000;
        if (this.MobBoss != null && !this.MobBoss.isDie) {
            this.MobBoss.startDie();
        }
        //tao vboss
        int[] array = new int[]{27, 28, 29};
        int index = Util.gI().nextInt(array.length);
        Map map = Map.getMapServer(array[index]);
        ZoneMap zoneMap = map.zones.get(Util.gI().nextInt(2, 19));
        zoneMap.addNewBoss(this.MobBoss = new dragon.t.ConGau(100, 150));
        mLog.log("Xuat hien boss gau tuong cop mapName="+zoneMap.mapTemplate.mapName+" zoneId="+zoneMap.zoneID);
    }
    
    public void appearPiano() {
        //tao vboss
        Map map = Map.getMapServer(10);
        for (int i = 0; i < map.zones.size() && i < 10; i++) {
            ZoneMap zoneMap = map.zones.get(i);
            zoneMap.addNewBoss(this.MobBoss = new dragon.t.Piano(100, 150));
        }
        mLog.log("Xuat hien boss Piano mapName="+map.template.mapName+" zoneId 0-9");
    }
    
    private void initHungVuong() {
        //Lang Aru
        Map map2 = Map.getMapServer(0);
        for (int i2 = 0; i2 < map2.zones.size(); i2++) {
            ZoneMap zone2 = map2.zones.get(i2);
            //add Vua Hung
            zone2.npcs.add(new Npc(zone2.npcs.size(), 1, 432, 432, 52, 4678));
        }
        System.out.println("Boss son tinh thuy tinh");
        //war son tinh thuy tinh
        for (int i = 0; i < 20; i++) {
            BWar.addBWar(1, null, 0, null);
        }
    }
    
    public void initAnTrom() {
        System.out.println("Boss an trom");
        //an trom
        for (int i = 0; i < 20; i++) {
            BWar.addBWar(2, "Ăn trộm "+(i+1), 0, null);
        }
    }
    
    private void initSuKienHe2023() {
        //Dao Kame
        Map map = Map.getMapServer(5);
        for (int i = 0; i < map.zones.size(); i++) {
            ZoneMap zone = map.zones.get(i);
            zone.npcs.add(new Npc(zone.npcs.size(), 1, 1141, 408, 66, 7084));
        }
    }
    
    public void daishinkan(boolean flag) {
        this.daishinkan = flag;
        if (this.daishinkan) {
            //Lang Aru
            Map map2 = Map.getMapServer(0);
            for (int i2 = 0; i2 < map2.zones.size(); i2++) {
                map2.zones.get(i2).addNpc(map2.zones.get(i2).npcs.size(), 1, 611, 432, 64, 6578);
                map2.zones.get(i2).allMapInfo();
            }
            //Lang Mori
            Map map3 = Map.getMapServer(7);
            for (int i3 = 0; i3 < map3.zones.size(); i3++) {
                map3.zones.get(i3).addNpc(map3.zones.get(i3).npcs.size(), 1, 617, 432, 64, 6578);
                map3.zones.get(i3).allMapInfo();
            }
            //Lang Kakarot
            Map map4 = Map.getMapServer(14);
            for (int i4 = 0; i4 < map4.zones.size(); i4++) {
                map4.zones.get(i4).addNpc(map4.zones.get(i4).npcs.size(), 1, 633, 408, 64, 6578);
                map4.zones.get(i4).allMapInfo();
            }
        } else {
            //Lang Aru
            Map map2 = Map.getMapServer(0);
            for (int i2 = 0; i2 < map2.zones.size(); i2++) {
                map2.zones.get(i2).removeNpc(64);
                map2.zones.get(i2).allMapInfo();
            }
            //Lang Mori
            Map map3 = Map.getMapServer(7);
            for (int i3 = 0; i3 < map3.zones.size(); i3++) {
                map3.zones.get(i3).removeNpc(64);
                map3.zones.get(i3).allMapInfo();
            }
            //Lang Kakarot
            Map map4 = Map.getMapServer(14);
            for (int i4 = 0; i4 < map4.zones.size(); i4++) {
                map4.zones.get(i4).removeNpc(64);
                map4.zones.get(i4).allMapInfo();
            }
        }
    }
    
    public boolean isSupport(int templateId) {
        return templateId == 58 || templateId == 59 || templateId == 61 || templateId == 62 || templateId == 63 || templateId == 64 || templateId == 65 || templateId == 69 || templateId == 70 || templateId == 68 ||
                templateId == 67 || templateId == 66 || templateId == 71 || templateId == 72 || templateId == 73 || templateId == 74 || templateId == 75 || templateId == 76 || templateId == 25 || templateId == 24;
    }
    
    public boolean isSupport(int taskId, int taskIndex, int templateId) {
        if (Server.gI().isTaskHelp) {
            //so 4
            if (templateId == 58) {
                return taskId == 24 ;
            }
            //so 3
            if (templateId == 59) {
                return taskId == 24 ;
            }
            //so 1
            if (templateId == 61) {
                return taskId == 24 ;
            }
            //TDST
            if (templateId == 62) {
                return taskId == 24;
            }
            //fide 1
            if (templateId == 63) {
                return taskId == 25 ;
            }
            //fide 2   
            if (templateId == 64) {
                return taskId == 25;
            }  
            //Fide 3
            if (templateId == 65) {
                return taskId == 25 ;
            }
            //androi 19
            if (templateId == 69) {
                return taskId == 27 ;
            }
            //androi 20
            if (templateId == 70) {
                return taskId == 27 ;
            }
             //androi 15
            if (templateId == 68) {
                return taskId == 28 ;
            }
            //androi 14
             if (templateId == 67) {
                return taskId == 28;
            }
            //androi 13
              if (templateId == 66) {
                return taskId == 28;
            } 
            //poc
            if (templateId == 71) {
                return taskId == 29 ;
            }
            //pic 
             if (templateId == 72) {
                return taskId == 29 ;
            }
            //King kong
              if (templateId == 73) {
                return taskId == 29 ;
            }
            //xen cap 1
             if (templateId == 74) {
                return taskId == 30 ;
            } 
            //xen cap 2      
            if (templateId == 75) {
                return taskId == 30 ;
            }
            //xen hoan thien 
            if (templateId == 76) {
                return taskId == 30 ;
            }  
           
        }
        return true;
    }
    
    public void initBossVuLan() {
        int[] arrMap = new int[] {5, 6, 10, 13, 19, 20, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38};
        int num = 5;
        //Mabu com
        for (int i = 0; i < num; i++) {
            int bossNumber1 = i + 1;
            Char bot1 = Player.addBoss(162, 5, -1, -1, true, 120, 150, null, -1, -1);
            bot1.cName = String.format(mResources.ADD_FORMAT_D, bot1.cName, bossNumber1);
            bot1.numberXH = bossNumber1;
            bot1.arrInMap = arrMap;
            int num2 = 0;
            while(num2++ < 100) {
                try {
                    Map map431 = Map.getMapServer(bot1.arrInMap[Util.gI().nextInt(bot1.arrInMap.length)]);
                    ZoneMap zone122 = map431.zones.get(Util.gI().nextInt(20));
                    if (zone122.countBossById(117) > 0) {
                        continue;
                    }
                    zone122.join(bot1, 0, -1, -1);
                    break;
                } catch (Exception e) {
                }
            }
        }
    }
    
}
