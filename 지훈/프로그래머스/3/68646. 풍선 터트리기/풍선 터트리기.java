import java.util.*;

class Solution {
    public int solution(int[] a) {
        int n = a.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        
        leftMin[0] = a[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], a[i]);
        }
        
        rightMin[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], a[i]);
        }
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 | i == n - 1) {
                cnt++;
            } else {
                if (a[i] < leftMin[i - 1] || a[i] < rightMin[i + 1]) {
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}