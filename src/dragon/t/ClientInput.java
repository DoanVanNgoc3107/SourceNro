package dragon.t;

import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.util.ArrayList;

/**
 *
 * @author TGDD
 */
public class ClientInput {
    
    private final Session_ME session;
    
    public int typeInput;
    public String tile;
    public String name[];
    public int type[];
    public ArrayList<Integer> indexs = new ArrayList<>();
    public String inputs[] = null;
    
    public ClientInput(Session_ME session) {
        this.session = session;
    }
    
    public void openClientInput(int typeInput, String tile, String name[], int type[]) {
        this.typeInput = typeInput;
        this.tile = tile;
        this.name = name;
        this.type = type;
        this.session.service.openClientInput(this.tile, this.name, this.type);
    }
    
    public void doClientInput(String[] texts) {
        this.inputs = texts;
        switch (this.typeInput) {
            case -1:
            {
                Admin.gI().input(this.session.myCharz(), this.inputs);
                break;
            }
            case 1:
            {
                try {
                    this.session.myCharz().changeCode(Integer.parseInt(this.inputs[0]));
                } catch (Exception e) {
                    
                }   this.typeInput = 0;
                break;
            }
            case 2:
            {
                GiftCode.gI().inputCode(this.session.myCharz(), this.inputs[0]);
                break;
            }
            case 3:
            {
                if (this.session.myCharz().clan != null && this.session.myCharz().clanMember.role == 0) {
                    try {
                        int level = Integer.parseInt(this.inputs[0]);
                        if (level < 1 || level > 110) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.INFO_LEVEL, null, 0);
                        } else {
                            this.session.myCharz().clan.selectLevel = level;
                            this.session.myCharz().resetMenu();
                            this.session.myCharz().menuBoard.chat = String.format(mResources.SAY_MR_POPO_3, this.session.myCharz().clan.selectLevel);
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 92));
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                            this.session.myCharz().menuBoard.openUIConfirm(this.session.myCharz().menuBoard.npcId, null, null, -1);
                        }
                    } catch (Exception e) {

                    }
                }
                break;
            }
            case 4:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100 && this.session.myCharz().canProceed()) {
                        if (this.session.myCharz().getLuong() < 25 * number || this.session.myCharz().getItemBagById(695) == null || this.session.myCharz().getItemBagById(695).quantity < 1 * number || this.session.myCharz().getItemBagById(696) == null || this.session.myCharz().getItemBagById(696).quantity < 1 * number || this.session.myCharz().getItemBagById(697) == null || this.session.myCharz().getItemBagById(697).quantity < 1 * number || this.session.myCharz().getItemBagById(698) == null || this.session.myCharz().getItemBagById(698).quantity < 1 * number) {
                            this.session.myCharz().resetMenu();
                            this.session.myCharz().menuBoard.chat = mResources.SAY_QUY_LAO_KAME_8;
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                            this.session.myCharz().menuBoard.openUIConfirm(13, null, null, -1);
                        } else if (!this.session.myCharz().isHaveItemBag(694) && this.session.myCharz().getEmptyBagCount() < 1) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, 0);
                        } else {
                            this.session.myCharz().useItemBag(this.session.myCharz().getItemBagById(695).indexUI, 1 * number);
                            this.session.myCharz().useItemBag(this.session.myCharz().getItemBagById(696).indexUI, 1 * number);
                            this.session.myCharz().useItemBag(this.session.myCharz().getItemBagById(697).indexUI, 1 * number);
                            this.session.myCharz().useItemBag(this.session.myCharz().getItemBagById(698).indexUI, 1 * number);
                            Item it2 = new Item(694, false, number, ItemOption.getOption(694, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            if (it2.isHaveOption(93)) {
                                it2.setExpires(System.currentTimeMillis() + (long)(1000l * 60l * 60l * 24l * (long)(it2.getParamOption(93) + 1)));
                            }
                            this.session.myCharz().addItemBag(0, it2);
                            this.session.myCharz().updateLuong(-(25 * number), 2);
                        }
                    }
                } catch (Exception e) {
                }
                break;
            }
            //Con so may man
            case 5:
            {
                try {
                    int first = Integer.parseInt(this.inputs[0]);
                    if (first >= 0 && first < LuckyNumber.maxNumber && Server.start) {
                        if (!this.session.myCharz().isCan()) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.KHONG_HO_TRO, null, 0);
                        } else if (LuckyNumber.gI().isLockBuy) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BUY_LUCKY_NUMBER, null, 0);
                        } else if (this.session.myCharz().cPower < 150000000) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BUY_LUCKY_NUMBER_2, null, 0);
                        } else if (LuckyNumber.gI().isHavePlayer(this.session.myCharz().playerId) && LuckyNumber.gI().getPlayer(this.session.myCharz().playerId).arrNumber.size() + LuckyNumber.gI().arrNumber[this.session.myCharz().nLuckyIndex][0] > 500) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BUY_LUCKY_NUMBER_3, null, 0);
                        } else if (this.session.myCharz().getLuong() < LuckyNumber.gI().arrNumber[this.session.myCharz().nLuckyIndex][1]) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.CONTHIEU_NGOC, LuckyNumber.gI().arrNumber[this.session.myCharz().nLuckyIndex][1] - this.session.myCharz().getLuong()), null, 0);
                        } else if (this.session.myCharz().canProceed()) {
                            this.session.myCharz().updateLuong(-LuckyNumber.gI().arrNumber[this.session.myCharz().nLuckyIndex][1], 2);
                            LuckyNumber.gI().join(this.session.myCharz(), first, this.session.myCharz().nLuckyIndex);
                            this.session.service.showYourNumber(LuckyNumber.gI().getPlayer(this.session.myCharz().playerId).yourNumber());
                        }
                    }
                } catch (Exception e) {
                    
                }
                break;
            }
            //Nhan thoi vang
            case 6:
            {
                try {
                    if (this.session.myCharz().canProceed()) {
                        int ntv = Integer.parseInt(this.inputs[0]);
                        if (ntv > 0 && ntv <= this.session.myCharz().totalGold) {
                            Item thoivang = new Item(457, false, ntv, ItemOption.getOption(457, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                            if (this.session.myCharz().totalBagByItem(thoivang) < ntv) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, 0);
                            } else {
                                if (this.session.myCharz().checkBag(thoivang)) {
                                    this.session.myCharz().totalGold -= ntv;
                                    this.session.myCharz().addItemBag(0, thoivang);
                                } else {
                                    this.session.myCharz().addInfo1(mResources.BAG_FULL);
                                }
                            }
                        }
                    }
                } catch (Exception e) {}
                break;
            }
            //Ban do kho bau
            case 7:
            {
                if (this.session.myCharz().clan != null && this.session.myCharz().clanMember.role == 0 && this.session.myCharz().canProceed()) {
                    try {
                        int level = Integer.parseInt(this.inputs[0]);
                        if (level < 1 || level > 110) {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.INFO_LEVEL_2, null, 0);
                        } else {
                            this.session.myCharz().clan.selectLevel = level;
                            this.session.myCharz().resetMenu();
                            this.session.myCharz().menuBoard.chat = String.format(mResources.SAY_QUY_LAO_KAME_4, this.session.myCharz().clan.selectLevel);
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 48));
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                            this.session.myCharz().menuBoard.openUIConfirm(this.session.myCharz().menuBoard.npcId, null, null, -1);
                        }
                    } catch (Exception e) {

                    }
                }
                break;
            }
            //Ban phao hoa
            case 8:
            {
                if (this.session.myCharz().canProceed() && this.session.myCharz().phaohoa != null && this.session.myCharz().arrItemBag[this.session.myCharz().phaohoa.indexUI] != null && this.session.myCharz().arrItemBag[this.session.myCharz().phaohoa.indexUI] == this.session.myCharz().phaohoa) {
                    try {
                        int nShooot = Integer.parseInt(this.inputs[0]);
                        if (nShooot > 0) {
                            if (nShooot > this.session.myCharz().phaohoa.quantity) {
                                nShooot = this.session.myCharz().phaohoa.quantity;
                            }
                            this.session.myCharz().shootPhaoHoa(nShooot, this.session.myCharz().phaohoa);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            }
            //Hoa dang
            case 9:
            {
                if (this.session.myCharz().canProceed() && this.session.myCharz().phaohoa != null && this.session.myCharz().arrItemBag[this.session.myCharz().phaohoa.indexUI] != null && this.session.myCharz().arrItemBag[this.session.myCharz().phaohoa.indexUI] == this.session.myCharz().phaohoa) {
                    try {
                        int nShooot = Integer.parseInt(this.inputs[0]);
                        if (nShooot > 0) {
                            if (nShooot > this.session.myCharz().phaohoa.quantity) {
                                nShooot = this.session.myCharz().phaohoa.quantity;
                            }
                            this.session.myCharz().shootHoaDang(nShooot, this.session.myCharz().phaohoa);
                        }
                    } catch (Exception e) {
                    }
                }
                break;
            }
            //Hoa dang loi chuc
            case 10:
            {
                if (this.session.myCharz().canProceed() && this.session.myCharz().phaohoa != null && this.session.myCharz().arrItemBag[this.session.myCharz().phaohoa.indexUI] != null && this.session.myCharz().arrItemBag[this.session.myCharz().phaohoa.indexUI] == this.session.myCharz().phaohoa) {
                    try {
                        this.session.myCharz().clientInputInt = Integer.parseInt(this.inputs[0]);
                        //
                        this.session.myCharz().resetMenu();
                        String str = "";
                        for (int i = 0; i < PhaoHoa.ARRAY_LOI_CHUC.length; i++) {
                            str += String.format(mResources.LOI_CHUC_3, i + 1, PhaoHoa.ARRAY_LOI_CHUC[i]);
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.LOI_CHUC_1, i + 1), 298, i));
                        }
                        this.session.myCharz().menuBoard.openUIConfirm(5, String.format(mResources.LOI_CHUC_2, str), null, -1);
                    } catch (Exception e) {
                    }
                }
                break;
            }
            //Lam capsule world cup 2022
            case 11:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().getEmptyBagCount() == 0) {
                            this.session.myCharz().addInfo1(String.format(mResources.BAG_FULL_2, 1));
                        } else if (this.session.myCharz().getItemBagQuantityById(1118) < number || this.session.myCharz().getItemBagQuantityById(1119) < number || this.session.myCharz().getItemBagQuantityById(1120) < number || this.session.myCharz().getItemBagQuantityById(1121) < number || this.session.myCharz().getItemBagQuantityById(1122) < number
                                || this.session.myCharz().getItemBagQuantityById(1123) < number || this.session.myCharz().getItemBagQuantityById(1124) < number || this.session.myCharz().getItemBagQuantityById(1125) < number || this.session.myCharz().getItemBagQuantityById(1126) < number || this.session.myCharz().getItemBagQuantityById(1127) < number
                                || this.session.myCharz().getItemBagQuantityById(1133) < number * 5) {
                            this.session.myCharz().addInfo1(mResources.CONTHIEU_ITEM);
                        } else if (this.session.myCharz().canProceed()) {
                            this.session.myCharz().useItemBagById(1118, number);
                            this.session.myCharz().useItemBagById(1119, number);
                            this.session.myCharz().useItemBagById(1120, number);
                            this.session.myCharz().useItemBagById(1121, number);
                            this.session.myCharz().useItemBagById(1122, number);
                            this.session.myCharz().useItemBagById(1123, number);
                            this.session.myCharz().useItemBagById(1124, number);
                            this.session.myCharz().useItemBagById(1125, number);
                            this.session.myCharz().useItemBagById(1126, number);
                            this.session.myCharz().useItemBagById(1127, number);
                            this.session.myCharz().useItemBagById(1133, number * 5);
                            this.session.myCharz().addItemBag(0, new Item(1135, false, number, ItemOption.getOption(1135, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {
                }
                break;
            }
            //Lam capsule world cup 2022 vip
            case 12:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().getEmptyBagCount() == 0) {
                            this.session.myCharz().addInfo1(String.format(mResources.BAG_FULL_2, 1));
                        } else if (this.session.myCharz().getItemBagQuantityById(1118) < number || this.session.myCharz().getItemBagQuantityById(1119) < number || this.session.myCharz().getItemBagQuantityById(1120) < number || this.session.myCharz().getItemBagQuantityById(1121) < number || this.session.myCharz().getItemBagQuantityById(1122) < number
                                || this.session.myCharz().getItemBagQuantityById(1123) < number || this.session.myCharz().getItemBagQuantityById(1124) < number || this.session.myCharz().getItemBagQuantityById(1125) < number || this.session.myCharz().getItemBagQuantityById(1126) < number || this.session.myCharz().getItemBagQuantityById(1127) < number
                                || this.session.myCharz().getItemBagQuantityById(1132) < number) {
                            this.session.myCharz().addInfo1(mResources.CONTHIEU_ITEM);
                        } else if (this.session.myCharz().canProceed()) {
                            this.session.myCharz().useItemBagById(1118, number);
                            this.session.myCharz().useItemBagById(1119, number);
                            this.session.myCharz().useItemBagById(1120, number);
                            this.session.myCharz().useItemBagById(1121, number);
                            this.session.myCharz().useItemBagById(1122, number);
                            this.session.myCharz().useItemBagById(1123, number);
                            this.session.myCharz().useItemBagById(1124, number);
                            this.session.myCharz().useItemBagById(1125, number);
                            this.session.myCharz().useItemBagById(1126, number);
                            this.session.myCharz().useItemBagById(1127, number);
                            this.session.myCharz().useItemBagById(1132, number);
                            this.session.myCharz().addItemBag(0, new Item(1136, false, number, ItemOption.getOption(1136, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {
                }
                break;
            }
            //Short name
            case 13:
            {
                if (this.session.myCharz().clan != null && this.session.myCharz().clanMember.role == 0) {
                    try {
                        String shortName = this.inputs[0].toUpperCase();
                        if (!Util.gI().CheckString(shortName, "^[a-zA-Z0-9]+$") || shortName.length() < 2 || shortName.length() > 4) {
                            this.session.service.startOKDlg(mResources.FAILD_SHORT_NAME);
                        } else {
                            this.session.myCharz().clan.setShortName(this.session.myCharz(), shortName);
                        }
                    } catch (Exception e) {}
                }
                break;
            }
            //Mam ngu qua
            case 14:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().canProceed() && this.session.myCharz().requestOpenUIItem(this.session.myCharz().menuBoard.npcId, mResources.YOU_FRUIT_TRAY,  new int[]{1177, 1178, 1179, 1180, 1181, 1183}, new int[]{20 * number, 20 * number, 20 * number, 20 * number, 20 * number, 3 * number}, 0, 5000000 * number, -1, true, 1)) {
                            this.session.myCharz().addItemBag(0, new Item(1182, false, number, ItemOption.getOption(1182, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {

                }
                break;
            }
            //Hop qua tet
            case 15:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().canProceed() && this.session.myCharz().requestOpenUIItem(this.session.myCharz().menuBoard.npcId, mResources.YOU_GIFT_TET, new int[]{1182, 1184}, new int[]{1 * number, 1 * number}, 0, -1, -1, true, 1)) {
                            this.session.myCharz().addItemBag(0, new Item(1187, false, number, ItemOption.getOption(1187, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {

                }
                break;
            }
            //Bong hoa xanh
            case 16:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().canProceed() && this.session.myCharz().requestOpenUIItem(this.session.myCharz().menuBoard.npcId, mResources.YOU_GRAFT_FLOWER_BLUE, new int[]{1093, 1094, 1095 , 1096}, new int[]{10 * number, 5 * number, 1 * number ,3 * number}, 0, 1000000 * number, 2 * number, true, 1)) {
                            this.session.myCharz().addItemBag(0, new Item(1098, false, number, ItemOption.getOption(1098, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {

                }
                break;
            }
            //Chau hoa xanh
            case 17:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().canProceed() && this.session.myCharz().requestOpenUIItem(this.session.myCharz().menuBoard.npcId, mResources.YOU_GRAFT_FLOWER_POT_BLUE, new int[]{1093, 1094, 1098, 1097}, new int[]{10 * number, 5 * number, 1 * number, 1 * number}, 0, 1000000 * number, -1, true, 1)) {
                            this.session.myCharz().addItemBag(0, new Item(1099, false, number, ItemOption.getOption(1099, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {

                }
                break;
            }
            //mam bac
            case 18:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().canProceed() && this.session.myCharz().requestOpenUIItem(this.session.myCharz().menuBoard.npcId, mResources.YOU_GRAFT_MAM_BAC, new int[]{2001, 2002, 2003 , 2004}, new int[]{5 * number, 5 * number, 5 * number , 5 * number}, 0, -1, -1, true, 1)) {
                            this.session.myCharz().addItemBag(0, new Item(2006, false, number, ItemOption.getOption(2006, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {

                }
                break;
            }
            //mam vang
            case 19:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        if (this.session.myCharz().canProceed() && this.session.myCharz().requestOpenUIItem(this.session.myCharz().menuBoard.npcId, mResources.YOU_GRAFT_MAM_VANG, new int[]{2001, 2002, 2003, 2005}, new int[]{10 * number, 10 * number, 10 * number, 10 * number}, 0, -1, -1, true, 1)) {
                            this.session.myCharz().addItemBag(0, new Item(2007, false, number, ItemOption.getOption(2007, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                } catch (Exception e) {

                }
                break;
            }
            //Lech Teamobi
            //So ca xanh
            case 20:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        RequestItem ri = new RequestItem(this.session.myCharz(), mResources.DOI_XOCA3, new int[]{1002, 1003, 1004, 1994}, new int[]{5 * number, 5 * number, 5 * number, 5 * number}, 195, mResources.AGREE, 0, mResources.REFUSE, -1, -1, 1, false) {
                            @Override
                            public boolean execute() {
                                ClientInput.this.session.myCharz().addItemBag(0, new Item(1005, false, number, ItemOption.getOption(1005, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                return true;
                            }
                        };
                        if (ri.isSet) {
                            this.session.myCharz().requestItem = ri;
                        }
                    }
                } catch (Exception e) {
                }
                break;
            }
            //So ca vang
            case 21:
            {
                try {
                    byte number = Byte.parseByte(this.inputs[0]);
                    if (number > 0 && number < 100) {
                        RequestItem ri = new RequestItem(this.session.myCharz(), mResources.DOI_XOCA4, new int[]{1002, 1003, 1004, 1996}, new int[]{10 * number, 10 * number, 10 * number, 5 * number}, 195, mResources.AGREE, 0, mResources.REFUSE, -1, -1, 1, false) {
                            @Override
                            public boolean execute() {
                                ClientInput.this.session.myCharz().addItemBag(0, new Item(1006, false, number, ItemOption.getOption(1006, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                                return true;
                            }
                        };
                        if (ri.isSet) {
                            this.session.myCharz().requestItem = ri;
                        }
                    }
                } catch (Exception e) {
                }
                break;
            }
            //Nap the
            case 22:
            {
                if (this.session.myCharz().cardLoad != null && this.session.myCharz().cardLoad.netWork != null && this.session.myCharz().cardLoad.price != 0) {
                    this.session.myCharz().cardLoad.code = this.inputs[0];
                    this.session.myCharz().cardLoad.serial = this.inputs[1];
                    this.session.myCharz().resetMenu();
                    this.session.myCharz().menuBoard.chat = String.format(mResources.SAY_NAPTHE3, this.session.myCharz().cardLoad.netWork, Util.gI().getFormatNumber(this.session.myCharz().cardLoad.price), this.session.myCharz().cardLoad.code, this.session.myCharz().cardLoad.serial);
                    this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 207));
                    this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                    this.session.myCharz().menuBoard.openUIConfirm(this.session.myCharz().menuBoard.npcId, null, null, -1);
                }
                break;
            }
            //Con duong ran doc
            case 23:
            {
                try {
                    int level = Integer.parseInt(this.inputs[0]);
                    if (level >= 1 && level <= 110) {
                        this.session.myCharz().resetMenu();
                        this.session.myCharz().menuBoard.chat = String.format(mResources.SAY_THAN_VU_TRU2, level);
                        this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 326, level));
                        this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                        this.session.myCharz().menuBoard.openUIConfirm(this.session.myCharz().menuBoard.npcId, null, null, -1);
                    }
                } catch (Exception e) {

                }
                break;
            }
            //Ban vang so luong lon
            case 24:
            {
                try {
                    int quantity = Integer.parseInt(this.inputs[0]);
                    if (this.indexs.size() == 3) {
                        if (quantity >= 1 && quantity <= 99 && quantity <= this.indexs.get(2)) {
                            this.session.myCharz().saleItem(1, this.indexs.get(0), this.indexs.get(1), quantity);
                        } else {
                            this.session.myCharz().addInfo1(String.format(mResources.ABOUT_SALE, this.indexs.get(2)));
                        }
                    }
                } catch (Exception e) {

                }
                break;
            }
            default:
                break;
        }
    }
    
}
