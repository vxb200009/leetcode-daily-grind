class UnwantedDuplicates{
    // time complexity O(n) and space - O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 1; // Pointer to iterate through the array
        int j = 1; // Pointer to track position for valid elements
        int count = 1; // Count of occurrences of the current element

        while (i < nums.length) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    i++;
                    continue;
                }
            }else{
                count=1;
            }
            nums[j]=nums[i];
            i++;
            j++;
        }
        return j;
    }
}