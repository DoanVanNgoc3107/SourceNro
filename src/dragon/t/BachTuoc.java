package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class BachTuoc extends Mob {
    
    private final ArrayList<Char> aChar = new ArrayList<>();
    private int timeMove;
    private boolean isMove;
    
    public BachTuoc(int mobId, int mobTemplateId, int level, int pointx, int pointy) {
        super(mobId, mobTemplateId, level, pointx, pointy);
    }
    
    @Override
    public void update() {
        super.update();
        if (super.milisecondAttackPlayer <= 0) {
            if (super.status != 0 && super.status != 1 && !super.isDie && !super.isFreez && !super.sleepEff && !super.holder) {
                if (Util.gI().nextInt(100) < 60) {
                    this.rock();
                } else {
                    this.away();
                }
            }
            super.milisecondAttackPlayer = 1000;
        } else {
            super.milisecondAttackPlayer -= super.zone.map.delays;
        }
        if (this.timeMove > 0) {
            this.timeMove -= super.zone.map.delays;
            if (this.timeMove <= 0) {
                super.pointx = super.pointy = -1000;
                super.zone.bachtuochaftBody();
            }
        }
        if (!this.isMove && super.isDie) {
            this.isMove = true;
            this.timeMove = 5000;
        }
        if (super.status != 0 && super.status != 1 && !super.isDie && !super.isFreez && !super.sleepEff && !super.holder && Util.gI().nextInt(100) < 50) {
            short toX = (short) Util.gI().nextInt(super.pointx - 50, super.pointx + 50);
            if (toX > super.firstx + 200) {
                toX = (short) (super.firstx + 200);
            } else if (toX < super.firstx - 200) {
                toX = (short) (super.firstx - 200);
            }
            this.move(toX);
        }
    }
    
    public void move(short x) {
        super.pointx = x;
        super.zone.bachtuocMove(x);
    }
    
    public void away() {
        this.aChar.clear();
        int i;
        synchronized (super.zone.players) {
            for (i = 0; i < super.zone.players.size(); i++) {
                if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.pointx - super.zone.players.get(i).cx) < 150 && Math.abs(super.zone.players.get(i).cy - super.pointy) < 24) {
                    if (this.aChar.isEmpty()) {
                        this.aChar.add(super.zone.players.get(i));
                    } else if (super.pointx > this.aChar.get(0).cx && super.pointx >= super.zone.players.get(i).cx) {
                        this.aChar.add(super.zone.players.get(i));
                    } else if (super.pointx <= super.zone.players.get(i).cx) {
                        this.aChar.add(super.zone.players.get(i));
                    }
                }
            }
        }
        if (this.aChar.isEmpty()) {
            return;
        }
        int[] array = new int[this.aChar.size()];
        int[] array2 = new int[this.aChar.size()];
        for (i = 0; i < this.aChar.size(); i++) {
            array[i] = this.aChar.get(i).charID;
            array2[i] = super.atkPlayer(super.maxHp / 100, this.aChar.get(i));
        }
        super.zone.bachtuocAway(array, array2);
    }
    
    public void rock() {
        this.aChar.clear();
        int i;
        synchronized (super.zone.players) {
            for (i = 0; i < super.zone.players.size(); i++) {
                if (this.aChar.size() == 1) {
                    break;
                }
                if (super.isMobAttack(super.zone.players.get(i)) && Math.abs(super.firstx - super.zone.players.get(i).cx) < 200 && Math.abs(super.firsty - super.zone.players.get(i).cy) < 50) {
                    this.aChar.add(super.zone.players.get(i));
                }
            }
        }
        if (this.aChar.isEmpty()) {
            return;
        }
        int[] array = new int[this.aChar.size()];
        int[] array2 = new int[this.aChar.size()];
        for (i = 0; i < this.aChar.size(); i++) {
            array[i] = this.aChar.get(i).charID;
            array2[i] = super.atkPlayer(super.maxHp / 200, this.aChar.get(i));
        }
        super.pointx = (short) this.aChar.get(0).cx;
        super.pointy = zone.mapTemplate.touchY(this.aChar.get(0).cx, this.aChar.get(0).cy);
        zone.bachtuocRock(array, array2);
    }
    
}
