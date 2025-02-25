import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int INF = 100_000_000;
    static int T;
    static int n, m, t, s, g ,h, a, b, d;
    static List<Node>[] graph;
    static StringBuilder sb = new StringBuilder();


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

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
