package dragon.t;

/**
 *
 * @author TGDD
 */
public class SetSQL {
    
    private String strSQL;
    private String strAdd = "";
    private int nAdd = 0;
    
    public SetSQL(String sql) {
        this.strSQL = sql;
    }
    
    public void addSet(String column, String value) {
        if (nAdd == 0)
            this.strAdd = "`"+column +"` = '"+ value +"'";
        else
            this.strAdd += ", `"+ column +"` = '"+ value +"'";
        this.nAdd++;
    }
    
    public void addSet(String column, byte value) {
        if (nAdd == 0)
            this.strAdd = "`"+column +"` = '"+ value +"'";
        else
            this.strAdd += ", `"+ column +"` = '"+ value +"'";
        this.nAdd++;
    }
    
    public void addSet(String column, short value) {
        if (nAdd == 0)
            this.strAdd = "`"+column +"` = '"+ value +"'";
        else
            this.strAdd += ", `"+ column +"` = '"+ value +"'";
        this.nAdd++;
    }
    
    public void addSet(String column, int value) {
        if (nAdd == 0)
            this.strAdd = "`"+column +"` = '"+ value +"'";
        else
            this.strAdd += ", `"+ column +"` = '"+ value +"'";
        this.nAdd++;
    }
    
    public void addSet(String column, long value) {
        if (nAdd == 0)
            this.strAdd = "`"+column +"` = '"+ value +"'";
        else
            this.strAdd += ", `"+ column +"` = '"+ value +"'";
        this.nAdd++;
    }
    
    public void addSet(String column, boolean value) {
        if (nAdd == 0)
            this.strAdd = "`"+column +"` = '"+ (value ? 1 : 0) +"'";
        else
            this.strAdd += ", `"+ column +"` = '"+ (value ? 1 : 0) +"'";
        this.nAdd++;
    }
    
    public void clearSet() {
        this.nAdd = 0;
        this.strAdd = "";
    }
    
    public void clearSQL() {
        this.strSQL = "";
        this.clearSet();
    }
    
    public String toSQL() {
        return this.strSQL.replace("%", this.strAdd);
    }
    
}
