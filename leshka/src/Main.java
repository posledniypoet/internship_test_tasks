import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        int[] arr = new int[n];
        boolean[] sign = new boolean[n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] splited = s.split(" ");
            arr[i] = Integer.parseInt(splited[0]);
            sign[i] = !Objects.equals(splited[1], "-");
        }
        int right_range = Integer.MAX_VALUE;
        int left_range = Integer.MIN_VALUE;
        if (!sign[n - 1]) {
            right_range = -1;
        } else {
            left_range = 0;
        }
        int sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            sum += arr[i + 1];
            if (!sign[i]) {
                if (right_range > sum) {
                    right_range = sum - 1;
                }
            } else {
                if (left_range < sum) {
                    left_range = sum;
                }
            }
        }
        if (right_range == Integer.MAX_VALUE) {
            System.out.print("inf");
        } else {
            System.out.print(right_range);
        }
    }
}