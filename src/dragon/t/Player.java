package dragon.t;

import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author TGDD
 */
public class Player extends Char {
    
    private class thr extends Thread {
        
        @Override
        public void run() {
            while (isPlay) {
                long l = System.currentTimeMillis();
                update();
                try {
                    TimeUnit.MILLISECONDS.sleep(Server.SERVER_DELAY_MILISECOND);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
                delay = (int) (System.currentTimeMillis() - l);
            }
            clear();
        }
    }
    
    public static final ArrayList<Player> BOTS = new ArrayList<>();

    public CharTemplate charTemplate;
    public boolean isPlay;
    public Thread thr;
    public int pre_x;
    public int pre_y;
    public int pointX;
    public int pointY;
    public ArrayList<Item> itemBuys;
    public int maxItem;
    public int timeDownHPTransport = 1000;
    public int transport_speed;
    public int transport_level;
    public boolean isNoiKore;
    
    public void initBot() {
        isPlay = true;
        isClear = false;
        thr = new thr();
        thr.start();
    }
    
    @Override
    public void update() {
        super.update();
        Player bot;
        int i;
        if (super.zoneMap !=  null) { 
            //Di chuyen
            if (!super.isStand() && !super.isSuper && super.timeMove <= 0 && super.tCharge <= 0) {
                int x = Util.gI().nextInt(super.cx-100, super.cx+100);
                if (x > super.zoneMap.mapTemplate.pxw - 50) {
                    x = super.zoneMap.mapTemplate.pxw - 50;
                }
                if (x < 50) {
                    x = 50;
                }
                int y = super.zoneMap.mapTemplate.touchY(x, 150);
                if (this.charTemplate.type == 6 && Util.gI().nextInt(100) < 40 && (this.charFocus == null || this.charFocus.isDie ||  Math.abs(this.charFocus.cx - this.cx) > 150 || Math.abs(this.charFocus.cy - this.cy) > 70)) {
                    x = Util.gI().nextInt(this.pre_x - 70, this.pre_x + 70);
                    super.addMove(0, x, y, 0);
                }
                if (this.charTemplate.type == 12 && Util.gI().nextInt(100) < 30 && x > this.pre_x - 100 && x < this.pre_x + 100) {
                    super.addMove(0, x, y, 0);
                }
            }
            //Danh
            if (!super.isStand() && super.isAtt && !super.isSuper && (super.isSee || super.isNhinThay) && super.timeHit <= 0 && !super.gong && (super.cTypePk == 5 || this.cFlag != 0 || super.isChallenge)) {
                if (!super.isCharge) {
                    for (i = super.skills.size() - 1; i >= 0; --i) {
                        Skill skill = super.skills.get(i);
                        if (skill.template.id != 7 && skill.template.id != 10 && skill.template.id != 11 && skill.template.id != 14 && skill.template.id != 23) {
                            if (skill.lastTimeUseThisSkill < System.currentTimeMillis()) {
                                int manaUse = skill.manaUse;
                                if (skill.template.manaUseType == 1) {
                                    manaUse = (int)((long)super.cMPFull * (long)manaUse / 100);
                                }
                                if (super.cMP >= manaUse && (skill.template.id != 9 || (skill.template.id == 9 && 100f / (float)super.cHPFull * (float)super.cHP > 10))) {
                                    super.mySkill = skill;
                                    break;
                                }
                            }
                        }
                    }
                }
                super.updateAttk();
                Skill skillF = super.mySkill;
                if (skillF != null && skillF.lastTimeUseThisSkill <= System.currentTimeMillis()) {
                    switch (skillF.template.id) {
                        case 6:
                            super.zoneMap.chat(this, "Thái Dương Hạ San");
                            super.skill_not_focus((byte)0, skillF);
                            if (super.isBossMain && super.cTemplateId == 108) {
                                super.isAddClone = !super.isAddClone;
                                if (super.isAddClone) {
                                    super.addClone(108);
                                } else {
                                    super.clearClone();
                                }
                            }
                            break;
                        case 8:
                            super.skill_not_focus((byte)1, skillF);
                            super.chargeDamage = 5;
                            super.tCharge = 10000;
                            break;
                        case 12:
                            super.skill_not_focus((byte)8, skillF);
                            break;
                        case 13:
                            super.skill_not_focus((byte)6, skillF);
                            break;
                        case 19:
                            super.skill_not_focus((byte)9, skillF);
                            break;
                        case 21:
                            super.skill_not_focus((byte)10, skillF);
                            break;
                        default:
                            super.aCharFocus.clear();
                            Char pclosest = null;
                            synchronized (super.zoneMap.players) {
                                for (i = 0; i < super.zoneMap.players.size(); i++) {
                                    Char player = super.zoneMap.players.get(i);
                                    if (this.charTemplate.type != 6 || (Math.abs(this.cx - player.cx) < 100 && Math.abs(this.cy - player.cy) < 70)) {
                                        if ((!player.isTemplate || (super.cTemplateType == 44 && player.cTemplateType == 44)) && !player.isInvisiblez && player.timeReady <= 0 && !player.isMabuHold && super.isMeCanAttackOtherPlayer(player) && ((!player.isInvisible && super.strike != 0) || super.isAtt(player.charID))) {
                                            if (skillF.maxFight == 1) {
                                                if (pclosest == null || (Math.abs(player.cx - super.cx) <= Math.abs(pclosest.cx - super.cx) && Math.abs(player.cy - super.cy) <= Math.abs(pclosest.cy - super.cy))) {
                                                    pclosest = player;
                                                }
                                            } else {
                                                super.aCharFocus.add(player);
                                            }
                                        }
                                        if (skillF.maxFight <= super.aCharFocus.size()) {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (super.cTemplateId == 84 && super.zoneMap.isHaveBoss(85)) {
                                super.aCharFocus.add(super.findBossInMapById(85));
                            } else if (super.cTemplateId == 85 && super.zoneMap.isHaveBoss(84)) {
                                super.aCharFocus.add(super.findBossInMapById(84));
                            } else if (pclosest != null && skillF.maxFight == 1) {
                                super.aCharFocus.add(pclosest);
                            }
                            if (!super.aCharFocus.isEmpty()) {
                                if ((this.charTemplate.id != 42 || (this.charTemplate.id == 42 && super.isBossMain && Util.gI().nextInt(100) < 20) || (this.charTemplate.id == 42 && !super.isBossMain && Util.gI().nextInt(100) < 5))) {
                                    if (super.isGo) {
                                        if (skillF.isChuong()) {
                                            if ((Math.abs(super.cx - super.aCharFocus.getFirst().cx) > 100 || Math.abs(super.cy - super.aCharFocus.getFirst().cy) < 30)) {
                                                super.addMove(0, super.aCharFocus.getFirst().cx + ((super.cx > super.aCharFocus.getFirst().cx) ? 100 : - 100), super.aCharFocus.getFirst().cy, 1);
                                            }
                                        } else if (skillF.isDonDanh()) {
                                            if (this.charTemplate.type == 6) {
                                                if (Math.abs(this.pre_x - super.aCharFocus.getFirst().cx) < 150 && Math.abs(this.pre_y - super.aCharFocus.getFirst().cy) < 70) {
                                                    super.addMove(0, Util.gI().nextInt(super.aCharFocus.getFirst().cx - 10, super.aCharFocus.getFirst().cx + 10), super.aCharFocus.getFirst().cy, 1);
                                                    super.timeMove = 1000;
                                                }
                                            } else {
                                                if (super.strike == 2) {
                                                    super.addMove(0, super.aCharFocus.getFirst().cx + new int[]{-24, 24}[Util.gI().nextInt(2)], super.aCharFocus.getFirst().cy + new int[]{0, -18, -18}[Util.gI().nextInt(3)], 1);
                                                    if (Util.gI().nextInt(3) == 0) {
                                                        int dX = new int[]{-120, 120}[Util.gI().nextInt(2)];
                                                        int dY = super.aCharFocus.getFirst().cy + new int[]{0, -50}[Util.gI().nextInt(2)];
                                                        super.addMove(0, super.aCharFocus.getFirst().cx + dX / 2, dY, 0);
                                                        super.addMove(0, super.aCharFocus.getFirst().cx + dX / 2, dY, 0);
                                                        super.timeLoadSkill = 1000;
                                                    }
                                                } else {
                                                    super.addMove(0, Util.gI().nextInt(super.aCharFocus.getFirst().cx - 24, super.aCharFocus.getFirst().cx + 24), super.aCharFocus.getFirst().cy, 1);
                                                }
                                            }
                                        }
                                    }
                                    if (super.isCome) {
                                        if (skillF.isChuong()) {
                                            if (!super.isMove && (Math.abs(super.cx - super.aCharFocus.getFirst().cx) > 100 || Math.abs(super.cx - super.aCharFocus.getFirst().cx) < 30 || Math.abs(super.cy - super.aCharFocus.getFirst().cy) > 50)) {
                                                super.setMove(0, super.aCharFocus.getFirst().cx + ((super.cx > super.aCharFocus.getFirst().cx) ? 100 : - 100), super.aCharFocus.getFirst().cy, 50, 0, 50);
                                            }
                                        } else {
                                            if (!super.isMove && (Math.abs(super.aCharFocus.getFirst().cx - super.cx) > 24 || Math.abs(super.aCharFocus.getFirst().cy - super.cy) > 24)) {
                                                super.setMove(0, Util.gI().nextInt(super.aCharFocus.getFirst().cx - 24, super.aCharFocus.getFirst().cx + 24), super.aCharFocus.getFirst().cy, 50, 0, 50);
                                            }
                                        }
                                    }
                                    if (!super.aCharFocus.isEmpty() && Math.abs(super.aCharFocus.getFirst().cx - super.cx) <= skillF.dx && Math.abs(super.aCharFocus.getFirst().cy - super.cy) <= skillF.dy) {
                                        super.Attack(skillF, super.aMobFocus, super.aCharFocus, 2);
                                    }
                                }
                            }
                            break;
                    }
                }
                super.timeHit = super.setSamllHit;
            }
            if (super.timeResetCloneTop != -1) {
                super.timeResetCloneTop -= delay;
                if (super.timeResetCloneTop <= 0) {
                    super.timeResetCloneTop = 10000;
                    super.cName = String.format(mResources.CNAME_ADD_STR, this.charTemplate.name, Rank.getRank(1).tops.getFirst().name);
                    Session_ME player = Server.gI().getByCName(Rank.getRank(1).tops.getFirst().name);
                    if (player != null) {
                        super.head = super.headDefault = player.myCharz().head;
                        super.body = super.bodyDefault = player.myCharz().body;
                        super.leg = super.legDefault = player.myCharz().leg;
                    } else {
                        super.head = super.headDefault = (short) Rank.getRank(1).tops.getFirst().headID;
                        super.body = super.bodyDefault = Rank.getRank(1).tops.getFirst().body;
                        super.leg = super.legDefault = Rank.getRank(1).tops.getFirst().leg;
                    }
                    if (super.zoneMap != null) {
                        super.zoneMap.playerLoadAll(this);
                    }
                }
            }
        }
        //Xoa boss
        if (this.isClear) {
            this.close();
        } else if (super.timeClear != -1) {
            super.timeClear -= super.delay;
            if (super.timeClear <= 0) {
                this.close();
                
                //Xuat hien lai
                if (this.charTemplate.id != 6 && this.charTemplate.id != 8 && this.charTemplate.id != 9 && this.charTemplate.id != 10) {
                    //Super Broly
                    if (this.charTemplate.type == 1) {
                        if (super.cHPGoc >= 1000000L) {
                            bot = Player.addBoss(14, 0, super.cHPGoc, -1, true, super.cx, super.cy, null, 10000, super.indexXH);
                            bot.maxTimeEff = 5000;
                            bot.arrInMap = super.arrInMap;
                            if (super.numberXH != -1) {
                                bot.numberXH = super.numberXH;
                                bot.cName = String.format(mResources.ADD_FORMAT_D, bot.cName, super.numberXH);
                            }
                            int num0 = 0;
                            while (num0++ < 100) {
                                try {
                                    ZoneMap zone_127 = super.zoneMap.map.zones.get(Util.gI().nextInt(20));
                                    if (zone_127.countBossById(13) > 0) {
                                        continue;
                                    }
                                    zone_127.join(bot, 0, -1, -1);
                                    break;
                                } catch (Exception e) {
                                }
                            }
                            Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot.cName, zoneMap.mapTemplate.mapName));
                        } else if (numberXH != -1) {
                            Char bot2 = Player.addBoss(13, 0, -1, -1, true, super.cx, super.cy, null, 10000, super.indexXH);
                            bot2.cName = super.cName;
                            bot2.numberXH = super.numberXH;
                            bot2.arrInMap = super.arrInMap;
                            int num1 = 0;
                            while(num1++ < 100) {
                                try {
                                    Map map_437 = Map.getMapServer(bot2.arrInMap[Util.gI().nextInt(bot2.arrInMap.length)]);
                                    ZoneMap zone_128 = map_437.zones.get(Util.gI().nextInt(20));
                                    if (zone_128.countBossById(13) > 0) {
                                        continue;
                                    }
                                    zone_128.join(bot2, 0, -1, -1);
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Bug broly xh");
                                }
                            }
                        }
                    } else {
                        if (this.charTemplate.id == 1) {
                            Server.gI().chatVip(String.format(mResources.BOSS_HAVE, Player.addBoss(2, 5, -1, -1, true, super.cx, super.cy, super.zoneMap, -1, super.indexXH).cName, super.zoneMap.mapTemplate.mapName));
                        }
                        if (this.charTemplate.id == 4) {
                            Server.gI().chatVip(String.format(mResources.BOSS_HAVE, Player.addBoss(5, 5, -1, -1, true, cx, cy, zoneMap, -1, super.indexXH).cName, zoneMap.mapTemplate.mapName));
                        }
                    }
                    //Broly
                    if (this.charTemplate.id == 14) {
                        if (super.numberXH != -1) {
                            Char bot2 = Player.addBoss(13, 0, -1, -1, true, super.cx, super.cy, null, 10000, super.indexXH);
                            bot2.cName = String.format(mResources.ADD_FORMAT_D, bot2.cName, super.numberXH);
                            bot2.numberXH = super.numberXH;
                            bot2.arrInMap = super.arrInMap;
                            int num2 = 0;
                            while(num2++ < 100) {
                                try {
                                    Map map_432 = Map.getMapServer(bot2.arrInMap[Util.gI().nextInt(bot2.arrInMap.length)]);
                                    if (map_432 == null) {
                                        continue;
                                    }
                                    ZoneMap zone_123 = map_432.zones.get(Util.gI().nextInt(20));
                                    if (zone_123.countBossById(14) > 0) {
                                        continue;
                                    }
                                    zone_123.join(bot2, 0, -1, -1);
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Bug broly xh");
                                }
                            }
                        }
                    }
                    
                    if (this.charTemplate.type == 33) {
                        if (super.numberXH != -1) {
                            Char bot_12 = Player.addBoss(this.charTemplate.id, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                            bot_12.cName = String.format(mResources.ADD_FORMAT_D, bot_12.cName, super.numberXH);
                            bot_12.numberXH = super.numberXH;
                            bot_12.arrInMap = super.arrInMap;
                            int num3 = 0;
                            while(num3++ < 100) {
                                try {
                                    num3++;
                                    Map map_434 = Map.getMapServer(bot_12.arrInMap[Util.gI().nextInt(bot_12.arrInMap.length)]);
                                    if (map_434 == null) {
                                        continue;
                                    }
                                    ZoneMap zone_125 = map_434.zones.get(Util.gI().nextInt(20));
                                    if (zone_125.countBossById(this.charTemplate.id) > 0) {
                                        continue;
                                    }
                                    zone_125.join(bot_12, 0, -1, -1);
                                    break;
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                    if (this.charTemplate.id == 16) {
                    }
                    //Xen hoan thien
                    if (this.charTemplate.id == 23) {
                        Char bot74 = Player.addBoss(24, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        super.zoneMap.join(bot74, 0, -1, -1);
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot74.cName, zoneMap.mapTemplate.mapName));
                    }
                    //Fide dai ca
                    if (this.charTemplate.id == 63) {
                        Char bot6 = Player.addBoss(64, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        super.zoneMap.join(bot6, 0, -1, -1);
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot6.cName, zoneMap.mapTemplate.mapName));
                    }
                    if (this.charTemplate.id == 64) {
                        Char bot7 = Player.addBoss(65, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        super.zoneMap.join(bot7, 0, -1, -1);
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot7.cName, zoneMap.mapTemplate.mapName));
                    }
                    //Xen bo hung
                    if (this.charTemplate.id == 74) {
                        Char bot49 = Player.addBoss(75, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        super.zoneMap.join(bot49, 0, -1, -1);
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot49.cName, zoneMap.mapTemplate.mapName));
                    }
                    if (this.charTemplate.id == 75) {
                        Char bot57 = Player.addBoss(76, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        super.zoneMap.join(bot57, 0, -1, -1);
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot57.cName, zoneMap.mapTemplate.mapName));
                    }
                }
                if (this.charTemplate.type == 9 && this.isPlayerId != -1) {
                    Map map = Map.getMapServer(Server.gI().arrMapMabu[Util.gI().nextInt(Server.gI().arrMapMabu.length)]);
                    if (map == null) {
                        return;
                    }
                    int zoneId = Util.gI().nextInt(5);
                    int x = Util.gI().nextInt(24, map.zones.get(zoneId).mapTemplate.pxw - 24);
                    int y = map.zones.get(zoneId).mapTemplate.touchY(x, 150);
                    Player.addBoss(41, 0, -1, -1, false, x, y, map.zones.get(zoneId), -1, super.indexXH);
                }
                if (this.charTemplate.type == 15) {
                    if (this.charTemplate.id != 52 && super.zoneMap.countBoss(15) <= 0) {
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, Player.addBoss(52, 0, -1, -1, true, super.cx, super.cy, super.zoneMap, 10000, super.indexXH).cName, zoneMap.mapTemplate.mapName));
                    }
                }
                //Child
                    if (this.charTemplate.id == 169) {
                        Char bot170 = Player.addBoss(170, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        super.zoneMap.join(bot170, 0, -1, -1);
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot170.cName, zoneMap.mapTemplate.mapName));
                    }
                //Xuat hien lai
                if (super.numberXH2 != -1) {
                    Char bot4 = Player.addBoss(this.charTemplate.id, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                    bot4.cName = super.cName;
                    bot4.numberXH2 = super.numberXH2;
                    bot4.arrInMap = super.arrInMap;
                    int num4 = 0;
                    while(num4++ < 100) {
                        try {
                            Map map_419 = Map.getMapServer(bot4.arrInMap[Util.gI().nextInt(bot4.arrInMap.length)]);
                            if (map_419 == null) {
                                continue;
                            }
                            ZoneMap zone_120 = map_419.zones.get(Util.gI().nextInt(20));
                            if (zone_120.countBossById(this.charTemplate.id)> 0) {
                                continue;
                            }
                            zone_120.join(bot4, 0, -1, -1);
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                
                //tdst
                if (this.charTemplate.id == 58) {
                    Char player = super.findBossInMapById(59);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                if (this.charTemplate.id == 59) {
                    Char player = super.findBossInMapById(60);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                    player = super.findBossInMapById(61);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                if (this.charTemplate.id == 60 || this.charTemplate.id == 61) {
                    if (!super.zoneMap.isHaveBoss(60) && !super.zoneMap.isHaveBoss(61)) {
                        Char player = super.findBossInMapById(62);
                        if (player != null) {
                            player.changeTypePk(5);
                        }
                    }
                }
                //tdst2
                if (this.charTemplate.id == 110) {
                    Char player = super.findBossInMapById(111);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                if (this.charTemplate.id == 111) {
                    Char player = super.findBossInMapById(112);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                    player = super.findBossInMapById(113);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                if (this.charTemplate.id == 112 || this.charTemplate.id == 113) {
                    if (!super.zoneMap.isHaveBoss(112) && !super.zoneMap.isHaveBoss(113)) {
                        Char player = super.findBossInMapById(114);
                        if (player != null) {
                            player.changeTypePk(5);
                        }
                    }
                }
                //Robot sat thu
                if (this.charTemplate.id == 69) {
                    Char player = super.findBossInMapById(70);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                //Pic poc kigkong
                if (this.charTemplate.id == 71) {
                    Char player = super.findBossInMapById(72);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                if (this.charTemplate.id == 72) {
                    Char player = super.findBossInMapById(73);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                //whis
                if (this.charTemplate.id == 167) {
                    Char player = super.findBossInMapById(168);
                    if (player != null) {
                        player.changeTypePk(5);
                    }
                }
                //Pet di theo
                if (this.charTemplate.type == 38) {
                    if (super.numberXH != -1) {
                        Char bot_13 = Player.addBoss(this.charTemplate.id, 0, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        bot_13.numberXH = super.numberXH;
                        bot_13.arrInMap = super.arrInMap;
                        bot_13.isRego = super.isRego;
                        bot_13.timeRego = super.timeRego;
                        bot_13.maxZoneXH = super.maxZoneXH;
                        int num4 = 0;
                        while(num4++ < 100) {
                            try {
                                num4++;
                                Map map_435 = Map.getMapServer(bot_13.arrInMap[Util.gI().nextInt(bot_13.arrInMap.length)]);
                                ZoneMap zone_126 = map_435.zones.get(Util.gI().nextInt(super.maxZoneXH));
                                zone_126.join(bot_13, 0, -1, -1);
                                break;
                            } catch (Exception e) {
                            }
                        }
                    }
                }
                //Hoa
                if (this.charTemplate.type == 41) {
                    if (super.numberXH != -1) {
                        Char bot_13 = Player.addBoss(this.charTemplate.id, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        bot_13.numberXH = super.numberXH;
                        bot_13.arrInMap = super.arrInMap;
                        bot_13.maxZoneXH = super.maxZoneXH;
                        int num4 = 0;
                        while(num4++ < 100) {
                            try {
                                num4++;
                                Map map_435 = Map.getMapServer(bot_13.arrInMap[Util.gI().nextInt(bot_13.arrInMap.length)]);
                                if (map_435 == null) {
                                    continue;
                                }
                                ZoneMap zone_126 = map_435.zones.get(Util.gI().nextInt(super.maxZoneXH));
                                int x = Util.gI().nextInt(50, zone_126.mapTemplate.pxw - 50);
                                zone_126.join(bot_13, 0, x, zone_126.mapTemplate.touchY(x, 150));
                                break;
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }
        super.timeMove -= delay;
        if (super.timeMove <= 0) {
            super.timeMove = 0;
        }
        //Di theo
        if ((super.isPlayerId != -1 || super.isCharId != -1) && super.zoneMap != null && !super.isStand()) {
            Char o = null;
            if (super.isCharId != -1) {
                o = super.zoneMap.findCharInMap(super.isCharId);
            } else if (super.isPlayerId != -1) {
                o = super.zoneMap.findCharInMap2(super.isPlayerId);
            }
            if (super.timeMove <= 0) {
                if (this.itemBuys != null && !this.itemBuys.isEmpty()) {
                    super.timeMove = 500;
                    if (o != null && Math.abs(o.cx - this.cx) < 120 && Math.abs(o.cy - super.cy) < 200 && Math.abs(o.cx - super.cx) > 24) {
                        int tdelay = (this.itemBuys.size() * 5);
                        int sp;
                        if (this.transport_speed < tdelay) {
                            sp = 1;
                        } else {
                            sp = this.transport_speed - tdelay;
                        }
                        if (o.cx > super.cx) {
                            super.cx += sp;
                        } else {
                            super.cx -= sp;
                        }
                        super.cy = super.zoneMap.mapTemplate.touchY(super.cx, o.cy);
                        super.zoneMap.playerMove(super.charID, super.cx, super.cy);
                    }
                } else if (this.charTemplate.type == 9) {
                    super.timeMove = 500;
                    if (o != null && Math.abs(o.cx - this.cx) < 200 && Math.abs(o.cy - super.cy) < 200 && Math.abs(o.cx - super.cx) > 24) {
                        if (o.cx > super.cx) {
                            super.cx += 30;
                        } else {
                            super.cx -= 30;
                        }
                        super.cy = super.zoneMap.mapTemplate.touchY(super.cx, o.cy);
                        super.zoneMap.playerMove(super.charID, super.cx, super.cy);
                    } else if (o == null || Math.abs(o.cx - this.cx) > 220) {
                        super.timeClear = 1;
                        Session_ME player = Server.gI().getByCName(super.cName);
                        if (player != null) {
                            player.service.chatTHEGIOI(mResources.EMPTY, mResources.FALID_MABU, null, 0);
                        }
                    }
                } else if (this.charTemplate.type == 38) {
                    super.timeMove = 0;
                    if (super.gameTick % 10 == 0) {
                        if (o != null && Math.abs(o.cx - this.cx) < 300 && Math.abs(o.cy - super.cy) < 200 && Math.abs(o.cx - super.cx) > 24) {
                            if (o.cx > super.cx) {
                                super.cx += 50;
                            } else {
                                super.cx -= 50;
                            }
                            super.cy = super.zoneMap.mapTemplate.touchY(super.cx, 125);
                            super.zoneMap.playerMove(super.charID, super.cx, super.cy);
                        } else if (o == null || Math.abs(o.cx - this.cx) > 320) {
                            Session_ME player = Server.gI().getByPId(super.isPlayerId);
                            if (player != null) {
                                player.myCharz().addInfo1(String.format(mResources.FALID_PET_DI_THEO, super.cName));
                                player.myCharz().isPetThiTheo = false;
                            }
                            super.isPlayerId = -1;
                        }
                    }
                } else if (o != null) {
                    super.timeMove = 200;
                    if (Math.abs(super.cx - o.cx) > 100) {
                        if (super.isRego) {
                            super.timeRego = 5000;
                        }
                        if (o.cx > super.cx) {
                            super.cx += 50;
                        } else {
                            super.cx -= 50;
                        }
                        if (Math.abs(super.cx - o .cx) <= 50) {
                            super.cx = Util.gI().nextInt(o.cx - 100, o.cx + 100);
                        }
                        super.cy = super.zoneMap.mapTemplate.touchY(super.cx, o.cy);
                        super.zoneMap.playerMove(super.charID, super.cx, super.cy);
                    }
                }
                if (this.charTemplate.type == 7) {
                    if (o == null || o.isDie) {
                        this.timeDownHPTransport -= delay;
                        if (this.timeDownHPTransport <= 0) {
                            this.timeDownHPTransport = 3000;
                            super.haveAttackPLayer(null, 1, super.cHPFull / 10, false, -1, true);
                        }
                    }
                }
            }
            if (super.myChar2 != null) {
                if (super.zoneMap != super.myChar2.zoneMap) {
                    super.zoneMap.exit(this, 1);
                    super.cx = super.myChar2.cx;
                    super.cy = super.myChar2.cy;
                    super.myChar2.zoneMap.join(this, 0, -1, -1);
                }
            }
        }
        //Di bo theo
        if (this.charTemplate.type == 10 && super.zoneMap != null && !super.isCharge && !super.isDie && !super.isFreez && !super.sleepEff && !super.holder && !super.blindEff) {
            Char o = super.zoneMap.getPlayerClosest(this);
            if (o != null && o.cy == super.zoneMap.mapTemplate.touchY(o.cx, o.cy) && (Math.abs(super.cx - o.cx) > 24 || Math.abs(super.cy - o.cy) > 5)) {
                int x = super.cx;
                if (o.cx > super.cx) {
                    if (Math.abs(o.cx - super.cx) > 150) {
                        x += 150;
                    } else if (Math.abs(o.cx - super.cx) < 50) {
                        x = o.cx;
                    } else  {
                        x += 50;
                    }
                } else {
                    if (Math.abs(o.cx - super.cx) > 150) {
                        x -= 150;
                    } else if (Math.abs(o.cx - super.cx) < 50) {
                        x = o.cx;
                    } else {
                        x -= 50;
                    }
                }
                int y = super.zoneMap.mapTemplate.touchY(x, o.cy);
                super.addMove(0, x, y, 0);
            }
        }
        //Nhin thay
        if (!super.isSee && super.cTypePk == 5) {
            Char o = super.zoneMap.getPlayerClosest(this);
            if (!this.isNhinThay) {
                if (o != null && Math.abs(o.cx - super.cx) < 200 && Math.abs(o. cy - super.cy) < 200) {
                    this.isNhinThay = true;
                }
            } else if (o == null) {
                this.isNhinThay = false;
            }
        }
        //Check xem con bao ve ko
        if (this.charTemplate.type == 12) {
            this.isBaoVe = super.zoneMap.isBaoVe(this);
        }
        //De con
        if (super.timeSonCall > 0) {
            super.timeSonCall -= delay;
            if (super.timeSonCall <= 0) {
                super.timeSonCall  = 0;
                if (!this.isDie) {
                    for (i = 0; i < super.sonCall; i++) {
                        bot = Player.addBoss(25, 5, -1, -1, true, super.cx, super.cy, null, -1, super.indexXH);
                        bot.cName = String.format(mResources.CNAME_ADD_NUMBER, bot.cName, i + 1);
                        bot.dabId = super.charID;
                        Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot.cName, super.zoneMap.mapTemplate.mapName));
                        super.zoneMap.join(bot, 0, -1, -1);
                    }
                }
            }
        }
        if (!super.isSonCall) {
            if (this.charTemplate.id == 23) {
                if (100f / (float)super.cHPFull * (float)super.cHP <= 80 && !super.isDie) {
                    super.sonCall(5, 7);
                }
            }
        }
        if (!super.isDie && super.zoneMap != null && super.sonCall > 0 && super.timeSonCall <= 0) {
            super.sonCall = super.zoneMap.getSonCount(super.charID);
            if (super.sonCall <= 0 && super.cTypePk == 0) {
                super.zoneMap.chat(this, mResources.SON_CELL);
                super.changeTypePk(5);
            }
        }
        //Bo chay
        if (this.charTemplate.type == 17 && (super.zoneMap == null || super.zoneMap.getCountPLayerNotAI() <= 0)) {
            this.isClear = true;
        }
        //Bien
        if (this.charTemplate.type == 20 && super.zoneMap != null) {
            super.timeSendClone -= delay;
            if (super.timeSendClone <= 0) {
                super.timeSendClone = 5000;
                super.zoneMap.cloneByChar(this);
            }
        }
        //Noi
        if (super.zoneMap != null && !this.isNoiKore && this.charTemplate.id == 68) {
            Char player = super.zoneMap.getPlayerNotPetz();
            if (player != null) {
                this.isNoiKore = true;
                player.NoiKore();
            }
        }
        if (!super.isEx2 && (this.charTemplate.id == 68 || this.charTemplate.id == 67) && 100f / (float)super.cHPFull * (float)super.cHP <= 40) {
            super.isEx2 = true;
            Char bot67;
            assert super.zoneMap != null; // Sử dụng zoneMap sau khi đã kiểm tra không null
            if (!super.zoneMap.isHaveBoss(66)) {
                bot67 = Player.addBoss(66, 0, -1, -1, true, super.cx + 24, super.cy, super.zoneMap, 20000, super.indexXH);
                Server.gI().chatVip(String.format(mResources.BOSS_HAVE, super.cName, super.zoneMap.mapTemplate.mapName));
            } else {
                bot67 = super.findBossInMapById(66);
            }
            bot67.isEx2 = true;
            Char bot54;
            if (this.charTemplate.id == 68) {
                bot54 = super.findBossInMapById(67);
            } else {
                bot54 = super.findBossInMapById(68);
            }
            if (bot54 != null && !bot54.isDie) {
                bot54.changeTypePk(0);
                bot54.timeChangePk5 = 20000;
                bot54.isEx2 = true;
            }
            if (!super.isDie) {
                super.changeTypePk(0);
                super.timeChangePk5 = 20000;
            }
        }
        //Hoa da
        if ((super.cTemplateId == 77 || super.cTemplateId == 81 || super.cTemplateId == 82) && !super.isSocola && !super.isCharge && !super.isDie && !super.isFreez && !super.sleepEff && !super.holder) {
            this.timeSendStone30_2 -= delay;
            if (this.timeSendStone30_2 <= 0) {
                this.timeSendStone30_2 = 30000;
                if (this.zoneMap != null) {
                    this.zoneMap.chat(this, mResources.PHET);
                    super.sendStone(this, 22, Util.gI().nextInt(2, 3));
                }
            }
        }
        //Di cham
        if (super.cTemplateId == 78 || super.cTemplateId == 83) {
            super.downSpeedSend_percent = 90;
            super.isDownSpeed = true;
        }
        //
        if (super.cTemplateId == 79) {
            super.isInvisiblez5 = true;
        }
    }

    @Override
    public void close() {
        this.isPlay = false;
        super.close();
    }
    
    public static void petInfo(Char charz, int gender) {
        if (charz.myPet != null) {
            if (charz.myPetz().zoneMap != null) {
                charz.myPetz().zoneMap.exit(charz.myPetz(), 0);
            }
            charz.myPet = null;
        }
        Char petz = new Char();
        petz.isBienHinh = false;
        petz.cry = false;
        petz.me = false;
        petz.isBaby = true;
        petz.isMabu = 0;
        petz.charID = -charz.charID;
        petz.cName = mResources.DE_TU;
        petz.headDefault = Boss.gI().petInfoHead[gender];
        petz.arrItemBag = new Item[20];
        petz.arrItemBox = new Item[20];
        petz.arrItemBody = new Item[Char.MAXBODY_PET];
        petz.cgender = (byte) gender;
        petz.nClassId = 3;
        petz.cHP = petz.cHPGoc = Util.gI().nextInt(800, 3000);
        petz.cMP = petz.cMPGoc = Util.gI().nextInt(800, 3000);
        petz.cDamGoc = Util.gI().nextInt(28, 60);
        petz.cDefGoc = Util.gI().nextInt(20, 50);
        petz.cCriticalGoc = Util.gI().nextInt(1, 3);
        petz.cTiemNang = 2000;
        petz.cPower = 2000;
        petz.cStamina = petz.cMaxStamina = 1000;
        petz.nextSkillPet(0, 0);
        petz.myChar = charz;
        petz.updateAll();
        charz.myPet = petz;
        charz.session.service.petInfo1();
    }
    
    public static void mabuInfo(Char charz) {
        if (charz.myPet != null) {
            if (charz.myPetz().zoneMap != null) {
                charz.myPetz().zoneMap.exit(charz.myPetz(), 0);
            }
            charz.myPet = null;
        }
        Char petz = new Char();
        petz.isBienHinh = false;
        petz.cry = true;
        petz.me = false;
        petz.isBaby = false;
        petz.isMabu = 1;
        petz.charID = -charz.charID;
        petz.cName = mResources.MABU;
        petz.headDefault = 297;
        petz.arrItemBag = new Item[20];
        petz.arrItemBox = new Item[20];
        petz.arrItemBody = new Item[Char.MAXBODY_PET];
        petz.cgender = (byte) charz.cgender;
        petz.nClassId = 3;
        petz.cHP = petz.cHPGoc = Util.gI().nextInt(800, 3000);
        petz.cMP = petz.cMPGoc = Util.gI().nextInt(800, 3000);
        petz.cDamGoc = Util.gI().nextInt(28, 60);
        petz.cDefGoc = Util.gI().nextInt(20, 50);
        petz.cCriticalGoc = Util.gI().nextInt(1, 3);
        petz.cTiemNang = 2000;
        petz.cPower = 1500000;
        petz.cStamina = petz.cMaxStamina = 1000;
        petz.nextSkillPet(0, 0);
        petz.myChar = charz;
        petz.updateAll();
        charz.myPet = petz;
        charz.session.service.petInfo1();
    }
    
    public Player(int charTemplateId) {
        super.isTemplate = true;
        super.me = true;
        super.charID = -Char.getNewCharID();
        this.charTemplate = CharTemplate.get(super.cTemplateId = charTemplateId);
        assert this.charTemplate != null;
        super.cName = this.charTemplate.name;
        super.head = super.headDefault = this.charTemplate.headId;
        super.body = super.bodyDefault = this.charTemplate.bodyId;
        super.leg = super.legDefault = this.charTemplate.legId;
        super.cPower = this.charTemplate.cPower;
        super.cHP = super.cHPFull = super.cHPGoc = this.charTemplate.cHPGoc;
        super.cMP = super.cMPFull = super.cMPGoc = this.charTemplate.cMPGoc;
        super.cDamGoc = this.charTemplate.cDamGoc;
        super.cDefGoc = this.charTemplate.cDefGoc;
        super.cCriticalGoc = this.charTemplate.cCriticalGoc;
        super.cDefPercentGoc = this.charTemplate.cDefPercentGoc;
        super.cMissPercentGoc = this.charTemplate.cMissPercentGoc;
        super.arrItemBag = new Item[20];
        super.arrItemBox = new Item[20];
        super.arrItemBody = new Item[10];
        for (int i = 0; i < this.charTemplate.skills.length; i++) {
            super.skills.add(Skill.arrSkill[this.charTemplate.skills[i]].clone());
        }
        if (!super.skills.isEmpty()) {
            super.mySkill = super.skills.getFirst();
        }
        super.cgender = this.charTemplate.cgender;
        super.nClassId = this.charTemplate.nClassId;
        super.typeTeleport = this.charTemplate.typeTeleport;
        super.magicTree_level = 1;
        super.cTemplateType = this.charTemplate.type;
        super.pDamHP = this.charTemplate.pDamHP;
        super.maxDamageTo = this.charTemplate.maxDamageTo;
        super.maxPercentHPTo = this.charTemplate.maxPercentHPTo;
        super.isSee = this.charTemplate.isSee;
        super.setSamllHit = this.charTemplate.setSamllHit;
        super.isGo = this.charTemplate.isGo;
        super.isCome = this.charTemplate.isCome;
        super.strike = this.charTemplate.strike;
        super.autoMove = this.charTemplate.autoMove;
        super.chatGameBot = (ArrayList<ChatGameBot>) this.charTemplate.chatGameBot.clone();
        
        if (this.charTemplate.type == 3) {
            this.cName = String.format(mResources.CNAME_ADD_STR, this.charTemplate.name, Objects.requireNonNull(Rank.getRank(1)).tops.getFirst().name);
            this.timeResetCloneTop = 10000;
            super.head = super.headDefault = (short) Objects.requireNonNull(Rank.getRank(1)).tops.getFirst().headID;
            super.body = super.bodyDefault = Objects.requireNonNull(Rank.getRank(1)).tops.getFirst().body;
            super.leg = super.legDefault = Objects.requireNonNull(Rank.getRank(1)).tops.getFirst().leg;
        }
        if (this.charTemplate.type == 1) {
            super.cHP = super.cHPFull = super.cHPGoc = Util.gI().nextInt(500, 100000);
        }
        if (this.charTemplate.type == 7) {
            this.itemBuys = new ArrayList<>();
        }
        if (this.charTemplate.type == 29 && this.charTemplate.id != 86) {
            super.belly = new Map(128, 1, 15, 0);
            super.belly.isOpen = true;
            super.isSkillMabu = true;
        }
        if (this.charTemplate.type == 30) {
            super.isSkillMabu = true;
        }
        if (this.charTemplate.type == 36) {
            super.isRego = true;
            super.timeRego = 3000;
        }
        if (this.charTemplate.type == 1) {
            super.isTaiTao1 = true;
        }
        super.updateAll();
    }
    
    public static Player addBoss(int charTemplateId, int cTypePk, int hp, int dam, boolean isAtt, int x, int y, ZoneMap zone, int timeChangePk5, int index) {
        Player player = new Player(charTemplateId);
        if (player.belly != null) {
            player.belly.owner = player;
        }
        player.cTypePk = (byte) cTypePk;
        player.timeChangePk5 = timeChangePk5;
        if (hp != -1) {
            player.cHP = player.cHPFull = player.cHPGoc = hp;
        }
        if (dam != -1) {
            player.cDamFull = player.cDamGoc = dam;
        }
        player.pre_x = player.cx = x;
        player.pre_y = player.cy = y;
        player.isAtt = isAtt;
        player.indexXH = index;
        
        player.timeClear = -1;
        if (zone != null) {
            zone.join(player, 0, -1, -1);
        }
        player.timeHit = 1000;
        if (player.cTemplateType != 35 && player.cTemplateType != 46 && player.cTemplateType != 47 && player.cTemplateType != 50) {
            player.initBot();
            if (player.cTemplateType != 43) {
                addBOT(player);
            }
        }
        return player;
    }
    
    public static void addBOT(Player bot) {
        synchronized (BOTS) {
            if (bot.indexXH != -1) {
                Server.gI().playerCls.add(bot);
            }
            BOTS.add(bot);
        }
    }
    
    public static void removeBOT(Player bot) {
        synchronized (BOTS) {
            if (bot.indexXH != -1) {
                Server.gI().playerCls.remove(bot);
            }
            BOTS.remove(bot);
        }
    }
    
    public static int sizeBot() {
        synchronized (BOTS) {
            return BOTS.size();
        }
    }
    
    public static void clearBot() {
        int i;
        synchronized (BOTS) {
           for (i = 0; i < BOTS.size(); i++) {
               BOTS.get(i).isClear = true;
           } 
        }
        System.out.println("Clear All Bot "+ i);
    }
    
    public static Player getBossPlayer(int playerId, int type) {
        Player o = null;
        int i;
        synchronized (BOTS) {
           for (i = 0; i < BOTS.size(); i++) {
               if (BOTS.get(i).isPlayerId == playerId && (type == -1 || (type != -1 && BOTS.get(i).charTemplate.type == type))) {
                   o = BOTS.get(i);
                   break;
               }
           } 
        }
        return o;
    }
    
    public static int getCountItem() {
        int count = 0;
        
        return  count;
    }
    
    public static Player findRandomBoss(int id) {
        int i;
        ArrayList<Player> aBosss = new ArrayList<>();
        synchronized (BOTS) {
            for (i = 0; i < BOTS.size(); i++) {
                Player boss = BOTS.get(i);
                if (boss.charTemplate.id == id && boss.zoneMap != null && boss.zoneMap.getCountPLayerNotAI() < boss.zoneMap.maxPlayer) {
                    aBosss.add(boss);
                }
            }
        }
        if (!aBosss.isEmpty()) {
            return aBosss.get(Util.gI().nextInt(aBosss.size()));
        }
        return null;
    }
    
    public void clear() {
        Player.removeBOT(this);
    }
}
