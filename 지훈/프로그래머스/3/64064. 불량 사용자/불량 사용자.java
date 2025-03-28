import java.util.*;

class Solution {
    static boolean[] isUsed;
    static Set<String> uniqueCase = new HashSet<>();
    
    /**
     * Computes the number of unique combinations of user IDs that match the banned ID patterns.
     *
     * <p>This method initializes a boolean array to track used user IDs and employs recursive backtracking
     * to explore all valid assignments of user IDs to banned ID patterns. Each banned ID pattern may use the
     * wildcard character '*' to match any single character.
     *
     * @param user_id an array of available user IDs.
     * @param banned_id an array of banned ID patterns, possibly containing wildcards ('*').
     * @return the count of unique valid combinations of user IDs that satisfy the banned ID patterns.
     */
    public int solution(String[] user_id, String[] banned_id) {
        isUsed = new boolean[user_id.length];
        back(0, user_id, banned_id);
        return uniqueCase.size();
    }
    
    /**
     * Recursively explores all valid assignments of user IDs to banned ID patterns using backtracking.
     *
     * <p>This helper method attempts to match each banned ID with a user ID that fits its pattern,
     * where patterns may include wildcard characters ('*'). Once a complete combination is found
     * (i.e., when the current index equals the length of the banned_id array), the combination is
     * recorded uniquely using a string representation of the selected user IDs.</p>
     *
     * @param k the current index in the banned_id array being processed
     * @param user_id an array of available user ID strings
     * @param banned_id an array of banned ID patterns
     */
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
    
    /**
     * Determines if a given word fits the banned ID pattern.
     *
     * <p>A match is confirmed if the word and the banned ID are the same length and each non-wildcard character
     * in the banned ID exactly matches the corresponding character in the word. Wildcards ('*') in the banned ID
     * can match any character.
     *
     * @param word the string to evaluate against the banned pattern
     * @param banned_id the banned pattern which may include wildcards ('*')
     * @return {@code true} if the word matches the banned pattern; {@code false} otherwise
     */
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
    
    /**
     * Returns a comma-separated string of user IDs that are marked as used.
     *
     * <p>This method iterates through the given user_id array and collects those user IDs for which
     * the corresponding index in the isUsed array is true, then joins them into a single string
     * separated by commas.
     *
     * @param isUsed a boolean array indicating which user IDs are selected
     * @param user_id an array of user IDs to filter
     * @return a comma-separated string of the user IDs that are marked as used
     */
    private String checkUsed(boolean[] isUsed, String[] user_id) {
        List<String> arr = new ArrayList<>();
        
        for (int i = 0; i < user_id.length; i++) {
            if (isUsed[i]) arr.add(user_id[i]);
        }
        
        return String.join(",", arr);
    }
}
