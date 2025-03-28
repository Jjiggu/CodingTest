import java.util.*;

class Solution {
    /**
     * Processes an array of string operations to update a double-ended priority queue and retrieves its extreme values.
     * <p>
     * Each operation is a string where the first token is a command:
     * <code>'I'</code> to insert the provided integer into both a min-heap and a max-heap, or 
     * <code>'D'</code> to delete an element. For deletion, a parameter of <code>1</code> removes the maximum element,
     * while <code>-1</code> removes the minimum element. After processing all operations, if the queues are empty,
     * the method returns <code>{0, 0}</code>; otherwise, it returns an array with the maximum value as the first element
     * and the minimum value as the second.
     * </p>
     *
     * @param operations an array of operations represented as strings
     * @return an array of two integers containing the maximum and minimum values, or {0, 0} if the queues are empty
     * @throws Exception if an error occurs during operation processing
     */
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