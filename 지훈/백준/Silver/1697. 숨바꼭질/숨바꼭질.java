import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int result;
    static int N, K;
    static int[] dist;
    static int MAX = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            dist[i] = -1;
        }

        result = bfs(N, K);

        System.out.println(result);

    }

    public static int bfs(int start, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()) {
            int x = q.poll();

            if (x == target) {
                return dist[x];
            }

            int[] moves = {x - 1, x + 1, x * 2};

            for (int nx : moves) {
                if (nx >= 0 && nx < MAX && dist[nx] == -1) {
                    dist[nx] = dist[x] + 1;
                    q.add(nx);
                }
            }
        }
        return -1;
    }
}