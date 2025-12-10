package dragon.t;

import dragon.server.mResources;

/**
 *
 * @author Admin
 */
public class DoelBossClan extends Instancing {
    
    public void init(Clan clan, int level) {
        super.clan = clan;
        super.level = level;
        super.lastOpen = System.currentTimeMillis();
        super.miliTime = 1800000;
        clan.doelBossClan = this;
        short[] arrMapId = new short[]{165};
        for (short value : arrMapId) {
            Map map = new Map(value, 1, 20, 0);
            map.phoban = this;
            map.isOpen = true;
            super.maps.add(map);
            Map.add(map);
        }
        //Create boss and skill
        if (level == 0) {
            Player fideDaiCa = Player.addBoss(163, 0, -1, -1, true, 120, 552, null, 2000, -1);
            //Dua vao map
            super.maps.getFirst().zones.getFirst().join(fideDaiCa, 0, -1, -1);
        }
        if (level == 1) {
            Player sieuBoHung = Player.addBoss(164, 0, -1, -1, true, 120, 552, null, 2000, -1);
            //Dua vao map
            super.maps.getFirst().zones.getFirst().join(sieuBoHung, 0, -1, -1);
        }
        if (level == 2) {
            Player mabu = Player.addBoss(165, 0, -1, -1, true, 120, 552, null, 2000, -1);
            //Dua vao map
            super.maps.getFirst().zones.getFirst().join(mabu, 0, -1, -1);
        }
        if (level == 3) {
            Player zamasu = Player.addBoss(166, 0, -1, -1, true, 120, 552, null, 2000, -1);
            //Dua vao map
            super.maps.getFirst().zones.getFirst().join(zamasu, 0, -1, -1);
        }
    }
    
    @Override
    public void close() {
        super.clan.doelBossClanLevel++;
        super.clan.doelBossClan = null;
        super.close();
    }
    
    @Override
    public void update() {
        super.update();
    }
    
}
