package dragon.t;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class Archivement {
    
    public int id;
    public int type;
    public String info1;
    public String info2;
    public int money;
    public int max;
    public int gold;
    public boolean isFinish;
    public boolean isRecieve;
    
    public Archivement(ResultSet res) throws SQLException {
        this.id = res.getShort(1);
        this.type = res.getByte(2);
        this.info1 = res.getString(3);
        this.info2 = res.getString(4);
        this.money = res.getShort(5);
        this.max = res.getInt(6);
        this.gold = res.getInt(7);
    }
    
    public Archivement(int id, int type, String info1, String info2, int money) {
        this.id = id;
        this.type = type;
        this.info1 = info1;
        this.info2 = info2;
        this.money = money;
    }
    
    public static ArrayList<Archivement> arrArchivement = new ArrayList<>();
    
    public static Archivement get(int id) {
        int i;
        for (i = 0; i < arrArchivement.size(); i++) {
            if (arrArchivement.get(i).id == id) {
                return arrArchivement.get(i);
            }
        }
        return null;
    }
    
}
