package dragon.t;

import dragon.server.mResources;

public class MeTask {
    
    
    public static void updateTask(Char charz, int count) {
        //updat task count
        if (Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex] != -1) {
            charz.ctaskCount += count;
            charz.session.service.getTaskCount(charz.ctaskCount);
        }
        //Update next task index
        if (Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex] == -1 || charz.ctaskCount >= Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex]) {
            charz.ctaskIndex++;
            charz.ctaskCount = 0;
            if (charz.ctaskIndex == Task.getTask(charz.ctaskId).counts[charz.cgender].length) {
                charz.ctaskIndex = 0;
                charz.ctaskCount = 0;
                charz.ctaskId++;
                charz.clearItemTask();
                if (charz.ctaskId == 4) {
                    charz.ctaskId = 6;
                }
                if (charz.ctaskId == 17) {
                    charz.ctaskId = 19;
                }
                if (charz.ctaskId == 21) {
                    charz.ctaskId = 22;
                }
                if (charz.ctaskId == 23) {
                    charz.ctaskId = 24;
                }
                if (charz.ctaskId == 32) {
                    charz.ctaskId = 33;
                }
                infoTask(charz);
                charz.session.service.getTask(charz.cgender, charz.ctaskId, charz.ctaskIndex, charz.ctaskCount);
            } else {
                infoTask(charz);
                charz.session.service.nextTaskIndex();
            }
        }
    }
    
    public static void checkTask(Char charz, int delay) {
        switch (charz.ctaskId) {
            case 0:
            {
                if (charz.ctaskIndex == 1 && ((charz.cgender == 0 && charz.mapTemplateId == 21) || (charz.cgender == 1 && charz.mapTemplateId == 22) || (charz.cgender == 2 && charz.mapTemplateId == 23))) {
                    charz.updateTask(1);
                }
            }
                break;
            //16.000 sm
            case 7:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 16000) {
                    charz.updateTask(1);
                }
                break;
            }
            //40.000 sm
            case 8:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 40000) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 3 && charz.mapTemplateId == 47) {
                    charz.updateTask(1);
                    charz.updateEXP(0, 15000);
                    charz.updateEXP(1, 15000);
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 15000), null, 0);
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 15000), null, 0);
                }
                break;
            }
            //Dung do Tau pay pay
            case 9:
            {
                if (charz.ctaskIndex == 1 && charz.mapTemplateId == 47) {
                    if (charz.timeExBossTask == -1) {
                        charz.timeExBossTask = 10000;
                    } else {
                        charz.timeExBossTask -= delay;
                        if (charz.timeExBossTask <= 0) {
                            charz.timeExBossTask = -1;
                            charz.updateTask(1);
                            Char c = Player.addBoss(53, 0, -1, 10000, true, 660, 150, charz.zoneMap, 10000, -1);
                            charz.zoneMap.chat(c, mResources.PAY_PAY_10S);
                        }
                    }
                }
                if (charz.ctaskIndex == 2 && charz.mapTemplateId == 46) {
                    charz.updateTask(1);
                }
                break;
            }
            case 11:
            {
                if (charz.ctaskIndex == 0 && ((charz.cgender == 0 && charz.mapTemplateId == 5) || (charz.cgender == 1 && charz.mapTemplateId == 13) || (charz.cgender == 2 && charz.mapTemplateId == 20))) {
                    charz.updateTask(1);
                }
                break;
            }
            //Vao bang hoi
            case 12:
            {
                if (charz.ctaskIndex == 0 && charz.clan != null && charz.clan.getSizeMember() >= 1) {
                    charz.updateTask(1);
                }
                break;
            }
            //200.000 sm
            case 14:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 200000) {
                    charz.updateTask(1);
                }
                break;
            }
            //500.000 sm
            case 15:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 500000) {
                    charz.updateTask(1);
                }
                break;
            }
            //1.500.000 sm
            case 19:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 1500000) {
                    charz.updateTask(1);
                }
                break;
            }
            //5.000.000 sm
            case 20:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 5000000) {
                    charz.updateTask(1);
                }
                break;
            }
            //15.000.000 sm
            case 21:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 15000000) {
                    charz.updateTask(1);
                }
                break;
            }
            //50.000.000 sm
            case 22:
            {
                if (charz.ctaskIndex == 0 && charz.cPower >= 50000000) {
                    charz.updateTask(1);
                }
                break;
            }
            case 27:
            {
                if (charz.ctaskIndex == 0 && (charz.mapTemplateId == 93 || charz.mapTemplateId == 94 || charz.mapTemplateId == 96) && (charz.zoneMap.isHaveBoss(69) || charz.zoneMap.isHaveBoss(70))) {
                    charz.updateTask(1);
                }
                break;
            }
            case 28:
            {
                if (charz.ctaskIndex == 0 && charz.mapTemplateId == 104 && (charz.zoneMap.isHaveBoss(66) || charz.zoneMap.isHaveBoss(67)  || charz.zoneMap.isHaveBoss(68))) {
                    charz.updateTask(1);
                }
                break;
            }
            case 29:
            {
                if (charz.ctaskIndex == 0 && (charz.mapTemplateId == 97 || charz.mapTemplateId == 98) && (charz.zoneMap.isHaveBoss(71) || charz.zoneMap.isHaveBoss(72) || charz.zoneMap.isHaveBoss(73))) {
                    charz.updateTask(1);
                }
                break;
            }
            case 30:
            {
                if (charz.ctaskIndex == 0 && charz.mapTemplateId == 100) {
                    charz.updateTask(1);
                }
                break;
            }
            //Suc danh goc 10k
            case 31:
            {
                if (charz.ctaskIndex == 0 && charz.cDamGoc >= 10000) {
                    charz.updateTask(1);
                }
                if (charz.ctaskIndex == 2 && charz.mapTemplateId == 103) {
                    charz.updateTask(1);
                }
                break;
            }
            //Do te
            case 33:
            {
                if (charz.ctaskIndex == 0 && charz.mapTemplateId == 114) {
                    charz.updateTask(1);
                }
                break;
            }
            //99 cai thuc an
            case  34:
            {
                
                if (charz.ctaskIndex == 7 && charz.getItemBagQuantityById(993) >= 99) {
                    charz.updateTask(1);
                }
            }
        }
    }
    
    public static void infoTask(Char charz) {
        switch (charz.ctaskId) {
            case 0:
            {
                //Moi vao game
                if (charz.ctaskIndex == 0) {
                    charz.session.service.openUISay(4, String.format(mResources.WELCOME_GAME, charz.cName, Char.gI().info2[charz.cgender][0]), Char.gI().info1[charz.cgender][2]);
                }
                //Di chuyen
                if (charz.ctaskIndex == 1) {
                    if (charz.cgender == 0) {
                        charz.session.service.openUISay(4, mResources.TASK_MOVE_0, Char.gI().info1[charz.cgender][2]);
                    }
                    if (charz.cgender == 1) {
                        charz.session.service.openUISay(4, mResources.TASK_MOVE_1, Char.gI().info1[charz.cgender][2]);
                    }
                    if (charz.cgender == 2) {
                        charz.session.service.openUISay(4, mResources.TASK_MOVE_2, Char.gI().info1[charz.cgender][2]);
                    }
                }
                //Vao nha ong noi
                if (charz.ctaskIndex == 2) {
                    if (charz.cgender == 0) {
                        charz.session.service.openUISay(4, mResources.GOHAN_WAIT, Char.gI().info1[charz.cgender][2]);
                    }
                    if (charz.cgender == 1) {
                        charz.session.service.openUISay(4, mResources.MOORI_WAIT, Char.gI().info1[charz.cgender][2]);
                    }
                    if (charz.cgender == 2) {
                        charz.session.service.openUISay(4, mResources.PARAGUS_WAIT, Char.gI().info1[charz.cgender][2]);
                    }
                }
                //Hoi va lay ra da
                if (charz.ctaskIndex == 3) {
                    charz.session.service.openUISay(4, mResources.HE_HASK, Char.gI().info1[charz.cgender][2]);
                }
                //
                break;
            }
        }
    }
    
//    public static boolean isChangeZone(Char charz, int mapId) {
//        if (Server.gI().isTaskHelp) {
//            switch (mapId) {
//                //nv tdst
//                case 79:
//                case 82:
//                case 83:
//                {
//                    return (charz.ctaskId == 24 && (charz.ctaskIndex == 0 || charz.ctaskIndex == 1 || charz.ctaskIndex == 2 || charz.ctaskIndex == 3));
//                }
//                //nv fide
//                case 80:
//                {
//                    return (charz.ctaskId == 25 && (charz.ctaskIndex == 0 || charz.ctaskIndex == 1 || charz.ctaskIndex == 2));
//                }
//                //nv robot sat thu 1
//                case 93:
//                case 94:
//                {
//                    return (charz.ctaskId == 27 && (charz.ctaskIndex == 0 || charz.ctaskIndex == 1 || charz.ctaskIndex == 2));
//                }
//                //nv robot sat thu 2
//                case 104:
//                {
//                    return (charz.ctaskId == 28 && (charz.ctaskIndex == 0 || charz.ctaskIndex == 1 || charz.ctaskIndex == 2 || charz.ctaskIndex == 3));
//                }
//                //nv robot sat thu 3
//                case 97:
//                {
//                    return (charz.ctaskId == 29 && (charz.ctaskIndex == 0 || charz.ctaskIndex == 1 || charz.ctaskIndex == 2 || charz.ctaskIndex == 3));
//                }
//                //nv cham tran zen bo hung
//                case 100:
//                {
//                    return (charz.ctaskId == 30 && (charz.ctaskIndex == 0 || charz.ctaskIndex == 1 || charz.ctaskIndex == 2 || charz.ctaskIndex == 3));
//                }
//            }
//        }
//        return true;
//    }
    
}
