import java.util.Scanner;

public class Fourth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt() - 1;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            fillDepth(arr, i, ans);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] - 1 + " ");
        }
    }

    public static void fillDepth(int[] parent, int i, int[] depth) {
        if (depth[i] != 0) {
            return;
        }

        if (parent[i] == -1) {
            depth[i] = 1;
            return;
        }

        if (depth[parent[i]] == 0) {
            fillDepth(parent, parent[i], depth);
        }

        depth[i] = depth[parent[i]] + 1;
    }
}