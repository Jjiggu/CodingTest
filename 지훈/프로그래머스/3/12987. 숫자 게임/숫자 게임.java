import java.util.*;

class Solution {
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