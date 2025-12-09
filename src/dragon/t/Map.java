package dragon.t;

import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Map {
    
    public ArrayList<ZoneMap> zones;
    public int templateId;
    public int mapId;
    public int delays = 0;
    public boolean isOpen;
    public KhiHuyDiet destronGas;
    public DoanhTrai doanhTrai;
    public KhoBau khobau;
    public Instancing phoban;
    public Char owner;
    public MapTemplate template;
    
    private final ArrayList<Mob> mobs = new ArrayList<>();
    private final ArrayList<Npc> npcs = new ArrayList<>();
    public ArrayList<ItemMap> itemMaps = new ArrayList<>();
    public ArrayList<dragon.t.PhaoHoa> phaohoas = new ArrayList<>();
    
    public boolean isClear = false;
    
    public Map(int mapTemplateId, int zoneCount, int maxPlayer, int status) {
        this.template = MapTemplate.arrMapTemplate[this.mapId = this.templateId = mapTemplateId];
        this.zones = new ArrayList<>();
        int i;
        int j;
        for (i = 0; i < zoneCount; i++) {
            ZoneMap zone = new ZoneMap(MapTemplate.arrMapTemplate[mapTemplateId], this, i);
            zone.maxPlayer = maxPlayer;
            if (status == 0) {
                //Init Waypoint
                for (int i4 = 0; i4 < MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_name.length; i4++) {
                    Waypoint waypoint = new Waypoint(i4,
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_name[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_minX[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_minY[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_maxX[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_maxY[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_isEnter[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_isOffline[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_goMapID[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_goX[i4],
                            MapTemplate.arrMapTemplate[mapTemplateId].arrWaypoint_goY[i4]);
                    zone.waypoints.add(waypoint);
                    //SET
                }
                //Init Mob
                for (int i3 = 0; i3 < MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId.length; i3++) {
                    if (MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId[i3] == 70) {
                        BigBoss mob2 = new BigBoss(i3, MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_level[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointx[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointy[i3]);
                        mob2.zone = zone;
                        zone.mobs.add(mob2);
                    } else if (MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId[i3] == 71) {
                        BachTuoc mob3 = new BachTuoc(i3, MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_level[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointx[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointy[i3]);
                        mob3.zone = zone;
                        zone.mobs.add(mob3);
                    } else if (MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId[i3] == 72) {
                        BigBoss2 mob4 = new BigBoss2(i3, MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_level[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointx[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointy[i3]);
                        mob4.zone = zone;
                        zone.mobs.add(mob4);
                    } else if (1 == 1) {
                        Mob mob = new Mob(i3, MapTemplate.arrMapTemplate[mapTemplateId].arrMob_templateId[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_level[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointx[i3], MapTemplate.arrMapTemplate[mapTemplateId].arrMob_pointy[i3]);
                        mob.zone = zone;
                        zone.mobs.add(mob);
                    }
                }
                //Init NPC
                for (int i2 = 0; i2 < MapTemplate.arrMapTemplate[mapTemplateId].arrNPC_templateId.length; i2++) {
                    Npc npc = new Npc(i2, MapTemplate.arrMapTemplate[mapTemplateId].arrNPC_status[i2], MapTemplate.arrMapTemplate[mapTemplateId].arrNPC_cx[i2], MapTemplate.arrMapTemplate[mapTemplateId].arrNPC_cy[i2],  MapTemplate.arrMapTemplate[mapTemplateId].arrNPC_templateId[i2], MapTemplate.arrMapTemplate[mapTemplateId].arrNPC_avatar[i2]);
                    zone.npcs.add(npc);
                }
                //Init ItemMap
                Item it = null;
                if (mapTemplateId == 85) {
                    it = new Item(372, false, 1, ItemOption.getOption(372, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (mapTemplateId == 86) {
                    it = new Item(373, false, 1, ItemOption.getOption(373, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (mapTemplateId == 87) {
                    it = new Item(374, false, 1, ItemOption.getOption(374, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (mapTemplateId == 88) {
                    it = new Item(375, false, 1, ItemOption.getOption(375, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (mapTemplateId == 89) {
                    it = new Item(376, false, 1, ItemOption.getOption(376, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (mapTemplateId == 90) {
                    it = new Item(377, false, 1, ItemOption.getOption(377, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (mapTemplateId == 91) {
                    it = new Item(378, false, 1, ItemOption.getOption(378, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (it != null) {
                    ItemMap itm = zone.addItemMap(-1, it, 100, zone.mapTemplate.touchY(100, 100), -1, -1);
                    itm.milisecondRemove = System.currentTimeMillis() + 10000;
                }

                //Yardart
                if (mapTemplateId == 131) {
                    for (j = 0; j < yardartBoss[0].length; j++) {
                        Player boss1 = Player.addBoss(yardartBoss[0][j][0], 5, -1, -1, true, yardartBoss[0][j][1], yardartBoss[0][j][2], null, -1, -1);
                        boss1.cName = String.format(mResources.ADD_NUMBER, boss1.cName, j);
                        zone.join(boss1, 0, -1, -1);
                    }
                }
                if (mapTemplateId == 132) {
                    for (j = 0; j < yardartBoss[1].length; j++) {
                        Player boss1 = Player.addBoss(yardartBoss[1][j][0], 5, -1, -1, true, yardartBoss[1][j][1], yardartBoss[1][j][2], null, -1, -1);
                        boss1.cName = String.format(mResources.ADD_NUMBER, boss1.cName, j);
                        zone.join(boss1, 0, -1, -1);
                    }
                }
                if (mapTemplateId == 133) {
                    for (j = 0; j < yardartBoss[2].length; j++) {
                        Player boss1 = Player.addBoss(yardartBoss[2][j][0], 5, -1, -1, true, yardartBoss[2][j][1], yardartBoss[2][j][2], null, -1, -1);
                        boss1.cName = String.format(mResources.ADD_NUMBER, boss1.cName, j);
                        zone.join(boss1, 0, -1, -1);
                    }
                }
            }
            this.zones.add(zone);
        }
    }
    
    public ZoneMap getZone(Char charz) {
        if (this.isMapTraiDat() && charz.cgender != 0) {
            
        } else if (this.isMapNamek() && charz.cgender != 1) {
            
        } else if (this.isMapXayda() && charz.cgender != 2) {
            
        } else {
            int i;
            int count = this.zones.size();
            for (i = 0; i < count; ++i) {
                ZoneMap zone = this.zones.get(i);
                if (zone != null && zone.getCountPLayerNotAI() < zone.maxPlayer && (!this.isMapButcher() || (this.isMapButcher() && zone.getCountPLayerNotAI() < 7))) {
                    return zone;
                }
            }
        }
        return null;
    }
    
    public void requestChangeZone(Char charz, int zoneId) {
        for (int i = this.zones.size() - 1; i >= 0; --i) {
            if (this.zones.get(i).zoneID == zoneId) {
                if (charz.mapTemplateId == 113 || charz.mapTemplateId == 114) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_CHNAGEMAP, null, 0);
                } else if (charz.mapTemplateId == 51) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_CHNAGEMAP, null, 0);
                } else if (charz.blindEff) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_CHNAGEMAP, null, 0);
                } else if (charz.zoneMap == this.zones.get(i)) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_JOIN_ZONE, null, 0);
                } else if (this.isMapButcher()) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_CHANGE_ZONE, null, 0);
                } else if (this.isMapBigBoss()) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_CHANGE_ZONE, null, 0);
                } else if (this.isMapMabu()) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_CHANGE_ZONE, null, 0);
                } else if (charz.timeChangeZone > 0) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.DELAY_DOI_KHU, Util.gI().getStrTime(charz.timeChangeZone)), null, 0);
                } else if (!this.zones.get(i).isHelp(charz)) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TASK_HOUR, null, 0);
                } else if (charz.itemNamekBall != null && charz.timeNextMapNamek > System.currentTimeMillis()) {
                    charz.addInfo1(mResources.DELAY_NEXT_MAP_NAMEK);
                } else if (this.zones.get(i).getCountPLayerNotAI() >= this.zones.get(i).maxPlayer) {
                    charz.session.service.startOKDlg(mResources.ZONE_FULL_PLAYER);
                } else {
                    charz.timeChangeZone = 10000;
                    charz.zoneMap.exit(charz, 0);
                    this.zones.get(i).join(charz, 0, -1, -1);
                }
                break;
            }
        }
    }
    
    public static boolean isMapOffline(int mapId) {
        return mapId == 21 || mapId == 22 || mapId == 23 || mapId == 39|| mapId == 40 || mapId == 41 || mapId == 45 || mapId == 46 || mapId == 47 || mapId == 48 || mapId == 50 || mapId == 101 || mapId == 111 || mapId == 154;
    }
    
    public boolean isMapTraiDat() {
        return this.mapId == 21;
    }
    
    public boolean isMapNamek() {
        return this.mapId == 22;
    }
    
    public boolean isMapXayda() {
        return this.mapId == 23;
    }
    
    public boolean isNotChangeZone() {
        return this.mapId == 21 || this.mapId == 22 || this.mapId == 23 || this.mapId == 51 || this.isMapDestronGas() || this.isMapDoanhTrai() || Map.isMapOffline(this.mapId) || this.isMapKhoBau() || this.mapId == 128 || this.isMapManorClan() || this.mapId == 165;
    }
    
    public boolean isMapHome() {
        return this.mapId == 21 || this.mapId == 22 || this.mapId == 23;
    }
    
    public void close() {
        Map.remove(this);
    }
    
    public static int[] mapId_server = new int[]{
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10,
        11,
        12,
        13,
        14,
        15,
        16,
        17,
        18,
        19,
        20,
        24,
        25,
        26,
        27,
        28,
        29,
        30,
        31,
        32,
        33,
        34,
        35,
        36,
        37,
        38,
        39,
        40,
        41,
        42,
        43,
        44,
        49,
        51,
        52,
        63,
        64,
        65,
        66,
        67,
        68,
        69,
        70,
        71,
        72,
        73,
        74,
        75,
        76,
        77,
        79,
        80,
        81,
        82,
        83,
        84,
        85,
        86,
        87,
        88,
        89,
        90,
        91,
        92,
        93,
        94,
        95,
        96,
        97,
        98,
        99,
        100,
        102,
        103,
        104,
        105,
        106,
        107,
        108,
        109,
        110,
        113,
        114,
        115,
        117,
        118,
        119,
        120,
        122,
        123,
        124,
        126,
        127,
        129,
        131,
        132,
        133,
        139,
        140,
        155,
        156,
        157,
        158,
        159,
        160,
        161,
        162,
        163,
        166,
        167,
        168
    };
    
    public static int[][][] yardartBoss = new int[][][] {
        {
            {27, 144, 456},
            {27, 360, 456},
            {27, 805, 456},
            {27, 1000, 456},
            {28, 1250, 456}
        },
        {
            {28, 144, 456},
            {28, 360, 456},
            {28, 641, 456},
            {28, 800, 456},
            {28, 1000, 456},
            {29, 1220, 456}
        },
        {
            {29, 300, 456},
            {29, 400, 456},
            {29, 600, 456},
            {29, 805, 456},
            {29, 1000, 456},
            {30, 1250, 456}
        }
    };
    
    public static short[][] pointDuaBe = new short[][] {
        {
            155,
            288
        },
        {
            136,
            264
        },
        {
            155,
            288
        }
    };
    
    public static final ArrayList<Map> MAPS = new ArrayList<>();
    public static final ArrayList<Map> MAPS_SERVER = new ArrayList<>();
    public static int maxPlayerInZone = 15;
    
    public static void add(Map map) {
        synchronized (MAPS) {
            MAPS.add(map);
        }
    }
    
    public static void remove(Map map) {
        synchronized (MAPS) {
            MAPS.remove(map);
        }
    }
    
    public static int size() {
        synchronized (MAPS) {
            return MAPS.size();
        }
    }
    
    public static void addServer(Map map) {
        synchronized (MAPS_SERVER) {
            MAPS_SERVER.add(map);
        }
    }
    
    public static void removeServer(Map map) {
        synchronized (MAPS_SERVER) {
            MAPS_SERVER.remove(map);
        }
    }
    
    public static int sizeServer() {
        synchronized (MAPS_SERVER) {
            return MAPS_SERVER.size();
        }
    }
    
    public static boolean contains(Map map) {
        synchronized (MAPS) {
            return MAPS.contains(map);
        }
    }
    
    public static boolean containsServer(Map map) {
        synchronized (MAPS_SERVER) {
            return MAPS_SERVER.contains(map);
        }
    }
    
    public static void initMapServer() {
        System.out.println("Load Map Server");
        int i;
        int j;
        for (i = 0; i < mapId_server.length; ++i) {
            int countZone = 50;
            //Ball black
            if (mapId_server[i] >= 85 && mapId_server[i] <= 91) {
                countZone = 10;
            }
            //BigBoss
            if (mapId_server[i] == 126) {
                countZone = 10;
            }
            //Butcher
            if (mapId_server[i] == 114 || mapId_server[i] == 115 || mapId_server[i] == 117 || mapId_server[i] == 118 || mapId_server[i] == 119 || mapId_server[i] == 120) {
                countZone = 25;
            }
            //Mabu
            if (mapId_server[i] == 127) {
                countZone = 20;
            }
            //tuong lai
            if (mapId_server[i] == 92 || mapId_server[i] == 93 || mapId_server[i] == 94 ||mapId_server[i] == 96 || mapId_server[i] == 97 || mapId_server[i] == 98 || mapId_server[i] == 99 || mapId_server[i] == 100 || mapId_server[i] == 102) {
                countZone = 25;
            }
            //Thuc vat
            if (mapId_server[i] == 160 || mapId_server[i] == 161 || mapId_server[i] == 162 || mapId_server[i] == 163) {
                countZone = 25;
            }
            //Map moi
            if (mapId_server[i] == 156 || mapId_server[i] == 157 || mapId_server[i] == 158 || mapId_server[i] == 159) {
                countZone = 25;
            }
            //Cold
            if ((mapId_server[i] >= 105 && mapId_server[i] <= 110)) {
                countZone = 50;
            }
            //Yardart
            if ((mapId_server[i] >= 131 && mapId_server[i] <= 133)) {
                countZone = 11;
            }
            //Thanh dia
            if ((mapId_server[i] >= 156 && mapId_server[i] <= 159)) {
                countZone = 10;
            }
            
            //Nappa
            if (mapId_server[i] == 63 || mapId_server[i] == 64 || mapId_server[i] == 65 || mapId_server[i] == 66 || mapId_server[i] == 67 || mapId_server[i] == 68 || mapId_server[i] == 69 || mapId_server[i] == 70 || mapId_server[i] == 71 || mapId_server[i] == 72 || mapId_server[i] == 73 || mapId_server[i] == 74 || mapId_server[i] == 75 || mapId_server[i] == 76 || mapId_server[i] == 77 || mapId_server[i] == 79 || mapId_server[i] == 80 || mapId_server[i] == 81 || mapId_server[i] == 82 || mapId_server[i] == 83) {
                countZone = 50;
            }
            //DHVT 23
            if (mapId_server[i] == 129) {
                countZone = 127;
            }
            //Hanh tinh nguc tu
            if (mapId_server[i] == 155 || mapId_server[i] == 166) {
                countZone = 20;
            }
            Map map = new Map(mapId_server[i], countZone, maxPlayerInZone, 0);
            for (j = 0; j < map.zones.size(); j++) {
                map.zones.get(j).initMob();
            }
            map.isOpen = true;
            add(map);
            addServer(map);
        }
    }
    
    public Map getMapKhoBau(int mapTemplateId) {
        int i;
        for (i = this.khobau.maps.size() - 1; i >= 0; --i) {
            if (this.khobau.maps.get(i).templateId == mapTemplateId) {
                return this.khobau.maps.get(i);
            }
        }
        return null;
    }
    
    public Map getMapDestronGas(int mapTemplateId) {
        int i;
        for (i = this.destronGas.maps.size() - 1; i >= 0; --i) {
            if (this.destronGas.maps.get(i).templateId == mapTemplateId) {
                return this.destronGas.maps.get(i);
            }
        }
        return null;
    }
    
    public Map getMapDoanhTrai(int mapTemplateId) {
        int i;
        for (i = this.doanhTrai.maps.size() - 1; i >= 0; --i) {
            if (this.doanhTrai.maps.get(i).templateId == mapTemplateId) {
                return this.doanhTrai.maps.get(i);
            }
        }
        return null;
    }
    
    public static Map getMapServer(int mapTemplateId) {
        synchronized (MAPS_SERVER) {
            for (int i = 0; i < MAPS_SERVER.size(); i++) {
                if (MAPS_SERVER.get(i).templateId == mapTemplateId) {
                    return MAPS_SERVER.get(i);
                }
            }
        }
        return null;
    }
    
    public boolean isMapTL() {
        return this.templateId == 92 || this.templateId == 93 || this.templateId == 94 || this.templateId == 96 || this.templateId == 97 || this.templateId == 98 || this.templateId == 99 || this.templateId == 100 || this.templateId == 102 || this.templateId == 103;
    }
    
    public boolean isMapBlackBall() {
        return this.templateId >= 85 && this.templateId <= 91;
    }
    
    public boolean isMapCold1() {
        return (this.templateId >= 105 && this.templateId <= 110);
    }
    
    public boolean isMapCold2() {
        return (this.templateId >= 105 && this.templateId <= 110) || this.templateId == 152 || this.templateId == 158 || this.templateId == 159;
    }
    
    public boolean isMapDestronGas() {
        return this.templateId == 149 || this.templateId == 147 || this.templateId == 152 || this.templateId == 151 || this.templateId == 148;
    }
    
    public boolean isMapDoanhTrai() {
        return this.templateId >= 53 && this.templateId <= 62;
    }
    
    public boolean isMapBien() {
        return this.templateId == 5 || this.templateId == 29 || this.templateId == 30 || this.templateId == 13 || this.templateId == 34 || this.templateId == 33;
    }
    
    public boolean isMapBigBoss() {
        return this.templateId == 126;
    }
    
    public boolean isMapNguHanhSon() {
        return this.templateId == 122 || this.templateId == 123 || this.templateId == 124;
    }
    
    public boolean isMapButcher() {
        return this.templateId == 114 || this.templateId == 115 || this.templateId == 117 || this.templateId == 118 || this.templateId == 119 || this.templateId == 120;
    }
    
    public boolean isMapThuong() {
        return this.mapId == 0 || this.mapId == 1 || this.mapId == 2 || this.mapId == 3 || this.mapId == 4 || this.mapId == 5 || this.mapId == 6 || this.mapId == 7 || this.mapId == 8 || this.mapId == 9 || this.mapId == 10 || this.mapId == 11 || this.mapId == 12 || this.mapId == 13 || this.mapId == 14 || this.mapId == 15 || this.mapId == 16 || this.mapId == 17 || this.mapId == 18 || this.mapId == 19 || this.mapId == 20 || this.mapId == 24 || this.mapId == 25 || this.mapId == 26 || this.mapId == 27 || this.mapId == 28 || this.mapId == 29 || this.mapId == 30 || this.mapId == 31 || this.mapId == 32 || this.mapId == 33 || this.mapId == 34 || this.mapId == 35 || this.mapId == 36 || this.mapId == 37 || this.mapId == 38 || this.mapId == 39 || this.mapId == 40 || this.mapId == 41 || this.mapId == 42 || this.mapId == 43 || this.mapId == 44;
    }
    
    public boolean isMapNappa() {
        return this.mapId == 63 || this.mapId == 64 || this.mapId == 65 || this.mapId == 66 || this.mapId == 67 || this.mapId == 68 || this.mapId == 69 || this.mapId == 70 || this.mapId == 71 || this.mapId == 72 || this.mapId == 73 || this.mapId == 74 || this.mapId == 75 || this.mapId == 76 || this.mapId == 77 || this.mapId == 79 || this.mapId == 80 || this.mapId == 81 || this.mapId == 82 || this.mapId == 83;
    }
    
    public boolean isMapThucVat() {
        return this.mapId == 160 || this.mapId == 161 || this.mapId == 162 || this.mapId == 163;
    }
    
    public boolean isMapMabu() {
        return this.templateId == 127;
    }
    
    public boolean isMapKhoBau() {
        return this.templateId == 135 || this.templateId == 136 || this.templateId == 137 || this.templateId == 138;
    }
    
    public boolean isMapManorClan() {
        return this.templateId == 153;
    }
    
    public boolean isMapYardart() {
        return this.templateId == 131 || this.templateId == 132 || this.templateId == 133;
    }
    
    public boolean isMapManor() {
        return this.templateId == 156 || this.templateId == 157 || this.templateId == 158 || this.templateId == 159;
    }
    
    public boolean isMapHell() {
        return this.templateId == 155 ||this.templateId == 166;
    }
    
    public boolean isMapCace23() {
        return this.templateId == 129;
    }
    
    public boolean isMapCace23_2() {
        return this.templateId == 52 || this.templateId == 129;
    }
    
    public boolean isMapNamekBall() {
        return this.templateId == 7 || this.templateId == 8 || this.templateId == 9 || this.templateId == 10 || this.templateId == 11 || this.templateId == 12 || this.templateId == 13 || this.templateId == 31 || this.templateId == 32 || this.templateId == 33 || this.templateId == 34 || this.templateId == 43;
    }
    
    public void update() {
        //Var
        int i;
        int j;
        Mob mob;
        ZoneMap zone;
        ItemMap itemMap;
        Char player;

        //----UPDATE ZONE----\\
        for (i = zones.size() - 1; i >= 0; --i) {
            zone = zones.get(i);
            if (zone != null) {
                //==UPDATE MOB==\\
                mobs.clear();
                synchronized (zone.mobs) {
                    for (j = zone.mobs.size() - 1; j >= 0; --j) {
                        mob = zone.mobs.get(j);
                        if (mob != null) {
                            mobs.add(mob);
                        }
                    }
                }
                for (j = mobs.size() - 1; j >= 0; --j) {
                    mob = mobs.get(j);
                    mob.update();
                }

                //===UPDATE ITEMMAP==\\
                itemMaps.clear();
                synchronized (zone.itemMaps) {
                    for (j = zone.itemMaps.size() - 1; j >= 0; --j) {
                        itemMap = zone.itemMaps.get(j);
                        if (itemMap != null) {
                            if (itemMap.milisecondRemove <= System.currentTimeMillis() || (itemMap.item.template.id == 362 && !NamekBall.gI().isFossil) || (itemMap.item.isItemNameBall() && NamekBall.gI().isFossil)) {
                                itemMaps.add(itemMap);
                            } else if (itemMap.charId != -1 && itemMap.milisecondRemove - System.currentTimeMillis() <= ItemMap.MILISECONDALLOW && !itemMap.item.isItemSKH() && !itemMap.item.isItemKGPA() && !itemMap.isPickItemNotMe) {
                                itemMap.charId = -1;
                            }
                        }
                    }
                }
                for (j = itemMaps.size() - 1; j >= 0; --j) {
                    itemMap = zone.itemMaps.get(j);
                    synchronized (zone.itemMaps) {
                        zone.itemMaps.remove(itemMap);
                    }
                    zone.itemMapRemove(itemMap.itemMapID);
                    if (itemMap.item.isItemBlackBall()) {
                        int x = itemMap.x;
                        int y = itemMap.y;
                        player = zone.getPlayerFirst();
                        if (player != null) {
                            x = player.cx;
                            y = zone.mapTemplate.touchY(x, player.cy);
                        }
                        itemMap = zone.addItemMap(-1, itemMap.item, x, y, -1, -1);
                        itemMap.milisecondRemove = System.currentTimeMillis() + 10000;
                        zone.itemMapAdd(itemMap);
                    } else if (itemMap.item.isItemNameBall()) {
                        BallRada rada = BallRada.getById(itemMap.item.template.id);
                        if (rada != null) {
                            if (NamekBall.gI().isFossil) {
                                itemMap.item.setTemplate(362);
                            }
                            itemMap = zone.addItemMap(-1, rada.ball, itemMap.x, itemMap.y, -1, -1);
                            rada.itemMapID = itemMap.itemMapID;
                            zone.itemMapAdd(itemMap);
                        }
                    } else if (itemMap.item.template.id == 362) {
                        if (!NamekBall.gI().isFossil) {
                            itemMap.item.setTemplate(353 + itemMap.item.getParamOption(73));
                        }
                        itemMap = zone.addItemMap(-1, itemMap.item, itemMap.x, itemMap.y, -1, -1);
                        zone.itemMapAdd(itemMap);
                    }
                }

                //===UPDATE NPC===\\
                this.npcs.clear();
                synchronized (zone.npcs) {
                    for (j = zone.npcs.size() - 1; j >= 0; --j) {
                        this.npcs.add(zone.npcs.get(j));
                    }
                }
                for (j = npcs.size() - 1; j >= 0; --j) {
                    npcs.get(j).update(zone);
                }

                //Qua trung
                if (zone.isEgg) {
                    if (!zone.isHaveBoss(80)) {
                        zone.timeHatch += delays;
                        if (zone.timeHatch >= zone.setTimehatch) {
                            zone.timeHatch = zone.setTimehatch;
                            zone.isEgg = false;
                            zone.tMabu = 3000;
                        }
                        if (zone.timeHatch % 2 == 0) {
                            zone.tMabu((int) (100f / (float)zone.setTimehatch * (float)zone.timeHatch));
                        }
                    }

                }
                //Mabu no
                if (zone.tMabu > 0) {
                    zone.tMabu -= delays;
                    if (zone.tMabu <= 0) {
                        zone.tMabu = 0;
                        Player boss = Player.addBoss(80, 0, -1, -1, true, zone.xHatch, zone.yHatch, zone, -1, -1);
                        boss.isSendSocola30 = true;
                        boss.isSendStone30 = true;
                        boss.timeSendSocola30 = 30000;
                        boss.timeSendStone30_2 = 50000;
                        zone.chat(boss, mResources.MABU_MABU_MABU);
                        Npc npc = zone.findNPCInMap(46);
                        if (npc != null) {
                            npc.timeInvateMabu = 5000;
                        }
                    }
                }

                //===UPDATE PHAOHOA==\\
                this.phaohoas.clear();
                synchronized (zone.phaohoas) {
                    for (j = 0; j < zone.phaohoas.size(); j++) {
                        this.phaohoas.add(zone.phaohoas.get(j));
                    }
                }
                for (j = 0; j < this.phaohoas.size(); j++) {
                    this.phaohoas.get(j).update();
                }
            }
        }
    }
    
//    @Override
//    public void run() {
//        while (isRun) {
//            final long l = System.currentTimeMillis();
//            this.update();
//            try {
//                TimeUnit.MILLISECONDS.sleep(Server.SERVER_DELAY_MILISECOND);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            delays = (int) (System.currentTimeMillis() - l);
//        }
//        Map.remove(this);
//        if (Map.containsServer(this)) {
//            Map.removeServer(this);
//        }
//    }
    
    public boolean isMapRoadSnake() {
        return this.templateId == 141 || this.templateId == 142 || this.templateId == 143 || this.templateId == 144;
    }
    
    public boolean isMapDiaNguc() {
        return this.templateId == 168 || this.templateId == 167;
    }
}
