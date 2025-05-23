import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnagramInString {

    public List<Integer> findAnagrams(String s, String p) {
        int ns = s.length(), np = p.length();
        if (ns < np) return new ArrayList();
    
        int [] pCount = new int[26];
        int [] sCount = new int[26];
        // build reference array using string p
        for (char ch : p.toCharArray()) {
          pCount[(int)(ch - 'a')]++;
        }
    
        List<Integer> output = new ArrayList();
        // sliding window on the string s
        for (int i = 0; i < ns; ++i) {
          // add one more letter 
          // on the right side of the window
          sCount[(int)(s.charAt(i) - 'a')]++;
          // remove one letter 
          // from the left side of the window
          if (i >= np) {
            sCount[(int)(s.charAt(i - np) - 'a')]--;
          }
          // compare array in the sliding window
          // with the reference array
          if (Arrays.equals(pCount, sCount)) {
            output.add(i - np + 1);
          }
        }
        return output;
      }

    // public List<Integer> findAnagrams(String s, String p) {
    //     if(p.length()>s.length())
    //         return new ArrayList();
        
    //     int[] sarr = new int[26];
    //     int[] parr = new int[26];
    //     List<Integer> res = new ArrayList<>();

    //     for(int i=0;i<p.length();i++){
    //         sarr[s.charAt(i)-'a']++;
    //         parr[p.charAt(i)-'a']++;
    //     }

    //     int count = 0;
    //     for (int i = 0; i < 26; i++) {
    //         if (sarr[i] == parr[i])
    //             count++;
    //     }

    //     if(count==26){
    //         res.add(0);
    //     }

    //     for(int i=0;i<s.length()-p.length();i++){
    //         int r = s.charAt(i+p.length()) - 'a', l = s.charAt(i) - 'a';
    //         sarr[r]++;
    //         if(sarr[r]==parr[r])
    //             count++;
    //         else if (sarr[r]==parr[r]+1)
    //             count--;
    //         sarr[l]--;
    //         if(sarr[l]==parr[l])
    //             count++;
    //         else if (sarr[l]==parr[l]-1)
    //             count--;

    //         if(count==26)
    //             res.add(i+1);
    //     }

    //     return res;
    // }
}
