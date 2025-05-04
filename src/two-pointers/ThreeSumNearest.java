import java.util.Arrays;

public class ThreeSumNearest {

    // binary search
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n && diff!=0;i++){
           for(int j=i+1;j<n-1;j++){
            int compliment = target - nums[i] - nums[j];
            var idx = Arrays.binarySearch(nums,j+1,n-1,compliment);
            int hi = idx>=0?idx:~idx, lo = hi-1;
            if(lo>j && Math.abs(compliment-nums[lo])<Math.abs(diff))
                diff = compliment - nums[lo];
            if(hi<n && Math.abs(compliment-nums[hi])<Math.abs(diff))
                diff = compliment - nums[hi];
           }
        }
        return target-diff;
        
    }

    // // without binary search
    // public int threeSumClosest(int[] nums, int target) {
    //     int n = nums.length;
    //     int diff = Integer.MAX_VALUE;
    //     Arrays.sort(nums);
    //     for(int i=0;i<n && diff!=0;i++){
    //         int lo = i+1,hi = n-1;
    //         while(lo<hi){
    //             int sum = nums[i]+nums[lo]+nums[hi];
    //             if(Math.abs(target-sum)<Math.abs(diff)){
    //                 diff = target - sum;
    //             }
    //             if(sum>target)
    //                 hi--;
    //             else
    //                 lo++;
    //         }
    //     }
    //     return target-diff;
        
    // }
}
