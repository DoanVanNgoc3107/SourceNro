package dragon.t;

import dragon.server.Session_ME;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class NangCap {
    
    public void init(){};
    public void execute(){};
   
    public final Session_ME session;
    public ArrayList<Item> myItem = new ArrayList<>();
    public int type;
    
    public NangCap(Session_ME session) {
        this.session = session;
    }
    
    public boolean isHaveItem(int... idArray) {
        if (this.myItem != null) {
            for (Item tem : this.myItem) {
                if (tem == null) {
                    continue;
                }
                for (int j = 0; j < idArray.length; j++) {
                    if (tem.template.id == idArray[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Item getItemById(int... idArray) {
        if (this.myItem != null) {
            for (Item tem : this.myItem) {
                if (tem == null) {
                    continue;
                }
                for (int j = 0; j < idArray.length; j++) {
                    if (tem.template.id == idArray[j]) {
                        return tem;
                    }
                }
            }
        }
        return null;
    }
    
    public Item getItemByType(int... typeArray) {
        if (this.myItem != null) {
            for (Item tem : this.myItem) {
                if (tem == null) {
                    continue;
                }
                for (int j = 0; j < typeArray.length; j++) {
                    if (tem.template.type == typeArray[j]) {
                        return tem;
                    }
                }
            }
        }
        return null;
    }
    
    public boolean checkBagOK() {
        for (int i = 0; i < this.myItem.size(); i++) {
            if (this.myItem.get(i) != this.session.myCharz().arrItemBag[this.myItem.get(i).indexUI]) return false;
        }
        return true;
    }
    
    
}
