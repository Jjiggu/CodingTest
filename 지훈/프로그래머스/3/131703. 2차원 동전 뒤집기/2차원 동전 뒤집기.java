import java.util.*;

class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;
        
        int[] start = new int[n];
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (int j = 0; j < m; j++) {
                if ((beginning[i][j] ^ target[i][j]) == 1) {
                    mask |= 1 << j;
                }
            }
            start[i] = mask;
        }
        
        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        q.offer(start);
        dist.offer(0);
        seen.add(key(start));

        int fullRowMask = (1 << m) - 1;

        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int d = dist.poll();
            
            if (allZero(cur)) return d;
            if (d == 10) continue;  

            
            for (int i = 0; i < n; i++) {
                int[] nxt = cur.clone();
                nxt[i] ^= fullRowMask;
                String k = key(nxt);
                if (seen.add(k)) {
                    q.offer(nxt);
                    dist.offer(d + 1);
                }
            }
            
            for (int j = 0; j < m; j++) {
                int[] nxt = cur.clone();
                for (int i = 0; i < n; i++) {
                    nxt[i] ^= 1 << j;
                }
                String k = key(nxt);
                if (seen.add(k)) {
                    q.offer(nxt);
                    dist.offer(d + 1);
                }
            }
        }
        return -1;
    }


    private boolean allZero(int[] masks) {
        for (int mask : masks) {
            if (mask != 0) return false;
        }
        return true;
    }

    
    private String key(int[] masks) {
        StringBuilder sb = new StringBuilder();
        for (int mask : masks) {
            sb.append(mask).append(',');
        }
        return sb.toString();
    }
}
