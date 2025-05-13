import java.util.ArrayList;
import java.util.List;

public class AnagramInString {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length()>s.length())
            return new ArrayList();
        
        int[] sarr = new int[26];
        int[] parr = new int[26];
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<p.length();i++){
            sarr[s.charAt(i)-'a']++;
            parr[p.charAt(i)-'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (sarr[i] == parr[i])
                count++;
        }

        if(count==26){
            res.add(0);
        }

        for(int i=0;i<s.length()-p.length();i++){
            int r = s.charAt(i+p.length()) - 'a', l = s.charAt(i) - 'a';
            sarr[r]++;
            if(sarr[r]==parr[r])
                count++;
            else if (sarr[r]==parr[r]+1)
                count--;
            sarr[l]--;
            if(sarr[l]==parr[l])
                count++;
            else if (sarr[l]==parr[l]-1)
                count--;

            if(count==26)
                res.add(i+1);
        }

        return res;
    }
}
