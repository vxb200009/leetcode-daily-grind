
public class SubArrayProdK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)
        return 0;
        int left=0;
        int res=0;
        int productOfWindow = 1;
        for(int right=0; right<nums.length;right++){
            productOfWindow *= nums[right];

            while (productOfWindow >= k ) {
                productOfWindow /= nums[left++];
            }

            res += right - left + 1;
        }
        return res;
    }
}
