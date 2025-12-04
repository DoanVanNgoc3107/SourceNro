package dragon.t;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class CharTemplate {
    
    public int id;
    public String name;
    public byte type;
    public short headId;
    public short bodyId;
    public short legId;
    public long cPower;
    public int cHPGoc;
    public int cMPGoc;
    public int cDamGoc;
    public int cDefGoc;
    public int cCriticalGoc;
    public int cDefPercentGoc;
    public int cMissPercentGoc;
    public short[] skills;
    public byte cgender;
    public byte nClassId;
    public byte typeTeleport;
    public byte pDamHP;
    public int maxDamageTo;
    public byte maxPercentHPTo;
    public boolean isSee;
    public int setSamllHit;
    public boolean isGo;
    public boolean isCome;
    public int strike;
    public int autoMove;
    public ArrayList<Char.ChatGameBot> chatGameBot;
    
    public CharTemplate(ResultSet res) {
        try {
            this.id = res.getInt("id");
            this.name = res.getString("name");
            this.type = res.getByte("type");
            this.headId = res.getShort("headId");
            this.bodyId = res.getShort("bodyId");
            this.legId = res.getShort("legId");
            this.cPower = res.getLong("cPower");
            this.cHPGoc = res.getInt("cHPGoc");
            this.cMPGoc = res.getInt("cMPGoc");
            this.cDamGoc = res.getInt("cDamGoc");
            this.cDefGoc = res.getInt("cDefGoc");
            this.cCriticalGoc = res.getInt("cCriticalGoc");
            this.cDefPercentGoc = res.getInt("cDefPercentGoc");
            this.cMissPercentGoc = res.getInt("cMissPercentGoc");
            JSONArray jarr = (JSONArray) JSONValue.parseWithException(res.getString("skills"));
            this.skills = new short[jarr.size()];
            for (int i = 0; i < this.skills.length; i++) {
                this.skills[i] = Short.parseShort(jarr.get(i).toString());
            }
            this.cgender = res.getByte("cgender");
            this.nClassId = res.getByte("nClassId");
            this.typeTeleport = res.getByte("typeTeleport");
            this.pDamHP = res.getByte("pDamHP");
            this.maxDamageTo = res.getInt("maxDamageTo");
            this.maxPercentHPTo = res.getByte("maxPercentHPTo");
            this.isSee = res.getBoolean("isSee");
            this.setSamllHit = res.getInt("smallHit");
            this.isGo = res.getBoolean("isGo");
            this.isCome = res.getBoolean("isCome");
            this.strike = res.getInt("strike");
            this.autoMove = res.getInt("autoMove");
            jarr = (JSONArray) JSONValue.parseWithException(res.getString("chatGameBot"));
            this.chatGameBot = new ArrayList<>();
            for (int i = 0; i < jarr.size(); i++) {
                JSONArray jarr2 = (JSONArray) jarr.get(i);
                this.chatGameBot.add(new Char.ChatGameBot(Integer.parseInt(jarr2.get(0).toString()), jarr2.get(1).toString()));
            }
        } catch (SQLException | ParseException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    public static CharTemplate[] arrCharTemplate;
    
    public static CharTemplate get(int id) {
        int i;
        for (i = 0; i < arrCharTemplate.length; i++) {
            if (arrCharTemplate[i].id == id) {
                return arrCharTemplate[i];
            }
        }
        return null;
    }
    
}
