//You are given a circular array arr[] of integers,
//  find the maximum possible sum of a non-empty subarray. 
// In a circular array, the subarray can start at the end and
//  wrap around to the beginning. Return the maximum non-empty subarray sum,
// considering both non-wrapping and wrapping cases.

class Solution {

    public int maxCircularSum(int[] arr) {
        int n = arr.length;

        int total = 0;
        int currentMax = 0, maxSum = Integer.MIN_VALUE;
        int currentMin = 0, minSum = Integer.MAX_VALUE;

        for (int num : arr) {
            total += num;

            // Kadane for max sum subarray
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane for min sum subarray
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
        }

        // If all elements are negative, return the maximum (non-circular) subarray sum
        if (maxSum < 0) {
            return maxSum;
        }

        // Circular sum = total - minSubarraySum
        int circularMax = total - minSum;

        return Math.max(maxSum, circularMax);
    }
}