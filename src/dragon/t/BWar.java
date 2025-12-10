package dragon.t;

import dragon.server.mResources;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 
 * @author TGDD
 */
public class BWar {

    public BWar(int bId, String name, int timeDelay, ZoneMap zone) {
        this.timeDelay = timeDelay;
        this.bId = bId;
        this.name = name;
        this.zone = zone;
    }

    public int bId;
    public final ArrayList<Char> ARRPLAYER = new ArrayList<>();
    public final ArrayList<Char> ARRPLAYERLOSS = new ArrayList<>();
    public boolean isWar;
    public int tick;
    public String name;
    public ZoneMap zone;
    public boolean removeAtTheEnd;
    public int timeDelay;

    public static final ArrayList<BWar> ARRBWAR = new ArrayList<>();

    private static final ArrayList<BWar> ARRBWAR2 = new ArrayList<>();

    public static int delay;

    public static void add(BWar b) {
        synchronized (ARRBWAR) {
            ARRBWAR.add(b);
        }
    }

    public static void remove(BWar b) {
        synchronized (ARRBWAR) {
            ARRBWAR.remove(b);
        }
    }

    public static void addBWar(int bId, String name, int timeDelay, ZoneMap zone) {
        BWar b = new BWar(bId, name, timeDelay, zone);
        add(b);
    }

    public static void update() {
        ARRBWAR2.clear();
        synchronized (ARRBWAR) {
            ARRBWAR2.addAll(ARRBWAR);
        }
        for (BWar bWar : ARRBWAR2) {
            // delay
            if (bWar.timeDelay > 0) {
                bWar.timeDelay -= delay;
            } else {
                // war
                if (bWar.isWar) {
                    if (bWar.bId == 1) {
                        if (bWar.ARRPLAYER.get(1).gameTick % 20 == 0 && !bWar.ARRPLAYER.get(1).isMove) {
                            // son tinh chay
                            int xTo = bWar.ARRPLAYER.get(1).cx + Util.gI().nextInt(-150, 150);
                            if (xTo > bWar.ARRPLAYER.get(1).zoneMap.mapTemplate.pxw - 50) {
                                xTo = bWar.ARRPLAYER.get(1).zoneMap.mapTemplate.pxw - 50;
                            }
                            if (xTo < 50) {
                                xTo = 50;
                            }
                            bWar.ARRPLAYER.get(1).setMove(0, xTo, 150, 50, 1, 200);
                        }
                        if (bWar.ARRPLAYER.get(1).gameTick % 150 == 0) {
                            // thuy tinh doi mi nuong
                            bWar.ARRPLAYER.getFirst().addChat(1, mResources.THUY_TINH_CHAT1);
                            // son tinh thach
                            bWar.ARRPLAYER.get(1).addChat(1, mResources.SON_TINH_CHAT1);
                        }
                        if (bWar.ARRPLAYER.get(1).gameTick % 250 == 0) {
                            // thuy tinh goi nuoc
                            bWar.ARRPLAYER.getFirst().addChat(1, mResources.THUY_TINH_CHAT2);
                            // son tinh thach
                            bWar.ARRPLAYER.get(1).addChat(1, mResources.SON_TINH_CHAT2);
                        }
                    }
                    if (bWar.bId == 2) {
                        if (bWar.ARRPLAYER.getFirst().gameTick % 20 == 0 && !bWar.ARRPLAYER.getFirst().isMove
                                && !bWar.ARRPLAYER.getFirst().isChuyenMap && bWar.ARRPLAYER.getFirst().stealCharId == -1) {
                            // di lai
                            int xTo = Util.gI().nextInt(50, bWar.ARRPLAYER.getFirst().zoneMap.mapTemplate.pxw - 50);
                            bWar.ARRPLAYER.getFirst().setMove(0, xTo, 150, 50, 1, 200);
                        }
                        // Chuyen map or khu
                        if (!bWar.ARRPLAYER.getFirst().isStand() && bWar.ARRPLAYER.getFirst().isChuyenMap) {
                            bWar.ARRPLAYER.getFirst().isChuyenMap = false;
                            bWar.ARRPLAYER.getFirst().isSteal = true;
                            kiemtra:
                            {
                                // tim map uu tien dong nguoi
                                int num2 = 0;
                                int max = 500;
                                while (num2++ < max) {
                                    try {
                                        Map map = Map.MAPS_SERVER.get(Util.gI().nextInt(Map.MAPS_SERVER.size()));
                                        if (map == null) {
                                            continue; // phong truong hop map bi xoa tren server
                                        }
                                        if (map.isMapThuong() || map.isMapNappa() || map.isMapCold1()
                                                || map.isMapTL()) {
                                            ZoneMap zone = map.zones.get(Util.gI().nextInt(map.zones.size()));
                                            if (zone.countBossById(138) > 0 || bWar.ARRPLAYER.getFirst().zoneMap == zone) {
                                                continue;
                                            }
                                            if (num2 < max / 1.5) {
                                                Char player = zone.getPLayerNotAI();
                                                if (player != null) {
                                                    bWar.ARRPLAYER.getFirst().zoneMap.exit(bWar.ARRPLAYER.getFirst(), 0);
                                                    zone.join(bWar.ARRPLAYER.getFirst(), 0, player.cx, player.cy);
                                                    break kiemtra;
                                                }
                                            } else {
                                                bWar.ARRPLAYER.getFirst().zoneMap.exit(bWar.ARRPLAYER.getFirst(), 0);
                                                zone.join(bWar.ARRPLAYER.getFirst(), 0, 120, 150);
                                                break kiemtra;
                                            }
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace(); // Câu lệnh in này để tránh lỗi vô hạn vòng lặp
                                    }
                                }
                            }
                        }
                    }
                    //Goku va cadic
                    if (bWar.bId == 1) {
                        if (bWar.ARRPLAYER.get(1).gameTick % 20 == 0 &&
                                !bWar.ARRPLAYER.get(1).isMove) {
                            // son tinh chay
                            int xTo = bWar.ARRPLAYER.get(1).cx + Util.gI().nextInt(-150, 150);
                            if (xTo > bWar.ARRPLAYER.get(1).zoneMap.mapTemplate.pxw - 50) {
                                xTo = bWar.ARRPLAYER.get(1).zoneMap.mapTemplate.pxw - 50;
                            }
                            if (xTo < 50) {
                                xTo = 50;
                            }
                            bWar.ARRPLAYER.get(1).setMove(0, xTo, 150, 50, 1, 200);
                        }
                    }
                }
                if (!bWar.isWar) {
                    // clear
                    if (!bWar.ARRPLAYER.isEmpty()) {
                        for (int j = 0; j < bWar.ARRPLAYER.size(); j++) {
                            bWar.ARRPLAYER.get(j).timeClear = 0;
                        }
                        bWar.ARRPLAYER.clear();
                    }
                    // clear or continue
                    if (bWar.removeAtTheEnd) {
                        remove(bWar);
                    } else {
                        // son tinh thuy tinh
                        if (bWar.bId == 1) {

                            int[] arrMap = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
                                    19, 20, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 42, 43, 44};
                            // thuy tinh, son tinh
                            kiemtra:
                            {
                                // Tim map and khu
                                int num2 = 0;
                                while (num2++ < 50) {
                                    try {
                                        Map map = Map.getMapServer(arrMap[Util.gI().nextInt(arrMap.length)]);
                                        // Map map = Map.getMapServer(0);
                                        // xuat hien uu tien cac khu truoc
                                        assert map != null;
                                        ZoneMap zone = map.zones
                                                .get(Util.gI().nextInt(Util.gI().nextInt(Util.gI().nextInt(20))));
                                        if (zone.countBossById(136) > 0) {
                                            continue;
                                        }
                                        // thuy tinh
                                        bWar.ARRPLAYER.add(Player.addBoss(136, 0, -1, -1, true,
                                                Util.gI().nextInt(50, zone.mapTemplate.pxw - 50), 150, zone, -1, -1));
                                        bWar.ARRPLAYER.getFirst().bWar = bWar;
                                        bWar.ARRPLAYER.getFirst().changeFlag(1);
                                        // son tinh
                                        bWar.ARRPLAYER.add(Player.addBoss(137, 0, -1, -1, true,
                                                Util.gI().nextInt(50, zone.mapTemplate.pxw - 50), 150, zone, -1, -1));
                                        bWar.ARRPLAYER.get(1).bWar = bWar;
                                        bWar.ARRPLAYER.get(1).changeFlag(2);
                                        bWar.isWar = true;
                                        break kiemtra;
                                    } catch (Exception e) {
                                    }
                                }
                                bWar.removeAtTheEnd = true;
                            }
                        }
                        // an trom
                        if (bWar.bId == 2) {
                            kiemtra:
                            {
                                // Tim map and khu
                                int num2 = 0;
                                while (num2++ < 50) {
                                    try {
                                        Map map = Map.MAPS_SERVER.get(Util.gI().nextInt(Map.MAPS_SERVER.size()));
                                        if (map == null) {
                                            continue; // phong truong hop map bi xoa tren server
                                        }
                                        if (map.isMapThuong() || map.isMapNappa() || map.isMapCold1() || map.isMapTL()) {
                                            ZoneMap zone = map.zones.get(Util.gI().nextInt(map.zones.size()));
                                            if (zone.countBossById(138) > 0) {
                                                continue;
                                            }
                                            // an trom
                                            bWar.ARRPLAYER.add(Player.addBoss(138, 5, -1, -1, false,
                                                    Util.gI().nextInt(50, zone.mapTemplate.pxw - 50), 150, null, -1,
                                                    -1));
                                            bWar.ARRPLAYER.getFirst().cName = bWar.name;
                                            bWar.ARRPLAYER.getFirst().bWar = bWar;
                                            bWar.isWar = true;
                                            zone.join(bWar.ARRPLAYER.getFirst(), 0, -1, -1);
                                            break kiemtra;
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                bWar.removeAtTheEnd = true;
                            }
                        }
                        // Goku ca dic
                        if (bWar.bId == 3) {
                            kiemtra:
                            {
                                if (bWar.tick == 0) {
                                    // Cadic
                                    bWar.ARRPLAYER
                                            .add(Player.addBoss(85, 0, -1, -1, true, 480, 336, bWar.zone, -1, -1));
                                    bWar.ARRPLAYER.getFirst().bWar = bWar;
                                    bWar.ARRPLAYER.getFirst().timeClear = 60000;
                                    bWar.ARRPLAYER.getFirst().changeFlag(Objects.requireNonNull(Flag.get(520)).id);
                                    // Goku
                                    bWar.ARRPLAYER
                                            .add(Player.addBoss(84, 0, -1, -1, true, 490, 336, bWar.zone, -1, -1));
                                    bWar.ARRPLAYER.get(1).bWar = bWar;
                                    bWar.ARRPLAYER.get(1).timeClear = 60000;
                                    bWar.ARRPLAYER.get(1).changeFlag(Objects.requireNonNull(Flag.get(519)).id);
                                    bWar.isWar = true;
                                    bWar.tick++;
                                } else {
                                    Player boss = Player.addBoss(81, 0, -1, -1, true, 290, 336, bWar.zone, 5000, -1);
                                    boss.isArgue = true;
                                    boss.setLive(60);
                                    bWar.removeAtTheEnd = true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
