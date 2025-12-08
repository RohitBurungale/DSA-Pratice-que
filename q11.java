//Given an array arr[] that contains positive and negative integers 
// (may contain 0 as well). Find the maximum product that we can get in a subarray of arr[].

//Note: It is guaranteed that the answer fits in a 32-bit integer.
class Solution {

    public int maxProduct(int[] arr) {
        int n = arr.length;

        int maxProd = arr[0];
        int minProd = arr[0];
        int result = arr[0];

        for (int i = 1; i < n; i++) {
            int val = arr[i];

            // When val is negative, swap max and min
            if (val < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update max and min products
            maxProd = Math.max(val, maxProd * val);
            minProd = Math.min(val, minProd * val);

            // Update global result
            result = Math.max(result, maxProd);
        }

        return result;
    }
}