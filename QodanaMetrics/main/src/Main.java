import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int N = 26;
    static List<List<Integer>> vertices = new ArrayList<>();
    static List<Integer> topologicalAnswer = new ArrayList<>();
    static boolean[] used = new boolean[N];
    static boolean[] recursiveStack = new boolean[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> arl = new ArrayList<>();
            vertices.add(arl);
        }
        boolean impossibleMarker = false;
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        ArrayList<String> names = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            names.add(name);
        }
        in.close();
        for (int i = 0; i < names.size(); i++) {
            for (int j = i + 1; j < names.size(); j++) {
                boolean markAdd = false;
                for (int k = 0; k < Math.min(names.get(i).length(), names.get(j).length()); k++) {
                    if (names.get(i).charAt(k) != names.get(j).charAt(k)) {
                        vertices.get(names.get(i).charAt(k) - 'a').add(names.get(j).charAt(k) - 'a');
                        markAdd = true;
                        break;
                    }
                }
                if (names.get(i).length() > names.get(j).length() && !markAdd) {
                    impossibleMarker = true;
                    break;
                }
            }
            if (impossibleMarker) {
                System.out.println("Impossible");
                break;
            }
        }

        if (!impossibleMarker) {
            if (!checkCycle()) {
                for (int i = topologicalAnswer.size() - 1; i >= 0; i--) {
                    System.out.print((char) (topologicalAnswer.get(i) + 'a'));
                    System.out.print(" ");
                }
            } else {
                System.out.println("Impossible");
            }
        }

    }

    private static boolean checkCycle() {
        for (int i = 0; i < N; i++) {
            if (!used[i]){
                if(dfs(i)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i) {
        if (recursiveStack[i])
            return true;

        used[i] = true;
        recursiveStack[i] = true;

        for (int v : vertices.get(i)) {
            if (recursiveStack[v]){
                return true;
            }
            if (!used[v]) {
                if (dfs(v))
                    return true;
            }
        }
        topologicalAnswer.add(i);
        recursiveStack[i] = false;
        return false;
    }
}

