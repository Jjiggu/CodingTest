import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] prev = new int[n];
        int[] next = new int[n];
        boolean[] isDeleted = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        
        next[n - 1] = -1;
        
        int finalCursor = processCommands(cmd, k, prev, next, isDeleted, stack);

        return buildResult(isDeleted);
    }
    
    private int processCommands(String[] cmd, int cursor, int[] prev, int[] next, boolean[] isDeleted, Stack<Integer> stack) {
        
        for (String c : cmd) {
            char command = c.charAt(0);
            
            if (command == 'U') {
                int x = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < x; i++) cursor = prev[cursor];
            } else if (command == 'D') {
                int x = Integer.parseInt(c.split(" ")[1]);
                for (int i = 0; i < x; i++) cursor = next[cursor];
            } else if (command == 'C') {
                stack.push(cursor);
                isDeleted[cursor] = true;

                if (prev[cursor] != -1) next[prev[cursor]] = next[cursor];
                if (next[cursor] != -1) prev[next[cursor]] = prev[cursor];

                cursor = (next[cursor] != -1) ? next[cursor] : prev[cursor];
            } else if (command == 'Z') {
                int restore = stack.pop();
                isDeleted[restore] = false;

                if (prev[restore] != -1) next[prev[restore]] = restore;
                if (next[restore] != -1) prev[next[restore]] = restore;
            }
        }
        
        return cursor;
    }
    
    private String buildResult(boolean[] isDeleted) {
        StringBuilder sb = new StringBuilder();
        
        for (boolean deleted : isDeleted) {
            sb.append(deleted ? 'X' : 'O');
        }
        
        return sb.toString();
    }
}