package dragon.t;

import dragon.server.mResources;
import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class NumberPlayer {
    
    NumberPlayer(int playerId, String name) {
        this.playerId = playerId;
        this.name = name;
    }

    public String name;
    public int playerId;
    public final ArrayList arrNumber = new ArrayList<>();
    
    public String yourNumber() {
        String str = null;
        int i = 0;
        for (int n = 0; n < LuckyNumber.maxNumber; n++) {
            if (this.arrNumber.contains(n)) {
                int l = n;
                for (; l < LuckyNumber.maxNumber; l++) {
                    if (!this.arrNumber.contains(l+1)) {
                        break;
                    }
                }
                if (Math.abs(l - n) < 9) {
                    if (i == 0) {
                        str = String.format(mResources.SET_NUMBER, n);
                    } else {
                        str = str + String.format(mResources.SET_NUMBER2, n);
                    }
                } else {
                    if (i == 0) {
                        str = String.format(mResources.SET_NUMBER, String.format(mResources.NUMBER_TO_NUMBER, n, l));
                    } else {
                        str = str + String.format(mResources.SET_NUMBER2, String.format(mResources.NUMBER_TO_NUMBER, n, l));
                    }
                    n = l;
                }
                i++;
            }
        }
        return str;
    }
}
