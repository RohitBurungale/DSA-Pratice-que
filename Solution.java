// Given an array of positive integers arr[], 
// return the second largest element from the array. I
// f the second largest element doesn't exist then return -1.

public class Solution {

    public static int getSecondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }

        int largest = -1;
        int second = -1;

        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num > second && num != largest) {
                second = num;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 4, 20, 5};
        System.out.println(getSecondLargest(arr)); // prints 10
    }
}
