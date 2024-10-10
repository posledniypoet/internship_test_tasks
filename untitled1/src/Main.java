import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int m = 3;
        List<Integer> price = new ArrayList<>();
        price.add(3);
        price.add(2);
        price.add(1);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                if(o1 < o2){
                    return -1;
                } else if( o1 ==o2){

                        return 0;


                } else {
                    return 1;
                }
            }
        });
        for(int i =0; i < price.size();i++){
            queue.add(price.get(i));
        }
        for(int i = 0; i < m;i++){
            Integer elem = queue.peek();
            elem = elem/2;
            queue.poll();
            queue.add(elem);
        }
        int sum = 0;
        for(int i =0; i < price.size();i++){
            sum+=queue.remove();
        }
        System.out.println(sum);
    }
}
