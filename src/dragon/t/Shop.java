package dragon.t;

import dragon.server.Server;
import dragon.server.mResources;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class Shop {

    public int shopId;
    public byte type;
    public String[] shopTabName;
    public ArrayList<Item>[] arrItemShop;

    public static HashMap<Integer, Shop> shops = new HashMap<>();

    public static Item getItem(int shopId, int templateId) {
        try {
            for (int i = 0; i < shops.get(shopId).arrItemShop.length; i++) {
                for (int j = 0; j < shops.get(shopId).arrItemShop[i].size(); j++) {
                    if (((templateId >= 293 && templateId <= 299) || templateId == 596 || templateId == 597)
                            && shops.get(shopId).arrItemShop[i].get(j).isItemPackOf30Foods()) {
                        return shops.get(shopId).arrItemShop[i].get(j);
                    }
                    if (shops.get(shopId).arrItemShop[i].get(j).template.id == templateId) {
                        return shops.get(shopId).arrItemShop[i].get(j);
                    }
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public static Shop get(int shopId) {
        try {
            return shops.get(shopId);
        } catch (Exception e) {
        }
        return null;
    }

    public static void ItemBuy(Char charz, int type, int id, int num) {
        if (num > 0) {
            num = 1;
            Util.gI().log("type=" + type + " id=" + id + " num=" + num);
            Item item = Shop.getItem(charz.shopId, id);
            Shop shop = Shop.get(charz.shopId);
            if (item != null) {
                int itemTemplateId = item.template.id;
                item = item.clone();
                item.quantity = num;
                if (item.isItemPackOf30Foods()) {
                    item.quantity *= 30;
                    // SETID
                    item.setTemplate(MagicTree.foods30templateId[charz.magicTree_level - 1]);
                }

                int indexUI = -1;
                if (item.isItemMerge()) {
                    indexUI = charz.getItemBagIndex(item);
                }
                if (indexUI == -1) {
                    indexUI = charz.getEmptyBagIndex();
                }

                int buyLuong = 0, buyXu = 0, point = 0;
                if (shop.type == 0 || shop.type == 2) {
                    buyLuong = item.buyGold * num;
                    buyXu = item.buyCoin * num;
                    if (item.isHaveOption(164)) {
                        point = item.getParamOption(164) * num;
                    }
                    if (item.template.id == 517) {
                        buyLuong = (item.buyGold * (charz.bagcount - 99)) * num;
                    }
                    if (item.template.id == 518) {
                        buyXu = (item.buyCoin * (charz.boxcount - 99)) * num;
                    }
                    if (item.template.id == 457) {
                        buyXu = Server.gI().gold_value * num;
                    }
                } else {
                    if (shop.type == 3) {
                        if (Shop2.check(charz, shop, item)) {
                            return;
                        }
                    }
                }
                if (charz.getLuong() < buyLuong) {
                    charz.addInfo1(String.format(mResources.NOT_LUONG, buyLuong - charz.getLuong()));
                } else if (charz.xu < buyXu) {
                    charz.addInfo1(String.format(mResources.NOT_XU, buyXu - charz.xu));
                } else if (item.template.id == 517 && charz.bagcount >= 100) {
                    charz.addInfo1(mResources.OPEN_BAG_FULL);
                } else if (item.template.id == 518 && charz.boxcount >= 100) {
                    charz.addInfo1(mResources.OPEN_BAG_FULL);
                } else if (item.template.id == 988 && charz.maxXu >= 200000000000L) {
                    charz.addInfo1(mResources.OPEN_COIN_FULL);
                } else if (charz.shopId == 17 && (!charz.isFullTBT || charz.indexUIFoods99() == -1)) {
                    charz.resetMenu();
                    charz.menuBoard.chat = mResources.SAY_BILL_2;
                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                    charz.menuBoard.openUIConfirm(55, null, null, -1);
                } else if (point > 0 && point > charz.myObj().pointEvent) {
                    charz.addInfo1(String.format(mResources.NOT_DIEM_SU_KIEN, point - charz.myObj().pointEvent));
                } else {
                    // Shop hot toc
                    if (charz.shopId == 4 || charz.shopId == 5 || charz.shopId == 6) {
                        charz.headDefault = (short) item.headTemp;
                        charz.session.service.itemBuy(charz.xu, charz.luong, charz.luongKhoa);
                        /// Shop bua
                    } else if (item.template.type == 13) {
                        // Down xu luong
                        if (buyLuong > 0) {
                            charz.updateLuong(-buyLuong, 0);
                        }
                        if (buyXu > 0) {
                            charz.updateXu(-buyXu, 0);
                        }
                        // point
                        if (point > 0) {
                            charz.myObj().pointEvent -= point;
                        }
                        if (shop.type == 3) {
                            Shop2.buy(charz, shop, item);
                        }

                        int second = 0;
                        if (charz.shopId == 13) {
                            second = 60 * 60;
                        }
                        if (charz.shopId == 14) {
                            second = 60 * 60 * 8;
                        }
                        if (charz.shopId == 15) {
                            second = 60 * 60 * 24 * 30;
                        }
                        int hours = charz.setAmu(item.template.id, second);
                        charz.openShop(charz.shopId);
                        charz.addInfo1(String.format(mResources.BUY_AMU, item.template.name, hours));
                        charz.session.service.itemBuy(charz.xu, charz.luong, charz.luongKhoa);
                    } else // Shop danh hieu
                    if (item.template.type == 36) {
                        EffChar eff = charz.getEffCharById(item.template.part);
                        if (eff == null) {
                            charz.addInfo1(mResources.DANH_HIEU3);
                        } else if (eff.isPaint) {
                            charz.addInfo1(mResources.DANH_HIEU4);
                        } else {
                            // Down xu luong
                            if (buyLuong > 0) {
                                charz.updateLuong(-buyLuong, 0);
                            }
                            if (buyXu > 0) {
                                charz.updateXu(-buyXu, 0);
                            }
                            // point
                            if (point > 0) {
                                charz.myObj().pointEvent -= point;
                            }
                            if (shop.type == 3) {
                                Shop2.buy(charz, shop, item);
                            }
                            for (int i = 0; i < charz.aEffChar.size(); i++) {
                                if (charz.aEffChar.get(i).item != null
                                        && charz.aEffChar.get(i).item.template.type == 36) {
                                    charz.aEffChar.get(i).isPaint = false;
                                    charz.zoneMap.removeEffChar(charz.charID, charz.aEffChar.get(i).effId);
                                }
                            }
                            eff.isPaint = true;
                            charz.zoneMap.addEffectChar(charz.charID, eff.effId, eff.layer, eff.loop, eff.tLoop,
                                    eff.isStand);
                            charz.updateAll();
                            charz.session.service.meLoadPoint();
                            charz.zoneMap.playerLoadAll(charz);

                            charz.addInfo1(String.format(mResources.DANH_HIEU5, item.template.name));
                            charz.session.service.itemBuy(charz.xu, charz.luong, charz.luongKhoa);
                        }
                    } else {
                        if (item.template.id == 193) {
                            item.quantity *= 10;
                        }
                        if (item.template.id == 361) {
                            item.quantity *= 10;
                        }
                        if (item.isItemSLL()) {
                            item.quantity *= item.getParamOption(31);
                        }
                        if (item.isItemLimit() && ItemCountAdd.getCount(item) - num < 0) {
                            charz.addInfo1(String.format(mResources.DA_HET_HANG, item.template.name,
                                    Util.gI().getStrTime(ItemCountAdd.get(item).time)));
                        } else if (charz.checkBag(item)) {
                            if (item.isItemLimit()) {
                                ItemCountAdd.downCount(item, num);
                                charz.addInfo1(String.format(mResources.ITEM_BUY_LIMIT, item.template.name,
                                        ItemCountAdd.getCount(item)));
                            }
                            // Down xu luong
                            if (buyLuong > 0) {
                                charz.updateLuong(-buyLuong, 0);
                            }
                            // point
                            if (point > 0) {
                                charz.myObj().pointEvent -= point;
                            }
                            if (buyXu > 0) {
                                charz.updateXu(-buyXu, 0);
                            }
                            if (shop.type == 3) {
                                Shop2.buy(charz, shop, item);
                            }

                            // Bill Huy Diet
                            if (charz.shopId == 17) {
                                charz.arrItemBag[charz.indexUIFoods99()] = null;
                                charz.arrItemBody[item.getIndexBody()] = null;
                                charz.updateAll();
                                charz.session.service.Body(charz.head, charz.arrItemBody);
                                charz.session.service.meLoadPoint();
                                charz.zoneMap.playerLoadAll(charz);
                                charz.session.service.updateBody(1, charz.charID, charz.head, charz.body, charz.leg,
                                        charz.isMonkey);
                            }
                            // IF Buy chien thuyen tennis
                            if (item.template.id == 453) {
                                charz.typeTeleport = 3;
                                charz.openShop(charz.shopId);
                                // ELSE IF Buy mo rong hanh trang
                            } else if (item.template.id == 517) {
                                Item[] bags = charz.arrItemBag;
                                charz.arrItemBag = new Item[++charz.bagcount];
                                for (int i = 0; i < bags.length; i++) {
                                    charz.arrItemBag[i] = bags[i];
                                }
                                charz.session.service.Bag(charz.arrItemBag);
                                charz.openShop(charz.shopId);
                                // ELSE IF Buy mo rong ruong do
                            } else if (item.template.id == 518) {
                                Item[] boxs = charz.arrItemBox;
                                charz.arrItemBox = new Item[++charz.boxcount];
                                for (int i = 0; i < boxs.length; i++) {
                                    charz.arrItemBox[i] = boxs[i];
                                }
                                charz.openShop(charz.shopId);
                            } else if (item.template.id == 988) {
                                charz.maxXu += 100000000L;
                                if (charz.maxXu > 200000000000L) {
                                    charz.maxXu = 200000000000L;
                                }
                            } else if (item.template.id == 521) {
                                charz.addItemBag(1, item);
                            } else if (item.isBigItem()) {
                                charz.addItemBag(1, item);
                            } else if (charz.arrItemBag[indexUI] != null) {
                                if (charz.arrItemBag[indexUI].quantity < charz.arrItemBag[indexUI].maxQuantity()
                                        || charz.arrItemBag[indexUI].isItemSLL()) {
                                    charz.addQuantityItemBagByIndex(indexUI, item.quantity);
                                    charz.session.service.Bag(charz.arrItemBag);
                                }
                            } else {
                                if (item.isHaveOption(93)) {
                                    item.setExpires(System.currentTimeMillis()
                                            + (86400000L * (long) (item.getParamOption(93) + 1L)));
                                }
                                // point
                                if (item.isHaveOption(164)) {
                                    item.options.remove(item.getOption(164));
                                }
                                // Bill Huy Diet
                                if (charz.shopId == 17) {
                                    int percent = Util.gI().nextInt(0, 15);
                                    for (int i = 0; i < item.options.size(); i++) {
                                        ItemOption option = item.options.get(i);
                                        if (option.optionTemplate.id != 30 && option.optionTemplate.id != 21) {
                                            option.param = option.param + (option.param * percent / 100);
                                        }
                                    }
                                }
                                if (item.isItemSLL()) {
                                    item.quantity = 1;
                                }
                                if (item.template.type == 6) {
                                    item.options.clear();
                                    item.options = ItemOption
                                            .getOption(MagicTree.foods30templateId[charz.magicTree_level - 1], 0, 0);
                                }
                                charz.addItemBag(item, indexUI);
                                charz.session.service.Bag(charz.arrItemBag);
                                if (item.template.type == 23 || item.template.type == 24) {
                                    charz.updateAll();
                                    charz.session.service.meLoadPoint();
                                    charz.zoneMap.playerLoadAll(charz);
                                }
                            }
                            charz.addInfo1(
                                    String.format(mResources.ITEM_BUY_SUCCESS, ItemTemplate.get((short) id).name));
                            // Bong tai
                            if (item.template.id == 454) {
                                charz.openShop(charz.shopId);
                            }
                        } else {
                            charz.addInfo1(mResources.BAG_FULL);
                        }
                        charz.session.service.itemBuy(charz.xu, charz.luong, charz.luongKhoa);
                    }
                }
            }
        }
    }
}
