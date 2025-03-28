import java.util.*;

class Solution {
    static class Node {
        int v;
        int cost;
        
        /**
         * Constructs a Node representing a graph vertex and the cost to reach it.
         *
         * @param v the identifier of the vertex
         * @param cost the cost associated with reaching the vertex
         */
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    
    static ArrayList<Node>[] graph;
    
    /**
     * Computes the shortest path distances from multiple source nodes to a given destination in an undirected graph.
     * 
     * <p>The graph is built using the provided roads, each treated as a bidirectional connection with equal cost.
     * Dijkstra's algorithm is applied in reverse from the destination to determine the minimum distance to every node.
     * For each source node, the corresponding distance is returned, or -1 if the destination is unreachable.
     *
     * @param n the total number of nodes in the graph
     * @param roads an array of bidirectional roads, each represented as a two-element array of connected nodes
     * @param sources an array of source nodes for which the shortest distance to the destination is required
     * @param destination the target node used as the starting point for computing shortest paths
     * @return an array where each element is the shortest path distance from the corresponding source node to the destination,
     *         or -1 if the source is unreachable
     */
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
    
    
    /**
     * Computes the shortest path distances from the specified start node to all nodes using Dijkstra's algorithm.
     *
     * <p>The method initializes all node distances to Integer.MAX_VALUE and updates them by exploring the graph via a priority queue.
     * If a node is unreachable from the start node, its distance remains Integer.MAX_VALUE.</p>
     *
     * @param n the total number of nodes in the graph
     * @param start the node from which to compute the shortest paths
     * @return an array containing the minimum distances from the start node to each node in the graph
     */
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