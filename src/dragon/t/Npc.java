package dragon.t;

import dragon.server.mResources;

/**
 *
 * @author Admin
 */
public class Npc extends Char {
    
    public static NpcTemplate[] arrNpcTemplate;
    
    public boolean isHide;
    public DuaHau duahau = null;
    
    protected int timeInvateMabu;
    private int timeNk;
    private int timeBien;
    
    private int nDadChat;
    private int timeDadChat;
    private int timeDad;
    
    public Npc(int npcId, int status, int cx, int cy, int templateId, int avatar) {
        this.isShadown = true;
        this.npcId = npcId;
        this.avatar = avatar;
        this.cx = cx;
        this.cy = cy;
        this.xSd = cx;
        this.ySd = cy;
        this.statusMe = status;
        if (npcId != -1) {
            this.template = Npc.arrNpcTemplate[templateId];
        }
        if (templateId == 23 || templateId == 42) {
            this.ch = 45;
        }
        if (templateId == 51) {
            this.isShadown = false;
            this.duaHauIndex = status;
        }
    }
    
    public void update(ZoneMap zone) {
        if (super.template.npcTemplateId == 48) {
            this.timeNk = (int) (this.timeNk - zone.map.delays);
            if (this.timeNk <= 0) {
                zone.npcChat(super.template.npcTemplateId, mResources.NGO_KHONG_CHAT_2);
                this.timeNk = 10000;
            }
        }
        if (super.template.npcTemplateId == 18) {
            if (this.isHide) {
                if (!zone.isHaveBoss(54)) {
                    zone.hideNpc(super.template.npcTemplateId, false);
                }
                if (zone.isHaveBoss(54) && zone.countPlayerNotDie() <= 0) {
                    zone.hideNpc(super.template.npcTemplateId, false);
                    ((Player)zone.findBossInMapById(54)).isClear = true;
                }
            }
        }
        if (this.timeInvateMabu > 0) {
            this.timeInvateMabu -= zone.map.delays;
            if (this.timeInvateMabu <= 0) {
                this.timeInvateMabu = 0;
                if (zone.isHaveBoss(80)) {
                    zone.findBossInMapById(80).changeTypePk(5);
                    if (zone.isHaveBoss(82)) {
                        zone.findBossInMapById(82).isClear = true;
                    }
                    zone.npcChat(super.template.npcTemplateId, mResources.SAY_BABIDAY_3);
                }
            }
        }
        if (this.template.npcTemplateId == 46 && zone.map.isMapButcher()) {
            this.timeBien -= zone.map.delays;
            if (timeBien <= 0) {
                this.timeBien = Util.gI().nextInt(30000, 60000);
                Char o = null;
                int i;
                synchronized (zone.players) {
                    for (i = 0; i < zone.players.size(); i++) {
                        Char player = zone.players.get(i);
                        if (player.me && !player.isTemplate && player.IDFlag != 520 && (o == null || (Math.abs(o.cx - super.cx) > Math.abs(player.cx - super.cx)))) {
                            o = player;
                        }
                    }
                }
                if (o != null) {
                    o.changeFlag(Flag.get(520).id);
                    if (o.myPet != null) {
                        o.myPetz().changeFlag(o.cFlag);
                    }
                    if (o.session != null) {
                        o.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_THOI_MIEN, null, 0);
                    }
                    zone.npcChat(super.template.npcTemplateId, String.format(mResources.SAY_BABIDAY_4, o.cName));
                }
            }
        }
        if (this.template.npcTemplateId == 44 && zone.map.isMapButcher()) {
            this.timeBien -= zone.map.delays;
            if (timeBien <= 0) {
                this.timeBien = Util.gI().nextInt(30000, 60000);
                Char o = null;
                int i;
                synchronized (zone.players) {
                    for (i = 0; i < zone.players.size(); i++) {
                        Char player = zone.players.get(i);
                        if (player.me && !player.isTemplate && player.IDFlag != 519 && (o == null || (Math.abs(o.cx - super.cx) > Math.abs(player.cx - super.cx)))) {
                            o = player;
                        }
                    }
                }
                if (o != null) {
                    o.changeFlag(Flag.get(519).id);
                    if (o.myPet != null) {
                        o.myPetz().changeFlag(o.cFlag);
                    }
                    if (o.session != null) {
                        o.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_HOA_GIAI, null, 0);
                    }
                    zone.npcChat(super.template.npcTemplateId, String.format(mResources.SAY_OSIN_4, o.cName));
                }
            }
        }
        //Quang cao Rong Vo Cuc
       if (super.template.npcTemplateId == 64 && !this.isHide) {
           if (this.nDadChat > 0) {
               this.timeDadChat -= zone.map.delays;
               if (this.timeDadChat <= 0) {
                   this.timeDadChat = 5000;
                   if (this.nDadChat == 3) {
                       zone.npcChat(super.template.npcTemplateId, mResources.CHAT_DAD_3);
                   }
                   if (this.nDadChat == 2) {
                       zone.npcChat(super.template.npcTemplateId, mResources.CHAT_DAD_2);
                   }
                   if (this.nDadChat == 1) {
                       zone.npcChat(super.template.npcTemplateId, mResources.CHAT_DAD_1);
                   }
                   if (this.nDadChat == 0) {
                       this.timeDad = 20000;
                   }
                   this.nDadChat--;
               }
           } else {
               this.timeDad -= zone.map.delays;
               if (this.timeDad <= 0) {
                   this.nDadChat = 3;
               }
           }
       }
        //Whis
        if (this.template.npcTemplateId == 56 && this.isHide && !zone.isHaveBoss(147)) {
            zone.hideNpc(56, false);
        }
    }
}
