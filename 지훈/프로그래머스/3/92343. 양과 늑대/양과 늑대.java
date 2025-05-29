import java.util.*;

class Solution {
    
    static int maxSheep = 0;
    static ArrayList<Integer>[] graph;
    
    public int solution(int[] info, int[][] edges) {
        
        graph = new ArrayList[info.length];
        
        for (int i = 0; i < info.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        
        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        
        dfs(0, 0, 0, nextNodes, info);   
        
        return maxSheep;
    }
    
    
    public void dfs(int current, int sheep, int wolf, List<Integer> nextNodes, int[] info) {
        if (info[current] == 0) {
            sheep++;
        } else {
            wolf++;
        }
        
        if (sheep <= wolf) return;
        
        maxSheep = Math.max(maxSheep, sheep);
        
        List<Integer> candidates = new ArrayList<>(nextNodes);
        candidates.remove(Integer.valueOf(current));
        
        for (int next : graph[current]) {
            candidates.add(next);
        }
        
        for (int next : candidates) {
            dfs(next, sheep, wolf, candidates, info);
        }
    }
}
