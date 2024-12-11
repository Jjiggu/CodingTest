import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, K;
    static int time;
    static int[] dist;
    static int[] prev;
    static int[] moves = {};
    static Queue<Integer> q;
    static Stack<Integer> s;
    static int MAX = 100001;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[MAX];
        prev = new int[MAX];

        for (int i = 0; i < MAX; i++) {
            dist[i] = 0;
        }

        bfs(N);

        s = new Stack<>();

        int idx = K;

        while (idx != N) {
            s.push(idx);
            idx = prev[idx];
        }
        s.push(idx);

        System.out.println(s.size() - 1);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }

    }


    public static void bfs(int start) {
        q = new LinkedList<>();
        q.add(start);
        dist[start] = 1;

        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == K) {
                return;
            }

            moves = new int[]{x - 1, x + 1, x * 2};

            for (int nx : moves) {
                if (nx >= 0 && nx < MAX && dist[nx] == 0) {
                    dist[nx] = dist[x] + 1;
                    prev[nx] = x;
                    q.add(nx);
                }
            }
        }
    }
}
