public class LongRepCharReplace {

    // Sliding window faster with while
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
        maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }

    // // SLiding window Fast
    // public int characterReplacement(String s, int k) {
    //     int start=0,end=0;
    //     int[] frequencyMap = new int[26];
    //     int maxFrequency = 0;
    //     int longestSubstringLength = 0;

    //     for(end=0;end<s.length();end++){
    //         int currentChar = s.charAt(end)-'A';

    //         frequencyMap[currentChar]+=1;

    //         maxFrequency = Math.max(maxFrequency,frequencyMap[currentChar]);

    //         Boolean isValid = (end+1-start-maxFrequency<=k);

    //         if(!isValid){
    //             int outGoingChar = s.charAt(start)-'A';
    //             frequencyMap[outGoingChar]-=1;
    //             start+=1;
    //         }

    //         longestSubstringLength = end+1-start;

    //     }

    //     return longestSubstringLength;
        
    // }
}
