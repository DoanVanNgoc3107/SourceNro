package dragon.server;

import dragon.t.Amu;
import dragon.t.Achievement;
import dragon.t.AchievementTask;
import dragon.t.Arrow;
import dragon.t.BgItem;
import dragon.t.Char;
import dragon.t.Clan;
import dragon.t.ClanImage;
import dragon.t.ClanMember;
import dragon.t.ClanMessage;
import dragon.t.DartInfo;
import dragon.t.EffectCharPaint;
import dragon.t.EffectData;
import dragon.t.Flag;
import dragon.t.Friend;
import dragon.t.GameData;
import dragon.t.GameInfo;
import dragon.t.ImageSource;
import dragon.t.ImgByName;
import dragon.t.Item;
import dragon.t.ItemKyGui;
import dragon.t.ItemMap;
import dragon.t.ItemOption;
import dragon.t.ItemTemplate;
import dragon.t.LuckyRound;
import dragon.t.LuyenTap;
import dragon.t.MagicTree;
import dragon.t.Map;
import dragon.t.MapTemplate;
import dragon.t.MenuInfo;
import dragon.t.MenuInfo2;
import dragon.t.Mob;
import dragon.t.Npc;
import dragon.t.Panel;
import dragon.t.Part;
import dragon.t.PlayerData;
import dragon.t.RadaTemplate;
import dragon.t.Rank;
import dragon.t.SaleItemNew;
import dragon.t.Skill;
import dragon.t.SkillPaint;
import dragon.t.SmallImage;
import dragon.t.SuperRank;
import dragon.t.Task;
import dragon.t.TaskDanhHieu;
import dragon.t.Transport;
import dragon.t.Util;
import dragon.t.Waypoint;
import dragon.t.ZoneMap;
import io.Message;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Service {

    public Service(Session_ME session) {
        this.session = session;
    }

    private final Session_ME session;

    private Message messageSubCommand(int command) throws Exception {
        Message message = new Message(-30);
        message.writer().writeByte(command);
        return message;
    }

    private Message messageNotLogin(int command) throws Exception {
        Message message = new Message(-29);
        message.writer().writeByte(command);
        return message;
    }

    private Message messageNotMap(int command) throws Exception {
        Message message = new Message(-28);
        message.writer().writeByte(command);
        return message;
    }

    protected void linkDefault() {
        Message msg = null;
        try {
            msg = messageNotLogin((byte) 2);
            msg.writer().writeUTF("Dev:127.0.0.1:14445:0,Local:127.0.0.1:14445:0,0,9");
            msg.writer().writeByte(1);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void updateVersion() {
        Message msg = null;
        try {
            msg = messageNotMap((byte) 4);
            msg.writer().writeByte(Dragon.vData);
            msg.writer().writeByte(Dragon.vMap);
            msg.writer().writeByte(Dragon.vSkill);
            msg.writer().writeByte(Dragon.vItem);
            msg.writer().writeByte(0);
            msg.writer().writeByte(GameData.exps.length);
            for (byte i = 0; i < GameData.exps.length; i++) {
                msg.writer().writeLong(GameData.exps[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void getVersionImageSource() {
        Message msg = null;
        try {
            msg = new Message(-74);
            msg.writer().writeByte(0);
            msg.writer().writeInt(ImageSource.hVersion.get(this.session.zoomLevel));
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void getnBigImageSource(int nBig) {
        Message msg = null;
        try {
            msg = new Message(-74);
            msg.writer().writeByte(1);
            msg.writer().writeShort(nBig);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void getImageSource(byte[] data, String original) {
        Message msg = null;
        try {
            msg = new Message(-74);
            msg.writer().writeByte(2);
            msg.writer().writeUTF(original);
            msg.writer().writeInt(data.length);
            msg.writer().write(data);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void lastVersionImageSource() {
        Message msg = null;
        try {
            msg = new Message(-74);
            msg.writer().writeByte(3);
            msg.writer().writeInt(ImageSource.hVersion.get(this.session.zoomLevel));
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void startOKDlg(String str) {
        Message msg = null;
        try {
            msg = new Message(-26);
            msg.writer().writeUTF(str);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void login2(String str) {
        Message msg = null;
        try {
            msg = new Message(-101);
            msg.writer().writeUTF(str);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void getImageSource2(int x, int y) {
        Message msg = null;
        try {
            msg = new Message(-111);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void updateData() {
        Message msg = null;
        try {
            msg = new Message(-87);
            msg.writer().writeByte(Dragon.vData);
            writeDart(msg);
            writeArrow(msg);
            writeEffect(msg);
            writeImage(msg);
            writePart(msg);
            writeSkill(msg);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void updateMap() {
        Message msg = null;
        try {
            msg = messageNotMap((byte) 6);
            msg.writer().writeByte(Dragon.vMap);
            msg.writer().writeByte(ZoneMap.mapNames.length);
            for (short i = 0; i < ZoneMap.mapNames.length; i++) {
                msg.writer().writeUTF(ZoneMap.mapNames[i]);
            }
            msg.writer().writeByte(Npc.arrNpcTemplate.length);
            for (byte i = 0; i < Npc.arrNpcTemplate.length; i++) {
                msg.writer().writeUTF(Npc.arrNpcTemplate[i].name);
                msg.writer().writeShort(Npc.arrNpcTemplate[i].headId);
                msg.writer().writeShort(Npc.arrNpcTemplate[i].bodyId);
                msg.writer().writeShort(Npc.arrNpcTemplate[i].legId);
                msg.writer().writeByte(Npc.arrNpcTemplate[i].menu.length);
                for (byte j = 0; j < Npc.arrNpcTemplate[i].menu.length; j++) {
                    msg.writer().writeByte(Npc.arrNpcTemplate[i].menu[j].length);
                    for (byte k = 0; k < Npc.arrNpcTemplate[i].menu[j].length; k++) {
                        msg.writer().writeUTF(Npc.arrNpcTemplate[i].menu[j][k]);
                    }
                }
            }
            msg.writer().writeByte(Mob.arrMobTemplate.length);
            for (byte i = 0; i < Mob.arrMobTemplate.length; i++) {
                msg.writer().writeByte(Mob.arrMobTemplate[i].type);
                msg.writer().writeUTF(Mob.arrMobTemplate[i].name);
                msg.writer().writeInt(Mob.arrMobTemplate[i].hp);
                msg.writer().writeByte(Mob.arrMobTemplate[i].rangeMove);
                msg.writer().writeByte(Mob.arrMobTemplate[i].speed);
                msg.writer().writeByte(Mob.arrMobTemplate[i].dartType);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void updateSkill() {
        Message msg = null;
        try {
            msg = this.messageNotMap((byte) 7);
            msg.writer().writeByte(Dragon.vSkill);
            msg.writer().writeByte(GameData.sOptionTemplates.length);
            for (byte i = 0; i < GameData.sOptionTemplates.length; i++) {
                msg.writer().writeUTF(GameData.sOptionTemplates[i].name);
            }
            msg.writer().writeByte(GameData.nClasss.length);
            for (byte i = 0; i < GameData.nClasss.length; i++) {
                msg.writer().writeUTF(GameData.nClasss[i].name);
                msg.writer().writeByte(GameData.nClasss[i].skillTemplates.length);
                for (byte j = 0; j < GameData.nClasss[i].skillTemplates.length; j++) {
                    msg.writer().writeByte(GameData.nClasss[i].skillTemplates[j].id);
                    msg.writer().writeUTF(GameData.nClasss[i].skillTemplates[j].name);
                    msg.writer().writeByte(GameData.nClasss[i].skillTemplates[j].maxPoint);
                    msg.writer().writeByte(GameData.nClasss[i].skillTemplates[j].manaUseType);
                    msg.writer().writeByte(GameData.nClasss[i].skillTemplates[j].type);
                    msg.writer().writeShort(GameData.nClasss[i].skillTemplates[j].iconId);
                    msg.writer().writeUTF(GameData.nClasss[i].skillTemplates[j].damInfo);
                    msg.writer().writeUTF(GameData.nClasss[i].skillTemplates[j].description);
                    msg.writer().writeByte(GameData.nClasss[i].skillTemplates[j].skills.length);
                    for (byte k = 0; k < GameData.nClasss[i].skillTemplates[j].skills.length; k++) {
                        msg.writer().writeShort(GameData.nClasss[i].skillTemplates[j].skills[k].skillId);
                        msg.writer().writeByte(GameData.nClasss[i].skillTemplates[j].skills[k].point);
                        msg.writer().writeLong(GameData.nClasss[i].skillTemplates[j].skills[k].powRequire);
                        msg.writer().writeShort(GameData.nClasss[i].skillTemplates[j].skills[k].manaUse);
                        msg.writer().writeInt(GameData.nClasss[i].skillTemplates[j].skills[k].coolDown);
                        msg.writer().writeShort(GameData.nClasss[i].skillTemplates[j].skills[k].dx);
                        msg.writer().writeShort(GameData.nClasss[i].skillTemplates[j].skills[k].dy);
                        msg.writer().writeByte(GameData.nClasss[i].skillTemplates[j].skills[k].maxFight);
                        msg.writer().writeShort(GameData.nClasss[i].skillTemplates[j].skills[k].damage);
                        msg.writer().writeShort(GameData.nClasss[i].skillTemplates[j].skills[k].price);
                        msg.writer().writeUTF(GameData.nClasss[i].skillTemplates[j].skills[k].moreInfo);
                    }
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateItem1() {
        Message msg = null;
        try {
            msg = messageNotMap((byte) 8);
            msg.writer().writeByte(Dragon.vItem);
            msg.writer().writeByte(0);
            msg.writer().writeByte(GameData.iOptionTemplates.length);
            for (short i = 0; i < GameData.iOptionTemplates.length; i++) {
                msg.writer().writeUTF(GameData.iOptionTemplates[i].name);
                msg.writer().writeByte(GameData.iOptionTemplates[i].type);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateItem2(int max) {
        Message msg = null;
        try {
            msg = this.messageNotMap(8);
            msg.writer().writeByte(Dragon.vItem);
            msg.writer().writeByte(1);
            msg.writer().writeShort(max);
            for (int i = 0; i < max; i++) {
                msg.writer().writeByte(ItemTemplate.get((short) i).type);
                msg.writer().writeByte(ItemTemplate.get((short) i).gender);
                msg.writer().writeUTF(ItemTemplate.get((short) i).name);
                msg.writer().writeUTF(ItemTemplate.get((short) i).description);
                msg.writer().writeByte(ItemTemplate.get((short) i).level);
                msg.writer().writeInt(ItemTemplate.get((short) i).strRequire);
                msg.writer().writeShort(ItemTemplate.get((short) i).iconID);
                msg.writer().writeShort(ItemTemplate.get((short) i).part);
                msg.writer().writeBoolean(ItemTemplate.get((short) i).isUpToUp);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateItem3(int min, int max) {
        Message msg = null;
        try {
            msg = this.messageNotMap(8);
            msg.writer().writeByte(Dragon.vItem);
            msg.writer().writeByte(2);
            msg.writer().writeShort(min);
            msg.writer().writeShort(max);
            for (int i = min; i < max; i++) {
                msg.writer().writeByte(ItemTemplate.get((short) i).type);
                msg.writer().writeByte(ItemTemplate.get((short) i).gender);
                msg.writer().writeUTF(ItemTemplate.get((short) i).name);
                msg.writer().writeUTF(ItemTemplate.get((short) i).description);
                msg.writer().writeByte(ItemTemplate.get((short) i).level);
                msg.writer().writeInt(ItemTemplate.get((short) i).strRequire);
                msg.writer().writeShort(ItemTemplate.get((short) i).iconID);
                msg.writer().writeShort(ItemTemplate.get((short) i).part);
                msg.writer().writeBoolean(ItemTemplate.get((short) i).isUpToUp);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateItem3LechTeamobi(ItemTemplate it) {
        Message msg = null;
        try {
            msg = this.messageNotMap(8);
            msg.writer().writeByte(Dragon.vItem);
            msg.writer().writeByte(2);
            msg.writer().writeShort(it.id);
            msg.writer().writeShort(it.id + 2);

            msg.writer().writeByte(it.type);
            msg.writer().writeByte(it.gender);
            msg.writer().writeUTF(it.name);
            msg.writer().writeUTF(it.description);
            msg.writer().writeByte(it.level);
            msg.writer().writeInt(it.strRequire);
            msg.writer().writeShort(it.iconID);
            msg.writer().writeShort(it.part);
            msg.writer().writeBoolean(it.isUpToUp);

            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateFHead() {
        Message msg = null;
        try {
            msg = this.messageNotMap(8);
            msg.writer().writeByte(Dragon.vItem);
            msg.writer().writeByte(100);
            msg.writer().writeShort(GameData.Arr_Head_2Fr.length);
            for (int i = 0; i < GameData.Arr_Head_2Fr.length; i++) {
                msg.writer().writeByte(GameData.Arr_Head_2Fr[i].length);
                for (int j = 0; j < GameData.Arr_Head_2Fr[i].length; j++) {
                    msg.writer().writeShort(GameData.Arr_Head_2Fr[i][j]);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void smallImageVerion(byte[] newSmallVersion) {
        Message msg = null;
        try {
            msg = new Message(-77);
            msg.writer().writeShort(newSmallVersion.length);
            for (int i = 0; i < newSmallVersion.length; i++) {
                msg.writer().writeByte(newSmallVersion[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void bgItemVersion(byte[] newSmallVersion) {
        Message msg = null;
        try {
            msg = new Message(-93);
            msg.writer().writeShort(newSmallVersion.length);
            for (int i = 0; i < newSmallVersion.length; i++) {
                msg.writer().writeByte(newSmallVersion[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void getBgTemplate(int id) {
        if (!session.isLoad) {
            return;
        }
        byte barr[];
        try {
            barr = BgItem.images.get((byte) this.session.zoomLevel)[id];
        } catch (Exception e) {
            return;
        }
        Message msg = null;
        try {
            msg = new Message(-32);
            msg.writer().writeShort(id);
            msg.writer().writeInt(barr.length);
            msg.writer().write(barr);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getBgTemplateLayer() {
        Message msg = null;
        try {
            msg = new Message(-31);
            msg.writer().writeShort(BgItem.aItemBg.size());
            for (int i = 0; i < BgItem.aItemBg.size(); i++) {
                msg.writer().writeShort(BgItem.aItemBg.get(i).idImage);
                msg.writer().writeByte(BgItem.aItemBg.get(i).layer);
                msg.writer().writeShort(BgItem.aItemBg.get(i).dx);
                msg.writer().writeShort(BgItem.aItemBg.get(i).dy);
                msg.writer().writeByte(BgItem.aItemBg.get(i).tileX.length);
                for (int i2 = 0; i2 < BgItem.aItemBg.get(i).tileX.length; i++) {
                    msg.writer().writeByte(BgItem.aItemBg.get(i).tileX[i2]);
                    msg.writer().writeByte(BgItem.aItemBg.get(i).tileY[i2]);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void meLoadPoint() {
        Message msg = null;
        try {
            msg = new Message(-42);
            msg.writer().writeInt(this.session.myCharz().cHPGoc);// cHPGoc
            msg.writer().writeInt(this.session.myCharz().cMPGoc);// cMPGoc
            msg.writer().writeInt(this.session.myCharz().cDamGoc);// cDamGoc
            msg.writer().writeInt(this.session.myCharz().cHPFull);// cHPFull
            msg.writer().writeInt(this.session.myCharz().cMPFull);// cMPFull
            msg.writer().writeInt(this.session.myCharz().cHP);// cHP
            msg.writer().writeInt(this.session.myCharz().cMP);// cMP
            msg.writer().writeByte(this.session.myCharz().cspeedFull);// cspeed
            msg.writer().writeByte(this.session.myCharz().hpFrom1000TiemNang);// hpFrom1000TiemNang
            msg.writer().writeByte(this.session.myCharz().mpFrom1000TiemNang);// mpFrom1000TiemNang
            msg.writer().writeByte(this.session.myCharz().damFrom1000TiemNang);// damFrom1000TiemNang
            msg.writer().writeInt(this.session.myCharz().cDamFull);// cDamFull
            msg.writer().writeInt(this.session.myCharz().cDefull);// cDefull
            msg.writer().writeByte(this.session.myCharz().cCriticalFull);// cCriticalFull
            msg.writer().writeLong(this.session.myCharz().cTiemNang);// cTiemNang
            msg.writer().writeShort(this.session.myCharz().expForOneAdd);// expForOneAdd
            msg.writer().writeShort(this.session.myCharz().cDefGoc);// cDefGoc
            msg.writer().writeByte(this.session.myCharz().cCriticalGoc);// cCriticalGoc
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void initSelectChar() {
        Message msg = null;
        try {
            msg = new Message(2);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void clearTask() {
        Message msg = null;
        try {
            msg = new Message(-82);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void speacialSkill(int cgender, int cspearcialSkill, int paramSpearcialSkill) {
        Message msg = null;
        try {
            msg = new Message(112);
            msg.writer().writeByte(0);
            if (cspearcialSkill == -1) {
                msg.writer().writeShort(5223);
                msg.writer().writeUTF(Panel.gI().infoSpeacialSkillDefault);
            } else {
                msg.writer().writeShort(Panel.gI().imgSpeacialSkill[cgender][cspearcialSkill]);
                if (cgender == 0 && cspearcialSkill == 2) {
                    msg.writer()
                            .writeUTF(String.format(Panel.gI().infoSpeacialSkill[cgender][cspearcialSkill],
                                    String.format(Panel.gI().numP, paramSpearcialSkill),
                                    String.format(Panel.gI().numP, paramSpearcialSkill),
                                    String.format(Panel.gI().numTo2,
                                            Panel.gI().nextSpeacialSkill[cgender][cspearcialSkill][0],
                                            Panel.gI().nextSpeacialSkill[cgender][cspearcialSkill][1])));
                } else {
                    msg.writer()
                            .writeUTF(String.format(Panel.gI().infoSpeacialSkill[cgender][cspearcialSkill],
                                    String.format(Panel.gI().numP, paramSpearcialSkill),
                                    String.format(Panel.gI().numTo2,
                                            Panel.gI().nextSpeacialSkill[cgender][cspearcialSkill][0],
                                            Panel.gI().nextSpeacialSkill[cgender][cspearcialSkill][1])));
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void speacialSkill(int cgender) {
        Message msg = null;
        int i;
        int j;
        try {
            msg = new Message(112);
            msg.writer().writeByte(1);
            msg.writer().writeByte(Panel.gI().speacialTab.length);
            for (i = 0; i < Panel.gI().speacialTab.length; i++) {
                msg.writer().writeUTF(Panel.gI().speacialTab[i]);
                if (i == 0) {
                    msg.writer().writeByte(Panel.gI().imgSpeacialSkill[cgender].length);
                    for (j = 0; j < Panel.gI().imgSpeacialSkill[cgender].length; j++) {
                        msg.writer().writeShort(Panel.gI().imgSpeacialSkill[cgender][j]);
                        if (cgender == 0 && j == 2) {
                            msg.writer()
                                    .writeUTF(String.format(Panel.gI().infoSpeacialSkill[cgender][j],
                                            String.format(Panel.gI().numTo, Panel.gI().nextSpeacialSkill[cgender][j][0],
                                                    Panel.gI().nextSpeacialSkill[cgender][j][1]),
                                            String.format(Panel.gI().numTo, Panel.gI().nextSpeacialSkill[cgender][j][0],
                                                    Panel.gI().nextSpeacialSkill[cgender][j][1]),
                                            mResources.EMPTY));
                        } else {
                            msg.writer()
                                    .writeUTF(String.format(Panel.gI().infoSpeacialSkill[cgender][j],
                                            String.format(Panel.gI().numTo, Panel.gI().nextSpeacialSkill[cgender][j][0],
                                                    Panel.gI().nextSpeacialSkill[cgender][j][1]),
                                            mResources.EMPTY));
                        }
                    }
                } else {
                    msg.writer().writeByte(0);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mapClear() {
        Message msg = null;
        try {
            msg = new Message(-22);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void meLoadAll() {
        Message msg = null;
        try {
            msg = this.messageSubCommand((byte) 0);
            msg.writer().writeInt(this.session.myCharz().charID);
            msg.writer().writeByte(this.session.myCharz().ctaskId);
            msg.writer().writeByte(this.session.myCharz().cgender);
            msg.writer().writeShort(this.session.myCharz().head);
            msg.writer().writeUTF(this.session.myCharz().cName);
            msg.writer().writeByte(this.session.myCharz().cPk);
            if (this.session.myCharz().challengeCharId == -9999) {
                msg.writer().writeByte(this.session.myCharz().cTypePk);
            } else {
                msg.writer().writeByte(3);
            }
            msg.writer().writeLong(this.session.myCharz().cPower);
            msg.writer().writeShort(this.session.myCharz().eff5BuffHp);
            msg.writer().writeShort(this.session.myCharz().eff5BuffMp);
            msg.writer().writeByte(this.session.myCharz().nClassId);
            // ===========Write Skill==============//
            msg.writer().writeByte(this.session.myCharz().skills.size());
            for (int i = 0; i < this.session.myCharz().skills.size(); i++) {
                msg.writer().writeShort(this.session.myCharz().skills.get(i).skillId);
            }
            // =============WRITE MONEY=============//
            if (session.getIntVersion() >= 213) {
                msg.writer().writeLong(this.session.myCharz().xu);
            } else {
                if (this.session.myCharz().xu > Integer.MAX_VALUE) {
                    msg.writer().writeInt(Integer.MAX_VALUE);
                } else {
                    msg.writer().writeInt((int) this.session.myCharz().xu);
                }
            }
            msg.writer().writeInt((int) this.session.myCharz().luongKhoa);
            msg.writer().writeInt((int) this.session.myCharz().luong);
            // ================Write ItemBody================//
            msg.writer().writeByte(this.session.myCharz().arrItemBody.length);
            for (int i = 0; i < this.session.myCharz().arrItemBody.length; i++) {
                Item itemBody = this.session.myCharz().arrItemBody[i];
                if (itemBody != null) {
                    msg.writer().writeShort(itemBody.template.id);
                    msg.writer().writeInt(itemBody.quantity);
                    msg.writer().writeUTF(itemBody.info);
                    msg.writer().writeUTF(itemBody.content);
                    // =================Write Option==============//
                    if (itemBody.options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(itemBody.options.size());
                        for (int j = 0; j < itemBody.options.size(); j++) {
                            msg.writer().writeByte(itemBody.options.get(j).optionTemplate.id);
                            msg.writer().writeShort(itemBody.options.get(j).param);
                        }
                    }
                } else {
                    msg.writer().writeShort(-1);
                }
            }
            // ================Write ItemBag================//
            msg.writer().writeByte(this.session.myCharz().arrItemBag.length);
            for (int i = 0; i < this.session.myCharz().arrItemBag.length; i++) {
                Item itemBag = this.session.myCharz().arrItemBag[i];
                if (itemBag != null) {
                    msg.writer().writeShort(itemBag.template.id);
                    msg.writer().writeInt(itemBag.quantity);
                    msg.writer().writeUTF(itemBag.info);
                    msg.writer().writeUTF(itemBag.content);
                    // =================Write Option==============//
                    if (itemBag.options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(itemBag.options.size());
                        for (int j = 0; j < itemBag.options.size(); j++) {
                            msg.writer().writeByte(itemBag.options.get(j).optionTemplate.id);
                            msg.writer().writeShort(itemBag.options.get(j).param);
                        }
                    }
                } else {
                    msg.writer().writeShort(-1);
                }
            }
            // ================Write ItemBox================//
            msg.writer().writeByte(this.session.myCharz().arrItemBox.length);
            for (int i = 0; i < this.session.myCharz().arrItemBox.length; i++) {
                Item itemBox = this.session.myCharz().arrItemBox[i];
                if (itemBox != null) {
                    msg.writer().writeShort(itemBox.template.id);
                    msg.writer().writeInt(itemBox.quantity);
                    msg.writer().writeUTF(itemBox.info);
                    msg.writer().writeUTF(itemBox.content);
                    // =================Write Option==============//
                    if (itemBox.options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(itemBox.options.size());
                        for (int j = 0; j < itemBox.options.size(); j++) {
                            msg.writer().writeByte(itemBox.options.get(j).optionTemplate.id);
                            msg.writer().writeShort(itemBox.options.get(j).param);
                        }
                    }
                } else {
                    msg.writer().writeShort(-1);
                }
            }
            // =====
            msg.writer().writeShort(dragon.t.Head.idHead.length);
            for (int i = 0; i < dragon.t.Head.idHead.length; i++) {
                msg.writer().writeShort(dragon.t.Head.idHead[i]);
                msg.writer().writeShort(dragon.t.Head.idAvatar[i]);
            }
            msg.writer().writeShort(Char.gI().info1[this.session.myCharz().cgender][0]);
            msg.writer().writeShort(Char.gI().info1[this.session.myCharz().cgender][1]);
            msg.writer().writeShort(Char.gI().info1[this.session.myCharz().cgender][2]);
            msg.writer().writeByte(this.session.myCharz().isNhapThe() ? 1 : 0);
            msg.writer().writeInt((int) (System.currentTimeMillis() / 1000) + 1000000);
            msg.writer().writeByte(
                    ((System.currentTimeMillis() - this.session.myCharz().lastTime) < (1000l * 60l * 60l * 24l * 35l))
                            ? 1
                            : 0);
            msg.writer().writeShort(this.session.myCharz().idAuraEff);
            msg.writer().writeByte(this.session.myCharz().idEff_Set_Item);
            msg.writer().writeShort(this.session.myCharz().idHat);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void requestIcon(int id) {
        if (!session.isLoad) {
            return;
        }
        Message msg = null;
        try {

            msg = new Message(-67);
            msg.writer().writeInt(id);
            byte[] data = Dragon.getFile("res/x" + session.zoomLevel + "/icon/" + id + ".png");
            msg.writer().writeInt(data.length);
            msg.writer().write(data);

            // msg = new Message(-67);
            // msg.writer().writeInt(id);
            // if (session.zoomLevel == 1) {
            // msg.writer().writeInt(SmallImage.img_1[id].length);
            // msg.writer().write(SmallImage.img_1[id]);
            // }
            // if (session.zoomLevel == 2) {
            // msg.writer().writeInt(SmallImage.img_2[id].length);
            // msg.writer().write(SmallImage.img_2[id]);
            // }
            // if (session.zoomLevel == 3) {
            // msg.writer().writeInt(SmallImage.img_3[id].length);
            // msg.writer().write(SmallImage.img_3[id]);
            // }
            // if (session.zoomLevel == 4) {
            // msg.writer().writeInt(SmallImage.img_4[id].length);
            // msg.writer().write(SmallImage.img_4[id]);
            // }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mapTemplate(ZoneMap zone, MapTemplate mapTemplate, ArrayList<Waypoint> waypoints, ArrayList<Mob> mobs,
            ArrayList<Npc> npcs, ArrayList<ItemMap> itemMaps, int typeTeleport) {
        Message msg = null;
        try {
            msg = this.messageNotMap(10);
            msg.writer().writeByte(mapTemplate.tmw);
            msg.writer().writeByte(mapTemplate.tmh);
            for (int i = 0; i < mapTemplate.maps.length; i++) {
                msg.writer().writeByte(mapTemplate.maps[i]);
            }
            this.loadInfoMap(msg, this.session.myCharz().cx, this.session.myCharz().cy, waypoints, mobs, npcs, itemMaps,
                    mapTemplate.arrBgItem, mapTemplate.arrEffect, mapTemplate.bgType, typeTeleport);
            msg.writer().writeByte((mapTemplate.isMapDouble ? 1 : 0));
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mapInfo(ZoneMap tile, ArrayList<Waypoint> waypoints, ArrayList<Mob> mobs, ArrayList<Npc> npcs,
            ArrayList<ItemMap> itemMaps, int typeTeleport) {
        Message msg = null;
        try {
            msg = new Message(-24);
            msg.writer().writeByte(tile.mapTemplate.mapTemplateId);
            msg.writer().writeByte(tile.mapTemplate.planetID);
            msg.writer().writeByte(tile.mapTemplate.tileID);
            msg.writer().writeByte(tile.mapTemplate.bgID);
            msg.writer().writeByte(tile.mapTemplate.typeMap);
            msg.writer().writeUTF(tile.mapTemplate.mapName);
            msg.writer().writeByte(tile.zoneID);
            this.loadInfoMap(msg, this.session.myCharz().cx, this.session.myCharz().cy, waypoints, mobs, npcs, itemMaps,
                    tile.mapTemplate.arrBgItem, tile.mapTemplate.arrEffect, tile.mapTemplate.bgType, typeTeleport);
            msg.writer().writeByte((tile.mapTemplate.isMapDouble ? 1 : 0));
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    private void loadInfoMap(Message msg, int x, int y, ArrayList<Waypoint> waypoints, ArrayList<Mob> mobs,
            ArrayList<Npc> npcs, ArrayList<ItemMap> itemMaps, ArrayList<Short[]> arrBgItem,
            ArrayList<String[]> arrEffect, int bgType, int typeTeleport) {
        try {
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            // waypoint
            msg.writer().writeByte(waypoints.size());
            for (int i1 = 0; i1 < waypoints.size(); i1++) {
                Waypoint waypoint = waypoints.get(i1);
                msg.writer().writeShort(waypoint.minX);
                msg.writer().writeShort(waypoint.minY);
                msg.writer().writeShort(waypoint.maxX);
                msg.writer().writeShort(waypoint.maxY);
                msg.writer().writeBoolean(waypoint.isEnter);
                msg.writer().writeBoolean(waypoint.isOffline);
                msg.writer().writeUTF(waypoint.name);
            }
            msg.writer().writeByte(mobs.size());
            for (int i2 = 0; i2 < mobs.size(); i2++) {
                Mob mob = mobs.get(i2);
                msg.writer().writeBoolean(mob.isDisable);
                msg.writer().writeBoolean(mob.isDontMove);
                msg.writer().writeBoolean(mob.isFire);
                msg.writer().writeBoolean(mob.isIce);
                msg.writer().writeBoolean(mob.isWind);
                msg.writer().writeByte(mob.templateId);
                msg.writer().writeByte(mob.sys);
                msg.writer().writeInt(mob.hp);
                msg.writer().writeByte(mob.level);
                msg.writer().writeInt(mob.maxHp);
                msg.writer().writeShort(mob.pointx);
                msg.writer().writeShort(mob.pointy);
                msg.writer().writeByte(mob.status);
                msg.writer().writeByte(mob.levelBoss);
                msg.writer().writeBoolean(mob.isBoss);
            }
            // Null
            msg.writer().writeByte(0);
            // NPC
            msg.writer().writeByte(npcs.size());
            for (int i3 = 0; i3 < npcs.size(); i3++) {
                Npc npc = npcs.get(i3);
                msg.writer().writeByte(npc.statusMe);
                msg.writer().writeShort(npc.cx);
                msg.writer().writeShort(npc.cy);
                msg.writer().writeByte(npc.template.npcTemplateId);
                msg.writer().writeShort(npc.avatar);
            }
            // Item Map
            msg.writer().writeByte(itemMaps.size());
            for (int i4 = 0; i4 < itemMaps.size(); i4++) {
                ItemMap itemMap = itemMaps.get(i4);
                msg.writer().writeShort(itemMap.itemMapID);
                msg.writer().writeShort(itemMap.item.template.id);
                msg.writer().writeShort(itemMap.x);
                msg.writer().writeShort(itemMap.y);
                msg.writer().writeInt(itemMap.playerId);
                if (itemMap.playerId == -2) {
                    msg.writer().writeShort(itemMap.r);
                }
            }
            if (!session.isLoad) {
                msg.writer().writeShort(0);
            } else {
                msg.writer().writeShort(arrBgItem.size());
                for (int i5 = 0; i5 < arrBgItem.size(); i5++) {
                    msg.writer().writeShort(arrBgItem.get(i5)[0]);
                    msg.writer().writeShort(arrBgItem.get(i5)[1]);
                    msg.writer().writeShort(arrBgItem.get(i5)[2]);
                }
            }
            if (!session.isLoad) {
                msg.writer().writeShort(0);
            } else {
                msg.writer().writeShort(arrEffect.size());
                for (int i6 = 0; i6 < arrEffect.size(); i6++) {
                    msg.writer().writeUTF(arrEffect.get(i6)[0]);
                    msg.writer().writeUTF(arrEffect.get(i6)[1]);
                }
            }

            msg.writer().writeByte(bgType);
            // teleport
            msg.writer().writeByte(typeTeleport);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tileSet(int mapTemplateId) {
        Message msg = null;
        MapTemplate mapTemplate = MapTemplate.arrMapTemplate[mapTemplateId];
        int i;
        int i2;
        int i3;
        try {
            msg = new Message(-82);
            msg.writer().writeByte(mapTemplate.tileIndex.length);
            for (i = 0; i < mapTemplate.tileIndex.length; i++) {
                msg.writer().writeByte(mapTemplate.tileIndex[i].length);
                for (i2 = 0; i2 < mapTemplate.tileIndex[i].length; i2++) {
                    msg.writer().writeInt(mapTemplate.tileType[i][i2]);
                    msg.writer().writeByte(mapTemplate.tileIndex[i][i2].length);
                    for (i3 = 0; i3 < mapTemplate.tileIndex[i][i2].length; i3++) {
                        msg.writer().writeByte(mapTemplate.tileIndex[i][i2][i3]);
                    }
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void mobTemplate(int modTemplateId) {
        if (!session.isLoad) {
            return;
        }
        EffectData eff = EffectData.get2(modTemplateId, session.zoomLevel);
        if (eff == null) {
            return;
        }
        Message msg = null;
        try {
            msg = new Message(11);
            msg.writer().writeByte(eff.ID);
            msg.writer().writeByte(eff.typeread);
            if (eff.typeread == 0) {
                writeData(msg, eff);
            } else {
                writeDataNewBoss(msg, eff);
            }
            msg.writer().writeInt(eff.img.length);
            msg.writer().write(eff.img);
            msg.writer().writeByte(eff.typeData);
            if (eff.typeData == 1 || eff.typeData == 2) {
                writeFrameBoss(msg, eff.frame_NEWBOSS);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    protected void updateCaption(int gender) {
        Message msg = null;
        try {
            int i;
            msg = new Message(-41);
            msg.writer().writeByte(GameData.strLevel.length);
            for (i = 0; i < GameData.strLevel.length; i++) {
                msg.writer().writeUTF(GameData.strLevel[i][gender]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void meLoadInfo() {
        Message msg = null;
        try {
            msg = this.messageSubCommand(4);
            if (session.getIntVersion() >= 213) {
                msg.writer().writeLong(this.session.myCharz().xu);
            } else {
                if (this.session.myCharz().xu > Integer.MAX_VALUE) {
                    msg.writer().writeInt(Integer.MAX_VALUE);
                } else {
                    msg.writer().writeInt((int) this.session.myCharz().xu);
                }
            }
            msg.writer().writeInt((int) this.session.myCharz().luong);
            msg.writer().writeInt(this.session.myCharz().cHP);
            msg.writer().writeInt(this.session.myCharz().cMP);
            msg.writer().writeInt((int) this.session.myCharz().luongKhoa);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getEffData(int id) {
        if (!session.isLoad) {
            return;
        }
        Message msg = null;
        try {
            EffectData eff = EffectData.get(id, session.zoomLevel);
            if (eff == null) {
                return;
            }
            msg = new Message(-66);
            msg.writer().writeShort(id);
            if (this.session.getIntVersion() >= 218) {
                if (eff.typeread == 0) {
                    this.writeData(msg, eff);
                } else {
                    this.writeDataNewBoss(msg, eff);
                }
                msg.writer().writeByte(eff.typeread);
            } else {
                this.writeData(msg, eff);
            }
            msg.writer().writeInt(eff.img.length);
            msg.writer().write(eff.img);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            System.out.println("effect id=" + id);
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void insertEffData(int idread, int idwrite) {
        if (!session.isLoad) {
            return;
        }
        Message msg = null;
        try {
            EffectData eff = EffectData.get(idread, session.zoomLevel);
            if (eff == null) {
                return;
            }
            msg = new Message(-66);
            msg.writer().writeShort(idwrite);
            if (session.getIntVersion() >= 218) {
                if (eff.typeread == 0) {
                    writeData(msg, eff);
                } else {
                    writeDataNewBoss(msg, eff);
                }
                msg.writer().writeByte(eff.typeread);
            } else {
                writeData(msg, eff);
            }
            msg.writer().writeInt(eff.img.length);
            msg.writer().write(eff.img);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void addPlayer(Char player, int typeTeleport) {
        Message msg = null;
        try {
            msg = new Message(-5);
            msg.writer().writeInt(player.charID);
            msg.writer().writeInt(player.getClanId());
            if (this.writeCharInfo(msg, player)) {
                msg.writer().writeByte(typeTeleport);
                msg.writer().writeByte(player.isMonkey);
                msg.writer().writeShort(player.idMount);
                msg.writer().writeByte(player.cFlag);
                msg.writer().writeByte(player.isNhapThe() ? 1 : 0);
                msg.writer().writeShort(player.idAuraEff);
                msg.writer().writeByte(player.idEff_Set_Item);
                msg.writer().writeShort(player.idHat);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    private boolean writeCharInfo(Message msg, Char player) {
        try {
            if (player.cloneByChar != null) {
                msg.writer().writeByte(player.cloneByChar.clevel);
                msg.writer().writeBoolean(player.cloneByChar.isInvisiblez);
                if (this.session.myCharz().charID == player.cloneByChar.challengeCharId
                        && player.cloneByChar.isChallenge) {
                    msg.writer().writeByte(3);
                } else {
                    msg.writer().writeByte(player.cloneByChar.cTypePk);
                }
                msg.writer().writeByte(player.cloneByChar.nClassId);
                msg.writer().writeByte(player.cloneByChar.cgender);
                msg.writer().writeShort(player.cloneByChar.head);
                if (player.cloneByChar.me) {
                    if (player.clan != null) {
                        msg.writer()
                                .writeUTF(String.format(mResources.CNAME_CLAN, player.clan.shortName, player.cName));
                    } else {
                        msg.writer().writeUTF(String.format(mResources.CNAME_CLONE, player.cloneByChar.cName));
                    }
                } else {
                    msg.writer().writeUTF(String.format(mResources.NAME_DETU,
                            String.format(mResources.CNAME_CLONE, player.cloneByChar.cName)));
                }
            } else {
                msg.writer().writeByte(player.clevel);
                msg.writer().writeBoolean(player.isInvisiblez);
                if (this.session.myCharz().charID == player.challengeCharId && player.isChallenge) {
                    msg.writer().writeByte(3);
                } else {
                    msg.writer().writeByte(player.cTypePk);
                }
                msg.writer().writeByte(player.nClassId);
                msg.writer().writeByte(player.cgender);
                msg.writer().writeShort(player.head);
                if (player.me) {
                    if (player.clan != null) {
                        msg.writer()
                                .writeUTF(String.format(mResources.CNAME_CLAN, player.clan.shortName, player.cName));
                    } else {
                        msg.writer().writeUTF(player.cName);
                    }
                } else {
                    msg.writer().writeUTF(String.format(mResources.NAME_DETU, player.cName));
                }
            }
            msg.writer().writeInt(player.cHP);
            msg.writer().writeInt(player.cHPFull);
            if (player.cloneByChar != null) {
                msg.writer().writeShort(player.cloneByChar.body);
                msg.writer().writeShort(player.cloneByChar.leg);
                msg.writer().writeByte(player.cloneByChar.bag);
            } else {
                msg.writer().writeShort(player.body);
                msg.writer().writeShort(player.leg);
                msg.writer().writeByte(player.bag);
            }
            msg.writer().writeByte(-1);
            msg.writer().writeShort(player.cx);
            msg.writer().writeShort(player.cy);
            msg.writer().writeShort(player.eff5BuffHp);
            msg.writer().writeShort(player.eff5BuffMp);
            msg.writer().writeByte(0);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void playerMove(int charID, int cx, int cy) {
        Message msg = null;
        try {
            msg = new Message(-7);
            msg.writer().writeInt(charID);
            msg.writer().writeShort(cx);
            msg.writer().writeShort(cy);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void playerReMove(int charID) {
        Message msg = null;
        try {
            msg = new Message(-6);
            msg.writer().writeInt(charID);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void chat(int charID, String text) {
        Message msg = null;
        try {
            msg = new Message(44);
            msg.writer().writeInt(charID);
            msg.writer().writeUTF(text);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void chatTHEGIOI(String who, String text, Char player, int b) {
        Message msg = null;
        try {
            msg = new Message(92);
            msg.writer().writeUTF(who);
            msg.writer().writeUTF(text);
            if (!who.isEmpty()) {
                msg.writer().writeInt(player.charID);
                msg.writer().writeShort(player.head);
                if (session.getIntVersion() >= 218) {
                    msg.writer().writeShort(player.headICON);
                }
                msg.writer().writeShort(player.body);
                msg.writer().writeShort(player.bag);
                msg.writer().writeShort(player.leg);
                msg.writer().writeByte(b);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateCoinBag(int num) {
        Message msg = null;
        try {
            msg = new Message(95);
            msg.writer().writeInt(num);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void Body(int head, Item array[]) {
        Message msg = null;
        try {
            msg = new Message(-37);
            msg.writer().writeByte(0);
            msg.writer().writeShort(head);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                Item item = array[i];
                if (item != null) {
                    msg.writer().writeShort(item.template.id);
                    msg.writer().writeInt(item.quantity);
                    msg.writer().writeUTF(item.info);
                    msg.writer().writeUTF(item.content);
                    if (item.options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(item.options.size());
                        for (int j = 0; j < item.options.size(); j++) {
                            msg.writer().writeByte(item.options.get(j).optionTemplate.id);
                            if (item.options.get(j).optionTemplate.type == 9 && this.session.myCharz().isCheckSetTb()) {
                                msg.writer().writeShort(1);
                            } else {
                                msg.writer().writeShort(item.options.get(j).param);
                            }
                        }
                    }
                } else {
                    msg.writer().writeShort(-1);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void Bag(Item array[]) {
        Message msg = null;
        try {
            msg = new Message(-36);
            msg.writer().writeByte(0);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                Item item = array[i];
                if (item != null) {
                    msg.writer().writeShort(item.template.id);
                    msg.writer().writeInt(item.quantity);
                    msg.writer().writeUTF(item.info);
                    msg.writer().writeUTF(item.content);
                    if (item.options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(item.options.size());
                        for (int j = 0; j < item.options.size(); j++) {
                            msg.writer().writeByte(item.options.get(j).optionTemplate.id);
                            msg.writer().writeShort(item.options.get(j).param);
                        }
                    }
                } else {
                    msg.writer().writeShort(-1);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void ItemBag(int indexUI, int quantity) {
        Message msg = null;
        try {
            msg = new Message(-36);
            msg.writer().writeByte(2);
            msg.writer().writeByte(indexUI);
            msg.writer().writeByte(quantity);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void playerLoadAll(Char player) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(7);
            msg.writer().writeInt(player.charID);
            msg.writer().writeInt(player.getClanId());
            this.writeCharInfo(msg, player);
            msg.writer().writeShort(player.idAuraEff);
            msg.writer().writeByte(player.idEff_Set_Item);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openMenuUI(String[] arrMenu) {
        Message msg = null;
        try {
            int i;
            msg = new Message(33);
            if (arrMenu != null && arrMenu.length > 0) {
                for (i = 0; i < arrMenu.length; i++) {
                    msg.writer().writeUTF(arrMenu[i]);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openUIConfirm(int npcId, String chat, ArrayList<MenuInfo> arrMenu, int avatar) {
        Message msg = null;
        try {
            msg = new Message(32);
            msg.writer().writeShort(npcId);
            msg.writer().writeUTF(chat);
            msg.writer().writeByte(arrMenu.size());
            for (int i = 0; i < arrMenu.size(); i++) {
                msg.writer().writeUTF(arrMenu.get(i).strMenu);
            }
            if (avatar != -1) {
                msg.writer().writeShort(avatar);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openUISay(int npcId, String say, int avatar) {
        Message msg = null;
        try {
            msg = new Message(38);
            msg.writer().writeShort(npcId);
            msg.writer().writeUTF(say);
            if (avatar != -1) {
                msg.writer().writeShort(avatar);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openBox() {
        Message msg = null;
        try {
            msg = new Message(-35);
            msg.writer().writeByte(1);
            msg.writer().writeByte(0);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void Box(Item[] array) {
        Message msg = null;
        try {
            msg = new Message(-35);
            msg.writer().writeByte(0);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                Item item = array[i];
                if (item != null) {
                    msg.writer().writeShort(item.template.id);
                    msg.writer().writeInt(item.quantity);
                    msg.writer().writeUTF(item.info);
                    msg.writer().writeUTF(item.content);
                    if (item.options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(item.options.size());
                        for (int j = 0; j < item.options.size(); j++) {
                            msg.writer().writeByte(item.options.get(j).optionTemplate.id);
                            msg.writer().writeShort(item.options.get(j).param);
                        }
                    }
                } else {
                    msg.writer().writeShort(-1);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void ItemBox(int indexUI, int quantity) {
        Message msg = null;
        try {
            msg = new Message(-35);
            msg.writer().writeByte(2);
            msg.writer().writeByte(indexUI);
            msg.writer().writeInt(quantity);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void telePort(int charID, int b) {
        Message msg = null;
        try {
            msg = new Message(-65);
            msg.writer().writeInt(charID);
            msg.writer().writeByte(b);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void startDie(int cPk, int cx, int cy, long cPower) {
        Message msg = null;
        try {
            msg = new Message(-17);
            msg.writer().writeByte(cPk);
            msg.writer().writeShort(cx);
            msg.writer().writeShort(cy);
            if (cPower != -1) {
                msg.writer().writeLong(cPower);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void liveFromDead() {
        Message msg = null;
        try {
            msg = new Message(-16);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void playerDie(int charID, int cPk, int cx, int cy) {
        Message msg = null;
        try {
            msg = new Message(-8);
            msg.writer().writeInt(charID);
            msg.writer().writeByte(cPk);
            msg.writer().writeShort(cx);
            msg.writer().writeShort(cy);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void returnPointMap(int charID, int cx, int cy) {
        Message msg = null;
        try {
            msg = new Message(84);
            msg.writer().writeInt(charID);
            msg.writer().writeShort(cx);
            msg.writer().writeShort(cy);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void playerLoadLive(int charID, int cHP, int cHPFull, int cx, int cy) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(15);
            msg.writer().writeInt(charID);
            msg.writer().writeInt(cHP);
            msg.writer().writeInt(cHPFull);
            msg.writer().writeShort(cx);
            msg.writer().writeShort(cy);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void playerLoadHP(int charID, int cHP, int b, int cHPFull) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(14);
            msg.writer().writeInt(charID);
            msg.writer().writeInt(cHP);
            msg.writer().writeByte(b);
            if (cHPFull != -1) {
                msg.writer().writeInt(cHPFull);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void playerAttackNPC(int charID, int skillId, ArrayList<Mob> mobs) {
        Message msg = null;
        try {
            msg = new Message(54);
            msg.writer().writeInt(charID);
            msg.writer().writeByte(skillId);
            for (int i = 0; i < mobs.size(); i++) {
                if (mobs.get(i) != null) {
                    msg.writer().writeByte(mobs.get(i).mobId);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void playerAttackPlayer(int playerId, int skillId, ArrayList<Char> chars, int isContinue, int typeSkill,
            int damHP, boolean isDie, boolean isCrit) {
        Message msg = null;
        try {
            msg = new Message(-60);
            msg.writer().writeInt(playerId);
            msg.writer().writeByte(skillId);
            msg.writer().writeByte(chars.size());
            for (int i = 0; i < chars.size(); i++) {
                if (chars.get(i) != null) {
                    msg.writer().writeInt(chars.get(i).charID);
                }
            }
            msg.writer().writeByte(isContinue);
            if (isContinue == 1) {
                msg.writer().writeByte(typeSkill);
                msg.writer().writeInt(damHP);
                msg.writer().writeBoolean(isDie);
                msg.writer().writeBoolean(isCrit);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void playerAttackNP(int charID, int skillId, ArrayList<Mob> mobs, ArrayList<Char> players) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-4);
            msg.writer().writeInt(charID);
            msg.writer().writeByte(skillId);
            msg.writer().writeByte(mobs.size());
            for (i = 0; i < mobs.size(); i++) {
                if (mobs.get(i) != null) {
                    msg.writer().writeByte(mobs.get(i).mobId);
                }
            }
            for (i = 0; i < players.size(); i++) {
                if (players.get(i) != null) {
                    msg.writer().writeInt(players.get(i).charID);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void mobHP(int mobId, int hp, int downhp, boolean flag, int effectId) {
        Message msg = null;
        try {
            msg = new Message(-9);
            msg.writer().writeByte(mobId);
            msg.writer().writeInt(hp);
            msg.writer().writeInt(downhp);
            if (downhp != 1) {
                msg.writer().writeBoolean(flag);
                msg.writer().writeByte(effectId);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void mobDie(int mobId, int downhp, boolean flag, ArrayList<ItemMap> itemMaps) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-12);
            msg.writer().writeByte(mobId);
            msg.writer().writeInt(downhp);
            msg.writer().writeBoolean(flag);
            // ===Item Map===\\\
            msg.writer().writeByte(itemMaps.size());
            for (i = 0; i < itemMaps.size(); i++) {
                msg.writer().writeShort(itemMaps.get(i).itemMapID);
                msg.writer().writeShort(itemMaps.get(i).item.template.id);
                msg.writer().writeShort(itemMaps.get(i).x);
                msg.writer().writeShort(itemMaps.get(i).y);
                msg.writer().writeInt(itemMaps.get(i).playerId);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void meLoadHP(int cHP) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(5);
            msg.writer().writeInt(cHP);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void meLoadMP(int cMP) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(6);
            msg.writer().writeInt(cMP);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void playerUpdateEXP(int type, long num) {
        Message msg = null;
        try {
            msg = new Message(-3);
            msg.writer().writeByte(type);
            msg.writer().writeInt((int) num);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void updateBody(int type, int charID, int head, int body, int leg, int isMonkey) {
        Message msg = null;
        try {
            msg = new Message(-90);
            msg.writer().writeByte(type);
            msg.writer().writeInt(charID);
            if (type != -1) {
                msg.writer().writeShort(head);
                msg.writer().writeShort(body);
                msg.writer().writeShort(leg);
                msg.writer().writeByte(isMonkey);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void itemMapRemove(int itemMapID) {
        Message msg = null;
        try {
            msg = new Message(-21);
            msg.writer().writeShort(itemMapID);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void itemMapMyPick(int itemMapID, String info, int type, int num, int num2) {
        Message msg = null;
        try {
            msg = new Message(-20);
            msg.writer().writeShort(itemMapID);
            msg.writer().writeUTF(info);
            msg.writer().writeShort(num);
            if (type == 9 || type == 10 || type == 34) {
                msg.writer().writeShort(num2);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void itemMapPlayerPick(int itemMapID, int charID) {
        Message msg = null;
        try {
            msg = new Message(-19);
            msg.writer().writeShort(itemMapID);
            msg.writer().writeInt(charID);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void itemBuy(long xu, int luong, int luongKhoa) {
        Message msg = null;
        try {
            msg = new Message(6);
            if (session.getIntVersion() >= 213) {
                msg.writer().writeLong(xu);
            } else {
                if (xu > Integer.MAX_VALUE) {
                    msg.writer().writeInt(Integer.MAX_VALUE);
                } else {
                    msg.writer().writeInt((int) xu);
                }
            }
            msg.writer().writeInt(luong);
            msg.writer().writeInt(luongKhoa);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void openShop(int type, String shopTabName[], ArrayList<Item> myItemShop[]) {
        Message msg = null;
        try {
            msg = new Message(-44);
            msg.writer().writeByte(type);
            msg.writer().writeByte(shopTabName.length);
            for (int i = 0; i < shopTabName.length; i++) {
                msg.writer().writeUTF(shopTabName[i].replaceAll("#", String.valueOf(myItemShop[i].size())));
                msg.writer().writeByte(myItemShop[i].size());
                for (int k = 0; k < myItemShop[i].size(); k++) {
                    if (myItemShop[i].get(k).isItemPackOf30Foods()) {
                        msg.writer().writeShort(MagicTree.pack30templateId[this.session.myCharz().magicTree_level - 1]);
                    } else {
                        msg.writer().writeShort(myItemShop[i].get(k).template.id);
                    }
                    if (type == 4) {
                        msg.writer().writeUTF(myItemShop[i].get(k).reason);
                    }
                    if (type == 0) {

                        if (myItemShop[i].get(k).template.id == 518 && myItemShop[i].get(k).template.id != 457) {
                            msg.writer()
                                    .writeInt(myItemShop[i].get(k).buyCoin * (this.session.myCharz().boxcount - 19));
                        } else if (myItemShop[i].get(k).template.id == 457) {
                            msg.writer().writeInt(Server.gI().gold_value);
                        } else {
                            msg.writer().writeInt(myItemShop[i].get(k).buyCoin);
                        }
                        if (myItemShop[i].get(k).template.id == 517) {
                            msg.writer()
                                    .writeInt(myItemShop[i].get(k).buyGold * (this.session.myCharz().bagcount - 19));
                        } else {
                            msg.writer().writeInt(myItemShop[i].get(k).buyGold);
                        }
                        // msg.writer().writeInt(itemShops[k].buyCoin);
                        // msg.writer().writeInt(itemShops[k].buyGold);
                    }
                    if (type == 1) {
                        msg.writer().writeLong(myItemShop[i].get(k).template.strRequire);
                    }
                    if (type == 2) {
                        msg.writer().writeShort(myItemShop[i].get(k).itemId);
                        msg.writer().writeInt(myItemShop[i].get(k).buyCoin);
                        msg.writer().writeInt(myItemShop[i].get(k).buyGold);
                        msg.writer().writeByte(myItemShop[i].get(k).buyType);
                        if (this.session.getIntVersion() >= 222) {
                            msg.writer().writeInt(myItemShop[i].get(k).quantity);
                        } else {
                            msg.writer().writeByte(myItemShop[i].get(k).quantity);
                        }
                        msg.writer().writeByte(myItemShop[i].get(k).isMe);
                    }
                    if (type == 3) {
                        msg.writer().writeShort(myItemShop[i].get(k).iconSpec);
                        msg.writer().writeInt(myItemShop[i].get(k).buySpec);
                    }
                    if (myItemShop[i].get(k).isItemPackOf30Foods()) {
                        ArrayList<ItemOption> options = ItemOption.getOption(
                                MagicTree.foods30templateId[this.session.myCharz().magicTree_level - 1], 0, 0);
                        msg.writer().writeByte(options.size());
                        for (int m = 0; m < options.size(); m++) {
                            msg.writer().writeByte(options.get(m).optionTemplate.id);
                            msg.writer().writeShort(options.get(m).param);
                        }
                    } else if (myItemShop[i].get(k).template.type == 36) {
                        ArrayList<ItemOption> options = new ArrayList<>(myItemShop[i].get(k).options);
                        if (i == 0) {
                            int point = this.session.myCharz().getTaskPointDH(myItemShop[i].get(k).template.id);
                            if (point > 0) {
                                options.add(0, new ItemOption(220, (int) (100.0F
                                        / TaskDanhHieu.hTask.get(myItemShop[i].get(k).template.id).maxCount * point)));
                            }
                        }
                        msg.writer().writeByte(options.size());
                        for (int m = 0; m < options.size(); m++) {
                            msg.writer().writeByte(options.get(m).optionTemplate.id);
                            msg.writer().writeShort(options.get(m).param);
                        }
                    } else {
                        msg.writer().writeByte(myItemShop[i].get(k).options.size());
                        for (int m = 0; m < myItemShop[i].get(k).options.size(); m++) {
                            if (myItemShop[i].get(k).template.type == 13
                                    && myItemShop[i].get(k).options.get(m).optionTemplate.id == 66
                                    && this.session.myCharz().isExistAmu(myItemShop[i].get(k).template.id)) {
                                Amu amu = this.session.myCharz().getAmuById(myItemShop[i].get(k).template.id);
                                if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60 * 24) {
                                    msg.writer().writeByte(63);
                                    msg.writer().writeShort((int) (((amu.second - (System.currentTimeMillis() / 1000)))
                                            / (60 * 60 * 24)));
                                } else if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60) {
                                    msg.writer().writeByte(64);
                                    msg.writer().writeShort(
                                            (int) ((amu.second - (System.currentTimeMillis() / 1000)) / (60 * 60)));
                                } else {
                                    msg.writer().writeByte(65);
                                    msg.writer().writeShort(
                                            (int) ((amu.second - (System.currentTimeMillis() / 1000)) / 60));
                                }
                            } else {
                                msg.writer().writeByte(myItemShop[i].get(k).options.get(m).optionTemplate.id);
                                msg.writer().writeShort(myItemShop[i].get(k).options.get(m).param);
                            }
                        }
                    }
                    msg.writer().writeByte((myItemShop[i].get(k).newItem ? 1 : 0));
                    if (myItemShop[i].get(k).headTemp != -1 || myItemShop[i].get(k).bodyTemp != -1
                            || myItemShop[i].get(k).legTemp != -1 || myItemShop[i].get(k).bagTemp != -1) {
                        msg.writer().writeByte(1);
                        msg.writer().writeShort(myItemShop[i].get(k).headTemp);
                        msg.writer().writeShort(myItemShop[i].get(k).bodyTemp);
                        msg.writer().writeShort(myItemShop[i].get(k).legTemp);
                        msg.writer().writeShort(myItemShop[i].get(k).bagTemp);

                    } else {
                        msg.writer().writeByte(0);
                    }
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void openUIZone(Map map) {
        Message msg = null;
        int i;
        try {
            msg = new Message(29);
            msg.writer().writeByte(map.zones.size());
            for (i = 0; i < map.zones.size(); i++) {
                msg.writer().writeByte(map.zones.get(i).zoneID);
                msg.writer().writeByte(map.zones.get(i).pts());
                msg.writer().writeByte(map.zones.get(i).getCountPLayerNotAI());
                msg.writer().writeByte(map.zones.get(i).maxPlayer);
                if (map.zones.get(i).rankName1 != null && map.zones.get(i).rankName2 != null) {
                    msg.writer().writeByte(1);
                    msg.writer().writeUTF(map.zones.get(i).rankName1);
                    msg.writer().writeInt(map.zones.get(i).rank1);
                    msg.writer().writeUTF(map.zones.get(i).rankName2);
                    msg.writer().writeInt(map.zones.get(i).rank2);
                } else {
                    msg.writer().writeByte(0);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void dialogMessage(String text) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-26);
            msg.writer().writeUTF(text);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void mobAttackMe(int mobId, int HPShow, int MPShow) {
        Message msg = null;
        try {
            msg = new Message(-11);
            if (mobId >= 0) {
                msg.writer().writeByte(mobId);
            }
            msg.writer().writeInt(HPShow);
            if (MPShow >= 0) {
                msg.writer().writeInt(MPShow);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void mobAttackPlayer(int mobId, int charID, int HPShow, int MPShow) {
        Message msg = null;
        try {
            msg = new Message(-10);
            if (mobId >= 0) {
                msg.writer().writeByte(mobId);
            }
            msg.writer().writeInt(charID);
            msg.writer().writeInt(HPShow);
            if (MPShow >= 0) {
                msg.writer().writeInt(MPShow);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void meLoadSkill(ArrayList<Skill> skills) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(2);
            msg.writer().writeByte(skills.size());
            for (int i = 0; i < skills.size(); i++) {
                msg.writer().writeShort(skills.get(i).skillId);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void loadRMS(String text, ArrayList<Byte> key) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(61);
            msg.writer().writeUTF(text);
            msg.writer().writeInt(key.size());
            for (int i = 0; i < key.size(); i++) {
                msg.writer().write(key.get(i));
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void mobLive(int mobId, int sys, int levelBoss, int hp) {
        Message msg = null;
        try {
            msg = new Message(-13);
            msg.writer().writeByte(mobId);
            msg.writer().writeByte(sys);
            msg.writer().writeByte(levelBoss);
            msg.writer().writeInt(hp);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    protected void writeGetImgByName(String text) {
        if (!session.isLoad) {
            return;
        }
        Message msg = null;
        Util.gI().logln("nameImg ================" + text);
        ImgByName imgByName = ImgByName.imgByNames.get(this.session.zoomLevel).get(text);
        if (imgByName != null) {
            try {
                msg = new Message(66);
                msg.writer().writeUTF(imgByName.nameImg);
                msg.writer().writeByte(imgByName.nFrame);
                msg.writer().writeInt(imgByName.data.length);
                msg.writer().write(imgByName.data);
                this.session.sendMessage(msg);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (msg != null)
                    msg.cleanup();
            }
        }
    }

    public void getFlag() {
        Message msg = null;
        try {
            msg = new Message(-103);
            msg.writer().writeByte(0);
            msg.writer().writeByte(Flag.FLAGS.size());
            for (int i = 0; i < Flag.FLAGS.size(); i++) {
                msg.writer().writeShort(Flag.FLAGS.get(i).itemFlag.template.id);
                msg.writer().writeByte(Flag.FLAGS.get(i).itemFlag.options.size());
                for (int j = 0; j < Flag.FLAGS.get(i).itemFlag.options.size(); j++) {
                    msg.writer().writeByte(Flag.FLAGS.get(i).itemFlag.options.get(j).optionTemplate.id);
                    msg.writer().writeShort(Flag.FLAGS.get(i).itemFlag.options.get(j).param);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void changeFlag(int charID, int cFlag) {
        Message msg = null;
        try {
            msg = new Message(-103);
            msg.writer().writeByte(1);
            msg.writer().writeInt(charID);
            msg.writer().writeByte(cFlag);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void idImgFlag(int cFlag, int IDimageFlag) {
        Message msg = null;
        try {
            msg = new Message(-103);
            msg.writer().writeByte(2);
            msg.writer().writeByte(cFlag);
            msg.writer().writeShort(IDimageFlag);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getPlayelrMenu(ArrayList<MenuInfo2> myList) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(63);
            msg.writer().writeByte(myList.size());
            for (int i = 0; i < myList.size(); i++) {
                msg.writer().writeUTF(myList.get(i).caption);
                msg.writer().writeUTF(myList.get(i).caption2);
                msg.writer().writeShort(myList.get(i).id);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void playerMenu(int int1, long cPower, String currStrLevel) {
        Message msg = null;
        try {
            msg = new Message(-79);
            msg.writer().writeInt(int1);
            msg.writer().writeLong(cPower);
            msg.writer().writeUTF(currStrLevel);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void player_vs_player(int typePK, int playerId, int xu, String info) {
        Message msg = null;
        try {
            msg = new Message(-59);
            msg.writer().writeByte(typePK);
            msg.writer().writeInt(playerId);
            msg.writer().writeInt(xu);
            msg.writer().writeUTF(info);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateTypePK(int playerId, int typePk) {
        Message msg = null;
        try {
            msg = new Message(-30);
            msg.writer().writeByte(35);
            msg.writer().writeInt(playerId);
            msg.writer().writeByte(typePk);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void skill_not_focus(int skill_type, int playerId, int skilltemplateId, ArrayList<Mob> mobs,
            ArrayList<Char> players, int seconds) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-45);
            msg.writer().writeByte(skill_type);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(skilltemplateId);
            if (skill_type == 0) {
                int count = 0;
                if (mobs != null) {
                    count = mobs.size();
                }
                msg.writer().writeByte(count);
                if (mobs != null) {
                    for (i = 0; i < count; i++) {
                        msg.writer().writeByte(mobs.get(i).mobId);
                        msg.writer().writeByte((mobs.get(i).mili_seconds / 1000));
                    }
                }
                if (players != null) {
                    count = players.size();
                }
                msg.writer().writeByte(count);
                if (players != null) {
                    for (i = 0; i < count; i++) {
                        msg.writer().writeInt(players.get(i).charID);
                        msg.writer().writeByte((players.get(i).freezMiliSeconds / 1000));
                    }
                }
            }
            if (skill_type == 1) {

            }
            if (skill_type == 6) {

            }
            if (skill_type == 4) {
                msg.writer().writeShort(seconds);
            }
            if (skill_type == 7) {
                msg.writer().writeShort(seconds);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void addEffectChar(int playerId, int id, int layer, int loop, int loopCount, int isStand) {
        Message msg = null;
        try {
            msg = new Message(-128);
            msg.writer().writeByte(0);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(id);
            msg.writer().writeByte(layer);
            msg.writer().writeByte(loop);
            msg.writer().writeShort(loopCount);
            msg.writer().writeByte(isStand);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void removeEffChar(int playerId, int id) {
        Message msg = null;
        try {
            msg = new Message(-128);
            msg.writer().writeByte(1);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(id);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void removeEffCharAll(int playerId) {
        Message msg = null;
        try {
            msg = new Message(-128);
            msg.writer().writeByte(2);
            msg.writer().writeInt(playerId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void haveAttackPlayer(int charID, int hp, int damHP, boolean isCrit, int idEff) {
        Message msg = null;
        try {
            msg = new Message(56);
            msg.writer().writeInt(charID);
            msg.writer().writeInt(hp);
            msg.writer().writeInt(damHP);
            if (isCrit || idEff != -1) {
                msg.writer().writeBoolean(isCrit);
                msg.writer().writeByte(idEff);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setPos(int charID, int x, int y, int b) {
        Message msg = null;
        try {
            msg = new Message(123);
            msg.writer().writeInt(charID);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            msg.writer().writeByte(b);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mobIsFire(int mobId, boolean isFire) {
        Message msg = null;
        try {
            msg = new Message(85);
            msg.writer().writeByte(mobId);
            msg.writer().writeBoolean(isFire);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mobIsIce(int mobId, boolean isIce) {
        Message msg = null;
        try {
            msg = new Message(86);
            msg.writer().writeByte(mobId);
            msg.writer().writeBoolean(isIce);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mobIsWind(int mobId, boolean isWind) {
        Message msg = null;
        try {
            msg = new Message(87);
            msg.writer().writeByte(mobId);
            msg.writer().writeBoolean(isWind);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mobIsDisable(int mobId, boolean isDisable) {
        Message msg = null;
        try {
            msg = new Message(81);
            msg.writer().writeByte(mobId);
            msg.writer().writeBoolean(isDisable);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mobIsDontMove(int mobId, boolean isDontMove) {
        Message msg = null;
        try {
            msg = new Message(82);
            msg.writer().writeByte(mobId);
            msg.writer().writeBoolean(isDontMove);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void holdChar(int effID, int holdEffID, int charId1, int charId2, int charId3) {
        Message msg = null;
        try {
            msg = new Message(-124);
            msg.writer().writeByte(effID);
            msg.writer().writeByte(0);
            if (effID == 2) {
                msg.writer().writeInt(charId1);
            }
            msg.writer().writeByte(holdEffID);
            msg.writer().writeInt(charId2);
            if (holdEffID == 32) {
                msg.writer().writeInt(charId3);
            }
            if (holdEffID == 41) {

            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void holdMob(int effID, int holdEffID, int mobId, int playerId) {
        Message msg = null;
        try {
            msg = new Message(-124);
            msg.writer().writeByte(effID);
            msg.writer().writeByte(1);
            msg.writer().writeByte(holdEffID);
            msg.writer().writeByte(mobId);
            if (holdEffID == 32) {
                msg.writer().writeInt(playerId);
            }
            if (holdEffID == 41) {

            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void itemTime(int iconId, int second) {
        Message msg = null;
        try {
            msg = new Message(-106);
            msg.writer().writeShort(iconId);
            msg.writer().writeShort(second);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void addMobMe(int charId, int templateId, int hp) {
        Message msg = null;
        try {
            msg = new Message(-95);
            msg.writer().writeByte(0);
            msg.writer().writeInt(charId);
            msg.writer().writeShort(templateId);
            msg.writer().writeInt(hp);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void clearMobMe(int charId) {
        Message msg = null;
        try {
            msg = new Message(-95);
            msg.writer().writeByte(7);
            msg.writer().writeInt(charId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mobMeAttackMob(int charId, int mobId) {
        Message msg = null;
        try {
            msg = new Message(-95);
            msg.writer().writeByte(1);
            msg.writer().writeInt(charId);
            msg.writer().writeByte(mobId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void mobMeAttackPlayer(int charId, int playerId, int dam, int cHPNew) {
        Message msg = null;
        try {
            msg = new Message(-95);
            msg.writer().writeByte(2);
            msg.writer().writeInt(charId);
            msg.writer().writeInt(playerId);
            msg.writer().writeInt(dam);
            msg.writer().writeInt(cHPNew);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void changeMobBody(int type, int mobIndex, int id) {
        Message msg = null;
        try {
            msg = new Message(-112);
            msg.writer().writeByte(type);
            msg.writer().writeByte(mobIndex);
            if (type == 1) {
                msg.writer().writeShort(id);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void combine(String src, String src2, int num) {
        Message msg = null;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(0);
            msg.writer().writeUTF(src);
            msg.writer().writeUTF(src2);
            if (num != -1) {
                msg.writer().writeShort(num);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setCombineEff(int type, int iconId, int iconId2, int npcId) {
        Message msg = null;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(type);
            if (type != 2 && type != 3) {
                msg.writer().writeShort(iconId);
            }
            if (type == 6) {
                msg.writer().writeShort(iconId2);
            }
            if (npcId != -1) {
                msg.writer().writeShort(npcId);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setCombineEff(Item[] arrItem) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(1);
            msg.writer().writeByte(arrItem.length);
            for (i = 0; i < arrItem.length; i++) {
                msg.writer().writeByte(arrItem[i].indexUI);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setCombineEff(int[] array, int npcId) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(1);
            msg.writer().writeByte(array.length);
            for (i = 0; i < array.length; i++) {
                msg.writer().writeByte(array[i]);
            }
            msg.writer().writeShort(npcId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setCombineEff(ArrayList<Item> items, int npcId) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-81);
            msg.writer().writeByte(1);
            msg.writer().writeByte(items.size());
            for (i = 0; i < items.size(); i++) {
                msg.writer().writeByte(items.get(i).indexUI);
            }
            msg.writer().writeShort(npcId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void magicTree() {
        Message msg = null;
        try {
            Npc npc = this.session.myCharz().getMapOffline(this.session.myCharz().mainHome()).zones.get(0)
                    .findNPCInMap(4);
            msg = new Message(-34);
            msg.writer().writeByte(0);
            msg.writer().writeShort(
                    MagicTree.magicTreeId[this.session.myCharz().cgender][this.session.myCharz().magicTree_level - 1]);
            msg.writer().writeUTF(String.format(MagicTree.infomagicTree, this.session.myCharz().magicTree_level));
            msg.writer().writeShort(npc.cx);
            msg.writer().writeShort(npc.cy);
            msg.writer().writeByte(this.session.myCharz().magicTree_level);
            msg.writer().writeShort(this.session.myCharz().magicTree_currPeas);
            msg.writer().writeShort(MagicTree.maxPeas[this.session.myCharz().magicTree_level - 1]);
            msg.writer().writeUTF(mResources.EMPTY);
            msg.writer().writeInt((int) ((this.session.myCharz().magicTree_miliseconds / 1000)
                    - (System.currentTimeMillis() / 1000)));
            msg.writer().writeByte(this.session.myCharz().magicTree_currPeas);
            for (int i = 0; i < this.session.myCharz().magicTree_currPeas; i++) {
                msg.writer().writeByte(MagicTree.peaPostionXY[this.session.myCharz().magicTree_level - 1][i][0]);
                msg.writer().writeByte(MagicTree.peaPostionXY[this.session.myCharz().magicTree_level - 1][i][1]);
            }
            msg.writer().writeBoolean(this.session.myCharz().magicTree_isUpdate);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openMagicTreConfirm(ArrayList<MenuInfo> arrMenu) {
        Message msg = null;
        try {
            msg = new Message(-34);
            msg.writer().writeByte(1);
            for (int i = 0; i < arrMenu.size(); i++) {
                msg.writer().writeUTF(arrMenu.get(i).strMenu);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void magicTree2(int remainPeas, int seconds) {
        Message msg = null;
        try {
            msg = new Message(-34);
            msg.writer().writeByte(2);
            msg.writer().writeShort(remainPeas);
            msg.writer().writeInt(seconds);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void autoPlay(int canAutoPlay) {
        Message msg = null;
        try {
            msg = new Message(-116);
            msg.writer().writeByte(canAutoPlay);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void hideDragon() {
        Message msg = null;
        try {
            msg = new Message(-83);
            msg.writer().writeByte(1);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void callDragon(int mapId, int bgId, int zoneId, int playerId, String text, int rx, int ry,
            int isRongNamek) {
        Message msg = null;
        try {
            msg = new Message(-83);
            msg.writer().writeByte(0);
            msg.writer().writeShort(mapId);
            msg.writer().writeShort(bgId);
            msg.writer().writeByte(zoneId);
            msg.writer().writeInt(playerId);
            msg.writer().writeUTF(text);
            msg.writer().writeShort(rx);
            msg.writer().writeShort(ry);
            msg.writer().writeByte(isRongNamek);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void itemMapAdd(ItemMap itMap) {
        Message msg = null;
        try {
            msg = new Message(68);
            msg.writer().writeShort(itMap.itemMapID);
            msg.writer().writeShort(itMap.item.template.id);
            msg.writer().writeShort(itMap.x);
            msg.writer().writeShort(itMap.y);
            msg.writer().writeInt(itMap.playerId);
            if (itMap.playerId == -2) {
                msg.writer().writeShort(itMap.r);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void itemMapAdd(int itemMapID, int id, int x, int y, int playerId, int r) {
        Message msg = null;
        try {
            msg = new Message(68);
            msg.writer().writeShort(itemMapID);
            msg.writer().writeShort(id);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            msg.writer().writeInt(playerId);
            if (playerId == -2) {
                msg.writer().writeShort(r);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void transPort(int maxTime, int type) {
        Message msg = null;
        try {
            msg = new Message(-105);
            msg.writer().writeShort(maxTime);
            msg.writer().writeByte(type);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void updateCoolDown(ArrayList<Skill> skills) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-94);
            for (i = 0; i < skills.size(); i++) {
                msg.writer().writeShort(skills.get(i).skillId);
                msg.writer().writeInt((int) (skills.get(i).lastTimeUseThisSkill - System.currentTimeMillis()));
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void chatVip(String text) {
        Message msg = null;
        int i;
        try {
            msg = new Message(93);
            msg.writer().writeUTF(text);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void petInfo0() {
        Message msg = null;
        int i;
        try {
            msg = new Message(-107);
            msg.writer().writeByte(0);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void petInfo1() {
        Message msg = null;
        int i;
        try {
            msg = new Message(-107);
            msg.writer().writeByte(1);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void petInfo2(Char petz) {
        Message msg = null;
        int i;
        int j;
        try {
            msg = new Message(-107);
            msg.writer().writeByte(2);
            msg.writer().writeShort(petz.head);
            msg.writer().writeByte(petz.arrItemBody.length);
            for (i = 0; i < petz.arrItemBody.length; i++) {
                if (petz.arrItemBody[i] != null) {
                    msg.writer().writeShort(petz.arrItemBody[i].template.id);
                    msg.writer().writeInt(petz.arrItemBody[i].quantity);
                    msg.writer().writeUTF(petz.arrItemBody[i].info);
                    msg.writer().writeUTF(petz.arrItemBody[i].content);
                    if (petz.arrItemBody[i].options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(petz.arrItemBody[i].options.size());
                        for (j = 0; j < petz.arrItemBody[i].options.size(); j++) {
                            msg.writer().writeByte(petz.arrItemBody[i].options.get(j).optionTemplate.id);
                            msg.writer().writeShort(petz.arrItemBody[i].options.get(j).param);
                        }
                    }
                } else {
                    msg.writer().writeShort(-1);
                }
            }
            msg.writer().writeInt(petz.cHP);
            msg.writer().writeInt(petz.cHPFull);
            msg.writer().writeInt(petz.cMP);
            msg.writer().writeInt(petz.cMPFull);
            msg.writer().writeInt(petz.cDamFull);
            msg.writer().writeUTF(petz.cName);
            msg.writer().writeUTF(GameData.strLevel[petz.clevel][petz.cgender]);
            msg.writer().writeLong(petz.cPower);
            msg.writer().writeLong(petz.cTiemNang);
            msg.writer().writeByte(petz.petStatus);
            msg.writer().writeShort(petz.cStamina);
            msg.writer().writeShort(petz.cMaxStamina);
            msg.writer().writeByte(petz.cCriticalFull);
            msg.writer().writeShort(petz.cDefull);
            msg.writer().writeByte(4);
            for (j = 0; j < petz.skills.size(); j++) {
                msg.writer().writeShort(petz.skills.get(j).skillId);
            }
            for (; j < 4; j++) {
                msg.writer().writeShort(-1);
                msg.writer().writeUTF(petz.spowerSkillPet[j]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setFusion(int fusion, int charId) {
        Message msg = null;
        try {
            msg = new Message(125);
            msg.writer().writeByte(fusion);
            msg.writer().writeInt(charId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void sendgiaodich(int charId) {
        Message msg = null;
        try {
            msg = new Message(-86);
            msg.writer().writeByte(0);
            msg.writer().writeInt(charId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void opengiaodich(int playerId) {
        Message msg = null;
        try {
            msg = new Message(-86);
            msg.writer().writeByte(1);
            msg.writer().writeInt(playerId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void cancelgiaodich() {
        Message msg = null;
        try {
            msg = new Message(-86);
            msg.writer().writeByte(7);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void lockgiaodich(Char player) {
        Message msg = null;
        int i;
        int j;
        try {
            msg = new Message(-86);
            msg.writer().writeByte(6);
            msg.writer().writeInt(player.coin_giaodich);
            msg.writer().writeByte(player.count_giaodich);
            for (i = 0; i < player.arrItem.length; i++) {
                if (player.arrItem[i] != null) {
                    msg.writer().writeShort(player.arrItem[i].template.id);
                    msg.writer().writeByte(player.arrQuantity[i]);
                    if (player.arrItem[i].options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(player.arrItem[i].options.size());
                        for (j = 0; j < player.arrItem[i].options.size(); j++) {
                            msg.writer().writeByte(player.arrItem[i].options.get(j).optionTemplate.id);
                            msg.writer().writeShort(player.arrItem[i].options.get(j).param);
                        }
                    }
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void lockgiaodich(int coin, ArrayList<Item> arraylist) {
        Message msg = null;
        try {
            msg = new Message(-86);
            msg.writer().writeByte(6);
            msg.writer().writeInt(coin);
            msg.writer().writeByte(arraylist.size());
            for (int i = 0; i < arraylist.size(); i++) {
                msg.writer().writeShort(arraylist.get(i).template.id);
                if (this.session.getIntVersion() >= 222) {
                    msg.writer().writeInt(arraylist.get(i).quantity);
                } else {
                    msg.writer().writeByte(arraylist.get(i).quantity);
                }
                if (arraylist.get(i).options.isEmpty()) {
                    msg.writer().writeByte(1);
                    msg.writer().writeByte(73);
                    msg.writer().writeShort(0);
                } else {
                    msg.writer().writeByte(arraylist.get(i).options.size());
                    for (int j = 0; j < arraylist.get(i).options.size(); j++) {
                        msg.writer().writeByte(arraylist.get(i).options.get(j).optionTemplate.id);
                        msg.writer().writeShort(arraylist.get(i).options.get(j).param);
                    }
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void removeitemgiaodich(int indexUI) {
        Message msg = null;
        try {
            msg = new Message(-86);
            msg.writer().writeByte(2);
            msg.writer().writeByte(indexUI);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void Stamina(int num) {
        Message msg = null;
        try {
            msg = new Message(-68);
            msg.writer().writeShort(num);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void maxStamina(int num) {
        Message msg = null;
        try {
            msg = new Message(-69);
            msg.writer().writeShort(num);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void rank(int num) {
        Message msg = null;
        try {
            msg = new Message(-119);
            msg.writer().writeInt(num);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openTextBoxId(String info, int textId) {
        Message msg = null;
        try {
            msg = new Message(88);
            msg.writer().writeUTF(info);
            msg.writer().writeShort(textId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void returnPointMap(int charId, int x, int y, int playerId) {
        Message msg = null;
        try {
            msg = new Message(84);
            msg.writer().writeInt(charId);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            if (playerId != -1) {
                msg.writer().writeInt(playerId);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void resetPont(int x, int y) {
        Message msg = null;
        try {
            msg = new Message(46);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void sendLuckyRound(int typePrice, int price, int idTicket) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-127);
            msg.writer().writeByte(0);
            msg.writer().writeByte(LuckyRound.gI().BallInfo_idImage.length);
            for (i = 0; i < LuckyRound.gI().BallInfo_idImage.length; i++) {
                msg.writer().writeShort(LuckyRound.gI().BallInfo_idImage[i]);
            }
            msg.writer().writeByte(typePrice);
            msg.writer().writeInt(price);
            msg.writer().writeShort(idTicket);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void sendLuckyRound(short[] idImage) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-127);
            msg.writer().writeByte(1);
            msg.writer().writeByte(idImage.length);
            for (i = 0; i < idImage.length; i++) {
                msg.writer().writeShort(idImage[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openItemMore(ArrayList<Item> items) {
        Message msg = null;
        int i;
        int k;
        int m;
        try {
            msg = new Message(-44);
            msg.writer().writeByte(4);
            msg.writer().writeByte(1);
            for (i = 0; i < 1; i++) {
                msg.writer().writeUTF(mResources.ITEM);
                msg.writer().writeByte(items.size());
                for (k = 0; k < items.size(); k++) {
                    msg.writer().writeShort(items.get(k).template.id);
                    msg.writer().writeUTF(items.get(k).reason);
                    if (items.get(k).quantity > 1) {
                        msg.writer().writeByte(items.get(k).options.size() + 1);
                        msg.writer().writeByte(31);
                        msg.writer().writeShort(items.get(k).quantity);
                    } else {
                        msg.writer().writeByte(items.get(k).options.size());
                    }
                    for (m = 0; m < items.get(k).options.size(); m++) {
                        msg.writer().writeByte(items.get(k).options.get(m).optionTemplate.id);
                        msg.writer().writeShort(items.get(k).options.get(m).param);
                    }
                    msg.writer().writeByte((items.get(k).newItem ? 1 : 0));
                    if (items.get(k).headTemp != -1 || items.get(k).bodyTemp != -1 || items.get(k).legTemp != -1
                            || items.get(k).bagTemp != -1) {
                        msg.writer().writeByte(1);
                        msg.writer().writeShort(items.get(k).headTemp);
                        msg.writer().writeShort(items.get(k).bodyTemp);
                        msg.writer().writeShort(items.get(k).legTemp);
                        msg.writer().writeShort(items.get(k).bagTemp);

                    } else {
                        msg.writer().writeByte(0);
                    }
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void getBag(int charId, int bag) {
        Message msg = null;
        try {
            msg = new Message(-64);
            msg.writer().writeInt(charId);
            msg.writer().writeByte(bag);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getBagImg(ClanImage clanImage) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-63);
            msg.writer().writeByte(clanImage.ID);
            msg.writer().writeByte(clanImage.idImage.length);
            for (i = 0; i < clanImage.idImage.length; i++) {
                msg.writer().writeShort(clanImage.idImage[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void clanImage(ClanImage clanImage) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-62);
            msg.writer().writeByte(clanImage.ID);
            msg.writer().writeByte(clanImage.idImage2.length + clanImage.idImage.length);
            for (i = 0; i < clanImage.idImage2.length; i++) {
                msg.writer().writeShort(clanImage.idImage2[i]);
            }
            for (i = 0; i < clanImage.idImage.length; i++) {
                msg.writer().writeShort(clanImage.idImage[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getClan(int action) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-46);
            msg.writer().writeByte(action);
            msg.writer().writeByte(ClanImage.clanImage.length);
            for (i = 0; i < ClanImage.clanImage.length; i++) {
                msg.writer().writeByte(ClanImage.clanImage[i][0]);
                msg.writer().writeUTF(ClanImage.images.get(ClanImage.clanImage[i][0]).name);
                msg.writer().writeInt(ClanImage.clanImage[i][1]);
                msg.writer().writeInt(ClanImage.clanImage[i][2]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setClan(int imgID, String text) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-46);
            msg.writer().writeByte(4);
            msg.writer().writeByte(imgID);
            msg.writer().writeUTF(text);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void serverScreen() {
        Message msg = null;
        try {
            msg = new Message(-88);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void startYesNoDlg(int b, String str1, String str2) {
        Message msg = null;
        try {
            msg = new Message(-98);
            msg.writer().writeByte(b);
            if (b == 0) {
                msg.writer().writeUTF(str1);
                msg.writer().writeUTF(str2);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void itemRequest(int itemAction, int where, int index, String info) {
        Message msg = null;
        try {
            msg = new Message(-43);
            msg.writer().writeByte(itemAction);
            msg.writer().writeByte(where);
            msg.writer().writeByte(index);
            msg.writer().writeUTF(info);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void frendList(ArrayList<Friend> freinds) {
        Message msg = null;
        try {
            msg = new Message(-80);
            msg.writer().writeByte(0);
            msg.writer().writeByte(freinds.size());
            for (int i = 0; i < freinds.size(); i++) {
                Friend f = freinds.get(i);
                msg.writer().writeInt(f.playerId);
                msg.writer().writeShort(f.head);
                if (session.getIntVersion() >= 218) {
                    msg.writer().writeShort(f.headICON);
                }
                msg.writer().writeShort(f.body);
                msg.writer().writeShort(f.leg);
                msg.writer().writeByte(f.bag);
                msg.writer().writeUTF(f.name);
                msg.writer().writeBoolean(f.isOnline);
                msg.writer().writeUTF(Util.gI().numberTostring(f.power));
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void remove_frend(int playerId) {
        Message msg = null;
        try {
            msg = new Message(-80);
            msg.writer().writeByte(2);
            msg.writer().writeInt(playerId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void clanInfo(int role, Clan clan) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-53);
            if (clan != null) {
                msg.writer().writeInt(clan.ID);
                msg.writer().writeUTF(clan.name);
                msg.writer().writeUTF(clan.slogan);
                msg.writer().writeByte(clan.imgID);
                msg.writer().writeUTF(Util.gI().numberTostring(clan.powerPoint));
                msg.writer().writeUTF(clan.leaderName);
                msg.writer().writeByte(clan.members.size());
                msg.writer().writeByte(clan.maxMember);
                msg.writer().writeByte(role);
                msg.writer().writeInt(clan.clanPoint);
                msg.writer().writeByte(clan.level);
                for (i = 0; i < clan.members.size(); i++) {
                    ClanMember mem = clan.members.get(i);
                    msg.writer().writeInt(mem.ID);
                    msg.writer().writeShort(mem.head);
                    if (session.getIntVersion() >= 218) {
                        msg.writer().writeShort(mem.headICON);
                    }
                    msg.writer().writeShort(mem.leg);
                    msg.writer().writeShort(mem.body);
                    msg.writer().writeUTF(mem.name);
                    msg.writer().writeByte(mem.role);
                    msg.writer().writeUTF(Util.gI().numberTostring(mem.powerPoint));
                    msg.writer().writeInt(mem.donate);
                    msg.writer().writeInt(mem.receive_donate);
                    msg.writer().writeInt(mem.clanPoint);
                    msg.writer().writeInt(mem.curClanPoint);
                    msg.writer().writeInt(mem.joinTime + 25200);
                }
                msg.writer().writeByte(clan.messages.size());
                for (i = clan.messages.size() - 1; i >= 0; --i) {
                    this.writeClanMsg(msg, clan.messages.get(i));
                }
            } else {
                msg.writer().writeInt(-1);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void addClanMember(ClanMember member) {
        Message msg = null;
        try {
            msg = new Message(-52);
            msg.writer().writeByte(0);
            msg.writer().writeInt(member.ID);
            msg.writer().writeShort(member.head);
            if (session.getIntVersion() >= 218) {
                msg.writer().writeShort(member.headICON);
            }
            msg.writer().writeShort(member.leg);
            msg.writer().writeShort(member.body);
            msg.writer().writeUTF(member.name);
            msg.writer().writeByte(member.role);
            msg.writer().writeUTF(Util.gI().numberTostring(member.powerPoint));
            msg.writer().writeInt(member.donate);
            msg.writer().writeInt(member.receive_donate);
            msg.writer().writeInt(member.clanPoint);
            msg.writer().writeInt(member.joinTime + 25200);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void removeClanMember(int index) {
        Message msg = null;
        try {
            msg = new Message(-52);
            msg.writer().writeByte(1);
            msg.writer().writeByte(index);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setClanMember(ClanMember member) {
        Message msg = null;
        try {
            msg = new Message(-52);
            msg.writer().writeByte(2);
            msg.writer().writeInt(member.ID);
            msg.writer().writeShort(member.head);
            if (session.getIntVersion() >= 218) {
                msg.writer().writeShort(member.headICON);
            }
            msg.writer().writeShort(member.leg);
            msg.writer().writeShort(member.body);
            msg.writer().writeUTF(member.name);
            msg.writer().writeByte(member.role);
            msg.writer().writeUTF(Util.gI().numberTostring(member.powerPoint));
            msg.writer().writeInt(member.donate);
            msg.writer().writeInt(member.receive_donate);
            msg.writer().writeInt(member.clanPoint);
            msg.writer().writeInt(member.joinTime + 25200);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void findClan(ArrayList<Clan> list) {
        Message msg = null;
        try {
            msg = new Message(-47);
            msg.writer().writeByte(list.size());
            for (int i = 0; i < list.size(); i++) {
                Clan clan = list.get(i);
                msg.writer().writeInt(clan.ID);
                msg.writer().writeUTF(clan.name);
                msg.writer().writeUTF(clan.slogan);
                msg.writer().writeByte(clan.imgID);
                msg.writer().writeUTF(Util.gI().numberTostring(clan.powerPoint));
                msg.writer().writeUTF(clan.leaderName);
                msg.writer().writeByte(clan.members.size());
                msg.writer().writeByte(clan.maxMember);
                msg.writer().writeInt(clan.date + 25200);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void clanMember(Clan clan) {
        Message msg = null;
        int i;
        ClanMember mem;
        try {
            msg = new Message(-50);
            msg.writer().writeByte(clan.members.size());
            for (i = 0; i < clan.members.size(); i++) {
                mem = clan.members.get(i);
                msg.writer().writeInt(mem.ID);
                msg.writer().writeShort(mem.head);
                if (session.getIntVersion() >= 218) {
                    msg.writer().writeShort(mem.headICON);
                }
                msg.writer().writeShort(mem.leg);
                msg.writer().writeShort(mem.body);
                msg.writer().writeUTF(mem.name);
                msg.writer().writeByte(mem.role);
                msg.writer().writeUTF(Util.gI().numberTostring(mem.powerPoint));
                msg.writer().writeInt(mem.donate);
                msg.writer().writeInt(mem.receive_donate);
                msg.writer().writeInt(mem.clanPoint);
                msg.writer().writeInt(mem.joinTime + 25200);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void clanInvite(String strInvite, int clanID, int code) {
        Message msg = null;
        try {
            msg = new Message(-57);
            msg.writer().writeUTF(strInvite);
            msg.writer().writeInt(clanID);
            msg.writer().writeInt(code);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void writeClanMsg(Message msg, ClanMessage clanMsg) {
        try {
            msg.writer().writeByte(clanMsg.type);
            msg.writer().writeInt(clanMsg.id);
            msg.writer().writeInt(clanMsg.playerId);
            msg.writer().writeUTF(clanMsg.playerName);
            msg.writer().writeByte(clanMsg.role);
            msg.writer().writeInt(clanMsg.time - 1000000000);
            if (clanMsg.type == 0) {
                msg.writer().writeUTF(clanMsg.chat);
                msg.writer().writeByte(clanMsg.color);
            } else if (clanMsg.type == 1) {
                msg.writer().writeByte(clanMsg.recieve);
                msg.writer().writeByte(clanMsg.maxCap);
                msg.writer().writeByte(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClanMessage(ClanMessage clanMsg) {
        Message msg = null;
        try {
            msg = new Message(-51);
            writeClanMsg(msg, clanMsg);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openNewMenuUI(String[] arrMenu) {
        Message msg = null;
        try {
            int i;
            msg = new Message(57);
            if (arrMenu != null && arrMenu.length > 0) {
                for (i = 0; i < arrMenu.length; i++) {
                    msg.writer().writeUTF(arrMenu[i]);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    /**
     * Hàm mở giao diện nhập liệu từ client
     * 
     * @param title Tiêu đề giao diện
     * @param name  Mảng tên các trường nhập liệu
     * @param type  Mảng kiểu dữ liệu tương ứng với các trường nhập liệu (trong
     *              name)
     */
    public void openClientInput(String title, String[] name, int[] type) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-125);
            msg.writer().writeUTF(title);
            msg.writer().writeByte(name.length);
            for (i = 0; i < name.length; i++) {
                msg.writer().writeUTF(name[i]);
                msg.writer().writeByte(type[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void inputCard() {
        Message msg = null;
        try {
            msg = this.messageNotMap(16);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void addInfo(String s) {
        Message msg = null;
        try {
            msg = this.messageNotMap(35);
            msg.writer().writeUTF(s);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void top(Rank rank) {
        Message msg = null;
        try {
            msg = new Message(-96);
            msg.writer().writeByte(rank.typeTop);
            msg.writer().writeUTF(rank.topName);
            msg.writer().writeByte(rank.tops.size());
            for (int i = 0; i < rank.tops.size(); i++) {
                Rank.TopInfo top = rank.tops.get(i);
                msg.writer().writeInt(top.rank);
                msg.writer().writeInt(top.pId);
                msg.writer().writeShort(top.headID);
                if (session.getIntVersion() >= 218) {
                    msg.writer().writeShort(top.headICON);
                }
                msg.writer().writeShort(top.body);
                msg.writer().writeShort(top.leg);
                msg.writer().writeUTF(top.name);
                if (rank.rankId == 0) {
                    msg.writer().writeUTF(String.format(mResources.TOP_GAS_INFO_1, top.point,
                            Util.gI().getFormatTime2(System.currentTimeMillis() - top.lastTime)));
                    msg.writer().writeUTF(String.format(mResources.TOP_GAS_INFO_2, Clan.getClan(top.name).leaderName,
                            Util.gI().getFormatTime3(top.time)));
                }
                if (rank.rankId == 1) {
                    msg.writer().writeUTF(String.format(mResources.TOP_CT_INFO_1, Util.gI().numberTostring(top.point),
                            Util.gI().getFormatTime2(System.currentTimeMillis() - top.lastTime)));
                    msg.writer()
                            .writeUTF(String.format(mResources.TOP_CT_INFO_2, Util.gI().getFormatNumber(top.point)));
                }
                if (rank.rankId == 2) {
                    msg.writer().writeUTF(String.format(mResources.TOP_DG_INFO_1, Util.gI().numberTostring(top.point),
                            Util.gI().getFormatTime2(System.currentTimeMillis() - top.lastTime)));
                    msg.writer()
                            .writeUTF(String.format(mResources.TOP_DG_INFO_2, Util.gI().getFormatNumber(top.point)));
                }
                if (rank.rankId == 3) {
                    msg.writer().writeUTF(String.format(mResources.TOP_SK_INFO_1, Util.gI().numberTostring(top.point),
                            Util.gI().getFormatTime2(System.currentTimeMillis() - top.lastTime)));
                    msg.writer()
                            .writeUTF(String.format(mResources.TOP_SK_INFO_2, Util.gI().getFormatNumber(top.point)));
                }
                if (rank.rankId == 4) {
                    msg.writer().writeUTF(String.format(mResources.TOP_SK_INFO_1, Util.gI().numberTostring(top.point),
                            Util.gI().getFormatTime2(System.currentTimeMillis() - top.lastTime)));
                    msg.writer()
                            .writeUTF(String.format(mResources.TOP_SK_INFO_2, Util.gI().getFormatNumber(top.point)));
                }
                if (rank.rankId == 5) {
                    msg.writer().writeUTF(String.format(mResources.TOP_GAS_INFO_1, top.point,
                            Util.gI().getFormatTime2(System.currentTimeMillis() - top.lastTime)));
                    msg.writer().writeUTF(String.format(mResources.TOP_GAS_INFO_2, Clan.getClan(top.name).leaderName,
                            Util.gI().getFormatTime3(top.time)));
                }
                if (rank.rankId == 6) {
                    msg.writer().writeUTF(Server.gI().isHaveByCName(top.name) ? mResources.ONLINE : mResources.EMPTY);
                    msg.writer().writeUTF("...");
                }
                if (rank.rankId == 7) {
                    msg.writer().writeUTF(String.format(mResources.TOP_PHOBAN_INFO_1, top.point,
                            Util.gI().getFormatTime2(System.currentTimeMillis() - top.lastTime)));
                    msg.writer().writeUTF(String.format(mResources.TOP_PHOBAN_INFO_2, Clan.getClan(top.name).leaderName,
                            Util.gI().getFormatTime3(top.time)));
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void top2() {
        Message msg = null;
        int i;
        try {
            msg = new Message(-96);
            msg.writer().writeByte(0);
            msg.writer().writeUTF("Top 2");
            msg.writer().writeByte(2);
            for (i = 0; i < 2; i++) {
                msg.writer().writeInt(i + 1);
                msg.writer().writeInt(i);
                msg.writer().writeShort(0);
                msg.writer().writeShort(1);
                msg.writer().writeShort(2);
                msg.writer().writeUTF("rongma" + (i + 1));
                msg.writer().writeUTF("ok");
                msg.writer().writeUTF("okz");
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getTask(int gender, int taskId, int taskIndex, int taskCount) {
        Message msg = null;
        int i;
        boolean b = false;
        try {
            msg = new Message(40);
            msg.writer().writeShort(taskId);
            msg.writer().writeByte(taskIndex);
            msg.writer().writeUTF(Task.getTask(taskId).name[gender]);
            msg.writer().writeUTF(Task.getTask(taskId).detail[gender]);
            msg.writer().writeByte(Task.getTask(taskId).subNames[gender].length);
            for (i = 0; i < Task.getTask(taskId).subNames[gender].length; i++) {
                msg.writer().writeUTF(Task.getTask(taskId).subNames[gender][i]);
                msg.writer().writeByte(Task.getTask(taskId).tasks[gender][i]);
                msg.writer().writeShort(Task.getTask(taskId).mapTasks[gender][i]);
                msg.writer().writeUTF(Task.getTask(taskId).contentInfo[gender][i]);
            }
            for (i = 0; i < Task.getTask(taskId).counts[gender].length; i++) {
                if (Task.getTask(taskId).counts[gender][i] != -1) {
                    b = true;
                    break;
                }
            }
            if (b) {
                msg.writer().writeShort(taskCount);
                for (i = 0; i < Task.getTask(taskId).counts[gender].length; i++) {
                    msg.writer().writeShort(Task.getTask(taskId).counts[gender][i]);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void saleItem(int type, int id, String info) {
        Message msg = null;
        try {
            msg = new Message(7);
            msg.writer().writeByte(type);
            msg.writer().writeShort(id);
            msg.writer().writeUTF(info);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void rada() {
        Message msg = null;
        try {
            msg = new Message(127);
            msg.writer().writeByte(0);
            msg.writer().writeShort(RadaTemplate.arrRadaTemplate.length);
            for (int i = 0; i < RadaTemplate.arrRadaTemplate.length; i++) {
                msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].id);
                msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].idIcon);
                msg.writer().writeByte(RadaTemplate.arrRadaTemplate[i].rank);
                msg.writer().writeByte(this.session.myCharz().getCardAmount(RadaTemplate.arrRadaTemplate[i].id));
                msg.writer().writeByte(RadaTemplate.arrRadaTemplate[i].max_amount);
                if (RadaTemplate.arrRadaTemplate[i].templateId != -1) {
                    msg.writer().writeByte(0);
                    msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].templateId);
                } else {
                    msg.writer().writeByte(1);
                    msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].head);
                    msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].body);
                    msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].leg);
                    msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].bag);
                }
                msg.writer().writeUTF(RadaTemplate.arrRadaTemplate[i].name);
                msg.writer().writeUTF(RadaTemplate.arrRadaTemplate[i].info);
                msg.writer().writeByte(this.session.myCharz().getCardLevel(RadaTemplate.arrRadaTemplate[i].id));
                msg.writer().writeByte(this.session.myCharz().isUseCard(RadaTemplate.arrRadaTemplate[i].id));
                msg.writer().writeByte(RadaTemplate.arrRadaTemplate[i].options.size());
                for (int j = 0; j < RadaTemplate.arrRadaTemplate[i].options.size(); j++) {
                    msg.writer().writeByte(RadaTemplate.arrRadaTemplate[i].options.get(j).optionTemplate.id);
                    msg.writer().writeShort(RadaTemplate.arrRadaTemplate[i].options.get(j).param);
                    msg.writer().writeByte(RadaTemplate.arrRadaTemplate[i].options.get(j).activeCard);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void addCard(int id, int amount, int max_amount) {
        Message msg = null;
        try {
            msg = new Message(127);
            msg.writer().writeByte(3);
            msg.writer().writeShort(id);
            msg.writer().writeByte(amount);
            msg.writer().writeByte(max_amount);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setRadaLevel(int id, int level) {
        Message msg = null;
        try {
            msg = new Message(127);
            msg.writer().writeByte(2);
            msg.writer().writeShort(id);
            msg.writer().writeByte(level);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void isUseCard(int id, int b) {
        Message msg = null;
        try {
            msg = new Message(127);
            msg.writer().writeByte(1);
            msg.writer().writeShort(id);
            msg.writer().writeByte(b);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getAuraEff(int charId, int idAuraEff) {
        Message msg = null;
        try {
            msg = new Message(127);
            msg.writer().writeByte(4);
            msg.writer().writeInt(charId);
            msg.writer().writeShort(idAuraEff);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void petFollow(int charId, int smallID, int fimg, int[] frameNew, int wimg, int himg) {
        Message msg = null;
        try {
            msg = new Message(31);
            msg.writer().writeInt(charId);
            msg.writer().writeByte(1);
            msg.writer().writeShort(smallID);
            if (fimg != -1) {
                msg.writer().writeByte(fimg);
                msg.writer().writeByte(frameNew.length);
                for (int i = 0; i < frameNew.length; i++) {
                    msg.writer().writeByte(frameNew[i]);
                }
                msg.writer().writeShort(wimg);
                msg.writer().writeShort(himg);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void clearPetFollow(int charId) {
        Message msg = null;
        try {
            msg = new Message(31);
            msg.writer().writeInt(charId);
            msg.writer().writeByte(0);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void messageTime(int id, String text, int time) {
        Message msg = null;
        try {
            msg = new Message(65);
            msg.writer().writeByte(id);
            msg.writer().writeUTF(text);
            msg.writer().writeShort(time);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void stoneMe(int charId, int eff) {
        Message msg = null;
        try {
            msg = new Message(-124);
            msg.writer().writeByte(eff > 0 ? 1 : 0);
            msg.writer().writeByte(0);
            msg.writer().writeByte(42);
            msg.writer().writeInt(charId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    private void writeDart(Message msg) throws IOException {
        int i1, i2, i3;
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(ab);
        dataOutputStream.writeShort(DartInfo.darts.length);
        for (i1 = 0; i1 < DartInfo.darts.length; i1++) {
            dataOutputStream.writeShort(DartInfo.darts[i1].id);
            dataOutputStream.writeShort(DartInfo.darts[i1].nUpdate);
            dataOutputStream.writeShort(DartInfo.darts[i1].va);
            dataOutputStream.writeShort(DartInfo.darts[i1].xdPercent);
            dataOutputStream.writeShort(DartInfo.darts[i1].tail.length);
            for (i2 = 0; i2 < DartInfo.darts[i1].tail.length; i2++) {
                dataOutputStream.writeShort(DartInfo.darts[i1].tail[i2]);
            }
            dataOutputStream.writeShort(DartInfo.darts[i1].tailBorder.length);
            for (i2 = 0; i2 < DartInfo.darts[i1].tailBorder.length; i2++) {
                dataOutputStream.writeShort(DartInfo.darts[i1].tailBorder[i2]);
            }
            dataOutputStream.writeShort(DartInfo.darts[i1].xd1.length);
            for (i2 = 0; i2 < DartInfo.darts[i1].xd1.length; i2++) {
                dataOutputStream.writeShort(DartInfo.darts[i1].xd1[i2]);
            }
            dataOutputStream.writeShort(DartInfo.darts[i1].xd2.length);
            for (i2 = 0; i2 < DartInfo.darts[i1].xd2.length; i2++) {
                dataOutputStream.writeShort(DartInfo.darts[i1].xd2[i2]);
            }
            dataOutputStream.writeShort(DartInfo.darts[i1].head.length);
            for (i2 = 0; i2 < DartInfo.darts[i1].head.length; i2++) {
                dataOutputStream.writeShort(DartInfo.darts[i1].head[i2].length);
                for (i3 = 0; i3 < DartInfo.darts[i1].head[i2].length; i3++) {
                    dataOutputStream.writeShort(DartInfo.darts[i1].head[i2][i3]);
                }
            }
            dataOutputStream.writeShort(DartInfo.darts[i1].headBorder.length);
            for (i2 = 0; i2 < DartInfo.darts[i1].headBorder.length; i2++) {
                dataOutputStream.writeShort(DartInfo.darts[i1].headBorder[i2].length);
                for (i3 = 0; i3 < DartInfo.darts[i1].headBorder[i2].length; i3++) {
                    dataOutputStream.writeShort(DartInfo.darts[i1].headBorder[i2][i3]);
                }
            }
        }
        msg.writer().writeInt(dataOutputStream.size());
        msg.writer().write(ab.toByteArray());
    }

    private void writeArrow(Message msg) throws IOException {
        int i1;
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(ab);
        dataOutputStream.writeShort(Arrow.arrs.length);
        for (i1 = 0; i1 < Arrow.arrs.length; i1++) {
            dataOutputStream.writeShort(Arrow.arrs[i1].id);
            dataOutputStream.writeShort(Arrow.arrs[i1].imgId[0]);
            dataOutputStream.writeShort(Arrow.arrs[i1].imgId[1]);
            dataOutputStream.writeShort(Arrow.arrs[i1].imgId[2]);
        }
        msg.writer().writeInt(dataOutputStream.size());
        msg.writer().write(ab.toByteArray());
    }

    private void writeEffect(Message msg) throws IOException {
        int i1, i2;
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(ab);
        dataOutputStream.writeShort(EffectCharPaint.efs.length);
        for (i1 = 0; i1 < EffectCharPaint.efs.length; i1++) {
            dataOutputStream.writeShort(EffectCharPaint.efs[i1].idEf);
            dataOutputStream.writeByte(EffectCharPaint.efs[i1].arrEfInfo.length);
            for (i2 = 0; i2 < EffectCharPaint.efs[i1].arrEfInfo.length; i2++) {
                dataOutputStream.writeShort(EffectCharPaint.efs[i1].arrEfInfo[i2].idImg);
                dataOutputStream.writeByte(EffectCharPaint.efs[i1].arrEfInfo[i2].dx);
                dataOutputStream.writeByte(EffectCharPaint.efs[i1].arrEfInfo[i2].dy);
            }
        }
        msg.writer().writeInt(dataOutputStream.size());
        msg.writer().write(ab.toByteArray());
    }

    private void writeImage(Message msg) throws IOException {
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(ab);
        dataOutputStream.writeShort(SmallImage.smallImg.length);
        for (int i1 = 0; i1 < SmallImage.smallImg.length; i1++) {
            dataOutputStream.writeByte(SmallImage.smallImg[i1][0]);
            dataOutputStream.writeShort(SmallImage.smallImg[i1][1]);
            dataOutputStream.writeShort(SmallImage.smallImg[i1][2]);
            dataOutputStream.writeShort(SmallImage.smallImg[i1][3]);
            dataOutputStream.writeShort(SmallImage.smallImg[i1][4]);
        }
        msg.writer().writeInt(dataOutputStream.size());
        msg.writer().write(ab.toByteArray());
    }

    private void writePart(Message msg) throws IOException {
        int i;
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream o = new DataOutputStream(ab);
        o.writeShort(Part.parts.length);
        for (i = 0; i < Part.parts.length; i++) {
            o.writeByte(Part.parts[i].type);
            int j;
            for (j = 0; j < Part.parts[i].pi.length; j++) {
                o.writeShort(Part.parts[i].pi[j].id);
                o.writeByte(Part.parts[i].pi[j].dx);
                o.writeByte(Part.parts[i].pi[j].dy);
            }
        }
        msg.writer().writeInt(o.size());
        msg.writer().write(ab.toByteArray());
    }

    private void writeSkill(Message msg) throws IOException {
        int i1, i2;
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(ab);
        dataOutputStream.writeShort(SkillPaint.sks.length);
        for (i1 = 0; i1 < SkillPaint.sks.length; i1++) {
            dataOutputStream.writeShort(SkillPaint.sks[i1].id);
            dataOutputStream.writeShort(SkillPaint.sks[i1].effectHappenOnMob);
            dataOutputStream.writeByte(SkillPaint.sks[i1].numEff);
            dataOutputStream.writeByte(SkillPaint.sks[i1].skillStand.length);
            for (i2 = 0; i2 < SkillPaint.sks[i1].skillStand.length; i2++) {
                dataOutputStream.writeByte(SkillPaint.sks[i1].skillStand[i2].status);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].effS0Id);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].e0dx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].e0dy);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].effS1Id);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].e1dx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].e1dy);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].effS2Id);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].e2dx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].e2dy);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].arrowId);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].adx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillStand[i2].ady);
            }
            dataOutputStream.writeByte(SkillPaint.sks[i1].skillfly.length);
            for (i2 = 0; i2 < SkillPaint.sks[i1].skillfly.length; i2++) {
                dataOutputStream.writeByte(SkillPaint.sks[i1].skillfly[i2].status);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].effS0Id);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].e0dx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].e0dy);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].effS1Id);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].e1dx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].e1dy);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].effS2Id);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].e2dx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].e2dy);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].arrowId);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].adx);
                dataOutputStream.writeShort(SkillPaint.sks[i1].skillfly[i2].ady);
            }
        }
        msg.writer().writeInt(dataOutputStream.size());
        msg.writer().write(ab.toByteArray());
    }

    public void tMabu(int percentMabu) {
        Message msg = null;
        try {
            msg = new Message(-117);
            msg.writer().writeByte(percentMabu);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setStatus(int id, int[] duahau, int duaHauIndex, int second) {
        Message msg = null;
        int i;
        try {
            msg = new Message(-122);
            msg.writer().writeShort(id);
            msg.writer().writeByte(duahau.length);
            for (i = 0; i < duahau.length; i++) {
                msg.writer().writeShort(duahau[i]);
            }
            msg.writer().writeByte(duaHauIndex);
            msg.writer().writeInt(second < 0 ? 0 : second);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBossFly(int x, int y) {
        Message msg = null;
        try {
            msg = new Message(101);
            msg.writer().writeByte(3);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBossMove(int x, int y) {
        Message msg = null;
        try {
            msg = new Message(101);
            msg.writer().writeByte(8);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBossMove() {
        Message msg = null;
        try {
            msg = new Message(101);
            msg.writer().writeByte(9);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBossAttack(int type, ArrayList<Integer> ch, ArrayList<Integer> dam) {
        Message msg = null;
        int i;
        try {
            msg = new Message(101);
            msg.writer().writeByte(type);
            msg.writer().writeByte(ch.size());
            for (i = 0; i < ch.size(); i++) {
                msg.writer().writeInt(ch.get(i));
                msg.writer().writeInt(dam.get(i));
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBossAttack() {
        Message msg = null;
        int i;
        try {
            msg = new Message(101);
            msg.writer().writeByte(7);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBossB2(int x, int y) {
        Message msg = null;
        try {
            msg = new Message(101);
            msg.writer().writeByte(6);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBosshaftBody() {
        Message msg = null;
        try {
            msg = new Message(101);
            msg.writer().writeByte(5);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void showYourNumber(String str) {
        Message msg = null;
        try {
            msg = new Message(-126);
            msg.writer().writeByte(0);
            msg.writer().writeUTF(str);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void showWinNumber(String num, String finish) {
        Message msg = null;
        try {
            msg = new Message(-126);
            msg.writer().writeByte(1);
            msg.writer().writeByte(0);
            msg.writer().writeUTF(num);
            msg.writer().writeUTF(finish);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void npcChat(int npcId, String chat) {
        Message msg = null;
        try {
            msg = new Message(124);
            msg.writer().writeShort(npcId);
            msg.writer().writeUTF(chat);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void addEffectServer(int loop, int layer, int id, int x, int y, int loopCount) {
        Message msg = null;
        try {
            msg = new Message(113);
            msg.writer().writeByte(loop);
            msg.writer().writeByte(layer);
            msg.writer().writeByte(id);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            msg.writer().writeShort(loopCount);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getTaskOrder(int taskId, int count, int maxCount, String name, String description, int killId,
            int mapId) {
        Message msg = null;
        try {
            msg = new Message(96);
            msg.writer().writeByte(taskId);
            msg.writer().writeShort(count);
            msg.writer().writeShort(maxCount);
            msg.writer().writeUTF(name);
            msg.writer().writeUTF(description);
            msg.writer().writeByte(killId);
            msg.writer().writeByte(mapId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getTaskCount(int count) {
        Message msg = null;
        try {
            msg = new Message(43);
            msg.writer().writeShort(count);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void nextTaskIndex() {
        Message msg = null;
        try {
            msg = new Message(41);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void hideNpc(int npcTemplateId, int b) {
        Message msg = null;
        try {
            msg = new Message(-73);
            msg.writer().writeByte(npcTemplateId);
            msg.writer().writeByte(b);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setPowerInfo(String info, int p, int maxP, int sc) {
        Message msg = null;
        try {
            msg = new Message(-115);
            msg.writer().writeUTF(info);
            msg.writer().writeShort(p);
            msg.writer().writeShort(maxP);
            msg.writer().writeShort(sc);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void gameInfo(ArrayList<GameInfo> gameinfos) {
        Message msg = null;
        int i;
        try {
            msg = new Message(50);
            msg.writer().writeByte(gameinfos.size());
            for (i = 0; i < gameinfos.size(); i++) {
                msg.writer().writeShort(gameinfos.get(i).id);
                msg.writer().writeUTF(gameinfos.get(i).main);
                msg.writer().writeUTF(gameinfos.get(i).content);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setArchive(ArrayList<AchievementTask> myList) {
        Message msg = null;
        try {
            msg = new Message(-76);
            msg.writer().writeByte(0);
            msg.writer().writeByte(myList.size());
            for (int i = 0; i < myList.size(); i++) {
                if (Achievement.get(myList.get(i).id).gold > 0 && !myList.get(i).isReceive) {
                    msg.writer()
                            .writeUTF(String.format(mResources.TASK_AND_GOLD, Achievement.get(myList.get(i).id).info1,
                                    Util.gI().numberTostring(Achievement.get(myList.get(i).id).gold)));
                } else {
                    msg.writer().writeUTF(Achievement.get(myList.get(i).id).info1);
                }
                if (Achievement.get(myList.get(i).id).max == -1) {
                    msg.writer().writeUTF(Achievement.get(myList.get(i).id).info2);
                } else {
                    msg.writer()
                            .writeUTF(String.format(mResources.TASK_AND_COUNT, Achievement.get(myList.get(i).id).info2,
                                    Util.gI().numberTostring(myList.get(i).count),
                                    Util.gI().numberTostring(Achievement.get(myList.get(i).id).max)));
                }
                msg.writer().writeShort(Achievement.get(myList.get(i).id).money);
                msg.writer().writeBoolean(myList.get(i).isFinish);
                msg.writer().writeBoolean(myList.get(i).isReceive);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setArchive(int index) {
        Message msg = null;
        try {
            msg = new Message(-76);
            msg.writer().writeByte(1);
            msg.writer().writeByte(index);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void eat(int charId, int playerId) {
        Message msg = null;
        try {
            msg = new Message(52);
            msg.writer().writeByte(2);
            msg.writer().writeInt(charId);
            msg.writer().writeInt(playerId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setMabuHold(boolean isMabuHold, int charId, int x, int y) {
        Message msg = null;
        try {
            msg = new Message(52);
            if (isMabuHold) {
                msg.writer().writeByte(1);
                msg.writer().writeInt(charId);
                msg.writer().writeShort(x);
                msg.writer().writeShort(y);
            } else {
                msg.writer().writeByte(0);
                msg.writer().writeInt(charId);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setSkill(int charId, int skillID, int x, int y, int[] array, int[] array2) {
        Message msg = null;
        try {
            msg = new Message(51);
            msg.writer().writeInt(charId);
            msg.writer().writeByte(skillID);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                msg.writer().writeInt(array[i]);
                msg.writer().writeInt(array2[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBoss2Cut(int[] array, int[] array2) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(0);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                msg.writer().writeInt(array[i]);
                msg.writer().writeInt(array2[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBoss2Away(int[] array, int[] array2) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(1);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                msg.writer().writeInt(array[i]);
                msg.writer().writeInt(array2[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBoss2Fly(int[] array, int[] array2) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(2);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                msg.writer().writeInt(array[i]);
                msg.writer().writeInt(array2[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bachtuocRock(int[] array, int[] array2) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(3);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                msg.writer().writeInt(array[i]);
                msg.writer().writeInt(array2[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bachtuocAway(int[] array, int[] array2) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(4);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                msg.writer().writeInt(array[i]);
                msg.writer().writeInt(array2[i]);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bachtuocMove(int x) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(5);
            msg.writer().writeShort(x);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigBoss2haftBody() {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(6);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bachtuochaftBody() {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(7);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    private void writeData(Message msg, EffectData eff) throws IOException {
        int i, j, k, l;
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream o = new DataOutputStream(ab);
        //
        o.writeByte(eff.imgInfo.length);
        for (i = 0; i < eff.imgInfo.length; i++) {
            o.writeByte(eff.imgInfo[i][0]);
            o.writeByte(eff.imgInfo[i][1]);
            o.writeByte(eff.imgInfo[i][2]);
            o.writeByte(eff.imgInfo[i][3]);
            o.writeByte(eff.imgInfo[i][4]);
        }
        //
        o.writeShort(eff.frame.length);
        for (j = 0; j < eff.frame.length; j++) {
            o.writeByte(eff.frame[j].length);
            for (k = 0; k < eff.frame[j].length; k++) {
                o.writeShort(eff.frame[j][k][0]);
                o.writeShort(eff.frame[j][k][1]);
                o.writeByte(eff.frame[j][k][2]);
            }
        }
        //
        o.writeShort(eff.arrFrame.length);
        for (l = 0; l < eff.arrFrame.length; l++) {
            o.writeShort(eff.arrFrame[l]);
        }
        //
        msg.writer().writeInt(o.size());
        msg.writer().write(ab.toByteArray());
    }

    private void writeDataNewBoss(Message msg, EffectData eff) throws IOException {
        int i, j, k, l;
        ByteArrayOutputStream ab = new ByteArrayOutputStream();
        DataOutputStream o = new DataOutputStream(ab);
        //
        o.writeByte(eff.imgInfo.length);
        for (i = 0; i < eff.imgInfo.length; i++) {
            o.writeByte(eff.imgInfo[i][0]);
            if (eff.typeread == 1) {
                o.writeByte(eff.imgInfo[i][1]);
                o.writeByte(eff.imgInfo[i][2]);
            } else {
                o.writeShort(eff.imgInfo[i][1]);
                o.writeShort(eff.imgInfo[i][2]);
            }
            o.writeByte(eff.imgInfo[i][3]);
            o.writeByte(eff.imgInfo[i][4]);
        }
        //
        o.writeShort(eff.frame.length);
        for (j = 0; j < eff.frame.length; j++) {
            o.writeByte(eff.frame[j].length);
            for (k = 0; k < eff.frame[j].length; k++) {
                o.writeShort(eff.frame[j][k][0]);
                o.writeShort(eff.frame[j][k][1]);
                o.writeByte(eff.frame[j][k][2]);
            }
        }
        //
        o.writeShort(eff.arrFrame.length);
        for (l = 0; l < eff.arrFrame.length; l++) {
            o.writeShort(eff.arrFrame[l]);
        }
        //
        msg.writer().writeInt(o.size());
        msg.writer().write(ab.toByteArray());
    }

    private void writeFrameBoss(Message msg, int[][] frameBoss) throws IOException {
        msg.writer().writeByte(frameBoss.length);
        int i, j;
        for (i = 0; i < frameBoss.length; i++) {
            msg.writer().writeByte(frameBoss[i].length);
            for (j = 0; j < frameBoss[i].length; j++) {
                msg.writer().writeByte(frameBoss[i][j]);
            }
        }
    }

    public void shopKyGui(String[] shopName, ArrayList<ItemKyGui>[] arrItem) {
        Message msg = null;
        int i;
        int k;
        int m;
        try {
            msg = new Message(-44);
            msg.writer().writeByte(2);
            msg.writer().writeByte(shopName.length);
            for (i = 0; i < shopName.length; i++) {
                msg.writer().writeUTF(shopName[i]);
                msg.writer().writeByte(ItemKyGui.maxPageShop(this.session.myCharz(), i));
                msg.writer().writeByte(arrItem[i].size());
                for (k = 0; k < arrItem[i].size(); k++) {
                    msg.writer().writeShort(arrItem[i].get(k).item.template.id);
                    msg.writer().writeShort(arrItem[i].get(k).item.itemId);
                    msg.writer().writeInt(arrItem[i].get(k).item.buyCoin);
                    msg.writer().writeInt(arrItem[i].get(k).item.buyGold);
                    msg.writer().writeByte(arrItem[i].get(k).item.buyType);
                    if (this.session.getIntVersion() >= 222) {
                        msg.writer().writeInt(arrItem[i].get(k).item.quantity);
                    } else {
                        msg.writer().writeByte(arrItem[i].get(k).item.quantity);
                    }
                    msg.writer().writeByte((arrItem[i].get(k).playerId == this.session.myCharz().playerId) ? 1 : 0);
                    if (arrItem[i].get(k).item.options.isEmpty()) {
                        msg.writer().writeByte(1);
                        msg.writer().writeByte(73);
                        msg.writer().writeShort(0);
                    } else {
                        msg.writer().writeByte(arrItem[i].get(k).item.options.size());
                        for (m = 0; m < arrItem[i].get(k).item.options.size(); m++) {
                            if (arrItem[i].get(k).item.template.type == 13
                                    && arrItem[i].get(k).item.options.get(m).optionTemplate.id == 66
                                    && this.session.myCharz().isExistAmu(arrItem[i].get(k).item.template.id)) {
                                Amu amu = this.session.myCharz().getAmuById(arrItem[i].get(k).item.template.id);
                                if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60 * 24) {
                                    msg.writer().writeByte(63);
                                    msg.writer().writeShort((int) (((amu.second - (System.currentTimeMillis() / 1000)))
                                            / (60 * 60 * 24)));
                                } else if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60) {
                                    msg.writer().writeByte(64);
                                    msg.writer().writeShort(
                                            (int) ((amu.second - (System.currentTimeMillis() / 1000)) / (60 * 60)));
                                } else {
                                    msg.writer().writeByte(65);
                                    msg.writer().writeShort(
                                            (int) ((amu.second - (System.currentTimeMillis() / 1000)) / 60));
                                }
                            } else {
                                msg.writer().writeByte(arrItem[i].get(k).item.options.get(m).optionTemplate.id);
                                msg.writer().writeShort(arrItem[i].get(k).item.options.get(m).param);
                            }
                        }
                    }

                    msg.writer().writeByte(0);
                    if (arrItem[i].get(k).item.headTemp != -1 || arrItem[i].get(k).item.bodyTemp != -1
                            || arrItem[i].get(k).item.legTemp != -1 || arrItem[i].get(k).item.bagTemp != -1) {
                        msg.writer().writeByte(1);
                        msg.writer().writeShort(arrItem[i].get(k).item.headTemp);
                        msg.writer().writeShort(arrItem[i].get(k).item.bodyTemp);
                        msg.writer().writeShort(arrItem[i].get(k).item.legTemp);
                        msg.writer().writeShort(arrItem[i].get(k).item.bagTemp);

                    } else {
                        msg.writer().writeByte(0);
                    }
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void shopKyGui(int index, int maxPageShop, int currPageShop, ArrayList<ItemKyGui> list_kygui) {
        Message msg = null;
        int k;
        int m;
        try {
            msg = new Message(-100);
            msg.writer().writeByte(index);
            msg.writer().writeByte(maxPageShop);
            msg.writer().writeByte(currPageShop);
            msg.writer().writeByte(list_kygui.size());
            for (k = 0; k < list_kygui.size(); k++) {
                msg.writer().writeShort(list_kygui.get(k).item.template.id);
                msg.writer().writeShort(list_kygui.get(k).item.itemId);
                msg.writer().writeInt(list_kygui.get(k).item.buyCoin);
                msg.writer().writeInt(list_kygui.get(k).item.buyGold);
                msg.writer().writeByte(list_kygui.get(k).item.buyType);
                if (this.session.getIntVersion() >= 222) {
                    msg.writer().writeInt(list_kygui.get(k).item.quantity);
                } else {
                    msg.writer().writeByte(list_kygui.get(k).item.quantity);
                }
                msg.writer().writeByte((list_kygui.get(k).playerId == this.session.myCharz().playerId) ? 1 : 0);
                if (list_kygui.get(k).item.options.isEmpty()) {
                    msg.writer().writeByte(1);
                    msg.writer().writeByte(73);
                    msg.writer().writeShort(0);
                } else {
                    msg.writer().writeByte(list_kygui.get(k).item.options.size());
                    for (m = 0; m < list_kygui.get(k).item.options.size(); m++) {
                        if (list_kygui.get(k).item.template.type == 13
                                && list_kygui.get(k).item.options.get(m).optionTemplate.id == 66
                                && this.session.myCharz().isExistAmu(list_kygui.get(k).item.template.id)) {
                            Amu amu = this.session.myCharz().getAmuById(list_kygui.get(k).item.template.id);
                            if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60 * 24) {
                                msg.writer().writeByte(63);
                                msg.writer().writeShort(
                                        (int) (((amu.second - (System.currentTimeMillis() / 1000))) / (60 * 60 * 24)));
                            } else if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60) {
                                msg.writer().writeByte(64);
                                msg.writer().writeShort(
                                        (int) ((amu.second - (System.currentTimeMillis() / 1000)) / (60 * 60)));
                            } else {
                                msg.writer().writeByte(65);
                                msg.writer()
                                        .writeShort((int) ((amu.second - (System.currentTimeMillis() / 1000)) / 60));
                            }
                        } else {
                            msg.writer().writeByte(list_kygui.get(k).item.options.get(m).optionTemplate.id);
                            msg.writer().writeShort(list_kygui.get(k).item.options.get(m).param);
                        }
                    }
                }
                if (list_kygui.get(k).item.headTemp != -1 || list_kygui.get(k).item.bodyTemp != -1
                        || list_kygui.get(k).item.legTemp != -1 || list_kygui.get(k).item.bagTemp != -1) {
                    msg.writer().writeByte(1);
                    msg.writer().writeShort(list_kygui.get(k).item.headTemp);
                    msg.writer().writeShort(list_kygui.get(k).item.bodyTemp);
                    msg.writer().writeShort(list_kygui.get(k).item.legTemp);
                    msg.writer().writeShort(list_kygui.get(k).item.bagTemp);

                } else {
                    msg.writer().writeByte(0);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void addCuuSat(int charId) {
        Message msg = null;
        try {
            msg = new Message(62);
            msg.writer().writeInt(charId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void meCuuSat(int charId) {
        Message msg = null;
        try {
            msg = new Message(63);
            msg.writer().writeInt(charId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void autoServer() {
        Message msg = null;
        try {
            msg = new Message(48);
            msg.writer().writeByte(0);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void meThrow(int itemMapID, int indexUI, int xEnd, int yEnd) {
        Message msg = null;
        try {
            msg = new Message(-18);
            msg.writer().writeByte(indexUI);
            msg.writer().writeShort(itemMapID);
            msg.writer().writeShort(xEnd);
            msg.writer().writeShort(yEnd);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void playerThrow(int charID, int itemMapID, int itemTemplateId, int xEnd, int yEnd) {
        Message msg = null;
        try {
            msg = new Message(-14);
            msg.writer().writeInt(charID);
            msg.writer().writeShort(itemMapID);
            msg.writer().writeShort(itemTemplateId);
            msg.writer().writeShort(xEnd);
            msg.writer().writeShort(yEnd);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void openTransport(ArrayList<Transport> teleports) {
        Message msg = null;
        try {
            msg = new Message(-91);
            msg.writer().writeByte(teleports.size());
            for (int i = 0; i < teleports.size(); i++) {
                msg.writer().writeUTF(teleports.get(i).mapName);
                msg.writer().writeUTF(teleports.get(i).planet);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void newBossMoveTo(int idBoss, int xTo, int yTo) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(10);
            msg.writer().writeByte(idBoss);
            msg.writer().writeShort(xTo);
            msg.writer().writeShort(yTo);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void newBossSetAttack(int type, int idBoss, ArrayList<Char> array, ArrayList<Integer> array2, int dir) {
        Message msg = null;
        try {
            if (type < 10) {
                msg = new Message(102);
                msg.writer().writeByte(11 + type);
                msg.writer().writeByte(idBoss);
                msg.writer().writeByte(array.size());
                for (int i = 0; i < array.size(); i++) {
                    msg.writer().writeInt(array.get(i).charID);
                    msg.writer().writeInt(array2.get(i));
                }
                msg.writer().writeByte(dir);
                this.session.sendMessage(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void newBossSetDie(int idBoss) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(23);
            msg.writer().writeByte(idBoss);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void newBossFlyTo(int idBoss, int xTo, int yTo) {
        Message msg = null;
        try {
            msg = new Message(102);
            msg.writer().writeByte(21);
            msg.writer().writeByte(idBoss);
            msg.writer().writeShort(xTo);
            msg.writer().writeShort(yTo);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void superRank(ArrayList<SuperRank> list) {
        Message msg = null;
        try {
            msg = new Message(-96);
            msg.writer().writeByte(0);
            msg.writer().writeUTF(mResources.TOP_100CT2);
            msg.writer().writeByte(list.size());
            for (int i = 0; i < list.size(); i++) {
                msg.writer().writeInt(list.get(i).rank + 1);
                msg.writer().writeInt(list.get(i).charID);
                msg.writer().writeShort(list.get(i).headID);
                if (this.session.getIntVersion() >= 218) {
                    msg.writer().writeShort(list.get(i).headICON);
                }
                msg.writer().writeShort(list.get(i).bodyID);
                msg.writer().writeShort(list.get(i).legID);
                msg.writer().writeUTF(list.get(i).name);
                if (list.get(i).isWar) {
                    msg.writer().writeUTF(list.get(i).strWar);
                } else {
                    if (SuperRank.ngocNhan(list.get(i).rank) > 0) {
                        msg.writer().writeUTF(
                                String.format(mResources.GIFT_TOP_SUPER, SuperRank.ngocNhan(list.get(i).rank)));
                    } else {
                        msg.writer().writeUTF(mResources.EMPTY);
                    }
                }
                msg.writer().writeUTF(String.format(mResources.INFO_TOP_SUPER,
                        Util.gI().getFormatNumber(list.get(i).cHPfull), Util.gI().getFormatNumber(list.get(i).cDamfull),
                        Util.gI().getFormatNumber(list.get(i).cDeffull), 0, ""));
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void SetSkillPaint_NEW(int playerId, short idskillPaint, int isFly, int typeFrame, int typePaint, int dir,
            int timeGong, int typeItem) {
        Message msg = null;
        try {
            msg = new Message(-45);
            msg.writer().writeByte(20);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(idskillPaint);
            msg.writer().writeByte(typeFrame);
            msg.writer().writeByte(dir);
            msg.writer().writeShort(timeGong);
            msg.writer().writeByte(isFly);
            msg.writer().writeByte(typePaint);
            if (typeItem != -1) {
                msg.writer().writeByte(typeItem);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void curExpSkill(int skillId, int curExp) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(62);
            msg.writer().writeShort(skillId);
            msg.writer().writeByte(0);
            msg.writer().writeShort(curExp);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void get_Img_Skill(int skillId, int typePaint) {
        Message msg = null;
        try {
            msg = this.messageSubCommand(62);
            msg.writer().writeShort(skillId);
            msg.writer().writeByte(1);
            msg.writer().writeByte(typePaint);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void SetSkillPaint_STT(int playerId, short idskillPaint, dragon.t.Point targetDame, int timeDame,
            int rangeDame, int typePaint, ArrayList<Mob> list1, ArrayList<Char> list2, int typeItem) {
        Message msg = null;
        try {
            msg = new Message(-45);
            msg.writer().writeByte(21);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(idskillPaint);
            msg.writer().writeShort(targetDame.x);
            msg.writer().writeShort(targetDame.y);
            msg.writer().writeShort(timeDame);
            msg.writer().writeShort(rangeDame);
            msg.writer().writeByte(typePaint);
            if (list1 == null) {
                msg.writer().writeByte(0);
            } else {
                msg.writer().writeByte(list1.size() + list2.size());
                for (int i = 0; i < list1.size(); i = i + 1) {
                    msg.writer().writeByte(0);
                    msg.writer().writeByte(list1.get(i).mobId);
                }
                for (int i = 0; i < list2.size(); i = i + 1) {
                    msg.writer().writeByte(1);
                    msg.writer().writeInt(list2.get(i).charID);
                }
            }
            if (typeItem != -1) {
                msg.writer().writeByte(typeItem);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void steal(int playerId, int x, int y, int itemMapID, int templateId) {
        Message msg = null;
        try {
            msg = new Message(68);
            msg.writer().writeShort(itemMapID);
            msg.writer().writeShort(templateId);
            msg.writer().writeShort(x);
            msg.writer().writeShort(y);
            msg.writer().writeInt(0);
            this.session.sendMessage(msg);

            msg = new Message(-19);
            msg.writer().writeShort(itemMapID);
            msg.writer().writeInt(playerId);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void shopReBuyItem(ArrayList<Item> list) {
        Message msg = null;
        try {
            msg = new Message(-44);
            msg.writer().writeByte(8);
            msg.writer().writeByte(1);
            msg.writer().writeUTF(mResources.REBUY);
            msg.writer().writeByte(list.size());
            for (int i = list.size() - 1; i >= 0; i--) {
                msg.writer().writeShort(list.get(i).template.id);
                int price = (int) (SaleItemNew.priceItemCoin(list.get(i)) * list.get(i).quantity * 1.1);
                if (price < 110)
                    price = 110;
                msg.writer().writeInt(price);
                msg.writer().writeInt(0);
                if (this.session.getIntVersion() >= 222) {
                    msg.writer().writeInt(list.get(i).quantity);
                } else {
                    msg.writer().writeByte(list.get(i).quantity);
                }
                if (list.get(i).options.isEmpty()) {
                    msg.writer().writeByte(1);
                    msg.writer().writeByte(73);
                    msg.writer().writeShort(0);
                } else {
                    msg.writer().writeByte(list.get(i).options.size());
                    for (int j = 0; j < list.get(i).options.size(); j++) {
                        if (list.get(i).template.type == 13 && list.get(i).options.get(j).optionTemplate.id == 66
                                && this.session.myCharz().isExistAmu(list.get(i).template.id)) {
                            Amu amu = this.session.myCharz().getAmuById(list.get(i).template.id);
                            if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60 * 24) {
                                msg.writer().writeByte(63);
                                msg.writer().writeShort(
                                        (int) (((amu.second - (System.currentTimeMillis() / 1000))) / (60 * 60 * 24)));
                            } else if (amu.second - (System.currentTimeMillis() / 1000) > 60 * 60) {
                                msg.writer().writeByte(64);
                                msg.writer().writeShort(
                                        (int) ((amu.second - (System.currentTimeMillis() / 1000)) / (60 * 60)));
                            } else {
                                msg.writer().writeByte(65);
                                msg.writer()
                                        .writeShort((int) ((amu.second - (System.currentTimeMillis() / 1000)) / 60));
                            }
                        } else {
                            msg.writer().writeByte(list.get(i).options.get(j).optionTemplate.id);
                            msg.writer().writeShort(list.get(i).options.get(j).param);
                        }
                    }
                }

                msg.writer().writeByte(0);
                if (list.get(i).headTemp != -1 || list.get(i).bodyTemp != -1 || list.get(i).legTemp != -1
                        || list.get(i).bagTemp != -1) {
                    msg.writer().writeByte(1);
                    msg.writer().writeShort(list.get(i).headTemp);
                    msg.writer().writeShort(list.get(i).bodyTemp);
                    msg.writer().writeShort(list.get(i).legTemp);
                    msg.writer().writeShort(list.get(i).bagTemp);

                } else {
                    msg.writer().writeByte(0);
                }
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null) {
                msg.cleanup();
            }
        }
    }

    public void topLuyenTap(ArrayList<LuyenTap> list) {
        Message msg = null;
        try {
            msg = new Message(-96);
            msg.writer().writeByte(0);
            msg.writer().writeUTF(mResources.TOP_100);
            msg.writer().writeByte(list.size());
            for (int i = 0; i < list.size(); i++) {
                msg.writer().writeInt(i + 1);
                msg.writer().writeInt(list.get(i).charID);
                msg.writer().writeShort(list.get(i).head);
                if (session.getIntVersion() >= 218) {
                    msg.writer().writeShort(list.get(i).headICON);
                }
                msg.writer().writeShort(list.get(i).body);
                msg.writer().writeShort(list.get(i).leg);
                msg.writer().writeUTF(list.get(i).name);
                msg.writer().writeUTF(String.format(mResources.SRC_TOPLUYENTAP1, list.get(i).level,
                        Util.gI().timeToSecondstring(list.get(i).timeFight)));
                msg.writer().writeUTF(String.format(mResources.SRC_TOPLUYENTAP2,
                        Util.gI().getStrTime(System.currentTimeMillis() - list.get(i).last)));
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void startGong(int playerId) {
        Message msg = null;
        try {
            msg = new Message(-45);
            msg.writer().writeByte(1);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(-1);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void endGong(int playerId) {
        Message msg = null;
        try {
            msg = new Message(-45);
            msg.writer().writeByte(3);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(-1);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigMessage(String chat, int avatar) {
        Message msg = null;
        try {
            msg = new Message(-70);
            msg.writer().writeShort(avatar);
            msg.writer().writeUTF(chat);
            msg.writer().writeByte(0);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void bigMessage2(String chat, int avatar, String p, String caption) {
        Message msg = null;
        try {
            msg = new Message(-70);
            msg.writer().writeShort(avatar);
            msg.writer().writeUTF(chat);
            msg.writer().writeByte(1);
            msg.writer().writeUTF(p);
            msg.writer().writeUTF(caption);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    // public void removeEffect(int id) {
    // Message msg = null;
    // try {
    // msg = new Message(-66);
    // msg.writer().writeShort(id);
    // if (this.session.getIntVersion() >= 218) {
    // if (eff.typeread == 0) {
    // this.writeData(msg, eff);
    // } else {
    // this.writeDataNewBoss(msg, eff);
    // }
    // msg.writer().writeByte(eff.typeread);
    // } else {
    // this.writeData(msg, eff);
    // }
    // msg.writer().writeInt(eff.img.length);
    // msg.writer().write(eff.img);
    // this.session.sendMessage(msg);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // finally {
    // if (msg != null)
    // msg.cleanup();
    // }
    // }

    public void loginDE(int second) {
        Message msg = null;
        try {
            msg = new Message(122);
            msg.writer().writeShort(second);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void playerLoadLevel(PlayerData array[]) {
        Message msg = null;
        try {
            msg = new Message(0);
            msg.writer().writeByte(array.length);
            for (int i = 0; i < array.length; i++) {
                msg.writer().writeInt(array[i].playerID);
                msg.writer().writeUTF(array[i].name);
                msg.writer().writeShort(array[i].head);
                msg.writer().writeShort(array[i].body);
                msg.writer().writeShort(array[i].leg);
                msg.writer().writeLong(array[i].powpoint);
            }
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void getHat(int idHat) {
        Message msg = null;
        try {
            msg = new Message(24);
            msg.writer().writeByte(0);
            msg.writer().writeShort(idHat);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void danhhieu(int charID, int id, int second) {
        Message msg = null;
        try {
            msg = new Message(24);
            msg.writer().writeByte(2);
            msg.writer().writeInt(charID);
            msg.writer().writeByte(second);
            msg.writer().writeShort(id);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void water(int id_water1) {
        Message msg = null;
        try {
            msg = new Message(24);
            msg.writer().writeByte(3);
            msg.writer().writeShort(id_water1);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void messageServer(String text) {
        Message msg = null;
        try {
            msg = new Message(24);
            msg.writer().writeByte(4);
            msg.writer().writeUTF(text);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

    public void setEff(int playerId, int idAuraEff, int idEff_Set_Item) {
        Message msg = null;
        try {
            msg = new Message(127);
            msg.writer().writeByte(4);
            msg.writer().writeInt(playerId);
            msg.writer().writeShort(idAuraEff);
            msg.writer().writeByte(idEff_Set_Item);
            this.session.sendMessage(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (msg != null)
                msg.cleanup();
        }
    }

}
