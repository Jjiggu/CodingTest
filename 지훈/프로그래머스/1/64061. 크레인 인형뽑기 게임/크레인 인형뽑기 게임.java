import java.util.ArrayList;
import java.util.Stack;

public class Solution {

    public int solution(int[][] board, int[] moves) {
        ArrayList<Stack<Integer>> boardList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        
        for (int i = 0; i < board[0].length; i++) {
            boardList.add(new Stack<>());
        }
        
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 0) {
                    boardList.get(j).push(board[i][j]);
                }
            }
        }
        
        for (int move : moves) {
            int col = move - 1;
            
            if(!boardList.get(col).isEmpty()) {
                int doll = boardList.get(col).pop();
                
                if (!stack.isEmpty() && stack.peek() == doll) {
                    stack.pop();
                    result += 2;
                } else {
                    stack.push(doll);
                }
            } 
        }
        
        return result;
        
    }
}
