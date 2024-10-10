import java.util.ArrayList;
import java.util.List;

class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        char[] str = new char[2 * n];
        ArrayList<String> arl = new ArrayList<>();
        if (n > 0)
            _printParenthesis(str, 0, n, 0, 0, arl);
        return arl;
    }

    public static void _printParenthesis(char[] str, int pos,
                                         int n, int open,
                                         int close, ArrayList<String> arl)
    {
        if (close == n) {
            arl.add(new String(str));
            return;
        }
        else {
            if (open > close) {
                str[pos] = ')';
                _printParenthesis(str, pos + 1, n, open,
                        close + 1, arl);
            }
            if (open < n) {
                str[pos] = '(';
                _printParenthesis(str, pos + 1, n, open + 1,
                        close, arl);
            }
        }
    }
}
