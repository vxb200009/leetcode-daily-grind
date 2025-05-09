public class MinSubArraySizeSum {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left=0,right=0;
        int currentWindowSum = 0;
        for(right=0;right<nums.length;right++){
            currentWindowSum+=nums[right];
            while(currentWindowSum>=target){
                res = Math.min(res,right-left+1);
                currentWindowSum-=nums[left];
                left++;
            }
        }

        return res==Integer.MAX_VALUE?0:res;
    }
}
