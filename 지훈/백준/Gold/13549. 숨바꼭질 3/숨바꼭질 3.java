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

    /**
     * Entry point of the application.
     *
     * <p>
     * Reads two integers from standard input representing the starting position (N) and the target position (K),
     * initializes the distance tracking array and BFS queue, performs a breadth-first search to compute the minimum
     * steps required to reach the target, and prints the result.
     * </p>
     *
     * @throws Exception if an error occurs during input reading
     */
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

    /**
     * Performs a breadth-first search (BFS) to determine the minimum steps required to reach the target position.
     *
     * <p>This method processes positions from the provided queue, exploring valid moves by doubling the current
     * position (which does not increase the step count) and moving one unit left or right (which increases the step count by one).
     * It updates the global distance array with the minimum number of steps needed to reach each position and terminates
     * once the target position is reached.</p>
     *
     * @param q the queue of positions to be explored, initialized with the starting position
     */
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
