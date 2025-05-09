import java.util.HashMap;
import java.util.Map;

public class MaxFruitsInBasket {

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
