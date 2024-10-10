import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class Third {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Comparator<String> setOrder = Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).reversed();
        TreeSet<String> set = new TreeSet<>(setOrder);
        System.out.print(str.charAt(0) + " ");
        set.add(str.substring(0, 1));
        str = str.substring(1);
        while (!str.equals("")) {
            String pref = "";
            boolean count = false;
            for (String elem : set) {
                if (str.startsWith(elem)) {
                    pref = elem.intern();
                    count = true;
                    break;
                }
            }
            if (count) {
                if (str.length() > pref.length()) {
                    String x = pref + str.charAt(pref.length());
                    set.add(x.intern());
                    System.out.print(x + " ");
                    str = str.substring(pref.length() + 1);
                } else {
                    System.out.print(pref + " ");
                    str = str.substring(pref.length());
                }
            } else {
                System.out.print(str.charAt(0) + " ");
                String kek = str.substring(0, 1);
                set.add(kek.intern());
                str = str.substring(1);
            }
        }
    }
}
