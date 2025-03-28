import java.util.*;

class Solution {
    /**
     * Determines the number of wins for team B in a number game.
     *
     * <p>The game pits team A against team B by comparing scores from their respective arrays.
     * Team A's scores are processed in descending order using a priority queue, while team B's scores
     * are first sorted in ascending order and stored in a deque. For each highest score from team A,
     * if team B's highest available score exceeds it, team B wins that round and the winning score is removed.
     * Otherwise, team B discards its lowest score to minimize losses. The method returns the total win count for team B.</p>
     *
     * @param A an array of scores for team A
     * @param B an array of scores for team B
     * @return the total number of wins for team B
     */
    public int solution(int[] A, int[] B) {
    	
        // 점수 역순으로 pq에 넣는다.
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        
        for(int i : A) {
            pq.add(i);
        }
        
        // 점수순으로 정렬하여 Deque에 삽입
        Arrays.sort(B);
        ArrayDeque<Integer> dq = new ArrayDeque();
        
        for(int i : B) {
            dq.add(i);   
        }
        
        int answer = 0;
        
        while(!pq.isEmpty()){
            int target = pq.poll();
            // B팀의 최고 숫자가 A팀의 최고 숫자보다 높은 경우 승리
            if(target < dq.peekLast()){
                dq.pollLast();
                answer++;
            } else{ // 질때는 가장 작은 숫자를 내며 져야 한다.
                dq.pollFirst();
            }
        }
        
        return answer;
    }
}