package dragon.t;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 * File này dùng để lưu thông tin mũi tên trong game
 * @author TGDD
 */
public class Arrow {
    
    public int id;
    
    public int[] imgId = new int[3];
    
    public Arrow(ResultSet res) throws SQLException, ParseException {
        this.id = res.getShort("id");
        JSONArray jarr1 = (JSONArray) JSONValue.parseWithException(res.getString("imgId"));
        this.imgId[0] = Short.parseShort(jarr1.get(0).toString());
        this.imgId[1] = Short.parseShort(jarr1.get(1).toString());
        this.imgId[2] = Short.parseShort(jarr1.get(2).toString());
    }
    
    public static Arrow[] arrs;
    
}
