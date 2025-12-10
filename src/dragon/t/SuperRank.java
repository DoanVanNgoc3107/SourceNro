package dragon.t;

import dragon.server.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Admin
 */
public class SuperRank {

    public SuperRank(int playerId, int charID, String name) {
        this.playerId = playerId;
        this.charID = charID;
        this.name = name;
    }

    public SuperRank() {
    }

    public int playerId;
    public int charID;
    public String name;
    public int rank;
    public byte cgender;
    public long cPower;
    public short headID = -1;
    public short bodyID = -1;
    public short legID = -1;
    public int bag = -1;
    public short headICON = -1;
    public int cHPfull;
    public int cMPfull;
    public int cDamfull;
    public int cDeffull;
    public int cCriticalfull;
    public int cDefPercentfull;
    public int cMissPercentfull;
    public int suckHPGoc;
    public int suckKIGoc;
    public ArrayList<Skill> skills = new ArrayList<>();
    public boolean isWar;
    public String strWar = null;
    public int ngocNhan;

    public static int baseID = 0;

    public static void add(SuperRank e) {
        synchronized (AMEMBER) {
            AMEMBER.add(e);
        }
        synchronized (HNAME) {
            HNAME.put(e.name, e);
        }
    }

    public static int size() {
        synchronized (AMEMBER) {
            return AMEMBER.size();
        }
    }

    private void initRank(ResultSet res) throws SQLException, ParseException {
        this.playerId = res.getInt("playerId");
        this.name = res.getString("cName");
        this.charID = Char.getNewCharID();
        this.rank = res.getInt("rank");
        this.cgender = res.getByte("cgender");
        this.cPower = res.getLong("cPower");
        this.headID = res.getShort("headID");
        this.bodyID = res.getShort("bodyID");
        this.legID = res.getShort("legID");
        this.bag = res.getInt("bag");
        this.headICON = res.getShort("headICON");
        this.cHPfull = res.getInt("cHPfull");
        this.cMPfull = res.getInt("cMPfull");
        this.cDamfull = res.getInt("cDamfull");
        this.cDeffull = res.getInt("cDeffull");
        this.cCriticalfull = res.getInt("cCriticalfull");
        this.cDefPercentfull = res.getInt("cDefPercentfull");
        this.cMissPercentfull = res.getInt("cMissPercentfull");
        this.suckHPGoc = res.getInt("suckHPGoc");
        this.suckKIGoc = res.getInt("suckKIGoc");
        JSONArray jarr = (JSONArray) (JSONArray) JSONValue.parseWithException(res.getString("skills"));
        for (int i = 0; i < jarr.size(); i++) {
            Skill o = Skill.arrSkill[Integer.parseInt(jarr.get(i).toString())].clone();
            this.skills.add(o);
        }
        this.ngocNhan = res.getInt("ngoc");
    }

    public static final ArrayList<SuperRank> AMEMBER = new ArrayList<>();
    public static final HashMap<String, SuperRank> HNAME = new HashMap<>();

    public static SuperRank getByname(String name) {
        synchronized (HNAME) {
            return HNAME.get(name);
        }
    }

    public static void sortTop() {
        synchronized (AMEMBER) {
            // sort ArrayList
            Collections.sort(AMEMBER, (SuperRank o1, SuperRank o2) -> Integer.compare(o1.rank, o2.rank));
        }
    }

    public static void init() {
        try {
            MySQL mySQL = MySQL.createData4();
            try {
                ResultSet red = mySQL.getConnection().prepareStatement("SELECT * FROM `superrank`;",
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                while (red.next()) {
                    SuperRank superRank = new SuperRank();
                    superRank.initRank(red);
                    SuperRank.add(superRank);
                }
            } finally {
                mySQL.close();
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        SuperRank.sortTop();
    }

    public static void saveData() {
        ArrayList<SuperRank> arrList = new ArrayList<>();
        synchronized (AMEMBER) {
            for (int i = 0; i < AMEMBER.size(); i++) {
                arrList.add(AMEMBER.get(i));
            }
        }
        try {
            MySQL mySQL = MySQL.createData4();
            try {
                mySQL.getConnection().setAutoCommit(false);
                try {
                    mySQL.getConnection().prepareStatement("DELETE FROM `superrank`;").executeUpdate();
                    for (int i = 0; i < arrList.size(); i++) {
                        JSONArray jarr = new JSONArray();
                        for (int j = 0; j < arrList.get(i).skills.size(); j++) {
                            jarr.add(arrList.get(i).skills.get(j).skillId);
                        }
                        mySQL.getConnection().prepareStatement(
                                "INSERT INTO `superrank`(`playerId`, `cName`, `charID`, `rank`, `cgender`, `cPower`, `headID`, `bodyID`, `legID`, `bag`, `headICON`, `cHPfull`, `cMPfull`, `cDamfull`, `cDeffull`, `cCriticalfull`, `cDefPercentfull`, `cMissPercentfull`, `suckHPGoc`, `suckKIGoc`, `skills`, `ngoc`) VALUES ("
                                        + arrList.get(i).playerId + ", \"" + arrList.get(i).name + "\", "
                                        + arrList.get(i).charID + " , " + arrList.get(i).rank + ", "
                                        + arrList.get(i).cgender + ", " + arrList.get(i).cPower + ", "
                                        + arrList.get(i).headID + ", " + arrList.get(i).bodyID + ", "
                                        + arrList.get(i).legID + ", " + arrList.get(i).bag + ", "
                                        + arrList.get(i).headICON + ", " + arrList.get(i).cHPfull + ", "
                                        + arrList.get(i).cMPfull + ", " + arrList.get(i).cDamfull + ", "
                                        + arrList.get(i).cDeffull + ", " + arrList.get(i).cCriticalfull + ", "
                                        + arrList.get(i).cDefPercentfull + ", " + arrList.get(i).cMissPercentfull + ", "
                                        + arrList.get(i).suckHPGoc + ", " + arrList.get(i).suckKIGoc + ", \"" + jarr
                                        + "\", " + arrList.get(i).ngocNhan + ")")
                                .executeUpdate();
                    }
                    mySQL.getConnection().commit();
                } catch (SQLException e) {
                    mySQL.getConnection().rollback();
                    e.printStackTrace();
                }
            } finally {
                mySQL.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int ngocNhan(int rank) {
        if (rank == 0) {
            return 500;
        }
        if (rank >= 1 && rank < 10) {
            return 100;
        }
        if (rank >= 10 && rank < 100) {
            return 10;
        }
        if (rank >= 100 && rank < 1000) {
            return 1;
        }
        return 0;
    }

    public static void phatQua() {
        ArrayList<SuperRank> arrList = new ArrayList<>();
        synchronized (AMEMBER) {
            for (int i = 0; i < AMEMBER.size(); i++) {
                arrList.add(AMEMBER.get(i));
            }
        }
        for (int i = 0; i < arrList.size(); i++) {
            if (ngocNhan(arrList.get(i).rank) > 0) {
                arrList.get(i).ngocNhan += ngocNhan(arrList.get(i).rank);
            }
        }
    }

}
