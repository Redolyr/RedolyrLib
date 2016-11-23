package SupplyPower;

/**
 * Created by redolyr on 2016/09/16.
 */
public class Time {

    public static final long[] maxDays = new long[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static long[] getDays(long var0) {
        long day = var0;
        int month = 0;
        long year = 0;
        while (day > maxDays[month]) {
            day -= maxDays[month];
            ++month;
            month %= 12;
        }
        if (month > 12) {
            int old = month;
            month = old % 12;
            year += (old - month) / 12;
        }
        return new long[] {year, month, day};
    }

    private static long[] getTimes(long seconds) {
        long sec = seconds % 60;
        long min = (seconds - sec) / 60 % 60;
        long hour = (seconds - min) / 3600 % 24;
        long days = (seconds - hour) / 86400 % 365;
        long year = (seconds - days) / 31536000;
        return new long[] {year, days, hour, min, sec};
    }

    public static long[] getDayTime(long seconds) {
        long[] times = getTimes(seconds);
        long[] days = getDays(times[1]);
        return new long[] {times[0] + days[0], days[1], days[2], times[2], times[3], times[4]};
    }

    public static long getYearToSec(long year) {
        return year * 31536000;
    }

    public static long getMonthToSec(long month) {
        long day = 0;
        for (int len = 0; len < month; ++len) {
            day += maxDays[len];
        }
        return getDaysToSec(day);
    }

    public static long getDaysToSec(long days) {
        return days * 86400;
    }

    public static long getHourToSec(long hour) {
        return hour * 3600;
    }

    public static long getMinToSec(long min) {
        return min * 60;
    }

    public static long getDaysToSec(long year, long month, long day) {
        return getYearToSec(year) + getMonthToSec(month) + getDaysToSec(day);
    }

    public static long getDaysToSec(long year, long days) {
        return getYearToSec(year) + getDaysToSec(days);
    }

    public static long getTimesToSec(long hour, long min, long sec) {
        return getHourToSec(hour) + getMinToSec(min) + sec;
    }

    public static long getDaysToSecMod(long year, long month, long day) {
        return getDaysToSec(year, month % 12, day % maxDays[(int) (month % 12)]);
    }

    public static long getDaysToSecMod(long year, long days) {
        return getDaysToSec(year, days % 365);
    }

    public static long getTimesToSecMod(long hour, long min, long sec) {
        return getTimesToSec(hour % 24, min % 60, sec % 60);
    }

    public static long getDayAndTimesToSec(long year, long month, long day, long hour, long min, long sec) {
        return getDaysToSec(year, month, day) + getTimesToSec(hour, min, sec);
    }

    public static long getDayAndTimesToSec(long year, long days, long hour, long min, long sec) {
        return getDaysToSec(year, days) + getTimesToSec(hour, min, sec);
    }

    public static long getDayAndTimesToSecMod(long year, long month, long day, long hour, long min, long sec) {
        return getDaysToSecMod(year, month, day) + getTimesToSecMod(hour, min, sec);
    }

    public static long getDayAndTimesToSecMod(long year, long days, long hour, long min, long sec) {
        return getDaysToSecMod(year, days) + getTimesToSecMod(hour, min, sec);
    }
}
