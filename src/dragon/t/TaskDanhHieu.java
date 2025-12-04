package dragon.t;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class TaskDanhHieu {
	
    public short id;
    public String name;
    public String info;
    public int maxCount;
    public byte type;

    public TaskDanhHieu(ResultSet res) throws SQLException {
        this.id = res.getShort("id");
        this.name = res.getString("name");
        this.info = res.getString("info");
        this.maxCount = res.getInt("maxCount");
        this.type = res.getByte("type");
    }
    
    public static final HashMap<Short, TaskDanhHieu> hTask = new HashMap<>();
    
}
