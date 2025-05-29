import java.util.*;

class Solution {
    
    class Node {
        int v;
        int cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static List<Node>[] graph;
    static boolean[] visited;
    static int[] distFromS, distFromA, distFromB;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        distFromS = new int[n + 1];
        distFromA = new int[n + 1];
        distFromB = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            graph[fare[0]].add(new Node(fare[1], fare[2]));
            graph[fare[1]].add(new Node(fare[0], fare[2]));
        }
        
        dijkstra(s, distFromS);
        dijkstra(a, distFromA);
        dijkstra(b, distFromB);
        
        
        int minCost = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int cost = distFromS[i] + distFromA[i] + distFromB[i];
            minCost = Math.min(minCost, cost);
        }
        
        return minCost;
    }
    
    
    private int[] dijkstra(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        pq.offer(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dist[now.v] < now.cost) continue;
            
            for (Node next : graph[now.v]){
                int nextCost = dist[now.v] + next.cost;
                
                if (dist[next.v] > nextCost) {
                    dist[next.v] = nextCost;
                    pq.offer(new Node(next.v, nextCost));
                }
            }
        }
        
        return dist;
    }
}