import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagIterator {

    Queue<Integer> queue;
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        for(int i = 0; i < Math.min(v1.size(), v2.size()); i++){
            queue.add(v1.get(i));
            queue.add(v2.get(i));
        }
        if(v1.size() == v2.size()){
            return;
        }
        if(v1.size() > v2.size()){
            for(int i = v2.size(); i < v1.size(); i++){
                queue.add(v1.get(i));
            }
        }
        if(v2.size() > v1.size()){
            for(int i = v1.size(); i < v2.size(); i++){
                queue.add(v2.get(i));
            }
        }
    }

    public int next() {
        return queue.remove();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        List<Integer> v1 = new ArrayList<Integer>();
        List<Integer> v2 = new ArrayList<Integer>();
        v1.add(1);
        v1.add(2);
        v2.add(3);
        v2.add(4);
        v2.add(5);
        v2.add(6);
        ZigZagIterator i = new ZigZagIterator(v1, v2);
        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
