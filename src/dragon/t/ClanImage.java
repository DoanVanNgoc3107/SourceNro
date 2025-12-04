package dragon.t;

import java.util.HashMap;

/**
 *
 * @author TGDD
 */
public class ClanImage {
    
    public int ID;
    public String name;
    public short[] idImage;
    public short[] idImage2;
    
    public static int[][] clanImage = new int[][] {
        {0, 10000, 1},
        {8, 10000, 1},
        {7, 10000, 1},
        {6, 10000, 1},
        {5, 10000, 1},
        {4, 10000, 1},
        {3, 10000, 1},
        {2, 10000, 1},
        {1, 10000, 1},
        {18, 50000, 1},
        {17, 50000, 1},
        {16, 50000, 1},
        {15, 50000, 1},
        {14, 50000, 1},
        {13, 50000, 1},
        {12, 50000, 1},
        {11, 50000, 1},
        {10, 50000, 1},
        {9, 50000, 1},
        {27, 100000, 1},
        {26, 100000, 1},
        {25, 100000, 1},
        {24, 100000, 1},
        {23, 100000, 1},
        {36, 0, 50},
        {35, 0, 50},
        {34, 0, 50},
        {33, 0, 50},
        {32, 0, 50},
        {19, 0, 200},
        {22, 0, 300},
        {21, 0, 400},
        {20, 0, 500},
        {29, 0, 600},
    };
    
    public static int[] getClanImage(int imgID) {
        int i;
        for (i = 0; i < clanImage.length; i++) {
            if (clanImage[i][0] == imgID) {
                return clanImage[i];
            }
        }
        return null;
    }
    
    public static HashMap<Integer, ClanImage> images = new HashMap();
}
