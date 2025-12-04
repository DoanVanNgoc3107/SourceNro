package dragon.t;

/**
 *
 * @author Admin
 */
public class Waypoint {
    public int waypointId;
    public short minX;
    public short minY;
    public short maxX;
    public short maxY;
    public boolean isEnter;
    public boolean isOffline;
    public String name;
    public int goMapId;
    public short goX;
    public short goY;
    
    public Waypoint(int waypointId, String name, int minX, int minY, int maxX, int maxY, boolean isEnter, boolean isOffline, int goMapId, int goX, int goY) {
        this.waypointId = waypointId;
        this.name = name;
        this.minX = (short) minX;
        this.minY = (short) minY;
        this.maxX = (short) maxX;
        this.maxY = (short) maxY;
        this.isEnter = isEnter;
        this.isOffline = isOffline;
        this.goMapId = goMapId;
        this.goX = (short) goX;
        this.goY = (short) goY;
    }
}
