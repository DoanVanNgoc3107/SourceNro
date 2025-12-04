package dragon.t;

import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class ConGau extends NewBoss {
    
    private boolean isMove;
    private int timeMove;
    private final ArrayList<Char> aCharFocus = new ArrayList<>();
    private final ArrayList<Integer> aCharDam = new ArrayList<>();
    private int gameTick;
    private long recoverHP;
    private boolean isRecover;
    private int timeRecover;
    
    public ConGau(int pointx, int pointy) {
        super(0, 77, 0, pointx, pointy);
    }
    
    @Override
    public void update() {
        super.update();
        this.gameTick++;
        if (this.timeMove > 0) {
            this.timeMove -= super.zone.map.delays;
            if (this.timeMove <= 0) {
                this.timeMove = 0;
            }
        }
        if (super.status != 0 && super.status != 1 && !super.isDie && !super.isFreez && !super.sleepEff && !super.holder && this.timeMove <= 0) {
            attk:
            {
                //chem dao
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 100 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 50) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add(200000);
                                break;
                            }
                        }
                    }
                    if (!this.aCharFocus.isEmpty()) {
                        for (int i = 0; i < this.aCharFocus.size(); i++) {
                            this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), this.aCharFocus.get(i)));
                        }
                        if (!this.aCharFocus.isEmpty()) {
                            if (this.aCharFocus.get(0).cx > super.pointx) {
                                super.dir = 1;
                            } else {
                                super.dir = -1;
                            }
                        }
                        super.zone.newBossSetAttack(0, super.mobId, this.aCharFocus, this.aCharDam, super.dir);
                        this.timeMove = 1000;
                    }
                }
                //chem dao quay
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 300 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 150) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add(100000);
                                break;
                            }
                        }
                    }
                    if (!this.aCharFocus.isEmpty()) {
                        for (int i = 0; i < this.aCharFocus.size(); i++) {
                            this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), this.aCharFocus.get(i)));
                        }
                        if (!this.aCharFocus.isEmpty()) {
                            if (this.aCharFocus.get(0).cx > super.pointx) {
                                super.dir = 1;
                            } else {
                                super.dir = -1;
                            }
                        }
                        super.zone.newBossSetAttack(1, super.mobId, this.aCharFocus, this.aCharDam, super.dir);
                        this.timeMove = 1000;
                        break attk;
                    }
                }
                //chem ki
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 300 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 150) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add(150000);
                                break;
                            }
                        }
                    }
                    if (!this.aCharFocus.isEmpty()) {
                        for (int i = 0; i < this.aCharFocus.size(); i++) {
                            this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), this.aCharFocus.get(i)));
                        }
                        if (!this.aCharFocus.isEmpty()) {
                            if (this.aCharFocus.get(0).cx > super.pointx) {
                                super.dir = 1;
                            } else {
                                super.dir = -1;
                            }
                        }
                        super.zone.newBossSetAttack(2, super.mobId, this.aCharFocus, this.aCharDam, super.dir);
                        this.timeMove = 1000;
                        break attk;
                    }
                }
                //chem ki
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 300 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 150) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add(150000);
                                break;
                            }
                        }
                    }
                    if (!this.aCharFocus.isEmpty()) {
                        for (int i = 0; i < this.aCharFocus.size(); i++) {
                            this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), this.aCharFocus.get(i)));
                        }
                        if (!this.aCharFocus.isEmpty()) {
                            if (this.aCharFocus.get(0).cx > super.pointx) {
                                super.dir = 1;
                            } else {
                                super.dir = -1;
                            }
                        }
                        super.zone.newBossSetAttack(3, super.mobId, this.aCharFocus, this.aCharDam, super.dir);
                        this.timeMove = 1000;
                        break attk;
                    }
                }
                //chem toan map
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 200 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 200) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add((int)((float)super.zone.players.get(i).cHPFull * 0.2F));
                            }
                        }
                    }
                    if (!this.aCharFocus.isEmpty()) {
                        for (int i = 0; i < this.aCharFocus.size(); i++) {
                            this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), this.aCharFocus.get(i)));
                        }
                        if (!this.aCharFocus.isEmpty()) {
                            if (this.aCharFocus.get(0).cx > super.pointx) {
                                super.dir = 1;
                            } else {
                                super.dir = -1;
                            }
                        }
                        super.zone.newBossSetAttack(4, super.mobId, this.aCharFocus, this.aCharDam, super.dir);
                        this.timeMove = 3000;
                        break attk;
                    }
                }

                //Di chuyen
                if (this.gameTick % 20 == 0) {
                    int sendX = Util.gI().nextInt(super.pointx - 500, super.pointx + 500);
                    super.move(sendX, 150);
                    this.timeMove = 1000;
                    break attk;
                }
            }
            //phuc hoi hp
            if (!this.isDie) {
                if (!this.isRecover && super.hp < 1000000000) {
                    this.isRecover = true;
                }
                if (this.isRecover && this.recoverHP < 5000000000L) {
                    this.timeRecover -= super.zone.map.delays;
                    if (this.timeRecover <= 0) {
                        this.timeRecover = 500;
                        int hpAdd = (int)((float)super.maxHp * 0.05F);
                        super.hp += hpAdd;
                        if (super.hp > super.maxHp) {
                            super.hp = super.maxHp;
                            this.isRecover = false;
                        }
                        this.recoverHP += hpAdd;
                        super.zone.mobHP(super.mobId, super.hp, 1, false, -1);
                    }
                }
            }
        }
    }
    
    @Override
    public void fallItem(Char target, ArrayList<ItemMap> itemMaps, int type, int charMaxDam) {
        
        int[][] array = super.sortCharIdDam();
        int num = 0;
        int num2 = 0;
        while (num2 < array.length) {
            Char player = super.zone.findCharInMap(array[num2][0]);
            if (player != null && !player.isgiaodich && player.getQuantityItem(874) < 3) {
                Item item = new Item(874, false, 1, ItemOption.getOption(874, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                player.addItemBag(0, item);
                if (++num == 5) {
                    break;
                }
            }
            num2++;
        }
        //qua phu tai day neu roi ra map
        //Manh da vun
        if (Util.gI().nextInt(100) <= 2) {
            for (int i = 0; i < 1; i++) {
                int toX = Util.gI().nextInt(this.pointx - 24, this.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
    }
    
    @Override
    public int AttackMob(Char charz, int dam, boolean flag, int type, int effId) {
        dam =  super.AttackMob(charz, dam, flag, type, effId);
        return dam;
    }
    
}
