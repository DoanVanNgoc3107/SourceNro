package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class Flag {
    
    public int id;
    public String name;
    public Item itemFlag;
    
    public Flag(int id, String name, Item item) {
        this.id = id;
        this.name = name;
        this.itemFlag = item;
    }
    
    public static Flag get(int itemTemplateId) {
        for (int i = 0; i < Flag.FLAGS.size(); i++) {
            if (Flag.FLAGS.get(i).itemFlag.template.id == itemTemplateId) {
                return Flag.FLAGS.get(i);
            }
        }
        return null;
    }
    
    public static final ArrayList<Flag> FLAGS = new ArrayList<>();
    
}
