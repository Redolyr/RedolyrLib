package RedolyrLibrary;

/**
 * Created by redolyr on 2015/02/05.
 */
public class MathHelper1 {

    private static boolean isPLoad = true;

    private static double p;

    public static double p() {
        isPLoad = false;
        pLoad();
        return p;
    }

    private static void pLoad() {
        if (!isPLoad) {
            boolean isMinus = true;
            int asb = 1;

            double outP = 1;

            double a = 1.73205080757;//root 3
            double b = 2;//root 4
            double c = -2.245315E-12;
            double aa = a * b;
            double ab = aa + c;
            outP *= ab;

            double outP1 = outP;
            System.out.println(outP);

            for (int len = 1; len < 14; len += 2) {
                double lower = Double.parseDouble(len + ".3");
                double lowerOut = lower;
                if (asb < 0) lower *= asb;
                for (; asb < 0 && asb > 13;) {
                    lowerOut *= lower;
                }
                double upper = 1;
                double out = upper / lowerOut;

                System.out.println(outP + ", " + isMinus);

                isMinus = !isMinus;

                outP += isMinus ? -out : out;

                ++asb;
            }

            System.out.println(outP + ", " + outP1 + ", " + (outP - outP1) + ", " + (outP - (outP - outP1)));

            p = outP;
        }
    }

    static {
        if (!isPLoad) pLoad();
    }
}
