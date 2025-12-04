package dragon.t;

import dragon.server.MySQL;
import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author TGDD
 */
public class LuckyNumber extends Thread {
    
    private static LuckyNumber instance;
    
    public int[][] arrNumber = new int[][] {
        {
            1, 1
        },
        {
            10, 9
        },
        {
            100, 80
        }
    };
    
    public static int maxNumber = 1000;
    public static int fire100 = 5;
    public static int setSecond = 120;
    
    public static LuckyNumber gI() {
        if (instance == null) {
            instance = new LuckyNumber();
        }
        return instance;
    }
    
    public long totalMoeny = 0;
    public final ArrayList<NumberPlayer> arrPlayer = new ArrayList();
    public ArrayList<String> arrWinName = new ArrayList();
    public ArrayList<Integer> arrWinId = new ArrayList();
    public final Object LOCK = new Object();
    public String number = new String();
    public long delays = 0;
    public boolean isStart;
    public boolean isLockBuy;
    public boolean isLockQuay;
    public int miliTime;
    
    @Override
    public void run() {
        while (isStart) {
            final long l = System.currentTimeMillis();
            //Time Quay
            if (this.miliTime > 0) {
                this.miliTime -= delays;
                if (this.miliTime <= 0) {
                    this.miliTime = 0;
                    this.quayNumber();
                }
                this.isLockBuy = !(this.miliTime > 10000 && this.miliTime < 295000);
            }
            try {
                TimeUnit.MILLISECONDS.sleep(Server.SERVER_DELAY_MILISECOND);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            delays = (System.currentTimeMillis() - l);
        }
    }
    
    public void close() {
        this.isStart = false;
        this.quayNumber();
    }
    
    @Override
    public void start() {
        this.isStart = true;
        super.start();
        this.init();
    }
    
    public void join(Char charz, int first, int index) {
        NumberPlayer o;
        this.addMoney(arrNumber[index][1]);
        if (this.isHavePlayer(charz.playerId)) {
            o = this.getPlayer(charz.playerId);
            int i;
            int length = first + arrNumber[index][0];
            if (length > maxNumber) {
                length = maxNumber;
            }
            for (i = first; i < length; i++) {
                if (!o.arrNumber.contains(i)) {
                    o.arrNumber.add(i);
                }
            }
        } else {
            o = new NumberPlayer(charz.playerId, charz.cName);
            int i;
            int length = first + arrNumber[index][0];
            if (length > maxNumber) {
                length = maxNumber;
            }
            for (i = first; i < length; i++) {
                o.arrNumber.add(i);
            }
            this.add(o);
        }
    }
    
    public boolean isHavePlayer(int playerId) {
        boolean r = false;
        int i;
        synchronized (this.arrPlayer) {
            for (i = 0; i < this.arrPlayer.size(); i++) {
                NumberPlayer o = this.arrPlayer.get(i);
                if (o.playerId == playerId) {
                    r = true;
                    break;
                }
            }
        }
        return r;
    }
    
    public NumberPlayer getPlayer(int playerId) {
        NumberPlayer o = null;
        int i;
        synchronized (this.arrPlayer) {
            for (i = 0; i < this.arrPlayer.size(); i++) {
                NumberPlayer o2 = this.arrPlayer.get(i);
                if (o2.playerId == playerId) {
                    o = o2;
                    break;
                }
            }
        }
        return o;
    }
    
    public int sizePlayer() {
        synchronized (this.arrPlayer) {
            return this.arrPlayer.size();
        }
    }
    
    private void add(NumberPlayer o) {
        synchronized (this.arrPlayer) {
            this.arrPlayer.add(o);
        }
    }
    
    public void addMoney(int v) {
        this.totalMoeny = this.totalMoeny + v;
    }
    
    public void openLuckyNumber(Char charz) {
        charz.resetMenu();
        if (this.number.isEmpty()) {
            if (this.isHavePlayer(charz.playerId)) {
                charz.menuBoard.chat = String.format(mResources.LUCKY_NUMBER1, this.sizePlayer(), this.totalMoeny, this.miliTime / 1000, this.getPlayer(charz.playerId).yourNumber());
            } else {
                charz.menuBoard.chat = String.format(mResources.LUCKY_NUMBER2, this.sizePlayer(), this.totalMoeny, this.miliTime / 1000);
            }
        } else {
            if (this.isHavePlayer(charz.playerId)) {
                if (this.arrWinName.isEmpty()) {
                    charz.menuBoard.chat = String.format(mResources.LUCKY_NUMBER3, this.number, this.sizePlayer(), this.totalMoeny, this.miliTime / 1000, this.getPlayer(charz.playerId).yourNumber());
                } else {
                    charz.menuBoard.chat = String.format(mResources.LUCKY_NUMBER6, this.number, this.strWin(), this.sizePlayer(), this.totalMoeny, this.miliTime / 1000, this.getPlayer(charz.playerId).yourNumber());
                }
            } else {
                if (this.arrWinName.isEmpty()) {
                    charz.menuBoard.chat = String.format(mResources.LUCKY_NUMBER4, this.number, this.sizePlayer(), this.totalMoeny, this.miliTime / 1000);
                } else {
                    charz.menuBoard.chat = String.format(mResources.LUCKY_NUMBER5, this.number, this.strWin(), this.sizePlayer(), this.totalMoeny, this.miliTime / 1000);
                }
            }
        }
        for (int i = 0; i < arrNumber.length; i++) {
            charz.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.NUMBER_MN, arrNumber[i][0], arrNumber[i][1]), 307, i));
        }
        charz.menuBoard.openUIConfirm(5, null, null, -1);
        
    }
    
    public String strWin() {
        String str = new String();
        int i;
        for (i = 0; i < this.arrWinName.size(); i++) {
            if (i == 0) {
                str = str + this.arrWinName.get(i);
            } else {
                str = str + String.format(mResources.SET_NAME, this.arrWinName.get(i));
            }
        }
        return str;
    }
    
    public void quayNumber() {
        if (!this.isLockQuay) {
            this.isLockQuay = true;
            int i;
            int[] arrId;
            long money = 0;
            
            //Lay player ra
            synchronized (this.arrPlayer) {
                arrId = new int[this.arrPlayer.size()];
                for (i = 0; i < arrId.length; i++) {
                    arrId[i] = this.arrPlayer.get(i).playerId;
                }
            }
            
            //Random number
            int l = (""+(LuckyNumber.maxNumber - 1)).length();
            String str = new String();
            this.number = new String();
            for (i = 0; i < l; i++) {
                int n = Util.gI().nextInt(10);
                this.number = this.number + n;
                str = str + (char)(n);
            }
            
            //Check ai trung
            this.arrWinName.clear();
            this.arrWinId.clear();
            synchronized (this.arrPlayer) {
                for (i = 0; i < this.arrPlayer.size(); i++) {
                    if (this.arrPlayer.get(i).arrNumber.contains(Integer.parseInt(this.number))) {
                        this.arrWinName.add(this.arrPlayer.get(i).name);
                        this.arrWinId.add(this.arrPlayer.get(i).playerId);
                    }
                }
            }
            
            //phat qua
            if (!this.arrWinId.isEmpty()) {
                money = this.totalMoeny - (this.totalMoeny * fire100 / 100l);
                this.totalMoeny = 0;
                for (i = 0; i < this.arrWinId.size(); i++) {
                    Session_ME player = Server.gI().getByPId(this.arrWinId.get(i));
                    if (player != null) {
                        player.myCharz().updateLuongKhoa(money / this.arrWinId.size(), 2);
                    } else {
                        try {
                            MySQL mySQL = MySQL.createData6();
                            try {
                                mySQL.getConnection().setAutoCommit(false);
                                try {
                                    mySQL.getConnection().prepareStatement(String.format(mResources.UPDATE_LUONGKHOA, money / this.arrWinId.size(), this.arrWinId.get(i))).executeUpdate();
                                    mySQL.getConnection().commit();
                                } catch  (SQLException e){
                                    mySQL.getConnection().rollback();
                                    e.printStackTrace();
                                }
                            } finally {
                                mySQL.close();
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
//                Server.chatVip(String.format(mResources.FINNISH_LUCKY_NUMBER3, this.arrWinName.get(0), money, this.number));
            }
            
            //Send
            for (i = 0; i < arrId.length; i++) {
                Session_ME player = Server.gI().getByPId(this.arrWinId.get(i));
                if (player != null) {
                    if (this.arrWinId.contains(player.myCharz().playerId)) {
                        player.service.showWinNumber(str, String.format(mResources.FINNISH_LUCKY_NUMBER, player.myCharz().cName, money, this.number));
                    } else {
                        player.service.showWinNumber(str, String.format(mResources.FINNISH_LUCKY_NUMBER2, this.number));
                    }
                }
            }
            this.init();
        }
    }
    
    public void init() {
        this.miliTime = 1000 * setSecond;
        this.isLockQuay = false;
        
        //Xoa all tv tham gia
        synchronized (this.arrPlayer) {
            this.arrPlayer.clear();
        }
    }
    
    
}
