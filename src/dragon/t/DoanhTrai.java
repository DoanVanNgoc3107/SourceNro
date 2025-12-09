package dragon.t;

import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class DoanhTrai {

    public long lastOpen;
    public int miliTime;
    public int miliTime2;
    public Clan clan;

    public final int[] mapIds = new int[] { 53, 58, 59, 60, 61, 62, 55, 56, 54, 57 };
    public final int[] maxMobDieNextMap = new int[] { 7, 12, 14, 8, 15, 25, 5, 5, 1, 9 };
    public ArrayList<Map> maps = new ArrayList<>();
    public boolean isWin;
    public boolean isGift;

    public void initDoanhTrai(Clan clan) {
        this.clan = clan;
        this.lastOpen = System.currentTimeMillis();
        this.miliTime = 1000 * 60 * 30;
        clan.doanhTrai = this;
        int i;
        int k;
        for (i = 0; i < mapIds.length; ++i) {
            Map map = new Map(mapIds[i], 1, 25, 0);
            map.doanhTrai = this;
            for (k = 0; k < map.zones.size(); k++) {
                map.zones.get(k).initMob();
            }
            map.isOpen = i == 0;
            maps.add(map);
            Map.add(map);
        }
        this.isWin = false;
        this.isGift = false;
        loadHPMob(0);
    }

    public void loadHPMob(int indexMap) {
        int i;
        int SD = this.clan.getMaxSDMember();
        synchronized (this.maps.get(indexMap).zones.get(0).mobs) {
            for (i = 0; i < this.maps.get(indexMap).zones.get(0).mobs.size(); i++) {
                Mob mob = this.maps.get(indexMap).zones.get(0).mobs.get(i);
                long maxHP = (long) SD * 10L;
                if (maxHP > 2000000000L) {
                    maxHP = 2000000000L;
                }
                if (maxHP > 0L) {
                    mob.hp = mob.maxHp = (int) maxHP;
                }
            }
        }
        int HP = this.clan.getMaxHPMember();
        synchronized (this.maps.get(indexMap).zones.get(0).mobs) {
            for (i = 0; i < this.maps.get(indexMap).zones.get(0).mobs.size(); i++) {
                Mob mob = this.maps.get(indexMap).zones.get(0).mobs.get(i);
                long maxDam = (long) HP * 5L / 100L;
                if (maxDam > 2000000000L) {
                    maxDam = 2000000000L;
                }
                mob.damFull = (int) maxDam;
            }
        }
    }

    public int getIndexMaps(int mapId) {
        int i;
        for (i = 0; i < mapIds.length; i++) {
            if (mapIds[i] == mapId) {
                return i;
            }
        }
        return -1;
    }

    public void addChatPet(String text) {
        ArrayList<Char> chars = new ArrayList<>();
        int i;
        int j;
        for (i = 0; i < this.maps.size(); i++) {
            synchronized (this.maps.get(i).zones.get(0).players) {
                for (j = 0; j < this.maps.get(i).zones.get(0).players.size(); j++) {
                    if (this.maps.get(i).zones.get(0).players.get(j).session != null) {
                        chars.add(this.maps.get(i).zones.get(0).players.get(j));
                    }
                }
            }
        }
        if (!chars.isEmpty()) {
            for (i = 0; i < chars.size(); i++) {
                chars.get(i).session.service.chatTHEGIOI(mResources.EMPTY, text, null, 0);
            }
        }
    }

    public void updateWin(int indexMap) {
        if (indexMap + 1 < mapIds.length) {
            loadHPMob(indexMap + 1);
            this.maps.get(indexMap + 1).isOpen = true;
            int SD = this.clan.getMaxSDMember();
            if (this.maps.get(indexMap + 1).templateId == 59) {
                long maxHP = (long) SD * 60L;
                if (maxHP > 2000000000L) {
                    maxHP = 2000000000L;
                }
                Char b = Player.addBoss(46, 5, (int) maxHP, -1, true, 896, 384,
                        this.maps.get(indexMap + 1).zones.get(0), -1, -1);
                b.isBossMain = true;
            }
            if (this.maps.get(indexMap + 1).templateId == 62) {
                long maxHP = (long) SD * 70L;
                if (maxHP > 2000000000L) {
                    maxHP = 2000000000L;
                }
                Char b = Player.addBoss(45, 5, (int) maxHP, -1, true, 321, 384,
                        this.maps.get(indexMap + 1).zones.get(0), -1, -1);
                b.isBossMain = true;
            }
            if (this.maps.get(indexMap + 1).templateId == 55) {
                long maxHP = (long) SD * 80L;
                if (maxHP > 2000000000L) {
                    maxHP = 2000000000L;
                }
                Char b = Player.addBoss(44, 0, (int) maxHP, -1, true, 414, 288,
                        this.maps.get(indexMap + 1).zones.get(0), 10000, -1);
                b.isBossMain = true;
            }
            if (this.maps.get(indexMap + 1).templateId == 54) {
                long maxHP = (long) SD * 90L;
                if (maxHP > 2000000000L) {
                    maxHP = 2000000000L;
                }
                Char b = Player.addBoss(42, 0, (int) maxHP, -1, true, 400, 312,
                        this.maps.get(indexMap + 1).zones.get(0), 10000, -1);
                b.isBossMain = true;
            }
            if (this.maps.get(indexMap + 1).templateId == 57) {
                long maxHP = (long) SD * 100L;
                if (maxHP > 2000000000L) {
                    maxHP = 2000000000L;
                }
                for (int i = 0; i < 4; i++) {
                    Char b = Player.addBoss(43, 0, (int) maxHP, -1, true, 400, 312, null, 10000, -1);
                    b.cName = String.format(mResources.ADD_0NUMBER, b.cName, i);
                    this.maps.get(indexMap + 1).zones.get(0).join(b, 0, -1, -1);
                }
            }
        } else {
            this.addChatPet(mResources.FIND_DOC_NHAN);
            this.isWin = true;
        }
    }

    public void updateWin() {
        int i;
        // Nogc rong 4 sao
        for (i = 0; i < 1; i++) {
            ZoneMap zone = this.maps.get(Util.gI().nextInt(this.maps.size())).zones.get(0);
            int x = Util.gI().nextInt(50, zone.mapTemplate.pxw - 50);
            Item item = new Item(17, false, 1, ItemOption.getOption(17, 0, 0), mResources.EMPTY, mResources.EMPTY,
                    mResources.EMPTY);
            ItemMap itemMap = zone.addItemMap(-1, item, x, zone.mapTemplate.touchY(x, 200), 0, -1);
            itemMap.milisecondRemove = System.currentTimeMillis() + (1000 * 60 * 5);
            zone.itemMapAdd(itemMap);
        }
        // Nogc rong 7 sao
        for (i = 0; i < 7; i++) {
            ZoneMap zone = this.maps.get(Util.gI().nextInt(this.maps.size())).zones.get(0);
            int x = Util.gI().nextInt(50, zone.mapTemplate.pxw - 50);
            Item item = new Item(20, false, 1, ItemOption.getOption(20, 0, 0), mResources.EMPTY, mResources.EMPTY,
                    mResources.EMPTY);
            ItemMap itemMap = zone.addItemMap(-1, item, x, zone.mapTemplate.touchY(x, 200), 0, -1);
            itemMap.milisecondRemove = System.currentTimeMillis() + (1000 * 60 * 5);
            zone.itemMapAdd(itemMap);
        }
        // The doc nhan
        if (Util.gI().nextInt(100) < 20) {
            for (i = 0; i < 1; i++) {
                ZoneMap zone = this.maps.get(Util.gI().nextInt(this.maps.size())).zones.get(0);
                int x = Util.gI().nextInt(50, zone.mapTemplate.pxw - 50);
                Item item = new Item(859, false, 1, ItemOption.getOption(859, 0, 0), mResources.EMPTY, mResources.EMPTY,
                        mResources.EMPTY);
                ItemMap itemMap = zone.addItemMap(-1, item, x, zone.mapTemplate.touchY(x, 200), 0, -1);
                itemMap.milisecondRemove = System.currentTimeMillis() + (1000 * 60 * 5);
                zone.itemMapAdd(itemMap);
            }
        }
        // Thong bao chien thang
        this.addChatPet(mResources.FIND_DOC_NHAN);
    }

    public void close() {
        int i;
        int j;
        this.clan.doanhTrai = null;

        Map map;
        for (i = 0; i < maps.size(); i++) {
            map = maps.get(i);
            for (j = 0; j < map.zones.size(); j++) {
                map.zones.get(j).pushPlayers(1);
            }
        }
        for (i = maps.size() - 1; i >= 0; --i) {
            maps.get(i).close();
        }
    }
}
