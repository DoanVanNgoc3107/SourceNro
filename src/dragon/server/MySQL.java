package dragon.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class MySQL {
    
    private final Connection conn;
    private static final Object LOCK = new Object();
    
    public MySQL(String host, String database, String user, String pass) throws SQLException {
        synchronized (LOCK) {
            this.conn = DriverManager.getConnection(String.format(URL_FORMAT, host, database), user, pass);
        }
    }
    
    // Helper to read DB host from the environment variable with fallback to localhost
    private static String getHostFromEnv() {
        String h = System.getenv("MYSQL_HOST");
        if (h == null || h.trim().isEmpty()) {
            return "localhost";
        }
        return h.trim();
    }

    public static MySQL createData1() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_data", "root", "31072005");
    }
    
    public static MySQL createData2() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_game", "root", "31072005");
    }
    
    public static MySQL createData3() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_player", "root", "31072005");
    }
    
    public static MySQL createData4() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_rank", "root", "31072005");
    }
    
    public static MySQL createData5() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_lucky", "root", "31072005");
    }
    
    public static MySQL createData6() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_option", "root", "31072005");
    }
    
    public static MySQL createData7() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_effect", "root", "31072005");
    }
    
    public static MySQL createData8() throws SQLException {
        return new MySQL(getHostFromEnv(), "ae_game2", "root", "31072005");
    }
    
    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConnection() {
        return conn;
    }
    
    //static
    
    private static final String URL_FORMAT = "jdbc:mysql://%s/%s";
}
