import java.util.*;

class Solution {
    public static Integer findMax(Queue<int[]> queue) {
        if (queue.isEmpty()) {
            return null;
        }

        int max = Integer.MIN_VALUE;

        for (int[] arr : queue) {
            if (arr[0] > max) { 
                max = arr[0];
            }
        }

        return max;
    }
    
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> prioritiesList = new ArrayList<Integer>();
        Queue<int[]> q = new LinkedList<>();
        
        
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[]{priorities[i], i});
        }
        
        
        while(!q.isEmpty()) {
            int[] current = q.remove();
            int currentPriority = current[0];
            int currentIndex = current[1];
            Integer maxNum = findMax(q);

            if (maxNum != null && currentPriority < maxNum) {
                q.add(current);
            } else {
                prioritiesList.add(currentPriority);
                answer++; 
                
                if (currentIndex == location) { 
                    return answer;
                }
                
            }
        }
        
        return answer;
    }
}