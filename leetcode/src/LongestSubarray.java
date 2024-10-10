class LongestSubarray {
    public int longestSubarray(int[] nums) {
        int leftIndex = 0;
        int rightIndex = 0;
        int maxSum = 0;
        int countZeros = 0;
        while(rightIndex < nums.length){
            if(nums[rightIndex] == 0){
                countZeros++;
            }
            while(countZeros > 1){
                if(nums[leftIndex] == 0){
                    countZeros--;
                }
                leftIndex++;
            }
            maxSum = Math.max(rightIndex - leftIndex, maxSum);
            rightIndex++;
        }
        return maxSum;
    }
}