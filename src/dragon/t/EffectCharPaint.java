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
public class EffectCharPaint {
    
    public int idEf;
    
    public EffectInfoPaint[] arrEfInfo;
    
    public EffectCharPaint(ResultSet res) throws SQLException, ParseException {
        this.idEf = res.getShort("idEf");
        JSONArray jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("arrEfInfo"));
        this.arrEfInfo = new EffectInfoPaint[jarr1.size()];
        for (int i1 = 0; i1 < jarr1.size(); i1++) {
            JSONArray jarr2 = (JSONArray) jarr1.get(i1);
            this.arrEfInfo[i1] = new EffectInfoPaint();
            this.arrEfInfo[i1].idImg = Short.parseShort(jarr2.get(0).toString());
            this.arrEfInfo[i1].dx = Byte.parseByte(jarr2.get(1).toString());
            this.arrEfInfo[i1].dy = Byte.parseByte(jarr2.get(2).toString());
        }
    }
    
    public static EffectCharPaint[] efs;
    
}
