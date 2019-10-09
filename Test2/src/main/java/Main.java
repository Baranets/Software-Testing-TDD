import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static double a;

    public static void main(String[] args) {
        Module[] modules = Module.values();
        for (int i = 0; i < modules.length; i++) {
            System.out.println(i + ". " + modules[i].toString());
        }

        int option;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                option = sc.nextInt();
                if (option >= 0 && option < 7) {
                    break;
                }
            } catch (Exception e) {
                continue;
            }
        }



        System.out.println("Step: ");
        double step = scanValue();
        if (option == 5) {
            System.out.println("a: ");
            a = scanValue();
        }
        System.out.println("x: ");
        double value = scanValue();
        System.out.println(step + " " + value);
        writeToFile(modules[option], step, value);

    }

    public static double scanValue() {
        double value;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                value = sc.nextDouble();
                return value;
            } catch (Exception e) {
                continue;
            }
        }
    }

    public static boolean writeToFile(Module module,double step, double value) {
        CSVManager manager = new CSVManager("/Users/max/Desktop/" + step + ", Результаты модуля (" + module + ").csv");
        List<List<String>> rows = new ArrayList<>();
        if (step > 0) {
            for (double i = value; i < value + step * 100; i += step) {
                List<String> row = createRow(module, i);
                rows.add(row);
            }
        } else if (step < 0) {
            for (double i = value; i > value + step * 100; i += step) {
                List<String> row = createRow(module, i);
                rows.add(row);
            }
        } else {
            return false;
        }

        try {
            manager.createFile();
            return manager.writeLines(rows);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return false;
    }

    public static List<String> createRow(Module module,double x) {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(x));
        double result = solve(module,x);
        list.add(String.valueOf(result));
        return list;
    }

    public static double solve(Module module, double x) {
        Math math = new Math();
        switch (module) {
            case sin:
                return math.sin(x);
            case cos:
                return math.cos(x);
            case tg:
                return math.tg(x);
            case ctg:
                return math.ctg(x);
            case csc:
                return math.csc(x);
            case log:
                if (a == -0) {
                    a = 2;
                }
                return math.log(a, x);
            case func:
                return Function.solve(x);
            default:
                return 0.0;
        }
    }

}

enum Module {
    sin,
    cos,
    tg,
    ctg,
    csc,
    log,
    func
}
