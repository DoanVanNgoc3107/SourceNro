package dragon.t;

import dragon.server.Server;
import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CallDragon {
    
    private static CallDragon instance;
    
    public static CallDragon gI() {
        if (instance == null) {
            instance = new CallDragon();
        }
        return instance;
    }
    
    public int mapId;
   
    public int bgId;
    
    public int zoneId;
    
    public int charId;
    
    public int playerId;
    
    public int rx;
    
    public int ry;
    
    public boolean isRongThanXuatHien;
    
    public boolean isRongNamek;
    
    public int timeXuatHien;
    
    public int select;
    
    public int status;
    
    public int timeWait;
    
    public static class MenuR extends MenuInfo {
        
        public int typeM;
        public int index;
        
        public MenuR(String str, int type, int index, int typeM) {
            super(str, type);
            this.index = index;
            this.typeM = typeM;
        }
        
    }
    
    public final Object LOCK = new Object();
    
    public String[][] arrDieuUocRongThan = new String[][] {
        {
            "Đẹp trai nhất\nVũ trụ",
            "+20 Tr\nSức mạnh và tiềm năng",
            "Giầu có\n+2 Tỉ Vàng"
        },
        {
            "Thay\nChiêu 2\nĐệ tử"
        },
        {
            "500 hồng ngọc",
            "2 tỉ\nvàng",
            "100 Capsule\nBang hội",
            "+5%\nHP, KI, SĐ\n1 ngày"
        }
    };
    
    public ArrayList<MenuR> menuR = new ArrayList<>();
    
    public void setup(Char charz, ZoneMap zone, int isRongNamek, int status) {
        this.mapId = zone.mapTemplate.mapTemplateId;
        this.bgId = zone.mapTemplate.bgID;
        this.zoneId = zone.zoneID;
        this.charId = charz.charID;
        this.playerId = charz.playerId;
        this.rx = charz.cx;
        this.ry = charz.cy;
        //Loai rong
        this.isRongThanXuatHien = true;
        this.isRongNamek = isRongNamek == 1;
        this.timeXuatHien = 1000 * 60 * 5;
        this.timeWait = 1000 * 60 * 10;
        this.status = status;
        //Send
        Server.gI().rongThan(0, this);
        this.openmenuRong(charz);
//        Server.gI().chatInfo(String.format(mResources.PLAYER_CALL_DRAGON, charz.cName, MapTemplate.arrMapTemplate[mapId].mapName, zoneId));
    }
    
    public void openmenuRong(Char charz) {
        if (this.isRongThanXuatHien && this.playerId == charz.playerId) {
            this.menuR.clear();
            charz.resetMenu();
            charz.menuBoard.chat = mResources.SAY_RONG_THAN_1;
            //menu
            for (int i = 0; i < arrDieuUocRongThan[this.status].length; i++) {
                MenuR mn1 = new MenuR(arrDieuUocRongThan[this.status][i], 105, i, 0);
                this.menuR.add(mn1);
                charz.menuBoard.arrMenu.add(mn1);
            }
            //....
            if (this.status == 0 || this.status == 1) {
                MenuR mn2 = new MenuR(mResources.OTHER_WISH, 105, this.menuR.size(), 1);
                this.menuR.add(mn2);
                charz.menuBoard.arrMenu.add(mn2);
            }
            charz.menuBoard.openUIConfirm(5, null, null, 0);
        }
    }
    
    public void finishCall(Char charz) {
        if (this.isRongThanXuatHien && this.playerId == charz.playerId) {
            if (charz.canProceed()) {
                switch (this.status) {
                    case 0:
                    {
                        //Dep Trai Nhat Vu Tru
                        if (this.select == 0) {
                            if (charz.getEmptyBagCount() == 0) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte)0);
                                return;
                            } else {
                                Item item = null;
                                if (charz.cgender == 0) {
                                    item = new Item(227, false, 1, ItemOption.getOption(227, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                                }
                                if (charz.cgender == 1) {
                                    item = new Item(228, false, 1, ItemOption.getOption(228, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                                }
                                if (charz.cgender == 2) {
                                    item = new Item(229, false, 1, ItemOption.getOption(229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                                }
                                if (item != null) {
                                    charz.addItemBag(0, item);
                                }
                            }
                        }
                        //+20m tn, sm
                        if (this.select == 1) {
                            charz.updateEXP(2, 20000000);
                        }
                        //Giau co 2b vang
                        if (this.select == 2) {
                            charz.updateXu(200000000, 1);
                        }
                        break;
                    }
                    case 1:
                    {
                        //Thay chieu de tu
                        if (this.select == 0 && charz.myPet != null) {
                            if (charz.myPetz().skills.size() > 1) {
                                charz.myPetz().skills.set(1, Skill.arrSkill[charz.myPetz().arrSkillPet[1][Util.gI().nextInt(charz.myPetz().arrSkillPet[1].length)]].clone());
                            }
//                            if (charz.myPetz().skills.size() > 2) {
//                                charz.myPetz().skills.set(2, Skill.arrSkill[charz.myPetz().arrSkillPet[2][Util.gI().nextInt(charz.myPetz().arrSkillPet[2].length)]].clone());
//                            }
                            charz.myPetz().updateAll();
                            charz.updateAll();
                            charz.session.service.meLoadPoint();
                            charz.zoneMap.playerLoadAll(charz);
                            charz.session.service.Body(charz.head, charz.arrItemBody);
                        }
                        break;
                    }
                    case 2:
                    {
                        //Lay player trong khu ra
                        Char array[]; int i;
                        synchronized(charz.zoneMap.players) {
                            array = new Char[charz.zoneMap.players.size()];
                            if (charz.clan != null) {
                                for (i = 0; i < charz.zoneMap.players.size(); i++) {
                                    Char player = charz.zoneMap.players.get(i);
                                    if (player.clan != null && player.clan.ID == charz.clan.ID) {
                                        array[i] = player;
                                    } else {
                                        array[i] = null;
                                    }
                                }
                            }
                        }
//                        //rong namek x2 tnsm
//                        if (this.select == 0) {
//                            for (i = 0; i < array.length; i++) {
//                                if (array[i] != null && array[i].timeReceiveNamek < System.currentTimeMillis()) {
//                                    array[i].timeReceiveNamek = System.currentTimeMillis() + 172800000L;
//                                    array[i].setText(7, mResources.X2_TEXT_RNM, 259200, 2, 0);
//                                }
//                            }
//                        }
                        //500 hong ngoc
                        if (this.select == 0) {
                            for (i = 0; i < array.length; i++) {
                                if (array[i] != null && array[i].timeReceiveNamek < System.currentTimeMillis()) {
                                    array[i].timeReceiveNamek = System.currentTimeMillis() + 172800000L;
                                    array[i].updateLuongKhoa(500, 2);
                                }
                            }
                        }
                        //2 ty vang
                        if (this.select == 1) {
                            for (i = 0; i < array.length; i++) {
                                if (array[i] != null && array[i].timeReceiveNamek < System.currentTimeMillis()) {
                                    array[i].timeReceiveNamek = System.currentTimeMillis() + 172800000L;
                                    array[i].updateXu(2000000000, 1);
                                }
                            }
                        }
                        //100 Capsule Bang hoi
                        if (this.select == 2) {
                            for (i = 0; i < array.length; i++) {
                                if (array[i] != null && array[i].timeReceiveNamek < System.currentTimeMillis()) {
                                    array[i].timeReceiveNamek = System.currentTimeMillis() + 172800000L;
                                    array[i].addClanPoint(100);
                                }
                            }
                        }
                        //5% hp ki sd
                        if (this.select == 3) {
                            for (i = 0; i < array.length; i++) {
                                if (array[i] != null && array[i].timeReceiveNamek < System.currentTimeMillis()) {
                                    array[i].timeReceiveNamek = System.currentTimeMillis() + 172800000L;
                                    array[i].setText(8, mResources.X2_TEXT_RNM2, 86400, 2, 0);
                                }
                            }
                        }
                        break;
                    }
                    default:
                        break;
                }
                charz.session.service.openUISay(0, mResources.SAY_RONG_THAN_2, 0);
                this.hideRong();
            }
        }
    }
    
    public void hideRong() {
        Server.gI().rongThan(1, this);
        this.isRongThanXuatHien = false;
        if (this.isRongNamek) {
            NamekBall.gI().hideBall();
        }
    }
    
    public synchronized void dragonControl(Char charz, ZoneMap zoneMap) {
        charz.countCallDragon++;
        if (charz.countCallDragon > 3) {
            charz.session.disconnect();
        } else if (charz.arrItem != null && charz.arrItem.length > 0) {
            //Rong than trai dat
            if (charz.arrItem[0] != null && charz.arrItem[0] == charz.arrItemBag[charz.arrItem[0].indexUI]) {
                if (charz.arrItem[0].template.id == 14 && charz.getItemBagById(15) != null && charz.getItemBagById(16) != null && charz.getItemBagById(17) != null && charz.getItemBagById(18) != null && charz.getItemBagById(19) != null && charz.getItemBagById(20) != null) {
                    if ((charz.cgender == 0 && charz.mapTemplateId != 0) || (charz.cgender == 1 && charz.mapTemplateId != 7) || (charz.cgender == 2 && charz.mapTemplateId != 14)) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_CALL_DRAGON_IN_VILLAGE, null, 0);
                    } else if (CallDragon.gI().timeWait > 0) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.TIME_WAIT_RONG, Util.gI().getStrTime(CallDragon.gI().timeWait)), null, 0);
                    } else {
                        charz.useItemBag(charz.arrItem[0].indexUI, 1);
                        charz.useItemBag(charz.getItemBagById(15).indexUI, 1);
                        charz.useItemBag(charz.getItemBagById(16).indexUI, 1);
                        charz.useItemBag(charz.getItemBagById(17).indexUI, 1);
                        charz.useItemBag(charz.getItemBagById(18).indexUI, 1);
                        charz.useItemBag(charz.getItemBagById(19).indexUI, 1);
                        charz.useItemBag(charz.getItemBagById(20).indexUI, 1);
                        CallDragon.gI().setup(charz, zoneMap, 0, 0);
                    }
                }
            }
        }
    }
    
}
