
import java.util.Objects;
import java.util.Scanner;
public class eralTask3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] modes = new int[n][k];
        for (int i = 0; i < n; i++) {
            int mode = scanner.nextInt() - 1;
            modes[i][mode] = 1;
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            boolean found = false;
            for (int j = 0; j < k; j++) {
                if (modes[a][j] == 1 && modes[b][j] == 1) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                result++;
                for (int j = 0; j < k; j++) {
                    if (modes[a][j] == 1 || modes[b][j] == 1) {
                        modes[a][j] = 1;
                        modes[b][j] = 1;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
