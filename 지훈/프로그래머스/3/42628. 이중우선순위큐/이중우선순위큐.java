import java.util.*;

class Solution {
    public int[] solution(String[] operations) throws Exception{
        
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            StringTokenizer st = new StringTokenizer(operation);
            char command = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            
            if (command == 'I') {
                minPq.add(num);
                maxPq.add(num);
            } else {
                if (!minPq.isEmpty() && !maxPq.isEmpty()) {
                    if (num == 1) {
                        int maxNum = maxPq.poll();
                        minPq.remove(maxNum);
                    } else {
                        int minNum = minPq.poll();
                        maxPq.remove(minNum);
                    }
                }
            }
        }
        
        if (minPq.isEmpty() && maxPq.isEmpty()) {
            return new int[] {0, 0};
        } 
        
        return new int[] {maxPq.poll(), minPq.poll()};
    }
}