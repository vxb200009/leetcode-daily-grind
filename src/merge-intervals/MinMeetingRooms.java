import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Sort meetings by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to track the earliest ending meeting
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int[] interval : intervals) {
            // If the room is free (the current meeting starts after or at the end of the earliest meeting)
            if (!heap.isEmpty() && interval[0] >= heap.peek()) {
                heap.poll(); // reuse the room
            }
            heap.offer(interval[1]); // add end time to the heap
        }

        // Size of heap tells us how many rooms are in use at peak
        return heap.size();
    }


    // another two pointer approach
    // public int minMeetingRooms(int[][] intervals) {
       
    //     int[] start = new int[intervals.length];
    //     int[] end = new int[intervals.length];
 
    //     for(int i=0;i<intervals.length;i++){
    //      start[i]=intervals[i][0];
    //      end[i]=intervals[i][1];
    //     } 
 
    //     Arrays.sort(start);//0,5,15
    //     Arrays.sort(end);//10,20,30
 
    //     int rooms=0, endPtr=0;
 
    //     for(int i=0;i<intervals.length;i++){
    //      if(start[i]<end[endPtr]){
    //          rooms++;
    //      } else{
    //          endPtr++;
    //      }
    //     }
 
    //      return rooms;
    //  }

    // prefix - sweeping algorithm
    // public int minMeetingRooms(int[][] intervals) {
    //     int res = 0;
    // int maxEnd = 0;

    // for (int i = 0; i < intervals.length; i++) {
    //     maxEnd = Math.max(maxEnd, intervals[i][1]);
    // }

    // int[] arr = new int[maxEnd + 1];

    // for (int i = 0; i < intervals.length; i++) {
    //     int start = intervals[i][0];
    //     int end = intervals[i][1];

    //     arr[start]++;   // room is occupied at `start`
    //     arr[end]--;     // room is freed at `end`
    // }

    // int roomsNeeded = 0;
    // for (int i = 0; i < arr.length; i++) {
    //     roomsNeeded += arr[i];
    //     res = Math.max(res, roomsNeeded);
    // }

    // return res;
    // }
}
