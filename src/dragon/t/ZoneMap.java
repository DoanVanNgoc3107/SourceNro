package dragon.t;

import dragon.server.Dragon;
import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ZoneMap {
    
    public static String[] mapNames;
    
    public MapTemplate mapTemplate;
    public Map map;
    public int zoneID;
    public int maxPlayer;
    
    public ArrayList itemBgs = new ArrayList();
    public ArrayList currItems = new ArrayList();
    public final ArrayList<Waypoint> waypoints = new ArrayList();
    public final ArrayList<Mob> mobs = new ArrayList();
    public final ArrayList<Npc> npcs = new ArrayList();
    public final ArrayList<Char> players = new ArrayList<>();
    public final ArrayList<ItemMap> itemMaps = new ArrayList<>();
    public final ArrayList<PhaoHoa> phaohoas = new ArrayList<>();
    
    private short base_itemMapID = 0;
    public boolean isWinBlackBall = false;
    public int countMobDie = 0;
    public boolean isEggHatch;
    public boolean isEgg;
    public int timeHatch;
    public int xHatch = 150;
    public int yHatch = 150;
    public int setTimehatch;
    public int tMabu = 0;
    public int tReturn = 0;
    public final Char[] arrCocoon = new Char[4];
    public short[][] arrCocoonPoint;
    public boolean isRace;
    public String rankName1 = null;
    public String rankName2 = null;
    public int rank1;
    public int rank2;
    public boolean isFightWish;
    public final ArrayList<Char> helps = new ArrayList<>();
    public long lastCumber;
    
    public ZoneMap(MapTemplate mapTemplate, Map map, int zoneID) {
        this.mapTemplate = mapTemplate;
        this.map = map;
        this.zoneID = zoneID;
        if (mapTemplate.mapTemplateId == 128) {
            this.arrCocoonPoint = new short[][] {
                {
                    198,
                    256
                },
                {
                    340,
                    256
                },
                {
                    413,
                    232
                },
                {
                    530,
                    256
                }
            };
        }
    }
    
    public void finishMap(Char charz) {
        synchronized(players) {
            //======ME======//
            for (int i1 = 0; i1 < this.players.size(); ++i1) {
                Char player1 = this.players.get(i1);
                if (player1 != null && player1.charID != charz.charID) {
                    //Me Add player
                    charz.session.service.addPlayer(player1, 0);
                    //Khien
                    if (player1.protectEff) {
                        charz.session.service.holdChar(1, 33, -1, player1.charID, -1);
                    }
                    //Mu
                    if (player1.blindEff) {
                        charz.session.service.holdChar(1, 40, -1, player1.charID, -1);
                    }
                    //Ru ngu
                    if (player1.sleepEff) {
                        charz.session.service.holdChar(1, 41, -1, player1.charID, -1);
                    }
                    //Huy sao
                    if (player1.huytSao) {
                        charz.session.service.holdChar(1, 39, -1, player1.charID, -1);
                    }
                    //Huy sao
                    if (player1.holder) {
                        charz.session.service.holdChar(1, 32, -1, player1.charID, player1.charId_holder);
                    }
                    //De trung
                    if (player1.mobMe != null) {
                        charz.session.service.addMobMe(player1.mobMe.mobId, player1.mobMe.templateId, player1.mobMe.hp);
                    }
                    //PetFollowz
                    if (player1.petFollowz != null) {
                        charz.session.service.petFollow(player1.charID, player1.petFollowz.smallID, player1.petFollowz.fimg, player1.petFollowz.frame, player1.petFollowz.wimg, player1.petFollowz.himg);
                    } else {
                        //PetFollow
                        if (player1.petFollow != null) {
                            charz.session.service.petFollow(player1.charID, player1.petFollow.smallID, player1.petFollow.fimg, player1.petFollow.frame, player1.petFollow.wimg, player1.petFollow.himg);
                        }
                    }
                    
                    //Hieu ung
                    if (player1.cTemplateId == 15) {
                        charz.session.service.addEffectChar(player1.charID, 58, 1, 0, 1, 0);
                    }
                    //Ken
                    if (player1.isMabuHold) {
                        charz.session.service.setMabuHold(player1.isMabuHold, player1.charID, player1.cx, player1.cy);
                    }
                    //Gong
                    if (player1.timeGong2 > 0) {
                        charz.session.service.startGong(player1.charID);
                    }
                    //itemEff
                    try {
                        for (int i = 0; i < player1.aEffChar.size(); i++) {
                            if (player1.aEffChar.get(i).isPaint) {
                                charz.session.service.addEffectChar(player1.charID, player1.aEffChar.get(i).effId, player1.aEffChar.get(i).layer, player1.aEffChar.get(i).loop, player1.aEffChar.get(i).tLoop, player1.aEffChar.get(i).isStand);
                            }
                        }
                    } catch (Exception e) {}
                }
            }
        }
        synchronized (mobs) {
            for (int i2 = 0; i2 < mobs.size(); ++i2) {
                Mob mob1 = mobs.get(i2);
                if (mob1 != null) {
//                    if (mob1.status != 0) {
//                        Service.mobLive(mob1.mobId, mob1.sys, mob1.levelBoss, mob1.maxHp);
//                    }
                    //Mu
                    if (mob1.blindEff) {
                        charz.session.service.holdMob(1, 40, mob1.mobId, -1);
                    }
                    //Ru ngu
                    if (mob1.sleepEff) {
                        charz.session.service.holdMob(1, 41, mob1.mobId, -1);
                    }
                    //Troi
                    if (mob1.holder) {
                        charz.session.service.holdMob(1, 32, mob1.mobId, mob1.holder_charId);
                    }
                    //Bien socola
                    if (mob1.changBody) {
                        charz.session.service.changeMobBody(1, mob1.mobId, mob1.smallBody);
                    }
                }
            }
        }
        //==========NPC======//
        synchronized (this.npcs) {
            for (int i3 = 0; i3 < this.npcs.size(); i3++) {
                if (this.npcs.get(i3).isHide) {
                    charz.session.service.hideNpc(this.npcs.get(i3).template.npcTemplateId, 0);
                }
            }
        }
        if (CallDragon.gI().isRongThanXuatHien && CallDragon.gI().playerId == charz.playerId) {
            CallDragon.gI().openmenuRong(charz);
        }
        //dua hau
        if (!charz.duahaus.isEmpty()) {
            for (int i4 = 0; i4 < charz.duahaus.size(); i4++) {
                if (this.isHaveNpc(charz.duahaus.get(i4).id) && this.findNPCInMap(charz.duahaus.get(i4).id).duahau == charz.duahaus.get(i4)) {
                    charz.session.service.setStatus(charz.duahaus.get(i4).id, charz.duahaus.get(i4).duahau, charz.duahaus.get(i4).duaHauIndex, (int) (charz.duahaus.get(i4).second - ((System.currentTimeMillis() / 1000L) - charz.duahaus.get(i4).last)));
                }
            }
        }
        if (this.map.isMapButcher()) {
            charz.session.service.setPowerInfo(mResources.TL, charz.collectPoint, 10, 10);
        }
        //Nhiem vu
        if (charz.ctaskId == 27 && charz.ctaskIndex == 0) {
            if (this.mapTemplate.mapTemplateId == 93 || this.mapTemplate.mapTemplateId == 94 || this.mapTemplate.mapTemplateId == 96) {
                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.FINNISH_TASK1_27, null, 0);
            }
        }
        if (charz.ctaskId == 28 && charz.ctaskIndex == 0) {
            if (this.mapTemplate.mapTemplateId == 104) {
                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.FINNISH_TASK1_28, null, 0);
            }
        }
        if (charz.ctaskId == 29 && charz.ctaskIndex == 0) {
            if (this.mapTemplate.mapTemplateId == 97 || this.mapTemplate.mapTemplateId == 98) {
                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.FINNISH_TASK1_29, null, 0);
            }
        }
    }
    
    public void loadMapInfo(Char charz, int mapTemplateId) {
        //MapInfo
        ArrayList<Waypoint> wps = new ArrayList<>();
        for (int i1 = 0; i1 < this.waypoints.size(); i1++) {
            wps.add(this.waypoints.get(i1));
        }
        ArrayList<Mob> ms = new ArrayList<>();
        synchronized(this.mobs) {
            for (int i2 = 0; i2 < this.mobs.size(); i2++) {
                if (!this.mobs.get(i2).isMobMe) {
                    ms.add(this.mobs.get(i2));
                }
            }
        }
        ArrayList<Npc> ns = new ArrayList<>();
        synchronized(this.npcs) {
            for (int i3 = 0; i3 < this.npcs.size(); i3++) {
                if ((this.npcs.get(i3).template.npcTemplateId != 71 || (charz.ctaskId == 34 && charz.ctaskIndex == 5))) {
                    ns.add(this.npcs.get(i3));
                }
            }
        }
        ArrayList<ItemMap> ims = new ArrayList<>();
        synchronized(this.itemMaps) {
            for (int i4 = 0; i4 < this.itemMaps.size(); i4++) {
                ims.add(itemMaps.get(i4));
            }
        }
        charz.session.service.mapTemplate(this, this.mapTemplate, wps, ms, ns, ims, 0);
    }
    
    public void mapInfo(Char player, int typeTeleport) {
        player.session.service.mapClear();
        player.session.service.tileSet(this.mapTemplate.mapTemplateId);
        //MapInfo
        ArrayList<Waypoint> wps = new ArrayList<>();
        for (int i1 = 0; i1 < this.waypoints.size(); i1++) {
            wps.add(this.waypoints.get(i1));
        }
        ArrayList<Mob> ms = new ArrayList<>();
        synchronized(this.mobs) {
            for (int i2 = 0; i2 < this.mobs.size(); i2++) {
                if (!this.mobs.get(i2).isMobMe) {
                    ms.add(this.mobs.get(i2));
                }
            }
        }
        ArrayList<Npc> ns = new ArrayList<>();
        synchronized(this.npcs) {
            for (int i3 = 0; i3 < this.npcs.size(); i3++) {
                if ((this.npcs.get(i3).template.npcTemplateId != 71 || (player.ctaskId == 34 && player.ctaskIndex == 5))) {
                    if (this.npcs.get(i3).template.npcTemplateId != 74 || player.isFullTBHD) {
                        ns.add(this.npcs.get(i3));
                    }
                }
            }
        }
        ArrayList<ItemMap> ims = new ArrayList<>();
        synchronized(this.itemMaps) {
            for (int i4 = 0; i4 < this.itemMaps.size(); i4++) {
                ims.add(itemMaps.get(i4));
            }
        }
        player.session.service.mapInfo(this, wps, ms, ns, ims, typeTeleport);
    }
    
    public void join(Char charz, int typeTeleport, int x, int y) {
        int flag = -1;
        ZoneMap zoneOld = charz.zoneMap;
        if (charz.itemNamekBall != null) {
            BallRada.timeCleanBall = -1;
            charz.timeNextMapNamek = System.currentTimeMillis() + 45000;
            if (!this.map.isMapNamekBall()) {
                charz.throwNamekBall();
            }
        }
        if (this.map.isMapCace23_2() && !charz.isTemplate) {
            flag = 0;
        } else if (this.map.isMapButcher() && !charz.isTemplate) {
            flag = Flag.get(new int[]{519, 519, 519, 520}[Util.gI().nextInt(4)]).id;
        } else if (this.map.isMapBlackBall() && !charz.isTemplate) {
            Char p = this.getPlayerFirstClan(charz);
            if (p != null) {
                flag = p.cFlag;
            } else {
                flag = Flag.get(new int[]{364, 365, 366, 367, 368, 369, 370}[Util.gI().nextInt(7)]).id;
            }
        } else {
            if (zoneOld != null) {
                if (zoneOld.map.isMapBlackBall() && !this.map.isMapBlackBall()) {
                    flag = 0;
                    if (charz.phuHoBlackBall > 0) {
                        charz.phuHoBlackBall = 0;
                        charz.updateAll();
                        if (charz.session != null) {
                            charz.session.service.meLoadPoint();
                        }
                        charz.zoneMap.playerLoadAll(charz);
                    }
                } else if (zoneOld.map.isMapButcher()) {
                    flag = 0;
                }
            }
        }
        if (this.map.isMapHome()) {
            if (this.itemMaps.isEmpty() && charz.ctaskId > 2) {
                this.addItemMap(charz.charID, new Item(74, false, 1, null, null, null, null), Char.gI().pointDuiGa[charz.cgender][0], Char.gI().pointDuiGa[charz.cgender][1]-18, 0, -1);
            }
        }
        if (x != -1) {
            charz.cx = x;
        }
        if (y != -1) {
            charz.cy = y;
        }
        try {
            charz.pixels = this.mapTemplate.getCollisionPixel(charz.cx, charz.cy -1);
        } catch (Exception e) {
            charz.setPos(150, 150, 1);
        }
        if (charz.session != null) {
            this.mapInfo(charz, typeTeleport);
            charz.session.service.meLoadInfo();
        }
        synchronized(players) {
            //=========PLAYER======//
            for (int i = 0; i < this.players.size(); ++i) {
                Char player2 = this.players.get(i);
                if (player2 != null && player2.session != null) {
                    //player Add Me
                    player2.session.service.addPlayer(charz, typeTeleport);
                    //Khien
                    if (charz.protectEff) {
                        player2.session.service.holdChar(1, 33, -1, charz.charID, -1);
                    }
                    //Mu
                    if (charz.blindEff) {
                        player2.session.service.holdChar(1, 40, -1, charz.charID, -1);
                    }
                    //Ru ngu
                    if (charz.sleepEff) {
                        player2.session.service.holdChar(1, 41, -1, charz.charID, -1);
                    }
                    //Huyt sao
                    if (charz.huytSao) {
                        player2.session.service.holdChar(1, 39, -1, charz.charID, -1);
                    }
                    //Troi
                    if (charz.holder) {
                        player2.session.service.holdChar(1, 32, -1, charz.charID, charz.charId_holder);
                    }
                    //De trung
                    if (charz.mobMe != null) {
                        player2.session.service.addMobMe(charz.mobMe.mobId, charz.mobMe.templateId, charz.mobMe.hp);
                    }
                    //PetFollowz
                    if (charz.petFollowz != null) {
                        player2.session.service.petFollow(charz.charID, charz.petFollowz.smallID, charz.petFollowz.fimg, charz.petFollowz.frame, charz.petFollowz.wimg, charz.petFollowz.himg);
                    } else {
                        //PetFollow
                        if (charz.petFollow != null) {
                            player2.session.service.petFollow(charz.charID, charz.petFollow.smallID, charz.petFollow.fimg, charz.petFollow.frame, charz.petFollow.wimg, charz.petFollow.himg);
                        }
                    }
                    //Ken
                    if (charz.isMabuHold) {
                        player2.session.service.setMabuHold(charz.isMabuHold, charz.charID, charz.cx, charz.cy);
                    }
                    //Gong
                    if (charz.timeGong2 > 0) {
                        player2.session.service.startGong(charz.charID);
                    }
                    //itemEff
                    for (int j = 0; j < charz.aEffChar.size(); j++) {
                        if (charz.aEffChar.get(j).isPaint) {
                            player2.session.service.addEffectChar(charz.charID, charz.aEffChar.get(j).effId, charz.aEffChar.get(j).layer, charz.aEffChar.get(j).loop, charz.aEffChar.get(j).tLoop, charz.aEffChar.get(j).isStand);
                        }
                    }
                }
            }
            if (!players.contains(charz)) {
                players.add(charz);
                charz.mapTemplateId = this.mapTemplate.mapTemplateId;
                charz.zoneID = this.zoneID;
                charz.zoneMap = this;
                charz.isInMap = true;
            }
        }
        //========Mob=====//
        synchronized (mobs) {
            if (charz.mobMe != null) {
                this.mobs.add(charz.mobMe);
            }
        }
        //ME
        if (typeTeleport != 2 && typeTeleport != 0) {
            charz.cy = this.mapTemplate.touchY(charz.cx, charz.cy);
        }
        if (this.map.isMapCold2()) {
            if (!charz.isCold && !charz.isKhienCold) {
                if (charz.session != null) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOUR_GO_COLD, null, (byte)0);
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOUR_ANHHUONG_COLD, null, (byte)0);
                }
            }
            charz.isCold = true;
            charz.updateAll();
        } else {
            if (charz.isCold && !charz.isKhienCold) {
                if (charz.session != null) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOUR_RESET_COLD, null, (byte)0);
                }
            }
            charz.isCold = false;
            charz.updateAll();
        }
        //Phong an
        if (this.map.isMapButcher()) {
            charz.isSeal = true;
            charz.updateAll();
        } else {
            charz.isSeal = false;
            charz.updateAll();
        }
        if (charz.session != null) {
            charz.session.service.meLoadPoint();
        }
        if (flag != -1 && charz.me) {
            charz.changeFlag(flag);
            if (charz.myPet != null) {
                charz.myPetz().changeFlag(flag);
            }
        }
        //Nhiem vu
        if (charz.ctaskId == 3 && charz.ctaskIndex == 1 && ((charz.cgender == 0 && charz.mapTemplateId == 42) || (charz.cgender == 1 && charz.mapTemplateId == 43) || (charz.cgender == 2 && charz.mapTemplateId == 44))) {
            synchronized (this.itemMaps) {
                if (charz.mapTemplateId == 42) {
                    charz.babyId = this.base_itemMapID++;
                    charz.session.service.itemMapAdd(charz.babyId, 78, Map.pointDuaBe[0][0], Map.pointDuaBe[0][1], -1, 0);
                }
                if (charz.mapTemplateId == 43) {
                    charz.babyId = this.base_itemMapID++;
                    charz.session.service.itemMapAdd(charz.babyId, 78, Map.pointDuaBe[1][0], Map.pointDuaBe[1][1], -1, 0);
                }
                if (charz.mapTemplateId == 44) {
                    charz.babyId = this.base_itemMapID++;
                    charz.session.service.itemMapAdd(charz.babyId, 78, Map.pointDuaBe[2][0], Map.pointDuaBe[2][1], -1, 0);
                }
            }
        }
        if ((charz.ctaskId == 10 && charz.ctaskIndex == 1) && charz.mapTemplateId == 47) {
            Player.addBoss(53, 0, -1, -1, true, 660, 150, charz.zoneMap, 5000, -1);
        }
        //tuong lai
        if (this.map.isMapTL()) {
            if (!charz.isFuture) {
                if (charz.session != null) {
                    charz.addInfo1(2000, mResources.CHAT_FUTURE1);
                }
            }
            charz.isFuture = true;
            charz.updateAll();
        } else {
            charz.isFuture = false;
            charz.updateAll();
        }
        if (charz.isTemplate && Server.gI().isSupport(charz.cTemplateId)) {
            synchronized(this.helps) {
                this.helps.add(charz);
            }
        }
    }
    
    public void exit(Char charz, int typeTeleport) {
        charz.exitMap();
        Trade.getInstance().cancelgiaodich(charz, 1);
        if (charz.itemBlackBall != null) {
            charz.throwBlackBall();
        }
        //set hp mp
        if (typeTeleport == 3 && !charz.isDie&& (charz.cHP < charz.cHPFull || charz.cMP < charz.cMPFull)) {
            charz.upHP(charz.cHPFull);
            charz.upMP(charz.cMPFull);
            if (charz.session != null) {
                charz.session.service.meLoadHP(charz.cHP);
                charz.session.service.meLoadMP(charz.cMP);
            }
        }
        synchronized(this.players) {
            if (typeTeleport != 0) {
                for (int i1 = this.players.size() - 1; i1 >= 0; --i1) {
                    Char player = this.players.get(i1);
                    if (player != null && player.session != null) {
                        player.session.service.telePort(charz.charID, typeTeleport);
                    }
                }
            }
            this.players.remove(charz);
            for (int i2 = this.players.size() - 1; i2 >= 0; --i2) {
                Char player = this.players.get(i2);
                if (player != null && player.session != null) {
                    player.session.service.playerReMove(charz.charID);
                }
                if (player != null && player.charFocus != null && player.charFocus.charID == charz.charID ) {
                    player.charFocus = null;
                }
            }
        }
        //=====Mob=====\\
        
        //Mob me
        if (charz.mobMe != null) {
            synchronized (mobs) {
                int i;
                for (i = mobs.size() - 1; i >= 0; --i) {
                    Mob mob1 = mobs.get(i);
                    if (mob1 != null) {
                        if (mob1.mobId == charz.mobMe.mobId) {
                            this.mobs.remove(i);
                        }
                    }
                }
            }
            this.claerMobMe(charz.mobMe.mobId);
        }
        removeAttMob(charz.charID);
        removeAttChar(charz.charID);
        //Me
        charz.mobFocus = null;
        charz.charFocus = null;
        charz.cloneByChar = null;
        charz.collectPoint = 0;
        charz.tCocoon = 0;
        charz.tEat = 0;
        charz.isEat = false;
        charz.isBlKaio = false;
        charz.isInMap = false;
        if (charz.isMabuHold) {
            this.setCocoon(charz.charID, false);
        }
        if (charz.isTemplate && Server.gI().isSupport(charz.cTemplateId)) {
            synchronized(this.helps) {
                this.helps.remove(charz);
            }
        }
    }
    
    public void removeAttMob(int charId) {
        //Mob map
        int i;
        Mob[] arrMob;
        Mob mob;
        synchronized (mobs) {
            arrMob = new Mob[mobs.size()];
            for (i = mobs.size() - 1; i >= 0; --i) {
                arrMob[i] = mobs.get(i);
            }
        }
        for (i = 0; i < arrMob.length; i++) {
            mob = arrMob[i];
            if (mob != null) {
                mob.removeAtt(charId);
            }
        }
    }
    
    public void removeAttChar(int charId) {
        //Char in Map
        int i;
        Char[] arrChar;
        Char player;
        synchronized (players) {
            arrChar = new Char[players.size()];
            for (i = players.size() - 1; i >= 0; --i) {
                arrChar[i] = players.get(i);
            }
        }
        for (i = 0; i < arrChar.length; i++) {
            player = arrChar[i];
            if (player != null && player.charID != charId) {
                player.removeAtt(charId);
            }
        }
    }
    
    public void playerMove(int charID, int cx, int cy) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null && this.players.get(i).charID != charID) {
                    this.players.get(i).session.service.playerMove(charID, cx, cy);
                }
            }
        }
    }
    
    public Waypoint getWaypoint(Char charz) {
        for (int i = 0; i < this.waypoints.size(); i++) {
            Waypoint waypoint = this.waypoints.get(i);
            if (waypoint != null && waypoint.minX - 100 <= charz.cx && waypoint.minY - 100 <= charz.cy && waypoint.maxX + 100 >= charz.cx && waypoint.maxY + 100 >= charz.cy) {
                return waypoint;
            }
        }
        return null;
    }
    
    public void chat(Char charz, String text) {
        if ("adh".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.addTaskPointDH(1292, 1);
            return;
        }
        if ("rnm".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            CallDragon.gI().setup(charz, this, 1, 2);
            return;
        }
        if ("hat0".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.session.service.getHat(0);
            return;
        }
        if (text.startsWith("sv ") && charz.session != null && charz.session.isAdmin > 0) {
            charz.session.service.messageServer(text.replaceAll("sv ", ""));
            return;
        }
        if (text.startsWith("b ") && charz.session != null && charz.session.isAdmin > 0) {
            charz.session.service.water(Integer.parseInt(text.replaceAll("b ", "")));
            return;
        }
        if (text.startsWith("danhhieu") && charz.session != null && charz.session.isAdmin > 0) {
            String arr[] = text.replaceAll("danhhieu ", "").split(" ");
            charz.session.service.danhhieu(charz.charID, Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
            return;
        }
        if ("clanpoint".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.addClanPoint(1000);
            return;
        }
        if ("rlg".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.session.service.playerLoadLevel(new PlayerData[] {new PlayerData(1, "admin1", (short)0, (short)1, (short)2, 1000000000), new PlayerData(3, "admin3", (short)3, (short)4, (short)5, 10000000000L), new PlayerData(4, "admin4", (short)3, (short)4, (short)5, 10000000000L), new PlayerData(5, "admin5", (short)3, (short)4, (short)5, 10000000000L)});
            return;
        }
        if ("dongb".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.sendFreeze(20);
            return;
        }
        if (text.contains("additem") && charz.session != null && charz.session.isAdmin > 0) {
            int id = Integer.parseInt(text.replace("additem", ""));
            this.itemMapAdd(this.addItemMap(-1, new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), charz.cx, charz.cy, 0, -1));
            return;
        }
        if ("vxmm".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.vxmm = !charz.vxmm;
            if (charz.vxmm) charz.session.service.addInfo("Đã bật auto win"); else charz.session.service.addInfo("Đã tắt auto win");
        }
        if ("gnh".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            DaiHoi.createPrize(5);
        }
         if ("rp457".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
             charz.addItemMore2(0, new Item(457, false, 5, ItemOption.getOption(457, 0, 0), "", "", "Quà tân thủ của bạn"));
         }
        if ("dsk".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.myObj().pointEvent += 100;
        }
        if (text.contains("ahu") && charz.session != null && charz.session.isAdmin > 0) {
            Item item = new Item(395, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item.options.add(new ItemOption(6, 10));
            item.options.add(new ItemOption(7, 10));
            charz.addEffectChar(Integer.parseInt(text.replace("ahu", "")), 1, 0, 1, 1, 60, 1, true, true, item);
        }
        if (text.contains("chu") && charz.session != null && charz.session.isAdmin > 0) {
            charz.removeEffChar(-1, 0);
        }
        if ("congau".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            this.addNewBoss(new dragon.t.ConGau(charz.cx, charz.cy));
        }
        if ("ccongau".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            ((NewBoss) this.findMobInMapById(77)).startDie();
        }
        if ("piano".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            this.addNewBoss(new dragon.t.Piano(charz.cx, charz.cy));
        }
        if ("opiano".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            Server.gI().appearPiano();
        }
        if ("cpiano".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            ((NewBoss) this.findMobInMapById(85)).startDie();
        }
        if ("hoathach".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            NamekBall.gI().refossil();
        }
        if ("choathach".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            NamekBall.gI().reappear();
        }
        if ("openrada".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            charz.openDoNgocNamek();
        }
        if ("rvc".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            RongVoCuc.gI().openRongVoCuc();
        }
        if ("crvc".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            RongVoCuc.gI().closeRongVoCuc();
        }
        if ("omabu".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            Server.gI().openMabu();
        }
        if ("cmabu".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            Server.gI().closeMabu();
        }
        if ("obigboss".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            Server.gI().openBigBoss();
        }
        if ("cbigboss".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            Server.gI().closeBigBoss();
        }
        if ("bth".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            Admin.gI().openAdmin(charz);
            return;
        }
        if ("nrsd".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            BlackBall.gI().openBlackBall();
        }
        if ("cnrsd".equals(text) && charz.session != null && charz.session.isAdmin > 0) {
            BlackBall.gI().closeBlackBall();
        }
        if ("28052003".equals(text)&& charz.session.isAdmin > 0 && charz.session != null) {
            charz.resetSkill();
        }
        if ("data".equals(text) && charz.session != null) {
            charz.session.isLoad = !charz.session.isLoad;
            if (charz.session.isLoad) {
                charz.addChat(1, "Đã bật tải tài nguyên");
            } else {
                charz.addChat(1, "Đã tắt tải tài nguyên");
            }
            return;
        }
        if (text.contains("mob") && charz.session != null && charz.session.isAdmin > 0) {
            int mobId = Integer.parseInt(text.replace("mob", ""));
            Mob mob = this.findMobInMap(mobId);
            charz.session.service.resetPont(mob.pointx, mob.pointy);
            System.out.println("goMob");
        }
        if (charz.session != null && charz.session.isAdmin > 0) {
            try {
                String[] ar = text.split(" ");
                if (Integer.parseInt(ar[0]) == 0) {
                    charz.head = Short.parseShort(ar[1]);
                }
                if (Integer.parseInt(ar[0]) == 1) {
                    charz.body = Short.parseShort(ar[1]);
                }
                if (Integer.parseInt(ar[0]) == 2) {
                    charz.leg = Short.parseShort(ar[1]);
                }
                charz.zoneMap.playerLoadAll(charz);
                charz.session.service.updateBody(1, charz.charID, charz.head, charz.body, charz.leg, charz.isMonkey);
            } catch (Exception e) {

            }
        }
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.chat(charz.charID, text);
                }
            }
        }
        //Dua mabu ve nha
        if (Dragon.isEvent_Mabu && text.contains(mResources.VE_NHA_THOI) && Player.getBossPlayer(charz.playerId, 9) == null) {
            Player o = this.getMabu(charz);
            if (o != null && o.isPlayerId == -1) {
                o.changeFlag(8);
                o.isPlayerId = charz.playerId;
                o.cName = charz.cName;
                this.playerLoadAll(o);
                charz.session.service.chat(o.charID, mResources.MABU_CHAT);
            }
        }
        if (charz.myPet != null && text.contains(mResources.TEN_CON_LA)) {
            int indexUI = charz.getItemBagByIndex(400);
            if (indexUI != -1) {
                String name = text.replace(mResources.TEN_CON_LA, mResources.EMPTY).toLowerCase();
                if (!Util.gI().CheckString(name, "^[a-zA-Z0-9]+$") || name.length() < 5 || name.length() > 10) {
                } else {
                    charz.myPetz().cName = name;
                    if (charz.myPetz().zoneMap != null) {
                        charz.myPetz().zoneMap.playerLoadAll(charz.myPetz());
                    }
                    charz.useItemBag(indexUI, 1);
                }
            }
        }
        if (charz.me && charz.myPet != null && charz.myPetz().timeVeNha == 0) {
            if (mResources.SP_DITHEO.equals(text)) {
                if (charz.myPetz().petStatus == 4) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NO_FINNISH, null, (byte)0);
                } else {
                    charz.myPetz().petStatus = 0;
                    charz.session.service.chat(charz.myPetz().charID, mResources.DT_DITHEO);
                }
            }
            if (mResources.SP_BAOVE.equals(text)) {
                if (charz.myPetz().petStatus == 4) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NO_FINNISH, null, (byte)0);
                } else {
                    charz.myPetz().petStatus = 1;
                    charz.session.service.chat(charz.myPetz().charID, mResources.DT_BAOVE);
                }
            }
            if (mResources.SP_TANCONG.equals(text)) {
                if (charz.myPetz().petStatus == 4) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NO_FINNISH, null, (byte)0);
                } else {
                    charz.myPetz().petStatus = 2;
                    charz.session.service.chat(charz.myPetz().charID, mResources.DT_TANCONG);
                }
            }
            if (mResources.SP_VENHA.equals(text)) {
                if (charz.myPetz().petStatus == 4) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NO_FINNISH, null, (byte)0);
                } else {
                    charz.myPetz().timeVeNha = 2000;
                    charz.myPetz().petStatus = 3;
                    charz.session.service.chat(charz.myPetz().charID, mResources.DT_VENHA);
                }
            }
            if (mResources.BIEN_HINH.equals(text) && charz.myPetz().isHopThe == 0 && charz.myPetz().isMabu == 1 && charz.myPetz().zoneMap != null) {
                charz.myPetz().isBienHinh = !charz.myPetz().isBienHinh;
                charz.myPetz().updateAll();
                this.playerLoadAll(charz.myPetz());
                charz.session.service.chat(charz.myPetz().charID, mResources.BU_BU_BU);
            }
//            if (mResources.BIEN_HINH.equals(text) && charz.myPetz().isHopThe != 0) {
//                charz.setValue(6, !(boolean)charz.valueById(6));
//            } 
       }
        //Tuan loc
        if (!charz.isPetThiTheo && (text.equals("ecec") || text.equals("ec ec")) && Player.getBossPlayer(charz.playerId, 38) == null) {
            Player o = this.getBossByType(charz.cx, 38);
            if (o != null) {
                if (o.isPlayerId != -1) {
                    Session_ME player = Server.gI().getByPId(o.isPlayerId);
                    if (player != null) {
                        player.myCharz().addInfo1(String.format(mResources.FALID_DUA_PET_2, o.cName));
                        player.myCharz().isPetThiTheo = false;
                    }
                }
                o.isMove = false;
                charz.isPetThiTheo = true;
                o.isPlayerId = charz.playerId;
                this.chat(charz, String.format(mResources.DUA_PET_GO, o.cName));
            }
        }
        //Lan con
        if (!charz.isPetThiTheo && (text.equals("tungtungtung") || text.equals("tung tung tung")) && Player.getBossPlayer(charz.playerId, 38) == null) {
            Player o = this.getBossByType(charz.cx, 38);
            if (o != null && o.isPlayerId == -1 && !o.isMove) {
                Session_ME player = Server.gI().getByPId(o.isPlayerId);
                if (player != null) {
                    player.myCharz().addInfo1(String.format(mResources.FALID_DUA_PET_2, o.cName));
                    player.myCharz().isPetThiTheo = false;
                }
                o.isMove = false;
                charz.isPetThiTheo = true;
                o.isPlayerId = charz.playerId;
                this.chat(charz, String.format(mResources.DUA_PET_GO, o.cName));
            }
        }
    }
    
    public void playerLoadAll(Char player) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).charID != player.charID && this.players.get(i).session != null) {
                    this.players.get(i).session.service.playerLoadAll(player);
                }
            }
        }
    }
    
    public void playerDie(Char charz) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID != charz.charID && player.session != null) {
                    player.session.service.playerDie(charz.charID, charz.cPk, charz.cx, charz.cy);
                }
            }
        }
    }
    
    public void playerLoadLive(Char charz, int cx, int cy) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID != charz.charID && player.session != null) {
                    player.session.service.playerLoadLive(charz.charID, charz.cHP, charz.cHPFull, cx, cy);
                }
            }
        }
    }
    
    public void returnPointMap(Char charz, int cx, int cy) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.returnPointMap(charz.charID, cx, cy);
                }
            }
        }
    }
    
    public void playerAttackNPC(int playerId, int skillTemplateId, ArrayList<Mob> mobs) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                	this.players.get(i).session.service.playerAttackNPC(playerId, skillTemplateId, mobs);
                }
            }
        }
    }
    
    public void playerLoadHP(Char charz, int b) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID != charz.charID && player.session != null) {
                    player.session.service.playerLoadHP(charz.charID, charz.cHP, b, charz.cHPFull);
                }
            }
        }
    }
    
    public void mobHP(int mobId, int hp, int downhp, boolean flag, int effectId) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.mobHP(mobId, hp, downhp, flag, effectId);
                }
            }
        }
    }
    
    public void mobDie(int mobId, int downhp, boolean flag, ArrayList<ItemMap> itemMaps) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.mobDie(mobId, downhp, flag, itemMaps);
                }
            }
        }
    }
    
    public void updateBody(Char charz, int type) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.updateBody(type, charz.charID, charz.head, charz.body, charz.leg, charz.isMonkey);
                }
            }
        }
    }
    
    public void itemMapRemove(int itemMapID) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.itemMapRemove(itemMapID);
                }
            }
        }
    }
    
    public void itemMapPlayerPick(int itemMapID, int charID) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID != charID && player.session != null) {
                    player.session.service.itemMapPlayerPick(itemMapID, charID);
                }
            }
        }
    }
    
    public void removeItemMap(int itemMapId) {
        int i;
        synchronized(itemMaps) {
            for (i = 0; i < itemMaps.size(); i++) {
                if (itemMaps.get(i).itemMapID == itemMapId) {
                    itemMaps.remove(i);
                    break;
                }
            }
        }
    }
    
    public ItemMap getItemMap(int itemMapId) {
        int i;
        ItemMap o =  null;
        synchronized(itemMaps) {
            for (i = 0; i < itemMaps.size(); i++) {
                if (itemMaps.get(i).itemMapID == itemMapId) {
                    o = itemMaps.get(i);
                    break;
                }
            }
        }
        return o;
    }
    
    public boolean isHaveItemMap(int itemMapId) {
        int i;
        boolean b = false;
        synchronized(itemMaps) {
            for (i = 0; i < itemMaps.size(); i++) {
                if (itemMaps.get(i).itemMapID == itemMapId) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public boolean isHaveItemMap(ItemMap value) {
        synchronized(itemMaps) {
            return itemMaps.contains(value);
        }
    }
    
    public void removeItemMax() {
        ItemMap im = null;
        int i;
        synchronized(itemMaps) {
            for (i = 0; i < itemMaps.size(); i++) {
                if (!itemMaps.get(i).item.isItemBlackBall() || !itemMaps.get(i).item.isItemNamekBall() && itemMaps.get(i).item.template.type != 22) {
                    im = itemMaps.get(i);
                    break;
                }
            }
        }
        if (im != null) {
            removeItemMap(im.itemMapID);
            this.itemMapRemove(im.itemMapID);
        }
    }
    
    public ItemMap addItemMap(int charId, Item item, int x, int y, int r, int playerId) {
        if (sizeItemMap() > 100) {
            removeItemMax();
        }
        ItemMap itemMap;
        synchronized(itemMaps) {
            if (!item.isExpires && item.isHaveOption(93)) {
                item.setExpires(System.currentTimeMillis() + (long)(1000l * 60l * 60l * 24l * (long)(item.getParamOption(93) + 1)));
            }
            CaiTrang.gI().setPartTemp(item);
            itemMap = new ItemMap(this.base_itemMapID++, charId, item, x, y, r, playerId);
            itemMaps.add(itemMap);
        }
        //Kiem tra x,y item
        kiemtra:
        {
            int xOld = itemMap.x;
            int yOld = itemMap.y;
            //Cho chui len
            while (itemMap.x > 0 && itemMap.x < this.mapTemplate.pxw && itemMap.y > 0 && itemMap.y < this.mapTemplate.pxh) {
                if (this.mapTemplate.isCollisionPixel(itemMap.x, itemMap.y - 1, 0xffffffff)) {
                    break kiemtra;
                }
                itemMap.y--;
            }
            //tim y rong
            itemMap.y = this.mapTemplate.pxh - 1;
            while (itemMap.x > 0 && itemMap.x < this.mapTemplate.pxw && itemMap.y > 0 && itemMap.y < this.mapTemplate.pxh) {
                if (this.mapTemplate.isCollisionPixel(itemMap.x, itemMap.y - 1, 0xffffffff)) {
                    break kiemtra;
                }
                itemMap.y--;
            }
        }
        return itemMap;
    }
    
    public int createItemMapId() {
        synchronized(itemMaps) {
            return this.base_itemMapID++;
        }
    }
    
    public void pickItem(Char player, int itemMapID, int type) {
        if (player.isgiaodich) {
            if (player.session != null) {
                player.addInfo1(mResources.O_THE_THUC_HIEN);
            }
        } else {
            boolean b = false;
            boolean b2 = true;
            Item it = null;
            if (player.babyId == itemMapID && player.ctaskId == 3 && player.ctaskIndex == 1 && ((player.cgender == 0 && player.mapTemplateId == 42) || (player.cgender == 1 && player.mapTemplateId == 43) || (player.cgender == 2 && player.mapTemplateId == 44))) {
                player.addInfo1(mResources.WOW_BABY);
                player.updateTask(1);
                player.updateAll();
                player.zoneMap.getBag(player);
            } else {
                synchronized(itemMaps) {
                    for (int i = this.itemMaps.size() - 1 ; i >= 0; --i) {
                        ItemMap itemMap = this.itemMaps.get(i);
                        if (itemMap.itemMapID == itemMapID) {
                            if (itemMap.item.template.type == 22) {
                                return;
                            }
                            b2 = false;
                            if (type == 1 && (Math.abs(player.cx - itemMap.x) > 100 || Math.abs(player.cy - itemMap.y) > 100)) {
                                if (player.session != null) {
                                    player.addInfo1(mResources.D_ITEM);
                                }
                            } else if (itemMap.item.template.id == 1258 && !player.isHaveItemBag(1259)) {
                                player.addInfo1(mResources.NOT_JAR_MAGIC);
                            } else  if (itemMap.item.template.id == 362) {
                                player.addInfo1(mResources.FOSSIL);
                            } else if (itemMap.item.isItemNamekBall() && player.itemNamekBall != null) {
                                player.addInfo1(mResources.NGOC_BU);
                            } else if (itemMap.item.template.id == 638 && player.isHaveItem(638)) {
                                player.addInfo1(mResources.HAVE_COMMESON);
                            } else if (itemMap.item.isItemBlackBall() && this.isWinBlackBall) {
                                player.addInfo1(mResources.NRSD_WIN);
                            } else if (itemMap.item.isItemBlackBall() && BlackBall.gI().timePickBlackBall > 0) {
                                player.addInfo1(String.format(mResources.DELAY_PICK_NRSD, BlackBall.gI().timePickBlackBall / 1000));
                            } else if (itemMap.charId != -1 && itemMap.charId != player.myCharz().charID) {
                                if (player.session != null) {
                                    player.addInfo1(mResources.ITEM_MAP_NOT_ME);
                                }
                            } else {
                                if (player.myCharz().checkBag(itemMap.item)) {
                                    b = true;
                                    it = itemMap.item;
                                    //Nhiem vu thanh tich nhat ngoc
                                    if (player.session != null && (itemMap.item.template.type == 10 || itemMap.item.template.type == 34)) {
                                    	player.updateArchivement(15, itemMap.item.quantity);
                                    }
                                    //Nhiem vu hang ngay nhat vang
                                    if (player.session != null && player.myObj().taskEveryday != null && player.myObj().taskEveryday.template.type == 3 && itemMap.item.template.type == 9) {
                                    	if (player.myObj().taskEveryday.addCount(itemMap.item.quantity)) {
                                    		player.addInfo1(mResources.TAKE_GIFT3);
                                    	}
                                    }
                                    switch (itemMap.item.template.type) {
                                        case 9:
                                        {
                                            player.myCharz().updateXu(itemMap.item.quantity, 0);
                                            break;
                                        }
                                        case 10:
                                        {
                                            player.myCharz().updateLuong(itemMap.item.quantity, 0);
                                            break;
                                        }
                                        case 34:
                                        {
                                            player.myCharz().updateLuongKhoa(itemMap.item.quantity, 0);
                                            break;
                                        }
                                        default:
                                        {
                                            if (itemMap.item.template.id == 74 || itemMap.item.template.id == 516) {
                                                player.upHP(player.cHPFull);
                                                if (player.session != null) {
                                                    player.session.service.meLoadHP(player.cHP);
                                                }
                                                if (itemMap.item.template.id == 74) {
                                                    player.upMP(player.cMPFull);
                                                    if (player.session != null) {
                                                        player.session.service.meLoadMP(player.cMP);
                                                    }
                                                }
                                            } else if (itemMap.item.template.id == 568) {
                                                player.addDuaHau(50, new int[]{4664}, 0, 2592000, 4664);
                                            } else if (itemMap.item.isItemBlackBall()) {
                                                player.myCharz().itemBlackBall = itemMap.item;
                                            } else if (itemMap.item.isItemNamekBall()) {
                                                player.myCharz().itemNamekBall = itemMap.item;
                                                BallRada ball = BallRada.getById(it.template.id);
                                                if (ball != null) {
                                                    ball.itemMapID = -1;
                                                }
                                                player.myCharz().cTypePk = 5;
                                            } else {
                                                int indexUI = player.myCharz().getItemBagIndex(itemMap.item);
                                                if (indexUI == -1) {
                                                    indexUI = player.myCharz().getEmptyBagIndex();
                                                }
                                                if (itemMap.item.isItemSLL() ? player.myCharz().addQuantityItemBagByIndex(indexUI, itemMap.item.getParamOption(31)) == 0 : player.myCharz().addQuantityItemBagByIndex(indexUI, itemMap.item.quantity) == 0) {
                                                    player.myCharz().addItemBag(itemMap.item, indexUI);
                                                }
                                                if (indexUI != -1 && player.myCharz().arrItemBag[indexUI] != null) {
                                                    if (player.myCharz().arrItemBag[indexUI].expires > itemMap.item.expires && itemMap.item.expires != -1) {
                                                        player.myCharz().arrItemBag[indexUI].setExpires(itemMap.item.expires);
                                                    }
                                                }
                                                player.myCharz().session.service.Bag(player.myCharz().arrItemBag);
                                            }
                                            break;
                                        }
                                    }
                                    this.itemMaps.remove(i);
                                    if (itemMap.item.template.id == 74 || itemMap.item.template.id == 516) {
                                        if (player.session != null) {
                                            player.session.service.itemMapMyPick(itemMapID, String.format(mResources.USE_FOODS, itemMap.item.template.name), itemMap.item.template.type, itemMap.item.quantity, itemMap.item.quantity);
                                        }
                                    } else {
                                        if (player.session != null) {
                                            player.session.service.itemMapMyPick(itemMapID, mResources.EMPTY, itemMap.item.template.type, itemMap.item.quantity, itemMap.item.quantity);
                                        }
                                    }
                                    if (type == 1) {
                                        player.timeNhat = 1000;
                                    }
                                    dragon.t.ItemMapTask.update(player, itemMap);
                                } else {
                                    if (player.session != null) {
                                        player.addInfo1(mResources.BAG_FULL);
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                if (it != null && it.isItemBlackBall()) {
                    player.updateAll();
                    player.zoneMap.getBag(player);
                    this.playerLoadAll(player);
                    this.updateBlackFlag(player);
                    player.timeBlackBall = BlackBall.gI().timeKeepBlackBall;
                }
                if (it != null && it.isItemNamekBall()) {
                    player.updateAll();
                    player.timeNextMapNamek = System.currentTimeMillis() + 45000;
                    player.zoneMap.getBag(player);
                    this.playerLoadAll(player);
                    this.updateTypePk(player.charID, player.cTypePk);
                }
            }
            if (b2) {
                if (player.session != null) {
                    player.session.service.itemMapRemove(itemMapID);
                }
            }
            if (b) {
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1295, 1);
                }
                this.itemMapPlayerPick(itemMapID, player.charID);
            }
        }
    }
    
    public byte pts() {
        int percent = this.getCountPLayerNotAI() * 100 / this.maxPlayer;
        if (percent < 50) {
            return 0;
        } else if (percent < 100) {
            return 1;
        } else {
            return 2;
        }
    }
    
    public Char getPlayerAttack(Mob mob) {
        Char array1[];
        Char array2[];
        int num = 0, i;
        synchronized (this.players) {
            array1 = new Char[this.players.size()];
            array2 = new Char[this.players.size()];
            for (i = 0; i < players.size(); i++) {
                array1[i] = this.players.get(i);
            }
        }
        for (i = 0; i < array1.length; i++) {
            if (array1[i] != null && !array1[i].isInvisiblez && !array1[i].isDie && mob.isAtt(array1[i].charID) && Math.abs(array1[i].cx - mob.pointx) <= 300 && Math.abs(array1[i].cy - mob.pointy) <= 200 && array1[i].timeReady <= 0) {
                array2[num++] = array1[i];
            }
        }
        if (num == 0) {
            for (i = 0; i < array1.length; i++) {
                if (array1[i] != null && !array1[i].isInvisible && !array1[i].isInvisiblez && !array1[i].isDie && !array1[i].isMobproactive && mob.level >= 5 && Math.abs(array1[i].cx - mob.pointx) <= 50 && Math.abs(array1[i].cy - mob.pointy) <= 50 && array1[i].timeReady <= 0 && (!array1[i].isTemplate || array1[i].cTemplateType == 7 || array1[i].cTemplateType == 46)) {
                    array2[num++] = array1[i];
                }
            }
        }
        if (num > 0) {
            Char player = array2[0];
            int minDistance = Math.abs(player.cx - mob.pointx) + Math.abs(player.cy - mob.pointy);
            for (i = 1; i < num; i++) {
                Char current = array2[i];
                int distance = Math.abs(current.cx - mob.pointx) + Math.abs(current.cy - mob.pointy);
                if (distance < minDistance) {
                    player = current;
                    minDistance = distance;
                }
            }
            return player;
        }
        return null;
    }
    
    public void mobAttackPlayer(int mobId, int charID, int cHP, int cMP) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).charID != charID && this.players.get(i).session != null) {
                    this.players.get(i).session.service.mobAttackPlayer(mobId, charID, cHP, cMP);
                }
            }
        }
    }
    
    public void mobLive(int mobId, int sys, int levelBoss, int hp) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.mobLive(mobId, sys, levelBoss, hp);
                }
            }
        }
    }
    
    public void changeFlag(int charID, int cFlag) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.changeFlag(charID, cFlag);
                }
            }
        }
    }
    
    public void loadMobID() {
        synchronized(this.mobs) {
            int num = 0;
            for (int i = 0; i < this.mobs.size(); i++) {
                if (!this.mobs.get(i).isMobMe) {
                    this.mobs.get(i).mobId = num++;
                }
            }
        }
    }
    
    public Mob findMobInMap(int mobId) {
        synchronized(this.mobs) {
            for (int i = 0; i < this.mobs.size(); i++) {
                Mob mob = this.mobs.get(i);
                if (mob.mobId == mobId) {
                    return mob;
                }
            }
        }
        return null;
    }
    
    public Mob findMobInMapById(int id) {
        synchronized(this.mobs) {
            for (int i = 0; i < this.mobs.size(); i++) {
                Mob mob = this.mobs.get(i);
                if (mob.templateId == id) {
                    return mob;
                }
            }
        }
        return null;
    }
    
    public Char findCharInMap(int charId) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID == charId) {
                    return player;
                }
            }
        }
        return null;
    }
    
    public Npc findNPCInMap(int templateId) {
        synchronized(this.npcs) {
            for (int i = 0; i < this.npcs.size(); i++) {
                if (this.npcs.get(i).template.npcTemplateId == templateId) {
                    return this.npcs.get(i);
                }
            }
            return null;
        }
    }
    
    public void playerAttackPlayer(int playerId, int skillId, ArrayList<Char> chars, int isContinue, int typeSkill, int damHP, boolean isDie, boolean isCrit) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.playerAttackPlayer(playerId, skillId, chars, isContinue, typeSkill, damHP, isDie, isCrit);
                }
            }
        }
    }
    
    public void playerAttackNP(int charId, int skillId, ArrayList<Mob> mobs, ArrayList<Char> chars) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID != charId && player.session != null) {
                    player.session.service.playerAttackNP(charId, skillId, mobs, chars);
                }
            }
        }
    }
    
    public void haveAttackPlayer(int charId, int hp, int damHP, boolean isCrit, int idEff) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.haveAttackPlayer(charId, hp, damHP, isCrit, idEff);
                }
            }
        }
    }
    
    public void player_skill_not_focus(int skill_type, int playerId, int skillTemplateId, ArrayList<Mob> mobs,ArrayList<Char> players, int seconds) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID != playerId && player.session != null) {
                    player.session.service.skill_not_focus(skill_type, playerId, skillTemplateId, mobs, players, seconds);
                }
            }
        }
    }
    
    public void setMobSkill(Char charz, Skill skillFight, ArrayList<Mob> mobs) {
        synchronized (this.mobs) {
            for (int i = 0; i < this.mobs.size(); i++) {
                Mob mob = this.mobs.get(i);
                if (mob != null && !mob.isDie && mob.status != 0 && Math.abs(mob.pointx - charz.cx) <= skillFight.dx && Math.abs(mob.pointy - charz.cy) <= skillFight.dy) {
                    mobs.add(mob);
                }
            }
        }
    }
    
    public void setCharSkill(Char charz, Skill skillFight, ArrayList<Char> chars) {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && Math.abs(player.cx - charz.cx) < skillFight.dx && Math.abs(player.cy - charz.cy) < skillFight.dy && charz.isMeCanAttackOtherPlayer(player)) {
                    chars.add(player);
                }
            }
        }
    }
    
    public void set_Pos(int charId, int x, int y, int b) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.setPos(charId, x, y, b);
                }
            }
        }
    }
    
    public void holdChar(int effID, int holdEffID, int charId1, int charId2, int charId3) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.holdChar(effID, holdEffID, charId1, charId2, charId3);
                }
            }
        }
    }
    
    public void holdMob(int effID, int holdEffID, int mobId, int playerId) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.holdMob(effID, holdEffID, mobId, playerId);
                }
            }
        }
    }
    
    public Mob getMobIdHold(int charId) {
        synchronized(this.mobs) {
            int i;
            for (i = 0; i < this.mobs.size(); i++) {
                Mob mob = this.mobs.get(i);
                if (mob != null && mob.holder_charId == charId) {
                    return mob;
                }
            }
        }
        return null;
    }
    
    public Char getCharIdHold(int charId) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.holder_charId == charId) {
                    return player;
                }
            }
        }
        return null;
    }
    
    public void addMobMe(Mob mob) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.addMobMe(mob.mobId, mob.templateId, mob.hp);
                }
            }
        }
    }
    
    public void addNewBoss(NewBoss newBoss) {
        synchronized(this.mobs) {
            newBoss.zone = this;
            newBoss.live(0, 0, -1);
            this.mobs.add(newBoss);
        }
        this.loadMobID();
        this.allMapInfo();
    }
    
    public void allMapInfo() {
        Char array[];
        synchronized(this.players) {
            array = new Char[this.players.size()];
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    array[i] = this.players.get(i);
                }
            }
        }
        int num = 0;
        while(num < array.length) {
            if (array[num] != null) this.mapInfo(array[num], 0);
            num++;
        }
    }
    
    public void removeMob1(int idMob) {
        synchronized(this.mobs) {
            this.mobs.remove(idMob);
        }
    }
    
    public void removeMob2(Mob mob) {
        synchronized(this.mobs) {
            this.mobs.remove(mob);
        }
    }
    
    public void claerMobMe(int charId) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.clearMobMe(charId);
                }
            }
        }
    }
    
    public void mobMeAttackMob(int charId, int mobId) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.mobMeAttackMob(charId, mobId);
                }
            }
        }
    }
    
    public void mobMeAttackPlayer(int charId, int playerId, int dam, int cHPNew) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.mobMeAttackPlayer(charId, playerId, dam, cHPNew);
                }
            }
        }
    }
    
    public void changeMobBody(int type, int mobIndex, int id) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.changeMobBody(type, mobIndex, id);
                }
            }
        }
    }
    
    public int getXChienThuyen(int x, int y) {
        int k = 0;
        while (k < 100000) {
            int x2 = Util.gI().nextInt(70, this.mapTemplate.pxw - 70);
            int y2 = y;
            if (this.mapTemplate.isTouchY(x2, y2)) {
                return x2;
            }
            k++;
        }
        return x;
    }
    
    public void itemMapAdd(ItemMap itMap) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.itemMapAdd(itMap);
                }
            }
        }
    }
    
    public boolean isHaveNpc(int npcTemplateId) {
        synchronized (this.npcs) {
            for (int i = 0; i < this.npcs.size(); i++) {
                if (this.npcs.get(i).template.npcTemplateId == npcTemplateId) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public ItemMap getSatellite(Char charz) {
        int i;
        ItemMap itemM = null;
        ItemMap itM;
        synchronized (this.itemMaps) {
            for (i = 0; i < this.itemMaps.size(); i++) {
                itM = this.itemMaps.get(i);
                if (itM.item != null && itM.item.template.type == 22 && itM.charId == charz.charID && Math.abs(itM.x - charz.cx) < 200 && Math.abs(itM.y - charz.cy) < 200) {
                    itemM = itM;
                    break;
                }
            }
        }
        return itemM;
    }
    
    public void dirtyDownHP(Char charz, int num) {
        int i;
        charz.aCharFocus.clear();
        charz.aMobFocus.clear();
        //Find player
        synchronized(this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.charID != charz.charID && !player.isDie && player.cHP > 1 && !player.isTemplate && Math.abs(player.cx - charz.cx) <= 200 && Math.abs(player.cy - charz.cy) <= 200) {
                    charz.aCharFocus.add(player);
                }
            }
        }
        for (i  = 0; i < charz.aCharFocus.size(); i++) {
            Char player = charz.aCharFocus.get(i);
            if (!player.isDie && player.cHP > 1) {
                int downHp = (int)((long)player.cHPFull * (long)(num) / 100l);
                if (downHp > 0) {
                    player.upHP(-downHp);
                    if (player.cHP < 1 && !player.isDie) {
                        player.cHP = 1;
                    }
                    if (player.session != null) {
                        player.session.service.meLoadHP(player.cHP);
                    }
                    this.playerLoadHP(player, -1);
                }
                if (Util.gI().nextInt(100) <= 25) {
                    this.chat(player, mResources.OI_HOI_QUA);
                } else if (Util.gI().nextInt(100) <= 25) {
                    this.chat(player, mResources.BIEN_DI);
                } else if (Util.gI().nextInt(100) <= 25) {
                    this.chat(player, mResources.HOI_QUA_TRANH_XA_RA);
                } else {
                    this.chat(player, mResources.THUI_QUA);
                }
            }
        }
    }
    
    public int getCountPLayerNotAI() {
        int i;
        Char player;
        int count = 0;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.me && !player.isTemplate) {
                    count = count + 1;
                }
            }
        }
        return count;
    }
    
    public Char getPLayerNotAI() {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).me && !this.players.get(i).isTemplate) {
                    return this.players.get(i);
                }
            }
            return null;
        }
    }
    
    public void getBag(Char charz) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.getBag(charz.charID, charz.bag);
                }
            }
        }
    }
    
    public void updateTypePk(int charId, int typePk) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.updateTypePK(charId, typePk);
                }
            }
        }
    }
    
    public Char findBossInMapById(int id) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).isTemplate && this.players.get(i).cTemplateId == id) {
                    return this.players.get(i);
                }
            }
            return null;
        }
    }
    
    public boolean isHaveBoss(int id) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.isTemplate && player.cTemplateId == id) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int getDameNice(Char charz) {
        int i ;
        Char player;
        Char o = null;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && !player.isTemplate && player.charID != charz.charID && player.isTBNice && Math.abs(charz.cx - player.cx) < 200 && Math.abs(charz.cy - player.cy) < 200 && (o == null || o.niceDamsend_percent < player.niceDamsend_percent)) {
                    o = player;
                }
            }
        }
        if (o == null) {
            return 0;
        }
        return o.niceDamsend_percent;
    }
    
    public int getDownDamge(Char player) {
        synchronized (this.players) {
            Char temp = null;
            for (int i = 0; i < this.players.size(); i++) {
                if (!this.players.get(i).isTemplate && this.players.get(i).charID != player.charID && this.players.get(i).isSetNgayHe && Math.abs(player.cx - this.players.get(i).cx) < 200 && Math.abs(player.cy - this.players.get(i).cy) < 200 && (temp == null || temp.sendDownDamagePercent < this.players.get(i).sendDownDamagePercent)) {
                    temp = this.players.get(i);
                }
            }
            if (temp == null) {
                return 0;
            }
            return temp.sendDownDamagePercent;
        }
    }
    
    public int getHutHPKI(Char charz) {
        int total = 0;
        int num;
        int i;
        Char player;
        Mob mob;
        charz.aCharFocus.clear();
        charz.aMobFocus.clear();
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.charID != charz.charID && !player.isDie && player.cHP > 1 && player.timeDownHutHPKI5 == 0 && !player.isTemplate && Math.abs(charz.cx - player.cx) < 150 && Math.abs(charz.cy - player.cy) < 150) {
                    charz.aCharFocus.add(player);
                    player.timeDownHutHPKI5 = 10000;
                }
            }
        }
        synchronized (this.mobs) {
            for (i = 0; i < this.mobs.size(); i++) {
                mob = this.mobs.get(i);
                if (mob != null && !mob.isDie && mob.hp > 1 && mob.timeDownHutHPKI5 == 0 && !mob.isMobMe && Math.abs(charz.cx - mob.pointx) < 150 && Math.abs(charz.cy - mob.pointy) < 150) {
                    charz.aMobFocus.add(mob);
                    mob.timeDownHutHPKI5 = 10000;
                }
            }
        }
        for (i = 0; i < charz.aCharFocus.size(); i++) {
            player = charz.aCharFocus.get(i);
            if (!player.isDie && player.cHP > 1) {
                num = (int) ((int)player.cHPFull * (long)charz.HutHPKI5_percent / 100l);
                if (player.cHP - num  < 1) {
                    num = player.cHP - 1;
                }
                player.upHP(-num);
                total = total + num;
                
                num = (int) ((int)player.cMPFull * (long)charz.HutHPKI5_percent / 100l);
                if (player.cMP - num  < 1) {
                    num = player.cMP - 1;
                }
                player.upMP(-num);
                total = total + num;
                if (player.session != null) {
                    player.session.service.meLoadHP(player.cHP);
                    player.session.service.meLoadMP(player.cMP);
                }
                this.playerLoadHP(player, -1);
            }
        }
        for (i = 0; i < charz.aMobFocus.size(); i++) {
            mob = charz.aMobFocus.get(i);
            if (!mob.isDie && mob.hp > 1) {
                num = (int) ((int)mob.maxHp * (long)charz.HutHPKI5_percent / 100l);
                if (mob.hp - num < 1) {
                    num = mob.hp - 1;
                }
                mob.hp -= num;
                total = total + num;
                this.mobHP(mob.mobId, mob.hp, num, false, -1);
            }
        }
        return total;
    }
    
    public int getDownSpeedPercent(Char charz) {
        int i ;
        Char player;
        Char o = null;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && !player.isDie && player.charID != charz.charID && player.isDownSpeed && Math.abs(charz.cx - player.cx) < 200 && Math.abs(charz.cy - player.cy) < 200 && (o == null || o.downSpeed_percent < player.downSpeedSend_percent)) {
                    o = player;
                }
            }
        }
        if (o == null) {
            return 0;
        }
        return o.downSpeedSend_percent;
    }
    
    public Char getPlayerFirst() {
        Char p = null;
        int i;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null) {
                    p = player;
                    break;
                }
            }
        }
        return p;
    }
    
    public int sizeItemMap() {
        int count;
        synchronized (this.itemMaps) {
            count = this.itemMaps.size();
        }
        return count;
    }
    
    public Char getPlayerFirstClan(Char charz) {
        Char p = null;
        int i;
        Char player;
        if (charz.clan != null) {
            synchronized (this.players) {
                for (i = 0; i < this.players.size(); i++) {
                    player = this.players.get(i);
                    if (player != null && player.clan != null && player.clan.ID == charz.clan.ID) {
                        p = player;
                        break;
                    }
                }
            }
        }
        return p;
    }
    
    public void updateBlackFlag(Char charz) {
        int flag = Flag.get(371).id;
        Char player;
        charz.changeFlag(flag);
        if (charz.myPet != null) {
            charz.myPetz().changeFlag(flag);
        }
        charz.aCharFocus.clear();
        if (charz.clan != null) {
            synchronized (this.players) {
                for (int i = 0; i < this.players.size(); i++) {
                    player = this.players.get(i);
                    if (player != null && player.clan != null && player.clan.ID == charz.clan.ID) {
                        charz.aCharFocus.add(player);
                    }
                }
            }
        }
        for (int i = 0; i < charz.aCharFocus.size(); i++) {
            player = charz.aCharFocus.get(i);
            player.changeFlag(flag);
            if (player.myPet != null) {
                player.myPetz().changeFlag(flag);
            }
        }
    }
    
    public void pushPlayers(int typeTeleport) {
        int i;
        Char player;
        Char[] pls;
        Map m;
        ZoneMap zone;
        synchronized (this.players) {
            pls = new Char[this.players.size()];
            for (i = 0; i < this.players.size(); i++) {
                if (!this.players.get(i).isTemplate || this.players.get(i).cTemplateType == 8) {
                    pls[i] = this.players.get(i);
                } else {
                    this.players.get(i).isClear = true;
                }
            }
        }
        for (i = 0; i < pls.length; i++) {
            player = pls[i];
            m = null;
            if (player != null && !player.isDie) {
                if (player.cgender == 0) {
                    m = Map.getMapServer(24);
                }
                if (player.cgender == 1) {
                    m = Map.getMapServer(25);
                }
                if (player.cgender == 2) {
                    m = Map.getMapServer(26);
                }
                if (m != null) {
                    zone = m.getZone(player);
                    if (zone == null) {
                        zone = player.getMapOffline(player.mainHome()).getZone(player);
                    }
                    if (zone != null) {
                        if (typeTeleport != 0) {
                            this.exit(player, player.typeTeleport);
                            zone.join(player, player.typeTeleport, 350, 5);
                        } else {
                            this.exit(player, 0);
                            zone.join(player, 0, 444, 336);
                        }
                    }
                }
            } else if (player != null) {
                if (player.cgender == 0) {
                    m = player.getMapOffline(21);
                }
                if (player.cgender == 1) {
                    m = player.getMapOffline(22);
                }
                if (player.cgender == 2) {
                    m = player.getMapOffline(23);
                }
                if (m != null) {
                    zone = m.getZone(player);
                    if (typeTeleport != 0) {
                        this.exit(player, player.typeTeleport);
                        zone.join(player, player.typeTeleport, 350, 5);
                    } else {
                        this.exit(player, 0);
                        zone.join(player, 0, 444, 336);
                    }
                    player.liveFromDead(2);
                }
           }
        }
    }
    
    public void resetItemBlackBall() {
        Item it;
        int i;
        ItemOption op;
        synchronized (this.itemMaps) {
            for (i = 0; i < this.itemMaps.size(); i++) {
                it = this.itemMaps.get(i).item;
                if (it.isItemBlackBall()) {
                    op = it.getOption(93);
                    if (op !=  null) {
                        op.param = 2;
                    } else {
                        it.options.add(new ItemOption(93, 2));
                    }
                    it.isExpires = true;
                    it.setExpires(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 2));
                }
            }
        }
    }
    
    public void initMob() {
        int i;
        Mob mob;
        int setHP;
        int levelBoss;
        int numSQ = 0;
        for (i = 0; i < this.mobs.size(); i++) {
            mob = this.mobs.get(i);
            setHP = -1;
            levelBoss = 0;
            //Khi ga
            if (this.map.destronGas != null) {
                mob.defull_percent = 50;
                if (numSQ < 2 && mob.templateId != 76) {
                    levelBoss = numSQ == 0 ? 1 : 2;
                    numSQ++;
                }
                int c = this.map.destronGas.level / 10;
                if (c < 1) {
                    c = 1;
                }
                setHP = Mob.arrMobTemplate[mob.templateId].hp * this.map.destronGas.level * c;
            }
            //Ban do kho bau
            if (this.map.khobau != null) {
                mob.defull_percent = 50;
                if (i > 0 && i % 5 == 0 && mob.templateId != 71 && mob.templateId != 72) {
                    levelBoss = 3;
                }
                int c = this.map.khobau.level / 10;
                if (c < 1) {
                    c = 1;
                }
                setHP = Mob.arrMobTemplate[mob.templateId].hp * this.map.khobau.level * c;
            }
            mob.live(Util.gI().nextInt(3), levelBoss, setHP);
        }
    }
    
    public Char getPlayerNotPetz() {
        int i ;
        Char o = null;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                if (!this.players.get(i).isTemplate && this.players.get(i).me && this.players.get(i).myPet == null) {
                    o = this.players.get(i);
                    break;
                }
            }
        }
        return o;
    }
    
    public void updateTiemNangClan(Char charz, long tiemnang) {
        int i;
        Char[] arrChar;
        long tiemNangNew;
        synchronized (this.players) {
            arrChar = new Char[this.players.size()];
            for (i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).charID != charz.charID && this.players.get(i).clan != null && this.players.get(i).clan.ID == charz.clan.ID) {
                    arrChar[i] = this.players.get(i);
                }
            }
        }
        for (i = 0; i < arrChar.length; i++) {
            if (arrChar[i] != null) {
                if (arrChar[i].clevel != charz.clevel) {
                    tiemNangNew = tiemnang / (Math.abs(arrChar[i].clevel - charz.clevel) + 1);
                } else {
                    tiemNangNew = tiemnang * 8L / 10L;
                }
                if (arrChar[i].cPower >= 40000000000L) {
                    tiemNangNew = (tiemNangNew * 10L / 100L);
                }
                if (arrChar[i].cPower < Char.getPowerLimit(arrChar[i].cPowerLimit)) {
                    arrChar[i].updateEXP(1, tiemNangNew);
                }
            }
        }
    }
    
    public Player getBossPlayer(int playerId) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).isTemplate) {
                    Player o2 = (Player) this.players.get(i);
                    if (o2.isPlayerId != -1 && o2.isPlayerId == playerId) {
                        return o2;
                    }
                }
            }
        }
        return null;
    }
    
    public Player getBossChar(int charId) {
        Player o = null;
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).isTemplate) {
                    Player o2 = (Player) this.players.get(i);
                    if (o2.isCharId != -1 && o2.isCharId == charId) {
                        o = o2;
                        break;
                    }
                }
            }
        }
        return o;
    }
    
    public Char findCharInMap2(int playerId) {
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.playerId == playerId) {
                    return player;
                }
            }
        }
        return null;
    }
    
    public int getCountVeTinh() {
        int i;
        Item it;
        int count = 0;
        synchronized (this.itemMaps) {
            for (i = 0; i < this.itemMaps.size(); i++) {
                it = this.itemMaps.get(i).item;
                if (it.template.type == 22) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public Player getMabu(Char charz) {
        int i;
        synchronized(this.players) {
            for (i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).isTemplate) {
                    Player player = (Player) this.players.get(i);
                    if (player.charTemplate.type == 9 && Math.abs(player.cx - charz.cx) <= 100) {
                        return player;
                    }
                }
            }
        }
        return null;
    }
    
    public void petFollow(int charId, int smallID, int fimg, int[] frameNew, int wimng, int himg) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.petFollow(charId, smallID, fimg, frameNew, wimng, himg);
                }
            }
        }
    }
    
    public void clearPetFollow(int charId) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.clearPetFollow(charId);
                }
            }
        }
    }
    
    public Char getPlayerClosest(Char charz) {
        Char playerClosest = null;
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && !player.isDie && (!charz.isTemplate || !player.isTemplate) && charz.charID != player.charID && charz.isMeCanAttackOtherPlayer(player) && (!player.isInvisible || charz.isAtt(player.charID))) {
                    if (playerClosest == null || (Math.abs(charz.cx - player.cx) <= Math.abs(charz.cx - playerClosest.cx) && Math.abs(charz.cy - player.cy) <= Math.abs(charz.cy - playerClosest.cy))) {
                        playerClosest = player;
                    }
                }
            }
        }
        return playerClosest;
    }
    
    public Mob getMobClosest(Char charz) {
        int i ;
        Mob mobClosest = null;
        synchronized (this.mobs) {
            for (i = 0; i < this.mobs.size(); i++) {
                Mob mob = this.mobs.get(i);
                if (!mob.isDie && mob.status != 0 && mob.status != 1) {
                    if (mobClosest == null || (Math.abs(charz.cx - mob.pointx) <= Math.abs(charz.cx - mobClosest.pointx) && Math.abs(charz.cy - mob.pointy) <= Math.abs(charz.cy - mobClosest.pointy))) {
                        mobClosest = mob;
                    }
                }
            }
        }
        return mobClosest;
    }
    
    public boolean isBaoVe(Char charz) {
        synchronized(this.mobs) {
            int i;
            for (i = 0; i < this.mobs.size(); i++) {
                Mob mob = this.mobs.get(i);
                if (mob != null && !mob.isDie && mob.status != 0 && mob.status != 1) {
                    if (charz.cTemplateType == 12 && mob.templateId == 22) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public int getCountPlayerInClan(Char charz) {
        int i ;
        int n = 0;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.clan != null && player.clan.ID == charz.clan.ID && player.charID != charz.charID) {
                    n++;
                }
            }
        }
        return n;
    }
    
    public boolean isHaveDisperse(Char charz) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && !player.isTemplate && player.charID != charz.charID && player.isSendDisperse && Math.abs(charz.cx - player.cx) < 200 && Math.abs(charz.cy - player.cy) < 200) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isHaveWorr(Char charz) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && !player.isTemplate && player.charID != charz.charID && player.isTBZenitsu && Math.abs(charz.cx - player.cx) < 200 && Math.abs(charz.cy - player.cy) < 200) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isHaveCazy(Char charz) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && !player.isTemplate && player.charID != charz.charID && player.isTBNezuko && Math.abs(charz.cx - player.cx) < 200 && Math.abs(charz.cy - player.cy) < 200) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int countBoss(int type) {
        int count = 0;
        synchronized(this.players) {
            int i;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && !player.isDie && player.isTemplate && player.cTemplateType == type) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bigBossMove(int x, int y) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBossMove(x, y);
                }
            }
        }
    }
    
    public void bigBossMove() {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBossMove();
                }
            }
        }
    }
    
    public void bigBossFly(int x, int y) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBossFly(x, y);
                }
            }
        }
    }
    
    public void bigBossAttack(int type, ArrayList<Integer> ch, ArrayList<Integer> dam) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBossAttack(type, ch, dam);
                }
            }
        }
    }
    
    public void bigBossAttack() {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBossAttack();
                }
            }
        }
    }
    
    public void bigBosshaftBody() {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBosshaftBody();
                }
            }
        }
    }
    
    public void bigBossB2(int x, int y) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBossB2(x, y);
                }
            }
        }
    }
    
    public void bigBoss() {
        int i;
        synchronized (this.mobs) {
            for (i = 0; i < this.mobs.size(); i++) {
                if (this.mobs.get(i).templateId == 70) {
                    this.mobs.get(i).sys = -1;
                    this.mobs.get(i).isDie = true;
                    this.mobs.get(i).status = 0;
                    this.mobs.get(i).milisecondLive = System.currentTimeMillis();
                }
            }
        }
    }
    
    public void npcChat(int id, String chat) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.npcChat(id, chat);
                }
            }
        }
    }
    
    public int getSonCount(int charId) {
        int i;
        int count = 0;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.dabId != -1 && player.dabId == charId) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void hideNpc(int npcTemplateId, boolean is) {
        Npc npc = this.findNPCInMap(npcTemplateId);
        if (npc != null) {
            npc.isHide = is;
            int i;
            synchronized (this.players) {
                for (i = 0; i < this.players.size(); i++) {
                    Char player = this.players.get(i);
                    if (player != null && player.session != null) {
                        player.session.service.hideNpc(npcTemplateId, npc.isHide ? 0 : 1);
                    }
                }
            }
        }
    }
    
    public boolean isCloestNpcById(int templateId, int x, int y) {
        Npc npc = this.findNPCInMap(templateId);
        if (npc != null) {
            return Math.abs(npc.cx - x) < 70 && Math.abs(npc.cy - y) < 50;
        } else {
            return false;
        }
    }
    
    public int countPlayerNotDie() {
        int i ;
        int count = 0;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.me && !player.isDie && !player.isTemplate) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void cloneByChar(Char charz) {
        int i;
        Char[] arrPlayer;
        synchronized (this.players) {
            arrPlayer = new Char[this.players.size()];
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (!player.isTemplate && player.cloneByChar == null && charz.isMeCanAttackOtherPlayer(player)) {
                    arrPlayer[i] = player;
                    break;
                }
            }
        }
        for (i = 0; i < arrPlayer.length; i++) {
            if (arrPlayer[i] != null) {
                if (arrPlayer[i].session != null) {
                    arrPlayer[i].session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_BIEN, charz.cName), null, 0);
                }
                arrPlayer[i].cloneByChar = charz;
                charz.zoneMap.playerLoadAll(arrPlayer[i]);
            }
        }
    }
    
    public void setTimeHatch(int sc) {
        this.isEgg = sc != -1;
        this.setTimehatch = sc * 1000;
        this.timeHatch =  0;
    }
    
    public void tMabu(int percentMabu) {
        int i ;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.tMabu(percentMabu);
                }
            }
        }
    }
    
    public void setPlayerToHome(int sc) {
        int i ;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.me && !player.isTemplate) {
                    player.setToHome(sc);
                }
            }
        }
    }
    
    public void setFusion(int fusion, int charId) {
        int i ;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.setFusion(fusion, charId);
                }
            }
        }
    }
    
    public long totalHPMob(int x, int y, int dx, int dy) {
        int i;
        long num = 0;
        synchronized (this.mobs) {
            for (i = 0; i < this.mobs.size(); i++) {
                Mob mob = this.mobs.get(i);
                if (mob != null && !mob.isDie && mob.status != 0 && Math.abs(mob.pointx - x) <= dx && Math.abs(mob.pointy - y) <= dy) {
                    num = num + mob.hp;
                }
            }
        }
        return num;
    }
    
    public long totalHpChar(int x, int y, int dx, int dy, int charId) {
        int i;
        long num = 0;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && !player.isDie && !player.isTemplate && player.charID != charId && Math.abs(player.cx - x) <= dx && Math.abs(player.cy - y) <= dy) {
                    num = num + player.cHP;
                }
            }
        }
        return num;
    }
    
    public void eat(int charId, int playerId) {
        int i ;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.eat(charId, playerId);
                }
            }
        }
    }
    
    public void drop() {
        int i;
        Char[] arrChar;
        synchronized (this.players) {
            arrChar = new Char[this.players.size()];
            for (i = 0; i < this.players.size(); i++) {
                arrChar[i] = this.players.get(i);
            }
        }
        for (i = 0; i < arrChar.length; i++) {
            Char player = arrChar[i];
            if (player != null && !player.isTemplate) {
                if (this.map.owner != null) {
                    player.zoneMap.exit(player, 0);
                    this.map.owner.zoneMap.join(player, 0, this.map.owner.cx, this.map.owner.cy);
                }
            }
        }
    }
    
    public void initBelly() {
        if (!this.isHaveBoss(91)) {
            Player boss = Player.addBoss(91, 5, -1, -1, true, 300, 150, this, -1, -1);
            boss.timeHit = 5000;
        }
    }
    
    public void setMabuHold(boolean m, int charID, int cx, int cy) {
        int i ;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.setMabuHold(m, charID, cx, cy);
                }
            }
        }
    }
    
    public void setCocoon(int charID, boolean o) {
        int i;
        if (o) {
            Char player = this.findCharInMap(charID);
            if (player == null) {
                return;
            }
            int k = -1;
            synchronized (this.arrCocoon) { 
                for (i = 0; i < this.arrCocoon.length; i++) {
                    if (this.arrCocoon[i] == null) {
                        this.arrCocoon[k = i] = player;
                        break;
                    }
                }
            }
            if (k != -1) {
                player.setMabuHold(true, this.arrCocoonPoint[k][0], this.arrCocoonPoint[k][1]);
                player.tachNhapThe();
            }
        } else {
            Char player = null;
            synchronized (this.arrCocoon) {
                for (i = 0; i < this.arrCocoon.length; i++) {
                    if (this.arrCocoon[i] != null && this.arrCocoon[i].charID == charID) {
                        player = this.arrCocoon[i];
                        this.arrCocoon[i] = null;
                    }
                }
            }
            if (player == null) {
                player = this.findCharInMap(charID);
            }
            if (player != null) {
                player.setMabuHold(false, player.cx, player.cy);
            }
        }
    }
    
    public void suckC() {
        int i;
        Char[] array;
        synchronized (this.players) { 
            array = new Char[this.players.size()];
            for (i = 0; i < this.players.size(); i++) {
                array[i] = this.players.get(i);
            }
        }
        for (i = 0; i < array.length; i++) {
            Char player = array[i];
            if (player != null && !player.isDie && player.isMabuHold) {
                int m = player.cHPFull / 60;
                if (m <= 0) {
                    m = 1;
                }
                player.haveAttackPLayer(null, 1, m, false, -1, false);
                if (player.session != null) {
                    player.session.service.meLoadHP(player.cHP);
                }
                this.playerLoadHP(player, -1);
            }
        }
    }
    
    public Char randPlayer() {
        int i;
        Char[] array;
        synchronized(this.players) {
            int n = 0;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.me && !player.isDie && !player.isTemplate) {
                    n++;
                }
            }
            array = new Char[n];
            n = 0;
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player != null && player.me && !player.isDie && !player.isTemplate) {
                    array[n++] = player;
                }
            }
        }
        if (array.length > 0) {
            return array[Util.gI().nextInt(array.length)];
        }
        return null;
    }
    
    public void helpMe() {
        int i;
        Char[] array;
        synchronized(this.players) {
            array = new Char[this.players.size()];
            for (i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).isMabuHold) {
                    array[i] = this.players.get(i);
                }
            }
        }
        for (i = 0; i < array.length; i++) {
            if (array[i] != null) {
                this.chat(array[i], mResources.CUU_TOI_VOI);
            }
        }
    }
    
    public void addPlayerAtt(ArrayList<Char> aChar, Char charz) {
        int i;
        synchronized(this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (charz.isMeCanAttackOtherPlayer(player)) {
                    aChar.add(player);
                }
            }
        }
    }
    
    public void setSkill(int charId, int skillID, int x, int y, int[] array, int[] array2) {
        int i ;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.setSkill(charId, skillID, x, y, array, array2);
                }
            }
        }
    }
    
    public void addEffectServer(int loop, int layer, int id, int x, int y, int loopCount) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.addEffectServer(loop, layer, id, x, y, loopCount);
                }
            }
        }
    }
    
    public void addEffectChar(int playerId, int id, int layer, int loop, int loopCount, int isStand) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.addEffectChar(playerId, id, layer, loop, loopCount, isStand);
                }
            }
        }
    }
    
    public void removeEffChar(int playerId, int id) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.removeEffChar(playerId, id);
                }
            }
        }
    }
    
    public void removeEffCharAll(int playerId) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.removeEffCharAll(playerId);
                }
            }
        }
    }
    
    public void bigBoss2Move(int x, int y) {
        int i ;
        Char player;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                player = this.players.get(i);
                if (player != null && player.session != null) {
                    player.session.service.bigBossMove(x, y);
                }
            }
        }
    }
    
    public void bigBoss2haftBody() {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bigBoss2haftBody();
                }
            }
        }
    }
    
    public void bachtuochaftBody() {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bachtuochaftBody();
                }
            }
        }
    }
    
    public void bigBoss2Cut(int[] array, int[] array2) {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bigBoss2Cut(array, array2);
                }
            }
        }
    }
    
    public void bigBoss2Away(int[] array, int[] array2) {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bigBoss2Away(array, array2);
                }
            }
        }
    }
    
    public void bigBoss2Fly(int[] array, int[] array2) {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bigBoss2Fly(array, array2);
                }
            }
        }
    }
    
    public void bachtuocRock(int[] array, int[] array2) {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bachtuocRock(array, array2);
                }
            }
        }
    }
    
    public void bachtuocAway(int[] array, int[] array2) {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bachtuocAway(array, array2);
                }
            }
        }
    }
    
    public void bachtuocMove(int x) {
        int i;
        synchronized (this.players) {
            for (i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.bachtuocMove(x);
                }
            }
        }
    }
    
    public void addPhaoHoa(int num, int x, int y, byte type) {
        PhaoHoa p = new PhaoHoa(this, num, (short)x, (short)y, type);
        synchronized (this.phaohoas) {
            this.phaohoas.add(p);
        }
    }
    
    public void reomvePhaoHoa(PhaoHoa p) {
        synchronized (this.phaohoas) {
            this.phaohoas.remove(p);
        }
    }
    
    public void loadMob(Char charz, ArrayList<Mob> aMob) {
        synchronized (this.mobs) {
            for (int i = 0; i < this.mobs.size(); i++) {
                aMob.add(this.mobs.get(i));
            }
        }
    }
    
    public void loadChar(Char charz, ArrayList aChar) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (charz.isMeCanAttackOtherPlayer(this.players.get(i))) {
                    aChar.add(this.players.get(i));
                }
            }
        }
    }
    
//    public int countBoss() {
//        int num = 0;
//        synchronized (this.players) {
//            for (int i = 0; i < this.players.size(); i++) {
//                Char player = this.players.get(i);
//                if (player.isTemplate && !player.isDie && player.cTemplateType != 8) {
//                    num++;
//                }
//            }
//        }
//        return num;
//    }
    
    public int countBossById(int id) {
        int num = 0;
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.isTemplate && !player.isDie && player.cTemplateType != 8 && player.cTemplateId == id) {
                    num++;
                }
            }
        }
        return num;
    }
    
    public void dropYard() {
        if (this.map.isMapCace23()) {
            Char[] array;
            synchronized (this.players) {
                array = new Char[this.players.size()];
                for (int i1 = 0; i1 < this.players.size(); i1++) {
                    array[i1] = this.players.get(i1);
                }
            }
            for (int i2 = 0; i2 < array.length;) {
                if (!array[i2].isTemplate && array[i2].cy < 300) {
                    if (array[i2].isDie) {
                        array[i2].liveFromDead(2);
                    }
                    array[i2].cx = 380;
                    array[i2].cy = 360;
                    if (array[i2].session != null) {
                        array[i2].session.service.resetPont(array[i2].cx, array[i2].cy);
                    }
                    this.playerMove(array[i2].charID, array[i2].cx, array[i2].cy);
                }
                i2++;
            }
        }
    }
    
    public int memberClanCount(int charId, int clanId, int x, int y, int dx, int dy) {
        int num = 0;
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.charID != charId && player.clan != null && player.clan.ID == clanId && Math.abs(x - player.cx) <= dx && Math.abs(y - player.cy) <= dy) {
                    num++;
                }
            }
        }
        return num;
    }
    
    public void playerThrow(int charID, int itemMapID, int itemTemplateId, int xEnd, int yEnd) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).charID != charID && this.players.get(i).session != null) {
                    this.players.get(i).session.service.playerThrow(charID, itemMapID, itemTemplateId, xEnd, yEnd);
                }
            }
        }
    }
    
    public Player getBossByType(int x, int type) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).isTemplate) {
                    Player player = (Player) this.players.get(i);
                    if (player.charTemplate.type == type && Math.abs(player.cx - x) <= 100) {
                        return player;
                    }
                }
            }
        }
        return null;
    }
    
    public void addNpc(int npcId, int status, int x, int y, int templateId, int avatar) {
        synchronized (this.npcs) {
            Npc npc = new Npc(npcId, status, x, y, templateId, avatar);
            this.npcs.add(npc);
        }
    }
    
    public void removeNpc(int templateId) {
        synchronized (this.npcs) {
            int num = 0;
            while(num < this.npcs.size()) {
                if (this.npcs.get(num).template.npcTemplateId == templateId) {
                    this.npcs.remove(num);
                    return;
                }
                num++;
            }
        }
    }
    
    public void newBossMoveTo(int idBoss, int xTo, int yTo) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.newBossMoveTo(idBoss, xTo, yTo);
                }
            }
        }
    }
    
    public void newBossFlyTo(int idBoss, int xTo, int yTo) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.newBossFlyTo(idBoss, xTo, yTo);
                }
            }
        }
    }
    
    public void newBossSetAttack(int type, int idBoss, ArrayList<Char> ch, ArrayList<Integer> dam, int dir) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.newBossSetAttack(type, idBoss, ch, dam, dir);
                }
            }
        }
    }
    
    public void newBossSetDie(int idBoss) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.newBossSetDie(idBoss);
                }
            }
        }
    }
    
    public void SetSkillPaint_NEW(int playerId, short idskillPaint, int isFly, int typeFrame, int typePaint, int dir, int timeGong, int typeItem) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.SetSkillPaint_NEW(playerId, idskillPaint, isFly, typeFrame, typePaint, dir, timeGong, typeItem);
                }
            }
        }
    }
    
    public void SetSkillPaint_STT(int playerId, short idskillPaint, Point targetDame, int timeDame, int rangeDame, int typePaint, ArrayList<Mob> list1, ArrayList<Char> list2, int typeItem) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.SetSkillPaint_STT(playerId, idskillPaint, targetDame, timeDame, rangeDame, typePaint, list1, list2, typeItem);
                }
            }
        }
    }
    
    public void steal(int playerId, int x, int y, int itemMapID, int templateId) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.steal(playerId, x, y, itemMapID, templateId);
                }
            }
        }
    }
    
    public boolean isHelp(Char player) {
        synchronized(this.helps) {
            if (this.helps.isEmpty()) return true;
            for (int i = 0; i < this.helps.size(); i++) {
                if (Server.gI().isSupport(player.ctaskId, player.ctaskIndex, this.helps.get(i).cTemplateId)) return true;
            }
            return false;
        }
    }
    
    public void addInfo(String text) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).addInfo1(text);
                }
            }
        }
    }
    
    public void addBinld(int time, int type) {
        Char array[];
        synchronized(this.players) {
            array = new Char[this.players.size()];
            for (int i = 0; i < this.players.size(); i++) {
                array[i] = this.players.get(i);
            }
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (type == 0) {
                if (!array[i].isTemplate) {
                    array[i].hold(1, time, 40, -1, -1);
                }
            } else {
                array[i].hold(1, time, 40, -1, -1);
            }
        }
    }
    
    public void addWarningBoom() {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).addInfo1(String.format(mResources.WARNING, this.players.get(i).cName));
                }
            }
        }
    }
    
    public void startGong(int playerId) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.startGong(playerId);
                }
            }
        }
    }
    
    public void endGong(int playerId) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.endGong(playerId);
                }
            }
        }
    }
    
    public void messageTime(int id, String text, int second) {
        synchronized(this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                if (this.players.get(i).session != null) {
                    this.players.get(i).session.service.messageTime(id, text, second);
                }
            }
        }
    }
    
    public void removeEffectServer(int id) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
//                    player.session.service.addEffectServer(loop, layer, id, x, y, loopCount);
                }
            }
        }
    }
    
    public void setEff(int playerId, int idAuraEff, int idEff_Set_Item) {
        synchronized (this.players) {
            for (int i = 0; i < this.players.size(); i++) {
                Char player = this.players.get(i);
                if (player.session != null) {
                    player.session.service.setEff(playerId, idAuraEff, idEff_Set_Item);
                }
            }
        }
    }
    
}
