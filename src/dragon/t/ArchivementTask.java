package dragon.t;

/**
 * File này dùng để lưu thông tin nhiệm vụ thành tựu
 * @author TGDD
 */
public class ArchivementTask {
    
    public int id;
    public long count;
    public boolean isFinish;
    public boolean isRecieve;
    
    public ArchivementTask() {
        
    }
    
    public ArchivementTask(int id, long count, boolean isFinish, boolean isRecieve) {
        this.id = id;
        this.count = count;
        this.isFinish = isFinish;
        this.isRecieve = isRecieve;
    }
    
    public void reset() {
        this.count = 0L; 
        this.isFinish = false;
        this.isRecieve = false;
    }
}
