package dragon.t;

import dragon.server.MySQL;
import dragon.server.Server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author TGDD
 */
public class LuyenTap {
    
    public LuyenTap(ResultSet res) throws SQLException {
        this.playerId = res.getInt("playerId");
        this.charID = Char.getNewCharID();
        this.name = res.getString("name");
        this.head = res.getShort("head");
        this.body = res.getShort("body");
        this.leg = res.getShort("leg");
        this.level = res.getInt("level");
        this.timeFight = res.getInt("timeFight");
        this.last = res.getLong("last");
        this.gift = res.getByte("gift");
    }
    
    public LuyenTap(String name, int playerId, int charID) {
        this.name = name;
        this.playerId = playerId;
        this.charID = charID;
    }
    
    public short head;
    public short body;
    public short leg;
    public short headICON = -1;
    public String name;
    public int playerId;
    public int charID;
    public int level;
    public int timeFight;
    public long last;
    public byte gift;
    
    public static final ArrayList<LuyenTap> LUYENS = new ArrayList<>();
    public static final ArrayList<LuyenTap> GIFTS = new ArrayList<>();
    public static final HashMap<String, LuyenTap> LUYENNAMES = new HashMap<>();
    public static final HashMap<Integer, LuyenTap> LUYENIDS = new HashMap<>();
    public static long lastWeek;
    
    public static void set(Char player) {
        synchronized(LUYENS) {
            LuyenTap o;
            if (LUYENNAMES.containsKey(player.cName)) {
                o = LUYENNAMES.get(player.cName);
            } else {
                o = new LuyenTap(player.cName, player.playerId, player.charID);
                o.level = 1;
                o.last = System.currentTimeMillis();
                o.timeFight = (int) (System.currentTimeMillis() - player.lastFight);
                o.gift = 0;
                LUYENS.add(o);
                LUYENNAMES.put(player.cName, o);
                LUYENIDS.put(o.playerId, o);
            }
            o.head = player.head;
            o.body = player.body;
            o.leg = player.leg;
        }
    }
    
    public static LuyenTap get(String name) {
        synchronized(LUYENS) {
            return LUYENNAMES.get(name);
        }
    }
    
    public static LuyenTap get(int playerId) {
        synchronized(LUYENS) {
            return LUYENIDS.get(playerId);
        }
    }
    
    public static boolean isHaveByName(String name) {
        synchronized(LUYENS) {
            return LUYENNAMES.containsKey(name);
        }
    }
    
    public static int getLevel(String name) {
        synchronized(LUYENS) {
            if (LUYENNAMES.containsKey(name)) {
                return LUYENNAMES.get(name).level;
            }
            return 1;
        }
    }
    
    public static void sortTOP() {
        synchronized(LUYENS) {
            Collections.sort(LUYENS, (LuyenTap level1, LuyenTap level2) -> Integer.compare(level2.level, level1.level));
        }
    }
    
    public static void openTOP(Char player) {
        ArrayList<LuyenTap> list = new ArrayList<>();
        synchronized(LUYENS) {for (int i = 0; i < 100 && i < LUYENS.size(); i++) {
                list.add(LUYENS.get(i));
            }
        }
        player.session.service.topLuyenTap(list);
    }
    
    public static void add(LuyenTap o) {
        synchronized(LUYENS) {
            if (o.gift != 0) {
                GIFTS.add(o);
            } else {
                LUYENS.add(o);
                LUYENNAMES.put(o.name, o);
                LUYENIDS.put(o.playerId, o);
            }
        }
    }
    
    public static void clear() {
        synchronized(LUYENS) {
            LUYENS.clear();
            LUYENNAMES.clear();
            LUYENIDS.clear();
        }
    }
    
    public static void saveData() {
        ArrayList<LuyenTap> arrList = new ArrayList<>();
        synchronized(LUYENS) {
            for (int i = 0; i < LUYENS.size(); i++) {
                arrList.add(LUYENS.get(i));
            }
            for (int i = 0; i < GIFTS.size(); i++) {
                arrList.add(GIFTS.get(i));
            }
        }
        try {
            MySQL mySQL = MySQL.createData8();
            try {
                mySQL.getConnection().setAutoCommit(false);
                try {
                    mySQL.getConnection().prepareStatement("DELETE FROM `luyentap`;").executeUpdate();
                    for (int i = 0; i < arrList.size(); i++) {
                        mySQL.getConnection().prepareStatement("INSERT INTO `luyentap` (`id`, `playerId`, `name`, `head`, `body`, `leg`, `level`, `timeFight`, `last`, `gift`) VALUES (NULL, '"+arrList.get(i).playerId+"', '"+arrList.get(i).name+"', '"+arrList.get(i).head+"', '"+arrList.get(i).body+"', '"+arrList.get(i).leg+"', '"+arrList.get(i).level+"', '"+arrList.get(i).timeFight+"', '"+arrList.get(i).last+"', '"+arrList.get(i).gift+"');").executeUpdate();
                    }
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
    
    public static LuyenTap removeGift(int playerId) {
        synchronized(LUYENS) {
            for (int i = 0; i < GIFTS.size(); i++) {
                if (GIFTS.get(i).playerId == playerId) {
                    return GIFTS.remove(i);
                }
            }
            return null;
        }
    }
    
    public static void init() {
        lastWeek = System.currentTimeMillis();
        clear();
        try {
            MySQL mySQL = MySQL.createData8();
            try {
                ResultSet red = mySQL.getConnection().prepareStatement("SELECT * FROM `luyentap`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                while(red.next()) {
                    LuyenTap o = new LuyenTap(red);
                    LuyenTap.add(o);
                }
            } finally {
                mySQL.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sortTOP();
    }
    
    public static void resetTOP() {
        lastWeek = System.currentTimeMillis();
        sortTOP();
        //Lay ra top 1,2,3
        synchronized(LUYENS) {
            GIFTS.clear();
            for (int i = 0; i < LUYENS.size() && i < 3; i++) {
                GIFTS.add(LUYENS.get(i));
                GIFTS.get(i).gift = (byte) (i + 1);
                GIFTS.get(i).last = System.currentTimeMillis() + 604800000L;
            }
        }
        //Phat qua
        Server.gI().addPhatQua();
        //Xoa
        clear();
    }
    
}
