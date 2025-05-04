import java.util.ArrayList;
import java.util.List;

public class GoodDaysToRob {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        List<Integer> res = new ArrayList<>();

        if (time == 0) {
            for (int i = 0; i < n; i++) res.add(i);
            return res;
        }

        if (n < 2 * time + 1) return res;

        int[] nonInc = new int[n];
        int[] nonDec = new int[n];

        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                nonInc[i] = nonInc[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                nonDec[i] = nonDec[i + 1] + 1;
            }
        }

        for (int i = time; i < n - time; i++) {
            if (nonInc[i] >= time && nonDec[i] >= time) {
                res.add(i);
            }
        }

        return res;
    }

    // // O(n) and O(n) space
    // public List<Integer> goodDaysToRobBank(int[] security, int time) {
    //     int n = security.length;
    //     int[] pre = new int[n];  // non-increasing counts
    //     int[] suf = new int[n];  // non-decreasing counts
    //     List<Integer> result = new ArrayList<>();

    //     // Build prefix: pre[i] = non-increasing streak up to i
    //     pre[0] = 1;
    //     for (int i = 1; i < n; i++) {
    //         if (security[i] <= security[i - 1])
    //             pre[i] = pre[i - 1] + 1;
    //         else
    //             pre[i] = 1;
    //     }

    //     // Build suffix: suf[i] = non-decreasing streak from i
    //     suf[n - 1] = 1;
    //     for (int i = n - 2; i >= 0; i--) {
    //         if (security[i] <= security[i + 1])
    //             suf[i] = suf[i + 1] + 1;
    //         else
    //             suf[i] = 1;
    //     }

    //     // Check for valid days
    //     for (int i = 0; i < n; i++) {
    //         if (pre[i] - 1 >= time && suf[i] - 1 >= time) {
    //             result.add(i);
    //         }
    //     }

    //     return result;
    // }
}
