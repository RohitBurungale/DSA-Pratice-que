//You are given an integer array arr[]. 
// You need to find the maximum sum of a subarray (containing at least one element) in
//  the array arr[].
class Solution {

    public int maxSubarraySum(int[] arr) {
        int currentSum = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            // Either extend the current subarray or start a new one
            currentSum = Math.max(arr[i], currentSum + arr[i]);

            // Track the best seen so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}