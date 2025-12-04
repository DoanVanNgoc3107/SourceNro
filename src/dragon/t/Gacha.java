package dragon.t;

import java.util.ArrayList;

public class Gacha {
    
    public static Gacha instance;
    
    public static Gacha gI() {
        if (instance == null) {
            instance = new Gacha();
        }
        return instance;
    }
    
    
}
