import java.util.ArrayList;

public class Timur {
    public static void main(String[] args) {
        ArrayList<Integer> oddNumbers = new ArrayList<>(); // нечётные
        ArrayList<Integer> evenNumbers = new ArrayList<>(); //создане списка для чётных чисел
        for (String x : args) {
            int value = Integer.parseInt(x);
            if (value % 2 == 0) {
                evenNumbers.add(value);
            } else {
                oddNumbers.add(value);
            }
        }
        if (evenNumbers.size() > oddNumbers.size()) {
            System.out.println("Чётных чисeл больше");
        } else if (evenNumbers.size() == oddNumbers.size()) {
            System.out.println("Поровну");
        } else {
            System.out.println("Нечётных чисел больше");
        }
    }
}