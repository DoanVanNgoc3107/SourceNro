package dragon.t;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.HashMap;

/**
 * File này dùng để lưu thông tin các vật phẩm nền trong game
 *
 * @author TGDD
 */
public class BgItem {

    public int id;
    public short idImage;
    public byte layer;
    public short dx;
    public short dy;
    public byte[] tileX;
    public byte[] tileY;

    public BgItem(ResultSet res) throws SQLException, ParseException {
        this.id = res.getShort("id");
        this.idImage = res.getShort("idImage");
        this.layer = res.getByte("layer");
        this.dx = res.getShort("dx");
        this.dy = res.getShort("dy");
        JSONArray jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("tileX"));
        JSONArray jarr2 = (JSONArray) JSONValue.parseWithException(res.getString("tileY"));
        this.tileX = new byte[jarr1.size()];
        this.tileY = new byte[jarr2.size()];
        for (int i = 0; i < tileX.length; i++) {
            this.tileX[i] = Byte.parseByte(jarr1.get(i).toString());
            this.tileY[i] = Byte.parseByte(jarr2.get(i).toString());
        }
    }

    public static HashMap<Integer, byte[]> newSmallVersion = new HashMap<>();

    public static HashMap<Byte, byte[][]> images = new HashMap<>();

    public static ArrayList<BgItem> aItemBg = new ArrayList<>();

    public static void init() {
        System.out.println("Load BgItem");
        BgItem.newSmallVersion.clear();
        for (int x = 1; x <= 4; x++) {
            byte[] array = new byte[Short.MAX_VALUE];
            File dir = new File(String.format("res/x%d/bgItem", x));
            File[] files = dir.listFiles();
            if (files == null) {
                continue;
            }
            int max = -1;
            images.put((byte) x, new byte[files.length][]);
            for (File file : files) {
                String name = file.getName();
                try {
                    if (name.contains(".")) {
                        name = name.substring(0, name.lastIndexOf("."));
                    }
                    int id = Integer.parseInt(name);
                    array[id] = (byte) (file.length() % 127);
                    try (FileInputStream fi = new FileInputStream(file)) {
                        images.get((byte) x)[id] = new byte[fi.available()];
                        fi.read(images.get((byte) x)[id]);
                        if (id > max) {
                            max = id;
                        }
                    } catch (Exception e) {
                        System.out.println("BgItem read file error: " + e.getMessage());
                    }
                } catch (Exception e) {
                    System.out.println("BgItem init error: " + e.getMessage());
                }
            }
            BgItem.newSmallVersion.put(x, Arrays.copyOf(array, max + 1));
        }
    }

}
