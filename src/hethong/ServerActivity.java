package hethong;

import dragon.t.BWar;
import dragon.t.Clan;
import dragon.t.ItemKyGui;
import dragon.t.LuckyRoundNew;
import dragon.t.Map;
import dragon.server.Server;
import dragon.server.Session_ME;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import dragon.t.Player;
import dragon.t.Util;
import dragon.t.mLog;

/**
 * Admin Dashboard - Dragon Server
 * @author TGDD - Redesigned
 */
public class ServerActivity {

    private final int WIDTH = 1000;
    private final int HEIGHT = 700;
    private final String NAME = "ADMIN DASHBOARD";
    public int menuType = 0;

    public JFrame mainFrame;
    private final ArrayList<JLabel> TEXTS = new ArrayList<>();
    private final ArrayList<Button> BUTTONS = new ArrayList<>();
    private final ArrayList<TextBox> TEXTBOXS = new ArrayList<>();
    public boolean isStart;
    public boolean isMenu;

    // Panels
    private JPanel panelServerInfo;
    private JPanel panelEvents;
    private JPanel panelControls;
    private JPanel panelQuickActions;
    private JPanel panelLog;
    private JTextArea logArea;
    private JTextField inputField;

    // Labels for live update
    private JLabel lblOnline;
    private JLabel lblConnections;
    private JLabel lblMaps;
    private JLabel lblClans;
    private JLabel lblThreads;
    private JLabel lblDelay;
    private JLabel lblUptime;
    private JLabel lblBots;
    private JLabel lblMemory;
    private JLabel lblServerStatus;
    private JTextArea eventStatusArea;

    private final Thread thr = new Thread() {
        @Override
        public void run() {
            while(isStart) {
                updateDashboard();
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public int actionSet;

    private static ServerActivity instance;

    public static ServerActivity gI() {
        if (instance == null) {
            instance = new ServerActivity();
            instance.mainFrame = new JFrame();
        }
        return instance;
    }

    public void Activity() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        this.mainFrame.setTitle(NAME);
        this.mainFrame.setSize(this.WIDTH, this.HEIGHT);
        this.mainFrame.setLayout(new BorderLayout(5, 5));
        this.mainFrame.getContentPane().setBackground(new Color(45, 45, 48));

        try {
            this.mainFrame.setIconImage(new ImageIcon("icon.png").getImage());
        } catch (Exception e) {
            mLog.log("Thieu icon.png");
        }

        this.mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        initUI();
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setVisible(true);
        this.isStart = true;
        this.thr.start();
    }

    private void initUI() {
        // Main container
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(new Color(45, 45, 48));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Top Panel - Server Info
        panelServerInfo = createServerInfoPanel();

        // Center Panel - Main Content
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        centerPanel.setBackground(new Color(45, 45, 48));

        // Left - Events Panel
        panelEvents = createEventsPanel();
        centerPanel.add(panelEvents);

        // Right - Controls Panel
        panelControls = createControlsPanel();
        centerPanel.add(panelControls);

        // Bottom Panel - Quick Actions & Log
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBackground(new Color(45, 45, 48));

        panelQuickActions = createQuickActionsPanel();
        panelLog = createLogPanel();

        bottomPanel.add(panelQuickActions, BorderLayout.NORTH);
        bottomPanel.add(panelLog, BorderLayout.CENTER);

        mainPanel.add(panelServerInfo, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        this.mainFrame.add(mainPanel);
    }

    private JPanel createServerInfoPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 5, 10, 5));
        panel.setBackground(new Color(60, 60, 65));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 150, 136), 2),
                " SERVER STATUS ", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14), new Color(0, 200, 180)
        ));

        lblServerStatus = createInfoLabel("RUNNING", new Color(76, 175, 80));
        lblOnline = createInfoLabel("Online: 0", Color.WHITE);
        lblConnections = createInfoLabel("Ket noi: 0", Color.WHITE);
        lblMaps = createInfoLabel("Maps: 0", Color.WHITE);
        lblClans = createInfoLabel("Clans: 0", Color.WHITE);
        lblThreads = createInfoLabel("Threads: 0", Color.WHITE);
        lblDelay = createInfoLabel("Delay: 0ms", Color.WHITE);
        lblUptime = createInfoLabel("Uptime: 0s", Color.WHITE);
        lblBots = createInfoLabel("Bots: 0", Color.WHITE);
        lblMemory = createInfoLabel("RAM: 0MB", Color.WHITE);

        panel.add(lblServerStatus);
        panel.add(lblOnline);
        panel.add(lblConnections);
        panel.add(lblMaps);
        panel.add(lblClans);
        panel.add(lblThreads);
        panel.add(lblDelay);
        panel.add(lblUptime);
        panel.add(lblBots);
        panel.add(lblMemory);

        return panel;
    }

    private JPanel createEventsPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(new Color(60, 60, 65));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(255, 152, 0), 2),
                " QUAN LY SU KIEN ", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14), new Color(255, 180, 0)
        ));

        JPanel btnPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        btnPanel.setBackground(new Color(60, 60, 65));

        // Event buttons
        addStyledButton(btnPanel, 101, "Phat Qua", new Color(76, 175, 80));
        addStyledButton(btnPanel, 102, "Butcher", new Color(244, 67, 54));
        addStyledButton(btnPanel, 103, "BigBoss", new Color(156, 39, 176));
        addStyledButton(btnPanel, 104, "Mabu", new Color(103, 58, 183));
        addStyledButton(btnPanel, 105, "Cace23", new Color(63, 81, 181));
        addStyledButton(btnPanel, 106, "BlackBall", new Color(33, 33, 33));
        // addStyledButton(btnPanel, 107, "Rong Vo Cuc", new Color(255, 193, 7));
        addStyledButton(btnPanel, 108, "Dai Hoi", new Color(0, 150, 136));
        addStyledButton(btnPanel, 109, "Vong Quay", new Color(233, 30, 99));
        addStyledButton(btnPanel, 110, "TAT TAT CA", new Color(183, 28, 28));

        panel.add(btnPanel, BorderLayout.CENTER);

        // Event status panel
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBackground(new Color(50, 50, 55));
        statusPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Sự kiện đang diễn ra", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.PLAIN, 11), Color.LIGHT_GRAY
        ));

        eventStatusArea = new JTextArea(4, 20);
        eventStatusArea.setEditable(false);
        eventStatusArea.setBackground(new Color(40, 40, 45));
        eventStatusArea.setForeground(new Color(0, 255, 128));
        eventStatusArea.setFont(new Font("Consolas", Font.PLAIN, 11));
        eventStatusArea.setText(getActiveEvents());

        statusPanel.add(new JScrollPane(eventStatusArea), BorderLayout.CENTER);
        panel.add(statusPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createControlsPanel() {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(new Color(60, 60, 65));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(33, 150, 243), 2),
                " DIEU KHIEN SERVER ", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 14), new Color(100, 180, 255)
        ));

        JPanel btnPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        btnPanel.setBackground(new Color(60, 60, 65));

        // Control buttons
        addStyledButton(btnPanel, 201, "Lưu dữ liệu", new Color(76, 175, 80));
        addStyledButton(btnPanel, 202, "Đặt lại dữ liệu", new Color(255, 152, 0));
        addStyledButton(btnPanel, 203, "Kết nối server", new Color(33, 150, 243));
        addStyledButton(btnPanel, 204, "Bảo trì", new Color(244, 67, 54));
        addStyledButton(btnPanel, 205, "Bảo trì 30p", new Color(255, 87, 34));
        addStyledButton(btnPanel, 206, "Thống kê", new Color(0, 150, 136));
        addStyledButton(btnPanel, 207, "Kick hết", new Color(156, 39, 176));
        addStyledButton(btnPanel, 208, "Kick All", new Color(183, 28, 28));
        addStyledButton(btnPanel, 209, "Quản lý Player", new Color(63, 81, 181));
        addStyledButton(btnPanel, 210, "Thông báo", new Color(0, 188, 212));
        addStyledButton(btnPanel, 211, "Chat Thế Giới", new Color(139, 195, 74));
        addStyledButton(btnPanel, 213, "Gửi Item", new Color(255, 193, 7));

        panel.add(btnPanel, BorderLayout.CENTER);

        // Auto save panel
        JPanel autoSavePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        autoSavePanel.setBackground(new Color(50, 50, 55));
        autoSavePanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                "Auto Save", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.PLAIN, 11), Color.LIGHT_GRAY
        ));

        addStyledButton(autoSavePanel, 6, "Auto Save", new Color(76, 175, 80));
        addStyledButton(autoSavePanel, 8, "+", new Color(33, 150, 243));
        addStyledButton(autoSavePanel, 9, "-", new Color(244, 67, 54));
        addStyledButton(autoSavePanel, 7, "Time: 0s", new Color(100, 100, 100));

        panel.add(autoSavePanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createQuickActionsPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panel.setBackground(new Color(55, 55, 60));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(233, 30, 99), 2),
                " QUICK ACTIONS ", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12), new Color(255, 100, 150)
        ));

        // Input field
        inputField = new JTextField(30);
        inputField.setBackground(new Color(40, 40, 45));
        inputField.setForeground(Color.WHITE);
        inputField.setCaretColor(Color.WHITE);
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(100, 100, 100)),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        inputField.setToolTipText("Nhập lệnh: kick:name | find:name | addgold:name:amount | senditem:name:itemid:quantity | chat:message");

        JButton btnExecute = createStyledButtonObj("Thực hiện", new Color(76, 175, 80));
        btnExecute.addActionListener(e -> executeQuickCommand(inputField.getText()));

        JButton btnClear = createStyledButtonObj("Xóa", new Color(158, 158, 158));
        btnClear.addActionListener(e -> inputField.setText(""));

        JLabel lblCmd = new JLabel("Lệnh: ");
        lblCmd.setForeground(Color.WHITE);
        panel.add(lblCmd);
        panel.add(inputField);
        panel.add(btnExecute);
        panel.add(btnClear);

        return panel;
    }

    private JPanel createLogPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(40, 40, 45));
        panel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(100, 100, 100)),
                " LOG & OUTPUT ", TitledBorder.LEFT, TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12), Color.LIGHT_GRAY
        ));
        panel.setPreferredSize(new Dimension(0, 120));

        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setBackground(new Color(30, 30, 35));
        logArea.setForeground(new Color(0, 255, 128));
        logArea.setFont(new Font("Consolas", Font.PLAIN, 12));
        logArea.setText("Server Dashboard đã khởi động...\n");

        JScrollPane scrollPane = new JScrollPane(logArea);
        scrollPane.setBorder(null);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void addStyledButton(JPanel panel, int action, String text, Color bgColor) {
        Button btn = new Button(action);
        btn.setText(text);
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 11));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        final Color originalColor = bgColor;
        btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn.setBackground(originalColor.brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn.setBackground(originalColor);
            }
        });

        panel.add(btn);
        BUTTONS.add(btn);
    }

    private JButton createStyledButtonObj(String text, Color bgColor) {
        JButton btn = new JButton(text);
        btn.setBackground(bgColor);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 11));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    private JLabel createInfoLabel(String text, Color color) {
        JLabel lbl = new JLabel(text, SwingConstants.CENTER);
        lbl.setForeground(color);
        lbl.setFont(new Font("Arial", Font.BOLD, 12));
        return lbl;
    }

    private void updateDashboard() {
        try {
            // Update server status
            if (Server.start) {
                lblServerStatus.setText("[ĐANG CHẠY]");
                lblServerStatus.setForeground(new Color(76, 175, 80));
            } else {
                lblServerStatus.setText("[DỪNG]");
                lblServerStatus.setForeground(new Color(244, 67, 54));
            }

            lblOnline.setText("Online: " + Server.gI().sizeByCId());
            lblConnections.setText("Kết nối: " + Server.gI().sizeConn());
            lblMaps.setText("Bản đồ: " + Map.size());
            lblClans.setText("Bang hội: " + Clan.size());
            lblThreads.setText("Luồng: " + Thread.activeCount());
            lblDelay.setText("Độ trễ: " + Server.gI().delay + "ms");
            lblUptime.setText(Util.gI().getFormatTime3(System.currentTimeMillis() - Server.gI().lastStart));
            lblBots.setText("Bots: " + Player.sizeBot());

            // Memory usage
            Runtime runtime = Runtime.getRuntime();
            long usedMem = (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024);
            lblMemory.setText("RAM: " + usedMem + "MB");

            // Update event status
            if (eventStatusArea != null) {
                eventStatusArea.setText(getActiveEvents());
            }

            // Update auto save buttons
            Button btnAutoSave = getButton(6);
            if (btnAutoSave != null) {
                btnAutoSave.setText(Server.gI().isAutoSave ? "Auto ON" : "Auto OFF");
                btnAutoSave.setBackground(Server.gI().isAutoSave ? new Color(76, 175, 80) : new Color(158, 158, 158));
            }

            Button btnTime = getButton(7);
            if (btnTime != null) {
                btnTime.setText(Util.gI().getStrTime(Server.gI().setSave));
            }

            // Update maintenance button
            Button btnMaintain = getButton(205);
            if (btnMaintain != null) {
                if (Server.gI().timeBaoTri != -1) {
                    btnMaintain.setText(Util.gI().getStrTime(Server.gI().timeBaoTri));
                    btnMaintain.setBackground(new Color(244, 67, 54));
                } else {
                    btnMaintain.setText("Bao tri 30p");
                    btnMaintain.setBackground(new Color(255, 87, 34));
                }
            }

        } catch (Exception e) {
            // Ignore update errors
        }
    }

    private void executeQuickCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            addLog("[WARN] Vui lòng nhập lệnh!");
            return;
        }

        input = input.trim();
        String[] parts = input.split(":", 2);
        String cmd = parts[0].toLowerCase();

        try {
            switch (cmd) {
                case "kick":
                    if (parts.length > 1) {
                        dragon.server.Session_ME session = Server.gI().getByCName(parts[1]);
                        if (session != null) {
                            session.close();
                            addLog("[OK] Đã kick player: " + parts[1]);
                        } else {
                            addLog("[ERR] Không tìm thấy: " + parts[1]);
                        }
                    }
                    break;

                case "find":
                    if (parts.length > 1) {
                        dragon.server.Session_ME s = Server.gI().getByCName(parts[1]);
                        if (s != null && s.myCharz() != null) {
                            addLog("[INFO] " + parts[1] + " | Lv:" + s.myCharz().clevel +
                                    " | Power:" + s.myCharz().cPower +
                                    " | Gold:" + s.myCharz().xu +
                                    " | Lượng:" + s.myCharz().luong);
                        } else {
                            addLog("[ERR] Không tìm thấy: " + parts[1]);
                        }
                    }
                    break;

                case "chat":
                    if (parts.length > 1) {
                        Server.gI().chatInfo("[ADMIN] " + parts[1]);
                        addLog("[OK] Da gui chat: " + parts[1]);
                    }
                    break;

                case "addgold":
                case "addxu":
                    String[] goldParts = input.split(":");
                    if (goldParts.length >= 3) {
                        dragon.server.Session_ME ss = Server.gI().getByCName(goldParts[1]);
                        if (ss != null && ss.myCharz() != null) {
                            long amount = Long.parseLong(goldParts[2]);
                            ss.myCharz().updateXu(amount, 1);
                            addLog("[OK] Da them " + amount + " vang cho " + goldParts[1]);
                        }
                    }
                    break;

                case "addluong":
                    String[] luongParts = input.split(":");
                    if (luongParts.length >= 3) {
                        dragon.server.Session_ME ss = Server.gI().getByCName(luongParts[1]);
                        if (ss != null && ss.myCharz() != null) {
                            int amount = Integer.parseInt(luongParts[2]);
                            ss.myCharz().updateLuong(amount, 1);
                            addLog("[OK] Da them " + amount + " luong cho " + luongParts[1]);
                        }
                    }
                    break;

                case "senditem":
                    String[] itemParts = input.split(":");
                    if (itemParts.length >= 3) {
                        String playerName = itemParts[1];
                        int itemId = Integer.parseInt(itemParts[2]);
                        int quantity = itemParts.length >= 4 ? Integer.parseInt(itemParts[3]) : 1;
                        sendItemToBox(playerName, itemId, quantity);
                        Server.gI().chatInfo("[ADMIN] " + itemId);
                    } else {
                        addLog("[ERR] Format: senditem:name:itemid:quantity");
                    }
                    break;

                default:
                    addLog("[ERR] Lenh khong hop le: " + cmd);
            }
        } catch (Exception e) {
            addLog("[ERR] Loi: " + e.getMessage());
        }
    }

    public void addLog(String message) {
        if (logArea != null) {
            logArea.append(getTimeStamp() + " " + message + "\n");
            logArea.setCaretPosition(logArea.getDocument().getLength());
        }
    }

    private String getTimeStamp() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        return "[" + sdf.format(new java.util.Date()) + "]";
    }

    public String getActiveEvents() {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        try {
            if (Server.gI().isButcher) {
                sb.append("[Butcher] con " + Util.gI().getStrTime(Server.gI().timeXongButcher) + "\n");
                count++;
            }
            if (Server.gI().isBigBoss) {
                sb.append("[BigBoss] con " + Util.gI().getStrTime(Server.gI().timeXongBigBoss) + "\n");
                count++;
            }
            if (Server.gI().isMabu) {
                sb.append("[Mabu] con " + Util.gI().getStrTime(Server.gI().tMabu) + "\n");
                count++;
            }
            if (dragon.t.BlackBall.gI().isBlackBall) {
                sb.append("[BlackBall] con " + Util.gI().getStrTime(dragon.t.BlackBall.gI().timeXongBlackBall) + "\n");
                count++;
            }
            if (dragon.t.RongVoCuc.gI().isCallRongVoCuc) {
                sb.append("[Rong Vo Cuc] con " + Util.gI().getStrTime(dragon.t.RongVoCuc.gI().timeRongVoCuc) + "\n");
                count++;
            }
            if (dragon.t.DaiHoi.isWar) {
                sb.append("[Dai Hoi] " + dragon.t.DaiHoi.name + "\n");
                count++;
            }
            if (LuckyRoundNew.countID() > 0) {
                sb.append("[Vong Quay] con " + Util.gI().getStrTime(LuckyRoundNew.time) + "\n");
                count++;
            }
        } catch (Exception e) {}

        if (count == 0) {
            sb.append("Khong co su kien nao\n");
        }
        return sb.toString();
    }

    // Legacy methods for compatibility
    public void setText(String str) {
        addLog(str.replace("\n", " | "));
    }

    public void getInfoServer() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== THỐNG KÊ SERVER ===\n");
        sb.append("Kết nối: " + Server.gI().sizeConn() + "\n");
        sb.append("Online: " + Server.gI().sizeByUId() + "\n");
        sb.append("Đang chơi: " + Server.gI().sizeByCId() + "\n");
        sb.append("Clan: " + Clan.size() + "\n");
        sb.append("ItemKyGui: " + ItemKyGui.countItemKyGui() + "\n");
        sb.append("Bot: " + Player.sizeBot() + "\n");
        sb.append("Map: " + Map.size() + "\n");
        sb.append("Thread: " + Thread.activeCount() + "\n");
        sb.append("Delay: " + Server.gI().delay + "ms\n");
        sb.append("Thời gian hoạt động: " + Util.gI().getFormatTime3(System.currentTimeMillis() - Server.gI().lastStart) + "\n");
        sb.append("BWar: " + BWar.ARRBWAR.size() + "\n");
        sb.append("Thỏi vàng: " + LuckyRoundNew.nPhi + "\n");

        addLog(sb.toString());
        JOptionPane.showMessageDialog(mainFrame, sb.toString(), "Thong ke Server", JOptionPane.INFORMATION_MESSAGE);
    }

    public void getStay() {
        StringBuilder str = new StringBuilder("Danh sach ket:\n");
        int count = 0;
        synchronized(Server.gI().connList) {
            for (int i = 0; i < Server.gI().connList.size(); i++) {
                if ((System.currentTimeMillis() - Server.gI().connList.get(i).l) > 10000L) {
                    str.append("status=" + Server.gI().connList.get(i).status +
                            " delay=" + (System.currentTimeMillis() - Server.gI().connList.get(i).l));
                    if (Server.gI().connList.get(i).isLogin) {
                        str.append(" user=" + Server.gI().connList.get(i).userName);
                    }
                    str.append("\n");
                    count++;
                }
            }
        }
        if (count == 0) {
            str.append("Không có kết nối nào bị kẹt!");
        }
        addLog(str.toString());
    }

    public void setButton(int action, String text, int x, int y, int width, int height) {
        Button o = this.getButton(action);
        if (o == null) {
            o = new Button(action);
            BUTTONS.add(o);
        }
        o.setText(text);
    }

    public Button getButton(int action) {
        for (int i = 0; i < BUTTONS.size(); i++) {
            if (BUTTONS.get(i).action == action) {
                return BUTTONS.get(i);
            }
        }
        return null;
    }

    public void setTextBox(int action, String text, int x, int y, int width, int height) {
        TextBox o = this.getTextBox(action);
        if (o == null) {
            o = new TextBox(action);
            TEXTBOXS.add(o);
        }
        o.setText(text);
    }

    public TextBox getTextBox(int action) {
        for (int i = 0; i < TEXTBOXS.size(); i++) {
            if (TEXTBOXS.get(i).action == action) {
                return TEXTBOXS.get(i);
            }
        }
        return null;
    }

    public void hideInputControls() {
        // Not needed in new design
    }

    // Legacy init for compatibility
    public void init() {
        // Already initialized in initUI()
    }

    // Legacy openTextBox - now shows dialog
    public void openTextBox() {
        String input = JOptionPane.showInputDialog(mainFrame,
                "Nhap so su kien:\n" +
                        "1. Phat qua\n" +
                        "2. Butcher\n" +
                        "3. BigBoss\n" +
                        "4. Mabu\n" +
                        "5. Cace23\n" +
                        "6. BlackBall\n" +
                        "7. Rồng Vô Cực\n" +
                        "8. Dai Hoi\n" +
                        "9. Vong Quay",
                "Mo Su Kien", JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.isEmpty()) {
            try {
                int idx = Integer.parseInt(input.trim());
                openEventByIndex(idx);
            } catch (Exception e) {
                addLog("[ERR] So khong hop le!");
            }
        }
    }

    public void openEventByIndex(int idx) {
        switch (idx) {
            case 1:
                Server.gI().addPhatQua();
                addLog("[OK] Da mo su kien: Phat qua");
                break;
            case 2:
                Server.gI().openButcher();
                addLog("[OK] Da mo su kien: Butcher");
                break;
            case 3:
                Server.gI().openBigBoss();
                addLog("[OK] Da mo su kien: BigBoss");
                break;
            case 4:
                Server.gI().openMabu();
                addLog("[OK] Da mo su kien: Mabu");
                break;
            case 5:
                Server.gI().openCace23();
                addLog("[OK] Da mo su kien: Cace23");
                break;
            case 6:
                dragon.t.BlackBall.gI().openBlackBall();
                addLog("[OK] Da mo su kien: BlackBall");
                break;
            case 7:
                dragon.t.RongVoCuc.gI().openRongVoCuc();
                addLog("[OK] Da mo su kien: Rong Vo Cuc");
                break;
            case 8:
                dragon.t.DaiHoi.createPrize(5);
                addLog("[OK] Da mo su kien: Dai Hoi Ngoai Hang");
                break;
            case 9:
                addLog("[INFO] Vong Quay tu dong khi co nguoi tham gia");
                break;
            default:
                addLog("[ERR] So su kien khong hop le!");
        }
    }

    public void closeAllEvents() {
        Server.gI().closeButcher();
        Server.gI().closeBigBoss();
        Server.gI().closeMabu();
        Server.gI().closeCace23();
        dragon.t.BlackBall.gI().closeBlackBall();
        dragon.t.RongVoCuc.gI().closeRongVoCuc();
        addLog("[OK] Da tat TAT CA su kien!");
    }

    // Placeholder methods for legacy compatibility
    public void openPlayerMenu() {
        String input = JOptionPane.showInputDialog(mainFrame,
                "Nhap lenh (VD: kick:TenNV | find:TenNV | addgold:TenNV:1000000)",
                "Quan ly Player", JOptionPane.QUESTION_MESSAGE);
        if (input != null) {
            executeQuickCommand(input);
        }
    }

    public void openNotifyMenu() {
        String input = JOptionPane.showInputDialog(mainFrame,
                "Nhap thong bao gui den tat ca nguoi choi:",
                "Gui Thong Bao", JOptionPane.QUESTION_MESSAGE);
        if (input != null && !input.isEmpty()) {
            Server.gI().chatInfo("[ADMIN] " + input);
            addLog("[OK] Da gui thong bao: " + input);
        }
    }

    public void openCloseEventMenu() {
        String input = JOptionPane.showInputDialog(mainFrame,
                "Nhap so de tat su kien:\n" +
                        "0. Tat TAT CA\n" +
                        "1. Butcher\n" +
                        "2. BigBoss\n" +
                        "3. Mabu\n" +
                        "4. BlackBall\n" +
                        "5. Rong Vo Cuc\n" +
                        "6. Cace23",
                "Tat Su Kien", JOptionPane.QUESTION_MESSAGE);

        if (input != null && !input.isEmpty()) {
            try {
                int idx = Integer.parseInt(input.trim());
                switch (idx) {
                    case 0: closeAllEvents(); break;
                    case 1: Server.gI().closeButcher(); addLog("[OK] Da tat Butcher"); break;
                    case 2: Server.gI().closeBigBoss(); addLog("[OK] Da tat BigBoss"); break;
                    case 3: Server.gI().closeMabu(); addLog("[OK] Da tat Mabu"); break;
                    case 4: dragon.t.BlackBall.gI().closeBlackBall(); addLog("[OK] Da tat BlackBall"); break;
                    case 5: dragon.t.RongVoCuc.gI().closeRongVoCuc(); addLog("[OK] Da tat Rong Vo Cuc"); break;
                    case 6: Server.gI().closeCace23(); addLog("[OK] Da tat Cace23"); break;
                }
            } catch (Exception e) {
                addLog("[ERR] So khong hop le!");
            }
        }
    }

    public void showActiveEvents() {
        JOptionPane.showMessageDialog(mainFrame, getActiveEvents(), "Su kien dang chay", JOptionPane.INFORMATION_MESSAGE);
    }

    public void openChatWorldMenu() {
        openNotifyMenu();
    }

    /**
     * Send item to the player's red box (arrItemBox)
     * @param playerName Name of the player
     * @param itemId Item template ID
     * @param quantity Quantity of item
     */
    public void sendItemToBox(String playerName, int itemId, int quantity) {
        try {
            dragon.server.Session_ME session = Server.gI().getByCName(playerName);
            if (session == null || session.myCharz() == null) {
                addLog("[ERR] Khong tim thay player: " + playerName);
                return;
            }

            dragon.t.Char player = session.myCharz();

            // Create item with proper initialization
            dragon.t.Item item = new dragon.t.Item(itemId, false, quantity, new ArrayList<>(), "", "", "");
            if (item.template == null) {
                addLog("[ERR] Item ID khong hop le: " + itemId);
                return;
            }


            // Find empty slot in box
            int emptyIndex = player.getEmptyBoxIndex();
            if (emptyIndex == -1) {
                addLog("[ERR] Ruong do cua " + playerName + " da day!");
                session.service.messageServer("[ADMIN] Rương đỏ của bạn đã đầy, không thể nhận item!");
                return;
            }

            // Add item to box
            player.addItemBox(item, emptyIndex);

            // Update box UI if player is online
            if (session.isConnected()) {
                session.service.Box(player.arrItemBox);
            }

            // Send detailed notification to the player
            String itemName = item.template.name;
            String notification = String.format("Bạn đã nhận được %s x%d từ ADMIN!\nVật phẩm đã được gửi vào rương đỏ.", itemName, quantity);

            // Show popup dialog to player
            session.service.dialogMessage(notification);

            // Also send a server message for chat history
            session.service.messageServer("[ADMIN] Đã gửi " + itemName + " x" + quantity + " vào rương đỏ của bạn!");

            // Log success in admin dashboard
            addLog("[OK] Da gui " + itemName + " (ID:" + itemId + ") x" + quantity + " vao ruong do cua " + playerName);

        } catch (Exception e) {
            addLog("[ERR] Loi khi gui item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Open advanced dialog to send items to player's box with checkbox selection
     * Loads items directly from database (ItemTemplate)
     */
    public void openSendItemMenu() {
        // Create main dialog
        JDialog dialog = new JDialog(mainFrame, "Gửi Item vào Rương Đỏ", true);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setSize(850, 600);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.getContentPane().setBackground(new Color(35, 35, 40));

        // Top panel - Player selection
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.setBackground(new Color(45, 45, 50));
        topPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(80, 150, 200), 2),
                "Chọn Người Chơi",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 13),
                new Color(100, 200, 255)));

        JLabel lblPlayer = new JLabel("👤 Người chơi:");
        lblPlayer.setForeground(new Color(100, 200, 255));
        lblPlayer.setFont(new Font("Arial", Font.BOLD, 12));

        // Get online players
        java.util.List<String> onlinePlayers = new ArrayList<>();
        synchronized (Server.gI().connList) {
            for (dragon.server.Session_ME session : Server.gI().connList) {
                if (session != null && session.myCharz() != null) {
                    onlinePlayers.add(session.myCharz().cName);
                }
            }
        }

        JComboBox<String> cboPlayers = new JComboBox<>(onlinePlayers.toArray(new String[0]));
        cboPlayers.setPreferredSize(new Dimension(250, 30));
        cboPlayers.setBackground(new Color(55, 55, 60));
        cboPlayers.setForeground(new Color(100, 200, 255));
        cboPlayers.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel lblOnline = new JLabel("🟢 " + onlinePlayers.size() + " online");
        lblOnline.setForeground(new Color(100, 255, 100));
        lblOnline.setFont(new Font("Arial", Font.BOLD, 12));

        topPanel.add(lblPlayer);
        topPanel.add(cboPlayers);
        topPanel.add(lblOnline);

        // Center panel - Item selection with checkboxes
        JPanel centerPanel = new JPanel(new BorderLayout(5, 5));
        centerPanel.setBackground(new Color(35, 35, 40));
        centerPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(80, 150, 200), 2),
                "Chọn Vật Phẩm (Click để bấm/bỏ dấu tích)",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 13),
                new Color(100, 200, 255)));

        // Create item table with checkbox
        String[] columnNames = {"✓", "ID", "Tên Item", "Loại", "Số lượng"};
        javax.swing.table.DefaultTableModel tableModel = new javax.swing.table.DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 0 || column == 4; // Checkbox and quantity are editable
            }

            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 0) return Boolean.class;
                if (column == 1 || column == 4) return Integer.class;
                return String.class;
            }
        };

        // Load all items from database
        java.util.Collection<dragon.t.ItemTemplate> allItems = dragon.t.ItemTemplate.itemTemplates.values();
        java.util.List<dragon.t.ItemTemplate> sortedItems = new ArrayList<>(allItems);
        sortedItems.sort((a, b) -> Short.compare(a.id, b.id));

        // Add items to table
        for (dragon.t.ItemTemplate item : sortedItems) {
            if (item != null && item.name != null && !item.name.isEmpty()) {
                tableModel.addRow(new Object[]{
                    false,                              // Checkbox (unchecked by default)
                    (int)item.id,                      // ID
                    item.name,                         // Name
                    getItemTypeName(item.type),        // Type
                    1                                  // Default quantity
                });
            }
        }

        // Create table with custom renderer for better UI
        JTable itemTable = new JTable(tableModel) {
            @Override
            public javax.swing.table.TableCellRenderer getCellRenderer(int row, int column) {
                return new javax.swing.table.DefaultTableCellRenderer() {
                    @Override
                    public java.awt.Component getTableCellRendererComponent(
                            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        java.awt.Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                        if (isSelected) {
                            comp.setBackground(new Color(70, 130, 200));
                            comp.setForeground(Color.WHITE);
                        } else {
                            // Alternate row colors
                            if (row % 2 == 0) {
                                comp.setBackground(new Color(45, 45, 50));
                            } else {
                                comp.setBackground(new Color(55, 55, 60));
                            }
                            comp.setForeground(new Color(200, 200, 200));
                        }

                        if (column == 0) {
                            setHorizontalAlignment(CENTER);
                        } else if (column == 1 || column == 4) {
                            setHorizontalAlignment(CENTER);
                        } else {
                            setHorizontalAlignment(LEFT);
                        }

                        this.setFont(new Font("Arial", Font.PLAIN, 11));
                        return comp;
                    }
                };
            }
        };

        itemTable.setBackground(new Color(45, 45, 50));
        itemTable.setForeground(new Color(200, 200, 200));
        itemTable.setSelectionBackground(new Color(70, 130, 200));
        itemTable.setSelectionForeground(Color.WHITE);
        itemTable.setRowHeight(28);
        itemTable.setGridColor(new Color(65, 65, 70));
        itemTable.getTableHeader().setBackground(new Color(50, 50, 55));
        itemTable.getTableHeader().setForeground(new Color(100, 200, 255));
        itemTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        // Set column widths
        itemTable.getColumnModel().getColumn(0).setPreferredWidth(40);   // Checkbox
        itemTable.getColumnModel().getColumn(1).setPreferredWidth(60);   // ID
        itemTable.getColumnModel().getColumn(2).setPreferredWidth(300);  // Name
        itemTable.getColumnModel().getColumn(3).setPreferredWidth(150);  // Type
        itemTable.getColumnModel().getColumn(4).setPreferredWidth(80);   // Quantity

        JScrollPane scrollPane = new JScrollPane(itemTable);
        scrollPane.setBackground(new Color(35, 35, 40));
        scrollPane.getViewport().setBackground(new Color(45, 45, 50));
        scrollPane.setPreferredSize(new Dimension(820, 350));
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        // Info panel
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        infoPanel.setBackground(new Color(40, 40, 45));
        JLabel lblInfo = new JLabel("ℹ️ Tổng cộng: " + sortedItems.size() + " item | Double-click cột 'Số lượng' để chỉnh");
        lblInfo.setForeground(new Color(150, 200, 100));
        lblInfo.setFont(new Font("Arial", Font.ITALIC, 11));
        infoPanel.add(lblInfo);
        centerPanel.add(infoPanel, BorderLayout.SOUTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.setBackground(new Color(35, 35, 40));

        JButton btnSend = new JButton("✓ Gửi Item");
        btnSend.setPreferredSize(new Dimension(150, 40));
        btnSend.setBackground(new Color(76, 175, 80));
        btnSend.setForeground(Color.WHITE);
        btnSend.setFont(new Font("Arial", Font.BOLD, 13));
        btnSend.setFocusPainted(false);
        btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JButton btnCancel = new JButton("✕ Hủy");
        btnCancel.setPreferredSize(new Dimension(150, 40));
        btnCancel.setBackground(new Color(244, 67, 54));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 13));
        btnCancel.setFocusPainted(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSend.addActionListener(e -> {
            // Validate player selection
            if (cboPlayers.getSelectedItem() == null || cboPlayers.getSelectedItem().toString().trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "❌ Vui lòng chọn người chơi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if any item is selected (checkbox = true)
            int checkedCount = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Boolean isChecked = (Boolean) tableModel.getValueAt(i, 0);
                if (isChecked != null && isChecked) {
                    checkedCount++;
                }
            }

            if (checkedCount == 0) {
                JOptionPane.showMessageDialog(dialog, "❌ Vui lòng chọn ít nhất 1 item!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String playerName = (String) cboPlayers.getSelectedItem();
            int successCount = 0;
            int failCount = 0;
            StringBuilder failedItems = new StringBuilder();

            // Send selected items
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Boolean isChecked = (Boolean) tableModel.getValueAt(i, 0);

                if (isChecked != null && isChecked) {
                    try {
                        Integer itemId = (Integer) tableModel.getValueAt(i, 1);
                        String itemName = (String) tableModel.getValueAt(i, 2);
                        Integer quantity = (Integer) tableModel.getValueAt(i, 4);

                        if (quantity == null || quantity <= 0) {
                            addLog("[WARN] Bo qua item '" + itemName + "' (ID:" + itemId + ") - so luong <= 0");
                            failCount++;
                            failedItems.append("- ").append(itemName).append(" (số lượng <= 0)\n");
                            continue;
                        }

                        // Verify item exists in database
                        dragon.t.ItemTemplate template = dragon.t.ItemTemplate.get((short)(int)itemId);
                        if (template == null) {
                            addLog("[ERR] Item ID " + itemId + " khong co trong database");
                            failCount++;
                            failedItems.append("- Item ID ").append(itemId).append(" (không có trong DB)\n");
                            continue;
                        }

                        sendItemToBox(playerName, itemId, quantity);
                        successCount++;
                        Thread.sleep(100);
                    } catch (NumberFormatException ex) {
                        addLog("[ERR] Loi parse number: " + ex.getMessage());
                        failCount++;
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    } catch (Exception ex) {
                        addLog("[ERR] Loi khi gui item: " + ex.getMessage());
                        failCount++;
                    }
                }
            }

            dialog.dispose();

            // Show result dialog
            String resultMessage;
            if (failCount == 0) {
                resultMessage = "✅ Đã gửi " + successCount + " item thành công!";
                addLog("[OK] Hoan thanh gui item: " + successCount + " thanh cong");
            } else {
                resultMessage = "✅ Đã gửi " + successCount + " item thành công!\n\n❌ Thất bại " + failCount + " item:\n" + failedItems.toString();
                addLog("[INFO] Hoan thanh gui item: " + successCount + " thanh cong, " + failCount + " that bai");
            }

            JOptionPane.showMessageDialog(mainFrame, resultMessage, "Kết Quả", JOptionPane.INFORMATION_MESSAGE);
        });

        btnCancel.addActionListener(e -> dialog.dispose());

        buttonPanel.add(btnSend);
        buttonPanel.add(btnCancel);

        // Add all panels to dialog
        dialog.add(topPanel, BorderLayout.NORTH);
        dialog.add(centerPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    /**
     * Open dialog to delete items from player's inventory or box
     */
    public void openDeleteItemMenu() {
        JDialog dialog = new JDialog(mainFrame, "Xóa Item từ Tủi/Rương", true);
        dialog.setLayout(new BorderLayout(10, 10));
        dialog.setSize(800, 500);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.getContentPane().setBackground(new Color(35, 35, 40));

        // Top panel - Player selection
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        topPanel.setBackground(new Color(45, 45, 50));
        topPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 100, 100), 2),
                "Chọn Người Chơi",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 13),
                new Color(255, 100, 100)));

        JLabel lblPlayer = new JLabel("👤 Người chơi:");
        lblPlayer.setForeground(new Color(255, 100, 100));
        lblPlayer.setFont(new Font("Arial", Font.BOLD, 12));

        JComboBox<String> cboPlayers = new JComboBox<>();
        cboPlayers.setPreferredSize(new Dimension(250, 35));
        cboPlayers.setBackground(new Color(60, 60, 65));
        cboPlayers.setForeground(Color.WHITE);
        cboPlayers.setFont(new Font("Arial", Font.PLAIN, 12));

        // Load all online players
        synchronized(Server.gI().connList) {
            for (Session_ME s : Server.gI().connList) {
                if (s.isConnected() && s.myCharz() != null) {
                    cboPlayers.addItem(s.myCharz().cName);
                }
            }
        }

        topPanel.add(lblPlayer);
        topPanel.add(cboPlayers);
        dialog.add(topPanel, BorderLayout.NORTH);

        // Center panel - Delete options
        JPanel centerPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        centerPanel.setBackground(new Color(45, 45, 50));
        centerPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(200, 100, 100), 1),
                "Xóa Item",
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12),
                new Color(255, 100, 100)));

        // Item ID input
        JLabel lblItemId = new JLabel("🎁 ID Item:");
        lblItemId.setForeground(new Color(200, 200, 200));
        lblItemId.setFont(new Font("Arial", Font.BOLD, 11));
        JTextField txtItemId = new JTextField();
        txtItemId.setBackground(new Color(60, 60, 65));
        txtItemId.setForeground(Color.WHITE);
        txtItemId.setFont(new Font("Arial", Font.PLAIN, 12));

        // Quantity input
        JLabel lblQuantity = new JLabel("📦 Số lượng:");
        lblQuantity.setForeground(new Color(200, 200, 200));
        lblQuantity.setFont(new Font("Arial", Font.BOLD, 11));
        JTextField txtQuantity = new JTextField("1");
        txtQuantity.setBackground(new Color(60, 60, 65));
        txtQuantity.setForeground(Color.WHITE);
        txtQuantity.setFont(new Font("Arial", Font.PLAIN, 12));

        // Location selection
        JLabel lblLocation = new JLabel("📍 Vị trí:");
        lblLocation.setForeground(new Color(200, 200, 200));
        lblLocation.setFont(new Font("Arial", Font.BOLD, 11));
        JComboBox<String> cboLocation = new JComboBox<>(new String[]{"Tủi đồ", "Rương đỏ"});
        cboLocation.setBackground(new Color(60, 60, 65));
        cboLocation.setForeground(Color.WHITE);
        cboLocation.setFont(new Font("Arial", Font.PLAIN, 12));

        // Delete all checkbox
        JCheckBox chkDeleteAll = new JCheckBox("Xóa tất cả cái loại");
        chkDeleteAll.setBackground(new Color(45, 45, 50));
        chkDeleteAll.setForeground(new Color(200, 200, 200));
        chkDeleteAll.setFont(new Font("Arial", Font.PLAIN, 11));

        centerPanel.add(lblItemId);
        centerPanel.add(txtItemId);
        centerPanel.add(lblQuantity);
        centerPanel.add(txtQuantity);
        centerPanel.add(lblLocation);
        centerPanel.add(cboLocation);
        centerPanel.add(chkDeleteAll);
        centerPanel.add(new JLabel(""));

        dialog.add(centerPanel, BorderLayout.CENTER);

        // Bottom panel - Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(45, 45, 50));

        JButton btnDelete = new JButton("🗑️ Xóa Item");
        btnDelete.setPreferredSize(new Dimension(150, 40));
        btnDelete.setBackground(new Color(244, 67, 54));
        btnDelete.setForeground(Color.WHITE);
        btnDelete.setFont(new Font("Arial", Font.BOLD, 13));
        btnDelete.setFocusPainted(false);
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        JButton btnCancel = new JButton("✕ Hủy");
        btnCancel.setPreferredSize(new Dimension(150, 40));
        btnCancel.setBackground(new Color(100, 100, 100));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Arial", Font.BOLD, 13));
        btnCancel.setFocusPainted(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnDelete.addActionListener(e -> {
            try {
                String playerName = (String) cboPlayers.getSelectedItem();
                if (playerName == null || playerName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "❌ Vui lòng chọn người chơi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int itemId = Integer.parseInt(txtItemId.getText().trim());
                String location = (String) cboLocation.getSelectedItem();
                boolean deleteAll = chkDeleteAll.isSelected();

                // Get session
                Session_ME session = null;
                synchronized(Server.gI().connList) {
                    for (Session_ME s : Server.gI().connList) {
                        if (s.isConnected() && s.myCharz() != null && s.myCharz().cName.equals(playerName)) {
                            session = s;
                            break;
                        }
                    }
                }

                if (session == null || !session.isConnected()) {
                    addLog("[ERR] Không tìm thấy hoặc mất kết nối của " + playerName);
                    JOptionPane.showMessageDialog(dialog, "❌ Không tìm thấy người chơi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                dragon.t.Char player = session.myCharz();
                int deletedCount = 0;

                if (location != null && location.equals("Tủi đồ")) {
                    // Delete from inventory
                    if (deleteAll) {
                        for (int i = 0; i < player.arrItemBag.length; i++) {
                            if (player.arrItemBag[i] != null && player.arrItemBag[i].template.id == itemId) {
                                deletedCount += player.arrItemBag[i].quantity;
                                player.arrItemBag[i] = null;
                            }
                        }
                    } else {
                        int quantity = Integer.parseInt(txtQuantity.getText().trim());
                        for (int i = 0; i < player.arrItemBag.length; i++) {
                            if (player.arrItemBag[i] != null && player.arrItemBag[i].template.id == itemId) {
                                if (player.arrItemBag[i].quantity >= quantity) {
                                    player.arrItemBag[i].quantity -= quantity;
                                    if (player.arrItemBag[i].quantity <= 0) {
                                        player.arrItemBag[i] = null;
                                    }
                                    deletedCount = quantity;
                                    break;
                                } else {
                                    deletedCount = player.arrItemBag[i].quantity;
                                    player.arrItemBag[i] = null;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    // Delete from box
                    if (deleteAll) {
                        for (int i = 0; i < player.arrItemBox.length; i++) {
                            if (player.arrItemBox[i] != null && player.arrItemBox[i].template.id == itemId) {
                                deletedCount += player.arrItemBox[i].quantity;
                                player.arrItemBox[i] = null;
                            }
                        }
                    } else {
                        int quantity = Integer.parseInt(txtQuantity.getText().trim());
                        for (int i = 0; i < player.arrItemBox.length; i++) {
                            if (player.arrItemBox[i] != null && player.arrItemBox[i].template.id == itemId) {
                                if (player.arrItemBox[i].quantity >= quantity) {
                                    player.arrItemBox[i].quantity -= quantity;
                                    if (player.arrItemBox[i].quantity <= 0) {
                                        player.arrItemBox[i] = null;
                                    }
                                    deletedCount = quantity;
                                    break;
                                } else {
                                    deletedCount = player.arrItemBox[i].quantity;
                                    player.arrItemBox[i] = null;
                                    break;
                                }
                            }
                        }
                    }
                    // Update UI
                    session.service.Box(player.arrItemBox);
                }

                if (deletedCount > 0) {
                    addLog("[OK] Da xoa " + deletedCount + " item (ID:" + itemId + ") tu " + location + " cua " + playerName);
                    JOptionPane.showMessageDialog(dialog, "✓ Xóa thành công " + deletedCount + " item!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                } else {
                    addLog("[WARN] Khong tim thay item ID:" + itemId + " trong " + location + " cua " + playerName);
                    JOptionPane.showMessageDialog(dialog, "⚠️ Không tìm thấy item!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "❌ Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                addLog("[ERR] Loi khi xoa item: " + ex.getMessage());
                JOptionPane.showMessageDialog(dialog, "❌ Lỗi: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancel.addActionListener(e -> dialog.dispose());

        buttonPanel.add(btnDelete);
        buttonPanel.add(btnCancel);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }

    /**
     * Get item type name based on type id
     */
    private String getItemTypeName(byte type) {
        switch (type) {
            case 0: return "Trang bị";
            case 1: return "Hàng tiêu hao";
            case 2: return "Tích lũy";
            case 3: return "Sách";
            case 4: return "Bảng tính";
            case 5: return "Petz";
            case 6: return "Quà tặng";
            case 7: return "Còn lại";
            case 10: return "Vàng";
            case 11: return "Lượng";
            default: return "Khác (" + type + ")";
        }
    }
}