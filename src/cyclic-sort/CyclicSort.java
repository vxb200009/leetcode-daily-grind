class CyclicSort{

    // cyclic sort
    static void sortArr(int[] arr) {
        int n = arr.length;
      
        for (int i = 0; i < n; i++) {
            int originalVal = arr[i] % (n + 1);
            int correctIdx = originalVal - 1;
            arr[correctIdx] += originalVal * (n + 1);
        }

        for (int i = 0; i < n; i++)
            arr[i] = arr[i] / (n + 1);
    }

// Example of the approach    
 // arr = {2, 1, 5, 4, 3}
// n = 5 → n+1 = 6
// After first loop:
// 	•	arr = {2, 1, 5, 4, 3}
// 	•	Let’s go through one element:
// arr[0] = 2 → originalVal = 2, correctIdx = 1
// → Add 2 * 6 = 12 to arr[1], so arr[1] = 13
}