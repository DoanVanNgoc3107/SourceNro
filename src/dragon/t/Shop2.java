package dragon.t;

import dragon.server.mResources;

/**
 *
 * @author TGDD
 */
public class Shop2 {
    
    public static boolean check(Char charz, Shop shop, Item item) {
        if (item.iconSpec == 4028) {
            if (charz.getItemBagQuantityById(457) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(457), "thỏi vàng"));
                return true;
            }
        }
        if (item.iconSpec == 6523) {
            if (charz.getItemBagQuantityById(712) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(712), "mảnh áo"));
                return true;
            }
        }
        if (item.iconSpec == 6524) {
            if (charz.getItemBagQuantityById(713) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(713), "mảnh quần"));
                return true;
            }
        }
        if (item.iconSpec == 6525) {
            if (charz.getItemBagQuantityById(714) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(714), "mảnh găng"));
                return true;
            }
        }
        if (item.iconSpec == 6526) {
            if (charz.getItemBagQuantityById(715) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(715), "mảnh giầy"));
                return true;
            }
        }
        if (item.iconSpec == 6527) {
            if (charz.getItemBagQuantityById(716) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(716), "mảnh nhẫn"));
                return true;
            }
        }
        //Ngoc xanh
        if (item.iconSpec == 932) {
            if (charz.luong < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM_2, Util.gI().numberTostring(item.buySpec - charz.luong), "ngọc xanh"));
                return true;
            }
        }
        //Hong ngoc
        if (item.iconSpec == 7743) {
            if (charz.luongKhoa < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM_2, Util.gI().numberTostring(item.buySpec - charz.luongKhoa), "hồng ngọc"));
                return true;
            }
        }
        //Vang
        if (item.iconSpec == 930) {
            if (charz.xu < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM_2, Util.gI().numberTostring(item.buySpec - charz.xu), "vàng"));
                return true;
            }
        }
        //Huan chuong
        if (item.iconSpec == 9397) {
            if (charz.getItemBagQuantityById(979) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(979), "huy chương đồng"));
                return true;
            }
        }
        if (item.iconSpec == 9398) {
            if (charz.getItemBagQuantityById(980) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(980), "huy chương bạc"));
                return true;
            }
        }
        if (item.iconSpec == 9399) {
            if (charz.getItemBagQuantityById(981) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(981), "huy chương vàng"));
                return true;
            }
        }
        //Be ngoan
        if (item.iconSpec == 11007) {
            if (charz.getItemBagQuantityById(1194) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(1194), "phiếu bé ngoan"));
                return true;
            }
        }
        // KEO
        if (item.iconSpec == 6763) {
            if (charz.getItemBagQuantityById(673) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(673), "kẹo"));
                return true;
            }
        }
        // Cup Vang
        if (item.iconSpec == 6553) {
            if (charz.getItemBagQuantityById(586) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(586), "Cúp Vàng"));
                return true;
            }
        }
        // Cup Vang
        if (item.iconSpec == 6554) {
            if (charz.getItemBagQuantityById(587) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(587), "Cúp Bạc"));
                return true;
            }
        }
         // Dua hau
        if (item.iconSpec == 4671) {
            if (charz.getItemBagQuantityById(569) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(569), "Dưa hấu"));
                return true;
            }
        }
        //Lech Teamobi
        //Dua hau
        if (item.iconSpec == 6694) {
            if (charz.getItemBagQuantityById(2008) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(2008), "Linh thạch"));
                return true;
            }
        }
        // Kem
        if (item.iconSpec == 6703) {
            if (charz.getItemBagQuantityById(2000) < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.getItemBagQuantityById(2000), "Hũ kem"));
                return true;
            }
        }
        //Diem vip
        if (item.iconSpec == 6689) {
            if (charz.pointVip < item.buySpec) {
                charz.addInfo1(String.format(mResources.CAN_ITEM, item.buySpec - charz.pointVip, "Điểm"));
                return true;
            }
        }
        return false;
    }
    
    public static void buy(Char charz, Shop shop, Item item) {
        if (item.iconSpec == 4028) {
            charz.useItemBagById(457, item.buySpec);
        }
        if (item.iconSpec == 6523) {
            charz.useItemBagById(712, item.buySpec);
        }
        if (item.iconSpec == 6524) {
            charz.useItemBagById(713, item.buySpec);
        }
        if (item.iconSpec == 6525) {
            charz.useItemBagById(714, item.buySpec);
        }
        if (item.iconSpec == 6526) {
            charz.useItemBagById(715, item.buySpec);
        }
        if (item.iconSpec == 6527) {
            charz.useItemBagById(716, item.buySpec);
        }
        //Ngoc xanh
        if (item.iconSpec == 932) {
            charz.updateLuong(-item.buySpec, 0);
        }
        //Hong ngoc
        if (item.iconSpec == 7743) {
            charz.updateLuongKhoa(-item.buySpec, 0);
        }
        //Vang
        if (item.iconSpec == 930) {
            charz.updateXu(-item.buySpec, 0);
        }
        //Huy chuong
        if (item.iconSpec == 9397) {
            charz.useItemBagById(979, item.buySpec);
        }
        if (item.iconSpec == 9398) {
            charz.useItemBagById(980, item.buySpec);
        }
        if (item.iconSpec == 9399) {
            charz.useItemBagById(981, item.buySpec);
        }
        //Be ngoan
        if (item.iconSpec == 11007) {
            charz.useItemBagById(1194, item.buySpec);
        }
        //hoa hong
        if (item.iconSpec == 6763) {
            charz.useItemBagById(673, item.buySpec);
        }
        //Cup vang
        if (item.iconSpec == 6553) {
            charz.useItemBagById(586, item.buySpec);
        }
        //Cup Bac
        if (item.iconSpec == 6554) {
            charz.useItemBagById(587, item.buySpec);
        }
        //dua hau
        if (item.iconSpec == 4671) {
            charz.useItemBagById(569, item.buySpec);
        }
        //Lech Teamobi
        //linh thach
        if (item.iconSpec == 6694) {
            charz.useItemBagById(2008, item.buySpec);    
        }
        //hu kem
        if (item.iconSpec == 6703) {
            charz.useItemBagById(2000, item.buySpec);    
        }
        //Diem vip
        if (item.iconSpec == 6689) {
            charz.pointVip -= item.buySpec;
        }
    }
    
}
