package dragon.t;

import dragon.server.Server;
import dragon.server.mResources;

import java.util.ArrayList;


/**
 *
 * @author TGDD
 */
public class Boss {
    
    public short[] petInfoHead;
    
    public int[] botId = new int[] {
        168,
        167,
        62,
        61,
        60,
        59,
        58,
        63,
        69,
        70,
        68,
        67,
        72,
        71,
        73,
        74,
        23,
        4,
        1,
        51,
        50,
        49,
        48,
        47,
        114,
        113,
        112,
        111,
        110,
        169
    };
    
    public int[] botSetTime = new int[] {
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        900000,
        1800000,
        1800000,
        1800000, 
        1800000,
        1800000,
        1800000,
        1800000,
        1800000,
        1800000,
        1800000,
        1800000,
        1800000,
        1800000,
        1800000
    };
    
    public int[] botTimeHs = new int[] {
        60000,
        60000,
        70000,
        73000,
        76000,
        79000,
        89000,
        100000,
        103000,
        113000,
        113000,
        123000,
        123000,
        123000,
        133000,
        143000,
        153000,
        163000,
        173000,
        183000,
        183000,
        183000,
        183000,
        190000,
        192000,
        194000,
        196000,
        198000,
        200000,
        202000,
    };
    
    public ZoneMap[] bossZone = new ZoneMap[]{
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    };
    
    protected static Boss instance;
    
    public static Boss gI() {
        if (instance == null) {
            instance = new Boss();
            instance.petInfoHead = new short[] {
                285,
                288,
                282
            };
        }
        return instance;
    }
    
    
    public void updateDie(Char player, Char boss, ZoneMap zone) {
        //Nhiem vu hang ngay
        if (player != null && player.session != null && player.myObj().taskEveryday != null && player.myObj().taskEveryday.template.type == 2 && player.myObj().taskEveryday.template.templateId == boss.cTemplateId) {
        	if (player.myObj().taskEveryday.addCount(1)) {
        		player.addInfo1(mResources.TAKE_GIFT3);
        	}
        }
        //Nhiem vu thanh tich trum diet boss
        if (player.session != null) {
        	player.updateArchivement(19, 1L);
        }
        //Broly
        if (boss.cTemplateId == 13) {
            
//            if (boss.cHPGoc >= 1000000L) {
//                Char bot = Player.addBoss(14, 0, boss.cHPGoc, -1, true, boss.cx, boss.cy, null, 10000, boss.indexXH);
//                bot.maxTimeEff = 5000;
//                bot.arrInMap = boss.arrInMap;
//                if (boss.numberXH != -1) {
//                    bot.numberXH = boss.numberXH;
//                    bot.cName = String.format(mResources.ADD_FORMAT_D, bot.cName, boss.numberXH);
//                }
//                int num0 = 0;
//                while (num0++ < 100) {
//                    try {
//                        ZoneMap zone_127 = boss.zoneMap.map.zones.get(Util.gI().nextInt(20));
//                        if (zone_127.countBossById(13) > 0) {
//                            continue;
//                        }
//                        zone_127.join(bot, 0, -1, -1);
//                        break;
//                    } catch (Exception e) {
//                    }
//                }
//                Server.gI().chatVip(String.format(mResources.BOSS_HAVE, bot.cName, boss.zoneMap.mapTemplate.mapName));
//            } else if (boss.numberXH != -1) {
//                Char bot2 = Player.addBoss(13, 0, -1, -1, true, boss.cx, boss.cy, null, 10000, boss.indexXH);
//                bot2.cName = boss.cName;
//                bot2.numberXH = boss.numberXH;
//                bot2.arrInMap = boss.arrInMap;
//                int num1 = 0;
//                while(num1++ < 100) {
//                    try {
//                        Map map_437 = Map.getMapServer(bot2.arrInMap[Util.gI().nextInt(bot2.arrInMap.length)]);
//                        ZoneMap zone_128 = map_437.zones.get(Util.gI().nextInt(20));
//                        if (zone_128.countBossById(13) > 0) {
//                            continue;
//                        }
//                        zone_128.join(bot2, 0, -1, -1);
//                        break;
//                    } catch (Exception e) {
//                    }
//                }
//            }
        }
        if (boss.cTemplateId == 46) {
            Char[] arrChar;
            synchronized (zone.players) {
                arrChar = new Char[zone.players.size()];
                for (int i = 0; i < zone.players.size(); i++) {
                    arrChar[i] = zone.players.get(i);
                }
            }
            for (int i = 0; i < arrChar.length; i++) {
                if (arrChar[i] != null && arrChar[i].ctaskId == 21 && arrChar[i].ctaskIndex == 1) {
                    arrChar[i].updateTask(1);
                }
            }
        }
        //Tau Pay Pay
        if (boss.cTemplateId == 53) {
            if (player != null && player.ctaskId == 10 && player.ctaskIndex == 1) {
                player.updateTask(1);
                zone.chat(boss, mResources.KHA_LAM);
            }
        }
        //Than meo karin
        if (boss.cTemplateId == 54) {
            if (player != null && player.ctaskId == 10 && player.ctaskIndex == 0) {
                player.updateTask(1);
            }
        }
        if (boss.cTemplateId == 77) {
            Char[] arrChar;
            synchronized (zone.players) {
                arrChar = new Char[zone.players.size()];
                for (int i = 0; i < zone.players.size(); i++) {
                    arrChar[i] = zone.players.get(i);
                }
            }
            for (int i = 0; i < arrChar.length; i++) {
                if ((int) (100f / (float)boss.cHPFull * (float)boss.getDam(arrChar[i].charID)) >= 20) {
                    if (arrChar[i].ctaskId == 33 && arrChar[i].ctaskIndex == 1) {
                        arrChar[i].updateTask(1);
                    }
                    if (arrChar[i].me && !arrChar[i].isTemplate) {
                        arrChar[i].updateCollectPoint(10);
                    }
                }
            }
        }
        if (boss.cTemplateId == 78) {
            Char[] arrChar;
            synchronized (zone.players) {
                arrChar = new Char[zone.players.size()];
                for (int i = 0; i < zone.players.size(); i++) {
                    arrChar[i] = zone.players.get(i);
                }
            }
            for (int i = 0; i < arrChar.length; i++) {
                if ((int) (100f / (float)boss.cHPFull * (float)boss.getDam(arrChar[i].charID)) >= 20) {
                    if (arrChar[i].ctaskId == 33 && arrChar[i].ctaskIndex == 2) {
                        arrChar[i].updateTask(1);
                    }
                    if (arrChar[i].me && !arrChar[i].isTemplate) {
                        arrChar[i].updateCollectPoint(10);
                    }
                }
            }
        }
        if (boss.cTemplateId == 83) {
            Char[] arrChar;
            synchronized (zone.players) {
                arrChar = new Char[zone.players.size()];
                for (int i = 0; i < zone.players.size(); i++) {
                    arrChar[i] = zone.players.get(i);
                }
            }
            for (int i = 0; i < arrChar.length; i++) {
                if ((int) (100f / (float)boss.cHPFull * (float)boss.getDam(arrChar[i].charID)) >= 20) {
                    if (arrChar[i].ctaskId == 33 && arrChar[i].ctaskIndex == 3) {
                        arrChar[i].updateTask(1);
                    }
                    if (arrChar[i].me && !arrChar[i].isTemplate) {
                        arrChar[i].updateCollectPoint(10);
                    }
                }
            }
        }
        if (boss.cTemplateId == 79) {
            Char[] arrChar;
            synchronized (zone.players) {
                arrChar = new Char[zone.players.size()];
                for (int i = 0; i < zone.players.size(); i++) {
                    arrChar[i] = zone.players.get(i);
                }
            }
            for (int i = 0; i < arrChar.length; i++) {
                if ((int) (100f / (float)boss.cHPFull * (float)boss.getDam(arrChar[i].charID)) >= 20) {
                    if (arrChar[i].ctaskId == 33 && arrChar[i].ctaskIndex == 4) {
                        arrChar[i].updateTask(1);
                    }
                    if (arrChar[i].me && !arrChar[i].isTemplate) {
                        arrChar[i].updateCollectPoint(10);
                    }
                }
            }
        }
        if (boss.cTemplateId == 81) {
            Char[] arrChar;
            synchronized (zone.players) {
                arrChar = new Char[zone.players.size()];
                for (int i = 0; i < zone.players.size(); i++) {
                    arrChar[i] = zone.players.get(i);
                }
            }
            for (int i = 0; i < arrChar.length; i++) {
                if ((int) (100f / (float)boss.cHPFull * (float)boss.getDam(arrChar[i].charID)) >= 20) {
                    if (arrChar[i].ctaskId == 33 && arrChar[i].ctaskIndex == 5) {
                        arrChar[i].updateTask(1);
                    }
                    if (arrChar[i].me && !arrChar[i].isTemplate) {
                        arrChar[i].updateCollectPoint(10);
                    }
                }
            }
        }
        if (boss.cTemplateId == 80) {
            Char[] arrChar;
            synchronized (zone.players) {
                arrChar = new Char[zone.players.size()];
                for (int i = 0; i < zone.players.size(); i++) {
                    arrChar[i] = zone.players.get(i);
                }
            }
            for (int i = 0; i < arrChar.length; i++) {
                if ((int) (100f / (float)boss.cHPFull * (float)boss.getDam(arrChar[i].charID)) >= 20) {
                    if (arrChar[i].ctaskId == 33 && arrChar[i].ctaskIndex == 6) {
                        arrChar[i].updateTask(1);
                    }
                    if (arrChar[i].me && !arrChar[i].isTemplate) {
                        arrChar[i].updateCollectPoint(10);
                    }
                }
            }
        }
        //Nhiem vu
        if (player != null) {
            if (boss.cTemplateId == 55 && player.ctaskId == 23 && player.ctaskIndex == 0) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 56 && player.ctaskId == 23 && player.ctaskIndex == 2) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 57 && player.ctaskId == 23 && player.ctaskIndex == 1) {
                player.updateTask(1);
            }
            //Tieu doi sat thu
            
            if (boss.cTemplateId == 58 && player.ctaskId == 24 && player.ctaskIndex == 0) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 59 && player.ctaskId == 24 && player.ctaskIndex == 1) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 61 && player.ctaskId == 24 && player.ctaskIndex == 2) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 62 && player.ctaskId == 24 && player.ctaskIndex == 3) {
                player.updateTask(1);
            }
            
            //Fide dai ca
            if (boss.cTemplateId == 63 && player.ctaskId == 25 && player.ctaskIndex == 0) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 64 && player.ctaskId == 25 && player.ctaskIndex == 1) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 65 && player.ctaskId == 25 && player.ctaskIndex == 2) {
                player.updateTask(1);
            }
            
            //Robot sat thu
            if (boss.cTemplateId == 69 && player.ctaskId == 27 && player.ctaskIndex == 1) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 70 && player.ctaskId == 27 && player.ctaskIndex == 2) {
                player.updateTask(1);
            }
            
            //Robot sat thu 2
            if (boss.cTemplateId == 68 && player.ctaskId == 28 && player.ctaskIndex == 1) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 67 && player.ctaskId == 28 && player.ctaskIndex == 2) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 66 && player.ctaskId == 28 && player.ctaskIndex == 3) {
                player.updateTask(1);
            }
            
            //Robot sat thu 3
            if (boss.cTemplateId == 71 && player.ctaskId == 29 && player.ctaskIndex == 1) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 72 && player.ctaskId == 29 && player.ctaskIndex == 2) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 73 && player.ctaskId == 29 && player.ctaskIndex == 3) {
                player.updateTask(1);
            }
            
            //Xen bo hung
            if (boss.cTemplateId == 74 && player.ctaskId == 30 && player.ctaskIndex == 1) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 75 && player.ctaskId == 30 && player.ctaskIndex == 2) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 76 && player.ctaskId == 30 && player.ctaskIndex == 3) {
                player.updateTask(1);
            }
            
            //Xen dao choi
            if (boss.cTemplateId == 25 && player.ctaskId == 31 && player.ctaskIndex == 3) {
                player.updateTask(1);
            }
            if (boss.cTemplateId == 24 && player.ctaskId == 31 && player.ctaskIndex == 4) {
                player.updateTask(1);
            }
        }
    }
    
    public void updateDie(Char player, Char boss, ArrayList<ItemMap> itemMaps, ZoneMap zone) {
        Boss.gI().updateDie(player, boss, zone);
        int charId = -1;
        if (player != null) {
            charId = player.myCharz().charID;
        }
        //Gift
        switch(boss.cTemplateId) {       
            //Cooler
            case 1:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                 //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_1 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it_1.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        if (Util.gI().nextInt(100) < 10) {
                            it_1.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it_1, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi ao than linh va ao
                if (Util.gI().nextInt(200) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555,557,559,563,565,567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi gang than linh
                if (Util.gI().nextInt(300) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(800) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi nhan than linh
                if (Util.gI().nextInt(1000) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Coller 2
            case 2:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 10, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                 //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_1 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it_1.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        if (Util.gI().nextInt(100) < 10) {
                            it_1.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it_1, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi ao than linh va ao
                if (Util.gI().nextInt(150) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555,557,559,563,565,567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi gang than linh
                if (Util.gI().nextInt(200) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(600) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi nhan than linh
                if (Util.gI().nextInt(800) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null  && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Fide vang
            case 3:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 1, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT FIDE GOLD
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(629, false, 1, ItemOption.getOption(629, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    if (Util.gI().nextInt(100) < 98) {
                        itemMap.item.options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
                    }
                    itemMaps.add(itemMap);
                }
                
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Black Goku
            case 4:
            {   
                // bi kip tuyet ki
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 10, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 30) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi ao than linh
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555, 557, 559, 563, 565, 567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi gang than linh
                if (Util.gI().nextInt(150) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(500) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi nhan than linh
                if (Util.gI().nextInt(800) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 2, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }

                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Super Black Goku
            case 5:
            {
                // bi kip tuyet ki
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 10, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 2 sao
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(15, false, 1, ItemOption.getOption(15, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi ao than linh
                if (Util.gI().nextInt(100) <= 2) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555, 557, 559, 563, 565, 567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi gang than linh
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(400) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi nhan than linh
                if (Util.gI().nextInt(500) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 2, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //nhan thoi khong sai lech
                {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(992, false, 1, ItemOption.getOption(992, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Dr Lychee
            case 11:
            {
                int ss = 0;
                if (zone.map.destronGas != null) {
                    if (zone.map.destronGas.level > 100) {
                        ss = dragon.t.Util.gI().nextInt(3, 5);
                    } else if (zone.map.destronGas.level > 80) {
                        ss = dragon.t.Util.gI().nextInt(2, 4);
                    } else if (zone.map.destronGas.level > 60) {
                        ss = dragon.t.Util.gI().nextInt(1, 3);
                    } else if (zone.map.destronGas.level > 40) {
                        ss = dragon.t.Util.gI().nextInt(1, 2);
                    } else if (zone.map.destronGas.level > 20) {
                        ss = 1;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    int toX = 200 + (i * 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(738, false, 1, ItemOption.getOption(738, ss, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                Char b = Player.addBoss(12, 0, -1, -1, true, 400, 150, null, 5000, -1);
                b.countLevel = boss.countLevel;
                b.downDamage_percent = 60;
                b.cHP = b.cHPFull = b.cHPGoc = b.cHPGoc * b.countLevel;
                zone.join(b, 0, -1, -1);
                break;
            }
            //
            case 12:
            {
                int ss = 0;
                if (zone.map.destronGas != null) {
                    if (zone.map.destronGas.level > 100) {
                        ss = 5;
                    } else if (zone.map.destronGas.level > 80) {
                        ss = 4;
                    } else if (zone.map.destronGas.level > 60) {
                        ss = 3;
                    } else if (zone.map.destronGas.level > 40) {
                        ss = 2;
                    } else if (zone.map.destronGas.level > 20) {
                        ss = 1;
                    }
                }
                for (int i = 0; i < 5; i++) {
                    int toX = 200 + (i * 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(729, false, 1, ItemOption.getOption(729, ss, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (zone.map.destronGas != null) {
                    Rank.RANKS.get(0).addTop(zone.map.destronGas.clan.name, zone.map.destronGas.clan.getMemberByName(zone.map.destronGas.clan.leaderName).head, zone.map.destronGas.clan.getMemberByName(zone.map.destronGas.clan.leaderName).headICON, zone.map.destronGas.clan.getMemberByName(zone.map.destronGas.clan.leaderName).body, zone.map.destronGas.clan.getMemberByName(zone.map.destronGas.clan.leaderName).leg, zone.map.destronGas.clan.getMemberByName(zone.map.destronGas.clan.leaderName).ID, zone.map.destronGas.level, (int) (System.currentTimeMillis() - zone.map.destronGas.lastOpen));
                    if (zone.map.destronGas.level >= 110) {
                        Server.gI().chatVip(String.format(mResources.WIN_GAS, zone.map.destronGas.clan.name, zone.map.destronGas.clan.leaderName, zone.map.destronGas.level));
                    }
                    zone.map.destronGas.miliTime = 30000;
                }
                break;
            }
            //Super Broly
            case 14:
            {
                if (player != null) {
                    if (player.myCharz().myPet == null) {
//                        Player.petInfo(player, Util.gI().nextInt(3));
//                        zone.join(player.myPetz(), 0, Util.gI().nextInt(player.cx - 24, player.cx + 24), player.cy);
//                        player.myCharz().session.service.chat(player.myPetz().charID, mResources.XIN_HAY_NHAN);
                    } else {
//                        Char o = zone.getPlayerNotPetz();
//                        if (o != null) {
//                            Player.petInfo(o, util.nextInt(3));
//                            o.myPetz().cx = util.nextInt(o.cx - 24, o.cx + 24);
//                            o.myPetz().cy = o.cy;
//                            zone.join(o.myPetz(), 0);
//                            Service.chat(o.myCharz().session, o.myPetz().charID, mResources.XIN_HAY_NHAN);
//                        }
                    }
                    //Trung mabu

                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(568, false, 1, ItemOption.getOption(568, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Xen hoan thien
            case 23:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 10) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) <= 15) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 20) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Sieu bo hung
            case 24:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Ngoc rong 2 sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(15, false, 1, ItemOption.getOption(15, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 30) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi ao than linh
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555,557,559,563,565,567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi gang than linh
                if (Util.gI().nextInt(150) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(400) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        //Add % param
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6 ||
                                    option.optionTemplate.id == 7 || option.optionTemplate.id == 14 ||
                                    option.optionTemplate.id == 22 || option.optionTemplate.id == 23 ||
                                    option.optionTemplate.id == 27 || option.optionTemplate.id == 28 ||
                                    option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi nhan than linh
                if (Util.gI().nextInt(500) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Xen con
            case 25:
            {   
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Tap su
            case 27:
            {
                boss.liveFromDead(2);
                boss.timeChangePk5 = 1;
                //Bi kiep
                if (Util.gI().nextInt(100) < 80) {
                    for (int i = 0; i < 2; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Tan binh
            case 28:
            {
                boss.liveFromDead(2);
                boss.timeChangePk5 = 1;
                //Bi kiep
                if (Util.gI().nextInt(100) < 80) {
                    for (int i = 0; i < 2; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Chien binh
            case 29:
            {
                boss.liveFromDead(2);
                boss.timeChangePk5 = 1;
                //Bi kiep
                if (Util.gI().nextInt(100) < 80) {
                    for (int i = 0; i < 2; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Doi truong
            case 30:
            {
                boss.liveFromDead(2);
                boss.timeChangePk5 = 1;
                //Bi kiep
                if (Util.gI().nextInt(100) < 80) {
                    for (int i = 0; i < 2; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Ninja Ao Tim
            case 42:
            {
                if (boss.isBossMain) {
                    //Roi moeny
                        for (int i = 0; i < 5; i++) {
                            int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                            int toY = zone.mapTemplate.touchY(toX, boss.cy);
                            ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    //Roi gold
                    for (int i = 0; i < 10; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Ngoc rong 7 sao
                    if (Util.gI().nextInt(100) < 5) {
                        for (int i = 0; i < 1; i++) {
                            int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                            int toY = zone.mapTemplate.touchY(toX, boss.cy);
                            ItemMap itemMap = zone.addItemMap(-1, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    //Ngoc rong 5 sao
                    if (Util.gI().nextInt(100) < 1) {
                        for (int i = 0; i < 1; i++) {
                            int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                            int toY = zone.mapTemplate.touchY(toX, boss.cy);
                            ItemMap itemMap = zone.addItemMap(-1, new Item(18, false, 1, ItemOption.getOption(18, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    //Trang bi co sao
                    if (Util.gI().nextInt(100) <= 30) {
                        for (int i = 0; i < 1; i++) {
                            short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                            int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                            int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                            int toY = zone.mapTemplate.touchY(toX, boss.cy);
                            Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                            ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                    //Manh the
                    if (Util.gI().nextInt(100) < 50) {
                        for (int i = 0; i < 1; i++) {
                            int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                            int toY = zone.mapTemplate.touchY(toX, boss.cy);
                            ItemMap itemMap = zone.addItemMap(-1, new Item(841, false, 1, ItemOption.getOption(841, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                            itemMaps.add(itemMap);
                        }
                    }
                }
                break;
            }
            //Robot ve si
            case 43:
            {
                //Roi moeny
                if (Util.gI().nextInt(100) <= 20) {
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 7 sao
                if (Util.gI().nextInt(100) < 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) < 5) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }   
                break;
            }
            //Trung Uy Thep
            case 44:
            {
                //Roi moeny
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 7 sao
                if (Util.gI().nextInt(100) < 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) < 1) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 10) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Trung Uy Xanh Lo
            case 45:
            {
                //Roi moeny
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 5, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 7 sao
                if (Util.gI().nextInt(100) < 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) < 1) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ban do kho bau
                if (Util.gI().nextInt(100) <= 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(611, false, 1, ItemOption.getOption(611, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Manh the
                if (Util.gI().nextInt(100) < 20) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(842, false, 1, ItemOption.getOption(842, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }      
                break;
            }
            //Trung Uy Trang
            case 46:
            {
                //Roi moeny
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 7 sao
                if (Util.gI().nextInt(100) < 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(20, false, 1, ItemOption.getOption(20, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) < 1) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Manh the
                if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(-1, new Item(840, false, 1, ItemOption.getOption(840, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }        
                break;
            }
            //Bujin Tieu Doi Bojack
            case 47:
            {                 
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Kogu Tieu Doi Bojack
            case 48:
            {           
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Zangya Tieu Doi Bojack
            case 49:
            {             
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Bido Tieu Doi Bojack
            case 50:
            {     
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Bojack Tieu Doi Bojack
            case 51:
            {      
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT BOJECK
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(427, false, 1, ItemOption.getOption(427, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS_2, player.cName));
                }
                break;
            }
            //Super Bojack Tieu Doi Bojack
            case 52:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 1, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT SUPER BOJECK
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(428, false, 1, ItemOption.getOption(428, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS_3, player.cName));
                }
                break;
            }
            //Poc
            case 71:
            {   // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_35 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_35.options.add(new ItemOption(86, 0));
                        }
                        it_35.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it_35, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Pic
            case 72:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_36 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_36.options.add(new ItemOption(86, 0));
                        }
                        it_36.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it_36, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //KigKong
            case 73:
            {  
                 // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_37 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_37.options.add(new ItemOption(86, 0));
                        }
                        it_37.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it_37, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 4 sao
                if (Util.gI().nextInt(100) <= 6) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Xen bo hung
            case 74:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 1, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 10) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_38 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_38.options.add(new ItemOption(86, 0));
                        }
                        it_38.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it_38, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Xen bo hung
            case 75:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 5) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_39 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_39.options.add(new ItemOption(86, 0));
                        }
                        it_39.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it_39, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Xen hoan thien
            case 76:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 6) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 2) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Drabula 12h
            case 77:
            {   
                //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Bui Bui 12h
            case 78:
            {   
                 //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Yancon 12h
            case 79:
            {   
                //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Mabu 12h
            case 80:
            {     
                //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                } 
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 100) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_40 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it_40.options.add(new ItemOption(86, 0));
                        }
                        it_40.options.add(new ItemOption(107, Util.gI().nextInt(1, 6)));
                        ItemMap itemMap = zone.addItemMap(-1, it_40, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                
                //Cho ve nha
                if (zone.isEggHatch) {
                    zone.setTimeHatch(60);
                    Player boss2 = Player.addBoss(82, 5, -1, -1, true, boss.cx, boss.cy, zone, -1, -1);
                }
                boss.timeClear = 1;
                zone.setPlayerToHome(30);
                break;
            }
            //Drabula 2 12h
            case 81:
            {    
                //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Drabula 3 12h
            case 82:
            {   
                //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Bui Bui 2 12h
            case 83:
            {   
                //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Mabu map
            case 86:
            {    
                //Bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi hong ngoc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Super bu
            case 87:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(500) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_40 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_40.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it_40, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Bu Tenk
            case 88:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(300) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_41 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_41.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it_41, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Bu Han
            case 89:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(200) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_42 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_42.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it_42, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                
                break;
            }
            //Kid Bu
            case 90:
            {   
                // bi kip tuyet ki
                 for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 5, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it_43 = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it_43.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it_43, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }

                break;
            }
            //Super Bu 2h
            case 91:
            {              
                boss.timeClear = 1;
                break;
            }
            //Trung uy Xanh Lo
            case 92: {
                if (zone.map.khobau.level >= 1 && zone.map.khobau.level <= 49) {
                    // hong ngoc
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 2), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // haitac
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (zone.map.khobau.level >= 50 && zone.map.khobau.level <= 100) {
                    // hong ngoc
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 4), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // trang bi sao
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // haitac
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (zone.map.khobau.level >= 101 && zone.map.khobau.level <= 110) {
                    // hong ngoc
                    for (int i = 0; i < 10; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 3, ItemOption.getOption(590, 0, 6), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // trang bi sao
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // lech teamobi
                    // haitac
                    for (int i = 0; i < 5; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    // hong ngoc
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                
                Rank.RANKS.get(5).addTop(zone.map.khobau.clan.name, zone.map.khobau.clan.getMemberByName(zone.map.khobau.clan.leaderName).head, zone.map.khobau.clan.getMemberByName(zone.map.khobau.clan.leaderName).headICON, zone.map.khobau.clan.getMemberByName(zone.map.khobau.clan.leaderName).body, zone.map.khobau.clan.getMemberByName(zone.map.khobau.clan.leaderName).leg, zone.map.khobau.clan.getMemberByName(zone.map.khobau.clan.leaderName).ID, zone.map.khobau.level, (int) (System.currentTimeMillis() - zone.map.khobau.lastOpen));
                boss.timeClear = 1;
                zone.map.khobau.miliTime = 60000;
                break;
            }
            //Tho dai ca
            case 96:
            {
                int num_535 = Util.gI().nextInt(1, 8);
                //Cu ca rot
                for (int i = 0; i < num_535; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it_935 = new Item(462, false, 1, ItemOption.getOption(462, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    it_935.options.add(new ItemOption(93, 30));
                    ItemMap itemMap_359 = zone.addItemMap(-1, it_935, toX, toY, 0, -1);
                    itemMaps.add(itemMap_359);
                }
                break;
            }            
            //Khi dot
            case 97:
            {
                int num_536 = Util.gI().nextInt(1, 8);
                //Duoi khi
                for (int i = 0; i < num_536; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it_936 = new Item(1045, false, 1, ItemOption.getOption(1045, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    it_936.options.add(new ItemOption(93, 30));
                    ItemMap itemMap_360 = zone.addItemMap(-1, it_936, toX, toY, 0, -1);
                    itemMaps.add(itemMap_360);
                }
                break;                
            }
            //So 4 Tieu Doi Sat Thu
            case 110:
            {       
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT So 4
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(429, false, 1, ItemOption.getOption(429, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                 //Ngoc rong 6 sao
                if (Util.gI().nextInt(100) <= 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(19, false, 1, ItemOption.getOption(19, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
             //So 3 Tieu Doi Sat Thu
            case 111:
            {     
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT So 3
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(430, false, 1, ItemOption.getOption(430, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 6 sao
                if (Util.gI().nextInt(100) <= 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(19, false, 1, ItemOption.getOption(19, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
             //So 2 Tieu Doi Sat Thu
            case 112:
            {     
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT So 2
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(431, false, 1, ItemOption.getOption(431, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 6 sao
                if (Util.gI().nextInt(100) <= 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(19, false, 1, ItemOption.getOption(19, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //So 1 Tieu Doi Sat Thu
            case 113:
            {       
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT So 1
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(432, false, 1, ItemOption.getOption(432, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 6 sao
                if (Util.gI().nextInt(100) <= 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(19, false, 1, ItemOption.getOption(19, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //TDT
            case 114:
            {    
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //CT TDT
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(433, false, 1, ItemOption.getOption(433, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 6 sao
                if (Util.gI().nextInt(100) <= 100) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(19, false, 1, ItemOption.getOption(19, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            // bi ma
            case 117:
            {
                //ngoc rong
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{807, 808, 809, 810, 811, 812, 813};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                // bi kip
                if (Util.gI().nextInt(100) <= 15) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(202, false, 1, ItemOption.getOption(202, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Roi gold
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, 30000, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //nlsk
                for (int i = 0; i < 5; i++) {
                    short[] arrItem = new short[]{199,200,201};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 10, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                }
                //Roi moeny
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }                             
                break;
            }
            //Nhan ban
            case 129:
            {
                //Win clone
                boss.isClear = true;
                if (player != null) {
                    player.myObj().isWinClone = true;
                }
                //Roi moeny
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(638, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;     
            }
            case 133:
            {
                boss.timeClear = 1;
                
                //hoa
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(723, false, 1, ItemOption.getOption(723, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //hong ngoc
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            case 136:
            {
                boss.timeClear = 1;
                //cai trang thuy tinh
                if (Util.gI().nextInt(100) <= 30) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(422, false, 1, ItemOption.getOption(422, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //hat dua
                if (Util.gI().nextInt(100) <= 20) {
                    for (int i = 0; i < 2; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(2009, false, 1, ItemOption.getOption(2009, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //mam bac
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(2004, false, 1, ItemOption.getOption(2004, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                
                //hong ngoc
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
                
            }
            case 137:
            {
                boss.timeClear = 1;
                //cai trang son tinh
                if (Util.gI().nextInt(100) <= 30) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(421, false, 1, ItemOption.getOption(422, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //hat dua
                if (Util.gI().nextInt(100) <= 20) {
                    for (int i = 0; i < 2; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(2009, false, 1, ItemOption.getOption(2009, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //mam bac
                if (Util.gI().nextInt(100) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(2004, false, 1, ItemOption.getOption(2004, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                
                //hong ngoc
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //An trom
            case 138:
            {
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1296, 1);
                }
                break;
            }
            case 147:
            {
                String text[] = mResources.CHAT_WHISDIE.split("`");
                boss.addChat(1, text[Util.gI().nextInt(text.length)]);
                boss.timeClear = 2000;
                break;
            }
            case 148:
            {
                boss.addChat(1, mResources.HE_HE_HE);
                Char fboss = boss.zoneMap.findBossInMapById(149);
                if (fboss != null) {
                    fboss.timeChangePk5 = 3000;
                }
                boss.timeClear = 3000;
                break;
            }
            case 149:
            {
                boss.addChat(1, mResources.HE_HE_HE);
                Char fboss = boss.zoneMap.findBossInMapById(150);
                if (fboss != null) {
                    fboss.timeChangePk5 = 3000;
                }
                boss.timeClear = 3000;
                break;
            }
            case 150:
            {
                boss.addChat(1, mResources.HE_HE_HE);
                Char fboss = boss.zoneMap.findBossInMapById(151);
                if (fboss != null) {
                    fboss.timeChangePk5 = 3000;
                }
                boss.timeClear = 3000;
                break;
            }
            case 151:
            {
                boss.addChat(1, mResources.HE_HE_HE);
                Char fboss = boss.zoneMap.findBossInMapById(152);
                if (fboss != null) {
                    fboss.timeChangePk5 = 3000;
                }
                boss.timeClear = 3000;
                break;
            }
            case 152:
            {
                boss.addChat(1, mResources.HE_HE_HE);
                Char fboss = boss.zoneMap.findBossInMapById(153);
                if (fboss != null) {
                    fboss.timeChangePk5 = 3000;
                }
                boss.timeClear = 3000;
                break;
            }
            case 153:
            {
                boss.addChat(1, mResources.HE_HE_HE);
                Char fboss = boss.zoneMap.findBossInMapById(154);
                if (fboss != null) {
                    fboss.addChat(3000, mResources.HA_HA_HA);
                    fboss.timeChangePk5 = 5000;
                }
                boss.timeClear = 3000;
                break;
            }
            case 154: {
                boss.addChat(1, mResources.NADIC_DIE_CHAT);
                Char fboss = boss.zoneMap.findBossInMapById(155);
                if (fboss != null) {
                    fboss.addChat(3000, mResources.CADIC_CHAT);
                    fboss.timeChangePk5 = 5000;
                }
                if (zone.map.phoban.level >= 1 && zone.map.phoban.level <= 49) {
                    // hong ngoc
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 2), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // haitac
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (zone.map.phoban.level >= 50 && zone.map.phoban.level <= 100) {
                    // hong ngoc
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 4), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // trang bi sao
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // haitac
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (zone.map.phoban.level >= 101 && zone.map.phoban.level <= 110) {
                    // hong ngoc
                    for (int i = 0; i < 10; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 3, ItemOption.getOption(590, 0, 6), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // trang bi sao
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // lech teamobi
                    // haitac
                    for (int i = 0; i < 5; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    // hong ngoc
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                boss.timeClear = 3000;
                break;
            }
            case 155: {
                boss.addChat(3000, mResources.CADIC_CHAT2);
                boss.timeClear = 3000;
                if (zone.map.phoban != null) {
                    Rank.RANKS.get(7).addTop(zone.map.phoban.clan.name, zone.map.phoban.clan.getMemberByName(zone.map.phoban.clan.leaderName).head, zone.map.phoban.clan.getMemberByName(zone.map.phoban.clan.leaderName).headICON, zone.map.phoban.clan.getMemberByName(zone.map.phoban.clan.leaderName).body, zone.map.phoban.clan.getMemberByName(zone.map.phoban.clan.leaderName).leg, zone.map.phoban.clan.getMemberByName(zone.map.phoban.clan.leaderName).ID, zone.map.phoban.level, (int) (System.currentTimeMillis() - zone.map.phoban.lastOpen));
                    zone.map.phoban.miliTime = 60000;
                    zone.addInfo(String.format(mResources.WAR_XAYDA, zone.map.phoban.miliTime / 1000));
                }
                if (zone.map.phoban.level >= 1 && zone.map.phoban.level <= 49) {
                    // hong ngoc
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 2), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // haitac
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (zone.map.phoban.level >= 50 && zone.map.phoban.level <= 100) {
                    // hong ngoc
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 1, ItemOption.getOption(590, 0, 4), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // trang bi sao
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // haitac
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (zone.map.phoban.level >= 101 && zone.map.phoban.level <= 110) {
                    // hong ngoc
                    for (int i = 0; i < 10; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // bi kip
                    for (int i = 0; i < 5; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        ItemMap itemMap = zone.addItemMap(charId, new Item(590, false, 3, ItemOption.getOption(590, 0, 6), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // trang bi sao
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    // lech teamobi
                    // haitac
                    for (int i = 0; i < 5; i++) {
                        short[] arrItem = new short[]{2001};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(93, 3));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    // hong ngoc
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(861, false, 1, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            case 158:
            {
                boss.isBaoVe = true;
                boss.liveFromDead(2);
                boss.gong(1000);
                boss.timeClear = 1000;
                Player cumber = Player.addBoss(159, 5, -1, -1, true, boss.cx, boss.cy, null, -1, -1);
                cumber.joinZone(boss.zoneMap, boss.cx, boss.cy, 0, 1000);
                cumber.gong(3000);
                cumber.isSendHPData = boss.isSendHPData;
                cumber.maxTimeEff = boss.maxTimeEff;
                //Wua tai day
                //hong ngoc
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // trang bi sao
                for (int i = 0; i < 1; i++) {
                    short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    it.options.add(new ItemOption(213, Util.gI().nextInt(10, 50)));
                     //Add % param
                        if (Util.gI().nextInt(100) < 20) {
                            it.options.add(new ItemOption(107, Util.gI().nextInt(1, 3)));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6 ||
                                    option.optionTemplate.id == 7 || option.optionTemplate.id == 14 ||
                                    option.optionTemplate.id == 22 || option.optionTemplate.id == 23 ||
                                    option.optionTemplate.id == 27 || option.optionTemplate.id == 28 ||
                                    option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                    ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            case 159:
            {
                //Wua tai day
                //hong ngoc
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(861, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // trang bi sao
                for (int i = 0; i < 1; i++) {
                    short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    it.options.add(new ItemOption(213, Util.gI().nextInt(10, 50)));
                    //Add % param
                    if (Util.gI().nextInt(100) < 50) {
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                    }
                    int percent = Util.gI().nextInt(1, 15);
                    for (int j = 0; j < it.options.size(); j++) {
                        ItemOption option = it.options.get(j);
                        if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                || option.optionTemplate.id == 47) {
                            option.param += option.param * percent / 100L;
                        }
                    }
                    it.options.add(new ItemOption(207, percent));
                    ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
               if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                if (player != null && player.session != null) {
                    player.addTaskPointDH(1291, 1);
                }
                break;
            }
            //Bo canh cung
            case 160:
            {
                //Bo canh cung
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 24, boss.cx + 24);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1248, false, 1, ItemOption.getOption(1248, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMap.isPickItemNotMe = true;
                    itemMaps.add(itemMap);
                }
                boss.timeClear = 0;
                break;
            }
            //Ngai dem
            case 161:
            {
                //Ngai dem
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 24, boss.cx + 24);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1249, false, 1, ItemOption.getOption(1249, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMap.isPickItemNotMe = true;
                    itemMaps.add(itemMap);
                }
                boss.timeClear = 0;
                break;
            }
            //Mabu com
            case 162:
            {
                boss.timeClear = 0;
            	break;
            }
            //Fide dai ca
            case 163:
            {
                boss.timeClear = 0;
                int[][] array = boss.sortCharIdDam();
                for (int i = 0; i < array.length; i++) {
                    Char player2 = zone.findCharInMap(array[i][0]);
                    if (player2 != null) {
                        player2.addClanPoint(i < 5 ? 15 : i < 10 ? 10 : 5);
                    }
                }
                if (player != null) {
                    player.addClanPoint(10);
                }
                if (zone.map.phoban != null) {
                    zone.map.phoban.miliTime = 30000;
                }
                //Qua boss tai day
                if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 30) {
                    for (int i = 0; i < 3; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(407, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(50, Util.gI().nextInt(20, 22)));
                        it.options.add(new ItemOption(77, Util.gI().nextInt(20, 25)));
                        it.options.add(new ItemOption(103, Util.gI().nextInt(20, 25)));
                        it.options.add(new ItemOption(80, Util.gI().nextInt(5, 10)));
                        it.options.add(new ItemOption(81, Util.gI().nextInt(5, 10)));
                        it.options.add(new ItemOption(101, Util.gI().nextInt(5, 10)));
                        it.options.add(new ItemOption(94, Util.gI().nextInt(5, 10)));
                        it.options.add(new ItemOption(108, Util.gI().nextInt(5, 10)));
                        it.options.add(new ItemOption(114, Util.gI().nextInt(10, 20)));
                        it.options.add(new ItemOption(14, Util.gI().nextInt(5, 10)));
                        it.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 10) {
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    for (int i = 0; i < 5; i++) {
                        short[] arrItem = new short[]{381, 382, 383, 384, 385};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                // ngoc hong
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(861, false, 5, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }    
                // soi sao pha le
                for (int i = 0; i < 5; i++) {
                    short[] arrItem = new short[]{441, 442, 443, 444, 445};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(boss.cx - 110, boss.cx + 110);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // da nang cap
                for (int i = 0; i < 5; i++) {
                    short[] arrItem = new short[]{220, 221, 223, 224};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(boss.cx - 120, boss.cx + 120);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(templateId, false, 10, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // ve quay thuong de
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(821, false, 1, ItemOption.getOption(821, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                break;
            }
            //Sieu bo hung
            case 164:
            {
                boss.timeClear = 0;
                int[][] array = boss.sortCharIdDam();
                for (int i = 0; i < array.length; i++) {
                    Char player2 = zone.findCharInMap(array[i][0]);
                    if (player2 != null) {
                        player2.addClanPoint(i < 5 ? 15 : i < 10 ? 10 : 5);
                    }
                }
                if (player != null) {
                    player.addClanPoint(10);
                }
                if (zone.map.phoban != null) {
                    zone.map.phoban.miliTime = 30000;
                }
                //Qua boss tai day
                if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 3; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(528, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(50, Util.gI().nextInt(23, 25)));
                        it.options.add(new ItemOption(77, Util.gI().nextInt(25, 30)));
                        it.options.add(new ItemOption(103, Util.gI().nextInt(25, 30)));
                        it.options.add(new ItemOption(8, Util.gI().nextInt(3, 10)));
                        it.options.add(new ItemOption(5, Util.gI().nextInt(5, 15)));
                        it.options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(20, 50)));
                        it.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 10) {
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                // da nang cap
                for (int i = 0; i < 5; i++) {
                    short[] arrItem = new short[]{220, 221, 223, 224};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(boss.cx - 61, boss.cx + 60);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(templateId, false, Util.gI().nextInt(25, 50), ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 5; i++) {
                        short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Mabu
            case 165:
            {
                boss.timeClear = 0;
                int[][] array = boss.sortCharIdDam();
                for (int i = 0; i < array.length; i++) {
                    Char player2 = zone.findCharInMap(array[i][0]);
                    if (player2 != null) {
                        player2.addClanPoint(i < 5 ? 15 : i < 10 ? 10 : 5);
                    }
                }
                if (player != null) {
                    player.addClanPoint(10);
                }
                if (zone.map.phoban != null) {
                    zone.map.phoban.miliTime = 30000;
                }
                //Qua boss tai day
                 if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 2; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 5)));
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 3; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(578, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(50, Util.gI().nextInt(23, 30)));
                        it.options.add(new ItemOption(77, Util.gI().nextInt(25, 35)));
                        it.options.add(new ItemOption(103, Util.gI().nextInt(25, 35)));
                        it.options.add(new ItemOption(5, Util.gI().nextInt(10, 15)));
                        it.options.add(new ItemOption(126, 15));      
                        it.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 30) {
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                // da nang cap
                for (int i = 0; i < 1; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 60, boss.cx + 60);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(1143, false, 1, ItemOption.getOption(1143, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 5; i++) {
                        short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                 //trang bi ao than linh va ao
                if (Util.gI().nextInt(150) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555,557,559,563,565,567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Zamasu
            case 166:
            {
                boss.timeClear = 0;
                int[][] array = boss.sortCharIdDam();
                for (int i = 0; i < array.length; i++) {
                    Char player2 = zone.findCharInMap(array[i][0]);
                    if (player2 != null) {
                        player2.addClanPoint(i < 5 ? 15 : i < 10 ? 10 : 5);
                    }
                }
                if (player != null) {
                    player.addClanPoint(10);
                }
                if (zone.map.phoban != null) {
                    zone.map.phoban.miliTime = 30000;
                }
                //Qua boss tai day
                if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 3; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(898, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(50, Util.gI().nextInt(30, 37)));
                        it.options.add(new ItemOption(77, Util.gI().nextInt(30, 42)));
                        it.options.add(new ItemOption(103, Util.gI().nextInt(30, 42)));
                        it.options.add(new ItemOption(5, Util.gI().nextInt(15, 25)));
                        it.options.add(new ItemOption(94, 20));      
                        it.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 50) {
                    for (int i = 0; i < 3; i++) {
                        short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                   for (int i = 0; i < 3; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(898, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(50, Util.gI().nextInt(30, 35)));
                        it.options.add(new ItemOption(77, Util.gI().nextInt(30, 40)));
                        it.options.add(new ItemOption(103, Util.gI().nextInt(30, 40)));
                        it.options.add(new ItemOption(5, Util.gI().nextInt(15, 20)));
                        it.options.add(new ItemOption(94, 15));      
                        it.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                // da nang cap
                for (int i = 0; i < 3; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(1143, false, 1, ItemOption.getOption(1143, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // ngoc hong
                for (int i = 0; i < 10; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(861, false, 5, ItemOption.getOption(861, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(-1, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // item 2
                for (int i = 0; i < 5; i++) {
                    short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // trang bi sao
                for (int i = 0; i < 3; i++) {
                    short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                    int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                    int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                    if (Util.gI().nextInt(100) < 10) {
                        it.options.add(new ItemOption(86, 0));
                    }
                    ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //trang bi ao than linh va ao
                if (Util.gI().nextInt(150) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555,557,559,563,565,567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 10) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi gang than linh
                if (Util.gI().nextInt(200) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86,0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi than linh (quan tl)
                if (Util.gI().nextInt(250) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi nhan than linh
                if (Util.gI().nextInt(350) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);                       
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                break;
            }
            //Berus
            case 167:
            {   
                // bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1229, false, 20, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(30, 0));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 30) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }             
                //Da linh luc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 110, boss.cx + 110);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(2006, false, 1, ItemOption.getOption(2006, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Da thang cap
                for (int i = 0; i < 2; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 120, boss.cx + 120);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(2007, false, 1, ItemOption.getOption(2007, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //sach cu
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 100, boss.cx + 100);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(1281, false, 10, ItemOption.getOption(1281, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Whis
            case 168:
            {   
                // bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 40, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc rong 3 sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(30, 0));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //Trang bi co sao
                if (Util.gI().nextInt(100) <= 50) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }           
                //Da linh luc
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(2006, false, 2, ItemOption.getOption(2006, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Da thang cap
                for (int i = 0; i < 2; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(charId, new Item(2007, false, 2, ItemOption.getOption(2007, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //sach cu
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 150, boss.cx + 150);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1281, false, 50, ItemOption.getOption(1281, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                // item 2
                if (Util.gI().nextInt(100) <= 10) {
                    for (int i = 0; i < 2; i++) {
                        short[] arrItem = new short[]{1150, 1151, 1152, 1153, 1154};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 80, boss.cx + 80);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                //trang bi ao than linh va ao
                 if (Util.gI().nextInt(150) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555, 557, 559, 563, 565, 567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        //Add % param
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6 ||
                                    option.optionTemplate.id == 7 || option.optionTemplate.id == 14 ||
                                    option.optionTemplate.id == 22 || option.optionTemplate.id == 23 ||
                                    option.optionTemplate.id == 27 || option.optionTemplate.id == 28 ||
                                    option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
 
                //trang bi gang than linh
                if (Util.gI().nextInt(200) <= 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86,0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6 ||
                                    option.optionTemplate.id == 7 || option.optionTemplate.id == 14 ||
                                    option.optionTemplate.id == 22 || option.optionTemplate.id == 23 ||
                                    option.optionTemplate.id == 27 || option.optionTemplate.id == 28 ||
                                    option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            //Chilld
            case 169: {
                // bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 75, boss.cx + 75);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 40, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc Rong 4 sao
                if (Util.gI().nextInt(100) < 30) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Trang bi
                } else if (Util.gI().nextInt(100) < 20) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 10) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555, 557, 559, 563, 565, 567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        //Add % param
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));

                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(120) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(150) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(200) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }        
                //sach cu
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 75, boss.cx + 75);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1281, false, 50, ItemOption.getOption(1281, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }          
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
            
            //Chilld
            case 170: {
                // bi kip tuyet ki
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 75, boss.cx + 75);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1229, false, 40, ItemOption.getOption(1229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }
                //Ngoc Rong 4 sao
                if (Util.gI().nextInt(100) < 20) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                    //Trang bi
                } else if (Util.gI().nextInt(100) < 15) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{241, 253, 265, 277, 233, 245, 257, 269, 237, 249, 261, 273, 281};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        it.options.add(new ItemOption(107, Util.gI().nextInt(1, 4)));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 10) {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(16, false, 1, ItemOption.getOption(16, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{555, 557, 559, 563, 565, 567};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        //Add % param
                        if (Util.gI().nextInt(100) < 80) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));

                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(100) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{562, 564, 566};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(120) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{556, 558, 560};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else if (Util.gI().nextInt(150) < 1) {
                    for (int i = 0; i < 1; i++) {
                        short[] arrItem = new short[]{561};
                        int templateId = arrItem[Util.gI().nextInt(arrItem.length)];
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(templateId, false, 1, ItemOption.getOption(templateId, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        if (Util.gI().nextInt(100) < 50) {
                            it.options.add(new ItemOption(86, 0));
                        }
                        int percent = Util.gI().nextInt(1, 15);
                        for (int j = 0; j < it.options.size(); j++) {
                            ItemOption option = it.options.get(j);
                            if (option.optionTemplate.id == 0 || option.optionTemplate.id == 6
                                    || option.optionTemplate.id == 7 || option.optionTemplate.id == 14
                                    || option.optionTemplate.id == 22 || option.optionTemplate.id == 23
                                    || option.optionTemplate.id == 27 || option.optionTemplate.id == 28
                                    || option.optionTemplate.id == 47) {
                                option.param += option.param * percent / 100L;
                            }
                        }
                        it.options.add(new ItemOption(207, percent));
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                } else {
                    for (int i = 0; i < 1; i++) {
                        int toX = Util.gI().nextInt(boss.cx - 50, boss.cx + 50);
                        int toY = zone.mapTemplate.touchY(toX, boss.cy);
                        Item it = new Item(17, false, 1, ItemOption.getOption(17, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        ItemMap itemMap = zone.addItemMap(charId, it, toX, toY, 0, -1);
                        itemMaps.add(itemMap);
                    }
                }        
                //sach cu
                for (int i = 0; i < 5; i++) {
                    int toX = Util.gI().nextInt(boss.cx - 75, boss.cx + 75);
                    int toY = zone.mapTemplate.touchY(toX, boss.cy);
                    ItemMap itemMap = zone.addItemMap(-1, new Item(1281, false, 50, ItemOption.getOption(1281, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                    itemMaps.add(itemMap);
                }          
                if (player != null) {
                    Server.gI().chatVip(String.format(mResources.ATT_DIE_BOSS, player.cName, boss.cName));
                }
                break;
            }
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //roi vang 
        if (boss.cTemplateType == 45) {
            long tongVang = boss.xuSteal;
            boss.xuSteal = 0;
            int num = 0;
            while(tongVang > 0) {
                int vang;
                if (tongVang >= 30000) {
                    vang = 30000;
                    tongVang -= 30000;
                } else {
                    vang = (int) tongVang;
                    tongVang = 0;
                }
                int toX = Util.gI().nextInt(boss.cx - 24, boss.cx + 24);
                int toY = zone.mapTemplate.touchY(toX, boss.cy);
                ItemMap itemMap = zone.addItemMap(-1, new Item(190, false, vang, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), toX, toY, 0, -1);
                itemMaps.add(itemMap);
                num++;
                if (num >= 30) break;
            }
        }
        if (boss.cTemplateType == 7) {
            //Roi all do trong pet
            Player o2 = (Player) boss;
            while(o2.itemBuys.size() > 0) {
                Item it94 = o2.itemBuys.remove(0);
                int toX = Util.gI().nextInt(boss.cx - 70, boss.cx + 70);
                int toY = zone.mapTemplate.touchY(toX, boss.cy);
                ItemMap itemMap = zone.addItemMap(charId, it94, toX, toY, 0, -1);
                itemMaps.add(itemMap);
            }
        }
    }
}
