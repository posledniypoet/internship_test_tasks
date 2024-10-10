import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {


    private final Deque<Integer> list;

    private final HashMap<Integer, Integer> map;

    private final int cacheSize;

    public LRUCache(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>();
        cacheSize = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int answer = map.get(key);
            list.remove(key);
            list.addFirst(key);
            return answer;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            list.remove(key);
            list.addFirst(key);
        } else {
            if (map.size() == cacheSize) {
                if (!list.isEmpty()) {
                    int elem = list.pollLast();
                    map.remove(elem);
                }
            }
            map.put(key, value);
            list.addFirst(key);
        }
    }
}
