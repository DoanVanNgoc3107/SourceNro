package dragon.t;

import dragon.server.MySQL;
import dragon.server.mResources;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class GiftCode {
    
    private static GiftCode in;
    
    public static GiftCode gI() {
        if (in == null) {
            in = new GiftCode();
        }
        return in;
    }
    
    public synchronized void inputCode(Char charz, String code) {
        try {
            if (!code.isEmpty()) {
                MySQL mySQL = MySQL.createData3();
                try {
                    mySQL.getConnection().setAutoCommit(false);
                    try {
                        ResultSet red = mySQL.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_GIFTCODE_FORMAT, Util.gI().stringSQL_LIKE(Util.gI().stringSQL(code))), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                        if (red.first()) {
                            //get value
                            JSONArray items = (JSONArray) JSONValue.parseWithException(red.getString(2));
                            JSONArray items0 = (JSONArray) JSONValue.parseWithException(red.getString(3));
                            JSONArray items1 = (JSONArray) JSONValue.parseWithException(red.getString(4));
                            JSONArray items2 = (JSONArray) JSONValue.parseWithException(red.getString(5));
                            int limit = red.getInt(6);
                            int type = red.getByte(7);
                            boolean isNew = red.getBoolean(8);
                            JSONArray users = (JSONArray) JSONValue.parseWithException(red.getString(9));
                            String str = red.getString("str");
                            String str2 = red.getString("str2");
                            //Check tui
                            if (items.size() + (charz.cgender == 0 ? items0.size() : charz.cgender == 1 ? items1.size() : charz.cgender == 2 ? items2.size(): 0) > charz.getEmptyBagCount()) {
                                charz.session.service.startOKDlg(String.format(mResources.GIFT_CODE_NHAN4, items.size() - charz.getEmptyBagCount()));
                            } else if (limit != -1 && limit <= users.size()){
                                charz.session.service.startOKDlg(mResources.GIFT_CODE_NHAN5);
                            } else if (type != 0 && users.contains(charz.session.userName)){ 
                                charz.session.service.startOKDlg(mResources.GIFT_CODE_NHAN6);
                            } else if (!str2.isEmpty() && ((str2.startsWith("isCan") && !charz.isCan()) || (str2.startsWith("setId") && !str2.contains(" "+charz.cName)))) {
                                charz.session.service.startOKDlg(mResources.GIFT_CODE_NHAN7);
                            } else {
                                users.add(charz.session.userName);
                                mySQL.getConnection().prepareStatement(String.format(mResources.UPDATE_GIFTCODE, Util.gI().stringSQL(users.toJSONString()), Util.gI().stringSQL_LIKE(code))).executeUpdate();
                                //add item to bag
                                String giftStr = new String();
                                for (int i = 0; i < items.size(); i++) {
                                    JSONArray item = (JSONArray) items.get(i);
                                    if ("item".equals(item.get(0).toString())) {
                                        Item gift = Item.parseItem(item.get(1).toString());
                                        charz.addItemBag(0, gift);
                                        giftStr += String.format(mResources.GIFT_CODE_NHAN2, Util.gI().numberTostring(gift.quantity), gift.template.name);
                                    }
                                }
                                //Theo hanh tinh
                                if (charz.cgender == 0) {
                                    for (int i = 0; i < items0.size(); i++) {
                                        JSONArray item0 = (JSONArray) items0.get(i);
                                        if ("item".equals(item0.get(0).toString())) {
                                            Item gift = Item.parseItem(item0.get(1).toString());
                                            charz.addItemBag(0, gift);
                                            giftStr += String.format(mResources.GIFT_CODE_NHAN2, Util.gI().numberTostring(gift.quantity), gift.template.name);
                                        }
                                    }
                                }
                                if (charz.cgender == 1) {
                                    for (int i = 0; i < items1.size(); i++) {
                                        JSONArray item1 = (JSONArray) items1.get(i);
                                        if ("item".equals(item1.get(0).toString())) {
                                            Item gift = Item.parseItem(item1.get(1).toString());
                                            charz.addItemBag(0, gift);
                                            giftStr += String.format(mResources.GIFT_CODE_NHAN2, Util.gI().numberTostring(gift.quantity), gift.template.name);
                                        }
                                    }
                                }
                                if (charz.cgender == 2) {
                                    for (int i = 0; i < items2.size(); i++) {
                                        JSONArray item2 = (JSONArray) items2.get(i);
                                        if ("item".equals(item2.get(0).toString())) {
                                            Item gift = Item.parseItem(item2.get(1).toString());
                                            charz.addItemBag(0, gift);
                                            giftStr += String.format(mResources.GIFT_CODE_NHAN2, Util.gI().numberTostring(gift.quantity), gift.template.name);
                                        }
                                    }
                                }
                                if (str.contains("#openmenu:")) {
                                    charz.resetMenu();
                                    charz.menuBoard.chat = str.replace("#openmenu:", "");
                                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                                    charz.menuBoard.openUIConfirm(5, null, null, -1);
                                } else {
                                    charz.resetMenu();
                                    charz.menuBoard.chat = String.format(mResources.GIFT_CODE_NHAN, giftStr);
                                    charz.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                                    charz.menuBoard.openUIConfirm(5, null, null, -1);
                                }
                            }
                        } else {
                            charz.session.service.startOKDlg(mResources.GIFT_CODE_NHAN3);
                        }
                        mySQL.getConnection().commit();
                    } catch (SQLException e) {
                        mySQL.getConnection().rollback();
                        e.printStackTrace();
                    }
                } finally {
                    mySQL.close();
                }
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
    
}
