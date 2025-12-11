package dragon.t;

import dragon.server.MySQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class GameData {
    
    public static long[] exps;
    
    public static SkillOptionTemplate[] sOptionTemplates;
    public static NClass[] nClasss;
    
    public static ItemOptionTemplate[] iOptionTemplates;
//    public static ItemTemplate[] itemTemplates;
    
    public static String[][] strLevel;
    public static int Arr_Head_2Fr[][];
    
    public static void init() {
        int n = -1;
        try {
            MySQL mySQL = MySQL.createData1();
            try {
                ResultSet res;
                mySQL.getConnection().prepareStatement("SET GLOBAL max_connections = 10000000000;").executeUpdate();

                //-------------Load Exp-----------------//
                System.out.println("Load exps");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `exps`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    exps = new long[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    exps[res.getByte(1)] = res.getLong(2);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD MAP TEMPLATE________________//
                System.out.println("Load mapTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `maptemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    ZoneMap.mapNames = new String[res.getRow()];
                    MapTemplate.arrMapTemplate = new MapTemplate[ZoneMap.mapNames.length];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    int mapTemplateId = res.getInt(1);
                    MapTemplate mapTemplate = new MapTemplate();
                    ZoneMap.mapNames[mapTemplateId] = mapTemplate.mapName = res.getString(2);
                    mapTemplate.mapTemplateId = mapTemplateId;
                    mapTemplate.planetID = res.getByte(3);
                    mapTemplate.tileID = res.getByte(4);
                    mapTemplate.bgID = res.getByte(5);
                    mapTemplate.typeMap = res.getByte(6);
                    mapTemplate.bgType = res.getByte(7);
                    //++++++++++++++LAOD JOSN ARRAY WAYPOINTS++++++++++++++++++++//
                    JSONArray waypoints = (JSONArray) JSONValue.parseWithException(res.getString(8));
                    mapTemplate.arrWaypoint_name = new String[waypoints.size()];
                    mapTemplate.arrWaypoint_minX = new int[waypoints.size()];
                    mapTemplate.arrWaypoint_minY = new int[waypoints.size()];
                    mapTemplate.arrWaypoint_maxX = new int[waypoints.size()];
                    mapTemplate.arrWaypoint_maxY = new int[waypoints.size()];
                    mapTemplate.arrWaypoint_isEnter = new boolean[waypoints.size()];
                    mapTemplate.arrWaypoint_isOffline = new boolean[waypoints.size()];
                    mapTemplate.arrWaypoint_goMapID = new int[waypoints.size()];
                    mapTemplate.arrWaypoint_goX = new int[waypoints.size()];
                    mapTemplate.arrWaypoint_goY = new int[waypoints.size()];
                    for (int i3 = 0; i3 < mapTemplate.arrWaypoint_name.length; i3++) {
                        JSONArray waypoint = (JSONArray) waypoints.get(i3);
                        mapTemplate.arrWaypoint_name[i3] = waypoint.get(0).toString();
                        mapTemplate.arrWaypoint_minX[i3] = Short.parseShort(waypoint.get(1).toString());
                        mapTemplate.arrWaypoint_minY[i3] = Short.parseShort(waypoint.get(2).toString());
                        mapTemplate.arrWaypoint_maxX[i3] = Short.parseShort(waypoint.get(3).toString());
                        mapTemplate.arrWaypoint_maxY[i3] = Short.parseShort(waypoint.get(4).toString());
                        mapTemplate.arrWaypoint_isEnter[i3] = Boolean.parseBoolean(waypoint.get(5).toString());
                        mapTemplate.arrWaypoint_isOffline[i3] = Boolean.parseBoolean(waypoint.get(6).toString());
                        mapTemplate.arrWaypoint_goMapID[i3] = Integer.parseInt(waypoint.get(7).toString());
                        mapTemplate.arrWaypoint_goX[i3] = Short.parseShort(waypoint.get(8).toString());
                        mapTemplate.arrWaypoint_goY[i3] = Short.parseShort(waypoint.get(9).toString());
                    }
                    //++++++++++++++LAOD JOSN ARRAY MOBS++++++++++++++++++++//
                    JSONArray mobs = (JSONArray) JSONValue.parseWithException(res.getString(9));
                    mapTemplate.arrMob_templateId = new int[mobs.size()];
                    mapTemplate.arrMob_level = new int[mobs.size()];
                    mapTemplate.arrMob_pointx = new int[mobs.size()];
                    mapTemplate.arrMob_pointy = new int[mobs.size()];
                    for (int i2 = 0; i2 < mapTemplate.arrMob_templateId.length; i2++) {
                        JSONArray mob = (JSONArray) mobs.get(i2);
                        mapTemplate.arrMob_templateId[i2] = Integer.parseInt(mob.get(0).toString());
                        mapTemplate.arrMob_level[i2] = Byte.parseByte(mob.get(1).toString());
                        mapTemplate.arrMob_pointx[i2] = Short.parseShort(mob.get(2).toString());
                        mapTemplate.arrMob_pointy[i2] = Short.parseShort(mob.get(3).toString());
                    }
                    //++++++++++++++LAOD JOSN ARRAY NPCS++++++++++++++++++++//
                    JSONArray npcs = (JSONArray) JSONValue.parseWithException(res.getString(10));
                    mapTemplate.arrNPC_status = new int[npcs.size()];
                    mapTemplate.arrNPC_cx = new int[npcs.size()];
                    mapTemplate.arrNPC_cy = new int[npcs.size()];
                    mapTemplate.arrNPC_templateId = new int[npcs.size()];
                    mapTemplate.arrNPC_avatar = new int[npcs.size()];
                    for (int i1 = 0; i1 < mapTemplate.arrNPC_status.length; i1++) {
                        JSONArray npc = (JSONArray) npcs.get(i1);
                        mapTemplate.arrNPC_status[i1] = Byte.parseByte(npc.get(0).toString());
                        mapTemplate.arrNPC_cx[i1] = Short.parseShort(npc.get(1).toString());
                        mapTemplate.arrNPC_cy[i1] = Short.parseShort(npc.get(2).toString());
                        mapTemplate.arrNPC_templateId[i1] = Integer.parseInt(npc.get(3).toString());
                        mapTemplate.arrNPC_avatar[i1] = Short.parseShort(npc.get(4).toString());
                    }
                    //=======LOAD JSONARRAY tile=====\\
                    JSONArray tileIndex = (JSONArray) JSONValue.parseWithException(res.getString(11));
                    JSONArray tileType = (JSONArray) JSONValue.parseWithException(res.getString(12));
                    mapTemplate.tileIndex = new int[tileIndex.size()][][];
                    mapTemplate.tileType = new int[tileType.size()][];
                    for (int i5 = 0; i5 < mapTemplate.tileIndex.length; i5++) {
                        JSONArray indexs = (JSONArray) tileIndex.get(i5);
                        JSONArray types = (JSONArray) tileType.get(i5);
                        mapTemplate.tileIndex[i5] = new int[indexs.size()][];
                        mapTemplate.tileType[i5] = new int[types.size()];
                        for (int i6 = 0; i6 < indexs.size(); i6++) {
                            JSONArray is = (JSONArray) indexs.get(i6);
                            mapTemplate.tileType[i5][i6] = Integer.parseInt(types.get(i6).toString());
                            mapTemplate.tileIndex[i5][i6] = new int[is.size()];
                            for (int i7 = 0; i7 < mapTemplate.tileIndex[i5][i6].length; i7++) {
                                mapTemplate.tileIndex[i5][i6][i7] = Byte.parseByte(is.get(i7).toString());
                            }
                        }
                    }
                    mapTemplate.tmw = res.getByte(13);
                    mapTemplate.tmh = res.getByte(14);
                    //========JOSNARRAY MAPS=======//
                    JSONArray maps = (JSONArray) JSONValue.parseWithException(res.getString(15));
                    mapTemplate.maps = new int[maps.size()];
                    for (int i2 = 0; i2 < maps.size(); i2++) {
                        mapTemplate.maps[i2] = Short.parseShort(maps.get(i2).toString());
                    }
                    //========JOSNARRAY BGITEM=======//
                    JSONArray bgItem = (JSONArray) JSONValue.parseWithException(res.getString(16));
                    mapTemplate.arrBgItem = new ArrayList<>();
                    for (int i3 = 0; i3 < bgItem.size(); i3++) {
                        JSONArray item = (JSONArray) bgItem.get(i3);
                        mapTemplate.arrBgItem.add(new Short[] {Short.parseShort(item.get(0).toString()), Short.parseShort(item.get(1).toString()), Short.parseShort(item.get(2).toString())});
                    }
                    //========JOSNARRAY EFFECT=======//
                    JSONArray Effect = (JSONArray) JSONValue.parseWithException(res.getString(17));
                    mapTemplate.arrEffect = new ArrayList<>();
                    for (int i4 = 0; i4 < Effect.size(); i4++) {
                        JSONArray eff = (JSONArray) Effect.get(i4);
                        mapTemplate.arrEffect.add(new String[] {eff.get(0).toString(), eff.get(1).toString()});
                    }
                    mapTemplate.types = new int[mapTemplate.maps.length];
                    mapTemplate.loadMap(mapTemplate.tileID);
                    MapTemplate.arrMapTemplate[mapTemplateId] = mapTemplate;
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD NPC TEMPLATE________________//
                System.out.println("Load npcTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `npctemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    Npc.arrNpcTemplate = new NpcTemplate[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    byte npcTemplateId = res.getByte(1);
                    Npc.arrNpcTemplate[npcTemplateId] = new NpcTemplate();
                    Npc.arrNpcTemplate[npcTemplateId].npcTemplateId = npcTemplateId;
                    Npc.arrNpcTemplate[npcTemplateId].name = res.getString(2);
                    Npc.arrNpcTemplate[npcTemplateId].headId = res.getShort(3);
                    Npc.arrNpcTemplate[npcTemplateId].bodyId = res.getShort(4);
                    Npc.arrNpcTemplate[npcTemplateId].legId = res.getShort(5);
                    //JSON ARRAY MENU
                    JSONArray menu = (JSONArray) JSONValue.parseWithException(res.getString(6));
                    Npc.arrNpcTemplate[npcTemplateId].menu = new String[menu.size()][];
                    for (byte i = 0; i < menu.size(); i++) {
                        JSONArray option = (JSONArray) menu.get(i);
                        Npc.arrNpcTemplate[npcTemplateId].menu[i] = new String[option.size()];
                        for (byte j = 0; j < option.size(); j++) {
                            Npc.arrNpcTemplate[npcTemplateId].menu[i][j] = option.get(j).toString();
                        }
                    }
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD MOB TEMPLATE________________//
                System.out.println("Load mobTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `mobtemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    Mob.arrMobTemplate = new MobTemplate[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    byte mobTemplateId = res.getByte(1);
                    Mob.arrMobTemplate[mobTemplateId] = new MobTemplate();
                    Mob.arrMobTemplate[mobTemplateId].type = res.getByte(2);
                    Mob.arrMobTemplate[mobTemplateId].name = res.getString(3);
                    Mob.arrMobTemplate[mobTemplateId].hp = res.getInt(4);
                    Mob.arrMobTemplate[mobTemplateId].rangeMove = res.getByte(5);
                    Mob.arrMobTemplate[mobTemplateId].speed = res.getByte(6);
                    Mob.arrMobTemplate[mobTemplateId].dartType = res.getByte(7);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD SKILL OPTION TEMPLATE________________//
                System.out.println("Load SkillOptionTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `skilloptiontemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    GameData.sOptionTemplates = new SkillOptionTemplate[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    byte id = res.getByte(1);
                    GameData.sOptionTemplates[id] = new SkillOptionTemplate();
                    GameData.sOptionTemplates[id].id = id;
                    GameData.sOptionTemplates[id].name = res.getString(2);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD SKILS________________//
                System.out.println("Load Skills");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `skill`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    Skill.arrSkill = new Skill[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    short skillId = res.getShort("skillId");
                    Skill.arrSkill[skillId] = new Skill();
                    Skill.arrSkill[skillId].skillId = skillId;
                    Skill.arrSkill[skillId].point = res.getByte("point");
                    Skill.arrSkill[skillId].powRequire = res.getLong("powRequire");
                    Skill.arrSkill[skillId].manaUse = res.getShort("manaUse");
                    Skill.arrSkill[skillId].coolDown = res.getInt("coolDown");
                    Skill.arrSkill[skillId].dx = res.getShort("dx");
                    Skill.arrSkill[skillId].dy = res.getShort("dy");
                    Skill.arrSkill[skillId].maxFight = res.getByte("maxFight");
                    Skill.arrSkill[skillId].damage = res.getShort("damage");
                    Skill.arrSkill[skillId].price = res.getShort("price");
                    Skill.arrSkill[skillId].moreInfo = res.getString("moreInfo");
                    n++;
                }
                res.close();
                //THE END

                //++++++++++++++LOAD SKILL TEMPLATE++++++++++++++++++++++//
                System.out.println("Load SkillTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `skilltemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    Skill.arrSkillTemplate = new SkillTemplate[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    byte id = res.getByte("id");
                    Skill.arrSkillTemplate[id] = new SkillTemplate();
                    Skill.arrSkillTemplate[id].id = id;
                    Skill.arrSkillTemplate[id].name = res.getString("name");
                    Skill.arrSkillTemplate[id].maxPoint = res.getByte("maxPoint");
                    Skill.arrSkillTemplate[id].manaUseType = res.getByte("manaUseType");
                    Skill.arrSkillTemplate[id].type = res.getByte("type");
                    Skill.arrSkillTemplate[id].iconId = res.getShort("iconId");
                    Skill.arrSkillTemplate[id].damInfo = res.getString("damInfo");
                    Skill.arrSkillTemplate[id].description = res.getString("description");
                    //----------JSON SKILLS LOAD----------//
                    JSONArray skills = (JSONArray) JSONValue.parseWithException(res.getString("skills"));
                    Skill.arrSkillTemplate[id].skills = new Skill[skills.size()];
                    for (byte i = 0; i < Skill.arrSkillTemplate[id].skills.length; i++) {
                        Skill.arrSkillTemplate[id].skills[i] = Skill.arrSkill[Integer.parseInt(skills.get(i).toString())];
                        Skill.arrSkillTemplate[id].skills[i].template = Skill.arrSkillTemplate[id];
                    }
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD NCLASS________________//
                System.out.println("Load NClass");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `nclass`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    GameData.nClasss = new NClass[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    byte classId = res.getByte(1);
                    GameData.nClasss[classId] = new NClass();
                    GameData.nClasss[classId].name = res.getString(2);
                    //-------------JSON SKILLTEMPLATES
                    JSONArray skilltemplates = (JSONArray) JSONValue.parseWithException(res.getString(3));
                    GameData.nClasss[classId].skillTemplates = new SkillTemplate[skilltemplates.size()];
                    for (byte i = 0; i < GameData.nClasss[classId].skillTemplates.length; i++) {
                        GameData.nClasss[classId].skillTemplates[i] = Skill.arrSkillTemplate[Integer.parseInt(skilltemplates.get(i).toString())];
                    }
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD ITEM OPTION TEMPLATE________________//
                System.out.println("Load ItemOptionTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `itemoptiontemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    GameData.iOptionTemplates = new ItemOptionTemplate[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    int id = res.getInt(1);
                    GameData.iOptionTemplates[id] = new ItemOptionTemplate();
                    GameData.iOptionTemplates[id].id = id;
                    GameData.iOptionTemplates[id].name = res.getString(2);
                    GameData.iOptionTemplates[id].type = res.getByte(3);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD ITEM TEMPLATE________________//
                System.out.println("Load ItemTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `itemtemplate`;").executeQuery();
                ItemTemplate.itemTemplates.clear();
                n = 0;
                while(res.next()) {
                    short id = res.getShort(1);
                    ItemTemplate itemTemplate = new ItemTemplate();
                    itemTemplate.id = id;
                    itemTemplate.type = res.getByte(2);
                    itemTemplate.gender = res.getByte(3);
                    itemTemplate.name = res.getString(4);
                    itemTemplate.description = res.getString(5);
                    itemTemplate.level = res.getByte(6);
                    itemTemplate.strRequire = res.getInt(7);
                    itemTemplate.iconID = res.getShort(8);
                    itemTemplate.part = res.getShort(9);
                    itemTemplate.isUpToUp = res.getBoolean(10);
                    itemTemplate.isNew = res.getBoolean("isNew");
                    ItemTemplate.add(itemTemplate);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD SHOPS________________//
                System.out.println("Load Shops");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `shop`;").executeQuery();
                n = 0;
                Shop.shops.clear();
                while(res.next()) {
                    int shopId = res.getByte(1);
                    Shop shop = new Shop();
                    shop.shopId = shopId;
                    shop.type = res.getByte(2);
                    //__________LOAD JOSNARRRAY SHOP____________//
                    JSONArray shopTabName = (JSONArray) JSONValue.parseWithException(res.getString(3));
                    JSONArray arrItemShop = (JSONArray) JSONValue.parseWithException(res.getString(4));
                    shop.shopTabName = new String[shopTabName.size()];
                    shop.arrItemShop = new ArrayList[arrItemShop.size()];
                    for (short i = 0; i < shop.shopTabName.length; i++) {
                        shop.shopTabName[i] = shopTabName.get(i).toString();
                        JSONArray items = (JSONArray) arrItemShop.get(i);
                        shop.arrItemShop[i] = new ArrayList<>();
                        for (int k = 0; k < items.size(); k++) {
                            shop.arrItemShop[i].add(Item.parseItem(items.get(k).toString()));
                        }
                    }
                    Shop.shops.put(shop.shopId, shop);
                    n++;
                }
                res.close();
                //THE END

                //_________________LOAD FLAG______________//
                System.out.println("Load Flags");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `flags`;").executeQuery();
                n = 0;
                Flag.FLAGS.clear();
                while(res.next()) {
                    Flag.FLAGS.add(new Flag(res.getInt("id"), res.getString("name"), Item.parseItem(res.getString("itemFlag"))));
                    n++;
                }
                //THE END

                //_________________LOAD MONKEYS______________//
                System.out.println("Load Monkeys");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `monkeys`;").executeQuery();
                n = 0;
                Monkey.MONKEYS.clear();
                while(res.next()) {
                    Monkey.MONKEYS.add(new Monkey(res.getByte("levelMonkey"), res.getShort("head"), res.getShort("body"), res.getShort("leg"), res.getInt("addST"), res.getInt("addHP")));
                    n++;
                }
                //THE END

                //____________LOAD HEAD________________//
                System.out.println("Load Head");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `head`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    dragon.t.Head.idHead = new short[res.getRow()];
                    dragon.t.Head.idAvatar = new short[dragon.t.Head.idHead.length];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    dragon.t.Head.idHead[n] = res.getShort(1);
                    dragon.t.Head.idAvatar[n] = res.getShort(2);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD CAPTION________________//
                System.out.println("Load Caption");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `caption`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    GameData.strLevel = new String[res.getRow()][];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    JSONArray caption = (JSONArray) JSONValue.parseWithException(res.getString(2));
                    GameData.strLevel[n] = new String[caption.size()];
                    int i;
                    for (i = 0; i < GameData.strLevel[n].length; i++) {
                        GameData.strLevel[n][i] = caption.get(i).toString();
                    }
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD TASK________________//
                System.out.println("Load Task");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `task`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    Task.arrTask = new Task[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    Task task = new Task();
                    int i;
                    int j;
                    task.taskId = res.getShort(1);
                    JSONArray jarr;
                    JSONArray jarr2;
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(2));
                    task.name = new String[jarr.size()];
                    for (i = 0; i < jarr.size(); i++) {
                        task.name[i] = jarr.get(i).toString();
                    }
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(3));
                    task.detail = new String[jarr.size()];
                    for (i = 0; i < jarr.size(); i++) {
                        task.detail[i] = jarr.get(i).toString();
                    }
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(4));
                    task.subNames = new String[jarr.size()][];
                    for (i = 0; i < jarr.size(); i++) {
                        jarr2 = (JSONArray) jarr.get(i);
                        task.subNames[i] = new String[jarr2.size()];
                        for (j = 0; j < task.subNames[i].length; j++) {
                            task.subNames[i][j] = jarr2.get(j).toString();
                        }
                    }
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(5));
                    task.tasks = new int[jarr.size()][];
                    for (i = 0; i < jarr.size(); i++) {
                        jarr2 = (JSONArray) jarr.get(i);
                        task.tasks[i] = new int[jarr2.size()];
                        for (j = 0; j < task.tasks[i].length; j++) {
                            task.tasks[i][j] = Byte.parseByte(jarr2.get(j).toString());
                        }
                    }
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(6));
                    task.mapTasks = new int[jarr.size()][];
                    for (i = 0; i < jarr.size(); i++) {
                        jarr2 = (JSONArray) jarr.get(i);
                        task.mapTasks[i] = new int[jarr2.size()];
                        for (j = 0; j < task.mapTasks[i].length; j++) {
                            task.mapTasks[i][j] = Short.parseShort(jarr2.get(j).toString());
                        }
                    }
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(7));
                    task.contentInfo = new String[jarr.size()][];
                    for (i = 0; i < jarr.size(); i++) {
                        jarr2 = (JSONArray) jarr.get(i);
                        task.contentInfo[i] = new String[jarr2.size()];
                        for (j = 0; j < task.contentInfo[i].length; j++) {
                            task.contentInfo[i][j] = jarr2.get(j).toString();
                        }
                    }
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(8));
                    task.counts = new short[jarr.size()][];
                    for (i = 0; i < jarr.size(); i++) {
                        jarr2 = (JSONArray) jarr.get(i);
                        task.counts[i] = new short[jarr2.size()];
                        for (j = 0; j < task.counts[i].length; j++) {
                            task.counts[i][j] = Short.parseShort(jarr2.get(j).toString());
                        }
                    }
                    Task.arrTask[n] = task;
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD BAGIMAGE________________//
                System.out.println("Load bagImage");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `bagimage`;").executeQuery();
                n = 0;
                ClanImage.images.clear();
                while(res.next()) {
                    int i;
                    JSONArray jarr;
                    ClanImage clanImage = new ClanImage();
                    clanImage.ID = res.getInt(1);
                    clanImage.name = res.getString(2);
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(3));
                    clanImage.idImage = new short[jarr.size()];
                    for (i = 0; i < jarr.size(); i++) {
                        clanImage.idImage[i] = Short.parseShort(jarr.get(i).toString());
                    }
                    jarr = (JSONArray) JSONValue.parseWithException(res.getString(4));
                    clanImage.idImage2 = new short[jarr.size()];
                    for (i = 0; i < jarr.size(); i++) {
                        clanImage.idImage2[i] = Short.parseShort(jarr.get(i).toString());
                    }
                    ClanImage.images.put(clanImage.ID, clanImage);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD CHARTEMPLATE________________//
                System.out.println("Load charTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `chartemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    CharTemplate.arrCharTemplate = new CharTemplate[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    CharTemplate.arrCharTemplate[n] = new CharTemplate(res);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD RADA________________//
                System.out.println("Load radaTemplate");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `radatemplate`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    RadaTemplate.arrRadaTemplate = new RadaTemplate[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    RadaTemplate.arrRadaTemplate[n] = new RadaTemplate(res);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD DartInfo________________//
                System.out.println("Load DartInfo");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `dartinfo`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    DartInfo.darts = new DartInfo[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    DartInfo.darts[n] = new DartInfo(res);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD Arrow________________//
                System.out.println("Load Arrow");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `arrow`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    Arrow.arrs = new Arrow[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    Arrow.arrs[n] = new Arrow(res);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD EffectCharPaint ________________//
                System.out.println("Load EffectCharPaint");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `effectcharpaint`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    EffectCharPaint.efs = new EffectCharPaint[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    EffectCharPaint.efs[n] = new EffectCharPaint(res);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD SmallImage ________________//
                System.out.println("Load SmallImage");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `smallimage`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    SmallImage.smallImg = new int[res.getRow()][5];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    JSONArray jarr = (JSONArray) JSONValue.parseWithException(res.getString("smallImg"));
                    SmallImage.smallImg[n][0] = Integer.parseInt(jarr.get(0).toString());
                    SmallImage.smallImg[n][1] = Short.parseShort(jarr.get(1).toString());
                    SmallImage.smallImg[n][2] = Short.parseShort(jarr.get(2).toString());
                    SmallImage.smallImg[n][3] = Short.parseShort(jarr.get(3).toString());
                    SmallImage.smallImg[n][4] = Short.parseShort(jarr.get(4).toString());
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD Part________________//
                System.out.println("Load Part");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `part`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    Part.parts = new Part[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    Part.parts[n] = new Part(res);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD SkillPaint ________________//
                System.out.println("Load SkillPaint");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `skillpaint`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    SkillPaint.sks = new SkillPaint[res.getRow()];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    SkillPaint.sks[n] = new SkillPaint(res);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD ARRTASKS________________//
                System.out.println("Load archivement");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `archivement`;").executeQuery();
                n = 0;
                Achievement.arrArchivement.clear();
                while(res.next()) {
                    Achievement.arrArchivement.add(new Achievement(res));
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD EFFECTDATA________________//
                System.out.println("Load EffectData");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `effectdata`;").executeQuery();
                n = 0;
                EffectData.effectData.clear();
                while(res.next()) {
                    int ID = res.getShort(1);
                    byte typeW = res.getByte("type");
                    HashMap<Integer, EffectData> effdata = new HashMap<>();
                    effdata.put(1, new EffectData(ID, res.getString("x1"), typeW).loadImage(1));
                    effdata.put(2, new EffectData(ID, res.getString("x2"), typeW).loadImage(2));
                    effdata.put(3, new EffectData(ID, res.getString("x3"), typeW).loadImage(3));
                    effdata.put(4, new EffectData(ID, res.getString("x4"), typeW).loadImage(4));
                    EffectData.effectData.put(ID, effdata);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD MOBDATA________________//
                System.out.println("Load MobData");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `mobdata`;").executeQuery();
                n = 0;
                EffectData.mobData.clear();
                while(res.next()) {
                    int ID = res.getShort(1);
                    byte typeW = res.getByte("type");
                    byte typeData = res.getByte("typeData");
                    HashMap<Integer, EffectData> mobdata = new HashMap<>();
                    mobdata.put(1, new EffectData(ID, res.getString("x1"), typeW).loadImage(1, typeData).loadFrame_NEWBOSS(res.getString("frame_NEWBOSS")));
                    mobdata.put(2, new EffectData(ID, res.getString("x2"), typeW).loadImage(2, typeData).loadFrame_NEWBOSS(res.getString("frame_NEWBOSS")));
                    mobdata.put(3, new EffectData(ID, res.getString("x3"), typeW).loadImage(3, typeData).loadFrame_NEWBOSS(res.getString("frame_NEWBOSS")));
                    mobdata.put(4, new EffectData(ID, res.getString("x4"), typeW).loadImage(4, typeData).loadFrame_NEWBOSS(res.getString("frame_NEWBOSS")));
                    EffectData.mobData.put(ID, mobdata);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD bgItem ________________//
                System.out.println("Load bgItem");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `bgitem`;").executeQuery();
                n = 0;
                BgItem.aItemBg.clear();
                while(res.next()) {
                    BgItem bgItem = new BgItem(res);
                    BgItem.aItemBg.add(bgItem);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD Arr_Head_2Fr ________________//
                System.out.println("Load Arr_Head_2Fr");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `fhead`;", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                if (res.last()) {
                    GameData.Arr_Head_2Fr = new int[res.getRow()][];
                    res.beforeFirst();
                }
                n = 0;
                while(res.next()) {
                    JSONArray jarr = (JSONArray) JSONValue.parseWithException(res.getString("fHead"));
                    GameData.Arr_Head_2Fr[n] = new int[jarr.size()];
                    for (int i = 0; i < GameData.Arr_Head_2Fr[n].length; i++) {
                        GameData.Arr_Head_2Fr[n][i] = Short.parseShort(jarr.get(i).toString());
                    }
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD TaskEveryDay ________________//
                System.out.println("Load TaskEveryDay");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `taskeveryday`;").executeQuery();
                n = 0;
                TaskEveryDay.myArrayList.clear();
                while(res.next()) {
                    TaskEveryDay task = new TaskEveryDay(res);
                    TaskEveryDay.myArrayList.add(task);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD TaskClanEveryDay ________________//
                System.out.println("Load TaskClanEveryDay");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `taskclaneveryday`;").executeQuery();
                n = 0;
                TaskEveryDay.myArrayListClan.clear();
                while(res.next()) {
                    TaskEveryDay task = new TaskEveryDay(res);
                    TaskEveryDay.myArrayListClan.add(task);
                    n++;
                }
                res.close();
                //THE END

                //____________LOAD TaskDanhHieu ________________//
                System.out.println("Load TaskDanhHieu");
                res = mySQL.getConnection().prepareStatement("SELECT * FROM `taskdanhhieu`;").executeQuery();
                n = 0;
                TaskDanhHieu.hTask.clear();
                while(res.next()) {
                    TaskDanhHieu task = new TaskDanhHieu(res);
                    TaskDanhHieu.hTask.put(task.id, task);
                    n++;
                }
                res.close();
                //THE END
            } finally {
                mySQL.close();
            }
        } catch (SQLException | ParseException e) {
            System.err.println("index = "+n);
            e.printStackTrace();
            System.exit(0);
        }
    }
    
}
