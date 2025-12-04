package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class Monkey {
    
    public byte levelMonkey;
    public short head;
    public short body;
    public short leg;
    public int addST;
    public int addHP;
    
    public Monkey(byte levelMonkey, short head, short body, short leg, int addST, int addHP) {
        this.levelMonkey = levelMonkey;
        this.head = head;
        this.body = body;
        this.leg = leg;
        this.addST = addST;
        this.addHP = addHP;
    }
    
    public static Monkey get(int levelMonkey) {
        for (int i = 0; i < Monkey.MONKEYS.size(); i++) {
            if (Monkey.MONKEYS.get(i).levelMonkey == levelMonkey) {
                return Monkey.MONKEYS.get(i);
            }
        }
        return null;
    }
    
    public static final ArrayList<Monkey> MONKEYS = new ArrayList<>();
    
}
