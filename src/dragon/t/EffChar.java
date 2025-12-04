package dragon.t;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

/**
 *
 * @author TGDD
 */
public class EffChar {
    
    public int effId;
    public int typeEff;
    public int loop;
    public int tLoop;
    public boolean isPaint = true;
    public int layer;
    public int isStand;
    public long last;
    public int second;
    public boolean isSave;
    public Item item;
    
    public String getName() {
        if (this.effId == 1000) {
            return "VIP I";
        }
        if (this.effId == 1001) {
            return "VIP II";
        }
        if (this.effId == 1002) {
            return "VIP III";
        }
        return "";
    }
    
    public String status() {
        return this.isPaint ? "ON" : "OFF";
    }
    
    public String hsd() {
        return this.second == -1 ? "" : ("\nHSD: "+ Util.gI().getStrTime((this.last + (this.second * 1000L)) - System.currentTimeMillis()));
    }
    
    public static EffChar parseItem(String str) throws ParseException {
        EffChar eff = new EffChar();
        JSONArray jarr = (JSONArray) JSONValue.parseWithException(str);
        eff.effId = Short.parseShort(jarr.get(0).toString());
        eff.typeEff = Byte.parseByte(jarr.get(1).toString());
        eff.loop = Integer.parseInt(jarr.get(2).toString());
        eff.tLoop = Integer.parseInt(jarr.get(3).toString());
        eff.isPaint = Boolean.parseBoolean(jarr.get(4).toString());
        eff.layer = Byte.parseByte(jarr.get(5).toString());
        eff.isStand = Integer.parseInt(jarr.get(6).toString());
        eff.last = Long.parseLong(jarr.get(7).toString());
        eff.second = Integer.parseInt(jarr.get(8).toString());
        if (eff.typeEff == 1 || eff.typeEff == 2) {
            eff.item = Item.parseItem(jarr.get(9).toString());
        }
        return eff;
    }
    
    @Override
    public String toString() {
        try {
            JSONArray jarr = new JSONArray();
            jarr.add(this.effId);
            jarr.add(this.typeEff);
            jarr.add(this.loop);
            jarr.add(this.tLoop);
            jarr.add(this.isPaint);
            jarr.add(this.layer);
            jarr.add(this.isStand);
            jarr.add(this.last);
            jarr.add(this.second);
            if (this.typeEff == 1 || this.typeEff == 2) {
                jarr.add((JSONArray) JSONValue.parseWithException(this.item.toString()));
            }
            return jarr.toJSONString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
