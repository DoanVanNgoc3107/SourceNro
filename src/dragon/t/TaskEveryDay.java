package dragon.t;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskEveryDay {
	
    public int id;
    public long minPower;
    public long maxPower;
    public String name;
    public String info;
    public int minCount;
    public int maxCount;
    public byte type;
    public int templateId;
    public byte level;
    public int doel_boss_level;

    public TaskEveryDay(ResultSet res) throws SQLException {
        this.id = res.getInt("id");
        this.minPower = res.getLong("minPower");
        this.maxPower = res.getLong("maxPower");
        this.name = res.getString("name");
        this.info = res.getString("info");
        this.minCount = res.getInt("minCount");
        this.maxCount = res.getInt("maxCount");
        this.type = res.getByte("type");
        this.templateId = res.getInt("templateId");
        this.level = res.getByte("level");
    }

    public static class Task {

        public int id;
        public int level;
        private int count;
        public int maxCount;
        private long last;
        public TaskEveryDay template;
        public boolean isFinish = false;

        public boolean addCount(int value) {
            this.count += value;
            if (!this.isFinish && this.count >= maxCount) {
                return this.isFinish = true;
            }
            return false;
        }

        public static Task get(long power, byte level) {
            ArrayList<TaskEveryDay> myList = new ArrayList<>();
            for (int i = 0; i < myArrayList.size(); i++) {
                if (myArrayList.get(i).level == level && power >= myArrayList.get(i).minPower && power <= myArrayList.get(i).maxPower) {
                    myList.add(myArrayList.get(i));
                }
            }
            if (myList.isEmpty()) return null;
            Task task = new Task();
            task.level = level;
            task.last = System.currentTimeMillis();
            task.template = myList.get(Util.gI().nextInt(myList.size()));
            task.maxCount = Util.gI().nextInt(task.template.minCount, task.template.maxCount);
            return task;
        }

        public static Task getForClan(long power, byte level) {
            ArrayList<TaskEveryDay> myList = new ArrayList<>();
            for (int i = 0; i < myArrayListClan.size(); i++) {
                if (myArrayListClan.get(i).level == level && power >= myArrayListClan.get(i).minPower && power <= myArrayListClan.get(i).maxPower) {
                    myList.add(myArrayListClan.get(i));
                }
            }
            if (myList.isEmpty()) return null;
            Task task = new Task();
            task.level = level;
            task.last = System.currentTimeMillis();
            task.template = myList.get(Util.gI().nextInt(myList.size()));
            task.maxCount = Util.gI().nextInt(task.template.minCount, task.template.maxCount);
            return task;
        }

        public String getInfo() {
            return this.conver(this.template.info);
        }

        public String getName() {
            return this.conver(this.template.name);
        }

        public String conver(String str) {
            return str.replace("$1", Util.gI().getFormatNumber(this.count)).
                    replace("$2", Util.gI().getFormatNumber(this.maxCount)).
                    replace("$3", Util.gI().getStrTime(System.currentTimeMillis() - this.last)).
                    replace("$4", String.valueOf(100.0F / this.maxCount * this.count));
        }

    }

    public static final ArrayList<TaskEveryDay> myArrayList = new ArrayList<>();
    public static final ArrayList<TaskEveryDay> myArrayListClan = new ArrayList<>();

//	public static TaskEveryDay get(int id) {
//		for (int i = 0; i < myArrayList.size(); i++) {
//			if (myArrayList.get(i).id == id) return myArrayList.get(id);
//		}
//		return null;
//	}



}