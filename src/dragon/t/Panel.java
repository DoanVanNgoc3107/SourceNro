package dragon.t;

/**
 *
 * @author TGDD
 */
public class Panel {
    private static Panel is;
    
    public static Panel gI() {
        if (is == null) {
            is = new Panel();
        }
        return is;
    }
    
    public String infoSpeacialSkillDefault = "Chưa có Nội Tại\nBấm vào để xem chi tiết";
    
    public String numTo = "%d%% đến %d%%";
    public String numTo2 = "[%d đến %d]";
    public String numP = "%d%%";
    
    public  String[][] infoSpeacialSkill = new String[][] {
       {
           "Chiêu đấm Dragon +%s sát thương %s",
           "Chiêu Kamejoko +%s sát thương %s",
           "Thái Dương Hạ San +%s tốc độ -%s KI %s",
           "Quả cầu khênh khi +%s tốc độ hồi phục %s",
           "Khiên năng lượng +%s tốc độ hồi phục %s",
           "Dịch chuyển tức thời +%s sát thương đòn kế %s",
           "Thôi miên +%s sát thương đòn kế %s",
           "Vàng roi từ quái +%s %s",
           "Sức mạnh và tiềm năng khi đánh quái +%s %s",
           "Chí mạng liên tục khi HP dưới %s %s"
       },
       {
           "Chiêu đấm Demon +%s sát thương %s",
           "Chiêu Masenko +%s sát thương %s",
           "Trị thương +%s tốc độ hồi phục %s",
           "Makankosappo +%s tốc độ hồi phục %s",
           "Đẻ trứng +%s tốc độ hồi phục %s",
           "Liên hoàn +%s sát thương %s",
           "Biến Sôcôla +%s sát thương đòn kế %s",
           "Khiên năng lượng +%s tốc độ hồi phục %s",
           "Vàng rơi từ quái +%s %s",
           "Sức mạnh và tiềm năng khi đánh quái +%s %s",
           "Chí mạng liên tục khi HP dưới %s %s"
       },
       {
           "Chiêu đấm Galick +%s sát thương %s",
           "Chiêu Antomic +%s sát thương %s",
           "Biến hình +%s sát thương %s",
           "Tự phát nổ +%s tốc độ hồi phục %s",
           "Khiên năng lượng +%s tốc độ hồi phục %s",
           "Huýt sáo +%s tốc độ hồi phục %s",
           "Trói +%s sát thương đòn kế %s",
           "Vàng rơi từ quái +%s %s",
           "Sức mạnh và tiềm năng khi đánh quái +%s %s",
           "Chí mạng liên tục khi HP dưới %s %s"
       }
    };
   
   public short[][] imgSpeacialSkill = new short[][] {
       {
           569,
           569,//Con nguoi
           5222,//Dong hoi
           5222,//Dong hoi
           5222,//Dong ho
           568,//Nam dam
           568,//Nam dam
           930,//Vang
           3783,//DCTT
           716//Kaioken
       },
       {
           569,
           569,
           5222,
           5222,
           5222,
           569,
           568,
           5222,
           930,
           3783,
           716
       },
       {
           569,
           569,
           569,
           5222,
           5222,
           5222,
           568,
           930,
           3783,
           716
       }
   };
   
   public int[][][] nextSpeacialSkill = new int[][][] {
       {
           {5, 25},
           {5, 25},
           {10, 35},
           {15, 55},
           {15, 55},
           {50, 150},
           {50, 150},
           {25, 300},
           {5, 35},
           {20, 50}
       },
       {
           {5, 25},
           {5, 25},
           {15, 55},
           {15, 55},
           {15, 65},
           {5, 25},
           {50, 150},
           {15, 55},
           {25, 300},
           {5, 35},
           {20, 50}
       },
       {
           {5, 25},
           {5, 25},
           {5, 25},
           {15, 65},
           {15, 55},
           {15, 65},
           {50, 150},
           {25, 300},
           {5, 35},
           {20, 50}
       }
   };
   
   public String[] speacialTab = new String[]{
       "Nội tại"
   };
}
