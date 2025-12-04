package dragon.t;

/**
 *
 * @author TGDD
 */
public class RoadSnake extends Instancing {
    
    
    public void init(Clan clan, int level) {
        super.clan = clan;
        super.level = level;
        super.lastOpen = System.currentTimeMillis();
        super.miliTime = 1800000;
        clan.roadSnake = this;
        short arrMapId[] = new short[]{143, 142, 141, 144};
        for (int i = 0; i < arrMapId.length; ++i) {
            Map map = new Map(arrMapId[i], 1, 25, 0);
            map.phoban = this;
            for (int k = 0; k < map.zones.size(); k++) {
                for (int l = 0; l < map.zones.get(k).mobs.size(); l++) {
                    map.zones.get(k).mobs.get(l).removeWhenDie = true;
                    int setHP;
                    int levelBoss = l == 3 ? 3 : 0;
                    int set = this.level / 10;
                    if (set < 1) {
                        set = 1;
                    }
                    setHP = 40000 * (i + 1) * this.level * set;
                    map.zones.get(k).mobs.get(l).live(Util.gI().nextInt(3), levelBoss, setHP);
                }
            }
            map.isOpen = i == 0;
            super.maps.add(map);
            Map.add(map);
        }
        //Create boss and skill
        Player so1 = Player.addBoss(148, 5, -1, -1, true, 600, 342, null, -1, -1);
        so1.cHP = so1.cHPFull = so1.cHPGoc = so1.cHPGoc * level;
        so1.cDamFull = so1.cDamGoc = so1.cDamGoc * level;
        so1.boomWhenDie = true;
        Player so2 = Player.addBoss(149, 0, -1, -1, true, 615, 342, null, -1, -1);
        so2.cHP = so2.cHPFull = so2.cHPGoc = so2.cHPGoc * level;
        so2.cDamFull = so2.cDamGoc = so2.cDamGoc * level;
        so2.boomWhenDie = true;
        Player so3 = Player.addBoss(150, 0, -1, -1, true, 630, 342, null, -1, -1);
        so3.cHP = so3.cHPFull = so3.cHPGoc = so3.cHPGoc * level;
        so3.cDamFull = so3.cDamGoc = so3.cDamGoc * level;
        so3.boomWhenDie = true;
        Player so4 = Player.addBoss(151, 0, -1, -1, true, 645, 342, null, -1, -1);
        so4.cHP = so4.cHPFull = so4.cHPGoc = so4.cHPGoc * level;
        so4.cDamFull = so4.cDamGoc = so4.cDamGoc * level;
        so4.boomWhenDie = true;
        Player so5 = Player.addBoss(152, 0, -1, -1, true, 660, 342, null, -1, -1);
        so5.cHP = so5.cHPFull = so5.cHPGoc = so5.cHPGoc * level;
        so5.cDamFull = so5.cDamGoc = so5.cDamGoc * level;
        so5.boomWhenDie = true;
        Player so6 = Player.addBoss(153, 0, -1, -1, true, 675, 342, null, -1, -1);
        so6.cHP = so6.cHPFull = so6.cHPGoc = so6.cHPGoc * level;
        so6.cDamFull = so6.cDamGoc = so6.cDamGoc * level;
        so6.boomWhenDie = true;
        Player nadic = Player.addBoss(154, 0, -1, -1, true, 645, 312, null, -1, -1);
        nadic.cHP = nadic.cHPFull = nadic.cHPGoc = nadic.cHPGoc * level;
        nadic.cDamFull = nadic.cDamGoc = nadic.cDamGoc * level;
        Player cadic = Player.addBoss(155, 0, -1, -1, true, 660, 312, null, -1, -1);
        cadic.cHP = cadic.cHPFull = cadic.cHPGoc = cadic.cHPGoc * level;
        cadic.cDamFull = cadic.cDamGoc = cadic.cDamGoc * level;
        cadic.isSkillXayda1 = true;
        cadic.isSkillXayda2 = true;
        cadic.isSkillXayda3 = true;
        //Dua vao map
        this.maps.get(3).zones.get(0).join(so1, 0, -1, -1);
        this.maps.get(3).zones.get(0).join(so2, 0, -1, -1);
        this.maps.get(3).zones.get(0).join(so3, 0, -1, -1);
        this.maps.get(3).zones.get(0).join(so4, 0, -1, -1);
        this.maps.get(3).zones.get(0).join(so5, 0, -1, -1);
        this.maps.get(3).zones.get(0).join(so6, 0, -1, -1);
        this.maps.get(3).zones.get(0).join(nadic, 0, -1, -1);
        this.maps.get(3).zones.get(0).join(cadic, 0, -1, -1);
    }
    
//    public int getIndexMaps(int mapId) {
//        for (int i = 0; i < this.mapIds.length; i++) {
//            if (this.mapIds[i] == mapId) {
//                return i;
//            }
//        }
//        return -1;
//    }
    
    @Override
    public void close() {
        super.clan.roadSnake = null;
        super.close();
    }
    
    @Override
    public void update() {
        super.update();
        //Mo map 2
        kiemtra: {
            int index = 1;
            if (!this.maps.get(index).isOpen) {
                synchronized(this.maps.get(index - 1).zones.get(0).mobs) {
                    for (int i = 0; i < this.maps.get(index - 1).zones.get(0).mobs.size(); i++) {
                        if (!this.maps.get(index - 1).zones.get(0).mobs.get(i).isMobMe && !this.maps.get(index - 1).zones.get(0).mobs.get(i).isDie) {
                            break kiemtra;
                        }
                    }
                }
                this.maps.get(index).isOpen = true;
            }
        }
        //Mo map 3
        kiemtra: {
            int index = 2;
            if (!this.maps.get(index).isOpen) {
                synchronized(this.maps.get(index - 1).zones.get(0).mobs) {
                    for (int i = 0; i < this.maps.get(index - 1).zones.get(0).mobs.size(); i++) {
                        if (!this.maps.get(index - 1).zones.get(0).mobs.get(i).isMobMe && !this.maps.get(index - 1).zones.get(0).mobs.get(i).isDie) {
                            break kiemtra;
                        }
                    }
                }
                this.maps.get(index).isOpen = true;
            }
        }
        //Mo map 4
        kiemtra: {
            int index = 3;
            if (!this.maps.get(index).isOpen) {
                synchronized(this.maps.get(index - 1).zones.get(0).mobs) {
                    for (int i = 0; i < this.maps.get(index - 1).zones.get(0).mobs.size(); i++) {
                        if (!this.maps.get(index - 1).zones.get(0).mobs.get(i).isMobMe && !this.maps.get(index - 1).zones.get(0).mobs.get(i).isDie) {
                            break kiemtra;
                        }
                    }
                }
                this.maps.get(index).isOpen = true;
            }
        }
    }
    
}
