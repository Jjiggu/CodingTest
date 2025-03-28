import java.util.*;

class Solution {
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