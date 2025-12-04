package dragon.t;

import dragon.server.mResources;

/**
 *
 * @author TGDD
 */
public class NpcTask {
    
    public static boolean updateTask(Char charz, int npcId) {
        if (Task.getTask(charz.ctaskId).tasks[charz.cgender][charz.ctaskIndex] != -1 && npcId == Task.getTask(charz.ctaskId).tasks[charz.cgender][charz.ctaskIndex] && charz.zoneMap.isHaveNpc(npcId)) {
            Npc npc = charz.zoneMap.findNPCInMap(npcId);
            if (Math.abs(npc.cx - charz.cx) < 50 && Math.abs(npc.cy - charz.cy) < 50) {
                switch (charz.ctaskId) {
                    case 0:
                    {
                        if (charz.ctaskIndex == 2) {
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        if (charz.ctaskIndex == 5) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_0, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                    }
                    case 1:
                    {
                        if (charz.ctaskIndex == 1) {
                            if (charz.cgender == 0) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK0_1, -1);
                            }
                            if (charz.cgender == 1) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_1, -1);
                            }
                            if (charz.cgender == 2) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_1, -1);
                            }
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 500);
                            charz.updateEXP(1, 500);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 500), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 500), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 2:
                    {
                        if (charz.ctaskIndex == 1) {
                            if (charz.cgender == 0) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK0_2, -1);
                            }
                            if (charz.cgender == 1) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_2, -1);
                            }
                            if (charz.cgender == 2) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_2, -1);
                            }
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 1000);
                            charz.updateEXP(1, 1000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 1000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 1000), null, 0);
                            ItemMap itM = charz.zoneMap.addItemMap(charz.charID, new Item(74, false, 1, null, null, null, null), Char.gI().pointDuiGa[charz.cgender][0], Char.gI().pointDuiGa[charz.cgender][1]-18, 0, -1);
                            charz.zoneMap.itemMapAdd(itM);
                            return false;
                        }
                        break;
                    }
                    case 3:
                    {
                        if (charz.ctaskIndex == 2) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_3, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 2000);
                            charz.updateEXP(1, 2000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 2000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 2000), null, 0);
                            charz.updateAll();
                            charz.session.service.meLoadPoint();
                            charz.session.service.getBag(charz.charID, charz.bag);
                            charz.zoneMap.playerLoadAll(charz);
                            return false;
                        }
                        break;
                    }
                    case 6:
                    {
                        if (charz.ctaskIndex == 3) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_6, -1);
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.updateEXP(0, 4000);
                                charz.updateEXP(1, 4000);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 4000), null, 0);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 4000), null, 0);
                                if (charz.cgender == 0) {
                                    charz.addItemBag(0, new Item(67, false, 1, ItemOption.getOption(67, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 1) {
                                    charz.addItemBag(0, new Item(80, false, 1, ItemOption.getOption(80, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 2) {
                                    charz.addItemBag(0, new Item(88, false, 1, ItemOption.getOption(88, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                            }
                            return false;
                        }
                        break;
                    }
                    case 7:
                    {
                        if (charz.ctaskIndex == 2) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_7, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        if (charz.ctaskIndex == 3) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_7, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 8000);
                            charz.updateEXP(1, 8000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 8000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 8000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 8:
                    {
                        if (charz.ctaskIndex == 2) {
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_8, -1);
                            return false;
                        }
                        break;
                    }
                    case 9:
                    {
                        if (charz.ctaskIndex == 0) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_9, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        if (charz.ctaskIndex == 3) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_9, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        break;
                    }
                    case 10:
                    {
                        if (charz.ctaskIndex == 2) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_10, -1);
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.addItemBag(0, new Item(19, false, 1, ItemOption.getOption(19, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                            }
                            return false;
                        }
                        if (charz.ctaskIndex == 3) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                if (charz.cgender == 0) {
                                    charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_10, -1);
                                }
                                if (charz.cgender == 1) {
                                    charz.session.service.openUISay(npcId, mResources.FINNISH_TASK3_10, -1);
                                }
                                if (charz.cgender == 2) {
                                    charz.session.service.openUISay(npcId, mResources.FINNISH_TASK4_10, -1);
                                }
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.updateEXP(0, 15000);
                                charz.updateEXP(1, 15000);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 15000), null, 0);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 15000), null, 0);
                                charz.addItemBag(0, new Item(85, false, 1, ItemOption.getOption(85, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                            }
                            return false;
                        }
                        break;
                    }
                    case 11:
                    {
                        if (charz.ctaskIndex == 1) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                if (charz.cgender == 0) {
                                    charz.session.service.openUISay(npcId, String.format(mResources.FINNISH_TASK2_11, charz.cName), -1);
                                }
                                if (charz.cgender == 1) {
                                    charz.session.service.openUISay(npcId, String.format(mResources.FINNISH_TASK2_11, charz.cName), -1);
                                }
                                if (charz.cgender == 2) {
                                    charz.session.service.openUISay(npcId, String.format(mResources.FINNISH_TASK2_11, charz.cName), -1);
                                }
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.updateEXP(0, 5000);
                                charz.updateEXP(1, 5000);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 5000), null, 0);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 5000), null, 0);
                                if (charz.cgender == 0) {
                                    charz.addItemBag(0, new Item(94, false, 1, ItemOption.getOption(94, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 1) {
                                    charz.addItemBag(0, new Item(101, false, 1, ItemOption.getOption(101, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 2) {
                                    charz.addItemBag(0, new Item(108, false, 1, ItemOption.getOption(108, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                            }
                            return false;
                        }
                        break;
                    }
                    case 12:
                    {
                        if (charz.ctaskIndex == 1) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                if (charz.cgender == 0) {
                                    charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_12, -1);
                                }
                                if (charz.cgender == 1) {
                                    charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_12, -1);
                                }
                                if (charz.cgender == 2) {
                                    charz.session.service.openUISay(npcId, mResources.FINNISH_TASK3_12, -1);
                                }
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.updateEXP(0, 20000);
                                charz.updateEXP(1, 20000);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 20000), null, 0);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 20000), null, 0);
                                if (charz.cgender == 0) {
                                    charz.addItemBag(0, new Item(115, false, 1, ItemOption.getOption(115, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 1) {
                                    charz.addItemBag(0, new Item(122, false, 1, ItemOption.getOption(122, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 2) {
                                    charz.addItemBag(0, new Item(129, false, 1, ItemOption.getOption(129, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                            }
                            return false;
                        }
                        break;
                    }
                    case 13:
                    {
                        if (charz.ctaskIndex == 3) {
                            if (charz.cgender == 0) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_13, -1);
                            }
                            if (charz.cgender == 1) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_13, -1);
                            }
                            if (charz.cgender == 2) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK3_13, -1);
                            }
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 50000);
                            charz.updateEXP(1, 50000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 50000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 50000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 14:
                    {
                        if (charz.ctaskIndex == 2) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_14, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 80000);
                            charz.updateEXP(1, 80000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 80000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 80000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 15:
                    {
                        if (charz.ctaskIndex == 4) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_15, -1);
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.updateEXP(0, 150000);
                                charz.updateEXP(1, 150000);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 150000), null, 0);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 150000), null, 0);
                                if (charz.cgender == 0) {
                                    charz.addItemBag(0, new Item(95, false, 1, ItemOption.getOption(95, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 1) {
                                    charz.addItemBag(0, new Item(102, false, 1, ItemOption.getOption(102, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 2) {
                                    charz.addItemBag(0, new Item(109, false, 1, ItemOption.getOption(109, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                            }
                            return false;
                        }
                        break;
                    }
                    case 16:
                    {
                        if (charz.ctaskIndex == 1) {
                            if (charz.cgender == 0) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_16, -1);
                            }
                            if (charz.cgender == 1) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_16 , -1);
                            }
                            if (charz.cgender == 2) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK3_16, -1);
                            }
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 150000);
                            charz.updateEXP(1, 150000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 150000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 150000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 19:
                    {
                        if (charz.ctaskIndex == 4) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_19, -1);
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.updateEXP(0, 200000);
                                charz.updateEXP(1, 200000);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 200000), null, 0);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 200000), null, 0);
                                if (charz.cgender == 0) {
                                    charz.addItemBag(0, new Item(96, false, 1, ItemOption.getOption(96, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 1) {
                                    charz.addItemBag(0, new Item(103, false, 1, ItemOption.getOption(103, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                                if (charz.cgender == 2) {
                                    charz.addItemBag(0, new Item(100, false, 1, ItemOption.getOption(100, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                }
                            }
                            return false;
                        }
                        break;
                    }
                    case 20:
                    {
                        if (charz.ctaskIndex == 2) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_20, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 5000000);
                            charz.updateEXP(1, 5000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 5000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 5000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 21:
                    {
                        if (charz.ctaskIndex == 2) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_21, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 5000000);
                            charz.updateEXP(1, 5000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 5000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 5000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 22:
                    {
                        if (charz.ctaskIndex == 6) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_22, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 50000000);
                            charz.updateEXP(1, 50000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 50000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 50000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 23:
                    {
                        if (charz.ctaskIndex == 3) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_23, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 20000000);
                            charz.updateEXP(1, 20000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 20000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 20000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 24:
                    {
                        if (charz.ctaskIndex == 4) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_24, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 20000000);
                            charz.updateEXP(1, 20000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 20000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 20000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 25:
                    {
                        if (charz.ctaskIndex == 3) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK_25, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 20000000);
                            charz.updateEXP(1, 20000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 20000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 20000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 26:
                    {
                        if (charz.ctaskIndex == 0) {
                            if (charz.cgender == 0) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK1_26, -1);
                            }
                            if (charz.cgender == 1) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_26, -1);
                            }
                            if (charz.cgender == 2) {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK3_26, -1);
                            }
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        if (charz.ctaskIndex == 1) {
                            charz.session.service.chat(charz.charID, mResources.FINNISH_TASK5_26);
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK4_26, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        if (charz.ctaskIndex == 2) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK6_26, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        if (charz.ctaskIndex == 3) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK7_26, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        if (charz.ctaskIndex == 5) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK8_26, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 1000000);
                            charz.updateEXP(1, 1000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 1000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 1000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 27:
                    {
                        if (charz.ctaskIndex == 4) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_27, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 1000000);
                            charz.updateEXP(1, 1000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 1000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 1000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 28:
                    {
                        if (charz.ctaskIndex == 4) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_28, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 1000000);
                            charz.updateEXP(1, 1000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 1000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 1000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 29:
                    {
                        if (charz.ctaskIndex == 5) {
                            if (charz.getEmptyBagCount() < 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAG_FULL_2, 1), null, 0);
                            } else {
                                charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_29, -1);
                                dragon.t.MeTask.updateTask(charz, 1);
                                charz.updateEXP(0, 1000000);
                                charz.updateEXP(1, 1000000);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 1000000), null, 0);
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 1000000), null, 0);
                                charz.addItemBag(0, new Item(379, false, 1, ItemOption.getOption(379, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                            }
                            return false;
                        }
                        break;
                    }
                    case 30:
                    {
                        if (charz.ctaskIndex == 5) {
                            charz.session.service.openUISay(npcId, mResources.FINNISH_TASK2_30, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 1000000);
                            charz.updateEXP(1, 1000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 1000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 1000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 31:
                    {
                        if (charz.ctaskIndex == 5) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.FINNISH_TASK2_31, null, 0);
                            dragon.t.MeTask.updateTask(charz, 1);
                            charz.updateEXP(0, 1000000);
                            charz.updateEXP(1, 1000000);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_SM, 1000000), null, 0);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.THUONG_TN, 1000000), null, 0);
                            return false;
                        }
                        break;
                    }
                    case 33:
                    {
                        if (charz.ctaskIndex == 7 && charz.mapTemplateId == 50) {
                            charz.resetMenu();
                            charz.menuBoard.chat = mResources.FINNISH_TASK2_33;
                            charz.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                            charz.menuBoard.openUIConfirm(5, null, null, -1);
                            dragon.t.MeTask.updateTask(charz, 1);
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        return true;
    }
    
}
