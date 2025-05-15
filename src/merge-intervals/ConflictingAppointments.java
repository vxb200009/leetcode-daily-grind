
public class ConflictingAppointments {
    // only for less maxEnd value case
    static boolean isIntersect(int[][] intervals) {
        int n = intervals.length;
        
        // find the maximum end time 
        int maxEnd = 0;
        for (int i = 0; i < n; i++) {
            maxEnd = Math.max(maxEnd, intervals[i][1]);
        }
        
        // create an array of size maxEnd
        // and initialize it with 0
        int[] arr = new int[maxEnd + 2];
        
        // iterate over all intervals
        for (int i = 0; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            // increment the start time
            arr[start] += 1;
            
            // decrement the end time
            arr[end + 1] -= 1;
        }
        
        // iterate over the array and
        // calculate the prefix sum
        for (int i = 1; i <= maxEnd; i++) {
            arr[i] += arr[i - 1];
            
            // if the prefix sum is greater than 1
            // then the intervals intersect
            if (arr[i] > 1)
                return true;
        }
        
        return false;
    }
}
