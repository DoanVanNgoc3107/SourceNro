package dragon.t;

import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class Piano extends NewBoss {
    
    
    private boolean isMove;
    private int timeMove;
    private final ArrayList<Char> aCharFocus = new ArrayList<>();
    private final ArrayList<Integer> aCharDam = new ArrayList<>();
    private int gameTick;
    private long recoverHP;
    private boolean isRecover;
    private int timeRecover;
    
    public Piano(int pointx, int pointy) {
        super(0, 85, 0, pointx, pointy);
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
                //Dam thuong
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 100 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 50) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add(500000);
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
                //Giat dien
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && super.isDir(super.zone.players.get(i).cx) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 120 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 80) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add(100000);
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
                //Qua cau red bummm
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 150 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 150) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add((int)((float)super.zone.players.get(i).cHPFull * 0.2F));
                            }
                        }
                    }
                    if (!this.aCharFocus.isEmpty()) {
                        int rand = Util.gI().nextInt(this.aCharFocus.size());
                        for (int i = 0; i < this.aCharFocus.size(); i++) {
                            if (i == rand) {
                                this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), this.aCharFocus.get(i)));
                            }
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
                //Giat dien xung quanh
                if (Util.gI().nextInt(100) < 10) {
                    this.aCharFocus.clear();
                    this.aCharDam.clear();
                    synchronized (super.zone.players) {
                        for (int i = 0; i < super.zone.players.size(); i++) {
                            if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 130 && Math.abs(super.pointy - super.zone.players.get(i).cy) < 100) {
                                this.aCharFocus.add(super.zone.players.get(i));
                                this.aCharDam.add(150000);
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

                //Di chuyen
                if (this.gameTick % 20 == 0) {
                    int sendX = Util.gI().nextInt(super.pointx - 200, super.pointx + 200);
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
        for (int i = 0, num = 0; i < array.length; i++) {
            Char player = super.zone.findCharInMap(array[i][0]);
            if (player != null && !player.isgiaodich && player.getQuantityItem(874) < 3) {
                Item item = new Item(874, false, 1, ItemOption.getOption(874, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                player.addItemBag(0, item);
                if (++num == 5) {
                    break;
                }
            }
        }
        for (int i = 0, num = 0; i < array.length; i++) {
            Char player = super.zone.findCharInMap(array[i][0]);
            if (player != null && !player.isgiaodich ) {
                Item item = new Item(1231, false, 1, ItemOption.getOption(1231, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                player.addItemBag(0, item);
                if (++num == 3) {
                    break;
                }
            }
        }
        for (int i = 0, num = 0; i < array.length; i++) {
            Char player = super.zone.findCharInMap(array[i][0]);
            if (player != null && !player.isgiaodich ) {
                short id2003 = new short[] {1150, 1152, 1153}[Util.gI().nextInt(3)]; 
                Item item = new Item(id2003, false, 1, ItemOption.getOption(id2003, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                player.addItemBag(0, item);
                if (++num == 10) {
                    break;
                }
            }
        }
        //qua phu tai day neu roi ra map
        // vang
        for (int i = 0; i < 3; i++) {
            int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
        // ve quay vang
        for (int i = 0; i < 3; i++) {
            int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(821, false, 1, ItemOption.getOption(821, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
        // bo khi
        for (int i = 0; i < 3; i++) {
            int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(383, false, 1, ItemOption.getOption(383, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
         // bo huyet
        for (int i = 0; i < 3; i++) {
            int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(382, false, 1, ItemOption.getOption(382, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
         // Cuong no
        for (int i = 0; i < 3; i++) {
            int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(381, false, 1, ItemOption.getOption(381, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
        // Da linh luc
        for (int i = 0; i < 3; i++) {
           int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(700, false, 2, ItemOption.getOption(700, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
        // 5 sao
        for (int i = 0; i < 3; i++) {
           int toX = Util.gI().nextInt(this.pointx - 250, this.pointx + 250);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(18, false, 1, ItemOption.getOption(18, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
        // ngoc xanh
        for (int i = 0; i < 20; i++) {
            int toX = Util.gI().nextInt(this.pointx - 100, this.pointx + 100);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(77, false, 5, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
        //Bi Kip Tuyet Ky
        for (int i = 0; i < 5; i++) {
            int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
            int toY = zone.mapTemplate.touchY(toX, this.pointy);
            ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
            itemMaps.add(itemMap);
        }
        // roi do ket lieu
        // 3 sao
        if (Util.gI().nextInt(100) <= 30) {
            for (int i = 0; i < 1; i++) {
                int toX = Util.gI().nextInt(this.pointx - 24, this.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(15, false, 1, ItemOption.getOption(15, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
        // manh than linh 
        if (Util.gI().nextInt(100) <= 20) {
            for (int i = 0; i < 5; i++) {
                int toX = Util.gI().nextInt(this.pointx - 150, this.pointx + 150);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                short id1998 = new short[] {712, 714, 715, 716}[Util.gI().nextInt(4)];
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(id1998, false, 1, ItemOption.getOption(id1998, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
        // ao than linh va giay than linh
        if (Util.gI().nextInt(100) <= 2) {
            for (int i = 0; i < 1; i++) {
                short[] arrItem = new short[]{555,557,559,563,565,567};
                int itemTemplateId = arrItem[Util.gI().nextInt(arrItem.length)];
                int toX = Util.gI().nextInt(this.pointx - 50, this.pointx + 50);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemTemplateId, false, 1, ItemOption.getOption(itemTemplateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
        // gang than linh
        if (Util.gI().nextInt(200) <= 1) {
            for (int i = 0; i < 1; i++) {
                short[] arrItem = new short[]{562, 564, 566};
                int itemTemplateId = arrItem[Util.gI().nextInt(arrItem.length)];
                int toX = Util.gI().nextInt(this.pointx - 50, this.pointx + 50);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemTemplateId, false, 1, ItemOption.getOption(itemTemplateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
        // quan than linh
        if (Util.gI().nextInt(500) <= 1) {
            for (int i = 0; i < 1; i++) {
                short[] arrItem = new short[]{556, 558, 560};
                int itemTemplateId = arrItem[Util.gI().nextInt(arrItem.length)];
                int toX = Util.gI().nextInt(this.pointx - 50, this.pointx + 50);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemTemplateId, false, 1, ItemOption.getOption(itemTemplateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
        // nhan than linh
        if (Util.gI().nextInt(500) <= 1) {
            for (int i = 0; i < 1; i++) {
                int toX = Util.gI().nextInt(this.pointx - 24, this.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(561, false, 1, ItemOption.getOption(561, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
        // gay thuong de
        if (Util.gI().nextInt(100) <= 10) {
            for (int i = 0; i < 2; i++) {
                int toX = Util.gI().nextInt(this.pointx - 100, this.pointx + 100);
                int toY = zone.mapTemplate.touchY(toX, this.pointy);
                ItemMap itemMap = zone.addItemMap(-1, new Item(1231, false, 1, ItemOption.getOption(1231, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
    }
    
    @Override
    public int AttackMob(Char charz, int dam, boolean flag, int type, int effId) {
        dam =  super.AttackMob(charz, dam, flag, type, effId);
        return dam;
    }
    
    @Override
    public boolean isSuckHP() {
        return false;
    }

    @Override
    public boolean isReDamge() {
        return false;
    }
}
