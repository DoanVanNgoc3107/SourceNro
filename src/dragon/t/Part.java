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
public class Part {
    
    public Part(int type) {
        this.type = type;
        if (type == 0) {
            this.pi = new PartImage[3];
        }
        if (type == 1) {
            this.pi = new PartImage[17];
        }
        if (type == 2) {
            this.pi = new PartImage[14];
        }
        if (type == 3) {
            this.pi = new PartImage[2];
        }
    }
    
    public Part(ResultSet res) {
        try {
            int i;
            this.type = res.getByte(2);
            if (this.type == 0) {
                this.pi = new PartImage[3];
            }
            if (this.type == 1) {
                this.pi = new PartImage[17];
            }
            if (this.type == 2) {
                this.pi = new PartImage[14];
            }
            if (this.type == 3) {
                this.pi = new PartImage[2];
            }
            JSONArray jarr = (JSONArray) JSONValue.parseWithException(res.getString(3));
            for (i = 0; i  < this.pi.length; i++) {
                JSONArray jarr2 = (JSONArray) jarr.get(i);
                this.pi[i] = new PartImage();
                this.pi[i].id = Short.parseShort(jarr2.get(0).toString());
                this.pi[i].dx = Byte.parseByte(jarr2.get(1).toString());
                this.pi[i].dy = Byte.parseByte(jarr2.get(2).toString());
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    public int type;
    public PartImage[] pi;
    
    public static Part[] parts;
}