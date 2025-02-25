import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    static int result = 0;
    static char[][] maps;
    static boolean[][] visited;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        maps = new char[5][5];
        visited = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        back(0, 0,0);

        System.out.print(result);

    }

    public static void back(int k, int lastIdx, int sCnt) {
        if (k == 7 && sCnt >= 4) {
            int startX = (lastIdx - 1) / 5;
            int startY = (lastIdx - 1) % 5;

            if (isConnected(startX, startY)) {
                result++;
            }
        }

        for (int i = lastIdx; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;

            if (!visited[x][y]) {
                visited[x][y] = true;

                if (maps[x][y] == 'S') {
                    back(k + 1, i + 1, sCnt + 1);
                } else {
                    back(k + 1, i + 1, sCnt);
                }

                visited[x][y] = false;
            }
        }
    }

    static boolean isConnected(int startX, int startY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] checkVisited = new boolean[5][5];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startX, startY});
        checkVisited[startX][startY] = true;

        int connectCnt = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if (visited[nx][ny] && !checkVisited[nx][ny]) {
                        q.add(new int[] {nx, ny});
                        checkVisited[nx][ny] = true;
                        connectCnt++;
                    }
                }
            }
        }
        return connectCnt == 7;
    }
}
