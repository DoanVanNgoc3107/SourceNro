package dragon.t;

/**
 *
 * @author TGDD
 */
public class Task {
    
    public short[][] counts;
    public short taskId;
    public String[] name;
    public String[] detail;
    public String[][] subNames;
    public String[][] contentInfo;
    public int[][] tasks;
    public int[][] mapTasks;
    
    public static Task[] arrTask;
    
    public static Task getTask(int taskId) {
        int i;
        for (i = 0; i < arrTask.length; i++) {
            if (arrTask[i].taskId == taskId) {
                return arrTask[i];
            }
        }
        return null;
    }
    
}
