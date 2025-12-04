package dragon.t;
public class MenuInfo2 {
    
    public int id;
    public String caption;
    public String caption2;
    public Object p;

    public MenuInfo2(String caption, String caption2, int id) {
        this.id = id;
        this.caption = caption;
        this.caption2 = caption2;
    }

    public MenuInfo2(String caption, String caption2, int id, Object p) {
        this.id = id;
        this.caption = caption;
        this.caption2 = caption2;
        this.p = p;
    }
    
    public boolean execute() {
        return true;
    }
    
    public void clean() {
        
    }
}
