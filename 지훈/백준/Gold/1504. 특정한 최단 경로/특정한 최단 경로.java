import org.w3c.dom.Node;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int INF = 200000001;
    static int N, E;
    static List<Node>[] graph;

    /**
     * Reads the graph configuration from standard input, constructs the graph as an adjacency list,
     * and calculates the shortest path from node 1 to node N that passes through two specific vertices.
     * It computes two potential routes:
     * <ul>
     *   <li>1 → v1 → v2 → N</li>
     *   <li>1 → v2 → v1 → N</li>
     * </ul>
     * The program prints the minimum distance of these two routes, or -1 if neither route is valid.
     *
     * @param args unused command-line arguments
     * @throws Exception if an error occurs during input reading or parsing
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<Node>();
        }


        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int distA = 0;
        int distB = 0;

        distA += dijkstra(1, v1);
        distA += dijkstra(v1, v2);
        distA += dijkstra(v2, N);

        distB += dijkstra(1, v2);
        distB += dijkstra(v2, v1);
        distB += dijkstra(v1, N);

        int result = (distA >= INF && distB >= INF ? -1 : Math.min(distA, distB));

        System.out.print(result);

    }

    /**
     * Computes the shortest path distance from the given start node to the target node in the graph using Dijkstra's algorithm.
     *
     * This method initializes all node distances to a preset infinite value, then iteratively relaxes edges by processing
     * the nodes in a priority queue. It returns the minimum distance from the start node to the target node, or a constant
     * representing infinity if the target node is unreachable.
     *
     * @param start the index of the starting node
     * @param end the index of the target node
     * @return the shortest distance from start to end, or INF if no path exists
     */
    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[] dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
        }

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int distance = node.weight;
            int nowNum = node.end;

            if (dist[nowNum] < distance) {
                continue;
            }

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

        return dist[end];
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        /**
         * Initializes a Node instance with a target node and its corresponding edge weight.
         *
         * @param end the identifier of the target node
         * @param weight the weight of the edge leading to the target node
         */
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        /**
         * Compares this node with the specified node based on their weights.
         *
         * @param o the node to be compared
         * @return a negative integer, zero, or a positive integer if this node's weight is less than,
         *         equal to, or greater than the specified node's weight, respectively
         */
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
