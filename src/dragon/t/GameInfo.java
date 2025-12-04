package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class GameInfo {
    
    public String main;
    public String content;
    public short id;
    public boolean hasRead;
    
    public GameInfo(int id, String main, String content) {
        this.id = (short) id;
        this.main = main;
        this.content = content;
    }
    
    public static ArrayList<GameInfo> infos = new ArrayList<>();
    
    public static void init() {
        infos.add(new GameInfo(100, "Hỗ trợ nhiệm vụ", "1) Hỗ trợ nhiệm vụ\nTất cả các ngày trong tuần từ 11 đến hết 13h và 18 đến hết 21h, chỉ những cư dân đang làm nhiệm vụ này mới có thể vào map có boss xuất hiện\nÁp dụng từ nhiệm vụ TDST đến Xên Bọ Hung tại Thị Trấn Ginder)"));
        infos.add(new GameInfo(5, "Hướng Dẫn Mở Thành Viên", "B1: Nạp tiền trại trang chủ ngocrongtori.com\nB2: Sau khi có tiền tiến hành vào game để quy đổi qua thỏi vàng\nB3:Sau khi quy đổi tài khoản sẽ tự động mở thành viên hoàn toàn miễn phí."));
        infos.add(new GameInfo(6, "Mã Quà Tặng", "Mã quà tặng: tori333,tori666,tori999\nNhập tại NPC tại nhà"));
    }
    
}
