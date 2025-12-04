package dragon.t;

/**
 *
 * @author Admin
 */
public class Skill {
    
    public final byte ATT_STAND = 0;
    public final byte ATT_FLY = 1;
    public final byte SKILL_AUTO_USE = 0;
    public final byte SKILL_CLICK_USE_ATTACK = 1;
    public final byte SKILL_CLICK_USE_BUFF = 2;
    public final byte SKILL_CLICK_NPC = 3;
    public final byte SKILL_CLICK_LIVE = 4;
    public SkillTemplate template;
    public short skillId;
    public int point;
    public long powRequire;
    public int coolDown;
    public long lastTimeUseThisSkill;
    public int dx;
    public int dy;
    public int maxFight;
    public int manaUse;
    public SkillOption[] options;
    public boolean paintCanNotUseSkill;
    public short damage;
    public String moreInfo;
    public short price;
    public short curExp;
    
    public static SkillTemplate[] arrSkillTemplate;
    public static Skill[] arrSkill;
    
    @Override
    public Skill clone() {
        Skill clone = new Skill();
        clone.template = this.template;
        clone.skillId = this.skillId;
        clone.point = this.point;
        clone.powRequire = this.powRequire;
        clone.coolDown = this.coolDown;
        clone.lastTimeUseThisSkill = this.lastTimeUseThisSkill;
        clone.dx = this.dx;
        clone.dy = this.dy;
        clone.maxFight = this.maxFight;
        clone.manaUse = this.manaUse;
        if (this.options != null) {
            clone.options = new SkillOption[this.options.length];
            for (int i = 0; i < this.options.length; i++) {
                SkillOption option = new SkillOption();
                option.optionString = String.valueOf(this.options[i].optionString);
                option.optionTemplate = this.options[i].optionTemplate;
                option.param = this.options[i].param;
                clone.options[i] = option;
            }
        }
        clone.paintCanNotUseSkill = this.paintCanNotUseSkill;
        clone.damage = this.damage;
        clone.moreInfo = String.valueOf(this.moreInfo);
        clone.price = this.price;
        clone.curExp = this.curExp;
        return clone;
    }
    
    protected static byte ClassBook(short id) {
        if ((id >= 66 && id <= 72) || (id >= 94 && id <= 100) || (id >= 115 && id <= 121) || (id >= 300 && id <= 306) || (id >= 307 && id <= 313) || (id >= 488 && id <= 494) || (id >= 495 && id <= 501)|| (id >= 434 && id <= 440)) {
            return 0;
        }
        if ((id >= 79 && id <= 86 && id != 85) || (id >= 101 && id <= 107) || (id >= 122 && id <= 128) || (id >= 328 && id <= 334) || (id >= 335 && id <= 341) || (id >= 474 && id <= 480) || (id >= 481 && id <= 487)|| (id >= 434 && id <= 440)) {
            return 1;
        }
        if ((id >= 87 && id <= 93) || (id >= 108 && id <= 114) || (id >= 129 && id <= 135) || (id >= 314 && id <= 320) || (id >= 321 && id <= 327) || (id >= 502 && id <= 508) || (id >= 509 && id <= 515)|| (id >= 434 && id <= 440)) {
            return 2;
        }
        return -1;
    }
    
    public static short skillIdByItem(short id, int nClass) {
        switch (id) {
            case 66:
                return 0;
            case 67:
                return 1;
            case 68:
                return 2;
            case 69:
                return 3;
            case 70:
                return 4;
            case 71:
                return 5;
            case 72:
                return 6;
            case 79:
                return 14;
            case 80:
                return 15;
            case 81:
                return 16;
            case 82:
                return 17;
            case 83:
                return 18;
            case 84:
                return 19;
            case 86:
                return 20;
            case 87:
                return 28;
            case 88:
                return 29;
            case 89:
                return 30;
            case 90:
                return 31;
            case 91:
                return 32;
            case 92:
                return 33;
            case 93:
                return 34;
            case 94:
                return 7;
            case 95:
                return 8;
            case 96:
                return 9;
            case 97:
                return 10;
            case 98:
                return 11;
            case 99:
                return 12;
            case 100:
                return 13;
            case 101:
                return 21;
            case 102:
                return 22;
            case 103:
                return 23;
            case 104:
                return 24;
            case 105:
                return 25;
            case 106:
                return 26;
            case 107:
                return 27;
            case 108:
                return 35;
            case 109:
                return 36;
            case 110:
                return 37;
            case 111:
                return 38;
            case 112:
                return 39;
            case 113:
                return 40;
            case 114:
                return 41;
            case 115:
                return 42;
            case 116:
                return 43;
            case 117:
                return 44;
            case 118:
                return 45;
            case 119:
                return 46;
            case 120:
                return 47;
            case 121:
                return 48;
            case 122:
                return 49;
            case 123:
                return 50;
            case 124:
                return 51;
            case 125:
                return 52;
            case 126:
                return 53;
            case 127:
                return 54;
            case 128:
                return 55;
            case 129:
                return 56;
            case 130:
                return 57;
            case 131:
                return 58;
            case 132:
                return 59;
            case 133:
                return 60;
            case 134:
                return 61;
            case 135:
                return 62;
            case 300:
                return 63;
            case 301:
                return 64;
            case 302:
                return 65;
            case 303:
                return 66;
            case 304:
                return 67;
            case 305:
                return 68;
            case 306:
                return 69;
            case 307:
                return 70;
            case 308:
                return 71;
            case 309:
                return 72;
            case 310:
                return 73;
            case 311:
                return 74;
            case 312:
                return 75;
            case 313:
                return 76;
            case 314:
                return 91;
            case 315:
                return 92;
            case 316:
                return 93;
            case 317:
                return 94;
            case 318:
                return 95;
            case 319:
                return 96;
            case 320:
                return 97;
            case 321:
                return 98;
            case 322:
                return 99;
            case 323:
                return 100;
            case 324:
                return 101;
            case 325:
                return 102;
            case 326:
                return 103;
            case 327:
                return 104;
            case 328:
                return 77;
            case 329:
                return 78;
            case 330:
                return 79;
            case 331:
                return 80;
            case 332:
                return 81;
            case 333:
                return 82;
            case 334:
                return 83;
            case 335:
                return 84;
            case 336:
                return 85;
            case 337:
                return 86;
            case 338:
                return 87;
            case 339:
                return 88;
            case 340:
                return 89;
            case 341:
                return 90;
            case 434:
                return 121;
            case 435:
                return 122;
            case 436:
                return 123;
            case 437:
                return 124;
            case 438:
                return 125;
            case 439:
                return 126;
            case 440:
                return 127;
            case 474:
                return 114;
            case 475:
                return 115;
            case 476:
                return 116;
            case 477:
                return 117;
            case 478:
                return 118;
            case 479:
                return 119;
            case 480:
                return 120;
            case 481:
                return 107;
            case 482:
                return 108;
            case 483:
                return 109;
            case 484:
                return 110;
            case 485:
                return 111;
            case 486:
                return 112;
            case 487:
                return 113;
            case 488:
                return 128;
            case 489:
                return 129;
            case 490:
                return 130;
            case 491:
                return 131;
            case 492:
                return 132;
            case 493:
                return 133;
            case 494:
                return 134;
            case 495:
                return 142;
            case 496:
                return 143;
            case 497:
                return 144;
            case 498:
                return 145;
            case 499:
                return 146;
            case 500:
                return 147;
            case 501:
                return 148;
            case 502:
                return 149;
            case 503:
                return 150;
            case 504:
                return 151;
            case 505:
                return 152;
            case 506:
                return 153;
            case 507:
                return 154;
            case 508:
                return 155;
            case 509:
                return 135;
            case 510:
                return 136;
            case 511:
                return 137;
            case 512:
                return 138;
            case 513:
                return 139;
            case 514:
                return 140;
            case 515:
                return 141;
        }
        return -1;
    }
    
//    public static Skill getSkill(short skillId) {
//        for (int i = 0; i < arrSkill.length; i++) {
//            if (arrSkill[i].skillId == skillId) {
//                return arrSkill[i];
//            }
//        }
//        return null;
//    }
    
    public boolean isSkillNotFocus() {
        return this.template.id == 6 || this.template.id == 10 || this.template.id == 19 || this.template.id == 8 || this.template.id == 13 || this.template.id == 14 || this.template.id == 21 || this.template.id == 11 || this.template.id == 12;
    }
    
    public boolean isChuong() {
        return this.template.id == 1 || this.template.id == 3 || this.template.id == 5;
    }
    
    public boolean isDonDanh() {
        return this.template.id == 0 || this.template.id == 2 || this.template.id == 4 || this.template.id == 9 || this.template.id == 17;
    }
}
