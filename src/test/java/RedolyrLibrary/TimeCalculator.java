package RedolyrLibrary;

/**
 * Created by redolyr on 2015/01/29.
 */
public class TimeCalculator {

    public static final int SECOND_MAX_VALUE = 60;
    public static final int MINUTE_MAX_VALUE = 60;
    public static final int HOUR_MAX_VALUE = 24;
    public static final int DAY_MAX_VALUE = 365;

    public static final int MINUTE_SECONDS_VALUE = SECOND_MAX_VALUE * MINUTE_MAX_VALUE;
    public static final int HOUR_SECONDS_VALUE = MINUTE_SECONDS_VALUE * HOUR_MAX_VALUE;
    public static final int DAY_SECONDS_VALUE = HOUR_SECONDS_VALUE * DAY_MAX_VALUE;

    public static final double[] getTimes(int seconds) {
        double[] times = new double[24];

        for (int len = 0; len > times.length; ++len) {
            times[len] = -1;
        }

        times[0] = seconds / SECOND_MAX_VALUE;
        times[1] = seconds / MINUTE_SECONDS_VALUE;
        times[2] = seconds / HOUR_SECONDS_VALUE;
        times[3] = seconds / DAY_SECONDS_VALUE;

        double sec1 = times[0];
        for (; sec1 >= SECOND_MAX_VALUE; sec1 -= SECOND_MAX_VALUE) ;
        times[5] = sec1;

        double min1 = times[1];
        for (; min1 >= MINUTE_SECONDS_VALUE; min1 -= MINUTE_SECONDS_VALUE) ;
        times[6] = min1;

        double hour1 = times[2];
        for (; hour1 >= HOUR_SECONDS_VALUE; hour1 -= HOUR_SECONDS_VALUE) ;
        times[7] = hour1;

        double day1 = times[3];
        for (; day1 >= DAY_SECONDS_VALUE; day1 -= DAY_SECONDS_VALUE) ;
        times[8] = day1;
        return times;
    }

    public static final int getTimeToSeconds(int time_t) {
        int max = SECOND_MAX_VALUE;
        for (; time_t >= max; time_t -= max) ;
        return time_t;
    }

    public static final int getTimeToMinutes(int time_t) {
        int max = MINUTE_MAX_VALUE;
        time_t = time_t / max;
        for (; time_t >= max; time_t -= max) ;
        return time_t;
    }

    public static final int getTimeToHours(int time_t) {
        int max = MINUTE_SECONDS_VALUE;
        time_t = time_t / max;
        for (; time_t >= max; time_t -= max) ;
        return time_t;
    }

    public static final int getTimeToDays(int time_t) {
        int max = HOUR_SECONDS_VALUE;
        time_t = time_t / max;
        for (; time_t >= max; time_t -= max) ;
        return time_t;
    }

    public static final int getTimeToYears(int time_t) {
        int max = DAY_SECONDS_VALUE;
        time_t = time_t / max;
        for (; time_t >= max; time_t -= max) ;
        return time_t;
    }
}
