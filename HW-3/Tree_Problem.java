import java.util.*;

public class Tree_Problem {

    public static int mod = 1000000007;
    public static int[] color;
    public static long[] result;
    public static List<List<int[]>> tree;
    public static long[] count;
    public static long[] sum_weight;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        color = new int[n+1];
        result = new long[n+1];
        tree = new ArrayList<>();

        tree.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            color[i] = scanner.nextInt();
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            tree.get(u).add(new int[]{v,w});
            tree.get(v).add(new int[]{u,w});
        }

        scanner.close();

        count = new long[n+1];
        sum_weight = new long[n+1];
        DFS_Child(1,0);
        DFS_Distance(1,0);

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
    }

    private static void DFS_Distance(int current, int father) {
        result[current] = sum_weight[current];
        for (int i = 0; i < tree.get(current).size(); i++) {
            int node = tree.get(current).get(i)[0];
            int distance = tree.get(current).get(i)[1];
            if(node != father){
                sum_weight[current] = ((sum_weight[current] - sum_weight[node] - count[node] * distance) % mod + mod) % mod;
                count[current] = count[current] - count[node];
                sum_weight[node] = ((sum_weight[node] + sum_weight[current] + count[current] * distance) % mod + mod) % mod;
                count[node] = count[node] + count[current];

                DFS_Distance(node, current);

                count[node] = count[node] - count[current];
                sum_weight[node] = ((sum_weight[node] - sum_weight[current] - count[current] * distance) % mod + mod) % mod;
                count[current] = count[current] + count[node];
                sum_weight[current] = ((sum_weight[current] + sum_weight[node] + count[node] * distance) % mod + mod) % mod;
            }
        }
    }

    private static void DFS_Child(int current, int father) {
        count[current] = color[current];
        for (int i = 0; i < tree.get(current).size(); i++) {
            int node = tree.get(current).get(i)[0];
            int distance = tree.get(current).get(i)[1];
            if(node != father){
                DFS_Child(node,current);
                count[current] = count[current] + count[node];
                sum_weight[current] = (sum_weight[current] + sum_weight[node] + distance * count[node]) % mod;
            }
        }
    }
}