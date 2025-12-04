package dragon.t;

import dragon.server.MySQL;
import dragon.server.mResources;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class Rank {
    
    public final static ArrayList<Rank> RANKS = new ArrayList<>();
    
    public int rankId;
    public String topName;
    public int typeTop;
    public final ArrayList<TopInfo> tops = new ArrayList<>();
    public int maxSizeTop = 100;
    
    public class TopInfo {
	public int headID;
        public int headICON;
	public short body;
	public short leg;
	public String name;
	public String info;
	public int pId;
	public int rank;
	public String info2;
        public long lastTime;
        public long point;
        public int time;
    }
    
    public static Rank getRank(int rankId) {
        int i;
        for (i = 0; i < RANKS.size(); i++) {
            if (RANKS.get(i).rankId == rankId) {
                return RANKS.get(i);
            }
        }
        return null;
    }
    
    public TopInfo getTop(String name) {
        synchronized (tops) {
            for (int i = 0; i < tops.size(); i++) {
                if (tops.get(i).name.equals(name)) {
                    return tops.get(i);
                }
            }
        }
        return null;
    }
    
    public boolean isHaveTop(String name) {
        synchronized (tops) {
            for (int i = 0; i < tops.size(); i++) {
                if (tops.get(i).name.equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public void addTop(TopInfo v) {
        synchronized (tops) {
            tops.add(v);
        }
    }
    
    public void removeTop(TopInfo v) {
        synchronized (tops) {
            tops.remove(v);
        }
    }
    
    public void addTop(String name, int headID, int headICON, int body, int leg, int pId, long point, int time) {
        TopInfo t = this.getTop(name);
        if (t != null) {
            if (this.rankId != 0 || ((this.rankId == 0 && point > t.point) || (this.rankId == 0 && point == t.point && time < t.time))) {
                t.headID = headID;
                t.headICON = headICON;
                t.body = (short) body;
                t.leg = (short) leg;
                t.pId = pId;
                t.point = point;
                t.time = time;
                t.lastTime = System.currentTimeMillis();
            }
        } else {
            t = new TopInfo();
            t.name = name;
            t.headID = headID;
            t.headICON = headICON;
            t.body = (short) body;
            t.leg = (short) leg;
            t.pId = pId;
            t.point = point;
            t.time = time;
            t.lastTime = System.currentTimeMillis();
            addTop(t);
        }
        sortTop();
    }
    
    public void removeTop(String name) {
        if (isHaveTop(name)) {
            this.removeTop(this.getTop(name));
            sortTop();
        }
    }
    
    
    public void sortTop() {
        synchronized (tops) {
            //SAP XEP
            for (int i = 0; i < tops.size() - 1; i++) {
                for (int j = i + 1; j < tops.size(); j++) {
                    if ((tops.get(i).point == tops.get(j).point && tops.get(i).time > tops.get(j).time) || (tops.get(i).point < tops.get(j).point)) {
                        TopInfo top1 = tops.get(i);
                        tops.set(i, tops.get(j));
                        tops.set(j, top1);
                    }
                }
            }
            //SET RANK
            for (int i2 = 0; i2 < tops.size(); i2++) {
                TopInfo top2 = tops.get(i2);
                top2.rank = i2 + 1;
            }
            //REMOVE MAX
            while(tops.size() > maxSizeTop) {
                tops.remove(tops.size() - 1);
            }
        }
    }
    
    public void initRank(ResultSet res) {
        int i;
        try {
            this.rankId = res.getInt(1);
            this.topName = res.getString(2);
            this.typeTop = res.getByte(3);
            JSONArray jtops = (JSONArray) JSONValue.parseWithException(res.getString(4));
            JSONArray jtop;
            TopInfo t;
            for (i = 0; i < jtops.size(); i++) {
                jtop = (JSONArray) jtops.get(i);
                t = new TopInfo();
                t.rank = i + 1;
                t.name = jtop.get(0).toString();
                t.headID = Short.parseShort(jtop.get(1).toString());
                t.headICON = Short.parseShort(jtop.get(2).toString());
                t.body = Short.parseShort(jtop.get(3).toString());
                t.leg = Short.parseShort(jtop.get(4).toString());
                t.pId = Integer.parseInt(jtop.get(5).toString());
                t.point = Long.parseLong(jtop.get(6).toString());
                t.time = Integer.parseInt(jtop.get(7).toString());
                t.lastTime = Long.parseLong(jtop.get(8).toString());
                this.tops.add(t);
            }
            this.maxSizeTop = res.getInt(5);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    public void remove(TopInfo top) {
        synchronized (this.tops) {
            this.tops.remove(top);
        }
    }
    
    public void loadRank() {
        TopInfo[] array;
        synchronized (this.tops) {
            array = new TopInfo[this.tops.size()];
            for (int i = 0; i < this.tops.size(); i++) {
                array[i] = this.tops.get(i);
            }
        }
        for (int i2 = 0; i2 < array.length; i2++) {
            if (this.rankId == 0 || this.rankId == 5 || this.rankId == 7) {
                Clan clan = Clan.getClan(array[i2].name);
                if (clan == null || clan.getMemberByName(clan.leaderName) == null) {
                    remove(array[i2]);
                } else {
                    array[i2].headID = clan.getMemberByName(clan.leaderName).head;
                    array[i2].headICON = clan.getMemberByName(clan.leaderName).headICON;
                    array[i2].body = clan.getMemberByName(clan.leaderName).body;
                    array[i2].leg = clan.getMemberByName(clan.leaderName).leg;
                }
            }
        }
        this.sortTop();
    }
    
    public static void saveRank() {
        Rank[] arrRank;
        arrRank = new Rank[Rank.RANKS.size()];
        for (int i5 = 0; i5 < Rank.RANKS.size(); i5++) {
            arrRank[i5] = Rank.RANKS.get(i5);
        }
        for (int i3 = 0; i3 < arrRank.length; i3++) {
            arrRank[i3].backup();
        }
    }
    
    private void backup() {
        Rank.TopInfo[] array;
        synchronized(this.tops) {
            array = new Rank.TopInfo[this.tops.size()];
            for (int i1 = 0; i1 < this.tops.size(); i1++) {
                array[i1] = this.tops.get(i1);
            }
        }
        try {
            MySQL mySQL = MySQL.createData3();
            JSONArray jtops = new JSONArray();
            for (int i = 0; i < array.length; i++) {
                JSONArray jtop = new JSONArray();
                jtop.add(array[i].name);
                jtop.add(array[i].headID);
                jtop.add(array[i].headICON);
                jtop.add(array[i].body);
                jtop.add(array[i].leg);
                jtop.add(array[i].pId);
                jtop.add(array[i].point);
                jtop.add(array[i].time);
                jtop.add(array[i].lastTime);
                jtops.add(jtop);
            }
            try {
                mySQL.getConnection().setAutoCommit(false);
                try {
                    mySQL.getConnection().prepareStatement(String.format(
                            mResources.UPDATE_RANK,
                            Util.gI().stringSQL(jtops.toJSONString()),
                            this.rankId
                    )).executeUpdate();
                    mySQL.getConnection().commit();
                } catch (SQLException e) {
                    mySQL.getConnection().rollback();
                    e.printStackTrace();
                }
            } finally {
                mySQL.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
}
