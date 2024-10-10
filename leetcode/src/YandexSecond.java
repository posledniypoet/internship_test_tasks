import java.util.Arrays;
import java.util.Scanner;

public class YandexSecond {

    public static int[] minCostFish(int N, int K, int[] prices) {
        int[] minCost = new int[N + 1];
        int[] priceArray = new int[N + 1];
        System.arraycopy(prices, 0, priceArray, 1, prices.length);
        for (int i = 1; i < minCost.length; i++) {
            minCost[i] = Integer.MAX_VALUE;
            priceArray[i] = priceArray[i-1] + priceArray[i];
        }
        minCost[1] = priceArray[1];

        for (int i = 1; i <= N; i++) {
            for (int j = Math.max(1, i - K); j < i; j++) {
                    minCost[i] = Math.min(minCost[i], minCost[i - j] + priceArray[j] * (i - j));
            }
        }

        int[] fishCount = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= Math.min(i, K); j++) {
                if (minCost[i] == minCost[i - j] + priceArray[j]) {
                    fishCount[i] = j;
                    break;
                }
            }
        }

        return fishCount;
    }

    public static void main(String[] args) {
        int N = 3; // Общее количество дней
        int K = 2; // Максимальное количество дней, на которое можно хранить рыбу
        int[] prices = {3, 1, 2}; // Цены на рыбу на каждый из N дней

        int[] fishCount = minCostFish(N, K, prices);
        System.out.println("Количество рыбы для каждого дня: " + (Arrays.toString(fishCount)));
    }
}
