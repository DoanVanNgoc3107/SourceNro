package dragon.t;

import dragon.server.mResources;

/**
 *
 * @author TGDD
 */
public class ItemMapTask {
    
    public static void update(Char charz, ItemMap itemMap) {
        switch (charz.ctaskId) {
            case 2:
            {
                if (charz.ctaskIndex == 0 && itemMap.item.template.id == 73) {
                    charz.updateTask(1);
                    if (charz.ctaskCount > 0) {
                        charz.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.YOUR_PICK_ITEM, charz.ctaskCount, Task.getTask(charz.ctaskId).counts[charz.cgender][charz.ctaskIndex], itemMap.item.template.name), null, 0);
                    }
                }
                break;
            }
            case 8:
            {
                if (charz.ctaskIndex == 1 && itemMap.item.template.id == 20) {
                    charz.updateTask(1);
                }
                break;
            }
            case 14:
            {
                if (charz.ctaskIndex == 1 && itemMap.item.template.id == 85) {
                    charz.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOUR_PICK_STORY, null, 0);
                    charz.updateTask(1);
                }
                break;
            }
            case 31:
            {
                if (charz.ctaskIndex == 1 && itemMap.item.template.id == 380) {
                    charz.updateTask(1);
                }
                break;
            }
            case 34:
            {
                if (charz.ctaskIndex == 0 && itemMap.item.template.id == 992) {
                    charz.updateTask(1);
                }
                break;
            }
        }
    }
    
}
