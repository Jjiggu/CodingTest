import java.util.*;

class Solution {
    
    static class Node{
        int v;
        int cost;
        
        /**
         * Constructs a Node with the specified vertex and cost.
         *
         * @param v the vertex identifier
         * @param cost the cost associated with reaching the vertex
         */
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    
    /**
     * Returns the count of nodes that are farthest from the starting node (node 1) in an undirected graph.
     *
     * <p>This method builds an adjacency list based on the provided edge list, employs Dijkstra's algorithm
     * to determine the shortest paths from node 1, and then identifies and counts the nodes with the maximum distance.
     *
     * @param n the total number of nodes in the graph (nodes are labeled 1 through n)
     * @param edge a 2D array of edges, where each element defines an undirected connection between two nodes with unit weight
     * @return the number of nodes with the maximum distance from node 1
     */
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
    
    
    /**
     * Computes the shortest paths from the specified start node to all other nodes using Dijkstra's algorithm.
     *
     * <p>This method leverages a priority queue to update the global distance array "dist" with the minimum cost required
     * to reach each node, while marking visited nodes in the global "visited" array. It assumes the graph is represented as
     * an adjacency list in the global "graph" variable.
     *
     * @param start the index of the starting node for the algorithm
     */
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