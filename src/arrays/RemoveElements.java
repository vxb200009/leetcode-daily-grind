class RemoveElements{

    // time complexity O(n) and space - O(1)
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length-1;

        while(i<=j){
            if(nums[i]==val){
                nums[i]=nums[j];
                nums[j--]=-1;
            }
            else{
                i++;
            }
        }
        return i;
    }
}