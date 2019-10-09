public class Function {

    public static double solve(double x) {
        Math math = new Math();
        double result;
        if (x <= 0) {
            double t1 = math.tg(x) / math.tg(x);
            double t2 = math.ctg(x) - math.sin(x);
            double t3 = t1 - t2 - math.ctg(x);
            double t4 = t3 / math.sin(x);

            result = t4 + math.csc(x);
        } else {
            double t1 = math.log(5, x) / math.log(2, x);
            double t2 = t1 / math.log(3, x);
            double t3 = t2 + math.log(2, x);
            double t4 = t3 * math.log(5, x);

            double t5 = java.lang.Math.pow(math.log(3, x)/math.log(5, x), 3);
            double t6 = math.log(5, java.lang.Math.pow(x,2));
            double t7 = java.lang.Math.pow(t5/t6, 3);

            result = t4 * t7;
        }
        return result;
    }

}
