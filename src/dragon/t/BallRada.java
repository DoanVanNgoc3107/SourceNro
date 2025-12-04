package dragon.t;


import java.util.ArrayList;

/**
 *
 * @author Văn Tú
 */
public class BallRada {
    
    public int type;
    public Item ball;
    public ZoneMap zoneMap;
    public Char player;
    public int itemMapID;
    public int x;
    public int y;
    public boolean stone;
    
    public BallRada(Item ball, ZoneMap zoneMap, int itemMapID, int x, int y) {
        this.ball = ball;
        this.zoneMap = zoneMap;
        this.itemMapID = itemMapID;
        this.x = x;
        this.y = y;
        this.stone = false;
    }
    
    public static final ArrayList<BallRada> HBALL = new ArrayList<>();
    public static long timeCleanBall = -1;
    
    public static BallRada getById(int id) {
        synchronized(HBALL) {
            int num = 0;
            while(num < HBALL.size()) {
                if (HBALL.get(num).ball.template.id == id) {
                    return HBALL.get(num);
                }
                num++;
            }
            return null;
        }
    }
    
    public static void add(BallRada ball) {
        synchronized(HBALL) {
            HBALL.add(ball);
        }
    }
    
}
