package dragon.t;

import dragon.server.Dragon;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class EffectData {
    
    public byte[] img;
    public int[][] imgInfo;
    public int[][][] frame;
    public short[] arrFrame;
    public int ID;
    public int typeread;
    public int typeData;
    public int width;
    public int height;
    public int[][] frame_NEWBOSS;
    
    public EffectData(int ID, String str, int type) throws ParseException {
        this.ID = ID;
        JSONArray jarr = (JSONArray) JSONValue.parseWithException(str);
        //ImageInfo
        JSONArray jarr2 = (JSONArray) jarr.get(0);
        this.imgInfo = new int[jarr2.size()][];
        for (int i = 0; i < jarr2.size(); i++) {
            this.imgInfo[i] = new int[5];
            JSONArray jarr7 = (JSONArray) jarr2.get(i);
            this.imgInfo[i][0] = Integer.parseInt(jarr7.get(0).toString());
            this.imgInfo[i][1] = Integer.parseInt(jarr7.get(1).toString());
            this.imgInfo[i][2] = Integer.parseInt(jarr7.get(2).toString());
            this.imgInfo[i][3] = Integer.parseInt(jarr7.get(3).toString());
            this.imgInfo[i][4] = Integer.parseInt(jarr7.get(4).toString());
        }
        //Frame
        JSONArray jarr3 = (JSONArray) jarr.get(1);
        this.frame = new int[jarr3.size()][][];
        for (int j = 0; j < jarr3.size(); j++) {
            JSONArray jarr4 = (JSONArray) jarr3.get(j);
            this.frame[j] = new int[jarr4.size()][];
            for (int k = 0; k < jarr4.size(); k++) {
                JSONArray jarr5 = (JSONArray) jarr4.get(k);
                this.frame[j][k] = new int[3];
                this.frame[j][k][0] = Integer.parseInt(jarr5.get(0).toString());
                this.frame[j][k][1] = Integer.parseInt(jarr5.get(1).toString());
                this.frame[j][k][2] = Integer.parseInt(jarr5.get(2).toString());
            }
        }
        //arrFrame
        JSONArray jarr6 = (JSONArray) jarr.get(2);
        this.arrFrame = new short[jarr6.size()];
        for (int l = 0; l < jarr6.size(); l++) {
            this.arrFrame[l] = Short.parseShort(jarr6.get(l).toString());
        }
        this.typeread = type;
    }
    
    public EffectData loadImage(int x) {
        this.img = Dragon.getFile("res/x"+ x +"/effect/"+this.ID+".png");
        return this;
    }
    
    public EffectData loadImage(int x, int typeData) {
        this.typeData = typeData;
        this.img = Dragon.getFile("res/x"+ x +"/mob/"+this.ID+".png");
        return this;
    }
    
    public EffectData loadFrame_NEWBOSS(String str) throws ParseException {
        JSONArray jarr = (JSONArray) JSONValue.parseWithException(str);
        this.frame_NEWBOSS = new int[jarr.size()][];
        for (int i = 0; i < jarr.size(); i++) {
            JSONArray jarr2 = (JSONArray) jarr.get(i);
            this.frame_NEWBOSS[i] = new int[jarr2.size()];
            for (int j = 0; j < jarr2.size(); j++) {
                this.frame_NEWBOSS[i][j] = Byte.parseByte(jarr2.get(j).toString());
            }
        }
        return this;
    }
    
    public static HashMap<Integer, HashMap<Integer, EffectData>> effectData = new HashMap<>();
    
    public static HashMap<Integer, HashMap<Integer, EffectData>> mobData = new HashMap<>();
    
    public static EffectData get(int ID, int x) {
        try {
            return effectData.get(ID).get(x);
        } catch (Exception e) {
            return null;
        }
    }
    public static EffectData get2(int ID, int x) {
        try {
            return mobData.get(ID).get(x);
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
