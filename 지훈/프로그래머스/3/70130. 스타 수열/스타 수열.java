import java.util.*;

class Solution {
    public int solution(int[] a) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : a) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // 등장을 많이 한 숫자 순으로 정렬
        List<Integer> sortedKeys = new ArrayList<>(countMap.keySet());
        sortedKeys.sort((x, y) -> countMap.get(y) - countMap.get(x));  // 내림차순

        int maxLen = 0;

        for (int x : sortedKeys) {
            if (countMap.get(x) * 2 <= maxLen) break;  // 더 길 수 없음
            int pairCnt = 0;
            for (int i = 0; i < a.length - 1;) {
                if (a[i] != a[i + 1] && (a[i] == x || a[i + 1] == x)) {
                    pairCnt++;
                    i += 2;
                } else {
                    i++;
                }
            }
            maxLen = Math.max(maxLen, pairCnt * 2);
        }

        return maxLen;
    }
}
