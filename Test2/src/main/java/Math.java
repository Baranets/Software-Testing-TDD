import sun.lwawt.macosx.CPrinterDevice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Math {

    public double sin(double value, int delta) {
        double result = 0.0;
        double pi = java.lang.Math.PI;
        value = value % (2 * pi);

        for (int i = 0; i < delta; i++) {
            try {
                long factorial = factorial(2*i+1);
                result += java.lang.Math.pow(-1.0, i) * java.lang.Math.pow(value, 2*i+1) / factorial;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return result;
    }

    public double sin(double value) {
        return sin(value, 12);
    }

    public double cos(double value) {
        double sinX = sin(value);
        double sinSquareX = java.lang.Math.pow(sinX, 2);
        double pi = java.lang.Math.PI;

        int n = 0;
        while (n < 1000) {
            double step = 2*pi*n;
            if (value >= -pi/2 + step && value <= pi/2 + step) {
                return java.lang.Math.sqrt(1 - sinSquareX);
            } else if (value >= pi/2 + step && value <= 3*pi/2 + step) {
                return -java.lang.Math.sqrt(1 - sinSquareX);
            }
            n++;
        }
        return  0.0;
    }

    public double tg(double value) {
        double sinX = round(sin(value),4);
        double cosX = round(cos(value),4);
        return sinX/cosX;
    }

    public double ctg(double value) {
        double sinX = round(sin(value),4);
        double cosX = round(cos(value),4);
        return cosX/sinX;
    }

    public double csc(double value) {
        double sinX = round(sin(value), 5);
        return 1 / sinX;
    }


//    public double ln(double x, int delta) {
//        double result = 0.0;
//        double pi = java.lang.Math.PI;
//
//        x = x % (2 * pi);
//        for (int i = 1; i < delta; i++) {
//            try {
//                result += java.lang.Math.pow(-1.0, i-1) * java.lang.Math.pow(x - 1, i) / i;
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
//        return result;
//    }

    public double log(double a, double x) {
        if (a < 0) {
            throw new IllegalArgumentException();
        }
        double lnX = java.lang.Math.log(x);
        double lnA = java.lang.Math.log(a);
        return lnX/lnA;
    }

    public long factorial(int value) throws Exception {
        if (value < 0) { throw new Exception(); }

        long result = 1;
        if (value > 0) {
            for (int i = 2; i <= value; i++) {
                result *= i;
            }
        }
        return result;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
