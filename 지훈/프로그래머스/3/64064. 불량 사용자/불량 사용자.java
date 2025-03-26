import java.util.*;

class Solution {
    static boolean[] isUsed;
    static Set<String> uniqueCase = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        isUsed = new boolean[user_id.length];
        back(0, user_id, banned_id);
        return uniqueCase.size();
    }
    
    private void back(int k, String[] user_id, String[] banned_id) {
        if (k == banned_id.length) {
            String uniqueString = checkUsed(isUsed, user_id);
            uniqueCase.add(uniqueString);
            return;
        }
        
        for (int i = 0; i < user_id.length; i++) {
            if (checkWord(user_id[i], banned_id[k]) && !isUsed[i]) {
                isUsed[i] = true;
                back(k + 1, user_id, banned_id);
                isUsed[i] = false;
            }
        }
    }
    
    private boolean checkWord(String word, String banned_id) {
        if (word.length() != banned_id.length()) {  // `length()` 사용
            return false;
        }
        
        for (int i = 0; i < word.length(); i++) {
            if (banned_id.charAt(i) == '*') continue;  // `charAt(i)` 사용
            if (banned_id.charAt(i) != word.charAt(i)) return false;
        }
        
        return true;
    }
    
    private String checkUsed(boolean[] isUsed, String[] user_id) {
        List<String> arr = new ArrayList<>();
        
        for (int i = 0; i < user_id.length; i++) {
            if (isUsed[i]) arr.add(user_id[i]);
        }
        
        return String.join(",", arr);
    }
}
