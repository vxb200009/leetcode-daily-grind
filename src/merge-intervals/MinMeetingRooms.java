
public class MinMeetingRooms {
    // prefix - sweeping algorithm
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
    int maxEnd = 0;

    for (int i = 0; i < intervals.length; i++) {
        maxEnd = Math.max(maxEnd, intervals[i][1]);
    }

    int[] arr = new int[maxEnd + 1];

    for (int i = 0; i < intervals.length; i++) {
        int start = intervals[i][0];
        int end = intervals[i][1];

        arr[start]++;   // room is occupied at `start`
        arr[end]--;     // room is freed at `end`
    }

    int roomsNeeded = 0;
    for (int i = 0; i < arr.length; i++) {
        roomsNeeded += arr[i];
        res = Math.max(res, roomsNeeded);
    }

    return res;
    }
}
