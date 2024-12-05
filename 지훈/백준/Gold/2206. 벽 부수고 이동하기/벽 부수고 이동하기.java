import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int result;
    static int N, M;
    static int[][] maps;
    static int[][][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        dist = new int[N][M][2];

        q = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = line.charAt(j) - '0';
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        dist[0][0][0] = 1;
        q.add(new int[]{0, 0, 0});


        result = bfs(q);

        System.out.println(result);
    }


    public static int bfs(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int z = now[2];

            if (x == N - 1 && y == M - 1) {
                return dist[x][y][z];
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (maps[nx][ny] == 0) {
                    if (dist[nx][ny][z] == -1) {
                        dist[nx][ny][z] = dist[x][y][z] + 1;
                        q.add(new int[]{nx, ny, z});
                    }
                } else if (maps[nx][ny] == 1) {
                    if (z == 0 && dist[nx][ny][1] == -1) {
                        dist[nx][ny][1] = dist[x][y][z] + 1;
                        q.add(new int[]{nx, ny, 1});
                    }
                }
            }
        }

        return -1;
    }
}
