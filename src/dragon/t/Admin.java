package dragon.t;

import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

/**
 *
 * @author Admin
 */
public class Admin {
    
    public static Admin instance;
    
    public static Admin gI() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }
    
    public void openAdmin(Char charz) {
        charz.clientInput.typeInput = -1;
        charz.resetMenu();
        charz.menuBoard.chat = "Chức năng dành cho Admin";
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Hệ thống", 1, charz));
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Chat vip", 2, charz));
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Người chơi", 3, charz));
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Vật phẩm", 4, charz));
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Boss", 5, charz));
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Log", 6, charz));
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("OpenSay", 7, charz));
        charz.menuBoard.arrMenu.add(new MenuInfoAdmin("OpenSay2", 19, charz));
        charz.menuBoard.openUIConfirm(5, null, null, -1);
    }
    
    public class MenuInfoAdmin extends MenuInfo {
        
        Char player;
        
        public MenuInfoAdmin(String str, int type, Char player) {
            super(str, type);
            this.player = player;
        }
        
        @Override
        public boolean execute() {
            Admin.gI().select(this.player, this);
            return false;
        }
        
    }
    
    public void select(Char charz, MenuInfo info) {
        System.out.println("AD_Player="+charz.cName+" AD_User="+charz.session.userName);
        switch (info.type) {
            case 1:
            {
                charz.resetMenu();
                charz.menuBoard.chat = "Một số chức năng hệ thống";
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Thống kê", 8, charz));
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Bảo trì", 9, charz));
                charz.menuBoard.openUIConfirm(5, null, null, -1);
                break;
            }
            case 2:
            {
                charz.session.service.openClientInput("Nhập chat vip", new String[] {""}, new int[] {1});
                break;
            }
            case 3:
            {
                charz.resetMenu();
                charz.menuBoard.chat = "Bạn có thể thực hiên một số chức năng với người chơi tại đây";
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Khóa vĩnh viễn", 10, charz));
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Khóa Chat", 11, charz));
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Tìm kiếm", 12, charz));
                charz.menuBoard.openUIConfirm(5, null, null, -1);
                break;
            }
            case 4:
            {
                charz.resetMenu();
                charz.menuBoard.chat = "Hãy lựa chọn kiểu gọi vật phẩm";
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Id vật phẩm\nsố lượng 1", 13, charz));
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Id vật phẩm\nNhập số lượng", 14, charz));
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Id vật phẩm\nkhác", 15, charz));
                charz.menuBoard.openUIConfirm(5, null, null, -1);
                break;
            }
            case 5:
            {
                charz.resetMenu();
                charz.menuBoard.chat = "Boss có thể xuất hiện như nào";
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Gọi BotId", 16, charz));
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Gọi Đầy Đủ", 17, charz));
                charz.menuBoard.arrMenu.add(new MenuInfoAdmin("Gọi Boss Tùy Ý", 18, charz));
                charz.menuBoard.openUIConfirm(5, null, null, -1);
                break;
            }
            case 6:
            {
                charz.session.service.openClientInput("Nhập log", new String[] {""}, new int[] {1});
                break;
            }
            case 7:
            {
                charz.session.service.openClientInput("Thông báo", new String[] {"NpcId (Có thể là 4)", "Nhập thông báo", "Avatar (Tùy ý)"}, new int[] {0, 1, 0});
                break;
            }
            case 8:
            {
                charz.session.service.openUISay(5, "LEVEL "+charz.clevel+" Tổng số kết nối:"+Server.gI().sizeConn()+" tổng online:"+Server.gI().sizeByUId()+" MapId="+charz.zoneMap.mapTemplate.mapTemplateId+" cx="+charz.cx+" cy="+charz.cy+" sizeMob="+charz.zoneMap.mobs.size()+" indexTile="+ (charz.cy / 24 * charz.zoneMap.mapTemplate.tmw + charz.cx / 24)+" sizeType="+ charz.zoneMap.mapTemplate.types.length, 1363);
                break;
            }
            case 9:
            {
                Server.start = false;
                break;
            }
            case 10:
            {
                charz.session.service.openClientInput("Tên nhân vật", new String[] {"Khóa vĩnh viễn"}, new int[] {1});
                break;
            }
            case 11:
            {
                charz.session.service.openClientInput("Tên nhân vật", new String[] {"Khóa chat thế giới"}, new int[] {1});
                break;
            }
            case 12:
            {
                charz.session.service.openClientInput("Tên nhân vật", new String[] {"Sẽ đưa bạn tới nhân vật này"}, new int[] {1});
                break;
            }
            case 13:
            {
                charz.session.service.openClientInput("Nhập thông tin vật phẩm", new String[] {"Id vật phẩm có số lượng là 1"}, new int[] {0});
                break;
            }
            case 14:
            {
                charz.session.service.openClientInput("Nhập thông tin vật phẩm", new String[] {"Id vật phẩm", "Số lượng"}, new int[] {0, 0});
                break;
            }
            case 15:
            {
                charz.session.service.openClientInput("Nhập thông tin vật phẩm", new String[] {"Id vật phẩm", "Số lượng", "trạng thái", "hành tinh"}, new int[] {0, 0, 0, 0});
                break;
            }
            case 16:
            {
                charz.session.service.openClientInput("Nhập Thông Tin Boss", new String[] {"botId", "Có báo KTG = 1"}, new int[] {0, 0});
                break;
            }
            case 17:
            {
                charz.session.service.openClientInput("Nhập Thông Tin Boss", new String[] {"botId", "Trạng thái PK", "HP", "Sát thương", "Tấn công = 1", "Có báo KTG = 1"}, new int[] {0, 0, 0, 0, 0, 0});
                break;
            }
            case 18:
            {
                charz.session.service.openClientInput("Nhập Thông Tin Boss", new String[] {"BotId", "Trạng thái PK", "Name HP ST", "Báo KTG = 1", "Head Body Leg"}, new int[] {0, 0, 1, 0, 1});
                break;
            }
            case 19:
            {
                charz.session.service.openClientInput("Thông báo", new String[] {"NpcId (Có thể là 4)", "Nhập thông báo", "Avatar (Tùy ý)", "P", "Caption"}, new int[] {0, 1, 0, 1, 1});
                break;
            }
        }
    }
    
    public void input(Char charz, String[] texts) {
        switch (charz.menuBoard.typeInfo) {
            case 2:
            {
                Server.gI().chatVip(texts[0]);
                break;
            }
            case 6:
            {
                Server.gI().log(texts[0]);
                break;
            }
            case 7:
            {
                Server.gI().openSay(Byte.parseByte(texts[0]), texts[1], Short.parseShort(texts[2]));
                break;
            }
            case 10:
            {
                Session_ME player = Server.gI().getByCName(texts[0]);
                if (player != null) {
                    player.isLock = 1;
                    player.disconnect();
                    charz.session.service.startOKDlg("Đã khóa thành công tài khoản nhân vật: "+texts[0]);
                } else {
                    charz.session.service.startOKDlg("Nhân vật không tồn tại hoặc chưa online.");
                }
                break;
            }
            case 11:
            {
                Session_ME player = Server.gI().getByCName(texts[0]);
                if (player != null) {
                    player.isLock = 2;
                    charz.session.service.startOKDlg("Đã khóa thành công tài khoản nhân vật: "+texts[0]);
                } else {
                    charz.session.service.startOKDlg("Nhân vật không tồn tại hoặc chưa online.");
                }
                break;
            }
            case 12:
            {
                Session_ME player = Server.gI().getByCName(texts[0]);
                if (player != null && player.myCharz().zoneMap != null) {
                    charz.zoneMap.exit(charz, 0);
                    player.myCharz().zoneMap.join(charz, 0, player.myCharz().cx, player.myCharz().cy);
                } else {
                    charz.session.service.startOKDlg("Nhân vật không tồn tại hoặc chưa online.");
                }
                break;
            }
            case 13:
            case 14:
            case 15:
            {
                int num = 1;
                int status = 0;
                int gender = charz.cgender;
                try {
                    num = Integer.parseInt(texts[1]);
                } catch (Exception e) {}
                try {
                    status = Byte.parseByte(texts[2]);
                } catch (Exception e) {}
                try {
                    gender = Byte.parseByte(texts[3]);
                } catch (Exception e) {}
                String[] numbers = texts[0].trim().split(" ");
                for (int i = 0; i < numbers.length; i++) {
                    Item it = new Item(Integer.parseInt(numbers[i]), false, num, ItemOption.getOption(Integer.parseInt(numbers[i]), status, gender), "", "", "");
                    if (it.isItemSLL()) {
                        it.quantity = 1;
                        it.getOption(31).param = num;
                    }
                    charz.addItemBag(0, it);
                }
                break;
            }
            case 16:
            {
                Player bot2 =  Player.addBoss(Short.parseShort(texts[0]), 5, -1, -1, true, charz.cx, charz.cy, charz.zoneMap, -1, -1);
                if (Byte.parseByte(texts[1]) == 1) {
                    Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot2.cName, charz.zoneMap.mapTemplate.mapName));
                }
                break;
            }
            case 17:
            {
                Player bot2 = Player.addBoss(Short.parseShort(texts[0]), Byte.parseByte(texts[1]), Integer.parseInt(texts[2]), Integer.parseInt(texts[3]), Integer.parseInt(texts[4]) != 0, charz.cx, charz.cy, charz.zoneMap, -1, -1);
                if (Byte.parseByte(texts[5]) == 1) {
                    Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot2.cName, charz.zoneMap.mapTemplate.mapName));
                }
                break;
            }
            case 18:
            {
                String[] arrStr = texts[2].split(" ");
                String[] arrStr2 = texts[4].split(" ");
                Char c = Player.addBoss(Short.parseShort(texts[0]), Byte.parseByte(texts[1]), Integer.parseInt(arrStr[arrStr.length - 2]), Integer.parseInt(arrStr[arrStr.length - 1]), true, charz.cx, charz.cy, null, -1, -1);
                c.cName = texts[2].replace(" "+arrStr[arrStr.length - 2]+" "+arrStr[arrStr.length - 1], "");
                c.head = c.headDefault = Short.parseShort(arrStr2[0]);
                c.body = c.bodyDefault = Short.parseShort(arrStr2[1]);
                c.leg = c.legDefault = Short.parseShort(arrStr2[2]);
                charz.zoneMap.join(c, 0, -1, -1);
                if (Byte.parseByte(texts[3]) == 1) {
                    Server.gI().chatVip(String.format(mResources.BOSS_HAVE, c.cName, charz.zoneMap.mapTemplate.mapName));
                }
                break;
            }
            case 19:
            {
                Server.gI().bigMessage2(Byte.parseByte(texts[0]), texts[1], texts[3], Short.parseShort(texts[2]), texts[4]);
                break;
            }
        }
    }
    
}
