import java.util.*;

public class Find_the_winner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] sum_c = new int[n];
        int[] sum_r = new int[n];
        int k;
        for (int i =0;i<n;i++){
            for (int j = 0; j < n; j++) {
                k = scanner.nextInt();
                sum_r[i] += k;
                sum_c[j] += k;
            }
        }
        scanner.close();
        int winner_tag = winner_tag(sum_r,sum_c);
        System.out.println(winner_tag);
    }

    private static int winner_tag(int[] sum_r,int[] sum_c) {
        int n = sum_r.length;
        for (int i = 0; i < n; i++) {
            if(sum_c[i] == n-1 && sum_r[i] == 0){
                return i;
            }
        }
        return -1;
    }
}