import java.util.*;

class Solution {
    /**
     * Reduces the highest workloads over a given number of hours and computes the resulting fatigue index.
     * <p>
     * This method uses a max-heap to repeatedly decrement the largest work value (if greater than zero) for
     * a total of <code>n</code> hours. After reducing the workloads, it calculates the fatigue index as the sum
     * of the squares of the remaining workload values.
     * </p>
     *
     * @param n     the total number of hours available to reduce the workloads
     * @param works an array of integers representing the initial workloads for each task
     * @return the fatigue index after processing the workloads for <code>n</code> hours
     */
    public long solution(int n, int[] works) {
        
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            pq.offer(work);
        }

        while (n > 0) {
            int num = pq.poll();
            
            pq.offer(num > 0 ? num - 1 : num);
            n--;
        }

        for (int num : pq) {
            answer += Math.pow(num, 2);
        }

        return answer;
        
    }
}