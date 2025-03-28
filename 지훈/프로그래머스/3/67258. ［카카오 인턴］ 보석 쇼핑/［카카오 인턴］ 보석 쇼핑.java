import java.util.*;

class Solution {
    /**
     * Finds the shortest contiguous subarray that includes every unique gem type.
     *
     * <p>This method uses a sliding window to identify the minimum-length subarray within the provided
     * array that contains all distinct gems. The resulting indices are 1-indexed.
     *
     * @param gems an array of gem types
     * @return an array of two integers representing the 1-indexed start and end positions of the subarray
     */
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int gemTypes = new HashSet<>(Arrays.asList(gems)).size(); 
        int length = Integer.MAX_VALUE, start = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if (map.size() == gemTypes && length > (i - start)) {
                length = i - start;
                answer[0] = start + 1;
                answer[1] = i + 1;
            }
        }
        return answer;
    }
}
