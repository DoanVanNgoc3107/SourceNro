package dragon.t;

import dragon.server.mResources;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;

/**
 * Class chứa các hàm tiện ích chung
 * 
 * @author Văn Tú
 */
public class Util {

    private static Util instance;

    public static Util gI() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public boolean debug = false;
    Locale locale = new Locale("vi", "VN");
    private final NumberFormat en = NumberFormat.getInstance(locale);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private final String digits = "0123456789"; // 0-9
    private final String specials = "~=+%^*/()[]{}/!@#$?|";
    private final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private final String ALL = alpha + alphaUpperCase + digits + specials;
    public static int UTC = +7;

    protected String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = nextInt(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    protected Date getDate(String dateString) {
        synchronized (dateFormat) {
            try {
                return dateFormat.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Error parse date: " + dateString);
            }
            return null;
        }
    }

    protected long TimeDay(int nDays) {
        return System.currentTimeMillis() + (nDays * 86400000L);
    }

    protected long TimeHours(int nHours) {
        return System.currentTimeMillis() + (+nHours * 3600000L);
    }

    protected long TimeMinutes(int nMinutes) {
        return System.currentTimeMillis() + (nMinutes * 60000L);
    }

    protected long TimeSeconds(long nSeconds) {
        return System.currentTimeMillis() + (nSeconds * 1000L);
    }

    protected long TimeMillis(long nMillis) {
        return System.currentTimeMillis() + nMillis;
    }

    protected Date DateDay(int nDays) {
        Date dat = new Date();
        dat.setTime(dat.getTime() + nDays * 86400000L);
        return dat;
    }

    protected String toDateString(Date date) {
        synchronized (dateFormat) {
            try {
                return dateFormat.format(date);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    protected Date DateHours(int nHours) {
        Date dat = new Date();
        dat.setTime(dat.getTime() + nHours * 3600000L);
        return dat;
    }

    protected Date DateMinutes(int nMinutes) {
        Date dat = new Date();
        dat.setTime(dat.getTime() + nMinutes * 60000L);
        return dat;
    }

    protected Date DateSeconds(long nSeconds) {
        Date dat = new Date();
        dat.setTime(dat.getTime() + nSeconds * 1000L);
        return dat;
    }

    public String getFormatNumber(long num) {
        return en.format(num);
    }

    protected boolean checkNumInt(String num) {
        return Pattern.compile("^[0-9]+$").matcher(num).find();
    }

    protected String parseString(String str, String wall) {
        return (!str.contains(wall)) ? null : str.substring(str.indexOf(wall) + 1);
    }

    public boolean CheckString(String str, String c) {
        return Pattern.compile(c).matcher(str).find();
    }

    public String stringSQL(String str) {
        return str.replaceAll("['\"\\\\]", "\\\\$0");
    }

    public String stringSQL_LIKE(String str) {
        return str.replaceAll("[%]", "\\\\$0");
    }

    public int nextInt(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return a + this.nextInt(Math.abs(b - a) + 1);
    }

    public int nextInt(int max) {
        return ThreadLocalRandom.current().nextInt(max);
    }

    public boolean trueOrFalse() {
        return Util.gI().nextInt(2) == 0;
    }

    public String getStrTime(long time) {
        if (time >= 86400000) {
            return (time / 86400000) + " ngày";
        } else if (time >= 3600000) {
            return (time / 3600000) + " giờ";
        } else if (time >= 60000) {
            return (time / 60000) + " phút";
        } else if (time >= 1000) {
            return (time / 1000) + " giây";
        } else {
            return "1 giây";
        }
    }

    public String getFormatTime2(long time) {
        if (time >= 86400000) {
            return (time / 86400000) + " n";
        } else if (time >= 3600000) {
            return (time / 3600000) + " g";
        } else if (time >= 60000) {
            return (time / 60000) + " p";
        } else if (time >= 1000) {
            return (time / 1000) + " s";
        } else {
            return "1 s";
        }
    }

    public String getStrNumber(long l) {
        if (l >= 1000000000) {
            return l / 1000000000 + " Tỉ";
        }
        if (l >= 1000000) {
            return l / 1000000 + " Tr";
        }
        if (l >= 1000) {
            return l / 1000 + " k";
        }
        return "" + l;
    }

    public String getFormatTime3(long l) {
        String str = "";
        int day = (int) (l / (1000 * 60 * 60 * 24));
        int hour = (int) ((l / (1000 * 60 * 60)) - ((l / (1000 * 60 * 60 * 24)) * 24));
        int muilte = (int) ((l / (1000 * 60)) - ((l / (1000 * 60 * 60)) * 60));
        int second = (int) ((l / 1000) - ((l / (1000 * 60)) * 60));
        int d = 0;
        if (day > 0) {
            str += day + "d";
        }
        if (hour > 0) {
            str += hour + "h";
        }
        if (day == 0 && muilte > 0) {
            str += muilte + "m";
        }
        if (day == 0 && hour == 0) {
            if (second < 1) {
                second = 1;
            }
            str += second + "s";
        }
        return str;
    }

    public String getFormatTime4(long l) {
        String str = "";
        int day = (int) (l / (1000 * 60 * 60 * 24));
        int hour = (int) ((l / (1000 * 60 * 60)) - ((l / (1000 * 60 * 60 * 24)) * 24));
        int muilte = (int) ((l / (1000 * 60)) - ((l / (1000 * 60 * 60)) * 60));
        int second = (int) ((l / 1000) - ((l / (1000 * 60)) * 60));
        int d = 0;
        if (day > 0) {
            if (!str.isEmpty()) {
                str += " ";
            }
            str += day + " ngày";
        }
        if (hour > 0) {
            if (!str.isEmpty()) {
                str += " ";
            }
            str += hour + " giờ";
        }
        if (day == 0 && muilte > 0) {
            if (!str.isEmpty()) {
                str += " ";
            }
            str += muilte + " phút";
        }
        if (day == 0 && hour == 0) {
            if (!str.isEmpty()) {
                str += " ";
            }
            str += second + " giây";
        }
        return str;
    }

    protected synchronized Calendar Calendar(long time) {
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTimeInMillis(time);
        return rightNow;
    }

    public void setDebug(boolean v) {
        this.debug = v;
    }

    public void log(String v) {
        if (this.debug) {
            System.out.print(v);
        }
    }

    public void logln(String v) {
        if (this.debug) {
            System.out.println(v);
        }
    }

    public String strHoursNow() {
        Calendar cal = Calendar.getInstance();
        if (cal.get(Calendar.MINUTE) < 10) {
            return String.format(mResources.HOURS_0, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
        } else {
            return String.format(mResources.HOURS, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
        }
    }

    public int getWeekGap(long v) {
        return (int) (Math.abs(((System.currentTimeMillis() + (3600000L * UTC) + 259200000) / 604800000)
                - ((v + (3600000L * UTC) + 259200000) / 604800000)));
    }

    public int getDayGap(long v) {
        return (int) (Math.abs(
                ((System.currentTimeMillis() + (3600000L * UTC)) / 86400000) - ((v + (3600000L * UTC)) / 86400000)));
    }

    public String numberTostring(long number) {
        String text = "" + number;
        boolean flag = false;
        try {
            String text2;
            if (number < 0L) {
                flag = true;
                number = -number;
                text = "" + number;
            }
            int length;
            if (number >= 1000000000L) {
                text2 = "Tỉ";
                number /= 1000000000L;
                length = ("" + number).length();
            } else if (number >= 1000000L) {
                text2 = "Tr";
                number /= 1000000L;
                length = ("" + number).length();
            } else if (number >= 1000L) {
                text2 = "k";
                number /= 1000L;
                length = ("" + number).length();
            } else {
                if (flag) {
                    return "-" + text;
                }
                return text;
            }
            int num = Integer.parseInt(text.substring(length, length + 2));
            if (num == 0) {
                text = text.substring(0, length) + text2;
            } else if (num % 10 == 0) {
                text = text.substring(0, length) + "," + text.substring(length, length + 1) + text2;
            } else {
                text = text.substring(0, length) + "," + text.substring(length, length + 2) + text2;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (flag) {
            return "-" + text;
        }
        return text;
    }

    public String nextString(String text, int num) {
        String str = "";
        for (int i = 0; i < num; i++) {
            int index = Util.gI().nextInt(text.length());
            str += text.substring(index, index + 1);
        }
        return str;
    }

    public long getTimeUCT() {
        return System.currentTimeMillis() + (3600000L * UTC);
    }

    public String convertTime(long time) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("HH'h'mm");
        String timeString = sdf.format(date);
        return timeString;
    }

    public String convertTime(long time, String format) {
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String timeString = sdf.format(date);
        return timeString;
    }

    public String timeToSecondstring(long time) {
        String text = "" + time;
        try {
            String text2 = " giây";
            time /= 1000L;
            int length = ("" + time).length();
            int num = Integer.parseInt(text.substring(length, length + 2));
            if (num == 0) {
                text = text.substring(0, length) + text2;
            } else if (num % 10 == 0) {
                text = text.substring(0, length) + "," + text.substring(length, length + 1) + text2;
            } else {
                text = text.substring(0, length) + "," + text.substring(length, length + 2) + text2;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }
}
