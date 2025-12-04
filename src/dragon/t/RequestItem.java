package dragon.t;

import dragon.server.mResources;


/**
 *
 * @author TGDD
 */
public class RequestItem {
    
    public String tile =  null, strOK = null;
    public int templateId[] = null, quantity[] = null;
    public int typeBoeardOK = 0;
    public int typeBoeard = 0;
    public int xu = -1, luong = -1, npcId = -1, quntityEmptyBag = 0;
    public boolean isSet = false;

    public RequestItem(String tile, int array1[], int array2[], int typeBoeardOK, String strOK, int typeBoeard) {
        this.tile = tile;
        this.templateId = array1;
        this.quantity = array2;
        this.typeBoeardOK = typeBoeardOK;
        this.typeBoeard = typeBoeard;
    }
    
    public RequestItem(Char player, String tile, int[] templateId, int[] quantity, int typeBoeardOK, String strOK, int typeBoeard, String strErr, int coin, int ngoc, int quntityEmptyBag, boolean setCombine) {
        player.requestItem = null;
        if (quntityEmptyBag != -1 && quntityEmptyBag > player.getEmptyBagCount()) {
            player.addInfo1(String.format(mResources.BAG_FULL_2, quntityEmptyBag));
        } else {
            this.tile = tile;
            this.templateId = templateId;
            this.quantity = quantity;
            this.typeBoeardOK = typeBoeardOK;
            this.typeBoeard = typeBoeard;
            this.npcId = player.menuBoard.npcId;
            this.xu = coin;
            this.luong = ngoc;
            this.quntityEmptyBag = quntityEmptyBag;
            player.resetMenu();
            player.menuBoard.chat = "|1|"+tile;
            for (int i2 = 0; i2 < templateId.length; i2++) {
                player.menuBoard.chat += "\n|"+(player.getItemBagQuantityById(templateId[i2]) >= quantity[i2] ? 2 : 7)+"|"+ItemTemplate.get((short)templateId[i2]).name+" "+player.getItemBagQuantityById(templateId[i2])+"/"+quantity[i2];
            }
            if (coin != -1) {
                player.menuBoard.chat += "\n|"+(player.xu >= coin ? 2 : 7)+"| Giá vàng: "+Util.gI().getFormatNumber(coin);
            }
            if (ngoc != -1) {
                player.menuBoard.chat += "\n|"+(player.getLuong() >= ngoc ? 2 : 7)+"| Giá ngọc: "+Util.gI().getFormatNumber(ngoc);
            }
            kiemtraCoOK:
            {
                if ((coin != -1 && player.xu < coin) || (ngoc != -1 && player.getLuong() < ngoc)) {
                    break kiemtraCoOK;
                }
                for (int i1 = 0; i1 < templateId.length; i1++) {
                    if (player.getItemBagQuantityById(templateId[i1]) < quantity[i1]) {
                        break kiemtraCoOK;
                    }
                }
                player.menuBoard.arrMenu.add(new MenuInfo(strOK, 173));
                if (setCombine) {
                    int array[] = new int[templateId.length];
                    for (int i = 0; i < templateId.length; i++) {
                        array[i] = player.getItemBagById(templateId[i]).indexUI;
                    }
                    player.session.service.setCombineEff(array, this.npcId);
                }
            }
            player.menuBoard.arrMenu.add(new MenuInfo(strErr, typeBoeard));
            player.menuBoard.openUIConfirm(npcId, null, null, -1);
            this.isSet = true;
        }
    }
    
    public boolean execute() {
        return false;
    }
}
