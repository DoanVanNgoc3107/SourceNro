package dragon.t;

import java.util.ArrayList;


/**
 *
 * @author TGDD
 */
public class NewBoss extends Mob {
    
    public NewBoss(int mobId, int mobTemplateId, int level, int pointx, int pointy) {
        super(mobId, mobTemplateId, level, pointx, pointy);
        super.isBoss = true;
    }
    
    @Override
    public void update() {
        super.update();
    }
    
    @Override
    public void startDie() {
        if (super.hp > 0)
            super.zone.mobDie(super.mobId, super.hp, false, new ArrayList<>());
        super.startDie();
        super.zone.removeMob2(this);
    }
    
    public boolean isDir(int x) {
        return (super.dir == 1 && x >= super.pointx) || (super.dir == -1 && x <= super.pointx);
    }
    
    public void move(int sendX, int sendY) {
        if (sendX > super.pointx) {
            super.dir = 1;
        } else {
            super.dir = -1;
        }
        super.pointx = (short) sendX;
        if (super.pointx < 50) {
            super.pointx = 50;
        }
        if (super.pointx > super.zone.mapTemplate.pxw - 50) {
            super.pointx = (short) (super.zone.mapTemplate.pxw - 50);
        }
        super.pointy = super.zone.mapTemplate.touchY(super.pointx, sendY);
        super.zone.newBossMoveTo(super.mobId, super.pointx, super.pointy);
    }
    
    public void setFly(int sendX, int sendY) {
        if (sendX > super.pointx) {
            super.dir = 1;
        } else {
            super.dir = -1;
        }
        super.pointx = (short) sendX;
        if (super.pointx < 50) {
            super.pointx = 50;
        }
        if (super.pointy > super.zone.mapTemplate.pxw - 50) {
            super.pointx = (short) (super.zone.mapTemplate.pxw - 50);
        }
        super.pointy = super.zone.mapTemplate.touchY(super.pointx, sendY);
        super.zone.newBossFlyTo(super.mobId, super.pointx, super.pointy);
    }
    
}
