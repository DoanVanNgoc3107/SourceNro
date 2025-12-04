package dragon.t;

import dragon.server.MySQL;
import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class ItemKyGui {
    
    public int playerId;
    public Item item;
    public long last;
    
    public static int gameTick;
    
    public ItemKyGui(ResultSet res) throws SQLException, ParseException {
        this.playerId = res.getInt("playerId");
        this.last = res.getLong("last");
        this.item = Item.parseItem(res.getString("item"));
    }
    
    public ItemKyGui(Item item, int playerId) {
        this.playerId = playerId;
        this.item = item;
        this.last = System.currentTimeMillis();
    }
    
    public static String[] shopName = new String[] {
        "Áo\nQuần",
        "Phụ\nkiện",
        "Găng\ntay",
        "Linh\ntinh",
        ""
    };
    
    public static final ArrayList<ItemKyGui>[] SHOP_KY_GUI = new ArrayList[] {
        new ArrayList<>(),
        new ArrayList<>(),
        new ArrayList<>(),
        new ArrayList<>(),
        new ArrayList<>()
    };
    private static short baseId = 0;
    private static final int MAX_ITEM_PAGE = 25;
    
    public static final int MINXU = 10000;
    public static final int MAXXU = 2000000000;
    
    public static final int MINLUONG = 2;
    public static final int MAXLUONG = 2000000000;
    
    public static final int NGOC_SALE = 1;
    
    public static final int FEE = 5;
    
    private static final int MAX_SLOT = 3000;
    
    private static final ArrayList<ItemKyGui> ITEMS = new ArrayList<>();
    
    private static boolean checkbaseId(int itemId) {
        for (int i = 0; i < SHOP_KY_GUI.length; i++) {
            for (int i2 = 0; i2 < SHOP_KY_GUI[i].size(); i2++) {
                if (SHOP_KY_GUI[i].get(i2).item.itemId == itemId) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isHaveItem(int itemId) {
        synchronized (SHOP_KY_GUI) {
            for (int i = 0; i < SHOP_KY_GUI.length; i++) {
                for (int i2 = 0; i2 < SHOP_KY_GUI[i].size(); i2++) {
                    if (SHOP_KY_GUI[i].get(i2).item.itemId == itemId) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    public static ItemKyGui getItem(int itemId) {
        synchronized (SHOP_KY_GUI) {
            for (int i = 0; i < SHOP_KY_GUI.length; i++) {
                for (int i2 = 0; i2 < SHOP_KY_GUI[i].size(); i2++) {
                    if (SHOP_KY_GUI[i].get(i2).item.itemId == itemId) {
                        return SHOP_KY_GUI[i].get(i2);
                    }
                }
            }
        }
        return null;
    }
    
    public static ItemKyGui remove(int itemId) {
        synchronized (SHOP_KY_GUI) {
            for (int i = 0; i < SHOP_KY_GUI.length; i++) {
                for (int i2 = 0; i2 < SHOP_KY_GUI[i].size(); i2++) {
                    if (SHOP_KY_GUI[i].get(i2).item.itemId == itemId) {
                        return SHOP_KY_GUI[i].remove(i2);
                    }
                }
            }
        }
        return null;
    }
    
    public static void add(ItemKyGui itemk) {
        synchronized (SHOP_KY_GUI) {
            for (;checkbaseId(itemk.item.itemId = baseId++);){}
            SHOP_KY_GUI[indexShop(itemk.item)].add(itemk);
        }
    }
    
    public static void openShop(Char charz) {
        ArrayList<ItemKyGui>[] arrkygui = new ArrayList[ItemKyGui.shopName.length];
        for (int i = 0; i < ItemKyGui.shopName.length; i++) {
            arrkygui[i] = new ArrayList<>();
            readShop(charz, i, 0, arrkygui[i]);
        }
        readShopMe(charz, arrkygui[4]);
        charz.session.service.shopKyGui(ItemKyGui.shopName, arrkygui);
    }
    
    private static void readShop(Char charz, int index, int page, ArrayList<ItemKyGui> list_kygui) {
        int first = page * MAX_ITEM_PAGE;
        int n = 0;
        synchronized (SHOP_KY_GUI) {
            for (int i = SHOP_KY_GUI[index].size() - 1; i >= 0; i--) {
                if (SHOP_KY_GUI[index].get(i).item.buyType == 1 && SHOP_KY_GUI[index].get(i).typeConsign() == charz.typeConsign) {
                    if (n >= first && n < first + MAX_ITEM_PAGE) {
                        list_kygui.add(SHOP_KY_GUI[index].get(i));
                        if (list_kygui.size() >= MAX_ITEM_PAGE) {
                            break;
                        }
                    }
                    n++;
                }
            }
        }
    }
    
    public static int maxPageShop(Char charz, int index) {
        synchronized (SHOP_KY_GUI) {
            int num = 0;
            for (int i = 0; i < SHOP_KY_GUI[index].size(); i++) {
                if (SHOP_KY_GUI[index].get(i).item.buyType == 1 && SHOP_KY_GUI[index].get(i).typeConsign() == charz.typeConsign) {
                    num++;
                }
            }
            return (num - 1) / MAX_ITEM_PAGE + 1;
        }
    }
    
    private static void readShopMe(Char charz, ArrayList<ItemKyGui> list_kygui) {
        synchronized (SHOP_KY_GUI) {
            for (int j = 0; j < SHOP_KY_GUI.length; j++)  {
                for (int i = SHOP_KY_GUI[j].size() - 1; i >= 0; i--) {
                    if (SHOP_KY_GUI[j].get(i).playerId == charz.playerId) {
                        list_kygui.add(SHOP_KY_GUI[j].get(i));
                        if (list_kygui.size() >= 100) return;
                    }
                }
            }
        }
        for (int i2 = 0; i2 < charz.arrItemBag.length; i2++) {
            if (charz.arrItemBag[i2] != null && charz.arrItemBag[i2].isItemKyGui()) {
                //new item
                Item item = charz.arrItemBag[i2].clone();
                //set item
                item.itemId = item.indexUI;
                item.buyType = 0;
                ItemKyGui itemk = new ItemKyGui(item, -1);
                //add item
                list_kygui.add(itemk);
                if (list_kygui.size() >= 100) return;
            }
        }
    }
    
    public static void kygui(Char charz, byte action, int itemId, byte moneyType, int money, int quaintly) {
        //ky gui
        if (charz.zoneMap.isHaveNpc(28)) {
            Npc npc = charz.zoneMap.findNPCInMap(28);
            if (Math.abs(npc.cx - charz.cx) < 70 && Math.abs(npc.cy - charz.cy) < 40) {
                if (action == 0) {
                    if (itemId >= 0 && itemId < charz.arrItemBag.length && charz.arrItemBag[itemId] != null && charz.arrItemBag[itemId].isItemKyGui() && quaintly > 0 && quaintly <= charz.arrItemBag[itemId].quantity) {
                        if (countItem() >= MAX_SLOT) {
                            charz.session.service.chatTHEGIOI("", mResources.MAX_KY_GUI, null, 0);
                            return;
                        }
                        int maxSale = 20;
                        if (countItemById(charz.playerId) >= maxSale) {
                            charz.addInfo1(String.format(mResources.MAX_SALE_ITEM, maxSale));
                            return;
                        }
                        if ((moneyType == 0 && (money < 5 || money > MAXXU)) || (moneyType != 0 && (money < MINLUONG || money > MAXLUONG))) {
                            charz.session.service.chatTHEGIOI("", String.format(mResources.BAN_CO_THE_BAN, Util.gI().numberTostring(MINXU), Util.gI().numberTostring(MAXXU), Util.gI().numberTostring(MINLUONG), Util.gI().numberTostring(MAXLUONG)), null, 0);
                            return;
                        }
                        if (charz.getLuong() < NGOC_SALE) {
                            charz.session.service.chatTHEGIOI("", String.format(mResources.CONTHIEU_NGOC, NGOC_SALE - charz.getLuong()), null, 0);
                            return;
                        }
                        if (charz.cPower < 150000000L) {
                            charz.session.service.chatTHEGIOI("", String.format(mResources.CAN_SUC_MANH_2, Util.gI().numberTostring(150000000L)), null, 0);
                            return;
                        }
                        if (quaintly < 10 && (charz.arrItemBag[itemId].template.type == 6 || charz.arrItemBag[itemId].template.type == 14)) {
                            charz.session.service.chatTHEGIOI("", mResources.KY_VAT_PHAM, null, 0);
                            return;
                        }
                        if ((moneyType == 0 && money < MINXU) && charz.arrItemBag[itemId].template.id == 457) {
                            charz.addInfo1(String.format(mResources.BAN_CO_THE_BAN, Util.gI().numberTostring(MINXU), Util.gI().numberTostring(MAXXU), Util.gI().numberTostring(MINLUONG), Util.gI().numberTostring(MAXLUONG)));
                            return;
                        }
                        //new item
                        ItemKyGui kygui0 = new ItemKyGui(charz.arrItemBag[itemId].clone(), charz.playerId);
                        //Xoa
                        charz.updateLuong(-NGOC_SALE, 2);
                        charz.useItemBag(itemId, quaintly);
                        //Set
                        kygui0.item.quantity = quaintly;
                        kygui0.item.buyType = 1;
                        if (moneyType == 1) {
                            if (!kygui0.item.isHaveOption(87)) {
                                return;
                            }
                            kygui0.item.buyCoin = -1;
                            kygui0.item.buyGold = money;
                        } else {
                            kygui0.item.buyCoin = money;
                            kygui0.item.buyGold = -1;
                        }
                        add(kygui0);
                        //open and tru
                        ArrayList<ItemKyGui>[] arrkygui = new ArrayList[ItemKyGui.shopName.length];
                        for (int i = 0; i < ItemKyGui.shopName.length; i++) {
                            arrkygui[i] = new ArrayList<>();
                            readShop(charz, i, 0, arrkygui[i]);
                        }
                        readShopMe(charz, arrkygui[4]);
                        for (int i2 = 0; i2 < arrkygui.length; i2++) {
                            charz.session.service.shopKyGui(i2, maxPageShop(charz, i2), 0, arrkygui[i2]);
                        }
                    }
                }
                //huy ky gui
                if (action == 1) {
                    if (isHaveItem(itemId)) {
                        ItemKyGui kygui2 = getItem(itemId);
                        if (kygui2.playerId == charz.playerId) {
                            if (kygui2.item.buyType != 1) {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.MUA_KY_GUI, null, (byte)0);
                                return;
                            }
                            if (charz.checkBag(kygui2.item)) {
                                remove(itemId);
                                charz.addItemBag(0, kygui2.item);
                                ArrayList<ItemKyGui>[] arrkygui = new ArrayList[ItemKyGui.shopName.length];
                                for (int i = 0; i < ItemKyGui.shopName.length; i++) {
                                    arrkygui[i] = new ArrayList<>();
                                    readShop(charz, i, 0, arrkygui[i]);
                                }
                                readShopMe(charz, arrkygui[4]);
                                for (int i2 = 0; i2 < arrkygui.length; i2++) {
                                    charz.session.service.shopKyGui(i2, maxPageShop(charz, i2), 0, arrkygui[i2]);
                                }
                            } else {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte)0);
                            }
                        }
                    }
                }
                //Nhan tien
                if (action == 2) {
                    if (isHaveItem(itemId)) {
                        ItemKyGui kygui2 = getItem(itemId);
                        if (kygui2.playerId == charz.playerId && kygui2.item.buyType == 2) {
                            if (kygui2.item.buyCoin != -1 && kygui2.typeConsign() == 1) {
                                Item thoivang = new Item(457, false, kygui2.item.buyCoin - 1, ItemOption.getOption(457, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                                if (charz.totalBagByItem(thoivang) < kygui2.item.buyCoin - 1) {
                                    charz.addInfo1(mResources.BAG_FULL);
                                    return;
                                } else {
                                    charz.addItemBag(0, thoivang);
                                }
                            }
                            remove(itemId);
                            if (kygui2.item.buyCoin != -1) {
                                if (kygui2.typeConsign() != 1) {
                                    charz.updateXu((int)((long)kygui2.item.buyCoin * 95L / 100L), 0);
                                }
                            }
                            if (kygui2.item.buyGold != -1) {
                                charz.updateLuong((int)((long)kygui2.item.buyGold * 95L / 100L), 0);
                            }
                            ArrayList<ItemKyGui>[] arrkygui = new ArrayList[ItemKyGui.shopName.length];
                            for (int i = 0; i < ItemKyGui.shopName.length; i++) {
                                arrkygui[i] = new ArrayList<>();
                                readShop(charz, i, 0, arrkygui[i]);
                            }
                            readShopMe(charz, arrkygui[4]);
                            for (int i2 = 0; i2 < arrkygui.length; i2++) {
                                charz.session.service.shopKyGui(i2, maxPageShop(charz, i2), 0, arrkygui[i2]);
                            }
                            charz.session.service.itemBuy(charz.xu, charz.luong, charz.luongKhoa);
                        }
                    }
                }
                //mua do
                if (action == 3) {
                    if (charz.cPower < 150000000L) {
                        charz.session.service.chatTHEGIOI("", String.format(mResources.CAN_SUC_MANH_3, Util.gI().numberTostring(150000000L)), null, 0);
                        return;
                    }
                    if (isHaveItem(itemId)) {
                        ItemKyGui kygui3 = getItem(itemId);
                        if (kygui3.item.buyType != 1) {
                            charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.MUA_KY_GUI, null, (byte)0);
                            return;
                        }
                        if (kygui3.item.buyType == 1) {
                            if (moneyType == 0) {
                                if (kygui3.item.buyCoin == -1) {
                                    return;
                                }
                                if (kygui3.typeConsign() == 1) {
                                    if (charz.getItemBagQuantityById(457) < kygui3.item.buyCoin) {
                                        charz.session.service.chatTHEGIOI("", String.format(mResources.CONTHIEU_ITEM_VANG, kygui3.item.buyCoin - charz.getItemBagQuantityById(457)), null, 0);
                                        return;
                                    }
                                } else if (kygui3.item.buyCoin > charz.xu) {
                                    charz.session.service.chatTHEGIOI("", String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(kygui3.item.buyCoin - charz.xu)), null, 0);
                                    return;
                                }
                            } else {
                                if (kygui3.item.buyGold == -1) {
                                    return;
                                }
                                if (kygui3.item.buyGold > charz.luong) {
                                    charz.session.service.chatTHEGIOI("", String.format(mResources.CONTHIEU_NGOC, kygui3.item.buyGold - charz.luong), null, 0);
                                    return;
                                }
                            }
                            if (charz.checkBag(kygui3.item)) {
                                if (moneyType == 0) {
                                    if (kygui3.typeConsign() == 1) {
                                        charz.useItemBagById(457, kygui3.item.buyCoin);
                                        kygui3.item.buyGold = -1;
                                    } else {
                                        charz.updateXu(-kygui3.item.buyCoin, 0);
                                        kygui3.item.buyGold = -1;
                                    }
                                } else {
                                    charz.updateLuong(-kygui3.item.buyGold, 0);
                                    kygui3.item.buyCoin = -1;
                                }
                                kygui3.item.buyType = 2;
                                charz.addItemBag(0, kygui3.item);
                                ArrayList<ItemKyGui>[] arrkygui = new ArrayList[ItemKyGui.shopName.length];
                                for (int i = 0; i < ItemKyGui.shopName.length; i++) {
                                    arrkygui[i] = new ArrayList<>();
                                    readShop(charz, i, 0, arrkygui[i]);
                                }
                                readShopMe(charz, arrkygui[4]);
                                for (int i2 = 0; i2 < arrkygui.length; i2++) {
                                    charz.session.service.shopKyGui(i2, maxPageShop(charz, i2), 0, arrkygui[i2]);
                                }
                                charz.session.service.itemBuy(charz.xu, charz.luong, charz.luongKhoa);
                            } else {
                                charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte)0);
                            }
                        }
                    }
                }
                //phan trang
                if (action == 4) {
                    if (moneyType >= 0 && moneyType < shopName.length && money >= 0 && money < maxPageShop(charz, moneyType) && moneyType != 4) {
                        ArrayList<ItemKyGui> list_kygui_2 = new ArrayList<>();
                        readShop(charz, moneyType, money, list_kygui_2);
                        charz.session.service.shopKyGui(moneyType, maxPageShop(charz, moneyType), money, list_kygui_2);
                    }
                }
            }
        }
        //debug
//        System.out.println("action="+action+" itemId="+itemId+" moneyType="+moneyType+" money="+money+" quaintly="+quaintly);
    }
    
    public static int indexShop(Item item) {
        if (item.template.type == 0 || item.template.type == 1) {
            return 0;
        }
        if (item.template.type == 3 || item.template.type == 4 || item.template.type == 5 || item.template.type == 11 || item.template.type == 23 || item.template.type == 24 || item.template.type == 32 || item.template.type == 33) {
            return 1;
        }
        if (item.template.type == 2) {
            return 2;
        }
        return 3;
    }
    
    public static void saveKyGui() {
        ArrayList<ItemKyGui> list = new ArrayList<>();
        synchronized (ItemKyGui.SHOP_KY_GUI) {
            for (int i4 = 0; i4 < ItemKyGui.SHOP_KY_GUI.length; i4++)  {
                for (int i5 = 0; i5 < ItemKyGui.SHOP_KY_GUI[i4].size(); i5++) {
                    list.add(ItemKyGui.SHOP_KY_GUI[i4].get(i5));
                }
            }
        }
        try {
            MySQL mySQL = MySQL.createData3();
            try {
                mySQL.getConnection().setAutoCommit(false);
                try {
                    //Xoa all data cu
                    mySQL.getConnection().prepareStatement(mResources.DELETE_ARRKYGUI).executeUpdate();
                    //insert data moi
                    for (int i = 0; i < list.size(); i++) {
                        mySQL.getConnection().prepareStatement(String.format(
                                mResources.INSERT_ARRKYGUI,
                                list.get(i).playerId,
                                list.get(i).item.toString(),
                                list.get(i).last
                        )).executeUpdate();
                    }
                    mySQL.getConnection().commit();
                } catch (SQLException e) {
                    mySQL.getConnection().rollback();
                    e.printStackTrace();
                }
            } finally {
                mySQL.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static int countItem() {
        synchronized (SHOP_KY_GUI) {
            int count = 0;
            for (int j = 0; j < SHOP_KY_GUI.length; j++)  {
                for (int i = 0; i < SHOP_KY_GUI[j].size(); i++) {
                    if (SHOP_KY_GUI[j].get(i).item.buyType == 1) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
    
    public static int countItemById(int playerId) {
        synchronized (SHOP_KY_GUI) {
            int count = 0;
            for (int j = 0; j < SHOP_KY_GUI.length; j++)  {
                for (int i = 0; i < SHOP_KY_GUI[j].size(); i++) {
                    if (SHOP_KY_GUI[j].get(i).playerId == playerId) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
    
    public static void update() {
        ITEMS.clear();
        synchronized (SHOP_KY_GUI) {
            for (int j = 0; j < SHOP_KY_GUI.length; ++j)  {
                for (int i = 0; i < SHOP_KY_GUI[j].size(); i++) {
                    ITEMS.add(SHOP_KY_GUI[j].get(i));
                }
            }
        }
        for (int i2 = 0; i2 < ITEMS.size(); i2++) {
            //Xoa do neu qua 1 tuan
            if (System.currentTimeMillis() - ITEMS.get(i2).last >= 604800000L) {
                ItemKyGui.remove(ITEMS.get(i2).item.itemId);
            } else {
                //Tra item neu qua 1 ngay
                if (System.currentTimeMillis() - ITEMS.get(i2).last >= 86400000L && ITEMS.get(i2).item.buyType == 1) {
                    ITEMS.get(i2).item.buyType = 0;
                }
                if (ITEMS.get(i2).item.buyType != 1 && ITEMS.get(i2).item.buyType != 2) {
                    Session_ME player = Server.gI().getByPId(ITEMS.get(i2).playerId);
                    if (player != null && !player.myCharz().isgiaodich) {
                        if (player.myCharz().checkBag(ITEMS.get(i2).item)) {
                            ITEMS.get(i2).item.buyType = 0;
                            remove(ITEMS.get(i2).item.itemId);
                            player.myCharz().addItemBag(0, ITEMS.get(i2).item);
                        }
                    }
                }
            }
        }
    }
    
    public int typeConsign() {
        //Kieu ky gui bang thoi vang
        if (this.item.buyCoin != -1 && this.item.buyCoin < MINXU) return 1;
        //Cac loai id cua shop su kien
        if (this.item.template.id == 457) return 2;
        return 0;
    }
    
    public static int countItemKyGui() {
        int num = 0;
        synchronized (ItemKyGui.SHOP_KY_GUI) {
            for (int i4 = 0; i4 < ItemKyGui.SHOP_KY_GUI.length; i4++)  {
                num += ItemKyGui.SHOP_KY_GUI[i4].size();
            }
        }
        return num;
    }
    
}
