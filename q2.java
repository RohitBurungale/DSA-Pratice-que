// You are given an array arr[] of non-negative integers.
//  You have to move all the zeros in the array to the right end while maintaining the
//   relative order of the non-zero elements. The operation must be performed in place,
//    meaning you should not use extra space for another array

class Solution {

    void pushZerosToEnd(int[] arr) {
        int index = 0;

        // Move all non-zero values forward
        for (int num : arr) {
            if (num != 0) {
                arr[index] = num;
                index++;
            }
        }

        // Fill the remaining positions with zeros
        while (index < arr.length) {
            arr[index] = 0;
            index++;
        }
    }
}