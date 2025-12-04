package dragon.t;

import dragon.server.Dragon;
import java.io.File;
import java.io.IOException;

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
        String str = new String(Dragon.getFile("logServer.txt"));
        str += (string+": "+Util.gI().convertTime(System.currentTimeMillis(), "HH'h'mm dd/MM/yyyy")+"\n");
        Dragon.saveFile("logServer.txt", str.getBytes());
    }
    
}
