import java.util.*;

class Solution {

    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        long sum = 0;
        
        for (int v : a) sum += v;
        if (sum != 0) return -1;
        if (n == 1) return 0;  

    
        List<List<Integer>> graph = new ArrayList<>(n);
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }


        long[] weight = new long[n];
        for (int i = 0; i < n; i++) weight[i] = a[i];

        
        return bfs(graph, degree, weight);
    }

    
    private long bfs(List<List<Integer>> graph, int[] degree, long[] weight) {
        int n = weight.length;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] processed = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }

        long operations = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (processed[u]) continue;
            processed[u] = true;

            
            for (int v : graph.get(u)) {
                if (processed[v]) continue;

                operations += Math.abs(weight[u]);
                weight[v] += weight[u];

                if (--degree[v] == 1) {
                    queue.offer(v);
                }
            }
        }

        return operations;
    }
}
