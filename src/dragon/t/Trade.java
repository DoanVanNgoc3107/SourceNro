package dragon.t;

import dragon.server.mResources;
import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class Trade {
    
    public static Trade instance;
    
    public static Trade getInstance() {
        if (instance == null) {
            instance = new Trade();
        }
        return instance;
    }
    
    public void giaodich(Char charz, byte action, int playerID, int index, int num) {
        //Gui giao dich
        int i;
        if (action == 0) {
            if (charz.delay_giaodich > 0) {
                charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.WAIT_TRADE, Util.gI().getFormatTime3(charz.delay_giaodich)), null, (byte)0);
            } else if (charz.canProceed()) {
                Char player = charz.zoneMap.findCharInMap(playerID);
                if (player != null && player.session != null) {
                    if (player.isgiaodich) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.IS_TRADE, null, (byte)0);
                    } else {
                        charz.delay_giaodich = 17000;
                        charz.tw_giaodich = 17000;
                        charz.wid_giaodich = player.charID;
                        //Gui giao dich
                        player.session.service.sendgiaodich(charz.charID);
                    }
                }
            }
        }
        //Ok giao dich
        if (action == 1) {
            if (charz.canProceed()) {
                Char player = charz.zoneMap.findCharInMap(playerID);
                if (player != null && player.session != null && !player.isgiaodich && player.wid_giaodich == charz.charID) {
                    //PLayer
                    player.wid_giaodich = -9999;
                    player.isgiaodich = true;
                    player.count_giaodich = 0;
                    player.arrItem = new Item[player.arrItemBag.length];
                    player.arrQuantity = new int[player.arrItemBag.length];
                    player.charId_giaodich = charz.charID;
                    //Me
                    charz.isgiaodich = true;
                    charz.count_giaodich = 0;
                    charz.arrItem = new Item[charz.arrItemBag.length];
                    charz.arrQuantity = new int[charz.arrItemBag.length];
                    charz.charId_giaodich = player.charID;
                    //SEND
                    charz.session.service.opengiaodich(player.charID);
                    player.session.service.opengiaodich(charz.charID);
                } else {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_TRADE, null, (byte)0);
                }
            }
        }
        //Gui Item
        if (action == 2) {
            if (charz.isgiaodich && !charz.isLock_giaodich) {
                //gui vang
                if (index == -1) {
                    if (!charz.isCan()) {
                        charz.addInfo1(mResources.KHONG_HO_TRO);
                    } else if (num > 0 && num <= charz.xu) {
                        charz.coin_giaodich = num;
                    } else {
                        cancelgiaodich(charz, 1);
                    }
                } else {
                    if (index < charz.arrItemBag.length && index >= 0 && num >= 0 && charz.arrItemBag[index] != null && !Item.isIndexUI(index, charz.arrItem) && num <= charz.arrItemBag[index].quantity) {
                        if (!charz.isCan()) {
                            charz.addInfo1(mResources.KHONG_HO_TRO);
                            charz.session.service.removeitemgiaodich(charz.arrItemBag[index].indexUI);
                        } else if (charz.arrItemBag[index].isItemNotTrade() || charz.arrItemBag[index].isOption(30) || charz.arrItemBag[index].isOption(34) || charz.arrItemBag[index].isOption(35) || charz.arrItemBag[index].isOption(36) || charz.arrItemBag[index].isOption(127) || charz.arrItemBag[index].isOption(128) || charz.arrItemBag[index].isOption(129) || charz.arrItemBag[index].isOption(130) || charz.arrItemBag[index].isOption(131) || charz.arrItemBag[index].isOption(132) || charz.arrItemBag[index].isOption(133) || charz.arrItemBag[index].isOption(134) || charz.arrItemBag[index].isOption(135)) {
                            charz.session.service.removeitemgiaodich(charz.arrItemBag[index].indexUI);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.NOT_TRADE_ITEM, charz.arrItemBag[index].template.name), null, (byte)0);
                        } else {
                            charz.arrItem[charz.count_giaodich] = charz.arrItemBag[index];
                            if (num == 0) {
                                charz.arrQuantity[charz.count_giaodich] = charz.arrItemBag[index].quantity;
                            } else {
                                charz.arrQuantity[charz.count_giaodich] = num;
                            }
                            ++charz.count_giaodich;
                        }
                    } else {
                        cancelgiaodich(charz, 1);
                    }
                }
                Util.gI().log("index =="+index+" num ==="+num);
            }
        }
        //Huy giao dich
        if (action == 3) {
            cancelgiaodich(charz, 1);
        }
        //Khoa item
        if (action == 5) {
            if (charz.isgiaodich) {
                Char player = charz.zoneMap.findCharInMap(charz.charId_giaodich);
                if (player != null && player.isgiaodich && player.charId_giaodich == charz.charID && charz.count_giaodich <= player.getEmptyBagCount()) {
                    charz.isLock_giaodich = true;
                    ArrayList arraylist = new ArrayList<>();
                    for (int i2 = 0; i2 < charz.arrItem.length; i2++) {
                        if (charz.arrItem[i2] != null) {
                            Item item = charz.arrItem[i2].clone();
                            if (player.session.getIntVersion() >= 222) {
                                item.quantity = charz.arrQuantity[i2];
                                arraylist.add(item);
                            } else {
                                int max = 100;
                                if (charz.arrQuantity[i2] > max) {
                                    int num1 = (charz.arrQuantity[i2] / max) + 1;
                                    int num2 = charz.arrQuantity[i2];
                                    for (int i3 = 0; i3 < num1; i3++) {
                                        Item item2 = item.clone();
                                        if (num2 < max) {
                                            item2.quantity = num2;
                                        } else {
                                            item2.quantity = max;
                                        }
                                        num2 = num2 - item2.quantity;
                                        arraylist.add(item2);
                                    }
                                } else {
                                    item.quantity = charz.arrQuantity[i2];
                                    arraylist.add(item);
                                }
                            }
                        }
                    }
                    player.session.service.lockgiaodich(charz.coin_giaodich, arraylist);
                } else {
                    cancelgiaodich(charz, 1);
                }
            }
        }
        //Chap nhan hoan thanh
        if (action == 7) {
            if (charz.isgiaodich && charz.isLock_giaodich && !charz.isOk_giaodich) {
                charz.isOk_giaodich = true;
                Char player = charz.zoneMap.findCharInMap(charz.charId_giaodich);
                if (player != null && player.isgiaodich && player.charId_giaodich == charz.charID && player.isLock_giaodich) {
                    if (player.isOk_giaodich) {
                        if (charz.coin_giaodich <= charz.xu && player.coin_giaodich <= player.xu && charz.count_giaodich <= player.getEmptyBagCount() && player.count_giaodich <= charz.getEmptyBagCount()) {
                            //Check all item
                            for (i = 0; i < charz.arrItem.length; i++) {
                                if (charz.arrItem[i] != null && (charz.arrItem[i] != charz.arrItemBag[charz.arrItem[i].indexUI] || charz.arrItemBag[charz.arrItem[i].indexUI].quantity < charz.arrQuantity[i])) {
                                    cancelgiaodich(charz, 1);
                                    return;
                                }
                            }
                            for (i = 0; i < player.arrItem.length; i++) {
                                if (player.arrItem[i] != null && (player.arrItem[i] != player.arrItemBag[player.arrItem[i].indexUI] || player.arrItemBag[player.arrItem[i].indexUI].quantity < player.arrQuantity[i])) {
                                    cancelgiaodich(charz, 1);
                                    return;
                                }
                            }
                            //Me send
                            if (charz.coin_giaodich > 0) {
                                player.updateXu(charz.coin_giaodich, 1);
                                charz.updateXu(-charz.coin_giaodich, 1);
                            }
                            for (i = 0; i < charz.arrItem.length; i++) {
                                if (charz.arrItem[i] != null) {
                                    int indexUI = player.getItemBagIndex(charz.arrItem[i]);
                                    if (indexUI != -1 && !charz.arrItem[i].isBigItem()) {
                                        player.addQuantityItemBagByIndex(indexUI, charz.arrItem[i].isItemSLL() ? charz.arrItem[i].getParamOption(31) : charz.arrQuantity[i]);
                                        if (player.arrItemBag[indexUI].expires > charz.arrItem[i].expires && charz.arrItem[i].expires != -1) {
                                            player.arrItemBag[indexUI].setExpires(charz.arrItem[i].expires);
                                        }
                                    } else {
                                        Item itnew = charz.arrItem[i].clone();
                                        itnew.quantity = charz.arrQuantity[i];
                                        player.addItemBag(itnew, player.getEmptyBagIndex());
                                    }
                                    //usePet
                                    if (charz.arrItem[i] == charz.usePet) {
                                        charz.usePet(null);
                                    }
                                    //usePetFollowz
                                    if (charz.checkPetFollowz(charz.arrItem[i])) {
                                        charz.checkClearPetFollowz(charz.arrItem[i]);
                                    }
                                    if (charz.arrItem[i].isItemSLL()) {
                                        charz.arrItemBag[charz.arrItem[i].indexUI] = null;
                                    } else {
                                        charz.addQuantityItemBagByIndex(charz.arrItem[i].indexUI, -charz.arrQuantity[i]);
                                    }
                                }
                            }
                            //Player send
                            if (player.coin_giaodich > 0) {
                                charz.updateXu(player.coin_giaodich, 1);
                                player.updateXu(-player.coin_giaodich, 1);
                            }
                            for (i = 0; i < player.arrItem.length; i++) {
                                if (player.arrItem[i] != null) {
                                    int indexUI = charz.getItemBagIndex(player.arrItem[i]);
                                    if (indexUI != -1 && !player.arrItem[i].isBigItem()) {
                                        charz.addQuantityItemBagByIndex(indexUI, player.arrItem[i].isItemSLL() ? player.arrItem[i].getParamOption(31) : player.arrQuantity[i]);
                                        if (charz.arrItemBag[indexUI].expires > player.arrItem[i].expires && player.arrItem[i].expires != -1) {
                                            charz.arrItemBag[indexUI].setExpires(player.arrItem[i].expires);
                                        }
                                    } else {
                                        Item itnew = player.arrItem[i].clone();
                                        itnew.quantity = player.arrQuantity[i];
                                        charz.addItemBag(itnew, charz.getEmptyBagIndex());
                                    }
                                    //usePet
                                    if (player.arrItem[i] == player.usePet) {
                                        player.usePet(null);
                                    }
                                    //usePetFollowz
                                    if (player.checkPetFollowz(player.arrItem[i])) {
                                        player.checkClearPetFollowz(player.arrItem[i]);
                                    }
                                    if (player.arrItem[i].isItemSLL()) {
                                        player.arrItemBag[player.arrItem[i].indexUI] = null;
                                    } else {
                                        player.addQuantityItemBagByIndex(player.arrItem[i].indexUI, -player.arrQuantity[i]);
                                    }
                                }
                            }
                            charz.session.service.Bag(charz.arrItemBag);
                            player.session.service.Bag(player.arrItemBag);
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TRADE_FINNISH, null, (byte)0);
                            player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TRADE_FINNISH, null, (byte)0);
                            cancelgiaodich(charz, 0);
                        } else {
                            cancelgiaodich(charz, 1);
                        }
                    } else {
                        charz.isOk_giaodich = true;
                    }
                } else {
                    cancelgiaodich(charz, 1);
                }
            }
        }
    }
    
    public void okGD(Char charz) {
        
    }
    
    public void cancelgiaodich(Char charz, int i) {
        if (charz.isgiaodich) {
            Char player = charz.zoneMap.findCharInMap(charz.charId_giaodich);
            charz.charId_giaodich = -9999;
            charz.isgiaodich = false;
            charz.isOk_giaodich = false;
            charz.coin_giaodich = 0;
            charz.count_giaodich = 0;
            charz.arrItem = null;
            charz.arrQuantity = null;
            charz.isLock_giaodich = false;
            charz.session.service.cancelgiaodich();
            if (i == 1) {
                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TRADE_CANCEL, null, (byte)0);
            }
            if (player != null && player.isgiaodich == true && player.charId_giaodich == charz.charID) {
                player.charId_giaodich = -9999;
                player.isgiaodich = false;
                player.isOk_giaodich = false;
                player.coin_giaodich = 0;
                player.count_giaodich = 0;
                player.arrItem = null;
                player.arrQuantity = null;
                player.isLock_giaodich = false;
                player.session.service.cancelgiaodich();
                if (i == 1) {
                    player.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TRADE_CANCEL, null, (byte)0);
                }
            }
        }
    }
    
}
