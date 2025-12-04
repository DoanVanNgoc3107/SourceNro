package dragon.t;

/**
 *
 * @author TGDD
 */
public class TextBox {
    
    private static TextBox instance;
    
    public static TextBox gI() {
        if (instance == null) {
            instance = new TextBox();
        }
        return instance;
    }
    
    public void textBoxId(Char charz, short menuId, String str) {
        Util.gI().log("texboxId="+menuId+" str="+str);
    }
    
}
