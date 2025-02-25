import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int[][] maps;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                maps[i][j] = s.charAt(j) - '0';
            }
        }

        visited  = new boolean[n][m];
        visited[0][0] = true;
        bfs(0, 0);

        System.out.println(maps[n - 1][m - 1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int node[] = q.poll();
            int currentX = node[0];
            int currentY = node[1];

            if (currentX == n - 1 && currentY == m - 1) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] || maps[nx][ny] == 0) continue;

                q.add(new int[]{nx, ny});
                maps[nx][ny] = maps[currentX][currentY] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}