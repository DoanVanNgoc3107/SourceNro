package dragon.t;

import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Admin
 */
public class Mob {
    
    public static MobTemplate[] arrMobTemplate;
    
    public static final byte TYPE_DUNG = 0;
    public static final byte TYPE_DI = 1;
    public static final byte TYPE_NHAY = 2;
    public static final byte TYPE_LET = 3;
    public static final byte TYPE_BAY = 4;
    public static final byte TYPE_BAY_DAU = 5;
    public static final byte MA_INHELL = 0;
    public static final byte MA_DEADFLY = 1;
    public static final byte MA_STANDWAIT = 2;
    public static final byte MA_ATTACK = 3;
    public static final byte MA_STANDFLY = 4;
    public static final byte MA_WALK = 5;
    public static final byte MA_FALL = 6;
    public static final byte MA_INJURE = 7;
    
    public static short[] deTrungMobId = new short[]{8, 11, 32, 43, 25, 49, 50};
    
    public Mob(int mobId, int mobTemplateId, int level, int pointx, int pointy) {
        this.mobId = mobId;
        this.templateId = mobTemplateId;
        this.level = (byte) level;
        this.firstx = this.pointx = (short) pointx;
        this.firsty = this.pointy = (short) pointy;
    }
    
    public boolean changBody;
    public short smallBody;
    public boolean isHintFocus;
    public String flystring;
    public int flyx;
    public int flyy;
    public int flyIndex;
    public boolean isFreez;
    public int mili_seconds;
    public long last;
    public long cur;
    public int holdEffID;
    public int hp;
    public int maxHp;
    public int x;
    public int y;
    public int dir = 1;
    public int dirV = 1;
    public int status;
    public int p1;
    public int p2;
    public int p3;
    public int xFirst;
    public int yFirst;
    public int vy;
    public int exp;
    public int w;
    public int h;
    public int hpInjure;
    public int charIndex;
    public int timeStatus;
    public int mobId;
    public boolean isx;
    public boolean isy;
    public boolean isDisable;
    public boolean isDontMove;
    public boolean isFire;
    public boolean isIce;
    public boolean isWind;
    public boolean isDie;
    public boolean isGo;
    public String mobName;
    public int templateId;
    public short pointx;
    public short pointy;
    public short firstx;
    public short firsty;
    public int dame;
    public int dameMp;
    public int sys;
    public byte levelBoss;
    public byte level;
    public boolean isBoss;
    public boolean isMobMe;
    
    public boolean blindEff;
    public int time_blindEff;
    public boolean sleepEff;
    public int time_sleepEff;
    public boolean holder;
    public int time_holder;
    public int holder_charId;
    
    public int milisecondAttackPlayer = 0;
    public long milisecondLive = 0;
    public int timeLiveMobMe = 0;
    public int damage;
    public int time_setBody;
    public final HashMap<Integer, Integer> charDam = new HashMap<>();
    public final ArrayList<Integer> charAtt = new ArrayList<>();
    public int timeDownHutHPKI5;
    public int defull = 0;
    public int defull_percent = 0;
    public int timeUpHp = 0;
    public int damFull = 0;
    public Char me;
    public ZoneMap zone;
    public int damageTDMPB;
    public Char playerTDMPB;
    private int timeTDMPB;
    public boolean removeWhenDie;
    
    public static long timeRoiDoTL = -1;
    
    public void addDam(int charId, int dam) {
        synchronized(this.charDam) {
            if (this.charDam.containsKey(charId)) {
                this.charDam.replace(charId, this.charDam.get(charId) + dam);
            } else {
                this.charDam.put(charId, dam);
            }
        }
    }
    
    public void addAtt(int charId) {
        synchronized(this.charAtt) {
            if (!this.charAtt.contains(charId)) {
                this.charAtt.add(charId);
            }
        }
    }
    
    public void removeAtt(int charId) {
        int i;
        synchronized(this.charAtt) {
            for (i = 0; i  < this.charAtt.size(); i++) {
                if (this.charAtt.get(i) == charId) {
                    this.charAtt.remove(i);
                    break;
                }
            }
        }
    }
    
    public void claerDam() {
        synchronized(this.charDam) {
            this.charDam.clear();
        }
    }
    
    public void claerAtt() {
        synchronized(this.charAtt) {
            this.charAtt.clear();
        }
    }
    
    public boolean isAtt(int charId) {
        synchronized(charAtt) {
            return this.charAtt.contains(charId);
        }
    }
    
    public int getCharDam(int key) {
        synchronized(this.charDam) {
            try {
                return this.charDam.get(key);
            } catch (Exception e) {
                return 0;
            }
        }
    }
    
    public int[][] sortCharIdDam() {
        int[][] array;
        synchronized(this.charDam) {
            array = new int[this.charDam.size()][2];
            if (!this.charDam.isEmpty()) {
                int i = 0;
                Iterator<Integer> itr = this.charDam.keySet().iterator();
                while (itr.hasNext()) {
                    int key = itr.next();
                    array[i][0] = key;
                    array[i][1] = this.charDam.get(key);
                    i++;
                }
            }
        }
        // sort giam dan
        Arrays.sort(array, Comparator.comparingInt((int[] arr) -> arr[1]).reversed());
        return array;
    }
    
    public int getCharIdMaxDam() {
        int charId = -1;
        int[] arrId = null;
        int i;
        synchronized(this.charDam) {
            if (!this.charDam.isEmpty()) {
                arrId = new int[this.charDam.size()];
                i = 0;
                Iterator<Integer> itr = this.charDam.keySet().iterator();
                while (itr.hasNext()) {
                    int key = itr.next();
                    arrId[i++] = key;
                }
            }
        }
        if (arrId != null) {
            int dameMax = 0;
            for (i = 0; i < arrId.length; i++) {
                Session_ME player = Server.gI().getByCId(arrId[i]);
                if (player != null && getCharDam(arrId[i]) > dameMax) {
                    dameMax = getCharDam(arrId[i]);
                    charId = player.myCharz().charID;
                }
            }
        }
        return charId;
    }
    
    public boolean isAttack() {
        return this.templateId != 0 && this.templateId != 76;
    }
    
    public void fallItem(Char target, ArrayList<ItemMap> itemMaps, int type, int charMaxDam) {
        dragon.t.Mob2.gI().fallItem(this, target, itemMaps, this.zone, type, charMaxDam);
    }
    
    public int AttackMob(Char charz, int dam, boolean flag, int type, int effectId) {
        int i;
            if (!this.isDie && this.status != 0 && this.status != 1) {
                this.timeUpHp = 0;
                if (dam != 1) {
                    if (flag) {
                        dam = dam * 2;
                        if (charz != null && charz.damCrit_percent > 0) {
                            dam = (int) (dam + ((long)dam * (long)charz.damCrit_percent / 100L));
                        }
                        if (charz != null && charz.vTanjiro > 0) {
                            dam = (int) (dam + ((long)dam * (long)charz.vTanjiro / 100L));
                        }
                    }
                    if (this.templateId == 0 && dam > 0) {
                        dam = 10;
                    }
                    if (this.templateId == 70 || this.templateId == 77 || this.templateId == 85) {
                        if (dam > 0) {
                            int percent = (int) (100 - (100f / (float)this.maxHp * (float)this.hp));
                            if (percent > 98) {
                                percent = 50;
                            } else {
                                percent = (percent / 15) + 4;
                            }
                            dam = dam / 3;
                            if (dam > (long)this.hp * (long)percent / 100l) {
                                dam = (int) ((long)this.hp * (long)percent / 100l);
                                if (dam <= 0) {
                                    dam = 1;
                                }
                            }
                        }
                    }
                    if (type != 3 && dam >= this.maxHp && this.maxHp == this.hp) {
                        dam = this.maxHp - 1;
                    }
                    if (dam > 0 && charz != null) {
                        this.addDam(charz.myCharz().charID, dam);
                        this.addAtt(charz.charID);
                    }
                    if (type == 5) {
                        if (hp - dam  < 1) {
                            dam = hp - 1;
                        }
                    } else {
                        dam = (int) (dam - ((long)dam * (long)this.defull_percent / 100l));
                    }
                    if (dam > this.hp) {
                        dam = this.hp;
                    }
                    this.hp -= dam;
                    if (this.templateId == 70) {
                        if ((type == 1 || type == 2) && Util.gI().nextInt(100) < 5) {
                            ArrayList<ItemMap> itemMaps = new ArrayList<>();
                            for (i = 0; i < 5; i++) {
                                int toX = Util.gI().nextInt(pointx - 70, pointx + 70);
                                int toY = this.zone.mapTemplate.touchY(toX, pointy);
                                ItemMap itemMap = this.zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                                itemMaps.add(itemMap);
                            }
                            for (i = 0; i < itemMaps.size(); i++) {
                                this.zone.itemMapAdd(itemMaps.get(i));
                            }
                        }
                    }
                }
                if (this.hp <= 0) {
                    this.startDie();
                    //Mu
                    if (this.blindEff) {
                        this.time_blindEff = 1;
                    }
                    //Ru ngu
                    if (this.sleepEff) {
                        this.time_sleepEff = 1;
                    }
                    //Troi
                    if (this.holder) {
                        this.time_holder = 1;
                    }
                    //Bien socola
                    if (this.changBody) {
                        this.time_setBody = 1;
                    }
                    //LIST ITEM MAP
                    ArrayList<ItemMap> itemMaps = new ArrayList<>();
                    //
                    //Nhiem Vu
                    if (charz != null) {
                        dragon.t.MobTask.updateTask(charz, this, itemMaps);
                    }
                    //
                    this.fallItem(charz, itemMaps, type, this.getCharIdMaxDam());
                    this.zone.mobDie(this.mobId, dam, flag, itemMaps);
                    if (charz != null && charz.myCharz().isHutVP) {
                        for (i = 0; i < itemMaps.size(); i++) {
                            ItemMap itemMap3 = itemMaps.get(i);
                            if (itemMap3 != null && itemMap3.charId == charz.myCharz().charID) {
                                charz.myCharz().zoneMap.pickItem(charz, itemMap3.itemMapID, 0);
                            }
                        }
                    }
                    if (!this.isMobMe) {
                        if (this.zone.map.isMapDoanhTrai()) {
                            if (this.templateId != 22) {
                                this.zone.countMobDie++;
                            }
                        } else if (this.zone.map.isMapDestronGas()) {
                            this.zone.countMobDie++;
                        } else if (this.zone.map.isMapKhoBau()) {
                            this.zone.countMobDie++;
                        }
                        if (this.zone.map.destronGas != null) {
                            int indexMap = this.zone.map.destronGas.getIndexMaps(this.zone.map.mapId);
                            if (this.zone.countMobDie >= this.zone.map.destronGas.maxMobDieNextMap[indexMap]) {
                                this.zone.map.destronGas.updateWin(indexMap);
                            }
                        }
                        if (this.zone.map.doanhTrai != null) {
                            int indexMap = this.zone.map.doanhTrai.getIndexMaps(this.zone.map.mapId);
                            if (this.zone.countMobDie >= this.zone.map.doanhTrai.maxMobDieNextMap[indexMap]) {
                                this.zone.map.doanhTrai.updateWin(indexMap);
                            }
                        }
                        if (this.zone.map.khobau != null) {
                            int indexMap = this.zone.map.khobau.getIndexMaps(this.zone.map.mapId);
                            if (this.zone.countMobDie >= this.zone.map.khobau.maxMobDieNextMap[indexMap]) {
                                this.zone.map.khobau.updateWin(indexMap);
                            }
                        }
                        if (this.zone.map.phoban != null) {
                        }
                    }
                } else {
                    this.zone.mobHP(this.mobId, this.hp, dam, flag, effectId);
                }
                if (this.sleepEff) {
                    this.hold(0, 0, 41, -1);
                }
            }
        return dam;
    }
    
    public void startDie() {
        this.hp = 0;
        this.status = 0;
        this.p1 = -3;
        this.p2 = -this.dir;
        this.p3 = 0;
        this.milisecondLive = System.currentTimeMillis() + 5000;
        this.isDie = true;
    }
    
    public boolean isReDamge() {
        return true;
    }
    
    public boolean isSuckHP() {
        return true;
    }
    
    public int atkPlayer(int dam, Char player) {
        int downDam_percent;
        if (this.damFull > 0) {
            dam = this.damFull;
        }
        if (dam > 0) {
            dam = Util.gI().nextInt((int) ((long)dam * 9l / 10l), dam);
        }
        //Giap or xen bo hung
        dam -= player.cDefull;
        if (player.downDamage_percent > 0) {
            downDam_percent = player.downDamage_percent;
            if (downDam_percent > 85) {
                downDam_percent = 85;
            }
            dam = (int) (dam - ((long)dam * (long)downDam_percent / 100l));
        }
        //GIam % moi sat thuong khi KI duoi 20%
        if (player.downDamKI20_percent > 0 && (100f / (float)player.cMPFull * (float)player.cMP) < 20) {
            dam -= (int)((long)dam * (long)player.downDamKI20_percent / (long)100);
        }
        if (player.isXenBoHung) {
            dam = dam / 2;
        }
        if (player.isXenBoHung2) {
            dam = (int) ((float)dam * 0.4F);
        }

        //Bua de tu
        if (!player.me && player.myCharz().isBuaDeTu) {
            dam = dam / 2;
        }
        //Bua oai hum
        if (!player.isOaiHum && this.levelBoss > 0) {
            dam = player.cHPFull / 10;
        }
        if (player.isMobproactive) {
            dam -= (int)((long)dam * (long)20 / (long)100);
        }
        //Binh Commeson
        if (player.isCommeson) {
            dam = (int) ((float)dam * 0.1F);
        }

        if (dam < 1) {
            dam = 1;
        }

        //Ne don
        if (player.cMissPercent > 0) {
            int neDon = player.cMissPercent > 80 ? 80 : player.cMissPercent;
            if (Util.gI().nextInt(1, 100) <= neDon) {
                dam = 0;
            }
        }

        if (dam > 1 && player.protectEff) {
            if (dam  >= player.cHPFull) {
                player.setItem(3784, 0, 0, 0);
            }
            dam = 1;
        }
        if (this.smallBody == 11183 || this.smallBody == 11192 || this.smallBody == 11173) {
            dam = 1;
        }
        if (dam > player.cHP) {
            dam = player.cHP;
        }
        player.upHP(-dam);
        if (player.isNotDieMob && player.cHP < 1) {
            dam = player.cHP - 1;
            player.cHP = 1;
        }
        if (player.isSetOcTieu && player.cHP < 1) {
            dam = player.cHP - 1;
            player.cHP = 1;
        }
        if (player.cHP <= 0) {
            int i;
            ArrayList<ItemMap> itMaps = new ArrayList<>();
            if (player.cTemplateType == 7) {
                //Roi all do trong pet
                Player o2 = (Player) player;
                while(o2.itemBuys.size() > 0) {
                    Item it94 = o2.itemBuys.remove(0);
                    int toX = Util.gI().nextInt(player.cx - 70, player.cx + 70);
                    int toY = this.zone.mapTemplate.touchY(toX, player.cy);
                    ItemMap itemMap = this.zone.addItemMap(-1, it94, toX, toY, 0, -1);
                    itMaps.add(itemMap);
                }
            }
            for (i = 0; i < itMaps.size(); i++) {
                this.zone.itemMapAdd(itMaps.get(i));
            }
            player.startDie(1, player.cx, this.zone.mapTemplate.touchY(player.cx, player.cy));
        }
        //Phan tan cong
        if (this.isReDamge()) {
            int recdam = (int) ((long)dam * (long)player.damReturn_percent / 100l);
            if (!this.isDie && player.damReturn_percent > 0 && recdam > 0 && this.hp > 1) {
                this.AttackMob(player, recdam, false, 3, 36);
            }
        }
        return dam;
    }
    
    public void update() {
        if (!this.isMobNew()) {
            if (this.milisecondAttackPlayer <= 0) {
                if (this.isAttack() && this.status != 0 && this.status != 1 && !this.isDie && !this.isFreez && !this.sleepEff && !this.holder) {
                    Char player_atk = this.zone.getPlayerAttack(this);
                    if (player_atk != null && !player_atk.isDie) {
                        int dam = this.atkPlayer(this.damGoc(), player_atk);
                        if (player_atk.session != null) {
                            if (player_atk.isNotDieMob && player_atk.cHP <= 1) {
                                player_atk.session.service.mobAttackMe(mobId, 0, -1);
                            } else {
                                player_atk.session.service.mobAttackMe(this.mobId, dam, -1);
                            }
                            player_atk.session.service.meLoadInfo();
                        }
                        this.zone.mobAttackPlayer(mobId, player_atk.charID, player_atk.cHP, -1);
                    }
                }
                this.milisecondAttackPlayer = 1000;
            } else {
                this.milisecondAttackPlayer -= this.zone.map.delays;
            }
        }
        if (!this.removeWhenDie) {
            //Live
            if (this.isDie && !this.isMobNew() && this.milisecondLive <= System.currentTimeMillis() && !this.zone.map.isMapDestronGas() && !this.zone.map.isMapDoanhTrai() && !this.zone.map.isMapKhoBau()) {
                live(Util.gI().nextInt(3), 0, -1);
                this.zone.mobLive(mobId, sys, this.levelBoss, hp);
            }
            //Live Bao Ve
            if (this.isDie && !this.isMobNew() && this.milisecondLive <= System.currentTimeMillis() && this.zone.map.isMapDoanhTrai() && this.templateId == 22) {
                Char o = this.zone.findBossInMapById(46);
                if (o != null && !o.isDie) {
                    live(Util.gI().nextInt(3), 0, -1);
                    this.zone.mobLive(mobId, sys, this.levelBoss, hp);
                }
            }
        }
        //Troi mat
        if (this.mili_seconds > 0) {
            this.mili_seconds -= this.zone.map.delays;
            if (this.mili_seconds <= 0) {
                this.mili_seconds = 0;
                this.isFreez = false;
            }
        }
        //Mu
        if (this.time_blindEff > 0) {
            this.time_blindEff -= this.zone.map.delays;
            if (this.time_blindEff <= 0) {
                this.hold(0, 0, 40, -1);
            }
        }
        //Ru ngu
        if (this.time_sleepEff > 0) {
            this.time_sleepEff -= this.zone.map.delays;
            if (this.time_sleepEff <= 0) {
                this.hold(0, 0, 41, -1);
            }
        }
        //Troi
        if (this.time_holder > 0) {
            this.time_holder -= this.zone.map.delays;
            if (this.time_holder <= 0) {
                Char player443 = this.zone.findCharInMap(this.holder_charId);
                if (player443 != null) {
                    player443.hold(0, 0, 32, -1, -1);
                }
                this.hold(0, 0, 32, -1);
            }
        }
        //Bien socola
        if (this.time_setBody > 0) {
            this.time_setBody -= this.zone.map.delays;
            if (this.time_setBody <= 0) {
                this.clearBody();
                this.zone.changeMobBody(0, mobId, 0);
            }
        }
        if (this.timeDownHutHPKI5 > 0) {
            this.timeDownHutHPKI5 -= this.zone.map.delays;
            if (this.timeDownHutHPKI5 <= 0) {
                timeDownHutHPKI5 = 0;
            }
        }
        this.timeUpHp += this.zone.map.delays;
        if (this.timeUpHp >= 10000) {
            if (!this.isDie && this.hp < this.maxHp && !this.isMobNew()) {
                this.hp += (int)((float)this.maxHp * 0.3F);
                if (this.hp > this.maxHp) {
                    this.hp = this.maxHp;
                }
                this.zone.mobHP(this.mobId, hp, 1, false, -1);
            }
            this.timeUpHp = 0;
        }
        this.timeTDMPB -= this.zone.map.delays;
        if (this.timeTDMPB <= 0) {
            this.timeTDMPB = 1000;
            if ((this.smallBody == 11183 || this.smallBody == 11192 || this.smallBody == 11173) && !this.isDie) {
                this.AttackMob(this.playerTDMPB, this.damageTDMPB, false, 2, -1);
            }
        }
    }
    
    public void live(int sys, int levelBoss, int setHP) {
        this.isDie = false;
        this.status = 5;
        this.levelBoss = (byte) levelBoss;
        if (setHP != -1) {
            this.hp = this.maxHp = setHP;
        } else {
            this.hp = this.maxHp = Mob.arrMobTemplate[this.templateId].hp;
        }
        if (levelBoss > 0) {
            if (levelBoss == 1) {
                this.hp = this.maxHp = this.maxHp * 10;
            }
            if (levelBoss == 2) {
                this.hp = this.maxHp = this.maxHp * 20;
            }
            if (levelBoss == 3) {
                this.hp = this.maxHp = this.maxHp * 12;
            }
        }
        this.claerDam();
        this.claerAtt();
    }
    
    public void hold(int effID, int time, int holdEffID, int playerId) {
        if (holdEffID == 32) {
            this.holder_charId = playerId;
            if (effID == 1) {
                this.holder = true;
                this.time_holder = time;
            } else {
                this.holder = false;
                this.time_holder = 0;
            }
        }
        if (holdEffID == 40) {
            if (effID == 1) {
                this.blindEff = true;
                this.time_blindEff = time;
            } else {
                this.blindEff = false;
                this.time_blindEff = 0;
            }
        }
         if (holdEffID == 41) {
            if (effID == 1) {
                this.sleepEff = true;
                this.time_sleepEff = time;
            } else {
                this.sleepEff = false;
                this.time_sleepEff = 0;
            }
        }
        this.zone.holdMob(effID, holdEffID, this.mobId, playerId);
    }
    
    public void updateFreez(boolean isFreez, int time) {
        this.isFreez = isFreez;
        this.mili_seconds = time;
    }
    
    public void setBody(short id, int time) {
        this.changBody = true;
        this.smallBody = id;
        this.time_setBody = time;
        this.zone.changeMobBody(1, this.mobId, this.smallBody);
    }
    
    public void clearBody() {
        this.changBody = false;
        this.smallBody = -1;
        this.time_setBody = 0;
    }
    
    public int damGoc() {
        switch(this.templateId) {
            case 1:
            case 2:
            case 3:
                return Util.gI().nextInt(8, 10);
            case 4:
            case 5:
            case 6:
                return Util.gI().nextInt(15, 20);
            case 7:
            case 8:
            case 9:
                return Util.gI().nextInt(20, 35);
            case 10:
            case 11:
            case 12:
                return Util.gI().nextInt(50, 76);
            case 13:
            case 14:
            case 15:
                return Util.gI().nextInt(250, 400);
            case 16:
            case 17:
            case 18:
                return Util.gI().nextInt(80, 150);
            case 19:
            case 20:
            case 21:
                return Util.gI().nextInt(400, 1000);
            case 22:
            case 23:
            case 24:
                return Util.gI().nextInt(450, 700);
            case 25:
            case 26:
            case 27:
                return Util.gI().nextInt(2000, 3500);
            case 28:
            case 29:
            case 30:
                return Util.gI().nextInt(80, 150);
            case 31:
            case 32:
            case 33:
                return Util.gI().nextInt(250, 450);
                //
            case 39:
                return Util.gI().nextInt(2200, 3500);
            case 40:
                return Util.gI().nextInt(3200, 5000);
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
                return Util.gI().nextInt(5000, 15000);
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
                return Util.gI().nextInt(5000, 15000);
            case 66:
            case 67:
            case 68:
            case 69:
                return Util.gI().nextInt(20000, 50000);
            case 78:
            case 79:
                return Util.gI().nextInt(30000, 50000);   
            case 86:
            case 87:
                return Util.gI().nextInt(50000, 75000);     
            default:
                return this.maxHp / (this.zone.map.isMapRoadSnake() ? 300 : 100);
        }
    }
    
    public int damExp() {
        if (this.zone.map.isMapRoadSnake() && (this.templateId == 24 || this.templateId == 25|| this.templateId == 26|| this.templateId == 33|| this.templateId == 49|| this.templateId == 50)) {
            return 120000;
        }
        switch(this.templateId) {
            case 0:
                return 1;
            case 1:
            case 2:
            case 3:
                return 200;
            case 4:
            case 5:
            case 6:
                return 300;
            case 7:
            case 8:
            case 9:
                return 350;
            case 10:
            case 11:
            case 12:
                return 500;
            case 13:
            case 14:
            case 15:
                return 650;
            case 16:
            case 17:
            case 18:
                return 550;
            case 19:
            case 20:
            case 21:
                return 1500;
            case 22:
            case 23:
            case 24:
                return 800;
            case 25:
            case 26:
            case 27:
                return 3000;
            case 28:
            case 29:
            case 30:
                return 520;
            case 31:
            case 32:
            case 33:
                return 850;
            case 34:
                return 70000;
             case 35:
                return 80000;
            case 36:
                return 90000;
            case 37:
                return 100000;
            case 38:
                return 110000;
                //Hieu
            case 39:
                return 8500;
            case 40:
                return 12500;
            case 41:
                return 15000;
            case 42:
                return 17500;
            case 43:
                return 25000;
            case 44:
                return 27500;
            case 45:
                return 30000;
            case 46:
                return 32500;
            case 47:
                return 35000;
            case 48:
                return 37500;
            case 49:
                return 40000;
            case 50:
                return 42500;
            case 51:
                return 45000;
            case 52:
                return 47500;
            case 53:
                return 50000;
            case 54:
                return 52500;
            case 55:
                return 55000;
            case 56:
                return 60000;
            case 57:
                return 62500;
            case 58:
                return 70000;
            case 59:
                return 75000;
            case 60:
                return 80000;
            case 61:
                return 85000;
            case 62:
                return 90000;
            case 63:
                return 92500;
            case 64:
                return 95000;
            case 65:
                return 100000;
            case 66:
                return 125000;
            case 67:
                return 135000;
            case 68:
                return 145000;
            case 69:
                return 150000;
                //nguc tu
            case 78:
                return 120000;
            case 79:
                return 130000;
            case 86:
                return 140000;
            case 87:
                return 150000;         
            default:
                return 0;//this.maxHp;
        }
    }
    
    public boolean isMobAttack(Char player) {
        return /*!player.isInvisible && */!player.isInvisiblez && !player.isDie && !player.isMobproactive && (!player.isTemplate || (player.isTemplate && ((Player)player).charTemplate.type == 7));
    }
    
    public boolean isBigBoss() {
        return this.templateId == 70;
    }
    
    public boolean isBachTuoc() {
        return this.templateId == 71;
    }
    
    public boolean isBigBoss2() {
        return this.templateId == 72;
    }
    
    public boolean isNewBoss() {
        return this.isBoss;
    }
    
    public boolean isMobNew() {
        return this.isBigBoss() || this.isBigBoss2() || this.isBachTuoc() || this.isNewBoss();
    }
    
    public static NewBoss getNewBoss(ZoneMap zone, int idBoss) {
        synchronized (zone.mobs) {
            Mob mob = zone.mobs.get(idBoss);
            if (mob.isNewBoss()) {
                return (NewBoss)mob;
            }
        }
        return null;
    }
    
    public static BigBoss getBigBoss(ZoneMap zone) {
        synchronized (zone.mobs) {
            for (int i = 0; i < zone.mobs.size(); i++) {
                Mob mob = zone.mobs.get(i);
                if (mob.isBigBoss()) {
                    return (BigBoss)mob;
                }
            }
        }
        return null;
    }
    
    public static BachTuoc getBachTuoc(ZoneMap zone) {
        synchronized (zone.mobs) {
            for (int i = 0; i < zone.mobs.size(); i++) {
                Mob mob = zone.mobs.get(i);
                if (mob.isBachTuoc()) {
                    return (BachTuoc)mob;
                }
            }
        }
        return null;
    }
    
    public static BigBoss2 getBigBoss2(ZoneMap zone) {
        synchronized (zone.mobs) {
            for (int i = 0; i < zone.mobs.size(); i++) {
                Mob mob = zone.mobs.get(i);
                if (mob.isBigBoss2()) {
                    return (BigBoss2)mob;
                }
            }
        }
        return null;
    }
    
    public boolean isMobFly() {
        return Mob.arrMobTemplate[this.templateId].type == 4;
    }
    
    public boolean isMobSoil() {
        return Mob.arrMobTemplate[this.templateId].type == 1;
    }
    
    public boolean isMobMonkey() {
        return this.templateId == 54 || this.templateId == 55 || this.templateId == 56;
    }
}
