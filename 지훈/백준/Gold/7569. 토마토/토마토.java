import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int result;
    static int H;
    static int N, M;
    static int[][][] maps;
    static int[][][] dist;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        maps = new int[N][M][H];
        dist = new int[N][M][H];
        visited = new boolean[N][M][H];
        Queue<int[]> q = new LinkedList<>();

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    maps[i][j][k] = Integer.parseInt(st.nextToken());

                    if (maps[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                        visited[i][j][k] = true;
                        dist[i][j][k] = 0;
                    }

                    if (maps[i][j][k] == 0) {
                        dist[i][j][k] = -1;
                    }
                }
            }
        }

        bfs(q);

        System.out.println(bfs(q));
    }

    public static int bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H && !visited[nx][ny][nz] && maps[nx][ny][nz] == 0) {
                    visited[nx][ny][nz] = true;
                    dist[nx][ny][nz] = dist[x][y][z] + 1;
                    q.add(new int[]{nx, ny, nz});
                }
            }
        }

        result = 0;

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j][k] == -1) {
                        continue;
                    }

                    if (dist[i][j][k] == -1) {
                        return -1;
                    }
                    result = Math.max(result, dist[i][j][k]);
                }
            }
        }
        return result;
    }
}