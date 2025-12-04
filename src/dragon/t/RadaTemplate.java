package dragon.t;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

/**
 *
 * @author TGDD
 */
public class RadaTemplate {
    
    public short id;
    public short idIcon;
    public byte rank;
    public byte max_amount;
    public short templateId;
    public short head;
    public short body;
    public short leg;
    public short bag;
    public String name;
    public String info;
    public ArrayList<ItemOption> options = new ArrayList<>();
    
    public RadaTemplate(ResultSet res) {
        try {
            int n = 1;
            int i;
            this.id = res.getShort(n++);
            this.idIcon = res.getShort(n++);
            this.rank = res.getByte(n++);
            this.max_amount = res.getByte(n++);
            this.templateId = res.getShort(n++);
            this.head = res.getShort(n++);
            this.body = res.getShort(n++);
            this.leg = res.getShort(n++);
            this.bag = res.getShort(n++);
            this.name = res.getString(n++);
            this.info = res.getString(n++);
            JSONArray jarr = (JSONArray) JSONValue.parseWithException(res.getString(n++));
            for (i = 0; i < jarr.size(); i++) {
                JSONArray option = (JSONArray) jarr.get(i);
                ItemOption op = new ItemOption(Integer.parseInt(option.get(0).toString()), Integer.parseInt(option.get(1).toString()));
                op.activeCard = Byte.parseByte(option.get(2).toString());
                this.options.add(op);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static RadaTemplate getRadaTemplate(int id) {
        byte i;
        for (i = 0; i < arrRadaTemplate.length; i++) {
            if (arrRadaTemplate[i].id == id) {
                return arrRadaTemplate[i];
            }
        }
        return null;
    }
    
    public static RadaTemplate[] arrRadaTemplate;
    
}
