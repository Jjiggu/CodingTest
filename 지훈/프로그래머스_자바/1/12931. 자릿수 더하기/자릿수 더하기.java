import java.util.*;

public class Solution {
    public int solution(int n) {
        String [] list = String.valueOf(n).split("");
        int sum = 0;
        
        for (String num:list) {
            sum += Integer.parseInt(num);    
        }
        
        return sum;
    }
}