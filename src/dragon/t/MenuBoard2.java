package dragon.t;

import dragon.server.Session_ME;
import dragon.server.mResources;
import java.util.ArrayList;

public class MenuBoard2 {
    
    private final Session_ME session;
    
    public ArrayList<MenuInfo2> arrMenu;
    public int select;
    public int charID;
    
    public MenuBoard2(Session_ME session) {
        this.session = session;
        this.arrMenu = new ArrayList<>();
    }
    
    public void getMenu(int charId) {
        Char player = this.session.myCharz().zoneMap.findCharInMap(charId);
        if (player != null) {
            this.charID = charId;
            this.arrMenu.clear();
//            if (this.session.myCharz().isCan() && this.session.myCharz().cPower >= 150000000 && player.isCan() && player.cPower >= 150000000) {
                this.arrMenu.add(new MenuInfo2(mResources.OAN_TU_TI1, mResources.EMPTY, 1));
//            }
            this.session.service.getPlayelrMenu(this.arrMenu);
        }
    }
    
    public MenuInfo2 get(short select) {
        for (int i = 0; i < this.arrMenu.size(); i++) if (this.arrMenu.get(i).id == select) return this.arrMenu.get(i);
        return null;
    }
    
    public void menuAction(int charID, short select) {
        MenuInfo2 info = this.get(select);
        if (info != null) {
            Char player = this.session.myCharz().zoneMap.findCharInMap(charID);
            if (player == null) return;
            if (!info.execute()) return;
            switch(info.id) {
                case 1:
                {
                    this.session.myCharz().resetMenu();
                    this.session.myCharz().menuBoard.chat = mResources.SAY_OAN_TU_TI1;
                    this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO21, 408, new Object[]{1000000, charID}));
                    this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO22, 408, new Object[]{5000000, charID}));
                    this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO23, 408, new Object[]{10000000, charID}));
                    this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO24, 408, new Object[]{50000000, charID}));
                    this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                    this.session.myCharz().menuBoard.openUIConfirm(5, null, null, -1);
                    break;
                }
            }
            info.clean();
        }
    }
    
}
