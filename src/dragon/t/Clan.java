package dragon.t;

import dragon.server.MySQL;
import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class Clan {
    
    //My
    public int ID;
    public int imgID;
    public String name;
    public String slogan = new String();
    public int date;
    public long powerPoint;
    public int maxMember;
    public int leaderID;
    public String leaderName;
    public int level;
    public int clanPoint;
    public final ArrayList<ClanMember> members = new ArrayList<>();
    public final ArrayList<Invite> invites = new ArrayList<>();
    public final ArrayList<ClanMessage> messages = new ArrayList<>();
    public final ArrayList<Map> maps = new ArrayList<>();
    public boolean isRun = true;
    public int delays = 0;
    public KhiHuyDiet destronGas = null;
    public DoanhTrai doanhTrai = null;
    public KhoBau khobau = null;
    public RoadSnake roadSnake = null;
    public DoelBossClan doelBossClan = null;
    public int selectLevel;
    public boolean isDelete = false;
    public boolean isBackup = true;
    public long lastOneMember = -1;
    public int countbarrack = 0;
    public int num_ = 0;
    public String playerBarrack = null;
    public String timeBarrack = null;
    public long yesterday;
    public long lastReport;
    public String shortName;
    public long lastChangeShortName;
    public int doelBossClanLevel;
    
    public static final HashMap<String, Clan> CLANNS = new HashMap<>();
    public static final HashMap<Integer, Clan> CLANIDS = new HashMap<>();
    public static final ArrayList<Clan> CLANS = new ArrayList<>();
    public static final int MAX_JOIN_BARRACK = 1;
    public static final int[] ARR_MAP = new int[] {
        153
    };
    public static final int UPGRADE_CLAN[] = new int[]{100, 300, 500, 1000, 1500, 2000, 2500, 3000, 5000};
    
    public static int gameTick;
    
    
    public Clan() {
        for (int i = 0; i < Clan.ARR_MAP.length; i++) {
            Map map = new Map(Clan.ARR_MAP[i], 1, 20, 0);
            map.isOpen = true;
            this.maps.add(map);
        }
    }
    
    public static int size() {
        synchronized (CLANNS) {
            return CLANNS.size();
        }
    }
    
    public static class Invite {
        
        public static int baseCode = 0;
        
        public synchronized static int getCode() {
            return baseCode++;
        }
        
        public int time;
        public int code;
        public int playerId;
    }
    
    public void update() {
        int i;
        synchronized (invites) {
            for (i = invites.size() - 1; i >= 0; --i) {
                invites.get(i).time -= delays;
                if (invites.get(i).time <= 0) {
                    invites.remove(i);
                }
            }
        }
        for (i = 0; i < this.maps.size(); i++) {
            this.maps.get(i).delays = this.delays;
            this.maps.get(i).update();
        }
        if (Util.gI().getDayGap(this.yesterday) > 0) {
            this.updateDay();
        }
    }
    
    public static Clan getClan(int clanId) {
        Clan c = null;
        if (clanId != -1) {
            synchronized (CLANIDS) {
                c = CLANIDS.get(clanId);
            }
        }
        return c;
    }
    
    public static boolean isHaveClan(int clanId) {
        boolean b;
        synchronized (CLANIDS) {
            b = CLANIDS.containsKey(clanId);
        }
        return b;
    }
    
    public static boolean isHaveClan(String name) {
        boolean b;
        synchronized (CLANNS) {
            b = CLANNS.containsKey(name);
        }
        return b;
    }
    
    public static Clan getClan(String clanName) {
        Clan c;
        synchronized (CLANNS) {
            c = CLANNS.get(clanName);
        }
        return c;
    }
    
    public static void removeClan(Clan c) {
        synchronized (CLANNS) {
            CLANNS.remove(c.name, c);
        }
        synchronized (CLANIDS) {
            CLANIDS.remove(c.ID, c);
        }
        synchronized (CLANS) {
            CLANS.remove(c);
        }
    }
    
    public static void addClan(Clan c) {
        synchronized (CLANNS) {
            CLANNS.put(c.name, c);
        }
        synchronized (CLANIDS) {
            CLANIDS.put(c.ID, c);
        }
        synchronized (CLANS) {
            CLANS.add(c);
        }
    }
    
    public static void create(Char charz, int id, String text) {
        int[] clanImage = ClanImage.getClanImage(id);
        if (charz.myObj().isExitClan) {
            charz.addInfo1(mResources.WAIT_TOMORROW);
        } else if (clanImage != null && charz.canProceed()) {
            if (clanImage[1] > charz.xu) {
                charz.addInfo1(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(clanImage[1] - charz.xu)));
            } else if (clanImage[2] > charz.luong) {
                charz.addInfo1(String.format(mResources.CONTHIEU_NGOC, clanImage[2] - charz.luong));
            } else {
                Clan c;
                if (!Util.gI().CheckString(text, mResources.REGEX_VIETNAM) || text.length() < 3 || text.length() > 20) {
                    charz.addInfo1(mResources.CREATE_CALN_FAILD1);
                } else if (isHaveClan(text)){
                    charz.addInfo1(mResources.CREATE_CALN_FAILD2);
                } else {
                    charz.updateXu(-clanImage[1], 0);
                    charz.updateLuong(-clanImage[2], 0);
                    c = new Clan();
                    c.leaderName = charz.cName;
                    c.name = text;
                    c.imgID = id;
                    c.level = 1;
                    c.maxMember = 10;
                    c.date = (int) (System.currentTimeMillis() / 1000L);
                    c.yesterday = System.currentTimeMillis();
                    c.lastReport = System.currentTimeMillis();
                    c.shortName = text.substring(0, 3);
                    charz.clan = c;
                    c.setMember(charz, 0);
                    charz.updateAll();
                    charz.session.service.meLoadPoint();
                    charz.session.service.getBag(charz.charID, charz.bag);
                    charz.zoneMap.playerLoadAll(charz);

                    
                    JSONArray jmembers = new JSONArray();
                    JSONArray jmessages = new JSONArray();
                    JSONArray m = new JSONArray();
                    m.add(charz.clanMember.ID);
                    m.add(charz.clanMember.head);
                    m.add(charz.clanMember.headICON);
                    m.add(charz.clanMember.leg);
                    m.add(charz.clanMember.body);
                    m.add(charz.clanMember.name);
                    m.add(charz.clanMember.role);
                    m.add(charz.clanMember.powerPoint);
                    m.add(charz.clanMember.donate);
                    m.add(charz.clanMember.receive_donate);
                    m.add(charz.clanMember.clanPoint);
                    m.add(charz.clanMember.curClanPoint);
                    m.add(charz.clanMember.joinTime);
                    jmembers.add(m);
                    try {
                        MySQL mySQL = MySQL.createData3();
                        try {
                            mySQL.getConnection().setAutoCommit(false);
                            try {
                                PreparedStatement p = mySQL.getConnection().prepareStatement(String.format(
                                        mResources.INSERT_CLAN,
                                        Util.gI().stringSQL(c.name),
                                        Util.gI().stringSQL(c.slogan),
                                        c.date,
                                        c.imgID,
                                        c.powerPoint,
                                        Util.gI().stringSQL(c.leaderName),
                                        c.maxMember,
                                        c.clanPoint,
                                        c.level,
                                        Util.gI().stringSQL(jmembers.toJSONString()),
                                        Util.gI().stringSQL(jmessages.toJSONString()),
                                        c.lastOneMember,
                                        c.yesterday,
                                        c.shortName
                                        ,c.lastReport
                                ), Statement.RETURN_GENERATED_KEYS);
                                p.executeUpdate();
                                ResultSet red = p.getGeneratedKeys();
                                red.first();
                                c.ID = red.getInt(1);
                                mySQL.getConnection().commit();
                            } catch (SQLException e) {
                                mySQL.getConnection().rollback();
                                e.printStackTrace();
                            }
                        } finally {
                            mySQL.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    Clan.addClan(c);
                    charz.session.isSave = true;
                    charz.session.service.meLoadInfo();
                    charz.addInfo1(mResources.CREATE_CALN_SUCCESS);
                    c.clanInfo();
                }
            }
        }
    }
    
    public static void findClan(Char charz, String text) {
        if (charz.listClan == null) {
            charz.listClan = new ArrayList<>();
        } else {
            charz.listClan.clear();
        }
        if (text.isEmpty()) {
            synchronized (CLANS) {
                for (int i = 0; i < CLANS.size(); ++i) {
                    for (int i2 = 0; i2 < 1000; i2++) {
                        Clan clan2 = CLANS.get(Util.gI().nextInt(CLANS.size()));
                        if (!charz.listClan.contains(clan2)) {
                            charz.listClan.add(clan2);
                            break;
                        }
                    }
                    if (charz.listClan.size() > 25) {
                        break;
                    }
                }
            }
        } else {
            synchronized (CLANIDS) {
                Iterator<Integer> itr = CLANIDS.keySet().iterator();
                while (itr.hasNext()) {
                    Integer key = itr.next();
                    Clan clan = CLANIDS.get(key);
                    if (clan != null && clan.name.contains(text)) {
                        charz.listClan.add(clan);
                    }
                    if (charz.listClan.size() > 25) {
                        break;
                    }
                }
            }
        }
        charz.session.service.findClan(charz.listClan);
    }
    
    public boolean isExistMember(String cName) {
        int i;
        boolean b = false;
        synchronized (members) {
            for (i = 0; i < members.size(); i++) {
                ClanMember mem = members.get(i);
                if (mem.name.equals(cName)) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public ClanMember getMemberByName(String name) {
        int i;
        ClanMember o = null;
        synchronized (members) {
            for (i = 0; i < members.size(); i++) {
                ClanMember mem = members.get(i);
                if (mem.name.equals(name)) {
                    o = mem;
                    break;
                }
            }
        }
        return o;
    }
    
    public ClanMember getMemberByID(int ID) {
        int i;
        ClanMember o = null;
        synchronized (members) {
            for (i = 0; i < members.size(); i++) {
                ClanMember mem = members.get(i);
                if (mem.ID == ID) {
                    o = mem;
                    break;
                }
            }
        }
        return o;
    }
    
    public void addMember(ClanMember o) {
        synchronized (members) {
            members.add(o);
        }
    }
    
    public void setMember(Char charz, int role) {
        if (this.isExistMember(charz.cName)) {
            ClanMember o = this.getMemberByName(charz.cName);
            o.ID = charz.charID;
            o.name = charz.cName;
            o.head = charz.head;
            o.headICON = charz.headICON;
            o.body = charz.body;
            o.leg = charz.leg;
            o.role = (byte) role;
        } else {
            ClanMember o = new ClanMember();
            o.ID = charz.charID;
            o.name = charz.cName;
            o.head = charz.head;
            o.headICON = charz.headICON;
            o.body = charz.body;
            o.leg = charz.leg;
            o.role = (byte) role;
            o.joinTime = (int) (System.currentTimeMillis() / 1000);
            addMember(o);
            charz.clan = this;
            charz.clanMember = o;
        }
    }
    
    public void setClan(Char charz, int imgID, String text) {
        if (!text.isEmpty()) {
            if (text.length() == 0 || text.length() > 30 || !Util.gI().CheckString(text, mResources.REGEX_VIETNAM)) {
                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_KTDB, null, 0);
            } else {
                this.slogan = text;
                charz.session.service.setClan(this.imgID, this.slogan);
            }
        } else if (imgID != this.imgID ) {
            int[] clanImage = ClanImage.getClanImage(imgID);
            if (clanImage != null && charz.canProceed()) {
                if (clanImage[1] > charz.xu) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(clanImage[1] - charz.xu)), null, (byte)0);
                } else if (clanImage[2] > charz.luong) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.CONTHIEU_NGOC, clanImage[2] - charz.luong), null, (byte)0);
                } else {
                    charz.updateXu(-clanImage[1], 0);
                    charz.updateLuong(-clanImage[2], 0);
                    this.imgID = imgID;
                    charz.session.service.meLoadInfo();
                    charz.session.service.setClan(this.imgID, this.slogan);
                    this.clanImgID();
                }
            }
        }
    }
    
    public int getSizeMember() {
        int r;
        synchronized (this.members) {
            r = this.members.size();
        }
        return r;
    }
    
    public void clanInfo() {
        int i;
        String[] ns;
        synchronized (members) {
            ns = new String[members.size()];
            for (i = 0; i < members.size(); i++) {
                ns[i] = members.get(i).name;
            }
        }
        for (i = 0; i < ns.length; i++) {
            if (ns[i] != null) {
                Session_ME player = Server.gI().getByCName(ns[i]);
                if (player != null && player.myCharz().clan == this) {
                    player.service.clanInfo(player.myCharz().getRole(), this);
                }
            }
        }
        
    }
    
    public void clanImgID() {
        int i;
        String[] ns;
        synchronized (members) {
            ns = new String[members.size()];
            for (i = 0; i < members.size(); i++) {
                ns[i] = members.get(i).name;
            }
        }
        for (i = 0; i < ns.length; i++) {
            if (ns[i] != null) {
                Session_ME player = Server.gI().getByCName(ns[i]);
                if (player != null && player.myCharz().clan == this && player.myCharz().zoneMap != null) {
                    player.myCharz().updateAll();
                    player.service.meLoadPoint();
                    player.service.getBag(player.myCharz().charID, player.myCharz().bag);
                    player.myCharz().zoneMap.playerLoadAll(player.myCharz());
                }
            }
        }
        
    }
    
    public int addInvite(int playerId) {
        int code = Invite.getCode();
        synchronized (invites) {
            Invite i = new Invite();
            i.code = code;
            i.time = 14000;
            i.playerId = playerId;
            invites.add(i);
        }
        return code;
    }
    
    public boolean isHaveInvite(int code, int playerId) {
        boolean b = false;
        int i;
        synchronized (invites) {
            for (i = 0; i < invites.size(); i++) {
                if (invites.get(i).playerId == playerId && invites.get(i).code == code) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public boolean isHaveInvite(int playerId) {
        boolean b = false;
        synchronized (invites) {
            for (int i = 0; i < invites.size(); i++) {
                if (invites.get(i).playerId == playerId) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public Object[] removeMember(int charId) {
        //Clear
        synchronized (members) {
            for (int i = 0; i < members.size(); i++) {
                if (members.get(i).ID == charId) {
                    return new Object[]{members.remove(i), i};
                }
            }
        }
        return null;
    }
    
    public void removeMember(Char charz, int charId) {
        Object[] array = removeMember(charId);
        if (array != null) {
            ClanMember m = (ClanMember) array[0];
            Obj obj = Obj.gI(m.name);
            if (obj.myChar != null) {
                obj.isExitClan = true;
                obj.myChar.setClan(-1);
                Session_ME player = Server.gI().getByCName(m.name);
                if (player != null && player.myCharz().zoneMap != null) {
                    player.myCharz().session.service.clanInfo(-1, null);
                    player.myCharz().updateAll();
                    player.service.meLoadPoint();
                    player.service.getBag(player.myCharz().charID, player.myCharz().bag);
                    player.myCharz().zoneMap.playerLoadAll(player.myCharz());
                }
            }
            this.removeClanMember((int) array[1]);
            
            //Log
            ClanMessage msg = new ClanMessage();
            msg.type = 0;
            msg.time = (int) (System.currentTimeMillis() / 1000);
            msg.color = 7;
            if (charz != null) {
                msg.playerId = charz.charID;
                msg.playerName = charz.cName;
                msg.headId = charz.head;
                msg.role = charz.getRole();
                msg.chat = String.format(mResources.PLAYER_KICK_CLAN, m.name);
            } else {
                msg.playerId = m.ID;
                msg.playerName = m.name;
                msg.headId = m.head;
                msg.role = m.role;
                msg.chat = String.format(mResources.PLAYER_EXIT_CLAN, m.name);
            }

            //Load
            this.addMsg(msg);
            this.addMessage(msg);
        }
    }
    
    public void clanRemote(Char charz, int id, int role) {
        if (charz.isSecurity) {
            charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAOVE, null, 0);
        } else if (this.isWork()) {
            charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_SET_CLAN, null, 0);
        } else {
            ClanMember mem = this.getMemberByID(id);
            if (id != charz.charID && mem != null && mem.role != 0) {
                if (role == -1 && (mem.role == 2 || (charz.clanMember.role == 0 && mem.role == 1))) {
                    this.removeMember(charz, id);
                }
                if (role == 0 && charz.clanMember.role == 0 && mem.role != 0) {
                    mem.role = 0;
                    this.leaderName = mem.name;
                    charz.clanMember.role = 2;
                    this.clanInfo();
                }
                if (role == 1 && mem.role != 1) {
                    mem.role = 1;
                    this.setClanMember(mem);
                }
                if (role == 2 && charz.clanMember.role == 0 && mem.role != 2) {
                    mem.role = 2;
                    this.setClanMember(mem);
                }
            }
        }
        Util.gI().logln("id="+id+" role="+role);
    }
    
    public void addMsg(ClanMessage msg) {
        synchronized(this.messages) {
            if (this.messages.size() > 25) {
                this.messages.remove(0);
            }
            if (!this.messages.isEmpty()) {
                msg.id = this.messages.get(this.messages.size() - 1).id + 1;
            }
            this.messages.add(msg);
        }
    }
    
    public boolean isHaveMsgPlayerNameInvate(String cName) {
        boolean b = false;
        int i;
        synchronized (messages) {
            for (i = 0; i< messages.size(); i++) {
                if (messages.get(i).type == 2 && messages.get(i).chat.equals(cName)) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public ClanMessage getMsgPlayerNameInvate(String cName) {
        ClanMessage m = null;
        int i;
        synchronized (messages) {
            for (i = 0; i< messages.size(); i++) {
                if (messages.get(i).type == 2 && messages.get(i).playerName.equals(cName)) {
                    m = messages.get(i);
                    break;
                }
            }
        }
        return m;
    }
    
    public ClanMessage getMsg(int ID) {
        ClanMessage m = null;
        int i;
        synchronized (messages) {
            for (i = 0; i< messages.size(); i++) {
                if (messages.get(i).id == ID) {
                    m = messages.get(i);
                    break;
                }
            }
        }
        return m;
    }
    
    public void addMessage(ClanMessage msg) {
        int[] pIds;
        synchronized (members) {
            pIds = new int[members.size()];
            for (int i = 0; i < members.size(); i++) {
                pIds[i] = members.get(i).ID;
            }
        }
        for (int i = 0; i < pIds.length; i++) {
            Session_ME player = Server.gI().getByCId(pIds[i]);
            if (player != null && player.myCharz().clan == this) {
                player.service.addClanMessage(msg);
            }
        }
    }
    
    public void addClanMember(ClanMember member) {
        int pIds[];
        synchronized (members) {
            pIds = new int[members.size()];
            for (int i = 0; i < members.size(); i++) {
                pIds[i] = members.get(i).ID;
            }
        }
        for (int i = 0; i < pIds.length; i++) {
            Session_ME player = Server.gI().getByCId(pIds[i]);
            if (player != null && player.myCharz().clan == this) {
                player.service.addClanMember(member);
            }
        }
    }
    
    public void removeClanMember(int index) {
        int pIds[];
        synchronized (members) {
            pIds = new int[members.size()];
            for (int i = 0; i < members.size(); i++) {
                pIds[i] = members.get(i).ID;
            }
        }
        for (int i = 0; i < pIds.length; i++) {
            Session_ME player = Server.gI().getByCId(pIds[i]);
            if (player != null && player.myCharz().clan == this) {
                player.service.removeClanMember(index);
            }
        }
    }
    
    public void setClanMember(ClanMember member) {
        int[] pIds;
        synchronized (members) {
            pIds = new int[members.size()];
            for (int i = 0; i < members.size(); i++) {
                pIds[i] = members.get(i).ID;
            }
        }
        for (int i = 0; i < pIds.length; i++) {
            Session_ME player = Server.gI().getByCId(pIds[i]);
            if (player != null && player.myCharz().clan == this) {
                player.service.setClanMember(member);
            }
        }
    }
    
    //add thanh vien
    public void joinClan(Char charz, int id, byte action) {
        ClanMessage msg = null;
        String playerName;
        if (action == 0) {
            ClanMessage msgOld = this.getMsg(id);
            if (msgOld != null && msgOld.type == 2) {
                playerName = msgOld.chat;
                Obj obj = Obj.gI(playerName);
                if (obj.myChar == null) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.PLAYER_INVATE_EXPIRED, null, 0);
                } else if (this.isWork()) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_SET_CLAN, null, 0);
                } else if (obj.myChar.clan != null) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.PLAYER_INVATE_ISJOIN, null, 0);
                } else if (this.getSizeMember() >= this.maxMember) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.CLAN_FULL_MEMBER, null, 0);
                } else {
                    synchronized (this.messages) {
                        for (int i1 = 0; i1 < this.messages.size(); i1++) {
                            if (this.messages.get(i1).type == 2 && this.messages.get(i1).id == id) {
                                msg = this.messages.remove(i1);
                                break;
                            }
                        }
                    }
                    this.setMember(obj.myChar, 2);
                    if (obj.myChar.clanMember != null) {
                        Session_ME player = Server.gI().getByCName(playerName);
                        if (player != null && player.myCharz().zoneMap != null) {
                            player.myCharz().updateAll();
                            player.service.meLoadPoint();
                            player.service.getBag(player.myCharz().charID, player.myCharz().bag);
                            player.myCharz().zoneMap.playerLoadAll(player.myCharz());
                        }
                        this.addClanMember(obj.myChar.clanMember);
                    }
                }
            }
        }
        if (action == 1) {
            synchronized (this.messages) {
                for (int i2 = 0; i2 < this.messages.size(); i2++) {
                    if (this.messages.get(i2).type == 2 && this.messages.get(i2).id == id) {
                        msg = this.messages.remove(i2);
                        break;
                    }
                }
            }
        }
        if (msg != null) {
            playerName = msg.chat;
            ClanMessage msgNew = new ClanMessage();
            msgNew.type = 0;
            msgNew.time = (int) (System.currentTimeMillis() / 1000);
            msgNew.color = 7;
            msgNew.playerId = charz.charID;
            msgNew.playerName = charz.cName;
            msgNew.headId = charz.head;
            msgNew.role = charz.getRole();
            if (action == 0) {
                msgNew.chat = String.format(mResources.PLAYER_JOIN_CLAN, playerName);
                Session_ME player = Server.gI().getByCName(playerName);
                if (player != null) {
                    player.service.clanInfo(player.myCharz().getRole(), this);
                }
                
            }
            if (action == 1) {
                msgNew.chat = String.format(mResources.PLAYER_NOTJOIN_CLAN, playerName);
            }
            //Load
            this.addMsg(msgNew);
            this.addMessage(msgNew);
            
            
            
            
        }
        Util.gI().logln("id="+id+" action="+action);
    }
    
    public void initClan(ResultSet res) {
        int i;
        ClanMember mem;
        ClanMessage msg;
        JSONArray jmem;
        JSONArray jmsg;
        int n;
        try {
            this.ID = res.getInt("ID");
            this.name = res.getString("name");
            this.slogan = res.getString("slogan");
            this.date = res.getInt("date");
            this.imgID = res.getInt("imgID");
            this.powerPoint = res.getLong("powerPoint");
            this.leaderName = res.getString("leaderName");
            this.maxMember = res.getInt("maxMember");
            this.clanPoint = res.getInt("clanPoint");
            this.level = res.getByte("level");
            //JSONARRAY
            JSONArray jmembers = (JSONArray) JSONValue.parseWithException(res.getString("members"));
            JSONArray jmessages = (JSONArray) JSONValue.parseWithException(res.getString("messages"));
            for (i = 0; i < jmembers.size(); i++) {
                n = 0;
                jmem = (JSONArray) jmembers.get(i);
                mem = new ClanMember();
                mem.ID = Integer.parseInt(jmem.get(n++).toString());
                mem.head = Short.parseShort(jmem.get(n++).toString());
                mem.headICON = Short.parseShort(jmem.get(n++).toString());
                mem.leg = Short.parseShort(jmem.get(n++).toString());
                mem.body = Short.parseShort(jmem.get(n++).toString());
                mem.name = jmem.get(n++).toString();
                mem.role = Byte.parseByte(jmem.get(n++).toString());
                mem.powerPoint = Long.parseLong(jmem.get(n++).toString());
                mem.donate = Integer.parseInt(jmem.get(n++).toString());
                mem.receive_donate = Integer.parseInt(jmem.get(n++).toString());
                mem.clanPoint = Integer.parseInt(jmem.get(n++).toString());
                mem.curClanPoint = Integer.parseInt(jmem.get(n++).toString());
                mem.joinTime = Integer.parseInt(jmem.get(n++).toString());
                this.members.add(mem);
            }
            for (i = 0; i < jmessages.size(); i++) {
                n = 0;
                jmsg = (JSONArray) jmessages.get(i);
                msg = new ClanMessage();
                msg.type = Byte.parseByte(jmsg.get(n++).toString());
                msg.id = Integer.parseInt(jmsg.get(n++).toString());
                msg.playerId = Integer.parseInt(jmsg.get(n++).toString());
                msg.playerName = jmsg.get(n++).toString();
                msg.role = Byte.parseByte(jmsg.get(n++).toString());
                msg.time = Integer.parseInt(jmsg.get(n++).toString());
                msg.chat = jmsg.get(n++).toString();
                msg.color = Byte.parseByte(jmsg.get(n++).toString());
                msg.recieve = Byte.parseByte(jmsg.get(n++).toString());
                msg.maxCap = Byte.parseByte(jmsg.get(n++).toString());
                this.messages.add(msg);
            }
            this.lastOneMember = res.getLong("lastOneMember");
            this.yesterday = res.getLong("yesterday");
            this.timeBarrack = res.getString("timeBarrack");
            this.playerBarrack = res.getString("playerBarrack");
            this.countbarrack = res.getByte("countbarrack");
            this.num_ = res.getByte("countgas");
            this.shortName = res.getString("shortName");
            this.lastReport = res.getLong("lastReport");
        } catch(SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveDataClan() {
        //Save clan
        Clan[] arrClan;
        synchronized(Clan.CLANS) {
            arrClan = new Clan[Clan.CLANS.size()];
            for (int i2 = 0; i2 < Clan.CLANS.size(); i2++) {
                arrClan[i2] = Clan.CLANS.get(i2);
            }
        }
        for (int i1 = 0; i1 < arrClan.length; i1++) {
            arrClan[i1].saveData();
        }
        ///
        
    }
    
    public void saveData() {
        JSONArray jmembers = new JSONArray();
        JSONArray jmessages = new JSONArray();
        synchronized (this.members) {
            for (int i1 = 0; i1 < this.members.size(); i1++) {
                ClanMember mem = this.members.get(i1);
                JSONArray m1 = new JSONArray();
                m1.add(mem.ID);
                m1.add(mem.head);
                m1.add(mem.headICON);
                m1.add(mem.leg);
                m1.add(mem.body);
                m1.add(mem.name);
                m1.add(mem.role);
                m1.add(mem.powerPoint);
                m1.add(mem.donate);
                m1.add(mem.receive_donate);
                m1.add(mem.clanPoint);
                m1.add(mem.curClanPoint);
                m1.add(mem.joinTime);
                jmembers.add(m1);
            }
        }
        synchronized (this.messages) {
            for (int i2 = 0; i2 < this.messages.size(); i2++) {
                ClanMessage msg = this.messages.get(i2);
                JSONArray m2 = new JSONArray();
                m2.add(msg.type);
                m2.add(msg.id);
                m2.add(msg.playerId);
                m2.add(msg.playerName);
                m2.add(msg.role);
                m2.add(msg.time);
                m2.add(msg.chat);
                m2.add(msg.color);
                m2.add(msg.recieve);
                m2.add(msg.maxCap);
                jmessages.add(m2);
            }
        }
        try {
            MySQL mySQL = MySQL.createData3();
            try {
                mySQL.getConnection().setAutoCommit(false);
                try {
                    mySQL.getConnection().prepareStatement(String.format(
                            mResources.UPDATE_CLAN,
                            Util.gI().stringSQL(this.slogan),
                            this.date,
                            this.imgID,
                            this.powerPoint,
                            Util.gI().stringSQL(this.leaderName),
                            this.maxMember,
                            this.clanPoint,
                            this.level,
                            Util.gI().stringSQL(jmembers.toJSONString()),
                            Util.gI().stringSQL(jmessages.toJSONString()),
                            this.lastOneMember,
                            this.yesterday,
                            this.timeBarrack,
                            this.playerBarrack,
                            this.countbarrack,
                            this.num_,
                            this.shortName,
                            this.lastReport,
                            this.ID
                    )).executeUpdate();
                    mySQL.getConnection().commit();
                } catch (SQLException e) {
                    mySQL.getConnection().rollback();
                    e.printStackTrace();
                }
            } finally {
                mySQL.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
//    public static void saveClan() {
//        //Save clan
//        Clan[] arrClan;
//        synchronized(Clan.CLANS) {
//            arrClan = new Clan[Clan.CLANS.size()];
//            for (int i2 = 0; i2 < Clan.CLANS.size(); i2++) {
//                arrClan[i2] = Clan.CLANS.get(i2);
//            }
//        }
//        Clan.backup(arrClan, false);
//        ///
//        
//    }
    
    public void dissolution() {
        ClanMember[] arrMem;
        int i;
        //Xoa tv trong map
        for (i = 0; i < this.maps.size(); i++) {
            for (int j = 0; j < this.maps.get(i).zones.size(); j++) {
                this.maps.get(i).zones.get(j).pushPlayers(0);
            }
        }
        //Xoa top
        Rank.getRank(0).removeTop(this.name);
        //Xoa member
        synchronized (members) {
            arrMem = new ClanMember[members.size()];
            for (i = members.size() - 1; i >= 0; i--) {
                arrMem[i] = members.remove(i);
            }
        }
        for (i = 0; i < arrMem.length; i++) {
            if (arrMem[i] != null) {
                Session_ME player = Server.gI().getByCName(arrMem[i].name);
                if (player != null) {
                    player.myCharz().setClan(-1);
                    player.service.clanInfo(-1, null);
                    if (player.myCharz().zoneMap != null) {
                        player.myCharz().updateAll();
                        player.service.meLoadPoint();
                        player.service.getBag(player.myCharz().charID, player.myCharz().bag);
                        player.myCharz().zoneMap.playerLoadAll(player.myCharz());
                    }
                    player.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.CLAN_GIAI_TAN, this.name), null, 0);
                }

            }
        }
        try {
            MySQL mySQL = MySQL.createData3();
            try {
                mySQL.getConnection().setAutoCommit(false);
                try {
                    mySQL.getConnection().prepareStatement(String.format(
                            mResources.DELETE_CLAN,
                            this.ID
                    )).executeUpdate();
                    mySQL.getConnection().commit();
                } catch(SQLException e) {
                    mySQL.getConnection().rollback();
                    e.printStackTrace();
                }
            } finally {
                mySQL.close();
            }
            this.isDelete = true;
            Clan.removeClan(this);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int getMaxSDMember() {
        int num = 0;
        int i;
        String[] arrM;
        synchronized (members) {
            arrM = new String[members.size()];
            for (i = 0; i < members.size(); i++) {
                arrM[i] = members.get(i).name;
            }
        }
        for (i = 0; i < arrM.length; i++) {
            Session_ME player = Server.gI().getByCName(arrM[i]);
            if (player != null && num < player.myCharz().cDamFull) {
                num = player.myCharz().cDamFull;
            }
        }
        return num;
    }
    
    public int getMaxHPMember() {
        int num = 0;
        int i;
        String[] arrM;
        synchronized (members) {
            arrM = new String[members.size()];
            for (i = 0; i < members.size(); i++) {
                arrM[i] = members.get(i).name;
            }
        }
        for (i = 0; i < arrM.length; i++) {
            Session_ME player = Server.gI().getByCName(arrM[i]);
            if (player != null && num < player.myCharz().cHPFull) {
                num = player.myCharz().cHPFull;
            }
        }
        return num;
    }
    
    public void updateDay() {
        this.yesterday = System.currentTimeMillis();
        this.countbarrack = 0;
        //Clear
        if (this.getSizeMember() < 2) {
            this.dissolution();
        } else if (Util.gI().getDayGap(this.lastReport) > 7) {
            this.dissolution();
        }
    }
    
    public boolean isWork() {
        return (this.destronGas != null && this.destronGas.miliTime != 0) || (this.doanhTrai != null && this.doanhTrai.miliTime != 0) || (this.khobau != null && this.khobau.miliTime != 0) || (this.roadSnake != null && this.roadSnake.miliTime != 0) || (this.doelBossClan != null && this.doelBossClan.miliTime != 0);
    }
    
    public Map getMap(int mapTemplateId) {
        int i;
        for (i = 0; i < this.maps.size(); i++) {
            if (this.maps.get(i).templateId == mapTemplateId) {
                return this.maps.get(i);
            }
        }
        return null;
    }
    
    public void setShortName(Char charz, String str) {
        this.shortName = str;
        charz.addInfo1(String.format(mResources.SHORT_TEXT_CLAN_OK, str.toUpperCase()));
        this.lastChangeShortName = System.currentTimeMillis() + 45000;
    }
    
}
