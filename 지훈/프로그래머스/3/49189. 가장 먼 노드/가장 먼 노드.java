import java.util.*;

class Solution {
    
    static class Node{
        int v;
        int cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(new Node(e[1], 1));
            graph[e[1]].add(new Node(e[0], 1));
        }
        
        dijkstra(1);
        
        int maxNum = Arrays.stream(dist)
                           .filter(d -> d != Integer.MAX_VALUE)
                           .max()
                           .getAsInt();
        
        int result = (int) Arrays.stream(dist)
                                 .filter(d -> d == maxNum)
                                 .count();
        
        return result;
        
    }
    
    
    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (!visited[now.v]) {
                visited[now.v] = true;
            }
            
            for (Node next : graph[now.v]) {
                if (!visited[next.v] && dist[next.v] > now.cost + next.cost) {
                    dist[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            } 
        }
    }
}