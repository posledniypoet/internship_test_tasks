package qodana.code.metrics.engine.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Print the directory where files could be analyzed.");
        Scanner in = new Scanner(System.in);
        String dir = in.nextLine();
        new CodeAnalyzer(dir).checkFiles();
    }
}
