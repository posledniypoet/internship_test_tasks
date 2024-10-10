import java.util.HashSet;
import java.util.Iterator;

public class LineReflection {
    public boolean isReflected(double[][] points) {
        double firstY = points[0][1];
        double firstX = points[0][0];
        double secondX = Integer.MIN_VALUE;
        int found = 0;
        HashSet<Double> hashSet = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            hashSet.add(points[i][0]);
            if (points[i][1] == firstY) {
                secondX = points[i][0];
                found = 1;
            }
        }
        if (found == 1) {
            double lineX = (firstX + secondX) / 2;
            for (int i = 0; i < points.length; i++) {
                if(!hashSet.contains(2*lineX - points[i][0])){
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}