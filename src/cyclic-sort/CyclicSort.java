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
}