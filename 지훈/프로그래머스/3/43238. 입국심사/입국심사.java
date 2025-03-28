class Solution {
    /**
     * Computes the minimum time required to process a given number of tasks using the available processing times.
     * <p>
     * This method employs a binary search algorithm to determine the earliest time at which the cumulative number
     * of tasks processed by all officers (each with their own processing time) meets or exceeds the target count.
     * </p>
     *
     * @param n the total number of tasks to be processed
     * @param times an array where each element represents the processing time for an officer
     * @return the minimum time required to process all tasks
     */
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