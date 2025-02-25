import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int T, N, M, K;
    static int result;
    static int[][] maps;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            maps = new int[M][N];
            visited = new boolean[M][N];


            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                maps[x][y] = 1;
            }


            result = 0;

            for (int nm = 0; nm < M; nm++) {
                for (int nn = 0; nn < N; nn++) {
                    if (maps[nm][nn] == 1 && !visited[nm][nn]) {
                        bfs(nm, nn);
                        result++;
                    }
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }


    public static void bfs(int startX, int startY) {
        q = new LinkedList<>();
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] cuurent = q.poll();
            int x = cuurent[0];
            int y = cuurent[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
