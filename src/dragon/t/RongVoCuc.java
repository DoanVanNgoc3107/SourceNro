package dragon.t;

import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.util.HashMap;

/**
 *
 * @author TGDD
 */
public class RongVoCuc {
    
    public boolean isCallRongVoCuc = false;
    public int timeRongVoCuc;
    public int total;
    private int[] arrWish;
    private boolean isWish;
    public final String[] arrStrWish = new String[] {"1 ngày\nx2 TN,SM", "10k\nHồng ngọc", "1Tỉ\nVàng", "1 ngày\nDoremon"};
    private final HashMap<Integer, Byte> hPlayer = new HashMap<>();
    public int timeClose;
    
    public static int hours = 21;
    
    private static RongVoCuc instance;
    
    public static RongVoCuc gI() {
        if (RongVoCuc.instance == null) {
            RongVoCuc.instance = new RongVoCuc();
        }
        return RongVoCuc.instance;
    }
    
    public void openRongVoCuc() {
        synchronized (this.hPlayer) {
            this.isCallRongVoCuc = true;
            this.isWish = true;
            this.timeRongVoCuc = 1800000;
//            this.timeRongVoCuc = 30000;
            this.timeClose = 0;
            this.total = 0;
            this.arrWish = new int[this.arrStrWish.length];
            this.hPlayer.clear();
        }
        mLog.log("Open Rong Vo Cuc time="+this.timeRongVoCuc);
    }
    
    public void addWish(int playerId, int wish) {
        synchronized (this.hPlayer) {
            if (this.isWish && !this.hPlayer.containsKey(playerId)) {
                this.hPlayer.put(playerId, (byte)wish);
                this.arrWish[wish]++;
                this.total++;
            } else {
                //Da dieu uoc hoac het thoi gian
                Server.gI().connCId.get(playerId).myCharz().setText(3, mResources.TIMEOUT_RONG, 5000, 1, 0);
            }
        }
    }
    
    public float getPercent(int i) {
        synchronized (this.hPlayer) {
            if (this.total > 0) {
                return 100F / (float)this.total * (float)this.arrWish[i];
            } else {
                return 0F;
            }
        }
    }
    
    public void endRongVoCuc() {
        int num1 = -1;
        int num2 = 0;
        synchronized (this.hPlayer) {
            this.isWish = false;
            this.timeRongVoCuc = 0;
            this.timeClose = 10000;
            for (int i = 0; i < this.arrWish.length; i++) {
                if (this.arrWish[i] > num2) {
                    num2 = this.arrWish[i];
                    num1 = i;
                }
            }
        }
        //Thuc hien dieu uoc
        if (num1 != -1) {
            synchronized(Server.gI().connCId) {
                for (int key : Server.gI().connCId.keySet()) {
                    Session_ME player = Server.gI().connCId.get(key);
                    switch (num1) {
                        //X2 Exp
                        case 0: {
                            player.myCharz().setText(3, mResources.X2_TEXT_RVC, 86400, 2, 0);
                            break;
                        }
                        //5K HN
                        case 1: {
                            player.myCharz().addItemBag(0, new Item(861, false, 10000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                            break;
                        }
                        //10 ti vang
                        case 2: {
                            player.myCharz().addItemBag(0, new Item(190, false, 1000000000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                            break;
                        }
                        // Doraemon
                        case 3: {
                            Item doremon = new Item(806, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            doremon.options.add(new ItemOption(50, 30));
                            doremon.options.add(new ItemOption(77, 30));
                            doremon.options.add(new ItemOption(103, 30));
                            doremon.options.add(new ItemOption(5, 20));
                            doremon.options.add(new ItemOption(93, 1));
                            player.myCharz().addItemMore(0, doremon);
                            break;
                        }
                    }
                }
            }
        }
        mLog.log("Gift Rong Vo Cuc total="+ this.total);
    }
    
    public void closeRongVoCuc() {
        synchronized (this.hPlayer) {
            this.isCallRongVoCuc = false;
            this.isWish = false;
            this.timeRongVoCuc = 0;
            this.timeClose = 0;
            this.total = 0;
            this.arrWish = null;
            this.hPlayer.clear();
        }
        mLog.log("Close Rong Vo Cuc");
    }
    
}
