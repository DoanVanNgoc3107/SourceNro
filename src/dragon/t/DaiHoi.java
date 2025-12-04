package dragon.t;

import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class DaiHoi {
    
    public static class Fighter {
        public int playerId;
        public int nTurn;
        
        public Fighter(int playerId) {
            this.playerId = playerId;
        }
        
    }
    
    public static class War {
        
        public int playerId1 = -1;
        public int playerId2 = -1;
        
    }
    
    public static boolean isWar;
    public static int type;
    public static String name;
    public static long minPower;
    public static long maxPower;
    public static long minTN;
    public static long maxTN;
    private static final ArrayList<Fighter> FIGHTERS = new ArrayList<>();
    public static boolean isRegister;
    public static int priceNgoc;
    public static int priceVang;
    public static long timeRegister;
    public static int timeFight;
    public static int delay;
    public static int nTurn;
    public static int timePush;
    public static int tick;
    public static boolean isPush;
    public static final ArrayList<String> LISTWIN = new ArrayList<>();
    
    public static void createPrize(int type) {
        DaiHoi.type = type;
        //nhi dong
        if (type == 1) {
            DaiHoi.name = mResources.PRIZE_NHI_DONG;
            DaiHoi.priceNgoc = 50;
            DaiHoi.priceVang = 0;
            DaiHoi.minPower = 0;
            DaiHoi.maxPower = 1500000;
            DaiHoi.minTN = 0;
            DaiHoi.maxTN = 1500000;
        }
        //sieu cap 1
        if (type == 2) {
            DaiHoi.name = mResources.PRIZE_SIEU_CAP1;
            DaiHoi.priceNgoc = 100;
            DaiHoi.priceVang = 0;
            DaiHoi.minPower = 1500000;
            DaiHoi.maxPower = 15000000;
            DaiHoi.minTN = 1500000;
            DaiHoi.maxTN = 15000000;
        }
        //sieu cap 2
        if (type == 3) {
            DaiHoi.name = mResources.PRIZE_SIEU_CAP2;
            DaiHoi.priceNgoc = 200;
            DaiHoi.priceVang = 0;
            DaiHoi.minPower = 1500000;
            DaiHoi.maxPower = 150000000;
            DaiHoi.minTN = 1500000;
            DaiHoi.maxTN = 150000000;
        }
        //sieu cap 3
        if (type == 4) {
            DaiHoi.name = mResources.PRIZE_SIEU_CAP3;
            DaiHoi.priceNgoc = 300;
            DaiHoi.priceVang = 0;
            DaiHoi.minPower = 1500000;
            DaiHoi.maxPower = 1500000000;
            DaiHoi.minTN = 1500000;
            DaiHoi.maxTN = 1500000000;
        }
        //ngoai hang
        if (type == 5) {
            DaiHoi.name = mResources.PRIZE_NGOAI_HANG;
            DaiHoi.priceNgoc = 0;
            DaiHoi.priceVang = 10000;
            DaiHoi.minPower = -1;
            DaiHoi.maxPower = -1;
            DaiHoi.minTN = -1;
            DaiHoi.maxTN = -1;
        }
        synchronized(DaiHoi.FIGHTERS) {
            DaiHoi.FIGHTERS.clear();
        }
        DaiHoi.isRegister = true;
        DaiHoi.timeRegister = System.currentTimeMillis() + 1800000L;
        DaiHoi.timeFight = 1800000;
//        DaiHoi.timeRegister = System.currentTimeMillis() + 30000L;
//        DaiHoi.timeFight = 30000;
        DaiHoi.nTurn = 1;
        DaiHoi.isWar = true;
    }
    
    public static void addFighter(int playerId) {
        synchronized(DaiHoi.FIGHTERS) {
            DaiHoi.FIGHTERS.add(new Fighter(playerId));
        }
    }
    
    public static boolean isHaveFighter(int playerId) {
        synchronized(DaiHoi.FIGHTERS) {
            for (int i = 0; i < DaiHoi.FIGHTERS.size(); i++) {
                if (DaiHoi.FIGHTERS.get(i).playerId == playerId) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public static void removeFighter(int playerId) {
        synchronized(DaiHoi.FIGHTERS) {
            for (int i = 0; i < DaiHoi.FIGHTERS.size(); i++) {
                if (DaiHoi.FIGHTERS.get(i).playerId == playerId) {
                    DaiHoi.FIGHTERS.remove(i);
                    return;
                }
            }
        }
    }
    
    public static int sizeFighter() {
        synchronized(DaiHoi.FIGHTERS) {
            return DaiHoi.FIGHTERS.size();
        }
    }
    
    public static void createFight() {
        ArrayList<Fighter> arraylist = new ArrayList<>();
        synchronized(DaiHoi.FIGHTERS) {
            for (int i = 0; i < DaiHoi.FIGHTERS.size(); i++) {
                arraylist.add(DaiHoi.FIGHTERS.get(i));
            }
        }
        ArrayList<War> arraylist2 = new ArrayList<>();
        while(!arraylist.isEmpty()) {
            War w = new War();
            w.playerId1 = arraylist.remove(Util.gI().nextInt(arraylist.size())).playerId;
            if (!arraylist.isEmpty()) {
                w.playerId2 = arraylist.remove(Util.gI().nextInt(arraylist.size())).playerId;
            }
            arraylist2.add(w);
        }
        for (int i = 0; i < arraylist2.size(); i++) {
            Char player1 = DaiHoi.findPlayerByPId(arraylist2.get(i).playerId1);
            Char player2 = DaiHoi.findPlayerByPId(arraylist2.get(i).playerId2);
            if (arraylist2.get(i).playerId2 == -1) {
                if (player1 != null) {
                    player1.myCharz().addInfo1(mResources.NEXT_TURN1);
                    player1.myCharz().isWaitWar = true;
                    player1.myCharz().addQuaGiaiDau();
                } else {
                    DaiHoi.removeFighter(arraylist2.get(i).playerId1);
                }
            } else if (player1 == null && player2 == null) {
                DaiHoi.removeFighter(arraylist2.get(i).playerId1);
                DaiHoi.removeFighter(arraylist2.get(i).playerId2);
            } else if (player1 == null) {
                DaiHoi.removeFighter(arraylist2.get(i).playerId1);
                player2.myCharz().addInfo1(mResources.NEXT_TURN2);
                player2.myCharz().isWaitWar = true;
                player2.myCharz().addQuaGiaiDau();
            } else if (player2 == null) {
                DaiHoi.removeFighter(arraylist2.get(i).playerId2);
                player1.myCharz().addInfo1(mResources.NEXT_TURN2);
                player1.myCharz().isWaitWar = true;
                player1.myCharz().addQuaGiaiDau();
            } else {
                Map map = Map.getMapServer(51);
                if (map != null) {
                    for (int j = 0; j < map.zones.size(); j++) {
                        if (!map.zones.get(j).isRace) {
                            map.zones.get(j).isRace = true;
                            //player 1
                            player1.zoneMap.exit(player1, 0);
                            map.zones.get(j).join(player1, 0, 300, 312);
                            //player 2
                            player2.zoneMap.exit(player2, 0);
                            map.zones.get(j).join(player2, 0, 480, 312);
                            map.zones.get(j).findBossInMapById(134).arb2(player1, player2, 0);
                            break;
                        }
                    }
                }
            }
        }
        if (DaiHoi.sizeFighter() == 1) {
            DaiHoi.win();
        }
    }
    
    public static void update() {
        DaiHoi.tick++;
        if (DaiHoi.isRegister && (DaiHoi.timeRegister - System.currentTimeMillis()) / 1000L < 0) {
            DaiHoi.isRegister = false;
        } else if (DaiHoi.isRegister && DaiHoi.tick % 100 == 0) {
            DaiHoi.addInfo1(String.format(mResources.TRAN_DAU_DIEN_RA, (DaiHoi.timeRegister - System.currentTimeMillis()) / 60000L));
        }
        if (DaiHoi.timeFight > 0) {
            DaiHoi.timeFight -= DaiHoi.delay;
            if (DaiHoi.timeFight <= 0) {
                DaiHoi.timeFight = 0;
                if (DaiHoi.isWar) {
                    DaiHoi.isPush = false;
                    DaiHoi.createFight();
                }
            }
        }
        if (!DaiHoi.isPush && DaiHoi.isPush()) {
            DaiHoi.isPush = true;
            DaiHoi.timeFight = 10000;
            if (DaiHoi.sizeFighter() != 1) {
                DaiHoi.timePush = 5000;
            }
        }
        if (DaiHoi.timePush > 0) {
            DaiHoi.timePush -= DaiHoi.delay;
            if (DaiHoi.timePush <= 0) {
                DaiHoi.timePush = 0;
                DaiHoi.pushToDaiHoi();
            }
        }
    }
    
    public static Char findPlayerByPId(int playerId) {
        Map map = Map.getMapServer(52);
        for (int i = 0; i < map.zones.size(); i++) {
            synchronized(map.zones.get(i).players) {
                for (int j = 0; j < map.zones.get(i).players.size(); j++) {
                    if (map.zones.get(i).players.get(j).playerId == playerId) {
                        return map.zones.get(i).players.get(j);
                    }
                }
            }
        }
        return null;
    }
    
    public static void pushToDaiHoi() {
        DaiHoi.nTurn++;
        ArrayList<Char> arrayList = new ArrayList<>();
        Map map = Map.getMapServer(51);
        for (int i = 0; i < map.zones.size(); i++) {
            synchronized(map.zones.get(i).players) {
                for (int j = 0; j < map.zones.get(i).players.size(); j++) {
                    if (!map.zones.get(i).players.get(j).isTemplate || map.zones.get(i).players.get(j).cTemplateType == 8) {
                        arrayList.add(map.zones.get(i).players.get(j));
                    }
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isDie) {
                arrayList.get(i).liveFromDead(2);
            }
            arrayList.get(i).goDaiHoi();
            if (DaiHoi.isHaveFighter(arrayList.get(i).playerId) && DaiHoi.sizeFighter() > 1) {
                arrayList.get(i).addInfo1(String.format(mResources.NEXT_TURN8, DaiHoi.nTurn));
            }
        }
    }
    
    public static boolean isPush() {
        Map map = Map.getMapServer(51);
        int n = 0;
        for (int i = 0; i < map.zones.size(); i++) {
            if (!map.zones.get(i).isRace) {
                n++;
            }
        }
        return n == map.zones.size();
    }
    
    public static void win() {
        DaiHoi.isWar = false;
        Session_ME player = Server.gI().getByPId(DaiHoi.FIGHTERS.get(0).playerId);
        player.myCharz().addInfo1(1000, String.format(mResources.NEXT_TURN9, player.myCharz().cName, DaiHoi.name));
        DaiHoi.LISTWIN.add(player.myCharz().cName);
    }
    
    public static int getNextHour() {
        int hNow = Server.gI().hours;
        switch(hNow) {
            case 0:
                return 8;
            case 1:
                return 8;
            case 2:
                return 8;
            case 3:
                return 8;
            case 4:
                return 8;
            case 5:
                return 8;
            case 6:
                return 8;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 15;
            case 15:
                return 16;
            case 16:
                return 17;
            case 17:
                return 18;
            case 18:
                return 19;
            case 19:
                return 20;
            case 20:
                return 21;
            case 21:
                return 22;
            case 22:
                return 23;
            case 23:
                return 8;
        }
        return 0;
    }
    
    public static void addInfo1(String text) {
        ArrayList<Integer> list = new ArrayList<>();
        synchronized(DaiHoi.FIGHTERS) {
            for (int i = 0; i < DaiHoi.FIGHTERS.size(); i++) {
                list.add(DaiHoi.FIGHTERS.get(i).playerId);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Session_ME player = Server.gI().getByPId(list.get(i));
            if (player != null) {
                player.myCharz().addInfo1(text);
            }
        }
    }
    
}
