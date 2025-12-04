package dragon.t;

import dragon.server.Server;
import dragon.server.mResources;

/**
 *
 * @author Admin
 */
public class Combine {
    
    public static int[] percent_plh = new int[]{50, 20, 10, 5, 3, 2, 1, 1};
    public static int[] coin_plh = new int[]{5000000, 10000000, 20000000, 40000000, 60000000, 90000000, 120000000, 180000000};
    public static int[] ngoc_phl = new int[]{1, 2, 3, 4, 5, 6, 7, 30};
    
    public static int ngoc_ep = 10;
    
    public static int max_Star = 8;
    public static int coin_nhap = 2000;
    
    //Dap do
    
    public static int[] dap_percent = new int[] {80, 50, 20, 10, 5, 2, 1, 1};
    public static int[] dap_coin = new int[] {80000, 500000, 1000000, 2500000, 5000000, 12000000, 26000000, 50000000};
    public static int[] dap_dasl = new int[] {5, 7, 9, 12, 15, 18, 21, 22};
    public static int[] downgrade = new int[] {0, 1, 1, 3, 3, 5, 5, 6};
    public static int[] downparam_percent = new int[] {0, 0, 1, 0, 1, 0, 1, 1};
    public static int max_Up = 8;
    
    //Nahp ngoc rong
    
    public static int[][] nhap_nr = new int[][] {
        {20, 19},
        {19, 18},
        {18, 17},
        {17, 16},
        {16, 15},
        {15, 14}
    };
    
    public static int idOption(int type) {
        int id = -1;
        if (type == 0) {
            id = 68;
        }
        if (type == 1) {
            id = 69;
        }
        if (type == 2) {
            id = 67;
        }
        if (type == 3) {
            id = 70;
        }
        if (type == 4) {
            id = 71;
        }
        return id;
    }
    
    public static int nextParamOption(int id, int next, int param) {
        int i;
        int p;
        if (id == 0 || id == 6 || id == 7 || id == 14 || id == 22 || id == 23 || id == 27 || id == 28 || id == 47) {
            for (i = 0; i < Math.abs(next); i++) {
                p = param * 10 / 100;
                if (p < 1) {
                    p = 1;
                }
                if (next > 0) {
                    param += p;
                } else {
                    param -= p;
                }
            }
            if (param < 0) {
                param = 0;
            }
        }
        return param;
    }
    
    public static void Combine(Char charz, byte action, Item[] items) {
        //Lam phep nhap ngoc rong
        if (charz.menuBoard.typeInfo == 27) {
            if (items.length == 1) {
                if (items[0] != null && getNr(items[0].template.id) != null) {
                    if (charz.getEmptyBagIndex() == -1) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte)0);
                    } else {
                        charz.arrItem = items;
                        int d = 1;
                        if (items[0].quantity < 7) {
                            d = 7;
                        }
                        charz.resetMenu();
                        charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT11, items[0].template.name,ItemTemplate.get((short)getNr(items[0].template.id)[1]).name, d, items[0].template.name);
                        charz.menuBoard.arrMenu.add(new MenuInfo(mResources.LAM_PHEP, 28));
                        charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 27));
                        charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
                    }
                }
            } else {
                charz.session.service.startOKDlg(mResources.NHAP_NR_1);
            }
            charz.menuBoard.typeInfo = 27;
        }
        //Lam phep nhap da
        if (charz.menuBoard.typeInfo == 25) {
            if (items.length == 2 && items[0] != null && items[1] != null && ((items[0].quantity >= 10 && items[0].template.type == 15 && items[1].template.type == 16) || (items[1].quantity >= 10 && items[1].template.type == 15 && items[0].template.type == 16))) {
                if (charz.getEmptyBagIndex() == -1) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte)0);
                } else if (charz.xu < coin_nhap) {
                    charz.resetMenu();
                    charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT6, 7, Util.gI().numberTostring(coin_nhap));
                    charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(coin_nhap - charz.xu)), 25));
                    charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
                } else if (charz.xu >= coin_nhap) {
                    charz.arrItem = items;
                    charz.resetMenu();
                    charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT6, 2, Util.gI().numberTostring(coin_nhap));
                    charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.PHEP_NHAP_DA_2, Util.gI().numberTostring(coin_nhap)), 26));
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 25));
                    charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
                }
            } else {
                charz.session.service.startOKDlg(mResources.PHEP_NHAP_DA_1);
            }
            charz.menuBoard.typeInfo = 25;
        }
        //Nang cap Porata
        if (charz.menuBoard.typeInfo == 23) {
            if (items.length == 2 && items[0] != null && items[1] != null && ((items[0].template.id == 454 && items[1].template.id == 933) || (items[1].template.id == 454 && items[0].template.id == 933))) {
                Item bt;
                Item md;
                if (items[0].template.id == 454) {
                    bt = items[0];
                    md = items[1];
                } else {
                    bt = items[1];
                    md = items[0];
                }
                int coinUp = 5000000;
                int goldUp = 20;
                int percent = 50;
                int numMD = 9999;
                int numMD2 = 99;
                charz.resetMenu();
                charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT9, percent, numMD > md.getParamOption(31) ? 7 : 2, numMD, md.template.name, coinUp > charz.xu ? 7 : 2, Util.gI().numberTostring(coinUp), goldUp > charz.getLuong() ? 7 : 2, Util.gI().numberTostring(goldUp), numMD2);
                if (charz.xu < coinUp || charz.getLuong() < goldUp || md.getParamOption(31) < numMD ) {
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 23));
                } else {
                    charz.arrItem = items;
                    charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.UP_BT, Util.gI().numberTostring(coinUp), Util.gI().numberTostring(goldUp)), 24));
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 23));
                }
                charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
            } else {
                charz.session.service.startOKDlg(mResources.NANG_CAP_2);
            }
            charz.menuBoard.typeInfo = 23;
        }
        //Mo chi so Potara 2
        if (charz.menuBoard.typeInfo == 21) {
            if (isHaveItem(items, 921) && isHaveItem(items, 934) && isHaveItem(items, 935)) {
                Item bt = getItem(items, 921);
                Item mh = getItem(items, 934);
                Item dxl = getItem(items, 935);

                int percent = 50;
                int numMH = 99;
                int numDXL = 1;
                int goldUp = 250;
                charz.resetMenu();
                charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT10, percent, numMH > mh.quantity ? 7 : 2, numMH, mh.template.name, numDXL > dxl.quantity ? 7 : 2, numDXL, dxl.template.name, goldUp > charz.getLuong() ? 7 : 2, Util.gI().numberTostring(goldUp));
                if (charz.getLuong() < goldUp || mh.quantity < numMH || dxl.quantity < numDXL) {
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 21));
                } else {
                    charz.arrItem = items;
                    charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.UP_BT2, Util.gI().numberTostring(goldUp)), 22));
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 21));
                }
                charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
            } else {
                charz.session.service.startOKDlg(mResources.NANG_CAP_3);
            }
            charz.menuBoard.typeInfo = 21;
        }
        //Nang cap
        if (charz.menuBoard.typeInfo == 19) {
            if (items != null && Combine.getItemBody(items) != null && Combine.getItemDa(items) != null && Combine.getItemDa(items).isOption(idOption(Combine.getItemBody(items).template.type)) && (items.length == 2 || (items.length == 2 && (getItem(items, 987) != null || getItem(items, 1143) != null)) || (items.length == 3 && (getItem(items, 987) != null || getItem(items, 1143) != null))))
            {
                Item tb = Combine.getItemBody(items);
                Item da = Combine.getItemDa(items);
                Item dbv = getItem(items, 987) == null ? getItem(items, 1143) : getItem(items, 987);
                int upgrade = tb.getParamOption(72);
                if (upgrade >= max_Up) {
                    charz.session.service.startOKDlg(mResources.UP_FULL);
                } else {
                    byte b1 = 2;
                    byte b2 = 2;
                    if (dap_dasl[upgrade] > da.quantity) {
                        b1 = 7;
                    }
                    if (charz.xu < dap_coin[upgrade]) {
                        b2 = 7;
                    }
                    charz.resetMenu();
                    if (upgrade > 0) {
                        if (charz.xu < dap_coin[upgrade]) {
                            charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT8, tb.template.name, upgrade, tb.optionCombine(), upgrade + 1, tb.optionCombine1(), dap_percent[upgrade], b1, dap_dasl[upgrade], da.template.name, b2, Util.gI().numberTostring(dap_coin[upgrade]), downgrade[upgrade]);
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(dap_coin[upgrade] - charz.xu)), 19));
                        } else {
                            charz.arrItem = items;
                            charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT8, tb.template.name, upgrade, tb.optionCombine(), upgrade + 1, tb.optionCombine1(), dap_percent[upgrade], b1, dap_dasl[upgrade], da.template.name, b2, Util.gI().numberTostring(dap_coin[upgrade]), downgrade[upgrade]);
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.UP_COIN, Util.gI().numberTostring(dap_coin[upgrade])), 20));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.UPGRADE_FULLPERCENT, upgrade + 1), 20, true));
                            charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 19));
                        }
                    } else {
                        if (charz.xu < dap_coin[upgrade]) {
                            charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT7, tb.template.name, tb.optionCombine(), upgrade + 1, tb.optionCombine1(), dap_percent[upgrade], b1, dap_dasl[upgrade], da.template.name, b2, Util.gI().numberTostring(dap_coin[upgrade]));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(dap_coin[upgrade] - charz.xu)), 19));
                        } else {
                            charz.arrItem = items;
                            charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT7, tb.template.name, tb.optionCombine(), upgrade + 1, tb.optionCombine1(), dap_percent[upgrade], b1, dap_dasl[upgrade], da.template.name, b2, Util.gI().numberTostring(dap_coin[upgrade]));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.UP_COIN, Util.gI().numberTostring(dap_coin[upgrade])), 20));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.UPGRADE_FULLPERCENT, upgrade + 1), 20, true));
                            charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 19));
                        }
                    }
                    charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
                }
            } else {
                charz.session.service.startOKDlg(mResources.NANG_CAP_1);
            }
            charz.menuBoard.typeInfo = 19;
        }
        //Ep sao pha le
        if (charz.menuBoard.typeInfo == 10) {
            if (items != null && items.length == 2 && items[0] != null && items[1] != null && ((items[0].isTypeBody() && items[0].getStarWhite() > items[0].getStarBlue() && (items[1].isItemWishGem() || items[1].isItemStar())) || (items[1].isTypeBody() && items[1].getStarWhite() > items[1].getStarBlue() && (items[0].isItemWishGem() || items[0].isItemStar())))) {
                Item item2;
                Item itEp;
                if (items[0].isTypeBody()) {
                    item2 = items[0];
                    itEp = items[1];
                } else {
                    item2 = items[1];
                    itEp = items[0];
                }
                charz.resetMenu();
                if (charz.getLuong() < ngoc_ep) {
                    charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT5, item2.template.name, item2.optionCombine(itEp), 7, ngoc_ep);
                    charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(ngoc_ep - charz.getLuong())), 10));
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 10));
                } else if (charz.getLuong() >= ngoc_ep) {
                    charz.arrItem = items;
                    charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT5, item2.template.name, item2.optionCombine(itEp), 2, ngoc_ep);
                    charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.NANGCAP_HOAPHALE, ngoc_ep), 11));
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 10));
                }
                charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
            } else {
                charz.session.service.startOKDlg(mResources.JOIN_STAR_1);
            }
            charz.menuBoard.typeInfo = 10;
        }
        //Duc lo
        if (charz.menuBoard.typeInfo == 12) {
            if (items != null && items.length == 1 && items[0] != null && items[0].isTypeBody()) {
                Item item1 = items[0];
                if (!item1.isItemDucLo()) {
                    charz.session.service.startOKDlg(mResources.TRANGBI_O_PHU_HOP);
                } else {
                    int star = item1.getStarWhite() + 1;
                    if (item1.getStarWhite() >= Combine.max_Star) {
                        charz.session.service.startOKDlg(mResources.STAR_FULL);
                    } else {
                        int percent = percent_plh[star - 1];
                        int coin = coin_plh[star - 1];
                        int ngoc = ngoc_phl[star - 1];
                        charz.resetMenu();
                        if (charz.xu < coin) {
                            charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT4, item1.template.name, item1.optionCombine(star), percent, 7, Util.gI().numberTostring(coin));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(coin - charz.xu)), 12));
                        } else if (charz.xu >= coin) {
                            charz.arrItem = items;
                            charz.menuBoard.chat = String.format(mResources.SAY_BA_HAT_MIT4, item1.template.name, item1.optionCombine(star), percent, 2, Util.gI().numberTostring(coin));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.NANGCAP_HOAPHALE2, ngoc, 100), 13, 100));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.NANGCAP_HOAPHALE2, ngoc, 10), 13, 10));
                            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.NANGCAP_HOAPHALE, ngoc), 13, -1));
                            charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 12));
                        }
                        charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
                    }
                }
            } else {
                charz.session.service.startOKDlg(mResources.TRANGBI_O_PHU_HOP);
            }
            charz.menuBoard.typeInfo = 12;
        }
        //Che tao tang bi thien su
        if (charz.menuBoard.typeInfo == 171) {
            if (items != null) {
                Item fm = null;
                Item gra = null;
                Item dnm = null;
                Item dmm = null;
                for (int i2 = 0; i2 < items.length; i2 = i2 + 1) {
                    if (items[i2] != null) {
                        if (items[i2].isItemFormula() && fm == null) {
                            fm = items[i2];
                        } else if (items[i2].isItemGraft() && gra == null) {
                            gra = items[i2];
                        } else if (items[i2].isItemRuby() && dnm == null) {
                            dnm = items[i2];
                        } else if (items[i2].isItemCrystal() && dmm == null) {
                            dmm = items[i2];
                        } else {
                            charz.session.service.startOKDlg(mResources.SAI_NGUYEN_LIEU);
                            return;
                        }
                    }
                }
                if (fm != null && gra != null) {
                    int totalPercent = 25;
                    if (fm.isItemFormulaVIP()) {
                        totalPercent = 35;
                    }
                    int addPercent = Combine.addPercentRuby(dnm);
                    totalPercent = totalPercent + addPercent;
                    boolean isGold = charz.xu >= 200000000;
                    boolean isGra = gra.quantity >= 999;
                    charz.resetMenu();
                    charz.menuBoard.chat = String.format(mResources.SAY_WISH_3, Combine.srcTX(gra, fm), isGra ? 2 : 7, gra.quantity, dnm != null ? dnm.template.name : mResources.KHONG_DUNG_DA_NANG_CAP, addPercent, dmm != null ? dmm.template.name : mResources.KHONG_DUNG_DA_MAY_MAN, Combine.addPercentCry(dmm), totalPercent, isGold ? 2 : 7);
                    if (isGold && isGra) {
                        charz.arrItem = items;
                        charz.menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 172));
                    }
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 171));
                    charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
                } else {
                    charz.session.service.startOKDlg(mResources.KHONG_DU_NGUYEN_LIEU);
                }
            }
            charz.menuBoard.typeInfo = 171;
        }
    }
    
    public static void EpNgoc(Char charz) {
        int i;
        if (charz.arrItem.length == 2 && charz.arrItem[0] != null && charz.arrItem[1] != null && ((charz.arrItem[0].isTypeBody() && charz.arrItem[0].getStarWhite() > charz.arrItem[0].getStarBlue() && (charz.arrItem[1].isItemWishGem() || charz.arrItem[1].isItemStar())) || (charz.arrItem[1].isTypeBody() && charz.arrItem[1].getStarWhite() > charz.arrItem[1].getStarBlue() && (charz.arrItem[0].isItemWishGem() || charz.arrItem[0].isItemStar()))) && charz.arrItemBag[charz.arrItem[0].indexUI] == charz.arrItem[0] && charz.arrItemBag[charz.arrItem[1].indexUI] == charz.arrItem[1]) {
            Item item2;
            Item itEp;
            if (charz.arrItem[0].isTypeBody()) {
                item2 = charz.arrItem[0];
                itEp = charz.arrItem[1];
            } else {
                item2 = charz.arrItem[1];
                itEp = charz.arrItem[0];
            }
            int star = item2.getStarWhite() + 1;
            if (ngoc_ep > charz.getLuong()) {

            } else {
                boolean b1 = false;
                boolean b2 = false;
                //Neu co tang them ko co tao moi
                for (i = 0; i < item2.options.size(); i++) {
                    if (item2.options.get(i).optionTemplate.id == 102) {
                        item2.options.get(i).param++;
                        b2 = true;
                    }
                    if (itEp.template.id == 14 && item2.options.get(i).optionTemplate.id == 108) {
                        b1 = true;
                        item2.options.get(i).param += 2;
                    }
                    if (itEp.template.id == 15 && item2.options.get(i).optionTemplate.id == 94) {
                        b1 = true;
                        item2.options.get(i).param += 2;
                    }
                    if (itEp.template.id == 16 && item2.options.get(i).optionTemplate.id == 147) {
                        b1 = true;
                        item2.options.get(i).param += 3;
                    }
                    if (itEp.template.id == 17 && item2.options.get(i).optionTemplate.id == 81) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 18 && item2.options.get(i).optionTemplate.id == 80) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 19 && item2.options.get(i).optionTemplate.id == 103) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 20 && item2.options.get(i).optionTemplate.id == 77) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 441 && item2.options.get(i).optionTemplate.id == 95) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 442 && item2.options.get(i).optionTemplate.id == 96) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 443 && item2.options.get(i).optionTemplate.id == 97) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 444 && item2.options.get(i).optionTemplate.id == 98) {
                        b1 = true;
                        item2.options.get(i).param += 3;
                    }
                    if (itEp.template.id == 445 && item2.options.get(i).optionTemplate.id == 99) {
                        b1 = true;
                        item2.options.get(i).param += 3;
                    }
                    if (itEp.template.id == 446 && item2.options.get(i).optionTemplate.id == 100) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                    if (itEp.template.id == 447 && item2.options.get(i).optionTemplate.id == 101) {
                        b1 = true;
                        item2.options.get(i).param += 5;
                    }
                }
                if (!b1) {
                    if (itEp.template.id == 14) {
                        item2.options.add(new ItemOption(108, 2));
                    }
                    if (itEp.template.id == 15) {
                        item2.options.add(new ItemOption(94, 2));
                    }
                    if (itEp.template.id == 16) {
                        item2.options.add(new ItemOption(147, 3));
                    }
                    if (itEp.template.id == 17) {
                        item2.options.add(new ItemOption(81, 5));
                    }
                    if (itEp.template.id == 18) {
                        item2.options.add(new ItemOption(80, 5));
                    }
                    if (itEp.template.id == 19) {
                        item2.options.add(new ItemOption(103, 5));
                    }
                    if (itEp.template.id == 20) {
                        item2.options.add(new ItemOption(77, 5));
                    }
                    if (itEp.template.id == 441) {
                        item2.options.add(new ItemOption(95, 5));
                    }
                    if (itEp.template.id == 442) {
                        item2.options.add(new ItemOption(96, 5));
                    }
                    if (itEp.template.id == 443) {
                        item2.options.add(new ItemOption(97, 5));
                    }
                    if (itEp.template.id == 444) {
                        item2.options.add(new ItemOption(98, 3));
                    }
                    if (itEp.template.id == 445) {
                        item2.options.add(new ItemOption(99, 3));
                    }
                    if (itEp.template.id == 446) {
                        item2.options.add(new ItemOption(100, 5));
                    }
                    if (itEp.template.id == 447) {
                        item2.options.add(new ItemOption(101, 5));
                    }
                }
                if (!b2) {
                    item2.options.add(new ItemOption(102, 1));
                }
                charz.addQuantityItemBagByIndex(itEp.indexUI, -1);
                charz.session.service.setCombineEff(2, -1, -1, -1);
                charz.updateLuong(-ngoc_ep, 0);
                charz.session.service.meLoadInfo();
                charz.session.service.Bag(charz.arrItemBag);
            }
        } else {
            charz.session.service.startOKDlg(mResources.JOIN_STAR_1);
        }
    }
    
    public static int DucLo(Char charz) {
        if (charz.arrItem != null && charz.arrItem.length == 1 && charz.arrItem[0] != null && charz.arrItem[0].isTypeBody() && charz.arrItem[0] == charz.arrItemBag[charz.arrItem[0].indexUI]) {
            Item item1 = charz.arrItem[0];
            if (!item1.isItemDucLo()) {
                charz.session.service.startOKDlg(mResources.TRANGBI_O_PHU_HOP);
            } else {
                int star = item1.getStarWhite() + 1;
                if (item1.getStarWhite() >= Combine.max_Star) {
                    charz.session.service.startOKDlg(mResources.STAR_FULL);
                } else {
                    int percent = percent_plh[star - 1];
                    int coin = coin_plh[star - 1];
                    int ngoc = ngoc_phl[star - 1];
                    if (charz.xu < coin) {
                        return 1;
                    } else if (ngoc > charz.getLuong()) {
                        return 2;
                    } else {
                        boolean b1;
                        int pP;
                        if (item1.getStarWhite() >= 7) {
                            pP = Util.gI().nextInt(400);
                        } else if (item1.getStarWhite() >= 6) {
                            pP = Util.gI().nextInt(350);
                        } else if (item1.getStarWhite() >= 5) {
                            pP = Util.gI().nextInt(300);
                        } else if (item1.getStarWhite() >= 4) {
                            pP = Util.gI().nextInt(200);
                        } else if (item1.getStarWhite() >= 3) {
                            pP = Util.gI().nextInt(120);
                        } else {
                            pP = Util.gI().nextInt(Util.gI().nextInt(1, 100));
                        }
                        if (item1.isItemSKH() || item1.template.type == 23) {
                            pP = pP * 2;
                        }
                        b1 = pP < percent;
                        boolean b2 = false;
                        if (b1) {
                            //Neu co tang them ko co tao moi
                            for (int i = 0; i < item1.options.size(); i++) {
                                if (item1.options.get(i).optionTemplate.id == 107) {
                                    item1.options.get(i).param++;
                                    b2 = true;
                                    break;
                                }
                            }
                            if (!b2) {
                                item1.options.add(new ItemOption(107, 1));
                            }
                            charz.session.service.setCombineEff(2, -1, -1, -1);
                        } else {
                            charz.session.service.setCombineEff(3, -1, -1, -1);
                        }
                        charz.updateXu(-coin, 0);
                        charz.updateLuong(-ngoc, 0);
                        charz.session.service.meLoadInfo();
                        charz.session.service.Bag(charz.arrItemBag);
                        return b1 ? 3 : 4;
                    }
                }
            }
        } else {
            charz.session.service.startOKDlg(mResources.TRANGBI_O_PHU_HOP);
        }
        return 0;
   }
    
    public static void NhapDa(Char charz) {
        int i;
        if (charz.arrItem != null && charz.arrItem.length == 2 && charz.arrItem[0] != null && charz.arrItem[1] != null && ((charz.arrItem[0].quantity >= 10 && charz.arrItem[0].template.type == 15 && charz.arrItem[1].template.type == 16) || (charz.arrItem[1].quantity >= 10 && charz.arrItem[1].template.type == 15 && charz.arrItem[0].template.type == 16)) && charz.arrItemBag[charz.arrItem[0].indexUI] == charz.arrItem[0] && charz.arrItemBag[charz.arrItem[1].indexUI] == charz.arrItem[1]) {
            int indexUI = charz.getEmptyBagIndex();
            if (indexUI == -1) {
                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte)0);
            } else if (charz.xu < coin_nhap) {
                
            } else {
                charz.updateXu(-coin_nhap, 2);
                if (charz.arrItem[0].template.type == 15) {
                    charz.addQuantityItemBagByIndex(charz.arrItem[0].indexUI, -10);
                    charz.addQuantityItemBagByIndex(charz.arrItem[1].indexUI, -1);
                } else {
                    charz.addQuantityItemBagByIndex(charz.arrItem[1].indexUI, -10);
                    charz.addQuantityItemBagByIndex(charz.arrItem[0].indexUI, -1);
                }
                short templateId = (short) Util.gI().nextInt(220, 224);
                charz.addItemBag(0, new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                charz.session.service.setCombineEff(4, ItemTemplate.getIcon((short)templateId), -1, -1);
                charz.session.service.Bag(charz.arrItemBag);
            }
        } else {
            charz.session.service.startOKDlg(mResources.PHEP_NHAP_DA_1);
        }
    }
    
    public static void nangCap(Char charz, boolean flag) {
        int upgrade;
        if (contains(charz.arrItemBag, charz.arrItem) && Combine.getItemBody(charz.arrItem) != null && Combine.getItemDa(charz.arrItem) != null && Combine.getItemDa(charz.arrItem).isOption(idOption(Combine.getItemBody(charz.arrItem).template.type)) && (charz.arrItem.length == 2 || (charz.arrItem.length == 2 && (getItem(charz.arrItem, 987) != null || getItem(charz.arrItem, 1143) != null)) || (charz.arrItem.length == 3 && (getItem(charz.arrItem, 987) != null || getItem(charz.arrItem, 1143) != null))))
        {
            Item tb = Combine.getItemBody(charz.arrItem);
            Item da = Combine.getItemDa(charz.arrItem);
            Item dbv = getItem(charz.arrItem, 987) == null ? getItem(charz.arrItem, 1143) : getItem(charz.arrItem, 987);
            upgrade = tb.getParamOption(72);
            if (flag && upgrade + 1 > charz.getItemBagQuantityById(2004)) {
                charz.addInfo1(mResources.CHAT_NGOC_NC1);
            } else if (upgrade >= max_Up) {
                charz.session.service.startOKDlg(mResources.UP_FULL);
            } else if (dap_dasl[upgrade] > da.quantity || charz.xu < dap_coin[upgrade]) {

            } else {
                charz.updateXu(-dap_coin[upgrade], 2);
                charz.addQuantityItemBagByIndex(da.indexUI, -dap_dasl[upgrade]);
                int pP;
                if (upgrade >= 7) {
                    pP = Util.gI().nextInt(250);
                } else if (upgrade >= 6) {
                    pP = Util.gI().nextInt(200);
                } else if (upgrade >= 5) {
                    pP = Util.gI().nextInt(150);
                } else if (upgrade >= 3) {
                    pP = Util.gI().nextInt(120);
                } else {
                    pP = Util.gI().nextInt(100);
                }
                boolean flag2 = pP < dap_percent[upgrade];
                if (flag) {
                    charz.useItemBagById(2004, upgrade + 1);
                    flag2 = true;
                }
                if (dbv != null) {
                    charz.addQuantityItemBagByIndex(dbv.indexUI, -1);
                }
                if (flag2) {
                    up(tb);
                    charz.session.service.setCombineEff(2, -1, -1, -1);
                    if (tb.getStarWhite() == 7) {
                        charz.addTaskPointDH(1292, 1);
                    }
                } else {
                    if (upgrade > 0 && dbv == null) {
                        int newupgrade = downgrade[upgrade];
                        for (int i = 0; i < tb.options.size(); i++) {
                            if (tb.options.get(i).optionTemplate.id == 72) {
                                tb.options.get(i).param = newupgrade;
                            } else {
                                tb.options.get(i).param = nextParamOption(tb.options.get(i).optionTemplate.id, -(upgrade-newupgrade), tb.options.get(i).param);
                                if (tb.options.get(i).optionTemplate.id == 0 || tb.options.get(i).optionTemplate.id == 6 || tb.options.get(i).optionTemplate.id == 7 || tb.options.get(i).optionTemplate.id == 14 || tb.options.get(i).optionTemplate.id == 27 || tb.options.get(i).optionTemplate.id == 28 || tb.options.get(i).optionTemplate.id == 47) {
                                    if (downparam_percent[upgrade] > 0) {
//                                        int p = (tb.options.get(i).param * downparam_percent[upgrade] / 100);
//                                        if (p < 1) {
//                                            p = 1;
//                                        }
//                                        tb.options.get(i).param -= p;
//                                        if (tb.options.get(i).param < 0) {
//                                            tb.options.get(i).param = 0;
//                                        }
                                    }
                                }
                            }
                        }
                        if (newupgrade != upgrade) {
                            if (tb.isHaveOption(209)) {
                                tb.getOption(209).param++;
                            } else {
                                tb.options.add(new ItemOption(209, 1));
                            }
                        }
                    }
                    charz.session.service.setCombineEff(3, -1, -1, -1);
                }
                charz.session.service.Bag(charz.arrItemBag);
            }
        } else {
            charz.session.service.startOKDlg(mResources.NANG_CAP_1);
        }
    }
    
    public static void up(Item item) {
        boolean b2 = false;
        //Neu co tang them ko co tao moi
        for (int i = 0; i < item.options.size(); i++) {
            if (item.options.get(i).optionTemplate.id == 72) {
                item.options.get(i).param++;
                b2 = true;
            } else {
                item.options.get(i).param = nextParamOption(item.options.get(i).optionTemplate.id, 1, item.options.get(i).param);
            }
        }
        if (!b2) {
            item.options.add(new ItemOption(72, 1));
        }
    }
    
    public static void NangcCapBongTai(Char charz) {
        if (charz.myPet != null && charz.myPetz().isHopThe > 0) {
            charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TACH_HOP_THE, null, 0);
        } else {
            if (charz.arrItem.length == 2 && charz.arrItem[0] != null && charz.arrItem[1] != null && ((charz.arrItem[0].template.id == 454 && charz.arrItem[1].template.id == 933) || (charz.arrItem[1].template.id == 454 && charz.arrItem[0].template.id == 933))&& charz.arrItemBag[charz.arrItem[0].indexUI] == charz.arrItem[0] && charz.arrItemBag[charz.arrItem[1].indexUI] == charz.arrItem[1]) {
                Item bt;
                Item md;
                if (charz.arrItem[0].template.id == 454) {
                    bt = charz.arrItem[0];
                    md = charz.arrItem[1];
                } else {
                    bt = charz.arrItem[1];
                    md = charz.arrItem[0];
                }
                int coinUp = 5000000;
                int goldUp = 20;
                int numMD = 9999;
                int numMD2 = 99;
                if (charz.xu >= coinUp && charz.getLuong() >= goldUp && md.getParamOption(31) >= numMD ) {
                    charz.updateXu(-coinUp, 1);
                    charz.updateLuong(-goldUp, 2);
                    boolean isSc = Util.gI().nextInt(100) < 50;
                    if (isSc) {
                        bt.template = ItemTemplate.get((short) (bt.itemId = 921));
                        bt.options.clear();
                        bt.options.add(new ItemOption(72, 2));
                        charz.addQuantityItemBagByIndex(md.indexUI, -numMD);
                        charz.session.service.setCombineEff(2, -1, -1, -1);
                    } else {
                        charz.addQuantityItemBagByIndex(md.indexUI, -numMD2);
                        charz.session.service.setCombineEff(3, -1, -1, -1);
                    }
                    charz.session.service.Bag(charz.arrItemBag);
                }
            } else {
                charz.session.service.startOKDlg(mResources.NANG_CAP_2);
            }
        }
    }
    
    public static boolean isHaveItem(Item[] arrItem, int id) {
        int i;
        if (arrItem !=  null) {
            for (i = 0; i < arrItem.length; i++) {
                if (arrItem[i] != null && arrItem[i].template.id == id) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static Item getItem(Item[] arrItem, int id) {
        int i;
        for (i = 0; i < arrItem.length; i++) {
            if (arrItem[i] != null && arrItem[i].template.id == id) {
                return arrItem[i];
            }
        }
        return null;
    }
    
    public static void openOptionBongTai(Char charz) {
        if (isHaveItem(charz.arrItem, 921) && isHaveItem(charz.arrItem, 934) && isHaveItem(charz.arrItem, 935) && charz.arrItemBag[charz.arrItem[0].indexUI] == charz.arrItem[0] && charz.arrItemBag[charz.arrItem[1].indexUI] == charz.arrItem[1] && charz.arrItemBag[charz.arrItem[2].indexUI] == charz.arrItem[2]) {
            Item bt = getItem(charz.arrItem, 921);
            Item mh = getItem(charz.arrItem, 934);
            Item dxl = getItem(charz.arrItem, 935);

            int percent = 70;
            int numMH = 99;
            int numDXL = 1;
            int goldUp = 250;
            if (charz.getLuong() >= goldUp && mh.quantity >= numMH && dxl.quantity >= numDXL) {
                charz.updateLuong(-goldUp, 2);
                charz.addQuantityItemBagByIndex(mh.indexUI, -numMH);
                charz.addQuantityItemBagByIndex(dxl.indexUI, -numDXL);
                boolean isSc = Util.gI().nextInt(100) < percent;
                if (isSc) {
                    bt.options.clear();
                    int idOption = new int[]{5, 14, 17, 27, 28, 50, 77, 94, 103, 175}[Util.gI().nextInt(10)];
                    int param = 0;
                    if (idOption == 17 || idOption ==  27 || idOption ==  28 || idOption ==  50 || idOption ==  77 || idOption ==  103 || idOption ==  175) {
                        param = Util.gI().nextInt(5, Util.gI().nextInt(5, 15));
                    }
                    if (idOption == 94) {
                        param = Util.gI().nextInt(5, Util.gI().nextInt(5, 10));
                    }
                    if (idOption == 14) {
                        param = Util.gI().nextInt(2, Util.gI().nextInt(2, 10));
                    }
                    if (idOption == 5) {
                        param = Util.gI().nextInt(1, Util.gI().nextInt(1, 5));
                    }
                    bt.options.add(new ItemOption(idOption, param));
                    bt.options.add(new ItemOption(38, 0));
                    bt.options.add(new ItemOption(72, 2));
                    charz.session.service.setCombineEff(2, -1, -1, -1);
                } else {
                    charz.session.service.setCombineEff(3, -1, -1, -1);
                }
                charz.session.service.Bag(charz.arrItemBag);
            }
        } else {
            charz.session.service.startOKDlg(mResources.NANG_CAP_2);
        }
    }
    
    public static Item getItemBody(Item[] arrItem) {
        int i;
        for (i = 0; i < arrItem.length; i++) {
            if (arrItem[i] != null && arrItem[i].isTypeBody()) {
                return arrItem[i];
            }
        }
        return null;
    }
    
    public static Item getItemDa(Item[] arrItem) {
        int i;
        for (i = 0; i < arrItem.length; i++) {
            if (arrItem[i] != null && arrItem[i].template.type == 14) {
                return arrItem[i];
            }
        }
        return null;
    }
    
    public static void NhapNgoc(Char charz) {
        if (charz.arrItem != null && charz.arrItem.length == 1 && charz.arrItem[0] != null && charz.arrItem[0].quantity >= 7 && charz.arrItemBag[charz.arrItem[0].indexUI] == charz.arrItem[0]) {
            if (charz.getEmptyBagCount() > 0 && getNr(charz.arrItem[0].template.id) != null) {
                Item item = new Item(getNr(charz.arrItem[0].template.id)[1], false, 1, ItemOption.getOption(getNr(charz.arrItem[0].template.id)[1], -1, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                if (!item.isHaveOption(30) && charz.arrItem[0].isHaveOption(30)) {
                    item.options.add(new ItemOption(30, 0));
                }
                charz.useItemBag(charz.arrItem[0].indexUI, 7);
                charz.addItemBag(2, item);
                charz.session.service.setCombineEff(5, ItemTemplate.getIcon((short)getNr(charz.arrItem[0].template.id)[1]), -1, -1);
                charz.session.service.Bag(charz.arrItemBag);
            }
        }
    }
    
    public static int[] getNr(int id) {
        int i;
        for (i = 0; i < nhap_nr.length; i++) {
            if (nhap_nr[i][0] == id) {
                return nhap_nr[i];
            }
        }
        return null;
    }
    
    private static boolean contains(Item[] array1, Item[] array2) {
        try {
            for (int i = 0; i < array2.length; ++i) {
                if (array1[array2[i].indexUI] != array2[i]) {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private static boolean contains(Item[] o, int... v) {
        for (int j = 0; j < v.length; j++) {
            for (int i = 0; i < o.length; ++i) {
                if (o[i] != null && o[i].template.id == v[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static int addPercentRuby(Item item) {
        if (item != null && item.template.id == 1074) {
            return 10;
        }
        if (item != null && item.template.id == 1075) {
            return 20;
        }
        if (item != null && item.template.id == 1076) {
            return 30;
        }
        if (item != null && item.template.id == 1077) {
            return 40;
        }
        if (item != null && item.template.id == 1078) {
            return 50;
        }
        return 0;
    }
    
    private static int addPercentCry(Item item) {
        if (item != null && item.template.id == 1079) {
            return 10;
        }
        if (item != null && item.template.id == 1080) {
            return 20;
        }
        if (item != null && item.template.id == 1081) {
            return 30;
        }
        if (item != null && item.template.id == 1082) {
            return 40;
        }
        if (item != null && item.template.id == 1083) {
            return 50;
        }
        return 0;
    }
    
    private static String srcTX(Item gra, Item fm) {
        if (gra.template.id == 1066) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return mResources.CHE_TAO_THIEN_SU_1;
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return mResources.CHE_TAO_THIEN_SU_2;
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return mResources.CHE_TAO_THIEN_SU_3;
            }
        }
        if (gra.template.id == 1067) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return mResources.CHE_TAO_THIEN_SU_4;
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return mResources.CHE_TAO_THIEN_SU_5;
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return mResources.CHE_TAO_THIEN_SU_6;
            }
        }
        if (gra.template.id == 1068) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return mResources.CHE_TAO_THIEN_SU_7;
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return mResources.CHE_TAO_THIEN_SU_8;
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return mResources.CHE_TAO_THIEN_SU_9;
            }
        }
        if (gra.template.id == 1069) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return mResources.CHE_TAO_THIEN_SU_10;
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return mResources.CHE_TAO_THIEN_SU_11;
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return mResources.CHE_TAO_THIEN_SU_12;
            }
        }
        if (gra.template.id == 1070) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return mResources.CHE_TAO_THIEN_SU_13;
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return mResources.CHE_TAO_THIEN_SU_14;
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return mResources.CHE_TAO_THIEN_SU_15;
            }
        }
        return "";
    }
    
    public static void Make(Char charz) {
        if (charz.getEmptyBagCount() == 0) {
            charz.addInfo1(mResources.BAG_FULL);
        } else if (charz.arrItem != null && Combine.contains(charz.arrItemBag, charz.arrItem)) {
            Item fm = null;
            Item gra = null;
            Item dnm = null;
            Item dmm = null;
            for (int i2 = 0; i2 < charz.arrItem.length; i2 = i2 + 1) {
                if (charz.arrItem[i2] != null) {
                    if (charz.arrItem[i2].isItemFormula() && fm == null) {
                        fm = charz.arrItem[i2];
                    } else if (charz.arrItem[i2].isItemGraft() && gra == null) {
                        gra = charz.arrItem[i2];
                    } else if (charz.arrItem[i2].isItemRuby() && dnm == null) {
                        dnm = charz.arrItem[i2];
                    } else if (charz.arrItem[i2].isItemCrystal() && dmm == null) {
                        dmm = charz.arrItem[i2];
                    } else {
                        charz.session.service.startOKDlg(mResources.SAI_NGUYEN_LIEU);
                        return;
                    }
                }
            }
            if (fm != null && gra != null) {
                int totalPercent = 25;
                if (fm.isItemFormulaVIP()) {
                    totalPercent = 35;
                }
                int addPercent = Combine.addPercentRuby(dnm);
                totalPercent = totalPercent + addPercent;
                boolean isGold = charz.xu >= 200000000L;
                boolean isGra = gra.quantity >= 999;
                if (isGold && isGra) {
                    boolean isSuccess = totalPercent > Util.gI().nextInt(100);
                    boolean isOption = Combine.addPercentCry(dmm) > Util.gI().nextInt(100);
                    charz.useItemBag(fm.indexUI, 1);
                    if (isSuccess) {
                        charz.useItemBag(gra.indexUI, 999);
                    } else {
                        charz.useItemBag(gra.indexUI, 99);
                    }
                    if (dnm != null) {
                        charz.useItemBag(dnm.indexUI, 1);
                    }
                    if (dmm != null) {
                        charz.useItemBag(dmm.indexUI, 1);
                    }
                    charz.updateXu(-200000000L, 2);
                    if (isSuccess) {
                        Item item = Combine.itemMake(gra, fm);
                        int percent = Util.gI().nextInt(20, Util.gI().nextInt(21, Util.gI().nextInt(23, Util.gI().nextInt(25, 35))));
                        //Add param option
                        for (int i = 0; i < item.options.size(); i++) {
                            ItemOption option = item.options.get(i);
                            if (option.optionTemplate.id != 30 && option.optionTemplate.id != 21) {
                                option.param = option.param + (option.param * percent / 100);
                            }
                        }
                        //Add option
                        if (isOption) {
                            int num = Util.gI().nextInt(1, Util.gI().nextInt(1, 3));
                            item.options.add(new ItemOption(41, num));
                            charz.addOptionHide(item, num);
                        }
                        charz.session.service.setCombineEff(7, item.template.iconID, -1, -1);
                        charz.addItemBag(1, item);
                        if (isOption) {
                            Server.gI().chatVip(String.format(mResources.CHAT_VIP, "Wish", String.format(mResources.WISH_CHAT_2, charz.cName, item.template.name, item.getParamOption(41))));
                        } else {
                            Server.gI().chatVip(String.format(mResources.CHAT_VIP, "Wish", String.format(mResources.WISH_CHAT, charz.cName, item.template.name)));
                        }
                    } else {
                        charz.session.service.setCombineEff(8, -1, -1, -1);
                    }
                } else {
                    charz.resetMenu();
                    charz.menuBoard.chat = String.format(mResources.SAY_WISH_3, Combine.srcTX(gra, fm), isGra ? 2 : 7, gra.quantity, dnm != null ? dnm.template.name : mResources.KHONG_DUNG_DA_NANG_CAP, addPercent, dmm != null ? dmm.template.name : mResources.KHONG_DUNG_DA_MAY_MAN, Combine.addPercentCry(dmm), totalPercent, isGold ? 2 : 7);
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 171));
                    charz.menuBoard.openUIConfirm(charz.menuBoard.npcId, null, null, -1);
                }
            } else {
                charz.session.service.startOKDlg(mResources.KHONG_DU_NGUYEN_LIEU);
            }
        }
    }
    
    private static Item itemMake(Item gra, Item fm) {
        if (gra.template.id == 1066) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return new Item(1048, false, 1, ItemOption.getOption(1048, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return new Item(1049, false, 1, ItemOption.getOption(1049, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return new Item(1050, false, 1, ItemOption.getOption(1050, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
        }
        if (gra.template.id == 1067) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return new Item(1051, false, 1, ItemOption.getOption(1051, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return new Item(1052, false, 1, ItemOption.getOption(1052, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return new Item(1053, false, 1, ItemOption.getOption(1053, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
        }
        if (gra.template.id == 1068) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return new Item(1057, false, 1, ItemOption.getOption(1057, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return new Item(1058, false, 1, ItemOption.getOption(1058, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return new Item(1059, false, 1, ItemOption.getOption(1059, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
        }
        if (gra.template.id == 1069) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return new Item(1060, false, 1, ItemOption.getOption(1060, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return new Item(1061, false, 1, ItemOption.getOption(1061, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return new Item(1062, false, 1, ItemOption.getOption(1062, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
        }
        if (gra.template.id == 1070) {
            if (fm.template.id == 1071 || fm.template.id == 1084) {
                return new Item(1054, false, 1, ItemOption.getOption(1054, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1072 || fm.template.id == 1085) {
                return new Item(1055, false, 1, ItemOption.getOption(1055, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
            if (fm.template.id == 1073 || fm.template.id == 1086) {
                return new Item(1056, false, 1, ItemOption.getOption(1056, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            }
        }
        return null;
    }
    
    
}
