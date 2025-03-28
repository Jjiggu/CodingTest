class Solution {
    public long solution(int n, int[] times) {
    
        long left = 1;
        long right = 1_000_000_000L * 100_000L;
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long total = 0;
            
            for (int time : times) {
                total += mid / time;
            }
            
            if (total >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
            
        }
        
        return answer;
    }
}