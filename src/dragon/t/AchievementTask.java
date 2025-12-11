package dragon.t;

/**
 * File này dùng để lưu thông tin nhiệm vụ thành tựu
 * @author TGDD
 */
public class AchievementTask {
    
    public int id;
    public long count;
    public boolean isFinish;
    public boolean isReceive;
    
    public AchievementTask() {
        
    }
    
    public AchievementTask(int id, long count, boolean isFinish, boolean isReceive) {
        this.id = id;
        this.count = count;
        this.isFinish = isFinish;
        this.isReceive = isReceive;
    }
    
    public void reset() {
        this.count = 0L; 
        this.isFinish = false;
        this.isReceive = false;
    }
}
