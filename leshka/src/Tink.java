import java.util.*;
import java.util.stream.Collectors;

public class Tink {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Map<Integer,Integer>> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int di = in.nextInt();
            int ci = in.nextInt();
            int si = in.nextInt();
            Map<Integer, Integer> tempMap = new HashMap<>();
            tempMap.put(di, ci);
            values.put(tempMap, si);
        }
    }
}
