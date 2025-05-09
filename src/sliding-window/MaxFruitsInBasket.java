import java.util.HashMap;
import java.util.Map;

public class MaxFruitsInBasket {

        // // Sliding Window I
        // public int totalFruit(int[] fruits) {
        //     // Hash map 'basket' to store the types of fruits.
        //     Map<Integer, Integer> basket = new HashMap<>();
        //     int left = 0, right;
            
        //     // Add fruit from right side (right) of the window.
        //     for (right = 0; right < fruits.length; ++right) {
        //         basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
                
        //         // If the current window has more than 2 types of fruit,
        //         // we remove one fruit from the left index (left) of the window.
        //         if (basket.size() > 2) {
        //             basket.put(fruits[left], basket.get(fruits[left]) - 1);
        //             if (basket.get(fruits[left]) == 0)
        //                 basket.remove(fruits[left]);
        //             left++;
        //         }
        //     }
            
        //     // Once we finish the iteration, the indexes left and right 
        //     // stands for the longest valid subarray we encountered.
        //     return right - left;
        // }
    

    // SLiding Window II
    public int totalFruit(int[] fruits) {
        int maxFruits=0;
        int res = 0;
        int left=0,right=0;
        Map<Integer,Integer> map = new HashMap<>();

        for(right=0;right<fruits.length;right++){
            int fruitType = fruits[right];
            map.put(fruitType, map.getOrDefault(fruitType,0)+1);
            maxFruits++;
            while(map.size()>2){
                map.put(fruits[left],map.get(fruits[left])-1);
                if(map.get(fruits[left])==0){
                    map.remove(fruits[left]);
                }
                left++;
                maxFruits--;
            }

            res = Math.max(res,maxFruits);

        }
        return res;
    }
}
