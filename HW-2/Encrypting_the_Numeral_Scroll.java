import java.util.*;

public class Encrypting_the_Numeral_Scroll {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int m = scanner.nextInt();
        scanner.close();

        int n = input.length();
        if(m == n){
            System.out.println(0);
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int k = input.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek()>k && m>0){
                stack.removeFirst();
                m--;
            }
            stack.addFirst(k);
        }

        while (m > 0 && !stack.isEmpty()) {
            stack.removeFirst();
            m--;
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pollLast();
        }
        int index=0;
        for (int i = 0; i < result.length-1; i++) {
            if(result[i]!=0)
                break;
            else
                index++;
        }
        for (int i = index; i < result.length-1; i++) {
            System.out.print(result[i]);
        }
        System.out.print(result[result.length-1]);
    }

}