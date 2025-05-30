import java.util.HashMap;
import java.util.Map;

public class MaxUniqueSubStrSize {

    // same as below but faster
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
             int maxLength = 0;
             int[] lastIndex = new int[128];
             
             for (int start = 0, end = 0; end < n; end++) {
                 char currentChar = s.charAt(end);
                 start = Math.max(start, lastIndex[currentChar]);
                 maxLength = Math.max(maxLength, end - start + 1);
                 lastIndex[currentChar] = end + 1;
             }
             
             return maxLength;
         }

    // // stores the index and starts the left from the duplicate+1 index
    // public int lengthOfLongestSubstring(String s) {
    //     int left=0,right;
    //     int res=0;
    //     Map<Character,Integer> map = new HashMap<>();

    //     for(right=0;right<s.length();right++){
    //         char rChar = s.charAt(right);
    //         if(map.containsKey(rChar)){
    //             left = Math.max(map.get(rChar)+1,left);
    //         }
    //         map.put(rChar,right);
    //         res = Math.max(res,right-left+1);
    //     }
    //     return res;
    // }

    // iterates through till it finds the duplicate
    // public int lengthOfLongestSubstring(String s) {
    //     int left=0,right;
    //     int res=0;
    //     Map<Character,Integer> map = new HashMap<>();

    //     for(right=0;right<s.length();right++){
    //         char rChar = s.charAt(right);
    //         map.put(rChar,map.getOrDefault(rChar,0)+1);
    //         while(map.get(rChar)>1){
    //             char lChar = s.charAt(left);
    //             map.put(lChar,map.get(lChar)-1);
    //             if(map.get(lChar)==0)
    //                 map.remove(lChar);
    //             left++;
    //         }
    //         res = Math.max(res,right-left+1);
    //     }
    //     return res;
    // }
}
