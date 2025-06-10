class MergeArrays{

    // time complexity O(m+n) space O(m+n)
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     // Make a copy of the first m elements of nums1.
    //     int[] nums1Copy = new int[m];
    //     for (int i = 0; i < m; i++) {
    //         nums1Copy[i] = nums1[i];
    //     }

    //     // Read pointers for nums1Copy and nums2 respectively.
    //     int p1 = 0;
    //     int p2 = 0;

    //     // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
    //     for (int p = 0; p < m + n; p++) {
    //         // We also need to ensure that p1 and p2 aren't over the boundaries
    //         // of their respective arrays.
    //         if (p2 >= n || (p1 < m && nums1Copy[p1] < nums2[p2])) {
    //             nums1[p] = nums1Copy[p1++];
    //         } else {
    //             nums1[p] = nums2[p2++];
    //         }
    //     }
    // }

    // time complexity O(m+n) space O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set p1 and p2 to point to the end of their respective arrays.
        int p1 = m - 1;
        int p2 = n - 1;

        // And move p backward through the array, each time writing
        // the largest value pointed at by p1 or p2.
        for (int p = m + n - 1; p >= 0; p--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1--];
            } else {
                nums1[p] = nums2[p2--];
            }
        }
    }
}