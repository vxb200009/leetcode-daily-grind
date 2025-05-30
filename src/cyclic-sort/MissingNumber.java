class MissingNumber{

    // using sum of n natural numbers formula
     public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length+1)/2;
        int actualSum = 0;
        for(int num:nums) actualSum+=num;

        return expectedSum -actualSum;
        
    }
    // // add in hashSet and check till length end in order whether present in the set
    //  public int missingNumber(int[] nums) {
    //     Set<Integer> numSet = new HashSet<Integer>();
    //     for (int num : nums) numSet.add(num);

    //     int expectedNumCount = nums.length + 1;
    //     for (int number = 0; number < expectedNumCount; number++) {
    //         if (!numSet.contains(number)) {
    //             return number;
    //         }
    //     }
    //     return -1;
    // }
    // // sort and find the missing easy but not efficient
    //  public int missingNumber(int[] nums) {
    //     Arrays.sort(nums);

    //     // Ensure that n is at the last index
    //     if (nums[nums.length-1] != nums.length) {
    //         return nums.length;
    //     }
    //     // Ensure that 0 is at the first index
    //     else if (nums[0] != 0) {
    //         return 0;
    //     }

    //     // If we get here, then the missing number is on the range (0, n)
    //     for (int i = 1; i < nums.length; i++) {
    //         int expectedNum = nums[i-1] + 1;
    //         if (nums[i] != expectedNum) {
    //             return expectedNum;
    //         }
    //     }

    //     // Array was not missing any numbers
    //     return -1;
    // }
}