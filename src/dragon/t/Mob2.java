package dragon.t;

import dragon.server.Dragon;
import dragon.server.Server;
import dragon.server.mResources;

import static dragon.t.Mob.timeRoiDoTL;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class Mob2 {
    
    private static Mob2 instance;
    
    public static Mob2 gI() {
        if (instance == null) {
            instance = new Mob2();
        }
        return instance;
    }
    
    public void fallItem(Mob mob, Char player, ArrayList<ItemMap> itemMaps, ZoneMap zone, int type, int charMaxDam) {
        int i;
        //Nhiem vu hang ngay
        if (player != null && player.session != null && player.myObj().taskEveryday != null && player.myObj().taskEveryday.template.type == 1 && player.myObj().taskEveryday.template.templateId == mob.templateId) {
        	if (player.myObj().taskEveryday.addCount(1)) {
        		player.addInfo1(mResources.TAKE_GIFT3);
        	}
        }
        //Nhiem vu thanh tich danh quai bay
    	if (player != null && player.session != null && Mob.arrMobTemplate[mob.templateId].type == 4) {
    		player.updateArchivement(6, 1L);
    	}
        //Nhiem vu thanh tich danh nguoi rom
    	if (player != null && player.session != null && mob.templateId == 0) {
    		player.updateArchivement(7, 1L);
    	}
        //Nhiem vu thanh tich danh sieu quai
    	if (player != null && player.session != null && mob.levelBoss > 0) {
    		player.updateArchivement(12, 1L);
    	}
        //Map binh thuong
        if (zone.map.isMapThuong()) {
            //Do co sao
            if (Util.gI().nextInt(1000) < 1) {
                for (i = 0; i < 1; i++) {
                    short[] arrItem = new short[]{0, 1, 2, 6, 7, 8, 12, 21, 22, 23, 27, 28, 29};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    Item it_1 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    it_1.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                    ItemMap itemMap = zone.addItemMap(charMaxDam, it_1, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Roi gold
            if (Util.gI().nextInt(100) < 5) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int coin = 2000;
                    if (player != null) {
                        if (player.coinMob_percent > 0) {
                            coin = coin + (coin * player.coinMob_percent / 100);
                        }
                        //Noi tai
                        if (player.cgender == 0 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 1 && player.cspeacialSkill == 8) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 2 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                    }
                    if (coin > 30000) {
                        coin = 30000;
                    }
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Ngoc rong 7 sao
            if (Util.gI().nextInt(1000) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 2) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Do pha le
            if (player != null && player.isFindCrystal && Util.gI().nextInt(100) <= 5) {
                int itemTId = Util.gI().nextInt(441, 447);
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemTId, false, 1, ItemOption.getOption(itemTId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Do kich hoat
//            if (player != null && util.nextInt(1000) <= 1 && mob.level <= 2 && (System.currentTimeMillis() - player.lastTime) < (1000l * 60l * 60l * 24l * 35l) && mob.templateId != 0) {
//                boolean f = false;
//                int count = player.getCountSKH(0);
//                if (count == 0) {
//                    f = true;
//                } else if (count == 1) {
//                    f = true;
//                } else if (count == 2 && util.nextInt(10) <= 1) {
//                    f = true;
//                } else if (count == 3 && util.nextInt(100) <= 1) {
//                    f = true;
//                } else if (count >= 4 && util.nextInt(200) <= 1) {
//                    f = true;
//                }
//                if (f) {
//                    int gender = player.cgender;
//                    int[] arrSetId = null;//new int[] {0, 1, 2, 6, 7, 8, 12, 21, 22, 23, 27, 28, 29};
//                    if (gender == 0) {
//                        arrSetId = new int[] {0, 6, 12, 21, 27};
//                    }
//                    if (gender == 1) {
//                        arrSetId = new int[] {1, 7, 12, 22, 28};
//                    }
//                    if (gender == 2) {
//                        arrSetId = new int[] {2, 8, 12, 23, 29};
//                    }
//                    if (arrSetId != null) {
//                        int setId = arrSetId[util.nextInt(arrSetId.length)];
//                        int toX = util.nextInt(mob.pointx - 24, mob.pointx + 24);
//                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
//                        ItemMap itemMap = zone.addItemMap(player.charID, new Item(setId, false, 1, ItemOption.getOption(setId, util.nextInt(1, 3), gender), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
//                        itemMaps.add(itemMap);
//                    }
//                }
//            }
            //Su kien halloween
            if (Dragon.isEvent_Halloween && Util.gI().nextInt(100) <= 10) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(200, false, 1, ItemOption.getOption(200, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Su kien World Cup 2022
            if (Dragon.isEvent_WorldCup2022 && Util.gI().nextInt(100) < 5) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int num = Util.gI().nextInt(1118, 1127);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(num, false, 1, ItemOption.getOption(num, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Su kien tet nguyen dan
            if (Dragon.isEvent_TetNguyenDan) {
                //Mam
                if (player != null && player.arrItemBody[5] != null && (player.arrItemBody[5].template.id == 846 || player.arrItemBody[5].template.id == 847 || player.arrItemBody[5].template.id == 848) &&  Util.gI().nextInt(100) < 50) {
                    int idNlMam = new int[]{1177, 1178, 1179, 1180, 1181}[Util.gI().nextInt(5)];
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(idNlMam, false, 1, ItemOption.getOption(idNlMam, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Thit heo
                
                if ( Util.gI().nextInt(100) < 5) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(748, false, 1, ItemOption.getOption(748, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Thung nep
                
                if ( Util.gI().nextInt(100) < 5) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(749, false, 1, ItemOption.getOption(749, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Thung dau xanh
                
                if ( Util.gI().nextInt(100) < 5) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(750, false, 1, ItemOption.getOption(750, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }        
            }
            //Su kien 8/3
            if (Dragon.isEvent_Girl && Util.gI().nextInt(100) < 10) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int num = Util.gI().nextInt(1093, 1095);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(num, false, 1, ItemOption.getOption(num, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
         
           
            //Su diet bo
            if (Dragon.isEvent_DIET_SAU_BO_2023 && Util.gI().nextInt(100) < 6) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int id = new int[]{1237 , 1238 , 1239 , 1240 }[Util.gI().nextInt(4)];
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(id, false, 1, ItemOption.getOption(id, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Su diet bo
            if (Dragon.isEvent_DIET_SAU_BO_2023 && Util.gI().nextInt(100) < 3) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int id = new int[]{ 1245, 1246, 1247}[Util.gI().nextInt(3)];
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(id, false, 1, ItemOption.getOption(id, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Quan Hoa
            if (player != null && player.isTBQuanHoa && Util.gI().nextInt(500) < 5) {
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                int id = new int[]{695, 696, 697, 698}[Util.gI().nextInt(4)];
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(id, false, 1, ItemOption.getOption(id, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
        
        //Hanh tinh Nappa
        if (zone.map.isMapNappa()) {
            //Su diet bo
            if (Dragon.isEvent_DIET_SAU_BO_2023 && Util.gI().nextInt(100) < 3) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int id = new int[]{ 1245, 1246, 1247}[Util.gI().nextInt(3)];
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(id, false, 1, ItemOption.getOption(id, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Do co sao
            if (Util.gI().nextInt(3000) < 2) {
                for (i = 0; i < 1; i++) {
                    short[] arrItem_5345 = new short[]{147, 163, 179, 230, 234, 238, 242, 246, 250, 266, 270, 274};
                    int templateId_345 = arrItem_5345[Util.gI().nextInt(arrItem_5345.length)];
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    Item it_2 = new Item(templateId_345, false, 1, ItemOption.getOption(templateId_345, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, it_2, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Do co sao
            if (Util.gI().nextInt(3000) < 1) {
                for (i = 0; i < 1; i++) {
                    short[] arrItem = new short[]{231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263, 275};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    Item it_3 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, it_3, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Roi gold
            if (Util.gI().nextInt(100) < 5) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int coin = 5000;
                    if (player != null) {
                        if (player.coinMob_percent > 0) {
                            coin = coin + (coin * player.coinMob_percent / 100);
                        }
                        //Noi tai
                        if (player.cgender == 0 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 1 && player.cspeacialSkill == 8) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 2 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                    }
                    if (coin > 30000) {
                        coin = 30000;
                    }
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Ngoc rong 7 sao
            if (Util.gI().nextInt(1000) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 2) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Do pha le
            if (player != null && player.isFindCrystal && Util.gI().nextInt(100) <= 5) {
                int itemTId = Util.gI().nextInt(441, 447);
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemTId, false, 1, ItemOption.getOption(itemTId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Su kien halloween
            if (Dragon.isEvent_Halloween && Util.gI().nextInt(100) <= 10) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(201, false, 1, ItemOption.getOption(201, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            if (player != null && player.cPower >= 40000000000L && player.myObj().nBiKipTuyetKi < 80) {
                //Bi kip tuyet ki
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1229, false, 1, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nBiKipTuyetKi++;
                    }
                }
            }
        }
        
        //Di den tuong lai
        if (zone.map.isMapTL()) {
            //Roi gold
            if (Util.gI().nextInt(100) < 10) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int coin = 500 * Util.gI().nextInt(1, 20);
                    if (player != null) {
                        if (player.coinMob_percent > 0) {
                            coin = coin + (coin * player.coinMob_percent / 100);
                        }
                        //Noi tai
                        if (player.cgender == 0 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 1 && player.cspeacialSkill == 8) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 2 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                    }
                    if (coin > 30000) {
                        coin = 30000;
                    }
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Ngoc rong 7 sao
            if (Util.gI().nextInt(1000) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //May do capsule Ki Bi
            if (player != null && player.isExistItem(2758)) {
                if (Util.gI().nextInt(100) < player.getItemById(2758).damage) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(380, false, 1, ItemOption.getOption(380, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Thuc an
            if (player != null && player.isFullTBT && Util.gI().nextInt(1000) <= 5) {
                for (i = 0; i < 1; i++) {
                    int itemId = Util.gI().nextInt(663, 667);
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemId, false, 1, ItemOption.getOption(itemId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMap.isPickItemNotMe = true;
                    itemMaps.add(itemMap);
                }
            }
            //Do pha le
            if (player != null && player.isFindCrystal && Util.gI().nextInt(100) <= 5) {
                int itemTId = Util.gI().nextInt(441, 447);
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemTId, false, 1, ItemOption.getOption(itemTId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Su kien halloween
            if (Dragon.isEvent_Halloween && Util.gI().nextInt(100) <= 10) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(199, false, 1, ItemOption.getOption(199, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            if (player != null && player.cPower >= 40000000000L && player.myObj().nBiKipTuyetKi < 200) {
                //Bi kip tuyet ki
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1229, false, 1, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nBiKipTuyetKi++;
                    }
                }
            }
        }
        
        //Hanh tinh cold
        if (zone.map.isMapCold1()) {
            //Do co sao
            if (Util.gI().nextInt(1500) < 1) {
                for (i = 0; i < 1; i++) {
                    short[] arrItem_4567 = new short[]{233, 245, 257, 269, 249, 237, 261, 273, 241, 253, 265, 277};
                    int templateId_789 = arrItem_4567[Util.gI().nextInt(arrItem_4567.length)];
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    Item it_7 = new Item(templateId_789, false, 1, ItemOption.getOption(templateId_789, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, it_7, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Roi gold
            if (Util.gI().nextInt(100) < 15) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int coin = 500 * Util.gI().nextInt(1, 30);
                    if (player != null) {
                        if (player.coinMob_percent > 0) {
                            coin = coin + (coin * player.coinMob_percent / 100);
                        }
                        //Noi tai
                        if (player.cgender == 0 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 1 && player.cspeacialSkill == 8) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 2 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                    }
                    if (coin > 30000) {
                        coin = 30000;
                    }
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Ngoc rong 7 sao
            if (Util.gI().nextInt(1000) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Thuc an
            if (player != null && player.isFullTBT && Util.gI().nextInt(1000) <= 5) {
                for (i = 0; i < 1; i++) {
                    int itemId = Util.gI().nextInt(663, 667);
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemId, false, 1, ItemOption.getOption(itemId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMap.isPickItemNotMe = true;
                    itemMaps.add(itemMap);
                }
            }
            //Do pha le
            if (player != null && player.isFindCrystal && Util.gI().nextInt(100) <= 5) {
                int itemTId = Util.gI().nextInt(441, 447);
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(itemTId, false, 1, ItemOption.getOption(itemTId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Roi do than linh o cold
//            if (player != null) {
//                if (timeRoiDoTL == -1) {
//                    timeRoiDoTL = System.currentTimeMillis() + 1000 * 60 * 60 * 2;
//                }
//                if (timeRoiDoTL <= System.currentTimeMillis()) {
//                    timeRoiDoTL = System.currentTimeMillis() + (1000 * 60 * 60 * 2);
//                    //Do than linh (gang tay)
//                    for (i = 0; i < 1; i++) {
//                        int itemId = new int[]{562, 564, 566}[Util.gI().nextInt(3)];
//                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
//                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
//                        Item it_8 = new Item(itemId, false, 1, ItemOption.getOption(itemId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
//                        ItemMap itemMap = zone.addItemMap(charMaxDam, it_8, toX, toY, 0, -1);
//                        itemMaps.add(itemMap);
//                        Server.gI().chatVip(String.format(mResources.PLAYER_ATT_TL, player.myCharz().cName, Mob.arrMobTemplate[mob.templateId].name, itemMap.item.template.name, zone.mapTemplate.mapName));
//                    }
//                }
//            }
            if (player != null && player.cPower >= 40000000000L && player.myObj().nBiKipTuyetKi < 200) {
                //Bi kip tuyet ki
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1229, false, 1, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nBiKipTuyetKi++;
                    }
                }
            }
        }
        
        //Doanh Trai
        if (zone.map.isMapDoanhTrai()) {
            //Roi gold
            for (i = 0; i < 1; i++) {
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Ngoc rong 7 sao
            if (Util.gI().nextInt(1000) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 2) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh the
            if (mob.templateId == 34) {
                if (Util.gI().nextInt(100) < 5) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(837, false, 1, ItemOption.getOption(837, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh the
            if (mob.templateId == 35) {
                if (Util.gI().nextInt(100) < 5) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(838, false, 1, ItemOption.getOption(838, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh the
            if (mob.templateId == 36) {
                if (Util.gI().nextInt(100) < 5) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(839, false, 1, ItemOption.getOption(839, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Ngu hanh son
            if (Dragon.isEvent_NHS) {
                if (Util.gI().nextInt(100) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        int temcharMaxDam = Util.gI().nextInt(537, 539);
                        if (Util.gI().nextInt(100) < 20) {
                            temcharMaxDam = Util.gI().nextInt(537, 540);
                        }
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(temcharMaxDam, false, 1, ItemOption.getOption(temcharMaxDam, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (Util.gI().nextInt(100) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(542, false, 1, ItemOption.getOption(542, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
            }
            if (player != null && player.isFullTBHD && player.myObj().nManhNhan < 40) {
                //Manh nhan
                if (Util.gI().nextInt(100) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1069, false, 1, ItemOption.getOption(1069, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nManhNhan++;
                    }
                }
            }
        }
        
        //Khi gas
        if (zone.map.isMapDestronGas()) {
            //Roi gold
            for (i = 0; i < 5; i++) {
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                int coin = 30000 / (111 - zone.map.destronGas.level);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 2) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            if (player != null && player.isFullTBHD && player.myObj().nManhNhan < 40) {
                //Manh nhan
                if (Util.gI().nextInt(100) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1069, false, 1, ItemOption.getOption(1069, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nManhNhan++;
                    }
                }
            }
        }
        
        //Kho bau
        if (zone.map.isMapKhoBau()) {
            //Roi gold
            int n = ((mob.isMobNew() || mob.levelBoss != 0) ? 30 : 3);
            for (i = 0; i < n ; i++) {
                int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                int coin = 30000 / (111 - zone.map.khobau.level);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Big boss2
            if (mob.isBigBoss2()) {
                if (zone.map.khobau.level >= 1 && zone.map.khobau.level <= 49) {
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(590, false, 1, ItemOption.getOption(590, 0, 2), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // ngoc hong
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, ItemOption.getOption(861, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Do co sao
                    if (Util.gI().nextInt(100) < 10) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263, 275};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    // lech teamobi
                    //Cai trang
                    if (Util.gI().nextInt(100) < 5) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{2001};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(93, 3));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                } else if (zone.map.khobau.level >= 50 && zone.map.khobau.level <= 100) {
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(590, false, 0, ItemOption.getOption(590, 0, 4), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // ngoc hong
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, ItemOption.getOption(861, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Do co sao
                    if (Util.gI().nextInt(100) < 20) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263, 275};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    // lech teamobi
                    //Cai trang
                    if (Util.gI().nextInt(100) < 50) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{2001};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(93, 3));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                } else if (zone.map.khobau.level >= 101 && zone.map.khobau.level <= 110) {
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(590, false, 1, ItemOption.getOption(590, 0, 6), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // ngoc hong
                    for (i = 0; i < 10; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, ItemOption.getOption(861, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Do co sao
                    if (Util.gI().nextInt(100) < 50) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263, 275};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, Util.gI().nextInt(3, 5))));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    // lech teamobi
                    //Cai trang
                    if (Util.gI().nextInt(100) < 50) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{2001};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(93, 3));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                } else {
                }
            }
            //Bach tuoc
            if (mob.isBachTuoc()) {
                if (zone.map.khobau.level >= 1 && zone.map.khobau.level <= 49) {
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(590, false, 1, ItemOption.getOption(590, 0, 2), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // ngoc hong
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, ItemOption.getOption(861, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Do co sao
                    if (Util.gI().nextInt(100) < 10) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263, 275};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    // lech teamobi
                     //Cai trang
                    if (Util.gI().nextInt(100) < 5) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{2001};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(93, 3));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                } else if (zone.map.khobau.level >= 50 && zone.map.khobau.level <= 100) {
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(590, false, 0, ItemOption.getOption(590, 0, 4), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // ngoc hong
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, ItemOption.getOption(861, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Do co sao
                    if (Util.gI().nextInt(100) < 20) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263, 275};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    // lech teamobi
                     //Cai trang
                    if (Util.gI().nextInt(100) < 20) {
                        for (i = 0; i < 2; i++) {
                            short[] arrItem = new short[]{2001};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(93, 3));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                } else if (zone.map.khobau.level >= 101 && zone.map.khobau.level <= 110) {
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 50, mob.pointx + 50);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(590, false, 1, ItemOption.getOption(590, 0, 6), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // ngoc hong
                    for (i = 0; i < 10; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, ItemOption.getOption(861, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Do co sao
                    if (Util.gI().nextInt(100) < 50) {
                        for (i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263, 275};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, Util.gI().nextInt(3, 5))));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    // lech teamobi
                     //Cai trang
                    if (Util.gI().nextInt(100) < 50) {
                        for (i = 0; i < 3; i++) {
                            short[] arrItem = new short[]{2001};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                            int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                            Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(93, 3));
                            ItemMap itemMap = zone.addItemMap(charMaxDam, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                } else {
                }
            }
            if (player != null && player.isFullTBHD && player.myObj().nManhNhan < 40) {
                //Manh nhan
                if (Util.gI().nextInt(100) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1069, false, 1, ItemOption.getOption(1069, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nManhNhan++;
                    }
                }
            }
        }
        
        //Ngu hanh son
        if (zone.map.isMapNguHanhSon()) {
            if (Util.gI().nextInt(100) < 5) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int tempId = Util.gI().nextInt(537, 540);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(tempId, false, 1, ItemOption.getOption(tempId, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
        }
        
        //BigBoss
        if (mob.templateId == 70) {
            if ((type == 1 || type == 2)) {
                //Capsule ki bi
                for (i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(380, false, 1, ItemOption.getOption(380, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Vang
                for (i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Xanh ngoc
                for (i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(77, false, 2, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Trung Mabu
                if (mob.sys == 2 && Util.gI().nextInt(100) < 20) {
                    int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(568, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Do than linh (Ao)
                if (mob.sys == 2 && Util.gI().nextInt(100) < 1) {
                    for (i = 0; i < 1; i++) {
                        int itemTemp = new short[]{555, 557, 559}[Util.gI().nextInt(3)];
                        int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        Item it_9 = new Item(itemTemp, false, 1, ItemOption.getOption(itemTemp, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, it_9, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Hong dao
                if (Dragon.isEvent_NHS && mob.sys == 2) {
                    for (i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(542, false, 1, ItemOption.getOption(542, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Manh the than linh
                if (Util.gI().nextInt(100) <= 10) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 70, mob.pointx + 70);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        short id_450 = new short[] {712, 713, 714, 715, 716}[Util.gI().nextInt(5)];
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(id_450, false, 1, ItemOption.getOption(id_450, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
            }
        }
        //Thanh dia
        if (zone.map.isMapManor()) {
            if (zone.map.mapId == 156 || zone.map.mapId == 157) {
                //Manh vo bong tai
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(933, false, 1, ItemOption.getOption(933, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
            }
            if (zone.map.mapId == 158 || zone.map.mapId == 159) {
                //Manh hon bong tai
                if (Util.gI().nextInt(1000) < 1) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(934, false, 1, ItemOption.getOption(934, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
            }
            //Su kien halloween
            if (Dragon.isEvent_Halloween && Util.gI().nextInt(100) <= 10) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(199, false, 1, ItemOption.getOption(199, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            if (player != null && player.cPower >= 40000000000L && player.myObj().nBiKipTuyetKi < 200) {
                //Bi kip tuyet ki
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1229, false, 1, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nBiKipTuyetKi++;
                    }
                }
            }
        }
        
        //Hanh tinh nguc tu
        if (zone.map.isMapHell()) {
            if (player != null && player.cPower >= 40000000000L && player.myObj().nBiKipTuyetKi < 200) {
                //Bi kip tuyet ki
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1229, false, 1, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nBiKipTuyetKi++;
                    }
                }
            }
            if (player != null && player.isFullTBHD && player.myObj().nManhAo < 40) {
                //Manh ao
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1066, false, 1, ItemOption.getOption(1066, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nManhAo++;
                    }
                }
            }
            if (player != null && player.isFullTBHD && player.myObj().nManhGiay < 40) {
                //Giay
                if (Util.gI().nextInt(1000) < 5) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1068, false, 1, ItemOption.getOption(1068, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nManhGiay++;
                    }
                }
            }
//            if (mob.templateId == 86 || mob.templateId == 87) {
//                //Do roi cua danh hieu than thoai
//                if (player != null && player.effThanThoai) {
//                    if (Util.gI().nextInt(1000) < 5) {
//                        //Item roi cua co hieu ung
//                        for (i = 0; i < 1; i++) {
//                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
//                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
//                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1988, false, 1, ItemOption.getOption(1988, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
//                        itemMap.isPickItemNotMe = true;
//                        itemMaps.add(itemMap);
//                    }
//                }  
//                } else {
//                    if (Util.gI().nextInt(1000) < 1) {
//                        //Item roi cua khong co hieu ung
//                        for (i = 0; i < 1; i++) {
//                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
//                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
//                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1988, false, 1, ItemOption.getOption(1988, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
//                        itemMap.isPickItemNotMe = true;
//                        itemMaps.add(itemMap);
//                    }
//                }
//                }
//            }
        }
        //con duong ran doc
        if (zone.map.isMapRoadSnake()) {
            //Roi gold
            for (i = 0; i < 10; i++) {
                int toX = Util.gI().nextInt(mob.pointx - 150, mob.pointx + 150);
                int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                int coin = 30000 / (111 - zone.map.phoban.level);
                ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 20) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            
        }
        //Tang dia nguc
        if (zone.map.isMapDiaNguc()) {
        	if (player != null && player.isMayDoLinhHon) {
                //Hon ma
                if (Util.gI().nextInt(100) <= 100) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1258, false, 1, ItemOption.getOption(1258, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
        	}
        }
        // thuc vat
        if (zone.map.isMapThucVat()) {
            //Roi gold
            if (Util.gI().nextInt(100) < 10) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    int coin = 500 * Util.gI().nextInt(1, 20);
                    if (player != null) {
                        if (player.coinMob_percent > 0) {
                            coin = coin + (coin * player.coinMob_percent / 100);
                        }
                        //Noi tai
                        if (player.cgender == 0 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 1 && player.cspeacialSkill == 8) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                        if (player.cgender == 2 && player.cspeacialSkill == 7) {
                            coin = coin + (coin * player.paramSpeacialSkill / 100);
                        }
                    }
                    if (coin > 30000) {
                        coin = 30000;
                    }
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(190, false, coin, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Ngoc rong 7 sao
            if (Util.gI().nextInt(500) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            //Manh da vun
            if (Util.gI().nextInt(100) <= 1) {
                for (i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(225, false, 1, ItemOption.getOption(225, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
            }
            if (player != null && player.cPower >= 40000000000L && player.myObj().nTrangsach < 1000) {
                //Sach Cu
                if (Util.gI().nextInt(100) < 1) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1281, false, 1, ItemOption.getOption(1281, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nTrangsach++;
                    }
                }
            }
            if (player != null && player.cPower >= 40000000000L && player.myObj().nBiKipTuyetKi < 200) {
                //Bi kip tuyet ki
                if (Util.gI().nextInt(150) < 1) {
                    for (i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = zone.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = zone.addItemMap(charMaxDam, new Item(1229, false, 1, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                        player.myObj().nBiKipTuyetKi++;
                    }
                }
            }
        }
        //Socola
        if (mob.changBody) {
            if (mob.smallBody == 4133) {
                ItemMap itemMap2 = zone.addItemMap(charMaxDam, new Item(516, false, 0, null, null, null, null), mob.pointx, zone.mapTemplate.touchY(mob.pointx, mob.pointy), 0, -1);
                itemMaps.add(itemMap2);
            }
            mob.clearBody();
            zone.changeMobBody(0, mob.mobId, 0);
        }
        
        
        
        
        
    }
    
}
