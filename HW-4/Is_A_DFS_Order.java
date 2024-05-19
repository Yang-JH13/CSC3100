import java.util.*;

public class Is_A_DFS_Order {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] sequence = new int[N];
            List<Integer>[] tree = new LinkedList[N+1];
            for (int j = 1; j <= N; j++) {
                tree[j] = new LinkedList<>();
            }
            for (int j = 2; j < N+1; j++) {
                int father = scanner.nextInt();
                tree[father].add(j);
            }
            for (int j = 0; j < N; j++) {
                sequence[j] = scanner.nextInt();
            }
            is_dfs_order(tree,sequence);
        }
        scanner.close();
    }

    private static void is_dfs_order(List<Integer>[] tree, int[] sequence) {
        reorder_tree(tree, sequence);
        boolean result = stimulate_dfs(tree,sequence);
        if(result)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private static boolean stimulate_dfs(List<Integer>[] tree, int[] sequence) {
        int num = sequence.length;
        boolean[] check = new boolean[num+1];
        check[1] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        for (int i = 1; i < num; i++) {
            if(check[sequence[i]])
                return false;
            else{
                check[sequence[i]] = true;
                while (!stack.isEmpty() && NotContain(tree,stack.peek(),sequence[i]))
                    stack.pop();
                if(stack.isEmpty())
                    return false;
                stack.push(sequence[i]);
            }
        }
        return true;
    }

    private static boolean NotContain(List<Integer>[] tree, int i, int target) {
        for (int j = 0; j < tree[i].size(); j++) {
            if(tree[i].get(j) == target)
                return false;
        }
        return true;
    }

    private static void reorder_tree(List<Integer>[] tree, int[] sequence) {
        int[] order = new int[sequence.length+1];
        for (int i = 0; i < sequence.length; i++) {
            order[sequence[i]] = i;
        }
        for (int i = 1; i < sequence.length+1; i++) {
            Collections.sort(tree[i], new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return order[o1] - order[o2];
                }
            });
        }
    }
}