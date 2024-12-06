import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < arr.length; i++) {
            int now_num = arr[i];
            
            if (stack.size() != 0 && stack.peek() != now_num) {
                stack.push(now_num);
            } else if (stack.size() == 0) {
                stack.push(arr[i]);
            }
        }
        
        int[] result = new int[stack.size()];
        
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        
        
        return result;
        
    }
}