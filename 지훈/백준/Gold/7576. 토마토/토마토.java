import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main { 
    static int n;
    static int m;
    static int result;
    static int[][] maps;
    static int[][] dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> q;

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        maps = new int[n][m];
        q = new LinkedList<>();
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == 1) {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0; 
                }
                if (maps[i][j] == 0) {
                    dist[i][j] = -1; 
                }
            }
        }

        while (!q.isEmpty()) {
            int node[] = q.poll();
            int currentX = node[0];
            int currentY = node[1];

            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maps[nx][ny] == -1) continue; 
                if (dist[nx][ny] >= 0) continue; 

                dist[nx][ny] = dist[currentX][currentY] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i][j] == -1) {
                    continue; 
                }
                if (dist[i][j] == -1) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, dist[i][j]);
            }
        }

        System.out.println(result);
    }
}
