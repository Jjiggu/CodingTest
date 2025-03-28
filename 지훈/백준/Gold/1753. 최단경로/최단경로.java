import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int INF = 100_000_000;;
    static int V, E, K;
    static List<Node>[] graph;

    /**
     * Entry point of the program that computes the shortest paths from a specified starting vertex in a directed graph.
     *
     * <p>This method reads the graph configuration from standard input — including the number of vertices, edges, and the starting vertex —
     * initializes the graph's adjacency list, and populates it with the provided edge information. It then uses Dijkstra's algorithm to
     * compute the shortest distances from the starting vertex to every other vertex. The distances are output to the console, with "INF"
     * indicating vertices that are unreachable.
     *
     * @param args command-line arguments (unused)
     * @throws Exception if an I/O error occurs while reading input
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];

        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }


        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
        }

        int[] distances = dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (distances[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distances[i]);
            }
        }
    }

    /**
     * Computes the shortest paths from the specified start vertex to all other vertices in the graph using Dijkstra's algorithm.
     *
     * <p>The method initializes distances to a high constant value (INF) and uses a priority queue to relax edges,
     * ensuring that each vertex is processed in order of increasing distance. Unreachable vertices retain the INF value.
     *
     * @param start the starting vertex for the shortest path calculation
     * @return an array where each element represents the minimum cost to reach the corresponding vertex from the start;
     *         vertices that are unreachable remain set to INF
     */
    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[V + 1];

        Arrays.fill(dist, INF);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int distance = node.weight;
            int nowNum = node.end;

            if (dist[nowNum] < distance) continue;


            for (Node next : graph[nowNum]) {
                int nextNum = next.end;
                int nextDist = next.weight;

                int cost = distance + nextDist;

                if (cost < dist[nextNum]) {
                    dist[nextNum] = cost;
                    pq.add(new Node(nextNum, cost));
                }
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        /**
         * Constructs a new Node with the specified endpoint and edge weight.
         *
         * @param end the destination vertex of the edge
         * @param weight the cost associated with the edge to the destination vertex
         */
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        /**
         * Compares this node with the specified node based on weight.
         * <p>
         * Returns a negative integer, zero, or a positive integer as this node's weight is less than,
         * equal to, or greater than the specified node's weight.
         *
         * @param o the node to compare with
         * @return a negative integer if this node's weight is less than the specified node's,
         *         zero if equal, or a positive integer if greater
         */
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
