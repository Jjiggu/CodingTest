import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static Integer[] dist;
    static int[] dx = {-1, 1};
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new Integer[100001];

        dist[N] = 0;
        q.add(N);
        bfs(q);

        System.out.print(dist[K]);
    }

    public static void bfs(Queue<Integer> q) {
        while(!q.isEmpty()) {
            int x = q.poll();

            if (x == K) {
                return;
            }

            if (x * 2 >= 0 && x * 2 < 100001 && dist[x * 2] == null) {
                dist[x * 2] = dist[x];
                q.add(x * 2);
            }

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];

                if (nx >= 0 && nx < 100001 && dist[nx] == null) {
                    dist[nx] = dist[x] + 1;
                    q.add(nx);
                }
            }
        }
    }
}
