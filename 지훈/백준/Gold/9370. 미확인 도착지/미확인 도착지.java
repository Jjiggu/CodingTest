import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int INF = 100_000_000;
    static int T;
    static int n, m, t, s, g ,h, a, b, d;
    static List<Node>[] graph;
    static StringBuilder sb = new StringBuilder();


    /**
     * The main entry point for the application.
     *
     * <p>This method processes multiple test cases of a graph problem by reading input from standard input,
     * constructing graphs with specially adjusted edge weights to identify routes that include a particular road segment,
     * and computing shortest paths via Dijkstra's algorithm. Destination nodes with an odd total distance—indicating that
     * the specific road was used—are then collected and printed.
     *
     * @param args command line arguments (not used)
     * @throws Exception if an I/O error occurs during input processing
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n + 1];

            for (int j = 0; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for (int e = 0; e < m; e++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());

                if ((a == g && b == h) || (a == h && b == g)) {
                    graph[a].add(new Node(b, d * 2 - 1));
                    graph[b].add(new Node(a, d * 2 - 1));
                } else {
                    graph[a].add(new Node(b, d * 2));
                    graph[b].add(new Node(a, d * 2));
                }
            }

            List<Integer> result = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                result.add(Integer.parseInt(br.readLine()));
            }

            int[] distance = dijkstra(s);

            Collections.sort(result);

            for (int num : result) {
                if (distance[num] % 2 == 1) {
                    sb.append(num).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    /**
     * Computes the shortest path distances from the given start node to every other node in the graph 
     * using Dijkstra's algorithm.
     * <p>
     * This method initializes all distances to infinity and progressively relaxes them by processing nodes 
     * via a priority queue. Each index in the returned array represents the minimum distance from the start node, 
     * with unreachable nodes retaining the distance value {@code INF}.
     *
     * @param start the index of the starting node
     * @return an array where each element holds the shortest distance from the start node to that node
     */
    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int distance = node.weight;
            int nowNum = node.end;

            if (visited[nowNum]) continue;

            visited[nowNum] = true;

            for (Node next : graph[nowNum]) {
                int nextNum = next.end;
                int nextDist = next.weight;

                int cost = distance + nextDist;

                if (!visited[nextNum] && cost < dist[nextNum]) {
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
         * Constructs a Node representing an edge's destination and its associated weight.
         *
         * @param end the destination node identifier
         * @param weight the cost or weight associated with the edge
         */
        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        /**
         * Compares this node with the specified node based on their weights.
         *
         * <p>This method returns a negative integer, zero, or a positive integer as this node's weight 
         * is less than, equal to, or greater than the specified node's weight. It enables proper ordering 
         * of nodes in priority queues and similar data structures.</p>
         *
         * @param o the node to compare against
         * @return a negative integer, zero, or a positive integer as this node's weight is less than, equal 
         *         to, or greater than the specified node's weight
         */
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
