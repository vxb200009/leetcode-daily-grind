import java.util.HashMap;
import java.util.Map;

public class LongSubStringAtmostK {

    // SLiding Window II learn this
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int maxSize = 0;
        Map<Character, Integer> counter = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
            
            if (counter.size() <= k) {
                maxSize++;
            } else {
                counter.put(s.charAt(right - maxSize), counter.get(s.charAt(right - maxSize)) - 1);
                if (counter.get(s.charAt(right - maxSize)) == 0) {
                    counter.remove(s.charAt(right - maxSize));
                }
            }
        }

        return maxSize; 
    }


    // // sliding window I
    // public int lengthOfLongestSubstringKDistinct(String s, int k) {
    //     int res = Integer.MIN_VALUE;
    //     int left=0,right=0;
    //     Map<Character,Integer> map = new HashMap<>();

    //     for(right=0;right<s.length();right++){
    //         char ch = s.charAt(right);
    //     map.put(ch, map.getOrDefault(ch, 0) + 1);

    //     while (map.size() > k) {
    //         char leftChar = s.charAt(left);
    //         map.put(leftChar, map.get(leftChar) - 1);
    //         if (map.get(leftChar) == 0) {
    //             map.remove(leftChar);
    //         }
    //         left++;
    //     }

    //     res = Math.max(res, right - left + 1);
    //     }
        
    //     return res==Integer.MIN_VALUE?0:res;
    // }
}
