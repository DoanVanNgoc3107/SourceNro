package dragon.t;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Stack;
import javax.imageio.ImageIO;


/**
 *
 * @author Admin
 */
public class MapTemplate {
    
    public static MapTemplate[] arrMapTemplate;
    
    public static final int T_EMPTY = 0;
    public static final int T_TOP = 2;
    public static final int T_LEFT = 4;
    public static final int T_RIGHT = 8;
    public static final int T_TREE = 16;
    public static final int T_WATERFALL = 32;
    public static final int T_WATERFLOW = 64;
    public static final int T_TOPFALL = 128;
    public static final int T_OUTSIDE = 256;
    public static final int T_DOWN1PIXEL = 512;
    public static final int T_BRIDGE = 1024;
    public static final int T_UNDERWATER = 2048;
    public static final int T_SOLIDGROUND = 4096;
    public static final int T_BOTTOM = 8192;
    public static final int T_DIE = 16384;
    public static final int T_HEBI = 32768;
    public static final int T_BANG = 65536;
    public static final int T_JUM8 = 131072;
    public static final int T_NT0 = 262144;
    public static final int T_NT1 = 524288;
    public static final int T_CENTER = 1;
    
    public static byte size = 24;
    
    public static final byte MAP_NORMAL = 0;
    public static final int TRAIDAT_DOINUI = 0;
    public static final int TRAIDAT_RUNG = 1;
    public static final int TRAIDAT_DAORUA = 2;
    public static final int TRAIDAT_DADO = 3;
    public static final int NAMEK_THUNGLUNG = 5;
    public static final int NAMEK_DOINUI = 4;
    public static final int NAMEK_RUNG = 6;
    public static final int NAMEK_DAO = 7;
    public static final int SAYAI_DOINUI = 8;
    public static final int SAYAI_RUNG = 9;
    public static final int SAYAI_CITY = 10;
    public static final int SAYAI_NIGHT = 11;
    public static final int KAMISAMA = 12;
    public static final int TIME_ROOM = 13;
    public static final int HELL = 15;
    public static final int BEERUS = 16;
    
    public static int[] offlineId = new int[] {21, 22, 23, 39, 40, 41};

    public static int[] highterId = new int[] {21, 22, 23, 24, 25, 26};

    public static int[] toOfflineId = new int[] {0, 7, 14};
    
    public static int yWater = 0;
    
    public int mapTemplateId;
    public int tmw;
    public int tmh;
    public int pxw;
    public int pxh;
    public int tileID;
    public int lastTileID = -1;
    public int[] maps;
    public int[] types;
    
    public int[] iX;
    public int[] iY;
    public int[] iW;
    public int iCount;
    public boolean isMapDouble = false;
    public String mapName = "";
    public byte versionMap = 1;
    public int lastBgID = -1;
    public int zoneID;
    public int bgID;
    public int bgType;
    public int lastType = -1;
    public int typeMap;
    public byte planetID;
    public byte lastPlanetId = -1;
    public long timeTranMini;
    
    public int[][] tileType;
    public int[][][] tileIndex;
    public int sizeMiniMap = 2;
    public int gssx;
    public int gssxe;
    public int gssy;
    public int gssye;
    public int countx;
    public int county;
    
    public String[] arrWaypoint_name;
    public int[] arrWaypoint_minX;
    public int[] arrWaypoint_minY;
    public int[] arrWaypoint_maxX;
    public int[] arrWaypoint_maxY;
    public boolean[] arrWaypoint_isEnter;
    public boolean[] arrWaypoint_isOffline;
    public int[] arrWaypoint_goMapID;
    public int[] arrWaypoint_goX;
    public int[] arrWaypoint_goY;
    
    public int[] arrMob_templateId;
    public int[] arrMob_level;
    public int[] arrMob_pointx;
    public int[] arrMob_pointy;
    
    public int[] arrNPC_status;
    public int[] arrNPC_cx;
    public int[] arrNPC_cy;
    public int[] arrNPC_templateId;
    public int[] arrNPC_avatar;
    
    public ArrayList<Short[]> arrBgItem;
    public ArrayList<String[]> arrEffect;
    
    public void setTile(int index, int[] mapsArr, int type) {
        for (int i = 0; i < mapsArr.length; i++) { 
            if (maps[index] == mapsArr[i]) {
                types[index] |= type;
                return;
            }
        }
    }
    
    public short touchY(int x, int y) {
        while(y < this.pxh) {
            if (this.tileTypeAt(x, y, T_TOP)) {
                return (short) y;
            }
            y++;
        }
        return (short) this.pxh;
    }
    
    public boolean isTouchY(int x, int y) {
        while(y < this.pxh - 24) {
            if (this.tileTypeAt(x, y, T_TOP)) {
                return true;
            }
            y++;
        }
        return false;
    }
    
    public boolean isBarrierY(int x, int preY, int goY) {
        while(preY < goY) {
            if (this.tileTypeAt(x, preY, T_TOP)) {
                return true;
            }
            preY++;
        }
        return false;
    }
    
    public void loadMap(int tileId) {
        pxh = tmh * (int)size;
        pxw = tmw * (int)size;
        int num = tileId - 1;
        try {
            for (int i = 0; i < tmw * tmh; i++) {
                for (int j = 0; j < tileType[num].length; j++) {
                    setTile(i, tileIndex[num][j], tileType[num][j]);
                }
            }
        } catch (Exception ex) {
        }
        this.drawMap();
    }
    
    public boolean isInAirMap() {
        return mapTemplateId == 45 || mapTemplateId == 46 || mapTemplateId == 48;
    }
    
    public boolean isDoubleMap() {
        return isMapDouble || mapTemplateId == 45 || mapTemplateId == 46 || mapTemplateId == 48 || mapTemplateId == 51 || mapTemplateId == 52 || mapTemplateId == 103 || mapTemplateId == 112 || mapTemplateId == 113 || mapTemplateId == 115 || mapTemplateId == 117 || mapTemplateId == 118 || mapTemplateId == 119 || mapTemplateId == 120 || mapTemplateId == 121 || mapTemplateId == 125 || mapTemplateId == 129 || mapTemplateId == 130;
    }

    public boolean isWaterEff() {
        return mapTemplateId != 54 && mapTemplateId != 55 && mapTemplateId != 56 && mapTemplateId != 57 && mapTemplateId != 138;
    }
    
    public int tileAt(int x, int y) {
        int result;
        try {
            result = maps[y * tmw + x];
        } catch (Exception ex) {
            result = 1000;
        }
        return result;
    }
    
    public int tileTypeAt(int x, int y) {
        int result;
        try {
            result = types[y * tmw + x];
        } catch (Exception ex) {
            result = 1000;
        }
        return result;
    }
    
    public int tileTypeAtPixel(int px, int py) {
        int result;
        try {
            result = types[py / (int)size * tmw + px / (int)size];
        } catch (Exception ex) {
            result = 1000;
        }
        return result;
    }
    
    public boolean tileTypeAt(int px, int py, int t) {
        boolean result;
        try {
            result = ((types[py / (int)size * tmw + px / (int)size] & t) == t);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
    
    public void setTileTypeAtPixel(int px, int py, int t) {
        types[py / (int)size * tmw + px / (int)size] |= t;
    }
    
    public void setTileTypeAt(int x, int y, int t) {
        types[y * tmw + x] = t;
    }
    
    public void killTileTypeAt(int px, int py, int t) {
        types[py / (int)size * tmw + px / (int)size] &= ~t;
    }
    
    public int tileYofPixel(int py) {
        return py / (int)size * (int)size;
    }
    
    public int tileXofPixel(int px) {
        return px / (int)size * (int)size;
    }
    
    public boolean tileTypeAt(int px, int py, int t, int kt) {
        boolean result;
        try {
            result = ((types[py / (int)kt * tmw + px / (int)kt] & t) == t);
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
    
//    int argbCollision[];
    BufferedImage imageCollision;
    
    public boolean isCollisionPixel(int px, int py, int pixel) {
//        System.out.println("peixel1="+(this.argbCollision[py * this.pxw + px])+" pixel2="+(pixel));
        return px > 0 && px < this.pxw && py > 0 && py < this.pxh && this.imageCollision.getRGB(px, py) == pixel;
    }

    public int getCollisionPixel(int px, int py) {
        return this.imageCollision.getRGB(px, py);
//        return this.argbCollision[py * this.pxw + px];
    }
    
    public static void initCollisionPixel() {
        System.out.println("Load Collsion");
        File file = new File("res/imageCollision/"), files[] = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            String name = files[i].getName();
            if (name.contains(".")) {
                name = name.substring(0, name.lastIndexOf("."));
            }
            try {
                int templagteId = Integer.parseInt(name);
                MapTemplate.arrMapTemplate[templagteId].imageCollision = ImageIO.read(files[i]);
//                MapTemplate.arrMapTemplate[templagteId].argbCollision = new int[img.getWidth() * img.getHeight()];
//                img.getRGB(i, i);
//                img.getRGB(0, 0, img.getWidth(), img.getHeight(), MapTemplate.arrMapTemplate[templagteId].argbCollision, 0, img.getWidth());
            } catch (Exception e) {
            }
        }
    }
    
    public void drawMap() {
        if (this.maps.length == 0) return;
        if (this.maps.length != -1) return;
//        if (this.mapTemplateId != 162 && this.mapTemplateId != 163) return;
//
        int zoom = 1;
        int kt = 24 * zoom;
        try {
            BufferedImage imgMap = new BufferedImage(this.tmw * kt, this.tmh * kt, BufferedImage.TYPE_INT_RGB);
            int x = 0;
            int y = 0;
            int[] black = new int[kt * kt]; for (int k = 0; k < black.length; k++) black[k] = 0xff000000;
            int[] white = new int[kt * kt]; for (int k = 0; k < white.length; k++) white[k] = 0xFFFFFFFF;
            int[] green = new int[kt * kt]; for (int k = 0; k < green.length; k++) green[k] = 0xFF00FF00;
            for (int i = 0; i < this.maps.length; i++) {
                if (this.maps[i] != 0) {
                    imgMap.setRGB(x * kt, y * kt, kt, kt, black, 0,kt);
                } else {
                    imgMap.setRGB(x * kt, y * kt, kt, kt, green, 0,kt);
                }
//                if (this.isWay(150, 150, x * kt, y * kt)) {
                    if (this.types[i] == 0){
                        imgMap.setRGB(x * kt, y * kt, kt, kt, green, 0, kt);
                    }
//                }
                //SET XY
                x++;
                if (x == this.tmw) {
                    x = 0;
                    y++;
                }
            }
            fill(imgMap, 120, 150, new Color(0, 255, 0), new Color(255, 255, 255));
            ImageIO.write(imgMap, "png", new File("imgMap/"+this.mapTemplateId+ ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void fill(BufferedImage image, int startX, int startY, Color targetColor, Color replacementColor) {
        int width = image.getWidth();
        int height = image.getHeight();
        int targetRGB = targetColor.getRGB();
        int replacementRGB = replacementColor.getRGB();

        // Kiểm tra điểm bắt đầu hợp lệ
        if (startX < 0 || startX >= width || startY < 0 || startY >= height) {
            return;
        }

        // Kiểm tra màu tại điểm bắt đầu
        if (image.getRGB(startX, startY) != targetRGB) {
            return;
        }

        // Sử dụng stack để lưu các điểm cần tô màu
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(startX, startY));

        while (!stack.isEmpty()) {
            Point point = stack.pop();
            int x = point.x;
            int y = point.y;

            // Kiểm tra giới hạn của hình ảnh
            if (x < 0 || x >= width || y < 0 || y >= height) {
                continue;
            }

            // Kiểm tra màu tại điểm hiện tại
            if (image.getRGB(x, y) != targetRGB) {
                continue;
            }

            // Tô màu điểm hiện tại
            image.setRGB(x, y, replacementRGB);

            // Đưa các điểm lân cận vào stack
            stack.push(new Point(x - 1, y));     // Điểm bên trái
            stack.push(new Point(x + 1, y));     // Điểm bên phải
            stack.push(new Point(x, y - 1));     // Điểm phía trên
            stack.push(new Point(x, y + 1));     // Điểm phía dưới
        }
    }
}
