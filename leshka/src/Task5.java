
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        List<Integer> list = new java.util.ArrayList<>(List.of(arr));
        Collections.sort(list);
        int element = list.get(0);
        long sum = 0;

        for (int i = 1; i < element + 1; i++) {
            long localSum = 0L;
            for (int j = 1; j < list.size(); j++) {
                localSum += (long) (list.get(j) / i) * i;
            }
            localSum += i;
            if (localSum > sum) {
                sum = localSum;
            }
        }
        System.out.println(sum);
    }
}
