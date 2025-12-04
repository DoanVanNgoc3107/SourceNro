package dragon.t;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ItemOption {

    public ItemOption() {

    }

    public ItemOption(int optionTemplateId, int param) {
        this.param = param;
        this.optionTemplate = GameData.iOptionTemplates[optionTemplateId];
    }

    public long getParam() {
        switch (this.optionTemplate.id) {
            case 2:
                return (long) this.param * 1000l;
            case 21:
                return (long) this.param * 1000000000l;
            case 22:
                return (long) this.param * 1000l;
            case 23:
                return (long) this.param * 1000l;
            case 171:
                return (long) this.param * 1000l;
            default:
                return this.param;
        }
    }

    public void setParam(long param) {
        switch (this.optionTemplate.id) {
            case 2:
                this.param = (int) (param / 1000);
                break;
            case 21:
                this.param = (int) (param / 1000000000);
                break;
            case 22:
                this.param = (int) (param / 1000);
                break;
            case 23:
                this.param = (int) (param / 1000);
                break;
            case 171:
                this.param = (int) (param / 1000);
                break;
            default:
                this.param = (int) param;
                break;
        }
    }

    public int param;
    public byte active;
    public byte activeCard;
    public ItemOptionTemplate optionTemplate;

    public static ArrayList<ItemOption> getOption(int itemTemplateId, int status, int gender) {
        ArrayList<ItemOption> options = new ArrayList<>();
        switch (itemTemplateId) {
            case 0:
                options.add(new ItemOption(47, 2));
                // Random 3
                if (status == 1) {
                    //KICK HOAT XI HANG
                    if (Util.gI().nextInt(100) < 40) {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT KIRIN    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(128, 0));
                        options.add(new ItemOption(140, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT SONGOKU    
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(129, 0));
                        options.add(new ItemOption(141, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT XI HANG    
                    } else {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 1:
                options.add(new ItemOption(47, 2));
                // Random 3
                if (status == 1) {
                    //KICK HOAT OC TIEU
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Pikkoro Daimao    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(132, 0));
                        options.add(new ItemOption(144, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT PICO    
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(130, 0));
                        options.add(new ItemOption(142, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT OC TIEU    
                    } else {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 2:
                options.add(new ItemOption(47, 3));
                // Random 3
                if (status == 1) {
                    //KICK HOAT CADIC
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Kakarot     
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(133, 0));
                        options.add(new ItemOption(136, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT NAPPA    
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(135, 0));
                        options.add(new ItemOption(138, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT CADIC    
                    } else {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 6:
                options.add(new ItemOption(6, 30));
                // Random 3
                if (status == 1) {
                    //KICK HOAT XI HANG
                    if (Util.gI().nextInt(100) < 40) {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT KIRIN    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(128, 0));
                        options.add(new ItemOption(140, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT SONGOKU    
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(129, 0));
                        options.add(new ItemOption(141, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT XI HANG    
                    } else {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 7:
                options.add(new ItemOption(6, 20));
                // Random 3
                if (status == 1) {
                    //KICK HOAT OC TIEU
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Pikkoro Daimao    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(132, 0));
                        options.add(new ItemOption(144, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT PICO    
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(130, 0));
                        options.add(new ItemOption(142, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT OC TIEU    
                    } else {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 8:
                options.add(new ItemOption(6, 20));
                // Random 3
                if (status == 1) {
                    //KICK HOAT CADIC
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Kakarot    
                    } else if (Util.gI().nextInt(100) < 35) {
                        options.add(new ItemOption(133, 0));
                        options.add(new ItemOption(136, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT NAPPA    
                    } else if (Util.gI().nextInt(100) < 5) {
                        options.add(new ItemOption(135, 0));
                        options.add(new ItemOption(138, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT CADIC    
                    } else {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 12:
                options.add(new ItemOption(14, 1));
                if (gender == 0) {
                    // Random 3
                    if (status == 1) {
                        //KICK HOAT XI HANG
                        if (Util.gI().nextInt(100) < 40) {
                            options.add(new ItemOption(127, 0));
                            options.add(new ItemOption(139, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT KIRIN    
                        } else if (Util.gI().nextInt(100) < 20) {
                            options.add(new ItemOption(128, 0));
                            options.add(new ItemOption(140, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT SONGOKU    
                        } else if (Util.gI().nextInt(100) < 5) {
                            options.add(new ItemOption(129, 0));
                            options.add(new ItemOption(141, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT XI HANG    
                        } else {
                            options.add(new ItemOption(127, 0));
                            options.add(new ItemOption(139, 0));
                            options.add(new ItemOption(30, 0));
                        }
                    }
                } else if (gender == 1) {
                    // Random 3
                    if (status == 1) {
                        //KICK HOAT OC TIEU
                        if (Util.gI().nextInt(100) < 50) {
                            options.add(new ItemOption(131, 0));
                            options.add(new ItemOption(143, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT Pikkoro Daimao    
                        } else if (Util.gI().nextInt(100) < 30) {
                            options.add(new ItemOption(132, 0));
                            options.add(new ItemOption(144, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT PICO    
                        } else if (Util.gI().nextInt(100) < 10) {
                            options.add(new ItemOption(130, 0));
                            options.add(new ItemOption(142, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT OC TIEU    
                        } else {
                            options.add(new ItemOption(131, 0));
                            options.add(new ItemOption(143, 0));
                            options.add(new ItemOption(30, 0));
                        }
                    }
                } else if (gender == 2) {
                    // Random 3
                    if (status == 1) {
                        //KICK HOAT CADIC
                        if (Util.gI().nextInt(100) < 45) {
                            options.add(new ItemOption(134, 0));
                            options.add(new ItemOption(137, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT Kakarot     
                        } else if (Util.gI().nextInt(100) < 30) {
                            options.add(new ItemOption(133, 0));
                            options.add(new ItemOption(136, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT NAPPA    
                        } else if (Util.gI().nextInt(100) < 5) {
                            options.add(new ItemOption(135, 0));
                            options.add(new ItemOption(138, 0));
                            options.add(new ItemOption(30, 0));
                            //KICK HOAT CADIC    
                        } else {
                            options.add(new ItemOption(134, 0));
                            options.add(new ItemOption(137, 0));
                            options.add(new ItemOption(30, 0));
                        }
                    }
                }
                break;
            case 13:
                options.add(new ItemOption(48, 100));
                break;
            case 60:
                options.add(new ItemOption(48, 500));
                break;
            case 61:
                options.add(new ItemOption(48, 2000));
                break;
            case 62:
                options.add(new ItemOption(48, 4000));
                break;
            case 63:
                options.add(new ItemOption(48, 8000));
                break;
            case 64:
                options.add(new ItemOption(48, 16000));
                break;
            case 65:
                options.add(new ItemOption(48, 32000));
                break;
            case 314:
                options.add(new ItemOption(49, 109));
                options.add(new ItemOption(77, 40));
                break;
            case 315:
                options.add(new ItemOption(49, 110));
                options.add(new ItemOption(77, 50));
                break;
            case 316:
                options.add(new ItemOption(49, 110));
                options.add(new ItemOption(77, 60));
                break;
            case 317:
                options.add(new ItemOption(49, 112));
                options.add(new ItemOption(77, 70));
                break;
            case 318:
                options.add(new ItemOption(49, 113));
                options.add(new ItemOption(77, 80));
                break;
            case 319:
                options.add(new ItemOption(49, 114));
                options.add(new ItemOption(77, 90));
                break;
            case 320:
                options.add(new ItemOption(49, 115));
                options.add(new ItemOption(77, 100));
                break;
            case 342:
                options.add(new ItemOption(81, 5));
                break;
            case 343:
                options.add(new ItemOption(83, 0));
                break;
            case 344:
                options.add(new ItemOption(82, 0));
                break;
            case 345:
                options.add(new ItemOption(80, 5));
                break;
            case 352:
                options.add(new ItemOption(2, 64));
                break;
            case 363:
                break;
            case 364:
                options.add(new ItemOption(88, 5));
                break;
            case 365:
                options.add(new ItemOption(88, 5));
                break;
            case 366:
                options.add(new ItemOption(88, 5));
                break;
            case 367:
                options.add(new ItemOption(88, 5));
                break;
            case 368:
                options.add(new ItemOption(88, 5));
                break;
            case 369:
                options.add(new ItemOption(88, 5));
                break;
            case 370:
                options.add(new ItemOption(88, 5));
                break;
            case 371:
                options.add(new ItemOption(88, 10));
                break;
            case 380:
                options.add(new ItemOption(86, 0));
                break;
            case 441:
                options.add(new ItemOption(95, 5));
                break;
            case 442:
                options.add(new ItemOption(96, 5));
                break;
            case 443:
                options.add(new ItemOption(97, 5));
                break;
            case 444:
                options.add(new ItemOption(98, 3));
                break;
            case 445:
                options.add(new ItemOption(99, 3));
                break;
            case 446:
                options.add(new ItemOption(100, 5));
                break;
            case 447:
                options.add(new ItemOption(101, 5));
                break;
            case 465:
                options.add(new ItemOption(50, 10));
                options.add(new ItemOption(14, 10));
                options.add(new ItemOption(93, 30));
                break;
            case 466:
                options.add(new ItemOption(50, 15));
                options.add(new ItemOption(14, 15));
                options.add(new ItemOption(93, 30));
                break;
            case 467:
                options.add(new ItemOption(77, 20));
                if (status > 0) {
                    options.add(new ItemOption(93, 30));
                }
                break;
            case 468:
                options.add(new ItemOption(103, 20));
                if (status > 0) {
                    options.add(new ItemOption(93, 30));
                }
                break;
            case 469:
                options.add(new ItemOption(50, 10));
                if (status > 0) {
                    options.add(new ItemOption(93, 30));
                }
                break;
            case 470:
                options.add(new ItemOption(101, 10));
                if (status > 0) {
                    options.add(new ItemOption(93, 30));
                }
                break;
            case 471:
                options.add(new ItemOption(94, 10));
                if (status > 0) {
                    options.add(new ItemOption(93, 30));
                }
                break;
            case 472:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(14, 30));
                options.add(new ItemOption(93, 30));
                break;
            case 473:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(14, 25));
                options.add(new ItemOption(93, 30));
                break;
            case 519:
                options.add(new ItemOption(88, 5));
                break;
            case 520:
                options.add(new ItemOption(88, 5));
                break;
            case 523:
                options.add(new ItemOption(2, 128));
                break;
            case 590:
                options.add(new ItemOption(31, gender));
                options.add(new ItemOption(30, 0));
                break;
            case 595:
                options.add(new ItemOption(2, 256));
                break;
            case 691:
            case 692:
            case 693:
                options.add(new ItemOption(158, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 729:
                 if (status == 0) {
                    options.add(new ItemOption(50, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(77, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(103, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(5, Util.gI().nextInt(1, 3)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 1) {
                    options.add(new ItemOption(50, Util.gI().nextInt(5, 10)));
                    options.add(new ItemOption(77, Util.gI().nextInt(5, 11)));
                    options.add(new ItemOption(103, Util.gI().nextInt(5, 11)));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, 7)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 2) {
                    options.add(new ItemOption(50, Util.gI().nextInt(10, 15)));
                    options.add(new ItemOption(77, Util.gI().nextInt(10, 20)));
                    options.add(new ItemOption(103, Util.gI().nextInt(10, 20)));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, 10)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 3) {
                    options.add(new ItemOption(50, Util.gI().nextInt(17, 20)));
                    options.add(new ItemOption(77, Util.gI().nextInt(16, 25)));
                    options.add(new ItemOption(103, Util.gI().nextInt(16, 25)));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, 10)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 4) {
                    options.add(new ItemOption(50, Util.gI().nextInt(15, 25)));
                    options.add(new ItemOption(77, Util.gI().nextInt(15, 30)));
                    options.add(new ItemOption(103, Util.gI().nextInt(15, 30)));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 5) {
                    options.add(new ItemOption(50, Util.gI().nextInt(15, 30)));
                    options.add(new ItemOption(77, Util.gI().nextInt(15, 35)));
                    options.add(new ItemOption(103, Util.gI().nextInt(15, 35)));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 20))));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                options.add(new ItemOption(30, 0));
                break;
            case 738:
                if (status == 0) {
                    options.add(new ItemOption(50, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(77, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(103, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(94, Util.gI().nextInt(1, 3)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 1) {
                    options.add(new ItemOption(50, Util.gI().nextInt(5, 10)));
                    options.add(new ItemOption(77, Util.gI().nextInt(5, 11)));
                    options.add(new ItemOption(103, Util.gI().nextInt(5, 11)));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, 7)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 2) {
                    options.add(new ItemOption(50, Util.gI().nextInt(10, 15)));
                    options.add(new ItemOption(77, Util.gI().nextInt(10, 20)));
                    options.add(new ItemOption(103, Util.gI().nextInt(10, 20)));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, 10)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 3) {
                    options.add(new ItemOption(50, Util.gI().nextInt(17, 20)));
                    options.add(new ItemOption(77, Util.gI().nextInt(16, 25)));
                    options.add(new ItemOption(103, Util.gI().nextInt(16, 25)));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, 10)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 4) {
                    options.add(new ItemOption(50, Util.gI().nextInt(15, 25)));
                    options.add(new ItemOption(77, Util.gI().nextInt(15, 30)));
                    options.add(new ItemOption(103, Util.gI().nextInt(15, 30)));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 5) {
                    options.add(new ItemOption(50, Util.gI().nextInt(15, 28)));
                    options.add(new ItemOption(77, Util.gI().nextInt(15, 35)));
                    options.add(new ItemOption(103, Util.gI().nextInt(15, 35)));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(10, 20))));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                options.add(new ItemOption(30, 0));
                break;
            case 747:
                options.add(new ItemOption(88, 5));
                break;
            case 757:
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 828:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 829:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 830:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 831:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 832:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 833:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 834:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 835:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 836:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 837:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 838:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 839:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 840:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 841:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 842:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 859:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;

            case 933:
                options.add(new ItemOption(31, gender));
                options.add(new ItemOption(30, 0));
                break;
            case 934:
                options.add(new ItemOption(30, 0));
                break;
            case 956:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;

//SCN
            case 3:
                options.add(new ItemOption(47, 8));
                break;
            case 4:
                options.add(new ItemOption(47, 8));
                break;
            case 5:
                options.add(new ItemOption(47, 10));
                break;
            case 9:
                options.add(new ItemOption(6, 300));
                options.add(new ItemOption(27, 40));
                break;
            case 10:
                options.add(new ItemOption(6, 120));
                options.add(new ItemOption(27, 28));
                break;
            case 11:
                options.add(new ItemOption(6, 100));
                options.add(new ItemOption(27, 20));
                break;
            case 21:
                options.add(new ItemOption(0, 4));
                // Random 3
                if (status == 1) {
                    //KICK HOAT XI HANG  
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT KIRIN    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(128, 0));
                        options.add(new ItemOption(140, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT SONGOKU    
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(129, 0));
                        options.add(new ItemOption(141, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT XI HANG    
                    } else {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 22:
                options.add(new ItemOption(0, 4));
                // Random 3
                if (status == 1) {
                    //KICK HOAT OC TIEU
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Pikkoro Daimao    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(132, 0));
                        options.add(new ItemOption(144, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT PICO   
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(130, 0));
                        options.add(new ItemOption(142, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT OC TIEU    
                    } else {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 23:
                options.add(new ItemOption(0, 5));
                // Random 3
                if (status == 1) {
                    //KICK HOAT CADIC
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Kakarot    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(133, 0));
                        options.add(new ItemOption(136, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT NAPPA    
                    } else if (Util.gI().nextInt(100) < 5) {
                        options.add(new ItemOption(135, 0));
                        options.add(new ItemOption(138, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT CADIC    
                    } else {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 24:
                options.add(new ItemOption(0, 7));
                break;
            case 25:
                options.add(new ItemOption(0, 12));
                break;
            case 26:
                options.add(new ItemOption(0, 16));
                break;
            case 27:
                options.add(new ItemOption(7, 10));
                // Random 3
                if (status == 1) {
                    //KICK HOAT XI HANG
                    if (Util.gI().nextInt(100) < 40) {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT KIRIN    
                    } else if (Util.gI().nextInt(100) < 35) {
                        options.add(new ItemOption(128, 0));
                        options.add(new ItemOption(140, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT SONGOK    
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(129, 0));
                        options.add(new ItemOption(141, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT XI HANG    
                    } else {
                        options.add(new ItemOption(127, 0));
                        options.add(new ItemOption(139, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 28:
                options.add(new ItemOption(7, 15));
                // Random 3
                if (status == 1) {
                    //KICK HOAT OC TIEU
                    if (Util.gI().nextInt(100) < 45) {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Pikkoro Daimao    
                    } else if (Util.gI().nextInt(100) < 20) {
                        options.add(new ItemOption(132, 0));
                        options.add(new ItemOption(144, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT PICO    
                    } else if (Util.gI().nextInt(100) < 5) {
                        options.add(new ItemOption(130, 0));
                        options.add(new ItemOption(142, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT OC TIEU    
                    } else {
                        options.add(new ItemOption(131, 0));
                        options.add(new ItemOption(143, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 29:
                options.add(new ItemOption(7, 10));
                // Random 3
                if (status == 1) {
                    //KICK HOAT CADIC
                    if (Util.gI().nextInt(100) < 40) {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT Kakarot    
                    } else if (Util.gI().nextInt(100) < 30) {
                        options.add(new ItemOption(133, 0));
                        options.add(new ItemOption(136, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT NAPPA   
                    } else if (Util.gI().nextInt(100) < 10) {
                        options.add(new ItemOption(135, 0));
                        options.add(new ItemOption(138, 0));
                        options.add(new ItemOption(30, 0));
                        //KICK HOAT CADIC    
                    } else {
                        options.add(new ItemOption(134, 0));
                        options.add(new ItemOption(137, 0));
                        options.add(new ItemOption(30, 0));
                    }
                }
                break;
            case 30:
                options.add(new ItemOption(7, 25));
                options.add(new ItemOption(28, 5));
                break;
            case 31:
                options.add(new ItemOption(7, 150));
                options.add(new ItemOption(28, 30));
                break;
            case 32:
                options.add(new ItemOption(7, 100));
                options.add(new ItemOption(28, 20));
                break;
            case 33:
                options.add(new ItemOption(47, 4));
                break;
            case 34:
                options.add(new ItemOption(47, 16));
                break;
            case 35:
                options.add(new ItemOption(6, 150));
                options.add(new ItemOption(27, 12));
                break;
            case 36:
                options.add(new ItemOption(6, 600));
                options.add(new ItemOption(27, 120));
                break;
            case 37:
                options.add(new ItemOption(0, 14));
                break;
            case 38:
                options.add(new ItemOption(0, 28));
                break;
            case 39:
                options.add(new ItemOption(7, 120));
                options.add(new ItemOption(28, 24));
                break;
            case 40:
                options.add(new ItemOption(7, 250));
                options.add(new ItemOption(28, 50));
                break;
            case 41:
                options.add(new ItemOption(47, 4));
                break;
            case 42:
                options.add(new ItemOption(47, 16));
                break;
            case 43:
                options.add(new ItemOption(6, 25));
                options.add(new ItemOption(27, 10));
                break;
            case 44:
                options.add(new ItemOption(6, 250));
                options.add(new ItemOption(27, 100));
                break;
            case 45:
                options.add(new ItemOption(0, 24));
                break;
            case 46:
                options.add(new ItemOption(0, 6));
                break;
            case 47:
                options.add(new ItemOption(7, 30));
                options.add(new ItemOption(28, 6));
                break;
            case 48:
                options.add(new ItemOption(7, 300));
                options.add(new ItemOption(28, 60));
                break;
            case 49:
                options.add(new ItemOption(47, 5));
                break;
            case 50:
                options.add(new ItemOption(47, 20));
                break;
            case 51:
                options.add(new ItemOption(6, 20));
                options.add(new ItemOption(27, 8));
                break;
            case 52:
                options.add(new ItemOption(6, 200));
                options.add(new ItemOption(27, 80));
                break;
            case 53:
                options.add(new ItemOption(0, 32));
                break;
            case 54:
                options.add(new ItemOption(0, 32));
                break;
            case 55:
                options.add(new ItemOption(7, 20));
                options.add(new ItemOption(28, 4));
                break;
            case 56:
                options.add(new ItemOption(7, 200));
                options.add(new ItemOption(28, 40));
                break;
            case 57:
                options.add(new ItemOption(14, 2));
                break;
            case 58:
                options.add(new ItemOption(14, 3));
                break;
            case 59:
                options.add(new ItemOption(14, 4));
                break;
            case 68:
                options.add(new ItemOption(50, 120));
                break;
            case 136:
                options.add(new ItemOption(47, 24));
                break;
            case 137:
                options.add(new ItemOption(47, 40));
                break;
            case 138:
                options.add(new ItemOption(47, 60));
                break;
            case 139:
                options.add(new ItemOption(47, 90));
                break;
            case 140:
                options.add(new ItemOption(6, 1400));
                options.add(new ItemOption(27, 280));
                break;
            case 141:
                options.add(new ItemOption(6, 3000));
                options.add(new ItemOption(27, 600));
                break;
            case 142:
                options.add(new ItemOption(6, 6000));
                options.add(new ItemOption(27, 1200));
                break;
            case 143:
                options.add(new ItemOption(6, 10000));
                options.add(new ItemOption(27, 2000));
                break;
            case 144:
                options.add(new ItemOption(0, 55));
                break;
            case 145:
                options.add(new ItemOption(0, 110));
                break;
            case 146:
                options.add(new ItemOption(0, 220));
                break;
            case 147:
                options.add(new ItemOption(0, 530));
                break;
            case 148:
                options.add(new ItemOption(7, 500));
                options.add(new ItemOption(28, 100));
                break;
            case 149:
                options.add(new ItemOption(7, 1200));
                options.add(new ItemOption(28, 240));
                break;
            case 150:
                options.add(new ItemOption(7, 2400));
                options.add(new ItemOption(28, 480));
                break;
            case 151:
                options.add(new ItemOption(7, 5000));
                options.add(new ItemOption(28, 1000));
                break;
            case 152:
                options.add(new ItemOption(47, 24));
                break;
            case 153:
                options.add(new ItemOption(47, 40));
                break;
            case 154:
                options.add(new ItemOption(47, 60));
                break;
            case 155:
                options.add(new ItemOption(47, 90));
                break;
            case 156:
                options.add(new ItemOption(6, 600));
                options.add(new ItemOption(27, 240));
                break;
            case 157:
                options.add(new ItemOption(6, 1200));
                options.add(new ItemOption(27, 480));
                break;
            case 158:
                options.add(new ItemOption(6, 2400));
                options.add(new ItemOption(27, 960));
                break;
            case 159:
                options.add(new ItemOption(6, 4800));
                options.add(new ItemOption(27, 1800));
                break;
            case 160:
                options.add(new ItemOption(0, 50));
                break;
            case 161:
                options.add(new ItemOption(0, 100));
                break;
            case 162:
                options.add(new ItemOption(0, 200));
                break;
            case 163:
                options.add(new ItemOption(0, 500));
                break;
            case 164:
                options.add(new ItemOption(7, 600));
                options.add(new ItemOption(28, 120));
                break;
            case 165:
                options.add(new ItemOption(7, 1500));
                options.add(new ItemOption(28, 300));
                break;
            case 166:
                options.add(new ItemOption(7, 3000));
                options.add(new ItemOption(28, 600));
                break;
            case 167:
                options.add(new ItemOption(7, 6000));
                options.add(new ItemOption(28, 1200));
                break;
            case 168:
                options.add(new ItemOption(47, 30));
                break;
            case 169:
                options.add(new ItemOption(47, 50));
                break;
            case 170:
                options.add(new ItemOption(47, 70));
                break;
            case 171:
                options.add(new ItemOption(47, 100));
                break;
            case 172:
                options.add(new ItemOption(6, 500));
                options.add(new ItemOption(27, 200));
                break;
            case 173:
                options.add(new ItemOption(6, 1000));
                options.add(new ItemOption(27, 400));
                break;
            case 174:
                options.add(new ItemOption(6, 2000));
                options.add(new ItemOption(27, 800));
                break;
            case 175:
                options.add(new ItemOption(6, 4000));
                options.add(new ItemOption(27, 1600));
                break;
            case 176:
                options.add(new ItemOption(0, 60));
                break;
            case 177:
                options.add(new ItemOption(0, 120));
                break;
            case 178:
                options.add(new ItemOption(0, 240));
                break;
            case 179:
                options.add(new ItemOption(0, 560));
                break;
            case 180:
                options.add(new ItemOption(7, 400));
                options.add(new ItemOption(28, 80));
                break;
            case 181:
                options.add(new ItemOption(7, 1000));
                options.add(new ItemOption(28, 200));
                break;
            case 182:
                options.add(new ItemOption(7, 2000));
                options.add(new ItemOption(28, 400));
                break;
            case 183:
                options.add(new ItemOption(7, 4000));
                options.add(new ItemOption(28, 800));
                break;
            case 184:
                options.add(new ItemOption(14, 5));
                break;
            case 185:
                options.add(new ItemOption(14, 6));
                break;
            case 186:
                options.add(new ItemOption(14, 7));
                break;
            case 187:
                options.add(new ItemOption(14, 8));
                break;
            case 211:
                options.add(new ItemOption(62, 100));
                break;
            case 214:
                options.add(new ItemOption(66, 0));
                break;
            case 215:
                options.add(new ItemOption(66, 0));
                break;
            case 220:
                options.add(new ItemOption(71, 1));
                break;
            case 221:
                options.add(new ItemOption(70, 1));
                break;
            case 222:
                options.add(new ItemOption(69, 1));
                break;
            case 223:
                options.add(new ItemOption(68, 1));
                break;
            case 224:
                options.add(new ItemOption(67, 1));
                break;
            case 230:
                options.add(new ItemOption(47, 200));
                break;
            case 231:
                options.add(new ItemOption(47, 250));
                break;
            case 232:
                options.add(new ItemOption(47, 300));
                break;
            case 233:
                options.add(new ItemOption(47, 400));
                break;
            case 234:
                options.add(new ItemOption(47, 200));
                break;
            case 235:
                options.add(new ItemOption(47, 250));
                break;
            case 236:
                options.add(new ItemOption(47, 300));
                break;
            case 237:
                options.add(new ItemOption(47, 400));
                break;
            case 238:
                options.add(new ItemOption(47, 230));
                break;
            case 239:
                options.add(new ItemOption(47, 280));
                break;
            case 240:
                options.add(new ItemOption(47, 330));
                break;
            case 241:
                options.add(new ItemOption(47, 450));
                break;
            case 242:
                options.add(new ItemOption(6, 14000));
                options.add(new ItemOption(27, 2500));
                break;
            case 243:
                options.add(new ItemOption(6, 18000));
                options.add(new ItemOption(27, 3000));
                break;
            case 244:
                options.add(new ItemOption(6, 22000));
                options.add(new ItemOption(27, 3500));
                break;
            case 245:
                options.add(new ItemOption(6, 26000));
                options.add(new ItemOption(27, 4000));
                break;
            case 246:
                options.add(new ItemOption(6, 13000));
                options.add(new ItemOption(27, 2200));
                break;
            case 247:
                options.add(new ItemOption(6, 17000));
                options.add(new ItemOption(27, 2700));
                break;
            case 248:
                options.add(new ItemOption(6, 21000));
                options.add(new ItemOption(27, 3200));
                break;
            case 249:
                options.add(new ItemOption(6, 25000));
                options.add(new ItemOption(27, 3700));
                break;
            case 250:
                options.add(new ItemOption(6, 12000));
                options.add(new ItemOption(27, 2100));
                break;
            case 251:
                options.add(new ItemOption(6, 16000));
                options.add(new ItemOption(27, 2600));
                break;
            case 252:
                options.add(new ItemOption(6, 20000));
                options.add(new ItemOption(27, 3100));
                break;
            case 253:
                options.add(new ItemOption(6, 24000));
                options.add(new ItemOption(27, 3600));
                break;
            case 254:
                options.add(new ItemOption(0, 680));
                break;
            case 255:
                options.add(new ItemOption(0, 1000));
                break;
            case 256:
                options.add(new ItemOption(0, 1500));
                break;
            case 257:
                options.add(new ItemOption(0, 2200));
                break;
            case 258:
                options.add(new ItemOption(0, 630));
                break;
            case 259:
                options.add(new ItemOption(0, 950));
                break;
            case 260:
                options.add(new ItemOption(0, 1450));
                break;
            case 261:
                options.add(new ItemOption(0, 2150));
                break;
            case 262:
                options.add(new ItemOption(0, 700));
                break;
            case 263:
                options.add(new ItemOption(0, 1050));
                break;
            case 264:
                options.add(new ItemOption(0, 1550));
                break;
            case 265:
                options.add(new ItemOption(0, 2250));
                break;
            case 266:
                options.add(new ItemOption(7, 9000));
                options.add(new ItemOption(28, 1500));
                break;
            case 267:
                options.add(new ItemOption(7, 14000));
                options.add(new ItemOption(28, 2000));
                break;
            case 268:
                options.add(new ItemOption(7, 19000));
                options.add(new ItemOption(28, 2500));
                break;
            case 269:
                options.add(new ItemOption(7, 24000));
                options.add(new ItemOption(28, 3000));
                break;
            case 270:
                options.add(new ItemOption(7, 10000));
                options.add(new ItemOption(28, 1700));
                break;
            case 271:
                options.add(new ItemOption(7, 15000));
                options.add(new ItemOption(28, 2200));
                break;
            case 272:
                options.add(new ItemOption(7, 20000));
                options.add(new ItemOption(28, 2700));
                break;
            case 273:
                options.add(new ItemOption(7, 25000));
                options.add(new ItemOption(28, 3200));
                break;
            case 274:
                options.add(new ItemOption(7, 8000));
                options.add(new ItemOption(28, 1300));
                break;
            case 275:
                options.add(new ItemOption(7, 13000));
                options.add(new ItemOption(28, 1800));
                break;
            case 276:
                options.add(new ItemOption(7, 18000));
                options.add(new ItemOption(28, 2300));
                break;
            case 277:
                options.add(new ItemOption(7, 23000));
                options.add(new ItemOption(28, 2800));
                break;
            case 278:
                options.add(new ItemOption(14, 9));
                break;
            case 279:
                options.add(new ItemOption(14, 10));
                break;
            case 280:
                options.add(new ItemOption(14, 11));
                break;
            case 281:
                options.add(new ItemOption(14, 12));
                break;
            case 283:
                options.add(new ItemOption(77, 10));
                break;
            case 284:
                options.add(new ItemOption(77, 10));
                break;
            case 285:
                options.add(new ItemOption(77, 10));
                break;
            case 290:
                options.add(new ItemOption(14, 2));
                options.add(new ItemOption(50, 12));
                options.add(new ItemOption(94, 8));
                break;
            case 291:
                options.add(new ItemOption(77, 10));
                break;
            case 292:
                options.add(new ItemOption(14, 2));
                options.add(new ItemOption(50, 12));
                options.add(new ItemOption(94, 8));
                break;
            case 293:
                options.add(new ItemOption(48, 100));
                break;
            case 294:
                options.add(new ItemOption(48, 1000));
                break;
            case 295:
                options.add(new ItemOption(48, 2000));
                break;
            case 296:
                options.add(new ItemOption(48, 4000));
                break;
            case 297:
                options.add(new ItemOption(48, 8000));
                break;
            case 298:
                options.add(new ItemOption(48, 16000));
                break;
            case 299:
                options.add(new ItemOption(48, 32000));
                break;
            case 361:
                break;
            case 379:
                break;
            case 381:
                options.add(new ItemOption(86, 0));
                break;
            case 382:
                options.add(new ItemOption(86, 0));
                break;
            case 383:
                options.add(new ItemOption(86, 0));
                break;
            case 384:
                options.add(new ItemOption(86, 0));
                break;
            case 386:
                options.add(new ItemOption(77, 10));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(50, 10));
                break;
            case 387:
                options.add(new ItemOption(77, 21));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(31, 50));
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(103, 20));
                break;
            case 388:
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 20));
                break;
            case 389:
                options.add(new ItemOption(77, 10));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(50, 10));
                break;
            case 390:
                options.add(new ItemOption(77, 21));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(31, 50));
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(103, 20));
                break;
            case 391:
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 20));
                break;
            case 392:
                options.add(new ItemOption(77, 10));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(50, 10));
                break;
            case 393:
                options.add(new ItemOption(77, 21));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(31, 50));
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(103, 20));
                break;
            case 394:
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 20));
                break;
            case 400:
                break;
            case 401:
                break;
            case 402:
                break;
            case 403:
                break;
            case 404:
                break;
            case 405:
                options.add(new ItemOption(50, 10));
                break;
            case 406:
                options.add(new ItemOption(50, 11));
                break;
            case 407:
                options.add(new ItemOption(50, 12));
                break;
            case 423:
                options.add(new ItemOption(50, 13));
                options.add(new ItemOption(93, 7));
                break;
            case 424:
                options.add(new ItemOption(50, 13));
                options.add(new ItemOption(93, 7));
                break;
            case 425:
                options.add(new ItemOption(50, 13));
                options.add(new ItemOption(93, 7));
                break;
            case 426:
                options.add(new ItemOption(50, 13));
                options.add(new ItemOption(93, 7));
                break;
            case 427:
                options.add(new ItemOption(50, 14));
                options.add(new ItemOption(93, 7));
                break;
            case 428:
                options.add(new ItemOption(50, 15));
                options.add(new ItemOption(93, 7));
                break;
            case 429:
                options.add(new ItemOption(50, 12));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(93, 30));
                break;
            case 430:
                options.add(new ItemOption(50, 13));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(93, 30));
                break;
            case 431:
                options.add(new ItemOption(50, 12));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(93, 30));
                break;
            case 432:
                options.add(new ItemOption(50, 14));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(93, 30));
                break;
            case 433:
                options.add(new ItemOption(50, 15));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(93, 30));
                break;
            case 448:
                options.add(new ItemOption(104, 50));
                break;
            case 449:
                options.add(new ItemOption(105, 0));
                break;
            case 450:
                options.add(new ItemOption(106, 0));
                break;
            case 451:
                options.add(new ItemOption(100, 20));
                break;
            case 452:
                options.add(new ItemOption(101, 20));
                break;
            case 455:
                options.add(new ItemOption(109, 10));
                options.add(new ItemOption(110, 0));
                break;
            case 457:
                options.add(new ItemOption(100, 1));
                break;
            case 458:
                options.add(new ItemOption(111, 0));
                options.add(new ItemOption(110, 0));
                break;
            case 461:
                options.add(new ItemOption(114, 100));
                options.add(new ItemOption(101, 10));
                options.add(new ItemOption(110, 0));
                break;
            case 464:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(117, 15));
                options.add(new ItemOption(114, 25));
                options.add(new ItemOption(77, 24));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 516:
                break;
            case 521:
                options.add(new ItemOption(1, 20));
                break;
            case 524:
                options.add(new ItemOption(3, 80));
                options.add(new ItemOption(4, 1));
                options.add(new ItemOption(5, 10));
                break;
            case 525:
                options.add(new ItemOption(3, 100));
                options.add(new ItemOption(4, 2));
                options.add(new ItemOption(5, 15));
                break;
            case 526:
                options.add(new ItemOption(8, 1));
                options.add(new ItemOption(50, 14));
                break;
            case 527:
                options.add(new ItemOption(8, 2));
                options.add(new ItemOption(50, 16));
                options.add(new ItemOption(103, 15));
                break;
            case 528:
                options.add(new ItemOption(8, 3));
                options.add(new ItemOption(50, 18));
                options.add(new ItemOption(77, 15));
                options.add(new ItemOption(103, 15));
                break;
            case 529:
                options.add(new ItemOption(9, 0));
                break;
            case 530:
                options.add(new ItemOption(9, 0));
                break;
            case 531:
                options.add(new ItemOption(9, 0));
                break;
            case 534:
                options.add(new ItemOption(9, 0));
                break;
            case 535:
                options.add(new ItemOption(9, 0));
                break;
            case 536:
                options.add(new ItemOption(9, 0));
                break;
            case 549:
                options.add(new ItemOption(8, 4));
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(77, 17));
                options.add(new ItemOption(103, 17));
                break;
            case 550:
                options.add(new ItemOption(19, 24));
                break;
            case 551:
                options.add(new ItemOption(19, 22));
                break;
            case 552:
                options.add(new ItemOption(19, 20));
                break;
            case 575:
                options.add(new ItemOption(50, 19));
                options.add(new ItemOption(77, 16));
                options.add(new ItemOption(103, 16));
                options.add(new ItemOption(24, 0));
                break;
            case 576:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(77, 17));
                options.add(new ItemOption(103, 17));
                options.add(new ItemOption(25, 0));
                break;
            case 577:
                options.add(new ItemOption(50, 21));
                options.add(new ItemOption(77, 18));
                options.add(new ItemOption(103, 18));
                options.add(new ItemOption(26, 0));
                break;
            case 578:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 19));
                options.add(new ItemOption(103, 19));
                options.add(new ItemOption(29, 0));
                break;
            case 583:
                options.add(new ItemOption(50, 8));
                options.add(new ItemOption(77, 8));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(150, 0));
                break;
            case 584:
                options.add(new ItemOption(117, 15));
                options.add(new ItemOption(114, 25));
                options.add(new ItemOption(93, 2));
                break;
            case 591:
                options.add(new ItemOption(47, 450));
                options.add(new ItemOption(108, 30));
                options.add(new ItemOption(33, 1));
                break;
            case 592:
                options.add(new ItemOption(47, 350));
                options.add(new ItemOption(108, 10));
                options.add(new ItemOption(33, 1));
                break;
            case 593:
                options.add(new ItemOption(47, 350));
                options.add(new ItemOption(108, 10));
                options.add(new ItemOption(33, 1));
                break;
            case 594:
                options.add(new ItemOption(47, 350));
                options.add(new ItemOption(108, 10));
                options.add(new ItemOption(33, 1));
                break;
            case 596:
                options.add(new ItemOption(48, 64000));
                break;
            case 597:
                options.add(new ItemOption(48, 128000));
                break;
            case 598:
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(80, 10));
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(88, 20));
                break;
            case 599:
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(80, 10));
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(88, 20));
                break;
            case 600:
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(80, 10));
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(88, 20));
                break;
            case 601:
                options.add(new ItemOption(50, 21));
                options.add(new ItemOption(77, 18));
                options.add(new ItemOption(103, 18));
                options.add(new ItemOption(38, 0));
                break;
            case 602:
                options.add(new ItemOption(50, 21));
                options.add(new ItemOption(77, 18));
                options.add(new ItemOption(103, 18));
                options.add(new ItemOption(38, 0));
                break;
            case 603:
                options.add(new ItemOption(50, 21));
                options.add(new ItemOption(77, 18));
                options.add(new ItemOption(103, 18));
                options.add(new ItemOption(38, 0));
                break;
            case 604:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                break;
            case 605:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                break;
            case 606:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                break;
            case 607:
                options.add(new ItemOption(19, 21));
                options.add(new ItemOption(77, 18));
                options.add(new ItemOption(103, 18));
                break;
            case 612:
                options.add(new ItemOption(50, 10));
                options.add(new ItemOption(114, 33));
                options.add(new ItemOption(145, 0));
                options.add(new ItemOption(146, 0));
                break;
            case 613:
                options.add(new ItemOption(50, 10));
                options.add(new ItemOption(114, 33));
                options.add(new ItemOption(145, 0));
                options.add(new ItemOption(146, 0));
                break;
            case 614:
                options.add(new ItemOption(50, 10));
                options.add(new ItemOption(114, 33));
                options.add(new ItemOption(145, 0));
                options.add(new ItemOption(146, 0));
                break;
            case 615:
                options.add(new ItemOption(14, 2));
                options.add(new ItemOption(114, 50));
                options.add(new ItemOption(50, 10));
                options.add(new ItemOption(94, 5));
                break;
            case 616:
                options.add(new ItemOption(14, 2));
                options.add(new ItemOption(50, 12));
                options.add(new ItemOption(94, 8));
                break;
            case 617:
                options.add(new ItemOption(14, 3));
                options.add(new ItemOption(50, 13));
                options.add(new ItemOption(94, 9));
                break;
            case 618:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 619:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 620:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 621:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 622:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 623:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 624:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 625:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 626:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 627:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(148, 12));
                options.add(new ItemOption(149, 1));
                break;
            case 629:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(94, 20));
                break;
            case 630:
                options.add(new ItemOption(50, 10));
                options.add(new ItemOption(106, 0));
                break;
            case 631:
                options.add(new ItemOption(50, 11));
                options.add(new ItemOption(106, 0));
                break;
            case 632:
                options.add(new ItemOption(50, 12));
                options.add(new ItemOption(106, 0));
                break;
            case 633:
                options.add(new ItemOption(50, 8));
                options.add(new ItemOption(77, 8));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(150, 0));
                break;
            case 634:
                options.add(new ItemOption(50, 8));
                options.add(new ItemOption(77, 8));
                options.add(new ItemOption(94, 8));
                options.add(new ItemOption(150, 0));
                break;
            case 640:
                options.add(new ItemOption(50, 21));
                options.add(new ItemOption(77, 18));
                options.add(new ItemOption(103, 18));
                options.add(new ItemOption(38, 0));
                options.add(new ItemOption(93, 45));
                break;
            case 642:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(95, 15));
                options.add(new ItemOption(96, 15));
                options.add(new ItemOption(81, 5));
                options.add(new ItemOption(154, 0));
                break;
            case 643:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(95, 10));
                options.add(new ItemOption(96, 10));
                options.add(new ItemOption(154, 0));
                break;
            case 644:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(181, 10));
                options.add(new ItemOption(154, 0));
                break;
            case 645:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(182, 10));
                options.add(new ItemOption(154, 0));
                break;
            case 646:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(183, 5));
                options.add(new ItemOption(154, 0));
                break;
            case 647:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(153, 50));
                break;
            case 649:
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 7));
                break;
            case 650:
                options.add(new ItemOption(47, 1600));
                options.add(new ItemOption(21, 42));
                options.add(new ItemOption(30, 0));
                break;
            case 651:
                options.add(new ItemOption(22, 104));
                options.add(new ItemOption(27, 16000));
                options.add(new ItemOption(21, 46));
                options.add(new ItemOption(30, 0));
                break;
            case 652:
                options.add(new ItemOption(47, 1700));
                options.add(new ItemOption(21, 42));
                options.add(new ItemOption(30, 0));
                break;
            case 653:
                options.add(new ItemOption(22, 100));
                options.add(new ItemOption(27, 14000));
                options.add(new ItemOption(21, 46));
                options.add(new ItemOption(30, 0));
                break;
            case 654:
                options.add(new ItemOption(47, 1800));
                options.add(new ItemOption(21, 42));
                options.add(new ItemOption(30, 0));
                break;
            case 655:
                options.add(new ItemOption(22, 96));
                options.add(new ItemOption(27, 12000));
                options.add(new ItemOption(21, 46));
                options.add(new ItemOption(30, 0));
                break;
            case 656:
                options.add(new ItemOption(14, 16));
                options.add(new ItemOption(21, 48));
                options.add(new ItemOption(30, 0));
                break;
            case 657:
                options.add(new ItemOption(0, 8800));
                options.add(new ItemOption(21, 50));
                options.add(new ItemOption(30, 0));
                break;
            case 658:
                options.add(new ItemOption(23, 96));
                options.add(new ItemOption(28, 12000));
                options.add(new ItemOption(21, 44));
                options.add(new ItemOption(30, 0));
                break;
            case 659:
                options.add(new ItemOption(0, 8600));
                options.add(new ItemOption(21, 50));
                options.add(new ItemOption(30, 0));
                break;
            case 660:
                options.add(new ItemOption(23, 100));
                options.add(new ItemOption(28, 12800));
                options.add(new ItemOption(21, 44));
                options.add(new ItemOption(30, 0));
                break;
            case 661:
                options.add(new ItemOption(0, 9000));
                options.add(new ItemOption(21, 50));
                options.add(new ItemOption(30, 0));
                break;
            case 662:
                options.add(new ItemOption(23, 92));
                options.add(new ItemOption(28, 11200));
                options.add(new ItemOption(21, 44));
                options.add(new ItemOption(30, 0));
                break;
            case 663:
                options.add(new ItemOption(30, 0));
                break;
            case 664:
                options.add(new ItemOption(30, 0));
                break;
            case 665:
                options.add(new ItemOption(30, 0));
                break;
            case 666:
                options.add(new ItemOption(30, 0));
                break;
            case 667:
                options.add(new ItemOption(30, 0));
                break;
            case 677:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(25, 30))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(20, 30))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(20, 35))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(148, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(5, Util.gI().nextInt(15, 20)));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 678:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(25, 30))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(20, 30))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(20, 35))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(148, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(5, Util.gI().nextInt(15, 20)));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 680:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(95, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(96, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 681:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(94, 20));
                break;
            case 710:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(159, 3));
                options.add(new ItemOption(160, 35));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 711:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 21));
                options.add(new ItemOption(103, 21));
                options.add(new ItemOption(159, 4));
                options.add(new ItemOption(160, 50));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 719:
                options.add(new ItemOption(50, 18));
                options.add(new ItemOption(77, 18));
                options.add(new ItemOption(103, 18));
                options.add(new ItemOption(100, 20));
                options.add(new ItemOption(161, 2));
                break;
            case 724:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(77, 17));
                options.add(new ItemOption(103, 17));
                options.add(new ItemOption(162, 2));
                break;
            case 730:
                options.add(new ItemOption(50, Util.gI().nextInt(23, Util.gI().nextInt(25, 30))));
                options.add(new ItemOption(77, Util.gI().nextInt(23, Util.gI().nextInt(25, 30))));
                options.add(new ItemOption(103, Util.gI().nextInt(23, Util.gI().nextInt(25, 30))));
                options.add(new ItemOption(95, Util.gI().nextInt(5, 20)));
                options.add(new ItemOption(5, Util.gI().nextInt(10, 20)));
                options.add(new ItemOption(154, 0));
                break;
            case 731:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(22, 25))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(22, 25))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(22, 25))));
                options.add(new ItemOption(95, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(181, Util.gI().nextInt(10, 15)));
                options.add(new ItemOption(154, 0));
                break;
            case 732:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(20, 25))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(22, 25))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(25, 30))));
                options.add(new ItemOption(96, Util.gI().nextInt(10, 15)));
                options.add(new ItemOption(81, Util.gI().nextInt(10, 15)));
                options.add(new ItemOption(154, 0));
                break;
            case 733:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                break;

            case 754:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 755:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 756:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 759:
                break;
            case 760:
                options.add(new ItemOption(50, 24));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                break;
            case 764:
                options.add(new ItemOption(19, 10));
                options.add(new ItemOption(88, 5));
                options.add(new ItemOption(9, 30));
                options.add(new ItemOption(30, 0));
                break;
            case 765:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 19));
                options.add(new ItemOption(103, 19));
                options.add(new ItemOption(80, 5));
                options.add(new ItemOption(28, 5));
                options.add(new ItemOption(177, 0));
                break;
            case 773:
                options.add(new ItemOption(88, 5));
                break;
            case 806:
                options.add(new ItemOption(94, 20));
                options.add(new ItemOption(108, 10));
                options.add(new ItemOption(176, 0));
                break;
            case 819:
                options.add(new ItemOption(117, 10));
                options.add(new ItemOption(80, 6));
                options.add(new ItemOption(176, 0));
                break;
            case 824:
                options.add(new ItemOption(77, 32));
                options.add(new ItemOption(106, 1));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 22));
                break;
            case 825:
                options.add(new ItemOption(77, 32));
                options.add(new ItemOption(106, 1));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 22));
                break;
            case 826:
                options.add(new ItemOption(77, 32));
                options.add(new ItemOption(106, 1));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 22));
                break;

            case 843:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 844:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 845:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 846:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 847:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 848:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 849:
                options.add(new ItemOption(84, 0));
                options.add(new ItemOption(148, 25));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 853:
                options.add(new ItemOption(77, 32));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 22));
                break;
            case 854:
                options.add(new ItemOption(77, 32));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 22));
                break;
            case 855:
                options.add(new ItemOption(77, 32));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 22));
                break;
            case 856:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 857:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 858:
                options.add(new ItemOption(77, 31));
                options.add(new ItemOption(80, 50));
                options.add(new ItemOption(50, 21));
                break;
            case 860:
                options.add(new ItemOption(50, 24));
                options.add(new ItemOption(117, 20));
                options.add(new ItemOption(114, 20));
                options.add(new ItemOption(154, 20));
                options.add(new ItemOption(77, 24));
                break;
            case 862:
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(98, 20));
                options.add(new ItemOption(176, 0));
                break;
            case 863:
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(176, 0));
                break;
            case 864:
                options.add(new ItemOption(50, 20));
                options.add(new ItemOption(77, 5));
                options.add(new ItemOption(176, 0));
                break;
            case 866:
                options.add(new ItemOption(50, 15));
                options.add(new ItemOption(103, 15));
                break;

            case 872:
                options.add(new ItemOption(76, 0));
                options.add(new ItemOption(77, 25));
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(14, 25));
                options.add(new ItemOption(103, 20));
                break;
            case 873:
                options.add(new ItemOption(76, 0));
                options.add(new ItemOption(77, 25));
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(14, 25));
                options.add(new ItemOption(103, 20));
                break;

            case 875:
                options.add(new ItemOption(187, 3));
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(24, 28)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(9, 15)))));
                options.add(new ItemOption(97, 10));
                options.add(new ItemOption(80, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(154, 0));
                break;
            case 876:
                options.add(new ItemOption(187, 3));
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(24, 28)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(9, 15)))));
                options.add(new ItemOption(97, 10));
                options.add(new ItemOption(80, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(154, 0));
                break;
            case 877:
                options.add(new ItemOption(187, 3));
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(24, 28)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(9, 15)))));
                options.add(new ItemOption(97, 10));
                options.add(new ItemOption(80, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(154, 0));
                break;
//            case 875:
//                options.add(new ItemOption(50, 22));
//                options.add(new ItemOption(116, 0));
//                options.add(new ItemOption(81, 5));
//                break;
//            case 876:
//                options.add(new ItemOption(50, 22));
//                options.add(new ItemOption(116, 0));
//                options.add(new ItemOption(81, 5));
//                break;
//            case 877:
//                options.add(new ItemOption(50, 22));
//                options.add(new ItemOption(116, 0));
//                options.add(new ItemOption(81, 5));
//                break;
            case 878:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(103, 19));
                options.add(new ItemOption(178, 3));
                options.add(new ItemOption(179, 0));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                break;
            case 879:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(103, 18));
                options.add(new ItemOption(178, 3));
                options.add(new ItemOption(179, 0));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                break;
            case 896:
                options.add(new ItemOption(77, 13));
                options.add(new ItemOption(103, 10));
                options.add(new ItemOption(14, 1));
                options.add(new ItemOption(97, 9));
                break;
            case 898:
                options.add(new ItemOption(50, 24));
                options.add(new ItemOption(14, 3));
                options.add(new ItemOption(77, 15));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(5, 15));
                options.add(new ItemOption(80, 11));
                options.add(new ItemOption(154, 0));
                options.add(new ItemOption(93, 30));
                if (status > 0) {
                    options.add(new ItemOption(93, Util.gI().nextInt(3, 15)));
                }
                break;
            case 904:
                options.add(new ItemOption(50, 24));
                options.add(new ItemOption(14, 4));
                options.add(new ItemOption(94, 10));
                options.add(new ItemOption(77, 15));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(108, 5));
                options.add(new ItemOption(80, 10));
                options.add(new ItemOption(180, 2));
                options.add(new ItemOption(154, 0));
                break;
            case 905:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(47, 400));
                options.add(new ItemOption(108, 30));
                options.add(new ItemOption(181, 10));
                options.add(new ItemOption(154, 0));
                break;
            case 906:
                options.add(new ItemOption(50, 24));
                options.add(new ItemOption(14, 3));
                options.add(new ItemOption(77, 19));
                options.add(new ItemOption(103, 19));
                options.add(new ItemOption(5, 14));
                options.add(new ItemOption(154, 0));
                break;
            case 907:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(47, 350));
                options.add(new ItemOption(108, 30));
                options.add(new ItemOption(182, 10));
                break;
            case 911:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(47, 350));
                options.add(new ItemOption(108, 30));
                options.add(new ItemOption(183, 10));
                break;
            case 912:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(94, 19));
                options.add(new ItemOption(184, 2));
                options.add(new ItemOption(106, 1));
                break;
            case 913:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(94, 19));
                options.add(new ItemOption(184, 2));
                options.add(new ItemOption(106, 1));
                break;
            case 914:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(94, 19));
                options.add(new ItemOption(184, 2));
                options.add(new ItemOption(106, 1));
                break;

            case 937:
                options.add(new ItemOption(50, 24));
                options.add(new ItemOption(77, 20));
                options.add(new ItemOption(103, 20));
                options.add(new ItemOption(94, 10));
                options.add(new ItemOption(108, 6));
                options.add(new ItemOption(80, 15));
                options.add(new ItemOption(106, 1));
                options.add(new ItemOption(186, 1));
                break;

//END RCN
//BEGIN HIEU
            case 555:
                options.add(new ItemOption(47, 800));
                options.add(new ItemOption(21, 15));
                break;
            case 556:
                options.add(new ItemOption(22, 52));
                options.add(new ItemOption(27, 6000));
                options.add(new ItemOption(21, 15));
                break;
            case 557:
                options.add(new ItemOption(47, 850));
                options.add(new ItemOption(21, 15));
                break;
            case 558:
                options.add(new ItemOption(22, 50));
                options.add(new ItemOption(27, 6000));
                options.add(new ItemOption(21, 15));
                break;
            case 559:
                options.add(new ItemOption(47, 900));
                options.add(new ItemOption(21, 15));
                break;
            case 560:
                options.add(new ItemOption(22, 48));
                options.add(new ItemOption(27, 6000));
                options.add(new ItemOption(21, 15));
                break;
            case 561:
                options.add(new ItemOption(14, 15));
                options.add(new ItemOption(21, 15));
                break;
            case 562:
                options.add(new ItemOption(0, 4400));
                options.add(new ItemOption(21, 15));
                break;
            case 563:
                options.add(new ItemOption(23, 60));
                options.add(new ItemOption(28, 6500));
                options.add(new ItemOption(21, 16));
                break;
            case 564:
                options.add(new ItemOption(0, 4300));
                options.add(new ItemOption(21, 15));
                break;
            case 565:
                options.add(new ItemOption(23, 60));
                options.add(new ItemOption(28, 6000));
                options.add(new ItemOption(21, 16));
                break;
            case 566:
                options.add(new ItemOption(0, 4500));
                options.add(new ItemOption(21, 15));
                break;
            case 567:
                options.add(new ItemOption(23, 60));
                options.add(new ItemOption(28, 5000));
                options.add(new ItemOption(21, 16));
                break;

            ///25/6                    
            case 1007:
                options.add(new ItemOption(50, 11));
                options.add(new ItemOption(77, 10));
                options.add(new ItemOption(103, 11));
                options.add(new ItemOption(94, 11));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1008:
                options.add(new ItemOption(50, 11));
                options.add(new ItemOption(77, 10));
                options.add(new ItemOption(103, 11));
                options.add(new ItemOption(94, 11));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 544:
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                options.add(new ItemOption(50, Util.gI().nextInt(15, 30)));
                options.add(new ItemOption(94, Util.gI().nextInt(10, 20)));
                options.add(new ItemOption(103, Util.gI().nextInt(10, Util.gI().nextInt(10, Util.gI().nextInt(30, 100)))));
                options.add(new ItemOption(77, Util.gI().nextInt(10, Util.gI().nextInt(10, Util.gI().nextInt(30, 100)))));
                options.add(new ItemOption(101, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(100, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(148, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(106, 0));
                break;
            case 545:
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                options.add(new ItemOption(50, Util.gI().nextInt(15, 30)));
                options.add(new ItemOption(94, Util.gI().nextInt(10, 20)));
                options.add(new ItemOption(103, Util.gI().nextInt(10, Util.gI().nextInt(10, Util.gI().nextInt(30, 100)))));
                options.add(new ItemOption(77, Util.gI().nextInt(10, Util.gI().nextInt(10, Util.gI().nextInt(30, 100)))));
                options.add(new ItemOption(101, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(100, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(148, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(106, 0));
                break;
            case 546:
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                options.add(new ItemOption(50, Util.gI().nextInt(15, 30)));
                options.add(new ItemOption(94, Util.gI().nextInt(10, 20)));
                options.add(new ItemOption(103, Util.gI().nextInt(10, Util.gI().nextInt(10, Util.gI().nextInt(30, 100)))));
                options.add(new ItemOption(77, Util.gI().nextInt(10, Util.gI().nextInt(10, Util.gI().nextInt(30, 100)))));
                options.add(new ItemOption(101, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(100, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(148, Util.gI().nextInt(10, 100)));
                options.add(new ItemOption(106, 0));
                break;
            case 1018:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 19));
                options.add(new ItemOption(108, 15));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1019:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 19));
                options.add(new ItemOption(108, 15));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1020:
                options.add(new ItemOption(50, 23));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 19));
                options.add(new ItemOption(108, 15));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1041:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(77, 23));
                options.add(new ItemOption(103, 23));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(108, 12));
                options.add(new ItemOption(196, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1042:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(77, 23));
                options.add(new ItemOption(103, 23));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(108, 12));
                options.add(new ItemOption(196, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1043:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(77, 23));
                options.add(new ItemOption(103, 23));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(108, 12));
                options.add(new ItemOption(196, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            //event trung thu

            //item lưng
            case 865:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(14, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 741:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(95, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 227:
                options.add(new ItemOption(76, 0));
                options.add(new ItemOption(77, Util.gI().nextInt(10, Util.gI().nextInt(10, 20))));
                options.add(new ItemOption(97, Util.gI().nextInt(5, Util.gI().nextInt(5, 10))));
                break;
            case 228:
                options.add(new ItemOption(76, 0));
                options.add(new ItemOption(77, Util.gI().nextInt(10, Util.gI().nextInt(10, 20))));
                options.add(new ItemOption(97, Util.gI().nextInt(5, Util.gI().nextInt(5, 10))));
                break;

            case 229:
                options.add(new ItemOption(76, 0));
                options.add(new ItemOption(77, Util.gI().nextInt(10, Util.gI().nextInt(10, 20))));
                options.add(new ItemOption(97, Util.gI().nextInt(5, Util.gI().nextInt(5, 10))));
                break;
            // sư kien trung thu 2022    

            /// Capsule
            /// van bay
            case 735:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 734:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 743:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            /// pet đi theo
            case 916:
                options.add(new ItemOption(95, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                options.add(new ItemOption(96, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 917:
                options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                options.add(new ItemOption(98, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 918:
                options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                options.add(new ItemOption(94, Util.gI().nextInt(3, Util.gI().nextInt(3, 10))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 1046:
                options.add(new ItemOption(77, Util.gI().nextInt(10, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(103, Util.gI().nextInt(10, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(50, Util.gI().nextInt(9, Util.gI().nextInt(9, 12))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1087:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(108, 14));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(205, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1088:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(108, 14));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(205, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1089:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(108, 14));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(205, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1090:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(108, 14));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(205, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1091:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 18));
                options.add(new ItemOption(108, 14));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(205, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            //Bua nang cap
            case 205:
                options.add(new ItemOption(30, 0));
                break;
            // su kien halloween
            // Nguyen lieu
            case 199:
                options.add(new ItemOption(174, 2022));
                options.add(new ItemOption(93, 30));
                break;
            case 200:
                options.add(new ItemOption(174, 2022));
                options.add(new ItemOption(93, 30));
                break;
            case 201:
                options.add(new ItemOption(174, 2022));
                options.add(new ItemOption(93, 30));
                break;
            case 202:
                options.add(new ItemOption(174, 2022));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            // tui qua halloween    
            case 739:
                options.add(new ItemOption(50, Util.gI().nextInt(15, Util.gI().nextInt(15, Util.gI().nextInt(20, 35)))));
                options.add(new ItemOption(77, Util.gI().nextInt(15, Util.gI().nextInt(20, Util.gI().nextInt(25, 40)))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(20, Util.gI().nextInt(30, 40)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, Util.gI().nextInt(15, 25)))));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 742:
                options.add(new ItemOption(50, Util.gI().nextInt(15, Util.gI().nextInt(20, Util.gI().nextInt(20, 35)))));
                options.add(new ItemOption(77, Util.gI().nextInt(15, Util.gI().nextInt(15, Util.gI().nextInt(25, 40)))));
                options.add(new ItemOption(103, Util.gI().nextInt(15, Util.gI().nextInt(20, Util.gI().nextInt(30, 40)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, Util.gI().nextInt(15, 30)))));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            //capsule halloween
            case 818:
                options.add(new ItemOption(174, 2022));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 204:
                options.add(new ItemOption(174, 2022));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 210:
                options.add(new ItemOption(174, 2022));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1001:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(1, Util.gI().nextInt(1, 5)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 814:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 20)))));
                options.add(new ItemOption(99, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 815:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(12, 20)))));
                options.add(new ItemOption(104, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 816:
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(12, 20)))));
                options.add(new ItemOption(81, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 817:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(12, 20)))));
                options.add(new ItemOption(97, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // Hop qua halloween

            case 1104:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(25, 28)))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(25, 28)))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(25, 32)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(5, Util.gI().nextInt(10, 15)));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1105:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(25, Util.gI().nextInt(28, 35)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 12)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(5, Util.gI().nextInt(10, 18)));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1106:
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(28, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(28, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(103, Util.gI().nextInt(20, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15))));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1108:
                options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(5, Util.gI().nextInt(5, 15)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(1, Util.gI().nextInt(1, 5)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1109:
                options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(5, Util.gI().nextInt(5, 15)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(1, Util.gI().nextInt(1, 5)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 999:
                options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(5, Util.gI().nextInt(5, 15)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, 10))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1116:
                options.add(new ItemOption(30, 0));
                break;
            // trang bi thien su
            case 1048:
                options.add(new ItemOption(47, 1600));
                options.add(new ItemOption(21, 62));
                options.add(new ItemOption(30, 0));
                break;
            case 1051:
                options.add(new ItemOption(22, 104));
                options.add(new ItemOption(27, 16000));
                options.add(new ItemOption(21, 66));
                options.add(new ItemOption(30, 0));
                break;
            case 1049:
                options.add(new ItemOption(47, 1700));
                options.add(new ItemOption(21, 62));
                options.add(new ItemOption(30, 0));
                break;
            case 1052:
                options.add(new ItemOption(22, 100));
                options.add(new ItemOption(27, 14000));
                options.add(new ItemOption(21, 66));
                options.add(new ItemOption(30, 0));
                break;
            case 1050:
                options.add(new ItemOption(47, 1800));
                options.add(new ItemOption(21, 62));
                options.add(new ItemOption(30, 0));
                break;
            case 1053:
                options.add(new ItemOption(22, 96));
                options.add(new ItemOption(27, 12000));
                options.add(new ItemOption(21, 66));
                options.add(new ItemOption(30, 0));
                break;
            case 1060:
                options.add(new ItemOption(14, 16));
                options.add(new ItemOption(21, 68));
                options.add(new ItemOption(30, 0));
                break;
            case 1061:
                options.add(new ItemOption(14, 16));
                options.add(new ItemOption(21, 68));
                options.add(new ItemOption(30, 0));
                break;
            case 1062:
                options.add(new ItemOption(14, 16));
                options.add(new ItemOption(21, 68));
                options.add(new ItemOption(30, 0));
                break;
            case 1054:
                options.add(new ItemOption(0, 8800));
                options.add(new ItemOption(21, 70));
                options.add(new ItemOption(30, 0));
                break;
            case 1057:
                options.add(new ItemOption(23, 96));
                options.add(new ItemOption(28, 12000));
                options.add(new ItemOption(21, 64));
                options.add(new ItemOption(30, 0));
                break;
            case 1055:
                options.add(new ItemOption(0, 8600));
                options.add(new ItemOption(21, 70));
                options.add(new ItemOption(30, 0));
                break;
            case 1058:
                options.add(new ItemOption(23, 100));
                options.add(new ItemOption(28, 12800));
                options.add(new ItemOption(21, 64));
                options.add(new ItemOption(30, 0));
                break;
            case 1056:
                options.add(new ItemOption(0, 9000));
                options.add(new ItemOption(21, 70));
                options.add(new ItemOption(30, 0));
                break;
            case 1059:
                options.add(new ItemOption(23, 92));
                options.add(new ItemOption(28, 11200));
                options.add(new ItemOption(21, 64));
                options.add(new ItemOption(30, 0));
                break;
            case 1066:
                options.add(new ItemOption(86, 0));
                break;
            case 1067:
                options.add(new ItemOption(86, 0));
                break;
            case 1068:
                options.add(new ItemOption(86, 0));
                break;
            case 1069:
                options.add(new ItemOption(86, 0));
                break;
            case 1070:
                options.add(new ItemOption(86, 0));
                break;
            // Su kien world cup
            case 1118:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1119:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1120:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1121:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1122:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1123:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1124:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1125:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1126:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1127:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1132:
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1133:
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1135:
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1136:
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1134:
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 966:
                options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(3, 9))));
                options.add(new ItemOption(95, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 982:
                options.add(new ItemOption(77, Util.gI().nextInt(3, Util.gI().nextInt(3, 9))));
                options.add(new ItemOption(96, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 983:
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(5, 9))));
                options.add(new ItemOption(96, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 897:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 920:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 1114:
                options.add(new ItemOption(50, Util.gI().nextInt(7, Util.gI().nextInt(10, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(3, Util.gI().nextInt(5, 10)))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1140:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 16)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, 5)));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 967:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(10, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(98, Util.gI().nextInt(5, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1128:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 16)))));
                options.add(new ItemOption(80, Util.gI().nextInt(1, 5)));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1107:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 18)))));
                options.add(new ItemOption(97, Util.gI().nextInt(1, 10)));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 979:
                options.add(new ItemOption(174, 2022));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 980:
                options.add(new ItemOption(174, 2022));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 981:
                options.add(new ItemOption(174, 2022));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 922:
                options.add(new ItemOption(97, 5));
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(24, 28)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(9, 15)))));
                options.add(new ItemOption(80, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                break;
            case 923:
                options.add(new ItemOption(97, 5));
                options.add(new ItemOption(50, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(24, 28)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(9, 15)))));
                options.add(new ItemOption(80, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                break;
            case 924:
                options.add(new ItemOption(97, 5));
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(77, Util.gI().nextInt(20, Util.gI().nextInt(22, Util.gI().nextInt(24, 28)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, 28))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(9, 15)))));
                options.add(new ItemOption(80, Util.gI().nextInt(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 15)))));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                break;
            case 989:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(195, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 990:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(195, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 991:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(108, Util.gI().nextInt(5, 15)));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(195, 2));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1155:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(80, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1156:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(80, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1157:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(80, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 823:
                options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(3, 9))));
                options.add(new ItemOption(95, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 827:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(30, 35))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(30, 35))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(30, 35))));
                options.add(new ItemOption(80, Util.gI().nextInt(10, Util.gI().nextInt(15, 20))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, Util.gI().nextInt(15, 20)))));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 948:
                options.add(new ItemOption(50, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(77, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(103, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(15, 25))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(108, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 952:
                options.add(new ItemOption(50, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(77, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(103, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(15, 25))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(108, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 953:
                options.add(new ItemOption(50, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(77, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(103, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 35)))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(15, 25))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(108, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 752:
                options.add(new ItemOption(50, 15));
                options.add(new ItemOption(14, 15));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 753:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(14, 25));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1185:
                options.add(new ItemOption(103, Util.gI().nextInt(7, Util.gI().nextInt(9, Util.gI().nextInt(12, Util.gI().nextInt(14, 18))))));
                options.add(new ItemOption(96, Util.gI().nextInt(5, 10)));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1186:
                options.add(new ItemOption(77, Util.gI().nextInt(7, Util.gI().nextInt(9, Util.gI().nextInt(12, Util.gI().nextInt(14, 18))))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 852:
                options.add(new ItemOption(50, Util.gI().nextInt(7, Util.gI().nextInt(9, Util.gI().nextInt(12, Util.gI().nextInt(14, 18))))));
                options.add(new ItemOption(14, Util.gI().nextInt(1, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 1100:
                options.add(new ItemOption(50, Util.gI().nextInt(8, Util.gI().nextInt(10, Util.gI().nextInt(12, 15)))));
                options.add(new ItemOption(99, Util.gI().nextInt(1, 10)));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 942:
                options.add(new ItemOption(103, Util.gI().nextInt(7, Util.gI().nextInt(9, Util.gI().nextInt(11, 18)))));
                options.add(new ItemOption(108, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 943:
                options.add(new ItemOption(77, Util.gI().nextInt(7, Util.gI().nextInt(9, Util.gI().nextInt(11, 18)))));
                options.add(new ItemOption(97, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 944:
                options.add(new ItemOption(50, Util.gI().nextInt(7, Util.gI().nextInt(9, Util.gI().nextInt(11, 18)))));
                options.add(new ItemOption(5, Util.gI().nextInt(3, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // nlsk 2023
            case 748:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 749:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 750:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 751:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 758:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1177:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1178:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1179:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1180:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1181:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1182:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1183:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1184:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1187:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1194:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1195:
                options.add(new ItemOption(174, 2023));
                break;
            case 1196:
                options.add(new ItemOption(174, 2023));
                break;
            case 1174:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(80, 25));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1175:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(80, 25));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1176:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 30));
                options.add(new ItemOption(80, 25));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1198:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(77, 25));
                options.add(new ItemOption(103, 25));
                options.add(new ItemOption(94, 15));
                options.add(new ItemOption(8, 4));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1199:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(77, 25));
                options.add(new ItemOption(103, 25));
                options.add(new ItemOption(94, 15));
                options.add(new ItemOption(8, 4));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1200:
                options.add(new ItemOption(50, 25));
                options.add(new ItemOption(77, 25));
                options.add(new ItemOption(103, 25));
                options.add(new ItemOption(94, 15));
                options.add(new ItemOption(8, 4));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 969:
                options.add(new ItemOption(30, 0));
                break;
            case 700:
                options.add(new ItemOption(30, 0));
                break;
            case 1143:
                options.add(new ItemOption(30, 0));
                break;
            case 805:
                options.add(new ItemOption(50, Util.gI().nextInt(2, Util.gI().nextInt(5, 8))));
                options.add(new ItemOption(50, Util.gI().nextInt(2, Util.gI().nextInt(5, 8))));
                options.add(new ItemOption(50, Util.gI().nextInt(2, Util.gI().nextInt(5, 8))));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 1093:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1094:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1095:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1096:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));

                break;
            case 1097:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1098:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 1099:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 673:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 722:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            case 723:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 586:
                options.add(new ItemOption(30, 0));
                break;
            case 587:
                options.add(new ItemOption(30, 0));
                break;
            case 874:
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 3));
                break;
            case 1150:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 1151:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 1152:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 1153:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 1154:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;

            // su kien 10-3
            case 867:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(94, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(108, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 868:
                options.add(new ItemOption(50, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(77, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(103, Util.gI().nextInt(25, Util.gI().nextInt(28, Util.gI().nextInt(30, 32)))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(108, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1110:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1111:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, 15))));
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, 15))));
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, 15))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // item   
            case 908:
                options.add(new ItemOption(103, Util.gI().nextInt(6, Util.gI().nextInt(8, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 5)))));
                options.add(new ItemOption(203, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 909:
                options.add(new ItemOption(77, Util.gI().nextInt(6, Util.gI().nextInt(8, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(94, Util.gI().nextInt(1, Util.gI().nextInt(3, Util.gI().nextInt(4, 10)))));
                options.add(new ItemOption(202, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 910:
                options.add(new ItemOption(50, Util.gI().nextInt(6, Util.gI().nextInt(8, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                options.add(new ItemOption(201, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            //item lung
            case 1013:
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 15)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, 5)));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, 3))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1021:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 15)))));
                options.add(new ItemOption(94, Util.gI().nextInt(1, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, 3))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1022:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 15)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(3, 4)))));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, 3))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // qua dua
            case 569:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 30));
                break;
            // nlsk 
            case 422:
                options.add(new ItemOption(50, Util.gI().nextInt(10, 28)));
                options.add(new ItemOption(77, Util.gI().nextInt(10, 28)));
                options.add(new ItemOption(103, Util.gI().nextInt(10, 28)));
                options.add(new ItemOption(101, Util.gI().nextInt(1, 40)));
                options.add(new ItemOption(5, Util.gI().nextInt(1, 10)));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(93, 3));

                break;
            case 421:
                options.add(new ItemOption(50, Util.gI().nextInt(10, 30)));
                options.add(new ItemOption(77, Util.gI().nextInt(10, 30)));
                options.add(new ItemOption(103, Util.gI().nextInt(10, 28)));
                options.add(new ItemOption(101, Util.gI().nextInt(1, 40)));
                options.add(new ItemOption(5, Util.gI().nextInt(1, 10)));
                options.add(new ItemOption(14, 5));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(93, 3));
                break;
            case 1204:
                options.add(new ItemOption(86, 0));
                options.add(new ItemOption(30, 0));
                break;
            case 1229:
                options.add(new ItemOption(30, 0));
                break;
            //Lech Teamobi
            case 1002:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 14));
                break;
            case 1003:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 14));
                break;
            case 1004:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 14));
                break;
            case 1005:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 14));
                break;
            case 1006:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, 14));
                break;

            //Điều ước thỏ 
            case 1010:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(94, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(108, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1011:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(94, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(108, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1012:
                options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(77, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(103, Util.gI().nextInt(22, Util.gI().nextInt(25, Util.gI().nextInt(28, 30)))));
                options.add(new ItemOption(94, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(108, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(106, 0));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // update 
            case 984:
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 994:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 995:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 996:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, 12))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            // ITEM LUNG
            case 1224:
                options.add(new ItemOption(103, Util.gI().nextInt(6, Util.gI().nextInt(8, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 5)))));
                options.add(new ItemOption(203, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1225:
                options.add(new ItemOption(77, Util.gI().nextInt(6, Util.gI().nextInt(8, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(94, Util.gI().nextInt(1, Util.gI().nextInt(3, Util.gI().nextInt(4, 10)))));
                options.add(new ItemOption(202, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1226:
                options.add(new ItemOption(50, Util.gI().nextInt(6, Util.gI().nextInt(8, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                options.add(new ItemOption(201, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(2, 4)))));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 997:
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 15)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, 5)));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, 3))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 998:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 15)))));
                options.add(new ItemOption(94, Util.gI().nextInt(1, Util.gI().nextInt(5, 10))));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, 3))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1000:
                options.add(new ItemOption(50, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 15)))));
                options.add(new ItemOption(5, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(3, 4)))));
                options.add(new ItemOption(204, Util.gI().nextInt(1, Util.gI().nextInt(2, 3))));
                options.add(new ItemOption(86, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1172:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                options.add(new ItemOption(103, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(3, 5)))));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1144:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1092:
                options.add(new ItemOption(148, 25));
                options.add(new ItemOption(84, 1));
                options.add(new ItemOption(50, Util.gI().nextInt(1, Util.gI().nextInt(2, Util.gI().nextInt(3, 5)))));
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // cai trang he vxmm

            case 1208:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 23));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 10));
                options.add(new ItemOption(108, 5));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1209:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 23));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 10));
                options.add(new ItemOption(108, 5));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1210:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 23));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(94, 10));
                options.add(new ItemOption(108, 5));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1234:
                options.add(new ItemOption(50, 28));
                options.add(new ItemOption(77, 28));
                options.add(new ItemOption(103, 28));
                options.add(new ItemOption(5, 15));
                options.add(new ItemOption(94, 15));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1235:
                options.add(new ItemOption(50, 28));
                options.add(new ItemOption(77, 28));
                options.add(new ItemOption(103, 28));
                options.add(new ItemOption(5, 10));
                options.add(new ItemOption(108, 15));
                options.add(new ItemOption(148, 20));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1236:
                options.add(new ItemOption(50, 28));
                options.add(new ItemOption(77, 28));
                options.add(new ItemOption(103, 28));
                options.add(new ItemOption(5, 10));
                options.add(new ItemOption(97, 15));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 938:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(80, 10));
                options.add(new ItemOption(95, 10));
                options.add(new ItemOption(96, 10));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 939:
                options.add(new ItemOption(50, 22));
                options.add(new ItemOption(77, 22));
                options.add(new ItemOption(103, 22));
                options.add(new ItemOption(80, 10));
                options.add(new ItemOption(95, 10));
                options.add(new ItemOption(96, 10));
                options.add(new ItemOption(154, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1231:
                options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(5, Util.gI().nextInt(8, 10)))));
                options.add(new ItemOption(77, Util.gI().nextInt(3, Util.gI().nextInt(5, Util.gI().nextInt(8, 10)))));
                options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(5, Util.gI().nextInt(8, 10)))));
                options.add(new ItemOption(94, Util.gI().nextInt(3, Util.gI().nextInt(5, Util.gI().nextInt(8, 10)))));
                options.add(new ItemOption(30, 0));
                options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                break;
            case 894:
                if (status == 0) {
                    options.add(new ItemOption(50, Util.gI().nextInt(1, 6)));
                    options.add(new ItemOption(77, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(103, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(5, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(1, 3)));
                    options.add(new ItemOption(93, Util.gI().nextInt(2, 4)));
                }
                if (status == 1) {
                    options.add(new ItemOption(50, Util.gI().nextInt(7, 11)));
                    options.add(new ItemOption(77, Util.gI().nextInt(6, 11)));
                    options.add(new ItemOption(103, Util.gI().nextInt(6, 11)));
                    options.add(new ItemOption(5, Util.gI().nextInt(3, 6)));
                    options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(4, 6)));
                    options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
                }
                if (status == 2) {
                    options.add(new ItemOption(50, Util.gI().nextInt(12, 16)));
                    options.add(new ItemOption(77, Util.gI().nextInt(12, 15)));
                    options.add(new ItemOption(103, Util.gI().nextInt(12, 15)));
                    options.add(new ItemOption(5, Util.gI().nextInt(3, 8)));
                    options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(7, 10)));
                    options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
                }
                if (status == 3) {
                    options.add(new ItemOption(50, Util.gI().nextInt(17, 21)));
                    options.add(new ItemOption(77, Util.gI().nextInt(16, 20)));
                    options.add(new ItemOption(103, Util.gI().nextInt(16, 20)));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, 8)));
                    options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(11, 14)));
                    options.add(new ItemOption(93, Util.gI().nextInt(3, 7)));
                }
                if (status == 4) {
                    options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(22, 28))));
                    options.add(new ItemOption(77, Util.gI().nextInt(21, Util.gI().nextInt(21, 28))));
                    options.add(new ItemOption(103, Util.gI().nextInt(21, Util.gI().nextInt(21, 28))));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(8, 10))));
                    options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(15, Util.gI().nextInt(15, 20))));
                    options.add(new ItemOption(93, Util.gI().nextInt(3, Util.gI().nextInt(5, 7))));
                }
                if (status == 5) {
                    options.add(new ItemOption(50, Util.gI().nextInt(25, Util.gI().nextInt(27, 30))));
                    options.add(new ItemOption(77, Util.gI().nextInt(25, Util.gI().nextInt(27, 32))));
                    options.add(new ItemOption(103, Util.gI().nextInt(25, Util.gI().nextInt(27, 32))));
                    options.add(new ItemOption(5, Util.gI().nextInt(5, Util.gI().nextInt(10, 15))));
                    options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(5, Util.gI().nextInt(17, 27))));
                    options.add(new ItemOption(93, Util.gI().nextInt(3, Util.gI().nextInt(5, 7))));
                }
                options.add(new ItemOption(30, 0));
                break;
            case 895:
                if (status == 0) {
                    options.add(new ItemOption(50, Util.gI().nextInt(1, 6)));
                    options.add(new ItemOption(77, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(103, Util.gI().nextInt(1, 5)));
                    options.add(new ItemOption(94, Util.gI().nextInt(1, 3)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 3)));
                }
                if (status == 1) {
                    options.add(new ItemOption(50, Util.gI().nextInt(7, 11)));
                    options.add(new ItemOption(77, Util.gI().nextInt(6, 11)));
                    options.add(new ItemOption(103, Util.gI().nextInt(6, 11)));
                    options.add(new ItemOption(94, Util.gI().nextInt(4, 6)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
                }
                if (status == 2) {
                    options.add(new ItemOption(50, Util.gI().nextInt(12, 16)));
                    options.add(new ItemOption(77, Util.gI().nextInt(12, 15)));
                    options.add(new ItemOption(103, Util.gI().nextInt(12, 15)));
                    options.add(new ItemOption(94, Util.gI().nextInt(7, 10)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
                }
                if (status == 3) {
                    options.add(new ItemOption(50, Util.gI().nextInt(17, 21)));
                    options.add(new ItemOption(77, Util.gI().nextInt(16, 20)));
                    options.add(new ItemOption(103, Util.gI().nextInt(16, 20)));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, 12)));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, 5)));
                }
                if (status == 4) {
                    options.add(new ItemOption(50, Util.gI().nextInt(22, Util.gI().nextInt(22, 26))));
                    options.add(new ItemOption(77, Util.gI().nextInt(21, Util.gI().nextInt(21, 25))));
                    options.add(new ItemOption(103, Util.gI().nextInt(21, Util.gI().nextInt(21, 25))));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(10, 18))));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, Util.gI().nextInt(3, 7))));
                }
                if (status == 5) {
                    options.add(new ItemOption(50, Util.gI().nextInt(25, Util.gI().nextInt(25, 28))));
                    options.add(new ItemOption(77, Util.gI().nextInt(25, Util.gI().nextInt(28, 28))));
                    options.add(new ItemOption(103, Util.gI().nextInt(25, Util.gI().nextInt(28, 28))));
                    options.add(new ItemOption(94, Util.gI().nextInt(5, Util.gI().nextInt(5, 20))));
                    options.add(new ItemOption(93, Util.gI().nextInt(1, Util.gI().nextInt(3, 7))));
                }
                options.add(new ItemOption(30, 0));
                break;
            case 821:
                options.add(new ItemOption(30, 0));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // he 2023 p2
            case 883:
                options.add(new ItemOption(50, Util.gI().nextInt(25, Util.gI().nextInt(28, 30))));
                options.add(new ItemOption(77, Util.gI().nextInt(25, Util.gI().nextInt(28, 30))));
                options.add(new ItemOption(103, Util.gI().nextInt(25, Util.gI().nextInt(28, 30))));
                options.add(new ItemOption(94, Util.gI().nextInt(5, 10)));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 884:
                options.add(new ItemOption(5, Util.gI().nextInt(30, Util.gI().nextInt(40, Util.gI().nextInt(50, Util.gI().nextInt(50, Util.gI().nextInt(55, 80)))))));
                options.add(new ItemOption(50, Util.gI().nextInt(1, 10)));
                options.add(new ItemOption(14, Util.gI().nextInt(1, 10)));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 740:
                options.add(new ItemOption(50, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(77, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                options.add(new ItemOption(103, Util.gI().nextInt(3, Util.gI().nextInt(8, 10))));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 1158:
                options.add(new ItemOption(103, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 17)))));
                options.add(new ItemOption(94, Util.gI().nextInt(1, Util.gI().nextInt(3, 8))));
                options.add(new ItemOption(30, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1159:
                options.add(new ItemOption(77, Util.gI().nextInt(5, Util.gI().nextInt(8, Util.gI().nextInt(10, 17)))));
                options.add(new ItemOption(95, Util.gI().nextInt(1, Util.gI().nextInt(3, 10))));
                options.add(new ItemOption(30, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1160:
                options.add(new ItemOption(50, Util.gI().nextInt(8, Util.gI().nextInt(10, Util.gI().nextInt(12, 17)))));
                options.add(new ItemOption(14, Util.gI().nextInt(1, 10)));
                options.add(new ItemOption(30, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;

            case 1243:
                options.add(new ItemOption(103, Util.gI().nextInt(7, Util.gI().nextInt(10, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(203, Util.gI().nextInt(1, 5)));
                options.add(new ItemOption(30, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1244:
                options.add(new ItemOption(77, Util.gI().nextInt(7, Util.gI().nextInt(10, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(94, Util.gI().nextInt(1, Util.gI().nextInt(5, 8))));
                options.add(new ItemOption(30, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 919:
                options.add(new ItemOption(50, Util.gI().nextInt(7, Util.gI().nextInt(10, Util.gI().nextInt(12, 18)))));
                options.add(new ItemOption(95, Util.gI().nextInt(1, Util.gI().nextInt(5, 8))));
                options.add(new ItemOption(30, 1));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            // nlsk
            case 1237:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1238:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1239:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1240:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1241:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 1242:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 1245:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1246:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1247:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(93, 30));
                break;
            case 1248:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 1249:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 1250:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 1251:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 694:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 695:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 696:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 697:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 698:
                options.add(new ItemOption(174, 2023));
                options.add(new ItemOption(30, 1));
                options.add(new ItemOption(93, 30));
                break;
            case 1039:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(77, 5));
                options.add(new ItemOption(103, 5));
                options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(10, 15)));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;
            case 1040:
                options.add(new ItemOption(50, 5));
                options.add(new ItemOption(77, 5));
                options.add(new ItemOption(103, 5));
                options.add(new ItemOption(Util.gI().nextInt(188, 190), Util.gI().nextInt(10, 15)));
                if (status > 0) {
                    options.add(new ItemOption(93, status));
                }
                break;        
            case 1282:
                options.add(new ItemOption(30, 1));
                break; 
            case 1283:
                options.add(new ItemOption(30, 1));
                break;
            case 1284:
                options.add(new ItemOption(30, 1));
                break;
            case 1285:
                options.add(new ItemOption(30, 1));
                break;     
             case 992:
                options.add(new ItemOption(30, 1));
                break;
            // lech teamobi
            case 2000:
                options.add(new ItemOption(30, 1));
                break;
            case 2004:
                options.add(new ItemOption(30, 1));
                break;     
            case 2005:
                options.add(new ItemOption(30, 1));
                break;
            case 2006:
                options.add(new ItemOption(30, 1));
                break;
            case 2008:
                options.add(new ItemOption(30, 1));
                break;
            case 2009:
                options.add(new ItemOption(30, 1));
                break;   
                
//THE END HIEU
        }
        return options;
    }

}
