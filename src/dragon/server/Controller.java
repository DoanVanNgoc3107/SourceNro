package dragon.server;

import dragon.t.Clan;
import dragon.t.ClanImage;
import dragon.t.ClientInput;
import dragon.t.Combine;
import dragon.t.Shop;
import dragon.t.Skill;
import dragon.t.SmallImage;
import dragon.t.TextBox;
import dragon.t.Trade;
import dragon.t.Util;
import dragon.t.ZoneMap;
import io.IMessageHandler;
import io.Message;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import dragon.t.ArchivementTask;
import dragon.t.BgItem;
import dragon.t.CaiTrang;
import dragon.t.Char;
import dragon.t.DuaHau;
import dragon.t.EffChar;
import dragon.t.Flag;
import dragon.t.Friend;
import dragon.t.GameData;
import dragon.t.ImageSource;
import dragon.t.Item;
import dragon.t.ItemKyGui;
import dragon.t.ItemOption;
import dragon.t.ItemTemplate;
import dragon.t.ItemTime;
import dragon.t.LuckyRound;
import dragon.t.MagicTree;
import dragon.t.Map;
import dragon.t.Memory;
import dragon.t.MenuBoard;
import dragon.t.MenuBoard2;
import dragon.t.MenuInfo;
import dragon.t.Mob;
import dragon.t.Obj;
import dragon.t.Rada;
import dragon.t.SetSQL;

/**
 *
 * @author Admin
 */
public class Controller implements IMessageHandler {
    
    private final Session_ME session;
    
    public Controller(Session_ME session) {
        this.session = session;
    }
    
    @Override
    public void onMessage(Message msg) {
        if (msg != null) {
            try {
                Util.gI().logln("Send msg "+msg.getCommand());
                switch(msg.getCommand()) {
                    case -127:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().canProceed()) {
                                int type982 = msg.reader().readByte();
                                int num362 = 1;
                                try {
                                    num362 = msg.reader().readByte();
                                } catch (Exception e) {}
                                LuckyRound.gI().crackBall(this.session.myCharz(), type982, num362);
                            }
                        }
                        break;
                    case -125:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            String texts[]= new String[msg.reader().readByte()];
                            for (int i = 0; i < texts.length; i++) {
                                texts[i] = msg.reader().readUTF();
                            }
                            this.session.myCharz().clientInput.doClientInput(texts);
                        }
                        break;
                    case -118:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            int idThachDau = msg.reader().readInt();
                            this.session.myCharz().thachDau(idThachDau);
                        }
                        break;
                    case -113:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            try {
                                this.session.myCharz().KSkill.clear();
                                for (int i2 = 0; i2 < 10; i2++) {
                                    this.session.myCharz().KSkill.add(msg.reader().readByte());
                                }
                            } catch (Exception e) {
                                
                            }
                            this.session.myCharz().OSkill = this.session.myCharz().KSkill;
                            this.session.service.loadRMS(mResources.CSKILL, this.session.myCharz().CSkill);
                            this.session.service.loadRMS(mResources.OSKILL, this.session.myCharz().OSkill);
                        }
                        break;
                    case -114:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().canProceed()) {
                                MagicTree.Harvest_beans(this.session.myCharz());
                            }
                        }
                        break;
                    case -111:
                        short size = msg.reader().readShort();
                        if (size > 0) {
                            for (short i = 0; i < size; i++) {
                                String original = msg.reader().readUTF();
                                byte[] data = ImageSource.imgData.get(String.format(mResources.PATH_IMG, this.session.zoomLevel, original));
                                //byte[] data = Dragon.getFile(String.format(mResources.PATH_IMG, this.session.zoomLevel, original));
                                if (data != null) {
                                    this.session.service.getImageSource(data, original);
                                }
                            }
                        }
                        break;
                    case -108:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie && this.session.myCharz().myPet != null) {
                            this.session.myCharz().petChangeStatus(msg.reader().readByte());
                        }
                        break;
                    case -107:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && this.session.myCharz().myPet != null) {
                            this.session.service.petInfo2(this.session.myCharz().myPetz());
                        }
                        break;
                    case -105:
                        if (this.session.myCharz() != null && this.session.myCharz().transport != null && this.session.myCharz().isTransport) {
                            if (this.session.myCharz().maxTimeTransport <= (System.currentTimeMillis() - this.session.myCharz().lastTransport) / 1000L) {
                                this.session.myCharz().transPort();
                            } else {
                                if (this.session.myCharz().getLuong() >= 1) {
                                    this.session.myCharz().updateLuong(-1, 2);
                                    this.session.myCharz().transPort();
                                }
                            }
                        }
                        break;
                    case -104:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            this.session.myCharz().setLockInventory(msg.reader().readInt());
                        }
                        break;
                    case -103:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            int action = msg.reader().readByte();
                            int flagType = -1;
                            if (action != 0) {
                                flagType = msg.reader().readByte();
                            }
                            Util.gI().log("action="+action+" flagType="+flagType);
                            if (action == 0) {
                                this.session.service.getFlag();
                            }
                            if (flagType >= 0 && flagType < Flag.FLAGS.size()) {
                                if (action == 1) {
                                    if (this.session.myCharz().cTypePk == 5) {
                                        this.session.myCharz().addInfo1(mResources.NOT_CHANGE_TYPEPK);
                                    } else if (this.session.myCharz().zoneMap.map.isMapBlackBall() || this.session.myCharz().zoneMap.map.isMapButcher() || this.session.myCharz().zoneMap.map.isMapCace23_2() || this.session.myCharz().zoneMap.mapTemplate.mapTemplateId == 51 || this.session.myCharz().mapTemplateId == 113) {
                                        this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_CHANGE_FLAG, null, 0);
                                    } else {
                                        this.session.myCharz().changeFlag(flagType);
                                        if (this.session.myCharz().myPet != null) {
                                            this.session.myCharz().myPetz().changeFlag(flagType);
                                        }
                                    }
                                }
                                if (action == 2) {
                                    this.session.service.idImgFlag(flagType, Flag.FLAGS.get(flagType).itemFlag.template.iconID);
                                }
                            }
                        }
                        break;
                    case -101:
                        String user = msg.reader().readUTF();
                        byte b = msg.reader().readByte();
                        Util.gI().logln("user "+user+" byte "+b);
                        this.session.service.login2(user);
                        break;
                    case -100:
                    {
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().canProceed()) {
                                byte sdvi_action = msg.reader().readByte();
                                if (sdvi_action == 0) {
                                    if (this.session.myCharz().timeKyGui > 0) {
                                        this.session.myCharz().addInfo1(String.format(mResources.TIME_WITE, Util.gI().getStrTime(this.session.myCharz().timeKyGui)));
                                    } else {
                                        this.session.myCharz().timeKyGui = 5000;
                                        if (!this.session.myCharz().isCan()) {
                                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.KHONG_HO_TRO, null, 0);
                                        } else {
                                            ItemKyGui.kygui(this.session.myCharz(), sdvi_action, msg.reader().readShort(), msg.reader().readByte(), msg.reader().readInt(), this.session.getIntVersion() >= 222 ? msg.reader().readInt() : msg.reader().readByte());
                                        }
                                    }
                                }
                                if (sdvi_action == 1 || sdvi_action == 2) {
                                    if (this.session.myCharz().timeKyGui > 0) {
                                        this.session.myCharz().addInfo1(String.format(mResources.TIME_WITE, Util.gI().getStrTime(this.session.myCharz().timeKyGui)));
                                    } else {
                                        this.session.myCharz().timeKyGui = 5000;
                                        ItemKyGui.kygui(this.session.myCharz(), sdvi_action, msg.reader().readShort(), (byte)0, 0, 0);
                                    }
                                }
                                if (sdvi_action == 3) {
                                    if (this.session.myCharz().timeKyGui > 0) {
                                        this.session.myCharz().addInfo1(String.format(mResources.TIME_WITE, Util.gI().getStrTime(this.session.myCharz().timeKyGui)));
                                    } else {
                                        this.session.myCharz().timeKyGui = 5000;
                                        if (!this.session.myCharz().isCan()) {
                                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.KHONG_HO_TRO, null, 0);
                                        } else {
                                            ItemKyGui.kygui(this.session.myCharz(), sdvi_action, msg.reader().readShort(), msg.reader().readByte(), msg.reader().readInt(), 0);
                                        }
                                    }
                                }
                                if (sdvi_action == 4) {
                                    ItemKyGui.kygui(this.session.myCharz(), sdvi_action, -1, msg.reader().readByte(), msg.reader().readByte(), 0);
                                }
                                if (sdvi_action == 5) {
                                    ItemKyGui.kygui(this.session.myCharz(), sdvi_action, msg.reader().readShort(), (byte)0, 0, 0);
                                }
                            }
                        }
                        break;
                    }
                    case -91:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            this.session.myCharz().requestMapSelect(msg.reader().readByte());
                        }
                        break;
                    case -87:
                        if (this.session.isLogin) {
                            this.session.service.updateData();
                        }
                        break;
                    case -86:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().challengeCharId != -9999) {
                                this.session.myCharz().addInfo1(mResources.YOU_HAVE_REQUESTED_A_CHALLENFE);
                            } else if (this.session.myCharz().mapTemplateId == 51 || this.session.myCharz().mapTemplateId == 113) {
                                this.session.myCharz().addInfo1(mResources.NOT_TRADE2);
                            } else {
                                byte action234 = msg.reader().readByte();
                                Util.gI().log("action ="+action234);
                                //Yeu cau va chap nhan giao dich
                                if (action234 == 0 || action234 == 1) {
                                    Trade.getInstance().giaodich(this.session.myCharz(), action234, msg.reader().readInt(), -1, -1);
                                }
                                //Chon item
                                if (action234 == 2) {
                                    Trade.getInstance().giaodich(this.session.myCharz(), action234, -1, msg.reader().readByte(), msg.reader().readInt());
                                }
                                //Khoa va hoan thanh giao dich
                                if (action234 == 3 || action234 == 5 || action234 == 7) {
                                    Trade.getInstance().giaodich(this.session.myCharz(), action234, -1, -1, -1);
                                }
                            }
                        }
                        break;
                    case -81:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().canProceed()) {
                                byte action348 = msg.reader().readByte();
                                Item[] items591 = null;
                                int i13;
                                if (action348 == 1) {
                                    try {
                                        byte n556 = msg.reader().readByte();
                                        items591 = new Item[n556];
                                        for (i13 = 0; i13 < items591.length; i13++) {
                                            byte index92 = msg.reader().readByte();
                                            if (!this.session.myCharz().isIndexUI(index92, items591)) {
                                                Item item519 = this.session.myCharz().arrItemBag[index92];
                                                if (item519 != null) {
                                                    items591[i13] = item519;
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                                if (this.session.myCharz().nangcap != null) {
                                    this.session.myCharz().nangcap.myItem.clear();
                                    for (Item item : items591) {
                                        if (item != null) {
                                            this.session.myCharz().nangcap.myItem.add(item);
                                        }
                                    }
                                    this.session.myCharz().nangcap.type = 0;
                                    this.session.myCharz().nangcap.execute();
                                }
                                Combine.Combine(this.session.myCharz(), action348, items591);
                            }
                        }
                        break;
                    case -80:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            byte action23 = msg.reader().readByte();
                            int playerId23 = -1;
                            try {
                                playerId23 = msg.reader().readInt();
                            } catch (Exception e) {}
                            if (action23 == 0) {
                                this.session.myCharz().initFriend();
                                this.session.service.frendList(this.session.myCharz().arrFriend);
                            }
                            if (action23 == 1) {
                                this.session.myCharz().addFriend(playerId23);
                            }
                            if (action23 == 2) {
                                this.session.myCharz().removeFriend(playerId23);
                            }
                            Util.gI().logln("ac="+action23+" playerId23="+playerId23);
                        }
                        break;
                    case -76:
                    {
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            this.session.myCharz().getArchivemnt(msg.reader().readUnsignedByte());
                        }
                        break;
                    }
                    case -79:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            Session_ME player213 = Server.gI().getByCId(msg.reader().readInt());
                            if (player213 != null) {
                                this.session.service.playerMenu(player213.myCharz().charID, player213.myCharz().cPower, GameData.strLevel[player213.myCharz().clevel][player213.myCharz().cgender]);
                            }
                        }
                        break;
                    case -74:
                    {
                        byte action = msg.reader().readByte();
                        if (action == 1 && ImageSource.imageOriginals.containsKey(this.session.zoomLevel)) {
                            this.session.service.getnBigImageSource(ImageSource.imageOriginals.get(this.session.zoomLevel).size());
                        } else if (action == 2) {
                            try {
                                short size2 = msg.reader().readShort();
                                for (int i = 0; i < size2; i++) {
                                    msg.reader().readShort();
                                }
                            } catch (IOException e) {}
                            for (short i = 0; i < ImageSource.imageOriginals.get(this.session.zoomLevel).size(); i++) {
                                String original = ImageSource.imageOriginals.get(this.session.zoomLevel).get(i);
//                                    byte[] data = Dragon.getFile(String.format(mResources.PATH_IMG, this.session.zoomLevel, original));
                                byte[] data = ImageSource.imgData.get(String.format(mResources.PATH_IMG, this.session.zoomLevel, original));
                                if (data != null) {
                                    this.session.service.getImageSource(data, original);
                                }
                            }
                            this.session.service.lastVersionImageSource();
                        }
                        break;
                    }
                    case -71:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            String chat = msg.reader().readUTF();
                            if (!this.session.myCharz().isCan()) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.KHONG_HO_TRO, null, 0);
                            } else if (this.session.myCharz().cPower < 1500000000) {
                                this.session.myCharz().addInfo1(String.format(mResources.YEU_CAU_SUC_MANH, Util.gI().numberTostring(1500000000)));
                            } else if (this.session.isLock == 2) {
                                this.session.service.startOKDlg(mResources.BAN_KTG);
                            } else if (this.session.myCharz().timeKTG > 0) {
                                this.session.service.startOKDlg(String.format(mResources.DELAY_KTG, Util.gI().getFormatTime2(this.session.myCharz().timeKTG)));
                            } else if (chat.length() > 0 && chat.length() <= 50) {
                                this.session.myCharz().timeKTG = 120000;
                                this.session.myCharz().chatWorld(chat, 1000000);
//                                Server.gI().Player_ChatTheGoi(this.session.myCharz(), chat);
                            }
                        }
                        break;
                    case -72:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.isLock == 2) {
                                this.session.myCharz().addInfo1(mResources.BAN_NTR);
                            } else {
                                int playerId24 = msg.reader().readInt();
                                if (playerId24 != this.session.myCharz().charID) {
                                    Session_ME player443 = Server.gI().getByCId(playerId24);
                                    if (player443 != null) {
                                        String text32 = msg.reader().readUTF();
                                        if (text32.length() > 5 && this.session.myCharz().arrChat.contains(text32)) {
                                        } else {
                                            this.session.myCharz().arrChat.add(text32);
                                            player443.service.chatTHEGIOI(this.session.myCharz().cName, String.format(mResources.CHAT_PLAYER, 2, text32), this.session.myCharz(), (byte)1);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case -67:
                        if (this.session.isLogin) {
                            this.session.service.requestIcon(msg.reader().readInt());
                        }
                        break;
                    case -66:
                        if (this.session.myCharz() != null) {
                            int effId = msg.reader().readShort();
                            if (!this.session.myCharz().insertEff(effId)) {
                                this.session.service.getEffData(effId);
                            }
                        }
                        break;
                    case -63:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            ClanImage clanImage = ClanImage.images.get(msg.reader().readUnsignedByte());
                            if (clanImage != null) {
                                if (this.session.getIntVersion() >= 228 && clanImage.ID >= 201 && clanImage.ID < 255) {
                                    //type 5
                                } else {
                                    this.session.service.getBagImg(clanImage);
                                }
                            } else {
                                
                            }
                        }
                        break;
                    case -62:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            int ii12 = msg.reader().readUnsignedByte();
                            ClanImage clanImage2 = ClanImage.images.get(ii12);
                            if (clanImage2 != null) {
                                this.session.service.clanImage(clanImage2);
                            }
                        }
                        break;
                    case -60:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie && !this.session.myCharz().isFreez && !this.session.myCharz().sleepEff && !this.session.myCharz().holder && !this.session.myCharz().blindEff && this.session.myCharz().stone == 0 && !this.session.myCharz().isMabuHold) {
                            if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().stone > 0) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_STONE, null, (byte)0);
                            } else {
                                if (this.session.myCharz().cStamina <= 0 && !this.session.myCharz().isNotTheLeDown) {
                                    this.session.service.Stamina(this.session.myCharz().cStamina);
                                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HET_TL, null, 0);
                                } else {
                                    if (this.session.myCharz().isNotTheLeDown) {
                                        this.session.service.Stamina(this.session.myCharz().cStamina);
                                    } else {
                                        this.session.myCharz().cStamina--;
                                    }
                                    Skill skillFight11 = this.session.myCharz().mySkill;
                                    this.session.myCharz().aMobFocus.clear();
                                    this.session.myCharz().aCharFocus.clear();
                                    int num55;
                                    try {
                                        for (num55 = 0; num55 < skillFight11.maxFight; num55++) {
                                            int charId23 = msg.reader().readInt();
                                            if (charId23 != -1 && charId23 != this.session.myCharz().charID) {
                                                this.session.myCharz().aCharFocus.add(this.session.myCharz().zoneMap.findCharInMap(charId23));
                                            }
                                        }
                                    } catch (Exception e) {}
                                    this.session.myCharz().Attack(skillFight11, this.session.myCharz().aMobFocus, this.session.myCharz().aCharFocus, 2);
                                    if (skillFight11.template.id == 20) {
                                        this.session.myCharz().setPos(this.session.myCharz().cx, this.session.myCharz().cy, 1);
                                    }
                                }
                            }
                        }
                        break;
                    case -59:
                    {
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie && !this.session.myCharz().isChallenge) {
                            byte action = msg.reader().readByte();
                            byte type = msg.reader().readByte();
                            int playerId = msg.reader().readInt();
                            this.session.myCharz().action_player_vs_player(action, type, playerId);
                            Util.gI().log("action="+action+" type="+type);
                        }
                        break;
                    }
                    case -57:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            int action342 = msg.reader().readByte();
                            int playerID432 = -1;
                            int clanID532 = -1;
                            int code352= -1;
                            if (action342 == 0) {
                                playerID432 = msg.reader().readInt();
                            }
                            if (action342 == 1 || action342 == 2) {
                                clanID532 = msg.reader().readInt();
                                code352 = msg.reader().readInt();
                            }
                            this.session.myCharz().clanInvite(action342, playerID432, clanID532, code352);
                        }
                        break;
                    case -56:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            if (this.session.myCharz().clan != null && this.session.myCharz().clanMember.role != 2) {
                                this.session.myCharz().clan.clanRemote(this.session.myCharz(), msg.reader().readInt(), msg.reader().readByte());
                            }
                        }
                        break;
                    case -55:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            this.session.myCharz().resetMenu();
                            this.session.myCharz().menuBoard.chat = mResources.SAY_OUT_CLAN;
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 301));
                            this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                            this.session.myCharz().menuBoard.openUIConfirm(5, null, null, -1);
                        }
                        break;
                    case -54:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && this.session.myCharz().clan != null) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().canProceed()) {
                                this.session.myCharz().clanDonate(msg.reader().readInt());
                            }
                        }
                        break;
                    case -51:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            byte type423 = msg.reader().readByte();
                            String text = mResources.EMPTY;
                            int clanID234 = -1;
                            if (type423 == 0) {
                                text = msg.reader().readUTF();
                            }
                            if (type423 == 2) {
                                clanID234 = msg.reader().readInt();
                            }
                            this.session.myCharz().clanMessage(type423, text, clanID234);
                        }
                        break;
                    case -50:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            Clan clan235 = Clan.getClan(msg.reader().readInt());
                            if (clan235 != null) {
                                this.session.service.clanMember(clan235);
                            }
                        }
                        break;
                    case -49:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            if (this.session.myCharz().clan != null && (this.session.myCharz().clanMember.role == 0 || this.session.myCharz().clanMember.role == 1)) {
                                this.session.myCharz().clan.joinClan(this.session.myCharz(), msg.reader().readInt(), msg.reader().readByte());
                            }
                        }
                        break;
                    case -47:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            Clan.findClan(this.session.myCharz(), msg.reader().readUTF());
                        }
                        break;
                    case -46:
                    {
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            byte action = msg.reader().readByte();
                            if (action == 2 || action == 4) {
                                if (action == 2) {
                                    if (this.session.myCharz().clan == null) {
//                                        if (!this.session.myCharz().isCan()) {
//                                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.KHONG_HO_TRO, null, 0);
//                                        } else {
                                            Clan.create(this.session.myCharz(), msg.reader().readUnsignedByte(), msg.reader().readUTF());
//                                        }
                                    }
                                }
                                if (action == 4) {
                                    if (this.session.myCharz().clan != null && this.session.myCharz().clanMember.role == 0) {
                                        this.session.myCharz().clan.setClan(this.session.myCharz(), msg.reader().readUnsignedByte(), msg.reader().readUTF());
                                    }
                                }
                            } else if (action == 1 || action == 3) {
                                this.session.service.getClan(action);
                            }
                        }
                        break;
                    }
                    case -45:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie && !this.session.myCharz().isFreez && !this.session.myCharz().sleepEff) {
                            if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().stone > 0) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_STONE, null, (byte)0);
                            } else if (this.session.myCharz().cStamina <= 0 && !this.session.myCharz().isNotTheLeDown) {
                                this.session.service.Stamina(this.session.myCharz().cStamina);
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HET_TL, null, 0);
                            } else {
                                if (this.session.myCharz().isNotTheLeDown) {
                                    this.session.service.Stamina(this.session.myCharz().cStamina);
                                } else {
                                    this.session.myCharz().cStamina--;
                                }
                                Skill skillFight9 = this.session.myCharz().mySkill;
                                if (skillFight9 != null) {
                                    byte status = msg.reader().readByte();
                                    if (status == 20) {
                                    	byte idTemplateSkill = msg.reader().readByte();
                                    	short x0 = msg.reader().readShort();
                                    	short y0 = msg.reader().readShort();
                                    	byte dir = msg.reader().readByte();
                                    	short x = msg.reader().readShort();
                                    	short y = msg.reader().readShort();
                                    	this.session.myCharz().new_skill_not_focus(this.session.myCharz().getSkillByTemplateId(idTemplateSkill), x0, y0, dir, x, y);
                                    } else {
                                    	this.session.myCharz().skill_not_focus(status, skillFight9);
                                    }
                                }
                            }
                        }
                        break;
                    case -43:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().canProceed()) {
                                int type675 = msg.reader().readByte();
                                int where675 = msg.reader().readByte();
                                int index675 = msg.reader().readByte();
                                int template675 = -1;
                                if (index675 == -1) {
                                    template675 = msg.reader().readUnsignedShort();
                                }
                                this.session.myCharz().useItem(type675, where675, index675, template675);
                            }
                        }
                        break;
                    case -41:
                        if (this.session.isLogin) {
                            this.session.service.updateCaption(msg.reader().readByte());
                        }
                        break;
                    case -40:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().isgiaodich) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.O_THE_THUC_HIEN, null, (byte)0);
                            } else if (this.session.myCharz().stone > 0) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_STONE, null, (byte)0);
                            } else {
                                this.session.myCharz().getItem(msg.reader().readByte(), msg.reader().readUnsignedByte());
                            }
                        }
                        break;
                    case -39:
                        if (this.session.myCharz() != null) {
                            if (this.session.myCharz().zoneMap != null) {
                                this.session.myCharz().zoneMap.finishMap(this.session.myCharz());
                                this.session.myCharz().finishLoadMap();
                            }
                        }
                        Util.gI().logln("finish LoadMap");
                        break;
                    case -38:
                        if (this.session.isLogin) {
                            this.session.service.getBgTemplateLayer();
                            if (this.session.myCharz() == null) {
                                this.session.service.initSelectChar();
                            } else {
                                this.session.myCharz().InGame();
                            }
                        }
                        Util.gI().logln("finish Update");
                        break;
                    case -34:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            byte b21 = msg.reader().readByte();
                            if (b21 == 1) {
                                this.session.myCharz().menuBoard.openMenuUI(4);
                            } else {
                                this.session.service.magicTree();
                            }
                        }
                        break;
                    case -32:
                        if (this.session.isLogin) {
                            this.session.service.getBgTemplate(msg.reader().readShort());
                        }
                        break;
                    case -30:
                        this.messageSubCommand(msg);
                        break;
                    case -29:
                        this.messageNotLogin(msg);
                        break;
                    case -28:
                        this.messageNotMap(msg);
                        break;
                    case -27:
                        this.session.getKey();
                        break;
                    case -23:
                    case -33:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else {
                                this.session.myCharz().addMove(0, 0, 0, msg.getCommand() == -23 ? 2 : 3);
                                this.session.myCharz().isCheckWaypoint = true;
                            }
                        }
                        break;
                    case -20:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().isgiaodich) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.O_THE_THUC_HIEN, null, (byte)0);
                            } else if (this.session.myCharz().stone > 0) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_STONE, null, (byte)0);
                            } else {
                                if (this.session.myCharz().timeNhat <= 0) {
                                    this.session.myCharz().zoneMap.pickItem(this.session.myCharz(), msg.reader().readShort(), 1);
                                }
                            }
                        }
                        break;
                    case -16:
                    {
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && this.session.myCharz().isDie && !this.session.myCharz().isFreez && !this.session.myCharz().blindEff && !this.session.myCharz().sleepEff) {
                            final int gia = 1;
                            if (this.session.myCharz().isSecurity) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAOVE, null, (byte)0);
                            } else if (this.session.myCharz().timeHSTaiCho > 0) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.HS_SAU, Util.gI().getFormatTime3(this.session.myCharz().timeHSTaiCho)), null, (byte)0);
                            } else if (this.session.myCharz().getLuong() < gia) {
                                this.session.myCharz().addInfo1(String.format(mResources.NOT_LUONG, gia - this.session.myCharz().getLuong()));
                            } else {
                                this.session.myCharz().timeHSTaiCho = 5000;
                                this.session.myCharz().updateLuong(-gia, 2);
                                this.session.myCharz().liveFromDead(2);
                                this.session.myCharz().updateArchivement(13, 1L);
                                this.session.myCharz().timeHit = this.session.myCharz().timeReady = 5000;
                            } 
                        }
                        break;
                    }
                    case -15:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && this.session.myCharz().isDie) {
                            if (this.session.myCharz().mapTemplateId == 114 || this.session.myCharz().mapTemplateId == 115 || this.session.myCharz().mapTemplateId == 117 || this.session.myCharz().mapTemplateId == 118 || this.session.myCharz().mapTemplateId == 119 || this.session.myCharz().mapTemplateId == 120) {
                                Map map = Map.getMapServer(114);
                                if (map != null) {
                                    ZoneMap zone3 = map.getZone(this.session.myCharz());
                                    if (zone3 != null) {
                                        this.session.myCharz().zoneMap.exit(this.session.myCharz(), 0);
                                        this.session.myCharz().liveFromDead(1);
                                        this.session.myCharz().upHP(this.session.myCharz().cHPFull);
                                        this.session.myCharz().upMP(this.session.myCharz().cMPFull);
                                        zone3.join(this.session.myCharz(), 0, 205, 336);
                                    } else {
                                        this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                                    }
                                }
                            } else {
                                Map map = this.session.myCharz().getMapOffline(this.session.myCharz().mainHome());
                                if (map != null) {
                                    ZoneMap zone3 = map.getZone(this.session.myCharz());
                                    if (zone3 != null) {
                                        this.session.myCharz().zoneMap.exit(this.session.myCharz(), this.session.myCharz().typeTeleport);
                                        this.session.myCharz().liveFromDead(1);
                                        if (this.session.myCharz().typeTeleport == 3) {
                                            this.session.myCharz().upHP(this.session.myCharz().cHPFull);
                                            this.session.myCharz().upMP(this.session.myCharz().cMPFull);
                                        }
                                        zone3.join(this.session.myCharz(), this.session.myCharz().typeTeleport, 350, 5);
                                    } else {
                                        this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                                    }
                                }
                            }
                        }
                        break;
                    case -7:
                        if (this.session.myCharz() != null && !this.session.myCharz().isDie && this.session.myCharz().zoneMap != null) {
                            byte type16 = msg.reader().readByte();
                            short sendX = msg.reader().readShort();
                            short sendY = -1;
                            try {
                                sendY = msg.reader().readShort();
                            } catch (IOException e) {
                            }
//                            this.session.myCharz().checkMove(sendX, sendY);
                            Util.gI().log("=====sendX="+sendX+" sendY="+sendY +" cspeed="+this.session.myCharz().cspeed);
                            
//                                if ((Math.abs(this.session.myCharz().cx - sendX) > this.session.myCharz().cspeed * 7 && Math.abs(this.session.myCharz().cx - sendX) > 50)) {
//                                    this.session.myCharz().cspeed--;
//                                    if (this.session.myCharz().cspeed < 1) {
//                                        this.session.myCharz().cspeed = 1;
//                                    }
//                                    Service.meLoadPoint(this.session.myCharz());
//                                }
                                this.session.myCharz().addMove(type16, sendX, sendY, 0);
//                                this.session.myCharz().move(type16, sendX, sendY);
                        }
                        break;
                    case 6:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().canProceed()) {
                                byte type41 = msg.reader().readByte();
                                short id45 = msg.reader().readShort();
                                int num78 = 1;
                                try {
                                    num78 = msg.reader().readShort();
                                } catch (Exception e){}
                                if (this.session.myCharz().isItemMore != 0) {
                                    this.session.myCharz().getItemMore(type41, id45, num78);
                                } else {
                                    if (this.session.myCharz().shopId == -2003) {
                                        this.session.myCharz().buyItemShop(type41, id45, num78);
                                    }
                                    Shop.ItemBuy(this.session.myCharz(), type41, id45, num78);
                                }
                            }
                        }
                        break;
                    case 7:
                    {
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().blindEff) {
                                this.session.myCharz().addInfo1(mResources.BLIND_ACT);
                            } else if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().canProceed()) {
                                this.session.myCharz().saleItem(msg.reader().readByte(), msg.reader().readByte(), msg.reader().readShort(), 999999);
                            }
                        }
                        break;
                    }
                    case 11:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            this.session.service.mobTemplate(msg.reader().readUnsignedByte());
                        }
                        break;
                    case 18:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            this.session.myCharz().goToPlayer(msg.reader().readInt());
                        }
                        break;
                    case 21:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().stone > 0) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_STONE, null, (byte)0);
                            } else {
                                this.session.myCharz().zoneMap.map.requestChangeZone(this.session.myCharz(), msg.reader().readByte());
                            }
                        }
                        break;
                    case 22:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            this.session.myCharz().menuBoard.menu(msg.reader().readByte(), msg.reader().readByte(), msg.reader().readByte());
                        }
                        break;
                    case 29:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            Map map13 = this.session.myCharz().zoneMap.map;
                            if (map13.isNotChangeZone()) {
                                this.session.service.startOKDlg(mResources.NOT_CHANGE_ZONE);
                            } else {
                                this.session.service.openUIZone(map13);
                            }
                        }
                        break;
                    case 33:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            this.session.myCharz().menuBoard.openMenuUI(msg.reader().readShort());
                        }
                        break;
                    case 32:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            this.session.myCharz().menuBoard.openUIConfirm(msg.reader().readShort(), msg.reader().readByte());
                        }
                        break;
                    case 34:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie && !this.session.myCharz().isFreez) {
                            this.session.myCharz().selectSkill(msg.reader().readShort());
                        }
                        break;
                    case 44:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                            if (this.session.myCharz().mapTemplateId == 52) {
                                this.session.myCharz().addInfo1(mResources.NOT_CHAT);
                            } else {
                                this.session.myCharz().zoneMap.chat(this.session.myCharz(), msg.reader().readUTF());
                            }
                        }
                        break;
                    case 54:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie && !this.session.myCharz().isFreez && !this.session.myCharz().sleepEff && !this.session.myCharz().holder && !this.session.myCharz().blindEff && this.session.myCharz().stone == 0 && !this.session.myCharz().isMabuHold) {
                            if (this.session.myCharz().holder) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BI_TROI_ROI, null, (byte)0);
                            } else if (this.session.myCharz().stone > 0) {
                                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOU_STONE, null, (byte)0);
                            } else {
                                if (this.session.myCharz().cStamina <= 0 && !this.session.myCharz().isNotTheLeDown) {
                                    this.session.service.Stamina(this.session.myCharz().cStamina);
                                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HET_TL, null, 0);
                                } else {
                                    if (this.session.myCharz().isNotTheLeDown) {
                                        this.session.service.Stamina(this.session.myCharz().cStamina);
                                    } else {
                                        this.session.myCharz().cStamina--;
                                    }
                                    Skill skillFight12 = this.session.myCharz().mySkill;
                                    this.session.myCharz().aMobFocus.clear();
                                    this.session.myCharz().aCharFocus.clear();
                                    int num56;
                                    try {
                                        for (num56 = 0; num56 < skillFight12.maxFight; num56++) {
                                            int mobId22 = msg.reader().readByte();
                                            if (mobId22 != -1) {
                                                Mob mob = this.session.myCharz().zoneMap.findMobInMap(mobId22);
                                                if (mob != null) {
                                                    this.session.myCharz().aMobFocus.add(mob);
                                                }
                                            } else {
                                                Mob mob = this.session.myCharz().zoneMap.findMobInMap(msg.reader().readInt());
                                                this.session.myCharz().aMobFocus.add(mob);
                                            }
                                        }
                                    } catch (Exception e) {}
                                    this.session.myCharz().Attack(skillFight12, this.session.myCharz().aMobFocus, this.session.myCharz().aCharFocus, 1);
                                    if (skillFight12.template.id == 20) {
                                        this.session.myCharz().setPos(this.session.myCharz().cx, this.session.myCharz().cy, 1);
                                    }
                                }
                            }
                        }
                        break;
                    case 66:
                        this.session.service.writeGetImgByName(msg.reader().readUTF());
                        break;
                    case 88:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            TextBox.gI().textBoxId(this.session.myCharz(), msg.reader().readShort(), msg.reader().readUTF());
                        }
                        break;
                    case 112:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            byte b22 = msg.reader().readByte();
                            if (b22 == 0) {
                                this.session.myCharz().resetMenu();
                                this.session.myCharz().menuBoard.chat = mResources.SAY_NOI_TAI;
                                this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.VIEW_ALL_NOITAI, 302));
                                this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.OPEN_NOITAI, 303));
                                this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.OPEN_NOITAI_VIP, 305));
                                this.session.myCharz().menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                                this.session.myCharz().menuBoard.openUIConfirm(5, null, null, -1);
                            }
                            Util.gI().log("speacialSkill = "+b22);
                        }
                        break;
                    case 127:
                        if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                            byte i23 = msg.reader().readByte();
                            short id32 = -1;
                            try {
                                id32 = msg.reader().readShort();
                            } catch (Exception e) {}
                            if (i23 == 0) {
                                this.session.service.rada();
                            }
                            if (i23 == 1) {
                                this.session.myCharz().useCard(id32);
                            }
                            Util.gI().logln("OK========="+ i23 +" ====="+ id32);
                        }
                        break;
                    default:
                    {
                        this.session.myCharz().addInfo1(String.format(mResources.SAP_CAP_NHAT, msg.getCommand()));
                        break;
                    }
                }
            } catch(IOException e) {
                if (Util.gI().debug) {
                    e.printStackTrace();
                }
                this.session.disconnect();
            } finally {
                msg.cleanup();
            }
        }
    }
    
    private void messageSubCommand(Message msg) {
        try {
            byte b = msg.reader().readByte();
            Util.gI().logln("messageSubCommand "+b);
            switch (b) {
                case 16:
                {
                    if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && !this.session.myCharz().isDie) {
                        this.session.myCharz().upPotential(msg.reader().readUnsignedByte(), msg.reader().readShort());
                    }
                    break;
                }
                case 63:
                {
                    if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && this.session.myCharz().menuBoard2 != null) {
                        this.session.myCharz().menuBoard2.getMenu(msg.reader().readInt());
                    }
                    break;
                }
                case 64:
                {
                    if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null && this.session.myCharz().menuBoard2 != null) {
                        this.session.myCharz().menuBoard2.menuAction(msg.reader().readInt(), msg.reader().readShort());
                    }
                    break;
                }
                default:
                {
                    this.session.myCharz().addInfo1(String.format(mResources.SAP_CAP_NHAT, msg.getCommand()));
                    break;
                }
            }
        } catch (IOException e) {
            if (Util.gI().debug) {
                e.printStackTrace();
            }
            this.session.disconnect();
        }
    }
    
    private void messageNotLogin(Message msg) {
        try {
            byte b = msg.reader().readByte();
            Util.gI().logln("messageNotLogin "+b);
            switch (b) {
                case 0:
                    if (!this.session.isSetClient || this.session.isLogin) {
                        this.session.disconnect();
                    } else if (this.session.loginFaid >= 10) {
                        this.session.service.startOKDlg(mResources.BAN_2);
                    } else {
                        //============================
                        String uname = msg.reader().readUTF();
                        String pass = msg.reader().readUTF();
                        String version = msg.reader().readUTF();
                        byte type = msg.reader().readByte();
                        Util.gI().logln("User "+uname+" pass "+Util.gI().stringSQL_LIKE(pass)+" version "+version+" type "+type);
                        if (uname.isEmpty() || pass.isEmpty()) {
                            this.session.service.startOKDlg(mResources.TB_ACC);
                        } else if (!Util.gI().CheckString(uname + pass, "^[a-zA-Z0-9]+$")) {
                            this.session.service.startOKDlg(mResources.KY_TU_DAC_BIET);
                        } else {
                            try {
                                MySQL mySQL1 = MySQL.createData2();
                                MySQL mySQL2 = MySQL.createData6();
                                MySQL mySQL3 = MySQL.createData3();
                                MySQL mySQL4 = MySQL.createData7();
                                try {
                                    ResultSet red1 = mySQL1.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_USER_FORMAT, Util.gI().stringSQL_LIKE(Util.gI().stringSQL(uname)), Util.gI().stringSQL_LIKE(Util.gI().stringSQL(pass))), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                    if (red1.first()) {
                                        //GET USER
                                        int uId = red1.getInt("id");
                                        String uName = red1.getString("username");

                                        int playerId = red1.getInt("playerId");
                                        byte look = red1.getByte("isLock");
                                        byte isA = red1.getByte("isAdmin");
                                        boolean load = red1.getBoolean("isLoad");
                                        if (look == 1) {
                                            this.session.service.startOKDlg(mResources.BAN);
                                        } else {
                                            Session_ME player = Server.gI().getByUId(uId);
                                            final int SECOND_DELAY = 15;
                                            int second = (int) ((System.currentTimeMillis() / 1000L) - Memory.get(uId).lastlogout);
                                            if (player != null) {
                                                player.disconnect();
                                                this.session.service.startOKDlg(mResources.LOGIN_LOGGED);
                                            } else if (second < SECOND_DELAY) {
                                                this.session.service.loginDE(SECOND_DELAY - second);
                                            } else {
                                                this.session.userId = uId;
                                                this.session.userName = uName;
                                                this.session.isLock = look;
                                                this.session.isAdmin = isA;

                                                //GHI
                                                this.session.isLoad = load;
                                                Server.gI().addConn(this.session, this.session.userId, this.session.userName);
                                                if (playerId != -1) {
                                                    Char newChar = new Char();
                                                    newChar.me = true;
                                                    newChar.isPlayer = true;
                                                    newChar.menuBoard = new MenuBoard(this.session);
                                                    newChar.menuBoard2 = new MenuBoard2(this.session);
                                                    newChar.clientInput = new ClientInput(this.session);
                                                    newChar.charID = Char.getNewCharID();
                                                    newChar.playerId = playerId;
                                                    {
                                                        ResultSet red2 = mySQL2.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_CHARS_FORMAT, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red2.first();
                                                        newChar.cName = red2.getString("cName");
                                                        newChar.cgender = red2.getByte("cgender");
                                                        newChar.headDefault = red2.getShort("head");
                                                        newChar.ctaskId = red2.getByte("ctaskId");
                                                        newChar.ctaskIndex = red2.getByte("ctaskIndex");
                                                        newChar.ctaskCount = red2.getShort("ctaskCount");
                                                        newChar.cPower = red2.getLong("cPower");
                                                        newChar.cPowerLimit = red2.getByte("cPowerLimit");
                                                        newChar.mapTemplateId = red2.getInt("mapTemplateId");
                                                        newChar.cx = red2.getShort("cx");
                                                        newChar.cy = red2.getShort("cy");
                                                        newChar.nClassId = red2.getByte("nClassId");
                                                        newChar.xu = red2.getLong("xu");
                                                        newChar.luong = red2.getInt("luong");
                                                        newChar.luongKhoa = red2.getInt("luongKhoa");
                                                        newChar.cHPGoc = red2.getInt("cHPGoc");
                                                        newChar.cMPGoc = red2.getInt("cMPGoc");
                                                        newChar.cHP = red2.getInt("cHP");
                                                        newChar.cMP = red2.getInt("cMP");
                                                        newChar.cDamGoc = red2.getInt("cDamGoc");
                                                        newChar.cDefGoc = red2.getInt("cDefGoc");
                                                        newChar.cCriticalGoc = red2.getInt("cCriticalGoc");
                                                        newChar.cTiemNang = red2.getLong("cTiemNang");
                                                        //===JSONArray SKILLS===//
                                                        JSONArray jarr = (JSONArray) JSONValue.parseWithException(red2.getString("skills"));
                                                        for (int i = 0; i < jarr.size(); i++) {
                                                            JSONArray jarr2 = (JSONArray) jarr.get(i);
                                                            Skill skill = Skill.arrSkill[Integer.parseInt(jarr2.get(0).toString())].clone();
                                                            skill.lastTimeUseThisSkill = Long.parseLong(jarr2.get(1).toString());
                                                            if (skill.template.type == 4) {
                                                                skill.curExp = Short.parseShort(jarr2.get(2).toString());
                                                            }
                                                            newChar.skills.add(skill);
                                                        }
                                                        //===JSONArray arrItemBody===//
                                                        JSONArray arrItemBody = (JSONArray) JSONValue.parseWithException(red2.getString("arrItemBody"));
                                                        newChar.arrItemBody = new Item[10];
                                                        for (int i = 0; i < arrItemBody.size(); i++) {
                                                            Item item3 = Item.parseItem(arrItemBody.get(i).toString());
                                                            if (item3 != null &&  !item3.isClear()) {
                                                                CaiTrang.gI().setPartTemp(item3);
                                                                item3.typeUI = 5;
                                                                newChar.arrItemBody[item3.indexUI] = item3;
                                                            }
                                                        }
                                                        //typeTeleport
                                                        newChar.typeTeleport = red2.getByte("typeTeleport");
                                                        //KeySkill
                                                        JSONArray KSkill = (JSONArray) JSONValue.parseWithException(red2.getString("KSkill"));
                                                        for (int i = 0; i < KSkill.size(); i++) {
                                                            newChar.KSkill.add(Byte.parseByte(KSkill.get(i).toString()));
                                                        }
                                                        JSONArray OSkill = (JSONArray) JSONValue.parseWithException(red2.getString("OSkill"));
                                                        for (int i = 0; i < OSkill.size(); i++) {
                                                            newChar.OSkill.add(Byte.parseByte(OSkill.get(i).toString()));
                                                        }
                                                        JSONArray CSkill = (JSONArray) JSONValue.parseWithException(red2.getString("CSkill"));
                                                        for (int i = 0; i < CSkill.size(); i++) {
                                                            newChar.CSkill.add(Byte.parseByte(CSkill.get(i).toString()));
                                                        }

                                                        JSONArray itemTimes = (JSONArray) JSONValue.parseWithException(red2.getString("itemTimes"));
                                                        for (int i = 0; i < itemTimes.size(); i++) {
                                                            JSONArray itemTime = (JSONArray) itemTimes.get(i);
                                                            ItemTime obj2;
                                                            if (Byte.parseByte(itemTime.get(1).toString()) == 2) {
                                                                obj2 = new ItemTime(Short.parseShort(itemTime.get(0).toString()), (int) (Integer.parseInt(itemTime.get(2).toString()) - (int)(System.currentTimeMillis() / 1000L)), Byte.parseByte(itemTime.get(1).toString()), Integer.parseInt(itemTime.get(3).toString()));
                                                            } else {
                                                                obj2 = new ItemTime(Short.parseShort(itemTime.get(0).toString()), Integer.parseInt(itemTime.get(2).toString()), Byte.parseByte(itemTime.get(1).toString()), Integer.parseInt(itemTime.get(3).toString()));
                                                            }
                                                            if (obj2.damage == -9999) {
                                                                obj2.item = Item.parseItem(itemTime.get(4).toString());
                                                            }
                                                            newChar.wit.add(obj2);
                                                        }

                                                        newChar.cStamina = red2.getShort("cStamina");
                                                        newChar.cMaxStamina = red2.getShort("cMaxStamina");

                                                        JSONArray speacialSkill = (JSONArray) JSONValue.parseWithException(red2.getString("cspeacialSkill"));
                                                        newChar.cspeacialSkill = Byte.parseByte(speacialSkill.get(0).toString());
                                                        newChar.paramSpeacialSkill = Integer.parseInt(speacialSkill.get(1).toString());
                                                        newChar.ncoinSpeacialSkill = Integer.parseInt(speacialSkill.get(2).toString());

                                                        newChar.setClan(red2.getInt("clanId"));
                                                        if (newChar.clan == null) {
                                                            Obj obj = Obj.gI(newChar.cName);
                                                            if (obj.myChar != null && obj.myChar.clan != null) {
                                                                newChar.setClan(obj.myChar.clan.ID);
                                                            }
                                                        }

                                                        newChar.securityCode = red2.getInt("securityCode");
                                                        if (newChar.securityCode != -1) {
                                                            newChar.isSecurity = true;
                                                        }
                                                        newChar.timeSecurity = red2.getLong("timeSecurity");
                                                        //===JSONArray items===//
                                                        JSONArray items = (JSONArray) JSONValue.parseWithException(red2.getString("items"));
                                                        for (int i = 0; i < items.size(); i++) {
                                                            Item item6 = Item.parseItem(items.get(i).toString());
                                                            if (item6 != null) {
                                                                newChar.items.add(item6);
                                                            }
                                                        }
                                                        newChar.lastTime = red2.getLong("lastTime");
                                                        newChar.clanPoint = red2.getInt("clanPoint");
                                                        newChar.pointEvent = red2.getInt("pointEvent");
                                                        //===JSONArray radas===//
                                                        JSONArray radas = (JSONArray) JSONValue.parseWithException(red2.getString("radas"));
                                                        for (int i = 0; i < radas.size(); i++) {
                                                            JSONArray rada = (JSONArray) radas.get(i);
                                                            Rada r = new Rada(Short.parseShort(rada.get(0).toString()), Byte.parseByte(rada.get(1).toString()), Byte.parseByte(rada.get(2).toString()));
                                                            r.isUse = Boolean.parseBoolean(rada.get(3).toString());
                                                            newChar.radas.add(r);
                                                        }
                                                        newChar.totalGold = red2.getInt("totalGold");
                                                        newChar.isCan = red2.getBoolean("isCan");
                                                        newChar.yesterday = red2.getLong("yesterday");
                                                        newChar.timeReceiveNamek = red2.getLong("timeReceiveNamek");
                                                        newChar.pointVip = red2.getInt("pointVip");
                                                        newChar.maxXu = red2.getLong("maxXu");
                                                    }

                                                    //Vat pham no ra\\
                                                    {
                                                        ResultSet red3 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_DUAHAUS_FORMAT, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red3.first();
                                                        JSONArray duahaus = (JSONArray) JSONValue.parseWithException(red3.getString(2));
                                                        for (int i = 0; i < duahaus.size(); i++) {
                                                            JSONArray dua = (JSONArray) duahaus.get(i);
                                                            DuaHau r = new DuaHau();
                                                            r.id = Short.parseShort(dua.get(0).toString());
                                                            JSONArray duahau = (JSONArray) dua.get(1);
                                                            r.duahau = new int[duahau.size()];
                                                            int num = 0;
                                                            while(num < duahau.size()) {
                                                                r.duahau[num] = Integer.parseInt(duahau.get(num).toString());
                                                                num++;
                                                            }
                                                            r.duaHauIndex = Integer.parseInt(dua.get(2).toString());
                                                            r.last = Integer.parseInt(dua.get(3).toString());
                                                            r.second = Integer.parseInt(dua.get(4).toString());
                                                            newChar.duahaus.add(r);
                                                        }
                                                    }

                                                    //Hanh trang

                                                    {
                                                        ResultSet red4 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_ARRITEMBAGS, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red4.first();
                                                        newChar.arrItemBag = new Item[newChar.bagcount = red4.getByte(1)];
                                                        JSONArray arrItemBag = (JSONArray) JSONValue.parseWithException(red4.getString(2));
                                                        for (int i = 0; i < arrItemBag.size(); i++) {
                                                            Item item1 = Item.parseItem(arrItemBag.get(i).toString());
                                                            if (item1 != null && !item1.isClear()) {
                                                                CaiTrang.gI().setPartTemp(item1);
                                                                item1.typeUI = 3;
                                                                newChar.arrItemBag[item1.indexUI] = item1;
                                                            }
                                                        }
                                                    }

                                                    //Ruong 

                                                    {
                                                        ResultSet red5 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_ARRITEMBOXS, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red5.first();
                                                        newChar.arrItemBox = new Item[newChar.boxcount = red5.getByte(1)];
                                                        JSONArray arrItemBox = (JSONArray) JSONValue.parseWithException(red5.getString(2));
                                                        for (int i = 0; i < arrItemBox.size(); i++) {
                                                            Item item2 = Item.parseItem(arrItemBox.get(i).toString());
                                                            if (item2 != null && !item2.isClear()) {
                                                                CaiTrang.gI().setPartTemp(item2);
                                                                newChar.arrItemBox[item2.indexUI] = item2;
                                                            }
                                                        }
                                                    }

                                                    //Ruong phu

                                                    {
                                                        ResultSet red8 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_ARRITEMMORES, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red8.first();
                                                        JSONArray arrItemMore = (JSONArray) JSONValue.parseWithException(red8.getString(1));
                                                        for (int i = 0; i < arrItemMore.size(); i++) {
                                                            Item item4 = Item.parseItem(arrItemMore.get(i).toString());
                                                            if (item4 != null) {
                                                                CaiTrang.gI().setPartTemp(item4);
                                                                if (item4.typeUI == 7) {
                                                                    newChar.arrItemMore2.add(item4);
                                                                } else {
                                                                    newChar.arrItemMore.add(item4);
                                                                }
                                                            }
                                                        }
                                                    }

                                                    //Cay dau than

                                                    {
                                                        ResultSet red7 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_MAGICTREES, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red7.first();
                                                        newChar.magicTree_level = red7.getByte(1);
                                                        newChar.magicTree_currPeas = red7.getShort(2);
                                                        newChar.magicTree_miliseconds = red7.getLong(3);
                                                        newChar.magicTree_isUpdate = red7.getBoolean(4);
                                                    }

                                                    //Ban be

                                                    {
                                                        ResultSet red9 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_ARRFRIENDS, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red9.first();
                                                        JSONArray arrFriend = (JSONArray) JSONValue.parseWithException(red9.getString(1));
                                                        for (int i = 0; i < arrFriend.size(); i++) {
                                                            JSONArray jf = (JSONArray) arrFriend.get(i);
                                                            Friend f = new Friend();
                                                            f.playerId = Integer.parseInt(jf.get(0).toString());
                                                            f.head = Short.parseShort(jf.get(1).toString());
                                                            f.headICON = Short.parseShort(jf.get(2).toString());
                                                            f.body = Short.parseShort(jf.get(3).toString());
                                                            f.leg = Short.parseShort(jf.get(4).toString());
                                                            f.bag = Short.parseShort(jf.get(5).toString());
                                                            f.name = jf.get(6).toString();
                                                            f.power = Long.parseLong(jf.get(7).toString());
                                                            newChar.arrFriend.add(f);
                                                        }
                                                    }

                                                    //Bua chu

                                                    {
                                                        ResultSet red10 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_ARRAMUS, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red10.first();
                                                        JSONArray arrAmu = (JSONArray) JSONValue.parseWithException(red10.getString(1));
                                                        for (int i = 0; i < arrAmu.size(); i++) {
                                                            JSONArray amu = (JSONArray) arrAmu.get(i);
                                                            newChar.setAmu(Short.parseShort(amu.get(0).toString()), (int) (Integer.parseInt(amu.get(1).toString()) - (System.currentTimeMillis() / 1000)));
                                                        }
                                                    }

                                                    //De tu

                                                    {
                                                        ResultSet red5 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_PETZS_FORMAT, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red5.first();
                                                        //De tu || Pet
                                                        if (red5.getBoolean(2)) {
                                                            Char petz = new Char();
                                                            petz.charID = -newChar.charID;
                                                            petz.me = false;
                                                            newChar.myPet = petz;

                                                            petz.cName = red5.getString(3);
                                                            petz.headDefault = red5.getShort(4);
                                                            petz.bodyDefault = red5.getShort(5);
                                                            petz.legDefault = red5.getShort(6);
                                                            petz.cPower = red5.getLong(7);
                                                            petz.cPowerLimit = red5.getByte(8);
                                                            petz.cgender = red5.getByte(9);
                                                            petz.nClassId = red5.getByte(10);
                                                            petz.cHPGoc = red5.getInt(11);
                                                            petz.cMPGoc = red5.getInt(12);
                                                            petz.cDamGoc = red5.getInt(13);
                                                            petz.cDefGoc = red5.getInt(14);
                                                            petz.cCriticalGoc = red5.getInt(15);
                                                            petz.cTiemNang = red5.getLong(16);
                                                            petz.petStatus = red5.getByte(17);
                                                            petz.cHP = red5.getInt(18);
                                                            petz.cMP = red5.getInt(19);
                                                            petz.cStamina = red5.getShort(20);
                                                            petz.cMaxStamina = red5.getShort(21);
                                                            petz.timeHS = red5.getInt(22);
                                                            petz.timeHopThe = red5.getInt(23);
                                                            petz.isBaby = red5.getBoolean(24);
                                                            petz.isHopThe = red5.getByte(25);
                                                            petz.arrItemBag = new Item[20];
                                                            petz.arrItemBox = new Item[20];

                                                            //===JSONArray arrItemBody===//
                                                            JSONArray  arrItemBody2 = (JSONArray) JSONValue.parseWithException(red5.getString(26));
                                                            petz.arrItemBody = new Item[Char.MAXBODY_PET];
                                                            for (int i = 0; i < arrItemBody2.size(); i++) {
                                                                Item item4 = Item.parseItem(arrItemBody2.get(i).toString());
                                                                if (item4 != null &&  !item4.isClear()) {
                                                                    CaiTrang.gI().setPartTemp(item4);
                                                                    item4.typeUI = 5;
                                                                    petz.arrItemBody[item4.indexUI] = item4;
                                                                }
                                                            }

                                                            //===JSONArray SKILLS===//
                                                            JSONArray jarr = (JSONArray) (JSONArray) JSONValue.parseWithException(red5.getString("skills"));
                                                            for (int i = 0; i < jarr.size(); i++) {
                                                                JSONArray jarr2 = (JSONArray) jarr.get(i);
                                                                Skill skill = Skill.arrSkill[Integer.parseInt(jarr2.get(0).toString())].clone();
                                                                skill.lastTimeUseThisSkill = Long.parseLong(jarr2.get(1).toString());
                                                                if (skill.template.type == 4) {
                                                                    skill.curExp = Short.parseShort(jarr2.get(2).toString());
                                                                }
                                                                petz.skills.add(skill);
                                                            }
                                                            petz.isMabu = red5.getByte(28);
                                                            if (petz.cHP <= 0) {
                                                                petz.isDie = true;
                                                            }
                                                            //Check xiu
                                                            if (petz.isHopThe == 1 && !newChar.isExistItem(3790) && !newChar.isExistItem(3901)) {
                                                                petz.isHopThe = 0;
                                                            }
                                                            petz.myChar = newChar;
                                                            petz.updateAll();
                                                        }
                                                    }

                                                    //Nhiem vu\\

                                                    {
                                                        ResultSet red6 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_ARRTASKS_FORMAT, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red6.first();
                                                        JSONArray arrTask = (JSONArray) JSONValue.parseWithException(red6.getString(1));
                                                        for (int i = 0; i < arrTask.size(); i++) {
                                                            JSONArray task = (JSONArray) arrTask.get(i);
                                                            ArchivementTask t = new ArchivementTask();
                                                            t.id = Short.parseShort(task.get(0).toString());
                                                            t.count = Long.parseLong(task.get(1).toString());
                                                            t.isFinish = Boolean.parseBoolean(task.get(2).toString());
                                                            t.isRecieve = Boolean.parseBoolean(task.get(3).toString());
                                                            newChar.archivements.add(t);
                                                        }
                                                    }

                                                    //textTime

                                                    {

                                                        ResultSet red12 = mySQL3.getConnection().prepareStatement(String.format(mResources.QUERY_SELECT_ARRTEXTTIME, playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        red12.first();
                                                        JSONArray textTimes = (JSONArray) JSONValue.parseWithException(red12.getString(1));
                                                        for (int i = 0; i < textTimes.size(); i++) {
                                                            JSONArray textTime = (JSONArray) textTimes.get(i);
                                                            ItemTime obj3;
                                                            if (Byte.parseByte(textTime.get(2).toString()) == 2) {
                                                                obj3 = new ItemTime(Byte.parseByte(textTime.get(0).toString()), textTime.get(1).toString(), (int) (Integer.parseInt(textTime.get(3).toString()) - (int)(System.currentTimeMillis() / 1000L)), Byte.parseByte(textTime.get(2).toString()), Integer.parseInt(textTime.get(4).toString()));
                                                            } else {
                                                                obj3 = new ItemTime(Byte.parseByte(textTime.get(0).toString()), textTime.get(1).toString(), Integer.parseInt(textTime.get(3).toString()), Byte.parseByte(textTime.get(2).toString()), Integer.parseInt(textTime.get(4).toString()));
                                                            }
                                                            if (obj3.damage == -9999) {
                                                                obj3.item = Item.parseItem(textTime.get(5).toString());
                                                            }
                                                            newChar.wtxt.add(obj3);
                                                        }
                                                    }

                                                    //EffChar

                                                    {

                                                        ResultSet res = mySQL4.getConnection().prepareStatement(String.format("SELECT `arrEffect` FROM `effchar` WHERE `playerId` = '%d' LIMIT 1;", playerId), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
                                                        res.first();
                                                        JSONArray effChar = (JSONArray) JSONValue.parseWithException(res.getString(1));
                                                        for (int i = 0; i < effChar.size(); i++) {
                                                            EffChar eff = EffChar.parseItem(effChar.get(i).toString());
                                                            eff.isSave = true;
                                                            newChar.aEffChar.add(eff);
                                                        }
                                                    }
                                                    newChar.updateAll();
                                                    //GHI
                                                    newChar.session = this.session;
                                                    newChar.myObj().myChar = newChar;
                                                    newChar.myObj().petition = true;
                                                    this.session.myChar = newChar;
                                                    Server.gI().addConn(this.session, newChar.charID, newChar.cName, newChar.playerId);
                                                }
                                                this.session.isBackup = true;
                                                this.session.isLogin = true;
                                            }
                                        }
                                    } else {
                                        this.session.service.startOKDlg(mResources.LOGIN_USER_PASS);
                                    }
                                } finally {
                                    mySQL1.close();
                                    mySQL2.close();
                                    mySQL3.close();
                                    mySQL4.close();
                                }
                            } catch (SQLException | ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        //============================
                        if (this.session.isLogin) {
                            this.session.service.updateVersion();
                            this.session.service.smallImageVerion(SmallImage.newSmallVersion.get((int)this.session.zoomLevel));
                            this.session.service.bgItemVersion(BgItem.newSmallVersion.get((int)this.session.zoomLevel));
                        } else {
                            this.session.loginFaid++;
                        }
                    }
                    break;
                case 2:
                    this.session.typeClient = msg.reader().readByte();
                    this.session.zoomLevel = msg.reader().readByte();
                    this.session.b = msg.reader().readBoolean();
                    this.session.w = msg.reader().readInt();
                    this.session.h = msg.reader().readInt();
                    this.session.isQwerty = msg.reader().readBoolean();
                    this.session.isTouch = msg.reader().readBoolean();
                    String str = msg.reader().readUTF();
                    this.session.platform = str;
                    this.session.version = str;
                    Util.gI().logln("typeClient="+this.session.typeClient+" zoonLevel="+this.session.zoomLevel+" "+str+" version="+this.session.getIntVersion());
                    
                    if (this.session.zoomLevel >= 1 && this.session.zoomLevel <= 4) {
                        this.session.isSetClient = true;
                        this.session.service.getImageSource2(955, 9);
                        this.session.service.getVersionImageSource();
                        this.session.service.linkDefault();
                    } else {
                        this.session.disconnect();
                    }
                    break;
                    
                default:
                {
                    this.session.myCharz().addInfo1(String.format(mResources.SAP_CAP_NHAT, msg.getCommand()));
                    break;
                }
            }
        } catch (IOException e) {
            if (Util.gI().debug) {
                e.printStackTrace();
            }
            this.session.disconnect();
        }
    }
    
    private void messageNotMap(Message msg) {
        try {
            byte b = msg.reader().readByte();
            Util.gI().logln("messageNotMap "+b);
            switch (b) {
                case 2:
                    if (this.session.isLogin && this.session.myCharz() == null) {
                        //================
                        String name = msg.reader().readUTF();
                        byte gender = msg.reader().readByte();
                        byte hair = msg.reader().readByte();
                        name = name.toLowerCase();
                        if (!Util.gI().CheckString(name, "^[a-zA-Z0-9]+$") || name.length() < 5 || name.length() > 10) {
                            this.session.service.startOKDlg(mResources.CREATE_PLAYER_FAILD1);
                        } else {
                            try {
                                MySQL mySQL1 = MySQL.createData6();
                                MySQL mySQL2 = MySQL.createData3();
                                MySQL mySQL3 = MySQL.createData7();
                                try {
                                    if (Server.gI().isHavecName(name)) {
                                        this.session.service.startOKDlg(mResources.CRETAE_CHAR_HAD);
                                    } else {
                                        Server.gI().addcName(name);
                                        short[] arrItemBody = null;
                                        byte ctaskId = 0;
                                        byte ctaskIndex = 0;
                                        long cPower = 0;
                                        byte cPowerLimit = 0;
                                        int mapTemplateId = 1;
                                        short sendX = 400;
                                        short sendY = 400;
                                        byte nClassId = -1;
                                        int xu = 20000;
                                        int luong = 0;
                                        int luongKhoa = 20;
                                        int cHPGoc = 0;
                                        int cMPGoc = 0;
                                        int cDamGoc = 0;
                                        int cDefGoc = 0;
                                        int cCriticalGoc = 0;
                                        long cTiemNang = 0;
                                        int bagcount = 20;
                                        int boxcount = 20;
                                        long last = System.currentTimeMillis();

                                        if (gender == 0) {
                                            //SETUP MAP
                                            mapTemplateId = 39;
                                            sendX = 180;
                                            sendY = 384;
                                            //SETUP INFO
                                            cPower = 1200;
                                            nClassId = 0;
                                            cHPGoc = 200;
                                            cMPGoc = 100;
                                            cDamGoc = 12;
                                            cTiemNang = 1200;
                                            arrItemBody = new short[]{0, 6};
                                        } else {
                                            if (gender == 1) {
                                                //SETUP MAP
                                                mapTemplateId = 40;
                                                sendX = 180;
                                                sendY = 384;
                                                //SETUP INFO
                                                cPower = 1200;
                                                nClassId = 1;
                                                cHPGoc = 100;
                                                cMPGoc = 200;
                                                cDamGoc = 12;
                                                cTiemNang = 1200;
                                                arrItemBody = new short[]{1, 7};
                                            } else {
                                                if (gender == 2) {
                                                    //SETUP MAP
                                                    mapTemplateId = 41;
                                                    sendX = 180;
                                                    sendY = 384;
                                                    //SETUP INFO
                                                    cPower = 1200;
                                                    nClassId = 2;
                                                    cHPGoc = 100;
                                                    cMPGoc = 100;
                                                    cDamGoc = 15;
                                                    cTiemNang = 1200;
                                                    arrItemBody = new short[]{2, 8};
                                                }
                                            }
                                        }
                                        if (nClassId != -1) {
                                            mySQL1.getConnection().setAutoCommit(false);
                                            mySQL2.getConnection().setAutoCommit(false);
                                            mySQL3.getConnection().setAutoCommit(false);
                                            try {
                                                //Insert options
                                                SetSQL strSQL = new SetSQL("INSERT INTO `options` SET %;");
                                                strSQL.addSet("cName", Util.gI().stringSQL(name));
                                                strSQL.addSet("cgender", gender);
                                                strSQL.addSet("head", hair);
                                                strSQL.addSet("ctaskId", ctaskId);
                                                strSQL.addSet("cPower", cPower);
                                                strSQL.addSet("cPowerLimit", cPowerLimit);
                                                strSQL.addSet("mapTemplateId", mapTemplateId);
                                                strSQL.addSet("cx", sendX);
                                                strSQL.addSet("cy", sendY);
                                                strSQL.addSet("nClassId", nClassId);
                                                strSQL.addSet("xu", xu);
                                                strSQL.addSet("luong", luong);
                                                strSQL.addSet("luongKhoa", luongKhoa);
                                                strSQL.addSet("cHPGoc", cHPGoc);
                                                strSQL.addSet("cMPGoc", cMPGoc);
                                                strSQL.addSet("cHP", 1);
                                                strSQL.addSet("cMP", 1);
                                                strSQL.addSet("cDamGoc", cDamGoc);
                                                strSQL.addSet("cDefGoc", cDefGoc);
                                                strSQL.addSet("cCriticalGoc", cCriticalGoc);
                                                strSQL.addSet("cTiemNang", cTiemNang);
                                                strSQL.addSet("arrItemBody", "[]");
                                                strSQL.addSet("cStamina", 10000);
                                                strSQL.addSet("cMaxStamina", 10000);
                                                strSQL.addSet("items", "[]");
                                                strSQL.addSet("lastTime", last);
                                                PreparedStatement p = mySQL1.getConnection().prepareStatement(strSQL.toSQL(), Statement.RETURN_GENERATED_KEYS);
                                                p.executeUpdate();
                                                ResultSet red = p.getGeneratedKeys();
                                                red.first();
                                                //Insert DuaHau
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_DUAHAUS, red.getInt(1))).executeUpdate();
                                                //Insert arrItemBag
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_ARRITEMBAGS, red.getInt(1))).executeUpdate();
                                                //Insert arrItemBox
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_ARRITEMBOXS, red.getInt(1))).executeUpdate();
                                                //Insert arrItemMore
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_ARRITEMMORES, red.getInt(1))).executeUpdate();
                                                //Insert magicTree
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_MAGICTREES, red.getInt(1))).executeUpdate();
                                                //Insert arrFriend
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_ARRFRIENDS, red.getInt(1))).executeUpdate();
                                                //Insert arrItemBody2
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_ARRAMUS, red.getInt(1))).executeUpdate();
                                                //Insert petz
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_PETZS, red.getInt(1))).executeUpdate();
                                                //Insert arrTask
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_ARRTASKS, red.getInt(1))).executeUpdate();
                                                //Insert arrTextTime
                                                mySQL2.getConnection().prepareStatement(String.format(mResources.INSERT_ARRTEXTTIME, red.getInt(1))).executeUpdate();
                                                //Insert EffChar
                                                mySQL3.getConnection().prepareStatement(String.format("INSERT INTO `effchar` (`playerId`, `arrEffect`) VALUES ('%d', '[]');", red.getInt(1)), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeUpdate();
                                                red.first();
                                                {
                                                    Char newChar = new Char();
                                                    newChar.me = true;
                                                    newChar.isPlayer = true;
                                                    newChar.menuBoard = new MenuBoard(this.session);
                                                    newChar.menuBoard2 = new MenuBoard2(this.session);
                                                    newChar.clientInput = new ClientInput(this.session);
                                                    newChar.playerId = red.getInt(1);
                                                    newChar.charID = Char.getNewCharID();
                                                    newChar.cName = name;
                                                    newChar.cgender = gender;
                                                    newChar.headDefault = hair;
                                                    newChar.ctaskId = ctaskId;
                                                    newChar.ctaskIndex = ctaskIndex;
                                                    newChar.cPower = cPower;
                                                    newChar.cPowerLimit = cPowerLimit;
                                                    newChar.mapTemplateId = mapTemplateId;
                                                    newChar.cx = sendX;
                                                    newChar.cy = sendY;
                                                    newChar.nClassId = nClassId;
                                                    newChar.xu = xu;
                                                    newChar.luong = luong;
                                                    newChar.luongKhoa = luongKhoa;
                                                    newChar.cHPGoc = cHPGoc;
                                                    newChar.cMPGoc = cMPGoc;
                                                    newChar.cDamGoc = cDamGoc;
                                                    newChar.cDefGoc = cDefGoc;
                                                    newChar.cCriticalGoc = cCriticalGoc;
                                                    newChar.cTiemNang = cTiemNang;
                                                    newChar.skills.add(GameData.nClasss[nClassId].skillTemplates[0].getSkill(1).clone());
                                                    newChar.arrItemBody = new Item[10];
                                                    newChar.arrItemBag = new Item[newChar.bagcount = bagcount];
                                                    newChar.arrItemBox = new Item[newChar.boxcount = boxcount];

                                                    //ItemBody
                                                    newChar.addItemBody(new Item(arrItemBody[0], false, 1, ItemOption.getOption(arrItemBody[0], 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), 0);
                                                    newChar.addItemBody(new Item(arrItemBody[1], false, 1, ItemOption.getOption(arrItemBody[1], 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), 1);

                                                    //ItemBox
                                                    newChar.addItemBox(new Item(12, false, 1, ItemOption.getOption(12, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY), 0);

                                                    //MagicTRee
                                                    newChar.magicTree_level = 1;
                                                    newChar.magicTree_currPeas = 5;
                                                    newChar.magicTree_miliseconds = System.currentTimeMillis();
                                                    newChar.magicTree_isUpdate = false;
                                                    newChar.cStamina = newChar.cMaxStamina = 10000;
                                                    newChar.lastTime = last;
                                                    newChar.yesterday = System.currentTimeMillis();
                                                    newChar.timeReceiveNamek = 0;
                                                    newChar.maxXu = 20000000000L;
                                                    //Update ALL
                                                    newChar.updateAll();
                                                    newChar.cHP = newChar.cHPFull;
                                                    newChar.cMP = newChar.cMPFull;
                                                    if (!newChar.skills.isEmpty()) {
                                                        newChar.mySkill = newChar.skills.get(0);
                                                        newChar.KSkill.add(newChar.mySkill.template.id);
                                                        newChar.OSkill.add(newChar.mySkill.template.id);
                                                        newChar.CSkill.add(newChar.mySkill.template.id);
                                                    }

                                                    //GHI
                                                    newChar.session = this.session;
                                                    newChar.myObj().myChar = newChar;
                                                    newChar.myObj().petition = true;
                                                    this.session.myChar = newChar;
                                                    Server.gI().addConn(this.session, newChar.charID, newChar.cName, newChar.playerId);
                                                    mySQL1.getConnection().commit();
                                                    mySQL2.getConnection().commit();
                                                    mySQL3.getConnection().commit();
                                                    //Qua tan thu
                                                    //newChar.giftTanThu();
                                                    //BACKUP
                                                    this.session.isSave = true;
                                                    this.session.myCharz().InGame();
                                                    this.session.myCharz().giftTanThu();
                                                }
                                            } catch (SQLException e) {
                                                mySQL1.getConnection().rollback();
                                                mySQL2.getConnection().rollback();
                                                mySQL3.getConnection().rollback();
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                } finally {
                                    mySQL1.close();
                                    mySQL2.close();
                                    mySQL3.close();
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                        //================
                    }
                    break;
                case 6:
                    if (this.session.isLogin) {
                        this.session.service.updateMap();
                    }
                    break;
                case 7:
                    if (this.session.isLogin) {
                        this.session.service.updateSkill();
                    }
                    break;
                case 8:
                    if (this.session.isLogin) {
                        this.session.service.updateItem1();
                        int max = ItemTemplate.itemTemplates.size();
                        if (max > 800) {
                            this.session.service.updateItem2(800);
                            this.session.service.updateItem3(800, max);
                        } else {
                            this.session.service.updateItem2(max);
                        }
                        this.session.service.updateFHead();
                    }
                    break;
                case 10:
                    if (this.session.myCharz() != null && this.session.myCharz().zoneMap != null) {
                        this.session.myCharz().zoneMap.loadMapInfo(this.session.myCharz(), msg.reader().readUnsignedByte());
                    }
                    break;
                case 13:
                    if (this.session.isLogin) {
                        this.session.service.getBgTemplateLayer();
                        if (this.session.myCharz() == null) {
                            this.session.service.initSelectChar();
                        } else {
                            this.session.myCharz().InGame();
                        }
                    }
                    Util.gI().logln("client ok");
                    break;
                    
                default:
                {
                    this.session.myCharz().addInfo1(String.format(mResources.SAP_CAP_NHAT, msg.getCommand()));
                    break;
                }
            }
        } catch (IOException e) {
            if (Util.gI().debug) {
                e.printStackTrace();
            }
            this.session.disconnect();
        }
    }

    @Override
    public void onConnectOK() {
    }

    @Override
    public void onConnectionFail() {
    }

    @Override
    public void onDisconnected() {
    }
}
