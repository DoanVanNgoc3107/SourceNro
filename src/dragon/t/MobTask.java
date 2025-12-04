package dragon.t;

import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class MobTask {
    
    public static void updateTask(Char charz, Mob mob, ArrayList<ItemMap> itemMaps) {
        switch (charz.ctaskId) {
            case 1:
            {
                if (charz.ctaskIndex == 0 && mob.templateId == 0) {
                    charz.updateTask(1);
                    if (charz.ctaskCount > 0) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                    }
                }
                break;
            }
            case 2:
            {
                if ((charz.cgender == 0 && charz.ctaskIndex == 0 && mob.templateId == 1) || (charz.cgender == 1 && charz.ctaskIndex == 0 && mob.templateId == 2) || (charz.cgender == 2 && charz.ctaskIndex == 0 && mob.templateId == 3)) {
                    int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                    int toY = charz.zoneMap.mapTemplate.touchY(toX, mob.pointy);
                    ItemMap itemMap = charz.zoneMap.addItemMap(charz.charID, new Item(73, false, 1, ItemOption.getOption(73, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, charz.charID);
                    itemMap.isPickItemNotMe = true;
                    itemMaps.add(itemMap);
                    if (charz.ctaskCount == 0) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.FIND_ITEM_TASK_2, null, 0);
                    }
                }
                break;
            }
            //Bao ve lang
            case 6:
            {
                if (charz.cgender == 0) {
                    if (charz.ctaskIndex == 0 && mob.templateId == 4) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                    if (charz.ctaskIndex == 1 && mob.templateId == 6) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                    if (charz.ctaskIndex == 2 && mob.templateId == 5) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                }
                if (charz.cgender == 1) {
                    if (charz.ctaskIndex == 0 && mob.templateId == 5) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                    if (charz.ctaskIndex == 1 && mob.templateId == 6) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                    if (charz.ctaskIndex == 2 && mob.templateId == 4) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                }
                if (charz.cgender == 2) {
                    if (charz.ctaskIndex == 0 && mob.templateId == 6) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                    if (charz.ctaskIndex == 1 && mob.templateId == 4) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                    if (charz.ctaskIndex == 2 && mob.templateId == 5) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                }
                break;
            }
            //Bao ve dan buon
            case 7:
            {
                if (charz.cgender == 0) {
                    if (charz.ctaskIndex == 1 && mob.templateId == 7) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                }
                if (charz.cgender == 1) {
                    if (charz.ctaskIndex == 1 && mob.templateId == 8) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                }
                if (charz.cgender == 2) {
                    if (charz.ctaskIndex == 1 && mob.templateId == 9) {
                        charz.updateTask(1);
                        if (charz.ctaskCount > 0) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_ATT_MOB, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], Mob.arrMobTemplate[mob.templateId].name), charz, 0);
                        }
                    }
                }
                break;
            }
            //Tim ngoc rong 7 sao
            case 8:
            {
                if (charz.ctaskIndex == 1 && mob.templateId == 10) {
                    if (Util.gI().nextInt(100) < 30) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.MOB_MUST_BALL, null, 0);
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = charz.zoneMap.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = charz.zoneMap.addItemMap(charz.charID, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, charz.charID);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                    } else {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.MOB_NOT_BALL, null, 0);
                    }
                }
                break;
            }
            //Nhiem vu bang hoi
            case 13:
            {
                if (charz.ctaskIndex == 0 && mob.templateId == 16/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 1*/) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 1 && mob.templateId == 17/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 1*/) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 2 && mob.templateId == 18/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 1*/) {
                    charz.updateTask(1);
                }
                break;
            }
            //Tim truyen
            case 14:
            {
                if (charz.ctaskIndex == 1 && ((charz.cgender == 0 && mob.templateId == 13) || (charz.cgender == 1 && mob.templateId == 14) || (charz.cgender == 2 && mob.templateId == 15))) {
                    if (Util.gI().nextInt(100) < 20) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.MOB_MUST_STORY, null, 0);
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = charz.zoneMap.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = charz.zoneMap.addItemMap(charz.charID, new Item(85, false, 1, ItemOption.getOption(85, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, charz.charID);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                    } else {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.MOB_NOT_STORY, Mob.arrMobTemplate[mob.templateId].name, Mob.arrMobTemplate[mob.templateId].name), null, 0);
                    }
                }
                break;
            }
            //Nhiem vu bang hoi
            case 15:
            {
                if (charz.ctaskIndex == 1 && mob.templateId == 22/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 1*/) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 2 && mob.templateId == 23/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 1*/) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 3 && mob.templateId == 24/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 1*/) {
                    charz.updateTask(1);
                }
                break;
            }
            //Danh trum
            case 19:
            {
                if (charz.cgender == 0) {
                    if (charz.ctaskIndex == 1 && mob.templateId == 25) {
                        charz.updateTask(1);
                    }
                    if (charz.ctaskIndex == 2 && mob.templateId == 27) {
                        charz.updateTask(1);
                    }
                    if (charz.ctaskIndex == 3 && mob.templateId == 26) {
                        charz.updateTask(1);
                    }
                }
                if (charz.cgender == 1) {
                    if (charz.ctaskIndex == 1 && mob.templateId == 26) {
                        charz.updateTask(1);
                    }
                    if (charz.ctaskIndex == 2 && mob.templateId == 25) {
                        charz.updateTask(1);
                    }
                    if (charz.ctaskIndex == 3 && mob.templateId == 27) {
                        charz.updateTask(1);
                    }
                }
                if (charz.cgender == 2) {
                    if (charz.ctaskIndex == 1 && mob.templateId == 27) {
                        charz.updateTask(1);
                    }
                    if (charz.ctaskIndex == 2 && mob.templateId == 25) {
                        charz.updateTask(1);
                    }
                    if (charz.ctaskIndex == 3 && mob.templateId == 26) {
                        charz.updateTask(1);
                    }
                }
                break;
            }
            //Bat kha thi
            case 22:
            {
                if (charz.ctaskIndex == 1 && mob.templateId == 39) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 2 && mob.templateId == 40) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 3 && mob.templateId == 41) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 4 && mob.templateId == 42) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 5 && mob.templateId == 43) {
                    charz.updateTask(1);
                }
                break;
            }
            //Nhiem vu chu be tuong lai
            case 26:
            {
                if (charz.ctaskIndex == 4 && mob.templateId == 58) {
                    charz.updateTask(1);
                }
                break;
            }
            //Nhiem vu chu be tuong lai
            case 27:
            {
                if (charz.ctaskIndex == 3 && mob.templateId == 60/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 0*/) {
                    charz.updateTask(1);
                }
                break;
            }
            //Nhiem botbot sat thu 3
            case 29:
            {
                if (charz.ctaskIndex == 4 && mob.templateId == 62/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 0*/) {
                    charz.updateTask(1);
                }
                break;
            }
            //Xen bo hung
            case 30:
            {
                if (charz.ctaskIndex == 4 && mob.templateId == 65/* && charz.clan != null && charz.zoneMap.getCountPlayerInClan(charz) > 1*/) {
                    charz.updateTask(1);
                }
                break;
            }
            //Sieu xayda huyen thoai
            case 34:
            {
                if (charz.ctaskIndex == 3 && (mob.templateId == 80 || mob.templateId == 81)) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 7 && (mob.templateId == 80 || mob.templateId == 81) && charz.mapTemplateId == 161) {
                    if (Util.gI().nextInt(100) < 100) {
                        int toX = Util.gI().nextInt(mob.pointx - 24, mob.pointx + 24);
                        int toY = charz.zoneMap.mapTemplate.touchY(toX, mob.pointy);
                        ItemMap itemMap = charz.zoneMap.addItemMap(charz.charID, new Item(993, false, 1, ItemOption.getOption(993, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, charz.charID);
                        itemMap.isPickItemNotMe = true;
                        itemMaps.add(itemMap);
                    }
                }
                if (charz.ctaskIndex == 8 && (mob.templateId == 80 || mob.templateId == 81)) {
                    charz.updateTask(1);
                }
                break;
            }
        }
    }
    
}
