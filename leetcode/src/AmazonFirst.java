import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmazonFirst {

    public static int findMaximumBalancedShipments(List<Integer> weight) {
        int answer = 0;
        int currentMax = 0;
        boolean check  = false;
        for(int i = 0; i < weight.size(); i++){
            if(weight.get(i) > currentMax){
                currentMax = weight.get(i);
                check = false;
            } else {
                answer++;
                if(i < weight.size() - 1){
                    currentMax = weight.get(i + 1);
                }
                i++;
                check = true;
                if(i == weight.size() - 1){
                    answer++;
                }
            }
        }
        if(!check){
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arl= new ArrayList<>();
        int  n = in.nextInt();
        for ( int i =0; i < n; i++ ){
            int k  = in.nextInt();
            arl.add(k);
        }
        System.out.println(findMaximumBalancedShipments(arl));
    }


}
