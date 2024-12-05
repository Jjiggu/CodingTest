import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int result;
    static int R, C;
    static char[][] maps;
    static int[][] distFire;
    static int[][] distHun;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> fireQ;
    static Queue<int[]> HunQ;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maps = new char[R][C];
        distFire = new int[R][C];
        distHun = new int[R][C];

        fireQ = new LinkedList<>();
        HunQ = new LinkedList<>();


        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                maps[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                distFire[i][j] = -1;
                distHun[i][j] = -1;
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (maps[i][j] == 'F') {
                    fireQ.add(new int[]{i, j});
                    distFire[i][j] = 0;
                }
                if (maps[i][j] == 'J') {
                    HunQ.add(new int[]{i, j});
                    distHun[i][j] = 0;
                }
            }
        }



        bfsFire(fireQ);

        result = bfsHun(HunQ);

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }


    public static void bfsFire(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < R && ny < C && distFire[nx][ny] == -1 && maps[nx][ny] != '#') {
                    distFire[nx][ny] = distFire[x][y] + 1;
                    fireQ.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static int bfsHun(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            if (x == 0 || y == 0 || x == R - 1 || y == C - 1) {
                return distHun[x][y] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C && distHun[nx][ny] == -1 && maps[nx][ny] != '#') {
                    if (distFire[nx][ny] == -1 || distFire[nx][ny] > distHun[x][y] + 1) {
                        distHun[nx][ny] = distHun[x][y] + 1;
                        HunQ.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}