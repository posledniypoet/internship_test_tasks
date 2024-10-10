import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class YandexFirst {

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int n = in.nextInt();
        List<HashMap<Integer, Integer>> first = new ArrayList<>();
        List<HashMap<Integer, Integer>> second = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(i % 2 == 0){
                HashMap<Integer, Integer> tempMap = new HashMap<>();
                tempMap.put(x, y);
                first.add(tempMap);
            } else {
                HashMap<Integer, Integer> tempMap = new HashMap<>();
                tempMap.put(x, y);
                second.add(tempMap);
            }
        }
        for (HashMap<Integer, Integer> map : first){
            int count  = 0;
            for (int i = 0; i < 5; i++){
                HashMap<Integer, Integer> tempMap = new HashMap<>();
//                tempMap.put(map.)
//                if (first.contains())
            }
        }
    }
}
