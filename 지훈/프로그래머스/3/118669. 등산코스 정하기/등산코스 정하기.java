import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] path : paths) {
            int u = path[0];
            int v = path[1];
            int w = path[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        
        
        
        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        for (int gate : gates) isGate[gate] = true;
        for (int summit : summits) isSummit[summit] = true;
        
        
        int[] intensity = dijkstra(graph, gates, isGate, isSummit, n);
        
        Arrays.sort(summits);
        
        return findAnswer(summits, intensity);
    }
    
    
    public int[] dijkstra(List<int[]>[] graph, int[] gates, boolean[] isGate, boolean[] isSummit, int n) {
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        for (int gate : gates) {
            intensity[gate] = 0;
            pq.offer(new int[]{gate, 0});
        }
        
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int nowIntensity = cur[1];
            
            if (nowIntensity > intensity[now]) continue;
            if (isSummit[now]) continue;
            
            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int weight = next[1];
                
                if (isGate[nextNode]) continue;
                
                int newIntensity = Math.max(intensity[now], weight);
                if (intensity[nextNode] > newIntensity) {
                    intensity[nextNode] = newIntensity;
                    pq.offer(new int[]{nextNode, newIntensity});
                }
            }
        }
        
        return intensity;
    }
    
    
    public int[] findAnswer(int[] summits, int[] intensity) {
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;
        
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minIntensity = intensity[summit];
                minSummit = summit;
            }
        }
        
        return new int[]{minSummit, minIntensity}; 
    }
}