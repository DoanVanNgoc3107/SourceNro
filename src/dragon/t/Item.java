package dragon.t;

import dragon.server.Dragon;
import dragon.server.mResources;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Admin
 */
public class Item {
    
    public Item() {
        
    }
    
    public Item(int itemTemplateId) {
        this.template = ItemTemplate.get((short) (this.itemId = itemTemplateId));
        this.quantity = 1;
    }
    
    public Item(int itemTemplateId, boolean isLock, int quantity, ArrayList<ItemOption> options, String info, String content, String reason) {
        this.template = ItemTemplate.get((short) (this.itemId = itemTemplateId));
        this.isLock = isLock;
        this.quantity = quantity;
        if (options != null) {
            this.options = options;
        } else {
            this.options = new ArrayList();
        }
        this.info = info;
        this.content = content;
        this.reason = reason;
    }
    
    public Item(int itemTemplateId, boolean isLock, int quantity, int[] arrOptionId, int[] arrOptionParam, String info, String content, String reason) {
        this.template = ItemTemplate.get((short) (this.itemId = itemTemplateId));
        this.isLock = isLock;
        this.quantity = quantity;
        this.options = new ArrayList();
        if (arrOptionId != null && arrOptionParam != null && arrOptionId.length == arrOptionParam.length) {
            int i;
            for (i = 0; i < arrOptionId.length; i++) {
                this.options.add(new ItemOption(arrOptionId[i], arrOptionParam[i]));
            }
        }
        this.info = info;
        this.content = content;
        this.reason = reason;
    }
    
    public void setTemplate(int itemTemplateId) {
        this.template = ItemTemplate.get((short) (this.itemId = itemTemplateId));
    }
    
    public boolean isHaveOption(int id) {
        for (int i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).optionTemplate.id == id) {
                return true;
            }
        }
        return false;
    }
    
    public void removeOption(int id) {
        for (int i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).optionTemplate.id == id) {
                this.options.remove(i);
                return;
            }
        }
    }
    
    @Override
    public Item clone() {
        Item item = new Item();
        item.template = this.template;
        if (this.options != null) {
            item.options = new ArrayList();
            for (int i = 0; i < this.options.size(); i++) {
                ItemOption itemOption = new ItemOption();
                itemOption.optionTemplate = this.options.get(i).optionTemplate;
                itemOption.param = this.options.get(i).param;
                item.options.add(itemOption);
            }
        }
        item.itemId = this.itemId;
        item.playerId = this.playerId;
        item.indexUI = this.indexUI;
        item.quantity = this.quantity;
        item.isLock = this.isLock;
        item.sys = this.sys;
        item.upgrade = this.upgrade;
        item.buyCoin = this.buyCoin;
        item.buyCoinLock = this.buyCoinLock;
        item.buyGold = this.buyGold;
        item.buyGoldLock = this.buyGoldLock;
        item.saleCoinLock = this.saleCoinLock;
        item.buySpec = this.buySpec;
        item.buyRuby = this.buyRuby;
        item.iconSpec = this.iconSpec;
        item.buyType = this.buyType;
        item.typeUI = this.typeUI;
        item.isExpires = this.isExpires;
        item.isBuySpec = this.isBuySpec;
        item.info = this.info;
        item.content = this.content;
        item.reason = this.reason;
        item.isMe = this.isMe;
        item.newItem = this.newItem;
        item.headTemp = this.headTemp;
        item.bodyTemp = bodyTemp;
        item.legTemp = this.legTemp;
        item.bagTemp = this.bagTemp;
        item.wpTemp = this.wpTemp;
        item.expires = this.expires;
        return item;
    }
    
    public boolean isTypeBody() {
        return (0 <= (int)this.template.type && (int)this.template.type < 6) || (int)this.template.type == 32 || (int)this.template.type == 35 || (int)this.template.type == 11 || (int)this.template.type == 23  || (int)this.template.type == 24;
    }
    
    public boolean isTypeFoodsHPKI() {
        return this.template.type == 6;
    }
    
    public boolean isTypeUIMe() {
        return this.typeUI == 5 || this.typeUI == 3 || this.typeUI == 4;
    }
    
    public boolean isTypeUIShopView() {
        return this.isTypeUIShop() || (this.isTypeUIStore() || this.isTypeUIBook() || this.isTypeUIFashion());
    }
    
    public boolean isTypeUIShop() {
        return this.typeUI == 20 || this.typeUI == 21 || this.typeUI == 22 || this.typeUI == 23 || this.typeUI == 24 || this.typeUI == 25 || this.typeUI == 26 || this.typeUI == 27 || this.typeUI == 28 || this.typeUI == 29 || this.typeUI == 16 || this.typeUI == 17 || this.typeUI == 18 || this.typeUI == 19 || this.typeUI == 2 || this.typeUI == 6 || this.typeUI == 8;
    }
    
    public boolean isTypeUIShopLock() {
        return this.typeUI == 7 || this.typeUI == 9;
    }
    
    public boolean isTypeUIStore() {
        return this.typeUI == 14;
    }
    
    public boolean isTypeUIBook() {
        return this.typeUI == 15;
    }
    
    public boolean isTypeUIFashion() {
        return this.typeUI == 32;
    }
    
    public boolean isUpMax() {
        return this.getUpMax() == this.upgrade;
    }
    
    public int getUpMax() {
        if ((int)this.template.level >= 1 && (int)this.template.level < 20) {
            return 4;
        }
        if ((int)this.template.level >= 20 && (int)this.template.level < 40) {
            return 8;
        }
        if ((int)this.template.level >= 40 && (int)this.template.level < 50) {
            return 12;
        }
        if ((int)this.template.level >= 50 && (int)this.template.level < 60) {
            return 14;
        }
        return 16;
    }
    
    public void setPartTemp(int headTemp, int bodyTemp, int legTemp, int bagTemp) {
        this.headTemp = headTemp;
        this.bodyTemp = bodyTemp;
        this.legTemp = legTemp;
        this.bagTemp = bagTemp;
    }
    
    public int getIndexBody() {
        if (this.template.type == 0) {
            return 0;
        }
        if (this.template.type == 1) {
            return 1;
        }
        if (this.template.type == 2) {
            return 2;
        }
        if (this.template.type == 3) {
            return 3;
        }
        if (this.template.type == 4) {
            return 4;
        }
        if (this.template.type == 5) {
            return 5;
        }
        if (this.template.type == 32) {
            return 6;
        }
        if (this.template.type == 35) {
            return 7;
        }
        if (this.template.type == 11) {
            return 8;
        }
        if (this.template.type == 23 || this.template.type == 24) {
            return 9;
        }
        return -1;
    }
    
    public static boolean isIndexUI(int indexUI, Item[] arrItem) {
        int i;
        for (i = 0; i < arrItem.length; i++) {
            Item item = arrItem[i];
            if (item != null) {
                if (item.indexUI == indexUI) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isItemNotTrade() {
        return this.template.type == 5 || this.template.type == 6 ||
                this.template.id == 194 || this.template.id == 211 ||
                this.template.id == 212 || this.template.id == 521 ||
                (this.template.id >= 401 && this.template.id <= 404) ||
                this.template.id == 759|| this.template.type == 7 ||
                this.template.id == 454 || this.template.type == 22 ||
                this.template.type == 23 || (this.template.id >= 650 && this.template.id <= 662) ||
                this.template.id == 921 || this.isItemPet() ||
                this.template.id == 984 || this.template.id == 574 ||
                this.isItemKGPA() || this.isItemTask() || this.template.id == 992 ||
                this.template.id == 570 || this.template.id == 586 ||
                this.template.id == 587 ||this.isItemPetFollowz() ||
                this.isHaveOption(30) || this.template.type == 11 || this.template.type == 32
        ;
    }
    
    public static final int TYPE_BODY_MIN = 0;
    public static final int TYPE_BODY_MAX = 6;
    public static final int TYPE_AO = 0;
    public static final int TYPE_QUAN = 1;
    public static final int TYPE_GANGTAY = 2;
    public static final int TYPE_GIAY = 3;
    public static final int TYPE_RADA = 4;
    public static final int TYPE_HAIR = 5;
    public static final int TYPE_DAUTHAN = 6;
    public static final int TYPE_NGOCRONG = 12;
    public static final int TYPE_SACH = 7;
    public static final int TYPE_NHIEMVU = 8;
    public static final int TYPE_GOLD = 9;
    public static final int TYPE_DIAMOND = 10;
    public static final int TYPE_BALO = 11;
    public static final int TYPE_DIAMOND_LOCK = 34;
    public static final byte UI_WEAPON = 2;
    public static final byte UI_BAG = 3;
    public static final byte UI_BOX = 4;
    public static final byte UI_BODY = 5;
    public static final byte UI_STACK = 6;
    public static final byte UI_STACK_LOCK = 7;
    public static final byte UI_GROCERY = 8;
    public static final byte UI_GROCERY_LOCK = 9;
    public static final byte UI_UPGRADE = 10;
    public static final byte UI_UPPEARL = 11;
    public static final byte UI_UPPEARL_LOCK = 12;
    public static final byte UI_SPLIT = 13;
    public static final byte UI_STORE = 14;
    public static final byte UI_BOOK = 15;
    public static final byte UI_LIEN = 16;
    public static final byte UI_NHAN = 17;
    public static final byte UI_NGOCBOI = 18;
    public static final byte UI_PHU = 19;
    public static final byte UI_NONNAM = 20;
    public static final byte UI_NONNU = 21;
    public static final byte UI_AONAM = 22;
    public static final byte UI_AONU = 23;
    public static final byte UI_GANGTAYNAM = 24;
    public static final byte UI_GANGTAYNU = 25;
    public static final byte UI_QUANNAM = 26;
    public static final byte UI_QUANNU = 27;
    public static final byte UI_GIAYNAM = 28;
    public static final byte UI_GIAYNU = 29;
    public static final byte UI_TRADE = 30;
    public static final byte UI_UPGRADE_GOLD = 31;
    public static final byte UI_FASHION = 32;
    public static final byte UI_CONVERT = 33;
    public ItemTemplate template;
    public ArrayList<ItemOption> options;
    public int itemId;
    public int playerId;
    public boolean isSelect;
    public int indexUI;
    public int quantity;
    public int quantilyToBuy;
    public long powerRequire;
    public boolean isLock;
    public int sys;
    public int upgrade;
    public int buyCoin;
    public int buyCoinLock;
    public int buyGold;
    public int buyGoldLock;
    public int saleCoinLock;
    public int buySpec;
    public int buyRuby;
    public short iconSpec = -1;
    public byte buyType = -1;
    public int typeUI;
    public long expires = -1;
    public boolean isExpires;
    public boolean isBuySpec;
    public String info;
    public String content;
    public String reason;
    public int compare;
    public byte isMe;
    public boolean newItem;
    public int headTemp = -1;
    public int bodyTemp = -1;
    public int legTemp = -1;
    public int bagTemp = -1;
    public int wpTemp = -1;
    
    public int foodsHPKI() {
        int num = 0;
        int i;
        for (i = 0; i < this.options.size(); i++) {
            ItemOption option = this.options.get(i);
            if (option != null && (option.optionTemplate.id == 2 || option.optionTemplate.id == 48)) {
                if (option.optionTemplate.id == 2) {
                    num += (option.param * 1000);
                } else {
                    num += option.param;
                }
            }
        }
        return num;
    }
    
    public boolean isItemPackOf30Foods() {
        return (this.template.id >= 293 && this.template.id <= 299) || this.template.id == 596 || this.template.id == 597;
    }
    
    public boolean isItemTraining1() {
        return this.template.id == 529 || this.template.id == 534;
    }
    
    public boolean isItemTraining2() {
        return this.template.id == 530 || this.template.id == 535;
    }
    
    public boolean isItemTraining3() {
        return this.template.id == 531 || this.template.id == 536;
    }
    
    public boolean isItemTraining() {
        return this.isItemTraining1() || this.isItemTraining2() || this.isItemTraining3();
    }
    
    public boolean isItemWishGem() {
        return (this.template.id >= 14 && this.template.id <= 20);
    }
    
    public boolean isItemStar() {
        return (this.template.id >= 441 && this.template.id <= 447);
    }
    
    public boolean isItemSkillPet() {
        return (this.template.id >= 402 && this.template.id <= 404) || this.template.id == 759;
    }
    
    public boolean isItemBlackBall() {
        return (this.template.id >= 372 && this.template.id <= 378);
    }
    
    public boolean isItemDiBien() {
        return (this.template.id >= 691 && this.template.id <= 693);
    }
    
    public boolean isBigItem() {
        return this.template.id == 457;
    }
    
    public boolean isItemBanhTrungThu() {
        return (this.template.id >= 465 && this.template.id <= 466) || this.template.id == 472;
    }
    
    public boolean isItemMerge() {
        return !this.isTypeBody() && this.template.type != 11 && !this.isItemPet() && !this.isItemPetFollowz() && !this.isItemnogop();
    }
    public boolean isItemnogop() {
        return this.template.id == 970;
    }
    public boolean isItemSLL() {
        return this.template.id == 590 || this.template.id == 933;
    }
    
    public boolean isItemPet() {
        if (this.template.id == 1224 || this.template.id == 1225 || this.template.id == 1226) {
            return true;
        }
        if (this.template.id == 1008 || this.template.id == 1207 || this.template.id == 1243 || this.template.id == 1244) {
            return true;
        }
        return (this.template.id >= 916 && this.template.id <= 919) || (this.template.id >= 942 && this.template.id <= 944) || this.template.id == 1039 || this.template.id == 1040 || this.template.id == 1046 || this.template.id == 908 || this.template.id == 909 || this.template.id == 910 || this.template.id == 967 || this.template.id == 1107 || this.template.id == 1114 || this.template.id == 1188;
    }

    
    public boolean isItemLimit() {
        return this.template.id == 984 || this.template.id == 574 || this.template.id == 1116 ;
    }
    
    public boolean isItem11_1() {
        return (this.template.id >= 386 && this.template.id <= 394);
    }
    
    public boolean isItemSKH() {
        return this.isHaveOption(127) || this.isHaveOption(128) || this.isHaveOption(129) || this.isHaveOption(130) || this.isHaveOption(131) || this.isHaveOption(132) || this.isHaveOption(133) || this.isHaveOption(134) || this.isHaveOption(135);
    }
    
    public boolean isItemNK() {
        return (this.template.id >= 541 && this.template.id <= 542);
    }
    
    public boolean isItemKGPA() {
        return (this.template.id >= 537 && this.template.id <= 540);
    }
    
    public boolean isItemNotSale() {
        return this.template.type == 22;
    }
    
    public boolean isItemTask() {
        return this.template.type == 8 || this.template.id == 993;
    }
    
    public boolean isItemKyGui() {
        return this.isHaveOption(86) || this.isHaveOption(87) || (this.template.id >= 14 && this.template.id <= 20 && !this.isHaveOption(30)) ||
                (this.template.id >= 63 && this.template.id <= 65) || this.template.id == 352 || this.template.id == 523 ||
                this.template.id == 595 || this.template.type == 14;
    }
    
    public int maxQuantity() {
        if (this.template.id == 457) {
            return 30000;
        }
        if (this.template.id >= 199 && this.template.id <= 202) {
            return 10000;
        }
        if (this.template.id >= 1066 && this.template.id <= 1070) {
            return 30000;
        }
        if (this.template.id >= 979 && this.template.id <= 981) {
            return 30000;
        }
        if (this.template.id >= 1118 && this.template.id <= 1127) {
            return 30000;
        }
        if (this.template.id == 1134) {
            return 30000;
        }
        if (this.template.id >= 1177 && this.template.id <= 1181) {
            return 30000;
        }
        if (this.template.id >= 748 && this.template.id <= 751) {
            return 30000;
        }
        if (this.template.id == 1194) {
            return 30000;
        }
        if (this.template.id >= 1177 && this.template.id <= 1181) {
            return 30000;
        }
        if (this.template.id == 700) {
            return 30000;
        }
        if (this.template.id == 1093 || this.template.id == 1094 || this.template.id == 1095 || this.template.id == 1096) {
            return 30000;
        }
        if (this.template.id == 723) {
            return 999;
        }
        if (this.template.id == 673) {
            return 999;
        }
         if (this.template.id == 586 || this.template.id == 587) {
            return 999;
        }
        if (this.template.id == 2001 || this.template.id == 2002 || this.template.id == 2003 || this.template.id == 2004 || this.template.id == 2005 || this.template.id == 2008 || this.template.id == 2009) {
            return 30000;
        }
        if (this.template.id == 569) {
            return 9999;
        }
        if (this.template.id == 1229) {
            return 9999;
        }
        //su kien he 2023
        if (this.template.id == 1002 || this.template.id == 1003 || this.template.id == 1004 || this.template.id == 1990 || this.template.id == 1991 || this.template.id == 1992 || this.template.id == 1993 || this.template.id == 1994 || this.template.id == 1995 || this.template.id == 1996 || this.template.id == 2000) {
            return 9999;
        }
        //su kien he 2023 2
        if (this.template.id >= 1237 && this.template.id <= 1240 || this.template.id >= 1245 && this.template.id <= 1251 || this.template.id >= 1987 && this.template.id <= 1988 ) {
            return 9999;
        }
        if (this.template.id >= 222 && this.template.id <= 224) {
            return 999;
        }
        //Trang sach
        if (this.template.id == 1281) {
            return 9999;
        }
        return 99;
    }
    
    public boolean isItemDucLo() {
        return this.template.type == 0 || this.template.type == 1 || this.template.type == 2 || this.template.type == 3 || this.template.type == 4 || this.template.type == 32;
    }
    
    public boolean isItemHD() {
        return this.template.id >= 650 && this.template.id <= 662;
    }
    
    public String optionCombine(int star) {
        String str = mResources.EMPTY;
        int i;
        for (i = 0; i < this.options.size(); i++) {
            ItemOption option = this.options.get(i);
            if (option.optionTemplate.id != 102 && option.optionTemplate.id != 107) {
                str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+option.param));
            }
        }
        return str + String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[107].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+star));
    }
    
    public boolean isOption(int id) {
        int i;
        for (i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).optionTemplate.id == id) {
                return true;
            }
        }
        return false;
    }
    
    public int getParamOption(int id) {
        int i;
        for (i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).optionTemplate.id == id) {
                return this.options.get(i).param;
            }
        }
        return 0;
    }
    
    public ItemOption getOption(int id) {
        int i;
        for (i = 0; i < this.options.size(); i++) {
            if (this.options.get(i).optionTemplate.id == id) {
                return this.options.get(i);
            }
        }
        return null;
    }
    
    public String optionCombine(Item itEp) {
        String str = mResources.EMPTY;
        int i;
        boolean isUp = false;
        //up
        for (i = 0; i < this.options.size(); i++) {
            ItemOption option = this.options.get(i);
            if (option.optionTemplate.id != 102 && option.optionTemplate.id != 107) {
                if (itEp.template.id == 14 && option.optionTemplate.id == 108) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 2)));
                    isUp = true;
                } else if (itEp.template.id == 15 && option.optionTemplate.id == 94) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 2)));
                    isUp = true;
                } else if (itEp.template.id == 16 && option.optionTemplate.id == 147) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 3)));
                    isUp = true;
                } else if (itEp.template.id == 17 && option.optionTemplate.id == 81) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 18 && option.optionTemplate.id == 80) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 19 && option.optionTemplate.id == 103) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 20 && option.optionTemplate.id == 77) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 441 && option.optionTemplate.id == 95) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 442 && option.optionTemplate.id == 96) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 443 && option.optionTemplate.id == 97) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 444 && option.optionTemplate.id == 98) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 3)));
                    isUp = true;
                } else if (itEp.template.id == 445 && option.optionTemplate.id == 99) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 3)));
                    isUp = true;
                } else if (itEp.template.id == 446 && option.optionTemplate.id == 100) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else if (itEp.template.id == 447 && option.optionTemplate.id == 101) {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+(option.param + 5)));
                    isUp = true;
                } else {
                    str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+option.param));
                }
            }
        }
        //add
        if (!isUp) {
            if (itEp.template.id == 14) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[108].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+2));
            }
            if (itEp.template.id == 15) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[94].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+2));
            }
            if (itEp.template.id == 16) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[147].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+3));
            }
            if (itEp.template.id == 17) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[81].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 18) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[80].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 19) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[103].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 20) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[77].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 441) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[95].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 442) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[96].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 443) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[97].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 444) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[98].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+3));
            }
            if (itEp.template.id == 445) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[99].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+3));
            }
            if (itEp.template.id == 446) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[100].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
            if (itEp.template.id == 447) {
                str += String.format(mResources.FONT_COLOR_OPTION, GameData.iOptionTemplates[101].name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY+5));
            }
        }
        return str;
    }
    
    public String optionCombine() {
        String str = mResources.EMPTY;
        int i;
        for (i = 0; i < this.options.size(); i++) {
            ItemOption option = this.options.get(i);
            if (option.optionTemplate.id != 102 && option.optionTemplate.id != 107) {
                str += String.format(mResources.FONT_COLOR_OPTION, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY + option.param));
            }
        }
        return str;
    }
    
    public String optionCombine1() {
        String str = mResources.EMPTY;
        int i;
        for (i = 0; i < this.options.size(); i++) {
            ItemOption option = this.options.get(i);
            if (option.optionTemplate.id != 102 && option.optionTemplate.id != 107) {
                str += String.format(mResources.FONT_COLOR_OPTION1, option.optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY + Combine.nextParamOption(option.optionTemplate.id, 1, option.param)));
            }
        }
        return str;
    }
    
    public int getStarBlue() {
        int i;
        for (i = 0; i < options.size(); i++) {
            if (options.get(i).optionTemplate.id == 102) {
                return options.get(i).param;
            }
        }
        return 0;
    }
    
    public int getStarWhite() {
        int i;
        for (i = 0; i < options.size(); i++) {
            if (options.get(i).optionTemplate.id == 107) {
                return options.get(i).param;
            }
        }
        return 0;
    }
    
    public long getstrRequire() {
        if (this.isHaveOption(21)) {
            return (long) ((long)this.getParamOption(21) * 1000000000L);
        }
        return this.template.strRequire;
    }
    
    public static Item parseItem(String str) throws ParseException {
        Item item = new Item();
        int m = 0;
        JSONArray jarr = (JSONArray) JSONValue.parseWithException(str);
        int id = Short.parseShort(jarr.get(m++).toString());
        item.template = ItemTemplate.get((short) (item.itemId = id));
        item.indexUI = Integer.parseInt(jarr.get(m++).toString());
        item.typeUI = Integer.parseInt(jarr.get(m++).toString());
        item.quantity = Integer.parseInt(jarr.get(m++).toString());
        item.isLock = Boolean.parseBoolean(jarr.get(m++).toString());
        item.sys = Byte.parseByte(jarr.get(m++).toString());
        item.upgrade = Integer.parseInt(jarr.get(m++).toString());
        item.buyCoin = Integer.parseInt(jarr.get(m++).toString());
        item.buyCoinLock = Integer.parseInt(jarr.get(m++).toString());
        item.buyGold = Integer.parseInt(jarr.get(m++).toString());
        item.buyGoldLock = Integer.parseInt(jarr.get(m++).toString());
        item.saleCoinLock = Integer.parseInt(jarr.get(m++).toString());
        item.buySpec = Integer.parseInt(jarr.get(m++).toString());
        item.buyRuby = Integer.parseInt(jarr.get(m++).toString());
        item.iconSpec = Short.parseShort(jarr.get(m++).toString());
        item.buyType = Byte.parseByte(jarr.get(m++).toString());
        item.isExpires = Boolean.parseBoolean(jarr.get(m++).toString());
        item.isBuySpec = Boolean.parseBoolean(jarr.get(m++).toString());
        item.options = new ArrayList<>();
        JSONArray options = (JSONArray) jarr.get(m++);
        for (int i = 0; i < options.size(); i++) {
            JSONArray jop = (JSONArray) options.get(i);
            ItemOption option = new ItemOption();
            option.optionTemplate = GameData.iOptionTemplates[Integer.parseInt(jop.get(0).toString())];
            option.param = Integer.parseInt(jop.get(1).toString());
            item.options.add(option);
        }
        item.info = jarr.get(m++).toString();
        item.content = jarr.get(m++).toString();
        item.reason = jarr.get(m++).toString();
        item.isMe = Byte.parseByte(jarr.get(m++).toString());
        item.newItem = Boolean.parseBoolean(jarr.get(m++).toString());
        item.headTemp = Short.parseShort(jarr.get(m++).toString());
        item.bodyTemp = Short.parseShort(jarr.get(m++).toString());
        item.legTemp = Short.parseShort(jarr.get(m++).toString());
        item.bagTemp = Short.parseShort(jarr.get(m++).toString());
        item.wpTemp = Short.parseShort(jarr.get(m++).toString());
        item.expires = Long.parseLong(jarr.get(m++).toString());
        return item;
    }
    
    @Override
    public String toString() {
        JSONArray jarr = new JSONArray();
        JSONArray joption = new JSONArray();
        int i;
        jarr.add(this.template.id);
        jarr.add(this.indexUI);
        jarr.add(this.typeUI);
        jarr.add(this.quantity);
        jarr.add(this.isLock);
        jarr.add(this.sys);
        jarr.add(this.upgrade);
        jarr.add(this.buyCoin);
        jarr.add(this.buyCoinLock);
        jarr.add(this.buyGold);
        jarr.add(this.buyGoldLock);
        jarr.add(this.saleCoinLock);
        jarr.add(this.buySpec);
        jarr.add(this.buyRuby);
        jarr.add(this.iconSpec);
        jarr.add(this.buyType);
        jarr.add(this.isExpires);
        jarr.add(this.isBuySpec);
        for (i = 0; i < this.options.size(); i++) {
            JSONArray option = new JSONArray();
            option.add(this.options.get(i).optionTemplate.id);
            option.add(this.options.get(i).param);
            joption.add(option);
        }
        jarr.add(joption);
        jarr.add(this.info);
        jarr.add(this.content);
        jarr.add(this.reason);
        jarr.add(this.isMe);
        jarr.add(this.newItem);
        jarr.add(this.headTemp);
        jarr.add(this.bodyTemp);
        jarr.add(this.legTemp);
        jarr.add(this.bagTemp);
        jarr.add(this.wpTemp);
        jarr.add(this.expires);
        return jarr.toJSONString();
    }
    
    public void setExpires(long curr) {
        ItemOption op = this.getOption(93);
        if (op !=  null) {
            op.param = (int) ((curr - System.currentTimeMillis()) / 86400000L);
        } else {
            this.options.add(new ItemOption(93, (int) ((curr - System.currentTimeMillis()) / 86400000L)));
        }
        this.isExpires = true;
        this.expires = curr;
    }
    
    public boolean isItemFormula() {
        return (this.template.id >= 1071 && this.template.id <= 1073) || (this.template.id >= 1084 && this.template.id <= 1086);
    }
    
    public boolean isItemFormulaVIP() {
        return (this.template.id >= 1084 && this.template.id <= 1086);
    }
    
    public boolean isItemGraft() {
        return (this.template.id >= 1066 && this.template.id <= 1070);
    }
    
    public boolean isItemCrystal() {
        return (this.template.id >= 1079 && this.template.id <= 1083);
    }
    
    public boolean isItemRuby() {
        return (this.template.id >= 1074 && this.template.id <= 1078);
    }
    
    public boolean isItemTL() {
        return (this.template.id >= 555 && this.template.id <= 567);
    }
    
    public boolean isItemPetFollowz() {
        return (this.template.id >= 2010 && this.template.id <= 2015);
    }
    
    public boolean isItemNamekBall() {
        return (this.template.id >= 353 && this.template.id <= 359);
    }
    
    public boolean isClear() {
    	if (this.template == null) {
    		System.out.println("Loi phai Xoa item templateId="+ this.itemId);
    		return true;
    	}
        if (this.isItem11_1() && !Dragon.isEvent_Noel) {
            return true;
        }
        if ((this.template.id == 752 || this.template.id == 753) && !Dragon.isEvent_TetNguyenDan) {
            return true;
        }
        return false;
    }
    
    public boolean isItemForSale() {
        return this.template.type == 0 || this.template.type == 1 || this.template.type == 2 || this.template.type == 3 || this.template.type == 4 ||
                this.template.type == 6 || this.template.type == 12 || this.template.type == 29 || this.template.type == 31 || this.template.type == 32 ||
                this.template.id == 457;
    }
    
    public boolean isItemForThrow() {
        return this.template.type == 0 || this.template.type == 1 || this.template.type == 2 || this.template.type == 3 || this.template.type == 4 ||
                this.template.type == 5 || this.template.type == 6 || this.template.type == 7 || this.template.type == 11 || this.template.type == 13 || this.template.type == 14 ||
                this.template.type == 15 || this.template.type == 16 || this.template.type == 22 || this.template.type == 23 || this.template.type == 24 || this.template.type == 25 ||
                this.template.type == 27 || this.template.type == 29 || this.template.type == 30 || this.template.type == 31 || this.template.type == 32 || this.template.type == 33;
    }
    
    public String strOption() {
        String str = "";
        for (int i = 0; i < this.options.size(); i++) {
            if (i > 0) str += ", ";
            str += this.options.get(i).optionTemplate.name.replaceAll(mResources.OPTION_PARAM, mResources.EMPTY + this.options.get(i).param);
        }
        return str;
    }
    
    public boolean isItemPractice() {
        return this.template.id == 880 || this.template.id == 881 || this.template.id == 882;
    }

}
