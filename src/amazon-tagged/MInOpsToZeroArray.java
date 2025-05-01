import java.util.HashSet;
import java.util.Set;

public class MInOpsToZeroArray {


    public int minimumOperations(int[] nums) {
        Set<Integer> res = new HashSet<>();

        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0 && !res.contains(nums[i]))
            res.add(nums[i]);
        }

        return res.size();
    }

    // // faster due to int[] usage for replicating set
    // public int minimumOperations(int[] nums) {
    //     boolean[] a = new boolean[101];
    //     int count = 0;
    //     for (int num: nums) {
    //         if(!a[num]) {
    //             a[num]  = true;
    //             count++;
    //         }
    //     }
    //     return a[0] ? count - 1 : count;
    // }
    
}
