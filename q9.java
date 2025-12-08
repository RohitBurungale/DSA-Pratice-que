// Given an array arr[] denoting heights of n towers and a positive integer k.

// For each tower, you must perform exactly one of the following operations exactly once.

// Increase the height of the tower by k
// Decrease the height of the tower by k
// Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.


import java.util.*;

class Solution {

    int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        Arrays.sort(arr);

        int ans = arr[n - 1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        for (int i = 1; i < n; i++) {
            int minHeight = Math.min(smallest, arr[i] - k);
            int maxHeight = Math.max(largest, arr[i - 1] + k);

            // Negative height is not allowed
            if (minHeight < 0) continue;

            ans = Math.min(ans, maxHeight - minHeight);
        }

        return ans;
    }
}
