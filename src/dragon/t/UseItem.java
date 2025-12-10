package dragon.t;

import dragon.server.Server;
import dragon.server.mResources;
import java.util.ArrayList;

/**
 * Class xử lý sử dụng item
 * Hàm này sử dụng cho cả Char và Pet
 * 
 * @author TGDD
 */
public class UseItem {

    public static void useItem(Char player, Item item) {
        if (item.isTypeBody() && item.typeUI == 3) {
            player.getItem(4, item.indexUI);
            return;
        }
        if (item.template.type == 6
                && (player.cHP < player.cHPFull || player.cMP < player.cMPFull || player.myPet != null)
                && player.lastTimeUseThisFoods <= System.currentTimeMillis()) {
            player.lastTimeUseThisFoods = System.currentTimeMillis() + 10000;
            int num = item.foodsHPKI();
            player.upHP(num);
            player.upMP(num);
            player.session.service.meLoadHP(player.cHP);
            player.session.service.meLoadMP(player.cMP);
            player.useItemBag(item.indexUI, 1);
            player.zoneMap.playerLoadHP(player, -1);
            if (player.myPet != null && player.myPetz().zoneMap != null && !player.myPetz().isDie) {
                player.myPetz().upHP(num);
                player.myPetz().upMP(num);
                player.myPetz().zoneMap.playerLoadHP(player.myPetz(), -1);
                player.myPetz().upStamina(player.myPetz().cMaxStamina);
                player.session.service.chat(player.myPetz().charID, mResources.THANK_KIS);
                player.isCallDau = false;
            }
        }

        // Method này dùng để học kỹ năng từ item
        if (item.template.type == 7) {
            short skillId = Skill.skillIdByItem(item.template.id, player.nClassId);
            if (skillId != -1) {
                Skill uSkill = Skill.arrSkill[skillId];
                if (uSkill != null) {
                    int pointSkill = player.getSkillPoint(uSkill.template.id);
                    if (pointSkill >= uSkill.point) {
                        player.session.service.chatTHEGIOI(mResources.EMPTY,
                                String.format(mResources.HAVE_LEARNED, uSkill.template.name, uSkill.point), null,
                                (byte) 0);
                    } else if ((uSkill.point != 1 && pointSkill == -1)
                            || (pointSkill != -1 && pointSkill + 1 != uSkill.point)) {
                        if (pointSkill != -1) {
                            player.session.service.chatTHEGIOI(mResources.EMPTY,
                                    String.format(mResources.HAVE_NOT_LEARNED, uSkill.template.name, (pointSkill + 1)),
                                    null, (byte) 0);
                        } else {
                            player.session.service.chatTHEGIOI(mResources.EMPTY,
                                    String.format(mResources.NEED_TO_LEARN, uSkill.template.name), null, (byte) 0);
                        }
                    } else {
                        Skill newSkill = uSkill.clone();
                        if (pointSkill == -1) {
                            player.skills.add(newSkill);
                        } else {
                            int i;
                            for (i = 0; i < player.skills.size(); i++) {
                                if (player.skills.get(i).template.id == uSkill.template.id) {
                                    newSkill.lastTimeUseThisSkill = player.skills.get(i).lastTimeUseThisSkill;
                                    player.skills.set(i, newSkill);
                                    if (player.mySkill != null && newSkill.template.id == player.mySkill.template.id) {
                                        player.mySkill = newSkill;
                                    }
                                    break;
                                }
                            }
                        }
                        player.updateAll();
                        player.session.service.meLoadSkill(player.skills);
                        player.useItemBag(item.indexUI, 1);
                        player.session.service.chatTHEGIOI(mResources.EMPTY,
                                String.format(mResources.FINISH_LEARN, uSkill.template.name, uSkill.point), null,
                                (byte) 0);
                    }
                }
            }
        }
        // Capsule
        if (item.template.id == 194 || item.template.id == 193) {
            player.itemUse = item;
            player.openTransport(0);
        }
        // Tu dong luyen tap
        if (item.template.id == 521) {
            if (player.isExistItem(4387)) {
                item.getOption(1).param = player.getItemById(4387).second / 60;
                player.setItem(4387, 0, 1, 0);
                player.session.service.Bag(player.arrItemBag);
            } else if (item.getParamOption(1) > 0) {
                player.setItem(4387, item.getParamOption(1) * 60, 1, 0);
                item.getOption(1).param = 0;
                player.session.service.Bag(player.arrItemBag);
            }
        }
        // May do Capsule ki bi
        if (item.template.id == 379) {
            player.setItem(2758, 60 * 30, 1, 5);
            player.useItemBag(item.indexUI, 1);
        }
        // Capsule ki bi
        if (item.template.id == 380) {
            int indexUI = player.getEmptyBagIndex();
            if (indexUI != -1) {
                short arrIdCapsuleKiBi[] = new short[] { 225, 381, 382, 383, 384, 385 };
                short templpateId232 = arrIdCapsuleKiBi[Util.gI().nextInt(arrIdCapsuleKiBi.length)];
                player.addItemBag(0, new Item(templpateId232, false, 1, ItemOption.getOption(templpateId232, 0, -1),
                        mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                player.addQuantityItemBagByIndex(item.indexUI, -1);
                player.session.service.Bag(player.arrItemBag);
                player.session.service.setCombineEff(6, item.template.iconID, ItemTemplate.getIcon(templpateId232), -1);
            } else {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
            }
        }
        // Cuong no
        if (item.template.id == 381) {
            if (player.isCuongNo2) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(2754, 60 * 10, 1, 0);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // Bo huyet
        if (item.template.id == 382) {
            if (player.isBoHuyet2) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(2755, 60 * 10, 1, 0);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // Bo khi
        if (item.template.id == 383) {
            if (player.isBoKhi2) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(2756, 60 * 10, 1, 0);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // Giap xen bo hung
        if (item.template.id == 384) {
            if (player.isXenBoHung2) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(2757, 60 * 10, 1, 50);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // An danh
        if (item.template.id == 385) {
            int sc = 600;
            if (player.isExistItem(2760)) {
                sc = sc + player.getItemById(2760).second;
            }
            if (sc > 1800) {
                sc = 1800;
            }
            player.setItem(2760, sc, 1, 0);
            player.useItemBag(item.indexUI, 1);
        }
        // Lam moi de tu
        if (item.template.id == 401) {
            if (player.myPet != null) {
                player.arrItem = new Item[] { item };
                player.resetMenu();
                player.menuBoard.chat = mResources.REQUEST_CHANGE_PET;
                player.menuBoard.arrMenu.add(new MenuInfo(mResources.CHANGE, 128));
                player.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                player.menuBoard.openUIConfirm(5, null, null, -1);

            }
        }
        // Hop the
        if (item.template.id == 454 && player.myPet != null) {
            if (player.myPetz().petStatus == 4 && (player.myPetz().isHopThe == 1) || player.mapTemplateId == 51
                    || player.mapTemplateId == 113) {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NO_FINNISH, null, (byte) 0);
            } else if (player.holder) {
                player.addInfo1(mResources.NO_FINNISH);
            } else {
                if (player.myPetz().petStatus != 4) {
                    player.hopThe(1);
                } else {
                    player.zoneMap.setFusion(1, player.charID);
                    player.myPetz().petStatus = 1;
                    player.myPetz().isHopThe = 0;
                    player.myPetz().timeHopThe = 1000 * 60;
                    player.updateAll();
                    if (player.session != null) {
                        player.session.service.meLoadPoint();
                    }
                    player.zoneMap.playerLoadAll(player);
                    player.zoneMap.updateBody(player, 0);
                    player.timeTach = 7000;
                }
            }
        }
        // Nang cap ki nang de tu
        if (item.isItemSkillPet() && player.myPet != null) {
            Skill gSkill = null;
            int v = -1;
            if (item.template.id == 402) {
                try {
                    v = 0;
                    gSkill = player.myPetz().skills.get(0);
                } catch (Exception _) {
                    System.out.println("err use item skill pet 402");
                }
            }
            if (item.template.id == 403) {
                try {
                    v = 1;
                    gSkill = player.myPetz().skills.get(1);
                } catch (Exception e) {
                    System.out.println("err use item skill pet 403");
                }
            }
            if (item.template.id == 404) {
                try {
                    v = 2;
                    gSkill = player.myPetz().skills.get(2);
                } catch (Exception e) {
                }
            }
            if (item.template.id == 759) {
                try {
                    v = 3;
                    gSkill = player.myPetz().skills.get(3);
                } catch (Exception e) {
                }
            }
            if (gSkill != null) {
                if (gSkill.point >= gSkill.template.maxPoint) {

                } else if (v != -1) {
                    player.useItemBag(item.indexUI, 1);
                    player.myPetz().nextSkillPet(v, 1);
                    player.session.service.chat(player.myPetz().charID, mResources.THANK_KIS);
                }
            }
        }
        // Nho tim
        if (item.template.id == 211) {
            player.upStamina(player.cMaxStamina);
            player.useItemBag(item.indexUI, 1);
            player.session.service.Stamina(player.cMaxStamina);
        }

        // Ve tinh
        if (item.template.type == 22) {
            if (player.zoneMap.map.isMapBlackBall()) {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_MAP_VETINH, null, 0);
            } else if (player.zoneMap.getCountVeTinh() >= 3) {
                player.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.MAX_VETINH, 3), null, 0);
            } else {
                ItemMap itemMap = player.zoneMap.addItemMap(-1, item, player.cx,
                        player.zoneMap.mapTemplate.touchY(player.cx, player.cy), 180, -2);
                itemMap.milisecondRemove = System.currentTimeMillis() + 1800000L;
                if (player.clan != null) {
                    itemMap.clanID = player.clan.ID;
                }
                itemMap.plId = player.playerId;
                player.zoneMap.itemMapAdd(itemMap);
                player.useItemBag(item.indexUI, 1);
            }
        }

        // Goi rong
        if ((item.template.type == 12 || item.isItemNameBall()) && !player.isGoiRong) {
            player.callDragon(item);
            return;
        }

        // Hop the 2
        if (item.template.id == 921 && player.myPet != null) {
            if (player.myPetz().petStatus == 4 && (player.myPetz().isHopThe == 1) || player.mapTemplateId == 51
                    || player.mapTemplateId == 113) {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NO_FINNISH, null, (byte) 0);
            } else if (player.holder) {
                player.addInfo1(mResources.NO_FINNISH);
            } else {
                if (player.myPetz().petStatus != 4) {
                    player.hopThe(2);
                } else {
                    player.zoneMap.setFusion(1, player.charID);
                    player.myPetz().petStatus = 1;
                    player.myPetz().isHopThe = 0;
                    player.myPetz().timeHopThe = 1000 * 60;
                    player.updateAll();
                    if (player.session != null) {
                        player.session.service.meLoadPoint();
                    }
                    player.zoneMap.playerLoadAll(player);
                    player.zoneMap.updateBody(player, 0);
                    player.timeTach = 5000;
                }
            }
        }
        // Thuc an
        if (item.template.id >= 663 && item.template.id <= 667) {
            if (player.isExistItem(item.template.iconID) || (!player.isExistItem(6324) && !player.isExistItem(6325)
                    && !player.isExistItem(6326) && !player.isExistItem(6327) && !player.isExistItem(6328))) {
                player.setItem(item.template.iconID, 60 * 10, 1, 10);
                player.useItemBag(item.indexUI, 1);
            } else {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HAVE_THUC_AN, null, 0);
            }
        }
        // Khau trang
        if (item.template.id == 764) {
            player.setItem(item.template.iconID, 60 * item.getParamOption(9), 1, item);
            player.useItemBag(item.indexUI, 1);
        }
        // Banh
        if (item.template.type == 31) {
            if (player.isExistItem(item.template.iconID)
                    || (!player.isExistItem(4042) && !player.isExistItem(4043) && !player.isExistItem(4125)
                            && !player.isExistItem(4126) && !player.isExistItem(7079) && !player.isExistItem(7080))) {
                Item it;
                if (item.template.id == 465) {
                    player.setItem(item.template.iconID, 60 * 60, 1, item);
                }
                if (item.template.id == 466) {
                    player.setItem(item.template.iconID, 60 * 90, 1, item);
                }
                if (item.template.id == 472) {
                    player.setItem(item.template.iconID, 60 * 120, 1, item);
                }
                if (item.template.id == 473) {
                    player.setItem(item.template.iconID, 60 * 150, 1, item);
                }
                if (item.template.id == 752) {
                    player.setItem(item.template.iconID, 60 * 60, 1, item);
                }
                if (item.template.id == 753) {
                    player.setItem(item.template.iconID, 60 * 60, 1, item);
                }

                player.useItemBag(item.indexUI, 1);
            } else {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HAVE_BANH, null, 0);
            }
        }
        // The
        if (item.template.type == 33) {
            player.useItemBag(item.indexUI, 1);
            player.addCard(item.template.id, 1);
        }
        // Use pet
        if (item.isItemPet()) {
            if (player.timeUsePet > 0) {
                player.session.service.chatTHEGIOI(mResources.EMPTY,
                        String.format(mResources.DELAY_THAO_TAC, Util.gI().getStrTime(player.timeUsePet)), null, 0);
            } else {
                if (player.usePet != null) {
                    player.timeUsePet = 10000;
                }
                if (item == player.usePet) {
                    player.usePet(null);
                } else {
                    player.usePet(item);
                }
            }
        }

        // //Capsule 574
        if (item.template.id == 574) {
            int indexUI = player.getEmptyBagIndex();
            if (indexUI != -1) {
                player.useItemBag(item.indexUI, 1);
                Item itnew;
                int[] arrD = new int[] { 3, 7 };
                if (Util.gI().nextInt(100) < 20) {
                    int tempId = Util.gI().nextInt(342, 345);
                    itnew = new Item(tempId, false, 1, ItemOption.getOption(tempId, 0, 0),
                            mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                } else if (Util.gI().nextInt(100) < 10) {
                    int tempId = Util.gI().nextInt(710, 711);
                    itnew = new Item(tempId, false, 1, ItemOption.getOption(tempId,
                            arrD[Util.gI().nextInt(arrD.length)], 0), mResources.EMPTY, mResources.EMPTY,
                            mResources.EMPTY);
                } else if (Util.gI().nextInt(100) < 5) {
                    itnew = new Item(464, false, 1, ItemOption.getOption(464,
                            arrD[Util.gI().nextInt(arrD.length)], 0), mResources.EMPTY, mResources.EMPTY,
                            mResources.EMPTY);
                } else if (Util.gI().nextInt(100) < 5) {
                    itnew = new Item(942, false, 1, ItemOption.getOption(942,
                            arrD[Util.gI().nextInt(arrD.length)], 0), mResources.EMPTY, mResources.EMPTY,
                            mResources.EMPTY);
                } else if (Util.gI().nextInt(1000) < 8) {
                    itnew = new Item(987, false, 1, ItemOption.getOption(987, 0, 0),
                            mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.USE_IDOL, player.cName,
                            item.template.name, itnew.template.name));
                } else if (Util.gI().nextInt(1000) < 1) {
                    int tempId = Util.gI().nextInt(710, 711);
                    itnew = new Item(tempId, false, 1, ItemOption.getOption(tempId, 0, 0),
                            mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.USE_IDOL2, player.cName,
                            item.template.name, itnew.template.name));
                } else if (Util.gI().nextInt(1000) < 1) {
                    itnew = new Item(464, false, 1, ItemOption.getOption(464, 0, 0),
                            mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.USE_IDOL2, player.cName,
                            item.template.name, itnew.template.name));
                } else if (Util.gI().nextInt(1000) < 10) {
                    itnew = new Item(942, false, 1, ItemOption.getOption(942, 0, 0),
                            mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.USE_IDOL2, player.cName,
                            item.template.name, itnew.template.name));
                } else if (Util.gI().nextInt(100) < 30) {
                    itnew = new Item(934, false, Util.gI().nextInt(5, 10),
                            ItemOption.getOption(934, 0, 0), mResources.EMPTY, mResources.EMPTY,
                            mResources.EMPTY);
                } else {
                    itnew = new Item(224, false, 99, ItemOption.getOption(224, 0, 0),
                            mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
                if (itnew.isHaveOption(93)) {
                    itnew.setExpires(System.currentTimeMillis() + (long) (1000l * 60l * 60l * 24l
                            * (long) (itnew.getParamOption(93) + 1)));
                }
                player.addItemBag(0, itnew);
                player.session.service.setCombineEff(6, item.template.iconID, itnew.template.iconID, -1);
            } else {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL,
                        null, (byte) 0);
            }
        }

        // Chuot than tai
        if (item.template.id == 757) {
            player.useItemBag(item.indexUI, 1);
            int second = 1800;
            player.setItem(6314, second, 0, 2);
        }

        // Nhan thoi khong sai lech
        if (item.template.id == 992 && !player.zoneMap.map.isMapThucVat()) {
            dragon.t.Map map = dragon.t.Map.getMapServer(160);
            if (map != null) {
                dragon.t.ZoneMap tile211 = map.getZone(player);
                if (tile211 != null) {
                    player.transPort(5000, 1, tile211, 0, 0, 775, 168);
                    if (player.ctaskId == 34 && player.ctaskIndex == 1) {
                        player.updateTask(1);
                    }
                } else {
                    player.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                }
            }
        }

        // Phao hoa
        if (item.template.id == 1036) {
            player.phaohoa = item;
            player.clientInput.openClientInput(8, mResources.SHOOT_PHAO_HOA, new String[] { mResources.QUANTITY },
                    new int[] { 0 });
        }

        // Hoa dang
        if (item.template.id == 1037) {
            player.phaohoa = item;
            player.clientInput.openClientInput(9, mResources.SHOOT_HOA_DANG, new String[] { mResources.QUANTITY },
                    new int[] { 0 });
        }

        // Hoa dang co loi chuc
        if (item.template.id == 1038) {
            player.phaohoa = item;
            player.clientInput.openClientInput(10, mResources.SHOOT_HOA_DANG, new String[] { mResources.QUANTITY },
                    new int[] { 0 });
        }

        // //Capsule trung thu
        // if (item.template.id == 737) {
        // openCapsuleTrungThu(player, item);
        // }
        // //Capsule nv
        // if (item.template.id == 209) {
        // openCapsuleNV(player, item);
        // }

        // Ruong go
        if (item.template.id == 570) {
            UseItem.openBox(player, item);
        }

        // //Capsule halloween
        // if (item.template.id == 818) {
        // if (Dragon.isEvent_Halloween) {
        // UseItem.openCapsuleHalloween(player, item);
        // } else {
        // player.addInfo1(mResources.THE_END_EVENT);
        // }
        // }

        // //Tui qua halloween
        // if (item.template.id == 204) {
        // UseItem.openGiftBag(player, item);
        // }
        // // hom halloween
        // if (item.template.id == 1116) {
        // UseItem.openArkhalloween(player, item);
        // }
        // // capsuel BF
        // if (item.template.id == 984) {
        // UseItem.openCapsuleBF(player, item);
        // }
        // //Hop qua dac biet
        // if (item.template.id == 210) {
        // UseItem.openGiftBox(player, item);
        // }

        // //Tinh linh
        // if (item.template.id == 206) {
        // player.useItemBag(item.indexUI, 1);
        // int second = 1800;
        // player.setItem(6535, second, 1, 10);
        // }
        // //Yeu tinh
        // if (item.template.id == 207) {
        // player.useItemBag(item.indexUI, 1);
        // int second = 1800;
        // player.setItem(6537, second, 1, 10);
        // }
        // //Ac linh
        // if (item.template.id == 208) {
        // player.useItemBag(item.indexUI, 1);
        // int second = 1800;
        // player.setItem(6539, second, 1, 10);
        // }

        // Thuc an halloween
        if (item.template.id == 899 || item.template.id == 900 || item.template.id == 902 || item.template.id == 903) {
            if (player.isExistItem(item.template.iconID) || (!player.isExistItem(8243) && !player.isExistItem(8244)
                    && !player.isExistItem(8246) && !player.isExistItem(8247))) {
                if (item.template.id == 899) {
                    player.setItem(item.template.iconID, 1800, 1, 5);
                } else {
                    player.setItem(item.template.iconID, 1800, 1, 10);
                }
                player.useItemBag(item.indexUI, 1);
            } else {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HAVE_THUC_AN, null, 0);
            }
        }

        // //su kien world cup
        // //Capsule worlcup 2022 thuong
        // if (item.template.id == 1135) {
        // UseItem.openCapsuleWC(player, item);
        // }
        // //Capsule worlcup 2022 VIP
        // if (item.template.id == 1136) {
        // UseItem.openCapsuleWCV(player, item);
        // }

        // su kien tet
        // Capsule tet 2023
        if (item.template.id == 758) {
            UseItem.openCapsuleTet2023(player, item);
        }

        // Mam Ngu Qua
        if (item.template.id == 1182) {
            UseItem.openFruitTray(player, item);
        }

        // Goi qua dac biet 2023
        if (item.template.id == 1184) {
            UseItem.openGiftBox2023(player, item);
        }

        // hop qua db 2023
        if (item.template.id == 1187) {
            UseItem.openGiftBoxDB(player, item);
        }

        // Thuc an tet (Xi muoi)
        if (item.template.id == 1195 || item.template.id == 1196) {
            if (player.isExistItem(item.template.iconID)
                    || (!player.isExistItem(10905) && !player.isExistItem(10904))) {
                player.setItem(item.template.iconID, 600, 1, 0);
                player.useItemBag(item.indexUI, 1);
            } else {
                player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HAVE_THUC_AN, null, 0);
            }
        }

        // Binh Commeson
        if (item.template.id == 638) {
            player.setItem(5829, 3600, 1, 0);
            player.useItemBag(item.indexUI, 1);
        }

        // usePetFollowz
        if (item.isItemPetFollowz()) {
            if (player.timeUsePet > 0) {
                player.session.service.chatTHEGIOI(mResources.EMPTY,
                        String.format(mResources.DELAY_THAO_TAC, Util.gI().getStrTime(player.timeUsePet)), null, 0);
            } else {
                if (player.checkPetFollowz(item)) {
                    player.checkClearPetFollowz(item);
                } else {
                    if (player.myPetz() == null) {
                        player.usePetFollowz(item);
                    } else {
                        player.openSelectPetFollowz(item);
                    }
                }
            }
        }

        // trung petfollower
        if (item.template.id == 2005) {
            player.session.myCharz().arrItem = new Item[] { item };
            player.session.myCharz().resetMenu();
            player.session.myCharz().menuBoard.chat = mResources.HATH_EGG;
            player.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 84));
            player.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
            player.session.myCharz().menuBoard.openUIConfirm(5, null, null, -1);
        }

        // do ngoc namek
        if (item.template.id == 361) {
            if (player.openDoNgocNamek()) {
                player.useItemBag(item.indexUI, 1);
            }
        }
        if (item.template.id == 722) {
            UseItem.openCapsuleHong(player, item);
        }
        // Cuong no 2
        if (item.template.id == 1150) {
            if (player.isCuongNo) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(10716, 60 * 10, 1, 0);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // Bo huyet 2
        if (item.template.id == 1152) {
            if (player.isBoHuyet) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(10714, 60 * 10, 1, 0);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // Bo khi 2
        if (item.template.id == 1151) {
            if (player.isBoKhi) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(10715, 60 * 10, 1, 0);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // Giap xen bo hung 2
        if (item.template.id == 1153) {
            if (player.isXenBoHung) {
                player.addInfo1(100, mResources.USING_ITEM);
            } else {
                player.setItem(10712, 60 * 10, 1, 50);
                player.useItemBag(item.indexUI, 1);
            }
        }
        // //Lech Teamobi
        // //hat mam dua hau
        // if (item.template.id == 2009) {
        // player.useItemBag(item.indexUI, 1);
        // player.addDuaHau(51, new int[]{4669, 4670, 4671, 4672}, 0, 3600, -1);
        // player.addInfo1(mResources.TRONG_CAY_DUA_HAU);
        // }
        // if (item.template.id == 1989) {
        // player.CanCau(item.indexUI);
        // }
        // if (item.template.id == 1997) {
        // player.useItemBag(item.indexUI, 1);
        // player.setText(9, mResources.TEXT_BANH1, 300, 2, item);
        // }
        // if (item.template.id == 1998) {
        // player.useItemBag(item.indexUI, 1);
        // player.setText(9, mResources.TEXT_BANH2, 300, 2, item);
        // }
        // //XO ca xanh
        // if (item.template.id == 1005) {
        // UseItem.openGreenFish(player, item);
        // }
        // //Xo ca vang
        // if (item.template.id == 1006) {
        // UseItem.openGoldFish(player, item);
        // }

        // Cai lo
        if (item.template.id == 1232) {
            if (!player.isExistItem(11166)) {
                player.setItem(11184, 1800, 1, 0);
                player.useItemBag(item.indexUI, 1);
            } else {
                player.addInfo1(mResources.HAVE_BINH_CHUA);
            }
        }

        // Noi com dien
        if (item.template.id == 1233) {
            if (!player.isExistItem(11184)) {
                player.setItem(11166, 1800, 1, 0);
                player.useItemBag(item.indexUI, 1);
            } else {
                player.addInfo1(mResources.HAVE_BINH_CHUA);
            }
        }

        // Thuc an Whis
        if (item.template.id == 880 || item.template.id == 881 || item.template.id == 882) {
            if (player.isFood1 || player.isFood2 || player.isFood3) {
                player.addInfo1(mResources.USE_ONE);
            } else {
                player.useItemBag(item.indexUI, 1);
                player.setItem(item.template.iconID, 600, 1, 0);
            }
        }

        // Bon tam go
        if (item.template.id == 1241) {
            if (player.mapTemplateId != 0 && player.mapTemplateId != 7 && player.mapTemplateId == 14) {
                player.addInfo1(mResources.USE_BY_VILLAGE);
            } else if (player.isExistItem(11250) || player.isExistItem(11251)) {

            } else {
                player.useItemBag(item.indexUI, 1);
                player.setItem(11250, 180, 0, 0);
            }
        }

        // Bon tam vang
        if (item.template.id == 1242) {
            if (player.mapTemplateId != 0 && player.mapTemplateId != 7 && player.mapTemplateId == 14) {
                player.addInfo1(mResources.USE_BY_VILLAGE);
            } else if (player.isExistItem(11250) || player.isExistItem(11251)) {

            } else {
                player.useItemBag(item.indexUI, 1);
                player.setItem(11251, 60, 0, 0);
            }
        }

        // Hu mat ong
        if (item.template.id == 1250) {
            if (player.zoneMap.isHaveBoss(160) || player.zoneMap.isHaveBoss(161)) {
                player.addInfo1(mResources.HAVE_BUG1);
            } else {
                player.requestOpenUIItem(5, mResources.BUGBAIT1);
            }
        }

        // Vot bat bo
        if (item.template.id == 1251) {
            if (player.zoneMap.isHaveBoss(160) || player.zoneMap.isHaveBoss(161)) {
                player.addInfo1(mResources.HAVE_BUG1);
            } else {
                player.requestOpenUIItem(5, mResources.BUGBAIT2);
            }
        }

        // manhthiensu
        if (item.template.id == 1173) {
            UseItem.openChestTS(player, item);
        }
        // lech teamobi
        // Capsule hong ngoc
        if (item.template.id == 2000) {
            UseItem.openCapsuleHN(player, item);
        }
        // OpenHaiTac
        if (item.template.id == 2001) {
            UseItem.openHaiTac(player, item);
        }

        // May do linh hon
        if (item.template.id == 1264) {
            player.setItem(11493, 3600, 1, 0);
            player.useItemBag(item.indexUI, 1);
        }
        // Thoi vang
        if (item.template.id == 457) {
            player.clientInput.openClientInput(24, String.format(mResources.REQUEST_SALE_ITEM, item.template.name),
                    new String[] { mResources.SOLUONG }, new int[] { 1 });
            player.clientInput.indexs.clear();
            player.clientInput.indexs.add(1);
            player.clientInput.indexs.add(item.indexUI);
            player.clientInput.indexs.add((int) ((player.maxXu - player.xu) / SaleItemNew.priceItemCoin(item)));
        }
    }

    private static void openCapsuleTrungThu(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 30) {
                int id_98438 = new int[] { 1039, 1040 }[Util.gI().nextInt(2)];
                item2 = new Item(id_98438, false, 1, ItemOption.getOption(id_98438, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 14)));
            } else if (Util.gI().nextInt(100) < 15) {
                int id_0339487 = new int[] { 1010, 1012, 1011 }[player.cgender];
                item2 = new Item(id_0339487, false, 1, ItemOption.getOption(id_0339487, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 14)));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(734, false, 1, ItemOption.getOption(734, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 45));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(735, false, 1, ItemOption.getOption(735, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 45));
            } else if (Util.gI().nextInt(100) < 10) {
                int id645 = Util.gI().nextInt(18, 20);
                item2 = new Item(id645, false, 1, ItemOption.getOption(id645, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                int id_039245 = new int[] { 865, 1001, 741, 740 }[Util.gI().nextInt(4)];
                item2 = new Item(id_039245, false, 1, ItemOption.getOption(id_039245, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 14)));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(466, false, 1, ItemOption.getOption(466, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                int id349 = Util.gI().nextInt(712, 716);
                item2 = new Item(id349, false, 1, ItemOption.getOption(id349, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(934, false, 20, ItemOption.getOption(934, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                int id_0339487 = new int[] { 1010, 1012, 1011 }[player.cgender];
                item2 = new Item(id_0339487, false, 1, ItemOption.getOption(id_0339487, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 14)));
            } else if (Util.gI().nextInt(100) < 5) {
                int id_98438 = new int[] { 472, 473 }[Util.gI().nextInt(2)];
                item2 = new Item(id_98438, false, 1, ItemOption.getOption(id_98438, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(93, 30));
            } else if (Util.gI().nextInt(100) < 5) {
                int id_395 = Util.gI().nextInt(441, Util.gI().nextInt(441, 447));
                item2 = new Item(id_395, false, Util.gI().nextInt(1, 3), ItemOption.getOption(id_395, 0, 0),
                        mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                int id_998437 = new int[] { 1039, 1040 }[Util.gI().nextInt(2)];
                item2 = new Item(id_998437, false, 1, ItemOption.getOption(id_998437, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                int id_03934 = new int[] { 865, 1001, 741, 740 }[Util.gI().nextInt(4)];
                item2 = new Item(id_03934, false, 1, ItemOption.getOption(id_03934, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(200) < 1) {
                item2 = new Item(14, false, 1, ItemOption.getOption(14, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else {
                item2 = new Item(465, false, 1, ItemOption.getOption(465, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            player.session.service.setCombineEff(6, item.template.iconID, item2.template.iconID, -1);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 2, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openCapsuleNV(Char player, Item item) {
        if ((player.ctaskId == 24 && (player.ctaskIndex == 0 || player.ctaskIndex == 1 || player.ctaskIndex == 2
                || player.ctaskIndex == 3))
                || (player.ctaskId == 25
                        && (player.ctaskIndex == 0 || player.ctaskIndex == 1 || player.ctaskIndex == 2))) {
            player.useItemBag(item.indexUI, 1);
            player.ctaskCount = Task.getTask(player.ctaskId).counts[player.cgender][player.ctaskIndex];
            player.updateTask(1);
        } else {
            player.addInfo1(mResources.KHONG_HO_TRO_NV);
        }
    }

    private static void openBox(Char player, Item item) {
        int num0 = item.getParamOption(72);
        if (Memory.get(player.session.userId).isRuongDaiHoi) {
            player.addInfo1(mResources.WAIT_DAY);
        } else if (player.getEmptyBagCount() < item.getParamOption(72)) {
            player.addInfo1(String.format(mResources.BAG_FULL_2, num0));
        } else {
            player.useItemBag(item.indexUI, 1);
            ArrayList list = new ArrayList<>();
            for (int i = 0; i < item.getParamOption(72); i++) {
                if (i == 0) {
                    int num1 = Util.gI().nextInt(5000000, 15000000) * num0;
                    player.updateXu(num1, 2);
                    list.add(String.format(mResources.BAN_NHAN_DUOC_4, Util.gI().getFormatNumber(num1)));
                } else if (i == 1) {
                    int num2 = Util.gI().nextInt(5, 7) * num0;
                    player.updateLuong(num2, 2);
                    list.add(String.format(mResources.BAN_NHAN_DUOC_5, Util.gI().getFormatNumber(num2)));
                } else if (i > 1) {
                    if (i == 2) {
                        int templateId1 = Util.gI().nextInt(441, 447);
                        Item item2 = new Item(templateId1, false, 1, ItemOption.getOption(templateId1, 0, 0),
                                mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        player.addItemBag(1, item2);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item2.template.name, item2.optionCombine(),
                                item2.template.description));
                    }
                    if (i == 3) {
                        int templateId2 = Util.gI().nextInt(18, 20);
                        Item item3 = new Item(templateId2, false, 1, ItemOption.getOption(templateId2, 0, 0),
                                mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        player.addItemBag(1, item3);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item3.template.name, item3.optionCombine(),
                                item3.template.description));
                    }
                    if (i == 4) {
                        int templateId3 = Util.gI().nextInt(220, 224);
                        Item item4 = new Item(templateId3, false, item.getParamOption(72) * Util.gI().nextInt(5, 9),
                                ItemOption.getOption(templateId3, 0, 0), mResources.EMPTY, mResources.EMPTY,
                                mResources.EMPTY);
                        player.addItemBag(1, item4);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item4.template.name, item4.optionCombine(),
                                item4.template.description));
                    }
                    if (i == 5) {
                        int templateId4 = 933;
                        Item item5 = new Item(templateId4, false, 1,
                                ItemOption.getOption(templateId4, 0, item.getParamOption(72) * 5), mResources.EMPTY,
                                mResources.EMPTY, mResources.EMPTY);
                        player.addItemBag(1, item5);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item5.template.name, item5.optionCombine(),
                                item5.template.description));
                    }
                    if (i == 6) {
                        int templateId5 = 1229;
                        Item item6 = new Item(templateId5, false, item.getParamOption(72) * 5,
                                ItemOption.getOption(templateId5, 0, 0), mResources.EMPTY, mResources.EMPTY,
                                mResources.EMPTY);
                        player.addItemBag(1, item6);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item6.template.name, item6.optionCombine(),
                                item6.template.description));
                    }
                    if (i == 7) {
                        int templateId6 = new int[] { 18, 19, 20, 380 }[Util.gI().nextInt(4)];
                        Item item7 = new Item(templateId6, false, 1, ItemOption.getOption(templateId6, 0, 0),
                                mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        player.addItemBag(1, item7);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item7.template.name, item7.optionCombine(),
                                item7.template.description));
                    }
                    if (i == 8) {
                        int templateId7 = 821;
                        Item item8 = new Item(templateId7, false, Util.gI().nextInt(5, 10),
                                ItemOption.getOption(templateId7, 0, 0), mResources.EMPTY, mResources.EMPTY,
                                mResources.EMPTY);
                        player.addItemBag(1, item8);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item8.template.name, item8.optionCombine(),
                                item8.template.description));
                    }
                    if (i == 9) {
                        int templateId8 = new int[] { 213, 214, 215, 216, 217, 218, 219, 522, 671, 672 }[Util.gI()
                                .nextInt(10)];
                        Item item9 = new Item(templateId8, false, 1, ItemOption.getOption(templateId8, 0, 0),
                                mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        item9.options.add(new ItemOption(185, 24 * Util.gI().nextInt(1, 7)));
                        player.addItemBag(1, item9);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item9.template.name, item9.optionCombine(),
                                item9.template.description));
                    }
                    if (i == 10 && Util.gI().nextInt(100) < 60) {
                        int templateId9 = new short[] { 231, 243, 255, 267, 235, 247, 259, 271, 239, 251, 263,
                                275 }[Util.gI().nextInt(12)];
                        Item item10 = new Item(templateId9, false, 1, ItemOption.getOption(templateId9, 0, -1),
                                mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        // random + 15%
                        for (int i2 = 0; i2 < item10.options.size(); i2++) {
                            item10.options.get(i2).param = (int) (item10.options.get(i2).param
                                    + ((float) item10.options.get(i2).param / 100F * (float) Util.gI().nextInt(15)));
                        }
                        player.addItemBag(1, item10);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item10.template.name, item10.optionCombine(),
                                item10.template.description));
                    } else if (i == 10) {
                        int templateId9 = new short[] { 16, 17 }[Util.gI().nextInt(2)];
                        Item item10 = new Item(templateId9, false, 1, null, mResources.EMPTY, mResources.EMPTY,
                                mResources.EMPTY);
                        item10.options.add(new ItemOption(30, 0));
                        player.addItemBag(1, item10);
                        list.add(String.format(mResources.BAN_NHAN_DUOC_6, item10.template.name, item10.optionCombine(),
                                item10.template.description));
                    }

                }
            }
            if (player.isFullTBHD) {
                Item item11 = new Item(1067, false, num0 * 2, ItemOption.getOption(1067, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
                player.addItemBag(1, item11);
                list.add(String.format(mResources.BAN_NHAN_DUOC_6, item11.template.name, item11.optionCombine(),
                        item11.template.description));
            }
            player.addConfirm(list);
        }
    }

    private static void openCapsuleHalloween(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1001, false, 1, ItemOption.getOption(1001, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(903, false, 1, ItemOption.getOption(903, 7, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 30));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(814, false, 1, ItemOption.getOption(814, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(815, false, 1, ItemOption.getOption(815, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(816, false, 1, ItemOption.getOption(816, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(817, false, 1, ItemOption.getOption(817, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(712, 716);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1001, false, 1, ItemOption.getOption(1001, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(Util.gI().nextInt(86, 87), 0));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(814, false, 1, ItemOption.getOption(814, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(Util.gI().nextInt(86, 87), 0));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(815, false, 1, ItemOption.getOption(815, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(Util.gI().nextInt(86, 87), 0));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(816, false, 1, ItemOption.getOption(816, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(Util.gI().nextInt(86, 87), 0));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(817, false, 1, ItemOption.getOption(817, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(Util.gI().nextInt(86, 87), 0));
            } else {
                int id = Util.gI().nextInt(199, 201);
                item2 = new Item(id, false, Util.gI().nextInt(1, 99), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            // Service.setCombineEff(6, item.template.iconID, item2.template.iconID);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openGiftBag(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 40) {
                item2 = new Item(739, false, 1, ItemOption.getOption(739, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 40) {
                item2 = new Item(742, false, 1, ItemOption.getOption(742, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(902, false, 1, ItemOption.getOption(902, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 30));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                int id = Util.gI().nextInt(712, 716);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(739, false, 1, ItemOption.getOption(739, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(742, false, 1, ItemOption.getOption(742, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else {
                int id = Util.gI().nextInt(199, 201);
                item2 = new Item(id, false, Util.gI().nextInt(1, 50), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 1, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openGiftBox(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(908, false, 1, ItemOption.getOption(908, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(899, 900);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 30));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(909, false, 1, ItemOption.getOption(909, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(206, 208);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 45));
            } else if (Util.gI().nextInt(100) < 15) {
                item2 = new Item(942, false, 1, ItemOption.getOption(942, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 15) {
                int id = Util.gI().nextInt(712, 716);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 15) {
                item2 = new Item(987, false, 1, ItemOption.getOption(987, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1108, false, 1, ItemOption.getOption(1108, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1109, false, 1, ItemOption.getOption(1109, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(999, false, 1, ItemOption.getOption(999, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(908, false, 1, ItemOption.getOption(908, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL2, player.cName, item.template.name, item2.template.name));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(909, false, 1, ItemOption.getOption(909, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL2, player.cName, item.template.name, item2.template.name));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(942, false, 1, ItemOption.getOption(942, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL2, player.cName, item.template.name, item2.template.name));
            } else {
                int id = Util.gI().nextInt(199, 201);
                item2 = new Item(id, false, Util.gI().nextInt(50, 99), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 3, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openArkhalloween(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 15), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1104, false, 1, ItemOption.getOption(1105, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1105, false, 1, ItemOption.getOption(1105, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1106, false, 1, ItemOption.getOption(1106, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(712, 716);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(1013, false, 1, ItemOption.getOption(1013, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(743, false, 1, ItemOption.getOption(743, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(15, 30)));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1104, false, 1, ItemOption.getOption(1104, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1105, false, 1, ItemOption.getOption(1105, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1106, false, 1, ItemOption.getOption(1106, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1013, false, 1, ItemOption.getOption(1013, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else {
                int id = Util.gI().nextInt(199, 201);
                item2 = new Item(id, false, Util.gI().nextInt(20, 50), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            // Rank.getRank(3).addTop(player.cName, player.head, player.headICON,
            // player.body, player.leg, player.charID, player.pointEvent += 3, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openCapsuleBF(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(1245, 1247);
                item2 = new Item(id, false, Util.gI().nextInt(5, 20), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 25) {
                int id = Util.gI().nextInt(618, 626);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(220, 224);
                item2 = new Item(id, false, Util.gI().nextInt(10, 50), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(934, false, 1, ItemOption.getOption(934, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(821, false, 1, ItemOption.getOption(821, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(30, 0));
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(300) < 1) {
                int id = Util.gI().nextInt(618, 626);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(500) < 1) {
                item2 = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else {
                int id = Util.gI().nextInt(1245, 1247);
                item2 = new Item(id, false, Util.gI().nextInt(5, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            // Rank.getRank(3).addTop(player.cName, player.head, player.headICON,
            // player.body, player.leg, player.charID, player.pointEvent += 3, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openCapsuleWC(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(677, false, 1, ItemOption.getOption(677, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(678, false, 1, ItemOption.getOption(678, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(984, false, 1, ItemOption.getOption(984, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(980, false, 1, ItemOption.getOption(980, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(897, false, 1, ItemOption.getOption(897, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 30));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(966, false, 1, ItemOption.getOption(966, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(982, false, 1, ItemOption.getOption(982, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(983, false, 1, ItemOption.getOption(983, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(680, false, 1, ItemOption.getOption(680, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(897, false, 1, ItemOption.getOption(897, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(966, false, 1, ItemOption.getOption(966, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(982, false, 1, ItemOption.getOption(982, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(983, false, 1, ItemOption.getOption(983, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(677, false, 1, ItemOption.getOption(677, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(678, false, 1, ItemOption.getOption(678, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else {
                int id = Util.gI().nextInt(677, 678);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 1, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openCapsuleWCV(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1114, false, 1, ItemOption.getOption(1114, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(995, false, 1, ItemOption.getOption(995, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1107, false, 1, ItemOption.getOption(1107, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(967, false, 1, ItemOption.getOption(967, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1140, false, 1, ItemOption.getOption(1140, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1128, false, 1, ItemOption.getOption(1128, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(981, false, 1, ItemOption.getOption(981, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 30));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(987, false, 1, ItemOption.getOption(987, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(920, false, 1, ItemOption.getOption(920, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(995, false, 1, ItemOption.getOption(995, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 3) {
                item2 = new Item(1114, false, 1, ItemOption.getOption(1114, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1140, false, 1, ItemOption.getOption(1140, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(967, false, 1, ItemOption.getOption(967, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1128, false, 1, ItemOption.getOption(1128, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(1107, false, 1, ItemOption.getOption(1107, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 3, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openCapsuleTet2023(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 30) {
                item2 = new Item(751, false, 5, ItemOption.getOption(751, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(861, false, 25, ItemOption.getOption(861, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(190, false, 5000000, ItemOption.getOption(190, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(441, 447);
                item2 = new Item(id, false, Util.gI().nextInt(1, 5), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(381, false, Util.gI().nextInt(1, 3), ItemOption.getOption(381, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(382, false, Util.gI().nextInt(1, 3), ItemOption.getOption(382, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(383, false, Util.gI().nextInt(1, 3), ItemOption.getOption(383, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(984, false, 1, ItemOption.getOption(984, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 7));
            } else if (Util.gI().nextInt(100) < 5) {
                int id = Util.gI().nextInt(929, 931);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 2) {
                int id = Util.gI().nextInt(927, 929);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 5) {
                int id = new int[] { 227, 228, 229 }[player.cgender];
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(926, false, 1, ItemOption.getOption(926, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(925, false, 1, ItemOption.getOption(925, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(757, false, 1, ItemOption.getOption(757, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(30, 0));
            } else {
                int id = Util.gI().nextInt(1177, 1181);
                item2 = new Item(id, false, Util.gI().nextInt(10, 30), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openFruitTray(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 40) {
                int id = new int[] { 1155, 1157, 1156 }[player.cgender];
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 30) {
                item2 = new Item(827, false, 1, ItemOption.getOption(827, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(984, false, 1, ItemOption.getOption(984, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(823, false, 1, ItemOption.getOption(823, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(997, false, 1, ItemOption.getOption(997, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1000, false, 1, ItemOption.getOption(1000, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(849, false, 1, ItemOption.getOption(849, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 8) {
                int id = new int[] { 1155, 1157, 1156 }[player.cgender];
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 3) {
                item2 = new Item(823, false, 1, ItemOption.getOption(823, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 3) {
                item2 = new Item(997, false, 1, ItemOption.getOption(997, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 3) {
                item2 = new Item(1000, false, 1, ItemOption.getOption(1000, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(400) < 1) {
                item2 = new Item(827, false, 1, ItemOption.getOption(827, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else {
                int id = new int[] { 1155, 1157, 1156 }[player.cgender];
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 1, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openGiftBox2023(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1185, false, 1, ItemOption.getOption(1185, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1186, false, 1, ItemOption.getOption(1186, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(852, false, 1, ItemOption.getOption(852, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(948, false, 1, ItemOption.getOption(948, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(952, false, 1, ItemOption.getOption(952, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(752, false, 1, ItemOption.getOption(752, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 15) {
                item2 = new Item(953, false, 1, ItemOption.getOption(953, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 10) {
                int id = Util.gI().nextInt(712, 716);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(948, false, 1, ItemOption.getOption(948, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(952, false, 1, ItemOption.getOption(952, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(953, false, 1, ItemOption.getOption(953, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1185, false, 1, ItemOption.getOption(1185, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1186, false, 1, ItemOption.getOption(1186, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(852, false, 1, ItemOption.getOption(852, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 5), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            // Rank.getRank(3).addTop(player.cName, player.head, player.headICON,
            // player.body, player.leg, player.charID, player.pointEvent += 1, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openGiftBoxDB(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(942, false, 1, ItemOption.getOption(942, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(943, false, 1, ItemOption.getOption(943, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(944, false, 1, ItemOption.getOption(944, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(753, false, 1, ItemOption.getOption(753, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 15) {
                item2 = new Item(987, false, 1, ItemOption.getOption(987, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 15) {
                item2 = new Item(1194, false, 1, ItemOption.getOption(1194, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(1195, 1196);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 25) {
                int id = Util.gI().nextInt(712, 716);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 3) {
                item2 = new Item(1021, false, 1, ItemOption.getOption(1021, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(1022, false, 1, ItemOption.getOption(1022, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1100, false, 1, ItemOption.getOption(1100, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 3) {
                item2 = new Item(942, false, 1, ItemOption.getOption(942, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL, player.cName, item.template.name, item2.template.name));
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(943, false, 1, ItemOption.getOption(943, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL, player.cName, item.template.name, item2.template.name));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(944, false, 1, ItemOption.getOption(944, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL, player.cName, item.template.name, item2.template.name));
            } else {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 3, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openCapsuleHong(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(700, false, 3, ItemOption.getOption(700, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                int id = Util.gI().nextInt(381, 383);
                item2 = new Item(id, false, Util.gI().nextInt(1, 3), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(984, false, 1, ItemOption.getOption(984, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 7));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(700, false, 3, ItemOption.getOption(700, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(699, false, 1, ItemOption.getOption(699, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1143, false, 1, ItemOption.getOption(1143, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(680, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(25, 30))));
                item2.options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(25, 30))));
                item2.options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(25, 30))));
                item2.options.add(new ItemOption(95, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(96, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(154, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 7)));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(757, false, 1, ItemOption.getOption(757, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(30, 0));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(805, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(50, Util.gI().nextInt(2, Util.gI().nextInt(5, 10))));
                item2.options.add(new ItemOption(77, Util.gI().nextInt(2, Util.gI().nextInt(5, 10))));
                item2.options.add(new ItemOption(103, Util.gI().nextInt(2, Util.gI().nextInt(5, 10))));
                item2.options.add(new ItemOption(30, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(200) < 1) {
                item2 = new Item(680, false, 1, ItemOption.getOption(680, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(200) < 1) {
                item2 = new Item(805, false, 1, ItemOption.getOption(805, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else {
                int id = Util.gI().nextInt(1093, 1095);
                item2 = new Item(id, false, Util.gI().nextInt(5, 20), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openGreenFish(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 30) {
                int id = new int[] { 1010, 1012, 1011 }[player.cgender];
                item2 = new Item(id, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(25, 32))));
                item2.options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(25, 32))));
                item2.options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(25, 32))));
                item2.options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(5, Util.gI().nextInt(5, 20)));
                item2.options.add(new ItemOption(154, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(984, false, 1, ItemOption.getOption(984, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(699, false, 1, ItemOption.getOption(699, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(701, false, 1, ItemOption.getOption(701, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(5, 10)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1151, false, 1, ItemOption.getOption(1151, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1153, false, 1, ItemOption.getOption(1153, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);

            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(994, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(50, Util.gI().nextInt(5, 12)));
                item2.options.add(new ItemOption(77, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(103, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(30, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(995, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(50, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(77, Util.gI().nextInt(5, 12)));
                item2.options.add(new ItemOption(103, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(30, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(996, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(50, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(77, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(103, Util.gI().nextInt(5, 15)));
                item2.options.add(new ItemOption(30, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));

            } else if (Util.gI().nextInt(100) < 2) {
                int id = new int[] { 1010, 1011, 1012 }[player.cgender];
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra cai trang " + item2.template.name);

            } else if (Util.gI().nextInt(100) < 3) {
                item2 = new Item(994, false, 1, ItemOption.getOption(994, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 2) {
                item2 = new Item(995, false, 1, ItemOption.getOption(995, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(996, false, 1, ItemOption.getOption(996, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else {
                int id = new int[] { 1010, 1012, 1011 }[player.cgender];
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 1, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openGoldFish(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(1224, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item2.options.add(new ItemOption(204, Util.gI().nextInt(1, 5)));
                item2.options.add(new ItemOption(203, Util.gI().nextInt(1, 5)));
                item2.options.add(new ItemOption(30, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 25) {
                item2 = new Item(1225, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item2.options.add(new ItemOption(94, Util.gI().nextInt(1, 10)));
                item2.options.add(new ItemOption(202, Util.gI().nextInt(1, 5)));
                item2.options.add(new ItemOption(30, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1226, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item2.options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item2.options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(3, 8))));
                item2.options.add(new ItemOption(201, Util.gI().nextInt(1, 5)));
                item2.options.add(new ItemOption(30, 0));
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(1998, false, 1, ItemOption.getOption(1998, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 15) {
                item2 = new Item(987, false, 1, ItemOption.getOption(987, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1152, false, 1, ItemOption.getOption(1152, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 25) {
                int id = Util.gI().nextInt(712, 716);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1150, false, 1, ItemOption.getOption(1150, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 10) {
                item2 = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(2000, false, 1, ItemOption.getOption(2000, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 5) {
                item2 = new Item(1204, false, 1, ItemOption.getOption(1204, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);

            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(997, false, 1, ItemOption.getOption(997, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(998, false, 1, ItemOption.getOption(998, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1000, false, 1, ItemOption.getOption(1000, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                mLog.log("Quay ra vv " + item2.template.name);

            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1224, false, 1, ItemOption.getOption(1224, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL, player.cName, item.template.name, item2.template.name));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1225, false, 1, ItemOption.getOption(1225, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL, player.cName, item.template.name, item2.template.name));
            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1226, false, 1, ItemOption.getOption(1226, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                Server.gI().chatVip(
                        String.format(mResources.USE_IDOL, player.cName, item.template.name, item2.template.name));

            } else if (Util.gI().nextInt(100) < 1) {
                item2 = new Item(1172, false, 1, ItemOption.getOption(1172, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(150) < 1) {
                item2 = new Item(1144, false, 1, ItemOption.getOption(1144, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(150) < 1) {
                item2 = new Item(1092, false, 1, ItemOption.getOption(1092, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else {
                int id = Util.gI().nextInt(1066, 1070);
                item2 = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY,
                        mResources.EMPTY, mResources.EMPTY);
            }
            player.addItemBag(0, item2);
            Rank.getRank(3).addTop(player.cName, player.head, player.headICON, player.body, player.leg, player.charID,
                    player.pointEvent += 3, -1);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openChestTS(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            // manh thien su
            int id = new short[] { 1066, 1067, 1068, 1069, 1070 }[Util.gI().nextInt(5)];
            item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                    mResources.EMPTY);
            player.addItemBag(0, item2);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openCapsuleHN(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            // Hong ngoc
            item2 = new Item(861, false, Util.gI().nextInt(30, Util.gI().nextInt(50, 70)), null, mResources.EMPTY,
                    mResources.EMPTY, mResources.EMPTY);
            player.addItemBag(0, item2);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }

    private static void openHaiTac(Char player, Item item) {
        int indexUI = player.getEmptyBagIndex();
        if (indexUI != -1) {
            player.useItemBag(item.indexUI, 1);
            Item item2;
            if (Util.gI().nextInt(100) < 50) {
                int id = Util.gI().nextInt(618, 626);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            } else if (Util.gI().nextInt(100) < 10) {
                int id = Util.gI().nextInt(618, 626);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
            } else if (Util.gI().nextInt(100) < 20) {
                item2 = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, 1));
            } else {
                int id = Util.gI().nextInt(618, 626);
                item2 = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                item2.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
            }
            player.addItemBag(0, item2);
        } else {
            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte) 0);
        }
    }
}
