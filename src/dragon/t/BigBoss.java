package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class BigBoss extends Mob {
    
    private boolean isLaser;
    private int timeLaser;
    private final ArrayList<Integer> aCharFocus = new ArrayList<>();
    private final ArrayList<Integer> aCharDam = new ArrayList<>();
    private boolean isMove;
    private int timeMove;
    
    public BigBoss(int mobId, int mobTemplateId, int level, int pointx, int pointy) {
        super(mobId, mobTemplateId, level, pointx, pointy);
    }
    
    @Override
    public void update() {
        super.update();
        if ((super.milisecondAttackPlayer <= 0 && this.timeLaser <= 0) || this.isLaser) {
            if (super.status != 0 && super.status != 1 && !super.isDie && !super.isFreez && !super.sleepEff && !super.holder) {
                if (super.zone.players.size() > 0) {
                    if (this.isLaser) {
                        this.isLaser = false;
                        this.aCharFocus.clear();
                        this.aCharDam.clear();
                        int i;
                        synchronized (super.zone.players) {
                            for (i = 0; i < super.zone.players.size(); i++) {
                                if (super.isMobAttack(super.zone.players.get(i))) {
                                    this.aCharFocus.add(super.zone.players.get(i).charID);
                                    this.aCharDam.add((int)((long)super.zone.players.get(i).cHPFull * 30l / 100l));
                                }
                            }
                        }
                        for (i = 0; i < this.aCharFocus.size(); i++) {
                            this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), super.zone.findCharInMap(this.aCharFocus.get(i))));
                        }
                        super.zone.bigBossAttack(0, this.aCharFocus, this.aCharDam);
                    } else {
                        //Da
                        if (Util.gI().nextInt(100) < 40) {
                            Char player_atk;
                            synchronized (super.zone.players) {
                                player_atk = super.zone.players.get(Util.gI().nextInt(super.zone.players.size()));
                            }
                            if (super.isMobAttack(player_atk)) {
                                this.aCharFocus.clear();
                                this.aCharDam.clear();
                                this.aCharFocus.add(player_atk.charID);
                                this.aCharDam.add((int)((long)player_atk.cHPFull * 20l / 100l));
                                int i;
                                for (i = 0; i < this.aCharFocus.size(); i++) {
                                    this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), super.zone.findCharInMap(this.aCharFocus.get(i))));
                                }
                                super.pointx = (short) player_atk.cx;
                                super.zone.bigBossMove(super.pointx, super.zone.mapTemplate.touchY(super.pointx, 150));
                                super.zone.bigBossAttack(1, this.aCharFocus, this.aCharDam);
                            }
                        }
                        //Nhay
                        else if (Util.gI().nextInt(100) < 5)
                        {
                            this.aCharFocus.clear();
                            this.aCharDam.clear();
                            int i;
                            synchronized (super.zone.players) {
                                for (i = 0; i < super.zone.players.size(); i++) {
                                    if (super.isMobAttack(super.zone.players.get(i))) {
                                        this.aCharFocus.add(super.zone.players.get(i).charID);
                                        this.aCharDam.add((int)((long)super.zone.players.get(i).cHPFull * 20l / 100l));
                                    }
                                }
                            }
                            for (i = 0; i < this.aCharFocus.size(); i++) {
                                this.aCharDam.set(i, super.atkPlayer(this.aCharDam.get(i), super.zone.findCharInMap(this.aCharFocus.get(i))));
                            }
                            super.zone.bigBossAttack(2, this.aCharFocus, this.aCharDam);
                        }
                        //Laze
                        else if ((super.sys == 1 || super.sys == 0) && Util.gI().nextInt(100) < 10)
                        {
                            super.zone.bigBossAttack();
                            this.timeLaser = 3000;
                        }
                    }
                }
            }
            super.milisecondAttackPlayer = 1000;
        } else {
            super.milisecondAttackPlayer -= super.zone.map.delays;
        }
        //Di lai
        if (!super.isDie && !super.holder && !super.sleepEff && !super.blindEff && !super.isFreez && this.timeLaser <= 0) {
            if (Util.gI().nextInt(1000) < 5 || super.pointx == -1000) {
                super.pointx = (short) Util.gI().nextInt(50, super.zone.mapTemplate.pxw - 50);
                super.zone.bigBossFly(super.pointx, super.pointy = super.zone.mapTemplate.touchY(super.pointx, 150));
            } else if (Util.gI().nextInt(1000) < 5) {
                super.pointx += Util.gI().nextInt(-100, 100);
                if (super.pointx < 50) {
                    super.pointx = 50;
                }
                if (super.pointx > super.zone.mapTemplate.pxw - 30) {
                    super.pointx = (short) (super.zone.mapTemplate.pxh - 30);
                }
                super.zone.bigBossMove(super.pointx, super.pointy = super.zone.mapTemplate.touchY(super.pointx, 150));
            }
        }
        //Live
        if (super.isDie && super.milisecondLive <= System.currentTimeMillis()) {
            if (super.sys < 2) {
                live(super.sys++, 0, -1);
                if (super.sys == 1) {
                    super.zone.bigBossB2(super.pointx, super.pointy);
                }
                if (super.sys == 2) {
                    super.zone.bigBosshaftBody();
                }
                super.zone.mobLive(super.mobId, super.sys, super.levelBoss, super.hp);
            }
        }
        if (this.timeLaser > 0) {
            this.timeLaser -= super.zone.map.delays;
            if (this.timeLaser < 0) {
                this.timeLaser = 0;
                this.isLaser = true;
            }
        }
        if (this.timeMove > 0) {
            this.timeMove -= super.zone.map.delays;
            if (this.timeMove <= 0) {
                super.pointx = super.pointy = -1000;
                super.zone.bigBossMove();
            }
        }
        if (super.sys == 2 && !this.isMove && super.isDie) {
            this.isMove = true;
            this.timeMove = 5000;
        }
    }
    
}
