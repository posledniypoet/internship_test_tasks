class MoveZeros {
    public void moveZeroes(int[] nums) {
        int countZeros = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countZeros++;
            } else{
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i = nums.length - countZeros; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}
