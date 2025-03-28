import java.util.*;

public class Solution {
    /**
     * Returns an array of n integers that sum to s with the integers distributed as evenly as possible.
     *
     * <p>If s is not evenly divisible by n, the remainder is distributed by incrementing the last elements of the array.
     * If n is greater than s, indicating that no valid set of positive integers exists, the method returns an array containing -1.
     *
     * @param n the number of elements in the resulting array
     * @param s the target sum of the array elements
     * @return an array of n integers summing up to s, or an array containing -1 if no valid set exists
     */
    public int[] solution(int n, int s) {
        if (n > s) return new int[] {-1}; 

        int[] answer = new int[n];
        int quotient = s / n;
        int remainder = s % n;

        Arrays.fill(answer, quotient);

        for (int i = 0; i < remainder; i++) {
            answer[n - i - 1] += 1;
        }

        return answer;
    }
}
