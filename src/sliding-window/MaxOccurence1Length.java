public class MaxOccurence1Length {
    public int longestOnes(int[] nums, int k) {
        int start=0;
        int maxCount=0,maxLength=0;
        for(int end=0;end<nums.length;end++){
           if(nums[end]==0){
            maxCount++;
           }

           while(maxCount>k){
            if(nums[start]==0){
                maxCount--;
            }
            start++;
           }
           maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }
}
