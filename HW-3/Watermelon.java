import java.util.*;

public class Watermelon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r1,r2,d;
        double result;

        for (int i = 0; i < n; i++) {
            r1 = scanner.nextInt();
            r2 = scanner.nextInt();
            d = scanner.nextInt();

            result = max_r2d(r1, r2, d);

            System.out.println(result);
        }

        scanner.close();
    }

    private static double max_r2d(int r1, int r2, int d) {
        int r11 = r1 * r1 * r1;
        int d1 = r1 - d;
        int d11 = d1 * d1 * d1;
        int r12 = r2 * r2 * r2;

        double in_r1 = r12-(r11-d11);
        double result = r2 - Math.pow(in_r1, 1.0/3.0);

        return result;
    }
}