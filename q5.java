// Given an array of integers arr[] representing a permutation, 
// implement the next permutation that rearranges the numbers into 
// the lexicographically next greater permutation. If no such permutation exists, 
// rearrange the numbers into the lowest possible order
//  (i.e., sorted in ascending order). 
class Solution {

    void nextPermutation(int[] arr) {
        int n = arr.length;

        // Step 1: Find the first index from the right where arr[i] < arr[i+1]
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2: If such an index exists, find the next bigger element on the right and swap
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // Step 3: Reverse the remaining right part
        reverse(arr, i + 1, n - 1);
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
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