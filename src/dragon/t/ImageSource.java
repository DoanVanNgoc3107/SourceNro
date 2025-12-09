package dragon.t;

import dragon.server.mResources;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * DFile này chứa các nguồn ảnh trong game
 * 
 * @author TGDD
 */
public class ImageSource {

    public static HashMap<Byte, ArrayList<String>> imageOriginals = new HashMap<>();
    public static HashMap<String, byte[]> imgData = new HashMap<>();
    public static HashMap<Byte, Integer> hVersion = new HashMap<>();

    public static void initImage() {
        System.out.println("Load ImgSources");
        ImageSource.imageOriginals.clear();
        ImageSource.hVersion.clear();
        for (int x = 1; x <= 4; x++) {
            File dir = new File(String.format("res/x%d/ImgSources", x));
            File[] files = dir.listFiles();
            ArrayList<String> myArrayList = new ArrayList<>();
            int length = 0;
            for (int i = 0; i < files.length; i++) {
                String original = files[i].getName().replace(" ; ", "/").replace(".png", "");
                myArrayList.add(original);
                length += files[i].length();
                try {
                    try (FileInputStream fileInput = new FileInputStream(files[i])) {
                        byte array[] = new byte[fileInput.available()];
                        fileInput.read(array);
                        imgData.put(String.format(mResources.PATH_IMG, x, original), array);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ImageSource.imageOriginals.put((byte) x, myArrayList);
            ImageSource.hVersion.put((byte) x, length);
        }
    }

}
