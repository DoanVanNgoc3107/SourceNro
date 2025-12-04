package dragon.t;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class ItemTemplate {
    
    public short id;
    public byte type;
    public byte gender;
    public String name;
    public String[] subName;
    public String description;
    public byte level;
    public short iconID;
    public short part;
    public boolean isUpToUp;
    public int w;
    public int h;
    public int strRequire;
    public boolean isNew;
    
    public static void add(ItemTemplate it) {
    	if (it.isNew) {
    		itemTemplatesNew.add(it);
    	} else {
    		itemTemplates.put(it.id, it);
    	}
    }
    
    public static ItemTemplate get(short id) {
    	if (!itemTemplates.containsKey(id)) {
    		for (int i = 0; i < itemTemplatesNew.size(); i++) {
    			if (itemTemplatesNew.get(i).id == id) return itemTemplatesNew.get(i);
    		}
    		return null;
    	}
        return itemTemplates.get(id);
    }
    
    public static short getPart(short itemTemplateID) {
        return get(itemTemplateID).part;
    }
    
    public static short getIcon(short itemTemplateID) {
        return get(itemTemplateID).iconID;
    }
    
    public static final HashMap<Short, ItemTemplate> itemTemplates = new HashMap<>();
    public static final ArrayList<ItemTemplate> itemTemplatesNew = new ArrayList<>();
}
