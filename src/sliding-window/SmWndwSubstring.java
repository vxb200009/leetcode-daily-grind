import java.util.HashMap;

public class SmWndwSubstring {
     // space is O(1) only one hashMap
     public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int l=0,r=0;
        String res="";
        int cnt=0;
        int min_Len=Integer.MAX_VALUE;
        int startIndex=-1;
        HashMap<Character,Integer> h1=new HashMap<>();
        for(int i=0;i<m;i++){
            h1.put(t.charAt(i),h1.getOrDefault(t.charAt(i),0)+1);
        }
        while(r<n){
            char ch=s.charAt(r);
            if(h1.containsKey(ch)&& h1.get(ch)>0){
                cnt++;
            }
            h1.put(ch,h1.getOrDefault(ch,0)-1);
            while(cnt==m){
                if((r-l+1)<min_Len){
                    min_Len=r-l+1;
                    startIndex=l;
                    }
                
                h1.put(s.charAt(l),h1.getOrDefault(s.charAt(l),0)+1);
                if(h1.get(s.charAt(l))>0){
                    cnt--;
                }
                l++;
            }
            r++;
        }
         return startIndex==-1?"":s.substring(startIndex,startIndex+min_Len);
    }
   

    // space isO(s+t)
    // public String minWindow(String s, String t) {
    //     if (s.length() == 0 || t.length() == 0) {
    //         return "";
    //     }

    //     Map<Character, Integer> dictT = new HashMap<Character, Integer>();

    //     for (int i = 0; i < t.length(); i++) {
    //         int count = dictT.getOrDefault(t.charAt(i), 0);
    //         dictT.put(t.charAt(i), count + 1);
    //     }

    //     int required = dictT.size();

    //     // Filter all the characters from s into a new list along with their index.
    //     // The filtering criteria is that the character should be present in t.
    //     List<Pair<Integer, Character>> filteredS = new ArrayList<
    //         Pair<Integer, Character>
    //     >();
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         if (dictT.containsKey(c)) {
    //             filteredS.add(new Pair<Integer, Character>(i, c));
    //         }
    //     }

    //     int l = 0, r = 0, formed = 0;
    //     Map<Character, Integer> windowCounts = new HashMap<
    //         Character,
    //         Integer
    //     >();
    //     int[] ans = { -1, 0, 0 };

    //     // Look for the characters only in the filtered list instead of entire s.
    //     // This helps to reduce our search.
    //     // Hence, we follow the sliding window approach on as small list.
    //     while (r < filteredS.size()) {
    //         char c = filteredS.get(r).getValue();
    //         int count = windowCounts.getOrDefault(c, 0);
    //         windowCounts.put(c, count + 1);

    //         if (
    //             dictT.containsKey(c) &&
    //             windowCounts.get(c).intValue() == dictT.get(c).intValue()
    //         ) {
    //             formed++;
    //         }

    //         // Try and contract the window till the point where it ceases to be 'desirable'.
    //         while (l <= r && formed == required) {
    //             c = filteredS.get(l).getValue();

    //             // Save the smallest window until now.
    //             int end = filteredS.get(r).getKey();
    //             int start = filteredS.get(l).getKey();
    //             if (ans[0] == -1 || end - start + 1 < ans[0]) {
    //                 ans[0] = end - start + 1;
    //                 ans[1] = start;
    //                 ans[2] = end;
    //             }

    //             windowCounts.put(c, windowCounts.get(c) - 1);
    //             if (
    //                 dictT.containsKey(c) &&
    //                 windowCounts.get(c).intValue() < dictT.get(c).intValue()
    //             ) {
    //                 formed--;
    //             }
    //             l++;
    //         }
    //         r++;
    //     }
    //     return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    // }
}
