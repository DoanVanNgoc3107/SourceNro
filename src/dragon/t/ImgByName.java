package dragon.t;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author TGDD
 */
public class ImgByName {
    
    public String nameImg;
    public int nFrame;
    public byte data[];

    public ImgByName(String nameImg, int nFrame, byte[] data) {
        this.nameImg = nameImg;
        this.nFrame = nFrame;
        this.data = data;
    }
    
    public static HashMap<Byte, HashMap<String, ImgByName>> imgByNames = new HashMap();
    
    public static void initImgByName() {
        System.out.println("Load ImgByName");
        ImgByName.imgByNames.clear();
        for (byte x = 1; x <= 4; x++) {
            ImgByName.imgByNames.put(x, new HashMap<>());
            
            File dir = new File(String.format("res/x%d/ImgByName", x));
            File[] files = dir.listFiles();
            
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                int num = fileName.lastIndexOf("_");
                String name = fileName.substring(0, num);
                int nFrame = Integer.parseInt(fileName.substring(num + 1, fileName.length()).replace(".png", ""));
                
                try {
                    FileInputStream fileInput = new FileInputStream(files[i]);
                    byte array[] = new byte[fileInput.available()];
                    fileInput.read(array);
                    ImgByName.imgByNames.get(x).put(name, new ImgByName(name, nFrame, array));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
