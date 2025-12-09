//You are given an integer array arr[].
//  Your task is to find the smallest positive number missing from the array.

//Note: Positive number starts from 1. The array can have negative integers too.

class Solution {

    public int missingNumber(int[] arr) {
        int n = arr.length;

        // Step 1: Place each positive number x (1 ≤ x ≤ n) at index x-1
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[i] != arr[arr[i] - 1]) {
                int correctIndex = arr[i] - 1;

                // swap arr[i] with arr[correctIndex]
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        // Step 2: first index i where arr[i] != i+1 → missing number is i+1
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: if all positions are correct, missing number is n+1
        return n + 1;
    }
}