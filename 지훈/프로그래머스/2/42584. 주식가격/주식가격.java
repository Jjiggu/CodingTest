import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
        // prices 돌면서 현재 인덱스의 숫자보다 작은 숫자 만나면 그때 인덱스 - 기준 숫자 인덱스
        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                } else {
                    answer[i] = prices.length - (i + 1);
                }
            }
        }
        
        return answer;
    }
}