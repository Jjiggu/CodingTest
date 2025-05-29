class Solution {
    
    private int n, num = 0;
    private boolean finish = false;
    private int[] weak, dist, choice;
    private int[][] rotateWeak;
    
    public int solution(int n, int[] weak, int[] dist) {
        
        this.n = n;
        this.weak = weak;
        this.dist = dist;
        setWeak();
        
        for (int i = 1; i <= dist.length; i++) {
            num = i;
            choice = new int[num];
            permutation(0, new boolean[dist.length]);
            
            if (finish) break;
        }
        
        return finish ? num : -1;
    }
    
    
    public void permutation(int depth, boolean[] visit) {
        if (finish) return;
        
        if (depth == num) {
            check();
            return;
        }
        
        for (int i = 0; i < dist.length; i++) {
            if (!visit[i]) {
                choice[depth] = dist[i];
                visit[i] = true;
                permutation(depth + 1, visit);
                visit[i] = false;
            }
        }
    }
    
    
    public void check() {
        for (int[] weak : rotateWeak) {
            int idx = 0;
            int start = 0;
            boolean[] visit = new boolean[weak.length];
            
            while(idx != num) {
                int i = start;
                int value = choice[idx++];
                
                for (int j = start; j < weak.length; j++) {
                    if (!(weak[i] <= weak[j] && weak[j] <= weak[i] + value)) break;
                    visit[j] = true;
                    start++;
                }
            }
            
            if (isFinish(visit)) {
                finish = true;
                return;
            }
        }
    }
    
    
    public boolean isFinish(boolean[] visit) {
        for (boolean bool : visit) {
            if (!bool) return false;
        }
        
        return true;
    }
    
    
    public void setWeak() {
        int len = weak.length;
        rotateWeak = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            rotateWeak[i] = rotate(weak, i);
        }
    }
    
    
    public int[] rotate(int[] weak, int idx) {
        int len = weak.length;
        int[] result = new int[len];
        
        for (int i = 0; i < len; i++) {
            if (i + idx < len) result[i] = weak[i + idx];
            else result[i] = weak[i + idx - len] + n;
        }
        
        return result;
    }
}