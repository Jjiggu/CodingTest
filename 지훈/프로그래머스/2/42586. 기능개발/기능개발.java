import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int[] prodDay = new int[progresses.length];
                
        for (int i = 0; i < progresses.length; i++) {
            int remaining = 100 - progresses[i];
            int day = remaining / speeds[i];
            if (remaining % speeds[i] != 0) {
                day += 1;
            }
            prodDay[i] = day;
        }
        
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = prodDay.length - 1; i >= 0; i--){
            stack.push(prodDay[i]);
        }
        
        while (!stack.isEmpty()) {
            int cnt = 1;
            int nowNum = stack.pop();
            
            // 다음 작업의 완료일과 비교
            while (!stack.isEmpty() && nowNum >= stack.peek()) {
                cnt++;
                stack.pop();
            }
            
            result.add(cnt);
        }
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
