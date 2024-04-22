import java.util.*;

public class PigCup_Final {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum_A = 0;
        int sum_B = 0;

        String a = scanner.nextLine();
        scanner.close();

        char[] result = a.toCharArray();
        for (int i = 0; i < result.length; i++) {
            if(result[i] == 'B')
                sum_B++;
            else if(result[i] == 'A')
                sum_A++;
        }

        System.out.println("A:" + sum_A);
        System.out.println("B:" + sum_B);

        if(sum_A == sum_B){
            System.out.println("Draw!");
        }
        if(sum_A > sum_B){
            System.out.println("A wins!");
        }
        if(sum_A < sum_B){
            System.out.println("B wins!");
        }
    }

}