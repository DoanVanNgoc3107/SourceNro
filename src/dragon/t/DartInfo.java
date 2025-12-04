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
public class DartInfo {
    
    public short id;

    public short[][] head;

    public short[][] headBorder;

    public short[] tail;

    public short[] tailBorder;

    public short[] xd1;

    public short[] xd2;

    public short xdPercent;

    public short nUpdate;

    public int va;
    
    public DartInfo(ResultSet res) throws SQLException, ParseException {
        this.id = res.getShort("id");
        this.nUpdate = res.getShort("nUpdate");
        this.va = res.getShort("va");
        this.xdPercent = res.getShort("xdPercent");
        JSONArray jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("tail"));
        this.tail = new short[jarr1.size()];
        for (int i1 = 0; i1 < jarr1.size(); i1++) {
            tail[i1] = Short.parseShort(jarr1.get(i1).toString());
        }
        jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("tailBorder"));
        this.tailBorder = new short[jarr1.size()];
        for (int i2 = 0; i2 < jarr1.size(); i2++) {
            tailBorder[i2] = Short.parseShort(jarr1.get(i2).toString());
        }
        jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("xd1"));
        this.xd1 = new short[jarr1.size()];
        for (int i3 = 0; i3 < jarr1.size(); i3++) {
            xd1[i3] = Short.parseShort(jarr1.get(i3).toString());
        }
        jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("xd2"));
        this.xd2 = new short[jarr1.size()];
        for (int i4 = 0; i4 < jarr1.size(); i4++) {
            xd2[i4] = Short.parseShort(jarr1.get(i4).toString());
        }
        jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("head"));
        this.head = new short[jarr1.size()][];
        for (int i5 = 0; i5 < jarr1.size(); i5++) {
            JSONArray jarr2 = (JSONArray) jarr1.get(i5);
            head[i5] = new short[jarr2.size()];
            for (int i6 = 0; i6 < jarr2.size(); i6++) {
                head[i5][i6] = Short.parseShort(jarr2.get(i6).toString());
            }
        }
        jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("headBorder"));
        this.headBorder = new short[jarr1.size()][];
        for (int i7 = 0; i7 < jarr1.size(); i7++) {
            JSONArray jarr3 = (JSONArray) jarr1.get(i7);
            headBorder[i7] = new short[jarr3.size()];
            for (int i8 = 0; i8 < jarr3.size(); i8++) {
                headBorder[i7][i8] = Short.parseShort(jarr3.get(i8).toString());
            }
        }
    }
    
    public static DartInfo[] darts;
    
}
