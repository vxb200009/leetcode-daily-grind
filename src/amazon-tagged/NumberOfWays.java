public class NumberOfWays {
    public long numberOfWays(String s) {
        long count0 = 0, count1 = 0;
        long count01 = 0, count10 = 0;
        long result = 0;
    
        for (char c : s.toCharArray()) {
            if (c == '0') {
                result+=count01;
                count0++;
                count10 += count1; // for "101"
            } else {
                result+=count10;
                count1++;
                count01 += count0; // for "010"
            }
        }
    
        return result;
    }
    
}
