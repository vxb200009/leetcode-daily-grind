public class PosProdSubArrayLen {

    public int getMaxLen(int[] nums) {
        int maxLen = 0, pos = 0, neg = 0; // pos - > positive product sub array length & neg ->negatives product length till i
        for (int n : nums) {
            if (n == 0) { // reset
                pos = 0;
                neg = 0;
            } else if (n > 0) { // increment pos and increment neg if more than 0 because neg+pos ->neg
                pos += 1;
                neg = neg > 0 ? neg + 1 : 0;
            } else {        // if neg swap because for even neg pos will have the longest length
                int temp = pos;
                pos = neg > 0 ? neg + 1 : 0;
                neg = temp + 1;
            }
            if (pos > maxLen) maxLen = pos;
        }
        return maxLen;
    }

    // O(n) & O(1) -but slow than above
    // public int getMaxLen(int[] nums) {
    //     int lastZeroPos = -1, firstNegative=-1;
    //     int negativesInProd = 0;
    //     int res = 0;

    //     for(int i=0; i<nums.length; i++){
    //         if(nums[i]<0){   calculate negs in product
    //             negativesInProd++;
    //             if(firstNegative==-1)
    //                 firstNegative = i;
    //         }
            
    //         if(nums[i]==0){ // reset if encountered 0
    //             lastZeroPos = i;
    //             firstNegative=-1;
    //             negativesInProd = 0;
    //         }
    //         else{            // for every number other than zero check the negatives and accordingly calculate the length
    //             if(negativesInProd%2==0){
    //                 res= Math.max(i-lastZeroPos,res);
    //             }
    //             else{
    //                 res = Math.max(i-firstNegative,res);
    //             }
    //         }
    //     }
    //     return res;
    // }
    
}
