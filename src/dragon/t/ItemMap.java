package dragon.t;

/**
 *
 * @author Admin
 */
public class ItemMap {
    
    public ItemMap(int itemMapID, int charId, Item item, int x, int y, int r, int playerId) {
        this.itemMapID = itemMapID;
        this.charId = charId;
        this.item = item;
        this.x = x;
        this.y = y;
        this.r = r;
        this.playerId = playerId;
        this.milisecondRemove = System.currentTimeMillis() + MILISECONDEXIST;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getH() {
        return 20;
    }
    
    public int getW() {
        return 20;
    }
    
    public int x;
    public int y;
    public int charId;
    public int playerId;
    public int itemMapID;
    public int IdCharMove;
    public byte status;
    public boolean isHintFocus;
    public int r;
    
    public Item item;
    public long milisecondRemove;
    public int clanID = -1;
    public int plId = -1;
    public boolean isPickItemNotMe;
    
    public static final long MILISECONDEXIST = 80000;
    
    public static final int MILISECONDALLOW = 30000;
    
    public void setTimeRemove() {
        this.milisecondRemove = System.currentTimeMillis() + MILISECONDEXIST;
    }

}
