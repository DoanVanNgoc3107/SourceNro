package dragon.t;

import dragon.server.Dragon;
import dragon.server.Server;
import dragon.server.Session_ME;
import dragon.server.mResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Admin
 */
public class Char {
    
    public Session_ME session = null;
    public int playerId = -1;
    public String cName = null;
    public byte cgender;
    public int ctaskId = -1;
    public int ctaskIndex = -1;
    public int ctaskCount = 0;
    public byte cPk;
    public byte cTypePk;
    public long cPower;
    public byte cPowerLimit;
    public byte maxLimitSV = 5;
    public byte maxLimitKaio = 10;
    public byte nClassId;
    public final ArrayList<Skill> skills = new ArrayList<>();
    public Skill mySkill;
    public short head = -1;
    public short headICON = -1;
    public short headDefault = -1;
    public short body = -1;
    public short wp = -1;
    public int bag = -1;
    public int bagDefault = -1;
    public short leg = -1;
    public short bodyDefault = -1;
    public short legDefault = -1;

    public int clevel;
    public long xu;
    public long maxXu;
    public int luong;
    public int luongKhoa;
    public Item[] arrItemBag;
    public Item[] arrItemBox;
    public Item[] arrItemBody;
    public byte typeTeleport = 1;
    private byte typeTeleport2;
    private int xTeleport2;
    private int yTeleport2;
    public ArrayList<Byte> KSkill = new ArrayList<>();
    public ArrayList<Byte> OSkill = new ArrayList<>();
    public ArrayList<Byte> CSkill = new ArrayList<>();
    public int bagcount;
    public int boxcount;
    public boolean isTemplate;
    public int indexXH = -1;
    public int numberXH = -1;
    public int numberXH2 = -1;
    public boolean isAtt;
    public int timeClear;
    public int timeChat;
    public int cStamina;
    public short cMaxStamina;
    public int cspeacialSkill = -1;
    public int paramSpeacialSkill;
    public int ncoinSpeacialSkill;
    public boolean vxmm = false;
    
    public short[] idHead;
    public short[] idAvatar;
    
    public static short ID_NEW_MOUNT = 30000;
    public short idMount;
    public boolean isHaveMount;
    public Item itemGLT;
    public byte cFlag;
    public int IDFlag = 363;
    public byte intrinsicCrit = 0;
    public int holder_mobId = -1;
    public int holder_charId = -1;
    public int mobId_holder = -1;
    public int charId_holder = -1;
    
    public int miliSecondChallenge;
    public boolean isChallenge = false;
    public int challengeCharId = -9999;
    public int xuChallenge;
    public long totalDamage;
    
    public boolean isFreez;
    public boolean isCharge;
    public int seconds;
    public int freezMiliSeconds;
    public int chargeMiliSeconds;
    public int chargeDamage;
    public int tCharge;
    
    public int mapTemplateId;
    public int zoneID;
    public int cx;
    public int cy;
    public int wpX = -1;
    public int wpY = -1;
    public ZoneMap zoneMap = null;
    public boolean isInMap;
    public boolean isDie = false;
    public long lastTimeUseThisFoods;
    public int shopId;
    public int typeLucky = -1;
    public Item[] arrItem;
    public int buff5;
    public int buff30;
    public Transport transportOld;
    public Item itemUse = null;
    public int magicTree_level = 1;
    public int magicTree_currPeas;
    public long magicTree_miliseconds;
    public boolean magicTree_isUpdate;
    public boolean isTransport;
    public ZoneMap transport;
    public int maxTimeTransport;
    public long lastTransport;
    public int timeKTG;
    public int timeResetCloneTop = -1;
    public int isMabu;
    public boolean cry = false;
    public boolean isBienHinh;
    public int nLuckyIndex;
    public boolean isClear;
    public int cTemplateId = -1;
    public int cTemplateType = -1;
    public int timeSetLive = -1;
    public int timeLive = -1;
    public long lSSkill;
    public boolean is100Miss;
    
    public int npcId;
    public int statusMe = 5;
    public int charID;
    public NpcTemplate template;
    public int avatar;
    public boolean isInvisiblez;
    public int stone;
    public int timeInvisiblez;
    public boolean isShadown = true;
    public boolean isLockMove;
    public boolean isLockAttack;
    public byte isMonkey;
    public byte levelMonkey;
    public int miliSecond_Monkey;
    public int xSd;
    public int ySd;
    public int cw = 22;
    public int ch = 32;
    public int chw = 11;
    public int chh = 16;
    public int duaHauIndex;
    
    public int cHPGoc;
    public int cMPGoc;
    public int cDamGoc;
    public int cHPFull;
    public int cMPFull;
    public int cHP;
    public int cMP;
    public int setSpeed = 6;
    public int cspeed;
    public int cspeedFull;
    public byte hpFrom1000TiemNang = 20;
    public byte mpFrom1000TiemNang = 20;
    public byte damFrom1000TiemNang = 1;
    public int cDamFull;
    public int cDefull;
    public int cCriticalFull;
    public long cTiemNang;
    public short expForOneAdd = 100;
    public int cDefGoc;
    public int cCriticalGoc;
    public int cDefPercentGoc;
    public int cMissPercentGoc;
    public int cdameDown;
    public int eff5BuffHp;
    public int eff5BuffMp;
    public int damage;
    public int eff30BuffHp;
    public int eff30BuffMp;
    public int eff30BuffHp_percent;
    public int eff30BuffMp_percent;
    public int bienHp_percent;
    public int bienMp_percent;
    public int suckHPGoc;
    public int suckKIGoc;
    public int tnsm_percent;
    public int coinMob_percent;
    public int bienMobHp_percent;
    public int damReturn_percent;
    public int damReturn_percent_default;
    public int cMissPercent;
    public boolean isInvisible;
    public int dirty_percent;
    public boolean isFindCrystal;
    public int damChuongToKi_percent;
    public int down50_percent;
    public int add1MaxDamage_percent;
    public int downDamKI20_percent;
    public boolean isFlyUpKI;
    public boolean isFlyUpHPKI;
    public int addDamMob_percent;
    public int expMob_percent;
    public boolean isFullTBT;
    public boolean isFullTBHD;
    public boolean isTBNice;
    public int niceDam_percent;
    public int niceDamsend_percent;
    public int timeChatNice;
    public int HutHPKI5_percent;
    public int attToKI;
    public int damCrit_percent;
    public boolean isDownSpeed;
    public int downSpeed_percent;
    public int downSpeedSend_percent;
    public int timeDownHutHPKI5;
    public int securityCode = -1;
    public int securityCode2;
    public boolean isSecurity;
    public long timeSecurity;
    public int xDamAway60s;
    public int tnsm_percent_petz;
    public boolean isMobproactive;
    public boolean isMobExp20;
    public boolean isBaoVe;
    public int timeMap;
    public boolean isSendDisperse;
    public boolean isDisperse;
    public int disperse_percent;
    public boolean isInvisiblez5;
    public int timeInvisiblez5;
    public boolean isSendStone30;
    public boolean isSendFreeze30;
    public int timeSendStone30_1 = 30000;
    public int timeSendStone30_2 = 30000;
    public boolean isSendSocola30;
    public int timeSendSocola30 = 30000;
    public int cuteUpKI;
    public int timeCuteUpKI = 1000;
    public int explode;
    public int timeExplode;
    public int timeStone;
    public boolean isSeal;
    public int collectPoint;
    public int pDamHP;
    
    public int huytSaoHP;
    public boolean isCuongNo;
    public boolean isBoHuyet;
    public boolean isBoKhi;
    public boolean isXenBoHung;
    public boolean isKhienCold;
    public boolean isCold;
    public boolean canAutoPlay;
    public boolean isThucAn;
    public boolean isKeoOneEye;
    public boolean isSupDark;
    public boolean isGatoSpider;
    public boolean isHumbergerWorm;
    public boolean isXiMuoiDao;
    public boolean isXiMuoiMai;
    public boolean isCommeson;
    
    public ArrayList<ItemTime> itemTime = new ArrayList<>();
    private int timeItemTime;
    public ArrayList<ItemTime> textTime = new ArrayList<>();
    private int timeTextTime;
    public boolean isItemTime = false;
    public boolean isTextTime = false;
    public ArrayList<ItemTime> wit = new ArrayList<>();
    public ArrayList<ItemTime> wtxt = new ArrayList<>();
    public ArrayList<Amu> arrAmu = new ArrayList<>();
    public ArrayList<Item> arrItemMore = new ArrayList<>();
    public ArrayList<Item> arrItemMore2 = new ArrayList<>();
    public ArrayList<Friend> arrFriend = new ArrayList<>();
    public ArrayList<Item> items = new ArrayList<>();
    public final ArrayList<Rada> radas = new ArrayList<>();
    public ArrayList<ItemMap> itemVTs = new ArrayList<>();
    public ArrayList<DuaHau> duahaus = new ArrayList<>();
    public PetFollow petFollow;
    public ArrayList<ArchivementTask> archivements = new ArrayList<>();
    
    public int xExp;
    public int damMob_percent;
    public int downDamMob_percent;
    public boolean isOaiHum;
    public boolean isNotDieMob;
    public boolean isNotTheLeDown;
    public boolean isHutVP;
    public boolean isBuaDeTu;
    
    public boolean huytSao;
    public int time_huytSao;
    public boolean blindEff;
    public int time_blindEff;
    public boolean sleepEff;
    public int time_sleepEff;
    public boolean holder;
    public int time_holder;
    public boolean protectEff;
    public int time_protectEff;
    public boolean isSocola;
    public int add1Damage_percent;
    public int timeFly;
    public int minutes_expires = 60000;
    public int minuteOnline = 0;
    public int damageNext_percent;
    public int damageNext_percent2;
    public int downDamage_percent;
    public int countLevel = 1;
    public int sonCall = 0;
    public boolean isSonCall;
    public int timeSonCall;
    public int dabId = -1;
    public int babyId;
    public Char cloneByChar = null;
    public int timeSendClone;
    
    public final byte defFrom1000TiemNang = 1;
    public final byte criticalFrom1000Tiemnang = 1;
    
    public final ArrayList<Map> mapOfflines = new ArrayList<>();
    public SkillNotFocus waitSkill_not_focus = null;
    public final HashMap<Integer, Integer> charDam = new HashMap<>();
    public final ArrayList<Integer> charAtt = new ArrayList<>();
    public final HashMap<Integer, Integer> npcTypes = new HashMap<>();
    public ArrayList<GameInfo> gameInfos = new ArrayList<>();
    public int timeHit;
    public int timeLoadSkill;
    public int timeReady;
    public boolean me;
    public byte petStatus;
    public int timeVeNha;
    public int timeHS;
    public int isHopThe;
    public int timeHopThe;
    public int timeDanh = -1;
    public final int settupPotential = 30000;
    public int tupPotential = settupPotential;
//    public int twrPotential;
    public boolean isBaby;
    public Mob mobFocus;
    public Char charFocus;
    public ArrayList<Mob> aMobFocus = new ArrayList<>();
    public ArrayList<Char> aCharFocus = new ArrayList<>();
    public Mob mobMe;
    public Char myChar = null;
    public Char myPet = null;
    public Char myChar2 = null;
    public Player myPet2 = null;
    public Char myChar3 = null;
    public Player myPet3 = null;
    public Char myChar4 = null;
    public Player myPet4 = null;
    public int instructionMapID;
    public long[] powerSkillPet = new long[] {0, 150000000, 1500000000, 20000000000L};
    public String[] spowerSkillPet = new String[] {"", "Cần 150 triệu sức mạnh để mở", "Cần 1,5 tỉ sức mạnh để mở", "Cần 20 tỉ sức mạnh để mở"};
    public short[][] arrSkillPet = new short[][] {
        {0, 14, 28},
        {7, 21, 35},
        {42, 63, 56},
        {121, 84, 91}
    };
    public short[][] arrStone = new short[][] {
        {454, 455, 456},
        {454, 455, 456},
        {454, 455, 456}
    };
    public int[][] arrMapOfflineId = new int[][] {
        {
            21, 39, 45, 46, 47, 48, 50, 101, 111, 154
        },
        {
            22, 40, 45, 46, 47, 48, 50, 101, 111, 154
        },
        {
            23, 41, 45, 46, 47, 48, 50, 101, 111, 154
        }
    };
    public int timeHoiqua;
    public int timeNhat;
    public int delay_giaodich;
    public int tw_giaodich;
    public boolean isgiaodich;
    public int wid_giaodich;
    public int charId_giaodich;
    public boolean isLock_giaodich;
    public boolean isOk_giaodich;
    public int coin_giaodich;
    public int count_giaodich;
    public int[] arrQuantity;
    public int countChangeZone;
    public int timeChangeZone;
    public int typeTrasport;
    public Item itemBlackBall;

    public int timeBlackBall = -1;
    public int timeChatWinBlackBall;
    public int phuHoBlackBall;
    public int timeChangePk5 = -1;
    public boolean isTaiTao1 = false;
    public long hpHoi = 0;
    public long lastTime;
    public long yesterday = 0;
    public int timeHSTaiCho;
    public Item usePet = null;
    public int clanPoint = 0;
    public int pointEvent = 0;
    public short idAuraEff = -1;
    public short idEff_Set_Item = -1;
    public short idHat = -1;
    public boolean isAnDanh;
    public int timeGoMe;
    public int timeGoPlayer;
    public int timeUsePet;
    public int timeTach;
    public int time_xDamAway60s = 60000;
    public boolean isBossMain;
    public boolean isBosseExportClone;
    public int timeExBossTask = -1;
    public int timeNoiKore;
    public int nNoiKore;
    public boolean isEx2 = false;
    public int totalGold;
    public int typeArchivemnt = -1;
    public boolean isCan;
    public int timeCallDragon;
    public int countCallDragon;
    
//    public int clanID;
    public Clan clan;
    public ClanMember clanMember;
    public ArrayList<Clan> listClan;
    
    public boolean isSetXiHang;
    public boolean isSetKirin;
    public boolean isSetSongoku;
    public boolean isSetPicolo;
    public boolean isSetOcTieu;
    public boolean isSetPikkoroDaimao;
    public boolean isSetKakarot;
    public boolean isSetCaDic;
    public boolean isSetNappa;
    
    public boolean isNextTask;
    public int tNextTask;
    public boolean isEat;
    public Map belly;
    public ZoneMap zbelly;
    public int tEat;
    public boolean isMabuHold;
    public int nMabuHold;
    public int tCocoon;
    public int tSuck;
    public int tNuot;
    public int tBienHinh;
    public boolean isSuper;
    public boolean isBlKaio;
    public boolean isSkillMabu;
    public int tUseMabu;
    public int tStab = 0;
    public int tToHome = 0;
    public boolean isCallDau;
//    public HashMap<Integer, Object> objArray;
    public int[] arrInMap;
    public int typeConsign;
    public long lastXinDau;
    public int tDownSpeed;
    
    private int arbCharId1;
    private int arbCharId2;
    private int tArb;
    private int nArb;
    private final ArrayList<TimeChat> aChat = new ArrayList<>();
    private boolean isClearChat;
    private int tFreeze;
    private boolean isSkillFreeze;
    private int tOneFinger;
    private boolean isSkillOneFinger;
    private boolean isFlyMove;
    private int cHPFullPetz;
    private int cMPFullPetz;
    private int cDamFullPetz;
    private int nConfirm;
    private String[] sayConfirm;
    private int damMove;
    private int damMob;
    private int downProtected;
    private int downEffblindSc;
    private int downEffblindPercent;
    public boolean isTBTanjiro;
    private int tTBTanjiro;
    private int tTanjiro;
    public int vTanjiro;
    public boolean isTBInosukeH;
    private int tTBInosukeH;
    private int tInosukeH;
    private int vInosukeH;
    public boolean isTBInosuke;
    private int tTBInosuke;
    private int tInosuke;
    private int vInosuke;
    public boolean isTBZenitsu;
    private boolean isWorr;
    private int worrPercent;
    public boolean isTBNezuko;
    public boolean isCazy;
    private int tCazy;
    private int tNezuko;
    private int vCazy;
    private int typeRong;
    private int timeRong;
    public boolean isGoiRong;
    public int selectRong;
    private boolean isX2Text;
    private boolean isX2EventText;
    private boolean isSetTypePk;
    private byte setTypePk;
    private int tTypePk;
    private int tSetTypePk;
    private Obj myObj;
    private int mobFlyPercent;
    private int mobMonkeyPercent;
    private int mobSoilPercent;
    private int toEarthPercent;
    private int toNamekPercent;
    private int toXaydaPercent;
    private int downEarthPercent;
    private int downNamekPercent;
    private int downXaydaPercent;
    private int clanNumberCountNear;
    private int dam2MemberPercent;
    private int hp2MemberPercent;
    private int mp2MemberPercent;
    private int damBossPercent;
    private boolean isX2RVC;
    private boolean isX2RNM;
    private boolean isPercentRNM;
    private boolean isAddSDHPKIText;
    public boolean isPlayer = false;
    public MenuBoard menuBoard;
    public MenuBoard2 menuBoard2;
    public ClientInput clientInput;
    public int isPlayerId = -1;
    public int isCharId = -1;
    public boolean isPetThiTheo;
    private ArrayList<int[]> moveAutos = null;
    public boolean isMove;
    private int nSendGift;
    private int timeSendGift;
    public boolean isSendGift;
    public boolean isGiaoCho;
    public boolean isRego;
    public int timeRego;
    private int dRego;
    private byte dirRego;
    private short xRego;
    public int maxZoneXH;
    private int petJoin;
    public ArrayList<Transport> transports;
    public int timeKyGui;
    public int timePkMyPet;
    public boolean gong;
    public int timeGong2;
    public boolean isNhinThay;
    public boolean isSee;
    public int setSamllHit;
    public boolean isGo;
    public boolean isCome;
    public byte cdir = 1;
    
    private int rID;
    private int charRID;
    private boolean isRongThanXuatHien;
    private int xR;
    private int yR;
    private int mapRID;
    private int bgRID;
    private int zoneRID;
    private boolean isRongNamek;
    private String textR;
    
    private int eggEffHideTick;
    private int eggXHide;
    private int eggYHide;
    private boolean isEggEffHide;
    private int eggEffStrTick;
    private int eggXStr;
    private int eggYStr;
    private int[] arrEggEffStr;
    private int arrEggEffStrIndex;
    private int eggScStr;
    private boolean isEggEffStr;
    private int indexDuaHau;
    private int isAttackting;
    private int timeAttackting;

    private static Char instance;
    
    public static Char gI() {
        if (instance == null) {
            instance = new Char();
            instance.char_baseId = 10000;
            instance.info1 = new short[][]{
                {
                    281,
                    361,
                    351
                },
                {
                    512,
                    513,
                    536
                },
                {
                    514,
                    515,
                    537
                }
            };
            instance.info2 = new String[][]{
                {
                    "Puaru"
                },
                {
                    "Piano"
                },
                {
                    "Icarus"
                }
            };
            instance.hopThe = new short[][] {
                {380, 381, 382},
                {391, 392, 393},
                {380, 381, 382}
            };
            instance.hopThe2 = new short[][] {
                {383, 384, 385},
                {391, 392, 393},
                {383, 384, 385}
            };
            instance.hopThe3 = new short[][] {
                {870, 871, 872},
                {873, 874, 875},
                {867, 868, 869}
            };
            instance.pointDuiGa = new int[][]{{625, 336}, {50, 336}, {627, 336}};
        }
        return instance;
    }
    private int char_baseId;
    public short[][] info1;
    public String[][] info2;
    public short[][] hopThe;
    public short[][] hopThe2;
    public short[][] hopThe3;
    
    public int[][] pointDuiGa;
    public static String[] strLevel;
    public Item phaohoa;
    public int clientInputInt;
    private int tColdTalk = 10000;
    private int minuteOld;
    public boolean vocuc;
    public boolean isSendCarrot;
    public boolean isCarrot;
    public Item usePetFollowz = null;
    public PetFollow petFollowz;
    public boolean isAgainst20Sun;
    public boolean isAgainstEffect;
    public boolean isAgainstCold;
    public int tPetzStCrit;
    private int pPetzStCrit;
    public boolean isAgainstDamageCrit;
    public int tPetzAgainsStCrit;
    public Item itemNamekBall;
    public long timeNextMapNamek;
    public boolean shield;
    public int goNamekBallStar;
    public long timeReceiveNamek;
    private boolean isArb2;
    private Char arbPlayer1;
    private Char arbPlayer2;
    private int timeOutPrize;
    private boolean winOutPrize;
    private final ArrayList<TimeChat> aInfo1 = new ArrayList<>();
    public final ArrayList<String> arrChat = new ArrayList<>();
    public boolean isWaitWar;
    public boolean isspeechWar;
    public int nspeechWar;
    public boolean isFuture;
    public int nearCombatPercent;
    public boolean isCuongNo2;
    public boolean isBoHuyet2;
    public boolean isBoKhi2;
    public boolean isXenBoHung2;
    private int autoX;
    private int autoY;
    private boolean isAutoXY;
    private int timeAutoXY;
    private int setTimeAutoXY;
    private String superRankName = null;
    private int timeSetChallenge;
    private Char playerSetChallenge;
    public int typeThachDau;
    public int timeThachDau;
    public final ArrayList<SuperRank> arrSuperRank = new ArrayList<>();
    public SuperRank superRank = null;
    public BWar bWar = null;
    private Skill newSkill;
    private int typePaint;
    private boolean isNewSkill;
    private boolean isCancelNewSkill;
    private int timeGong;
    private Point targetDame;
    private int timeDanhSkill;
    private int timeDame;
    private int typeItem;
    private final ArrayList<Mob> mPhongBa1 = new ArrayList<>();
    private final ArrayList<Char> mPhongBa2 = new ArrayList<>();
    private int damageTDMPB;
    private Char playerTDMPB;
    private int timeTDMPB;
    private boolean isMaPhongBa1;
    private int isMaPhongBa2;
    public boolean isChuyenMap;
    private boolean isBiDanh;
    private int timeChuyenMap = 15000;
    public int stealCharId = -1;
    public boolean isSteal = true;
    private int timeSteal;
    public long xuSteal = 0;
    private final Object LOCK = new Object();
    public static final byte ARRHOCSKILL[] = new byte[]{24, 26, 25};
    private int isThaCau;
    private Item moiCau;
    private int timeThaCau;
    public ArrayList<EffChar> aEffChar = new ArrayList<>();
    private boolean vPet9;
    private int timevPet9;
    public NapThe cardLoad = null;
    public boolean isAddClone;
    public boolean isMonkeyCheat;
    private ArrayList<Char> cloneMEs = null;
    private boolean isHideDuongTang;
    private ArrayList<int[]> moves = null;
    private boolean isMoveNew = false;
    public boolean isCheckWaypoint;
    public int timeCheckWaypoint;
    public int timeMove2;
    public int pixels;
    public Char fighter1 = null;
    public Char fighter2 = null;
    public Char fightWish1 = null;
    public Char fightWish2 = null;
    public long lastFight;
    public boolean isPhatQua = false;
    public boolean isRecDam = true;
    public boolean isFood1;
    public boolean isFood2;
    public boolean isFood3;
    public boolean isNhanDauThan;
    public int timeGoMapHoangMac;
    public boolean boomWhenDie;
    public boolean isSkillXayda1 = false;
    private int tSkillXayda1;
    private Char skillXaydaFocus1 = null;
    public boolean isSkillXayda2 = false;
    private Char skillXaydaFocus2 = null;
    private int tSkillXayda2;
    private int tSkillXayda2_2;
    public boolean isSkillXayda3 = false;
    private Char skillXaydaFocus3 = null;
    private int addDamgeKamejoko;
    private int addDamgeAntomic;
    private int addDamgeMasenko;
    public boolean  isSetNgayHe;
    public int      downDamagePercent;
    public int      sendDownDamagePercent;
    public int  strike;
    public int  autoMove;
    public int  timeMove;
    public int      isCallCumber = 0;
    public boolean  isCallFuAndMai;
    public Char myChar5 = null;
    public ArrayList<Char> myPetz5s = null;
    public ZoneMap  waitJoinZone = null;
    public int      timeJoinZone;
    public int      xJoinZone;
    public int      yJoinZone;
    public int      telePortJoinZone;
    public long lastDie;
    public boolean  isSendHPData = false;
    public int      timeSendHPData;
    public int  maxTimeEff = -1;
    public int isItemMore;
    public int maxDamageTo = -1;
    public int maxPercentHPTo = -1;
    public boolean isTBQuanHoa;
    public int vatChuId = -1;
    public static final int MAXBODY_PET = 6;
    public boolean effThanThoai;
    public boolean isMayDoLinhHon = false;
    public NangCap nangcap;
    public ArrayList<ChatGameBot> chatGameBot = null;
    public ArrayList<Command> myCommands = null;
    public int timeBotChat2;
    public boolean isArgue;
    public int pointVip;
    public int type_player_vs_player;
    public int xu_player_vs_player;
    
    public int miliSecondRPS;
    public boolean isRPS = false;
    public int rPSCharId = -9999;
    public int statusRPS = -1;
    public int winRPS = 0;
    public int xuRPS;
    public int ntRPS = 0;
    public boolean rdRPS = false;
    private int levelBook;
    private int idBook;
    
    public static class ChatGameBot {
        
        public int id;
        public String chat;

        public ChatGameBot(int id, String chat) {
            this.id = id;
            this.chat = chat;
        }
        
    }
    
    private static class Command {
        
        int action;
        Object p;
        
        public Command(int action, Object p) {
            this.action = action;
            this.p = p;
        }
    }
    
    
    
    public Char() {
    }
    
    public int delay;
    public int gameTick;
    
    public static synchronized int getNewCharID() {
        return gI().char_baseId++;
    }
    
    
    public void update() {
        this.gameTick++;
        this.minutes_expires -= this.delay;
        this.minuteOld = this.minuteOnline;
        if (this.minutes_expires <= 0) {
            this.minutes_expires = 60000;
            this.minuteOnline++;
            if (this.session != null && this.minuteOnline % 60 == 0) {
            	this.updateArchivement(8, 1L);
            }
        }
        
        //Item Time
        this.updateItemTime();
        //Text Time
        this.updateTextTime();
        //Amu
        if (this.gameTick % 20 == 0) {
            this.updateAmu();
        }
        //skill_not_focus
        this.updateSkillNotFocus();
        //Kiem tra ve tinh
        if (this.gameTick % 20 == 0) {
            this.checkVeTinh();
        }
        
        //New
        if (this.zoneMap != null) {
            this.updateNew();
        }
        //Time linh tinh
        this.updateNew2();
        //Ma bu
        this.updateMabu();
        //Arb
        this.updateArb();
        //Goi rong
        this.updateGoiRong();
        //livePk
        this.updateLivePk();
        //De tu
        if (!this.me) {
            this.petzAuto();
        }
        //Lanh dia bang
        this.updateMapClan();
        
        //ItemBody
        if (this.zoneMap != null && (this.gameTick % 20 == 0 || this.minuteOnline != this.minuteOld)) {
            this.updateItemBody();
        }
        //ItemBag
        if (this.zoneMap != null && (this.gameTick % 20 == 0 || this.minuteOnline != this.minuteOld)) {
            this.updateItemBag();
        }
        //ItemBox
        if (this.zoneMap != null && (this.gameTick % 20 == 0 || this.minuteOnline != this.minuteOld)) {
            this.updateItemBox();
        }
        //Items
        if (this.zoneMap != null && (this.gameTick % 20 == 0 || this.minuteOnline != this.minuteOld)) {
            this.updateItems();
        }
        //ItemMore
        if (this.zoneMap != null && (this.gameTick % 20 == 0 || this.minuteOnline != this.minuteOld)) {
            this.updateItemMore();
        }
        //ItemBlackBall
        if (this.zoneMap != null && this.timeBlackBall != -1) {
            this.updateBlackBall();
        }
        //Time chat
        if (!this.aChat.isEmpty()) {
            this.updateTimeChat();
        }
        //Tele
        this.updateTele();
        //Clan
        if (this.clan != null && this.gameTick % 20 == 0) {
            this.updateClan();
        }
        //Goi rong
        this.updateRong();
        //ClanNew
        if (this.isPlayer && this.gameTick % 20 == 0) {
            this.updateNoiBanh();
        }
        this.updateOngGia();
        if (this.isRego && this.zoneMap !=  null && !this.isStand()) {
            this.updateReGo();
        }
        //Join
        if (this.isInMap) {
            this.updateJoin();
        }
        //my pet
        if (this.myPet3 != null) {
            this.updateMyChar3();
        }
        //my char
        if (this.myChar3 != null) {
            this.updateMyPet3();
        }
        //Dua hau
        if (this.zoneMap != null) {
            this.updateDuaHau();
        }
        //Egg Eff
        this.updateEggEff();
        //Ngoc rong Namek
        if (this.itemNamekBall != null) {
            this.updateNamekBall();
        }
        //Time info1
        if (!this.aInfo1.isEmpty()) {
            this.updateTimeInfo1();
        }
        //Time go dai hoi
        this.updateOutPrize();
        //Auto xy
        this.updateAutoXY();
        if (this.zoneMap != null) {
            this.updateSuperRank();
        }
        if (this.bWar != null) {
            this.updateBWar();
        }
        this.updateNSkill();
        this.updateAnTrom();
        //Cau ca
        this.updateThaCau();
        //EffectChar
        this.updateEffectChar();
        //Noi tai
        this.updateNoiTai();
        //myPet 4
        this.updateMyPet4();
        //move
        this.updateMove();
        //phat qua
        if (this.isPhatQua) {
            this.isPhatQua = false;
            this.updatePhatQua();
        }
        if (this.isTemplate) {
            this.cMP = this.cMPFull;
        }
        //Thanh tich
        this.updateArchivement();
        //Giap luyen tap
        this.updateItemGLT();
        //Chat bot
        if (this.chatGameBot != null) {
            this.updateChatGameBot();
        }
        //Command
        if (this.myCommands != null) {
            this.updateCommand();
        }
    }
    
    public Char myCharz() {
        if (this.me) {
            return this;
        } else {
            return this.myChar;
        }
    }
    
    public Char myPetz() {
        if (this.me) {
            return this.myPet;
        } else {
            return this;
        }
    }
    
    public void updateAll() {
        //VAR
        int i;
        this.applyCharLevelPercent();
        this.setMountIsStart();
        this.checkHaveGLT();
        this.checkHaveAuraEff();
        this.checkHaveEff_Set_Item();
        
        //===Apply Level===\\
        this.applyCharLevelPercent();
        
        //===SET DEFAULT PART===//
        this.setDefaultPart();
            
        if (this.headDefault == -1) {
            this.setDefaultHeadPet();
        }
        this.head = this.headDefault;
        this.bag = this.bagDefault;
        
        //===UPDATE HP===//
        this.cHPFull = (int) (this.cHPGoc + (this.paramItem(0, 2, 0) * 1000) + (this.paramItem(0, 22, 0) * 1000) + this.paramItem(0, 6, 0) + this.paramItem(0, 48, 0));
        this.cHPFull = (int) this.paramItem(this.cHPFull, 77, 1);
        if (this.isHaveItems(373)) {
            this.cHPFull = (int) (this.cHPFull * 1.15);
        }
        
        //===UPDATE MP===//
        this.cMPFull = (int) (this.cMPGoc + (this.paramItem(0, 2, 0) * 1000) + (this.paramItem(0, 23, 0) * 1000) + this.paramItem(0, 7, 0) + this.paramItem(0, 48, 0));
        this.cMPFull = (int) this.paramItem(this.cMPFull, 103, 1);
        if (this.isHaveItems(374)) {
            this.cMPFull = (int) (this.cMPFull * 1.15);
        }
        
        //===UPDATE DAME===//
        this.cDamFull = this.cDamGoc;
        //Cuong no
        if (this.isCuongNo) {
            this.cDamFull = this.cDamFull * 2;
        }
        //Cuong no 2
        if (this.isCuongNo2) {
            this.cDamFull = this.cDamFull + (int) ((float)this.cDamFull * 1.2F);
        }
        //Xi muoi dao
        if (this.isXiMuoiDao) {
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.20F));
        }
        this.cDamFull = (int) (this.cDamFull + this.paramItem(0, 0, 0));
        this.cDamFull = (int) this.paramItem(this.cDamFull, 50, 1);
        this.cDamFull = (int) this.paramItem(this.cDamFull, 147, 1);
        this.cDamFull = (int) this.paramItem(this.cDamFull, 49, 2);
        this.isTBNice = this.paramItem(0, 117, 3) == 1;
        if (this.isTBNice) {
            this.cDamFull = (int) this.paramItem(this.cDamFull, 117, 1);
            this.niceDamsend_percent = (int) this.paramItem(this.cDamFull, 117, 0);
        } else {
            this.cDamFull = (int) (this.cDamFull + ((long)this.cDamFull * (long)this.niceDam_percent / 100L));
        }
        if (this.isHaveItems(372)) {
            this.cDamFull = (int) (this.cDamFull + ((long)this.cDamFull * 15L / 100L));
        }
        if (this.myCharz().isThucAn) {
            this.cDamFull = (int) (this.cDamFull + ((long)this.cDamFull * 10L / 100L));
        }
        if (this.vCazy > 0) {
            this.cDamFull = (int) (this.cDamFull + ((long)this.cDamFull * (long)this.vCazy / 100L));
        }
        
        //===UPDATE DEF===//
        this.cDefull = (int) ((this.cDefGoc * 4) + this.paramItem(0, 47, 0));
        
        //===UPDATE CRITICAL===//
        this.cCriticalFull = (int) (this.cCriticalGoc + this.paramItem(0, 14, 0));
        if (this.isHaveItems(376)) {
            this.cCriticalFull = this.cCriticalFull + 5;
        }
        if (this.isKeoOneEye) {
            this.cCriticalFull = this.cCriticalFull + 5;
        }
        if (this.isMonkey != 0) {
            this.cCriticalFull = 110;
            this.cHPFull = this.cHPFull + ((int)((long)this.cHPFull * (long)Monkey.get(this.levelMonkey).addHP / 100L));
            this.cDamFull = this.cDamFull + ((int)((long)this.cDamFull * (long)Monkey.get(this.levelMonkey).addST / 100L));
        }
        
        //===UPDATE BUFFHP30 ===//
        this.eff30BuffHp = (int) this.paramItem(0, 27, 0);
        
        //===UPDATE BUFFMP30 ===//
        this.eff30BuffMp = (int) this.paramItem(0, 28, 0);
        
        //===UPDATE BUFFHP30 PERCENT ===//
        this.eff30BuffHp_percent = (int) this.paramItem(0, 80, 0);
        
        //===UPDATE BUFFMP30 PERCENT ===//
        this.eff30BuffMp_percent = (int) this.paramItem(0, 81, 0);
        
        //===UPDATE BIENHP PERCENT ===//
        this.bienHp_percent = (int) this.paramItem(0, 95, 0) + this.suckHPGoc;
        
        //===UPDATE BIENMP PERCENT ===//
        this.bienMp_percent = (int) this.paramItem(0, 96, 0) + this.suckKIGoc;
        
        //===UPDATE VANG TU QUAI PERCENT ===//
        this.coinMob_percent = (int) this.paramItem(0, 100, 0);
        
        //===UPDATE TN,SM PERCENT ===//
        this.tnsm_percent = (int) this.paramItem(0, 101, 0);
        
        //===UPDATE BIENMOBHP PERCENT ===//
        this.bienMobHp_percent = (int) this.paramItem(0, 104, 0);
        
        //===UPDATE DAMRETURN PERCENT ===//
        this.damReturn_percent = (int) this.paramItem(0, 97, 0) + this.damReturn_percent_default;
        if (this.isHaveItems(377)) {
            this.damReturn_percent = this.damReturn_percent + 10;
        }
        
        //===UPDATE NEDE PERCENT ===//
        this.cMissPercent = (int) this.paramItem(0, 108, 0) + this.cMissPercentGoc;
        
        //===UPDATE VO HINH BOSS AND QUAI ===//
        this.isInvisible = this.paramItem(0, 105, 3) == 1;
        
        //===UPDATE HOI GIAM HP XUNG QUANH ===//
        this.dirty_percent = (int) this.paramItem(0, 109, 0);
        
        //===UPDATE DO PHA LE ===//
        this.isFindCrystal = this.paramItem(0, 110, 3) == 1;
        
        //===UPDATE DAM CHUONG THANH KI ===//
        this.damChuongToKi_percent = (int) this.paramItem(0, 3, 0);
        
        //===UPDATE Giam 50%SD,Tn,SM +%COIN,TN,SM===//
        this.down50_percent = (int) this.paramItem(0, 155, 0);
        if (this.paramItem(0, 155, 3) == 1) {
            this.cHPFull = this.cHPFull / 2;
            this.cMPFull = this.cMPFull / 2;
            this.cDamFull = this.cDamFull / 2;
        }
        
        //===UPDATE ADD1% DAME DAM TOI DA %===\\
        this.add1MaxDamage_percent = (int) this.paramItem(0, 156, 4);
        
        //===UPDATE GIAM ST KI < 20%===\\
        this.downDamKI20_percent = (int) this.paramItem(0, 157, 0);
        
        //===UPDATE BAY HOI KI ===//
        this.isFlyUpKI = this.paramItem(0, 85, 3) == 1;
        
        //===UPDATE BAY HOI HP KI ===//
        this.isFlyUpHPKI = this.paramItem(0, 89, 3) == 1;
        
        //===UPDATE %DAM KHI DANH QUAI ===//
        this.addDamMob_percent = (int) this.paramItem(0, 19, 0);
        
        //===UPDATE %EXP KHI DANH QUAI ===//
        this.expMob_percent = (int) this.paramItem(0, 88, 0);
        
        //===UPDATE DOWNDAMAGE QUAI ===//
        this.downDamage_percent = (int) this.paramItem(0, 94, 0) + this.cDefPercentGoc;
        if (this.isHaveItems(378)) {
            this.downDamage_percent = this.downDamage_percent + 5;
        }
        if (this.vInosukeH > 0) {
            this.downDamage_percent = this.downDamage_percent + this.vInosukeH;
        }
        if (this.vInosuke > 0) {
            this.downDamage_percent = this.downDamage_percent + this.vInosuke;
        }
        //Gato nhen
        if (this.isGatoSpider) {
            this.downDamage_percent = this.downDamage_percent + 5;
        }
        // 9 nga, 9 cua, 9 hong mao
        if (this.vPet9) this.downDamage_percent += 9;
        
        //isSetXiHang
        this.isSetXiHang = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(127) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(127) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(127) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(127) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(127);
        
        //isSetKirin
        this.isSetKirin = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(128) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(128) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(128) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(128) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(128);
        //isSetSongoku
        this.isSetSongoku = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(129) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(129) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(129) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(129) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(129);
        //isSetPicolo
        this.isSetPicolo = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(130) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(130) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(130) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(130) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(130);
        //isSetOcTieu
        this.isSetOcTieu = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(131) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(131) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(131) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(131) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(131);
        //isSetPikkoroDaimao
        this.isSetPikkoroDaimao = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(132) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(132) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(132) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(132) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(132);
        //isSetKakarot
        this.isSetKakarot = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(133) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(133) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(133) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(133) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(133);
        //isSetCaDic
        this.isSetCaDic = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(134) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(134) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(134) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(134) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(134);
        //isSetNappa
        this.isSetNappa = this.arrItemBody[0] != null && this.arrItemBody[0].isHaveOption(135) && this.arrItemBody[1] != null && this.arrItemBody[1].isHaveOption(135) && this.arrItemBody[2] != null && this.arrItemBody[2].isHaveOption(135) && this.arrItemBody[3] != null && this.arrItemBody[3].isHaveOption(135) && this.arrItemBody[4] != null && this.arrItemBody[4].isHaveOption(135);
        if (this.isSetNappa) {
            this.cHPFull = this.cHPFull + (int)((long)this.cHPFull * 8l / 10L);
        }
        
        //===UPDATE HUTKI PERCENT 5s ===//
        this.HutHPKI5_percent = (int) this.paramItem(0, 8, 0);
        
        //===UPDATE BI TAN CONG HOI KI ===//
        this.attToKI = (int) this.paramItem(0, 4, 0);
        
        //===UPDATE DAM CRIT PERCENT ===//
        this.damCrit_percent = (int) this.paramItem(0, 5, 0);
        
        //===UPDATE LAM TANG TRONG LUC ===//
        this.isDownSpeed = this.paramItem(0, 24, 3) == 1;
        if (this.isDownSpeed) {
            this.downSpeedSend_percent = 70;
        } else {
            this.downSpeedSend_percent = 0;
        }
        
        //===UPDATE TN,SM, DE SP USE===//
        this.tnsm_percent_petz = 0;
        if (this.me) {
            this.tnsm_percent_petz = (int) this.paramItem(0, 160, 0);
        }
        
        //===UPDATE X SD 60 SECOND===//
        this.xDamAway60s = (int) this.paramItem(0, 159, 0);
        
        //Trang bi than
        this.isFullTBT = this.arrItemBody[0] != null && this.arrItemBody[0].template.id >= 555 && this.arrItemBody[0].template.id <= 567 && this.arrItemBody[1] != null && this.arrItemBody[1].template.id >= 555 && this.arrItemBody[1].template.id <= 567 && this.arrItemBody[2] != null && this.arrItemBody[2].template.id >= 555 && this.arrItemBody[2].template.id <= 567 && this.arrItemBody[3] != null && this.arrItemBody[3].template.id >= 555 && this.arrItemBody[3].template.id <= 567 && this.arrItemBody[4] != null && this.arrItemBody[4].template.id >= 555 && this.arrItemBody[4].template.id <= 567;
        
        //Trang bi huy diet
        this.isFullTBHD = this.arrItemBody[0] != null && this.arrItemBody[0].isItemHD() && this.arrItemBody[1] != null && this.arrItemBody[1].isItemHD() && this.arrItemBody[2] != null && this.arrItemBody[2].isItemHD() && this.arrItemBody[3] != null && this.arrItemBody[3].isItemHD() && this.arrItemBody[4] != null && this.arrItemBody[4].isItemHD();
        
        
        //===UPDATE QUAI KO CHU DONG===//
        this.isMobproactive =  this.paramItem(0, 82, 3) == 1;
        
        //===UPDATE MOB EXP 20===//
        this.isMobExp20 = this.paramItem(0, 83, 3) == 1;
        
        //===UPDATE isSendDistraction===//
        this.isSendDisperse = this.paramItem(0, 111, 3) == 1;
        
        //===UPDATE isInvisiblez5===//
        this.isInvisiblez5 = this.paramItem(0, 25, 3) == 1;
        
        //====UPDATE disperse_percent %====/
        this.disperse_percent = 0;
        if (this.isDisperse) {
            this.disperse_percent = 20;
        }
        
        //===UPDATE isSendStone===//
        this.isSendStone30 = this.paramItem(0, 26, 3) == 1;
        
        //===UPDATE isSendSocola30===//
        this.isSendSocola30 = this.paramItem(0, 29, 3) == 1;
        
        //===UPDATE cuteUpKI===//
        this.cuteUpKI = (int) this.paramItem(0, 162, 0);
        
        //===UPDATE explode===//
        this.explode = (int) this.paramItem(0, 153, 0);
        
        //===UPDATE Carrot===//
        this.isSendCarrot = this.paramItem(0, 115, 3) == 1;
        
        //===UPDATE SPEED ===//
        this.cspeed = this.setSpeed;
        this.cspeed = (int) this.paramItem(this.cspeed, 16, 1);
        this.cspeed = (int) this.paramItem(this.cspeed, 114, 1);
        this.cspeed = (int) this.paramItem(this.cspeed, 148, 1);
        if (this.isMonkey != 0) {
            this.cspeed += 4;
        }
        if (this.cPower > 100000L) {
            this.cspeed += 2;
        }
        if (this.downSpeed_percent > 0) {
            this.cspeed = (int) ((long)this.cspeed - ((long)this.cspeed * (long)downSpeed_percent / 100L));
        }
        this.cspeedFull = this.cspeed;
        
        //Dich chuyen tuc thoi
        this.damMove = (int) this.paramItem(0, 181, 0);
        
        //Sat thuong de tu trung
        this.damMob = (int) this.paramItem(0, 182, 0);
        
        //Giam hoi khien
        this.downProtected = (int) this.paramItem(0, 183, 0);
        
        //Giam % hoi khien
        this.downEffblindPercent = (int) this.paramItem(0, 175, 0);
        
        //Giam giay hoi khien
        this.downEffblindSc = (int) this.paramItem(0, 187, 0);
        
        //Tb Tanjiro
        this.isTBTanjiro = this.arrItemBody[5] != null && this.arrItemBody[5].template.id == 1087;
        
        //Tb Inosuke Hashibira
        this.isTBInosukeH = this.arrItemBody[5] != null && this.arrItemBody[5].template.id == 1088;
        
        //Tb Inosuke
        this.isTBInosuke = this.arrItemBody[5] != null && this.arrItemBody[5].template.id == 1089;
        
        //Tb Zenitsu
        this.isTBZenitsu = this.arrItemBody[5] != null && this.arrItemBody[5].template.id == 1090;
        
        //Tb Nezuko
        this.isTBNezuko = this.arrItemBody[5] != null && this.arrItemBody[5].template.id == 1091;
        
        //Quan Hoa
        this.isTBQuanHoa = this.arrItemBody[0] == null && this.arrItemBody[1] != null && this.arrItemBody[5] == null && (this.arrItemBody[1].template.id == 691 || this.arrItemBody[1].template.id == 692 || this.arrItemBody[1].template.id == 693);
        
        //Lo lang
        this.worrPercent = 0;
        if (this.isWorr) {
            this.worrPercent = 30;
        }
        
        //Sat thuong quai bay
        this.mobFlyPercent = (int) this.paramItem(0, 42, 0);
        
        //Sat thuong quai khi
        this.mobMonkeyPercent = (int) this.paramItem(0, 43, 0);
        
        //Sat thuong quai mat dat
        this.mobSoilPercent = (int) this.paramItem(0, 44, 0);
        
        //Sat thuong toc Trai Dat
        this.toEarthPercent = (int) this.paramItem(0, 46, 0);
        
        //Sat thuong toc Namek
        this.toNamekPercent = (int) this.paramItem(0, 45, 0);
        
        //Sat thuong toc Xayda
        this.toXaydaPercent = (int) this.paramItem(0, 197, 0);
        
        //Giam sat thuong toc Trai Dat
        this.downEarthPercent = (int) this.paramItem(0, 198, 0);
        
        //Giam sat thuong toc Namek
        this.downNamekPercent = (int) this.paramItem(0, 199, 0);
        
        //Giam sat thuong toc Xayda
        this.downXaydaPercent = (int) this.paramItem(0, 200, 0);
        
        //Sat thuong gan 2 thanh vien bang hoi
        this.dam2MemberPercent = (int) this.paramItem(0, 201, 0);
        if (this.dam2MemberPercent > 0 && this.clanNumberCountNear >= 2) {
            this.cDamFull = this.cDamFull + (int) ((long)this.cDamFull * (long)this.dam2MemberPercent / 100L);
        }
        
        //HP gan 2 thanh vien bang hoi
        this.hp2MemberPercent = (int) this.paramItem(0, 202, 0);
        if (this.hp2MemberPercent > 0 && this.clanNumberCountNear >= 2) {
            this.cHPFull = this.cHPFull + ((int)((long)this.cHPFull * (long)this.hp2MemberPercent / 100L));
        }
        
        //Ki gan 2 thanh vien bang hoi
        this.mp2MemberPercent = (int) this.paramItem(0, 203, 0);
        if (this.mp2MemberPercent > 0 && this.clanNumberCountNear >= 2) {
            this.cMPFull = this.cMPFull + ((int)((long)this.cMPFull * (long)this.mp2MemberPercent / 100L));
        }
        
        //Sat thuong len boss
        this.damBossPercent = (int) this.paramItem(0, 204, 0);
        
        //Xuyen giap can chien
        this.nearCombatPercent = (int) this.paramItem(0, 99, 0);
        
        //Dong bang 30s
        this.isSendFreeze30 = this.arrItemBody[5] != null && this.arrItemBody[5].template.id == 1205;
        
        //Con khi nguy trang
        this.isMonkeyCheat = this.arrItemBody[5] != null && (this.arrItemBody[5].template.id == 544 || this.arrItemBody[5].template.id == 545 || this.arrItemBody[5].template.id == 546) && (this.myPet == null || this.myPetz().isHopThe == 0);

        //De tu
        if (!this.me) {
            this.addDamgeKamejoko = (int) this.paramItem(0, 188, 0);
            this.addDamgeAntomic = (int) this.paramItem(0, 189, 0);
            this.addDamgeMasenko = (int) this.paramItem(0, 190, 0);
        }
        //Tb he
        this.isSetNgayHe = this.arrItemBody[5] != null && (this.arrItemBody[5].template.id == 1234 || this.arrItemBody[5].template.id == 1235 || this.arrItemBody[5].template.id == 1236);
        if (this.isSetNgayHe) {
            this.sendDownDamagePercent = 5;
        }
        
        //======================================================================================================
        
        //===UPDATE SKILL===//
        if (this.skills.size() > 0 && !this.CSkill.isEmpty()) {
            for (i = 0; i < this.skills.size(); ++i) {
                if (this.skills.get(i).template.id == this.CSkill.get(0)) {
                    this.mySkill = this.skills.get(i);
                    break;
                }
            }
        }
        
        if (this.mySkill == null && this.skills.size() > 0) {
            this.mySkill = this.skills.get(0);
            this.CSkill.clear();
            this.CSkill.add(this.mySkill.template.id);
        }
        
        //===UPDATE HEAD, BODY, LEG...===//
        if (this.arrItemBody[0] != null) {
            if (this.arrItemBody[0].template.part != -1) {
                this.body = this.arrItemBody[0].template.part;
            }
        }
        if (this.arrItemBody[1] != null) {
            if (this.arrItemBody[1].template.part != -1) {
                this.leg = this.arrItemBody[1].template.part;
            }
        }
        if (this.arrItemBody[5] != null && (!this.arrItemBody[5].isHaveOption(38) || (this.arrItemBody[5].isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
            if (this.arrItemBody[5].template.part != -1) {
                this.head = this.arrItemBody[5].template.part;
            }
            if (this.arrItemBody[5].headTemp != -1) {
                this.head = (short) this.arrItemBody[5].headTemp;
            }
            if (this.arrItemBody[5].bodyTemp != -1) {
                this.body = (short) this.arrItemBody[5].bodyTemp;
            }
            if (this.arrItemBody[5].legTemp != -1) {
                this.leg = (short) this.arrItemBody[5].legTemp;
            }
            if (this.arrItemBody[5].bagTemp != -1) {
                this.bag = (short) this.arrItemBody[5].bagTemp;
            }
            if (this.arrItemBody[5].wpTemp != -1) {
                this.wp = (short) this.arrItemBody[5].wpTemp;
            }
        }
        //Hop The
        if (this.myPet != null && this.myPetz().isHopThe > 0) {
            this.cHPFull = this.cHPFull + this.myPetz().cHPFull + (int) (this.myPetz().isMabu == 1 ? this.myPetz().cHPFull * 0.1 : 0);
            this.cMPFull = this.cMPFull + this.myPetz().cMPFull + (int) (this.myPetz().isMabu == 1 ? this.myPetz().cMPFull * 0.1 : 0);
            this.cDamFull = this.cDamFull + this.myPetz().cDamFull + (int) (this.myPetz().isMabu == 1 ? this.myPetz().cDamFull * 0.1 : 0);
        }
        try {
            //Giap Luyen Tap
            if (this.arrItemBody[6] != null) {
                if (this.arrItemBody[6].isItemTraining1()) {
                    this.cDamFull = this.cDamFull - ((int)((long)this.cDamFull * 10L /100L));
                }
                if (this.arrItemBody[6].isItemTraining2()) {
                    this.cDamFull = this.cDamFull - (int)((long)(this.cDamFull * 20L / 100L));
                }
                if (this.arrItemBody[6].isItemTraining3()) {
                    this.cDamFull = this.cDamFull - ((int)((long)this.cDamFull * 30L / 100L));
                }
            }
            if (this.isMonkeyCheat) {
                this.isMonkeyCheat = this.arrItemBody[6].template.id == 543;
            }
        } catch (Exception e) {
            this.isMonkeyCheat = false;
        }
        if (this.itemGLT != null) {
            if (this.itemGLT.isItemTraining1()) {
                this.cDamFull = this.cDamFull + ((int)((long)this.cDamFull * 10L /100L));
            }
            if (this.itemGLT.isItemTraining2()) {
                this.cDamFull = this.cDamFull + (int)((long)(this.cDamFull * 20L / 100L));
            }
            if (this.itemGLT.isItemTraining3()) {
                this.cDamFull = this.cDamFull + ((int)((long)this.cDamFull * 30L / 100L));
            }
        }
        //khang lanh
        this.isKhienCold = this.paramItem(0, 106, 3) == 1;
        if (this.isSeal) {
            this.cDamFull = (int) (this.cDamFull - (this.cDamFull * 10L / 100L));
        }
        if (this.huytSaoHP > 0) {
            this.cHPFull = this.cHPFull + ((int)((long)this.cHPFull * (long)this.huytSaoHP / 100L));
        }
        //NRSD PHU HO
        if (this.phuHoBlackBall > 0) {
            this.cHPFull = this.cHPFull * this.phuHoBlackBall;
        }
        //Bo huyet
        if (this.isBoHuyet) {
            this.cHPFull = this.cHPFull * 2;
        }
        //Bo huyet 2
        if (this.isBoHuyet2) {
            this.cHPFull = this.cHPFull + (int)((float)this.cHPFull * 1.2F);
        }
        //Bo khi
        if (this.isBoKhi) {
            this.cMPFull = this.cMPFull * 2;
        }
        //Bo khi 2
        if (this.isBoKhi2) {
            this.cMPFull = this.cMPFull + (int)((float)this.cMPFull * 1.2F);
        }
        //Tinh linh
        if (this.myCharz().petFollow != null && this.myCharz().petFollow.smallID == 6536) {
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.10F));
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.10F));
            this.cMPFull = (int) (this.cMPFull + (this.cMPFull * 0.10F));
        }
        //Yeu tinh
        if (this.myCharz().petFollow != null && this.myCharz().petFollow.smallID == 6538) {
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.10F));
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.10F));
            this.cMPFull = (int) (this.cMPFull + (this.cMPFull * 0.10F));
        }
        //Ac linh
        if (this.myCharz().petFollow != null && this.myCharz().petFollow.smallID == 6540) {
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.10F));
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.10F));
            this.cMPFull = (int) (this.cMPFull + (this.cMPFull * 0.10F));
        }
        //Sup hac am
        if (this.isSupDark) {
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.10F));
        }
        //Sup hac am
        if (this.isHumbergerWorm) {
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.10F));
        }
        //Xi muoi mai
        if (this.isXiMuoiMai) {
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.20F));
        }
        //Cua rang me
        if (this.isFood1) {
            this.cDamFull *= 1.05F;
        }
        //Bach tuoc nuong
        if (this.isFood2) {
            this.damCrit_percent += 5;
        }
        //Tom tam bot chien xu
        if (this.isFood3) {
            this.cHPFull *= 1.05F;
        }
        //Sach tuyet ky
        if (this.arrItemBody.length > 7 && this.arrItemBody[7] != null && this.arrItemBody[7].getParamOption(212) > 0) {
            this.levelBook = this.arrItemBody[7].template.level;
        } else {
            this.levelBook = 0;
        }
        //Set trang bi
        if (this.idEff_Set_Item >= 8) {
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.15F));
            this.cMPFull = (int) (this.cMPFull + (this.cMPFull * 0.15F));
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.09F));
        } else if (this.idEff_Set_Item >= 7) {
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.010F));
            this.cMPFull = (int) (this.cMPFull + (this.cMPFull * 0.010F));
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.06F));
        } else if (this.idEff_Set_Item >= 6) {
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.05F));
            this.cMPFull = (int) (this.cMPFull + (this.cMPFull * 0.05F));
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.03F));
        }
        //5% hp, ki sd
        if (this.isPercentRNM) {
            this.cHPFull = (int) (this.cHPFull + (this.cHPFull * 0.05F));
            this.cMPFull = (int) (this.cMPFull + (this.cMPFull * 0.05F));
            this.cDamFull = (int) (this.cDamFull + (this.cDamFull * 0.05F));
        }
        if (this.downDamagePercent > 0 && !this.isSetNgayHe) {
            this.cDamFull = (int) (this.cDamFull - ((long)this.cDamFull * (long)this.downDamagePercent / 100L));
        }
        //Kaio phu ho
        if (this.isBlKaio) {
            this.cHPFull = this.cHPFull + 1000000;
            this.cMPFull = this.cMPFull + 1000000;
            this.cDamFull = this.cDamFull + 10000;
        }
        
        //Danh hieu than thoai
        this.effThanThoai = this.getEffCharById(1008) != null;
        
        //Hop the
        if (this.me && this.myPet != null && this.myPetz().isHopThe > 0 && (this.arrItemBody[5] == null || !this.arrItemBody[5].isHaveOption(38)) && (this.arrItemBody[5] == null || !this.myObj().isHideFusion)) {
            if (this.myPetz().isHopThe == 1) {
                this.head = Char.gI().hopThe[this.cgender][0];
                this.body = Char.gI().hopThe[this.cgender][1];
                this.leg = Char.gI().hopThe[this.cgender][2];
            }
            if (this.myPetz().isHopThe == 2) {
                this.head = Char.gI().hopThe2[this.cgender][0];
                this.body = Char.gI().hopThe2[this.cgender][1];
                this.leg = Char.gI().hopThe2[this.cgender][2];
            }
            if (this.myPetz().isHopThe == 3) {
                this.head = Char.gI().hopThe3[this.cgender][0];
                this.body = Char.gI().hopThe3[this.cgender][1];
                this.leg = Char.gI().hopThe3[this.cgender][2];
            }
        }
        if (!this.isBienHinh && this.isMabu == 1) {
            this.head = 297;
            this.body = 298;
            this.leg = 299;
        }
        if (this.isMonkey != 0) {
            this.head = Monkey.get(this.levelMonkey).head;
            this.body = Monkey.get(this.levelMonkey).body;
            this.leg = Monkey.get(this.levelMonkey).leg;
        }
        if (this.isCarrot) {
            this.cDamFull *= 0.85;
            this.head = 406;
            this.body = 407;
            this.leg = 408;
        }
        if (this.isSocola) {
            this.head = 412;
            this.body = 413;
            this.leg = 414;
        }
        if (this.stone == 1) {
            this.head = 454;
            this.body = 455;
            this.leg = 456;
        }
        if (this.stone == 2) {
            this.head = 1210;
            this.body = 1211;
            this.leg = 1212;
        }
        if (this.isMaPhongBa1) {
            this.head = 1221;
            this.body = 1222;
            this.leg = 1223;
        }
        if (this.isAddSDHPKIText) {
            this.cDamFull = this.cDamFull + 50000;
            this.cHPFull = this.cHPFull + 50000;
            this.cMPFull = this.cMPFull + 50000;
        }
        
        //khang tdhs
        this.isAgainst20Sun = this.usePetFollowz != null && this.usePetFollowz.template.id == 2010;
        
        //khang hieu ung
        this.isAgainstEffect = this.usePetFollowz != null && this.usePetFollowz.template.id == 2011;
        
        //chong lanh
        this.isAgainstCold = this.usePetFollowz != null && this.usePetFollowz.template.id == 2012;
        if (this.isAgainstCold) {
            this.isKhienCold = true;
        }
        
        //chi mang
        if (this.pPetzStCrit > 0) {
            this.damCrit_percent = this.damCrit_percent + this.pPetzStCrit;
        }
        
        //Init Clan Member
        initClanMember();
        //Phu kien
        try {
            if (this.arrItemBody[8] != null) {
                this.bag = this.arrItemBody[8].template.part;
            }
        } catch (Exception e) {
        }
        //Dua be
        if (this.ctaskId == 3 && this.ctaskIndex == 2) {
            this.bag = 111;
        }
        //Berry
        if (this.ctaskId == 34 && this.ctaskIndex == 6) {
            this.bag = 112;
        }
        //Ngoc rong sao den
        if (this.itemBlackBall != null) {
            this.bag = 110;
        }
        //Ngoc rong namek
        if (this.itemNamekBall != null) {
            this.bag = 113;
        }
        //den cold
        if (this.isCold && !this.isKhienCold && !this.isTemplate) {
            this.cHPFull = this.cHPFull / 2;
            this.cDamFull = this.cDamFull / 2;
        }
        //Set hp mp ko cho qua max hp mp
        if (this.cHP > this.cHPFull) {
            this.cHP = this.cHPFull;
        }
        if (this.cMP > this.cMPFull) {
            this.cMP = this.cMPFull;
        }
        //LuyenTap
        if (this.playerId != -1) {
            LuyenTap o = LuyenTap.get(this.playerId);
            if (o != null) {
                o.head = this.head;
                o.body = this.body;
                o.leg = this.leg;
                o.charID = this.charID;
            }
        }
    }
    
    public long paramItem(int num, int id, int status) {
        long param = 0;
        if (status == 1 || status == 2) {
            param = num;
        }
        int i;
        int j;
        int count;
        Item item;
        ItemOption option;
        for (i = 0; i < this.arrItemBody.length; ++i) {
            item = this.arrItemBody[i];
            if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
                count = item.options.size();
                for (j = 0; j < count; ++j) {
                    option = item.options.get(j);
                    if (option != null && option.optionTemplate.id == id) {
                        switch (status) {
                            case 1:
                                param = param + ((long)param * (long)option.param / 100L);
                                break;
                            case 2:
                                param = param * (long)option.param / 100L;
                                break;
                            case 3:
                                return 1l;
                            case 4:
                                return (long)option.param;
                            default:
                                param += (long)option.param;
                                break;
                        }
                    }
                }
            }
        }
        item = Flag.FLAGS.get(this.cFlag).itemFlag;
        if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
            count = item.options.size();
            for (j = 0; j < count; ++j) {
                option = item.options.get(j);
                if (option != null && option.optionTemplate.id == id) {
                    switch (status) {
                        case 1:
                            param = param + ((long)param * (long)option.param / 100L);
                            break;
                        case 2:
                            param = param * (long)option.param / 100L;
                            break;
                        case 3:
                            return 1l;
                        case 4:
                            return (long)option.param;
                        default:
                            param += (long)option.param;
                            break;
                    }
                }
            }
        }
        item = this.getBongTai();
        if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
            count = item.options.size();
            for (j = 0; j < count; ++j) {
                option = item.options.get(j);
                if (option != null && option.optionTemplate.id == id) {
                    switch (status) {
                        case 1:
                            param = param + ((long)param * (long)option.param / 100L);
                            break;
                        case 2:
                            param = param * (long)option.param / 100L;
                            break;
                        case 3:
                            return 1l;
                        case 4:
                            return (long)option.param;
                        default:
                            param += (long)option.param;
                            break;
                    }
                }
            }
        }
        //So sieu tam
        if (!this.radas.isEmpty() && (this.zoneMap == null || !this.zoneMap.map.isMapBlackBall())) {
            for (i = 0; i < this.radas.size(); i++) {
                Rada r = this.radas.get(i);
                if (r.level != 0) {
                    for (j = 0; j < RadaTemplate.getRadaTemplate(r.id).options.size(); j++) {
                        option = RadaTemplate.getRadaTemplate(r.id).options.get(j);
                        if ((r.isUse || option.activeCard == 0) && option.activeCard <= r.level && option.optionTemplate.id == id) {
                            switch (status) {
                                case 1:
                                    param = param + ((long)param * (long)option.param / 100L);
                                    break;
                                case 2:
                                    param = param * (long)option.param / 100L;
                                    break;
                                case 3:
                                    return 1l;
                                case 4:
                                    return (long)option.param;
                                default:
                                    param += (long)option.param;
                                    break;
                            }
                        }
                    }
                }
            }
        }
        //usePet
        item = this.usePet;
        if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
            count = item.options.size();
            for (j = 0; j < count; ++j) {
                option = item.options.get(j);
                if (option != null && option.optionTemplate.id == id) {
                    switch (status) {
                        case 1:
                            param = param + ((long)param * (long)option.param / 100L);
                            break;
                        case 2:
                            param = param * (long)option.param / 100L;
                            break;
                        case 3:
                            return 1l;
                        case 4:
                            return (long)option.param;
                        default:
                            param += (long)option.param;
                            break;
                    }
                }
            }
        }
        //ItemTime
        for (i = 0; i < this.itemTime.size(); ++i) {
            item = this.itemTime.get(i).item;
            if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
                count = item.options.size();
                for (j = 0; j < count; ++j) {
                    option = item.options.get(j);
                    if (option != null && option.optionTemplate.id == id) {
                        switch (status) {
                            case 1:
                                param = param + ((long)param * (long)option.param / 100L);
                                break;
                            case 2:
                                param = param * (long)option.param / 100L;
                                break;
                            case 3:
                                return 1l;
                            case 4:
                                return (long)option.param;
                            default:
                                param += (long)option.param;
                                break;
                        }
                    }
                }
            }
        }
        //TextTime
        for (i = 0; i < this.textTime.size(); ++i) {
            item = this.textTime.get(i).item;
            if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
                count = item.options.size();
                for (j = 0; j < count; ++j) {
                    option = item.options.get(j);
                    if (option != null && option.optionTemplate.id == id) {
                        switch (status) {
                            case 1:
                                param = param + ((long)param * (long)option.param / 100L);
                                break;
                            case 2:
                                param = param * (long)option.param / 100L;
                                break;
                            case 3:
                                return 1l;
                            case 4:
                                return (long)option.param;
                            default:
                                param += (long)option.param;
                                break;
                        }
                    }
                }
            }
        }
        //Ve tinh
        
        for (i = 0; i < this.itemVTs.size(); ++i) {
            item = this.itemVTs.get(i).item;
            if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
                count = item.options.size();
                for (j = 0; j < count; ++j) {
                    option = item.options.get(j);
                    if (option != null && option.optionTemplate.id == id) {
                        switch (status) {
                            case 1:
                                param = param + ((long)param * (long)option.param / 100L);
                                break;
                            case 2:
                                param = param * (long)option.param / 100L;
                                break;
                            case 3:
                                return 1l;
                            case 4:
                                return (long)option.param;
                            default:
                                param += (long)option.param;
                                break;
                        }
                    }
                }
            }
        }
        //usePetFollowz
        item = this.usePetFollowz;
        if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
            count = item.options.size();
            for (j = 0; j < count; ++j) {
                option = item.options.get(j);
                if (option != null && option.optionTemplate.id == id) {
                    switch (status) {
                        case 1:
                            param = param + ((long)param * (long)option.param / 100L);
                            break;
                        case 2:
                            param = param * (long)option.param / 100L;
                            break;
                        case 3:
                            return 1l;
                        case 4:
                            return (long)option.param;
                        default:
                            param += (long)option.param;
                            break;
                    }
                }
            }
        }
        //EffChar
        for (i = 0; i < this.aEffChar.size(); ++i) {
            if (!this.aEffChar.get(i).isPaint) {
                continue;
            }
            item = this.aEffChar.get(i).item;
            if (item != null && this.cPower >= item.getstrRequire() && (!item.isHaveOption(212) || item.getParamOption(212) > 0) && (!item.isHaveOption(38) || (item.isHaveOption(38) && this.myPet != null && this.myPetz().isHopThe > 0))) {
                count = item.options.size();
                for (j = 0; j < count; ++j) {
                    option = item.options.get(j);
                    if (option != null && option.optionTemplate.id == id) {
                        switch (status) {
                            case 1:
                                param = param + ((long)param * (long)option.param / 100L);
                                break;
                            case 2:
                                param = param * (long)option.param / 100L;
                                break;
                            case 3:
                                return 1l;
                            case 4:
                                return (long)option.param;
                            default:
                                param += (long)option.param;
                                break;
                        }
                    }
                }
            }
        }
        if (param > 2000000000L) {
            param = 2000000000L;
        }
        return param;
    }
    
    public void InGame() {
        if (this.zoneMap == null) {
            
            //Lech Teamobi
            for (int i = 0; i < ItemTemplate.itemTemplatesNew.size(); i++) {
            this.session.service.updateItem3LechTeamobi(ItemTemplate.itemTemplatesNew.get(i));
            }
            //set
            this.setSuperRank(0);
            this.session.timeDisconnect = -1;
            //MapOffline
            for (int i1 = 0; i1 < this.arrMapOfflineId[this.cgender].length; i1++) {
                Map map = new Map(this.arrMapOfflineId[this.cgender][i1], 1, 15, 0);
                map.isOpen = true;
                this.mapOfflines.add(map);
            }
            //Duahau
            this.updateDuaHau();
            if (this.cHP <= 0) {
                this.cHP = 1;
                this.mapTemplateId = mainHome();
                this.cx = 444;
                this.cy = 336;
            }
            //WRITE
            this.session.service.meLoadAll();
            this.session.service.meLoadPoint();
            this.session.service.getTask(this.cgender, this.ctaskId, this.ctaskIndex, this.ctaskCount);
            if (CallDragon.gI().isRongThanXuatHien) {
                this.session.service.callDragon(CallDragon.gI().mapId, CallDragon.gI().bgId, CallDragon.gI().zoneId, CallDragon.gI().charId, "", CallDragon.gI().rx, CallDragon.gI().ry, CallDragon.gI().isRongNamek ? 1 : 0);
            }
            //JOIN MAP
            ZoneMap zone;
            if (Map.isMapOffline(this.mapTemplateId)) {
                try {
                    zone = this.getMapOffline(this.mapTemplateId).getZone(this);
                } catch (Exception e) {
                    this.cx = 444;
                    this.cy = 336;
                    zone = this.getMapOffline(this.mapTemplateId = mainHome()).getZone(this);
                }
            } else {
                Map map = Map.getMapServer(this.mapTemplateId);
                if (map != null && !map.isMapBigBoss() && !map.isMapBlackBall() && !map.isMapButcher() && !map.isMapMabu() && !map.isMapCace23() && map.templateId != 51) {
                    zone = map.getZone(this);
                } else {
                    this.cx = 444;
                    this.cy = 336;
                    zone = this.getMapOffline(this.mapTemplateId = mainHome()).getZone(this);
                }
            }
            if (zone != null) {
                zone.join(this, 0, -1, -1);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                return;
            }
            //itemTime
            for (int i2 = 0; i2 < this.wit.size(); i2++) {
                ItemTime itemTime2 = this.wit.get(i2);
                if (itemTime2.second > 0) {
                    if (itemTime2.item == null) {
                        this.setItem(itemTime2.idIcon, itemTime2.second, itemTime2.type, itemTime2.damage);
                    } else {
                        this.setItem(itemTime2.idIcon, itemTime2.second, itemTime2.type, itemTime2.item);
                    }
                }
            }
            this.wit.clear();
            this.isItemTime = true;
            //textTime
            for (int i2 = 0; i2 < this.wtxt.size(); i2++) {
                ItemTime textTime2 = this.wtxt.get(i2);
                if (textTime2.second > 0) {
                    if (textTime2.item == null) {
                        this.setText(textTime2.idIcon, textTime2.text, textTime2.second, textTime2.type, textTime2.damage);
                    } else {
                        this.setText(textTime2.idIcon, textTime2.text, textTime2.second, textTime2.type, textTime2.item);
                    }
                }
            }
            this.wtxt.clear();
            this.isTextTime = true;
            this.session.service.Body(this.head, this.arrItemBody);
            this.session.service.updateBody(1, charID, head, body, leg, isMonkey);
            this.session.service.loadRMS(mResources.CSKILL, CSkill);
            this.session.service.loadRMS(mResources.OSKILL, OSkill);
            this.session.service.loadRMS(mResources.KSKILL, KSkill);
            this.session.service.maxStamina(this.cMaxStamina);
            this.session.service.Stamina(this.cStamina);
            this.session.service.rank(this.getRank() + 1);
            if (this.myPet != null) {
                this.session.service.petInfo1();
            } else {
                this.session.service.petInfo0();
            }
            this.session.service.speacialSkill(this.cgender, this.cspeacialSkill, this.paramSpeacialSkill);
            this.session.service.clanInfo(getRole(), this.clan);
            this.session.service.getBag(this.charID, this.bag);
            this.session.service.updateCoolDown(this.skills);
            this.curExpSkill();
            //
            if (!RongVoCuc.gI().isCallRongVoCuc) {
                this.session.service.openUISay(4, mResources.TB, 1139);
//                String srcchat[] = mResources.SRC_BIG_MESSAGE1.split("\\|");
//                this.session.service.bigMessage2(srcchat[0], 1139, srcchat[1], srcchat[2]);
            }
            //Task Info
            
            {
                dragon.t.MeTask.infoTask(this);
                this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.TASK_INFO, Task.getTask(this.ctaskId).subNames[this.cgender][this.ctaskIndex]), null, 0);
            }
            this.session.service.gameInfo(GameInfo.infos);
            if (LuckyNumber.gI().isHavePlayer(this.playerId)) {
                this.session.service.showYourNumber(LuckyNumber.gI().getPlayer(this.playerId).yourNumber());
            }
            /////
//            long thoigianx2 = 1697709414079L;
//            if (thoigianx2 - System.currentTimeMillis() > 0) {
//                int day = (int) (((thoigianx2 - System.currentTimeMillis()) / 1000L) / 86400L) + 1;
//                short sc = (short) ((thoigianx2 - System.currentTimeMillis()) / 1000L);
//                if (sc < 0) {
//                    sc = 30000;
//                }
//                this.setText(2, String.format(mResources.X2_EVENT_TEXT, day), sc, 0, 0);
//            }
            this.isPhatQua = true;
            //max the luc
            this.upStamina(this.cMaxStamina);
            //EffChar
            for (int i = 0; i < this.aEffChar.size(); i++) {
                if (this.aEffChar.get(i).isPaint) {
                    this.session.service.addEffectChar(this.charID, this.aEffChar.get(i).effId, this.aEffChar.get(i).layer, this.aEffChar.get(i).loop, this.aEffChar.get(i).tLoop, this.aEffChar.get(i).isStand);
                }
            }
        }
    }
    
    public void updateXu(long x, int type) {
        if ((long)(this.xu+x) > this.maxXu) {
            x = this.maxXu - this.xu;
        } else if ((long)(this.xu-x) < -this.maxXu) {
            x = this.maxXu + this.xu;
        }
        this.xu += x;
        if (type == 1 && this.session != null) {
            this.session.service.updateCoinBag((int) x);
        }
        if (type == 2 && this.session != null) {
            this.session.service.meLoadInfo();
        }
    }
    
    public long getLuong2() {
        return (long)this.luongKhoa + (long)this.luong;
    }
    
    public long getLuong() {
        return this.luong;
    }
    
    public void updateLuong2(long x, int type) {
        if ((long)(this.luongKhoa+x) > 2000000000) {
            x = 2000000000 - this.luongKhoa;
        } else if ((long)(this.luongKhoa+x) < -2000000000) {
            x = -2000000000 - this.luongKhoa;
        }
        this.luongKhoa += x;
        if (this.luongKhoa < 0) {
            int x2 = this.luongKhoa;
            this.luongKhoa = 0;
            if ((long)(this.luong+x2) > 2000000000) {
                x2 = 2000000000 - this.luong;
            } else if ((long)(this.luong+x2) < -2000000000) {
                x2 = -2000000000 - this.luong;
            }
            this.luong += x2;
        }
        if (type == 2) {
            this.session.service.meLoadInfo();
        }
    }
    
    public void updateLuong(long x, int type) {
        if ((long)(this.luong+x) > 2000000000) {
            x = 2000000000 - this.luong;
        } else if ((long)(this.luong-x) < -2000000000) {
            x = 2000000000 + this.luong;
        }
        this.luong += x;
        if (type == 2) {
            this.session.service.meLoadInfo();
        }
    }
    
    public void updateLuongKhoa(long x, int type) {
        if ((long)(this.luongKhoa+x) > 2000000000) {
            x = 2000000000 - this.luongKhoa;
        } else if ((long)(this.luongKhoa+x) < -2000000000) {
            x = -2000000000 - this.luongKhoa;
        }
        this.luongKhoa += x;
        if (type == 2) {
            this.session.service.meLoadInfo();
        }
    }
    
    public int totalBagByItem(Item item) {
        int totalQuantity = 0, i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] == null) {
                totalQuantity = totalQuantity + item.maxQuantity();
            } else if (this.isAlikeItem(this.arrItemBag[i], item) && this.arrItemBag[i].quantity < item.maxQuantity()) {
                totalQuantity = totalQuantity + (item.maxQuantity() - this.arrItemBag[i].quantity);
            }
        }
        return totalQuantity;
    }
    
//    public int totalBagById(int id, int maxQuantity) {
//        int totalQuantity = 0, i;
//        for (i = 0; i < this.arrItemBag.length; i++) {
//            if (this.arrItemBag[i] == null) {
//                totalQuantity = totalQuantity + maxQuantity;
//            } else if (this.arrItemBag[i].template.id == id && this.arrItemBag[i].quantity < maxQuantity) {
//                totalQuantity = totalQuantity + (maxQuantity - this.arrItemBag[i].quantity);
//            }
//        }
//        return totalQuantity;
//    }
    
    public void addItemMore(int status, Item item) {
        if (item.isHaveOption(93)) {
            item.setExpires(System.currentTimeMillis() + (86400000L * (long)(item.getParamOption(93) + 1L)));
        }
        item.typeUI = 6;
        this.arrItemMore.add(item);
        if (status == 0) {
            if (item.quantity > 1) {
                this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_7, item.quantity, item.template.name));
            } else {
                this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_8, item.template.name));
            }
        }
    }
    
    public void addItemMore2(int status, Item item) {
        if (item.isHaveOption(93)) {
            item.setExpires(System.currentTimeMillis() + (86400000L * (long)(item.getParamOption(93) + 1L)));
        }
        item.typeUI = 7;
        this.arrItemMore2.add(item);
        if (status == 0) {
            if (item.quantity > 1) {
                this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_9, item.quantity, item.template.name));
            } else {
                this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_10, item.template.name));
            }
        }
    }
    
    public boolean isAlikeItem(Item... array) {
        if(array.length == 0) return true; // Handle empty array

        Item firstItem = array[0];
        for (Item item : array) {
            if (item == null && firstItem != null) return false;
            if (item != null && firstItem == null) return false;

            if (item == null || firstItem == null) {
                continue;
            }

            if (item.template.id != firstItem.template.id) return false;
            if (item.isLock != firstItem.isLock) return false;

            if (item.options.size() != firstItem.options.size()) return false;
            for (int i = 0; i < item.options.size(); i++) {
                if (item.options.size() != firstItem.options.size() || item.options.get(i).optionTemplate.id != firstItem.options.get(i).optionTemplate.id) {
                    return false;
                }
            }
        }
        return true;
    }

    
    public boolean addItemBag(int status, Item item) {
        switch (item.template.type) {
            //Vang
            case 9:
            {
                int n = item.quantity;
                if (item.isHaveOption(171)) {
                    n = item.getParamOption(171) * 1000;
                }
                this.updateXu(n, 1);
                if (status == 0) {
                    this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_VANG, Util.gI().getFormatNumber(n)));
                }
                return true;
            }
            case 10:
            {
                int n = item.quantity;
                if (item.isHaveOption(171)) {
                    n = item.getParamOption(171) * 1000;
                }
                this.updateLuong(n, 2);
                if (status == 0) {
                    this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_NGOC, Util.gI().getFormatNumber(n)));
                }
                return true;
            }
            //Bua
            case 13:
            {
                int second = item.getParamOption(185) * 3600;
                if (second < 3600) {
                    second = 3600;
                }
                this.setAmu(item.template.id, second);
                if (status == 0) {
                    this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_2, Util.gI().getFormatTime3(second * 1000L), item.template.name));
                }
                return true;
            }
            case 34:
            {
                int n = item.quantity;
                if (item.isHaveOption(171)) {
                    n = item.getParamOption(171) * 1000;
                }
                this.updateLuongKhoa(n, 2);
                if (status == 0) {
                    this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_HNGOC, Util.gI().getFormatNumber(n)));
                }
                return true;
            }
            default:
                CaiTrang.gI().setPartTemp(item);
                if (item.isHaveOption(93)) {
                    item.setExpires(System.currentTimeMillis() + (86400000L * (long)(item.getParamOption(93) + 1L)));
                }
                //Check quntity
                int totalQuantity = 0;
                int indexUI = -1;
                boolean ctn = false;
                if (item.template.id == 521) {
                    if (this.isExistItem(4387)) {
                        int second = this.getItemById(4387).second + (item.getParamOption(1) * 60);
                        if (second > 31200) {
                            second = 31200;
                        }
                        this.setItem(4387, second, 1, 0);
                        ctn = true;
                        indexUI = 0;
                    } else if (this.isHaveItem(item.template.id)) {
                        for (int i = 0; i < item.options.size(); i++) {
                            if (item.options.get(i).optionTemplate.id == 1 && this.getItem(item.template.id).getOption(1) != null) {
                                this.getItem(item.template.id).getOption(1).param += item.options.get(i).param;
                                if (this.getItem(item.template.id).getOption(1).param > 520) {
                                    this.getItem(item.template.id).getOption(1).param = 520;
                                }
                            }
                        }
                        if (status != 2) {
                            this.session.service.Bag(this.arrItemBag);
                        }
                        if (status != 2) {
                            this.session.service.Box(this.arrItemBox);
                        }
                        if (status != 2) {
                            this.session.service.Body(this.head, this.arrItemBody);
                        }
                        ctn = true;
                        indexUI = 0;
                    } else {
                        ctn = false;
                    }
                }
                if (!ctn) {
                    for (int i = 0; i < this.arrItemBag.length; i++) {
                        if (item.isItemSLL()) {
                            if (this.arrItemBag[i] == null) {
                                totalQuantity = totalQuantity + 30000;
                            } else if (this.isAlikeItem(item, this.arrItemBag[i]) && this.arrItemBag[i].getParamOption(31) < 30000) {
                                totalQuantity = totalQuantity + (30000 - this.arrItemBag[i].quantity);
                            }
                        } else {
                            if (this.arrItemBag[i] == null) {
                                totalQuantity = totalQuantity + item.maxQuantity();
                            } else if (this.isAlikeItem(item, this.arrItemBag[i]) && this.arrItemBag[i].quantity < item.maxQuantity()) {
                                totalQuantity = totalQuantity + (item.maxQuantity() - this.arrItemBag[i].quantity);
                            }
                        }
                    }
                    if (item.isItemSLL() ? totalQuantity >= item.getParamOption(31) : totalQuantity >= item.quantity) {
                        //Add
                        if (item.isBigItem()) {
                            totalQuantity = item.quantity;
                            for (int i = 0; i < this.arrItemBag.length; i++) {
                                if (this.arrItemBag[i] == null) {
                                    if (totalQuantity > item.maxQuantity()) {
                                        this.addItemBag(item.clone(), i);
                                        this.arrItemBag[i].quantity = item.maxQuantity();
                                        totalQuantity = totalQuantity - this.arrItemBag[i].quantity;
                                    } else {
                                        this.addItemBag(item.clone(), i);
                                        this.arrItemBag[i].quantity = totalQuantity;
                                        totalQuantity = totalQuantity - this.arrItemBag[i].quantity;
                                    }
                                } else if (this.isAlikeItem(item, this.arrItemBag[i]) && this.arrItemBag[i].quantity < item.maxQuantity()) {
                                    if (this.arrItemBag[i].quantity + totalQuantity > item.maxQuantity()) {
                                        int num = this.arrItemBag[i].quantity;
                                        this.arrItemBag[i].quantity = item.maxQuantity();
                                        totalQuantity = totalQuantity - (this.arrItemBag[i].quantity - num);
                                        if (this.arrItemBag[i].expires > item.expires && item.expires != -1) {
                                            this.arrItemBag[i].setExpires(item.expires);
                                        }
                                    } else {
                                        int num = this.arrItemBag[i].quantity;
                                        this.arrItemBag[i].quantity = this.arrItemBag[i].quantity + totalQuantity;
                                        totalQuantity = totalQuantity - (this.arrItemBag[i].quantity - num);
                                        if (this.arrItemBag[i].expires > item.expires && item.expires != -1) {
                                            this.arrItemBag[i].setExpires(item.expires);
                                        }
                                    }
                                }
                                if (totalQuantity <= 0) {
                                    break;
                                }
                            }
                            indexUI = -2;
                        } else {
                            indexUI = this.getItemBagIndex(item);
                            if (indexUI != -1) {
                                if (item.isItemSLL()) {
                                    this.addQuantityItemBagByIndex(indexUI, item.getParamOption(31));
                                } else {
                                    this.addQuantityItemBagByIndex(indexUI, item.quantity);
                                }
                                if (this.arrItemBag[indexUI].expires > item.expires && item.expires != -1) {
                                    this.arrItemBag[indexUI].setExpires(item.expires);
                                }
                            } else {
                                indexUI = getEmptyBagIndex();
                                if (indexUI != -1) {
                                    this.addItemBag(item.clone(), indexUI);
                                }
                            }
                        }
                    }
                }
                if (indexUI != -1) {
                    if (status != 2) {
                        this.session.service.Bag(this.arrItemBag);
                    }
                    if (status == 0) {
                        if (item.template.type == 6) {
                            this.addInfo1(String.format(mResources.BAN_NHAN_DUOC_3, item.quantity, item.template.name));
                        } else {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.BAN_NHAN_DUOC, item.template.name), null, (byte)1);
                        }
                    }
                    if (status == 3) {
                        if (item.template.type == 6) {
                            this.addInfo1(3000, String.format(mResources.BAN_NHAN_DUOC_3, item.quantity, item.template.name));
                        } else {
                            this.addInfo1(3000, String.format(mResources.BAN_NHAN_DUOC, item.template.name));
                        }
                    }
                    return true;
                } else {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.BAG_FULL, null, (byte)0);
                    return false;
                }
        }
    }
    
    public void addItemBody(Item item, int indexUI) {
        item.indexUI = indexUI;
        item.typeUI = 5;
        this.arrItemBody[indexUI] = item;
    }
    
    public void addItemBag(Item item, int indexUI) {
        item.indexUI = indexUI;
        item.typeUI = 3;
        this.arrItemBag[indexUI] = item;
    }
    
    public void addItemBox(Item item, int indexUI) {
        item.indexUI = indexUI;
        item.typeUI = 4;
        this.arrItemBox[indexUI] = item;
    }
    
    public void sortBag() {
        for (int i = this.arrItemBag.length - 1; i >= 0; --i) {
            if (this.arrItemBag[i] != null) {
                for (int j = 0; j < i; ++j) {
                    if (this.arrItemBag[j] == null) {
                        this.addItemBag(this.arrItemBag[i], j);
                        this.arrItemBag[i] = null;
                        break;
                    }
                }
            }
        }
    }
    
    public int addQuantityItemBoxByIndex(int indexUI, int quantity) {
        Item item = this.arrItemBox[indexUI];
        if (item != null) {
            if (item.isItemSLL()) {
                if (!item.isHaveOption(31)) {
                    item.options.add(new ItemOption(31, item.quantity + quantity));
                } else {
                    item.getOption(31).param += quantity;
                }
                if (item.getOption(31).param > 30000) {
                    item.getOption(31).param = 30000;
                }
                if (item.getParamOption(31) <= 0) {
                    item.getOption(31).param = 0;
                    this.arrItemBox[indexUI] = null;
                }
                return item.getParamOption(31);
            } else {
                item.quantity += quantity;
                if (item.quantity <= 0) {
                    item.quantity = 0;
                    this.arrItemBox[indexUI] = null;
                }
                if (item.quantity > item.maxQuantity()) {
                    item.quantity = item.maxQuantity();
                }
                return item.quantity;
            }
        } else {
            return 0;
        }
    }
    
    public int addQuantityItemBagByIndex(int indexUI, int quantity) {
        Item item = this.arrItemBag[indexUI];
        if (item != null) {
            if (item.isItemSLL()) {
                if (!item.isHaveOption(31)) {
                    item.options.add(new ItemOption(31, item.quantity + quantity));
                } else {
                    item.getOption(31).param += quantity;
                }
                if (item.getOption(31).param > 30000) {
                    item.getOption(31).param = 30000;
                }
                if (item.getParamOption(31) <= 0) {
                    item.getOption(31).param = 0;
                    this.arrItemBag[indexUI] = null;
                }
                item.quantity = 1;
                return item.getParamOption(31);
            } else {
                item.quantity += quantity;
                if (item.quantity <= 0) {
                    item.quantity = 0;
                    this.arrItemBag[indexUI] = null;
                }
                if (item.quantity > item.maxQuantity()) {
                    item.quantity = item.maxQuantity();
                }
                return item.quantity;
            }
        } else {
            return 0;
        }
    }
    
    public int getEmptyBagIndex() {
        int indexUI = -1;
        int i;
        for (i = 0; i < this.arrItemBag.length; ++i) {
            if (this.arrItemBag[i] == null) {
                return i;
            }
        }
        return indexUI;
    }
    
    public int getEmptyBagCount() {
        int count = 0;
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] == null) {
                ++count;
            }
        }
        return count;
    }
    
    public int getEmptyBoxIndex() {
        for (int i = 0; i < this.arrItemBox.length; i++) {
            if (this.arrItemBox[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public int getItemBoxIndex(Item item) {
        for (int i = 0; i < this.arrItemBox.length; i++) {
            if (this.isAlikeItem(this.arrItemBox[i], item) && item.isItemMerge()) {
                return i;
            }
        }
        return -1;
    }
    
    public Item getItemBagById(int templateId) {
        for (int i = 0; i < this.arrItemBag.length; i++) {
            Item item = this.arrItemBag[i];
            if (item != null && item.template.id == templateId) {
                return item;
            }
        }
        return null;
    }
    
    public Item getItemBodyById(int templateId) {
        for (int i = 0; i < this.arrItemBody.length; i++) {
            Item item = this.arrItemBody[i];
            if (item != null && item.template.id == templateId) {
                return item;
            }
        }
        return null;
    }
    
    public Item getItemBoxById(int templateId) {
        for (int i = 0; i < this.arrItemBox.length; i++) {
            Item item = this.arrItemBox[i];
            if (item != null && item.template.id == templateId) {
                return item;
            }
        }
        return null;
    }
    
    public void useItemBag(int indexUI, int num) {
        Item item = this.arrItemBag[indexUI];
        item.quantity -= num;
        if (item.quantity <= 0) {
            item.quantity = 0;
            this.arrItemBag[indexUI] = null;
        }
        this.session.service.Bag(this.arrItemBag);
    }
    
    public int getItemBagIndex(Item item) {
        int indexUI = -1;
        for (int i = 0; i < this.arrItemBag.length; i++) {
            if (this.isAlikeItem(item, this.arrItemBag[i]) && item.isItemMerge()) {
                return i;
            }
        }
        return indexUI;
    }
    
    public int getItemBagByIndex(int id) {
        int indexUI = -1;
        for (int i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null && this.arrItemBag[i].template.id == id) {
                return i;
            }
        }
        return indexUI;
    }
    
//    public int getItemBagIndex(int id) {
//        int indexUI = -1;
//        int i;
//        for (i = 0; i < this.arrItemBag.length; i++) {
//            Item item = this.arrItemBag[i];
//            if (item != null && item.template.id == id && item.isItemMerge()) {
//                return i;
//            }
//        }
//        return indexUI;
//    }
    
    public int getItemBagIndex(int id, boolean isLock, int maxQuantity) {
        int indexUI = -1;
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            Item item = this.arrItemBag[i];
            if (item != null && item.template.id == id && item.isLock == isLock && item.isItemMerge() && item.quantity < maxQuantity) {
                return i;
            }
        }
        return indexUI;
    }
    
    public int getItemBagQuantityById(int id) {
        int quantity = 0, i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null && this.arrItemBag[i].template.id == id) {
                quantity += this.arrItemBag[i].quantity;
            }
        }
        return quantity;
    }
    
    public int getItemBoxQuantityById(int id) {
        int quantity = 0, i;
        for (i = 0; i < this.arrItemBox.length; i++) {
            if (this.arrItemBox[i] != null && this.arrItemBox[i].template.id == id) {
                quantity += this.arrItemBox[i].quantity;
            }
        }
        return quantity;
    }
    
    public int getItemBagQuantity(int type) {
        int quantity = 0;
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            Item item = this.arrItemBag[i];
            if (item != null && item.template.type == type) {
                quantity += item.quantity;
            }
        }
        return quantity;
    }
    
    public int getItemBoxQuantity(int type) {
        int quantity = 0;
        int i;
        for (i = 0; i < this.arrItemBox.length; i++) {
            Item item = this.arrItemBox[i];
            if (item != null && item.template.type == type) {
                quantity += item.quantity;
            }
        }
        return quantity;
    }
    
    public void setDefaultPart() {
        this.setDefaultWeapon();
        this.setDefaultBody();
        this.setDefaultLeg();
    }
    
    public void setDefaultWeapon() {
        if (this.cgender == 0) {
            this.wp = 0;
        }
    }
    
    public void setDefaultBody() {
        if (this.bodyDefault != -1) {
            this.body = this.bodyDefault;
            return;
        }
        switch (this.cgender) {
            case 0:
                if (this.isBaby) {
                    this.body = 286;
                } else {
                    this.body = 57;
                }
                break;
            case 1:
                if (this.isBaby) {
                    this.body = 289;
                } else {
                    this.body = 59;
                }
                break;
            case 2:
                if (this.isBaby) {
                    this.body = 283;
                } else {
                    this.body = 57;
                }
                break;
            default:
                break;
        }
    }
    public void setDefaultHeadPet() {
        if (this.isMabu == 1) {
            this.headDefault = 297;
            return;
        }
        switch (this.cgender) {
            case 0:
                if (this.isBaby) {
                    this.headDefault = 285;
                } else {
                    this.headDefault = 304;
                }
                break;
            case 1:
                if (this.isBaby) {
                    this.headDefault = 288;
                } else {
                    this.headDefault = 305;
                }
                break;
            case 2:
                if (this.isBaby) {
                    this.headDefault = 282;
                } else {
                    this.headDefault = 303;
                }
                break;
            default:
                break;
        }
    }
    
    
    public void setDefaultLeg() {
        if (this.legDefault != -1) {
            this.leg = this.legDefault;
            return;
        }
        switch (this.cgender) {
            case 0:
                if (this.isBaby) {
                    this.leg = 287;
                } else {
                    this.leg = 58;
                }
                break;
            case 1:
                if (this.isBaby) {
                    this.leg = 290;
                } else {
                    this.leg = 60;
                }
                break;
            case 2:
                if (this.isBaby) {
                    this.leg = 284;
                } else {
                    this.leg = 58;
                }
                break;
            default:
                break;
        }
    }
    
    public long getMoneys(int k, int n) {
        int i;
        long potential = 0;
        long c;
        if (k == 0) {
            c = this.cHPGoc;
            for (i = 0; i < n; i++) {
                potential += (c + 1000);
                c += this.hpFrom1000TiemNang;
            }
        }
        if (k == 1) {
            c = this.cMPGoc;
            for (i = 0; i < n; i++) {
                potential += (c + 1000);
                c += this.mpFrom1000TiemNang;
            }
        }
        if (k == 2) {
            c = this.cDamGoc;
            for (i = 0; i < n; i++) {
                potential += (c * 100);
                c += this.damFrom1000TiemNang;
            }
        }
        if (k == 3) {
            c = this.cDefGoc;
            for (i = 0; i < n; i++) {
                potential += (500000 + c * 100000);
                c += this.defFrom1000TiemNang;
            }
        }
        if (k == 4) {
            c = this.cCriticalGoc;
            for (i = 0; i < n; i++) {
                long num8 = 50000000L;
                for (int j = 0; j < c; j++) {
                    num8 *= 5L;
                }
                potential += num8;
                c += this.criticalFrom1000Tiemnang;
            }
        }
        return potential;
    }
    
    public void upPotentialPet() {
        this.myPetz().tupPotential = this.myPetz().settupPotential;
        if (this.myPetz().zoneMap == null) {
            return;
        }
        for(int i1 = 0; i1 < 100; i1++) {
            int u = -1;
            long min = -1;
            int num = 1;
            for (int i2 = 0; i2 < 5; i2++) {
                long potential = this.myPetz().getMoneys(i2, num);
                if (this.myPetz().cTiemNang >= potential && (this.myPetz().getPointNext(i2, num) + getPoint(i2)) <= this.myPetz().getPointLimit(i2) && (min == -1 || (min > this.getPointMin(i2, num)))) {
                    min = this.getPointMin(i2, num);
                    u = i2;
                }
            }
            if (u == -1) {
                break;
            } else {
                this.myPetz().upPotential(u, num);
            }
        }
    }
    
    public int potentialForOneAdd(int typePotential) {
        if (typePotential == 0) {
            return this.hpFrom1000TiemNang;
        }
        if (typePotential == 1) {
            return this.mpFrom1000TiemNang;
        }
        if (typePotential == 2) {
            return this.damFrom1000TiemNang;
        }
        if (typePotential == 3) {
            return this.defFrom1000TiemNang;
        }
        if (typePotential == 4) {
            return this.criticalFrom1000Tiemnang;
        }
        return 0;
    }
    
    public void upPotential(int typePotential, int num) {
        int num2;
        long potential;
        long p1 = this.cTiemNang;
        if (typePotential == 0) {
            num2 = this.hpFrom1000TiemNang * num;
            potential = getMoneys(typePotential, num);
            if ((num2 + this.cHPGoc) > getPointLimit(typePotential)) {
                if (session != null) {
                    this.session.service.startOKDlg(mResources.NOT_ENOUGH_POWER_LIMIT);
                }
            } else if (num2 > 0 && potential > 0) {
                if (potential > this.cTiemNang) {
                    if (session != null) {
                        this.session.service.startOKDlg(String.format(mResources.NOT_ENOUGH_POTENTIAL, Util.gI().numberTostring(this.cTiemNang), Util.gI().numberTostring(potential)));
                    }
                } else {
                    this.cHPGoc += num2;
                    this.cTiemNang -= potential;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        if (typePotential == 1) {
            num2 = this.mpFrom1000TiemNang * num;
            potential = getMoneys(typePotential, num);
            if ((num2 + this.cMPGoc) > getPointLimit(typePotential)) {
                if (session != null) {
                    this.session.service.startOKDlg(mResources.NOT_ENOUGH_POWER_LIMIT);
                }
            } else if (num2 > 0 && potential > 0) {
                if (potential > this.cTiemNang) {
                    if (session != null) {
                        this.session.service.startOKDlg(String.format(mResources.NOT_ENOUGH_POTENTIAL, Util.gI().numberTostring(this.cTiemNang), Util.gI().numberTostring(potential)));
                    }
                } else {
                    this.cMPGoc += num2;
                    this.cTiemNang -= potential;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        if (typePotential == 2) {
            num2 = this.damFrom1000TiemNang * num;
            potential = getMoneys(typePotential, num);
            if ((num2 + this.cDamGoc) > getPointLimit(typePotential)) {
                if (session != null) {
                    this.session.service.startOKDlg(mResources.NOT_ENOUGH_POWER_LIMIT);
                }
            } else if (num2 > 0 && potential > 0) {
                if (potential > this.cTiemNang) {
                    if (session != null) {
                        this.session.service.startOKDlg(String.format(mResources.NOT_ENOUGH_POTENTIAL, Util.gI().numberTostring(this.cTiemNang), Util.gI().numberTostring(potential)));
                    }
                } else {
                    this.cDamGoc += num2;
                    this.cTiemNang -= potential;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        if (typePotential == 3) {
            num2 = this.defFrom1000TiemNang * num;
            potential = getMoneys(typePotential, num);
            if ((num2 + this.cDefGoc) > getPointLimit(typePotential)) {
                if (session != null) {
                    this.session.service.startOKDlg(mResources.NOT_ENOUGH_POWER_LIMIT);
                }
            } else if (num2 > 0 && potential > 0) {
                if (potential > this.cTiemNang) {
                    if (session != null) {
                        this.session.service.startOKDlg(String.format(mResources.NOT_ENOUGH_POTENTIAL, Util.gI().numberTostring(this.cTiemNang), Util.gI().numberTostring(potential)));
                    }
                } else {
                    this.cDefGoc += num2;
                    this.cTiemNang -= potential;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        if (typePotential == 4) {
            num2 = this.criticalFrom1000Tiemnang * num;
            potential = getMoneys(typePotential, num);
            if ((num2 + this.cCriticalGoc) > getPointLimit(typePotential)) {
                if (this.session != null) {
                    this.session.service.startOKDlg(mResources.NOT_ENOUGH_POWER_LIMIT);
                }
            } else if (num2 > 0 && potential > 0) {
                if (potential > this.cTiemNang) {
                    if (session != null) {
                        this.session.service.startOKDlg(String.format(mResources.NOT_ENOUGH_POTENTIAL, Util.gI().numberTostring(this.cTiemNang), Util.gI().numberTostring(potential)));
                    }
                } else {
                    this.cCriticalGoc += num2;
                    this.cTiemNang -= potential;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        if (p1 != this.cTiemNang) {
            if (this.ctaskId == 3 && this.ctaskIndex == 0) {
                this.updateTask(1);
            }
        }
    }
    
    public boolean isEquipThan() {
        boolean b = true;
        int i;
        for (i = 0; i < this.arrItemBody.length; ++i) {
            Item it = this.arrItemBody[i];
            if (it != null && (it.template.id >= 555 && it.template.id <= 567)) {
                b = true;
                break;
            }
        }
        return b;
    }
    
    public static long getPowerLimit(int cPowerLimit) {
        switch (cPowerLimit) {
            case 0:
                return 17999999999L;
            case 1:
                return 19999999999L;
            case 2:
                return 24999999999L;
            case 3:
                return 29999999999L;
            case 4:
                return 39999999999L;
            case 5:
                return 50010000000L;
            case 6:
                return 60010000000L;
            case 7:
                return 70000000000L;
            case 8:
                return 80000000000L;
            case 9:
                return 120010000000L;
            case 10:
                return 150010000000L;
            default:
                return 200000000000L;
        }
    }
    
    public int getPointNext(int i, int num) {
        if (i == 0) {
            return this.hpFrom1000TiemNang * num;
        }
        if (i == 1) {
            return this.mpFrom1000TiemNang * num;
        }
        if (i == 2) {
            return this.damFrom1000TiemNang * num;
        }
        if (i == 3) {
            return this.defFrom1000TiemNang * num;
        }
        if (i == 4) {
            return this.criticalFrom1000Tiemnang * num;
        }
        return 0;
    } 
    
    public int getPoint(int i) {
        if (i == 0) {
            return this.cHPGoc;
        }
        if (i == 1) {
            return this.cMPGoc;
        }
        if (i == 2) {
            return this.cDamGoc;
        }
        if (i == 3) {
            return this.cDefGoc;
        }
        if (i == 4) {
            return this.cCriticalGoc;
        }
        return 0;
    }
    
    public int getPointLimit(int i) {
        if (i == 0 || i == 1) {
            return getHpMpLimit();
        }
        if (i == 2) {
            return getDamLimit();
        }
        if (i == 3) {
            return getDefLimit();
        }
        if (i == 4) {
            return getCritLimit();
        }
        return 0;
    }

    public int getHpMpLimit() {
        switch (cPowerLimit) {
            case 0:
                return 220000;
            case 1:
                return 240000;
            case 2:
                return 300000;
            case 3:
                return 350000;
            case 4:
                return 400000;
            case 5:
                return 450000;
            case 6:
                return 500000;
            case 7:
                return 525000;
            case 8:
                return 550000;
            case 9:
                return 575000;
            case 10:
                return 600000;
            default:
                return 0;
        }
    }

    public int getDamLimit() {
        switch (cPowerLimit) {
            case 0:
                return 11000;
            case 1:
                return 12000;
            case 2:
                return 15000;
            case 3:
                return 18000;
            case 4:
                return 20000;
            case 5:
                return 22000;
            case 6:
                return 24000;
            case 7:
                return 24500;
            case 8:
                return 25000;
            case 9:
                return 25500;
            case 10:
                return 26000;
            default:
                return 0;
        }
    }

    public short getDefLimit() {
        switch (cPowerLimit) {
            case 0:
                return 550;
            case 1:
                return 600;
            case 2:
                return 700;
            case 3:
                return 800;
            case 4:
                return 1000;
            case 5:
                return 1200;
            case 6:
                return 1400;
            case 7:
                return 1500;
            case 8:
                return 1600;
            case 9:
                return 1700;
            case 10:
                return 1800;
            default:
                return 0;
        }
    }

    public byte getCritLimit() {
        switch (cPowerLimit) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            case 4:
                return 9;
            case 5:
                return 10;
            case 6:
                return 11;
            case 7:
                return 12;
            case 8:
                return 13;
            case 9:
                return 14;
            case 10:
                return 15;
            default:
                return 0;
        }
    }
    
    public int mainHome() {
        if (this.cgender == 0) {
            return 21;
        }
        if (this.cgender == 1) {
            return 22;
        }
        if (this.cgender == 2) {
            return 23;
        }
        return -1;
    }
    
    public int newStart() {
        if (this.cgender == 0) {
            return 39;
        }
        if (this.cgender == 1) {
            return 40;
        }
        if (this.cgender == 2) {
            return 41;
        }
        return -1;
    }
    
    public void startDie(int type, int cx, int cy) {
        if (!this.me) {
            this.timeHS = (int) ((System.currentTimeMillis() + (1000 * 60)) / 1000);
        }
        this.cx = cx;
        this.cy = cy;
        this.cHP = 0;
        this.isLockMove = true;
        this.isDie = true;
        Trade.getInstance().cancelgiaodich(this, 1);
        this.isCharge = false;
        this.gong = false;
        this.timeGong2 = 0;
        zoneMap.removeAttMob(charID);
        zoneMap.removeAttChar(charID);
        if (this.isMonkey != 0) {
            this.bienHinh(0, 0, 0);
        }
        if (type == 1 && this.cTemplateType != 6) {
            if (this.session != null) {
                this.session.service.startDie(this.cPk, cx, cy, this.isFuture ? this.cPower : -1);
            }
            this.zoneMap.playerDie(this);
            if (this.timeLive == -1 && this.cTemplateType != 26) {
                if (this.cTemplateType == 7 || this.cTemplateId == 53) {
                    this.timeClear = 0;
                } else {
                    this.timeClear = 5000;
                }
            }
        }
        
        //De trung
        if (this.mobMe != null) {
            this.clearMobMe();
        }
        //Hieu ung troi
        if (this.holder_charId != -1) {
            Char player443 = this.zoneMap.findCharInMap(this.holder_charId);
            if (player443 != null) {
                player443.hold(0, 0, 32, -1, -1);
            }
            this.hold(0, 0, 32, -1, -1);
        }
        //Bo troi neu chet
        if (this.mobId_holder != -1 || this.charId_holder != -1) {
            Mob mob34 = this.zoneMap.getMobIdHold(this.charID);
            if (mob34 != null) {
                mob34.hold(0, 0, 32, -1);
            }
            Char player34 = this.zoneMap.getCharIdHold(this.charID);
            if (player34 != null) {
                player34.hold(0, 0, 32, -1, -1);
            }
            this.hold(0, 0, 32, -1, -1);
            this.mobId_holder = -1;
            this.charId_holder = -1;
        }
        //Bo nrsd neu chet
        if (this.itemBlackBall != null) {
            this.throwBlackBall();
        }
        //Bo nrnm neu chet
        if (this.itemNamekBall != null) {
            this.throwNamekBall();
        }
        //Bo bien socola
        if (this.isSocola) {
            this.setItem(4133, 0, 0, 0);
        }
        //Phat no
        if (this.explode > 0 && this.explode > Util.gI().nextInt(200)) {
            this.explode(3);
        }
        //Xen hoan thien no
        if (this.cTemplateType == 16 || this.cTemplateType == 20) {
            this.explode(2);
            this.zoneMap.chat(this, mResources.BOOM_CELL);
        }
        //Saibamen chet
        if (this.boomWhenDie) {
            this.explode(3);
            this.zoneMap.addWarningBoom();
            this.zoneMap.addBinld(3000, 0);
        }
        if (this.phuHoBlackBall > 0) {
            this.phuHoBlackBall = 0;
            this.updateAll();
            if (this.session != null) {
                this.session.service.meLoadPoint();
            }
            this.zoneMap.playerLoadAll(this);
        }
        //Bao hoi sinh
        if (this.cTemplateType == 26) {
            this.zoneMap.chat(this, mResources.SAY_HOI_SINH);
        }
        //Drabula
        this.isArgue = false;
        //Bo nguoi ra
        if (this.cTemplateId == 91) {
            this.zoneMap.drop();
        }
        //Ra khoi ken
        if (this.isMabuHold) {
            this.zoneMap.setCocoon(this.charID, false);
        }
        //ket thuc thach dau
        this.loser(1);
        //Hoi mau nhan ban
        if (this.myPet3 != null) {
            if (!this.myPet3.isDie) {
                this.myPet3.upHP(this.myPet3.cHPFull);
                this.zoneMap.playerLoadHP(this.myPet3, -1);
            }
        }
//        //tru tn,sm khi o tuong lai
//        if (this.isFuture) {
//            //suc manh
//            if (this.cPower > 1200L) {
//                this.cPower -= 150000L;
//                if (this.cPower < 1200L) {
//                    this.cPower = 1200L;
//                }
//            }
//            //tiem nang
//            if (this.cTiemNang > 1200L) {
//                this.cTiemNang -= 150000L;
//                if (this.cTiemNang < 1200L) {
//                    this.cTiemNang = 1200L;
//                }
//            }
//            if (this.session != null) {
//                this.session.service.meLoadPoint();
//            }
//        }
        this.isCancelNewSkill = true;
        //Mat cau
        this.isThaCau = 0;
        if (this.myChar4 != null) {
            this.myChar4.clearPet4();
        }
        //Tu Chat Khi Chet
        if (this.isHaveChatGameBot(3)) {
            this.addChat(this.nextChatGameBot(3).chat);
        }
        //Xoa nhan ban
        this.clearClone();
        this.lastDie = System.currentTimeMillis();
    }
    
    public void liveFromDead(int type) {
        this.isLockMove = false;
        this.isDie = false;
        this.claerDam();
        this.claerAtt();
        if (type == 1) {
            if (this.cHP < 1) {
                this.cHP = 1;
            }
            if (this.session != null) {
                this.session.service.liveFromDead();
                this.session.service.meLoadInfo();
            }
        }
        if (type == 2) {
            this.cHP = this.cHPFull;
            this.cMP = this.cMPFull;
            if (this.session != null) {
                this.session.service.liveFromDead();
                this.session.service.meLoadInfo();
            }
            if (this.zoneMap != null) {
                this.zoneMap.playerLoadLive(this, cx, cy);
            }
            if (this.zoneMap != null) {
                this.zoneMap.playerLoadAll(this);
            }
        }
        if (type == 3) {
            if (session != null) {
                this.session.service.liveFromDead();
                this.session.service.meLoadInfo();
            }
            if (this.zoneMap != null) {
                this.zoneMap.playerLoadLive(this, cx, cy);
            }
            if (this.zoneMap != null) {
                this.zoneMap.playerLoadAll(this);
            }
        }
        if (this.isSetTypePk) {
            this.tTypePk = this.tSetTypePk;
        }
    }
    
    public int getDamage() {
        return this.cDamFull;
    }
    
    public void upHP(long num) {
        if (num + (long) this.cHP > 2000000000) {
            this.cHP = 2000000000;
        } else {
            this.cHP += num;
        }
        if (this.cHP < 0) {
            this.cHP = 0;
        }
        if (this.cHP > this.cHPFull) {
            this.cHP = this.cHPFull;
        }
    }
    
    public void upMP(int num) {
        if (num + (long) this.cMP > 2000000000) {
            this.cMP = 2000000000;
        } else {
            this.cMP += num;
        }
        if (this.cMP < 0) {
            this.cMP = 0;
        }
        if (this.cMP > this.cMPFull) {
            this.cMP = this.cMPFull;
        }
    }
    
    public void updateEXP(int type, long num) {
        if (num != 0) {
            long power_old = this.cPower;
            if (type == 0) {
                if (this.cPower + num <= getPowerLimit(this.cPowerLimit)) {
                    this.cPower += num;
                } else {
                    num = getPowerLimit(this.cPowerLimit) - this.cPower;
                    this.cPower = getPowerLimit(this.cPowerLimit);
                }
            }
            if (type == 1) {
                this.cTiemNang += num;
            }
            if (type == 2) {
                if (this.cPower + num <= getPowerLimit(this.cPowerLimit)) {
                    this.cTiemNang += num;
                    this.cPower += num;
                } else {
                    num = getPowerLimit(this.cPowerLimit) - this.cPower;
                    this.cPower = getPowerLimit(this.cPowerLimit);
                    if (num > 0) {
                        this.cTiemNang += num;
                        if (this.session != null) {
                            this.session.service.meLoadInfo();
                        }
                        num = 0;
                    }
                }
            }
            if (num != 0) {
                this.applyCharLevelPercent();
                if (this.session != null) {
                    this.session.service.playerUpdateEXP(type, num);
                }
            }
            if (!this.me) {
//                this.myPetz().twrPotential = 30000;
            }
            if (!this.me && this.myPetz().powerSkillPet.length > this.myPetz().skills.size() && this.myPetz().powerSkillPet[this.myPetz().skills.size()] <= this.myPetz().cPower) {
                this.myPetz().nextSkillPet(this.myPetz().skills.size(), 0);
            }
            if (power_old != this.cPower && this.me && !this.isTemplate) {
                Rank.getRank(1).addTop(this.cName, this.head, this.headICON, this.body, this.leg, this.charID, this.cPower, -1);
            }
        }
    }
    
    public boolean isMeCanAttackOtherPlayer(Char att) {
        Char cme = this;
        if (cme.cloneByChar != null && cme.cloneByChar != this) {
            cme = this.cloneByChar;
        }
        if (att.cloneByChar != null && att.cloneByChar != this) {
            att = att.cloneByChar;
        }
        if (this.myChar3 != null && att.charID != this.myChar3.charID) {
            return false;
        }
        if (att.myChar3 != null && this.charID != att.myChar3.charID) {
            return false;
        }
        return (!att.isDie && att.charID != this.charID && !att.isInvisiblez && att.isInMap && att.zoneMap == this.zoneMap && !att.isBaoVe && !att.isSuper && (this.me || (!this.me && this.myCharz().charID != att.charID)) && ((this.cTypePk == 5 || att.cTypePk == 5) || (att.IDFlag != 363 && IDFlag != 363 && (this.IDFlag == 371 || att.IDFlag == 371 || (att.IDFlag != this.IDFlag))) || (cme.isChallenge && cme.challengeCharId == att.charID)));
    }
    
    public boolean isMeCanAttackOtherMob(Mob mob) {
        return !mob.isDie && (!mob.isMobMe || (mob.isMobMe && this.isMeCanAttackOtherPlayer(mob.me)));
    }
    
    public void Attack(Skill skillFight, ArrayList<Mob> mobs, ArrayList<Char> chars, int type) {
        if (skillFight != null && skillFight.template.type != 3 && skillFight.lastTimeUseThisSkill <= System.currentTimeMillis() && this.timeHit <= 0 && this.timeLoadSkill <= 0 && (skillFight.template.id != 9 || (skillFight.template.id == 9 && 100f / (float)this.cHPFull * (float)this.cHP > 10)) && !this.is100Miss) {
            int manaUse = skillFight.manaUse;
            long exps = 0;
            long hoiHPMPChar = 0, hoiHPMPMob = 0;
            long totalDam = 0;
            long totalDamMob = 0;
            long totalDamChar = 0;
            int downDam_percent;
            boolean isChim = false;
            this.isCancelNewSkill = true;
            this.isAttackting = 5000;
            this.isThaCau = 0;
            if (skillFight.template.manaUseType == 1) {
                manaUse = (int)((long)this.cMPFull * (long)manaUse / 100L);
            }
            if (this.cMP >= manaUse) {
                //Bo troi neu danh
                if (this.mobId_holder != -1 || this.charId_holder != -1) {
                    Mob mob34 = this.zoneMap.getMobIdHold(this.charID);
                    if (mob34 != null) {
                        mob34.hold(0, 0, 32, -1);
                    }
                    Char player34 = this.zoneMap.getCharIdHold(this.charID);
                    if (player34 != null) {
                        player34.hold(0, 0, 32, -1, -1);
                    }
                    this.hold(0, 0, 32, -1, -1);
                    this.mobId_holder = -1;
                    this.charId_holder = -1;
                }
                skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + skillFight.coolDown;
                //TRai dat
                if (this.cgender == 0 && this.cspeacialSkill == 3 && skillFight.template.id == 10) {
                    skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + ((long)skillFight.coolDown - (skillFight.coolDown * (long)this.paramSpeacialSkill / 100L));
                    if (this.session != null) {
                        this.session.service.updateCoolDown(this.skills);
                    }
                }
                //Namek
                if (this.cgender == 1 && ((this.cspeacialSkill == 2 && skillFight.template.id == 7) || (this.cspeacialSkill == 3 && skillFight.template.id == 11))) {
                    skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + ((long)skillFight.coolDown - ((long)skillFight.coolDown * (long)this.paramSpeacialSkill / 100L));
                    if (this.session != null) {
                        this.session.service.updateCoolDown(this.skills);
                    }
                }
                if (!this.me/* || this.isTemplate*/) {
                    if (skillFight.isChuong()) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + 1100L;
                    }
                    if (skillFight.isDonDanh()) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + 1000L;
                    }
                }
                if (skillFight.isDonDanh() && this.add1MaxDamage_percent > 0) {
                    this.add1Damage_percent++;
                    if (this.add1Damage_percent > this.add1MaxDamage_percent) {
                        this.add1Damage_percent = this.add1MaxDamage_percent;
                    }
                } else {
                    this.add1Damage_percent = 0;
                }
                this.upMP(-manaUse);
                if (this.cHP <= 1 && this.isNotDieMob) {
                    return;
                }
                if (this.cHP <= 1 && this.isSetOcTieu) {
                    return;
                }
                if (this.protectEff && skillFight.template.id == 23) {
                    this.addInfo1(mResources.NOT_HOLD);
                    return;
                }
                //Time de tu danh co su phu 
                if (this.me) {
                    if( this.myPet != null && this.myPetz().timeDanh != -1) {
                        this.myPetz().timeDanh = Util.gI().nextInt(1000*60*5, 1000*60*10);
                    }
                } else {
                    if (this.timeDanh == -1) {
                        this.timeDanh = Util.gI().nextInt(1000*60*5, 1000*60*10);
                    }
                }
                if (this.isCharge) {
                    this.isCharge = false;
                    this.zoneMap.player_skill_not_focus(3, this.charID, -1, null, null, 0);
                }
                //Total Dam
                //Nem chieu
                if (!chars.isEmpty() && !mobs.isEmpty()) {
                    this.zoneMap.playerAttackNP(this.charID, skillFight.skillId, mobs, chars);
                } else if (mobs.isEmpty()) {
                    this.zoneMap.playerAttackPlayer(this.charID, skillFight.skillId, chars, 0, 0, 0, false, false);
                } else if (chars.isEmpty()) {
                    this.zoneMap.playerAttackNPC(this.charID, skillFight.skillId, mobs);
                }
                
                //Kaioken
                if (skillFight.template.id == 9) {
                    this.haveAttackPLayer(null, 1, ((int)((long)this.cHPFull * 10L / 100L)), false, -1, true);
                }
                //Qua cau khenh khi
                if (skillFight.template.id == 10) {
                }
                //Tri thuong
                if (skillFight.template.id == 7) {
                    chars = this.zoneMap.players;
                }
                //Nhiem vu danh chuong

            	if (skillFight.isChuong() && this.session != null) {
                    this.updateArchivement(4, 1L);
            	}
                if (!mobs.isEmpty()) {
                    for (int i = 0; i < mobs.size(); i++) {
                        Mob mob = mobs.get(i);
                        if (mob != null && this.isMeCanAttackOtherMob(mob)) {
                            int dam;
                            boolean isContinue = false;
                            boolean flag = Util.gI().nextInt(1, 100) <= this.cCriticalFull;
                            if (i == 0) {
                                this.mobFocus = mob;
                                if (mob.pointx >= this.cx) {
                                    this.cdir = 1;
                                } else {
                                    this.cdir = -1;
                                }
                            }
                            if (!flag) {
                                flag = Util.gI().nextInt(1, 100) <= this.intrinsicCrit;
                            }
                            if (mob.time_holder > 0) {
                                flag = true;
                            }
                            //Noi tai
                            if (!flag && (skillFight.isChuong() || skillFight.isDonDanh()) && (((this.cgender == 0 && this.cspeacialSkill == 9) || (this.cgender == 1 && this.cspeacialSkill == 10) || (this.cgender == 2 && this.cspeacialSkill == 9)) && 100f / (float)this.cHPFull * (float)this.cHP < this.paramSpeacialSkill)) {
                                flag = true;
                            }
                            if (!skillFight.isChuong() && !skillFight.isDonDanh()) {
                                flag = false;
                            }
                            this.intrinsicCrit = 0;
                            if (skillFight.template.id == 10 || skillFight.template.id == 11 || (Math.abs(mob.pointx - this.cx) < skillFight.dx + 50 && Math.abs(mob.pointy - this.cy) < skillFight.dy + 30)) {
                                dam = Util.gI().nextInt(((int)((long)this.cDamFull * 9L / 10L)), this.cDamFull);
                                dam = (int) ((long)((long)dam * (long)skillFight.damage) / 100L);
                                if (this.damMob_percent > 0) {
                                    dam = (int) ((long)((long)dam * (long)this.damMob_percent) / 100L);
                                }
                                if (this.addDamMob_percent > 0) {
                                    dam = dam + (int) ((long)((long)dam * (long)this.addDamMob_percent) / 100L);
                                }
                                if (!this.me && this.myCharz().isBuaDeTu) {
                                    dam = dam * 2;
                                }
                                //Qua cau khenh khi
                                if (skillFight.template.id == 10) {
                                    dam = (int) (((float)this.zoneMap.totalHPMob(this.cx, this.cy, skillFight.dx, skillFight.dy) * 0.1F) + ((float)this.zoneMap.totalHpChar(this.cx, this.cy, skillFight.dx, skillFight.dy, this.charID) * 0.1F) + ((float)this.cDamFull * 10L));
                                }
                                //Makankosappo
                                if (skillFight.template.id == 11) {
                                    dam = (int) ((long)this.cMPFull * (long)skillFight.damage / 100L);
                                }
                                //DichChuyen
                                if (skillFight.template.id == 20) {
                                    dam = skillFight.damage;
                                    this.intrinsicCrit = 100;
                                    this.cx = mob.pointx;
                                    this.cy = mob.pointy;
                                    mob.hold(1, 5000, 40, -1);
                                }
                                //Thoi mien
                                if (skillFight.template.id == 22) {
                                    isContinue = true;
                                    mob.hold(1, skillFight.damage * 1000, 41, -1);
                                }
                                //Troi
                                if (skillFight.template.id == 23) {
                                    isContinue = true;
                                    if (mob.isBoss) {
                                        this.addInfo1(mResources.LEVEL_TOO_HIGH);
                                    } else if (mob.time_holder <= 0) {
                                        mob.hold(1, skillFight.damage * 1000, 32, this.charID);
                                        this.mobId_holder = mob.mobId;
                                    }
                                }
                                //Bien socola
                                if (skillFight.template.id == 18) {
                                    isContinue = true;
                                    if (mob.isBoss) {
                                        this.addInfo1(mResources.LEVEL_TOO_HIGH);
                                    } else {
                                        mob.setBody((short)4133, skillFight.damage * 1000);
                                   }
                                }
                                //tru hp va + exp
                                if (!isContinue) {
                                    if (this.add1Damage_percent > 0) {
                                        dam = dam + (int)((long)dam * (long)this.add1Damage_percent / 100L);
                                    }
                                    if (this.damageNext_percent > 0 && (skillFight.isChuong() || skillFight.isDonDanh())) {
                                        dam = dam + (int)((long)dam * (long)this.damageNext_percent / 100L);
                                    }
                                    if (this.damageNext_percent2 > 0 && (skillFight.isChuong() || skillFight.isDonDanh())) {
                                        dam = dam + (int)((long)dam * (long)this.damageNext_percent2 / 100L);
                                    }
                                    //Danh theo hp
                                    if (this.pDamHP > 0) {
                                        dam += (int) ((long)mob.hp * this.pDamHP / 100L);
                                    }
                                    //st quai bay
                                    if (this.mobFlyPercent > 0 && mob.isMobFly()) {
                                        dam = dam + (int)((long)dam * (long)this.mobFlyPercent / 100L);
                                    }
                                    //st quai khi
                                    if (this.mobMonkeyPercent > 0 && mob.isMobMonkey()) {
                                        dam = dam + (int)((long)dam * (long)this.mobMonkeyPercent / 100L);
                                    }
                                    //st quai mat dat
                                    if (this.mobSoilPercent > 0 && mob.isMobSoil()) {
                                        dam = dam + (int)((long)dam * (long)this.mobSoilPercent / 100L);
                                    }
                                    //Noi tai
                                    //Trai dat
                                    if (this.cgender == 0 && ((this.cspeacialSkill == 0 && skillFight.template.id == 0) || (this.cspeacialSkill == 1 && skillFight.template.id == 1))) {
                                        dam = dam + (int)((long)dam * (long)this.paramSpeacialSkill / 100L);
                                    }
                                    //Namek
                                    if (this.cgender == 1 && ((this.cspeacialSkill == 0 && skillFight.template.id == 2) || (this.cspeacialSkill == 1 && skillFight.template.id == 3) || (this.cspeacialSkill == 5 && skillFight.template.id == 17))) {
                                        dam = dam + (int)((long)dam * (long)this.paramSpeacialSkill / 100L);
                                    }
                                    //Xaiyan
                                    if (this.cgender == 2 && ((this.cspeacialSkill == 0 && skillFight.template.id == 4) || (this.cspeacialSkill == 1 && skillFight.template.id == 5) || (this.cspeacialSkill == 2 && this.isMonkey != 0))) {
                                        dam = dam + (int)((long)dam * (long)this.paramSpeacialSkill / 100L);
                                    }
                                    //SET TB
                                    if (skillFight.template.id == 10 && this.isSetKirin) {
                                        dam = dam * 2;
                                    }
                                    if (skillFight.template.id == 1 && this.isSetSongoku) {
                                        dam = dam * 2;
                                    }
                                    if (skillFight.template.id == 11 && this.isSetPicolo) {
                                        dam = dam + (dam / 2);
                                    }
                                    if (skillFight.template.id == 4 && this.isSetKakarot) {
                                        dam = dam * 2;
                                    }
                                    if (skillFight.template.id == 1 && this.addDamgeKamejoko > 0) {
                                        dam = (int) (dam + (dam * this.addDamgeKamejoko / 100L));
                                    }
                                    if (skillFight.template.id == 5 && this.addDamgeAntomic > 0) {
                                        dam = (int) (dam + (dam * this.addDamgeAntomic / 100L));
                                    }
                                    if (skillFight.template.id == 3 && this.addDamgeMasenko > 0) {
                                        dam = (int) (dam + (dam * this.addDamgeMasenko / 100L));
                                    }
                                    if (skillFight.isChuong() && this.xDamAway60s > 0 && this.time_xDamAway60s <= 0) {
                                        dam = dam * this.xDamAway60s;
                                        this.time_xDamAway60s = 60000;
                                    }
                                    if (this.disperse_percent > 0 && this.disperse_percent > Util.gI().nextInt(100)) {
                                        dam = 0;
                                        if (Util.gI().nextInt(100) < 25) {
                                            this.zoneMap.chat(this, mResources.CHAT_XINBATO_1);
                                        } else if (Util.gI().nextInt(100) < 25) {
                                            this.zoneMap.chat(this, mResources.CHAT_XINBATO_2);
                                        } else if (Util.gI().nextInt(100) < 25) {
                                            this.zoneMap.chat(this, mResources.CHAT_XINBATO_3);
                                        } else if (Util.gI().nextInt(100) < 25) {
                                            this.zoneMap.chat(this, mResources.CHAT_XINBATO_4);
                                        } else {
                                            this.zoneMap.chat(this, mResources.CHAT_XINBATO_5);
                                        }
                                    }
                                    if (this.worrPercent > 0 && this.worrPercent > Util.gI().nextInt(100)) {
                                        dam = 0;
                                        if (Util.gI().nextInt(100) < 25) {
                                            this.zoneMap.chat(this, mResources.CHAT_WORR_1);
                                        } else {
                                            this.zoneMap.chat(this, mResources.CHAT_WORR_2);
                                        }
                                    }
                                    if (dam <= 0) {
                                        flag = false;
                                    }
                                    dam = mob.AttackMob(this, dam, flag, type, this.bienHp_percent > 0 || this.bienMp_percent > 0 ? 37 : -1);
    //                                if (this.me && dam > 50000000) {
    //                                    Server.chatVip(String.format(mResources.PLAYER_DAMTO, this.cName, skillFight.template.name, util.gI().getFormatNumber(dam)));
    //                                }
                                    totalDam += dam;
                                    totalDamMob += dam;
                                    if (mob.isSuckHP()) {
                                        hoiHPMPMob += dam;
                                    }
                                    if (dam > 0) {
                                        long exp =(long) (1F+ ((float)(mob.damExp() * 4F) / (float)mob.maxHp * (float)dam));
                                        //Exp ban do kho bau
                                        if (this.zoneMap.map.isMapKhoBau()) {
                                            int level = this.zoneMap.map.khobau.level;
                                            int levelC = (level / 10) + 1;
                                            exp =(long) (1F+ ((float)(mob.damExp() * (long)levelC) / (float)mob.maxHp * (float)dam));
                                            exp += (level * 1000);
                                        }
                                        //Con duong ran doc
                                        if (this.zoneMap.map.isMapRoadSnake()) {
                                            int level = this.zoneMap.map.phoban.level;
                                            int levelC = (level / 10) + 1;
                                            exp =(long) (1F+ ((float)(mob.damExp() * (long)levelC) / (float)mob.maxHp * (float)dam));
                                            exp += (level * 1000);
                                        }
                                        if (this.expMob_percent > 0) {
                                            exp = exp + (exp * (long)this.expMob_percent / 100L);
                                        }
                                        if (exp < 0) {
                                            mLog.log("am exp o expMob_percent");
                                        }
                                        if (this.down50_percent > 0) {
                                            exp = exp + (exp * this.down50_percent / 100L);
                                        }
                                        if (exp < 0) {
                                            mLog.log("am exp o down50_percent");
                                        }
                                        if (this.isMobExp20) {
                                            exp = exp + (exp * 20L / 100L);
                                        }
                                        if (exp < 0) {
                                            mLog.log("am exp o isMobExp20");
                                        }
                                        //Doanh trai
                                        if (this.zoneMap.map.isMapDoanhTrai()) {
                                            exp = exp * 2L;
                                        }
                                        //Map clan
                                        if (this.zoneMap.map.isMapManor()) {
                                            //exp = 0;
                                        }
                                        if (exp < 0) {
                                            mLog.log("am exp o doanh trai");
                                        }
                                        if (this.zoneMap.map.isMapNguHanhSon()) {
                                            if (!this.me) {
                                                exp = exp * 5L;
                                            }
                                        }
                                        if (exp < 0) {
                                            mLog.log("am exp o ngu hanh son");
                                        }
                                        //Noi tai
                                        if (this.cgender == 0 && this.cspeacialSkill == 8) {
                                            exp = exp + (exp * (long)this.paramSpeacialSkill / 100L);
                                        }
                                        if (this.cgender == 1 && this.cspeacialSkill == 9) {
                                            exp = exp + (exp * (long)this.paramSpeacialSkill / 100L);
                                        }
                                        if (this.cgender == 2 && this.cspeacialSkill == 8) {
                                            exp = exp + (exp * (long)this.paramSpeacialSkill / 100L);
                                        }
                                        if (exp < 0) {
                                            mLog.log("am exp o noi tai");
                                        }

                                        //De trung
                                        if (this.mobMe != null && !mob.isDie && !isChim) {
                                            isChim = true;
                                            this.zoneMap.mobMeAttackMob(this.mobMe.mobId, mob.mobId);
                                            dam = Util.gI().nextInt(this.cDamFull, ((int)((long)this.cDamFull * 9L / 10L)));
                                            dam = (int) ((long)((long)dam * (long)this.mobMe.damage) / 100L);
                                            if (this.isSetPikkoroDaimao) {
                                                dam = dam * 2;
                                            }
                                            if (this.damMob > 0) {
                                                dam = (int) (dam + ((float)dam / 100F * (float)this.damMob));
                                            }
                                            dam = mob.AttackMob(this, dam, false, type, this.bienHp_percent > 0 || this.bienMp_percent > 0 ? 37 : -1);
                                            totalDam += dam;
                                            totalDamMob += dam;
                                            if (mob.isSuckHP()) {
                                                hoiHPMPMob += dam;
                                            }
                                            exp = (long) (exp + (1F+ ((float)(mob.damExp() * 10L) / (float)mob.maxHp * (float)dam)));
                                            if (exp < 0) {
                                                mLog.log("Am exp o chim");
                                            }
                                        }
                                        if (exp > 0) {
                                            if (this.myCharz().isX2Text) {
                                                exp = exp * 2L;
                                            }
                                            if (this.myCharz().isX2EventText) {
                                                exp = exp * 2L;
                                            }
                                            if (this.myCharz().isX2RVC) {
                                                exp = exp * 2L;
                                            }
                                            if (this.myCharz().isX2RNM) {
                                                exp = exp * 2L;
                                            }
                                            if (Server.gI().isTangGift1()) {
                                                exp = exp * 2L;
                                            }
                                        }
                                        exps = exps + exp;
                                    }
                                }
                            }
                        }
                    }
                }
                if (!chars.isEmpty()) {
                    for (int i = 0; i < chars.size(); i++) {
                        Char player = chars.get(i);
                        if (player != null && player.zoneMap != null && ((skillFight.template.id == 7 && !player.isTemplate) || (skillFight.template.id != 7 && this.isMeCanAttackOtherPlayer(player)))) {
                            if (((player.cTemplateType == 23 || player.cTemplateType == 26 || player.cTemplateType == 27 || player.cTemplateType == 28) && skillFight.isChuong())) {
                                continue;
                            }
                            int dam;
                            boolean isContinue2 = false;
                            if (i == 0) {
                                this.charFocus = player;
                                if (player.cx >= this.cx) {
                                    this.cdir = 1;
                                } else {
                                    this.cdir = -1;
                                }
                            }
                            boolean flag = Util.gI().nextInt(1, 100) <= this.cCriticalFull;
                            if (!flag && (skillFight.isChuong() || skillFight.isDonDanh())) {
                                flag = Util.gI().nextInt(1, 100) <= this.intrinsicCrit;
                            }
                            if (player.time_holder > 0) {
                                flag = true;
                            }
                            if (player.cTemplateId == 96 && !this.isCarrot) {
                                this.setItem(4082, 300, 0, 0);
                            }
                            //Noi tai
                            if (!flag && (skillFight.isChuong() || skillFight.isDonDanh()) && (((this.cgender == 0 && this.cspeacialSkill == 9) || (this.cgender == 1 && this.cspeacialSkill == 10) || (this.cgender == 2 && this.cspeacialSkill == 9)) && 100f / (float)this.cHPFull * (float)this.cHP < this.paramSpeacialSkill)) {
                                flag = true;
                            }
                            if (!skillFight.isChuong() && !skillFight.isDonDanh()) {
                                flag = false;
                            }
                            this.intrinsicCrit = 0;
                            if (skillFight.template.id == 10 || skillFight.template.id == 11 || (Math.abs(player.cx - this.cx) < skillFight.dx + 50 && Math.abs(player.cy - this.cy) < skillFight.dy + 30)) {
                                dam = Util.gI().nextInt( ((int)((long)this.cDamFull * 9L / 10L)), this.cDamFull);
                                dam = (int) (((long)dam * (long)skillFight.damage) / 100L);
                                //Qua cau khenh khi
                                if (skillFight.template.id == 10) {
                                    dam = (int) (((long)this.zoneMap.totalHPMob(this.cx, this.cy, skillFight.dx, skillFight.dy) / 10L) + ((long)this.zoneMap.totalHpChar(this.cx, this.cy, skillFight.dx, skillFight.dy, this.charID) / 10L) + ((long)this.cDamFull * 10L));
                                    if (player.isTemplate) {
                                        dam = dam / 2;
                                    }
                                }
                                //Makankosappo
                                if (skillFight.template.id == 11) {
                                    dam = (int) ((long)this.cMPFull * (long)skillFight.damage / 100L);
                                }
                                //DichChuyen
                                if (skillFight.template.id == 20) {
                                    this.intrinsicCrit = 100;
                                    dam = skillFight.damage;
                                    this.cx = player.cx;
                                    this.cy = player.cy;
                                    player.hold(1, 5000, 40, -1, -1);
                                }
                                //Thoi mien
                                if (skillFight.template.id == 22) {
                                    isContinue2 = true;
                                    player.hold(1, skillFight.damage * 1000, 41, -1, -1);
                                }
                                //Troi
                                if (skillFight.template.id == 23) {
                                    isContinue2 = true;
                                    if (player.time_holder <= 0) {
                                        player.hold(1, skillFight.damage * 1000, 32, -1, this.charID);
                                        this.charId_holder = this.charID;
                                    }
                                }
                                //Tri thuong
                                if (skillFight.template.id == 7) {
                                    isContinue2 = true;
                                    player.upHP((int)((long)player.cHPFull * (long)skillFight.damage / 100));
                                    player.upMP((int)((long)player.cMPFull * (long)skillFight.damage / 100));
                                    if (!player.isDie) {
                                        if (player.session != null) {
                                            player.session.service.meLoadHP(player.cHP);
                                            player.session.service.meLoadMP(player.cMP);
                                        }
                                        player.zoneMap.playerLoadHP(player, -1);
                                    } else {
                                        player.liveFromDead(3);
                                    }
                                    player.zoneMap.chat(player, String.format(mResources.OK_TRITHUONG, this.cName));

                                    //Nhiem vu thanh tich duoc namek tri thuong
                                    if (player.session != null) {
                                    	player.updateArchivement(18, 1L);
                                    }
                                }
                                //Bien socola
                                if (skillFight.template.id == 18) {
                                    isContinue2 = true;
                                    player.setItem(4133, skillFight.damage, 0, ((skillFight.point - 1) * 2) + 50);
                                }
                                //Giai ken
                                if (player.isMabuHold) {
                                    player.nMabuHold--;
                                    isContinue2 = true;
                                }
                                //tru hp
                                if (!isContinue2) {
                                    //Giap aand Xuyen Giap
                                    //Xuyen giap can chien
                                    boolean flag2 = Math.abs(this.cx - player.cx) < 30 && Math.abs(this.cy - player.cy) < 30 && this.nearCombatPercent > 0 && Util.gI().nextInt(100) < this.nearCombatPercent;
                                    if (!flag2) {
                                        dam -= player.cDefull;
                                    }
                                    if (this.cTemplateType == 10 || this.cTemplateType == 11 || this.cTemplateType == 12 || this.cTemplateType == 13 || this.cTemplateType == 14) {
                                        dam = (int) ((long)player.cHPFull * this.cDamGoc / 100L);
                                    }
                                    if (this.pDamHP > 0) {
                                        dam += (int) ((long)player.cHPFull * this.pDamHP / 100L);
                                    }
                                    if (this.cTemplateId == 42) {
                                        if (this.isBossMain) {
                                            dam = (int) ((long)player.cHPFull * 10L / 100L);
                                        } else {
                                            dam = (int) ((long)player.cHPFull * 1L / 100L);
                                        }
                                    }
                                    if (player.downDamage_percent > 0) {
                                        downDam_percent = player.downDamage_percent;
                                        if (downDam_percent > 85) {
                                            downDam_percent = 85;
                                        }
                                        dam = (int) (dam - ((long)dam * (long)downDam_percent / 100L));
                                    }
                                    //GIam % moi sat thuong khi KI duoi 20%
                                    if (player.downDamKI20_percent > 0 && (100F / (float)player.cMPFull * (float)player.cMP) < 20) {
                                        dam -= (int)((long)dam * (long)player.downDamKI20_percent / 100L);
                                    }
                                    if (player.isXenBoHung) {
                                        dam = (int) ((long)dam / 2L);
                                    }
                                    if (player.isXenBoHung2) {
                                        dam = (int) ((float)dam * 0.4F);
                                    }
                                    if (dam < 0) {
                                        dam = 1;
                                    }
                                    //Ne don
                                    if (player.cMissPercent > 0) {
                                        int neDon = player.cMissPercent > 80 ? 80 : player.cMissPercent;
                                        if (Util.gI().nextInt(1, 100) <= neDon) {
                                            dam = 0;
                                        }
                                    }
                                    if (!flag2 && dam > 1 && player.protectEff) {
                                        if (dam >= player.cHP) {
                                            player.setItem(3784, 0, 0, 0);
                                        }
                                        dam = player.haveAttackPLayer(this, 1, 1, false, -1, true);
                                        totalDam += dam;
                                        totalDamChar += dam;
                                        if (player.myPet != null && player.myPetz().charFocus == null) {
                                            player.myPetz().charFocus = this;
                                        }
                                    } else {
                                        if (this.add1Damage_percent > 0) {
                                            dam = dam + (int)((long)dam * (long)this.add1Damage_percent / 100L);
                                        }
                                        if (this.damageNext_percent > 0 && (skillFight.isChuong() || skillFight.isDonDanh())) {
                                            dam = dam + (int)((long)dam * (long)this.damageNext_percent / 100L);
                                        }
                                        if (this.damageNext_percent2 > 0 && (skillFight.isChuong() || skillFight.isDonDanh())) {
                                            dam = dam + (int)((long)dam * (long)this.damageNext_percent2 / 100L);
                                        }
                                        //st toc Trai Dat
                                        if (this.toEarthPercent > 0 && player.cgender == 0) {
                                            dam = dam + (int)((long)dam * (long)this.toEarthPercent / 100L);
                                        }
                                        //st toc Namek
                                        if (this.toNamekPercent > 0 && player.cgender == 1) {
                                            dam = dam + (int)((long)dam * (long)this.toNamekPercent / 100L);
                                        }
                                        //st toc Xayda
                                        if (this.toXaydaPercent > 0 && player.cgender == 2) {
                                            dam = dam + (int)((long)dam * (long)this.toXaydaPercent / 100L);
                                        }
                                        //giam st toc Trai Dat
                                        if (player.downEarthPercent > 0 && this.cgender == 0) {
                                            dam = dam - (int)((long)dam * (long)player.downEarthPercent / 100L);
                                        }
                                        //giam st toc Namek
                                        if (player.downNamekPercent > 0 && this.cgender == 1) {
                                            dam = dam - (int)((long)dam * (long)player.downNamekPercent / 100L);
                                        }
                                        //giam st toc Xayda
                                        if (player.downXaydaPercent > 0 && this.cgender == 2) {
                                            dam = dam - (int)((long)dam * (long)player.downXaydaPercent / 100L);
                                        }
                                        //st len boss
                                        if (this.damBossPercent > 0 && player.isTemplate) {
                                            dam = dam + (int)((long)dam * (long)this.damBossPercent / 100L);
                                        }
                                        //Noi tai
                                        //Trai dat
                                        if (this.cgender == 0 && ((this.cspeacialSkill == 0 && skillFight.template.id == 0) || (this.cspeacialSkill == 1 && skillFight.template.id == 1))) {
                                            dam = dam + (int)((long)dam * (long)this.paramSpeacialSkill / 100L);
                                        }
                                        //Namek
                                        if (this.cgender == 1 && ((this.cspeacialSkill == 0 && skillFight.template.id == 2) || (this.cspeacialSkill == 1 && skillFight.template.id == 3) || (this.cspeacialSkill == 5 && skillFight.template.id == 17))) {
                                            dam = dam + (int)((long)dam * (long)this.paramSpeacialSkill / 100L);
                                        }
                                        //Xaiyan
                                        if (this.cgender == 2 && ((this.cspeacialSkill == 0 && skillFight.template.id == 4) || (this.cspeacialSkill == 1 && skillFight.template.id == 5) || (this.cspeacialSkill == 2 && skillFight.template.id == 13))) {
                                            dam = dam + (int)((long)dam * (long)this.paramSpeacialSkill / 100L);
                                        }
                                        //SET TB
                                        if (skillFight.template.id == 10 && this.isSetKirin) {
                                            dam = (int) ((long)dam * 2L);
                                        }
                                        if (skillFight.template.id == 1 && this.isSetSongoku) {
                                            dam = (int) ((long)dam * 2L);
                                        }
                                        if (skillFight.template.id == 11 && this.isSetPicolo) {
                                            dam = (int) (dam + ((long)dam / 2L));
                                        }
                                        if (skillFight.template.id == 4 && this.isSetKakarot) {
                                            dam = (int) ((long)dam * 2L);
                                        }
                                        if (skillFight.template.id == 1 && this.addDamgeKamejoko > 0) {
                                            dam = (int) (dam + (dam * this.addDamgeKamejoko / 100L));
                                        }
                                        if (skillFight.template.id == 5 && this.addDamgeAntomic > 0) {
                                            dam = (int) (dam + (dam * this.addDamgeAntomic / 100L));
                                        }
                                        if (skillFight.template.id == 3 && this.addDamgeMasenko > 0) {
                                            dam = (int) (dam + (dam * this.addDamgeMasenko / 100L));
                                        }
                                        if (skillFight.isChuong() && this.xDamAway60s > 0 && this.time_xDamAway60s <= 0 && !player.isTemplate) {
                                            dam = dam * this.xDamAway60s;
                                            this.time_xDamAway60s = 60000;
                                        }
                                        int downAndKi = 0;
                                        if (player.damChuongToKi_percent > 0 && skillFight.isChuong()) {
                                            downAndKi = (int) ((long)dam * (long)player.damChuongToKi_percent / 100L);
                                            dam = dam - downAndKi;
                                        }
                                        if (dam > 1 && player.isTemplate && (player.cTemplateId == 13 || player.cTemplateId == 14)) {
                                            if (skillFight.template.id != 11) {
                                                dam = (int) ((long)player.cHPFull / 100L);
                                            }
                                            if (skillFight.template.id == 10) {
                                                dam = (int)(this.cDamFull + ((long)this.cDamFull * 30L / 100L));
                                            }
                                        }
                                        if (player.isTemplate && (player.cTemplateId == 78 || player.cTemplateId == 83) && skillFight.template.id != 0 && skillFight.template.id != 2 && skillFight.template.id != 4) {
                                            dam = (int) ((long)player.cHPFull / 600L);
                                        }
                                        if (this.disperse_percent > 0 && this.disperse_percent > Util.gI().nextInt(100)) {
                                            dam = 0;
                                            if (Util.gI().nextInt(100) < 25) {
                                                this.zoneMap.chat(this, mResources.CHAT_XINBATO_1);
                                            } else if (Util.gI().nextInt(100) < 25) {
                                                this.zoneMap.chat(this, mResources.CHAT_XINBATO_2);
                                            } else if (Util.gI().nextInt(100) < 25) {
                                                this.zoneMap.chat(this, mResources.CHAT_XINBATO_3);
                                            } else if (Util.gI().nextInt(100) < 25) {
                                                this.zoneMap.chat(this, mResources.CHAT_XINBATO_4);
                                            } else {
                                                this.zoneMap.chat(this, mResources.CHAT_XINBATO_5);
                                            }
                                        }
                                        if (dam <= 0) {
                                            flag = false;
                                        }
                                        dam = player.haveAttackPLayer(this, 1, dam, flag, -1, true);
                                        if (dam > 0) {
                                            if (downAndKi > 0 && skillFight.isChuong() && !player.isDie) {
                                                player.upMP(downAndKi);
                                                if (player.session != null) {
                                                    player.session.service.meLoadMP(player.cMP);
                                                }
                                            }
                                            totalDam += dam;
                                            totalDamChar += dam;
                                            hoiHPMPChar += dam;
                                            //phan sat thuong
                                            if (!this.isDie && player.damReturn_percent > 0 && this.isRecDam) {
                                                int recDam = (int) ((long)dam * (long)player.damReturn_percent / 100L);
                                                if (recDam > 0 && this.cHP > 1) {
                                                    this.haveAttackPLayer(player, 5, recDam, false, 36, true);
                                                }
                                            }
                                            if (player.myPet != null && player.myPetz().charFocus == null) {
                                                player.myPetz().charFocus = this;
                                            }
                                        }
                                    }
                                    //De trung
                                    if (this.mobMe != null && dam > 0 && !player.isDie && !isChim) {
                                        isChim = true;
                                        dam = Util.gI().nextInt(this.cDamFull, ((int)((long)this.cDamFull * 9L / 10L)));
                                        dam = (int) ((long)((long)dam * (long)this.mobMe.damage) / 100L);
                                        if (this.isSetPikkoroDaimao) {
                                            dam = dam * 2;
                                        }
                                        if (this.damMob > 0) {
                                            dam = (int) (dam + ((float)dam / 100F * (float)this.damMob));
                                        }
                                        if (dam > 1 && player.isTemplate && (cTemplateId == 13 || cTemplateId == 14)) {
                                            if (skillFight.template.id != 11) {
                                                dam = player.cHPFull / 100;
                                            }
                                            if (skillFight.template.id == 10) {
                                                dam = (int)(this.cDamFull + ((long)this.cDamFull * 30L / 100L));
                                            }
                                        }
                                        if ((float)player.cHP / (float)player.cHPFull < 0.1) {
                                            dam = 1;
                                        } else {
                                            
                                        }
                                        dam = player.haveAttackPLayer(this, 1, dam, false, this.bienHp_percent > 0 || this.bienMp_percent > 0 ? 37 : -1, false);
                                        totalDam += dam;
                                        totalDamChar += dam;
                                        hoiHPMPChar += dam;
                                        this.zoneMap.mobMeAttackPlayer(this.mobMe.mobId, player.charID, dam, 0);
                                        //phan sat thuong
                                        if (!this.isDie && player.damReturn_percent > 0 && this.isRecDam) {
                                            int recDam = (int) ((long)dam * (long)player.damReturn_percent / 100L);
                                            if (recDam > 0 && this.cHP > 1) {
                                                this.haveAttackPLayer(player, 5, recDam, false, 36, true);
                                            }
                                        }
                                    }
                                    if (player.attToKI > 0 && !player.isDie && player.cMP < player.cMPFull) {
                                        int num = (int) ((long)player.cMPFull * (long) player.attToKI / 100L);
                                        player.upMP(num);
                                        if (player.session != null) {
                                            player.session.service.meLoadMP(player.cMP);
                                        }
                                    }
                                    //Bien carrot
                                    if (this.isSendCarrot && !player.isSendCarrot && !player.isCarrot) {
                                        player.setItem(4082, 300, 0, 0);
                                    }
                                }
                            }
                        }
                    }
                }
                //SET EXP
                if (this.tnsm_percent > 0) {
                    exps += (exps * this.tnsm_percent / 100);
                }
                if (!this.me && this.myCharz().tnsm_percent_petz > 0) {
                    exps += (exps * this.myCharz().tnsm_percent_petz / 100);
                }
                if (this.isHaveItems(375)) {
                    exps = exps + (exps * 20L / 100L);
                }
                if (this.xExp > 0) {
                    exps = exps * this.xExp;
                }
                if (this.myCharz().petFollow != null && this.myCharz().petFollow.smallID == 7094) {
                    exps = exps * 2L;
                }
                if (this.cPower < 1500000000L) {
                    exps = exps * 5L;
                } else if (this.cPower < 1900000000L) {
                    exps = exps * 2L;
                } else if (this.cPower >= 100000000000L) {
                    exps = (long) (exps * 0.01);
                } else if (this.cPower >= 40000000000L) {
                    exps = (long) (exps * 0.1);
                }
                exps = exps * Server.gI().xTNSM;
                if (exps < 0) {
                    mLog.log("Am tong exp="+exps);
                }
                if (exps > 0) {
                    long sm_old = this.cPower;
                    this.updateEXP(2, exps);
                    if (sm_old != this.cPower && this.me && this.clan != null) {
                        this.zoneMap.updateTiemNangClan(this, exps);
                    }
                }
                if (this.zoneMap != null && this.zoneMap.map.isMapBlackBall()) {
                	exps = 0;
                }
                exps = exps / 2L;
                if (!this.me && exps > 0) {
                    if (this.myCharz().cPower >= 40000000000L) {
                        exps = (long) (exps * 0.1);
                    }
                    this.myCharz().updateEXP(2, exps);
                }
                int hpHoi = 0;
                int mpHoi = 0;
                this.totalDamage = totalDam;
                if (hoiHPMPMob + hoiHPMPChar > 0 && !this.isDie) {
                    if (this.cHP < this.cHPFull) {
                        if (this.bienHp_percent > 0) {
                            hpHoi += ((hoiHPMPMob + hoiHPMPChar) * (long)this.bienHp_percent / 100L);
                        }
                        if (this.bienMobHp_percent > 0 && hoiHPMPMob > 0) {
                            hpHoi += ((long)hoiHPMPMob * (long)this.bienMobHp_percent / 100L);
                        }
                    }
                    if (this.cMP < this.cMPFull) {
                        if (this.bienMp_percent > 0) {
                            mpHoi += ((hoiHPMPMob + hoiHPMPChar) * (long)this.bienMp_percent / 100L);
                        }
                    }
                }
                if (hpHoi > 0 && !this.isDie) {
                    this.upHP(hpHoi);
                    if (this.session != null) {
                        this.session.service.meLoadHP(this.cHP);
                    }
                    this.zoneMap.playerLoadHP(this, -1);
                }
                if (mpHoi > 0 && !this.isDie) {
                    this.upMP(mpHoi);
                    if (this.session != null) {
                        this.session.service.meLoadMP(this.cMP);
                    }
                }
                this.damageNext_percent = 0;
                this.damageNext_percent2 = 0;
                //Noi tai dich chuyen tuc thoi or Thoi mien
                if (this.cgender == 0 && ((this.cspeacialSkill == 5 && skillFight.template.id == 20) || (this.cspeacialSkill == 6 && skillFight.template.id == 22))) {
                    this.damageNext_percent = this.paramSpeacialSkill;
                }
                //Namek Bien socola
                if (this.cgender == 1 && ((this.cspeacialSkill == 6 && skillFight.template.id == 18))) {
                    this.damageNext_percent = this.paramSpeacialSkill;
                }
                //Trai xaiyan
                if (this.cgender == 2 && ((this.cspeacialSkill == 6 && skillFight.template.id == 23))) {
                    this.damageNext_percent = this.paramSpeacialSkill;
                }
                //Trang bi
                if (skillFight.template.id == 20 && this.damMove > 0) {
                    this.damageNext_percent2 = this.damMove;
                }
            }
        } else if (this.cTemplateType == 43) {
            if (skillFight != null) {
                System.out.println(this.cName+" skill="+skillFight.template.name+" timeLoad="+this.timeLoadSkill+" 100Miss="+this.is100Miss+" timeHit="+this.timeHit);
            }
        } else {
            if (skillFight != null) {
//                System.out.println(this.cName+" skill="+skillFight.template.name+" timeLoad="+this.timeLoadSkill+" 100Miss="+this.is100Miss+" timeHit="+this.timeHit);
            }
        }
    }
    
    public void skill_not_focus(byte status, Skill skillFight) {
        if (skillFight != null && skillFight.lastTimeUseThisSkill <= System.currentTimeMillis()) {
            int manaUse = 0;
            this.isThaCau = 0;
            if (status == 0 || status == 1 || status == 6 || status == 7 || status == 8 || status == 9 || status == 10 || status == 20) {
                manaUse = skillFight.manaUse;
                if (skillFight.template.manaUseType == 1) {
                    manaUse = (int)((long)this.cMPFull * (long)manaUse / 100);
                }
            }
            if (this.cMP >= manaUse) {
                if (status == 0 || status == 1 || status == 6 || status == 7 || status == 8 || status == 9 || status == 10 || status == 20) {
                    skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + skillFight.coolDown;
                    //Noi tai
                    //Trai dat
                    if (this.cgender == 0 && ((this.cspeacialSkill == 2 && skillFight.template.id == 6))) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.paramSpeacialSkill / 100));
                        manaUse =(int)(manaUse - ((long)manaUse * (long)this.paramSpeacialSkill / 100L));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                            this.session.service.meLoadMP(this.cMP - manaUse);
                        }
                    }
                    //De trung
                    if (this.cgender == 1 && ((this.cspeacialSkill == 4 && skillFight.template.id == 12))) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.paramSpeacialSkill / 100));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                        }
                    }
                    //Noi tai khien nang luong
                    if (this.cgender == 0 && ((this.cspeacialSkill == 4 && skillFight.template.id == 19))) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.paramSpeacialSkill / 100));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                        }
                    }
                    //Noi tai khien nang luong Namek
                    if (this.cgender == 1 && ((this.cspeacialSkill == 7 && skillFight.template.id == 19))) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.paramSpeacialSkill / 100));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                        }
                    }
                    //Noi tai phat no
                    if (this.cgender == 2 && ((this.cspeacialSkill == 3 && skillFight.template.id == 14))) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.paramSpeacialSkill / 100));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                        }
                    }
                    //Khien nang luong
                    if (this.cgender == 2 && ((this.cspeacialSkill == 4 && skillFight.template.id == 19))) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.paramSpeacialSkill / 100));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                        }
                    }
                    //Huyt sao
                    if (this.cgender == 2 && ((this.cspeacialSkill == 5 && skillFight.template.id == 21))) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.paramSpeacialSkill / 100));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                        }
                    }
                    //Trang bi
                    //Giam time khien nang luong
                    if (skillFight.template.id == 19 && this.downProtected > 0) {
                        skillFight.lastTimeUseThisSkill = System.currentTimeMillis() + (skillFight.coolDown - (skillFight.coolDown * this.downProtected / 100));
                        if (this.session != null) {
                            this.session.service.updateCoolDown(this.skills);
                        }
                    }
                    this.upMP(-manaUse);
                }
                
                if (this.cHP <= 1 && this.isNotDieMob) {
                    return;
                }
                if (this.cHP <= 1 && this.isSetOcTieu) {
                    return;
                }
                //Thai duong ha san
                if (status == -1 || (status == 0 && skillFight.template.id == 6)) {
                    
                    this.aMobFocus.clear();
                    this.aCharFocus.clear();
                    if (!this.isTemplate) {
                        synchronized (this.zoneMap.mobs) {
                            for (int i = 0; i < this.zoneMap.mobs.size(); i++) {
                                if (!this.zoneMap.mobs.get(i).isDie && !this.zoneMap.mobs.get(i).isMobMe && Math.abs(this.cx - this.zoneMap.mobs.get(i).pointx) <= skillFight.dx && Math.abs(this.cy - this.zoneMap.mobs.get(i).pointy) <= skillFight.dy) {
                                    this.zoneMap.mobs.get(i).updateFreez(true, (this.isSetXiHang ? skillFight.damage * 2: skillFight.damage));
                                    this.aMobFocus.add(this.zoneMap.mobs.get(i));
                                }
                            }
                        }
                    }
                    synchronized (this.zoneMap.players) {
                        for (int i = 0; i < this.zoneMap.players.size(); i++) {
                            if (!this.zoneMap.players.get(i).isDie && this.zoneMap.players.get(i).charID != this.charID && Math.abs(this.cx - this.zoneMap.players.get(i).cx) <= skillFight.dx && Math.abs(this.cy - this.zoneMap.players.get(i).cy) <= skillFight.dy && (this.isMeCanAttackOtherPlayer(this.zoneMap.players.get(i)))) {
                                if (this.zoneMap.players.get(i).isAgainst20Sun && Util.gI().nextInt(100) < 20) {
                                    this.zoneMap.players.get(i).addChat(1000, mResources.XI_HUT);
                                    continue;
                                }
                                this.aCharFocus.add(this.zoneMap.players.get(i));
                            }
                        }
                    }
                    for (int i = 0; i < this.aCharFocus.size(); i++) {
                        int timeEff = this.isSetXiHang ? skillFight.damage * 2: skillFight.damage;
                        if (this.aCharFocus.get(i).downEffblindPercent > 0) {
                            timeEff = (int) (timeEff - ((long)timeEff * (long)this.aCharFocus.get(i).downEffblindPercent / 100L));
                        }
                        if (this.aCharFocus.get(i).downEffblindSc > 0) {
                            timeEff = timeEff - (this.aCharFocus.get(i).downEffblindSc * 1000);
                        }
                        if (timeEff > 0) {
                            this.aCharFocus.get(i).updateFreez(timeEff, true);
                        }
                    }
                    //Bo troi neu bi choang
                    for (int i = 0; i < this.aCharFocus.size(); i++) {
                        if (this.aCharFocus.get(i).mobId_holder != -1 || this.aCharFocus.get(i).charId_holder != -1) {
                            Mob mob34 = this.zoneMap.getMobIdHold(this.aCharFocus.get(i).charID);
                            if (mob34 != null) {
                                mob34.hold(0, 0, 32, -1);
                            }
                            Char player34 = zoneMap.getCharIdHold(this.aCharFocus.get(i).charID);
                            if (player34 != null) {
                                player34.hold(0, 0, 32, -1, -1);
                            }
                            this.aCharFocus.get(i).hold(0, 0, 32, -1, -1);
                            this.aCharFocus.get(i).mobId_holder = -1;
                            this.aCharFocus.get(i).charId_holder = -1;
                        }
                    }
                    this.zoneMap.player_skill_not_focus(status, this.charID, skillFight.skillId, this.aMobFocus, this.aCharFocus, 3000);
                    if (this.session != null) {
                        this.session.service.skill_not_focus(status, this.charID, skillFight.skillId, this.aMobFocus, this.aCharFocus, 0);
                    }
                }
                //Qua cau khenh khi
                if (status == -1 || (status == 4 && skillFight.template.id == 10)) {
                    this.timeLoadSkill = 3000;
                    this.addSkillNotFocus(status, 5000, skillFight.skillId, skillFight.damage, skillFight.dx, skillFight.dy, skillFight.point);
                }
                //Khien nang luong
                if (status == -1 || (status == 9 && skillFight.template.id == 19)) {
                    //Bo troi neu bat khien nang luong
                    if (this.mobId_holder != -1 || this.charId_holder != -1) {
                        Mob mob34 = this.zoneMap.getMobIdHold(this.charID);
                        if (mob34 != null) {
                            mob34.hold(0, 0, 32, -1);
                        }
                        Char player34 = this.zoneMap.getCharIdHold(this.charID);
                        if (player34 != null) {
                            player34.hold(0, 0, 32, -1, -1);
                        }
                        this.hold(0, 0, 32, -1, -1);
                        this.mobId_holder = -1;
                        this.charId_holder = -1;
                    }
                    this.setItem(skillFight.template.iconId, skillFight.damage, 0, 0);
                }
                //Tai tao nang luong
                if (status == -1 || (status == 1 && skillFight.template.id == 8)) {
                    this.isCharge = true;
                    this.chargeDamage = skillFight.damage;
                    this.zoneMap.player_skill_not_focus(status, this.charID, -1, null, null, -1);
                }
                //Tai tao nang luong
                if (status == -1 || (status == 2 && skillFight.template.id == 8)) {
                    if (!this.isCharge) {
                        this.session.service.skill_not_focus(3, this.charID, -1, null, null, 0);
                    }
                    if (this.session != null) {
                        this.session.service.meLoadInfo();
                    }
                }
                //Hoa khi khong lo
                if (status == -1 || (status == 6 && skillFight.template.id == 13)) {
                    this.timeLoadSkill = 2000;
                    this.gong = true;
                    this.addSkillNotFocus(status, 2000, skillFight.skillId, skillFight.damage, skillFight.dx, skillFight.dy, skillFight.point);
                }
                //Tu phat no
                if (status == -1 || (status == 7 && skillFight.template.id == 14)) {
                    this.timeLoadSkill = 2000;
                    this.gong = true;
                    this.addSkillNotFocus(status, 3000, skillFight.skillId, skillFight.damage, skillFight.dx, skillFight.dy, skillFight.point);
                }
                //Huyt sao
                if (status == -1 || (status == 10 && skillFight.template.id == 21)) {
                    //Bo troi neu bat huyt sao
                    if (this.mobId_holder != -1 || this.charId_holder != -1) {
                        Mob mob34 = this.zoneMap.getMobIdHold(this.charID);
                        if (mob34 != null) {
                            mob34.hold(0, 0, 32, -1);
                        }
                        Char player34 = this.zoneMap.getCharIdHold(this.charID);
                        if (player34 != null) {
                            player34.hold(0, 0, 32, -1, -1);
                        }
                        this.hold(0, 0, 32, -1, -1);
                        this.mobId_holder = -1;
                        this.charId_holder = -1;
                    }
                    synchronized (this.zoneMap.players) {
                        for (int i = 0; i < this.zoneMap.players.size(); i++) {
                            if (!this.zoneMap.players.get(i).isDie && !this.zoneMap.players.get(i).isTemplate && Math.abs(this.cx - this.zoneMap.players.get(i).cx) <= skillFight.dx && Math.abs(this.cy - this.zoneMap.players.get(i).cy) <= skillFight.dy) {
                                this.zoneMap.players.get(i).setItem(skillFight.template.iconId, 31, 0, skillFight.damage);
                            }
                        }
                    }
                }
                //Makankosappo
                if (status == -1 || (status == 4 && skillFight.template.id == 11)) {
                    this.timeLoadSkill = 3000;
                    this.addSkillNotFocus(status, 3000, skillFight.skillId, skillFight.damage, skillFight.dx, skillFight.dy, skillFight.point);
                }
                //De trung
                if (status == -1 || (status == 8 && skillFight.template.id == 12)) {
                    this.zoneMap.player_skill_not_focus(status, this.charID, skillFight.skillId, null, null, 0);
                    this.addMobMe(Mob.deTrungMobId[skillFight.point - 1], this.cHPFull, (skillFight.damage + 195) * 1000);
                    this.mobMe.damage = skillFight.damage;
                }
                
                //Xoa tao nang luong
                if (skillFight.template.id != 8) {
                    if (this.isCharge) {
                        this.isCharge = false;
                        this.zoneMap.player_skill_not_focus(3, this.charID, -1, null, null, 0);
                    }
                }
                //Nhiem vu thanh tich dung chieu dac biet
                if (this.session != null) {
                    this.updateArchivement(14, 1L);
                }
            }
        }
    }
    
    public int haveAttackPLayer(Char myChar, int type, int dam, boolean flag, int idEff, boolean isShowDam) {
        this.isThaCau = 0;
        if (!this.isDie && !this.shield) {
            if (myChar != null && dam > 0 && this.vatChuId != -1 && myChar.charID != this.vatChuId) {
                dam = 0;
            }
            if (dam > 0 && this.isTemplate && ((Player) this).charTemplate.type == 6) {
                dam = (int) ((long)this.cHPFull / 100L);
            }
            if (dam > 0 && myChar != null && myChar.isTemplate && ((Player) myChar).charTemplate.type == 6 && dam > 1) {
                dam = (int) ((long)myChar.cHPFull / 100L);
            }
            if (dam > 0 && flag && this.cTemplateId != 13 && this.cTemplateId != 14 && !this.isAgainstDamageCrit) {
                dam = (int) ((long)dam * 2L);
                if (myChar != null && myChar.damCrit_percent > 0) {
                    dam = (int) (dam + ((long)dam * (long)myChar.damCrit_percent / 100L));
                }
                if (myChar != null && myChar.vTanjiro > 0) {
                    dam = (int) (dam + ((long)dam * (long)myChar.vTanjiro / 100L));
                }
            }
            if (this.maxDamageTo != -1 && dam > this.maxDamageTo) {
                dam = this.maxDamageTo;
            }
            if (this.maxPercentHPTo != -1 && dam > this.cHPFull * this.maxPercentHPTo / 100) {
                dam = this.cHPFull * this.maxPercentHPTo / 100;
            }
            if (this.cTemplateType == 45) {
                this.isBiDanh = true;
            }
            if (type == 5) {
                if (this.cHP - dam  < 1) {
                    dam = this.cHP - 1;
                }
            }
            if (myChar != null && myChar.isMaPhongBa1) {
                dam = 1;
            }
            if (dam > this.cHP) {
                dam = this.cHP;
            }
            //Ne don chat
            if (dam == 0) {
                String chat[] = mResources.NE_DON.split("\\|");
                this.addChat(0, chat[Util.gI().nextInt(chat.length)]);
            }
            this.cHP -= dam;
            if (dam > 0 && myChar != null && myChar.myCharz() != null && myChar.myCharz().charID != this.charID) {
                this.addDam(myChar.myCharz().charID, dam);
                this.addAtt(myChar.myCharz().charID);
                if (this.isTemplate && (this.cTemplateType == 26 || this.cTemplateType == 27) && myChar.session != null) {
                    if (dam % 2 == 0) {
                        myChar.session.service.setPowerInfo(mResources.PERCENT, (int) (100f / (float)this.cHPFull * (float)this.getDam(myChar.charID)), 20, 1);
                    }
                }
            }
            if (isShowDam && zoneMap != null) {
                this.zoneMap.haveAttackPlayer(charID, this.cHP, dam, flag, idEff);
            }
            if (this.cHP <= 0) {
                //Non trong bung ra
                if (this.belly != null) {
                    this.drop();
                }
                if (this.cTemplateType == 29) {
                    this.bienhinh(5);
                } else {
                    this.startDie(type, this.cx, this.zoneMap.mapTemplate.touchY(this.cx, this.cy));
                }
                if (myChar != null && !this.isTemplate && this.me) {
                    if (this.cTemplateType == 26 || this.cTemplateType == 27) {
                        updateCollectPoint(5);
                    }
                }
                if (myChar != null && this.isTemplate) {
                }
            }
            if (myChar != null && this.isDie && myChar.isHaveChatGameBot(1)) {
                myChar.addChat(1, myChar.nextChatGameBot(1).chat.replace("$1", this.cName));
            }
            
            if (this.sleepEff) {
                this.hold(0, 0, 41, -1, -1);
            }
            if (this.isSocola && this.isDie) {
                ItemMap itemMap = this.zoneMap.addItemMap(-1, new Item(516, false, 0, null, null, null, null), cx, this.zoneMap.mapTemplate.touchY(cx, cy), 0, -1);
                this.zoneMap.itemMapAdd(itemMap);
            }
            //Nhiem vu
            if (myChar != null && !this.isTemplate && this.cHP <= 0) {
                if (myChar.ctaskId == 16 && myChar.ctaskIndex == 0 && !myChar.zoneMap.map.isMapBlackBall()) {
                    myChar.updateTask(1);
                }
            }
            if (this.isTemplate && this.cHP <= 0) {
                ArrayList<ItemMap> itMaps = new ArrayList<>();
                Boss.gI().updateDie(myChar, this, itMaps, this.zoneMap);
                for (int i = 0; i < itMaps.size(); i++) {
                    this.zoneMap.itemMapAdd(itMaps.get(i));
                }
                if (this.zoneMap.map.isMapDoanhTrai()) {
                    int indexMap = this.zoneMap.map.doanhTrai.getIndexMaps(this.mapTemplateId);
                    if (this.cTemplateId == 42) {
                        if (this.isBossMain) {
                            this.zoneMap.countMobDie++;
                            if (this.zoneMap.countMobDie >= this.zoneMap.map.doanhTrai.maxMobDieNextMap[indexMap]) {
                                this.zoneMap.map.doanhTrai.updateWin(this.zoneMap.map.doanhTrai.getIndexMaps(this.mapTemplateId));
                            }
                        }
                    } else {
                        this.zoneMap.countMobDie++;
                        if (this.zoneMap.countMobDie >= this.zoneMap.map.doanhTrai.maxMobDieNextMap[indexMap]) {
                            this.zoneMap.map.doanhTrai.updateWin(this.zoneMap.map.doanhTrai.getIndexMaps(this.mapTemplateId));
                        }
                    }
                }
            }
        }
        return dam;
    }
    
    public void selectSkill(int skillTemplateId) {
        if (this.skills != null && this.skills.size() > 0) {
            for (int i = 0; i < this.skills.size(); i++) {
                Skill skill = this.skills.get(i);
                if (skill != null && skill.template.id == skillTemplateId) {
                    this.mySkill = skill;
                    if (!this.CSkill.isEmpty() && this.CSkill.get(0) != skill.template.id) {
                        this.lSSkill = System.currentTimeMillis();
                    }
                    this.CSkill.clear();
                    this.CSkill.add(skill.template.id);
                    break;
                }
            }
        }
    }
    
    public Skill getSkillBySkillId(short skillId) {
        int i;
        for (i = 0; i < this.skills.size(); i++) {
            Skill skill = this.skills.get(i);
            if (skill != null && skill.skillId == skillId) {
                return skill;
            }
        }
        return null;
    }
    
    public Skill getSkillByTemplateId(int skillTemplateId) {
        int i;
        for (i = 0; i < this.skills.size(); i++) {
            Skill skill = this.skills.get(i);
            if (skill != null && skill.template.id == skillTemplateId) {
                return skill;
            }
        }
        return null;
    }
    
    public int getSkillPoint(int skillTemplateId) {
        int i;
        for (i = 0; i < this.skills.size(); i++) {
            Skill skill = this.skills.get(i);
            if (skill != null && skill.template.id == skillTemplateId) {
                return skill.point;
            }
        }
        return -1;
    }
    
    public boolean checkHaveMount() {
        int i;
        this.idMount = -1;
        Item[] array = this.arrItemBody;
        for (i = 0; i < array.length; i++) {
            if (array[i] != null && ((int)array[i].template.type == 24 || (int)array[i].template.type == 23)) {
                if (array[i].template.part >= 0) {
                    this.idMount = (short) (Char.ID_NEW_MOUNT + array[i].template.part);
                } else {
                    this.idMount = array[i].template.id;
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean checkHaveGLT() {
        int i;
        this.itemGLT = null;
        if (this.arrItemBag != null) {
            for (i = 0; i < this.arrItemBag.length; i++) {
                if (this.arrItemBag[i] != null && this.arrItemBag[i].isItemTraining() && this.arrItemBag[i].isHaveOption(9) && this.arrItemBag[i].getOption(9).param > 0) {
                    if (this.itemGLT == null || this.itemGLT.getParamOption(9) < this.arrItemBag[i].getParamOption(9)) {
                        this.itemGLT = this.arrItemBag[i];
                    }
                }
            }
        }
        return false;
    }
    
    public void setPos(int x, int y, int b) {
        this.isThaCau = 0;
        ZoneMap myMap = this.zoneMap;
        if (myMap != null) {
            try {
                this.pixels = MapTemplate.arrMapTemplate[this.mapTemplateId].getCollisionPixel(x, y - 1);
            } catch (Exception e) {
                int xMax = 0;
                int yMax = myMap.mapTemplate.pxh;
                while(xMax < myMap.mapTemplate.pxw) {
                    while(yMax > 0) {
                        if (myMap.mapTemplate.isCollisionPixel(xMax, yMax - 1, 0xffffffff)) {
                            x = xMax;
                            y = yMax;
                            this.pixels = 0xffffffff;
                            break;
                        }
                        yMax -= 24;
                    }
                    xMax += 24;
                }
            }
            this.cx = x;
            this.cy = y;
            myMap.set_Pos(this.charID, x, y, b);
        }
    }
    
    public void changeFlag(int flagType) {
        this.cFlag = (byte) flagType;
        this.IDFlag = Flag.FLAGS.get(flagType).itemFlag.template.id;
        this.updateAll();
        if (this.session != null) {
            this.session.service.meLoadPoint();
        }
        if (this.zoneMap != null) {
            this.zoneMap.changeFlag(this.charID, flagType);
            this.zoneMap.playerLoadAll(this);
        }
    }
    
    public void applyCharLevelPercent() {
        try {
            long num = 1L;
            long num2 = 0L;
            int num3 = 0;
            for (int i = GameData.exps.length - 1; i >= 0; i--) {
                if (this.cPower >= GameData.exps[i]) {
                    if (i == GameData.exps.length - 1) {
                        num = 1L;
                    } else {
                        num = GameData.exps[i + 1] - GameData.exps[i];
                    }
                    num2 = this.cPower - GameData.exps[i];
                    num3 = i;
                    break;
                }
            }
            this.clevel = num3;
        }
        catch (Exception ex) {}
    }
    
    public void hold(int effID, int time, int holdEffID, int charId1, int charId3) {
        //Troi
        if (holdEffID == 32) {
            this.holder_charId = charId3;
            if (effID == 1) {
                this.holder = true;
                if (this.maxTimeEff != -1 && time > this.maxTimeEff) {
                    time = this.maxTimeEff;
                }
                this.time_holder = time;
            } else {
                this.holder = false;
                this.time_holder = 0;
            }
        }
        //Khien nang luong
        if (holdEffID == 33) {
            if (effID == 1) {
                this.protectEff = true;
                this.time_protectEff = time;
            } else {
                this.protectEff = false;
                this.time_protectEff = 0;
            }
        }
        //Huyt Sao
        if (holdEffID == 39) {
            if (effID == 1) {
                this.huytSao = true;
                this.time_huytSao = time;
            } else {
                this.huytSao = false;
                this.time_huytSao = 0;
            }
        }
        //Co dinh
        if (holdEffID == 40) {
            if (effID == 1) {
                this.blindEff = true;
                this.time_blindEff = time;
            } else {
                this.blindEff = false;
                this.time_blindEff = 0;
            }
        }
        //Ru ngu
        if (holdEffID == 41) {
            if (effID == 1) {
                this.sleepEff = true;
                this.time_sleepEff = time;
            } else {
                this.sleepEff = false;
                this.time_sleepEff = 0;
            }
        }
        if (this.zoneMap != null) {
            this.zoneMap.holdChar(effID, holdEffID, charId1, this.charID, charId3);
        }
    }
    
    public void bienHinh(int isMonkey, int level, int time) {
        this.isMonkey = (byte) isMonkey;
        this.levelMonkey = (byte) level;
        this.updateAll();
        if (isMonkey == 1) {
            this.miliSecond_Monkey = time;
            this.cMP = this.cMPFull;
        } else {
            this.miliSecond_Monkey = 0;
        }
        if (session != null) {
            this.session.service.meLoadPoint();
        }
        if (this.zoneMap != null) {
            this.zoneMap.playerLoadAll(this);
            this.zoneMap.updateBody(this, 0);
        }
    }
    
    public void addMobMe(int mobTemplateId, int hp, int timeLive) {
        if (this.mobMe != null) {
            this.clearMobMe();
        }
        Mob mob = new Mob(this.charID, mobTemplateId, 1, this.cx, this.cy);
        mob.zone = this.zoneMap;
        mob.hp = mob.maxHp = hp;
        mob.status = 4;
        mob.isMobMe = true;
        mob.timeLiveMobMe = timeLive;
        mob.me = this;
        synchronized (this.zoneMap.mobs) {
            this.zoneMap.mobs.add(mob);
        }
        this.mobMe = mob;
        this.zoneMap.addMobMe(this.mobMe);
    }
    
    public void clearMobMe() {
        synchronized (this.zoneMap.mobs) {
            if (this.mobMe != null) {
                for (int i = 0; i < this.zoneMap.mobs.size(); i++) {
                    Mob mob = this.zoneMap.mobs.get(i);
                    if (mob.mobId == this.mobMe.mobId) {
                        this.zoneMap.mobs.remove(i);
                    }
                }
                this.mobMe = null;
            }
        }
        this.zoneMap.claerMobMe(this.charID);
    }
    
    public void upStamina(int num) {
        this.cStamina = this.cStamina + num;
        if (this.cStamina > this.cMaxStamina) {
            this.cStamina = this.cMaxStamina;
        }
    }
    
    public boolean moveFast(int x, int y) {
        if (this.isStand() || (!this.zoneMap.mapTemplate.isCollisionPixel(x, (y == -1 ? this.cy : y) - 1, this.pixels) && !(this.checkPixel(this.cx, this.cy - 1, x, (y == -1 ? this.cy : y) -1)))) {
            this.setPos(this.cx, this.cy, 1);
            return true;
        }
        return false;
    }
    
    public boolean checkPixel(int x0, int y0, int x, int y) {
        if (this.zoneMap.mapTemplate.isCollisionPixel(x0, y0, 0xff000000) && this.zoneMap.mapTemplate.isCollisionPixel(x, y, 0xffffffff)) {
            this.pixels = this.zoneMap.mapTemplate.getCollisionPixel(x, y);
            return true;
        }
        return false;
    }
    
    public void move(int type, int x, int y) {
        this.cdir = (byte) (x > this.cx ? 1 : -1);
        this.cx = x;
        if (type == 1) {
            if (this.session != null) {
                this.updateArchivement(5, 1L);
            }
            if (!this.isHaveMount) {
                this.upMP(-this.cMPGoc / 100 * (((int)this.isMonkey != 1) ? 1 : 2));
            }
            if (this.timeFly <= 0) {
                this.timeFly = 2000;
                if (this.isFlyUpKI) {
                    this.upMP(this.cMPGoc / 100 * (((int)this.isMonkey != 1) ? 1 : 2));
                    if (this.session != null) {
                        this.session.service.meLoadMP(this.cMP);
                    }
                }
                if (this.isFlyUpHPKI) {
                    this.upHP(this.cHPGoc / 100 * (((int)this.isMonkey != 1) ? 1 : 2));
                    this.upMP(this.cMPGoc / 100 * (((int)this.isMonkey != 1) ? 1 : 2));
                    if (this.session != null) {
                        this.session.service.meLoadHP(this.cHP);
                        this.session.service.meLoadMP(this.cMP);
                        this.zoneMap.playerLoadHP(this, -1);
                    }
                }
            }
        }
        if (y != -1) {
            this.cy = y;
        } else {
        }
        this.zoneMap.playerMove(this.charID, this.cx, this.cy);
        if (this.myPet != null) {
            if (!this.myPetz().isStand() && (this.myPetz().petStatus == 0 || this.myPetz().petStatus == 1 || (this.myPetz().charFocus == null && this.myPetz().mobFocus == null) || (this.myPetz().charFocus != null && this.myPetz().charFocus.isDie) || (this.myPetz().mobFocus != null && this.myPetz().mobFocus.isDie))) {
                int x2 = Util.gI().nextInt(this.cx - 48, this.cx + 48);
                if (Math.abs(x2 - this.cx) < 24) {
                    if (x2 > this.cx) {
                        x2 = Util.gI().nextInt(this.cx + 24, this.cx + 48);
                    } else {
                        x2 = Util.gI().nextInt(this.cx - 24, this.cx - 48);
                    }
                }
                this.myPetz().timeHit = 1000;
                this.myPetz().cx = x2;
                this.myPetz().cy = cy;
                this.zoneMap.playerMove(this.myPetz().charID, this.myPetz().cx, this.myPetz().cy);
                if (this.myPetz().mobFocus != null && (Math.abs(this.myPetz().mobFocus.pointx - this.myPetz().cx) > 50 || Math.abs(this.myPetz().mobFocus.pointy - this.myPetz().cy) > 50)) {
                    this.myPetz().mobFocus = null;
                }
                if (this.myPetz().charFocus != null && (Math.abs(this.myPetz().charFocus.cx - this.myPetz().cx) > 50 || Math.abs(this.myPetz().charFocus.cy - this.myPetz().cy) > 50)) {
                    this.myPetz().charFocus = null;
                }
            }
        }
        if (this.isCharge) {
            this.isCharge = false;
            this.zoneMap.player_skill_not_focus(3, this.charID, -1, null, null, 0);
        }
        //Bo troi neu di chuyen
        if (this.mobId_holder != -1 || this.charId_holder != -1) {
            Mob mob34 = this.zoneMap.getMobIdHold(this.charID);
            if (mob34 != null) {
                mob34.hold(0, 0, 32, -1);
            }
            Char player34 = zoneMap.getCharIdHold(this.charID);
            if (player34 != null) {
                player34.hold(0, 0, 32, -1, -1);
            }
            this.hold(0, 0, 32, -1, -1);
            this.mobId_holder = -1;
            this.charId_holder = -1;
        }
        if (this.mobFocus != null && (Math.abs(this.mobFocus.pointx - this.cx) > 50 || Math.abs(this.mobFocus.pointy - this.cy) > 50)) {
            this.mobFocus = null;
        }
        if (this.charFocus != null && (Math.abs(this.charFocus.cx - this.cx) > 50 || Math.abs(this.charFocus.cy - this.cy) > 50)) {
            this.charFocus = null;
        }
        //Check roi vo dai
        if (this.mapTemplateId == 129 && this.cy >= 280 && this.zoneMap.isRace && this.me && !this.isTemplate) {
            this.loser(2);
        }
        //Check roi dau truong
        if (this.mapTemplateId == 51 && this.zoneMap.isRace && this.cy >= 336) {
            this.loser(2);
        }
        //Check roi vo dai sieu hang
        if (this.mapTemplateId == 113 && this.cy >= 280 && this.zoneMap.isRace && this.me && !this.isTemplate) {
            this.loser(2);
        }
        //Mat tha cau
        this.isThaCau = 0;
        //Nhiem vu
        if (this.ctaskId == 0 && this.ctaskIndex == 0 && this.cx >= 385) {
            this.updateTask(1);
        }
    }
    
    public void transPort(int maxTime, int type, ZoneMap zone, int typeTeleport1, int typeTeleport2, int xTeleport, int yTeleport) {
        if (!this.isTransport) {
            if (zone == null) {
                Map map = Map.getMapServer(102);
                if (map != null) {
                    zone = map.getZone(this);
                }
            }
            if (zone != null) {
                this.zoneMap.exit(this, typeTeleport1);
                this.typeTeleport2 = (byte) typeTeleport2;
                this.isTransport = true;
                this.maxTimeTransport = maxTime;
                this.lastTransport = System.currentTimeMillis();
                this.session.service.transPort(maxTime, type);
                this.transport = zone;
                this.xTeleport2 = xTeleport;
                this.yTeleport2 = yTeleport;
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void petChangeStatus(byte status) {
        Util.gI().log("Change status="+status);
        if (this.myPet != null) {
            if (this.myPetz().petStatus == 4) {
                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NO_FINNISH, null, (byte)0);
            } else {
                if (status == 0) {
                    this.myPetz().petStatus = 0;
                    this.session.service.chat(this.myPetz().charID, mResources.DT_DITHEO);
                }
                if (status == 1) {
                    this.myPetz().petStatus = 1;
                    this.session.service.chat(this.myPetz().charID, mResources.DT_BAOVE);
                }
                if (status == 2) {
                    this.myPetz().petStatus = 2;
                    this.session.service.chat(this.myPetz().charID, mResources.DT_TANCONG);
                }
                if (status == 3) {
                    this.myPetz().timeVeNha = 2000;
                    this.myPetz().petStatus = 3;
                    this.session.service.chat(this.myPetz().charID, mResources.DT_VENHA);
                }
                if (status == 4) {
                    this.hopThe(0);
                }
                //hop the vinh vien namek
                if (status == 5 && this.cgender == 1) {
                    if (this.myPet != null) {
                        this.updateEXP(1, this.myPetz().cPower);
                        if (this.myPetz().zoneMap != null) {
                            this.myPetz().zoneMap.exit(this.myPetz(), 0);
                        }
                        this.myPet = null;
                        this.session.service.petInfo0();
                        this.zoneMap.setFusion(4, this.charID);
                    }
                }
            }
        }
    }
    
    public void hopThe(int type) {
        if (!this.myPetz().isDie) {
            if (type == 0 && this.myPetz().timeHopThe > 0) {
                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.HOPTHE_BEFORE_10, null, (byte)0);
            } else if (this.timeTach > 0) {
                this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.TIME_WITE, Util.gI().getStrTime(this.timeTach)), null, (byte)0);
            } else if (this.holder) {
                this.addInfo1(mResources.NO_FINNISH);
            } else {
                //Hieu ung hop the
                this.zoneMap.setFusion(type == 5 ? 0 : 6, this.charID);
                //Tat khi
                if (this.myPetz().isMonkey != 0) {
                    this.myPetz().bienHinh(0, 0, 0);
                }
                //Tat huyt sao
                if (this.myPetz().isExistItem(3781)) {
                    this.myPetz().setItem(3781, 0, 0, 0);
                }
                //Mat tac dung huyt sao
                this.myPetz().huytSaoHP = 0;
                //Mat tac dung mi
                this.myPetz().niceDam_percent = 0;
                //Mat tac dung giam st
                this.myPetz().downDamagePercent = 0;
                //Mat tang dung dien loan
                this.myPetz().vCazy = 0;
                if (this.myPetz().zoneMap != null) {
                    this.myPetz().zoneMap.exit(this.myPetz(), 0);
                }
                if (type == 0) {
                    if (this.cgender == 0) {
                        this.setItem(3790, 60 * 10, 1, 0);
                    }
                    if (this.cgender == 1) {
                        this.setItem(3901, 60 * 10, 1, 0);
                    }
                    if (this.cgender == 2) {
                        this.setItem(3790, 60 * 10, 1, 0);
                    }
                }
                if (type != 0) {
                    myPetz().petStatus = 4;
                    if (type == 1) {
                        myPetz().isHopThe = 2;
                    }
                    if (type == 2) {
                        myPetz().isHopThe = 3;
                    }
                    this.myPetz().updateAll();
                    this.updateAll();
                    this.cHP = this.cHPFull + this.myPetz().cHPFull;
                    this.cMP = this.cMPFull + this.myPetz().cMPFull;
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    this.zoneMap.playerLoadAll(this);
                    this.zoneMap.updateBody(this, 0);
                }
            }
        }
    }
    
    public void nextSkillPet(int v, int n) {
        if (n == 0) {
            this.myPetz().skills.add(Skill.arrSkill[this.myPetz().arrSkillPet[v][Util.gI().nextInt(this.myPetz().arrSkillPet[v].length)]].clone());
        } else {
           Skill uSkill = this.myPetz().skills.get(v);
           int i;
           for (i = 0; i < uSkill.template.skills.length; i++) {
               if (uSkill.template.skills[i].point == uSkill.point + 1) {
                   this.myPetz().skills.set(v, uSkill.template.skills[i].clone());
                   break;
               }
           }
        }
    }
    
    public void goMe() {
        int x = Util.gI().nextInt(this.myCharz().cx - 48, this.myCharz().cx + 48);
        if (Math.abs(x - this.myCharz().cx) < 24) {
            if (x > this.myCharz().cx) {
                x = Util.gI().nextInt(this.myCharz().cx + 24, this.myCharz().cx + 48);
            } else {
                x = Util.gI().nextInt(this.myCharz().cx - 24, this.myCharz().cx - 48);
            }
        }
        this.myPetz().addMove(0, x, this.myCharz().cy, 0);
    }
    
    public void close() {
        if (this.itemNamekBall != null) {
            this.throwNamekBall();
        }
        if (this.zoneMap != null) {
            if (this.isTemplate) {
                this.zoneMap.exit(this, this.typeTeleport);
            } else {
                this.zoneMap.exit(this, 0);
            }
        }
        if (this.myPet != null) {
            if (this.myPetz().zoneMap != null) {
                this.myPetz().zoneMap.exit(this.myPetz(), 0);
            }
        }
        if (this.myPet2 != null) {
            this.myPet2.timeClear = 0;
        }
        if (this.belly != null) {
            for (int i = 0; i < this.belly.zones.size(); i++) {
                this.belly.zones.get(i).pushPlayers(0);
            }
        }
        if (this.myChar3 != null) {
            this.myChar3.timePkMyPet = 0;
            this.myPet3 = null;
        }
        //Xoa myPet4
        this.clearPet4();
        //nguoi dau
        this.clearFighter();
        //Xoa nhan ban
        this.clearClone();
        //Xoa wish
        this.clearWish();
        //Xoa all mypet
        this.clearMyPets();
        //ket thuc war
        if (this.bWar != null) {
            this.bWar.isWar = false;
        }
    }
    
    public void clearPet4() {
        if (this.myPet4 != null) {
            if (this.myPet4.zoneMap != null) {
               this.myPet4.zoneMap.exit(this.myPet4, 0);
            }
            this.myPet4.myChar4 = null;
            this.myPet4 = null;
        }
    }
    
    public void addDam(int charId, int dam) {
        synchronized(charDam) {
            if (charDam.containsKey(charId)) {
                charDam.replace(charId, charDam.get(charId) + dam);
            } else {
                charDam.put(charId, dam);
            }
        }
    }
    
    public int getDam(int charId) {
        synchronized(charDam) {
            if (charDam.containsKey(charId)) {
                return charDam.get(charId);
            } else {
                return -1;
            }
        }
    }
    
    public void addAtt(int charId) {
        synchronized(charAtt) {
            if (!charAtt.contains(charId)) {
                charAtt.add(charId);
            }
        }
    }
    
    public void removeAtt(int charId) {
        int i;
        synchronized(charAtt) {
            for (i = 0; i  < charAtt.size(); i++) {
                if (charAtt.get(i) == charId) {
                    charAtt.remove(i);
                    break;
                }
            }
        }
    }
    
    public void claerDam() {
        synchronized(charDam) {
            charDam.clear();
        }
    }
    
    public void claerAtt() {
        synchronized(charAtt) {
            charAtt.clear();
        }
    }
    
    public boolean isAtt(int charId) {
        boolean b;
        synchronized(charAtt) {
            b = charAtt.contains(charId);
        }
        return b;
    }
    
    public int getCharIdMaxDam() {
        int charId = -1;
        int[] arrId = null;
        int i;
        synchronized(charDam) {
            if (!charDam.isEmpty()) {
                arrId = new int[charDam.size()];
                i = 0;
                Iterator<Integer> itr = charDam.keySet().iterator();
                while (itr.hasNext()) {
                    int key = itr.next();
                    arrId[i++] = key;
                }
            }
        }
        if (arrId != null) {
            int dameMax = 0;
            for (i = 0; i < arrId.length; i++) {
                Session_ME player = Server.gI().getByCId(arrId[i]);
                if (player != null && this.getDam(arrId[i]) > dameMax) {
                    dameMax = this.getDam(arrId[i]);
                    charId = player.myCharz().charID;
                }
            }
        }
        return charId;
    }
    
    public long getCoinNT() {
        int i;
        long coin343 = 10000000;
        if (this.ncoinSpeacialSkill > 0) {
            for (i = 0; i < this.ncoinSpeacialSkill; i++) {
                coin343 = coin343 * 2l;
            }
        }
        if (coin343 > 2000000000) {
            coin343 = 2000000000L;
        }
        return coin343;
    }
    
    public void setClan(int clanId) {
        if (clanId == -1) {
            this.clan = null;
            this.clanMember = null;
            this.bag = -1;
            return;
        }
        Clan c = Clan.getClan(clanId);
        if (c != null && c.isExistMember(this.cName)) {
            this.clan = c;
            this.clanMember = c.getMemberByName(this.cName);
        } else {
            this.clan = null;
            this.clanMember = null;
        }
    }
    
    public void initClanMember() {
        if (this.clan != null) {
            this.clanMember.ID = this.charID;
            this.clanMember.head = this.head;
            this.clanMember.headICON = this.headICON;
            this.clanMember.body = this.body;
            this.clanMember.leg = this.leg;
            this.clanMember.powerPoint = this.cPower;
            this.clanMember.curClanPoint = this.clanPoint;
            this.bag = this.clan.imgID;
        } else {
            this.clanMember = null;
            this.bag = -1;
        }
    }
    
    public int getClanId() {
        if (clan != null) {
            return clan.ID;
        } else {
            if (this.cTemplateType == 29 || this.cTemplateType == 30) {
                return -100;
            }
            return -1;
        }
    }
    
    public void clanInvite(int action, int playerID, int clanID, int code) {
        Util.gI().logln("clanInvite action="+action+" playerID="+playerID+" clanID="+clanID+" code="+code);
        if (action == 0) {
            if (this.clan != null) {
                Session_ME player = Server.gI().getByCId(playerID);
                if (player != null) {
                    if (player.myCharz().ctaskId < 12) {
                        
                    } else if (player.myCharz().clan != null && player.myCharz().clan.ID == this.clan.ID) {

                    } else if (this.clan.isWork()) {
                        this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_SET_CLAN, null, 0);
                    } else if (player.myCharz().clan != null) {

                    } else if (this.clan.getSizeMember() >= this.clan.maxMember) {

                    } else if (this.clan.isHaveInvite(player.myCharz().playerId)) {
                        
                    } else {
                        player.service.clanInvite(String.format(mResources.SEND_CALN_INVITE2, this.cName, this.clan.name), this.clan.ID, this.clan.addInvite(player.myCharz().playerId));
                        this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.SEND_CALN_INVITE, player.myCharz().cName), null, 0);
                    }
                }
            }
        }
        if (action == 1) {
            if (this.myObj().isExitClan) {
                this.addInfo1(mResources.WAIT_TOMORROW);
            } else if (this.clan == null) {
                Clan c = Clan.getClan(clanID);
                if (c != null) {
                    if (c.getSizeMember() >= c.maxMember) {
                        
                    } else if (c.isHaveInvite(code, playerId)) {
                        c.setMember(this, 2);
                        this.initClanMember();
                        c.clanInfo();
                        
                        this.updateAll();
                        this.session.service.meLoadPoint();
                        this.session.service.getBag(this.charID, this.bag);
                        this.zoneMap.playerLoadAll(this);
                    }
                    
                }
            }
        }
    }
    
    public byte getRole() {
        if (this.clanMember != null) {
            return this.clanMember.role;
        }
        return -1;
    }
    
    public void clanMessage(int type, String text, int clanID) {
        ClanMessage msg;
        Util.gI().logln("type="+type+" text="+text+" clanID="+clanID);
        //chat bang hoi
        if (type == 0 && this.clan != null) {
            if (text.length() == 0 || text.length() > 50 || !Util.gI().CheckString(text, mResources.REGEX_VIETNAM)) {
                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_KTDB, null, 0);
            } else {
                msg = new ClanMessage();
                msg.type = 0;
                msg.playerId = this.charID;
                msg.playerName = this.cName;
                msg.headId = this.head;
                msg.role = this.clanMember.role;
                msg.time = (int) (System.currentTimeMillis() / 1000);
                msg.chat = text;
                msg.color = 0;
                this.clan.addMsg(msg);
                this.clan.addMessage(msg);
            }
        }
        //xin vao bang
        if (type == 2 && this.clan == null) {
            Clan c = Clan.getClan(clanID);
            if (this.myObj().isExitClan) {
                this.addInfo1(mResources.WAIT_TOMORROW);
            } else if (c != null) {
                if (this.ctaskId < 12) {
                    
                } else if (c.isHaveMsgPlayerNameInvate(cName)) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.CLAN_HAVE_INVATE, null, 0);
                } else if (c.getSizeMember() >= c.maxMember) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.CLAN_FULL_MEMBER, null, 0);
                } else {
                    msg = new ClanMessage();
                    msg.type = 2;
                    msg.playerId = this.charID;
                    msg.playerName = String.format(mResources.CNAME_CLAN_INVATE, this.cName, Util.gI().numberTostring(this.cPower));
                    msg.headId = this.head;
                    msg.role = -1;
                    msg.time = (int) (System.currentTimeMillis() / 1000);
                    msg.chat = this.cName;
                    msg.color = 0;
                    c.addMsg(msg);
                    c.addMessage(msg);
                }
            }
        }
        //Xin dau
        if (type == 1 && this.clan != null) {
            if (this.lastXinDau - System.currentTimeMillis() > 0) {
                this.addInfo1(String.format(mResources.NOT_CALL_DAU, Util.gI().getStrTime(this.lastXinDau - System.currentTimeMillis())));
            } else {
                this.lastXinDau = System.currentTimeMillis() + 300000L;
                msg = new ClanMessage();
                msg.type = 1;
                msg.playerId = this.charID;
                msg.playerName = this.cName;
                msg.headId = this.head;
                msg.role = -1;
                msg.time = (int) (System.currentTimeMillis() / 1000);
                msg.chat = "";
                msg.color = 0;
                msg.recieve = 0;
                msg.maxCap = 5;
                this.clan.addMsg(msg);
                this.clan.addMessage(msg);
            }
        }
    }
    
    public void changeTypePk(int typePk) {
        this.cTypePk = (byte) typePk;
        if (this.zoneMap != null) {
            this.zoneMap.updateTypePk(this.charID, typePk);
        }
    }
    
    public int indexUIFoods99() {
        int indexUI = -1;
        int i;
        Item item;
        for (i = 0; i < this.arrItemBag.length; i++) {
            item = this.arrItemBag[i];
            if (item != null && item.template.id >= 663 && item.template.id <= 667 && item.quantity >= 99) {
                indexUI = item.indexUI;
                break;
            }
        }
        return indexUI;
    }
    
    public void initFriend() {
        for (int i = 0; i < this.arrFriend.size(); i++) {
            Friend f = this.arrFriend.get(i);
            Session_ME player = Server.gI().getByCName(f.name);
            if (player != null) {
                f.playerId = player.myCharz().charID;
                f.head = player.myCharz().head;
                f.headICON = player.myCharz().headICON;
                f.body = player.myCharz().body;
                f.leg = player.myCharz().leg;
                f.bag = player.myCharz().bag;
                f.name = player.myCharz().cName;
                f.isOnline = true;
                f.power = player.myCharz().cPower;
            } else {
                f.isOnline = false;
            }
        }
    }
    
    public boolean isHaveFriend(String name) {
        int i;
        for (i = 0; i < this.arrFriend.size(); i++) {
            if (this.arrFriend.get(i).name.equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    public void addFriend(int playerId) {
        if (playerId == this.charID) {
            return;
        }
        Session_ME player = Server.gI().getByCId(playerId);
        if (player != null) {
            if (this.isHaveFriend(player.myCharz().cName)) {
                this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.HAVE_PLAYER_FRIEND_LIST, player.myCharz().cName), null, 0);
            } else if (this.arrFriend.size() >= 5) {
                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.FRIEND_LIST_FULL, null, 0);
            } else {
                Friend f = new Friend();
                f.playerId = player.myCharz().charID;
                f.head = player.myCharz().head;
                f.headICON = player.myCharz().headICON;
                f.body = player.myCharz().body;
                f.leg = player.myCharz().leg;
                f.bag = player.myCharz().bag;
                f.name = player.myCharz().cName;
                f.isOnline = true;
                f.power = player.myCharz().cPower;
                this.arrFriend.add(f);
                this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.ADD_FRIEND_TO_LIST, player.myCharz().cName), null, 0);
            }
        }
    }
    
    public void removeFriend(int playerId) {
        int i;
        for (i = 0; i < this.arrFriend.size(); i++) {
            if (this.arrFriend.get(i).playerId == playerId) {
                this.arrFriend.remove(i);
                this.session.service.remove_frend(playerId);
                break;
            }
        }
    }
    
    public void throwBlackBall() {
        Item item;
        //khong cho roi nhieu
        synchronized(this.LOCK) {
            if (this.itemBlackBall != null) {
                item = this.itemBlackBall;
                this.itemBlackBall = null;
            } else {
                return;
            }
        }
        ItemMap itm = zoneMap.addItemMap(-1, item, this.cx, this.zoneMap.mapTemplate.touchY(this.cx, this.cy), -1, -1);
        itm.milisecondRemove = System.currentTimeMillis() + 10000;
        this.zoneMap.itemMapAdd(itm);
        this.timeBlackBall = -1;
        
        this.updateAll();
        this.session.service.meLoadPoint();
        this.session.service.getBag(this.charID, this.bag);
        this.zoneMap.playerLoadAll(this);
    }
    
    public void throwNamekBall() {
        BallRada.timeCleanBall = -1;
        int tX = this.cx;
        if (tX < 50) {
            tX = 50;
        }
        if (this.zoneMap != null && tX > this.zoneMap.mapTemplate.pxw - 50) {
            tX = this.zoneMap.mapTemplate.pxw - 50;
        }
        BallRada rada = BallRada.getById(this.itemNamekBall.template.id);
        if (rada != null) {
            rada.player = null;
            rada.x = this.cx;
            rada.zoneMap = this.zoneMap;
            //
            if (NamekBall.gI().isFossil) {
                rada.ball.setTemplate(362);
            }
            ItemMap itm = zoneMap.addItemMap(-1, rada.ball, tX, this.zoneMap.mapTemplate.touchY(tX, 150), -1, -1);
            rada.itemMapID = itm.itemMapID;
            this.zoneMap.itemMapAdd(itm);
            this.itemNamekBall = null;
            this.cTypePk = 0;

            this.updateAll();
            this.session.service.meLoadPoint();
            this.zoneMap.playerLoadAll(this);
            this.zoneMap.updateTypePk(this.charID, this.cTypePk);
            this.zoneMap.getBag(this);
        }
    }
    
    public void addItemBlackBall(Item item) {
        if (!this.myObj().isHaveItemBlackBall(item.template.id)) {
            this.myObj().addItemBlackBall(item);
        }
        if (this.clan != null) {
            ClanMember[] arrMember;
            synchronized (this.clan.members) {
                arrMember = new ClanMember[this.clan.members.size()];
                for (int i = 0; i < this.clan.members.size(); i++) {
                    arrMember[i] = this.clan.members.get(i);
                }
            }
            for (int i2 = 0; i2 < arrMember.length; i2 += 1) {
                arrMember[i2].blackBalls.add(item);
            }
        }
    }
    
    public boolean isHaveItems(int id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).template.id == id) {
                return true;
            }
        }
        return false;
    }
    
    public Item getItems(int id) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).template.id == id) {
                return this.items.get(i);
            }
        }
        return null;
    }
    
    public void setItemsById(int id, Item item) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).template.id == id) {
                this.items.set(i, item);
                break;
            }
        }
    }
    
    public void saleItem(int action, int type, int id, int quantity) {
        try {
            Item item = null;
            if (type == 0) {
                item = this.arrItemBody[id];
            }
            if (type == 1) {
                if (this.session.getIntVersion() < 220) {
                    item = this.arrItemBag[id - 3];
                } else {
                    item = this.arrItemBag[id];
                }
            }
            if (item != null) {
                if (item.isItemTask() || item.template.id == 570 || !item.isItemForSale()) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.NOT_SALE, null, 0);
                } else {
                    if (quantity > 100 && item.template.id == 457) {
                        quantity = 1;
                    }
                    if (quantity > item.quantity) {
                        quantity = item.quantity;
                    }
                    if (quantity <= 0) {
                        quantity = 1;
                    }
                    long coinSale = SaleItemNew.priceItemCoin(item);
                    coinSale = coinSale * (long)quantity;
                    
                    if (action == 0) {
//                        if (item.template.id == 457) {
//                            this.clientInput.openClientInput(24, String.format(mResources.REQUEST_SALE_ITEM, item.template.name), new String[]{mResources.SOLUONG}, new int[]{1});
//                            this.clientInput.indexs.clear();
//                            this.clientInput.indexs.add(type);
//                            this.clientInput.indexs.add(id);
//                            this.clientInput.indexs.add((int)((this.session.myCharz().maxXu - this.session.myCharz().xu) / SaleItemNew.priceItemCoin(item)));
////                            System.out.println("number="+this.clientInput.indexs.get(2));
//                        } else {
                            this.session.service.saleItem(type, id, String.format(mResources.BAN_CO_MUON, quantity, item.template.name, Util.gI().getFormatNumber(coinSale)));
//                        }
                    }
                    if (action == 1) {
                        long xuOld = this.xu;
                        this.updateXu(coinSale, 2);
                        this.updateArchivement(10, 1L);
                        //bag
                        if (item.typeUI == 3) {
                            if (item.template.id == 457) {
                                this.addQuantityItemBagByIndex(item.indexUI, -quantity);
                                this.pointVip += 1;
                            } else {
                                this.arrItemBag[item.indexUI] = null;
                            }
                            this.sortBag();
                            this.session.service.Bag(this.arrItemBag);
                            if (item.template.type == 23 || item.template.type == 24 || item.template.type == 32) {
                                this.updateAll();
                                this.session.service.meLoadPoint();
                                this.zoneMap.playerLoadAll(this);
                            }
                            //usePet
                            if (item == this.usePet) {
                                this.usePet(null);
                            }
                            //usePetFollowz
                            if (this.checkPetFollowz(item)) {
                                this.checkClearPetFollowz(item);
                            }
                        }
                        //body
                        if (item.typeUI == 5) {
                            this.arrItemBody[item.indexUI] = null;
                            this.updateAll();
                            this.session.service.meLoadPoint();
                            this.zoneMap.playerLoadAll(this);
                            this.session.service.Body(this.head, this.arrItemBody);
                            this.session.service.updateBody(1, charID, head, body, leg, isMonkey);
                            this.session.service.getBag(this.charID, this.bag);
                            this.session.service.setEff(this.charID, this.idAuraEff, this.idEff_Set_Item);
                        }
                        this.addInfo1(String.format(mResources.SALE_SUCCESSFUL2, quantity, item.template.name, Util.gI().numberTostring(this.xu - xuOld)));
                        if (item.template.id != 457) {
                            this.myObj().reBuyItem.add(item);
                            if (this.myObj().reBuyItem.size() > 20) {
                                this.myObj().reBuyItem.remove(0);
                            }
                            if (this.shopId == -2003) {
                                this.session.service.shopReBuyItem(this.myObj().reBuyItem);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
    public void goToPlayer(int playerId) {
        if (!(this.paramItem(0, 33, 3) == 1l)) {
            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.DCTT, null, 0);
        } else {
            Session_ME player = Server.gI().getByCId(playerId);
            if (player != null) {
                if (player.myCharz().zoneMap == null || Map.isMapOffline(player.myCharz().mapTemplateId)|| player.myCharz().zoneMap.map.isMapDestronGas() || player.myCharz().zoneMap.map.isMapDoanhTrai() ||
                        player.myCharz().zoneMap.map.isMapBigBoss() || player.myCharz().zoneMap.map.isMapButcher() || player.myCharz().zoneMap.map.isMapKhoBau() || player.myCharz().isAnDanh || !player.myCharz().zoneMap.isHelp(this) ||
                        player.myCharz().zoneMap.map.isMapManorClan() || player.myCharz().zoneMap.map.isMapCace23() || player.myCharz().mapTemplateId == 51 || player.myCharz().mapTemplateId == 113 || player.myCharz().mapTemplateId == 165) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.DCTT3, null, 0);
                } else if (!dragon.t.MapTask.isNextMap(this, player.myCharz().mapTemplateId)) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.YOUR_NOT_TO, null, 0);
                } else if (player.myCharz().timeGoMe > 0) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.TIME_WITE, Util.gI().getFormatTime2(player.myCharz().timeGoMe)), null, 0);
                } else if (this.timeGoPlayer > 0) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.TIME_WITE, Util.gI().getFormatTime2(this.timeGoPlayer)), null, 0);
                } else if (player.myCharz().zoneMap.getCountPLayerNotAI() >= player.myCharz().zoneMap.maxPlayer) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.ZONE_FULL_PLAYER, null, 0);
                } else {
                    this.clearPet4();
                    if (this.itemNamekBall != null) {
                        this.throwNamekBall();
                    }
                    this.zoneMap.exit(this, 0);
                    player.myCharz().timeGoMe = 5000;
                    this.timeGoPlayer = 60000;
                    player.myCharz().zoneMap.join(this, 0, player.myCharz().cx, player.myCharz().cy);
                }
            } else {
                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.DCTT2, null, 0);
            }
        }
    }
    
    public Item getBongTai() {
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null && (this.arrItemBag[i].template.id == 454 || this.arrItemBag[i].template.id == 921)) {
                return this.arrItemBag[i];
            }
        }
        for (i = 0; i < this.arrItemBox.length; i++) {
            if (this.arrItemBox[i] != null && (this.arrItemBox[i].template.id == 454 || this.arrItemBox[i].template.id == 921)) {
                return this.arrItemBox[i];
            }
        }
        return null;
    }
    
    public int getCardLevel(int id) {
        for (int i = 0; i < this.radas.size(); i++) {
            if (this.radas.get(i).id == id) {
                return this.radas.get(i).level;
            }
        }
        return 0;
    }
    
    public int getCardAmount(int id) {
        for (int i = 0; i < this.radas.size(); i++) {
            if (this.radas.get(i).id == id) {
                return this.radas.get(i).amount;
            }
        }
        return 0;
    }
    
    public int getCountCardUse() {
        int num = 0;
        for (int i = 0; i < this.radas.size(); i++) {
            if (this.radas.get(i).isUse) {
                num++;
            }
        }
        return num;
    }
    
    public Rada getCard(int id) {
        for (int i = 0; i < this.radas.size(); i++) {
            if (this.radas.get(i).id == id) {
                return this.radas.get(i);
            }
        }
        return null;
    }
    
    public byte isUseCard(int id) {
        for (int i = 0; i < this.radas.size(); i++) {
            if (this.radas.get(i).id == id) {
                return (byte) (this.radas.get(i).isUse ? 1 : 0);
            }
        }
        return 0;
    }
    
    public boolean isHaveCard(int id) {
        for (int i = 0; i < this.radas.size(); i++) {
            if (this.radas.get(i).id == id) {
                return true;
            }
        }
        return false;
    }
    
    public void addCard(int id, int amountAdd) {
        Rada o = null;
        for (int i = 0; i < this.radas.size(); i++) {
            if (this.radas.get(i).id == id) {
                this.radas.get(i).amount += amountAdd;
                o = this.radas.get(i);
                break;
            }
        }
        if (o == null) {
            o = new Rada(id, amountAdd, 0);
            this.radas.add(o);
        }
        if (o.amount >= RadaTemplate.getRadaTemplate(id).max_amount) {
            o.level++;
            if (o.level > 100) {
                o.level = 100;
            }
            o.amount = 0;
            this.session.service.setRadaLevel(id, o.level);
            this.updateAll();
            this.session.service.meLoadPoint();
            this.zoneMap.playerLoadAll(this);
            this.session.service.getAuraEff(this.charID, this.idAuraEff);
        }
        this.session.service.addCard(id, this.getCardAmount(id), RadaTemplate.getRadaTemplate(id).max_amount);
        this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.ADD_CARD_RADA, null, 0);
    }
    
    public void useCard(int id) {
        Rada o = this.getCard(id);
        if (o != null && o.level != 0) {
            if (this.getCountCardUse() >= 3 && !o.isUse) {
                this.resetMenu();
                this.menuBoard.chat = String.format(mResources.MAX_USE_CARD, 3);
                this.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                this.menuBoard.openUIConfirm(5, null, null, -1);
            } else {
                o.isUse = !o.isUse;
                this.session.service.isUseCard(id, o.isUse ? 1 : 0);
                this.updateAll();
                this.session.service.meLoadPoint();
                this.session.service.getAuraEff(this.charID, this.idAuraEff);
                this.zoneMap.playerLoadAll(this);
            }
        }
    }
    
    private boolean checkHaveAuraEff() {
        this.idAuraEff = -1;
        if (!this.radas.isEmpty()) {
            if (this.isHaveCard(1204) && this.getCard(1204).isUse && this.getCard(1204).level >= 2) {
                this.idAuraEff = 1;
                return true;
            }
            if (this.isHaveCard(956) && this.getCard(956).isUse && this.getCard(956).level >= 2) {
                this.idAuraEff = 0;
                return true;
            }
        }
        return false;
    }
    
    public void usePet(Item item) {
        this.usePet = item;
        this.updateAll();
        this.session.service.meLoadPoint();
        this.zoneMap.playerLoadAll(this);
        if (this.myPet2 != null) {
            this.myPet2.timeClear = 1;
            this.myPet2 = null;
        }
        if (item != null) {
            int tempId = -1;
            if (item.template.id == 916) {
                tempId = 37;
            }
            if (item.template.id == 917) {
                tempId = 38;
            }
            if (item.template.id == 918) {
                tempId = 39;
            }
            if (item.template.id == 919) {
                tempId = 40;
            }
            if (item.template.id == 942) {
                tempId = 34;
            }
            if (item.template.id == 943) {
                tempId = 35;
            }
            if (item.template.id == 944) {
                tempId = 36;
            }
            if (item.template.id == 1039) {
                tempId = 93;
            }
            if (item.template.id == 1040) {
                tempId = 94;
            }
            if (item.template.id == 1046) {
                tempId = 95;
            }
            if (item.template.id == 908) {
                tempId = 115;
            }
            if (item.template.id == 909) {
                tempId = 116;
            }
            if (item.template.id == 910) {
                tempId = 118;
            }
            if (item.template.id == 967) {
                tempId = 122;
            }
            if (item.template.id == 1107) {
                tempId = 123;
            }
            if (item.template.id == 1114) {
                tempId = 124;
            }
            if (item.template.id == 1188) {
                tempId = 128;
            }
            if (item.template.id == 1224) {
                tempId = 139;
            }
            if (item.template.id == 1225) {
                tempId = 140;
            }
            if (item.template.id == 1226) {
                tempId = 141;
            }
            if (item.template.id == 1008) {
                tempId = 142;
            }
            if (item.template.id == 1207) {
                tempId = 143;
            }
            if (item.template.id == 1243) {
                tempId = 144;
            }
            if (item.template.id == 1244) {
                tempId = 145;
            }
            if (tempId != -1) {
                Player o2 = Player.addBoss(tempId, 0, -1, 0, false, Util.gI().nextInt(this.cx - 70, this.cx + 70), this.cy, null, -1, -1);
                o2.isCharId = this.charID;
                o2.myChar2 = this;
                this.myPet2 = o2;
                this.zoneMap.join(o2, 0, -1, -1);
            }
        }
    }
    
    public boolean isHaveVT(int id) {
        int i;
        for (i = 0; i < this.itemVTs.size(); i++) {
            if (this.itemVTs.get(i).item.template.id == id) {
                return true;
            }
        }
        return false;
    }
    
    public void checkVeTinh() {
        boolean b = false;
        if (this.zoneMap == null) {
            if (!itemVTs.isEmpty()) {
                this.itemVTs.clear();
                b = true;
            }
        } else {
            ItemMap o2;
            //Nhap ve tinh
            synchronized (this.zoneMap.itemMaps) {
                for (int i1 = 0; i1 < this.zoneMap.itemMaps.size(); i1++) {
                    o2 = this.zoneMap.itemMaps.get(i1);
                    if (o2.item.template.type == 22 && (this.playerId == o2.plId || (this.clan != null && this.clan.ID == o2.clanID)) && Math.abs(o2.x - this.cx) <= o2.r && Math.abs(o2.y - this.cy) <= o2.r) {
                        if (!this.isHaveVT(o2.item.template.id)) {
                            this.itemVTs.add(o2);
                            b = true;
                        }
                    }
                }
            }
            //Check ve tinh
            for (int i2 = this.itemVTs.size() - 1; i2 >= 0; i2--) {
                o2 = this.itemVTs.get(i2);
                if (this.zoneMap.isHaveItemMap(o2)) {
                    if (o2.item.template.type != 22 || (this.playerId != o2.plId && (this.clan == null || this.clan.ID != o2.clanID)) || Math.abs(o2.x - this.cx) > o2.r || Math.abs(o2.y - this.cy) > o2.r) {
                        this.itemVTs.remove(o2);
                        b = true;
                    }
                } else {
                    this.itemVTs.remove(o2);
                    b = true;
                }
            }
        }
        if (b) {
            this.updateAll();
            if (this.session != null) {
                this.session.service.meLoadPoint();
            }
            if (this.zoneMap != null) {
                this.zoneMap.playerLoadAll(this);
            }
        }
    }
    
    public void setPetFollow(int smallID, int fimg, int[] frameNew, int wimg, int himg, int second) {
        this.petFollow = new PetFollow(smallID, fimg, frameNew, wimg, himg, second);
        this.updateAll();
        if (this.session != null) {
            this.session.service.meLoadPoint();
        }
        if (this.zoneMap != null) {
            this.zoneMap.playerLoadAll(this);
            this.zoneMap.petFollow(this.charID, this.petFollow.smallID, this.petFollow.fimg, this.petFollow.frame, this.petFollow.wimg, this.petFollow.himg);
        }
    }
    
    public void clearPetFollow() {
        this.petFollow = null;
        this.updateAll();
        if (this.session != null) {
            this.session.service.meLoadPoint();
        }
        if (this.zoneMap != null) {
            this.zoneMap.playerLoadAll(this);
            this.zoneMap.clearPetFollow(this.charID);
            //petFollowz
            if (this.petFollowz != null) {
                this.zoneMap.petFollow(this.charID, this.petFollowz.smallID, this.petFollowz.fimg, this.petFollowz.frame, this.petFollowz.wimg, this.petFollowz.himg);
            }
        }
    }
    
    public void updateInvisiblez(int second) {
        if (second > 0) {
            this.timeInvisiblez = second * 1000;
            this.isInvisiblez = true;
        } else {
            this.timeInvisiblez = 0;
            this.isInvisiblez = false;
        }
        if (this.zoneMap != null) {
            this.zoneMap.playerLoadAll(this);
        }
    }
    
    public void sendStone(int second) {
        if (this.zoneMap != null) {
            Char[] arr;
            int i;
            synchronized (this.zoneMap.players) {
                arr = new Char[this.zoneMap.players.size()];
                for (i = 0; i < this.zoneMap.players.size(); i++) {
                    arr[i] = this.zoneMap.players.get(i);
                }
            }
            for (i = 0; i < arr.length; i++) {
                if (arr[i] != null && !arr[i].isTemplate && arr[i].charID != this.charID && !arr[i].isDie && arr[i].timeStone <= 0 && Math.abs(arr[i].cx - this.cx) <= 200 && Math.abs(arr[i].cy - this.cy) <= 200 && !arr[i].isSendSocola30 && !arr[i].isAgainstEffect) {
                    arr[i].timeStone = 30000;
                    arr[i].setItem(4392, second, 0, 0);
                }
            }
        }
    }
    
    public void sendStone(Char myChar, int second, int num) {
        if (this.zoneMap != null) {
            Char[] arr;
            int i;
            synchronized (this.zoneMap.players) {
                arr = new Char[this.zoneMap.players.size()];
                for (i = 0; i < this.zoneMap.players.size(); i++) {
                    arr[i] = this.zoneMap.players.get(i);
                }
            }
            for (i = 0; i < arr.length; i++) {
                if (num <= 0) {
                    break;
                }
                if (arr[i] != null && !arr[i].isTemplate && arr[i].charID != this.charID && !arr[i].isDie && arr[i].timeStone <= 0 && myChar.isMeCanAttackOtherPlayer(arr[i]) && !arr[i].isSendSocola30 && !arr[i].isAgainstEffect) {
                    arr[i].timeStone = 30000;
                    arr[i].setItem(4392, second, 0, 0);
                    num--;
                }
            }
        }
    }
    
    public void sendSocola(int second) {
        if (this.zoneMap != null) {
            Char[] arr;
            int i;
            synchronized (this.zoneMap.players) {
                arr = new Char[this.zoneMap.players.size()];
                for (i = 0; i < this.zoneMap.players.size(); i++) {
                    arr[i] = this.zoneMap.players.get(i);
                }
            }
            for (i = 0; i < arr.length; i++) {
                if (arr[i] != null && !arr[i].isTemplate && arr[i].charID != this.charID && !arr[i].isDie && Math.abs(arr[i].cx - this.cx) <= 200 && Math.abs(arr[i].cy - this.cy) <= 200 && !arr[i].isSendSocola30 && !arr[i].isAgainstEffect) {
                    arr[i].setItem(4133, second, 0, 0);
                }
            }
        }
    }
    
    public void cute(int percent) {
        if (this.zoneMap != null) {
            Char[] arr;
            int i;
            synchronized (this.zoneMap.players) {
                arr = new Char[this.zoneMap.players.size()];
                for (i = 0; i < this.zoneMap.players.size(); i++) {
                    arr[i] = this.zoneMap.players.get(i);
                }
            }
            for (i = 0; i < arr.length; i++) {
                if (arr[i] != null && !arr[i].isTemplate && arr[i].charID != this.charID && !arr[i].isDie && Math.abs(arr[i].cx - this.cx) <= 200 && Math.abs(arr[i].cy - this.cy) <= 200 && arr[i].cMP < arr[i].cMPFull) {
                    arr[i].upMP((int) ((long)arr[i].cMPFull * (long)percent / 100L));
                    if (arr[i].session != null) {
                        arr[i].session.service.meLoadMP(arr[i].cMP);
                    }
                }
            }
        }
    }
    
    public void explode(int second) {
        this.timeExplode = 1000 * second;
        this.zoneMap.player_skill_not_focus(7, this.charID, 107, null, null, this.timeExplode);
        if (this.session != null) {
            this.session.service.skill_not_focus(7, this.charID, 107, null, null, this.timeExplode);
        }
    }
    
    public void explode() {
        int i;
        this.zoneMap.player_skill_not_focus(7, this.charID, 107, null, null, -1);
        if (this.session != null) {
            this.session.service.skill_not_focus(7, this.charID, 107, null, null, -1);
        }
        int dam;
        Mob[] arrMob;
        synchronized (this.zoneMap.mobs) {
            arrMob = new Mob[this.zoneMap.mobs.size()];
            for (i = 0; i < this.zoneMap.mobs.size(); i++) {
                arrMob[i] = this.zoneMap.mobs.get(i);
            }
        }
        Char[] arrChar;
        synchronized (this.zoneMap.players) {
            arrChar = new Char[this.zoneMap.players.size()];
            for (i = 0; i < this.zoneMap.players.size(); i++) {
                arrChar[i] = this.zoneMap.players.get(i);
            }
        }
        for (i = 0; i < arrMob.length; i++) {
            Mob mob = arrMob[i];
            if (mob != null && this.isMeCanAttackOtherMob(mob) && Math.abs(this.cx - mob.pointx) <= 200 && Math.abs(this.cy - mob.pointy) <= 200) {
                dam = this.cHPFull;
                mob.AttackMob(this, dam, false, 3, -1);
            }
        }
        for (i = 0; i < arrChar.length; i++) {
            Char player = arrChar[i];
            if (player != null) {
                if (this.cTemplateType == 48 && player.isTemplate) continue;
                if (!player.isDie && player.charID != this.charID && Math.abs(this.cx - player.cx) <= 200 && Math.abs(this.cy - player.cy) <= 200 && this.isMeCanAttackOtherPlayer(player)) {
                    dam = this.cHPFull;
                    //Bat khien
                    if (dam > 1 && player.protectEff) {
                        if (dam  >= player.cHPFull) {
                            player.setItem(3784, 0, 0, 0);
                        }
                        dam = 1;
                    } else {
                        if (player.isTemplate) {
                            dam = dam / 2;
                        }
                    }

                    if (player.downDamage_percent > 0) {
                        int downDam_percent = player.downDamage_percent;
                        if (downDam_percent > 89) {
                            downDam_percent = 89;
                        }
                        dam = (int) (dam - ((long)dam * (long)downDam_percent / 100L));
                    }
                    player.haveAttackPLayer(this, 1, dam, false, -1, true);
                }
            }
        }
    }
    
    public void addDuaHau(int id, int[] duahau, int duaHauIndex, int second, int icon) {
        DuaHau d;
        if (this.isHaveDuaHau(id, icon)) {
            d = this.getDuaHau(id, icon);
        } else {
            d = new DuaHau();
            this.duahaus.add(d);
        }
        d.id = id;
        d.duahau = duahau;
        d.duaHauIndex = duaHauIndex;
        d.last = (int) (System.currentTimeMillis() / 1000L);
        d.second = second;
    }
    
    public DuaHau getDuaHau(int id, int icon) {
        for (int i = 0; i < this.duahaus.size(); i++) {
            if (this.duahaus.get(i).id == id && (icon == -1 || this.duahaus.get(i).duahau[this.duahaus.get(i).duaHauIndex] == icon)) {
                return this.duahaus.get(i);
            }
        }
        return null;
    }
    
    public boolean isHaveDuaHau(int id, int icon) {
        for (int i = 0; i < this.duahaus.size(); i++) {
            if (this.duahaus.get(i).id == id && (icon == -1 || this.duahaus.get(i).duahau[this.duahaus.get(i).duaHauIndex] == icon)) {
                return true;
            }
        }
        return false;
    }
    
    public void tMabu(int icon) {
        this.session.service.tMabu(101);
        this.duahaus.remove(this.getDuaHau(50, icon));
    }
    
    public void sonCall(int sc, int sonCount) {
        this.isSonCall = true;
        this.sonCall = this.sonCall + sonCount;
        this.timeSonCall = sc * 1000;
        if (this.cTypePk == 5) {
            this.changeTypePk(0);
        }
        if (this.zoneMap != null) {
            this.zoneMap.chat(this, String.format(mResources.CALL_SON, sonCount));
        }
    }
    
    public void updateFreez(int time, boolean isFreez) {
        //Thai duong ha san
        if (this.maxTimeEff != -1 && time > this.maxTimeEff) {
            time = this.maxTimeEff;
        }
        this.freezMiliSeconds = time;
        this.isFreez = isFreez;
        if (this.zoneMap != null) {
            String str[] = mResources.EFF_TDHS.split("\\|");
            this.zoneMap.chat(this, str[Util.gI().nextInt(str.length)]);
        }
    }
    
    public void updateTask(int count) {
        MeTask.updateTask(this, count);
    }
    
    public void clearItemTask() {
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            Item item = this.arrItemBag[i];
            if (item != null && item.isItemTask()) {
                this.arrItemBag[i] = null;
            }
        }
        this.session.service.Bag(this.arrItemBag);
    }
    
    public void NoiKore() {
        this.nNoiKore = 4;
    }
    
    public void setLive(int second) {
        this.timeLive = this.timeSetLive = second * 1000;
    }
    
    public void updateCollectPoint(int point) {
        this.collectPoint = this.collectPoint + point;
        if (this.session != null) {
            this.session.service.setPowerInfo(mResources.TL, this.collectPoint, 10, 10);
        }
        if (this.collectPoint >= 10) {
            if (this.IDFlag == 519) {
                this.resetMenu();
                if (this.mapTemplateId == 120) {
                    this.menuBoard.chat = mResources.THE_END_FINGHT;
                } else {
                    this.menuBoard.chat = mResources.SAY_DI_THEO;
                }
                this.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                this.menuBoard.openUIConfirm(44, null, null, 4390);
            }
            if (this.IDFlag == 520) {
                this.resetMenu();
                if (this.mapTemplateId == 120) {
                    this.menuBoard.chat = mResources.THE_END_FINGHT;
                } else {
                    this.menuBoard.chat = mResources.SAY_DI_THEO;
                }
                this.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
                this.menuBoard.openUIConfirm(46, null, null, 4388);
            }
        }
    }
    
    public void setToHome(int sc) {
        this.tToHome = sc * 1000;
    }
    
    public int npcType(int npcTemplateId) {
        if (!this.npcTypes.containsKey(npcTemplateId)) {
            this.npcTypes.put(npcTemplateId, 0);
        }
        return this.npcTypes.get(npcTemplateId);
    }
    
    public void setNpcType(int npcTemplateId, int type) {
        if (!this.npcTypes.containsKey(npcTemplateId)) {
            this.npcTypes.put(npcTemplateId, type);
            return;
        }
        this.npcTypes.replace(npcTemplateId, type);
    }
    
    public boolean isCan() {
        return this.isCan;
    }
    
    private void updateArchivement() {
    	//Updateset
    	if (this.session != null && this.gameTick % 10 == 0) {
            this.setArchivement(0, this.cPower);
            this.setArchivement(1, this.cPower);
            this.setArchivement(16, this.cPower);
            this.setArchivement(20, this.cPower);
            this.setArchivement(21, this.cPower);
            this.setArchivement(2, this.magicTree_level);
    	}
    }
    
    public void openArchivement(int type) {
    	ArrayList<ArchivementTask> myList = new ArrayList<>();
        for (int i = 0; i  < this.archivements.size(); i++) {
            if (Archivement.get(this.archivements.get(i).id).type == type) {
            	myList.add(this.archivements.get(i));
            }
        }
        this.typeArchivemnt = type;
        this.session.service.setArchive(myList);
    }
    
    public boolean isHaveArchivementById(int id) {
        for (int i = 0; i < this.archivements.size(); i++) {
            if (this.archivements.get(i).id == id) {
                return true;
            }
        }
        return false;
    }
    
    public ArchivementTask getArchivementById(int id) {
        for (int i = 0; i < this.archivements.size(); i++) {
            if (this.archivements.get(i).id == id) {
                return this.archivements.get(i);
            }
        }
        return null;
    }
    
    public void initArchivement() {
    	int myArray[] = new int[][]{
    		{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
    		{0, 20, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
    		{0, 21, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19}}
    	[this.cgender];
        for (int i = 0; i < myArray.length; i++) {
        	if (!this.isHaveArchivementById(myArray[i])) {
                this.archivements.add(new ArchivementTask(myArray[i], 0, false, false));
            } else {
            	this.getArchivementById(myArray[i]).reset();
            }
        }
    }
    
    public void updateArchivement(int id, long count) {
        if (this.isHaveArchivementById(id)) {
            this.getArchivementById(id).count += count;
            if (this.getArchivementById(id).count >= Archivement.get(id).max) {
                this.getArchivementById(id).isFinish = true;
            }
        }
    }
    
    public void setArchivement(int id, long count) {
        if (this.isHaveArchivementById(id)) {
            this.getArchivementById(id).count = count;
            if (this.getArchivementById(id).count >= Archivement.get(id).max) {
                this.getArchivementById(id).isFinish = true;
            }
        }
    }
    
    public void updateDay() {
        this.yesterday = System.currentTimeMillis();
        this.myObj().nWinHD23 = 0;
        this.myObj().nJoinDH23 = 0;
        //Sk 8/3
        this.myObj().nTangBongHoaXanh = 0;
        this.myObj().nTangChauHoaXanh = 0;
        this.session.service.Stamina(this.cMaxStamina);
        //
        this.myObj().nRuaCon = 0;
        this.myObj().nFreeTicket = 2;
        this.myObj().nBiKipTuyetKi = 0;
        Memory.get(this.session.userId).nFreeWish = 1;
        this.myObj().isExitClan = false;
    }
    
    public void getArchivemnt(int index) {
        for (int i = 0, j = 0; i < this.archivements.size(); i++) {
            if (Archivement.get(this.archivements.get(i).id).type == this.typeArchivemnt) {
            	if (j == index) {
                    ArchivementTask o = this.archivements.get(i);
                    if (o.isFinish && !o.isRecieve) {
                        o.isRecieve = true;
                        if (Archivement.get(o.id).gold != 0) {
                            this.updateXu(Archivement.get(o.id).gold, 1);
                        }
                        if (Archivement.get(o.id).money != 0) {
                            this.updateLuongKhoa(Archivement.get(o.id).money, 2);
                        }
                        this.session.service.setArchive(index);
                    }
            		return;
            	}
            	j++;
            }
        }
    }
    
    public boolean isHaveItem(int templateId) {
        for (int i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null && this.arrItemBag[i].template.id == templateId) {
                return true;
            }
        }
        for (int i = 0; i < this.arrItemBox.length; i++) {
            if (this.arrItemBox[i] != null && this.arrItemBox[i].template.id == templateId) {
                return true;
            }
        }
        for (int i = 0; i < this.arrItemBody.length; i++) {
            if (this.arrItemBody[i] != null && this.arrItemBody[i].template.id == templateId) {
                return true;
            }
        }
        return false;
    }
    
    public Item getItem(int templateId) {
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null && this.arrItemBag[i].template.id == templateId) {
                return this.arrItemBag[i];
            }
        }
        for (i = 0; i < this.arrItemBox.length; i++) {
            if (this.arrItemBox[i] != null && this.arrItemBox[i].template.id == templateId) {
                return this.arrItemBox[i];
            }
        }
        for (i = 0; i < this.arrItemBody.length; i++) {
            if (this.arrItemBody[i] != null && this.arrItemBody[i].template.id == templateId) {
                return this.arrItemBody[i];
            }
        }
        return null;
    }
    
    public boolean isNhapThe() {
        return this.myPet != null && this.myPetz().isHopThe > 0;
    }
    
    public void callDragon(Item item) {
        if (item.template.id == 14) {
            this.arrItem = new Item[] {item};
            //
            this.resetMenu();
            this.menuBoard.chat = mResources.YOU_INVATE_DRAGON;
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.HDT_NEW, 108));
//            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.CALL_DRAGON, 1), 109));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.CALL_DRAGON, 1), 294));
            this.menuBoard.openUIConfirm(5, null, null, -1);
        }
        if (item.template.id == 807) {
            this.arrItem = new Item[] {item};
            //
            this.resetMenu();
            this.menuBoard.chat = mResources.YOU_INVATE_DRAGON_2;
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 294));
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
            this.menuBoard.openUIConfirm(5, null, null, -1);
        }
        if (item.template.id == 925) {
            this.arrItem = new Item[] {item};
            //
            this.resetMenu();
            this.menuBoard.chat = mResources.YOU_INVATE_DRAGON_3;
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.AGREE, 294));
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
            this.menuBoard.openUIConfirm(5, null, null, -1);
        }
    }
    
    public int getCountSKH(int type) {
        int i;
        int num = 0;
        if (type == 0) {
            for (int j = 0; j < 5; j++) {
                boolean b = true;
                if (b) {
                    for (i = 0; i < this.arrItemBag.length; i++) {
                        if (this.arrItemBag[i] != null && this.arrItemBag[i].template.type == j && this.arrItemBag[i].isItemSKH()) {
                            num++;
                            b = false;
                            break;
                        }
                    }
                }
                if (b) {
                    for (i = 0; i < this.arrItemBox.length; i++) {
                        if (this.arrItemBox[i] != null && this.arrItemBox[i].template.type == j && this.arrItemBox[i].isItemSKH()) {
                            num++;
                            b = false;
                            break;
                        }
                    }
                }
                if (b) {
                    for (i = 0; i < this.arrItemBody.length; i++) {
                        if (this.arrItemBody[i] != null && this.arrItemBody[i].template.type == j && this.arrItemBody[i].isItemSKH()) {
                            num++;
                            b = false;
                            break;
                        }
                    }
                }
                if (b) {
                    
                }
            }
        }
        return num;
    }
    
    public void nextTask(int sc) {
        if (!this.isNextTask) {
            this.isNextTask = true;
            this.tNextTask = sc * 1000;
            if (this.ctaskId == 34 && this.ctaskIndex == 2) {
                this.session.service.chat(this.charID, mResources.NEXT_TASK_1);
            }
            if (this.ctaskId == 34 && this.ctaskIndex == 4) {
                this.session.service.chat(this.charID, mResources.NEXT_TASK_2);
            }
            if (this.ctaskId == 34 && this.ctaskIndex == 5) {
                this.session.service.chat(this.charID, mResources.NEXT_TASK_3);
            }
            if (this.ctaskId == 34 && this.ctaskIndex == 6) {
                this.session.service.chat(this.charID, mResources.NEXT_TASK_4);
            }
        }
    }
    
    public void finishTask() {
        this.isNextTask = false;
        this.tNextTask = 0;
        this.updateTask(1);
        if (this.ctaskId == 34 && this.ctaskIndex == 6) {
            this.session.service.hideNpc(71, 0);
            this.updateAll();
            this.session.service.meLoadPoint();
            this.session.service.getBag(this.charID, this.bag);
            this.zoneMap.playerLoadAll(this);
        }
        if (this.ctaskId == 34 && this.ctaskIndex == 7) {
            this.updateAll();
            this.session.service.meLoadPoint();
            this.session.service.getBag(this.charID, this.bag);
            this.zoneMap.playerLoadAll(this);
        }
    }
    
    public void eat(Char player) {
        if (!player.isEat) {
            this.timeHit = 1000;
            this.zoneMap.eat(this.charID, player.charID);
            player.eat(this.belly.zones.get(0), 1);
            for (int i = 0; i < this.belly.zones.size(); i++) {
                this.belly.zones.get(i).initBelly();
            }
        }
    }
    
    public void eat(ZoneMap zone, int sc) {
        this.isEat = true;
        this.zbelly = zone;
        this.tEat = sc * 1000;
    }
    
    public void eat() {
        this.isEat = false;
        if (!this.zbelly.map.owner.isSuper) {
            this.zoneMap.exit(this, 0);
            this.zbelly.join(this, 0, 300, 250);
            if (!this.protectEff) {
                this.tCocoon = 500;
            }
        }
    }
    
    public void drop() {
        int i;
        for (i = 0; i < this.belly.zones.size(); i++) {
            this.belly.zones.get(i).drop();
        }
    }
    
    public void setMabuHold(boolean m, int x, int y) {
        this.isMabuHold = m;
        this.zoneMap.setMabuHold(m, this.charID, this.cx = x, this.cy = y);
        if (m) {
            this.nMabuHold = 10;
            this.changeTypePk(5);
        } else {
            this.changeTypePk(0);
            this.nMabuHold = 0;
        }
    }
    
    public void tachNhapThe() {
        if (this.myPet != null && this.myPetz().petStatus == 4) {
            this.zoneMap.setFusion(1, this.charID);
            this.myPetz().petStatus = 1;
            this.myPetz().isHopThe = 0;
            this.myPetz().timeHopThe = 1000 * 60;
            this.updateAll();
            if (this.session != null) {
                this.session.service.meLoadPoint();
            }
            this.zoneMap.playerLoadAll(this);
            this.zoneMap.updateBody(this, 0);
            this.timeTach = 7000;
            if (this.isExistItem(3790)) {
                this.setItem(3790, 0, 0, 0);
            }
            if (this.isExistItem(3901)) {
                this.setItem(3901, 0, 0, 0);
            }
        }
    }
    
    public void bienhinh(int sc) {
        this.isSuper = true;
        this.tBienHinh = sc * 1000;
        this.isCharge = true;
        this.zoneMap.playerLoadHP(this, -1);
        if (this.cTemplateId == 90) {
            this.timeClear = 1;
        } else {
            this.cHP = 1;
            this.isCharge = true;
            this.chargeDamage = 4;
            this.zoneMap.player_skill_not_focus(1, this.charID, -1, null, null, -1);
            this.zoneMap.chat(this, mResources.BIEN_HINH_2);
        }
    }
    
    public void bienhinh() {
        this.timeClear = 1;
        //Super Bu
        if (this.cTemplateId == 86) {
            Player.addBoss(87, 5, -1, -1, true, this.cx, this.cy, this.zoneMap, -1, this.indexXH);
        }
        //Bu Tenk
        if (this.cTemplateId == 87) {
            Player.addBoss(88, 5, -1, -1, true, this.cx, this.cy, this.zoneMap, -1, this.indexXH);
        }
        //Bu Han
        if (this.cTemplateId == 88) {
            Player.addBoss(89, 5, -1, -1, true, this.cx, this.cy, this.zoneMap, -1, this.indexXH);
        }
        //Kid Bu
        if (this.cTemplateId == 89) {
            Player.addBoss(90, 5, -1, -1, true, this.cx, this.cy, this.zoneMap, -1, this.indexXH);
        }
    }
    
    public void rock() {
        boolean isCrit = false;
        this.aCharFocus.clear();
        this.zoneMap.addPlayerAtt(this.aCharFocus, this);
        int i;
        int[] array = new int[this.aCharFocus.size()];
        int[] array2 = new int[this.aCharFocus.size()];
        for (i = 0; i < this.aCharFocus.size(); i++) {
            array[i] = this.aCharFocus.get(i).charID;
            int d = (int) (this.aCharFocus.get(i).cHPFull * 15l / 100L);
            array2[i] = this.aCharFocus.get(i).haveAttackPLayer(this, 1, d, isCrit, -1, false);
        }
        this.zoneMap.setSkill(this.charID, 0, this.cx, this.cy, array, array2);
    }
    
    public void roll() {
        boolean isCrit = false;
        this.aCharFocus.clear();
        this.zoneMap.addPlayerAtt(this.aCharFocus, this);
        if (!this.aCharFocus.isEmpty()) {
            Char o = this.aCharFocus.get(Util.gI().nextInt(this.aCharFocus.size()));
            this.aCharFocus.clear();
            this.aCharFocus.add(o);
            int i;
            int[] array = new int[this.aCharFocus.size()];
            int[] array2 = new int[this.aCharFocus.size()];
            for (i = 0; i < this.aCharFocus.size(); i++) {
                array[i] = this.aCharFocus.get(i).charID;
                int d = (int) (this.aCharFocus.get(i).cHPFull * 15l / 100L);
                array2[i] = this.aCharFocus.get(i).haveAttackPLayer(this, 1, d, isCrit, -1, false);
            }
            this.zoneMap.setSkill(this.charID, 1, this.cx = o.cx, this.cy = o.cy, array, array2);
        }
    }
    
    public void hideRun() {
        this.aCharFocus.clear();
        int[] array = new int[this.aCharFocus.size()];
        int[] array2 = new int[this.aCharFocus.size()];
        this.zoneMap.setSkill(this.charID, 2, this.cx, this.cy, array, array2);
    }
    
    public void roll2() {
        boolean isCrit = false;
        this.aCharFocus.clear();
        this.zoneMap.addPlayerAtt(this.aCharFocus, this);
        if (!this.aCharFocus.isEmpty()) {
            Char o = this.aCharFocus.get(Util.gI().nextInt(this.aCharFocus.size()));
            this.aCharFocus.clear();
            this.aCharFocus.add(o);
            int i;
            int[] array = new int[this.aCharFocus.size()];
            int[] array2 = new int[this.aCharFocus.size()];
            for (i = 0; i < this.aCharFocus.size(); i++) {
                array[i] = this.aCharFocus.get(i).charID;
                int d = (int) (this.aCharFocus.get(i).cHPFull * 15l / 100L);
                array2[i] = this.aCharFocus.get(i).haveAttackPLayer(this, 1, d, isCrit, -1, false);
            }
            this.zoneMap.setSkill(this.charID, 3, this.cx = o.cx, this.cy = o.cy, array, array2);
        }
    }
    
    private void stab() {
        this.zoneMap.addEffectServer(1, 3, 49, this.cx - 40, this.cy + 30, -1);
        this.haveAttackPLayer(null, 1, 1000, false, -1, true);
    }
    
    public void transPort() {
        this.isTransport = false;
        this.transport.join(this, this.typeTeleport2, this.xTeleport2, this.yTeleport2);
        this.transport = null;
    }
    
    public boolean isHaveItemBag(int templateId) {
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null && this.arrItemBag[i].template.id == templateId) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isHaveItemBag(int... templateId) {
        int i;
        for (i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null) {
                for (int j = 0; j < templateId.length; j++) if (this.arrItemBag[i].template.id == templateId[j]) return true;
            }
        }
        return false;
    }
    
    public int getPointMin(int i, int num) {
        if (i == 0) {
            return this.cHPGoc / this.hpFrom1000TiemNang;
        }
        if (i == 1) {
            return this.cMPGoc / this.mpFrom1000TiemNang;
        }
        if (i == 2) {
            return this.cDamGoc / this.damFrom1000TiemNang;
        }
        if (i == 3) {
            return this.cDefull / this.defFrom1000TiemNang;
        }
        if (i == 4) {
            return this.cCriticalGoc / this.criticalFrom1000Tiemnang;
        }
        return 0;
    }
    
    public void useItemBagById(int id, int num) {
        for (int i = 0; i < this.arrItemBag.length; i++) {
            if (this.arrItemBag[i] != null && this.arrItemBag[i].template.id == id) {
                if (num < this.arrItemBag[i].quantity) {
                    useItemBag(i, num);
                    break;
                } else {
                    num = num - this.arrItemBag[i].quantity;
                    useItemBag(i, this.arrItemBag[i].quantity);
                    if (num == 0) {
                        break;
                    }
                }
            }
        }
    }
    
    public void shootPhaoHoa(int nShoot, Item item) {
        if (this.arrItemBag[item.indexUI] != null && this.arrItemBag[item.indexUI] == item && item.quantity >= nShoot) {
            this.useItemBag(item.indexUI, nShoot);
            this.zoneMap.addPhaoHoa(nShoot, this.cx, this.cy - 24, (byte)0);
            Server.gI().chatVip(String.format(mResources.PLAYER_DOT_PHAO, this.cName, nShoot, this.zoneMap.mapTemplate.mapName, this.zoneMap.zoneID));
        }
    }
    
    public void shootHoaDang(int nShoot, Item item) {
        if (this.arrItemBag[item.indexUI] != null && this.arrItemBag[item.indexUI] == item && item.quantity >= nShoot) {
            this.useItemBag(item.indexUI, nShoot);
            this.zoneMap.addPhaoHoa(nShoot, this.cx, this.cy - 24, (byte)1);
            Server.gI().chatVip(String.format(mResources.PLAYER_HOA_DANG, this.cName, nShoot, this.zoneMap.mapTemplate.mapName, this.zoneMap.zoneID));
        }
    }
    
    public void shootHoaDangLoiChuc(int nShoot, Item item, String loichuc) {
        if (this.arrItemBag[item.indexUI] != null && this.arrItemBag[item.indexUI] == item && item.quantity >= nShoot) {
            this.useItemBag(item.indexUI, nShoot);
            this.zoneMap.addPhaoHoa(nShoot, this.cx, this.cy - 24, (byte)2);
            Server.gI().chatVip(String.format(mResources.PLAYER_HOA_DANG_LOI_CHUC, this.cName, nShoot, loichuc));
        }
    }
    
    private void autoPlay() {
        boolean flag = false;
        for (int i = 0; i < this.aMobFocus.size(); i++) {
            Mob mob = this.aMobFocus.get(i);
            if (mob.status != 0 && mob.status != 1 && !mob.isDie) {
                flag = true;
            }
        }
        for (int i2 = 0; i2 < this.aCharFocus.size(); i2++) {
            Char player = this.aCharFocus.get(i2);
            if (!player.isDie) {
                flag = true;
            }
        }
        if (!flag) {
            return;
        }
        if (this.mobFocus == null || (this.mobFocus != null && this.mobFocus.isMobMe)) {
            for (int k = 0; k < this.aMobFocus.size(); k++) {
                Mob mob2 = this.aMobFocus.get(k);
                if (mob2.status != 0 && mob2.status != 1 && mob2.hp > 0 && !mob2.isMobMe && !mob2.isDie) {
                    this.mobFocus = mob2;
                    this.addMove(0, mob2.pointx, mob2.pointy, 0);
                    break;
                }
            }
        } else if (this.mobFocus.hp <= 0 || this.mobFocus.status == 1 || this.mobFocus.status == 0) {
            this.mobFocus = null;
        }
        if (this.charFocus == null) {
            for (int k2 = 0; k2 < this.aCharFocus.size(); k2++) {
                Char player2 = this.aCharFocus.get(k2);
                if (player2.cHP > 0) {
                    this.charFocus = player2;
                    this.addMove(0, player2.cx, player2.cy, 0);
                    break;
                }
            }
        } else if (this.charFocus.cHP <= 0) {
            this.charFocus = null;
        }
        if (this.charFocus != null) {
            this.mobFocus = null;
        }
        if (this.mobFocus != null || this.charFocus != null) {
            Skill skill = null;
            for (int l = 0; l < this.skills.size(); l++) {
                if (this.skills.get(l).lastTimeUseThisSkill <= System.currentTimeMillis()) {
                    if ((int)this.skills.get(l).template.id != 10) {
                        if ((int)this.skills.get(l).template.id != 11) {
                            if ((int)this.skills.get(l).template.id != 14) {
                                if ((int)this.skills.get(l).template.id != 23) {
                                    if ((int)this.skills.get(l).template.id != 7) {
                                        int num;
                                        if (this.skills.get(l).template.manaUseType == 2) {
                                            num = 1;
                                        } else if (this.skills.get(l).template.manaUseType != 1) {
                                            num = this.skills.get(l).manaUse;
                                        } else {
                                            num = this.skills.get(l).manaUse * this.cMPFull / 100;
                                        }
                                        if (this.cMP >= num) {
                                            if (skill == null) {
                                                skill = this.skills.get(l);
                                            } else if (skill.coolDown < this.skills.get(l).coolDown) {
                                                skill = this.skills.get(l);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (skill != null) {
                this.setSkill(skill);
            }
        }
    }
    
    private void setSkill(Skill skill) {
        if (this.stone > 0) {
            return;
        }
        if (skill.template.id == 9 && this.cHP <= this.cHPFull / 10) {
            return;
        }
        this.cStamina--;
        if (skill.template.id == 6) {
            this.skill_not_focus((byte)0, skill);
            return;
        }
        if (skill.template.id == 8) {
            this.skill_not_focus((byte)1, skill);
            return;
        }
        if (skill.template.id == 12) {
            this.skill_not_focus((byte)8, skill);
            return;
        }
        if (skill.template.id == 13) {
            this.skill_not_focus((byte)6, skill);
            return;
        }
        if (skill.template.id == 14) {
            this.skill_not_focus((byte)7, skill);
            return;
        }
        if (skill.template.id == 21) {
            this.skill_not_focus((byte)10, skill);
            return;
        }
        if (skill.template.id == 19) {
            this.skill_not_focus((byte)9, skill);
            return;
        }
        if (skill.skillId >= 128 && skill.skillId <= 134) {
            if (charFocus != null) {
                this.cx = charFocus.cx;
                this.cy = charFocus.cy;
            }
            if (mobFocus != null) {
                this.cx = mobFocus.pointx;
                this.cy = mobFocus.pointy;
            }
        }
        
        ArrayList arrayList1 = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList<>();
        if (mobFocus != null) {
            arrayList1.add(mobFocus);
        }
        if (charFocus != null) {
            arrayList2.add(charFocus);
        }
        int type = 0;
        if (mobFocus != null) {
            type = 1;
        } else if (charFocus != null) {
            type = 2;
        }
        this.Attack(skill, arrayList1, arrayList2, type);
    }
    
    private void petzAuto() {
        if (!this.isDie && this.petStatus != 3 && this.petStatus != 4) {
            if ((this.myPetz().zoneMap != this.myCharz().zoneMap || !this.myPetz().isInMap) && !this.myPetz().isStand()) {
                if (this.myPetz().isInMap) {
                    this.myPetz().zoneMap.exit(this.myPetz(), 0);
                }
                if (this.myCharz().zoneMap != null && !Map.isMapOffline(this.myCharz().mapTemplateId) && this.myCharz().mapTemplateId != 51 && this.myCharz().mapTemplateId != 113) {
                    int x = Util.gI().nextInt(this.myCharz().cx - 48, this.myCharz().cx + 48);
                    if (Math.abs(x - this.myCharz().cx) < 24) {
                        if (x > this.myCharz().cx) {
                            x = Util.gI().nextInt(this.myCharz().cx + 24, this.myCharz().cx + 48);
                        } else {
                            x = Util.gI().nextInt(this.myCharz().cx - 24, this.myCharz().cx - 48);
                        }
                    }
                    this.myCharz().zoneMap.join(this.myPetz(), 0, x, this.myCharz().cy);
                }
            }
            
            //Tan cong lau lau go me
            if (this.myPetz().isInMap && !this.myPetz().isStand() && !this.myPetz().isCharge && this.myPetz().petStatus != 2 && Util.gI().nextInt(1000) < 1) {
                this.myPetz().goMe();
            }
            if (!this.myPetz().isCharge && !this.myPetz().gong && this.myPetz().timeLoadSkill <= 0) {
                for (int i = this.myPetz().skills.size() - 1; i >= 0; --i) {
                    Skill skill = this.myPetz().skills.get(i);
                    if (((skill.isChuong() || skill.isDonDanh())) || (skill.lastTimeUseThisSkill < System.currentTimeMillis() && (skill.template.id != 8 || (100f / (float)this.myPetz().cHPFull * (float)this.myPetz().cHP <= 10 || 100f / (float)this.myPetz().cMPFull * (float)this.myPetz().cMP <= 10)))) {
                        int manaUse = skill.manaUse;
                        if (skill.template.manaUseType == 1) {
                            manaUse = (int)((long)this.myPetz().cMPFull * (long)manaUse / 100);
                        }
                        if (this.myPetz().cMP >= manaUse && (skill.template.id != 9 || (skill.template.id == 9 && 100f / (float)this.myPetz().cHPFull * (float)this.myPetz().cHP > 10))) {
                            this.myPetz().mySkill = skill;
                            break;
                        }

                    }
                }
            }
            if ((this.myPetz().petStatus == 1 || this.myPetz().petStatus == 2) && this.myPetz().isInMap && !this.myPetz().isStand() && this.myPetz().timeHit <= 0 && this.myPetz().timeLoadSkill <= 0 && (this.myCharz().isBuaDeTu || this.myPetz().timeDanh != 0)) {
                if (this.myPetz().cStamina <= 0) {
                    if (Math.abs(this.myPetz().cx - this.myCharz().cx) > 50 || Math.abs(this.myPetz().cy - this.myCharz().cy) > 50) {
                        this.myPetz().goMe();
                    }
                    if (!this.isCallDau) {
                        this.isCallDau = true;
                        this.myCharz().session.service.chat(this.myPetz().charID, mResources.SP_HELP);
                    }
                    if (this.myCharz().isBuaDeTu) {
                        Item itemDau = this.myCharz().getItemBagByType(6);
                        if (itemDau != null) {
                            UseItem.useItem(this.myCharz(), itemDau);
                        }
                    }
                } else {
                    Skill skillF = this.myPetz().mySkill;
                    if (skillF != null && skillF.lastTimeUseThisSkill <= System.currentTimeMillis()) {
                        int manaUse = skillF.manaUse;
                        if (skillF.template.manaUseType == 1) {
                            manaUse = (int)((long)this.myPetz().cMPFull * (long)manaUse / 100L);
                        }
                        if (this.myPetz().cMP >= manaUse) {
                            switch (skillF.template.id) {
                                case 6:
                                    this.myPetz().cStamina--;
                                    this.myPetz().skill_not_focus((byte)0, skillF);
                                    break;
                                case 8:
                                    this.myPetz().cStamina--;
                                    this.myPetz().skill_not_focus((byte)1, skillF);
                                    break;
                                case 12:
                                    this.myPetz().cStamina--;
                                    this.myPetz().skill_not_focus((byte)8, skillF);
                                    break;
                                case 13:
                                    this.myPetz().cStamina--;
                                    this.myPetz().skill_not_focus((byte)6, skillF);
                                    break;
                                case 19:
                                    this.myPetz().cStamina--;
                                    this.myPetz().skill_not_focus((byte)9, skillF);
                                    break;
                                default:
                                    this.myPetz().aMobFocus.clear();
                                    this.myPetz().aCharFocus.clear();
                                    if (this.myPetz().charFocus != null && this.myPetz().isMeCanAttackOtherPlayer(this.myPetz().charFocus)) {
                                        this.myPetz().aCharFocus.add(this.myPetz().charFocus);
                                    } else {
                                        if (this.myPetz().charFocus != null) {
                                            this.myPetz().charFocus = null;
                                        }
                                        if (this.myPetz().mobFocus != null && !this.myPetz().mobFocus.isDie) {
                                            this.myPetz().aMobFocus.add(this.myPetz().mobFocus);
                                        }
                                        Mob goMob = null;
                                        synchronized (this.myPetz().zoneMap.mobs) {
                                            for (int i2 = 0; i2 < this.myPetz().zoneMap.mobs.size(); i2++) {
                                                if (this.myPetz().aMobFocus.size() >= skillF.maxFight) {
                                                    break;
                                                }
                                                if (!this.myPetz().zoneMap.mobs.get(i2).isDie && !this.myPetz().zoneMap.mobs.get(i2).isMobMe) {
                                                    if ((this.myPetz().petStatus == 2) || (this.myPetz().petStatus == 1 && Math.abs(this.myCharz().cx - this.myPetz().zoneMap.mobs.get(i2).pointx) <= 125 && Math.abs(this.myCharz().cy - this.myPetz().zoneMap.mobs.get(i2).pointy) <= 125)) {
                                                        if ((Math.abs(this.myPetz().zoneMap.mobs.get(i2).pointx - this.myPetz().cx) > skillF.dx || Math.abs(this.myPetz().zoneMap.mobs.get(i2).pointy - this.myPetz().cy) > skillF.dy) ) {
                                                            goMob = this.myPetz().zoneMap.mobs.get(i2);
                                                            this.myPetz().cx = goMob.pointx;
                                                            this.myPetz().cy = goMob.pointy;
                                                        }
                                                    }
                                                    if (Math.abs(this.myPetz().cx - this.myPetz().zoneMap.mobs.get(i2).pointx) <= skillF.dx && Math.abs(this.myPetz().cy - this.myPetz().zoneMap.mobs.get(i2).pointy) <= skillF.dy) {
                                                        this.myPetz().aMobFocus.add(this.myPetz().zoneMap.mobs.get(i2));
                                                    }
                                                }
                                            }
                                        }
                                        if (goMob != null) {
                                            this.myPetz().addMove(0, goMob.pointx, goMob.pointy, 0);
                                        }
                                    }
                                    if (this.myPetz().aMobFocus.size() > 0 || this.myPetz().aCharFocus.size() > 0) {
                                        if (this.myPetz().aMobFocus.size() > 0) {
                                            if (skillF.dx < 50 || skillF.dy < 50) {
                                                this.myPetz().addMove(0, Util.gI().nextInt(this.myPetz().aMobFocus.get(0).pointx - skillF.dx, this.myPetz().aMobFocus.get(0).pointx + skillF.dx), this.myPetz().aMobFocus.get(0).pointy, 0);
                                            }
                                            if (skillF.isChuong() && Math.abs(this.myPetz().cx - this.myPetz().aMobFocus.get(0).pointx) < 100) {
                                                if (this.myPetz().cx > this.myPetz().aMobFocus.get(0).pointx) {
                                                    this.myPetz().addMove(0, this.myPetz().aMobFocus.get(0).pointx + 120, -1, 0);
                                                } else {
                                                    this.myPetz().addMove(0, this.myPetz().aMobFocus.get(0).pointx - 120, -1, 0);
                                                }
                                            }
                                        }
                                        if (this.myPetz().aCharFocus.size() > 0) {
                                            if (skillF.dx < 50 || skillF.dy < 50) {
                                                this.myPetz().addMove(0, Util.gI().nextInt(this.myPetz().aCharFocus.get(0).cx - skillF.dx, this.myPetz().aCharFocus.get(0).cx + skillF.dx), this.myPetz().aCharFocus.get(0).cy, 0);
                                            }
                                            if (skillF.isChuong() && Math.abs(this.myPetz().cx - this.myPetz().aCharFocus.get(0).cx) < 100) {
                                                if (this.myPetz().cx > this.myPetz().aCharFocus.get(0).cx) {
                                                    this.myPetz().addMove(0, this.myPetz().aCharFocus.get(0).cx + 120, -1, 0);
                                                } else {
                                                    this.myPetz().addMove(0, this.myPetz().aCharFocus.get(0).cx - 120, -1, 0);
                                                }
                                            }
                                        }
                                        this.myPetz().cStamina--;
                                        this.myPetz().Attack(skillF, this.myPetz().aMobFocus, this.myPetz().aCharFocus, 1);
                                    }
                                    break;
                            }
                        }
                    }
                }
                this.timeHit = 100;
            }
        }
        if (this.isDie && this.timeHS <= System.currentTimeMillis() / 1000) {
            this.timeHS = 0;
            this.liveFromDead(2);
        }
        if (this.petStatus == 3) {
            this.timeVeNha -= this.delay;
            if (this.timeVeNha <= 0) {
                this.timeVeNha = 0;
                if (this.zoneMap != null) {
                    this.zoneMap.exit(this, 0);
                    this.zoneMap = null;
                }
            }
        }
        if (this.timeHopThe > 0) {
            this.timeHopThe -= this.delay;
            if (this.timeHopThe <= 0) {
                this.timeHopThe = 0;
            }
        }
        if (this.petStatus == 4 && this.isHopThe == 0) {
            this.petStatus = 0;
        }
        if (this.tupPotential > 0) {
            this.tupPotential -= this.delay;
            if (this.tupPotential <= 0) {
                this.upPotentialPet();
            }
        }
        if (this.timeDanh > 0) {
            this.timeDanh -= this.delay;
            if (this.timeDanh <= 0) {
                this.myCharz().session.service.chat(this.charID, mResources.SP_DANH_DI);
                this.timeDanh = 0;
            }
        }
    }
    
    private void updateItemBody() {
        for (int i = 0; i < this.arrItemBody.length; i++) {
            Item item = this.arrItemBody[i];
            if (item != null && item.expires != -1) {
                int expires_day = (int)((item.expires - System.currentTimeMillis()) / 86400000L);
                if (expires_day > 0) {
                    if (item.isHaveOption(93)) {
                        ItemOption option2 = item.getOption(93);
                        if (option2.param != expires_day) {
                            option2.param = expires_day;
                            if (this.session != null) {
                            this.session.service.Body(this.head, this.arrItemBody);
                            this.session.service.Bag(this.arrItemBag);
                                this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            }
                        }
                    }
                } else {
                    this.arrItemBody[i] = null;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.Bag(this.arrItemBag);
                        this.session.service.meLoadPoint();
                        this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    }
                    this.zoneMap.playerLoadAll(this);

                    if (!this.me && this.myCharz() != null) {
                        this.myCharz().updateAll();
                        if (this.myCharz().session != null) {
                            this.myCharz().session.service.meLoadPoint();
                        }
                        if (this.myCharz().zoneMap != null) {
                            this.myCharz().zoneMap.playerLoadAll(this.myCharz());
                        }
                    }
                }
            }
        }
    }
    
    private void updateItemBag() {
        for (int i = 0; i < this.arrItemBag.length; i++) {
            Item item = this.arrItemBag[i];
            if (item != null && item.expires != -1) {
                int expires_day = (int)((item.expires - System.currentTimeMillis()) / 86400000L);
                if (expires_day > 0) {
                    if (item.isHaveOption(93)) {
                        ItemOption option2 = item.getOption(93);
                        if (option2.param != expires_day) {
                            option2.param = expires_day;
                            if (this.session != null) {
                                this.session.service.Body(this.head, this.arrItemBody);
                                this.session.service.Bag(this.arrItemBag);
                                this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            }
                        }
                    }
                } else {
                    this.arrItemBag[i] = null;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.Bag(this.arrItemBag);
                        this.session.service.meLoadPoint();
                        this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
    }
    
    private void updateItemBox() {
        for (int i = 0; i < this.arrItemBox.length; i++) {
            Item item = this.arrItemBox[i];
            if (item != null && item.expires != -1) {
                int expires_day = (int)((item.expires - System.currentTimeMillis()) / 86400000L);
                if (expires_day > 0) {
                    if (item.isHaveOption(93)) {
                        ItemOption option2 = item.getOption(93);
                        if (option2.param != expires_day) {
                            option2.param = expires_day;
                            if (this.session != null) {
                                this.session.service.Body(this.head, this.arrItemBody);
                                this.session.service.Bag(this.arrItemBag);
                                this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            }
                        }
                    }
                } else {
                    this.arrItemBox[i] = null;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.Bag(this.arrItemBag);
                        this.session.service.meLoadPoint();
                        this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
    }
    
    private void updateItems() {
        for (int i = this.items.size() - 1; i >= 0; --i) {
            Item item = this.items.get(i);
            if (item != null && item.expires != -1) {
                int expires_day = (int)((item.expires - System.currentTimeMillis()) / 86400000L);
                if (expires_day > 0) {
                    if (item.isHaveOption(93)) {
                        ItemOption option2 = item.getOption(93);
                        if (option2.param != expires_day) {
                            option2.param = expires_day;
                            if (this.session != null) {
                                this.session.service.Body(this.head, this.arrItemBody);
                                this.session.service.Bag(this.arrItemBag);
                                this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            }
                        }
                    }
                } else {
                    this.items.remove(i);
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.Bag(this.arrItemBag);
                        this.session.service.meLoadPoint();
                        this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
    }
    
    private void updateItemMore() {
        for (int i = this.arrItemMore.size() - 1; i >= 0; --i) {
            Item item = this.arrItemMore.get(i);
            if (item != null && item.expires != -1) {
                int expires_day = (int)((item.expires - System.currentTimeMillis()) / 86400000L);
                if (expires_day > 0) {
                    if (item.isHaveOption(93)) {
                        ItemOption option2 = item.getOption(93);
                        if (option2.param != expires_day) {
                            option2.param = expires_day;
                            if (this.session != null) {
                                this.session.service.Body(this.head, this.arrItemBody);
                                this.session.service.Bag(this.arrItemBag);
                                this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            }
                        }
                    }
                } else {
                    this.arrItemMore.remove(i);
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.Bag(this.arrItemBag);
                        this.session.service.meLoadPoint();
                        this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        for (int i = this.arrItemMore2.size() - 1; i >= 0; --i) {
            Item item = this.arrItemMore2.get(i);
            if (item != null && item.expires != -1) {
                int expires_day = (int)((item.expires - System.currentTimeMillis()) / 86400000L);
                if (expires_day > 0) {
                    if (item.isHaveOption(93)) {
                        ItemOption option2 = item.getOption(93);
                        if (option2.param != expires_day) {
                            option2.param = expires_day;
                            if (this.session != null) {
                                this.session.service.Body(this.head, this.arrItemBody);
                                this.session.service.Bag(this.arrItemBag);
                                this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            }
                        }
                    }
                } else {
                    this.arrItemMore2.remove(i);
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.Bag(this.arrItemBag);
                        this.session.service.meLoadPoint();
                        this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
    }
    
    private void updateBlackBall() {
        //Thoi gian ngoc rong sao den
        this.timeBlackBall -= this.delay;
        this.timeChatWinBlackBall -= this.delay;
        if (timeChatWinBlackBall <= 0) {
            this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.DELAY_WIN_NRSD, this.timeBlackBall / 1000), null, 0);
            timeChatWinBlackBall = 10000;
        }
        if (this.timeBlackBall <= 0 || BlackBall.gI().isWinAll) {
            this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.NRSD_WIN_TO_CLAN, this.itemBlackBall.template.name), null, 0);
            this.zoneMap.isWinBlackBall = true;
            this.addItemBlackBall(this.itemBlackBall);
            this.throwBlackBall();
            this.zoneMap.pushPlayers(0);
        }
    }
    
    private void updateMapClan() {
        //Ra khoi lanh dia
        if (this.zoneMap != null && this.mapTemplateId == 153 && this.cx <= 35 && this.cy <= 400 && this.me && !this.isTemplate) {
            Map vodis_ = Map.getMapServer(5);
            if (vodis_ != null) {
                ZoneMap ureit_ = vodis_.getZone(this);
                if (ureit_ != null) {
                    this.zoneMap.exit(this, 0);
                    ureit_.join(this, 0, 1090, 408);
                } else {
                    this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                }
            }
        }
    }
    
    public boolean checkBag(Item item) {
        int indexUI = this.getItemBagIndex(item);
        if (indexUI == -1) {
            indexUI = this.getEmptyBagIndex();
        }
        return (indexUI != -1 && (this.arrItemBag[indexUI] == null || (this.arrItemBag[indexUI].quantity + item.quantity <= item.maxQuantity()) || (item.isBigItem() && this.totalBagByItem(item) >= item.quantity) || (item.isItemSLL() && this.arrItemBag[indexUI].getParamOption(31) + item.getParamOption(31) <= 30000))) || item.template.id == 74 || item.template.id == 453 || item.template.id == 516  || item.template.id == 568 || item.template.type == 9 || item.template.type == 10 || item.template.type == 34 || item.isItemBlackBall() || item.isItemNamekBall() || (this.isHaveItem(item.template.id) && item.template.id == 521) || item.template.id == 517 || item.template.id == 518;
    }
    
    private void updateStab() {
        this.tStab -= this.delay;
        if (this.tStab <= 0) {
            this.tStab = 1000;
            if ((this.zoneMap.mapTemplate.tileAt(this.cx / 24, this.cy / 24) == 25 || this.zoneMap.mapTemplate.tileAt(this.cx / 24, this.cy / 24) == 33)) {
                this.stab();
            }
        }
    }
    
    private void updateGoHome() {
        this.tToHome -= this.delay;
        if (this.tToHome <= 0) {
            this.tToHome = 0;
            Map map = this.getMapOffline(this.mainHome());
            if (map != null) {
                ZoneMap zone = map.getZone(this);
                if (zone != null) {
                    this.zoneMap.exit(this, this.typeTeleport);
                    zone.join(this, this.typeTeleport, 350, 5);
                    if (this.isDie) {
                        this.liveFromDead(2);
                    }
                } else {
                    this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                }
            }
        } else if (this.tToHome / 1000 > 0 && (this.tToHome / 1000) % 10 == 0) {
            this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.GO_HOME_AFTER, this.tToHome / 1000), null, 0);
        }
    }
    
    public void setMountIsStart() {
        this.isHaveMount = this.checkHaveMount();
        if (this.mapTemplateId == 112 || this.mapTemplateId == 113 || this.mapTemplateId == 51 || this.mapTemplateId == 103) {
            this.isHaveMount = false;
        }
    }
    
    public boolean isExistItem(int id) {
        for (int i = 0; i < this.itemTime.size(); i++) {
            ItemTime itemTime2 = this.itemTime.get(i);
            if ((int)itemTime2.idIcon == id) {
                return true;
            }
        }
        return false;
    }
    
    public ItemTime getItemById(int id) {
        for (int i = 0; i < this.itemTime.size(); i++) {
            ItemTime itemTime2 = this.itemTime.get(i);
            if ((int)itemTime2.idIcon == id) {
                return itemTime2;
            }
        }
        return null;
    }
    
    public void setItem(int iconId, int second, int type, int damage) {
        if (second < 0) {
            mLog.log("Item time bi am="+second+" iconId="+iconId);
        }
        Util.gI().log("ItemTime iconId = "+iconId);
        if (this.isExistItem(iconId)) {
            this.getItemById(iconId).initTime(second, type, damage);
        } else {
            ItemTime o = new ItemTime((short)iconId, second, type, damage);
            this.itemTime.add(o);
            //Co phai tac dung bang item khong
            //Huyt sao
            if (iconId == 3781) {
                if (this.cMPFull < 2000000000) {
                    this.hold(1, second * 1000, 39, -1, -1);
                    this.huytSaoHP = damage;
                    this.cHP = (int)(this.cHP + ((long)this.cHPFull * (long)damage / 100L));
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    if (this.zoneMap != null) {
                        this.zoneMap.playerLoadAll(this);
                    }
                }
            }
            if (iconId == 3784) {
                if (second > 0) {
                    this.hold(1, second * 1000, 33, -1, -1);
                } else {
                    if (this.session != null) {
                        this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.PROTECTED_BROKEN, null, (byte)0);
                    }
                }
            }
            //Tu dong luyen tap
            if (iconId == 4387) {
                this.canAutoPlay = second > 0;
                if (this.session != null) {
                    if (second > 0) {
                        this.session.service.autoPlay(1);
                    } else {
                        this.session.service.autoPlay(0);
                    }
                }
            }
            //Cuong no
            if (iconId == 2754) {
                this.isCuongNo = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Bo huyet
            if (iconId == 2755) {
                this.isBoHuyet = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
            //Bo khi
            if (iconId == 2756) {
                this.isBoKhi = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Giap xen bo hung
            if (iconId == 2757) {
                this.isXenBoHung = true;
            }
            //An danh
            if (iconId == 2760) {
                this.isAnDanh = true;
            }
            //Cuong no 2
            if (iconId == 10716) {
                this.isCuongNo2 = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Bo huyet 2
            if (iconId == 10714) {
                this.isBoHuyet2 = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
            //Bo khi 2
            if (iconId == 10715) {
                this.isBoKhi2 = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Giap xen bo hung 2
            if (iconId == 10712) {
                this.isXenBoHung2 = true;
            }
            //Hop the
            if (iconId == 3790 || iconId == 3901) {
                if (this.myPet == null) {
                    o.second = 0;
                } else {
                    this.myPetz().petStatus = 4;
                    this.myPetz().isHopThe = 1;
                    this.updateAll();
                    this.cHP = this.cHPFull + this.myPetz().cHPFull;
                    this.cMP = this.cMPFull + this.myPetz().cMPFull;
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    if (this.zoneMap != null) {
                        this.zoneMap.playerLoadAll(this);
                        this.zoneMap.updateBody(this, 0);
                    }
                }
            }
            //Thuc an
            if (iconId == 6324 || iconId == 6325 || iconId == 6326 || iconId == 6327 || iconId == 6328) {
                this.isThucAn = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Hoa da
            if (iconId == 4392) {
                this.stone = 1;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.stoneMe(this.charID, this.stone);
                }
                if (this.zoneMap != null) {
                    this.zoneMap.updateBody(this, 1);
                }
            }
            //Bien socola
            if (iconId == 4133) {
                this.isSocola = true;
                this.updateAll();
                if (this.zoneMap != null) {
                    this.zoneMap.updateBody(this, 1);
                }
            }
            //Bien Ca rot
            if (iconId == 4082) {
                this.isCarrot = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.updateBody(this, 1);
                }
            }
            //Chuot canh ty
            if (iconId == 6314) {
                this.setPetFollow(7094, -1, null, 0, 0, second);
            }
            //Tinh linh
            if (iconId == 6535) {
                this.setPetFollow(6536, -1, null, 0, 0, second);
            }
            //Yeu tinh
            if (iconId == 6537) {
                this.setPetFollow(6538, -1, null, 0, 0, second);
            }
            //Ac linh
            if (iconId == 6539) {
                this.setPetFollow(6540, -1, null, 0, 0, second);
            }
            //Keo mot mat
            if (iconId == 8243) {
                this.isKeoOneEye = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Sup hac am
            if (iconId == 8244) {
                this.isSupDark = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Banh gato nhen
            if (iconId == 8246) {
                this.isGatoSpider = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Hamberger sau
            if (iconId == 8247) {
                this.isHumbergerWorm = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
            //Xi muoi dao
            if (iconId == 10905) {
                this.isXiMuoiDao = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
            //Xi muoi mai
            if (iconId == 10904) {
                this.isXiMuoiMai = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
            //Binh Commeson
            if (iconId == 5829) {
                this.isCommeson = true;
            }
            //ma phong ba
            if (iconId == 11183 || iconId == 11192 || iconId == 11173) {
                this.isMaPhongBa1 = true;
                this.updateAll();
                if (this.zoneMap != null) {
                    this.zoneMap.updateBody(this, 1);
                }
            }
            //Dong bang
            if (iconId == 11085) {
                this.stone = 2;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.stoneMe(this.charID, this.stone);
                }
                if (this.zoneMap != null) {
                    this.zoneMap.updateBody(this, 1);
                }
            }
            //Cai lo
            if (iconId == 11184) {
                this.isMaPhongBa2 = 1;
            }
            //Noi com
            if (iconId == 11166) {
                this.isMaPhongBa2 = 2;
            }
            //Cua rang me
            if (iconId == 8060) {
                this.isFood1 = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
            //Bach tuoc nuong
            if (iconId == 8061) {
                this.isFood2 = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
            //Tom tam bot chien xu
            if (iconId == 8062) {
                this.isFood3 = true;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
            //Bon tam go
            if (iconId == 11250) {
                this.hold(1, second * 1000, 40, -1, -1);
                if (this.zoneMap != null) {
                    this.zoneMap.addEffectServer(30, 3, 208, this.cx, this.cy + 30, 1);
                }
            }
            //Bon tam vang
            if (iconId == 11251) {
                this.hold(1, second * 1000, 40, -1, -1);
                if (this.zoneMap != null) {
                    this.zoneMap.addEffectServer(30, 3, 209, this.cx, this.cy + 30, 1);
                }
            }
            //May do linh hon
            if (iconId == 11493) {
            	this.isMayDoLinhHon = true;
            }
        }
        if (this.session != null) {
            this.session.service.itemTime(iconId, second);
        }
    }
    
    private void updateItemTime() {
        this.timeItemTime -= this.delay;
        if (this.timeItemTime <= 0) {
            this.timeItemTime = 1000;
            for (int i = this.itemTime.size() - 1; i >= 0; --i) {
                this.itemTime.get(i).second--;
                if (this.itemTime.get(i).second <= 0) {
                    //Huyt sao
                    if (this.itemTime.get(i).idIcon == 3781) {
                        if (this.huytSao) {
                            this.hold(0, 0, 39, -1, -1);
                        }
                        this.huytSaoHP = 0;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    if (this.itemTime.get(i).idIcon == 3784) {
                        if (this.protectEff) {
                            this.hold(0, 0, 33, -1, -1);
                        }
                    }
                    //Tu dong luyen tap
                    if (this.itemTime.get(i).idIcon == 4387) {
                        this.canAutoPlay = false;
                        if (this.session != null) {
                            this.session.service.autoPlay(0);
                        }
                    }
                    //Cuong no
                    if (this.itemTime.get(i).idIcon == 2754) {
                        this.isCuongNo = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Bo huyet
                    if (this.itemTime.get(i).idIcon == 2755) {
                        this.isBoHuyet = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    //Bo khi
                    if (this.itemTime.get(i).idIcon == 2756) {
                        this.isBoKhi = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Giap xen bo hung
                    if (this.itemTime.get(i).idIcon == 2757) {
                        this.isXenBoHung = false;
                    }
                    //An danh
                    if (this.itemTime.get(i).idIcon == 2760) {
                        this.isAnDanh = false;
                    }
                    //Cuong no 2
                    if (this.itemTime.get(i).idIcon == 10716) {
                        this.isCuongNo2 = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Bo huyet 2
                    if (this.itemTime.get(i).idIcon == 10714) {
                        this.isBoHuyet2 = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    //Bo khi 2
                    if (this.itemTime.get(i).idIcon == 10715) {
                        this.isBoKhi2 = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Giap xen bo hung 2
                    if (this.itemTime.get(i).idIcon == 10712) {
                        this.isXenBoHung2 = false;
                    }
                    //Hop the
                    if ((this.itemTime.get(i).idIcon == 3790 || this.itemTime.get(i).idIcon == 3901) && this.myPet != null) {
                        this.myPetz().petStatus = 1;
                        this.myPetz().isHopThe = 0;
                        this.myPetz().timeHopThe = 1000 * 60;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.setFusion(1, this.charID);
                            this.zoneMap.playerLoadAll(this);
                            this.zoneMap.updateBody(this, 0);
                        }
                    }

                    //Thuc an
                    if (this.itemTime.get(i).idIcon == 6324 || this.itemTime.get(i).idIcon == 6325 || this.itemTime.get(i).idIcon == 6326 || this.itemTime.get(i).idIcon == 6327 || this.itemTime.get(i).idIcon == 6328) {
                        this.isThucAn = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Hoa da
                    if (this.itemTime.get(i).idIcon == 4392) {
                        this.stone = 0;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.stoneMe(this.charID, this.stone);
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.updateBody(this, 1);
                        }
                    }
                    //Bien socola
                    if (this.itemTime.get(i).idIcon == 4133) {
                        this.isSocola = false;
                        this.updateAll();
                        if (this.zoneMap != null) {
                            this.zoneMap.updateBody(this, 1);
                        }
                    }
                    //Bien Ca rot
                    if (this.itemTime.get(i).idIcon == 4082) {
                        this.isCarrot = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.updateBody(this, 1);
                        }
                    }
                    //Keo mot mat
                    if (this.itemTime.get(i).idIcon == 8243) {
                        this.isKeoOneEye = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Sup hac am
                    if (this.itemTime.get(i).idIcon == 8244) {
                        this.isSupDark = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Banh gato nhen
                    if (this.itemTime.get(i).idIcon == 8246) {
                        this.isGatoSpider = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Hamberger sau
                    if (this.itemTime.get(i).idIcon == 8247) {
                        this.isHumbergerWorm = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                    }
                    //Xi muoi dao
                    if (this.itemTime.get(i).idIcon == 10905) {
                        this.isXiMuoiDao = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    //Xi muoi mai
                    if (this.itemTime.get(i).idIcon == 10904) {
                        this.isXiMuoiMai = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    //Binh Commeson
                    if (this.itemTime.get(i).idIcon == 5829) {
                        this.isCommeson = false;
                    }
                    //ma phong ba
                    if (this.itemTime.get(i).idIcon == 11183 || this.itemTime.get(i).idIcon == 11192 || this.itemTime.get(i).idIcon == 11173) {
                        this.isMaPhongBa1 = false;
                        this.updateAll();
                        if (this.zoneMap != null) {
                            this.zoneMap.updateBody(this, 1);
                        }
                    }
                    //Dong bang
                    if (this.itemTime.get(i).idIcon == 11085) {
                        this.stone = 0;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.stoneMe(this.charID, this.stone);
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.updateBody(this, 1);
                        }
                    }
                    //Cai lo
                    if (this.itemTime.get(i).idIcon == 11184) {
                        this.isMaPhongBa2 = 0;
                    }
                    //Noi com
                    if (this.itemTime.get(i).idIcon == 11166) {
                        this.isMaPhongBa2 = 0;
                    }
                    //Cua rang me
                    if (this.itemTime.get(i).idIcon == 8060) {
                        this.isFood1 = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    //Bach tuoc nuong
                    if (this.itemTime.get(i).idIcon == 8061) {
                        this.isFood2 = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    //Tom tam bot chien xu
                    if (this.itemTime.get(i).idIcon == 8062) {
                        this.isFood3 = false;
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    //Bon tam go
                    if (this.itemTime.get(i).idIcon == 11250) {
                        this.bathWoodGift();
                    }
                    //Bon tam vang
                    if (this.itemTime.get(i).idIcon == 11251) {
                        this.bathGoldGift();

                    }
                    //May do linh hon
                    if (this.itemTime.get(i).idIcon == 11493) {
                    	this.isMayDoLinhHon = false;
                    }
                    //_________________________
                    //Item
                    if (this.itemTime.get(i).item != null) {
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                            this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            this.session.service.getBag(this.charID, this.bag);
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                    this.itemTime.remove(i);
                }
            }
        }
    }
    
    public void setItem(int iconId, int second, int type, Item item) {
        if (second < 0) {
            mLog.log("Item time bi am="+second+" iconId="+type);
        }
        Util.gI().log("ItemTime iconId = "+iconId);
        if (this.isExistItem(iconId)) {
            this.getItemById(iconId).initTime(second, type, 0);
            this.getItemById(iconId).item = item;
        } else {
            ItemTime o = new ItemTime((short)iconId, second, type, 0);
            o.item = item;
            this.itemTime.add(o);
        }
        this.updateAll();
        if (this.session != null) {
            this.session.service.itemTime(iconId, second);
            this.session.service.meLoadPoint();
            this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
            this.session.service.getBag(this.charID, this.bag);
        }
        if (this.zoneMap != null) {
            this.zoneMap.playerLoadAll(this);
        }
    }
            
    public void addInfo1(String text) {
        if (this.session != null) {
            this.session.service.chatTHEGIOI("", text, null, 0);
        }
    }
    
    public void wish() {
        if (Util.gI().nextInt(100) < 20) {
            short id_34523 = new short[]{828, 829, 830, 831, 832, 833, 834, 835, 836}[Util.gI().nextInt(9)];
            this.addItemBag(0, new Item(id_34523, false, 1, ItemOption.getOption(id_34523, 0, 0), "", "", ""));
        } else if (Util.gI().nextInt(100) < 20) {
            short id_34533 = new short[]{213, 214, 215, 216, 217, 218, 219}[Util.gI().nextInt(7)];
            this.addItemBag(0, new Item(id_34533, false, 1, ItemOption.getOption(id_34533, 0, 0), "", "", ""));
        } else if (Util.gI().nextInt(100) < 20) {
            this.addItemBag(0, new Item(595, false, Util.gI().nextInt(1, 3) * 10, ItemOption.getOption(595, 0, 0), "", "", ""));
        } else if (Util.gI().nextInt(100) < 10) {
            if (this.cgender == 0) {
                Item item_496 = new Item(604, false, 1, ItemOption.getOption(604, 0, 0), "", "", "");
                item_496.options.add(new ItemOption(93, 3));
                this.addItemBag(0, item_496);
            }
            if (this.cgender == 1) {
                Item item_497 = new Item(605, false, 1, ItemOption.getOption(605, 0, 0), "", "", "");
                item_497.options.add(new ItemOption(93, 3));
                this.addItemBag(0, item_497);
            }
            if (this.cgender == 2) {
                Item item_498 = new Item(606, false, 1, ItemOption.getOption(606, 0, 0), "", "", "");
                item_498.options.add(new ItemOption(93, 3));
                this.addItemBag(0, item_498);
            }
        } else if (Util.gI().nextInt(100) < 10) {
            Item item_499 = new Item(765, false, 1, ItemOption.getOption(765, 0, 0), "", "", "");
            item_499.options.add(new ItemOption(93, 3));
            this.addItemBag(0, item_499);
        } else if (Util.gI().nextInt(100) < 5) {
            Item item_450 = new Item(591, false, 1, ItemOption.getOption(591, 0, 0), "", "", "");
            item_450.options.add(new ItemOption(93, 3));
            this.addItemBag(0, item_450);
        } else {
            this.addItemBag(0, new Item(595, false, Util.gI().nextInt(1, 3) * 10, ItemOption.getOption(595, 0, 0), "", "", ""));
        }
    }
    
    public void wish2() {
        Item item = null;
        if (Util.gI().nextInt(100) < 10) {
            short id_34523 = new short[]{828, 829, 830, 831, 832, 833, 834, 835, 836}[Util.gI().nextInt(9)];
            item = new Item(id_34523, false, 1, ItemOption.getOption(id_34523, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(100) < 10) {
            short id_34533 = new short[]{213, 214, 215, 216, 217, 218, 219}[Util.gI().nextInt(7)];
            item = new Item(id_34533, false, 1, ItemOption.getOption(id_34533, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(100) < 10) {
            item = new Item(595, false, Util.gI().nextInt(1, 3) * 10, ItemOption.getOption(595, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(100) < 10) {
            if (this.cgender == 0) {
                item = new Item(604, false, 1, ItemOption.getOption(604, 0, 0), "", "", "");
                item.options.add(new ItemOption(93, 3));
            }
            if (this.cgender == 1) {
                item = new Item(605, false, 1, ItemOption.getOption(605, 0, 0), "", "", "");
                item.options.add(new ItemOption(93, 3));
            }
            if (this.cgender == 2) {
                item = new Item(606, false, 1, ItemOption.getOption(606, 0, 0), "", "", "");
                item.options.add(new ItemOption(93, 3));
            }
        } else if (Util.gI().nextInt(100) < 10) {
            item = new Item(765, false, 1, ItemOption.getOption(765, 0, 0), "", "", "");
            item.options.add(new ItemOption(93, 3));
        } else if (Util.gI().nextInt(100) < 10) {
            short id_796 = new short[]{382, 383}[Util.gI().nextInt(2)];
            item = new Item(id_796, false, 1, ItemOption.getOption(id_796, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(100) < 10) {
            short id_9487 = new short[]{916, 917, 918}[Util.gI().nextInt(3)];
            item = new Item(id_9487, false, 1, ItemOption.getOption(id_9487, 0, 0), "", "", "");
            item.options.add(new ItemOption(93, Util.gI().nextInt(3, 14)));
        } else if (Util.gI().nextInt(100) < 10) {
            short id_349 = new short[]{465, 466}[Util.gI().nextInt(2)];
            item = new Item(id_349, false, 1, ItemOption.getOption(id_349, 0, 0), "", "", "");
            item.options.add(new ItemOption(93, 30));
        } else if (Util.gI().nextInt(100) < 10) {
            item = new Item(591, false, 1, ItemOption.getOption(591, 0, 0), "", "", "");
            item.options.add(new ItemOption(93, 3));
        } else if (Util.gI().nextInt(100) < 10) {
            item = new Item(734, false, 1, ItemOption.getOption(734, 0, 0), "", "", "");
            item.options.add(new ItemOption(93, 30));
        } else if (Util.gI().nextInt(100) < 5) {
            item  = new Item(463, false, 1, ItemOption.getOption(463, 0, 0), "", "", "");
            item.options.add(new ItemOption(93, 7));
        } else if (Util.gI().nextInt(100) < 5) {
            item = new Item(934, false, 10, ItemOption.getOption(934, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(100) < 1) {
            item = new Item(987, false, 1, ItemOption.getOption(987, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(100) < 1) {
            int id_9023845 = Util.gI().nextInt(712, 716);
            item = new Item(id_9023845, false, 1, ItemOption.getOption(id_9023845, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(300) < 1) {
            short id_9sd8 = new short[]{916, 917, 918}[Util.gI().nextInt(3)];
            item = new Item(id_9sd8, false, 1, ItemOption.getOption(id_9sd8, 0, 0), "", "", "");
        } else if (Util.gI().nextInt(300) < 1) {
            item = new Item(734, false, 1, ItemOption.getOption(734, 0, 0), "", "", "");
        } else {
            item = new Item(595, false, Util.gI().nextInt(1, 3) * 10, ItemOption.getOption(595, 0, 0), "", "", "");
        }
        if (item != null) {
            this.addItemBag(0, item);
            Rank.getRank(3).addTop(this.cName, this.head, this.headICON, this.body, this.leg, this.charID, this.pointEvent += 1, -1);
        }
    }
    
    private void updateMabu() {
        //Nuot
        if (this.isEat) {
            this.tEat -= this.delay;
            if (this.tEat <= 0) {
                this.tEat = 0;
                this.eat();
            }
        }
        //Cai bung
        if (this.belly != null) {
            this.belly.delays = delay;
            this.belly.update();
        }
        //Thoi gian boc ken
        if (this.tCocoon > 0) {
            this.tCocoon -= this.delay;
            if (this.tCocoon <= 0) {
                this.tCocoon = 0;
                this.zoneMap.setCocoon(this.charID, true);
            }
        }
        //Hut mau o ken
        if (this.belly != null) {
            this.tSuck -= this.delay;
            if (this.tSuck <= 0) {
                this.tSuck = 500;
                for (int i = 0; i < this.belly.zones.size(); i++) {
                    this.belly.zones.get(i).suckC();
                }
            }
        }
        //Nuot
        if (this.belly != null && !this.isDie && this.zoneMap != null && !this.isSuper) {
            this.tNuot -= this.delay;
            if (this.tNuot <= 0) {
                this.tNuot = 20000;
                Char charz24 = this.zoneMap.randPlayer();
                if (charz24 != null && !charz24.isDie) {
                    this.eat(charz24);
                }
            }
            for (int i2 = 0; i2 < this.belly.zones.size(); i2++) {
                this.belly.zones.get(i2).helpMe();
            }
        }
        //Bien hinh
        if (this.tBienHinh > 0) {
            this.tBienHinh -= this.delay;
            if (this.tBienHinh <= 0) {
                this.tBienHinh = 0;
                this.bienhinh();
            }
        }
        //Danh ken
        if (this.isMabuHold && this.nMabuHold <= 0) {
            this.zoneMap.setCocoon(this.charID, false);
        }
        //Skill mabu
        if (this.zoneMap != null && this.isSkillMabu && !this.isDie && !this.isFreez && !this.sleepEff && !this.holder && this.isAtt && !this.isSuper) {
            this.tUseMabu -= this.delay;
            if (this.tUseMabu <= 0) {
                if (Util.gI().nextInt(100) < 25) {
                    this.timeHit = 1000;
                    this.rock();
                } else if (Util.gI().nextInt(100) < 25) {
                    this.timeHit = 1000;
                    this.roll();
                } else if (Util.gI().nextInt(100) < 25) {
                    this.timeHit = 1000;
                    this.roll2();
                } else {
                    this.hideRun();
                }
                this.tUseMabu = 5000;
            }
        }
    }
    
    public Item getItemBagByType(int type) {
        for (int i = 0; i < this.arrItemBag.length; ++i) {
            Item item = this.arrItemBag[i];
            if (item != null && item.template.type == type) {
                return item;
            }
        }
        return null;
    }
    
    private boolean checkHaveEff_Set_Item() {
        this.idEff_Set_Item = -1;
        int level = -1;
        Item myArray[] = new Item[]{
            this.arrItemBody[0],
            this.arrItemBody[1],
            this.arrItemBody[2],
            this.arrItemBody[3],
            this.arrItemBody[4]
        };
        for (int i = 0; i < myArray.length; ++i) {
            Item item = myArray[i];
            if (item != null) {
                if (level > item.getParamOption(72) || level == -1) {
                    level = item.getParamOption(72);
                }
            } else {
                return false;
            }
        }
        if (level == 4) {
            this.idEff_Set_Item = 4;
            return true;
        }
        if (level == 5) {
            this.idEff_Set_Item = 5;
            return true;
        }
        if (level == 6) {
            this.idEff_Set_Item = 6;
            return true;
        }
        if (level == 7) {
            this.idEff_Set_Item = 7;
            return true;
        }
        if (level == 8) {
            this.idEff_Set_Item = 8;
            return true;
        }
        return false;
    }
    
    //Cho dau than
    public void clanDonate(int id) {
        ClanMessage msg = this.clan.getMsg(id);
        if (msg != null && msg.type == 1 && msg.recieve < msg.maxCap && !this.cName.equals(msg.playerName)) {
            Item item = this.getItemBagByType(6);
            if (item == null) {
                this.addInfo1(mResources.NOT_DAU_THAN);
            } else {
                Session_ME player = Server.gI().getByCName(msg.playerName);
                if (player != null && !player.myCharz().isgiaodich && player.myCharz().clan == this.clan) {
                    msg.recieve++;
                    this.clanMember.donate++;
                    player.myCharz().clanMember.receive_donate++;
                    
                    this.useItemBag(item.indexUI, 1);
                    Item item2 = item.clone();
                    item2.quantity = 1;
                    player.myCharz().addItemBag(0, item2);
                    player.myCharz().clan.setClanMember(this.clanMember);
                    this.updateArchivement(9, 1L);
                    this.clan.addMessage(msg);
                    this.clan.setClanMember(this.clanMember);
                    this.clan.setClanMember(player.myCharz().clanMember);
                }
            }
        }
    }
    
    public void setDownMove(int sc, int p) {
        this.cspeedFull = p;
        if (this.cspeedFull < 1) {
            this.cspeedFull = 1;
        }
        this.tDownSpeed = sc * 1000;
        this.session.service.meLoadPoint();
        this.zoneMap.playerLoadAll(this);
    }
    
    public void setChallenge(int playerId, int xu) {
        Char player = this.zoneMap.findCharInMap(playerId);
        if (player != null) {
            if (this.xu < xu || player.xu < xu) {
                this.addInfo1(mResources.NOT_THACH_DAU4);
                player.addInfo1(mResources.NOT_THACH_DAU4);
            } else {
                
                this.challengeCharId = playerId;
                this.totalDamage = 0;
                this.isChallenge = true;
                this.xuChallenge = xu;
                this.updateXu(-this.xuChallenge, 1);
                player.challengeCharId = this.charID;
                player.totalDamage = 0;
                player.isChallenge = true;
                player.xuChallenge = xu;
                player.updateXu(-player.xuChallenge, 1);
                Util.gI().log("start fight");
                if (this.session != null) {
                    this.session.service.updateTypePK(playerId, 3);
                    this.session.service.updateTypePK(this.charID, 3);
                }
                if (player.session != null) {
                    player.session.service.updateTypePK(this.charID, 3);
                    player.session.service.updateTypePK(player.charID, 3);
                }
            }
        }
    }
    
    public void resetYard(int dir) {
        ZoneMap zone = null;
        //Tim phong dau
        if (this.mapTemplateId == 129 && !this.zoneMap.isRace) {
            this.zoneMap.isRace = true;
            zone = this.zoneMap;
        } else {
            Map map = Map.getMapServer(129);
            if (map != null) {
                for (int i = 0; i < map.zones.size(); i++) {
                    if (!map.zones.get(i).isRace) {
                        map.zones.get(i).isRace = true;
                        this.zoneMap.exit(this, 0);
                        map.zones.get(i).join(this, 0, -1, -1);
                        zone = map.zones.get(i);
                        break;
                    }
                }
            }
        }
        //Len tran dau
        if (zone != null) {
            if (dir == 1 && this.myObj().nJoinDH23 + 1 < 4000) {
                this.myObj().nJoinDH23++;
            }
            this.setPos(313, 264, 1);
            Char bot = null;
            //Soi hec quyn
            if (this.myObj().nWinHD23 == 0) {
                bot = Player.addBoss(99, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            //O do
            if (this.myObj().nWinHD23 == 1) {
                bot = Player.addBoss(100, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            //Xinbato
            if (this.myObj().nWinHD23 == 2) {
                bot = Player.addBoss(101, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            //
            if (this.myObj().nWinHD23 == 3) {
                bot = Player.addBoss(102, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            if (this.myObj().nWinHD23 == 4) {
                bot = Player.addBoss(103, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            //Chan xu
            if (this.myObj().nWinHD23 == 5) {
                bot = Player.addBoss(104, 0, -1, -1, true, 450, 264, null, -1, -1);
                bot.isSkillFreeze = true;
                bot.isSkillOneFinger = true;
                bot.isFlyMove = true;
            }
            if (this.myObj().nWinHD23 == 6) {
                bot = Player.addBoss(105, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            if (this.myObj().nWinHD23 == 7) {
                bot = Player.addBoss(106, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            if (this.myObj().nWinHD23 == 8) {
                bot = Player.addBoss(107, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            //Thien xi hang
            if (this.myObj().nWinHD23 == 9) {
                bot = Player.addBoss(108, 0, -1, -1, true, 450, 264, null, -1, -1);
                bot.isBossMain = true;
            }
            //Liu liu
            if (this.myObj().nWinHD23 == 10) {
                bot = Player.addBoss(109, 0, -1, -1, true, 450, 264, null, -1, -1);
            }
            if (bot != null) {
                bot.fighter1 = this;
                this.fighter2 = bot;
                this.zoneMap.join(bot, 0, -1, -1);
                bot.hold(1, 9000, 40, -1, -1);
                this.hold(1, 9000, 40, -1, -1);
                //Trong tai
                if (dir == -1) {
                    this.findBossInMapById(98).addChat(0, String.format(mResources.CHAT_TRONG_TAI_0, this.cName, bot.cName));
                }
                this.findBossInMapById(98).addChat(2000, String.format(mResources.CHAT_TRONG_TAI_1, this.cName, bot.cName));
                this.findBossInMapById(98).addChat(4000, mResources.CHAT_TRONG_TAI_2);
                this.findBossInMapById(98).addChat(6000, mResources.CHAT_TRONG_TAI_3);
                this.findBossInMapById(98).addChat(8000, mResources.CHAT_TRONG_TAI_8);
                bot.addChat(8000, mResources.OK);
                this.addChat(9000, mResources.OK);
                //bat dau thach dau
                this.setChallenge(9000, bot);
                //Reset skill
                if (this.myObj().nWinHD23 == 0 || this.myObj().nWinHD23 == 2 || this.myObj().nWinHD23 == 4 || this.myObj().nWinHD23 == 6 || this.myObj().nWinHD23 == 8) {
                    this.resetSkill();
                }
            }
        } else {
            this.resetMenu();
            this.menuBoard.chat = mResources.SAY_GHI_DANH_3;
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
            this.menuBoard.openUIConfirm(23, null, null, -1);
        }
    }
    
    public void loser(int type) {
        if (this.isChallenge) {
            Char player = this.zoneMap.findCharInMap(this.challengeCharId);
            if (this.session != null) {
                this.session.service.updateTypePK(this.charID, this.cTypePk);
            }
            if (player != null) {
                if (player.session != null) {
                    if (player.xuChallenge > 0) {
                        player.updateXu(player.xuChallenge * 2, 1);
                    }
                    //Nhiem vu thanh tich danh bai nguoi khac
                    if (this.session != null) {
                        player.updateArchivement(3, 1L);
                    }
                    //Nhiem vu hang ngay danh bai nguoi khac
                    if (this.session != null && player.myObj().taskEveryday != null && player.myObj().taskEveryday.template.type == 4) {
                    	if (player.myObj().taskEveryday.addCount(1)) {
                            player.addInfo1(mResources.TAKE_GIFT3);
                    	}
                    }
                    player.session.service.updateTypePK(this.charID, this.cTypePk);
                    player.session.service.updateTypePK(player.charID, player.cTypePk);
                }
                if (this.session != null) {
                    this.session.service.updateTypePK(this.challengeCharId, player.cTypePk);
                }
                player.isChallenge = false;
                player.challengeCharId = -9999;
                player.xuChallenge = 0;
            }
            this.isChallenge = false;
            this.challengeCharId = -9999;
            this.xuChallenge = 0;
        }
        //giai dau
        if (this.mapTemplateId == 51 && this.zoneMap.isRace) {
            this.zoneMap.isRace = false;
            this.zoneMap.findBossInMapById(134).judArb(this, type);
        }
        //sieu hang
        if (this.mapTemplateId == 113 && this.zoneMap.isRace && this.playerSetChallenge != null) {
            //clear zone
            this.zoneMap.isRace = false;
            this.zoneMap.rankName1 = null;
            this.zoneMap.rankName2 = null;
            SuperRank my = SuperRank.getByname(this.cName);
            SuperRank player = SuperRank.getByname(this.playerSetChallenge.cName);
            //clear war
            my.isWar = false;
            my.strWar = null;
            player.isWar = false;
            player.strWar = null;
            
            //me chet hoi sinh dua xuong dai
            if (this.me && !this.isTemplate) {
                this.timeThachDau = 0;
                if (this.isDie) {
                    this.liveFromDead(2);
                }
                this.setPos(390, 360, 1);
                //tru diem
                if (this.myObj().nFreeTicket >= 1) {
                    this.myObj().nFreeTicket--;
                } else if (this.getLuong() >= 1) {
                    this.updateLuong(-1, 2);
                }
                this.addInfo1(mResources.LOSS_SUPER_RANK);
                this.playerSetChallenge.timeClear = 0;
            } else {
                this.playerSetChallenge.timeThachDau = 0;
                if (this.playerSetChallenge.isDie) {
                    this.playerSetChallenge.liveFromDead(2);
                }
                this.playerSetChallenge.setPos(390, 360, 1);
                //tinh top
                if (player.rank > my.rank) {
                    int t = player.rank;
                    player.rank = my.rank;
                    my.rank = t;
                }
                SuperRank.sortTop();
                this.playerSetChallenge.addInfo1(String.format(mResources.WIN_SUPER_RANK, player.rank + 1));
                this.timeClear = 0;
            }
            if (this.playerSetChallenge != null) {
                this.playerSetChallenge.playerSetChallenge = null;
            }
            this.playerSetChallenge = null;
        }
        //dai hoi vo thuat 23
        if (this.mapTemplateId == 129 && this.zoneMap.isRace && this.playerSetChallenge != null) {
            //Clear
            this.zoneMap.isRace = false;
            boolean flag = false;
            //me chet hoi sinh dua xuong dai
            if (this.me && !this.isTemplate) {
                this.timeThachDau = 0;
                if (this.isDie) {
                    this.liveFromDead(2);
                }
                this.setPos(380, 360, 1);
                //Thua roi
                this.addInfo1(mResources.LOSER_DHVT);
                this.clearFighter();
            } else {
                this.playerSetChallenge.timeThachDau = 0;
                this.playerSetChallenge.myObj().nWinHD23++;
                //Nhiem vu
                if (this.playerSetChallenge.ctaskId == 20 && this.playerSetChallenge.ctaskIndex == 1 && this.playerSetChallenge.myObj().nWinHD23 >= 2) {
                	this.playerSetChallenge.updateTask(1);
                }
                if (this.playerSetChallenge.myObj().nWinHD23 > 10) {
                    this.playerSetChallenge.setPos(380, 360, 1);
                    //Vo dich giai
                    this.playerSetChallenge.addInfo1(String.format(mResources.WINER_DHVT, this.playerSetChallenge.cName));
                } else {
                    this.playerSetChallenge.cHP = this.playerSetChallenge.cHPFull;
                    this.playerSetChallenge.cMP = this.playerSetChallenge.cMPFull;
                    if (this.playerSetChallenge.session != null) {
                        this.playerSetChallenge.session.service.meLoadPoint();
                    }
                    this.playerSetChallenge.zoneMap.playerLoadAll(this.playerSetChallenge);
                    flag = true;
                }
                this.playerSetChallenge.clearFighter();
            }
            //Clear thach dau
            if (this.playerSetChallenge != null) {
                if (flag) {
                    this.playerSetChallenge.resetYard(-1);
                } else {
                    this.playerSetChallenge.playerSetChallenge = null;
                }
            }
            this.playerSetChallenge = null;
        }
        if (this.zoneMap.isFightWish && type != 5) {
            this.zoneMap.isFightWish = false;
            if (this.fightWish1 != null) {
                LuyenTap.set(this.fightWish1);
                LuyenTap.get(this.fightWish1.cName).level++;
                LuyenTap.get(this.fightWish1.cName).last = System.currentTimeMillis();
                LuyenTap.get(this.fightWish1.cName).timeFight = (int) (System.currentTimeMillis() - this.fightWish1.lastFight);
                LuyenTap.sortTOP();
                if (this.fightWish1.isCallCumber == 0 && Util.gI().nextInt(2) == 0) {
                    this.fightWish1.callMaiAndFu();
                }
            }
            if (this.fightWish2 != null) {
                LuyenTap.set(this);
                Memory.get(this.session.userId).nFreeWish--;
                this.clearWish();
            }
        }
    }
    
    private void clearWish() {
        if (this.fightWish2 != null) {
            this.fightWish2.zoneMap.exit(this.fightWish2, 0);
            if (this.fightWish2.fightWish1 != null) {
                this.fightWish2.fightWish1 = null;
            }
            this.fightWish2 = null;
        }
//        if (this.fightWish1 != null) {
//            if (this.fightWish1.fightWish2 != null) {
//                this.fightWish1.fightWish2.zoneMap.hideNpc(56, false);
//                this.fightWish1.fightWish2.zoneMap.exit(this.fightWish1.fightWish2, 0);
//                this.fightWish1.fightWish2 = null;
//            }
//            this.fightWish1 = null;
//        }
    }
    
    public void judArb(Char player, int type) {
        this.isArb2 = false;
        Char player1 = this.arbPlayer1 == player ? this.arbPlayer1 : this.arbPlayer2 == player ? this.arbPlayer2 : null;
        Char player2 = this.arbPlayer1 != player ? this.arbPlayer1 : this.arbPlayer2 != player ? this.arbPlayer2 : null;
        if (player1 != null) {
            DaiHoi.removeFighter(player1.playerId);
        }
        if (player2 != null) {
            if (DaiHoi.priceNgoc > 0) {
                player2.updateLuong(DaiHoi.priceNgoc, 2);
                player2.addInfo1(1000, String.format(mResources.PRIZE_NGOC, DaiHoi.priceNgoc));
            }
            if (DaiHoi.priceVang > 0) {
                player2.updateXu(DaiHoi.priceVang, 2);
                player2.addInfo1(1000, String.format(mResources.PRIZE_VANG, DaiHoi.priceVang));
            }
            player2.addQuaGiaiDau();
        }
        if (type == 1 || type == 5) {
            if (player2 != null) {
                this.addChat(0, String.format(mResources.CHAT_NEXT_TURN1, player2.cName));
                player2.addInfo1(mResources.NEXT_TURN3);
            }
        }
        if (type == 2) {
            if (player2 != null) {
                this.addChat(0, String.format(mResources.CHAT_NEXT_TURN2, player2.cName));
                player2.addInfo1(mResources.NEXT_TURN4);
            }
        }
        if (type == 3) {
            if (player2 != null) {
                this.addChat(0, String.format(mResources.CHAT_NEXT_TURN3, player2.cName));
                player2.addInfo1(mResources.NEXT_TURN5);
            }
        }
        if (type == 4) {
            if (player2 != null) {
                this.addChat(0, String.format(mResources.CHAT_NEXT_TURN4, player2.cName));
                player2.addInfo1(mResources.NEXT_TURN6);
            }
        }
        //Ket thuc
        if (player1 != null) {
            player1.timeOutPrize = 5000;
            player1.winOutPrize = true;
            player1.setAutoXY(false, player1.cx, player1.cy, 0);
        }
        if (player2 != null) {
            player2.timeOutPrize = 5000;
            player2.winOutPrize = false;
            player2.setAutoXY(false, player2.cx, player2.cy, 0);
        }
        if (DaiHoi.sizeFighter() == 1) {
            if (player2 != null) {
                this.addChat(1000, String.format(mResources.CHAT_NEXT_TURN5, player2.cName));
                player2.addInfo1(mResources.NEXT_TURN7);
                Server.gI().chatInfo(String.format(mResources.CHAT_VODICH_GIAI_DAU, player2.cName, DaiHoi.name));
            }
            DaiHoi.win();
        }
    }
    
    public void addQuaGiaiDau() {
//        //qua qua cac vong
//        this.addItemBag(0, new Item(587, false, 1, ItemOption.getOption(587, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
//        if (DaiHoi.sizeFighter() == 1) {
//            //qua vo dich
//            this.addItemBag(0, new Item(586, false, 1, ItemOption.getOption(586, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
//        }
    }
    
    public void arb2(Char player1, Char player2, int nArb) {
        this.arbPlayer1 = player1;
        this.arbPlayer2 = player2;
        this.tArb = 0;
        this.nArb = nArb;
        this.isArb2 = true;
    }
    
    private void updateArb() {
        if (this.isArb2) {
            this.tArb -= this.delay;
            if (this.tArb <= 0) {
                switch (this.nArb) {
                    case 0:
                        this.nArb = 1;
                        this.tArb = 2000;
                        break;
                    case 1:
                        this.nArb = 2;
                        this.tArb = 2000;
                        this.zoneMap.chat(this, String.format(mResources.CHAT_TRONG_TAI_4, this.arbPlayer1.cName, this.arbPlayer2.cName));
                        break;
                    case 2:
                        this.nArb = 3;
                        this.tArb = 2000;
                        this.zoneMap.chat(this, mResources.CHAT_TRONG_TAI_2);
                        break;
                    case 3:
                        this.nArb = 4;
                        this.tArb = 2000;
                        this.zoneMap.chat(this, mResources.CHAT_TRONG_TAI_3);
                        break;
                    case 4:
                        this.nArb = 5;
                        this.tArb = 1000;
                        this.zoneMap.chat(this, mResources.CHAT_TRONG_TAI_5);
                        break;
                    case 5:
                        this.nArb = 6;
                        this.tArb = 1000;
                        this.zoneMap.chat(this, mResources.CHAT_TRONG_TAI_6);
                        break;
                    case 6:
                        this.nArb = 7;
                        this.tArb = 1000;
                        this.zoneMap.chat(this, mResources.CHAT_TRONG_TAI_7);
                        break;
                    case 7:
                        this.nArb = 8;
                        this.tArb = 60000;
                        this.arbPlayer1.setAutoXY(true, 300, 312, 5000);
                        this.arbPlayer2.setAutoXY(true, 480, 312, 5000);
                        this.arbPlayer1.setChallenge(this.arbPlayer2.charID, 0);
                        break;
                    case 8:
                        this.isArb2 = false;
                        if (this.arbPlayer1.totalDamage > this.arbPlayer2.totalDamage) {
                            this.arbPlayer2.loser(4);
                        } else {
                            this.arbPlayer1.loser(4);
                        }
                        break;
                }
            }
        }
    }
    
    private void updateTimeChat() {
        if (this.isClearChat) {
            this.isClearChat = false;
            this.aChat.clear();
        } else {
            for (int i = this.aChat.size() - 1; i >= 0; i--) {
                this.aChat.get(i).time -= this.delay;
                if (this.aChat.get(i).time <= 0) {
                    if (this.zoneMap != null) {
                        this.zoneMap.chat(this, this.aChat.get(i).chat);
                    }
                    this.aChat.remove(i);
                }
            }
        }
    }
    
    private void updateTimeInfo1() {
        for (int i = this.aInfo1.size() - 1; i >= 0; i--) {
            this.aInfo1.get(i).time -= this.delay;
            if (this.aInfo1.get(i).time <= 0) {
                this.addInfo1(this.aInfo1.get(i).chat);
                this.aInfo1.remove(i);
            }
        }
    }
    
    public void addChat(int time, String text) {
        TimeChat o = new TimeChat();
        o.time = time;
        o.chat = text;
        this.aChat.add(o);
    }
    
    public void addChat(String chat) {
        if (this.zoneMap != null) {
            this.zoneMap.chat(this, chat);
        }
    }
    
    public void addInfo1(int time, String text) {
        TimeChat o = new TimeChat();
        o.time = time;
        o.chat = text;
        this.aInfo1.add(o);
    }
    
    public void oneFinger(Char player) {
        ArrayList<Mob> list1 = new ArrayList<>();
        ArrayList<Char> list2 = new ArrayList<>();
        list2.add(player);
        this.addChat(0, mResources.ONE_FINGER);
        this.Attack(Skill.arrSkill[27].clone(), list1, list2, 2);
        this.timeHit = 1000;
    }
    
    public void freeze(Char player) {
        this.addChat(0, mResources.FREEZE);
        player.hold(1, 5000, 40, -1, -1);
        this.timeHit = 2000;
    }
    
    public void updateAttk() {
        if (this.isSkillOneFinger) {
            this.tOneFinger -= this.delay;
            if (this.tOneFinger <= 0) {
                this.tOneFinger = 5000;
                Char player1 = this.zoneMap.getPlayerClosest(this);
                if (player1 != null) {
                    this.oneFinger(player1);
                }
            }
        }
        if (this.isSkillFreeze) {
            this.tFreeze -= this.delay;
            if (this.tFreeze <= 0) {
                this.tFreeze = 20000;
                Char player2 = this.zoneMap.getPlayerClosest(this);
                if (player2 != null) {
                    this.freeze(player2);
                }
            }
        }
    }
    
    public void addConfirm(ArrayList<String> list) {
        this.nConfirm = 0;
        this.sayConfirm = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.sayConfirm[i] = list.get(i);
        }
        this.openConfirm();
    }
    
    public void openConfirm() {
        if (this.sayConfirm != null && this.nConfirm < this.sayConfirm.length) {
            this.resetMenu();
            this.menuBoard.chat = this.sayConfirm[this.nConfirm];
            this.menuBoard.arrMenu.add(new MenuInfo(this.sayConfirm.length - 1 == this.nConfirm ? mResources.OK : String.format(mResources.OK_2, this.sayConfirm.length - this.nConfirm - 1), 0) {
                    @Override
                    public boolean execute() {
                        Char.this.openConfirm();
                        return true;
                    }
                });
            this.menuBoard.openUIConfirm(5, null, null, -1);
            this.nConfirm++;
        }
    }
    
    private void setTanjiro(int time, int v) {
        this.tTanjiro = time;
        this.vTanjiro = v;
        this.updateAll();
    }
    
    private void setInosukeH(int time, int v) {
        this.tInosukeH = time;
        this.vInosukeH = v;
        this.updateAll();
    }
    
    private void setInosuke(int time, int v) {
        this.tInosuke = time;
        this.vInosuke = v;
        this.updateAll();
    }
    
    private void setCazy(int time, int v) {
        this.tCazy = time;
        this.vCazy = v;
        this.updateAll();
        if (this.session != null) {
            this.session.service.meLoadPoint();
        }
    }
    
    private void updateNoiTai() {
        //Noi tai Tanjiro
        if (this.vTanjiro > 0) {
            this.tTanjiro -= this.delay;
            if (this.tTanjiro <= 0) {
                this.tTanjiro = 0;
                this.vTanjiro = 0;
                this.updateAll();
            }
        }
        //Tac dung trang bi
        this.tTBTanjiro -= this.delay;
        if (this.tTBTanjiro <= 0) {
            this.tTBTanjiro = 120000;
            if (this.isTBTanjiro) {
                this.setTanjiro(15000, 30);
            }
        }
        //Noi tai Inosuke Hashibira
        if (this.vInosukeH > 0) {
            this.tInosukeH -= this.delay;
            if (this.tInosukeH <= 0) {
                this.tInosukeH = 0;
                this.vInosukeH = 0;
                this.updateAll();
            }
        }
        //Tac dung trang bi
        this.tTBInosukeH -= this.delay;
        if (this.tTBInosukeH <= 0) {
            this.tTBInosukeH = 120000;
            if (this.isTBInosukeH) {
                this.setInosukeH(20000, 60);
            }
        }
        //Noi tai Inosuke
        if (this.vInosuke > 0) {
            this.tInosuke -= this.delay;
            if (this.tInosuke <= 0) {
                this.tInosuke = 0;
                this.vInosuke = 0;
                this.updateAll();
            }
        }
        //Tac dung trang bi
        this.tTBInosuke -= this.delay;
        if (this.tTBInosuke <= 0) {
            this.tTBInosuke = 120000;
            if (this.isTBInosuke) {
                this.setInosuke(20000, 50);
            }
        }
        //Lo lang
        if (!this.isTemplate && this.zoneMap != null) {
            boolean worr = this.zoneMap.isHaveWorr(this);
            if (worr != this.isWorr) {
                this.isWorr = worr;
                this.updateAll();
            }
        }
        //Dien loan
        if (this.tCazy > 0) {
            this.tCazy -= this.delay;
            if (this.tCazy <= 0) {
                this.tCazy = 0;
                this.vCazy = 0;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
        }
        //Tac dung trang bi
        this.tNezuko -= this.delay;
        if (this.tNezuko <= 0) {
            this.tNezuko = 120000;
            if (!this.isTemplate && this.zoneMap != null && (this.isTBNezuko || this.zoneMap.isHaveCazy(this))) {
                this.setCazy(10000, 15);
                //Hoi 3% HP, KI
                if (!this.isDie) {
                    this.upHP((int)((long)this.cHPFull * 3L / 100L));
                    this.upMP((int)((long)this.cMPFull * 3L / 100L));
                    if (this.session != null) {
                        this.session.service.meLoadHP(this.cHP);
                        this.session.service.meLoadMP(this.cMP);
                    }
                    this.zoneMap.playerLoadHP(this, -1);
                }
            }
        }
        //Tac dung voi chin nga ga chin cua ngua 9 hong mao
        if (!this.vPet9) {
            if (this.timevPet9 >= 20000) {
                if (this.usePet != null && (this.usePet.template.id == 1224 || this.usePet.template.id == 1225 || this.usePet.template.id == 1226)) {
                    this.timevPet9 = 0;
                    this.setText(10, mResources.NOITAI_CHIN, 10, 0, 15);
                }
            } else {
                this.timevPet9 += this.delay;
            }
        }
    }
    
    public void resetSkill() {
        for (int i = 0; i < this.skills.size(); i++) {
            this.skills.get(i).lastTimeUseThisSkill = System.currentTimeMillis() - this.skills.get(i).coolDown;
        }
        if (this.session != null) {
            this.session.service.updateCoolDown(this.skills);
        }
    }
    
    private void updateTele() {
        if (this.zoneMap != null) {
            //BlackBall
            if (this.transportOld != null && this.transportOld.map.templateId >= 85 && this.transportOld.map.templateId <= 91 && !BlackBall.gI().isBlackBall) {
                this.transportOld = null;
            }
        }
    }
    
    private void updateGoiRong() {
        if (this.isGoiRong) {
            this.timeRong -= this.delay;
            if (this.timeRong <= 0) {
                this.hideRong();
            }
        }
    }
    
    public void addEffRong(int rongId, int mapRID, int bgRID, int zoneRID, int charRID, String textR, int xR, int yR, boolean isRongNamek) {
        this.rID = rongId;
        this.mapRID = mapRID;
        this.bgRID = bgRID;
        this.zoneRID = zoneRID;
        this.charRID = charRID;
        this.textR = textR;
        this.xR = xR;
        this.yR = yR;
        this.isRongNamek = isRongNamek;
        this.isRongThanXuatHien = true;
        this.session.service.callDragon(this.mapRID, this.bgRID, zoneRID, this.charRID, this.textR, this.xR, this.yR, this.isRongNamek ? 1 : 0);
    }
    
    public void hideEffRong() {
        this.isRongThanXuatHien = false;
        this.isRongNamek = false;
        this.session.service.hideDragon();
    }
    
    private void hideRong() {
        this.timeRong = 0;
        this.isGoiRong = false;
        this.hideEffRong();
    }
    
    public void goirong(int typeRong, int timeRong) {
        this.isGoiRong = true;
        this.typeRong = typeRong;
        this.timeRong = timeRong;
        if (this.typeRong == 1) {
            this.addEffRong(51, this.mapTemplateId, this.zoneMap.mapTemplate.bgID, this.zoneMap.zoneID, this.charID, mResources.EMPTY, this.cx, this.cy, true);
        }
        if (this.typeRong == 2) {
            this.addEffRong(59, this.mapTemplateId, this.zoneMap.mapTemplate.bgID, this.zoneMap.zoneID, this.charID, mResources.EMPTY, this.cx, this.cy, true);
        }
        if (this.typeRong == 3) {
            this.addEffRong(17, this.mapTemplateId, this.zoneMap.mapTemplate.bgID, this.zoneMap.zoneID, this.charID, mResources.EMPTY, this.cx, this.cy, true);
        }
        this.openMenuRong();
    }
    
    public void openMenuRong() {
        if (this.typeRong == 1) {
            this.resetMenu();
            this.menuBoard.chat = mResources.SAY_RONG_THAN_4;
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 1), 295, 1));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 2), 295, 2));
//            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 3), 295, 3));
//            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 4), 295, 4));
            this.menuBoard.openUIConfirm(5, null, null, -1);
        }
        if (this.typeRong == 2) {
            this.resetMenu();
            this.menuBoard.chat = mResources.SAY_RONG_THAN_5;
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 1), 295, 1));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 2), 295, 2));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 3), 295, 3));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.DIEU_UOC, 4), 295, 4));
            this.menuBoard.openUIConfirm(5, null, null, -1);
        }
        if (this.typeRong == 3) {
            this.resetMenu();
            this.menuBoard.chat = mResources.SAY_RONG_THAN_6;
            this.menuBoard.arrMenu.add(new MenuInfo(CallDragon.gI().arrDieuUocRongThan[0][0], 295, 1));
            this.menuBoard.arrMenu.add(new MenuInfo(CallDragon.gI().arrDieuUocRongThan[0][1], 295, 2));
            this.menuBoard.arrMenu.add(new MenuInfo(CallDragon.gI().arrDieuUocRongThan[0][2], 295, 3));
            this.menuBoard.arrMenu.add(new MenuInfo(CallDragon.gI().arrDieuUocRongThan[1][0], 295, 4));
            this.menuBoard.openUIConfirm(5, null, null, -1);
        }
    }
    
    public void finishRong() {
        if (this.typeRong == 1) {
            //Thay chieu 2 3 4 cua de
            switch (this.selectRong) {
                case 1:
                    if (this.myPet != null) {
                        if (this.myPetz().skills.size() > 1) {
                            this.myPetz().skills.set(1, Skill.arrSkill[this.myPetz().arrSkillPet[1][Util.gI().nextInt(this.myPetz().arrSkillPet[1].length)]].clone());
                        }
                        if (this.myPetz().skills.size() > 2) {
                            this.myPetz().skills.set(2, Skill.arrSkill[this.myPetz().arrSkillPet[2][Util.gI().nextInt(this.myPetz().arrSkillPet[2].length)]].clone());
                        }
                        if (this.myPetz().skills.size() > 3) {
                            this.myPetz().skills.set(3, Skill.arrSkill[this.myPetz().arrSkillPet[3][Util.gI().nextInt(this.myPetz().arrSkillPet[3].length)]].clone());
                        }
                    }   break;
                case 2:
                    this.setText(1, mResources.X2_TEXT, 3600, 2, 0);
                    break;
                default:
                    break;
            }
        }
        if (this.typeRong == 2) {
            //Doi chieu 3, 4 de
            switch (this.selectRong) {
                case 1:
                    if (this.myPet != null) {
                        if (this.myPetz().skills.size() > 2) {
                            this.myPetz().skills.set(2, Skill.arrSkill[this.myPetz().arrSkillPet[2][Util.gI().nextInt(this.myPetz().arrSkillPet[2].length)]].clone());
                        }
                        if (this.myPetz().skills.size() > 3) {
                            this.myPetz().skills.set(3, Skill.arrSkill[this.myPetz().arrSkillPet[3][Util.gI().nextInt(this.myPetz().arrSkillPet[3].length)]].clone());
                        }
                    }
                    break;
                case 2:
                    this.setText(1, mResources.X2_TEXT, 3600, 2, 0);
                    break;
                case 3:
                    this.addDuaHau(50, new int[]{4664}, 0, 604800, 4664);
                    break;
                case 4:
                    this.setText(4, mResources.AD_SDHPKI_TEXT, 3600, 2, 0);
                    break;
                default:
                    break;
            }
        }
        if (this.typeRong == 3) {
            //Dep Trai Nhat Vu Tru
            if (this.selectRong == 1) {
                if (this.getEmptyBagCount() == 0) {
                    this.addInfo1(mResources.BAG_FULL);
                } else {
                    if (this.cgender == 0) {
                        this.addItemBag(0, new Item(227, false, 1, ItemOption.getOption(227, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                    }
                    if (this.cgender == 1) {
                        this.addItemBag(0, new Item(228, false, 1, ItemOption.getOption(228, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                    }
                    if (this.cgender == 2) {
                        this.addItemBag(0, new Item(229, false, 1, ItemOption.getOption(229, 0, -1), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                    }
                 }
            }
            //+20m tn, sm
            if (this.selectRong == 2) {
                this.updateEXP(2, 20000000);
            }
            //Giau co 2b vang
            if (this.selectRong == 3) {
                this.updateXu(200000000, 1);
            }
            //Thay chieu de tu
            if (this.selectRong == 4) {
                if (this.myPet != null) {
                    if (this.myPetz().skills.size() > 1) {
                        this.myPetz().skills.set(1, Skill.arrSkill[this.myPetz().arrSkillPet[1][Util.gI().nextInt(this.myPetz().arrSkillPet[1].length)]].clone());
                    }
//                    if (charz.myPetz().skills.size() > 2) {
//                        charz.myPetz().skills.set(2, Skill.arrSkill[charz.myPetz().arrSkillPet[2][Util.gI().nextInt(charz.myPetz().arrSkillPet[2].length)]].clone());
//                    }
                    this.myPetz().updateAll();
                    this.updateAll();
                    this.session.service.meLoadPoint();
                    this.zoneMap.playerLoadAll(this);
                    this.session.service.Body(this.head, this.arrItemBody);
                }
            }
        }
        this.hideRong();
        this.session.service.startOKDlg(String.format(mResources.UOC_XONG, this.selectRong));
    }
    
    public boolean insertEff(int effId) {
        if (effId == 25) {
            if (this.isRongThanXuatHien) {
                this.session.service.insertEffData(this.rID, effId);
                return true;
            }
        }
        return false;
    }
    
    public void menuRong() {
        if (this.arrItem[0].template.id == 807 && this.getItemBagById(808) != null && this.getItemBagById(809) != null && this.getItemBagById(810) != null && this.getItemBagById(811) != null && this.getItemBagById(812) != null && this.getItemBagById(813) != null) {
            this.useItemBag(this.arrItem[0].indexUI, 1);
            this.useItemBag(this.getItemBagById(808).indexUI, 1);
            this.useItemBag(this.getItemBagById(809).indexUI, 1);
            this.useItemBag(this.getItemBagById(810).indexUI, 1);
            this.useItemBag(this.getItemBagById(811).indexUI, 1);
            this.useItemBag(this.getItemBagById(812).indexUI, 1);
            this.useItemBag(this.getItemBagById(813).indexUI, 1);
            this.goirong(1, 300000);
        }
        if (this.arrItem[0].template.id == 925 && this.getItemBagById(926) != null && this.getItemBagById(927) != null && this.getItemBagById(928) != null && this.getItemBagById(929) != null && this.getItemBagById(930) != null && this.getItemBagById(931) != null) {
            this.useItemBag(this.arrItem[0].indexUI, 1);
            this.useItemBag(this.getItemBagById(926).indexUI, 1);
            this.useItemBag(this.getItemBagById(927).indexUI, 1);
            this.useItemBag(this.getItemBagById(928).indexUI, 1);
            this.useItemBag(this.getItemBagById(929).indexUI, 1);
            this.useItemBag(this.getItemBagById(930).indexUI, 1);
            this.useItemBag(this.getItemBagById(931).indexUI, 1);
            this.goirong(2, 300000);
        }
        if (this.arrItem[0].template.id == 14 && this.getItemBagById(15) != null && this.getItemBagById(16) != null && this.getItemBagById(17) != null && this.getItemBagById(18) != null && this.getItemBagById(19) != null && this.getItemBagById(20) != null) {
            this.useItemBag(this.arrItem[0].indexUI, 1);
            this.useItemBag(this.getItemBagById(15).indexUI, 1);
            this.useItemBag(this.getItemBagById(16).indexUI, 1);
            this.useItemBag(this.getItemBagById(17).indexUI, 1);
            this.useItemBag(this.getItemBagById(18).indexUI, 1);
            this.useItemBag(this.getItemBagById(19).indexUI, 1);
            this.useItemBag(this.getItemBagById(20).indexUI, 1);
            this.goirong(3, 300000);
            this.addTaskPointDH(1290, 1);
        }
    }
    
    public ItemTime getMessageById(int id) {
        for (int i = 0; i < this.textTime.size(); i++) {
            ItemTime textTime2 = this.textTime.get(i);
            if ((int)textTime2.idIcon == id) {
                return textTime2;
            }
        }
        return null;
    }
    
    public boolean isExistMessage(int id) {
        for (int i = 0; i < this.textTime.size(); i++) {
            ItemTime textTime2 = this.textTime.get(i);
            if ((int)textTime2.idIcon == id) {
                return true;
            }
        }
        return false;
    }
    
    public void setText(int id, String text, int second, int type, int damage) {
        if (this.isExistMessage(id)) {
            this.getMessageById(id).initTimeText(text, second, type, damage);
        } else {
            ItemTime o = new ItemTime((byte)id, text, second, type, damage);
            this.textTime.add(o);
            switch (o.idIcon) {
                case 1:
                    this.isX2Text = true;
                    break;
                case 2:
                    this.isX2EventText = true;
                    break;
                case 3:
                    this.isX2RVC = true;
                    break;
                case 4:
                    this.isAddSDHPKIText = true;
                    break;
                case 5:
                    this.pPetzStCrit = damage;
                    break;
                case 6:
                    this.isAgainstDamageCrit = true;
                    break;
                case 7:
                    this.isX2RNM = true;
                    break;
                case 8:
                    this.isPercentRNM = true;
                    break;
                case 10:
                    this.vPet9 = true;
                    break;
                case 11:
                    break;
                default:
                    break;
            }
        }
        this.updateAll();
        if (this.session != null) {
            this.session.service.messageTime(id, text, second);
            this.session.service.meLoadPoint();
            this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
            this.session.service.getBag(this.charID, this.bag);
        }
        if (this.zoneMap != null) {
            this.zoneMap.playerLoadAll(this);
        }
    }
    
    public void setText(int id, String text, int second, int type, Item item) {
        if (this.isExistMessage(id)) {
            this.getMessageById(id).initTimeText(text, second, type, 0);
            this.getMessageById(id).item = item;
        } else {
            ItemTime o = new ItemTime((byte)id, text, second, type, 0);
            o.item = item;
            this.textTime.add(o);
        }
        this.updateAll();
        if (this.session != null) {
            this.session.service.messageTime(id, text, second);
            this.session.service.meLoadPoint();
            this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
            this.session.service.getBag(this.charID, this.bag);
        }
        if (this.zoneMap != null) {
            this.zoneMap.playerLoadAll(this);
        }
    }
    
    private void updateTextTime() {
        this.timeTextTime -= this.delay;
        if (this.timeTextTime <= 0) {
            this.timeTextTime = 1000;
            if (!this.textTime.isEmpty()) {
                for (int i = this.textTime.size() - 1; i >= 0; --i) {
                    this.textTime.get(i).second--;
                    if (this.textTime.get(i).second <= 0) {
                        switch (this.textTime.get(i).idIcon) {
                            case 1:
                                this.isX2Text = false;
                                break;
                            case 2:
                                this.isX2EventText = false;
                                break;
                            case 3:
                                this.isX2RVC = false;
                                break;
                            case 4:
                                this.isAddSDHPKIText = false;
                                break;
                            case 5:
                                this.pPetzStCrit = 0;
                                break;
                            case 6:
                                this.isAgainstDamageCrit = false;
                                break;
                            case 7:
                                this.isX2RNM = false;
                                break;
                            case 8:
                                this.isPercentRNM = false;
                                break;
                            case 10:
                                this.vPet9 = false;
                                break;
                            case 11:
                                this.rdRPS = true;
                                break;
                            default:
                                break;
                        }
                        //_________________________
                        this.updateAll();
                        if (this.session != null) {
                            this.session.service.meLoadPoint();
                            this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            this.session.service.getBag(this.charID, this.bag);
                        }
                        if (this.zoneMap != null) {
                            this.zoneMap.playerLoadAll(this);
                        }
                        this.textTime.remove(i);
                    }
                }
            }
        }
    }
    
    private void updateLivePk() {
        if (this.tTypePk > 0) {
            this.tTypePk -= this.delay;
            if (this.tTypePk <= 0) {
                this.tTypePk = 0;
                this.changeTypePk(this.setTypePk);
            }
        }
    }
    
    public void setLiveTypePk(int sc, int cTypePk) {
        this.isSetTypePk = sc != -1;
        this.setTypePk = (byte) cTypePk;
        this.tSetTypePk = sc * 1000;
    }
    
    public Obj myObj() {
        if (this.myCharz().myObj == null) {
            this.myCharz().myObj = Obj.gI(this.myCharz().cName);
        }
        return this.myCharz().myObj;
    }
    
    private void updateClan() {
        if (this.zoneMap != null) {
            int num = this.zoneMap.memberClanCount(this.charID, this.clan.ID, this.cx, this.cy, 200, 200);
            if (num != this.clanNumberCountNear) {
                this.clanNumberCountNear = num;
                if (this.dam2MemberPercent > 0 || this.hp2MemberPercent > 0 || this.mp2MemberPercent > 0) {
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        while(!this.clanMember.blackBalls.isEmpty()) {
            Item blackBall = this.clanMember.blackBalls.remove(0);
            if (!this.myObj().isHaveItemBlackBall(blackBall.template.id)) {
                this.myObj().addItemBlackBall(blackBall);
            }
        }
    }
    
    public boolean isStand() {
        return this.isDie || this.stone > 0 || this.isFreez || this.sleepEff || this.holder || this.blindEff || this.isMabuHold;
    }
    
    public void giftTanThu() {
        this.updateXu(10000000000L, 1);
        //Max nhiem vu
//            this.ctaskId = 34;
//            this.ctaskIndex = 0;
        //De free
        Player.petInfo(this, Util.gI().nextInt(3));
    }
//    
    private void updateRong() {
        //Rong Vo Cuc
        if (this.zoneMap != null && this.session != null) {
            if (RongVoCuc.gI().isCallRongVoCuc) {
                if (!this.isGoiRong && (this.mapTemplateId == 0 || this.mapTemplateId == 7 || this.mapTemplateId == 14) && (!this.isRongThanXuatHien || this.mapRID != this.mapTemplateId || this.zoneRID != this.zoneID)) {
                    if (this.mapTemplateId == 0) {
                        this.addEffRong(50, this.mapTemplateId, this.zoneMap.mapTemplate.bgID, this.zoneMap.zoneID, -1, mResources.EMPTY, 714, 450, true);
                    }
                    if (this.mapTemplateId == 7) {
                        this.addEffRong(50, this.mapTemplateId, this.zoneMap.mapTemplate.bgID, this.zoneMap.zoneID, -1, mResources.EMPTY, 659, 450, true);
                    }
                    if (this.mapTemplateId == 14) {
                        this.addEffRong(50, this.mapTemplateId, this.zoneMap.mapTemplate.bgID, this.zoneMap.zoneID, -1, mResources.EMPTY, 700, 426, true);
                    }
                }
            } else if (!this.isGoiRong && this.isRongThanXuatHien && this.rID == 50) {
                this.hideEffRong();
            }
        }
    }
    
    public void finishLoadMap() {
        if (!this.isGoiRong && this.isRongThanXuatHien && this.rID == 50) {
            this.hideEffRong();
        }
    }
    
    public boolean isExistAmu(int id) {
        for (int i = 0; i < this.arrAmu.size(); i++) {
            if (this.arrAmu.get(i).templateId == id) {
                return true;
            }
        }
        return false;
    }
    
    public Amu getAmuById(int id) {
        for (int i = 0; i < this.arrAmu.size(); i++) {
            if (this.arrAmu.get(i).templateId == id) {
                return this.arrAmu.get(i);
            }
        }
        return null;
    }
    
    public int setAmu(int templateId, int second) {
        if (this.isExistAmu(templateId)) {
            Amu c = this.getAmuById(templateId);
            c.second += second;
            return (int) ((c.second - (System.currentTimeMillis() / 1000)) / (60 * 60));
        } else {
            Amu o = new Amu((short)templateId, (int)((System.currentTimeMillis() / 1000) + second));
            if (o.templateId == 213) {
                this.xExp += 2;
            }
            if (o.templateId == 214) {
                this.damMob_percent += 150;
            }
            if (o.templateId == 215) {
                this.downDamMob_percent += 50;
            }
            if (o.templateId == 216) {
                this.isOaiHum = true;
            }
            if (o.templateId == 217) {
                this.isNotDieMob = true;
            }
            if (o.templateId == 218) {
                this.isNotTheLeDown = true;
            }
            if (o.templateId == 219) {
                this.isHutVP = true;
            }
            if (o.templateId == 522) {
                this.isBuaDeTu = true;
            }
            if (o.templateId == 671) {
                this.xExp += 3;
            }
            if (o.templateId == 672) {
                this.xExp += 4;
            }
            this.arrAmu.add(o);
            return second / (60 * 60);
        }
    }
    
    public void updateAmu() {
        for (int i = this.arrAmu.size() - 1; i >= 0; --i) {
            if (this.arrAmu.get(i).second <= System.currentTimeMillis() / 1000) {
                if (this.arrAmu.get(i).templateId == 213) {
                    this.xExp -= 2;
                }
                if (this.arrAmu.get(i).templateId == 214) {
                    this.damMob_percent -= 150;
                }
                if (this.arrAmu.get(i).templateId == 215) {
                    this.downDamMob_percent -= 50;
                }
                if (this.arrAmu.get(i).templateId == 216) {
                    this.isOaiHum = false;
                }
                if (this.arrAmu.get(i).templateId == 217) {
                    this.isNotDieMob = false;
                }
                if (this.arrAmu.get(i).templateId == 218) {
                    this.isNotTheLeDown = false;
                }
                if (this.arrAmu.get(i).templateId == 219) {
                    this.isHutVP = false;
                }
                if (this.arrAmu.get(i).templateId == 522) {
                    this.isBuaDeTu = false;
                }
                if (this.arrAmu.get(i).templateId == 671) {
                    this.xExp -= 3;
                }
                if (this.arrAmu.get(i).templateId == 672) {
                    this.xExp -= 4;
                }
                this.arrAmu.remove(i);
            }
        }
    }
    
    private void addSkillNotFocus(int status, int miliSecond, int skillId, int damage, int dx, int dy, int point) {
        SkillNotFocus skillNotFocus = new SkillNotFocus();
        skillNotFocus.status = (byte) status;
        skillNotFocus.skillId = skillId;
        skillNotFocus.damage = damage;
        skillNotFocus.seconds = miliSecond;
        skillNotFocus.dx = dx;
        skillNotFocus.dx = dx;
        skillNotFocus.point = point;
        
        this.waitSkill_not_focus = skillNotFocus;
        if (status == 4) {
            this.zoneMap.player_skill_not_focus(status, this.charID, skillId, null, null, miliSecond);
        }
        if (status == 6) {
            this.zoneMap.player_skill_not_focus(status, this.charID, skillId, null, null, miliSecond);
        }
        if (status == 7) {
            this.zoneMap.player_skill_not_focus(status, this.charID, skillId, null, null, miliSecond);
            if (this.session != null) {
                this.session.service.skill_not_focus(status, this.charID, skillId, null, null, miliSecond);
            }
        }
    }
    
    private void updateSkillNotFocus() {
        if (!this.isDie) {
            if (this.waitSkill_not_focus != null) {
                if (this.waitSkill_not_focus.seconds > 0) {
                    this.waitSkill_not_focus.seconds -= this.delay;
                    if (this.waitSkill_not_focus.seconds <= 0) {
                        if (this.waitSkill_not_focus.status == 4) {
                            if (this.session != null) {
                                this.session.service.skill_not_focus(this.waitSkill_not_focus.status, this.charID, this.waitSkill_not_focus.skillId, null, null, 0);
                            }
                        }
                        //Bien hinh
                        if (this.waitSkill_not_focus.status == 6) {
                            this.gong = false;
                            if (this.session != null) {
                                this.session.service.skill_not_focus(this.waitSkill_not_focus.status, this.charID, this.waitSkill_not_focus.skillId, null, null, 0);
                            }
                            int timeH = 60000;
                            if (this.waitSkill_not_focus.point == 2) {
                                timeH = 70000;
                            }
                            if (this.waitSkill_not_focus.point == 3) {
                                timeH = 80000;
                            }
                            if (this.waitSkill_not_focus.point == 4) {
                                timeH = 90000;
                            }
                            if (this.waitSkill_not_focus.point == 5) {
                                timeH = 100000;
                            }
                            if (this.waitSkill_not_focus.point == 6) {
                                timeH = 110000;
                            }
                            if (this.waitSkill_not_focus.point == 7) {
                                timeH = 120000;
                            }
                            if (this.isSetCaDic) {
                                timeH = timeH * 5;
                            }
                            this.bienHinh(1, this.waitSkill_not_focus.point - 1, timeH);
                        }
                        //Bom
                        if (this.waitSkill_not_focus.status == 7) {
                            this.gong = false;
                            this.zoneMap.player_skill_not_focus(7, this.charID, this.waitSkill_not_focus.skillId, null, null, -1);
                            if (this.session != null) {
                                this.session.service.skill_not_focus(7, this.charID, this.waitSkill_not_focus.skillId, null, null, -1);
                            }
                            //Thua cuoc
                            this.loser(5);
                            Mob[] arrMob;
                            synchronized (this.zoneMap.mobs) {
                                arrMob = new Mob[this.zoneMap.mobs.size()];
                                for (int i = 0; i < this.zoneMap.mobs.size(); i++) {
                                    arrMob[i] = this.zoneMap.mobs.get(i);
                                }
                            }
                            Char[] arrChar;
                            synchronized (this.zoneMap.players) {
                                arrChar = new Char[this.zoneMap.players.size()];
                                for (int i2 = 0; i2 < this.zoneMap.players.size(); i2++) {
                                    arrChar[i2] = this.zoneMap.players.get(i2);
                                }
                            }
                            for (int i3 = 0; i3 < arrMob.length; i3 = i3 + 1) {
                                Mob mob = arrMob[i3];
                                if (mob != null && this.isMeCanAttackOtherMob(mob) && (this.waitSkill_not_focus.point > 6 || (Math.abs(this.cx - mob.pointx) <= this.waitSkill_not_focus.dx && Math.abs(this.cy - mob.pointy) <= this.waitSkill_not_focus.dy))) {
                                    int num1 = this.cHPFull;
                                    mob.AttackMob(this, num1, false, 3, -1);
                                }
                            }
                            for (int i4 = 0; i4 < arrChar.length; i4 = i4 +1) {
                                Char player = arrChar[i4];
                                if (player != null) {
                                    if (!player.isDie && (this.waitSkill_not_focus.point > 6 || (Math.abs(this.cx - player.cx) <= this.waitSkill_not_focus.dx && Math.abs(this.cy - player.cy) <= this.waitSkill_not_focus.dy)) && this.isMeCanAttackOtherPlayer(player)) {
                                        if (player.cTemplateId != 26 && player.cTemplateId != 27 && player.cTemplateId != 28) {
                                            int num2 = this.cHPFull;
                                            if (player.isTemplate) {
                                                if (this.isMonkey != 0) {
                                                    num2 = num2 / 3;
                                                } else {
                                                    num2 = num2 / 2;
                                                }
                                            }
                                            //Bat khien
                                            if (num2 > 1 && player.protectEff) {
                                                if (num2  >= player.cHPFull) {
                                                    player.setItem(3784, 0, 0, 0);
                                                }
                                                num2 = 1;
                                            }

                                            if (player.downDamage_percent > 0) {
                                                int downDam_percent = player.downDamage_percent;
                                                if (downDam_percent > 89) {
                                                    downDam_percent = 89;
                                                }
                                                num2 = (int) (num2 - ((long)num2 * (long)downDam_percent / 100L));
                                            }
                                            player.haveAttackPLayer(this, 1, num2, false, -1, true);
                                        }
                                    }
                                }
                            }
                            //Die and attk
                            this.startDie(1, this.cx, this.zoneMap.mapTemplate.touchY(this.cx, this.cy));
                        }
                        this.waitSkill_not_focus = null;
                    }
                }
            }
        } else {
            this.waitSkill_not_focus = null;
        }
    }
    
    private void updateNew() {
        //Thach dau
        if (this.miliSecondChallenge > 0) {
            this.miliSecondChallenge -= this.delay;
            if ( this.miliSecondChallenge <= 0) {
                this.miliSecondChallenge = 0;
                if (!this.isChallenge) {
                    this.challengeCharId = -9999;
                }
            }
        }
        //Oan tu ti
        if (this.miliSecondRPS > 0) {
            this.miliSecondRPS -= this.delay;
            if (this.miliSecondRPS <= 0) {
                this.miliSecondRPS = 0;
                if (!this.isRPS) {
                    this.rPSCharId = -9999;
                }
            }
        }
        if (this.rdRPS) {
            this.rdRPS = false;
            if (this.isRPS &&this.statusRPS == -1) {
                this.ntRPS++;
                this.actionRPS(Util.gI().nextInt(3));
            }
        }
        //Bien hinh
        if (this.miliSecond_Monkey > 0) {
            this.miliSecond_Monkey -= this.delay;
            if (this.miliSecond_Monkey <= 0) {
                this.bienHinh(0, 0, 0);
            }
        }
        //Troi mat
        if (this.freezMiliSeconds > 0) {
            this.freezMiliSeconds -= this.delay;
            if (this.freezMiliSeconds <= 0) {
                this.freezMiliSeconds = 0;
                this.isFreez = false;
            }
        }
        //Kien nang luong
        if (this.time_protectEff > 0) {
            this.time_protectEff -= this.delay;
            if (this.time_protectEff <= 0) {
                this.hold(0, 0, 33, -1, -1);
            }
        }
        //Mu
        if (this.time_blindEff > 0) {
            this.time_blindEff -= this.delay;
            if (this.time_blindEff <= 0) {
                this.hold(0, 0, 40, -1, -1);
            }
        }
        //Ru ngu
        if (this.time_sleepEff > 0) {
            this.time_sleepEff -= this.delay;
            if (this.time_sleepEff <= 0) {
                this.hold(0, 0, 41, -1, -1);
            }
        }
        //Tai tao nang luong
        if (this.chargeMiliSeconds > 0) {
            this.chargeMiliSeconds -= this.delay;
            if (this.chargeMiliSeconds <= 0) {
                chargeMiliSeconds = 0;
            }
        }
        if (this.tCharge > 0) {
            this.tCharge -= this.delay;
            if (this.tCharge <= 0) {
                this.tCharge = 0;
                this.isCharge = false;
                if (this.session != null) {
                    this.session.service.skill_not_focus(3, this.charID, -1, null, null, 0);
                    this.session.service.meLoadInfo();
                }
                this.zoneMap.player_skill_not_focus(3, this.charID, -1, null, null, 0);
            }
        }
        if (this.isCharge && this.chargeMiliSeconds <= 0) {
            if (!this.isDie) {
                this.chargeMiliSeconds = 1000;
                int hpOld = this.cHP;
                this.upHP((int)((long)this.cHPFull * (long)this.chargeDamage / 100));
                this.upMP((int)((long)this.cMPFull * (long)this.chargeDamage / 100));
                this.hpHoi += this.cHP - hpOld;
                this.zoneMap.playerLoadHP(this, this.cHP);
                if (this.cHP >= this.cHPFull && this.cMP >= this.cMPFull) {
                    this.isCharge = false;
                    if (this.session != null) {
                        this.session.service.skill_not_focus(3, this.charID, -1, null, null, 0);
                        this.session.service.meLoadInfo();
                    }
                    this.zoneMap.player_skill_not_focus(3, this.charID, -1, null, null, 0);
                }
                if (this.cHP < this.cHPFull && this.gameTick % 5 == 0) {
                    this.addChat(1, String.format(mResources.RECOVER_ENERGY, (int)(100.0F / (float)this.cHPFull * (float)this.cHP)));
                }
            } else {
                this.isCharge = false;
                if (this.session != null) {
                    this.session.service.skill_not_focus(3, this.charID, -1, null, null, 0);
                    this.session.service.meLoadInfo();
                }
            }
        }
        //Huy sao
        if (this.time_huytSao > 0) {
            this.time_huytSao -= this.delay;
            if (this.time_huytSao <= 0) {
                this.hold(0, 0, 39, -1, -1);
            }
        }
        //Troi
        if (this.time_holder > 0) {
            this.time_holder -= this.delay;
            if (this.time_holder <= 0) {
                Char player443 = this.zoneMap.findCharInMap(this.holder_charId);
                if (player443 != null) {
                    player443.hold(0, 0, 32, -1, -1);
                }
                this.hold(0, 0, 32, -1, -1);
            }
        }
        //De trung
        if (this.mobMe != null) {
            if (this.mobMe.timeLiveMobMe != -1) {
                this.mobMe.timeLiveMobMe -= this.delay;
                if (this.mobMe.timeLiveMobMe <= 0) {
                    this.clearMobMe();
                }
            }
        }
        //5 giay hoi hp mp
        this.buff5 -= this.delay;
        if (this.buff5 <= 0) {
            this.buff5 = 5000;
            if (!this.isDie) {
                if (this.cHP < this.cHPFull) {
                    if (this.eff5BuffHp > 0) {
                        this.upHP(eff5BuffHp);
                        if (this.session != null) {
                            this.session.service.meLoadHP(this.cHP);
                        }
                        this.zoneMap.playerLoadHP(this, -1);
                    }
                }
                if (this.cMP < this.cMPFull) {
                    if (this.eff5BuffMp > 0) {
                        this.upMP(eff5BuffMp);
                        if (this.session != null) {
                            this.session.service.meLoadMP(this.cMP);
                        }
                    }
                }
                if (this.HutHPKI5_percent > 0 && !this.zoneMap.map.isMapBlackBall() && (this.cMP < this.cMPFull || this.cHP < this.cHPFull)) {
                    int num = this.zoneMap.getHutHPKI(this);
                    if (num > 0) {
                        this.upHP(num);
                        this.upMP(num);
                        if (this.session != null) {
                            this.session.service.meLoadHP(this.cHP);
                            this.session.service.meLoadMP(this.cMP);
                        }
                    }
                }
            }
        }
        //30 giay hoi hp mp
        this.buff30 -= this.delay;
        if (this.buff30 <= 0) {
            this.buff30 = 30000;
            if (!this.isDie) {
                if (this.cHP < this.cHPFull) {
                    if (this.eff30BuffHp_percent > 0 || this.eff30BuffHp > 0) {
                        this.upHP(((int)((long)this.cHPFull * (long)this.eff30BuffHp_percent / 100)) + this.eff30BuffHp);
                        if (this.session != null) {
                            this.session.service.meLoadHP(this.cHP);
                        }
                        this.zoneMap.playerLoadHP(this, -1);
                    }
                }
                if (this.cMP < this.cMPFull) {
                    if (this.eff30BuffMp_percent > 0 || this.eff30BuffMp > 0) {
                        this.upMP(((int)((long)this.cMPFull * (long)this.eff30BuffMp_percent / 100)) + this.eff30BuffMp);
                        if (this.session != null) {
                            this.session.service.meLoadMP(this.cMP);
                        }
                    }
                }
            }
        }
        //Dau than
        if (!this.magicTree_isUpdate) {
            if (this.magicTree_miliseconds <= System.currentTimeMillis()) {
                MagicTree.setPeas(this);
                this.magicTree_miliseconds  = System.currentTimeMillis() + (MagicTree.timePeas[magicTree_level - 1]);
            }
        } else {
            if (this.magicTree_miliseconds <= System.currentTimeMillis()) {
                this.magicTree_level++;
                this.magicTree_isUpdate = false;
                this.magicTree_miliseconds = System.currentTimeMillis() + (MagicTree.timePeas[this.magicTree_level - 1]);
            }
        }
        //CHat KTG
        if (this.timeKTG > 0) {
            this.timeKTG -= this.delay;
            if (this.timeKTG <= 0) {
                this.timeKTG = 0;
            }
        }
        //HOi qua di
        this.timeHoiqua -= this.delay;
        if (this.timeHoiqua <= 0) {
            this.timeHoiqua = 10000;
            if (this.dirty_percent > 0 && !this.isDie && !this.zoneMap.map.isMapBlackBall()) {
                this.zoneMap.dirtyDownHP(this, this.dirty_percent);
            }
        }
        //Dep tang dam
        if (this.gameTick % 20 == 0) {
            if (!this.isTBNice && !this.isTemplate && this.zoneMap != null) {
                int dameNice_percent = this.zoneMap.getDameNice(this);
                if (dameNice_percent != this.niceDam_percent) {
                    this.niceDam_percent = dameNice_percent;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                }
            }
        }
        //Phan tam
        if (this.gameTick % 20 == 0) {
            if (!this.isTemplate && this.zoneMap != null) {
                boolean phantam = !this.isAgainstEffect && this.zoneMap.isHaveDisperse(this);
                if (phantam != this.isDisperse) {
                    this.isDisperse = phantam;
                    this.updateAll();
                }
            }
        }
        //Dep chat
        if (this.niceDam_percent > 0 && this.timeChatNice <= 0 && this.zoneMap != null) {
            this.timeChatNice = 30000;
            this.zoneMap.chat(this, mResources.WOW_SEXY);
        }
        //Tang Trong Luc
        if (!this.isTemplate && this.zoneMap != null) {
            int downSpped_percent = this.zoneMap.getDownSpeedPercent(this);
            if (downSpped_percent != this.downSpeed_percent) {
                this.downSpeed_percent = downSpped_percent;
                this.updateAll();
                if (this.session != null) {
                    this.session.service.meLoadPoint();
                }
            }
        }
        if (this.timeDownHutHPKI5 > 0) {
            this.timeDownHutHPKI5 -= this.delay;
            if (this.timeDownHutHPKI5 <= 0) {
                timeDownHutHPKI5 = 0;
            }
        }
        //Thoi gian doi pk = 5
        if (this.timeChangePk5 != -1) {
            this.timeChangePk5 -= this.delay;
            if (this.timeChangePk5 <= 0) {
                this.timeChangePk5 = -1;
                this.changeTypePk(5);
            }
        }
        //sm tach hop the
        if (this.myPet != null && this.myPetz().petStatus == 4 && (this.myPetz().isHopThe == 2 || this.myPetz().isHopThe == 3) && this.cPower < 1500000L) {
            this.zoneMap.setFusion(1, this.charID);
            this.myPetz().petStatus = 1;
            this.myPetz().isHopThe = 0;
            this.myPetz().timeHopThe = 1000 * 60;
            this.updateAll();
            if (this.session != null) {
                this.session.service.meLoadPoint();
            }
            this.zoneMap.playerLoadAll(this);
            this.zoneMap.updateBody(this, 0);
            this.timeTach = 5000;
        }
        //SkillXayda
        if (!this.isStand()) {
            if (this.isSkillXayda1) {
                this.tSkillXayda1 -= this.delay;
                if (this.tSkillXayda1 <= 0) {
                    this.tSkillXayda1 = 20000;
                    Char player1 = this.zoneMap.getPlayerClosest(this);
                    if (player1 != null) {
                        this.addMove(0, player1.cx + new int[]{-120, 120}[Util.gI().nextInt(2)], player1.cy, 0);
                        this.skillXayda1(3000, player1);
                    }
                }
            }
            if (this.timeGong2 > 0) {
                this.timeGong2 -= this.delay;
                if (this.timeGong2 <= 0 || !this.gong) {
                    this.timeGong2 = 0;
                    this.gong = false;
                }
                if (!this.gong && this.zoneMap != null) {
                    this.zoneMap.endGong(this.charID);
                }
            }
            if (this.skillXaydaFocus1 != null && !this.gong) {
                if (this.isMeCanAttackOtherPlayer(this.skillXaydaFocus1)) {
                    this.aMobFocus.clear();
                    this.aCharFocus.clear();
                    this.aCharFocus.add(this.skillXaydaFocus1);
                    Skill skill = Skill.arrSkill[10].clone();
                    skill.dx = 1000;
                    skill.dy = 1000;
                    skill.damage = 500;
                    this.addMove(0, this.cx, this.cy - 20, 0);
                    this.timeHit = 0;
                    this.Attack(skill, this.aMobFocus, this.aCharFocus, 2);
                    this.timeHit = 2000;
                }
                this.skillXaydaFocus1 = null;
            }
            if (this.isSkillXayda2) {
                this.tSkillXayda2 -= this.delay;
                if (this.tSkillXayda2 <= 0) {
                    this.tSkillXayda2 = 25000;
                    Char player1 = this.zoneMap.getPlayerClosest(this);
                    if (player1 != null) {
                        this.addMove(0, player1.cx + new int[]{-50, 50}[Util.gI().nextInt(2)], player1.cy, 0);
                        this.skillXayda2(3000, player1);
                    }
                }
            }
            if (this.skillXaydaFocus2 != null && !this.gong) {
                if (this.gameTick % 4 == 0 && this.isMeCanAttackOtherPlayer(this.skillXaydaFocus2)) {
                    this.aMobFocus.clear();
                    this.aCharFocus.clear();
                    this.aCharFocus.add(this.skillXaydaFocus2);
                    Skill skill = Skill.arrSkill[21].clone();
                    skill.dx = 1000;
                    skill.dy = 1000;
                    skill.damage = 500;
                    this.timeHit = 0;
                    this.Attack(skill, this.aMobFocus, this.aCharFocus, 2);
                    this.timeHit = 2000;
                }
                this.tSkillXayda2_2 -= this.delay;
                if (this.tSkillXayda2_2 <= 0) {
                    this.tSkillXayda2_2 = 0;
                    this.skillXaydaFocus2 = null;
                }
            }
            if (this.isSkillXayda3 && 100.0F / this.cHPFull * this.cHP < 70) {
                Char player = this.zoneMap.getPlayerClosest(this);
                if (player != null) {
                    this.isSkillXayda3 = false;
                    this.skillXayda3(10000, player);
                }
            }
            if (this.skillXaydaFocus3 != null && !this.gong) {
                this.bienHinh(1, 0, 1000000);
                this.upHP(this.cHPFull);
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadHP(this, -1);
                }
                this.addChat(1, String.format(mResources.MONKEY_HOW_ABOUT_YOU, this.skillXaydaFocus3.cName));
                this.skillXaydaFocus3 = null;
            }
        }
        //Trang bi ngay he giam damage
        if (this.gameTick % 20 == 0) {
            if (!this.isSetNgayHe && !this.isTemplate && this.zoneMap != null) {
                int percent = this.zoneMap.getDownDamge(this);
                if (percent != this.downDamagePercent) {
                    this.downDamagePercent = percent;
                    this.updateAll();
                    if (this.session != null) {
                        this.session.service.meLoadPoint();
                    }
                }
            }
        }
        //Tai tao khi hp == 1
        if (this.isTaiTao1 && this.cHP == 1 && this.gameTick % 10 == 0) {
            this.skillXayda4(10000, 5);
        }
        //Trong map pho ban danh boss bang hoi het goi kick
        if (this.clan != null && this.mapTemplateId == 165 && this.clan.doelBossClan != null && this.clan.doelBossClan.miliTime <= 30000 && !isCommand(0)) {
            this.addCommand(0, new Object[]{this.clan.doelBossClan.miliTime - 1000, this.clan.getMap(153).getZone(this), mResources.CHAT_GO_MAP_CLAN, 0, 160, 432});
            this.setText(0, String.format(mResources.DOELBOSSCLAN, this.clan.doelBossClanLevel + 1), this.clan.doelBossClan.miliTime / 1000, 0 ,0);
        }
        //Map la dua ve nha
        if (this.mapTemplateId ==153 && this.clan == null) {
            this.goHome2();
        }
    }
    
    private void updateNew2() {
        //Tru time tan cong
        if (this.timeHit > 0) {
            this.timeHit -= this.delay;
            if (this.timeHit <= 0) {
                this.timeHit = 0;
            }
        }
        if (this.timeLoadSkill > 0) {
            this.timeLoadSkill -= this.delay;
            if (this.timeLoadSkill <= 0) {
                this.timeLoadSkill = 0;
            }
        }
        //Tru time san sang
        if (this.timeReady > 0) {
            this.timeReady -= this.delay;
            if (this.timeReady <= 0) {
                this.timeReady = 0;
            }
        }
        //Giao dich
        if (this.delay_giaodich > 0) {
            this.delay_giaodich -= this.delay;
            if (this.delay_giaodich <= 0) {
                this.delay_giaodich = 0;
            }
        }
        if (this.tw_giaodich > 0) {
            this.tw_giaodich -= this.delay;
            if (this.tw_giaodich <= 0) {
                this.tw_giaodich = 0;
                this.wid_giaodich = -9999;
            }
        }
        //THoi gian bay hoi ki
        if (this.timeFly > 0) {
            this.timeFly -= this.delay;
        }
        //THoi gian cho nhat
        if (this.timeNhat > 0) {
            this.timeNhat -= this.delay;
        }
        //Thoi gian doi khu
        if (this.timeChangeZone > 0) {
            this.timeChangeZone -= this.delay;
            if (this.timeChangeZone < 0) {
                this.timeChangeZone = 0;
            }
        }
        //Ket thuc bao ve
        if (this.securityCode != -1 && this.timeSecurity <= System.currentTimeMillis()) {
            this.securityCode = -1;
            this.securityCode2 = 0;
            this.isSecurity = false;
        }
        //Delay hoi sinh luong
        if (this.timeHSTaiCho > 0) {
            this.timeHSTaiCho -= this.delay;
            if (this.timeHSTaiCho <= 0) {
                this.timeHSTaiCho = 0;
            }
        }
        if (this.timeGoMe > 0) {
            this.timeGoMe -= this.delay;
            if (this.timeGoMe <= 0) {
                this.timeGoMe = 0;
            }
        }
        if (this.timeGoPlayer > 0) {
            this.timeGoPlayer -= this.delay;
            if (this.timeGoPlayer <= 0) {
                this.timeGoPlayer = 0;
            }
        }
        if (this.timeUsePet > 0) {
            this.timeUsePet -= this.delay;
            if (this.timeUsePet <= 0) {
                this.timeUsePet = 0;
            }
        }
        if (this.timeTach > 0) {
            this.timeTach -= this.delay;
            if (this.timeTach <= 0) {
                this.timeTach = 0;
            }
        }
        if (this.time_xDamAway60s > 0) {
            this.time_xDamAway60s -= this.delay;
            if (this.time_xDamAway60s <= 0) {
                this.time_xDamAway60s = 0;
            }
        }
        if (this.timeChatNice > 0) {
            this.timeChatNice -= this.delay;
            if (this.timeChatNice <= 0) {
                this.timeChatNice = 0;
            }
        }
        if (this.petFollow != null) {
            if (this.petFollow.time != -1) {
                this.petFollow.time -= this.delay;
                if (this.petFollow.time <= 0) {
                    this.clearPetFollow();
                }
            }
        }
        //Tang hinh 5s
        if (this.timeInvisiblez > 0) {
            this.timeInvisiblez -= this.delay;
            if (this.timeInvisiblez <= 0) {
                this.timeInvisiblez = 0;
                this.isInvisiblez = false;
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        if (!this.isInvisiblez) {
            this.timeInvisiblez5 -= this.delay;
            if (this.timeInvisiblez5 <= 0) {
                this.timeInvisiblez5 = 25000;
                if (this.isInvisiblez5) {
                    this.updateInvisiblez(3);
                }
            }
        }
        //Hoa da
        this.timeSendStone30_1 -= this.delay;
        if (this.timeSendStone30_1 <= 0) {
            this.timeSendStone30_1 = 30000;
            if (this.isSendStone30) {
                if (this.zoneMap != null) {
                    this.zoneMap.chat(this, mResources.PHET);
                }
                this.sendStone(5);
            }
            if (this.isSendFreeze30) {
                if (this.zoneMap != null) {
                    this.zoneMap.chat(this, mResources.PHET);
                }
                this.sendFreeze(5);
            }
        }
        //Socola
        this.timeSendSocola30 -= this.delay;
        if (this.timeSendSocola30 <= 0) {
            this.timeSendSocola30 = 30000;
            if (this.isSendSocola30) {
                if (this.zoneMap != null) {
                    this.zoneMap.chat(this, mResources.UM_BA_LA);
                }
                this.sendSocola(15);
            }
        }
        //Cute hoi ki
        this.timeCuteUpKI -= this.delay;
        if (this.timeCuteUpKI <= 0) {
            this.timeCuteUpKI = 1000;
            if (this.cuteUpKI > 0) {
                if (this.cMP < this.cMPFull) {
                    this.upMP((int) ((long)this.cMPFull * (long)this.cuteUpKI / 100L));
                    if (this.session != null) {
                        this.session.service.meLoadMP(this.cMP);
                    }
                }
                this.cute(this.cuteUpKI);
            }
        }
        //Phat no
        if (this.timeExplode > 0) {
            if (this.isDie && this.zoneMap != null) {
                this.timeExplode -= this.delay;
                if (this.timeExplode <= 0) {
                    this.timeExplode = 0;
                    this.explode();
                }
            } else {
                this.timeExplode = 0;
            }
        }
        if (this.timeStone > 0) {
            this.timeStone -= this.delay;
            if (this.timeStone <= 0) {
                this.timeStone = 0;
            }
        }
        //Khoc
        if (this.zoneMap != null && this.cry) {
            this.cry = false;
            this.zoneMap.chat(this, mResources.CRY);
        }
        //Nhiem vu sm
        if (this.zoneMap != null) {
            dragon.t.MeTask.checkTask(this, (int) delay);
        }
        //Noi kore
        if (this.zoneMap != null && this.nNoiKore > 0) {
            this.timeNoiKore -= this.delay;
            if (this.timeNoiKore <= 0) {
                this.timeNoiKore = 3000;
                if (this.nNoiKore == 4) {
                    this.zoneMap.chat(this, mResources.WHO_ARE_YOU);
                }
                if (this.nNoiKore == 3) {
                    this.zoneMap.chat(this, mResources.NO_FEELING);
                }
                if (this.nNoiKore == 2) {
                    this.zoneMap.chat(this, mResources.ROBOT_KNOWN);
                }
                if (this.nNoiKore == 1) {
                    this.zoneMap.chat(this, mResources.HE_NOT_CANCEL);
                }
                this.nNoiKore--;
            }
        }
        //Live
        if (this.timeLive != -1 && this.isDie && this.zoneMap != null) {
            this.timeLive -= this.delay;
            if (this.timeLive <= 0) {
                this.timeLive = this.timeSetLive;
                this.liveFromDead(2);
            }
        }
        //Qua ngay
        if (this.zoneMap != null && this.yesterday > 0) {
            if (Util.gI().getDayGap(this.yesterday) > 0) {
                this.updateDay();
            }
        }
        //Qua nhieu skill
        this.is100Miss = System.currentTimeMillis() - this.lSSkill < 100;
        
        //Update map Offline
        if (!this.mapOfflines.isEmpty()) {
            for (int i1 = 0; i1 < this.mapOfflines.size(); i1++) {
                this.mapOfflines.get(i1).delays = this.delay;
                this.mapOfflines.get(i1).update();
            }
        }
        //Delay call rong
        if (this.countCallDragon > 0) {
            this.timeCallDragon -= this.delay;
            if (this.timeCallDragon <= 0) {
                this.timeCallDragon = 500;
                this.countCallDragon--;
            }
        }
        //Khong con tre con
        if (!this.me && this.myPetz().isBaby && this.myPetz().cPower >= 1500000) {
            this.myPetz().isBaby = false;
            this.myPetz().headDefault = -1;
            this.updateAll();
            if (this.myPetz().zoneMap != null) {
                this.myPetz().zoneMap.playerLoadAll(this.myPetz());
            }
        }
        //Co thoi gian qua nhiem vu
        if (this.isNextTask) {
            this.tNextTask -= this.delay;
            if (this.tNextTask <= 0) {
                this.finishTask();
            }
        }
        //Lanh
        this.tColdTalk -= this.delay;
        if (this.tColdTalk <= 0) {
            this.tColdTalk = 10000;
            if (this.zoneMap != null && this.isCold && !this.isKhienCold && !this.isTemplate) {
                if (Util.gI().nextInt(100) < 50)  {
                    this.zoneMap.chat(this, mResources.COLD_1);
                } else {
                    this.zoneMap.chat(this, mResources.COLD_2);
                }
            }
        }
        //Ve nha
        if (this.zoneMap != null && this.tToHome > 0) {
            this.updateGoHome();
        }
        //Giam toc do
        if (this.tDownSpeed > 0) {
            this.tDownSpeed -= this.delay;
            if (this.tDownSpeed <= 0) {
                this.tDownSpeed = 0;
                this.updateAll();
                this.session.service.meLoadPoint();
                if (this.zoneMap != null) {
                    this.zoneMap.playerLoadAll(this);
                }
            }
        }
        if (!this.isTemplate && this.zoneMap != null && this.zoneMap.mapTemplate.tileID == 28) {
            this.updateStab();
        }
        //Delay ky gui
        if (this.timeKyGui > 0) {
            this.timeKyGui -= this.delay;
            if (this.timeKyGui <= 0) {
                this.timeKyGui = 0;
            }
        }
        //delay sat thuong chi mang
        this.tPetzStCrit -= this.delay;
        if (this.tPetzStCrit <= 0) {
            this.tPetzStCrit = 120000;
            if (this.usePetFollowz != null && this.usePetFollowz.template.id == 2013) {
                this.setText(5, String.format(mResources.DAMAGE_CRIT, 1 + this.usePetFollowz.getParamOption(72)), 30, 0, 1 + this.usePetFollowz.getParamOption(72));
            }
        }
        //delay khang sat thuong chi mang
        this.tPetzAgainsStCrit -= this.delay;
        if (this.tPetzAgainsStCrit <= 0) {
            this.tPetzAgainsStCrit = 60000;
            if (this.usePetFollowz != null && this.usePetFollowz.template.id == 2014) {
                this.setText(6, mResources.AGAINST_DAMAGE_CRIT, 1 + this.usePetFollowz.getParamOption(72), 0, 0);
            }
        }
        //Co dang danh khong
        if (this.isAttackting > 0) {
            this.isAttackting -= this.delay;
            if (this.isAttackting <= 0) {
                    this.isAttackting = 0;
            }
            this.timeAttackting += this.delay;
        }
    }
    
    public void changePoint() {
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (Memory.get(this.session.userId).pointEvent2 < 50) {
            this.addInfo1(mResources.KHONG_DU_DIEM);
        } else {
            Memory.get(this.session.userId).pointEvent2 -= 50;
            if (Util.gI().nextInt(100) < 1) {
                    int id_934 = new int[]{1087, 1088 ,1091}[Util.gI().nextInt(3)];
                this.addItemBag(0, new Item(id_934, false, 1, ItemOption.getOption(id_934, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
            } else if (Util.gI().nextInt(100) < 25) {
                this.addItemBag(0, new Item(987, false, 1, ItemOption.getOption(987, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
            } else {
                int id_935 = new int[]{1087, 1088 ,1091}[Util.gI().nextInt(3)];
                this.addItemBag(0, new Item(id_935, false, 1, ItemOption.getOption(id_935, 15, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
            }
        }
    }
    
    public void exitMap() {
        //Hieu ung troi
        if (this.holder_charId != -1) {
            Char player443 = this.zoneMap.findCharInMap(this.holder_charId);
            if (player443 != null) {
                player443.hold(0, 0, 32, -1, -1);
            }
            this.hold(0, 0, 32, -1, -1);
        }
        //Bo troi neu thoat map
        if (this.mobId_holder != -1 || this.charId_holder != -1) {
            Mob mob34 = this.zoneMap.getMobIdHold(this.charID);
            if (mob34 != null) {
                mob34.hold(0, 0, 32, -1);
            }
            Char player34 = this.zoneMap.getCharIdHold(this.charID);
            if (player34 != null) {
                player34.hold(0, 0, 32, -1, -1);
            }
            this.hold(0, 0, 32, -1, -1);
            this.mobId_holder = -1;
            this.charId_holder = -1;
        }
        this.petJoin = 0;
        //cho thua neu roi map
        if (this.myPet3 != null) {
            this.compMyPet3();
        }
        //ket thuc thach dau va thua cuoc
        this.loser(3);
        //eff
        this.isEggEffHide = false;
        this.isEggEffStr = false;
        this.timeOutPrize = 0;
        this.isWaitWar = false;
        //huy autoXY
        this.isAutoXY = false;
        //huy dau
        this.superRankName = null;
        this.typeThachDau = 0;
        this.isChuyenMap = false;
        //xoa menu
        if (this.session != null) {
            this.resetMenu();
            this.requestItem = null;
        }
        //xoa shop
        this.shopId = -1;
        this.isThaCau = 0;
        //Xoa menu
        this.resetMenu();
        //Duong tang
        this.isHideDuongTang = false;
        //Waypoint
        this.isCheckWaypoint = false;
        this.timeGoMapHoangMac = 0;
        //xoa wait zone
        this.waitJoinZone = null;
        //Xoa
        this.removeAllByAction(0);
        //Ket thuc oan tu ti
        this.closeRPS(1);
    }
    
    public boolean requestOpenUIItem(int npcId, String tile, int[] templateId, int[] quantity, int typeBoeard, int coin, int ngoc, boolean isUse, int quntityEmptyBag) {
        if (quntityEmptyBag != -1 && quntityEmptyBag > this.getEmptyBagCount()) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, quntityEmptyBag));
            return false;
        }
        boolean flag = false;
            for (int i1 = 0; i1 < templateId.length; i1++) {
                if (this.getItemBagQuantityById(templateId[i1]) < quantity[i1]) {
                    flag = true;
                    break;
                }
            }
        if (flag || (coin != -1 && this.xu < coin) || (ngoc != -1 && this.getLuong() < ngoc)) {
            this.resetMenu();
            this.menuBoard.chat = "|1|"+tile;
            for (int i2 = 0; i2 < templateId.length; i2++) {
                this.menuBoard.chat += "\n|"+(this.getItemBagQuantityById(templateId[i2]) >= quantity[i2] ? 2 : 7)+"|"+ItemTemplate.get((short)templateId[i2]).name+" "+this.getItemBagQuantityById(templateId[i2])+"/"+quantity[i2];
            }
            if (coin != -1) {
                this.menuBoard.chat += "\n|"+(this.xu >= coin ? 2 : 7)+"| Giá vàng: "+Util.gI().getFormatNumber(coin);
            }
            if (ngoc != -1) {
                this.menuBoard.chat += "\n|"+(this.getLuong() >= ngoc ? 2 : 7)+"| Giá ngọc: "+Util.gI().getFormatNumber(ngoc);
            }
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, typeBoeard));
            this.menuBoard.openUIConfirm(npcId, null, null, -1);
            return false;
        }
        if (isUse) {
            for (int i3 = 0; i3 < templateId.length; i3++) {
                this.useItemBagById(templateId[i3], quantity[i3]);
            }
            if (coin != -1) {
                this.updateXu(-coin, 2);
            }
            if (ngoc != -1) {
                this.updateLuong(-ngoc, 2);
            }
        }
        return true;
    }
    
    public boolean isHaveNauBanhById(int id) {
        for (int i = 0; i < this.myObj().arrBanh.size(); i++) {
            if (this.myObj().arrBanh.get(i).id == id) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isNauBanhOK() {
        for (int i = 0; i < this.myObj().arrBanh.size(); i++) {
            if (this.myObj().arrBanh.get(i).finish) {
                return true;
            }
        }
        return false;
    }
    
    public String strNauBanhOK() {
        for (int i = 0; i < this.myObj().arrBanh.size(); i++) {
            if (this.myObj().arrBanh.get(i).finish) {
                return this.myObj().arrBanh.get(i).text;
            }
        }
        return null;
    }
    
    public Item itemNauBanhOK() {
        for (int i = 0; i < this.myObj().arrBanh.size(); i++) {
            if (this.myObj().arrBanh.get(i).finish) {
                return this.myObj().arrBanh.get(i).item;
            }
        }
        return null;
    }
    
    public void removeNauBanhOK() {
        for (int i = 0; i < this.myObj().arrBanh.size(); i++) {
            if (this.myObj().arrBanh.get(i).finish) {
                this.myObj().arrBanh.remove(i);
                return;
            }
        }
    }
    
    private void updateNoiBanh() {
        if (!this.myObj().arrBanh.isEmpty()) {
            for (int i = 0; i < this.myObj().arrBanh.size(); i++) {
                if (!this.myObj().arrBanh.get(i).finish && this.myObj().arrBanh.get(i).time < System.currentTimeMillis()) {
                    this.addInfo1(mResources.FINISH_BANH);
                    this.myObj().arrBanh.get(i).finish = true;
                }
            }
        }
    }
    
    public void addNauBanh(int npcId, int sc, int id) {
        if (npcId != -1) {
            this.resetMenu();
            this.menuBoard.chat = String.format(mResources.START_NAU_BANH, Util.gI().getStrTime((long)sc * 1000L));
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
            this.menuBoard.openUIConfirm(npcId, null, null, -1);
        }
        Item item = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
        String text = String.format(mResources.NHAN_ITEM, item.template.name);
        if (id == 752) {
            text = mResources.NHAN_BANH_TET;
            this.setItem(7095, sc, 2, 0);
        }
        if (id == 753) {
            text = mResources.NHAN_BANH_CHUNG;
            this.setItem(7096, sc, 2, 0);
        }
        //Lech Teamobi
        if (id == 1997) {
            text = mResources.NHAN_BANH1;
            this.setItem(6704, sc, 2, 0);
        }
        if (id == 1998) {
            text = mResources.NHAN_BANH2;
            this.setItem(6462, sc, 2, 0);
        }
        this.myObj().addNauBanh(sc, id, text, item);
    }
    
    
    public boolean setMove(int type, int tox, int toy, int dx, int status, int delayMove) {
        if (!this.zoneMap.mapTemplate.isCollisionPixel(tox, toy - 1, this.pixels)) {
            return false;
        }
        this.isMove = true;
        if (this.moveAutos == null) this.moveAutos = new ArrayList<>();
        int x0 = this.cx, y0 = this.cy, dir = (byte) (x0 < tox ? 1 : -1);
        while (x0 != tox || y0 != toy) {
            x0 += (dir * dx);
            if (Math.abs(x0 - tox) <= dx) {
                x0 = tox;
            }
            y0 = toy;
            if (status == 1) {
                this.moveAutos.add(new int[]{type, x0, this.zoneMap.mapTemplate.touchY(x0, y0), 1, delayMove});
            } else {
                this.moveAutos.add(new int[]{type, x0, y0, 1, delayMove});
            }
        }
        return true;
    }
    
    private void updateOngGia() {
        //Phat qua
        if (this.zoneMap != null && this.isSendGift) {
            this.timeSendGift -= this.delay;
            if (this.timeSendGift <= 0) {
                this.isSendGift = false;
                Item item = new Item(648, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, 7));
                ItemMap itemMap = this.zoneMap.addItemMap(-1, item, this.cx, this.zoneMap.mapTemplate.touchY(this.cx, this.cy), 0, -1);
                this.zoneMap.playerThrow(this.charID, itemMap.itemMapID, itemMap.item.template.id, itemMap.x, itemMap.y);
                this.nSendGift++;
            }
        }
        //Doi map
        if (this.zoneMap != null && this.nSendGift >= 3) {
            this.zoneMap.chat(this, "Bye bye");
            this.nSendGift = 0;
            int num = 0;
            while(num++ < 100) {
                try {
                    Map map = Map.getMapServer(this.arrInMap[Util.gI().nextInt(this.arrInMap.length)]);
                    ZoneMap zone = map.zones.get(Util.gI().nextInt(20));
                    if (zone.countBossById(125) > 0) {
                        continue;
                    }
                    this.zoneMap.exit(this, 0);
                    zone.join(this, 0, 150, 150);
                    break;
                } catch (Exception e) {
                }
            }
        }
        if (this.zoneMap != null && !this.isCharge && !this.isSuper && !this.isStand()) {
            if (this.cTemplateId == 125 && this.gameTick % 45 == 0 && !this.isMove) {
                this.setMove(0, Util.gI().nextInt(50, this.zoneMap.mapTemplate.pxw - 50), 150, 50, 1, 200);
            }
            if (this.cTemplateId == 125 && this.gameTick % 300 == 0 && !this.isSendGift) {
                this.addGift(1000, "Hô hô hô");
            }
            if (this.cTemplateType == 38 && this.gameTick % 40 == 0 && !this.isMove && this.isPlayerId == -1) {
                int x = Util.gI().nextInt(this.cx - 100, this.cy + 100);
                if (x < 50) {
                    x = 50;
                } else if (x > this.zoneMap.mapTemplate.pxw - 50) {
                    x = this.zoneMap.mapTemplate.pxw - 50;
                }
                this.setMove(0, x, 150, 50, 1, 200);
            }
        }
        if (this.cTemplateId == 127 && this.zoneMap != null && this.gameTick % 50 == 0) {
            this.addChat(3000, mResources.TUNG_TUNG_TUNG1);
            this.addChat(6000, mResources.TUNG_TUNG_TUNG2);
        }
    }
    
    private void petGoMe(int type, ZoneMap zoneNew, ZoneMap zoneOld, int x, int y) {
        Player o = zoneOld.getBossPlayer(this.playerId);
        if (o != null && !o.isDie) {
            if (o.charTemplate.type == 7 && o.itemBuys.size() > 0) {
                if (Math.abs(o.cx - x) < 70 && type == 0) {
                    o.zoneMap.exit(o, 0);
                    zoneNew.join(o, 0, this.cx, this.cy);
                }
            } else if (o.charTemplate.type == 9) {
                if (Math.abs(o.cx - x) < 70 && type == 0) {
                    o.zoneMap.exit(o, 0);
                    zoneNew.join(o, 0, this.cx, this.cy);
                }
            } else if (o.charTemplate.type == 38) {
                if (Math.abs(o.cx - x) < 300 && type == 0) {
                    o.zoneMap.exit(o, 0);
                    zoneNew.join(o, 0, this.cx, this.cy);
                }
            } else {
                o.zoneMap.exit(o, 0);
                zoneNew.join(o, 0, this.cx, this.cy);
            }
        }
    }
    
    public void wayPoint() {
        Waypoint waypoint = this.zoneMap.getWaypoint(this);
        if (waypoint != null) {
            Util.gI().log("Go MapID="+waypoint.goMapId);
            Map map;
            if (this.zoneMap.map.phoban != null) {
                map = this.zoneMap.map.phoban.getMap(waypoint.goMapId);
            } else if (this.zoneMap.map.isMapKhoBau()) {
                map = this.zoneMap.map.getMapKhoBau(waypoint.goMapId);
            } else if (this.zoneMap.map.isMapDestronGas()) {
                map = this.zoneMap.map.getMapDestronGas(waypoint.goMapId);
            } else if (this.zoneMap.map.isMapDoanhTrai() && waypoint.goMapId != 27) {
                map = this.zoneMap.map.getMapDoanhTrai(waypoint.goMapId);
            } else if (Map.isMapOffline(waypoint.goMapId)) {
                map = this.getMapOffline(waypoint.goMapId);
            } else {
                map = Map.getMapServer(waypoint.goMapId);
            }
            if (map != null) {
                ZoneMap zoneNew = map.getZone(this);
                wp:
                {
                    if (zoneNew == null) {
                        this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                        break wp;
                    }
                    if (!map.isOpen) {
                        this.addInfo1(mResources.NOT_GO_MAP);
                        break wp;
                    }
                    if (!dragon.t.MapTask.isNextMap(this, map.mapId)) {
                        this.addInfo1(mResources.YOUR_NOT_TO);
                        break wp;
                    }
                    // delay nrnm
                    if (this.itemNamekBall != null && this.timeNextMapNamek > System.currentTimeMillis()) {
                        this.addInfo1(mResources.DELAY_NEXT_MAP_NAMEK);
                        break wp;
                    }
                    //OK go
                    if (!zoneNew.map.isMapNamekBall() && this.itemNamekBall != null) {
                        this.throwNamekBall();
                    }
                    short xOld = (short) (this.wpX = this.cx);
                    short yOld = (short) (this.wpY = this.cy);
                    ZoneMap zoneOld = this.zoneMap;
                    if (this.zoneMap.map.templateId == 149) {
                        this.transPort(-1, 1, zoneNew, 0, 0, waypoint.goX, waypoint.goY);
                    } else {
                        this.zoneMap.exit(this, 0);
                        zoneNew.join(this, 0, waypoint.goX, waypoint.goY);
                    }
                    this.petGoMe(0, zoneNew, zoneOld, xOld, yOld);
                    return;
                }
                //quay lai vi tri cu
                boolean isSetXY = false;
                for (int i = 0; i < MapTemplate.arrMapTemplate[map.mapId].arrWaypoint_goMapID.length; i++) {
                    if (MapTemplate.arrMapTemplate[map.mapId].arrWaypoint_goMapID[i] == this.mapTemplateId) {
                        this.cx = MapTemplate.arrMapTemplate[map.mapId].arrWaypoint_goX[i];
                        this.cy = MapTemplate.arrMapTemplate[map.mapId].arrWaypoint_goY[i];
                        isSetXY = true;
                    }
                }
                if (!isSetXY) {
                    this.cx = 120;
                    this.cy = 336;
                }
                this.session.service.resetPont(this.cx, this.cy);
            }
        }
    }
    
    public void duaPet() {
        if (this.getEmptyBagCount() != 0) {
            //Xoa pet
            this.isGiaoCho = false;
            this.isPetThiTheo = false;
            Player o = this.zoneMap.getBossPlayer(this.playerId);
            if (o != null) {
                o.timeClear = 1;
                if (o.cTemplateId == 127) {
                    this.quaLanCon();
                }
            }
            //End
        } else {
            this.addInfo1(mResources.BAG_FULL);
        }
    }
    
    public void addGift(int time, String chat) {
        this.isSendGift = true;
        this.timeSendGift = time;
        this.zoneMap.chat(this, chat);
    }
    
    private void quaLanCon() {
        this.addItemBag(0, new Item(758, false, 1, ItemOption.getOption(758, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
    }
    
    private void updateReGo() {
        if (this.isPlayerId == -1) {
            if (this.timeRego > 0) {
                this.timeRego -= this.delay;
                if (this.timeRego <= 0) {
                    this.dirRego = 15;
                    this.xRego = (short) this.cx;
                }
            } else {
                if (this.dirRego > 0) {
                    this.dRego -= delay;
                    if (this.dRego <= 0) {
                        if (this.dirRego % 2 == 0) {
                            this.addMove(0, this.xRego + 40, -1, 0);
                        } else {
                            this.addMove(0, this.xRego - 40, -1, 0);
                        }
                        this.dirRego--;
                        this.dRego = 300;
                    }
                    if (this.dirRego <= 0) {
                        this.timeRego = 5000;
                    }
                }
            }
        }
    }
    
    public void goTramTauTraiDat() {
        Map map = Map.getMapServer(24);
        if (map != null) {
            ZoneMap tile28 = map.getZone(this);
            if (tile28 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile28.join(this, this.typeTeleport, Util.gI().nextInt(400, 444), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goTramTauNamek() {
        Map map = Map.getMapServer(25);
        if (map != null) {
            ZoneMap tile211 = map.getZone(this);
            if (tile211 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile211.join(this, this.typeTeleport, Util.gI().nextInt(400, 444), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goTramTauXayda() {
        Map map = Map.getMapServer(26);
        if (map != null) {
            ZoneMap tile299 = map.getZone(this);
            if (tile299 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile299.join(this, this.typeTeleport, Util.gI().nextInt(400, 444), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goSieuThi() {
        Map map = Map.getMapServer(84);
        if (map != null) {
            ZoneMap tile29 = map.getZone(this);
            if (tile29 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile29.join(this, this.typeTeleport, Util.gI().nextInt(400, 444), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goKaiO() {
        Map map = this.getMapOffline(48);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, 0);
                tile25.join(this, 0, 372, 240);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goPlanetBill() {
        Map _surg_ = this.getMapOffline(154);
        if (_surg_ != null) {
            ZoneMap sdovi_ = _surg_.getZone(this);
            if (sdovi_ != null) {
                this.zoneMap.exit(this, 0);
                sdovi_.join(this, 0, 220, 300);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goDaoKame2() {
        Map vzxi_1 = Map.getMapServer(5);
        if (vzxi_1 != null) {
            ZoneMap sdi_5 = vzxi_1.getZone(this);
            if (sdi_5 != null) {
                this.zoneMap.exit(this, 0);
                sdi_5.join(this, 0, 1205, 320);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goDaoKame() {
        Map vzxi_1 = Map.getMapServer(5);
        if (vzxi_1 != null) {
            ZoneMap sdi_5 = vzxi_1.getZone(this);
            if (sdi_5 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                sdi_5.join(this, this.typeTeleport, 880, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goCold() {
        Map map = Map.getMapServer(109);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile25.join(this, this.typeTeleport, Util.gI().nextInt(400, 444), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goNappa() {
        Map map = Map.getMapServer(68);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile25.join(this, this.typeTeleport, Util.gI().nextInt(80, 120), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goVegetaCity() {
        Map map = Map.getMapServer(19);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile25.join(this, this.typeTeleport, Util.gI().nextInt(1100, 1140), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goPlanetKaio() {
        Map map = this.getMapOffline(48);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile25.join(this, this.typeTeleport, Util.gI().nextInt(350, 400), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goThanDien() {
        Map map = this.getMapOffline(45);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile25.join(this, this.typeTeleport, Util.gI().nextInt(350, 400), 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goThanDien2() {
        Map map = this.getMapOffline(45);
        if (map != null) {
            ZoneMap zone = map.getZone(this);
            if (zone != null) {
                this.zoneMap.exit(this, 2);
                zone.join(this, 2, 350, 408);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goSanKaio() {
        Map map = this.getMapOffline(50);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, 0);
                tile25.join(this, 0, 309, 336);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goSanKaio2() {
        Map _vdoj_ = this.getMapOffline(50);
        if (_vdoj_ != null) {
            ZoneMap ___vud = _vdoj_.getZone(this);
            if (___vud != null) {
                this.zoneMap.exit(this, 0);
                ___vud.join(this, 0, 240, 300);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goDaiHoiVoThuat() {
        Map map543 = Map.getMapServer(129);
        if (map543 != null) {
            ZoneMap zone294 = map543.getZone(this);
            if (zone294 != null) {
                this.zoneMap.exit(this, 0);
                zone294.join(this, 0, Util.gI().nextInt(300, 400), 360);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goDaiHoi() {
        Map map544 = Map.getMapServer(52);
        if (map544 != null) {
            ZoneMap zone295 = map544.getZone(this);
            if (zone295 != null) {
                this.zoneMap.exit(this, 0);
                zone295.join(this, 0, Util.gI().nextInt(300, 400), 336);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goDaiHoi2() {
        Map dovi9 = Map.getMapServer(52);
        if (dovi9 != null) {
            ZoneMap _9ergu = dovi9.getZone(this);
            if (_9ergu != null) {
                this.zoneMap.exit(this, 0);
                _9ergu.join(this, 0, 176, 336);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goPortSpace1() {
        Map map = Map.getMapServer(114);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, 0);
                tile25.join(this, this.typeTeleport, 200, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goPortSpace2() {
        Map map = Map.getMapServer(127);
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, 0);
                tile25.join(this, this.typeTeleport, 200, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goPrisonPalnet() {
        Map i298fu_ = Map.getMapServer(155);
        if (i298fu_ != null) {
            ZoneMap vdb_ = i298fu_.getZone(this);
            if (vdb_ != null) {
                this.zoneMap.exit(this, 0);
                vdb_.join(this, 0, 155, 792);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goMarble() {
        Map map = Map.getMapServer(122);
        if (map != null) {
            ZoneMap tile215 = map.getZone(this);
            if (tile215 != null) {
                this.zoneMap.exit(this, 0);
                tile215.join(this, 0, 45, 300);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goAru() {
        Map map = Map.getMapServer(0);
        if (map != null) {
            ZoneMap tile216 = map.getZone(this);
            if (tile216 != null) {
                this.zoneMap.exit(this, 0);
                tile216.join(this, 0, 580, 432);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goHome() {
        Map map = this.getMapOffline(this.mainHome());
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile25.join(this, this.typeTeleport, 350, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goHome2() {
        Map map = this.getMapOffline(this.mainHome());
        if (map != null) {
            ZoneMap tile25 = map.getZone(this);
            if (tile25 != null) {
                this.zoneMap.exit(this, 0);
                tile25.join(this, 0, 350, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goYardart() {
        Map map = Map.getMapServer(131);
        if (map != null) {
            ZoneMap tile27 = map.getZone(this);
            if (tile27 != null) {
                this.zoneMap.exit(this, 0);
                tile27.join(this, this.typeTeleport, 933, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goMonkeyGold() {
        Map map = Map.getMapServer(80);
        if (map != null) {
            ZoneMap tile27 = map.getZone(this);
            if (tile27 != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                tile27.join(this, this.typeTeleport, 850, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goManorClan() {
        Map isaov_i = Map.getMapServer(156);
        if (isaov_i != null) {
            ZoneMap vdi_8 = isaov_i.getZone(this);
            if (vdi_8 != null) {
                this.transPort(-1, 1, vdi_8, 0, this.typeTeleport, 200, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void downRoom() {
        if (Server.gI().isButcher && this.collectPoint >= 10) {
            Map map = null;
            if (this.mapTemplateId == 114) {
                map = Map.getMapServer(115);
            }
            if (this.mapTemplateId == 115) {
                map = Map.getMapServer(117);
            }
            if (this.mapTemplateId == 117) {
                map = Map.getMapServer(118);
            }
            if (this.mapTemplateId == 118) {
                map = Map.getMapServer(119);
            }
            if (this.mapTemplateId == 119) {
                map = Map.getMapServer(120);
            }
            if (map != null) {
                ZoneMap tile25 = map.getZone(this);
                if (tile25 != null) {
                    this.zoneMap.exit(this, 0);
                    tile25.join(this, 0, 360, 150);
                } else {
                    this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                }
            }

        }
    }
    
    public void goSanTaCity() {
        Map map = Map.getMapServer(126);
        if (map != null) {
            ZoneMap tile211 = map.zones.get(Util.gI().nextInt(map.zones.size()));
            if (tile211 != null) {
                if (tile211.getCountPLayerNotAI() >= tile211.maxPlayer) {
                    this.session.service.startOKDlg(mResources.ZONE_FULL_PLAYER);
                } else {
                    this.zoneMap.exit(this, 0);
                    tile211.join(this, 0, 180, 360);
                }
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goVegetaCity2() {
        Map map = Map.getMapServer(19);
        if (map != null) {
            ZoneMap tile211 = map.getZone(this);
            if (tile211 != null) {
                this.zoneMap.exit(this, 0);
                tile211.join(this, 0, 1100, 360);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void addOptionHide(Item item, int numOption) {
        int[] array = new int[]{80, 19, 3, 81, 5, 114, 42, 43, 44, 45, 46, 197, 198, 199, 200, 201, 202, 203, 204};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i3 = 0; i3 < array.length; i3++) {
            list.add(array[i3]);
        }
        for (int i4 = 0; i4 < numOption; i4++) {
            int num2 = list.remove(Util.gI().nextInt(list.size()));
            ItemOption option2 = new ItemOption(num2, Util.gI().nextInt(1, Util.gI().nextInt(3, 5)));
            item.options.add(option2);
        }
    }
    
    private void updateJoin() {
        if (this.cTemplateId == 127) {
            if (this.isPlayerId != -1) {
                this.petJoin += this.delay;
                if (this.petJoin >= 300000) {
                    Session_ME player = Server.gI().getByPId(this.isPlayerId);
                    if (player != null) {
                        player.myCharz().addInfo1(String.format(mResources.FALID_PET_DI_THEO, this.cName));
                        player.myCharz().isPetThiTheo = false;
                    }
                    this.isPlayerId = -1;
                    this.setMove(0, Util.gI().nextInt(50, this.zoneMap.mapTemplate.pxw - 50), 150, 50, 1, 200);
                }
            } else {
                this.petJoin = 0;
            }
        }
    }
    
    public Map getMapOffline(int mapTemplateId) {
        for (int i = 0; i < this.mapOfflines.size(); i++) {
            if (this.mapOfflines.get(i).templateId == mapTemplateId) {
                return this.mapOfflines.get(i);
            }
        }
        return null;
    }
    
    public void openTransport(int type) {
        this.transports = new ArrayList<>();
        if (type == 0) {
            //Quay ve cho cu
            if (this.transportOld != null && this.transportOld.map.templateId != 21 && this.transportOld.map.templateId != 22 && this.transportOld.map.templateId != 23) {
                this.transports.add(new Transport(type, String.format(mResources.GO_BACK, this.transportOld.mapName), this.transportOld.planet, this.transportOld.map, this.transportOld.zone, this.transportOld.xGo, this.transportOld.yGo, this.typeTeleport));
            }
            //Ve nha
            if (this.cgender == 0 && this.mapTemplateId != 21) {
                this.transports.add(new Transport(type, mResources.GO_HOME, mResources.THE_EARTH, this.getMapOffline(21), null, 300, 5, this.typeTeleport));
            }
            if (this.cgender == 1 && this.mapTemplateId != 22) {
                this.transports.add(new Transport(type, mResources.GO_HOME, mResources.NAMEK, this.getMapOffline(22), null, 300, 5, this.typeTeleport));
            }
            if (this.cgender == 2 && this.mapTemplateId != 23) {
                this.transports.add(new Transport(type, mResources.GO_HOME, mResources.XAYDA, this.getMapOffline(23), null, 300, 5, this.typeTeleport));
            }
            //Rung Karin
            if (this.mapTemplateId != 47) {
                this.transports.add(new Transport(type, this.getMapOffline(47).template.mapName, mResources.THE_EARTH, this.getMapOffline(47), null, 300, 5, this.typeTeleport));
            }
            //Than dien
            if (this.mapTemplateId != 45) {
                this.transports.add(new Transport(type, this.getMapOffline(45).template.mapName, mResources.THE_EARTH, this.getMapOffline(45), null, 350, 5, this.typeTeleport));
            }
            //Lang Aru
            if (this.mapTemplateId != 0) {
                this.transports.add(new Transport(type, Map.getMapServer(0).template.mapName, mResources.THE_EARTH, Map.getMapServer(0), null, 200, 5, this.typeTeleport));
            }
            //Lang Morri
            if (this.mapTemplateId != 7) {
                this.transports.add(new Transport(type, Map.getMapServer(7).template.mapName, mResources.NAMEK, Map.getMapServer(7), null, 400, 5, this.typeTeleport));
            }
            //Lang Kakarot
            if (this.mapTemplateId != 14) {
                this.transports.add(new Transport(type, Map.getMapServer(14).template.mapName, mResources.XAYDA, Map.getMapServer(14), null, 300, 5, this.typeTeleport));
            }
            //Dao Kame
            if (this.mapTemplateId != 5) {
                this.transports.add(new Transport(type, Map.getMapServer(5).template.mapName, mResources.THE_EARTH, Map.getMapServer(5), null, 200, 5, this.typeTeleport));
            }
            //Vach nui den
            if (this.mapTemplateId != 20) {
                this.transports.add(new Transport(type, Map.getMapServer(20).template.mapName, mResources.XAYDA, Map.getMapServer(20), null, 200, 5, this.typeTeleport));
            }
            //Dao Gurru
            if (this.mapTemplateId != 13) {
                this.transports.add(new Transport(type, Map.getMapServer(13).template.mapName, mResources.NAMEK, Map.getMapServer(13), null, 200, 5, this.typeTeleport));
            }
            //Tram tau vu tru
            if (this.cgender == 0 && this.mapTemplateId != 24) {
                this.transports.add(new Transport(type, Map.getMapServer(24).template.mapName, mResources.THE_EARTH, Map.getMapServer(24), null, 300, 5, this.typeTeleport));
            }
            if (this.cgender == 1 && this.mapTemplateId != 25) {
                this.transports.add(new Transport(type, Map.getMapServer(25).template.mapName, mResources.NAMEK, Map.getMapServer(25), null, 300, 5, this.typeTeleport));
            }
            if (this.cgender == 2 && this.mapTemplateId != 26) {
                this.transports.add(new Transport(type, Map.getMapServer(26).template.mapName, mResources.XAYDA, Map.getMapServer(26), null, 300, 5, this.typeTeleport));
            }
            //Rung Bamboo
            if (this.mapTemplateId != 27) {
                this.transports.add(new Transport(type, Map.getMapServer(27).template.mapName, mResources.THE_EARTH, Map.getMapServer(27), null, 150, 5, this.typeTeleport));
            }
            //Thanh pho Vegeta
            if (this.mapTemplateId != 19) {
                this.transports.add(new Transport(type, Map.getMapServer(19).template.mapName, mResources.XAYDA, Map.getMapServer(19), null, 200, 5, this.typeTeleport));
            }
            //Nui khi do
            if (this.mapTemplateId != 79) {
                this.transports.add(new Transport(type, Map.getMapServer(79).template.mapName, mResources.FIDE, Map.getMapServer(79), null, 200, 5, this.typeTeleport));
            }
            //Sieu thi
            if (this.mapTemplateId != 84) {
                this.transports.add(new Transport(type, Map.getMapServer(84).template.mapName, mResources.SHOPPING_HEAVEN, Map.getMapServer(84), null, 200, 5, this.typeTeleport));
            }
            //Hanh tinh bill
            if (this.mapTemplateId != 154) {
                if (this.cPower >= 40000000000L) {
                    this.transports.add(new Transport(type, this.getMapOffline(154).template.mapName, mResources.HOME_BY_BILL, this.getMapOffline(154), null, 780, 5, this.typeTeleport));
                }
            }
            //Dai hoi vo thuat
            if (this.mapTemplateId != 52) {
                this.transports.add(new Transport(type, Map.getMapServer(52).template.mapName, mResources.TRANH_TAI_NHAN_THUONG, Map.getMapServer(52), null, 200, 5, this.typeTeleport));
            }
            
        }
        if (type == 1) {
            this.transports.add(new Transport(type, Map.getMapServer(85).template.mapName, mResources.UNIVERSE, Map.getMapServer(85), null, 100, 100, 0));
            this.transports.add(new Transport(type, Map.getMapServer(86).template.mapName, mResources.UNIVERSE, Map.getMapServer(86), null, 100, 100, 0));
            this.transports.add(new Transport(type, Map.getMapServer(87).template.mapName, mResources.UNIVERSE, Map.getMapServer(87), null, 100, 100, 0));
            this.transports.add(new Transport(type, Map.getMapServer(88).template.mapName, mResources.UNIVERSE, Map.getMapServer(88), null, 100, 100, 0));
            this.transports.add(new Transport(type, Map.getMapServer(89).template.mapName, mResources.UNIVERSE, Map.getMapServer(89), null, 100, 100, 0));
            this.transports.add(new Transport(type, Map.getMapServer(90).template.mapName, mResources.UNIVERSE, Map.getMapServer(90), null, 100, 100, 0));
            this.transports.add(new Transport(type, Map.getMapServer(91).template.mapName, mResources.UNIVERSE, Map.getMapServer(91), null, 100, 100, 0));
        }
        this.session.service.openTransport(this.transports);
    }
    
    public void requestMapSelect(int index) {
        if (this.transports != null && index >= 0 && index < this.transports.size()) {
            Transport tr = this.transports.get(index);
            if ((tr.type == 1 && this.cPower >= 1000000000L) || (tr.type == 0 && this.itemUse != null && (this.itemUse == this.arrItemBag[this.itemUse.indexUI] || this.itemUse == this.arrItemBox[this.itemUse.indexUI]) && (this.itemUse.template.id == 194 || this.itemUse.template.id == 193))) {
                if (!dragon.t.MapTask.isNextMap(this, tr.map.templateId)) {
                    this.addInfo1(mResources.YOUR_NOT_TO);
                } else {
                    ZoneMap zone = tr.zone != null ? tr.zone : tr.map.getZone(this);
                    if (zone != null) {
                        if (zone.map.khobau != null && zone.map.khobau.miliTime <= 0) {
                            this.session.myCharz().addInfo1(mResources.NOT_MAP);
                            return;
                        }
                        if (this.itemNamekBall != null) {
                            this.throwNamekBall();
                        }
                        this.clearPet4();
                        int xTele = tr.xGo;
                        int yTele = tr.yGo;
                        if (tr.type == 0) {
                            if (this.transportOld != null && tr.map.templateId == this.transportOld.map.templateId && index == 0) {
                                this.transportOld = null;
                            } else if (!this.zoneMap.map.isMapTL() && !this.zoneMap.map.isMapDestronGas() && !this.zoneMap.map.isMapDoanhTrai() && !this.zoneMap.map.isMapBigBoss() && !this.zoneMap.map.isMapButcher() && !this.zoneMap.map.isMapMabu() && !this.zoneMap.map.isMapThucVat() && !this.zoneMap.map.isMapManorClan() && !this.zoneMap.map.isMapManor() && !this.zoneMap.map.isMapCace23() && this.mapTemplateId != 51 && this.mapTemplateId != 113 && !this.zoneMap.map.isMapRoadSnake() && this.mapTemplateId != 165) {
                                this.transportOld = new Transport(0, this.zoneMap.mapTemplate.mapName, tr.planet, this.zoneMap.map, this.zoneMap, this.cx, 5, this.typeTeleport);
                            }
                        }
                        this.zoneMap.exit(this, tr.typeTeleport);
                        zone.join(this, tr.typeTeleport, xTele, yTele);
                        if (tr.type == 0) {
                            if (this.itemUse.typeUI == 3) {
                                if (this.itemUse.template.id == 193) {
                                    this.addQuantityItemBagByIndex(this.itemUse.indexUI, -1);
                                }
                                this.session.service.Bag(this.arrItemBag);
                            } else if (this.itemUse.typeUI == 4) {
                                if (this.itemUse.template.id == 193) {
                                    this.addQuantityItemBoxByIndex(this.itemUse.indexUI, -1);
                                    this.session.service.Box(this.arrItemBox);
                                }
                            }
                        }
                    } else {
                        this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                    }
                }
            }
        }
    }
    
    public void goPotaufe() {
        Map map = Map.getMapServer(139);
        if (map != null) {
            ZoneMap zone = map.getZone(this);
            if (zone != null) {
                this.zoneMap.exit(this, this.typeTeleport);
                zone.join(this, this.typeTeleport, 135, 5);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void goDiaNguc() {
        Map map = Map.getMapServer(167);
        if (map != null) {
            ZoneMap zone = map.getZone(this);
            if (zone != null) {
                this.zoneMap.exit(this, 0);
                zone.join(this, 0, 1050, 200);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    public void setClone(Char myChar) {
        this.cName = myChar.cName;
        this.cgender = myChar.cgender;
        this.nClassId = myChar.nClassId;
        this.cspeacialSkill = myChar.cspeacialSkill;
        this.paramSpeacialSkill = myChar.paramSpeacialSkill;
        for (int i = 0; i < myChar.skills.size(); i++) {
            Skill skill = myChar.skills.get(i).clone();
            if (skill.template.id != 9 && skill.template.id != 21) {
                this.skills.add(skill);
            }
        }
        this.resetSkill();
        this.cgender = myChar.cgender;
        this.headDefault = myChar.head;
        this.bodyDefault = myChar.body;
        this.legDefault = myChar.leg;
        this.cHP = this.cHPFull = this.cHPGoc = myChar.cHPFull * 10;
        this.cMP = this.cMPFull = this.cMPGoc = myChar.cMPFull;
        this.cDamGoc = this.cDamFull = myChar.cDamFull;
        this.cDefGoc = this.cDefull = myChar.cDefull;
        this.cCriticalGoc = this.cCriticalFull = myChar.cCriticalFull;
        this.damReturn_percent = this.damReturn_percent_default = myChar.damReturn_percent;
        this.cMissPercent = this.cMissPercentGoc = myChar.cMissPercent;
        this.myChar3 = myChar;
        myChar.myPet3 = (Player) this;
        this.updateAll();
    }
    
    private void updateMyChar3() {
        if (this.timePkMyPet != -1) {
            this.timePkMyPet -= this.delay;
            if (this.timePkMyPet <= 0) {
                this.compMyPet3();
            }
        }
    }
    
    private void updateMyPet3() {
        if (this.gameTick % 200 == 0) {
            this.addChat(1000, mResources.MY_CHANGE_YOU);
        }
    }
    
    public void compMyPet3() {
        this.timePkMyPet = -1;
        this.myPet3.isClear = true;
        this.myPet3 = null;
        if (!this.myObj().isWinClone) {
            this.addInfo1(mResources.YOU_LOSER);
        } else {
            this.addInfo1(mResources.YOU_WIN);
        }
    }
    
    public Char findBossInMapById(int id) {
        synchronized(this.zoneMap.players) {
            for (int i = 0; i < this.zoneMap.players.size(); i++) {
                if (this.zoneMap.players.get(i).isTemplate && this.zoneMap.players.get(i).cTemplateId == id) {
                    return this.zoneMap.players.get(i);
                }
            }
            return null;
        }
    }
    
    private void updateDuaHau() {
        //Trung
        if (this.gameTick % 20 == 0) {
            if (this.isHaveDuaHau(50, -1)) {
                if (this.isHaveDuaHau(50, 4664) && !this.getMapOffline(this.mainHome()).zones.get(0).isHaveNpc(this.getDuaHau(50, 4664).id)) {
                    this.getMapOffline(this.mainHome()).zones.get(0).addNpc(50, 1, this.mainHome() == 21 ? 700 : this.mainHome() == 22 ? 700 : this.mainHome() == 23 ? 688 : 0, 336, 50, 0);
                    this.getMapOffline(this.mainHome()).zones.get(0).findNPCInMap(50).duahau = this.getDuaHau(50, 4664);
                }
                if (this.isHaveDuaHau(50, 6546) && !this.getMapOffline(154).zones.get(0).isHaveNpc(this.getDuaHau(50, 6546).id)) {
                    this.getMapOffline(154).zones.get(0).addNpc(50, 1, 115, 312, 50, 0);
                    this.getMapOffline(154).zones.get(0).findNPCInMap(50).duahau = this.getDuaHau(50, 6546);
                }
            } else {

            }
        }
        //dua hau
        if (this.gameTick % 28 == 0) {
            if (this.isHaveDuaHau(51, -1)) {
                if (!this.getMapOffline(this.mainHome()).zones.get(0).isHaveNpc(this.getDuaHau(51, -1).id)) {
                    this.getMapOffline(this.mainHome()).zones.get(0).addNpc(51, 1, this.mainHome() == 21 ? 574 : this.mainHome() == 22 ? 115 : this.mainHome() == 23 ? 563 : 0, 336, 51, 0);
                    this.getMapOffline(this.mainHome()).zones.get(0).findNPCInMap(51).duahau = this.getDuaHau(51, -1);
                } else {
                    float pDuaHau = (float)((System.currentTimeMillis() / 1000L) - this.getDuaHau(51, -1).last) / (float)this.getDuaHau(51, -1).second;
                    if (pDuaHau >= 1.0F) {
                        this.getDuaHau(51, -1).duaHauIndex = 3;
                    } else if (pDuaHau >= 0.75F) {
                        this.getDuaHau(51, -1).duaHauIndex = 2;
                    } else if (pDuaHau >= 0.50F) {
                        this.getDuaHau(51, -1).duaHauIndex = 1;
                    } else {
                        this.getDuaHau(51, -1).duaHauIndex = 0;
                    }
                    if (this.indexDuaHau != this.getDuaHau(51, -1).duaHauIndex && this.mapTemplateId == this.mainHome()) {
                        this.indexDuaHau = this.getDuaHau(51, -1).duaHauIndex;
                        if (this.session != null) {
                            this.session.service.setStatus(51, this.getDuaHau(51, -1).duahau, this.getDuaHau(51, -1).duaHauIndex, (int) (this.getDuaHau(51, -1).second - ((System.currentTimeMillis() / 1000L) - this.getDuaHau(51, -1).last)));
                        }
                    }
                }
            } else {
            }
        }
    }
    
    public void checkClearPetFollowz(Item item) {
        if (this.myCharz() != null && item == this.myCharz().usePetFollowz) {
            this.myCharz().usePetFollowz(null);
        }
        if (this.myPetz() != null && item == this.myPetz().usePetFollowz) {
            this.myPetz().usePetFollowz(null);
            this.myCharz().updateAll();
            this.myCharz().session.service.meLoadPoint();
            if (this.myCharz().zoneMap != null) {
                this.myCharz().zoneMap.playerLoadAll(this.myCharz());
            }
        }
    }
    
    public boolean isHavePetFollowzs() {
        return (this.myCharz() != null && this.myCharz().usePetFollowz != null) || (this.myPetz() != null && this.myPetz().usePetFollowz != null);
    }
    
    public boolean checkPetFollowz(Item item) {
        return (this.myCharz() != null && item == this.myCharz().usePetFollowz) || (this.myPetz() != null && item == this.myPetz().usePetFollowz);
    }
    
    public void usePetFollowz(Item item) {
        this.myCharz().timeUsePet = 5000;
        if (item == null) {
            this.petFollowz = null;
            this.usePetFollowz = null;
            this.updateAll();
            if (this.session != null) {
                this.session.service.meLoadPoint();
            }
            if (this.zoneMap != null) {
                this.zoneMap.playerLoadAll(this);
                if (this.petFollow != null) {
                    this.zoneMap.petFollow(this.charID, this.petFollow.smallID, this.petFollow.fimg, this.petFollow.frame, this.petFollow.wimg, this.petFollow.himg);
                } else {
                    this.zoneMap.clearPetFollow(this.charID);
                }
            }
        } else {
            if (item.template.id == 2010) {
                this.petFollowz = new PetFollow(6535, 1, new int[]{0, 1, 2, 3, 4, 5, 6}, 75, 75, -1);
            }
            if (item.template.id == 2011) {
                this.petFollowz = new PetFollow(6537, 1, new int[]{0, 1, 2, 3, 4, 5, 6}, 75, 75, -1);
            }
            if (item.template.id == 2012) {
                this.petFollowz = new PetFollow(6539, 1, new int[]{0, 1, 2, 3, 4, 5, 6}, 75, 75, -1);
            }
            if (item.template.id == 2013) {
                this.petFollowz = new PetFollow(6541, 1, new int[]{0, 1, 2, 3, 4, 5, 6}, 75, 75, -1);
            }
            if (item.template.id == 2014) {
                this.petFollowz = new PetFollow(6543, 1, new int[]{0, 1, 2, 3, 4, 5, 6}, 75, 75, -1);
            }
            if (item.template.id == 2015) {
                this.petFollowz = new PetFollow(6545, 1, new int[]{0, 1, 2, 3, 4, 5, 6}, 75, 75, -1);
            }
            this.usePetFollowz = item;
            System.out.println("cName: "+this.cName+" usePetFollowz="+usePetFollowz);
            this.updateAll();
            if (this.session != null) {
                this.session.service.meLoadPoint();
            }
            if (this.zoneMap != null) {
                this.zoneMap.playerLoadAll(this);
                this.zoneMap.petFollow(this.charID, this.petFollowz.smallID, this.petFollowz.fimg, this.petFollowz.frame, this.petFollowz.wimg, this.petFollowz.himg);
            }
        }
    }
    
    private void updateEggEff() {
        //Hide
        if (this.isEggEffHide) {
            this.eggEffHideTick++;
            if (this.eggEffHideTick == 50) {
                this.isEggEffHide = false;
                this.session.service.hideNpc(50, 0);
            } else if (this.eggEffHideTick % 10 == 0) {
                this.session.service.addEffectServer(1, 3, 18, this.eggXHide, this.eggYHide, 1);
            }
        }
        //Truyen linh luc
        if (this.isEggEffStr) {
            this.eggEffStrTick++;
            if (this.eggEffStrTick == 50) {
                this.session.service.setStatus(50, this.arrEggEffStr, this.arrEggEffStrIndex, this.eggScStr);
                this.isEggEffStr = false;
            } else if (this.eggEffStrTick % 10 == 0) {
                this.session.service.addEffectServer(1, 3, 21, this.eggXStr, this.eggYStr, 1);
            }
        }
    }
    
    public void eggEffHide(int eggX, int eggY) {
        this.isEggEffHide = true;
        this.eggEffHideTick = 0;
        this.eggXHide = eggX;
        this.eggYHide = eggY;
    }
    
    public void eggEffStatus(int eggX, int eggY, int[] arrEggEffStr, int arrEggEffStrIndex, int sc) {
        this.isEggEffStr = true;
        this.eggEffStrTick = 0;
        this.eggXStr = eggX;
        this.eggYStr = eggY;
        this.arrEggEffStr = arrEggEffStr;
        this.arrEggEffStrIndex = arrEggEffStrIndex;
        this.eggScStr = sc;
    }
    
    public void resetMenu() {
        if (this.menuBoard != null) {
            this.isItemMore = 0;
            this.menuBoard.typeInfo = 0;
            this.npcId = -1;
            this.menuBoard.chat = mResources.EMPTY;
            this.menuBoard.arrMenu.clear();
            this.menuBoard.avatar = -1;
        }
    }
    
    public void openSelectPetFollowz(Item item) {
        this.arrItem = new Item[]{item};
        this.resetMenu();
        this.menuBoard.chat = mResources.SELECT_PET_FOLLOWZ;
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.USE, 96));
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.USE_PET, 97));
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.CLOSE, 0));
        this.menuBoard.openUIConfirm(5, null, null, -1);
    }
    
    private void updateNamekBall() {
        if (NamekBall.gI().isFossil) {
            this.throwNamekBall();
        } else {
            BallRada rada = BallRada.getById(this.itemNamekBall.template.id);
            if (rada != null) {
                rada.player = this;
                rada.x = this.cx;
                rada.y = this.cy;
                rada.zoneMap = this.zoneMap;
                rada.itemMapID = -1;
            }
        }
    }
    
    public boolean openDoNgocNamek() {
        String str = "";
        int num = 1;
        for (int i = 353; i <= 359; i++) {
            BallRada rada = BallRada.getById(i);
            if (rada != null && !rada.stone) {
                str += (num + " Sao:"+ rada.zoneMap.mapTemplate.mapName +" ("+ rada.x +" m)(kv "+ rada.zoneMap.zoneID +")"+ (rada.player != null ? "("+ rada.player.cName +")" : "") +"\n");
            }
            num++;
        }
        if (str.isEmpty()) {
            this.addInfo1(mResources.NAMEK_BALL_STONE);
            return false;
        } else {
            this.goNamekBallStar++;
            if (this.goNamekBallStar > 7) {
                this.goNamekBallStar = 1;
            }
            this.resetMenu();
            this.menuBoard.chat = str;
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.GO_NAMEK_BALL1, this.goNamekBallStar), 100));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.GO_NAMEK_BALL2, this.goNamekBallStar), 101));
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.THE_END, 0));
            this.menuBoard.openUIConfirm(5, null, null, 2294);
            return true;
        }
    }
    
    public boolean checkFullNamekBall() {
        synchronized(this.zoneMap.players) {
            ArrayList<Short> arrayList = new ArrayList<>();
            for (int i = 0; i < this.zoneMap.players.size(); i++) {
                Char player = this.zoneMap.players.get(i);
                if (player.itemNamekBall != null && !arrayList.contains(player.itemNamekBall.template.id) && player.clan != null && this.clan != null && player.clan.ID == this.clan.ID) {
                    arrayList.add(player.itemNamekBall.template.id);
                }
            }
            return arrayList.size() >= 7;
        }
    }
    
    public void tangBongHoaXanh() {
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (!this.isHaveItemBag(1098)) {
            this.addInfo1(mResources.CAN_BONG_HOA_XANH);
//        } else if (this.myObj().nTangBongHoaXanh >= 200) {
//            this.addInfo1(mResources.TANGHOA_FAILD1);
        } else {
            this.session.service.npcChat(this.menuBoard.npcId, mResources.SAY_THANKS_GIFT);
            this.myObj().nTangBongHoaXanh++;
            this.useItemBagById(1098, 1);
            //qua
            this.updateEXP(2, 1000);
            if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(1104, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(50, Util.gI().nextInt(20,28)));
                item.options.add(new ItemOption(77, Util.gI().nextInt(20,28)));
                item.options.add(new ItemOption(103, Util.gI().nextInt(20,28)));
                item.options.add(new ItemOption(94, Util.gI().nextInt(5,10)));
                item.options.add(new ItemOption(108, Util.gI().nextInt(5,15)));
                item.options.add(new ItemOption(5, Util.gI().nextInt(1,10)));
                item.options.add(new ItemOption(154, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(1105, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                item.options.add(new ItemOption(50, Util.gI().nextInt(20,30)));
                item.options.add(new ItemOption(77, Util.gI().nextInt(20,30)));
                item.options.add(new ItemOption(103, Util.gI().nextInt(20,35)));
                item.options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                item.options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                item.options.add(new ItemOption(5, Util.gI().nextInt(1, 12)));
                item.options.add(new ItemOption(154, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(1106, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);          
                item.options.add(new ItemOption(50, Util.gI().nextInt(20,32)));
                item.options.add(new ItemOption(77, Util.gI().nextInt(20,32)));
                item.options.add(new ItemOption(103, Util.gI().nextInt(20,32)));
                item.options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                item.options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                item.options.add(new ItemOption(5, Util.gI().nextInt(1, 15)));
                item.options.add(new ItemOption(154, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(984, false, 1, ItemOption.getOption(984, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(699, false, 1, ItemOption.getOption(699, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(701, false, 5, ItemOption.getOption(701, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 5) {
                int id = Util.gI().nextInt(712, 716);
                Item item = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(1143, false, 1, ItemOption.getOption(1143, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(1104, false, 1, ItemOption.getOption(1104, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);         
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(120) < 1) {
                Item item = new Item(1105, false, 1, ItemOption.getOption(1105, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(200) < 1) {
                Item item = new Item(1106, false, 1, ItemOption.getOption(1106, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);           
                this.addItemBag(0, item);
            } else{
               int idct = new int[]{1104,1105,1106}[Util.gI().nextInt(3)];
               Item item = new Item(idct, false, 1, ItemOption.getOption(idct, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
               item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
               this.addItemBag(0, item);
            }
            Rank.getRank(3).addTop(this.cName, this.head, this.headICON, this.body, this.leg, this.charID, this.pointEvent += 1, -1);
        }
    }
    
    public void tangChauHoaXanh() {
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (!this.isHaveItemBag(1099)) {
            this.addInfo1(mResources.CAN_CHAU_HOA_XANH);
//        } else if (this.myObj().nTangChauHoaXanh >= 200) {
//            this.addInfo1(mResources.TANGHOA_FAILD2);
        } else {
            this.session.service.npcChat(this.menuBoard.npcId, mResources.SAY_THANKS_GIFT);
            this.myObj().nTangChauHoaXanh++;
            this.useItemBagById(1099, 1);
            //qua
           this.updateEXP(2, 1000);
            if (Util.gI().nextInt(100) < 15) {
                int id = Util.gI().nextInt(1066, 1070); 
                Item item = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 25) {
                Item item = new Item(1039, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item.options.add(new ItemOption(203, Util.gI().nextInt(1,10)));
                item.options.add(new ItemOption(14, 5));
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 25) {
                Item item = new Item(1040, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item.options.add(new ItemOption(94, Util.gI().nextInt(1,10)));
                item.options.add(new ItemOption(14, 5));
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(1114, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item.options.add(new ItemOption(5 , Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                item.options.add(new ItemOption(14, 5));
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(899, false, 1, ItemOption.getOption(899, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(93, 15));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(987, false, 1, ItemOption.getOption(987, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(902, false, 1, ItemOption.getOption(902, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(93, 15));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 25) {
                int id = Util.gI().nextInt(712, 716); 
                Item item = new Item(id , false, 1, ItemOption.getOption(id , 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(673, false, 1, ItemOption.getOption(673, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(997, false, 1, ItemOption.getOption(997, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(998, false, 1, ItemOption.getOption(998, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);         
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(1000, false, 1, ItemOption.getOption(1000, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(16, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(1039, false, 1, ItemOption.getOption(1039, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                mLog.log("Quay ra vv "+item.template.name);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(120) < 1) {
                Item item = new Item(1040, false, 1, ItemOption.getOption(1040, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                mLog.log("Quay ra vv "+item.template.name);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(150) < 1) {
                Item item = new Item(1114, false, 1, ItemOption.getOption(1114, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);   
                 mLog.log("Quay ra vv "+item.template.name);
                this.addItemBag(0, item);    
            } else{
               int id = Util.gI().nextInt(1066, 1070); 
               Item item = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);   
               this.addItemBag(0, item);
            }
           Rank.getRank(3).addTop(this.cName, this.head, this.headICON, this.body, this.leg, this.charID, this.pointEvent += 3, -1);
        }
    }
    
    public void tangBongHoa1(int n) {
        if (this.getItemBagQuantityById(723) != 0 && this.getItemBagQuantityById(723) < n) {
            n = this.getItemBagQuantityById(723);
        }
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (this.getItemBagQuantityById(723) < n) {
            this.addInfo1(String.format(mResources.TANG_HOA_FAILD1, n));
        } else {
            this.session.service.npcChat(this.menuBoard.npcId, mResources.SAY_THANKS_GIFT);
            this.myObj().nPointTang1 += n;
            if (this.myObj().nPointTang1 >= 99) {
                this.myObj().nPointTang1 = 0;
                this.addItemBag(0, new Item(722, false, 1, ItemOption.getOption(722, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                Server.gI().nSendFl1++;
                if (Server.gI().nSendFl1 >= 999) {
                    Server.gI().nSendFl1 = 0;
                    Server.gI().timeTangGift1 += 3600000;
                    if (Server.gI().timeTangGift1 > 3600000) {
                        Server.gI().timeTangGift1 = 3600000;
                    }
                }
            }
            this.useItemBagById(723, n);
            //qua tai day
        }
    }
    
    private void updateOutPrize() {
        if (this.timeOutPrize > 0) {
            this.timeOutPrize -= this.delay;
            if (this.timeOutPrize <= 0) {
                this.timeOutPrize = 0;
                if (this.isDie) {
                    this.liveFromDead(2);
                }
                if (DaiHoi.isWar && DaiHoi.isHaveFighter(this.playerId)) {
                    if (DaiHoi.sizeFighter() > 1) {
                        this.goDaiHoi();
                        this.addInfo1(String.format(mResources.NEXT_TURN8, DaiHoi.nTurn));
                        this.isWaitWar = true;
                    }
                } else {
                    this.goHome();
                    if (this.winOutPrize) {
                        this.winOutPrize = false;
                        this.addInfo1(mResources.YOU_LOSS_PRIZE);
                    }
                }
            }
        }
        if (this.isWaitWar && !DaiHoi.isWar) {
            this.isWaitWar = false;
        }
        if (this.isspeechWar) {
            if (this.aChat.isEmpty()) {
                if (!DaiHoi.isWar) {
                    this.addChat(3000, String.format(mResources.WAR_PRIZE_CHAT1, DaiHoi.getNextHour()));
                } else {
                    if (!DaiHoi.isRegister) {
                        this.addChat(3000, String.format(mResources.WAR_PRIZE_CHAT2, DaiHoi.getNextHour()));
                    } else {
                        this.addChat(3000, String.format(mResources.WAR_PRIZE_CHAT5, Util.gI().convertTime(DaiHoi.timeRegister)));
                    }
                }
                this.addChat(6000, mResources.WAR_PRIZE_CHAT3);
                this.addChat(9000, mResources.WAR_PRIZE_CHAT4);
                if (!DaiHoi.LISTWIN.isEmpty()) {
                    String list = DaiHoi.LISTWIN.get(0);
                    for (int i = 1; i < DaiHoi.LISTWIN.size(); i++) {
                        list += (","+DaiHoi.LISTWIN.get(i));
                    }
                    this.addChat(12000, String.format(mResources.WAR_PRIZE_CHAT6, list));
                }
            }
        }
    }
    public static long getPotentialAdded(int planet, int hpGoc, int kiGoc, int damGoc, int defGoc, int critGoc) {
        long potential = 0;
        labe:
        {
            //hp
            for (int i = planet == 0 ? 200 : planet == 1 ? 100 : planet == 2 ? 100 : 0; i < hpGoc;) {
                potential += (i + 1000);
                i += 20;
            }
            //ki
            for (int i = planet == 0 ? 100 : planet == 1 ? 200 : planet == 2 ? 100 : 0; i < kiGoc;) {
                potential += (i + 1000);
                i += 20;
            }
            //dam
            for (int i = planet == 0 ? 12 : planet == 1 ? 12 : planet == 2 ? 15 : 0; i < damGoc;) {
                potential += (i * 100);
                i += 1;
            }
            //def
            for (int i = 0; i < defGoc;) {
                potential += (500000 + i * 100000);
                i += 1;
            }
            //crit
            for (int i = 0; i < critGoc; i++) {
                long num8 = 50000000L;
                for (int j = 0; j < i; j++) {
                    num8 *= 5L;
                }
                potential += num8;
                i += 1;
            }
        }
        return potential;
    }
    
    private void updateAutoXY() {
        if (this.isAutoXY) {
            this.timeAutoXY -= this.delay;
            if (this.timeAutoXY <= 0) {
                this.timeAutoXY = this.setTimeAutoXY;
                if (this.zoneMap != null) {
                    this.setPos(this.autoX, this.autoY, 1);
                }
            }
        }
    }
    
    public void setAutoXY(boolean auto, int toX, int toY, int time) {
        this.isAutoXY = auto;
        this.autoX = toX;
        this.autoY = toY;
        this.timeAutoXY = 0;
        this.setTimeAutoXY = time;
    }
    
    public int getQuantityItem(int templateId) {
        int quantity = 0;
        for (int i = 0; i < this.arrItemBag.length;) {
            if (this.arrItemBag[i] != null && this.arrItemBag[i].template.id == templateId) {
                quantity += this.arrItemBag[i].quantity;
            }
            i++;
        }
        for (int i = 0; i < this.arrItemBox.length;) {
            if (this.arrItemBox[i] != null && this.arrItemBox[i].template.id == templateId) {
                quantity += this.arrItemBox[i].quantity;
            }
            i++;
        }
        for (int i = 0; i < this.arrItemBody.length;) {
            if (this.arrItemBody[i] != null && this.arrItemBody[i].template.id == templateId) {
                quantity += this.arrItemBody[i].quantity;
            }
            i++;
        }
        return quantity;
    }
    
    public void goDaiHoiVoThuat2() {
        Map map543 = Map.getMapServer(113);
        if (map543 != null) {
            ZoneMap zone294 = map543.getZone(this);
            if (zone294 != null) {
                this.zoneMap.exit(this, 0);
                zone294.join(this, 0, Util.gI().nextInt(300, 400), 360);
            } else {
                this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
            }
        }
    }
    
    private void updateSuperRank() {
        if (this.superRankName != null) {
            SuperRank player = SuperRank.getByname(this.superRankName);
            SuperRank my = SuperRank.getByname(this.cName);
            if (player != null && my != null) {
                if (player.isWar) {
                    this.addInfo1(String.format(mResources.FAILD_THACH_DAU1, player.name));
                } else if (my.isWar) {
                    this.addInfo1(mResources.FAILD_THACH_DAU2);
                } else {
                    //Tim phong
                    Map map = Map.getMapServer(113);
                    if (map != null) {
                        trandau:
                        {
                            boolean flag = false;
                            for (int j = 0; j < map.zones.size(); j++) {
                                if (!map.zones.get(j).isRace) {
                                    map.zones.get(j).isRace = true;
                                    map.zones.get(j).rankName1 = my.name;
                                    map.zones.get(j).rank1 = my.rank + 1;
                                    map.zones.get(j).rankName2 = player.name;
                                    map.zones.get(j).rank2 = player.rank + 1;
                                    if (this.zoneMap != map.zones.get(j)) {
                                        this.zoneMap.exit(this, 0);
                                        map.zones.get(j).join(this, 0, -1, -1);
                                    }
                                    flag = true;
                                    break;
                                }
                            }
                            if (flag) {
                                player.isWar = true;
                                player.strWar = String.format(mResources.SUPER_RANK_VS, my.name, this.zoneID);
                                my.isWar = true;
                                my.strWar = String.format(mResources.SUPER_RANK_VS, player.name, this.zoneID);
                                this.setPos(300, 264, 1);
                                Char bot = Player.addBoss(135, 0, -1, -1, true, 450, 264, null, -1, -1);
                                bot.headDefault = player.headID;
                                bot.bodyDefault = player.bodyID;
                                bot.legDefault = player.legID;
                                bot.bagDefault = player.bag;
                                bot.cName = player.name;
                                bot.cgender = player.cgender;
                                bot.cPower = player.cPower;
                                //
                                bot.cHP = bot.cHPFull = bot.cHPGoc = player.cHPfull;
                                bot.cMP = bot.cMPFull = bot.cMPGoc = player.cHPfull;
                                bot.cDamGoc = player.cDamfull;
                                bot.cDefGoc = player.cDeffull;
                                bot.cCriticalGoc = player.cCriticalfull;
                                bot.cDefPercentGoc = player.cDefPercentfull;
                                bot.cMissPercentGoc = player.cMissPercentfull;
                                bot.suckHPGoc = player.suckHPGoc;
                                bot.suckKIGoc = player.suckKIGoc;
                                for (int i = 0; i < player.skills.size(); i++) {
                                    bot.skills.add(player.skills.get(i).clone());
                                }
                                bot.resetSkill();
                                bot.updateAll();
                                //zo map
                                this.zoneMap.join(bot, 0, -1, -1);
                                this.setChallenge(3000, bot);
                                this.addInfo1(mResources.CHAT_THACH_DAU1);
                                bot.addChat(100, mResources.CHAT_THACH_DAU2);
                                this.addChat(3000, mResources.CHAT_THACH_DAU3);
                            } else {
                                this.addInfo1(mResources.DA_HET_PHONG);
                            }
                        }
                    }
                }
            }
            this.superRankName = null;
        }
        if (this.mapTemplateId == 113) {
//            System.out.println("this.mapTemplateId="+this.mapTemplateId);
//            if (this.challengeCharId == -9999) {
//                this.setPos(this.cx, 336, 1);
//            }
        }
        if (this.timeSetChallenge > 0) {
            this.timeSetChallenge -= this.delay;
            if (this.timeSetChallenge <= 0) {
                this.timeSetChallenge = 0;
                if (this.playerSetChallenge != null) {
                    this.setChallenge(this.playerSetChallenge.charID, 0);
                    this.timeThachDau = 180000;
                }
            }
        }
        if (this.timeThachDau > 0) {
            this.timeThachDau -= this.delay;
            if (this.timeThachDau <= 0) {
                this.timeThachDau = 0;
                this.loser(4);
            }
        }
        if (this.superRank != null) {
            if (this.superRank.ngocNhan > 0) {
                int ngocNhan = this.superRank.ngocNhan;
                this.superRank.ngocNhan = 0;
                this.updateLuongKhoa(ngocNhan, 2);
                this.addInfo1(1, String.format(mResources.ADD_NGOC_TOP, this.superRank.rank + 1, ngocNhan));
                if (this.superRank.rank == 0) {
                    this.addTaskPointDH(1293, 1);
                }
            }
        }
    }
    
    public void thachDau(int playerId) {
        if (playerId == -1) {
            this.typeThachDau = 0;
            return;
        }
        if (playerId == this.charID) {
            this.addInfo1(mResources.NOT_THACH_DAU_TOP1002);
            return;
        }
        if (this.typeThachDau == 0) {
            return;
        }
        if (this.typeThachDau == 1) {
            this.addInfo1(mResources.NOT_THACH_DAU_TOP100);
            return;
        }
        if (this.arrSuperRank.isEmpty()) {
            return;
        }
        if (this.typeThachDau == 2 && this.playerSetChallenge == null) {
            if (this.myObj().nFreeTicket < 1 && this.getLuong() < 1) {
                this.addInfo1(mResources.NOT_THACH_DAU_TOP1003);
            } else {
                for (int i = 0; i < this.arrSuperRank.size(); i++) {
                    if (this.arrSuperRank.get(i).charID == playerId) {
                        if (this.arrSuperRank.get(this.arrSuperRank.size() - 1).rank < 20 && Math.abs(this.arrSuperRank.get(this.arrSuperRank.size() - 1).rank - this.arrSuperRank.get(i).rank) > 2) {
                            this.addInfo1(mResources.FAIL_THACH_DAU1);
                        } else {
                            this.superRankName = this.arrSuperRank.get(i).name;
                        }
                        return;
                    }
                }
            }
        }
    }
    
    public void setChallenge(int time, Char player) {
        this.timeSetChallenge = time;
        this.playerSetChallenge = player;
        player.playerSetChallenge = this;
    }
    
    public void setSuperRank(int type) {
        SuperRank o = SuperRank.getByname(this.cName);
        if (o == null) {
            if (type == 0) {
                return;
            }
            o = new SuperRank(this.playerId, this.charID, this.cName);
            o.rank = SuperRank.size();
            SuperRank.add(o);
        } else {
            if (type == 1) {
                return;
            }
        }
        //new charID
        o.charID = this.charID;
        o.cgender = this.cgender;
        o.cPower = this.cPower;
        o.headID = this.head;
        o.bodyID = this.body;
        o.legID = this.leg;
        o.bag = this.bag;
        o.cHPfull = this.cHPFull;
        o.cMPfull = this.cMPFull;
        o.cDamfull = this.cDamFull;
        o.cDeffull = this.cDefull;
        o.cCriticalfull = this.cCriticalFull;
        o.cDefPercentfull = this.cDefPercentGoc;
        o.cMissPercentfull = this.cDefPercentGoc;
        o.suckHPGoc = this.bienHp_percent;
        o.suckKIGoc = this.bienMp_percent;
        o.skills.clear();
        for (int i = 0; i < this.skills.size(); i++) {
            o.skills.add(this.skills.get(i).clone());
        }
        this.superRank = o;
    }
    
    public void openTop100CT() {
        this.typeThachDau = 1;
        ArrayList<SuperRank> arrayList = new ArrayList<>();
        synchronized(SuperRank.AMEMBER) {
            int i = 0;
            while(i < 100 && i < SuperRank.AMEMBER.size()) {
                arrayList.add(SuperRank.AMEMBER.get(i));
                i++;
            }
        }
        this.session.service.superRank(arrayList);
    }
    
    public void openThachDau() {
        this.typeThachDau = 2;
        this.arrSuperRank.clear();
        SuperRank my = SuperRank.getByname(this.cName);
        if (my != null) {
            synchronized(SuperRank.AMEMBER) {
                int index = SuperRank.AMEMBER.indexOf(my);
                int i = index;
                while(index - i <= 10 && i  >= 0) {
                    this.arrSuperRank.add(SuperRank.AMEMBER.get(i));
                    i--;
                }
                if (index - 100 > 0) {
                    this.arrSuperRank.add(SuperRank.AMEMBER.get(Util.gI().nextInt(100, index - 10)));
                }
                // dao lai
                SuperRank[] array = new SuperRank[this.arrSuperRank.size()];
                for (int j = 0; j < array.length; j++) {
                    array[j] = this.arrSuperRank.get(j);
                }
                this.arrSuperRank.clear();
                for (int j = array.length - 1; j >= 0; j--) {
                    this.arrSuperRank.add(array[j]);
                }
            }
        }
        this.session.service.superRank(this.arrSuperRank);
    }
    
    public int getRank() {
        if (SuperRank.getByname(this.cName) != null) {
            return SuperRank.getByname(this.cName).rank;
        } else {
            return -1;
        }
    }
    
    private void updateBWar() {
//        this.aCharFocus
    }
    
    public void clearDuaHau() {
        this.session.service.hideNpc(51, 0);
        this.duahaus.remove(this.getDuaHau(51, -1));
        this.zoneMap.removeNpc(51);
    }
    
    public void tangmamlebac(int n) {
        if (this.getItemBagQuantityById(2006) != 0 && this.getItemBagQuantityById(2006) < n) {
            n = this.getItemBagQuantityById(2006);
        }
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (this.getItemBagQuantityById(2006) < n) {
            this.addInfo1(String.format(mResources.THIEU_LE_VAT, n));
        } else {
            this.useItemBagById(2006, n);
            //qua tai day
            this.updateEXP(2, 1000);
            if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(867, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(50, Util.gI().nextInt(20,30)));
                item.options.add(new ItemOption(77, Util.gI().nextInt(20,30)));
                item.options.add(new ItemOption(103, Util.gI().nextInt(20,32)));
                item.options.add(new ItemOption(94, Util.gI().nextInt(5,10)));
                item.options.add(new ItemOption(108, Util.gI().nextInt(5,10)));               
                item.options.add(new ItemOption(5, Util.gI().nextInt(5,20)));
                item.options.add(new ItemOption(154, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(868, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                item.options.add(new ItemOption(50, Util.gI().nextInt(20,35)));
                item.options.add(new ItemOption(77, Util.gI().nextInt(20,35)));
                item.options.add(new ItemOption(103, Util.gI().nextInt(20,35)));
                item.options.add(new ItemOption(94, Util.gI().nextInt(5,15)));
                item.options.add(new ItemOption(108, Util.gI().nextInt(5,20)));               
                item.options.add(new ItemOption(5, Util.gI().nextInt(10,20)));
                item.options.add(new ItemOption(154, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(2009, false, 1, ItemOption.getOption(2009, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(984, false, 1, ItemOption.getOption(984, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(699, false, 1, ItemOption.getOption(699, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(1110, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                item.options.add(new ItemOption(50, Util.gI().nextInt(3,12)));
                item.options.add(new ItemOption(77, Util.gI().nextInt(3,12)));
                item.options.add(new ItemOption(103, Util.gI().nextInt(3,12)));
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(1111, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                item.options.add(new ItemOption(50, Util.gI().nextInt(3,15)));
                item.options.add(new ItemOption(77, Util.gI().nextInt(3,15)));
                item.options.add(new ItemOption(103, Util.gI().nextInt(3,15)));
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
                this.addItemBag(0, item);     
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(925, false, 1, ItemOption.getOption(925, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(93, 15));
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(1151, false, 1, ItemOption.getOption(1151, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);      
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 5) {
                int id = Util.gI().nextInt(712, 716);
                Item item = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(1143, false, 1, ItemOption.getOption(1143, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(1110, false, 1, ItemOption.getOption(1110, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);         
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(120) < 1) {
                Item item = new Item(1111, false, 1, ItemOption.getOption(1111, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(200) < 1) {
                Item item = new Item(867, false, 1, ItemOption.getOption(867, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);           
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(200) < 1) {
                Item item = new Item(868, false, 1, ItemOption.getOption(868, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);           
                this.addItemBag(0, item);    
            } else{
               int idct = new int[]{867,868}[Util.gI().nextInt(2)];
               Item item = new Item(idct, false, 1, ItemOption.getOption(idct, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
               item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3))); 
               this.addItemBag(0, item);
            }
            Rank.getRank(3).addTop(this.cName, this.head, this.headICON, this.body, this.leg, this.charID, this.pointEvent += 1, -1);
        }
    }
    
    public void tangmamlevang(int n) {
        if (this.getItemBagQuantityById(3000) != 0 && this.getItemBagQuantityById(3000) < n) {
            n = this.getItemBagQuantityById(3000);
        }
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (this.getItemBagQuantityById(3000) < n) {
            this.addInfo1(String.format(mResources.THIEU_LE_VAT, n));
        } else {
            this.useItemBagById(3000, n);
            //qua tai day
            this.updateEXP(2, 1000);
            if (Util.gI().nextInt(100) < 15) {
                int id = Util.gI().nextInt(1066, 1070); 
                Item item = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 25) {
                Item item = new Item(908, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item.options.add(new ItemOption(204, Util.gI().nextInt(1,5)));  
                item.options.add(new ItemOption(203, Util.gI().nextInt(1,5)));               
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 25) {
                Item item = new Item(909, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item.options.add(new ItemOption(94, Util.gI().nextInt(1,10)));
                item.options.add(new ItemOption(202, Util.gI().nextInt(1,5)));
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(910, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                item.options.add(new ItemOption(5 , Util.gI().nextInt(1, Util.gI().nextInt(3, 8))));
                item.options.add(new ItemOption(201, Util.gI().nextInt(1,5)));
                item.options.add(new ItemOption(30, 0));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(1152, false, 1, ItemOption.getOption(1152, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(987, false, 1, ItemOption.getOption(987, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(1150, false, 1, ItemOption.getOption(1150, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                int id = Util.gI().nextInt(712, 716); 
                Item item = new Item(id , false, 1, ItemOption.getOption(id , 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(15, false, 1, ItemOption.getOption(15, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(2008, false, 1, ItemOption.getOption(2008, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(1204, false, 1, ItemOption.getOption(1204, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(1013, false, 1, ItemOption.getOption(1013, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(1021, false, 1, ItemOption.getOption(1021, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);         
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(1022, false, 1, ItemOption.getOption(1022, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);        
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(16, false, 1, ItemOption.getOption(16, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(908, false, 1, ItemOption.getOption(908, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                mLog.log("Quay ra vv "+item.template.name);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(909, false, 1, ItemOption.getOption(909, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                mLog.log("Quay ra vv "+item.template.name);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 1) {
                Item item = new Item(910, false, 1, ItemOption.getOption(910, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);   
                mLog.log("Quay ra vv "+item.template.name);
                this.addItemBag(0, item);    
            } else {
               int id = Util.gI().nextInt(1066, 1070); 
               Item item = new Item(id, false, Util.gI().nextInt(1, 10), ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);   
               this.addItemBag(0, item);
            }
            Rank.getRank(3).addTop(this.cName, this.head, this.headICON, this.body, this.leg, this.charID, this.pointEvent += 3, -1);
        }
    }
    
    public void curExpSkill() {
        if (this.session == null) return;
        if (this.session.getIntVersion() >= 231) {
            for (int i = 0; i < this.skills.size(); i++) {
                if (this.skills.get(i).template.type == 4) {
                    this.session.service.curExpSkill(this.skills.get(i).skillId, this.skills.get(i).curExp);
                }
            }
        }
    }
    
    public void setNewSkill(Skill newSkill, int typePaint, Point targetDame, int timeGong, int timeDame, int typeItem) {
        this.isNewSkill = true;
        this.isCancelNewSkill = false;
        this.newSkill = newSkill;
        this.typePaint = typePaint;
        this.targetDame = targetDame;
        this.timeGong = timeGong;
        this.timeDame = timeDame;
        this.typeItem = typeItem;
        this.session.service.get_Img_Skill(newSkill.skillId, typePaint);
        if (newSkill.template.id == 24) {
            this.zoneMap.SetSkillPaint_NEW(this.charID, newSkill.template.id, 0, 1, typePaint, this.cdir, this.timeGong, this.typeItem);
        }
        if (newSkill.template.id == 25) {
            this.zoneMap.SetSkillPaint_NEW(this.charID, newSkill.template.id, 0, 2, typePaint, this.cdir, this.timeGong, this.typeItem);
        }
        if (newSkill.template.id == 26) {
            this.zoneMap.SetSkillPaint_NEW(this.charID, newSkill.template.id, 0, 3, typePaint, this.cdir, this.timeGong, this.typeItem);
        }
    }
    
    private void updateNSkill() {
        if (this.isNewSkill) {
            if (this.isCancelNewSkill) {
                this.isNewSkill = false;
                this.isCancelNewSkill = false;
            } else {
                if (this.timeGong > 0) {
                    this.timeGong -= this.delay;
                    if (this.timeGong <= 0) {
                        this.timeGong = 0;
                        if (this.newSkill.template.id == 24) {
                            this.zoneMap.SetSkillPaint_STT(this.charID, this.newSkill.template.id, this.targetDame, this.timeDame, this.newSkill.dy, this.typePaint, null, null, this.typeItem);
                        }
                        if (this.newSkill.template.id == 25) {
                            this.zoneMap.SetSkillPaint_STT(this.charID, this.newSkill.template.id, this.targetDame, this.timeDame, 30, this.typePaint, null, null, this.typeItem);
                        }
                        //ma phong ba
                        if (this.newSkill.template.id == 26) {
                            this.mPhongBa2.clear();
                            this.mPhongBa1.clear();
                            int num = 0, maxJail = 1;
                            if (this.typeItem == 1) {
                                maxJail += 1;
                            }
                            if (this.typeItem == 1) {
                                maxJail += 2;
                            }
                            synchronized(this.zoneMap.players) {
                                for (int i = 0; i < this.zoneMap.players.size() && num < maxJail; i++) {
                                    Char player = this.zoneMap.players.get(i);
                                    if (this.isMeCanAttackOtherPlayer(player) && Math.abs(player.cx - this.cx) <= this.newSkill.dx && Math.abs(this.cy - player.cy) <= this.newSkill.dy && (this.cdir == 1 ? player.cx >= this.cx : player.cx <= this.cx)) {
                                        this.mPhongBa2.add(player);
                                        num++;
                                    }
                                }
                            }
                            synchronized(this.zoneMap.mobs) {
                                for (int i = 0; i < this.zoneMap.mobs.size() && num < maxJail; i++) {
                                    Mob mob = this.zoneMap.mobs.get(i);
                                    if (this.isMeCanAttackOtherMob(mob) && Math.abs(mob.pointx - this.cx) <= this.newSkill.dx && Math.abs(this.cy - mob.pointy) <= this.newSkill.dy && (this.cdir == 1 ? mob.pointx >= this.cx : mob.pointx <= this.cx)) {
                                        this.mPhongBa1.add(mob);
                                        num++;
                                    }
                                }
                            }
                            this.zoneMap.SetSkillPaint_STT(this.charID, this.newSkill.template.id, this.targetDame, this.timeDame, this.newSkill.dy, this.typePaint, this.mPhongBa1, this.mPhongBa2, this.typeItem);
                        }
                    }
                }
                if (this.timeGong == 0 && this.timeDame > 0) {
                    this.timeDame -= this.delay;
                    if (this.timeDame <= 0) {
                        this.timeDame = 0;
                    }
                    //gay dam Super Kamejoko
                    if (this.newSkill.template.id == 24) {
                        this.timeDanhSkill -= this.delay;
                        if (this.timeDanhSkill <= 0) {
                            this.timeDanhSkill = 210;
                            this.superKamejoko((this.cDamFull * (this.newSkill.damage / 100 / 100)) + this.cDamFull);
                        }
                    }
                    //Cadic lien hoan chuong
                    if (this.newSkill.template.id == 25) {
                        this.timeDanhSkill -= this.delay;
                        if (this.timeDanhSkill <= 0) {
                            this.timeDanhSkill = 210;
                            this.cadicLienHoanChuong((this.cDamFull * (this.newSkill.damage / 100 / 100)) + this.cDamFull);
                        }
                    }
                    //cho vao lo
                    if (this.timeDame == 0) {
                        short array[] = new short[] {11183, 11192, 11173};
                        if (!this.mPhongBa1.isEmpty()) {
                            for (int i = 0; i < this.mPhongBa1.size(); i++) {
                                this.mPhongBa1.get(i).setBody(array[this.typeItem], 12000);
                                this.mPhongBa1.get(i).playerTDMPB = this;
                                this.mPhongBa1.get(i).damageTDMPB = (int) (this.cHPFull / 100F * this.newSkill.damage);
                            }
                            this.mPhongBa1.clear();
                        }
                        if (!this.mPhongBa2.isEmpty()) {
                            for (int i = 0; i < this.mPhongBa2.size(); i++) {
                                this.mPhongBa2.get(i).setItem(array[this.typeItem], 12, 0, 0);
                                this.mPhongBa2.get(i).playerTDMPB = this;
                                this.mPhongBa2.get(i).damageTDMPB = (int) (this.cHPFull / 100F * this.newSkill.damage);
                            }
                            this.mPhongBa2.clear();
                        }
                    }
                }
                if (this.timeDame == 0) {
                    this.isNewSkill = false;
                    this.isCancelNewSkill = false;
                }
            }
        }
        this.timeTDMPB -= this.delay;
        if (this.timeTDMPB <= 0) {
            this.timeTDMPB = 1000;
            if (this.isMaPhongBa1 && !this.isDie) {
                this.haveAttackPLayer(this.playerTDMPB, 1, this.damageTDMPB, false, -1, true);
            }
        }
    }
    
    public void superKamejoko(int damage) {
        Mob[] arrMob;
        synchronized (this.zoneMap.mobs) {
            arrMob = new Mob[this.zoneMap.mobs.size()];
            for (int i = 0; i < this.zoneMap.mobs.size(); i++) {
                arrMob[i] = this.zoneMap.mobs.get(i);
            }
        }
        Char[] arrChar;
        synchronized (this.zoneMap.players) {
            arrChar = new Char[this.zoneMap.players.size()];
            for (int i2 = 0; i2 < this.zoneMap.players.size(); i2++) {
                arrChar[i2] = this.zoneMap.players.get(i2);
            }
        }
        for (int i3 = 0; i3 < arrMob.length; i3 = i3 + 1) {
            Mob mob = arrMob[i3];
            if (mob != null && this.isMeCanAttackOtherMob(mob) && mob.pointx > Math.min(this.targetDame.x, this.cx) && mob.pointx < Math.max(this.targetDame.x, this.cx) && Math.abs(mob.pointy - this.cy) < this.targetDame.y) {
                mob.AttackMob(this, damage, false, 3, -1);
            }
        }
        for (int i4 = 0; i4 < arrChar.length; i4 = i4 +1) {
            Char player = arrChar[i4];
            if (player != null) {
                if (this.isMeCanAttackOtherPlayer(player) && player.cy > Math.min(this.targetDame.x, this.cx) && player.cy < Math.max(this.targetDame.x, this.cx) && Math.abs(player.cy - this.cy) < this.targetDame.y) {
                    int damage2 = damage;
                    if (player.isTemplate) {
                        if (this.isMonkey != 0) {
                            damage2 = damage2 / 3;
                        } else {
                            damage2 = damage2 / 2;
                        }
                    }
                    //Bat khien
                    if (damage2 > 1 && player.protectEff) {
                        if (damage2  >= player.cHPFull) {
                            player.setItem(3784, 0, 0, 0);
                        }
                        damage2 = 1;
                    }

                    if (player.downDamage_percent > 0) {
                        int downDam_percent = player.downDamage_percent;
                        if (downDam_percent > 89) {
                            downDam_percent = 89;
                        }
                        damage2 = (int) (damage2 - ((long)damage2 * (long)downDam_percent / 100L));
                    }
                    player.haveAttackPLayer(this, 1, damage2, false, -1, true);
                }
            }
        }
    }
    
    public void cadicLienHoanChuong(int damage) {
        Mob[] arrMob;
        synchronized (this.zoneMap.mobs) {
            arrMob = new Mob[this.zoneMap.mobs.size()];
            for (int i = 0; i < this.zoneMap.mobs.size(); i++) {
                arrMob[i] = this.zoneMap.mobs.get(i);
            }
        }
        Char[] arrChar;
        synchronized (this.zoneMap.players) {
            arrChar = new Char[this.zoneMap.players.size()];
            for (int i2 = 0; i2 < this.zoneMap.players.size(); i2++) {
                arrChar[i2] = this.zoneMap.players.get(i2);
            }
        }
        for (int i3 = 0; i3 < arrMob.length; i3 = i3 + 1) {
            Mob mob = arrMob[i3];
            if (mob != null && this.isMeCanAttackOtherMob(mob) && Math.abs(this.targetDame.x - mob.pointx) < this.newSkill.dx && Math.abs(this.targetDame.y - mob.pointy) < this.newSkill.dy) {
                mob.AttackMob(this, damage, false, 3, -1);
            }
        }
        for (int i4 = 0; i4 < arrChar.length; i4 = i4 +1) {
            Char player = arrChar[i4];
            if (player != null) {
                if (this.isMeCanAttackOtherPlayer(player) && Math.abs(this.targetDame.x - player.cx) < this.newSkill.dx && Math.abs(this.targetDame.y - player.cy) < this.newSkill.dy) {
                    int damage2 = damage;
                    if (player.isTemplate) {
                        if (this.isMonkey != 0) {
                            damage2 = damage2 / 3;
                        } else {
                            damage2 = damage2 / 2;
                        }
                    }
                    //Bat khien
                    if (damage2 > 1 && player.protectEff) {
                        if (damage2  >= player.cHPFull) {
                            player.setItem(3784, 0, 0, 0);
                        }
                        damage2 = 1;
                    }

                    if (player.downDamage_percent > 0) {
                        int downDam_percent = player.downDamage_percent;
                        if (downDam_percent > 89) {
                            downDam_percent = 89;
                        }
                        damage2 = (int) (damage2 - ((long)damage2 * (long)downDam_percent / 100L));
                    }
                    player.haveAttackPLayer(this, 1, damage2, false, -1, true);
                }
            }
        }
    }
    
    public void sendFreeze(int second) {
        if (this.zoneMap != null) {
            Char[] arr; int i;
            synchronized (this.zoneMap.players) {
                arr = new Char[this.zoneMap.players.size()];
                for (i = 0; i < this.zoneMap.players.size(); i++) {
                    arr[i] = this.zoneMap.players.get(i);
                }
            }
            for (i = 0; i < arr.length; i++) {
                if (arr[i] != null && !arr[i].isTemplate && arr[i].charID != this.charID && !arr[i].isDie && arr[i].timeStone <= 0 && Math.abs(arr[i].cx - this.cx) <= 200 && Math.abs(arr[i].cy - this.cy) <= 200 && !arr[i].isSendSocola30 && !arr[i].isAgainstEffect) {
                    arr[i].timeStone = 30000;
                    arr[i].setItem(11085, second, 0, 0);
                    this.zoneMap.addEffectChar(arr[i].charID, 202, 1, 1, 1, 0);
                }
            }
        }
    }
    
    private void updateAnTrom() {
        if (this.zoneMap != null) {
            if (this.cTemplateType == 45) {
                this.timeChuyenMap -= this.delay;
                if (this.timeChuyenMap <= 0) {
                    this.timeChuyenMap = 60000;
                    this.isChuyenMap = true;
                }
                if (this.isBiDanh) {
                    this.isBiDanh = false;
                    this.isSteal = false;
                    this.stealCharId = -1;
                    if (!this.isStand() && this.mySkill.lastTimeUseThisSkill <= System.currentTimeMillis()) {
                        this.skill_not_focus((byte)0, this.mySkill);
                        if (Util.gI().nextInt(100) < 15) {
                            this.timeChuyenMap = 500;
                        }
                    }
                }
                if (this.isSteal) {
                    if (this.stealCharId != -1) {
                        this.timeSteal -= this.delay;
                        if (this.timeSteal <= 0) {
                            this.timeSteal = 500;
                            Char player = this.zoneMap.findCharInMap(this.stealCharId);
                            if (player != null && player.xu > 100 && !player.isgiaodich) {
                                if (!this.isStand()) {
                                    if (Math.abs(this.cx - player.cx) <= 50 && Math.abs(this.cy - player.cy) <= 50) {
                                        //hut vang
                                        this.zoneMap.steal(this.charID, player.cx, player.cy, this.zoneMap.createItemMapId(), 188);
                                        long soVang = Util.gI().nextInt(500, 5000);
                                        if (soVang > player.xu) soVang = player.xu;
                                        player.updateXu(-soVang, 1);
                                        this.xuSteal += soVang;
                                        this.timeChuyenMap = 60000;
                                    } else if (!this.isMove) {
                                        this.setMove(0, player.cx + Util.gI().nextInt(-24, 24), player.cy, 50, 0, 300);
                                    }
                                }
                            } else {
                                this.stealCharId = -1;
                                this.timeSteal = 5000;
                            }
                        }
                    } else {
                        this.timeSteal -= this.delay;
                        if (this.timeSteal <= 0) {
                            this.timeSteal = 5000;
                            synchronized(this.zoneMap.players) {
                                for (int i = 0; i < this.zoneMap.players.size(); i++) {
                                    Char player = this.zoneMap.players.get(i);
                                    if (player.session != null && player.xu > 100 && !player.isgiaodich) {
                                        this.stealCharId = player.charID;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.xuSteal > 0 && this.gameTick % 100 == 0) {
                    this.addChat(10, String.format(mResources.CHAT_STEAL_VANG, Util.gI().numberTostring(this.xuSteal)));
                }
            }
        }
    }
    
    public RequestItem requestItem = null;
    
//    public void requestOpenUIItem(int npcId, String tile, int[] templateId, int[] quantity, int typeBoardOK, String strOK, int typeBoeard, String strErr, int coin, int ngoc, int quntityEmptyBag, boolean setCombine, String tile2) {
//        this.requestItem = null;
//        if (quntityEmptyBag != -1 && quntityEmptyBag > this.getEmptyBagCount()) {
//            this.addInfo1(String.format(mResources.BAG_FULL_2, quntityEmptyBag));
//        } else {
//            RequestItem request = new RequestItem(tile, templateId, quantity, typeBoardOK, strOK, typeBoeard);
//            request.npcId = npcId;
//            request.xu = coin;
//            request.luong = ngoc;
//            request.quntityEmptyBag = quntityEmptyBag;
//            this.requestItem = request;
//            this.resetMenu();
//            this.menuBoard.chat = "|1|"+tile;
//            for (int i2 = 0; i2 < templateId.length; i2++) {
//                this.menuBoard.chat += "\n|"+(this.getItemBagQuantityById(templateId[i2]) >= quantity[i2] ? 2 : 7)+"|"+ItemTemplate.get((short)templateId[i2]).name+" "+this.getItemBagQuantityById(templateId[i2])+"/"+quantity[i2];
//            }
//            if (coin != -1) {
//                this.menuBoard.chat += "\n|"+(this.xu >= coin ? 2 : 7)+"| Giá vàng: "+Util.gI().getFormatNumber(coin);
//            }
//            if (ngoc != -1) {
//                this.menuBoard.chat += "\n|"+(this.getLuongNew() >= ngoc ? 2 : 7)+"| Giá ngọc: "+Util.gI().getFormatNumber(ngoc);
//            }
//            kiemtraCoOK:
//            {
//                if (!tile2.isEmpty()) {
//                    String che = "{check:}";
//                    if (tile2.contains(che)) {
//                        this.menuBoard.chat += ("\n"+ tile2.replace(che, ""));
//                        if (tile2.contains("|7|")) break kiemtraCoOK;
//                    } else {
//                        this.menuBoard.chat += ("\n"+ tile2);
//                    }
//                }
//                if ((coin != -1 && this.xu < coin) || (ngoc != -1 && this.getLuongNew() < ngoc)) {
//                    break kiemtraCoOK;
//                }
//                for (int i1 = 0; i1 < templateId.length; i1++) {
//                    if (this.getItemBagQuantityById(templateId[i1]) < quantity[i1]) {
//                        break kiemtraCoOK;
//                    }
//                }
//                this.menuBoard.arrMenu.add(new MenuInfo(strOK, 173));
//                if (setCombine) {
//                    int array[] = new int[templateId.length];
//                    for (int i = 0; i < templateId.length; i++) {
//                        array[i] = this.getItemBag(templateId[i]).indexUI;
//                    }
//                    this.session.service.setCombineEff(array, npcId);
//                }
//            }
//            this.menuBoard.arrMenu.add(new MenuInfo(strErr, typeBoeard));
//            this.menuBoard.openUIConfirm(npcId, null, null, -1);
//        }
//    }
    
    public void openTabGold() {
        this.resetMenu();
        this.menuBoard.chat = String.format(mResources.INFO_LUCKYROUND, LuckyRoundNew.history, Util.gI().getStrTime(LuckyRoundNew.time), Util.gI().getFormatNumber(LuckyRoundNew.totalMoney), LuckyRoundNew.countID(), Util.gI().getFormatNumber(LuckyRoundNew.countMoneyME(this.playerId)), LuckyRoundNew.percentME(this.playerId));
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.REFRESH, 175));
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.LUCKY_ROUND_NEW_JOIN1, 176));
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.LUCKY_ROUND_NEW_JOIN10, 177));
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.LUCKY_ROUND_NEW_JOIN20, 178));
        int win = LuckyRoundNew.countWin(this.playerId);
        if (win > 0) {
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.LUCKY_ROUND_NEW_WIN, Util.gI().getFormatNumber(win)), 179));
        }
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.CLOSE, 0));
        this.menuBoard.openUIConfirm(54, null, null, -1);
    }
    
    public void winLuckyRoundNew() {
        int win = LuckyRoundNew.countWin(this.playerId);
        if (win > 0) {
            LuckyRoundNew.removeWin(this.playerId);
            Item item = new Item(457, false, win, ItemOption.getOption(457, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            this.addItemBag(0, item);
        }
    }
    
    public void buyItemShop(int type, int id, int num) {
        //shop mua lai do
        if (this.shopId == -2003 && id >= 0 && id < this.myObj().reBuyItem.size()) {
            Item item = null;
            try {
                item = this.myObj().reBuyItem.get(this.myObj().reBuyItem.size() - 1 - id);
            } catch (Exception e) {
            }
           if (item != null) {
                if (this.checkBag(item)) {
                    int price = (int) (SaleItemNew.priceItemCoin(item) * item.quantity * 1.1);
                    if (price < 110) price = 110;
                    if (price > this.xu) {
                        this.addInfo1(String.format(mResources.NOT_XU, price - this.xu));
                    } else {
                        this.updateXu(-price, 0);
                        this.myObj().reBuyItem.remove(item);
                        this.addItemBag(1, item);
                        this.addInfo1(String.format(mResources.ITEM_BUY_SUCCESS, item.template.name));
                        this.session.service.shopReBuyItem(this.myObj().reBuyItem);
                        this.session.service.itemBuy(this.xu, this.luong, this.luongKhoa);
                    }
                } else {
                    this.addInfo1(mResources.BAG_FULL);
                }
            }
        }
    }
    
    //Lech Teamobi
    
    public void CanCau(int indexCanCau) {
        if (this.mapTemplateId != 5) {
            this.addInfo1(mResources.CAU_CA_FAILD2);
        } else if (!Dragon.isEvent_HE2023) {
            this.addInfo1(mResources.CAU_CA_FAILD1);
        } else {
            Item item = this.getItemBagById(1990);
            if (item == null) {
                this.addInfo1(mResources.CAU_CA_FAILD3);
            } else {
                this.moiCau = item;
                this.isThaCau = 1;
                this.timeThaCau = 1000;
                this.addChat(1, mResources.CAU_CA_SUCCESS1);
            }
        }
    }
    
    private void cauSKHe() {
        int tempId = new int[]{1991, 1992, 1993 , 1002 ,1002 ,1003 ,1003 ,1004, 1004}[Util.gI().nextInt(9)];   
        Item item = new Item(tempId, false, 1, ItemOption.getOption(tempId, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
        if (this.checkBag(item)) {
            this.addChat(1, String.format(mResources.CAU_CA_SUCCESS2, item.template.name));
            this.addItemBag(1, item);
        } else {
            this.addChat(1, mResources.BAG_FULL);
        }
    }
    
    private void updateThaCau() {
        if (this.isThaCau > 0) {
            this.timeThaCau -= this.delay;
            if (this.timeThaCau <= 0) {
                this.timeThaCau = 0;
                if (!this.isgiaodich && (this.moiCau == null || this.arrItemBag[this.moiCau.indexUI] == this.moiCau)) {
                    if (this.moiCau != null) this.useItemBag(this.moiCau.indexUI, 1);
                    if (this.isThaCau == 1) {
                        this.cauSKHe();
                    }
                }
                this.isThaCau = 0;
                this.moiCau = null;
            }
        }
    }
    
    private void updateEffectChar() {
        if (this.zoneMap == null || this.gameTick % 20 == 0) return;
        for (int i = this.aEffChar.size() - 1; i >= 0; i--) {
            EffChar eff = this.aEffChar.get(i);
            if (eff.second != -1 && eff.last / 1000L + eff.second < System.currentTimeMillis() / 1000L) {
                this.zoneMap.removeEffChar(this.charID, this.aEffChar.remove(i).effId);
            }
        }
    }
    
    public void addEffectChar(int effId, int layer, int loop, int loopCount, int isStand, int second, int typeEff, boolean isPaint, boolean isSave, Item item) {
        EffChar iEff = new EffChar();
        iEff.effId = effId;
        iEff.layer = layer;
        iEff.loop = loop;
        iEff.tLoop = loopCount;
        iEff.isStand = isStand;
        iEff.second = second;
        iEff.typeEff = typeEff;
        iEff.isSave = isSave;
        iEff.isPaint = isPaint;
        iEff.item = item;
        iEff.last = System.currentTimeMillis();
        this.aEffChar.add(iEff);
        if (isPaint) {
            this.zoneMap.addEffectChar(this.charID, iEff.effId, iEff.layer, iEff.loop, iEff.tLoop, iEff.isStand);
        }
        this.updateAll();
        this.session.service.meLoadPoint();
        this.zoneMap.playerLoadAll(this);
    }
    
    public EffChar getEffCharById(int id) {
        for (int i = 0; i < this.aEffChar.size(); i++) {
            EffChar effect = this.aEffChar.get(i);
            if (effect.effId == id) {
                return effect;
            }
        }
        return null;
    }
    
    public void removeEffChar(int type, int effId) {
        if (type == -1) {
            this.aEffChar.clear();
            this.zoneMap.removeEffCharAll(this.charID);
        } else {
            this.aEffChar.remove(this.getEffCharById(effId));
            this.zoneMap.removeEffChar(this.charID, effId);
        }
    }
    
    public void removeEffVip() {
        for (int i = this.aEffChar.size() - 1; i >= 0; i--) {
            if (this.aEffChar.get(i).effId == 1000 || this.aEffChar.get(i).effId == 1001 || this.aEffChar.get(i).effId == 1002) {
                this.aEffChar.remove(i);
            }
        }
    }
    
    public void unseal() {
        if (this.getItemBagQuantityById(537) < 10 || this.getItemBagQuantityById(538) < 10 || this.getItemBagQuantityById(539) < 10 || this.getItemBagQuantityById(540) < 10) {
            this.resetMenu();
            this.menuBoard.chat = mResources.SAY_DUONG_TANG_3;
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 0));
            this.menuBoard.openUIConfirm(49, null, null, -1);
        } else if (this.getEmptyBagCount() < 1) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else {
            this.useItemBag(this.getItemBagById(537).indexUI, 10);
            this.useItemBag(this.getItemBagById(538).indexUI, 10);
            this.useItemBag(this.getItemBagById(539).indexUI, 10);
            this.useItemBag(this.getItemBagById(540).indexUI, 10);
            Item item = null;
            if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(994, false, 1, ItemOption.getOption(994, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(994, false, 1, ItemOption.getOption(994, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(995, false, 1, ItemOption.getOption(995, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(995, false, 1, ItemOption.getOption(995, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(996, false, 1, ItemOption.getOption(996, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(996, false, 1, ItemOption.getOption(996, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(997, false, 1, ItemOption.getOption(997, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(997, false, 1, ItemOption.getOption(997, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(999, false, 1, ItemOption.getOption(999, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(999, false, 1, ItemOption.getOption(999, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(1000, false, 1, ItemOption.getOption(1000, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(1000, false, 1, ItemOption.getOption(1000, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(1001, false, 1, ItemOption.getOption(1001, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(1001, false, 1, ItemOption.getOption(1001, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(1000) < 1) {
                    item = new Item(1007, false, 1, ItemOption.getOption(1007, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                    mLog.log("Giai phong an vv "+item.template.name);
                } else {
                    item = new Item(1007, false, 1, ItemOption.getOption(1007, Util.gI().nextInt(3, 7), 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                }
            } else {
                int ctId = -1;
                if (this.cgender == 0) {
                    ctId = 544;
                }
                if (this.cgender == 1) {
                    ctId = 545;
                }
                if (this.cgender == 2) {
                    ctId = 546;
                }
                if (ctId != -1) {
                    if (Util.gI().nextInt(10000) < 1) {
                        item = new Item(ctId, false, 1, ItemOption.getOption(ctId, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                        Server.gI().chatVip(String.format(mResources.EVENT_IDOL, this.cName, item.template.name));
                        mLog.log("Giai phong an vv "+item.template.name);
                    } else {
                        item = new Item(ctId, false, 1, ItemOption.getOption(ctId, 3, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    }
                }
            }
            if (item != null) {
                if (item.isHaveOption(93)) {
                    item.setExpires(System.currentTimeMillis() + (long)(1000l * 60l * 60l * 24l * (long)(item.getParamOption(93) + 1)));
                }
                this.addItemBag(0, item);
            }
            this.session.service.npcChat(npcId, mResources.DUONG_TANG_CHAT_1);
        }
    }
    
    public void setLockInventory(int code) {
        if (this.isgiaodich) {
            this.addInfo1(mResources.O_THE_THUC_HIEN);
        } else {
            this.securityCode2 = code;
            if (code > 999999 || code < 100000 || (this.securityCode != -1 && code != this.securityCode)) {
                this.addInfo1(mResources.PASS_FAIL);
            } else {
                if (this.securityCode == -1) {
                    this.resetMenu();
                    final int gia = 1000;
                    this.menuBoard.chat = String.format(mResources.YES_NO_CODE, this.securityCode2, Util.gI().numberTostring(gia));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.OK, 308, gia));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                    this.menuBoard.openUIConfirm(5, null, null, -1);
                } else {
                    this.addInfo1(String.format(mResources.CODE_OK, this.securityCode2));
                    this.resetMenu();
                    this.menuBoard.chat = mResources.SAY_CODE;
                    this.menuBoard.arrMenu.add(new MenuInfo(this.isSecurity ? mResources.TURN_OFF : mResources.TURN_ON, 309));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.CHANGE_CODE, 310));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.CANCEL_CODE, 311));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.REFUSE, 0));
                    this.menuBoard.openUIConfirm(5, null, null, -1);
                }
            }
        }
    }
    
    public void changeCode(int code) {
        if (code > 999999 || code < 100000) {
            this.addInfo1(mResources.PASS_FAIL);
        } else {
            this.securityCode = this.securityCode2 = code;
            this.addInfo1(String.format(mResources.CODE_OK, this.securityCode2));
            this.setLockInventory(this.securityCode2);
        }
    }
    
    public void updateMyPet4() {
        if (this.myPet4 != null) {
            if (!this.isMonkeyCheat) {
                this.clearPet4();
                return;
            }
            this.myPet4.delay = this.delay;
            this.myPet4.update();
            if (this.gameTick % 300 == 0) {
                this.myPet4.addChat(1, String.format(mResources.HO_TONG1, MapTemplate.arrMapTemplate[this.myPet4.instructionMapID].mapName));
            }
            if (this.myPet4.instructionMapID == this.myPet4.mapTemplateId ) {
                int point = Util.gI().nextInt(1, 100);
                this.addChat(1, String.format(mResources.HO_TONG2, point));
                if (this.arrItemBody[6] != null) {
                    //Chua co tao moi
                    if (!this.arrItemBody[6].isHaveOption(11)) {
                        this.arrItemBody[6].options.add(new ItemOption(11, point));
                    } else {
                        this.arrItemBody[6].getOption(11).param += point;
                        if (this.arrItemBody[6].getOption(11).param > 30000) {
                            this.arrItemBody[6].getOption(11).param = 30000;
                        }
                    }
                }
                this.clearPet4();
                return;
            }
            if (!this.myPet4.isMove && (Math.abs(this.cx - this.myPet4.cx) > 50 || Math.abs(this.cy - this.myPet4.cy) > 50)) {
                this.myPet4.setMove(0, this.cx += Util.gI().nextInt(-24, 24), this.cy, 50, 0, 300);
            }
            if (Map.isMapOffline(this.mapTemplateId) || (this.zoneMap == this.myPet4.zoneMap && (Math.abs(this.cx - this.myPet4.cx) > 400 || Math.abs(this.cy - this.myPet4.cy) > 400))) {
                this.clearPet4();
            } else if (this.zoneMap != this.myPet4.zoneMap) {
                if (this.myPet4.zoneMap != null) {
                    this.myPet4.zoneMap.exit(this.myPet4, 0);
                }
                if (this.isInMap) {
                    this.myPet4.isMove = false;
                    this.zoneMap.join(this.myPet4, 0, this.cx, this.cy);
                }
            }
        }
        if (this.session != null) {
            if (this.isHideDuongTang && this.myPet4 == null) {
                this.isHideDuongTang = false;
                this.session.service.hideNpc(49, 1);
            }
            if (!this.isHideDuongTang && this.myPet4 != null) {
                this.isHideDuongTang = true;
                this.session.service.hideNpc(49, 0);
            }
        }
        if (this.fighter2 != null) {
            this.fighter2.delay = this.delay;
            this.fighter2.update();
        }
        if (this.cloneMEs != null) {
            for (int i = 0; i < this.cloneMEs.size(); i++) {
                this.cloneMEs.get(i).delay = this.delay;
                this.cloneMEs.get(i).update();
            }
        }
        if (this.fightWish2 != null) {
            this.fightWish2.delay = this.delay;
            this.fightWish2.update();
        }
        if (this.myPetz5s != null && !this.myPetz5s.isEmpty()) {
            for (int i = 0; i < this.myPetz5s.size(); i++) {
                this.myPetz5s.get(i).delay = delay;
                this.myPetz5s.get(i).update();
            }
        }
        if (this.isSendHPData) {
            this.timeSendHPData += this.delay;
            if (this.timeSendHPData > 10000) {
                this.timeSendHPData = 0;
                this.sendHPData(3);
            }
        }
    }
    
    public void clearFighter() {
        if (this.fighter1 != null) {
            if (this.fighter1.fighter2 != null) {
                //Xoa nhan ban
                this.fighter1.fighter2.clearClone();
                if (this.fighter1.fighter2.zoneMap != null) {
                    this.fighter1.fighter2.zoneMap.exit(this.fighter1.fighter2, 0);
                }
                this.fighter1.fighter2 = null;
            }
            this.fighter1 = null;
        }
        if (this.fighter2 != null) {
            if (this.fighter2.fighter1 != null) {
                this.fighter2.fighter1 = null;
            }
            if (this.fighter2.zoneMap != null) {
                //Xoa nhan ban
                this.fighter2.clearClone();
                this.fighter2.zoneMap.exit(this.fighter2, 0);
            }
            this.fighter2 = null;
        }
    }
    
    public void addDuongTang() {
        this.myPet4 = Player.addBoss(146, 5, this.cHPFull, 0, false, this.cx, this.cy, this.zoneMap, -1, -1);
        int array[] = new int[]{5};
        this.myPet4.instructionMapID = array[Util.gI().nextInt(array.length)];
        this.myPet4.myChar4 = this;
    }
    
    private void fMove(int type, int sendX, int sendY, int status) {
        if (status == 0 || status == 1) {
            if (!this.moveFast(sendX, sendY)) {
                this.move(type, sendX, sendY);
            }
        }
        if (status == 2 || status == 3) {
            this.wayPoint();
            this.isCheckWaypoint = false;
        }
    }
    
    private void updateMove() {
        if (this.zoneMap != null && this.isFlyMove) {
            if (this.cTemplateId == 104 && !this.isMove && !this.isStand() && this.gameTick % 10 == 0) {
                this.addMove(0, Util.gI().nextInt(this.cx - 70, this.cx + 70), Util.gI().nextInt(100, 200), 0);
            }
        }
        
        if (this.zoneMap != null && this.isMove && !this.isStand() && this.moveAutos != null && !this.moveAutos.isEmpty()) {
            int array[] = this.moveAutos.get(0);
            array[4] -= this.delay;
            if (array[4] <= 0) {
                this.addMove(array[0], array[1], array[2], array[3]);
                this.moveAutos.remove(array);
            }
            if (this.moveAutos.isEmpty()) {
                this.isMove = false;
            }
        }
        this.timeMove2 -= this.delay;
        if (this.timeMove2 <= 0) {
            this.timeMove2 = 100;
            if (this.moves != null && !this.moves.isEmpty()) {
                int array[] = this.moves.remove(0);
                this.fMove(array[0], array[1], array[2], array[3]);
            }
        }
//        Chui vao map se duoc keo ra
        if (this.zoneMap != null && !this.isStand() && this.pixels == 0xff00ff00) {
            int yMax = this.zoneMap.mapTemplate.pxh;
            while(yMax > 0) {
                if (this.zoneMap.mapTemplate.isCollisionPixel(this.cx, yMax - 1, 0xffffffff)) {
                    this.setPos(this.cx, yMax, 1);
                    break;
                }
                yMax -= 24;
            }
        }
        
        if (this.mapTemplateId == 47 && this.clan != null && this.timeGoMapHoangMac < 3000) {
            this.timeGoMapHoangMac += this.delay;
            if (this.timeGoMapHoangMac >= 3000) {
                Instancing phoban = this.clan.roadSnake;
                if (phoban != null && phoban.isJoin(this.playerId) && phoban.getMap(144).isOpen) {
                    Map map = phoban.getMap(144);
                    if (map != null) {
                        ZoneMap zone = map.getZone(this);
                        if (zone != null) {
                            this.zoneMap.exit(this, 2);
                            zone.join(this, 2, 600, 312);
                        } else {
                            this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                        }
                    }
                }
            }
        }
        if (this.waitJoinZone != null) {
            this.timeJoinZone -= this.delay;
            if (this.timeJoinZone <= 0) {
                this.timeJoinZone = 0;
                if (this.zoneMap != null && this.isInMap) {
                    this.zoneMap.exit(this, this.telePortJoinZone);
                }
                this.waitJoinZone.join(this, this.telePortJoinZone, this.xJoinZone, this.yJoinZone);
                this.waitJoinZone = null;
            }
        }
        if (this.session != null && this.isDie && System.currentTimeMillis() - this.lastDie > 60000L) {
            Map map = this.getMapOffline(this.mainHome());
            if (map != null) {
                ZoneMap zone = map.getZone(this);
                if (zone != null) {
                    this.zoneMap.exit(this, 0);
                    zone.join(this, 0, 350, 120);
                    this.liveFromDead(2);
                } else {
                    this.session.service.startOKDlg(mResources.MAP_OVERLOAD);
                }
            }
        }
        //Kieu di chuyen
        if (this.zoneMap != null && this.isInMap && !this.isStand() && !this.isSuper && this.timeMove <= 0 && this.tCharge <= 0) {
            if (this.autoMove == 1 && this.gameTick % 20 == 0) {
                this.setMove(0, this.cx + Util.gI().nextInt(-50, 50), 150, 50, 1, 0);
            }
            if (this.autoMove == 2 && this.gameTick % 20 == 0) {
                this.setMove(0, this.cx + Util.gI().nextInt(-50, 50), this.cy - 50, 50, 1, 0);
            }
            if (this.autoMove == 3 && this.gameTick % 20 == 0) {
                Char player = this.getCharClosest();
                if (player != null) {
                    this.setMove(1, player.cx + Util.gI().nextInt(-24, 24), player.cy, 50, 0, 200);
                }
            }
            if (this.autoMove == 4 && this.gameTick % 20 == 0) {
                this.setMove(0, this.cx + Util.gI().nextInt(-50, 50), Util.gI().nextInt(150, 300), 50, 0, 0);
            }
        }
    }
    
    public void clearClone() {
        if (this.cloneMEs != null) {
            for (int i = 0; i < this.cloneMEs.size(); i++) {
                this.cloneMEs.get(i).close();
            }
            this.cloneMEs.clear();
//            this.cloneMEs = null;
        }
    }
    
    public void addClone(int templateId) {
        if (templateId == 108) {
            if (this.cloneMEs == null) {
                this.cloneMEs = new ArrayList<>();
            }
            for (int i = 0; i < 5; i++) {
                Char bot = Player.addBoss(templateId, 0, -1, -1, true, this.cx, this.cy, null, -1, -1);
                bot.isBossMain = false;
                bot.cloneByChar = this;
                bot.skills.clear();
                bot.skills.add(Skill.arrSkill[0].clone());
                this.zoneMap.join(bot, 0, -1, -1);
                this.cloneMEs.add(bot);
            }
        }
    }
    
    public void addMove(int type, int sendX, int sendY, int status) {
        if (this.isCheckWaypoint) return;
        if (this.moves == null) {
            this.moves = new ArrayList<>();
        }
        if (status == 1) {
            this.fMove(type, sendX, sendY, status);
        } else {
            this.moves.add(new int[]{type, sendX, sendY, status});
        }
//        int kcX = this.cspeed * 7;
//        int x = this.cx;
//        int y = this.cy;
//        if (!this.moves.isEmpty()) {
//            x = this.moves.get(this.moves.size() - 1)[1];
//            y = this.moves.get(this.moves.size() - 1)[2];
//        }
//        while(x != sendX || (sendY != -1 && y != sendY)) {
//            if (x != sendX) {
//                if (x > sendX) {
//                    x -= kcX;
//                } else {
//                    x += kcX;
//                }
//                if (Math.abs(x - sendX) <= kcX) {
//                    x = sendX;
//                }
//            }
//            y = sendY;
//            this.moves.add(new int[]{type, x, y});
//        }
    }
    
    private int getPercentLevel(int num0, int level, float p) {
        long num = num0;
        for (int i = 1; i < level; i++) {
            num *= p;
        }
        if (num > 2000000000L) {
            num = 2000000000L;
        }
        return (int) num;
    }
    
    public void addFightWish() {
        Player bot = Player.addBoss(147, 0, this.getPercentLevel(550000, LuyenTap.getLevel(this.cName), 1.1F), this.getPercentLevel(5000, LuyenTap.getLevel(this.cName), 1.05F), true, 385, 360, null, 2000, -1);
        bot.cName = String.format(bot.cName, LuyenTap.getLevel(this.cName));
        bot.fightWish1 = this;
        if (LuyenTap.getLevel(this.cName) >= 100) {
            bot.isRecDam = false;
        }
        bot.cMissPercentGoc += LuyenTap.getLevel(this.cName) / 2;
        this.zoneMap.join(bot, 0, -1, -1);
        this.fightWish2 = bot;
        this.setPos(485, 360, 1);
        this.zoneMap.hideNpc(56, true);
        this.zoneMap.isFightWish = true;
        this.lastFight = System.currentTimeMillis();
    }
    
    public void updatePhatQua() {
        if (this.playerId != -1) {
            //Phat qua top
            LuyenTap o = LuyenTap.removeGift(this.playerId);
            if (o != null) {
                if (o.gift == 1) {
                    Item item = new Item(0, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(77, 3));
                    item.options.add(new ItemOption(103, 3));
                    item.options.add(new ItemOption(50, 3));
                    this.addEffectChar(58, 1, 0, 1, 1, (int) ((o.last - System.currentTimeMillis()) / 1000L), 2, true, true, item);
                }
                if (o.gift == 2) {
                    Item item = new Item(0, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(77, 2));
                    item.options.add(new ItemOption(103, 2));
                    item.options.add(new ItemOption(50, 2));
                    this.addEffectChar(57, 1, 0, 1, 1, (int) ((o.last - System.currentTimeMillis()) / 1000L), 2, true, true, item);
                }
                if (o.gift == 3) {
                    Item item = new Item(0, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(77, 1));
                    item.options.add(new ItemOption(103, 1));
                    item.options.add(new ItemOption(50, 1));
                    this.addEffectChar(56, 1, 0, 1, 1, (int) ((o.last - System.currentTimeMillis()) / 1000L), 2, true, true, item);
                }
            }
        }
    }
    
    public void skillXayda1(int time, Char player) {
        this.addChat(0, mResources.SKILL_XAYDA1);
        player.hold(1, time, 40, -1, -1);
        this.gong(time);
        this.skillXaydaFocus1 = player;
        this.timeHit = time;
    }
    
    public void skillXayda2(int time, Char player) {
        player.hold(1, time, 40, -1, -1);
        this.skillXaydaFocus2 = player;
        this.tSkillXayda2_2 = time;
    }
    
    public void skillXayda3(int time, Char player) {
        this.addChat(1, mResources.HA_HA_HA_HA_HA_HA);
        Skill skill = Skill.arrSkill[56].clone();
        this.skill_not_focus((byte)1, skill);
        this.chargeDamage = 5;
        this.gong(this.tCharge = time);
        this.skillXaydaFocus3 = player;
    }
    
    public void skillXayda4(int time, int p) {
        this.skill_not_focus((byte)1, Skill.arrSkill[62].clone());
        this.chargeDamage = p;
        this.gong(this.tCharge = time);
        this.cHPFull = this.cHPGoc = (int) (this.cHPGoc + ((float)Util.gI().nextInt(1, 5) / 100.0F) * this.cHPGoc);
        this.zoneMap.playerLoadHP(this, 0);
    }
    
    public void gong(int time) {
        this.gong = true;
        this.timeGong2 = time;
        if (this.zoneMap != null) {
            this.zoneMap.startGong(this.charID);
        }
    }
    
    public void getItem(int type, int id) {
        Util.gI().log("type="+type+" id="+id);
        //ItemBox to Bag or Body\\
        if (type == 0) {
            Item item = null;
            try {
                item = this.arrItemBox[id];
            } catch (Exception e) {}
            if (item != null) {
                int indexUI = item.getIndexBody();
                if (item.isTypeBody() && item.getstrRequire() <= this.cPower && this.arrItemBody[indexUI] == null && (item.template.gender == 3 || (item.template.gender == this.cgender))) {
                    this.addItemBody(item, indexUI);
                    this.arrItemBox[id] = null;
                    this.updateAll();
                    this.session.service.Body(this.head, this.arrItemBody);
                    this.session.service.ItemBox(id, 0);
                    this.session.service.meLoadPoint();
                    this.zoneMap.playerLoadAll(this);
                    this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    this.session.service.getBag(this.charID, this.bag);
                    this.session.service.setEff(this.charID, this.idAuraEff, this.idEff_Set_Item);
                    if (this.ctaskId == 0 && this.ctaskIndex == 3 && item.template.id == 12) {
                        this.updateTask(1);
                    }
                } else {
                    if (item.isBigItem()) {
                        for (int i = 0; i < this.arrItemBag.length; i++) {
                            if (this.arrItemBag[i] == null) {
                                this.addItemBag(item.clone(), i);
                                item.quantity = 0;
                            } else {
                                if (this.isAlikeItem(this.arrItemBag[i], item) && this.arrItemBag[i].quantity < this.arrItemBag[i].maxQuantity()) {
                                    if (this.arrItemBag[i].quantity + item.quantity > this.arrItemBag[i].maxQuantity()) {
                                        int num = this.arrItemBag[i].quantity;
                                        this.arrItemBag[i].quantity = this.arrItemBag[i].maxQuantity();
                                        item.quantity = item.quantity - (this.arrItemBag[i].quantity - num);
                                    } else {
                                        int num = this.arrItemBag[i].quantity;
                                        this.arrItemBag[i].quantity = this.arrItemBag[i].quantity + item.quantity;
                                        item.quantity = item.quantity - (this.arrItemBag[i].quantity - num);
                                    }
                                }
                                if (this.arrItemBag[i].expires > item.expires && item.expires != -1) {
                                    this.arrItemBag[i].setExpires(item.expires);
                                }
                            }
                            if (item.quantity <= 0) {
                                this.arrItemBox[id] = null;
                                this.session.service.ItemBox(id, 0);
                                break;
                            }
                        }
                        this.session.service.Box(this.arrItemBox);
                        this.session.service.Bag(this.arrItemBag);
                    } else {
                        indexUI = this.getItemBagIndex(item);
                        if (indexUI != -1) {
                            Item it2 = this.arrItemBag[indexUI];
                            if (it2.isItemSLL()) {
                                int quantity = item.getParamOption(31);
                                if (item.getParamOption(31) + it2.getParamOption(31) > 30000) {
                                    quantity = 30000 - it2.getParamOption(31);
                                }
                                this.addQuantityItemBagByIndex(indexUI, quantity);
                                this.addQuantityItemBoxByIndex(id, -quantity);
                            } else {
                                int quantity = item.quantity;
                                if (item.quantity + it2.quantity > it2.maxQuantity()) {
                                    quantity = it2.maxQuantity() - it2.quantity;
                                }
                                this.addQuantityItemBagByIndex(indexUI, quantity);
                                this.addQuantityItemBoxByIndex(id, -quantity);
                            }
                            if (this.arrItemBag[indexUI].expires > item.expires && item.expires != -1) {
                                this.arrItemBag[indexUI].setExpires(item.expires);
                            }
                            this.session.service.Box(this.arrItemBox);
                            this.session.service.Bag(this.arrItemBag);
                        } else {
                            indexUI = this.getEmptyBagIndex();
                            if (indexUI != -1) {
                                this.arrItemBox[id] = null;
                                this.addItemBag(item, indexUI);
                                this.session.service.ItemBox(id, 0);
                                this.session.service.Bag(this.arrItemBag);
                                if (this.ctaskId == 0 && this.ctaskIndex == 3 && item.template.id == 12) {
                                    this.updateTask(1);
                                }
                            }
                        }
                        if (item.template.type == 23 || item.template.type == 24 || item.template.type == 32) {
                            this.updateAll();
                            this.session.service.meLoadPoint();
                            this.zoneMap.playerLoadAll(this);
                        }
                    }
                }
            }
        }
        //ItemBag to Box\\
        if (type == 1) {
            Item item = null;
            try {
                item = this.arrItemBag[id];
            } catch (Exception e) {}
            if (item != null && !item.isItemTask()) {
                if (item.isBigItem()) {
                    for (int i = 0; i < this.arrItemBox.length; i++) {
                        if (this.arrItemBox[i] == null) {
                            this.addItemBox(item.clone(), i);
                            item.quantity = 0;
                        } else {
                            if (this.isAlikeItem(this.arrItemBox[i], item) && this.arrItemBox[i].quantity < this.arrItemBox[i].maxQuantity()) {
                                if (this.arrItemBox[i].quantity + item.quantity > this.arrItemBox[i].maxQuantity()) {
                                    int num = this.arrItemBox[i].quantity;
                                    this.arrItemBox[i].quantity = this.arrItemBox[i].maxQuantity();
                                    item.quantity = item.quantity - (this.arrItemBox[i].quantity - num);
                                } else {
                                    int num = this.arrItemBox[i].quantity;
                                    this.arrItemBox[i].quantity = this.arrItemBox[i].quantity + item.quantity;
                                    item.quantity = item.quantity - (this.arrItemBox[i].quantity - num);
                                }
                            }
                            if (this.arrItemBox[i].expires > item.expires && item.expires != -1) {
                                this.arrItemBox[i].setExpires(item.expires);
                            }
                        }
                        if (item.quantity <= 0) {
                            this.arrItemBag[id] = null;
                            break;
                        }
                    }
                    this.session.service.Box(this.arrItemBox);
                    this.session.service.Bag(this.arrItemBag);
                } else {
                    int indexUI = this.getItemBoxIndex(item);
                    if (indexUI != -1) {
                        Item item2 = this.arrItemBox[indexUI];
                        if (item2.isItemSLL()) {
                            int quantity = item.getParamOption(31);
                            if (item.getParamOption(31) + item2.getParamOption(31) > 30000) {
                                quantity = 30000 - item2.getParamOption(31);
                            }
                            this.addQuantityItemBoxByIndex(indexUI, quantity);
                            this.addQuantityItemBagByIndex(id, -quantity);
                        } else {
                            int quantity = item.quantity;
                            if (item.quantity + item2.quantity > item2.maxQuantity()) {
                                quantity = item2.maxQuantity() - item2.quantity;
                            }
                            this.addQuantityItemBoxByIndex(indexUI, quantity);
                            this.addQuantityItemBagByIndex(id, -quantity);
                        }
                        if (this.arrItemBox[indexUI].expires > item.expires && item.expires != -1) {
                            this.arrItemBox[indexUI].setExpires(item.expires);
                        }
                        this.session.service.Box(this.arrItemBox);
                        this.session.service.Bag(this.arrItemBag);
                    } else {
                        indexUI = this.getEmptyBoxIndex();
                        if (indexUI != -1) {
                            this.arrItemBag[id] = null;
                            this.addItemBox(item, indexUI);
                            this.sortBag();
                            this.session.service.Box(this.arrItemBox);
                            this.session.service.Bag(this.arrItemBag);
                        }
                    }
                    if (item.template.type == 23 || item.template.type == 24 || item.template.type == 32) {
                        this.updateAll();
                        this.session.service.meLoadPoint();
                        this.zoneMap.playerLoadAll(this);
                    }
                    //usePet
                    if (item == this.usePet) {
                        this.usePet(null);
                    }
                    //usePetFollowz
                    if (this.checkPetFollowz(item)) {
                        this.checkClearPetFollowz(item);
                    }
                }
            }
        }
        //ItemBody to Box\\
        if (type == 3) {
            Item item = null;
            try {
                item = this.arrItemBody[id];
            } catch (Exception e) {}
            if (item != null) {
                int indexUI = this.getEmptyBoxIndex();
                if (indexUI != -1) {
                    this.addItemBox(item, indexUI);
                    this.arrItemBody[id] = null;
                    this.updateAll();
                    this.session.service.Body(this.head, this.arrItemBody);
                    this.session.service.Box(this.arrItemBox);
                    this.session.service.meLoadPoint();
                    this.zoneMap.playerLoadAll(this);
                    this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    this.session.service.getBag(this.charID, this.bag);
                    this.session.service.setEff(this.charID, this.idAuraEff, this.idEff_Set_Item);
                }
            }
        }
        //ItemBag to Body\\
        if (type == 4) {
            Item item = null;
            try {
                item = this.arrItemBag[id];
            } catch (Exception e) {}
            if (item != null) {
                if (item.getstrRequire() > this.cPower) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.ITEM_USE_NOT_POWER_TB, Util.gI().numberTostring(item.getstrRequire() - this.cPower)), null, (byte)0);
                } else if (item.template.gender != 3 && item.template.gender != this.cgender) {
                    this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TRANGBI_O_PHU_HOP, null, (byte)0);
                } else if (item.template.id == 1986) {
                    if (item.getParamOption(72) < 6) {
                        int array1[] = new int[]{2, 3, 4, 5, 6, 7};
                        int array2[] = new int[]{2, 3, 4, 5, 6, 7};
                        int array3[] = new int[]{30, 15, 10, 5, 3, 2};
                        this.session.myCharz().requestOpenUIItem(5, String.format(mResources.NANG_CAP_KIEMZ, item.template.name, array1[item.getParamOption(72)], array2[item.getParamOption(72)], array3[item.getParamOption(72)], item.indexUI));
                    } else {
                        this.addInfo1(mResources.TB_CHIDANH_CHODE);
                    }
                } else if (item.isTypeBody()) {
                    int indexUI2 = item.getIndexBody();
                    Item item2 = this.arrItemBody[indexUI2];
                    this.addItemBody(item, indexUI2);
                    this.arrItemBag[id] = null;
                    if (item2 != null) {
                        this.addItemBag(item2, id);
                    }
                    this.sortBag();
                    this.updateAll();
                    this.session.service.Body(this.head, this.arrItemBody);
                    this.session.service.Bag(this.arrItemBag);
                    this.session.service.meLoadPoint();
                    this.zoneMap.playerLoadAll(this);
                    this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    this.session.service.getBag(this.charID, this.bag);
                    this.session.service.setEff(this.charID, this.idAuraEff, this.idEff_Set_Item);
                }
            }
        }
        //ItemBody to Bag\\
        if (type == 5) {
            Item item = null;
            try {
                item = this.arrItemBody[id];
            } catch (Exception e) {}
            if (item != null) {
                int indexUI = this.getEmptyBagIndex();
                if (indexUI != -1) {
                    //add option random hide
                    if (item.template.type == 11 && item.isHaveOption(210)) {
                        this.addOptionHide(item, item.getParamOption(210));
                        item.options.remove(item.getOption(210));
                    }
                    this.addItemBag(item, indexUI);
                    this.arrItemBody[id] = null;
                    this.updateAll();
                    this.session.service.Body(this.head, this.arrItemBody);
                    this.session.service.Bag(this.arrItemBag);
                    this.session.service.meLoadPoint();
                    this.zoneMap.playerLoadAll(this);
                    this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    this.session.service.getBag(this.charID, this.bag);
                    this.session.service.setEff(this.charID, this.idAuraEff, this.idEff_Set_Item);
                }
            }
        }
        //ItemBag to Body de tu
        if (type == 6 && this.myPet != null) {
            if (this.myPetz().isBaby) {
                this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.IS_BABY, null, (byte)0);
            } else {
                Item item = null;
                try {
                    item = this.arrItemBag[id];
                } catch (Exception e) {}
                if (item != null) {
                    if (item.getstrRequire() > this.myPetz().cPower) {
                        this.session.service.chatTHEGIOI(mResources.EMPTY, String.format(mResources.ITEM_USE_NOT_POWER_TB, Util.gI().numberTostring(item.getstrRequire() - this.myPetz().cPower)), null, (byte)0);
                    } else if (item.template.gender != 3 && item.template.gender != this.myPetz().cgender) {
                        this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TRANGBI_O_PHU_HOP, null, (byte)0);
                    } else if (item.isTypeBody()) {
                        if ((item.template.type == 0 || item.template.type == 1 ||item.template.type == 2 || item.template.type == 3 || item.template.type == 4 || item.template.type == 5 || item.template.id == 1986)) {
                            
                            int indexUI2 = item.getIndexBody();
                            Item item2 = this.myPetz().arrItemBody[indexUI2];
                            this.myPetz().addItemBody(item, indexUI2);
                            this.arrItemBag[id] = null;
                            if (item2 != null) {
                                this.addItemBag(item2, id);
                            }
                            this.sortBag();
                            this.myPetz().updateAll();
                            this.myCharz().updateAll();
                            this.session.service.petInfo2(this.myPetz());
                            this.session.service.Bag(this.arrItemBag);
                            if (this.myPetz().zoneMap != null) {
                                this.myPetz().zoneMap.playerLoadAll(this.myPetz());
                                this.session.service.chat(this.myPetz().charID, mResources.THANK_KIS);
                            }
                            this.myCharz().session.service.meLoadPoint();
                            if (this.myCharz().zoneMap != null) {
                                this.myCharz().zoneMap.playerLoadAll(this.myCharz());
                            }
                        } else {
                            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.TB_O_PHU_HOP, null, (byte)0);
                        }
                    }
                }
            }
        }
        //ItemBody de tu to Bag\\
        if (type == 7 && this.myPet != null) {
            Item item = null;
            try {
                item = this.myPetz().arrItemBody[id];
            } catch (Exception e) {}
            if (item != null) {
                int indexUI = this.getEmptyBagIndex();
                if (indexUI != -1) {
                    this.addItemBag(item, indexUI);
                    this.myPetz().arrItemBody[id] = null;
                    this.myPetz().updateAll();
                    this.myCharz().updateAll();
                    this.session.service.petInfo2(this.myPetz());
                    this.session.service.Bag(this.arrItemBag);
                    if (this.myPetz().zoneMap != null) {
                        this.myPetz().zoneMap.playerLoadAll(this.myPetz());
                        this.session.service.chat(this.myPetz().charID, mResources.THANK_KIS);
                    }
                    
                    this.myCharz().session.service.meLoadPoint();
                    if (this.myCharz().zoneMap != null) {
                        this.myCharz().zoneMap.playerLoadAll(this.myCharz());
                    }
                }
            }
        }
        
    }
    
    public void useItem(int type, int where, int index, int template) {
        Util.gI().log("type="+type+" where="+where+" index="+index+" template="+template);
        if (type == 0) {
            Item item = null;
            //ItemBag
            if (where == 1) {
                if(index != -1) {
                    try {
                        item = this.arrItemBag[index];
                    } catch (Exception e) {}
                } else {
                    item = this.getItemBagById(template);
                }
            }
            //ItemBox
            if (where == 2) {
                if(index != -1) {
                    try {
                        item = this.arrItemBox[index];
                    } catch (Exception e) {}
                } else {
                    item = this.getItemBoxById(template);
                }
            }
            //use Item not null
            if (item != null) {
                if (where == 2) {
                    this.addInfo1(mResources.LAY_RA_DI);
                } else if (item.getstrRequire() > this.cPower) {
                    this.addInfo1(String.format(mResources.ITEM_USE_NOT_POWER, Util.gI().numberTostring(item.getstrRequire() - this.cPower)));
                } else {
                    dragon.t.UseItem.useItem(this, item);
                }
            }
        }
        if (type == 1 || type == 2) {
            Item item = null;
            //ItemBody
            if (where == 0) {
                if(index != -1) {
                    try {
                        item = this.arrItemBody[index];
                    } catch (Exception e) {}
                } else {
                    item = this.getItemBodyById(template);
                }
            }
            //ItemBag
            if (where == 1) {
                if(index != -1) {
                    try {
                        item = this.arrItemBag[index];
                    } catch (Exception e) {}
                } else {
                    item = this.getItemBagById(template);
                }
            }
            //ItemBox
            if (where == 2) {
                if(index != -1) {
                    try {
                        item = this.arrItemBox[index];
                    } catch (Exception e) {}
                } else {
                    item = this.getItemBoxById(template);
                }
            }
            //Vut item
            if (item != null && !item.isItemTask()) {
                if (item.template.id == 570 || !item.isItemForThrow() || (this.canAutoPlay && item.template.id == 521)) {
                    this.addInfo1(mResources.NOT_THOWS_ITEM);
                } else if (this.zoneMap.map.isMapHome()) {
                    this.addInfo1(mResources.THOWS_ITEM_SAN_NHA);
                } else {
                    if (type == 1) {
                        if (item.isItemTL()) {
                            this.session.service.itemRequest(56, where, index, String.format(mResources.LOAI_BO_2, item.template.name));
                        } else {
                            this.session.service.itemRequest(56, where, index, String.format(mResources.LOAI_BO, item.template.name));
                        }
                    } else {
                        if (item.typeUI == 5) {
                            this.arrItemBody[item.indexUI] = null;
                            this.updateAll();
                            this.session.service.Body(this.head, this.arrItemBody);
                            this.session.service.meLoadPoint();
                            this.zoneMap.playerLoadAll(this);
                            this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                            this.session.service.getBag(this.charID, this.bag);
                            this.session.service.setEff(this.charID, this.idAuraEff, this.idEff_Set_Item);
                        }
                        if (item.typeUI == 3) {
                            this.arrItemBag[item.indexUI] = null;
                            this.sortBag();
                            this.session.service.Bag(this.arrItemBag);
                            if (item.template.type == 23 || item.template.type == 24 || item.template.type == 32) {
                                this.updateAll();
                                this.session.service.meLoadPoint();
                                this.zoneMap.playerLoadAll(this);
                            }
                            //usePet
                            if (item == this.usePet) {
                                this.usePet(null);
                            }
                            //usePetFollowz
                            if (this.checkPetFollowz(item)) {
                                this.checkClearPetFollowz(item);
                            }
                        }
                        if (item.typeUI == 4) {
                            this.arrItemBox[item.indexUI] = null;
                            this.session.service.ItemBox(item.indexUI, 0);
                        }
                        //Nhan manh
                        if (item.isItemTL()) {
                            int itemBo = Util.gI().nextInt(1066, 1070);
                            this.addItemBag(0, new Item(itemBo, false, Util.gI().nextInt(30, 50), ItemOption.getOption(itemBo, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY));
                        }
                    }
                }
            }
        }
    }
    
    public boolean isIndexUI(int indexUI, Item[] arrItem) {
        try {
            for (byte i = 0; i < arrItem.length; i++) {
                Item item = arrItem[i];
                if (item != null) {
                    if (item.indexUI == indexUI) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {}
        return false;
    }
    
    private void removeMyPets(Char o) {
        if (this.myPetz5s != null && !this.myPetz5s.isEmpty()) {
            if (o.zoneMap != null) {
                o.zoneMap.exit(o, o.typeTeleport);
            }
            this.myPetz5s.remove(o);
        }
    }
    
    public void joinZone(ZoneMap zoneMap, int x, int y, int telePort, int time) {
        this.waitJoinZone = zoneMap;
        this.xJoinZone = x;
        this.yJoinZone = y;
        this.telePortJoinZone = telePort;
        this.timeJoinZone = time;
    }
    
    public void addMyPet5(Char pet) {
        if (this.myPetz5s == null) {
            this.myPetz5s = new ArrayList<>();
        }
        pet.myChar5 = this;
        this.myPetz5s.add(pet);
    }
    
    private void clearMyPets() {
        if (this.myChar5 != null) {
            this.myChar5.myPetz5s.remove(this);
        }
        while(this.myPetz5s != null && !this.myPetz5s.isEmpty()) {
            Char pet = this.myPetz5s.remove(0);
            if (pet.zoneMap != null) {
                pet.zoneMap.exit(pet, pet.typeTeleport);
            }
            this.myPetz5s.remove(pet);
        }
    }
    
    private void callMaiAndFu() {
        this.isCallFuAndMai = true;
        Char mai = Player.addBoss(157, 0, -1, -1, false, 370, 360, this.zoneMap, -1, -1);
        Char fu = Player.addBoss(156, 0, -1, -1, false, 505, 360, null, -1, -1);
        String chatMai[] = mResources.CHAT_MAI_ARR.split("\\|");
        String chatMe[] = mResources.CHAT_ME_ARR.split("\\|");
        String chatFu[] = mResources.CHAT_FU_ARR.split("\\|");
        String chatBird[] = mResources.CHAT_BIRD1.split("\\|");
        mai.addChat(3000, chatMai[0]);
        this.addChat(4000, chatMe[0]);
        mai.addChat(7000, chatMai[1]);
        this.addChat(10000, chatMe[1]);
        this.addChat(13000, chatMe[2]);
        mai.addChat(16000, chatMai[2]);
        fu.joinZone(this.zoneMap, 505, 360, 2, 19000);
        fu.addChat(21000, chatFu[0]);
        fu.addChat(24000, chatFu[1]);
        fu.addChat(27000, chatFu[2]);
        this.addChat(30000, chatMe[3]);
        fu.addChat(33000, chatFu[3]);
        fu.addChat(36000, chatFu[4]);
        fu.addChat(40000, chatFu[5]);
        fu.timeClear = 42000;
        mai.timeClear = 42000;
        for (int i = 0; i < chatBird.length; i++) {
            this.addInfo1(42000 + (i * 50), chatBird[i]);
        }
        this.isCallCumber = 1;
        this.addMyPet5(mai);
        this.addMyPet5(fu);
    }
    
    public int[][] sortCharIdDam() {
        int[][] array;
        synchronized(this.charDam) {
            array = new int[this.charDam.size()][2];
            if (!this.charDam.isEmpty()) {
                int i = 0;
                Iterator<Integer> itr = this.charDam.keySet().iterator();
                while (itr.hasNext()) {
                    int key = itr.next();
                    array[i][0] = key;
                    array[i][1] = this.charDam.get(key);
                    i++;
                }
            }
        }
        // sort giam dan
        Arrays.sort(array, Comparator.comparingInt((int[] arr) -> arr[1]).reversed());
        return array;
    }
    
    public long getTotalDam() {
        long total = 0;
        synchronized(this.charDam) {
            if (!this.charDam.isEmpty()) {
                int i = 0;
                Iterator<Integer> itr = this.charDam.keySet().iterator();
                while (itr.hasNext()) {
                    int key = itr.next();
                    total += this.charDam.get(key);
                    i++;
                }
            }
        }
        return total;
    }
    
    public void sendHPData(int nTop) {
        String str = "";
        long total = this.getTotalDam();
        int array[][] = this.sortCharIdDam();
        for (int i = 0, top = 1; i < array.length && top <= nTop; i++) {
            Session_ME player = Server.gI().getByCId(array[i][0]);
            if (player != null) {
                str += String.format("#%d %s [%d%%]\n", top, player.myCharz().cName, (int)(100.0F / (float)total * (float)array[i][1]));
                top++;
            }
        }
        if (!str.isEmpty() && this.zoneMap != null && this.isInMap) {
            this.zoneMap.messageTime(0, str, 10);
        }
    }
    
    public void getItemMore(int type, int index, int num) {
        ArrayList<Item> itemMores = null;
        if (this.isItemMore == 1) {
            itemMores = this.arrItemMore;
        }
        if (this.isItemMore == 2) {
            itemMores = this.arrItemMore2;
        }
        if (itemMores != null && num > 0 && index >= 0 && index < itemMores.size()) {
            
            num = 1;
            Item item;
            Util.gI().log("type="+type+" index="+index+" num="+num);
            //Nhan
            if (type == 0) {
                item = itemMores.get(index);
                if (item != null) {
                    if (this.addItemBag(0, item)) {
                        itemMores.remove(item);
                        this.session.service.openItemMore(itemMores);
                    }
                }
            }
            //Xoa 
            if (type == 1) {
                item = itemMores.remove(index);
                this.session.service.openItemMore(itemMores);
                if (item != null) {
                    this.addInfo1(String.format(mResources.DA_XOA_ITEM, item.template.name));
                }
            }
            //Nhan het
            if (type == 2) {
                while (!itemMores.isEmpty()) {
                    item = itemMores.get(0);
                    if (item != null) {
                        if (this.addItemBag(0, item)) {
                            itemMores.remove(0);
                            this.session.service.openItemMore(itemMores);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void bathGoldGift() {
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (this.canProceed()) {
            //qua tai day
            this.updateEXP(2, 1000);
            if  (Util.gI().nextInt(100) < 15) {
                Item item = new Item(933, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(31, Util.gI().nextInt(5,10 )));
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);    
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(934, false, 1, ItemOption.getOption(934, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);  
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(1229, false, 5, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);  
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(733, false, 1, ItemOption.getOption(733, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(93, 7));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(1000) < 1) {
                Item item = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(591, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(47, 450));
                item.options.add(new ItemOption(108, 15));
                item.options.add(new ItemOption(33, 1));
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(1000) < 1) {
                Item item = new Item(591, false, 1, ItemOption.getOption(591, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(120) < 1) {
                Item item = new Item(1143, false, 1, ItemOption.getOption(1143, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else {
                Item item = new Item(933, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(31, Util.gI().nextInt(1, 5)));
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);
            }
        }
    }
    
    public void bathWoodGift() {
        if (this.getEmptyBagCount() == 0) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 1));
        } else if (this.canProceed()) {
            //qua tai day
            this.updateEXP(2, 1000);
            if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(20, false, 1, ItemOption.getOption(20, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(595, false, 10, ItemOption.getOption(595, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 15) {
                Item item = new Item(933, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(31, Util.gI().nextInt(5, 10)));
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(934, false, 1, ItemOption.getOption(934, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(821, false, 1, ItemOption.getOption(821, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                 item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 20) {
                Item item = new Item(1229, false, 1, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(734, false, 1, ItemOption.getOption(734, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(93, 7));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 10) {
                Item item = new Item(671, false, 1, ItemOption.getOption(671, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(100) < 5) {
                Item item = new Item(672, false, 1, ItemOption.getOption(672, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else if (Util.gI().nextInt(1000) < 1) {
                Item item = new Item(464, false, 1, ItemOption.getOption(464, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                this.addItemBag(0, item);
            } else {
                Item item = new Item(933, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                item.options.add(new ItemOption(31, Util.gI().nextInt(1, 5)));
                item.options.add(new ItemOption(30, 0));
                this.addItemBag(0, item);
            }
        }
    }
    
    //Ham su ly du lieu dua vao
    public Object[] checkString(String src, int status) {
        String array[] = src.split(";:");
        boolean flag0 = true;
        ArrayList<Item> aItemCombine = null;
        ArrayList<MenuInfo> menus = status == 0 ? new ArrayList<>() : null;
        String chat = "";
        int quntityEmptyBag = -1;
        for (String array1 : array) {
            String[] array2 = array1.split(" ", 2);
            if (array2[0].equals("text0")) {
                if (status == 0) {
                    chat += array2[1];
                }
            }
            if (array2[0].equals("co0")) {
                if (status == 0) {
                    aItemCombine = new ArrayList<>();
                }
            }
            if (array2[0].equals("item0")) {
                String array3[] = array2[1].split(" ", 2);
                int id = Integer.parseInt(array3[0]);
                int quantity = Integer.parseInt(array3[1]);
                int quantity0 = this.getItemBagQuantityById(id);
                if (status == 0) {
                    chat = String.format("%s\n|%d|%s %d/%d", chat, quantity0 >= quantity ? 2 : 7, ItemTemplate.get((short)id).name, quantity0, quantity);
                    if (aItemCombine != null && quantity0 > 0) {
                        aItemCombine.add(this.getItemBagById(id));
                    }
                    if (quantity0 < quantity) {
                        flag0 = false;
                    }
                } else {
                    this.useItemBagById(id, quantity);
                }
            }
            if (array2[0].equals("item1")) {
                String array3[] = array2[1].split(" ", 3);
                int id = Integer.parseInt(array3[0]);
                int quantity = Integer.parseInt(array3[1]);
                int quantity2 = Integer.parseInt(array3[2]);
                int quantity0 = this.getItemBagQuantityById(id);
                if (status == 0) {
                    chat = String.format("%s\n|%d|%s %d/%d", chat, quantity0 >= quantity ? 2 : 7, ItemTemplate.get((short)id).name, quantity0, quantity);
                    if (aItemCombine != null && quantity0 > 0) {
                        aItemCombine.add(this.getItemBagById(id));
                    }
                    if (quantity0 < quantity) {
                        flag0 = false;
                    }
                } else {
                    this.useItemBagById(id, quantity2);
                }
            }
            if (array2[0].equals("item2")) {
                String array3[] = array2[1].split(" ", 3);
                int id = Integer.parseInt(array3[0]);
                int quantity = Integer.parseInt(array3[1]);
                int quantity0 = this.getItemBagQuantityById(id);
                if (status == 0) {
                    if (aItemCombine != null && quantity0 > 0) {
                        aItemCombine.add(this.getItemBagById(id));
                    }
                    if (quantity0 < quantity) {
                        flag0 = false;
                    }
                } else {
                    this.useItemBagById(id, quantity);
                }
            }
            if (array2[0].equals("xu0")) {
                int quantity = Integer.parseInt(array2[1]);
                if (status == 0) {
                    chat = String.format("%s\n|%d|%s: %s", chat, this.xu >= quantity ? 2 : 7, mResources.GOLD_PRICE, Util.gI().getFormatNumber(quantity));
                    if (this.xu < quantity) {
                        flag0 = false;
                    }
                } else {
                    this.updateXu(-quantity, 2);
                }
            }
            if (array2[0].equals("ngoc0")) {
                int quantity = Integer.parseInt(array2[1]);
                if (status == 0) {
                    chat = String.format("%s\n|%d|%s: %s", chat, this.getLuong() >= quantity ? 2 : 7, mResources.JADE_PRICE, Util.gI().getFormatNumber(quantity));
                    if (this.getLuong() < quantity) {
                        flag0 = false;
                    }
                } else {
                    this.updateLuong(-quantity, 2);
                }
            }
            if (array2[0].equals("map0")) {
                if (status == 0) {
                    String array3[] = array2[1].split(" ");
                    if (array3.length > 0) {
                        int id0 = Integer.parseInt(array3[0]);
                        String text = MapTemplate.arrMapTemplate[id0].mapName;
                        boolean flag = id0 == this.mapTemplateId;
                        for (int j = 1; j < array3.length; j++) {
                            int id = Integer.parseInt(array3[j]);
                            text = String.format("%s%s%s", text, j % 2 != 0 ? ", " : "\n", MapTemplate.arrMapTemplate[id].mapName);
                            if (id == this.mapTemplateId) {
                                flag = true;
                            }
                        }
                        chat = String.format("%s\n|%d|%s", chat, flag ? 2 : 7, text);
                        if (flag0 && !flag) {
                            flag0 = false;
                        }
                    }
                }
            }
            if (array2[0].equals("menu0")) {
                if (status == 0) {
                    String array3[] = array2[1].split(":=", 2);
                    if (menus != null) {
                        menus.add(new MenuInfo(array3[0], Integer.parseInt(array3[1])));
                    }
                }
            }
            if (array2[0].equals("menu1") && flag0) {
                if (status == 0) {
                    String array3[] = array2[1].split(":=", 2);
                    if (menus != null) {
                        menus.add(new MenuInfo(array3[0], Integer.parseInt(array3[1]), 0) {
                            @Override
                            public boolean execute() {
                                Object array[] = Char.this.checkString(src, 0);
                                if ((int)array[3] != -1) {
                                    Char.this.addInfo1(String.format(mResources.BAG_FULL_2, (int)array[3]));
                                } else if ((boolean)array[0] && Char.this.canProceed()) {
                                    Char.this.checkString(src, 1);
                                    return true;
                                }
                                return false;
                            }
                            
                            @Override
                            public void clean() {
                                Char.this.resetMenu();
                            }
                        });
                    }
                }
            }
            if (array2[0].equals("menu2")) {
                if (status == 0) {
                    String array3[] = array2[1].split(":=", 3);
                    if (menus != null) {
                        String array4[] = array3[2].split(" ");
                        String tileMN = array3[0];
                        if (array4.length > 0) {
                            String lName = String.format("X%s %s", array4[0], ItemTemplate.get(Short.parseShort(array4[1])).name);
                            for (int j = 2; j < array4.length; j++) {
                                lName = String.format("%s, %s", lName, ItemTemplate.get(Short.parseShort(array4[j])).name);
                            }
                            tileMN = String.format(tileMN, lName);
                        }
                        menus.add(new MenuInfo(tileMN, Integer.parseInt(array3[1]), array4) {
                            @Override
                            public boolean execute() {
                                Object array[] = Char.this.checkString(src, 0);
                                if ((int)array[3] != -1) {
                                    Char.this.addInfo1(String.format(mResources.BAG_FULL_2, (int)array[3]));
                                } else if (array4.length > 0 && Char.this.canProceed()) {
                                    int quantity = Integer.parseInt(array4[0]);
                                    for (int j = 1; j < array4.length; j++) {
                                        short id = Short.parseShort(array4[j]);
                                        int quantity0 = Char.this.getItemBagQuantityById(id);
                                        if (quantity0 < quantity) {
                                            if (quantity > 1) {
                                                Char.this.addInfo1(String.format(mResources.LACK_ITEM1, quantity, ItemTemplate.get(id).name));
                                            } else {
                                                Char.this.addInfo1(String.format(mResources.LACK_ITEM2, ItemTemplate.get(id).name));
                                            }
                                            return false;
                                        }
                                    }
                                    for (int j = 1; j < array4.length; j++) {
                                        Char.this.useItemBagById(Short.parseShort(array4[j]), quantity);
                                    }
                                }
                                return true;
                            }
                            
                            @Override
                            public void clean() {
                                Char.this.resetMenu();
                            }
                        });
                    }
                }
            }
            if (array2[0].equals("cbag0")) {
                int quantity = Integer.parseInt(array2[1]);
                if (status == 0) {
                    if (quantity > this.getEmptyBagCount()) {
                        quntityEmptyBag = quantity;
                    }
                }
            }
            if (array2[0].equals("obj0")) {
                if (status == 0) {
                    String array3[] = array2[1].split("&nbsp;");
                    String array4[] = array3[0].split(" ");
                    for (int j = 0; array4 != null && j < array4.length; j++) {
                        for (int k = 0; menus != null && k < menus.size(); k++) {
                            if (menus.get(k).type == Integer.parseInt(array4[j])) {
                                menus.get(k).arrayStr0 = array3;
                            }
                        }
                    }
                }
            }
            if (array2[0].equals("stm")) {
                if (status == 0) {
                    String array3[] = array2[1].split(" ");
                    for (int j = 0; array3 != null && j < array3.length; j++) {
                        for (int k = 0; menus != null && k < menus.size(); k++) {
                            if (menus.get(k).type == Integer.parseInt(array3[j])) {
                                menus.get(k).stm = src;
                            }
                        }
                    }
                }
            }
            if (array2[0].equals("cm0")) {
                if (status == 0 && !flag0) {
                    String array3[] = array2[1].split(" ");
                    for (int j = 0; array3 != null && menus != null && j < array3.length; j++) {
                        int k = menus.size() - 1;
                        while (k >= 0) {
                            if (menus.get(k).type == Integer.parseInt(array3[j])) {
                                menus.remove(k);
                            }
                            k--;
                        }
                    }
                }
            }
        }
        if (aItemCombine != null) {
            this.session.service.setCombineEff(aItemCombine, npcId);
        }
        return new Object[]{flag0, chat, menus, quntityEmptyBag};
    }
    
    public void requestOpenUIItem(int npcId, String src) {
        Object array[] = this.checkString(src, 0);
        this.resetMenu();
        this.menuBoard.chat = (String) array[1];
        ArrayList<MenuInfo> arrayList = (ArrayList<MenuInfo>) array[2];
        for (int i = 0; i < arrayList.size(); i++) this.menuBoard.arrMenu.add(arrayList.get(i));
        this.menuBoard.openUIConfirm(npcId, null, null, -1);
    }
    
    public Char getCharClosest() {
        if (this.zoneMap != null) {
            synchronized(this.zoneMap.players) {
                Char pclosest = null;
                for (int i = 0; i < this.zoneMap.players.size(); i++) {
                    if (!this.isMeCanAttackOtherPlayer(this.zoneMap.players.get(i)) || this.isTemplate == this.zoneMap.players.get(i).isTemplate) {
                        continue;
                    }
                    if (pclosest == null || (Math.abs(this.zoneMap.players.get(i).cx - this.cx) <= Math.abs(pclosest.cx - this.cx) && Math.abs(this.zoneMap.players.get(i).cy - this.cy) <= Math.abs(pclosest.cy - this.zoneMap.players.get(i).cy))) {
                        pclosest = this.zoneMap.players.get(i);
                    }
                }
                return pclosest;
            }
        }
        return null;
    }
    
    public int nangKiemZ(int type, Item item) {
        if (item != null && item.template.id == 1986 && item.getParamOption(72) < 6) {
            boolean flag = Util.gI().nextInt(100) < new int[]{30, 15, 5, 3, 2, 1}[item.getParamOption(72)];
            if (flag) {
                if (type == 1) {
                    this.addInfo1(mResources.THANH_CONG);
                }
                //++
                int array[][] = new int[][] {
                    {50, 1, 2, 3, 4, 7, 9},
                    {77, 1, 3, 5, 7, 9, 12},
                    {103, 1, 3, 5, 7, 9, 12},
                    {77, 1, 3, 5, 7, 9, 12},
                    {103, 1, 3, 5, 7, 9, 12},
                    {50, 1, 2, 3, 4, 7, 9},
                    {103, 1, 3, 5, 7, 9, 12},
                    {77, 1, 3, 5, 7, 9, 12},
                    {50, 1, 2, 3, 4, 7, 9},
                };
                int num1 = Util.gI().nextInt(array.length);
                if (item.isHaveOption(array[num1][0])) {
                    item.getOption(array[num1][0]).param += array[num1][item.getParamOption(72) + 1];
                }
                //Khong co option + tao moi, else ++
                if (!item.isHaveOption(72)) {
                    item.options.add(new ItemOption(72, 1));
                } else {
                    item.getOption(72).param++;
                }
                this.session.service.Bag(this.arrItemBag);
            } else {
                if (type == 1) {
                    this.addInfo1(mResources.THAT_BAI);
                }
            }
            return flag ? 1 : 0;
        }
        return -1;
    }
    
    public void giftSeason1(int num) {
        if (this.getEmptyBagCount() < 15) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 15));
        } else if (2000 > this.myObj().pointEventVIP) {
            
        } else if (this.canProceed()) {
            this.myObj().pointEventVIP -= 2000;
            //20 ti vang
            this.updateXu(20000000000L, 1);
            //de tu
            if (num == 0) {
                Player.mabuInfo(this);
//                Player.petInfo(this, this.cgender);
            }
            
            //qua tai day
            Item item1 = new Item(1229, false, 4999, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            //lech teamobi 1987
            Item item2 = new Item(1987, false, 299, ItemOption.getOption(1987, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item3 = new Item(970, false, 10, ItemOption.getOption(970, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item4 = new Item(956, false, 10, ItemOption.getOption(956, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item5 = new Item(1143, false, 99, ItemOption.getOption(1143, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item6 = new Item(904, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item6.options.add(new ItemOption(50, 32));
            item6.options.add(new ItemOption(77, 32));
            item6.options.add(new ItemOption(103, 32));
            item6.options.add(new ItemOption(5, 20));
            Item item7 = new Item(909, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item7.options.add(new ItemOption(50, 7));
            item7.options.add(new ItemOption(77, 7));
            item7.options.add(new ItemOption(103, 7));   
            item7.options.add(new ItemOption(30, 1)); 
            Item item8 = new Item(1223, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item8.options.add(new ItemOption(50, 10));
            item8.options.add(new ItemOption(77, 10));
            item8.options.add(new ItemOption(103,10)); 
            item8.options.add(new ItemOption(30,1)); 
            Item item9 = new Item(1131, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item9.options.add(new ItemOption(148, 25));
            item9.options.add(new ItemOption(84, 1));
            item9.options.add(new ItemOption(175, 20));
            item9.options.add(new ItemOption(93, 30));
            Item item10 = new Item(1204, false, 3, ItemOption.getOption(1204, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            //add bag
            this.addItemBag(0, item1);
            this.addItemBag(0, item2);
            this.addItemBag(0, item3);
            this.addItemBag(0, item4);
            this.addItemBag(0, item5);
            this.addItemBag(0, item6);
            this.addItemBag(0, item7);
            this.addItemBag(0, item8);
            this.addItemBag(0, item9);
            this.addItemBag(0, item10);
            //eff
            this.session.myCharz().removeEffChar(0, 1000);
            Item item = new Item(395, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item.options.add(new ItemOption(77, 3));
            item.options.add(new ItemOption(103, 3));
            item.options.add(new ItemOption(50, 3));
            this.session.myCharz().addEffectChar(1000, 1, 0, 1, 1, 2590000, 1, true, true, item);
            this.addInfo1(String.format(mResources.DONE_VIP, 1));
        }
    }
    
    public void giftSeason2(int num) {
        if (this.getEmptyBagCount() < 15) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 15));
        } else if (500 > this.myObj().pointEventVIP) {
            
        } else if (this.canProceed()) {
            this.myObj().pointEventVIP -= 500;
            //10 ti vang
            this.updateXu(10000000000L, 1);
            //de tu
            if (num == 0) {
                Player.mabuInfo(this);
//                Player.petInfo(this, this.cgender);
           }
            //qua tai day
            Item item1 = new Item(1229, false, 2000, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            //lech teamobi 1987
            Item item2 = new Item(1987, false, 199, ItemOption.getOption(1987, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item3 = new Item(970, false, 5, ItemOption.getOption(970, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item4 = new Item(956, false, 5, ItemOption.getOption(956, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item5 = new Item(1143, false, 30, ItemOption.getOption(1143, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item6 = new Item(904, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item6.options.add(new ItemOption(50, 32));
            item6.options.add(new ItemOption(77, 32));
            item6.options.add(new ItemOption(103, 32));
            item6.options.add(new ItemOption(5, 20));
            item6.options.add(new ItemOption(93, 60));
            Item item7 = new Item(909, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item7.options.add(new ItemOption(50, 7));
            item7.options.add(new ItemOption(77, 7));
            item7.options.add(new ItemOption(103, 7));   
            item7.options.add(new ItemOption(93, 30));
            item7.options.add(new ItemOption(30,1 )); 
            Item item8 = new Item(1223, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item8.options.add(new ItemOption(50, 10));
            item8.options.add(new ItemOption(77, 10));
            item8.options.add(new ItemOption(103,10));
            item8.options.add(new ItemOption(93, 15));
            item8.options.add(new ItemOption(30,1)); 
            Item item9 = new Item(1131, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item9.options.add(new ItemOption(148, 25));
            item9.options.add(new ItemOption(84, 1));
            item9.options.add(new ItemOption(175, 20));
            item9.options.add(new ItemOption(93, 30));
            Item item10 = new Item(1204, false, 1, ItemOption.getOption(1204, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            //add bag
            this.addItemBag(0, item1);
            this.addItemBag(0, item2);
            this.addItemBag(0, item3);
            this.addItemBag(0, item4);
            this.addItemBag(0, item5);
            this.addItemBag(0, item6);
            this.addItemBag(0, item7);
            this.addItemBag(0, item8);
            this.addItemBag(0, item9);
            this.addItemBag(0, item10);
            //eff
            this.session.myCharz().removeEffChar(0, 1001);
            Item item = new Item(395, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item.options.add(new ItemOption(77, 2));
            item.options.add(new ItemOption(103, 2));
            item.options.add(new ItemOption(50, 2));
            this.session.myCharz().addEffectChar(1001, 1, 0, 1, 1, 2590000, 1, true, true, item);
            this.addInfo1(String.format(mResources.DONE_VIP, 2));
        }
    }
    
    public void giftSeason3(int num) {
        if (this.getEmptyBagCount() < 15) {
            this.addInfo1(String.format(mResources.BAG_FULL_2, 15));
        } else if (200 > this.myObj().pointEventVIP) {
            
        } else if (this.canProceed()) {
            this.myObj().pointEventVIP -= 200;
            //5 ti vang
            this.updateXu(5000000000L, 1);
            //de tu
            if (num == 0) {
                Player.mabuInfo(this);
//                Player.petInfo(this, this.cgender);
            }
            //qua tai day
            Item item1 = new Item(1229, false, 999, ItemOption.getOption(1229, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            //lech teamobi 1987
            Item item2 = new Item(1987, false, 99, ItemOption.getOption(1987, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item3 = new Item(970, false, 1, ItemOption.getOption(970, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item4 = new Item(956, false, 3, ItemOption.getOption(956, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item5 = new Item(1143, false, 10, ItemOption.getOption(1143, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            Item item6 = new Item(904, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item6.options.add(new ItemOption(50, 32));
            item6.options.add(new ItemOption(77, 32));
            item6.options.add(new ItemOption(103, 32));
            item6.options.add(new ItemOption(5, 20));
            item6.options.add(new ItemOption(93, 15));
            Item item7 = new Item(909, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item7.options.add(new ItemOption(50, 7));
            item7.options.add(new ItemOption(77, 7));
            item7.options.add(new ItemOption(103, 7));   
            item7.options.add(new ItemOption(30,1)); 
            item7.options.add(new ItemOption(93, 15));
            Item item8 = new Item(1223, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item8.options.add(new ItemOption(50, 10));
            item8.options.add(new ItemOption(77, 10));
            item8.options.add(new ItemOption(103,10)); 
            item8.options.add(new ItemOption(30,1)); 
            item8.options.add(new ItemOption(93, 15));
            Item item9 = new Item(1131, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item9.options.add(new ItemOption(148, 25));
            item9.options.add(new ItemOption(84, 1));
            item9.options.add(new ItemOption(175, 20));
            item9.options.add(new ItemOption(30,1)); 
            item9.options.add(new ItemOption(93, 15));
            //add bag
            this.addItemBag(0, item1);
            this.addItemBag(0, item2);
            this.addItemBag(0, item3);
            this.addItemBag(0, item4);
            this.addItemBag(0, item5);
            this.addItemBag(0, item6);
            this.addItemBag(0, item7);
            this.addItemBag(0, item8);
            this.addItemBag(0, item9);
            //eff
            this.session.myCharz().removeEffChar(0, 1002);
            Item item = new Item(395, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item.options.add(new ItemOption(77, 1));
            item.options.add(new ItemOption(103, 1));
            item.options.add(new ItemOption(50, 1));
            this.session.myCharz().addEffectChar(1002, 1, 0, 1, 1, 2592000, 1, true, true, item);
            this.addInfo1(String.format(mResources.DONE_VIP, 3));
            
        }
    }
    
    public void new_skill_not_focus(Skill skill, short x0, short y0, byte dir, short x, short y) {
    	//System.out.printf("Tọa độ meX=%d meY=%d, x0=%d y0=%d x=%d y=%d dir=%d\n", this.cx, this.cy, x0, y0, x, y, dir);
    	if (dir == 1 || dir == -1) {
            this.addMove(0, x0, y0, 1);
            this.cdir = dir;
    	}
        if (skill != null && skill.lastTimeUseThisSkill <= System.currentTimeMillis()) {
            int manaUse;
            this.isThaCau = 0;
            manaUse = skill.manaUse;
            if (skill.template.manaUseType == 1) {
                manaUse = (int)((long)this.cMPFull * (long)manaUse / 100);
            }
            if (this.cMP >= manaUse) {
            	skill.lastTimeUseThisSkill = System.currentTimeMillis() + skill.coolDown;
                this.upMP(-manaUse);
	            if (this.cHP <= 1 && this.isNotDieMob) {
	                return;
	            }
	            if (this.cHP <= 1 && this.isSetOcTieu) {
	                return;
	            }
                //Super Kamejoko
                if (skill.template.id == 24) {
                    Point point = new Point();
                    point.x = this.cx + (this.cdir * skill.dx);
                    point.y = skill.dy;
                    this.setNewSkill(skill, this.levelBook + 1, point, 2000, 3000, -1);
                    skill.curExp += 1;
                    this.curExpSkill();
                    //Do ben
                    if (this.levelBook != 0) {
                        ItemOption option = this.arrItemBody[7].getOption(212);
                        option.param--;
                        if (option.param < 0) {
                            option.param = 0;
                        }
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.updateBody(1, charID, head, body, leg, isMonkey);
                    }
                }
                //Cadic lien hoan chuong
                if (skill.template.id == 25) {
                    Point point = new Point();
                    if (x != -1 && y != -1 && x > 0 && y > 0) {
                        point.x = x;
                        point.y = y;
                        this.cdir = (byte) (x > this.cx ? 1 : -1);
                    } else {
                        point.x = this.cx + (this.cdir * (skill.dx + 120));
                        Char player = this.zoneMap.getPlayerClosest(this);
                        if (player != null && point.x > player.cx) {
                            point.x = player.cx;
                        }
                        Mob mob = this.zoneMap.getMobClosest(this);
                        if (mob != null && point.x > mob.pointx) {
                            point.x = mob.pointx;
                        }
                        point.y = this.cy;
                    }
                    this.setNewSkill(skill, this.levelBook + 1, point, 2000, 3000, -1);
                    skill.curExp += 1;
                    this.curExpSkill();
                    //Do ben
                    if (this.levelBook != 0) {
                        ItemOption option = this.arrItemBody[7].getOption(212);
                        option.param--;
                        if (option.param < 0) {
                            option.param = 0;
                        }
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.updateBody(1, charID, head, body, leg, isMonkey);
                    }
                }
                //Ma phong ba
                if (skill.template.id == 26) {
                    Point point = new Point();
                    point.x = this.cx + (this.cdir * 50);
                    point.y = cy;
                    this.setNewSkill(skill, this.levelBook + 1, point, 2000, 3000, this.isMaPhongBa2);
                    skill.curExp += 1;
                    this.curExpSkill();
                    //Do ben
                    if (this.levelBook != 0) {
                        ItemOption option = this.arrItemBody[7].getOption(212);
                        option.param--;
                        if (option.param < 0) {
                            option.param = 0;
                        }
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.updateBody(1, charID, head, body, leg, isMonkey);
                    }
                }
                //Nhiem vu thanh tich dung ki nang thu 9
                if (this.session != null) {
                    this.updateArchivement(17, 1L);
                }
            } else {
                this.addInfo1(mResources.KHONG_DU_KI_DE_DUNG);
            }
        }
    }
    
    private void updateItemGLT() {
        if (this.timeAttackting >= 60000) {
            this.timeAttackting = 0;
            for (Item item : this.arrItemBody) {
                if (item != null && item.template.type == 32 && item.isHaveOption(9)) {
                    ItemOption option = item.getOption(9);
                    if (option.param < 10000) {
                        option.param++;
                        this.session.service.Body(this.head, this.arrItemBody);
                        this.session.service.Bag(this.arrItemBag);
                        this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
                    }
                }
            }
        }
        if (this.minuteOnline != this.minuteOld && this.itemGLT != null && this.itemGLT.template.type == 32 && this.itemGLT.isHaveOption(9)) {
            ItemOption option = this.itemGLT.getOption(9);
            if (option.param > 0) {
                option.param--;
                this.session.service.Body(this.head, this.arrItemBody);
                this.session.service.Bag(this.arrItemBag);
                this.session.service.updateBody(1, this.charID, this.head, this.body, this.leg, this.isMonkey);
            }
        }
    }
    
    public boolean isCheckSetTb() {
        
        return this.isSetXiHang ||
        this.isSetKirin ||
        this.isSetSongoku ||
        this.isSetPicolo ||
        this.isSetOcTieu ||
        this.isSetPikkoroDaimao ||
        this.isSetKakarot ||
        this.isSetCaDic ||
        this.isSetNappa;  ///
    }
    
    public Char.ChatGameBot nextChatGameBot(int id) {
        ArrayList<Char.ChatGameBot> myList = getChatGameBots(id);
        if (myList != null) return myList.get(Util.gI().nextInt(myList.size()));
        return null;
    }
    
    public ArrayList<Char.ChatGameBot> getChatGameBots(int id) {
        if (this.chatGameBot == null) return null;
        ArrayList<Char.ChatGameBot> myList = new ArrayList<>();
        for (int i = 0; i < this.chatGameBot.size(); i++) {
            if (this.chatGameBot.get(i).id == id) {
                myList.add(this.chatGameBot.get(i));
            }
        }
        return myList.isEmpty() ? null : myList;
    }
    
    public boolean isHaveChatGameBot(int id) {
        if (this.chatGameBot == null) return false;
        for (int i = 0; i < this.chatGameBot.size(); i++) {
            if (this.chatGameBot.get(i).id == id) {
                return true;
            }
        }
        return false;
    }
    
    private void updateChatGameBot() {
        if (this.zoneMap != null && this.gameTick % 30 == 0 && this.isHaveChatGameBot(0)) {
            Char player = this.zoneMap.getPlayerClosest(this);
            if (player != null && Math.abs(player.cx - this.cx) < 50 && Math.abs(player.cy - this.cy) <= 50) {
                String chat = this.nextChatGameBot(0).chat;
                if (chat.contains("$1")) {
                    this.addAtt(player.charID);
                }
                this.addChat(1, this.nextChatGameBot(0).chat.replace("$1", player.cName));
            }
        }
        this.timeBotChat2 -= this.delay;
        if (this.timeBotChat2 <= 0) {
            this.timeBotChat2 = 10000;
            if (!this.isDie && this.isHaveChatGameBot(2) && (this.cTypePk == 5 || this.cFlag != 0)) {
                this.addChat(this.nextChatGameBot(2).chat);
            }
        }
        if (this.zoneMap != null && !this.isCharge && !this.isCommand(1) && !this.isDie && this.isHaveChatGameBot(4) && this.cTypePk == 5) {
            String myArray[] = this.nextChatGameBot(4).chat.split("\\|");
            String chat = myArray[0];
            Char player = this.zoneMap.getPlayerClosest(this);
            if (!chat.isEmpty() && player != null) {
                this.addChat(chat);
            }
            this.addCommand(1, new Object[]{chat, (short)Short.parseShort(myArray[1]), (int)Integer.parseInt(myArray[2]), (int)Integer.parseInt(myArray[3]), 0, (int)Integer.parseInt(myArray[4]), player});
        }
        if (this.zoneMap != null && !this.isCharge && !this.isCommand(2) && !this.isDie && this.isHaveChatGameBot(5) && this.cTypePk == 5) {
            String myArray[] = this.nextChatGameBot(5).chat.split("\\|");
            String chat = myArray[0];
            if (!chat.isEmpty()) {
                this.addChat(chat);
            }
            this.addCommand(2, new Object[]{chat, (short)Short.parseShort(myArray[1]), (int)Integer.parseInt(myArray[2]), (int)Integer.parseInt(myArray[3]), 0, (int)Integer.parseInt(myArray[4]), (short)Short.parseShort(myArray[5])});
        }
        //Goku vs Ca Dic
        if (this.zoneMap != null && !this.isCharge && !this.isArgue && !this.isDie && this.isHaveChatGameBot(6) && this.cTypePk == 5) {
            String myArray[] = this.nextChatGameBot(6).chat.split("\\|");
            int hpMin = Integer.parseInt(myArray[1]);
            if (100f / (float)this.cHPFull * (float)this.cHP <= hpMin) {
                String myChat = myArray[0];
                if (!myChat.isEmpty()) {
                    String myArray2[] = myChat.split(";");
                    for (int i = 0; i < myArray2.length; i++) {
                        this.addChat(Integer.parseInt(myArray2[i]), myArray2[++i]);
                    }
                }
                this.changeTypePk(0);
                this.timeClear = Integer.parseInt(myArray[2]);
                BWar.addBWar(Integer.parseInt(myArray[3]), null, Integer.parseInt(myArray[4]), this.zoneMap);
                this.isArgue = true;
            }
        }
    }
    
    public void addClanPoint(int pointAdd) {
        if (this.clan != null) {
            this.clan.clanPoint += pointAdd;
            if (pointAdd > 0) {
                this.clanMember.clanPoint += pointAdd;
                this.clanMember.curClanPoint = this.clanPoint += pointAdd;
                this.addInfo1(String.format(mResources.RECEIVE_GIFT2, pointAdd));
            }
            this.clan.clanInfo();
        }
    }
    
    public void removeAllByAction(int action) {
        if (this.myCommands != null) {
            for (int i = 0; i < this.myCommands.size(); i++) {
                if (this.myCommands.get(i).action == action) {
                    this.myCommands.remove(i);
                }
            }
        }
    }
    
    public void addCommand(int action, Object p) {
        if (this.myCommands == null) this.myCommands = new ArrayList<>();
        this.myCommands.add(new Char.Command(action, p));
    }
    
    public boolean isCommand(int action) {
        if (this.myCommands == null) return false;
        for (int i = 0; i < this.myCommands.size(); i++) {
            if (this.myCommands.get(i).action == action) return true;
        }
        return false;
    }
    
    private void updateCommand() {
        Char.Command myArray[] = new Char.Command[this.myCommands.size()];
        for (int i = 0; i < this.myCommands.size(); i++) myArray[i] = this.myCommands.get(i);
        for (int i = 0; i < myArray.length; i++) {
            switch(myArray[i].action) {
                //Toi noi nao do
                case 0:
                {
                    Object array[] = (Object[]) myArray[i].p;
                    array[0] = (int)array[0] - this.delay;
                    if ((int)array[0] <= 0) {
                        this.myCommands.remove(myArray[i]);
                        ZoneMap z = (ZoneMap) array[1];
                        if (z == null) {
                            this.goHome();
                        } else {
                            this.zoneMap.exit(this, 0);
                            z.join(this, (int)array[3], (int)array[4], (int)array[5]);
                        }
                    } else if (((int)array[0] / 1000) % 5 == 0) {
                        String src = (String) array[2];
                        if (!src.isEmpty()) {
                            this.addInfo1(src.replace("$1", Util.gI().getStrTime((int)array[0])));
                        }
                    }
                    break;
                }
                //Danh chieu
                case 1:
                {
                    Object array[] = (Object[]) myArray[i].p;
                    int count = (int)array[2];
                    if (count > 0) {
                        int time = (int)array[4] - this.delay;
                        if (time > 0) {
                            array[4] = time;
                        } else {
                            array[4] = array[3];
                            array[2] = --count;
                            Char player = (Char) array[6];
                            if (player != null && this.isMeCanAttackOtherPlayer(player) && !this.isStand() && player.timeReady <= 0) {
                                Skill skill = Skill.arrSkill[(short)array[1]].clone();
                                this.aMobFocus.clear();
                                this.aCharFocus.clear();
                                this.aCharFocus.add(player);
                                if (skill.isChuong()) {
                                    if (!this.isMove && (Math.abs(this.cx - this.aCharFocus.get(0).cx) > 120 || Math.abs(this.cx - this.aCharFocus.get(0).cx) < 30 || Math.abs(this.cy - this.aCharFocus.get(0).cy) > 50)) {
                                        this.addMove(0, this.aCharFocus.get(0).cx + new int[]{120, -120}[Util.gI().nextInt(2)], this.aCharFocus.get(0).cy, 1);
                                    }
                                } else {
                                    if (!this.isMove && (Math.abs(this.aCharFocus.get(0).cx - this.cx) > 24 || Math.abs(this.aCharFocus.get(0).cy - this.cy) > 24)) {
                                        this.addMove(0, this.aCharFocus.get(0).cx + new int[]{24, -24}[Util.gI().nextInt(2)], this.aCharFocus.get(0).cy, 1);
                                    }
                                }
                                this.timeLoadSkill = 0;
                                this.timeHit = 0;
                                this.Attack(skill, this.aMobFocus, this.aCharFocus, 2);
                                this.timeLoadSkill = (int) array[3] + 500;
                                this.timeHit = (int) array[3] + 500;
                            } else {
                                this.myCommands.remove(myArray[i]);
                            }
                        }
                    } else {
                        int time = (int)array[5] - this.delay;
                        if (time > 0) {
                            array[5] = time;
                        } else {
                            this.myCommands.remove(myArray[i]);
                        }
                    }
                    break;
                }
                //Chieu phu tro
                case 2:
                {
                    Object array[] = (Object[]) myArray[i].p;
                    int count = (int)array[2];
                    if (count > 0) {
                        int time = (int)array[4] - this.delay;
                        if (time > 0) {
                            array[4] = time;
                        } else {
                            array[4] = array[3];
                            array[2] = --count;
                            if (!this.isStand()) {
                                Skill skill = Skill.arrSkill[(short)array[1]].clone();
                                skill.damage = (short) array[6];
                                if (skill.template.id == 6 && true) {
                                    this.skill_not_focus((byte)0, skill);
                                } else if (skill.template.id == 8) {
                                    if (skill.damage == 0) {
                                        this.gong((int)array[3]);
                                    } else {
                                        this.skill_not_focus((byte)1, skill);
                                    }
                                } else if (skill.template.id == 12) {
                                    this.skill_not_focus((byte)8, skill);
                                } else if (skill.template.id == 13) {
                                    this.skill_not_focus((byte)6, skill);
                                } else if (skill.template.id == 19) {
                                    this.skill_not_focus((byte)9, skill);
                                } else if (skill.template.id == 21) {
                                    this.skill_not_focus((byte)10, skill);
                                }
                            } else {
                                this.myCommands.remove(myArray[i]);
                            }
                        }
                    } else {
                        int time = (int)array[5] - this.delay;
                        if (time > 0) {
                            array[5] = time;
                        } else {
                            this.myCommands.remove(myArray[i]);
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public void chatWorld(String chat, int money) {
        if (this.xu < money) {
            this.addInfo1(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(money - this.session.myCharz().xu)));
        } else {
            this.updateXu(-money, 1);
            Server.gI().chatTheGioi(this, chat);
        }
    }
    
    public void openGacha() {
        this.resetMenu();
        this.menuBoard.chat = String.format(mResources.SAY_GACHA1, this.pointVip);
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.MENU_GACHA6, 400));
        if (!this.arrItemMore.isEmpty()) {
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.RUONG_PHU, this.arrItemMore.size()), 115));
            this.menuBoard.arrMenu.add(new MenuInfo(mResources.RUONG_PHU2, 402));
        }
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.CHANGE_POINT2, 403));
        this.menuBoard.arrMenu.add(new MenuInfo(mResources.CLOSE, 0));
        this.menuBoard.openUIConfirm(this.menuBoard.npcId, null, null, -1);
    }
    
    public void createGacha() {
        Item item;
        random:
        {
            if (Util.gI().nextInt(100) < 10) {
                int id = Util.gI().nextInt(220, 224);
                item = new Item(id, false, Util.gI().nextInt(20, 50), ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                break random;
            }
            if (Util.gI().nextInt(100) < 10) {
                item = new Item(1229, false, 10, ItemOption.getOption(1299, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                break random;
            }            
            if (Util.gI().nextInt(100) < 5) {
                item = new Item(861, false, Util.gI().nextInt(50, 100), null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                break random;
            }
             if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(100) < 1) {
                    item = new Item(904, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(50, 30));
                    item.options.add(new ItemOption(77, 30));
                    item.options.add(new ItemOption(103, 30));
                    item.options.add(new ItemOption(94, 10));
                } else {
                    item = new Item(904, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                    item.options.add(new ItemOption(50, 30));
                    item.options.add(new ItemOption(77, 30));
                    item.options.add(new ItemOption(103, 30));
                    item.options.add(new ItemOption(94, 10));
                }
                break random;
            }
            if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(100) < 1) {
                    item = new Item(883, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(50, 30));
                    item.options.add(new ItemOption(77, 30));
                    item.options.add(new ItemOption(103, 30));
                    item.options.add(new ItemOption(14, 10));
                } else {
                    item = new Item(883, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                    item.options.add(new ItemOption(50, 30));
                    item.options.add(new ItemOption(77, 30));
                    item.options.add(new ItemOption(103, 30));
                    item.options.add(new ItemOption(14, 10));
                }
                break random;
            }
            if (Util.gI().nextInt(100) < 5) {
                if (Util.gI().nextInt(100) < 1) {
                    int id2 = new int[]{1013, 1021, 1022, 1023, 1047, 1100, 1108, 1109, 1110, 1111, 1112, 1140}[Util.gI().nextInt(12)];
                    item = new Item(id2, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                    item.options.add(new ItemOption(77, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                    item.options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                    item.options.add(new ItemOption(14, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                    item.options.add(new ItemOption(160, 20));
                } else {
                    int id = new int[]{1013, 1021, 1022, 1023, 1047, 1100, 1108, 1109, 1110, 1111, 1112, 1140}[Util.gI().nextInt(12)];
                    item = new Item(id, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                    item.options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                    item.options.add(new ItemOption(77, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                    item.options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                    item.options.add(new ItemOption(14, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                    item.options.add(new ItemOption(160, 20));
                }
                break random;
            }
            if (Util.gI().nextInt(100) < 3) {
                if (Util.gI().nextInt(100) < 1) {               
                    item = new Item(1252, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(50, Util.gI().nextInt(1, Util.gI().nextInt(3, 5))));
                    item.options.add(new ItemOption(77, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                    item.options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                } else {
                    item = new Item(1252, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                    item.options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                    item.options.add(new ItemOption(50, Util.gI().nextInt(1, Util.gI().nextInt(3, 5))));
                    item.options.add(new ItemOption(77, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                    item.options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                }
                break random;
            }
            if (Util.gI().nextInt(500) < 1) {
                item = new Item(1204, false, 1, ItemOption.getOption(1204, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                break random;
            }   
            if (Util.gI().nextInt(100) < 3) {
                int id = Util.gI().nextInt(1150, 1154);
                item = new Item(id, false, 1, ItemOption.getOption(id, 0, 0), mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
                break random;
            }
            
            item = new Item(190, false, 1, null, mResources.EMPTY, mResources.EMPTY, mResources.EMPTY);
            item.options.add(new ItemOption(171, Util.gI().nextInt(100) * 100));
        }
        CaiTrang.gI().setPartTemp(item);
        if (item.isHaveOption(93)) {
            item.setExpires(System.currentTimeMillis() + (long) (1000l * 60l * 60l * 24l * (long)(item.getParamOption(93) + 1)));
        }
        if (item.template.type != 9) {
            this.addItemMore(1, item);
        } else {
            this.addItemBag(0, item);
        }
        this.pointVip += 1;
    }
    
    public void openShop(int shopId) {
        this.session.myCharz().shopId = shopId;
        Shop shop = Shop.shops.get(shopId);
        //Loc va tao moi item
        ArrayList<Item> arrItemShops[] = new ArrayList[shop.shopTabName.length];
        for (int i = 0; i < arrItemShops.length; i++) {
            arrItemShops[i] = new ArrayList<>();
            for (int j = 0; j < shop.arrItemShop[i].size(); j++) {
                Item item = shop.arrItemShop[i].get(j).clone();
                //Xoa chien thuyen tenis
                if (item.template.id == 453 && this.session.myCharz().typeTeleport == 3) {
                    continue;
                }
                //Xoa bong tai
                if (item.template.id == 454 && (this.session.myCharz().isHaveItem(454) || this.session.myCharz().isHaveItem(921))) {
                    continue;
                }
                arrItemShops[i].add(item);
            }
        }
        if (shopId == 30) {
            for (int i = arrItemShops[0].size() - 1; i >= 0; i--) {
                EffChar eff = this.getEffCharById(arrItemShops[0].get(i).template.part);
                if (eff != null) {
                    Item item = eff.item;
                    if (eff.second != -1) {
                        item.removeOption(93);
                        
                        item.options.add(0, new ItemOption(93, (int) ((((eff.last / 1000) + eff.second) - (System.currentTimeMillis() / 1000)) / 86400)+ 1));
                    }
                    arrItemShops[1].add(item);
                    arrItemShops[0].remove(i);
                }
            }
        }
        this.session.service.openShop(shop.type, shop.shopTabName, arrItemShops);
    }
    
    public int getTaskPointDH(int id) {
        int point = 0;
        if (Memory.get(this.session.userId).hTaskDH.containsKey((short)id)) {
            point = Memory.get(this.session.userId).hTaskDH.get((short)id);
        }
        return point;
    }
    
    public void addTaskPointDH(int id, int point) {
        int pointSet = point + this.getTaskPointDH(id);
        Memory.get(this.session.userId).hTaskDH.put((short)id, pointSet);
        if (pointSet >= TaskDanhHieu.hTask.get((short)id).maxCount && this.getEffCharById(ItemTemplate.get((short)id).part) == null) {
            Item item = Shop.getItem(30, id);
            if (item != null) {
                item = item.clone();
                this.addEffectChar(item.template.part, 1, 0, 1, 1, item.isHaveOption(93) ? 86400 * item.getParamOption(93) : -1, 2, false, true, item);
            }
        }
    }
    
    public boolean canProceed() {
        if (this.isgiaodich) {
            this.addInfo1(mResources.O_THE_THUC_HIEN);
            return false;
        }
        if (this.isSecurity) {
            this.addInfo1(mResources.BAOVE);
            return false;
        }
        return true;
    }
    
    public void get_player_vs_player(int type, int type2, int playerId, int xu, String str) {
        this.type_player_vs_player = type;
        this.xu_player_vs_player = xu;
        this.session.service.player_vs_player(type2, playerId, xu, str);
    }
    
    public void moiThachDau(Char player) {
        
        if (this.isRPS) {
            this.addInfo1(mResources.PLEASE_WAIT);
        } else if (this.cTypePk == 5) {
            this.addInfo1(mResources.NOT_CHANGE_TYPEPK);
        } else if (this.miliSecondChallenge > 0) {
            this.session.service.chatTHEGIOI(mResources.EMPTY, mResources.PLEASE_WAIT, null, (byte)0);
        } else if (player.zoneMap.map.isMapCace23_2()) {
            this.addInfo1(mResources.NOT_THACH_DAU);
        } else if (player.zoneMap.mapTemplate.mapTemplateId == 51 || this.mapTemplateId == 113) {
            this.addInfo1(mResources.NOT_THACH_DAU2);
        } else if (!player.isChallenge) {
            this.miliSecondChallenge = 30000;
            this.challengeCharId = player.charID;
            //
            this.resetMenu();
            this.menuBoard.chat = String.format(mResources.CHALLENGE_SELECT_XU, player.cName, Util.gI().numberTostring(player.cPower));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.XU_FORMAT, 1000), 300, 1000));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.XU_FORMAT, 10000), 300, 10000));
            this.menuBoard.arrMenu.add(new MenuInfo(String.format(mResources.XU_FORMAT, 100000), 300, 100000));
            this.menuBoard.openUIConfirm(5, null, null, -1);
        } else {
            this.addInfo1(mResources.NOT_THACH_DAU3);
        }
    }
    
    public void action_player_vs_player(byte action, byte type, int playerId) {
        Char player = this.zoneMap.findCharInMap(playerId);
        if (player == null) {
            return;
        }
        //Gui thach dau
        if (action == 0) {
            this.moiThachDau(player);
            return;
        }
        switch (this.type_player_vs_player) {
            case 0:
            {
                //Chap nhan thach dau
                if (this.canProceed()) {
                    if (this.isRPS) {
                        this.addInfo1(mResources.PLEASE_WAIT);
                    } else if (this.xu < this.xu_player_vs_player) {
                        this.addInfo1(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(this.xu_player_vs_player - this.xu)));
                    } else if (!this.isChallenge && !player.isChallenge && player.challengeCharId == this.charID) {
                        this.setChallenge(playerId, this.xu_player_vs_player);
                    }
                }
                break;
            }
            case 1:
            {
                //Chap nhan choi oan tu ti
                if (this.canProceed()) {
                    if (this.xu < player.xu_player_vs_player) {
                        this.addInfo1(String.format(mResources.CONTHIEU_VANG, Util.gI().numberTostring(this.xu_player_vs_player - this.xu)));
                        player.addInfo1(String.format(mResources.OAN_TU_TI4, this.cName));
                    } else if (!this.isRPS && !player.isRPS && player.rPSCharId == this.charID) {
                        this.isRPS = true;
                        this.rPSCharId = player.charID;
                        this.statusRPS = -1;
                        this.xuRPS = this.xu_player_vs_player;
                        player.isRPS = true;
                        player.rPSCharId = this.charID;
                        player.statusRPS = -1;
                        player.xuRPS = this.xu_player_vs_player;
                        //Bang choi oan tu ti
                        this.resetMenu();
                        this.menuBoard.chat = String.format(mResources.SAY_KEO_BUA_BAO2, Util.gI().getFormatNumber(this.xuRPS));
                        this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO31, 410, 0));
                        this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO32, 410, 1));
                        this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO33, 410, 2));
                        this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO35, 409));
                        this.menuBoard.openUIConfirm(5, null, null, -1);
                        //Player
                        
                        player.resetMenu();
                        player.menuBoard.chat = String.format(mResources.SAY_KEO_BUA_BAO2, Util.gI().getFormatNumber(player.xuRPS));
                        player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO31, 410, 0));
                        player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO32, 410, 1));
                        player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO33, 410, 2));
                        player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO35, 409));
                        player.menuBoard.openUIConfirm(5, null, null, -1);
                        
                        this.setText(11, mResources.TIME, 15, 0, 0);
                        player.setText(11, mResources.TIME, 15, 0, 0);
                    }
                }
                break;
            }
        }
    }
    
    public void closeRPS(int status) {
        if (this.isRPS) {
            Char player = this.zoneMap.findCharInMap(this.rPSCharId);
            if (player != null && player.rPSCharId == this.charID) {
                if (status == 0) {
                    player.addInfo1(String.format(mResources.KET_THUC_OAN_TU_TI0, this.cName));
                }
                if (status == 1) {
                    player.addInfo1(String.format(mResources.KET_THUC_OAN_TU_TI1, this.cName));
                }
                if (status == 2) {
                    player.addInfo1(String.format(mResources.KET_THUC_OAN_TU_TI2, this.cName));
                }
                if (status == 3) {
                    player.addInfo1(String.format(mResources.KET_THUC_OAN_TU_TI3, this.cName));
                }
                player.statusRPS = -1;
                player.isRPS = false;
                player.rPSCharId = -9999;
                player.xuRPS = 0;
                player.winRPS = 0;
            }
        }
        this.statusRPS = -1;
        this.isRPS = false;
        this.rPSCharId = -9999;
        this.xuRPS = 0;
        this.winRPS = 0;
        this.ntRPS = 0;
    }
    
    public Char[] checkWinRPS(Char player) {
        if (this.statusRPS == player.statusRPS) {
            return null;
        } else if ((this.statusRPS == 0 && player.statusRPS == 2) || (this.statusRPS == 1 && player.statusRPS == 0) || (this.statusRPS == 2 && player.statusRPS == 1)) {
            return new Char[]{this, player};
        } else {
            return new Char[]{player, this};
        }
    }
    
    public void actionRPS(int status) {
        if (this.canProceed() && this.isRPS && this.statusRPS == -1 && this.zoneMap != null) {
            Char player = this.zoneMap.findCharInMap(this.rPSCharId);
            if (player == null || !player.isRPS || player.rPSCharId != this.charID) {
                this.closeRPS(1);
            } else if (!player.canProceed()) {
                
            } else if (this.xuRPS > this.xu) {
                this.closeRPS(2);
            } else if (player.xuRPS > player.xu) {
                player.closeRPS(2);
            } else {
                this.statusRPS = status;
                //Kiem tra xem da cả 2 ben chon chua
                if (player.statusRPS != -1) {
                    Char array[] = this.checkWinRPS(player);
                    String str, array2[] = new String[]{mResources.KEO_BUA_BAO31, mResources.KEO_BUA_BAO32, mResources.KEO_BUA_BAO33};
                    //Hoa
                    if (array == null) {
                        str = String.format(mResources.SAY_KEO_BUA_BAO23, array2[this.statusRPS]);
                    } else {
                    //Khong hoa
                        int xuThang = (int) (array[1].xuRPS > array[1].xu ? array[1].xu : array[1].xuRPS);
                        array[0].updateXu((int)(xuThang * 0.9), 1);
                        array[0].winRPS++;
                        array[1].updateXu(-xuThang, 1);
                        str = String.format(mResources.SAY_KEO_BUA_BAO22, array[0].cName, array2[array[0].statusRPS], array[1].cName, array2[array[1].statusRPS], array[0].cName, Util.gI().getFormatNumber((int)(xuThang * 0.9F)));
                    }
                    //Bang choi oan tu ti
                    String chat = String.format(mResources.SAY_KEO_BUA_BAO21, Util.gI().getFormatNumber(this.xuRPS), str, this.cName, this.winRPS, player.cName, player.winRPS);
                    this.resetMenu();
                    this.menuBoard.chat = chat;
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO31, 410, 0));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO32, 410, 1));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO33, 410, 2));
                    this.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO35, 409));
                    this.menuBoard.openUIConfirm(5, null, null, -1);
                    //Player
                    player.resetMenu();
                    player.menuBoard.chat = chat;
                    player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO31, 410, 0));
                    player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO32, 410, 1));
                    player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO33, 410, 2));
                    player.menuBoard.arrMenu.add(new MenuInfo(mResources.KEO_BUA_BAO35, 409));
                    player.menuBoard.openUIConfirm(5, null, null, -1);

                    this.statusRPS = -1;
                    player.statusRPS = -1;
                    
                    if (this.ntRPS == 2 || player.ntRPS == 2) {
                        this.closeRPS(3);
                        player.closeRPS(3);
                    } else {
                        this.setText(11, mResources.TIME, 15, 0, 0);
                        player.setText(11, mResources.TIME, 15, 0, 0);
                    }
                }
            }
        }
    }
    
}
