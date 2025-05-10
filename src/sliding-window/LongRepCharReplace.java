public class LongRepCharReplace {

    // SLiding window Fast
    public int characterReplacement(String s, int k) {
        int start=0,end=0;
        int[] frequencyMap = new int[26];
        int maxFrequency = 0;
        int longestSubstringLength = 0;

        for(end=0;end<s.length();end++){
            int currentChar = s.charAt(end)-'A';

            frequencyMap[currentChar]+=1;

            maxFrequency = Math.max(maxFrequency,frequencyMap[currentChar]);

            Boolean isValid = (end+1-start-maxFrequency<=k);

            if(!isValid){
                int outGoingChar = s.charAt(start)-'A';
                frequencyMap[outGoingChar]-=1;
                start+=1;
            }

            longestSubstringLength = end+1-start;

        }

        return longestSubstringLength;
        
    }
}
