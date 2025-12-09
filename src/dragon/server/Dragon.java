package dragon.server;

import dragon.t.BgItem;
import dragon.t.GameData;
import dragon.t.GameInfo;
import dragon.t.ImageSource;
import dragon.t.ImgByName;
import dragon.t.LuckyRoundNew;
import dragon.t.LuyenTap;
import dragon.t.Map;
import dragon.t.MapTemplate;
import dragon.t.NamekBall;
import dragon.t.SmallImage;
import dragon.t.SuperRank;
import dragon.t.Util;
import hethong.ServerActivity;
import io.Message;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Dragon {

    protected static byte vData = 27;
    protected static byte vMap = 21;
    protected static byte vSkill = 14;
    protected static byte vItem = 37;

    public static boolean isEvent_Noel = false;
    public static boolean isEvent_Mabu = false;
    public static boolean isEvent_NHS = false;
    public static boolean isEvent_NgayHe = false;
    public static boolean isEvent_TrungThu = false;
    public static boolean isEvent_Halloween = false;
    public static boolean isEvent_WorldCup2022 = false;
    public static boolean isEvent_TetNguyenDan = false;
    public static boolean isEvent_Girl = false;
    public static boolean isEvent_HungVuong = false;
    public static boolean isEvent_HE2023 = false;
    public static boolean isEvent_DIET_SAU_BO_2023 = false;
    public static boolean isEvent_VIP = false;
    public static boolean isEvent_VULAN2023 = false;

    public static void main(String[] args) {
        Util.gI().setDebug(false);
        System.out.println("DEBUG=" + Util.gI().debug);
        ServerActivity.gI().Activity();
        GameData.init();
        ImageSource.initImage();
        ImgByName.initImgByName();
        Server.init();
        MapTemplate.initCollisionPixel();
        Map.initMapServer();
        Server.gI().openCace23();
        SmallImage.init();
        BgItem.init();
        GameInfo.init();
        Server.gI().initEvent();
       Server.gI().initAnTrom();
        Server.gI().initNpc();
        NamekBall.gI().initNamekBall();
        Server.gI().openPrize();
        SuperRank.init();
        LuckyRoundNew.init();
        LuyenTap.init();
        Server.gI().initBroly();
        Server.gI().initKuku();
        Server.gI().initMap_Dau_Dinh();
        Server.gI().initRambo();
        Server.gI().initBotTop();
        Server.gI().initMabu();
        Server.start(14445);
    }

    public static byte[] getFile(String url) {
        FileInputStream openFileInput;
        try {
            openFileInput = new FileInputStream(url);
            byte[] data = new byte[openFileInput.available()];
            openFileInput.read(data);
            openFileInput.close();
            return data;
        } catch (IOException e) {
            System.out.println("Path " + url);
//            e.printStackTrace();
        }
        return null;
    }

    public static void saveFile(String url, byte[] ab) {
        FileOutputStream fos;
        try {
            File f = new File(url);
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            fos = new FileOutputStream(url);
            fos.write(ab);
            fos.flush();
            fos.close();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }

    protected static void writeByteArray(Message msg, byte[] ab) {
        try {
            msg.writer().writeInt(ab.length);
            msg.writer().write(ab);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
