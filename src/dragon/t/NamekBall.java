package dragon.t;

import dragon.server.Server;
import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class NamekBall {
    
    public int delay;
    private static NamekBall instance;
    public boolean isFossil;
    public long lastCallDragon = -1;
    public boolean isDendeRanh;
    
    public static NamekBall gI() {
        if (instance == null) {
            instance = new NamekBall();
        }
        return instance;
    }
    
    public void initNamekBall() {
        ArrayList<Map> list = new ArrayList<>();
        synchronized (Map.MAPS_SERVER) {
            for (int i = 0; i < Map.MAPS_SERVER.size(); i++) {
                if (Map.MAPS_SERVER.get(i).isMapNamekBall()) {
                    list.add(Map.MAPS_SERVER.get(i));
                }
            }
        }
        for (int k = 0; k < 7; k++) {
            Map map =  list.remove(Util.gI().nextInt(list.size()));
            ZoneMap zone = map.zones.get(Util.gI().nextInt(map.zones.size()));
            Item item = new Item(353 + k, false, 1, ItemOption.getOption(353 + k, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item.options.add(new ItemOption(73, k));
            int x = Util.gI().nextInt(50, zone.mapTemplate.pxw - 50);
            ItemMap itemMap = zone.addItemMap(-1, item, x, zone.mapTemplate.touchY(x, 150), 0, -1);
            zone.itemMapAdd(itemMap);
            BallRada.add(new BallRada(itemMap.item, zone, itemMap.itemMapID, itemMap.x, itemMap.y));
        }
    }
    
    public void thungoc() {
        BallRada.timeCleanBall = -1;
        for (int s = 0; s < 7; s++) {
            BallRada rada = BallRada.getById(353 + s);
            Char player = rada.player;
            if (player != null) {
                rada.player = null;
                player.itemNamekBall = null;
                player.cTypePk = 0;
                player.updateAll();
                player.session.service.meLoadPoint();
                player.zoneMap.playerLoadAll(player);
                player.zoneMap.getBag(player);
                player.zoneMap.updateTypePk(player.charID, player.cTypePk);
            } else {
                rada.zoneMap.removeItemMap(rada.itemMapID);
                rada.zoneMap.itemMapRemove(rada.itemMapID);
                rada.itemMapID = -1;
            }
        }
    }
    
    public void refossil() {
        this.lastCallDragon = System.currentTimeMillis();
        BallRada.timeCleanBall = -1;
        this.isFossil = true;
    }
    
    public void reappear() {
        this.lastCallDragon = -1;
        BallRada.timeCleanBall = -1;
        this.isFossil = false;
    }
    
    public void hideBall() {
        ArrayList<BallRada> list1 = new ArrayList<>();
        synchronized(BallRada.HBALL) {
            int num = 0;
            while(num < BallRada.HBALL.size()) {
                if (BallRada.HBALL.get(num).ball.isItemNamekBall()) {
                    list1.add(BallRada.HBALL.get(num));
                }
                num++;
            }
        }
        ArrayList<Map> list2 = new ArrayList<>();
        synchronized (Map.MAPS_SERVER) {
            for (int i = 0; i < Map.MAPS_SERVER.size(); i++) {
                if (Map.MAPS_SERVER.get(i).isMapNamekBall()) {
                    list2.add(Map.MAPS_SERVER.get(i));
                }
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            Map map = list2.remove(Util.gI().nextInt(list2.size()));
            ZoneMap zone = map.zones.get(Util.gI().nextInt(map.zones.size()));
            int x = Util.gI().nextInt(50, zone.mapTemplate.pxw - 50);
            ItemMap itemMap = zone.addItemMap(-1, list1.get(i).ball, x, zone.mapTemplate.touchY(x, 150), 0, -1);
            list1.get(i).player = null;
            list1.get(i).x = itemMap.x;
            list1.get(i).y = itemMap.y;
            list1.get(i).zoneMap = zone;
            list1.get(i).itemMapID = -1;
            zone.itemMapAdd(itemMap);
        }
        this.refossil();
    }
    
    public void update() {
        this.isDendeRanh = Server.gI().hours >= 12 && Server.gI().hours < 22;
//        if (this.lastCallDragon != -1 && this.isFossil && System.currentTimeMillis() - this.lastCallDragon >= 20000L) {
        if (this.lastCallDragon != -1 && this.isFossil && System.currentTimeMillis() - this.lastCallDragon >= 86400000L) {
            this.reappear();
        }
    }
    
}
