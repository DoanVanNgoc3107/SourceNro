package dragon.t;

import dragon.server.Server;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class Instancing {
    
    public int level;
    public long lastOpen;
    public int miliTime;
    public int miliTime2;
    public Clan clan;
    public int delay;
    
    public final ArrayList<Map> maps = new ArrayList<>();
    
    private final ArrayList<Integer> players = new ArrayList<>();
    
    public void close() {
        for (int i = 0; i < this.maps.size(); i++) {
            Map map = this.maps.get(i);
            for (int j = 0; j < map.zones.size(); j++) {
                map.zones.get(j).pushPlayers(0);
            }
        }
        for (int i = this.maps.size() - 1; i >= 0; --i) {
            this.maps.get(i).close();
        }
    }
    
    public boolean isJoin(int playerId) {
        synchronized (this.players) {
            return this.players.contains(playerId);
        }
    }
    
    public boolean join(int playerId) {
        synchronized (this.players) {
            if (this.players.contains(playerId)) {
                return false;
            }
            this.players.add(playerId);
            return true;
        }
    }
    
    public void update() {
        this.miliTime -= this.delay;
        if (this.miliTime <= 0) {
            this.miliTime = 0;
            Server.gI().remove(this);
            this.close();
        }
    }
    
    public Map getMap(int mapTemplateId) {
        for (int i = 0; i < this.maps.size(); i++) {
            if (this.maps.get(i).templateId == mapTemplateId) {
                return this.maps.get(i);
            }
        }
        return null;
    }
    
    public void updateWin(int status) {
        
    }
    
}
