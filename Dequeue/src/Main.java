import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public class Dequeue {

        private int size;

        private Integer left_node;

        private Integer right_node;

        private int[] array;

        private int capacity = 0;


        Dequeue(int size) {
            this.size = size;
            this.array = new int[size];
            this.left_node = null;
            this.right_node = null;
            this.capacity = 0;
        }

        public void push_back(int value) {
            if (left_node == null && right_node == null) {
                left_node = 0;
                right_node = 0;
                array[0] = value;
            } else {
                right_node = right_node + 1;
                array[right_node] = value;
            }
        }
    }
}