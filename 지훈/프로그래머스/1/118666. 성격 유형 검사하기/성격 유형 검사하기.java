import java.util.Map;
import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> score = new HashMap<>();
        
        score.put("R", 0);
        score.put("T", 0);
        score.put("C", 0);
        score.put("F", 0);
        score.put("J", 0);
        score.put("M", 0);
        score.put("A", 0);
        score.put("N", 0);
        
        for (int i = 0; i < survey.length; i++) {
            String mbti = survey[i];
            int num = choices[i];
            
            if (num > 4) {
                String key = String.valueOf(mbti.charAt(1));
                score.put(key, score.get(key) + (num % 4));
            }
            
            if (num < 4) {
                String key = String.valueOf(mbti.charAt(0));
                score.put(key, score.get(key) + (4 - num));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(score.get("R") >= score.get("T") ? "R" : "T");
        sb.append(score.get("C") >= score.get("F") ? "C" : "F");
        sb.append(score.get("J") >= score.get("M") ? "J" : "M");
        sb.append(score.get("A") >= score.get("N") ? "A" : "N");
        
        String answer = sb.toString();
        
        return answer;
    }
}