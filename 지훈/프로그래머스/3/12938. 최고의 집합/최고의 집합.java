import java.util.*;

public class Solution {
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
