public class Main {
    public static void main(String[] args) throws Exception {
        new B().function1();
    }
}

class A {
    public void function1() {
        System.out.println("A");
        function2();
    }

    public void function2() {
        System.out.println("A");
    }
}

class B extends A {
    public void function1() {
        super.function1();
    }

    public void function21() {
        System.out.println("B");
    }
}
