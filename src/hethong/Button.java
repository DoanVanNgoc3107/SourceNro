package hethong;

import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.t.GameData;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author TGDD
 */
public class Button extends JButton {

    public int action;

    public Button(int action) {
        super.addActionListener(this::actionPerformed);
        this.action = action;
    }

    public void actionPerformed(ActionEvent e) {
        switch (this.action) {
            case 0:
            {
                if (dragon.server.Server.start) {
                    // Server đang chạy -> Bảo trì với countdown 5 giây
                    ServerActivity.gI().setText("Bat dau bao tri sau 5 giay...");
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                for (int i = 5; i > 0; i--) {
                                    Server.gI().chatVip("[BAO TRI] Server se bao tri sau " + i + " giay! Vui long thoat game!");
                                    Thread.sleep(1000);
                                }
                                Server.gI().saveData();
                                Session_ME[] array;
                                synchronized(Server.gI().connList) {
                                    array = new Session_ME[Server.gI().connList.size()];
                                    for (int j = 0; j < Server.gI().connList.size(); j++) {
                                        array[j] = Server.gI().connList.get(j);
                                    }
                                }
                                for (int j = 0; j < array.length; j++) {
                                    if (array[j] != null) {
                                        array[j].close();
                                    }
                                }
                                Server.start = false;
                                ServerActivity.gI().setText("Server DA BAO TRI!");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }.start();
                } else {
                    // Server đang bảo trì -> Bật lại
                    Server.start = true;
                    ServerActivity.gI().setText("Server DA HOAT DONG TRO LAI!");
                }
                break;
            }
            case 1:
            {
                ServerActivity.gI().isStart = false;
                ServerActivity.gI().mainFrame.dispose();
                break;
            }
            case 2:
            {
                if (dragon.server.Server.isGoKN) {
                    dragon.server.Server.isGoKN = false;
                    ServerActivity.gI().setText("Tạm ngừng cho kết nối");
                } else {
                    dragon.server.Server.isGoKN = true;
                    ServerActivity.gI().setText("Đã bật cho kết nối");
                }
                break;
            }
            case 3:
            {
                ServerActivity.gI().getInfoServer();
                break;
            }
            case 4:
            {
                ServerActivity.gI().getStay();
                break;
            }
            case 5:
            {
                Session_ME[] array;
                synchronized(Server.gI().connList) {
                    array = new Session_ME[Server.gI().connList.size()];
                    for (int i = 0; i < Server.gI().connList.size(); i++) {
                        if ((System.currentTimeMillis() - Server.gI().connList.get(i).l) > 10000L) {
                            array[i] = Server.gI().connList.get(i);
                        }
                    }
                }
                for (int i2 = 0; i2 < array.length; i2++) {
                    if (array[i2] != null) {
                        array[i2].close();
                    }
                }
                break;
            }
            case 6:
            {
                Server.gI().isAutoSave = !Server.gI().isAutoSave;
                break;
            }
            case 7:
            {
                ServerActivity.gI().actionSet++;
                if (ServerActivity.gI().actionSet > 2) {
                    ServerActivity.gI().actionSet = 0;
                }
                break;
            }
            case 8:
            {
                if (ServerActivity.gI().actionSet == 0) {
                    Server.gI().setSave += 1000;
                }
                if (ServerActivity.gI().actionSet == 1) {
                    Server.gI().setSave += 60000;
                }
                if (ServerActivity.gI().actionSet == 2) {
                    Server.gI().setSave += 3600000;
                }
                break;
            }
            case 9:
            {
                if (ServerActivity.gI().actionSet == 0) {
                    Server.gI().setSave -= 1000;
                }
                if (ServerActivity.gI().actionSet == 1) {
                    Server.gI().setSave -= 60000;
                }
                if (ServerActivity.gI().actionSet == 2) {
                    Server.gI().setSave -= 3600000;
                }
                break;
            }
            case 10:
            {
                ServerActivity.gI().setText("Đang lưu...");
                Server.gI().saveData();
                ServerActivity.gI().setText("Đã lưu thành công");
                break;
            }
            case 11:
            {
                ServerActivity.gI().setText("Đang tải lại data...");
                GameData.init();
                ServerActivity.gI().setText("Đã tải thành công");
                break;
            }
            case 12:
            {
                String input = "";
                try {
                    if (ServerActivity.gI().getTextBox(0) != null) {
                        input = ServerActivity.gI().getTextBox(0).getText();
                    }
                } catch (Exception ignore) {
                }
                if (input != null) {
                    input = input.trim();
                }
                int idx = -1;
                try {
                    idx = Integer.parseInt(input);
                } catch (Exception ex) {
                    ServerActivity.gI().setText("Lỗi: vui lòng nhập số hợp lệ");
                    break;
                }
                switch (idx) {
                    case 1:
                        dragon.server.Server.gI().addPhatQua();
                        ServerActivity.gI().setText("Đã mở sự kiện: Phát quà");
                        break;
                    case 2:
                        dragon.server.Server.gI().openButcher();
                        ServerActivity.gI().setText("Đã mở sự kiện: Butcher");
                        break;
                    case 3:
                        dragon.server.Server.gI().openBigBoss();
                        ServerActivity.gI().setText("Đã mở sự kiện: BigBoss");
                        break;
                    case 4:
                        dragon.server.Server.gI().openMabu();
                        ServerActivity.gI().setText("Đã mở sự kiện: Mabu");
                        break;
                    case 5:
                        dragon.server.Server.gI().openCace23();
                        ServerActivity.gI().setText("Đã mở sự kiện: Cace23");
                        break;
                    case 6:
                        dragon.t.BlackBall.gI().openBlackBall();
                        ServerActivity.gI().setText("Đã mở sự kiện: BlackBall");
                        break;
                    case 7:
                        dragon.t.RongVoCuc.gI().openRongVoCuc();
                        ServerActivity.gI().setText("Đã mở sự kiện: Rồng Vô Cực");
                        break;
                    case 8:
                        // Đại Hội Võ Thuật - mở giải Ngoại Hạng (type 5)
                        dragon.t.DaiHoi.createPrize(5);
                        ServerActivity.gI().setText("Đã mở sự kiện: Đại Hội Võ Thuật - Ngoại Hạng");
                        break;
                    case 9:
                        // Vòng Quay May Mắn - thông báo hướng dẫn
                        ServerActivity.gI().setText("Vòng Quay May Mắn tự động bắt đầu khi có người tham gia");
                        break;
                    default:
                        ServerActivity.gI().setText("Số sự kiện không hợp lệ (1-9)");
                        break;
                }
                // Ẩn textbox và nút khi xong (giữ component nhưng đặt kích thước bằng 0 để ẩn)
                try {
                    if (ServerActivity.gI().getTextBox(0) != null) {
                        ServerActivity.gI().getTextBox(0).setBounds(0, 0, 0, 0);
                    }
                    if (ServerActivity.gI().getButton(12) != null) {
                        ServerActivity.gI().getButton(12).setBounds(0, 0, 0, 0);
                    }
                    if (ServerActivity.gI().getButton(13) != null) {
                        ServerActivity.gI().getButton(13).setBounds(0, 0, 0, 0);
                    }
                } catch (Exception ignore) {
                }
                ServerActivity.gI().isMenu = false;
                break;
            }
            case 13:
            {
                // Đóng menu sự kiện
                try {
                    if (ServerActivity.gI().getTextBox(0) != null) {
                        ServerActivity.gI().getTextBox(0).setBounds(0, 0, 0, 0);
                    }
                    if (ServerActivity.gI().getButton(12) != null) {
                        ServerActivity.gI().getButton(12).setBounds(0, 0, 0, 0);
                    }
                    if (ServerActivity.gI().getButton(13) != null) {
                        ServerActivity.gI().getButton(13).setBounds(0, 0, 0, 0);
                    }
                } catch (Exception ignore) {
                }
                ServerActivity.gI().setText("");
                ServerActivity.gI().isMenu = false;
                break;
            }
            case 14:
            {
                if (Server.gI().timeBaoTri != -1) {
                    Server.gI().timeBaoTri = -1;
                } else {
                    Server.gI().timeBaoTri = 1800000;
                }
                break;
            }
            case 15:
            {
                // Mở menu sự kiện
                ServerActivity.gI().openTextBox();
                break;
            }
            case 16:
            {
                // Mở menu quản lý player
                ServerActivity.gI().openPlayerMenu();
                break;
            }
            case 17:
            {
                // Mở menu gửi thông báo
                ServerActivity.gI().openNotifyMenu();
                break;
            }
            case 18:
            {
                // Mở menu tắt sự kiện
                ServerActivity.gI().openCloseEventMenu();
                break;
            }
            case 19:
            {
                // Xem sự kiện đang chạy
                ServerActivity.gI().showActiveEvents();
                break;
            }
            case 20:
            {
                // Kick all players
                int count = 0;
                dragon.server.Session_ME[] array;
                synchronized(Server.gI().connList) {
                    array = new dragon.server.Session_ME[Server.gI().connList.size()];
                    for (int i = 0; i < Server.gI().connList.size(); i++) {
                        array[i] = Server.gI().connList.get(i);
                    }
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] != null) {
                        array[i].close();
                        count++;
                    }
                }
                ServerActivity.gI().setText("Đã kick " + count + " kết nối");
                break;
            }
            case 21:
            {
                // Mở menu chat thế giới
                ServerActivity.gI().openChatWorldMenu();
                break;
            }
            case 22:
            {
                // Xử lý lệnh quản lý player
                String input = "";
                try {
                    if (ServerActivity.gI().getTextBox(0) != null) {
                        input = ServerActivity.gI().getTextBox(0).getText().trim();
                    }
                } catch (Exception ignore) {}

                if (input.isEmpty()) {
                    ServerActivity.gI().setText("Vui lòng nhập lệnh!");
                    break;
                }

                String[] parts = input.split(":");
                if (parts.length < 2) {
                    ServerActivity.gI().setText("Sai format! VD: kick:TenNhanVat");
                    break;
                }

                String cmd = parts[0].toLowerCase();
                String playerName = parts[1];

                switch (cmd) {
                    case "kick":
                        dragon.server.Session_ME session = Server.gI().getByCName(playerName);
                        if (session != null) {
                            session.close();
                            ServerActivity.gI().setText("Đã kick player: " + playerName);
                        } else {
                            ServerActivity.gI().setText("Không tìm thấy player: " + playerName);
                        }
                        break;
                    case "find":
                        dragon.server.Session_ME s = Server.gI().getByCName(playerName);
                        if (s != null && s.myCharz() != null) {
                            StringBuilder info = new StringBuilder();
                            info.append("=== THÔNG TIN PLAYER ===\n");
                            info.append("Tên: " + s.myCharz().cName + "\n");
                            info.append("Sức mạnh: " + s.myCharz().cPower + "\n");
                            info.append("Level: " + s.myCharz().clevel + "\n");
                            info.append("Vàng (xu): " + s.myCharz().xu + "\n");
                            info.append("Lượng: " + s.myCharz().luong + "\n");
                            info.append("Lượng khóa: " + s.myCharz().luongKhoa + "\n");
                            info.append("Map: " + (s.myCharz().zoneMap != null ? s.myCharz().zoneMap.mapTemplate.mapName : "N/A") + "\n");
                            info.append("HP: " + s.myCharz().cHP + "/" + s.myCharz().cHPFull + "\n");
                            ServerActivity.gI().setText(info.toString());
                        } else {
                            ServerActivity.gI().setText("Không tìm thấy player: " + playerName);
                        }
                        break;
                    case "addgold":
                    case "addvang":
                    case "addxu":
                        if (parts.length >= 3) {
                            try {
                                long amount = Long.parseLong(parts[2]);
                                dragon.server.Session_ME ss = Server.gI().getByCName(playerName);
                                if (ss != null && ss.myCharz() != null) {
                                    ss.myCharz().updateXu(amount, 1);
                                    ServerActivity.gI().setText("Đã thêm " + amount + " vàng cho " + playerName);
                                } else {
                                    ServerActivity.gI().setText("Không tìm thấy player: " + playerName);
                                }
                            } catch (Exception ex) {
                                ServerActivity.gI().setText("Số lượng không hợp lệ!");
                            }
                        } else {
                            ServerActivity.gI().setText("Sai format! VD: addgold:TenNV:1000000");
                        }
                        break;
                    case "addluong":
                        if (parts.length >= 3) {
                            try {
                                int amount = Integer.parseInt(parts[2]);
                                dragon.server.Session_ME ss = Server.gI().getByCName(playerName);
                                if (ss != null && ss.myCharz() != null) {
                                    ss.myCharz().updateLuong(amount, 1);
                                    ServerActivity.gI().setText("Đã thêm " + amount + " lượng cho " + playerName);
                                } else {
                                    ServerActivity.gI().setText("Không tìm thấy player: " + playerName);
                                }
                            } catch (Exception ex) {
                                ServerActivity.gI().setText("Số lượng không hợp lệ!");
                            }
                        } else {
                            ServerActivity.gI().setText("Sai format! VD: addluong:TenNV:1000");
                        }
                        break;
                    default:
                        ServerActivity.gI().setText("Lệnh không hợp lệ: " + cmd);
                }
                ServerActivity.gI().hideInputControls();
                ServerActivity.gI().isMenu = false;
                break;
            }
            case 23:
            {
                // Xử lý gửi thông báo
                String input = "";
                try {
                    if (ServerActivity.gI().getTextBox(0) != null) {
                        input = ServerActivity.gI().getTextBox(0).getText().trim();
                    }
                } catch (Exception ignore) {}

                if (input.isEmpty()) {
                    ServerActivity.gI().setText("Vui lòng nhập thông báo!");
                    break;
                }

                String[] parts = input.split(":", 2);
                if (parts.length < 2) {
                    ServerActivity.gI().setText("Sai format! VD: 1:Nội dung thông báo");
                    break;
                }

                try {
                    int type = Integer.parseInt(parts[0]);
                    String content = parts[1];

                    switch (type) {
                        case 1:
                            // Chat thế giới
                            Server.gI().chatInfo("[ADMIN] " + content);
                            ServerActivity.gI().setText("Đã gửi chat thế giới: " + content);
                            break;
                        case 2:
                            // Thông báo hệ thống
                            Server.gI().chatVip(content);
                            ServerActivity.gI().setText("Đã gửi thông báo VIP: " + content);
                            break;
                        case 3:
                            // Big message: npcId|text|avatar
                            String[] msgParts = content.split("\\|");
                            if (msgParts.length >= 3) {
                                int npcId = Integer.parseInt(msgParts[0]);
                                String text = msgParts[1];
                                int avatar = Integer.parseInt(msgParts[2]);
                                Server.gI().openSay(npcId, text, avatar);
                                ServerActivity.gI().setText("Đã gửi Big Message");
                            } else {
                                ServerActivity.gI().setText("Sai format Big Message!");
                            }
                            break;
                        default:
                            ServerActivity.gI().setText("Loại thông báo không hợp lệ (1-3)");
                    }
                } catch (Exception ex) {
                    ServerActivity.gI().setText("Lỗi: " + ex.getMessage());
                }
                ServerActivity.gI().hideInputControls();
                ServerActivity.gI().isMenu = false;
                break;
            }
            case 24:
            {
                // Xử lý tắt sự kiện
                String input = "";
                try {
                    if (ServerActivity.gI().getTextBox(0) != null) {
                        input = ServerActivity.gI().getTextBox(0).getText().trim();
                    }
                } catch (Exception ignore) {}

                int idx = -1;
                try {
                    idx = Integer.parseInt(input);
                } catch (Exception ex) {
                    ServerActivity.gI().setText("Vui lòng nhập số!");
                    break;
                }

                switch (idx) {
                    case 0:
                        // Tắt tất cả
                        Server.gI().closeButcher();
                        Server.gI().closeBigBoss();
                        Server.gI().closeMabu();
                        Server.gI().closeCace23();
                        dragon.t.BlackBall.gI().closeBlackBall();
                        dragon.t.RongVoCuc.gI().closeRongVoCuc();
                        ServerActivity.gI().setText("Đã tắt TẤT CẢ sự kiện!");
                        break;
                    case 1:
                        Server.gI().closeButcher();
                        ServerActivity.gI().setText("Đã tắt sự kiện Butcher");
                        break;
                    case 2:
                        Server.gI().closeBigBoss();
                        ServerActivity.gI().setText("Đã tắt sự kiện BigBoss");
                        break;
                    case 3:
                        Server.gI().closeMabu();
                        ServerActivity.gI().setText("Đã tắt sự kiện Mabu");
                        break;
                    case 4:
                        dragon.t.BlackBall.gI().closeBlackBall();
                        ServerActivity.gI().setText("Đã tắt sự kiện BlackBall");
                        break;
                    case 5:
                        dragon.t.RongVoCuc.gI().closeRongVoCuc();
                        ServerActivity.gI().setText("Đã tắt sự kiện Rồng Vô Cực");
                        break;
                    case 6:
                        Server.gI().closeCace23();
                        ServerActivity.gI().setText("Đã tắt sự kiện Cace23");
                        break;
                    default:
                        ServerActivity.gI().setText("Số không hợp lệ (0-6)");
                }
                ServerActivity.gI().hideInputControls();
                ServerActivity.gI().isMenu = false;
                break;
            }
            case 25:
            {
                // Xử lý chat thế giới nhanh
                String input = "";
                try {
                    if (ServerActivity.gI().getTextBox(0) != null) {
                        input = ServerActivity.gI().getTextBox(0).getText().trim();
                    }
                } catch (Exception ignore) {}

                if (!input.isEmpty()) {
                    Server.gI().chatInfo("[ADMIN] " + input);
                    ServerActivity.gI().setText("Đã gửi: " + input);
                } else {
                    ServerActivity.gI().setText("Vui lòng nhập nội dung chat!");
                }
                ServerActivity.gI().hideInputControls();
                ServerActivity.gI().isMenu = false;
                break;
            }

            // ============= NEW DASHBOARD ACTIONS =============

            // Event Actions (101-110)
            case 101: // Phat Qua
            {
                Server.gI().addPhatQua();
                ServerActivity.gI().addLog("[OK] Da mo su kien: Phat qua");
                break;
            }
            case 102: // Butcher
            {
                Server.gI().openButcher();
                ServerActivity.gI().addLog("[OK] Da mo su kien: Butcher");
                break;
            }
            case 103: // BigBoss
            {
                Server.gI().openBigBoss();
                ServerActivity.gI().addLog("[OK] Da mo su kien: BigBoss");
                break;
            }
            case 104: // Mabu
            {
                Server.gI().openMabu();
                ServerActivity.gI().addLog("[OK] Da mo su kien: Mabu");
                break;
            }
            case 105: // Cace23
            {
                Server.gI().openCace23();
                ServerActivity.gI().addLog("[OK] Da mo su kien: Cace23");
                break;
            }
            case 106: // BlackBall
            {
                dragon.t.BlackBall.gI().openBlackBall();
                ServerActivity.gI().addLog("[OK] Da mo su kien: BlackBall");
                break;
            }
            case 107: // Rong Vo Cuc
            {
                dragon.t.RongVoCuc.gI().openRongVoCuc();
                ServerActivity.gI().addLog("[OK] Da mo su kien: Rong Vo Cuc");
                break;
            }
            case 108: // Dai Hoi
            {
                dragon.t.DaiHoi.createPrize(5);
                ServerActivity.gI().addLog("[OK] Da mo su kien: Dai Hoi Ngoai Hang");
                break;
            }
            case 109: // Vong Quay
            {
                ServerActivity.gI().addLog("[INFO] Vong Quay tu dong bat dau khi co nguoi tham gia");
                break;
            }
            case 110: // Tat tat ca su kien
            {
                ServerActivity.gI().closeAllEvents();
                break;
            }

            // Control Actions (201-212)
            case 201: // Save Data
            {
                ServerActivity.gI().addLog("[INFO] Dang luu data...");
                Server.gI().saveData();
                ServerActivity.gI().addLog("[OK] Da luu thanh cong!");
                break;
            }
            case 202: // Reset Data
            {
                ServerActivity.gI().addLog("[INFO] Dang tai lai data...");
                GameData.init();
                ServerActivity.gI().addLog("[OK] Da tai lai thanh cong!");
                break;
            }
            case 203: // Ket noi ON/OFF
            {
                if (dragon.server.Server.isGoKN) {
                    dragon.server.Server.isGoKN = false;
                    ServerActivity.gI().addLog("[WARN] Tam ngung cho ket noi!");
                } else {
                    dragon.server.Server.isGoKN = true;
                    ServerActivity.gI().addLog("[OK] Da bat cho ket noi!");
                }
                break;
            }
            case 204: // Bao tri
            {
                if (dragon.server.Server.start) {
                    // Server đang chạy -> Bảo trì với countdown 5 giây
                    ServerActivity.gI().addLog("[WARN] Bat dau bao tri sau 5 giay...");
                    new Thread() {
                        @Override
                        public void run() {
                            try {
                                // Thông báo countdown trong game
                                for (int i = 5; i > 0; i--) {
                                    Server.gI().chatVip("[BAO TRI] Server se bao tri sau " + i + " giay! Vui long thoat game!");
                                    ServerActivity.gI().addLog("[WARN] Bao tri sau " + i + " giay...");
                                    Thread.sleep(1000);
                                }
                                // Lưu data trước khi bảo trì
                                ServerActivity.gI().addLog("[INFO] Dang luu data truoc khi bao tri...");
                                Server.gI().saveData();
                                ServerActivity.gI().addLog("[OK] Da luu data thanh cong!");

                                // Kick all players
                                Session_ME[] array;
                                synchronized(Server.gI().connList) {
                                    array = new Session_ME[Server.gI().connList.size()];
                                    for (int j = 0; j < Server.gI().connList.size(); j++) {
                                        array[j] = Server.gI().connList.get(j);
                                    }
                                }
                                for (int j = 0; j < array.length; j++) {
                                    if (array[j] != null) {
                                        array[j].close();
                                    }
                                }

                                // Bảo trì server
                                Server.start = false;
                                ServerActivity.gI().addLog("[WARN] Server DA BAO TRI!");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }.start();
                } else {
                    // Server đang bảo trì -> Bật lại
                    Server.start = true;
                    ServerActivity.gI().addLog("[OK] Server DA HOAT DONG TRO LAI!");
                    Server.gI().chatVip("[THONG BAO] Server da hoat dong tro lai! Chao mung cac ban!");
                }
                break;
            }
            case 205: // Bao tri 30p
            {
                if (Server.gI().timeBaoTri != -1) {
                    Server.gI().timeBaoTri = -1;
                    ServerActivity.gI().addLog("[OK] Da huy hen gio bao tri");
                } else {
                    Server.gI().timeBaoTri = 1800000;
                    ServerActivity.gI().addLog("[WARN] Da hen bao tri sau 30 phut!");
                }
                break;
            }
            case 206: // Thong ke
            {
                ServerActivity.gI().getInfoServer();
                break;
            }
            case 207: // Kick Ket
            {
                Session_ME[] array;
                int count = 0;
                synchronized(Server.gI().connList) {
                    array = new Session_ME[Server.gI().connList.size()];
                    for (int i = 0; i < Server.gI().connList.size(); i++) {
                        if ((System.currentTimeMillis() - Server.gI().connList.get(i).l) > 10000L) {
                            array[i] = Server.gI().connList.get(i);
                        }
                    }
                }
                for (int i2 = 0; i2 < array.length; i2++) {
                    if (array[i2] != null) {
                        array[i2].close();
                        count++;
                    }
                }
                ServerActivity.gI().addLog("[OK] Da kick " + count + " ket noi bi ket");
                break;
            }
            case 208: // Kick All
            {
                int count = 0;
                Session_ME[] array;
                synchronized(Server.gI().connList) {
                    array = new Session_ME[Server.gI().connList.size()];
                    for (int i = 0; i < Server.gI().connList.size(); i++) {
                        array[i] = Server.gI().connList.get(i);
                    }
                }
                for (int i = 0; i < array.length; i++) {
                    if (array[i] != null) {
                        array[i].close();
                        count++;
                    }
                }
                ServerActivity.gI().addLog("[OK] Da kick " + count + " ket noi");
                break;
            }
            case 209: // Quan ly Player
            {
                ServerActivity.gI().openPlayerMenu();
                break;
            }
            case 210: // Thong bao
            {
                ServerActivity.gI().openNotifyMenu();
                break;
            }
            case 211: // Chat The Gioi
            {
                ServerActivity.gI().openChatWorldMenu();
                break;
            }
            case 212: // An Panel
            {
                ServerActivity.gI().isStart = false;
                ServerActivity.gI().mainFrame.dispose();
                break;
            }
            case 213: // Gui Item vao Ruong Do
            {
                ServerActivity.gI().openSendItemMenu();
                break;
            }
            case 214: // Xoa Item trong Tui/Ruong
            {
                ServerActivity.gI().openDeleteItemMenu();
                break;
            }
        }
    }

}