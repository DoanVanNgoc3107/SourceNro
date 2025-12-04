package dragon.t;

/**
 *
 * @author TGDD
 */
public class Head {
    
    public static short[] idHead;
    public static short[] idAvatar;
    
    public static int getHeadICON(int head) {
        int i;
        for (i = 0; i < idHead.length; i++) {
            if (idHead[i] == head) {
                return idAvatar[i];
            }
        }
        return -1;
    }
    
}
