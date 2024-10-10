public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        String input = "))((";
        System.out.println(minRemoveToMakeValid(input));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        int countDeleted = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
            } else {
                if (s.charAt(i) == ')') {
                    count--;
                    if (count < 0) {
                        count++;
                        sb.deleteCharAt(i - countDeleted);
                        countDeleted++;
                    }
                }
                if (s.charAt(i) == '(') {
                    count++;
                }
            }
        }
        String str = sb.toString();
        StringBuilder answer = new StringBuilder(str);
        if (count > 0) {
            for (int i = str.length() - 1; i >= 0; i--) {
                if (count == 0) {
                    break;
                }
                if (str.charAt(i) == '(') {
                    answer.deleteCharAt(i);
                    count--;
                }
            }
        }
        return sb.toString();
    }
}
