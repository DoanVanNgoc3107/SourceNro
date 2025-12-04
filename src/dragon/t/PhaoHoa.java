package dragon.t;

/**
 *
 * @author TGDD
 */
public class PhaoHoa {
    
    private final short x;
    private final short y;
    private int num;
    private int tShoot;
    private final byte type;
    private long last;
    private final ZoneMap zone;
    
    public static final String[] ARRAY_LOI_CHUC = new String[] {
        "Chúc các bạn vui vẻ",
        "Anh thắp sáng đường vào tym em",
        "Anh em Fa máu thoát ế",
        "Anh yêu em nhiều lắm, ahihi",
        "Quẩy lên đi anh em",
        "Mình iu các bạn nhiều lắm"
    };
    
    public PhaoHoa(ZoneMap zone, int num, short x, short y, byte type) {
        this.zone = zone;
        this.num = num;
        this.x = x;
        this.y = y;
        this.type = type;
        this.last = System.currentTimeMillis();
    }
    
    public void update() {
        int howLong = (int) (System.currentTimeMillis() - this.last);
        if (this.num > 0) {
            this.tShoot -= howLong;
            if (this.tShoot <= 0) {
                this.tShoot = 0;
                if (this.type == 0) {
                    this.tShoot = 500;
                    int n = Util.gI().nextInt(1 , 10);
                    if (n > this.num) {
                        n = num;
                    }
                    for (int i = 0; i < n; i++) {
                        this.zone.addEffectServer(1, 2, Util.gI().nextInt(62, 65), Util.gI().nextInt(this.x - 100, this.x + 100), this.y, 0);
                    }
                    this.num -= n;
                }
                if (this.type == 1) {
                    this.tShoot = 200;
                    this.zone.addEffectServer(1, 2, 66, Util.gI().nextInt(this.x - 100, this.x + 100), this.y, 0);
                    this.num--;
                }
                if (this.type == 2) {
                    this.tShoot = 200;
                    this.zone.addEffectServer(1, 2, 67, Util.gI().nextInt(this.x - 100, this.x + 100), this.y, 0);
                    this.num--;
                }
            }
        } else {
            this.zone.reomvePhaoHoa(this);
        }
        this.last = System.currentTimeMillis();
    }
    
}
