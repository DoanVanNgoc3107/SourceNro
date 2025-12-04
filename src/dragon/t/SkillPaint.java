package dragon.t;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class SkillPaint {
    
    public int id;
    
    public int effectHappenOnMob;
    
    public int numEff;
    
    public SkillInfoPaint[] skillStand;
    
    public SkillInfoPaint[] skillfly;
    
    
    public SkillPaint(ResultSet res) throws SQLException, ParseException {
        this.id = res.getShort("skillId");
        this.effectHappenOnMob = res.getShort("effectHappenOnMob");
        this.numEff = res.getByte("numEff");
        JSONArray jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("skillStand"));
        this.skillStand = new SkillInfoPaint[jarr1.size()];
        for (int i1 = 0; i1 < jarr1.size(); i1++) {
            JSONArray jarr2 = (JSONArray) jarr1.get(i1);
            this.skillStand[i1] = new SkillInfoPaint();
            this.skillStand[i1].status = Byte.parseByte(jarr2.get(0).toString());
            this.skillStand[i1].effS0Id = Short.parseShort(jarr2.get(1).toString());
            this.skillStand[i1].e0dx = Short.parseShort(jarr2.get(2).toString());
            this.skillStand[i1].e0dy = Short.parseShort(jarr2.get(3).toString());
            this.skillStand[i1].effS1Id = Short.parseShort(jarr2.get(4).toString());
            this.skillStand[i1].e1dx = Short.parseShort(jarr2.get(5).toString());
            this.skillStand[i1].e1dy = Short.parseShort(jarr2.get(6).toString());
            this.skillStand[i1].effS2Id = Short.parseShort(jarr2.get(7).toString());
            this.skillStand[i1].e2dx = Short.parseShort(jarr2.get(8).toString());
            this.skillStand[i1].e2dy = Short.parseShort(jarr2.get(9).toString());
            this.skillStand[i1].arrowId = Short.parseShort(jarr2.get(10).toString());
            this.skillStand[i1].adx = Short.parseShort(jarr2.get(11).toString());
            this.skillStand[i1].ady = Short.parseShort(jarr2.get(12).toString());
        }
        jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("skillfly"));
        this.skillfly = new SkillInfoPaint[jarr1.size()];
        for (int i2 = 0; i2 < jarr1.size(); i2++) {
            JSONArray jarr3 = (JSONArray) jarr1.get(i2);
            this.skillfly[i2] = new SkillInfoPaint();
            this.skillfly[i2].status = Byte.parseByte(jarr3.get(0).toString());
            this.skillfly[i2].effS0Id = Short.parseShort(jarr3.get(1).toString());
            this.skillfly[i2].e0dx = Short.parseShort(jarr3.get(2).toString());
            this.skillfly[i2].e0dy = Short.parseShort(jarr3.get(3).toString());
            this.skillfly[i2].effS1Id = Short.parseShort(jarr3.get(4).toString());
            this.skillfly[i2].e1dx = Short.parseShort(jarr3.get(5).toString());
            this.skillfly[i2].e1dy = Short.parseShort(jarr3.get(6).toString());
            this.skillfly[i2].effS2Id = Short.parseShort(jarr3.get(7).toString());
            this.skillfly[i2].e2dx = Short.parseShort(jarr3.get(8).toString());
            this.skillfly[i2].e2dy = Short.parseShort(jarr3.get(9).toString());
            this.skillfly[i2].arrowId = Short.parseShort(jarr3.get(10).toString());
            this.skillfly[i2].adx = Short.parseShort(jarr3.get(11).toString());
            this.skillfly[i2].ady = Short.parseShort(jarr3.get(12).toString());
        }
    }
    
    public static SkillPaint[] sks;
    
}
