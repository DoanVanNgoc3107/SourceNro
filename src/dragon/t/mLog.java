package dragon.t;

import dragon.server.Dragon;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 *
 * @author TGDD
 */
public class mLog {
    
    static {
        File f = new File("logServer.txt");
        if(f.exists()) {
            f.delete();
        }
        try {
            f.createNewFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void log(String string) {
        String str = new String(Objects.requireNonNull(Dragon.getFile("logServer.txt")));
        str += (string+": "+Util.gI().convertTime(System.currentTimeMillis(), "HH'h'mm dd/MM/yyyy")+"\n");
        Dragon.saveFile("logServer.txt", str.getBytes());
    }
    
}
