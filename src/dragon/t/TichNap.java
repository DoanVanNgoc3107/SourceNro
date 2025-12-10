package dragon.t;

import java.time.Instant;

import java.util.HashMap;

/**
 * Class này dùng để lưu trữ số tiền mà user đã nạp vào game, từ đó tích lũy và nhận mốc quà
 * @author Đoàn Văn Ngọc 
 */
public class TichNap {
    private final Player player;

    private static Long goldPay = 0L;

    private final HashMap<Integer, Boolean> rewardReceived = new HashMap<>();

    private Instant startTime;

    private Instant endTime;

    public TichNap(Player player) {
        this.player = player;
    }
}
