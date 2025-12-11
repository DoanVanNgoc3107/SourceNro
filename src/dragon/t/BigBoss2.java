package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class BigBoss2 extends Mob {

    private final ArrayList<Char> aChar = new ArrayList<>();
    private int timeMove;
    private boolean isMove;

    public BigBoss2(int mobId, int mobTemplateId, int level, int pointx, int pointy) {
        super(mobId, mobTemplateId, level, pointx, pointy);
    }

    @Override
    public void update() {
        super.update();
        if (super.milisecondAttackPlayer <= 0) {
            if (super.status != 0 && super.status != 1 && !super.isDie && !super.isFreez && !super.sleepEff
                    && !super.holder) {
                if (Util.gI().nextInt(100) < 50) {
                    this.away();
                } else if (Util.gI().nextInt(100) < 50) {
                    this.fly();
                } else {
                    this.cut();
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
                super.zone.bigBoss2haftBody();
            }
        }
        if (!this.isMove && super.isDie) {
            this.isMove = true;
            this.timeMove = 5000;
        }
    }

    public void cut() {
        this.aChar.clear();
        int i;
        synchronized (super.zone.players) {
            for (i = 0; i < super.zone.players.size(); i++) {
                if (this.aChar.size() == 1) {
                    break;
                }
                if (super.isMobAttack(super.zone.players.get(i))) {
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
        super.pointy = super.zone.mapTemplate.touchY(this.aChar.get(0).cx, this.aChar.get(0).cy);
        super.zone.bigBoss2Cut(array, array2);
    }

    public void away() {
        this.aChar.clear();
        int i;
        synchronized (super.zone.players) {
            for (i = 0; i < super.zone.players.size(); i++) {
                if (super.isMobAttack(super.zone.players.get(i))) {
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
            array2[i] = super.atkPlayer(super.maxHp / 100, this.aChar.get(i));
        }
        super.zone.bigBoss2Away(array, array2);
    }

    public void fly() {
        this.aChar.clear();
        int i;
        synchronized (super.zone.players) {
            for (i = 0; i < super.zone.players.size(); i++) {
                if (this.aChar.size() == 1) {
                    break;
                }
                if (super.isMobAttack(super.zone.players.get(i))) {
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
        super.pointx = (short) this.aChar.getFirst().cx;
        super.pointy = super.zone.mapTemplate.touchY(this.aChar.getFirst().cx, this.aChar.getFirst().cy);
        super.zone.bigBoss2Fly(array, array2);
    }

}
