//Given an array arr[]. 
// Rotate the array to the left (counter-clockwise direction) by d steps,
//  where d is a positive integer. Do the mentioned change in the array in place.
class Solution {

    void rotateArr(int[] arr, int d) {
        int n = arr.length;
        d = d % n; // handle cases when d >= n

        // Step 1: reverse first d elements
        reverse(arr, 0, d - 1);

        // Step 2: reverse rest of the array
        reverse(arr, d, n - 1);

        // Step 3: reverse whole array
        reverse(arr, 0, n - 1);
    }

    void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}


