import java.util.*;

class Solution {
    static class Node {
        int v;
        int cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            graph[road[0]].add(new Node(road[1], 1));
            graph[road[1]].add(new Node(road[0], 1));
        }
        
        
        int[] dist = dijkstra(n, destination);

        for (int i = 0; i < sources.length; i++) {
            int source = sources[i];
            answer[i] = dist[source] == Integer.MAX_VALUE ? -1 : dist[source];
        }
        
        return answer;
    }
    
    
    private int[] dijkstra(int n, int start) {
        
        int[] dist = new int[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.v] < now.cost) continue;
            
            for (Node next : graph[now.v]) {
                if (dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            } 
        }
        
        return dist;
    }    
}