package dragon.t;

/**
 *
 * @author TGDD
 */
public class MenuInfo {
    
    public String strMenu;
    public int type;
    public Object p;
    public String[] arrayStr0;
    public String stm;
    
    public MenuInfo(String str, int type) {
        this.strMenu = str;
        this.type = type;
    }
    
    public MenuInfo(String str, int type, Object p) {
        this.strMenu = str;
        this.type = type;
        this.p = p;
    }
    
    public boolean execute() {
        return true;
    }
    
    public void clean() {
        
    }
    
}
