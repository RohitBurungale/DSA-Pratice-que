//Given an array arr[] consisting of n integers, the task is to find all 
//the array elements which occurs more than floor(n/3) times.
import java.util.*;

class Solution {

    public List<Integer> findMajority(int[] arr) {
        int n = arr.length;
        if (n == 0) return new ArrayList<>();

        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;

        // 1) Find potential candidates
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // 2) Verify actual counts
        count1 = 0;
        count2 = 0;
        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Ensure ascending order for judge comparison
        Collections.sort(result);
        return result;
    }
}