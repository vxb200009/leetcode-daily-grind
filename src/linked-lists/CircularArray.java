public class CircularArray {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = getNextIndex(nums, i);

            // Only proceed if both fast and slow are moving in same direction
            while (
                nums[slow] * nums[fast] > 0 &&
                nums[slow] * nums[getNextIndex(nums, fast)] > 0
            ) {
                if (slow == fast) {
                    // One-element loop check
                    if (slow == getNextIndex(nums, slow)) break;
                    return true;
                }

                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, getNextIndex(nums, fast));
            }

            // Mark all nodes visited in this path as 0
            int val = nums[i];
            int j = i;
            while (nums[j] * val > 0) {
                int tmp = getNextIndex(nums, j);
                nums[j] = 0;
                j = tmp;
            }
        }

        return false;
    }

    // Normalize next index with wrap-around and handle negatives
    private int getNextIndex(int[] nums, int i) {
        int n = nums.length;
        return ((i + nums[i]) % n + n) % n;
    }
}
