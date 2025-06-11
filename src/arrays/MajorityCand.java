class MajorityCand{
        // time complexity O(n) and space - O(1)

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;

        for(int num : nums){
            if(count==0)
                candidate=num;
            count+=(candidate==num)?1:-1;
        }

        return candidate;

    }
}