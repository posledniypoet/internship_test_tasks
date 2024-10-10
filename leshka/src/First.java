import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        for (int i = 1; i <= n; i++) {
            String ans = str.substring(0, i);
            if (check(str, ans)) {
                System.out.print(ans.length());
                break;
            }
        }
    }

    private static boolean check(String str, String ans) {
        char[] str_array = str.toCharArray();
        char[] ans_array = ans.toCharArray();
        for (int i = 0; i < str_array.length; i++) {
            if (ans_array[i % ans.length()] == '#' && str_array[i] != '#') {
                ans_array[i % ans.length()] = str_array[i];
                continue;
            }
            if (str_array[i] != ans_array[i % ans_array.length] && str_array[i] != '#') {
                return false;
            }
        }
        return true;
    }
}
