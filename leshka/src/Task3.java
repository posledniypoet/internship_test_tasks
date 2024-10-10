import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String begin = str.substring(0, 10);
        int[] check = new int[10];
        int count_of = 0;
        char[] arr = begin.toCharArray();
        for (char ch : arr) {
            if (ch == '?') {
                count_of++;
            } else {
                check[Character.getNumericValue(ch)]++;
            }
        }
        int answer = 0;
        if (check(check, count_of)) {
            System.out.print("YES");
        } else {
            for (int i = 0; i < str.length() - 10; i++) {
                if (str.charAt(i) == '?') {
                    count_of--;
                } else {
                    check[Character.getNumericValue(str.charAt(i))]--;
                }
                if (str.charAt(i + 10) == '?') {
                    count_of++;
                } else {
                    check[Character.getNumericValue(str.charAt(i + 10))]++;
                }
                if (check(check, count_of)){
                    System.out.print("YES");
                    answer = 1;
                    break;
                }
            }
            if (answer == 0){
                System.out.print("NO");
            }
        }

    }

    public static boolean check(int[] check, int count_of) {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (check[i] == 1) {
                sum++;
            }
        }
        return sum + count_of == 10;
    }
}
