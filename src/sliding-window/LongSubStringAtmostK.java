import java.util.HashMap;
import java.util.Map;

public class LongSubStringAtmostK {



    // sliding window I
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int res = Integer.MIN_VALUE;
        int left=0,right=0;
        Map<Character,Integer> map = new HashMap<>();

        for(right=0;right<s.length();right++){
            char ch = s.charAt(right);
        map.put(ch, map.getOrDefault(ch, 0) + 1);

        while (map.size() > k) {
            char leftChar = s.charAt(left);
            map.put(leftChar, map.get(leftChar) - 1);
            if (map.get(leftChar) == 0) {
                map.remove(leftChar);
            }
            left++;
        }

        res = Math.max(res, right - left + 1);
        }
        
        return res==Integer.MIN_VALUE?0:res;
    }
}
