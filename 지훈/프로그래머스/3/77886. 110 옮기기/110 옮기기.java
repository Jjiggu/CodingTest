import java.util.*;

class Solution {
    
    static class Result {
        String removedString;
        int cnt;
        
        Result(String removedString, int cnt) {
            this.removedString = removedString;
            this.cnt = cnt;
        }
    }
    
    public String[] solution(String[] s) {
        
        String[] answer = new String[s.length];
        
        for (int i = 0; i < s.length; i++) {
            Result result = remove110(s[i]);
            answer[i] = insert110(result.removedString, result.cnt);
        }
        
        return answer;
    }
    
    
    public Result remove110(String str) {
        
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
            
            if (stack.size() < 3) continue;
            
            char third = stack.pop();
            char second = stack.pop();
            char first = stack.pop();

            if (first == '1' && second == '1' && third == '0') {
                cnt++;
            } else {
                stack.push(first);
                stack.push(second);
                stack.push(third);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (char ch : stack) {
            sb.append(ch);
        }
        
        return new Result(sb.toString(), cnt);
    }
    
    
    public String insert110(String str, int cnt) {
        
        StringBuilder sb110 = new StringBuilder();
        
        for (int i = 0; i < cnt; i++) {
            sb110.append("110");
        }
        
        int insertIdx = str.lastIndexOf('0');
        
        StringBuilder result = new StringBuilder();

        if (insertIdx == -1) {
            result.append(sb110).append(str);
        } else {
            result.append(str.substring(0, insertIdx + 1));
            result.append(sb110);
            result.append(str.substring(insertIdx + 1));
        }
        
        return result.toString();
    }
}