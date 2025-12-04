package dragon.t;

/**
 *
 * @author TGDD
 */
public class NauBanh {
    
    public int id;
    public Item item;
    public long time;
    public boolean finish;
    public String text;
    
    public NauBanh(int sc, int id, String text, Item item) {
        this.time = ((long)sc * 1000L) + System.currentTimeMillis();
        this.id = id;
        this.item = item;
        this.text = text;
        this.finish = false;
    }
    
}
