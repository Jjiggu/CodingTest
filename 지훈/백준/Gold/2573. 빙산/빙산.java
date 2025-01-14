import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int time, area;
    static int[][] maps;
    static boolean[][] visited;
    static int[][] melts;
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                maps[i][j] = x;
            }
        }

        q = new LinkedList<>();
        time = 0;

        while (true) {
            visited = new boolean[N][M];
            area = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j] > 0 && !visited[i][j]) {
                        q.add(new int[]{i, j});
                        visited[i][j] = true;
                        bfs(q);
                        area++;
                    }
                }
            }

            if (area >= 2) {
                System.out.println(time);
                return;
            } else if (area == 0) {
                System.out.println(0);
                return;
            }

            meltIce();

            time++;
        }

    }


    public static void bfs(Queue<int[]> q) {

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && maps[nx][ny] > 0 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

            }
        }
    }


    public static void meltIce() {

        melts = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] > 0) {
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < N && ny < M && maps[nx][ny] == 0) {
                            cnt++;
                        }
                    }
                    melts[i][j] = cnt;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] > 0) {
                    maps[i][j] -= melts[i][j];

                    if (maps[i][j] < 0) {
                        maps[i][j] = 0;
                    }
                }
            }
        }
    }
}
