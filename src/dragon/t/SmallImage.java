package dragon.t;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author TGDD
 */
public class SmallImage {
    
    public static HashMap<Integer, byte[]> newSmallVersion = new HashMap<>();
    
    public static int[][] smallImg;
    
    public static void init() {
        System.out.println("Load SamllImage");
        SmallImage.newSmallVersion.clear();
        for (int x = 1; x <= 4; x++) {
            byte array[] = new byte[Short.MAX_VALUE];
            File dir = new File(String.format("res/x%d/icon", x));
            File[] files = dir.listFiles();
            int max = -1;
            for (int i = 0; i < files.length; i++) {
                String name = files[i].getName();
                try {
                    if (name.contains(".")) {
                        name = name.substring(0, name.lastIndexOf("."));
                    }
                    int id = Integer.parseInt(name);
                    array[id] = (byte) (files[i].length() % 127);
                    if (id > max) {
                        max = id;
                    }
                } catch (Exception e) {
                }
            }
            SmallImage.newSmallVersion.put(x, Arrays.copyOf(array, max + 1));
        }
    }

}
