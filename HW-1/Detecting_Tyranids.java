import java.util.*;

public class Detecting_Tyranids {
    public static void main(String[] args) {
        int n,m,p,i,j,k;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        p = scanner.nextInt();
        long[] squad = new long[p];
        int mod = 998244353;

        for(int idx=0;idx<p;idx++){
            i = scanner.nextInt();
            j = scanner.nextInt();
            k = scanner.nextInt();

            long p1 = i % mod;
            long p2 = j % mod;
            long p3 = k % mod;
            long p4 = ((n+1)%mod - p1)%mod;
            long p5 = ((m+1)%mod - p2)%mod;

            long q1 = (p1*p2)%mod;
            long q2 = (q1*p3)%mod;
            long q3 = (q2*p4)%mod;
            long q4 = (q3*p5)%mod;

            squad[idx] = q4;
        }

        if(p==1)
            System.out.println(squad[0]);
        else{
            long sum = (squad[0]+squad[1])%mod;
            for(int idx = 2;idx<p;idx++){
                sum = (sum + squad[idx])%mod;
            }
            System.out.println(sum);
        }
    }
}