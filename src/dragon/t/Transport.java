package dragon.t;

/**
 *
 * @author TGDD
 */
public class Transport {
    
    public int type;
    public String mapName;
    public String planet;
    public Map map;
    public ZoneMap zone;
    public int xGo;
    public int yGo;
    public int typeTeleport;
    
    public Transport(int type, String mapName, String planet, Map map, ZoneMap zone, int xGo, int yGo, int typeTeleport) {
        this.type = type;
        this.mapName = mapName;
        this.planet = planet;
        this.map = map;
        this.zone = zone;
        this.xGo = xGo;
        this.yGo = yGo;
        this.typeTeleport = typeTeleport;
    }
    
}
