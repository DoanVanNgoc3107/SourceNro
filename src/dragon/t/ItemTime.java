package dragon.t;

/**
 *
 * @author Admin
 */
public class ItemTime {
    
    public short idIcon;
    public int second;
    public long last;
    public int type;
    public int time = 1000;
    public int damage;
    public Item item;
    public String text;
    private boolean isText;
    
    public ItemTime(short idIcon, int second, int type, int damage) {
        this.idIcon = idIcon;
        this.second = second;
        this.last = System.currentTimeMillis();
        this.type = type;
        this.damage = damage;
    }
    
    public ItemTime(short id, String text, int second, int type, int damage) {
        this.isText = true;
        this.second = second;
        this.last = System.currentTimeMillis();
        this.idIcon = (short)id;
        this.type = type;
        this.text = text;
        this.damage = damage;
    }
    
    public void initTime(int second, int type, int damage) {
        this.second = second;
        this.last = System.currentTimeMillis();
        this.type = type;
        this.damage = damage;
    }
    
    public void initTimeText(String text, int second, int type, int damage) {
        this.isText = true;
        this.second = second;
        this.last = System.currentTimeMillis();
        this.type = type;
        this.text = text;
        this.damage = damage;
    }
}
