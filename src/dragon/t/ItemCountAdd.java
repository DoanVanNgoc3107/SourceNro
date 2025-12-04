package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class ItemCountAdd {
    
    public int setCount;
    public int timeSet;
    public int time;
    public Item item;
    public int count;
    
    public static final Object LOCK = new Object();
    public static int capsuleIndex = -1;
    public static int capsuleCountUse = 0;
    
    public static boolean isHaveEterne() {
        synchronized (LOCK) {
            if (capsuleCountUse == capsuleIndex) {
                capsuleCountUse++;
                return true;
            } else {
                capsuleCountUse++;
                return false;
            }
        }
    }
    
    public static final ArrayList<ItemCountAdd> ITEMS = new ArrayList<>();
    
    
    public ItemCountAdd(Item item, int setCount, int second) {
        this.item = item;
        this.count = this.setCount = setCount;
        this.timeSet = this.time = second * 1000;
    }
    
    public static ItemCountAdd get(Item item) {
        int i;
        ItemCountAdd o = null;
        synchronized (ITEMS) {
            for (i = 0; i < ITEMS.size(); i++) {
                if (ITEMS.get(i).item == item) {
                    o = ITEMS.get(i);
                    break;
                }
            }
        }
        return o;
    }
    
    public static void update(int delay) {
        int i;
        synchronized (ITEMS) {
            for (i = ITEMS.size() - 1; i >= 0; i--) {
                if (ITEMS.get(i).count <= 0) {
                    ITEMS.get(i).time -= delay;
                    if (ITEMS.get(i).time <= 0) {
                        if (ITEMS.get(i).item.template.id == 984) {
                            capsuleCountUse = 0;
                            capsuleIndex = Util.gI().nextInt(ITEMS.get(i).setCount);
                        }
                        ITEMS.get(i).count = ITEMS.get(i).setCount;
                    }
                }
            }
        }
    }
    
    public static void downCount(Item it, int count) {
        int i;
        synchronized (ITEMS) {
            for (i = ITEMS.size() - 1; i >= 0; i--) {
                if (ITEMS.get(i).item == it) {
                    ITEMS.get(i).count -= count;
                    if (ITEMS.get(i).count <= 0) {
                        ITEMS.get(i).count = 0;
                        ITEMS.get(i).time = ITEMS.get(i).timeSet;
                    }
                    break;
                }
            }
        }
    }
    
    public static int getCount(Item it) {
        if (!isHaveCount(it)) {
            if (it.template.id == 984) {
                addCount(it, 500 , 60 * 60);
                capsuleCountUse = 0;
                capsuleIndex = Util.gI().nextInt(ItemCountAdd.get(it).setCount);
            }
            if (it.template.id == 574) {
                addCount(it, 10000, 60 * 60);
            }
            if (it.template.id == 1116) {
                addCount(it, 1000, 60 * 60);
            }
        }
        int i;
        synchronized (ITEMS) {
            for (i = ITEMS.size() - 1; i >= 0; i--) {
                if (ITEMS.get(i).item == it) {
                    return ITEMS.get(i).count;
                }
            }
        }
        return 0;
    }
    
    public static boolean isHaveCount(Item it) {
        boolean b = false;
        synchronized (ITEMS) {
            for (int i = 0; i < ITEMS.size(); i++) {
                if (ITEMS.get(i).item == it) {
                    b = true;
                    break;
                }
            }
        }
        return b;
    }
    
    public static void addCount(Item item, int setCount, int second) {
        synchronized (ITEMS) {
            ITEMS.add(new ItemCountAdd(item, setCount, second));
        }
    }
    
}
