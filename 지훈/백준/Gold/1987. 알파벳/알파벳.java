import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int R, C;
    static int result = 0;
    static char[][] maps;
    static int[][] visited;
    static boolean[] isUsed;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        isUsed = new boolean[26];
        maps = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        isUsed[maps[0][0] - 'A'] = true;

        dfs(0, 0);

        System.out.print(result);

    }

    public static void dfs(int x, int y) {
        result = Math.max(result, visited[x][y] + 1);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if (!isUsed[maps[nx][ny] - 'A']) {
                    isUsed[maps[nx][ny] - 'A'] = true;
                    visited[nx][ny] = visited[x][y] + 1;
                    dfs(nx, ny);
                    visited[nx][ny] = 0;
                    isUsed[maps[nx][ny] - 'A'] = false;
                }
            }
        }
    }
}
