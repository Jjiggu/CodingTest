import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int F, S, G, U, D;
    static int result = 0;
    static int[] dist;
    static Queue<Integer> q;
    static int[] moves;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[F + 1];

        q = new LinkedList<>();

        q.add(S);
        dist[S] = 1;
        result = bfs(q);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }
    }


    public static int bfs(Queue<Integer> q) {
        while (!q.isEmpty()) {
            int current = q.poll();
            int x = current;

            if (x == G) {
                return dist[x] - 1;
            }

            moves = new int[]{U, - D};

            for (int move : moves) {
                int nx = x + move;

                if (nx >= 1 && nx < F + 1 && dist[nx] == 0) {
                    q.add(nx);
                    dist[nx] = dist[x] + 1;
                }
            }
        }
        return -1;
    }
}
