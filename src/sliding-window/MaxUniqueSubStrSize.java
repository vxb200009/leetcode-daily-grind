import java.util.HashMap;
import java.util.Map;

public class MaxUniqueSubStrSize {
    public int lengthOfLongestSubstring(String s) {
        int left=0,right;
        int res=0;
        Map<Character,Integer> map = new HashMap<>();

        for(right=0;right<s.length();right++){
            char rChar = s.charAt(right);
            map.put(rChar,map.getOrDefault(rChar,0)+1);
            while(map.get(rChar)>1){
                char lChar = s.charAt(left);
                map.put(lChar,map.get(lChar)-1);
                if(map.get(lChar)==0)
                    map.remove(lChar);
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
