import java.util.HashMap;

class SubarraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int prefixSum = 0;
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int currSum = prefixSum - k;
            if (map.containsKey(currSum)) {
                answer += map.get(currSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(subarraySum(arr, 2));
    }
}