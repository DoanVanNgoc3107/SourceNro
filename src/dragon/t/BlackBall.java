package dragon.t;

/**
 * File này dùng để lưu thông tin ngọc rồng sao đen
 * @author TGDD
 */
public class BlackBall {
    
    public boolean isBlackBall;
    public int timePickBlackBall;
    public int timeXongBlackBall;
    public boolean isWinAll;
    public int timeKeepBlackBall;
    
    public int delay;
    
    private static BlackBall instance;
    
    public static BlackBall gI() {
        if (instance == null) {
            instance = new BlackBall();
        }
        return instance;
    }
    
    public void openBlackBall() {
        this.isBlackBall = true;
        this.isWinAll = false;
        this.timeKeepBlackBall = 300000;
        this.timePickBlackBall = 1000 * 60 * 30;
        this.timeXongBlackBall = 1000 * 60 * 60;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (Map map : array) {
            if (map.isMapBlackBall()) {
                for (int j = 0; j < map.zones.size(); j++) {
                    map.zones.get(j).isWinBlackBall = false;
                    map.zones.get(j).resetItemBlackBall();
                }
            }
        }
    }
    
    public void closeBlackBall() {
        this.isBlackBall = false;
        this.isWinAll = false;
        Map[] array;
        synchronized (Map.MAPS) {
            array = new Map[Map.MAPS.size()];
            for (int i = 0; i < Map.MAPS.size(); i++) {
                array[i] = Map.MAPS.get(i);
            }
        }
        for (Map map : array) {
            if (map.isMapBlackBall()) {
                for (int j = 0; j < map.zones.size(); j++) {
                    map.zones.get(j).pushPlayers(0);
                }
            }
        }
    }


    public void update() {
        //Time nhat ngoc rong sao den
        if (this.timePickBlackBall > 0) {
            this.timePickBlackBall -= this.delay;
            if (this.timePickBlackBall <= 0) {
                this.timePickBlackBall = 0;
            }
        }

        //Time ket thuc ngoc rong sao den
        if (this.timeXongBlackBall > 0) {
            this.timeXongBlackBall -= this.delay;
            if (this.timeXongBlackBall <= 3000) {
                this.isWinAll = true;
            }
            if (this.timeXongBlackBall <= 0) {
                this.timeXongBlackBall = 0;
                this.closeBlackBall();
            }
        }
    }
    
}
