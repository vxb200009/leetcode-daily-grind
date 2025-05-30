class FirstMissingPositive{
    // with non constant space
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[n+1];

        for(int i=0;i<n;i++){
            if(nums[i]>0 && nums[i]<=n){
                seen[nums[i]] = true;
            }
        }

        for(int i=1;i<seen.length;i++){
            if(!seen[i])
                return i;
        }

        return n+1;
    }
}