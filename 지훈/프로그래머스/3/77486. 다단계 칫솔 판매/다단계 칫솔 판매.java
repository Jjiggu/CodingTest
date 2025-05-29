import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> maps = new HashMap<>();
        Map<String, Integer> revenue = new HashMap<>();
        int[] answer = new int[enroll.length];
        
        for (int i = 0; i < enroll.length; i++) {
            maps.put(enroll[i], referral[i]);
            revenue.put(enroll[i], revenue.getOrDefault(enroll[i], 0));
        }
        
        
        for (int i = 0; i < amount.length; i++) {
            String curr = seller[i];
            int sell = amount[i] * 100;
            
            while (!curr.equals("-") && sell > 0) {
                int ref = sell / 10;
                int keep = sell - ref;
                
                revenue.put(curr, revenue.get(curr) + keep);
                
                curr = maps.get(curr);
                sell = ref;
            }
        }
        
        
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = revenue.get(enroll[i]);
        }
        
        return answer;
    }
}