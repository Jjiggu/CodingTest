import java.util.Arrays;

class Solution {
    public int solution(String t, String p) {
        int n = p.length();
        long pNum = Long.parseLong(p);
        int answer = 0;
        
        for(int i = 0; i < t.length()-n+1; i++){
            String temp = t.substring(i, i+n);
            if (Long.parseLong(temp) <= pNum){
                answer++;
            }
        }
        
        return answer;
    }
}