import java.util.*;

public class Gift {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int W = scanner.nextInt();
        int[][] mat = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int ipt = scanner.nextInt();
                int input = Math.min(ipt,W);
                if(ipt == 0)
                    input = W;
                mat[i][j] = input;
            }
        }
        int total_cost = W + min_cost(mat);
        System.out.println(total_cost);
    }

    public static int min_cost(int[][] mat) {
        int res = 0;
        int num = mat.length;
        int[] clo_dis = new int[num];
        int[] clo_ver = new int[num];
        boolean[] visited = new boolean[num];
        visited[0] = true;
        for (int i = 1; i < num; i++) {
            clo_dis[i] = mat[0][i];
            clo_ver[i] = 0;
        }
        for (int i = 1; i < num; i++) {
            int min_edge = 1001;
            int vertex = 0;
            for (int j = 1; j < num; j++) {
                if(clo_dis[j] < min_edge && !visited[j]){
                    vertex = j;
                    min_edge = clo_dis[j];
                }
            }
            for (int j = 1; j < num; j++) {
                if(!visited[j]){
                    clo_dis[j] = Math.min(mat[j][vertex],clo_dis[j]);
                    clo_ver[j] = vertex;
                }
            }
            res = res + min_edge;
            visited[vertex] = true;
        }
        return res;
    }
}