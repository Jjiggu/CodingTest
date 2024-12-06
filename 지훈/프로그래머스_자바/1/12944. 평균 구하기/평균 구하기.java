import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        double avg = 0;
        
        for (int num : arr) {
            avg += num;
        }      
        
        return avg / arr.length;
    }
}