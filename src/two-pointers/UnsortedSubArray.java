public class UnsortedSubArray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = -1, end = -2; // if already sorted, end - start + 1 = 0
        int min = nums[n - 1];
        int max = nums[0];
    
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] < max) {
                end = i;
            }
        }
    
        for (int i = n - 2; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min) {
                start = i;
            }
        }
    
        return end - start + 1;
    }
}
