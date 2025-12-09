package dragon.t;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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
            for (ItemTemplate itemTemplate : itemTemplatesNew) {
                if (itemTemplate.id == id) return itemTemplate;
            }
    		return null;
    	}
        return itemTemplates.get(id);
    }
    
    public static short getPart(short itemTemplateID) {
        return Objects.requireNonNull(get(itemTemplateID)).part;
    }
    
    public static short getIcon(short itemTemplateID) {
        return Objects.requireNonNull(get(itemTemplateID)).iconID;
    }
    
    public static final HashMap<Short, ItemTemplate> itemTemplates = new HashMap<>();
    public static final ArrayList<ItemTemplate> itemTemplatesNew = new ArrayList<>();
}
