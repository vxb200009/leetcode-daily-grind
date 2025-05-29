class AllMissingNumbers{

    // in-place solution
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int newIndex = Math.abs(nums[i]) - 1;

            if(nums[newIndex]>0){
                nums[newIndex]*=-1;
            } 
        }

        List<Integer> result = new ArrayList<>();

        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0){
                result.add(i);
            }
        }

        return result;
    }

    // using extra space faster and you can use set as well
    // public List<Integer> findDisappearedNumbers(int[] nums) {
        
    //     // Hash table for keeping track of the numbers in the array
    //     // Note that we can also use a set here since we are not 
    //     // really concerned with the frequency of numbers.
    //     HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();
        
    //     // Add each of the numbers to the hash table
    //     for (int i = 0; i < nums.length; i++) {
    //         hashTable.put(nums[i], true);
    //     }
        
    //     // Response array that would contain the missing numbers
    //     List<Integer> result = new LinkedList<Integer>();
        
    //     // Iterate over the numbers from 1 to N and add all those
    //     // that don't appear in the hash table. 
    //     for (int i = 1; i <= nums.length; i++) {
    //         if (!hashTable.containsKey(i)) {
    //             result.add(i);
    //         }
    //     }
        
    //     return result;
    // }
}