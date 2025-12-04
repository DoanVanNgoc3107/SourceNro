package dragon.t;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Memory {

    public int userId = -1;
    public int lastlogout = 0;
    public int nFreeWish = 1;
    public long timeWaitRoadSnake = -1;
    public boolean isRuongDaiHoi = false;
    public int pointEvent2 = 0;
    public boolean isThoDaiCa = false;
    public int nBanDoKhoBau = 3;
    public int nKhiHuyDiet = 3;
    public HashMap<Short, Integer> hTaskDH = new HashMap<>();

    public Memory(int userId) {
        this.userId = userId;
    }

    private static final Map<Integer, Memory> MEMORYS = new ConcurrentHashMap<>();

    public static Memory get(int userId) {
        return MEMORYS.computeIfAbsent(userId, Memory::new);
    }
}
