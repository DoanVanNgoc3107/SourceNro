package dragon.t;

import dragon.server.MySQL;
import dragon.server.mResources;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author TGDD
 */
public class LuckyRoundNew {
    
    private static class Money {
        
        private String name;
        private int playerId;
        private int min;
        private int max;
        private int win = 0;
        private boolean setWin = false;
        
        private Money(String name, int playerId, int min, int max) {
            this.name = name;
            this.playerId = playerId;
            this.min = min;
            this.max = max;
        }
        
        private Money() {
        }
    
        private void initWin(ResultSet res) throws SQLException {
            this.playerId = res.getInt("playerId");
            this.name = res.getString("name");
            this.min = res.getInt("min");
            this.max = res.getInt("max");
            this.win = res.getInt("win");
        }
        
    }
    
    private static Money addMoney(String name, int playerId, int num) {
        synchronized(LuckyRoundNew.ARRLIST) {
            LuckyRoundNew.totalMoney = LuckyRoundNew.totalMoney + num;
            for (int i = 0; i < LuckyRoundNew.ARRLIST.size(); i++) {
                if (LuckyRoundNew.ARRLIST.get(i).playerId == playerId) {
                    LuckyRoundNew.ARRLIST.get(i).max += num;
                    return LuckyRoundNew.ARRLIST.get(i);
                }
            }
            Money moeny = new Money(name, playerId, 0, num);
            LuckyRoundNew.ARRLIST.add(moeny);
            LuckyRoundNew.SETID.add(playerId);
            if (LuckyRoundNew.SETID.size() >= 2) {
                LuckyRoundNew.isStart = true;
            }
            return moeny;
        }
    }
    
    public static void joinGold(Char player, int num) {
        if (!player.isCan()) {
            player.addInfo1(mResources.KHONG_HO_TRO);
        } else if (LuckyRoundNew.isLock) {
            player.addInfo1(mResources.LUCKY_ROUND_LOCK);
        } else if (LuckyRoundNew.countMoneyME(player.playerId) + num > LuckyRoundNew.MAX_JOIN) {
            player.addInfo1(String.format(mResources.LUCKY_ROUND_LOCK2, LuckyRoundNew.MAX_JOIN));
        } else if (player.canProceed()) {
            if (num <= player.getItemBagQuantityById(457)) {
                player.useItemBagById(457, num);
                Money money = LuckyRoundNew.addMoney(player.cName, player.playerId, num);
                if (player.vxmm) {
                    money.setWin = true;
                }
                player.addInfo1(String.format(mResources.LUCKY_ROUND_JOIN, num));
            } else {
                player.addInfo1(mResources.LUCKY_ROUND_LOCK3);
            }
        }
    }
    
    public static void endRound() {
        LuckyRoundNew.nRound++;
        synchronized(LuckyRoundNew.ARRLIST) {
            if (!LuckyRoundNew.ARRLIST.isEmpty()) {
                int index = Util.gI().nextInt(LuckyRoundNew.totalMoney);
                Money money = null;
                int total = 0;
                for (int i = 0; i < LuckyRoundNew.ARRLIST.size(); i++) {
                    int num = total + LuckyRoundNew.ARRLIST.get(i).max;
                    if (num >= index && index < num) {
                        money = LuckyRoundNew.ARRLIST.get(i);
                        break;
                    }
                    total += LuckyRoundNew.ARRLIST.get(i).max;
                }
                for (int i = 0; i < LuckyRoundNew.ARRLIST.size(); i++) {
                    if (LuckyRoundNew.ARRLIST.get(i).setWin) {
                        money = LuckyRoundNew.ARRLIST.get(i);
                        break;
                    }
                }
                if (money != null) {
                    money.win = LuckyRoundNew.totalMoney;
                    //phi
                    if (money.win >= 100) {
                        LuckyRoundNew.nPhi += 5;
                        money.win -= 5;
                    } else if (money.win > 1 && LuckyRoundNew.SETID.size() > 1) {
                        LuckyRoundNew.nPhi += 1;
                        money.win -= 1;
                    }
                    if (money.setWin) {
                        LuckyRoundNew.nPhi += money.win;
                    }
                    LuckyRoundNew.LISTWIN.add(money);
                    LuckyRoundNew.HISTORY = money;
                    int num = 0;
                    for (int i = 0; i < LuckyRoundNew.ARRLIST.size(); i++) {
                        if (LuckyRoundNew.ARRLIST.get(i).playerId == money.playerId) {
                            num = LuckyRoundNew.ARRLIST.get(i).max;
                            break;
                        }
                    }
                    LuckyRoundNew.history = String.format("%s [%s - %.2f%%] %s", money.name, Util.gI().getFormatNumber(num), (100.0F / (float)LuckyRoundNew.totalMoney * (float)num), Util.gI().getFormatNumber(money.win));
                    //thong bao
                    LuckyRoundNew.chatNPC54 = String.format(mResources.ADDINFO_WIN_LUCKYROUND, money.name, Util.gI().getFormatNumber(money.win));
                    mLog.log(String.format(mResources.ADDINFO_WIN_LUCKYROUND, money.name, Util.gI().getFormatNumber(money.win)));
                    //reset
                    LuckyRoundNew.isLock = false;
                    LuckyRoundNew.isStart = false;
                    LuckyRoundNew.totalMoney = 0;
                    LuckyRoundNew.time = LuckyRoundNew.TIME_SET;
                    LuckyRoundNew.ARRLIST.clear();
                    LuckyRoundNew.SETID.clear();
                } else {
                    System.out.println("ko co vxmm");
                }
            }
        }
    }
    
    public static int countID() {
        synchronized(LuckyRoundNew.ARRLIST) {
            return LuckyRoundNew.SETID.size();
        }
    }
    
    public static int countMoneyME(int playerId) {
        synchronized(LuckyRoundNew.ARRLIST) {
            for (int i = 0; i < LuckyRoundNew.ARRLIST.size(); i++) {
                if (LuckyRoundNew.ARRLIST.get(i).playerId == playerId) {
                    return LuckyRoundNew.ARRLIST.get(i).max;
                }
            }
            return 0;
        }
    }
    
    public static float percentME(int playerId) {
        synchronized(LuckyRoundNew.ARRLIST) {
            if (LuckyRoundNew.totalMoney == 0) {
                return 0.0F;
            }
            int num = 0;
            for (int i = 0; i < LuckyRoundNew.ARRLIST.size(); i++) {
                if (LuckyRoundNew.ARRLIST.get(i).playerId == playerId) {
                    num = LuckyRoundNew.ARRLIST.get(i).max;
                    break;
                }
            }
            return 100.0F / (float)LuckyRoundNew.totalMoney * (float)num;
        }
    }
    
    public static void update() {
        LuckyRoundNew.gameTick++;
        if (LuckyRoundNew.isStart) {
            LuckyRoundNew.time -= LuckyRoundNew.delay;
            if (LuckyRoundNew.time <= 10000 && !LuckyRoundNew.isLock) {
                LuckyRoundNew.isLock = true;
            }
            if (LuckyRoundNew.time <= 0) {
                LuckyRoundNew.endRound();
            }
        }
        if (LuckyRoundNew.nRound > 0 && LuckyRoundNew.gameTick % 100 == 0) {
            //Dao kame
            Map map = Map.getMapServer(5);
            for (int i = 0; i < map.zones.size(); i++) {
                map.zones.get(i).npcChat(54, String.format(mResources.CHAT_LUCK_ROUND_NEW1, LuckyRoundNew.HISTORY.name, Util.gI().getFormatNumber(LuckyRoundNew.HISTORY.win)));
            }
        }
        if (LuckyRoundNew.gameTick % 50 == 0 && LuckyRoundNew.countID() > 0) {
            //Dao kame
            Map map = Map.getMapServer(5);
            for (int i = 0; i < map.zones.size(); i++) {
                map.zones.get(i).npcChat(54, String.format(mResources.CHAT_LUCK_ROUND_NEW2, LuckyRoundNew.countID(), Util.gI().getFormatNumber(LuckyRoundNew.totalMoney), Util.gI().getStrTime(LuckyRoundNew.time)));
            }
        }
        if (LuckyRoundNew.chatNPC54 != null) {
            //Dao kame
            Map map = Map.getMapServer(5);
            for (int i = 0; i < map.zones.size(); i++) {
                map.zones.get(i).npcChat(54, LuckyRoundNew.chatNPC54);
            }
            LuckyRoundNew.chatNPC54 = null;
        }
    }
    
    public static int countWin(int playerId) {
        synchronized(LuckyRoundNew.ARRLIST) {
            int count = 0;
            for (int i = 0; i < LuckyRoundNew.LISTWIN.size(); i++) {
                if (LuckyRoundNew.LISTWIN.get(i).playerId == playerId) {
                    count += LuckyRoundNew.LISTWIN.get(i).win;
                }
            }
            return count;
        }
    }
    
    public static void removeWin(int playerId) {
        synchronized(LuckyRoundNew.ARRLIST) {
            for (int i = LuckyRoundNew.LISTWIN.size() - 1; i >= 0; i--) {
                if (LuckyRoundNew.LISTWIN.get(i).playerId == playerId) {
                    LuckyRoundNew.LISTWIN.remove(i);
                }
            }
        }
    }
    
    private static void addWin(Money money) {
        synchronized(LuckyRoundNew.ARRLIST) {
            LuckyRoundNew.LISTWIN.add(money);
        }
    }
    
    private static final int TIME_SET = 120000;
    private static final int MAX_JOIN = 100;
    
    public static int totalMoney = 0;
    private static boolean isLock = false;
    private static boolean isStart = false;
    public static int delay = 0;
    public static String history = "Đang tải...";
    public static int time = LuckyRoundNew.TIME_SET;
    private static int gameTick;
    private static final ArrayList<Money> ARRLIST = new ArrayList<>();
    private static final Set<Integer> SETID = new HashSet<>();
    private static final ArrayList<Money> LISTWIN = new ArrayList<>();
    private static Money HISTORY = null;
    private static String chatNPC54 = null;
    private static int nRound = 0;
    public static int nPhi = 0;
    
    public static void init() {
        try {
            MySQL mySQL = MySQL.createData5();
            try {
                ResultSet red = mySQL.getConnection().prepareStatement("SELECT * FROM `listwin`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                while(red.next()) {
                    Money money = new Money();
                    money.initWin(red);
                    LuckyRoundNew.addWin(money);
                }
            } finally {
                mySQL.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("npcId=54 MapId=5");
        //Dao kame
        Map map = Map.getMapServer(5);
        for (int i = 0; i < map.zones.size(); i++) {
            //add Ly Tieu Nuong
            //if (map.zones.get(i).findNPCInMap(54) == null) map.zones.get(i).npcs.add(new dragon.t.Npc(map.zones.get(i).npcs.size(), 1, 1300, 408, 54, 9077));
        }
    }
    
    public static void saveData() {
        ArrayList<Money> arrList = new ArrayList<>();
        synchronized(ARRLIST) {
            for (int i = 0; i < LISTWIN.size(); i++) {
                arrList.add(LISTWIN.get(i));
            }
        }
        try {
            MySQL mySQL = MySQL.createData5();
            try {
                mySQL.getConnection().setAutoCommit(false);
                try {
                    mySQL.getConnection().prepareStatement("DELETE FROM `listwin`;").executeUpdate();
                    for (int i = 0; i < arrList.size(); i++) {
                        mySQL.getConnection().prepareStatement("INSERT INTO `listwin`(`playerId`, `name`, `min`, `max`, `win`) VALUES ("+ arrList.get(i).playerId+", \""+ arrList.get(i).name +"\", "+ arrList.get(i).min +" , "+ arrList.get(i).max +", "+ arrList.get(i).win +")").executeUpdate();
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
    
}
