import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> answers = new ArrayList<>();
        int leftValue = -1;
        int rightValue = -1;
        if(nums.length == 0){
            return answers;
        }
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                leftValue = nums[i];
                rightValue = nums[i];
            } else{
                if(nums[i] - nums[i - 1] == 1){
                    rightValue = nums[i];
                } else{
                    if(rightValue == leftValue){
                        answers.add(String.valueOf(rightValue));
                    } else{
                        answers.add(leftValue + "->" + rightValue);
                    }
                    leftValue = nums[i];
                    rightValue = nums[i];
                }
            }
        }
        if(rightValue == leftValue){
            answers.add(String.valueOf(rightValue));
        } else{
            answers.add(leftValue + "->" + rightValue);
        }
        return answers;
    }
}
