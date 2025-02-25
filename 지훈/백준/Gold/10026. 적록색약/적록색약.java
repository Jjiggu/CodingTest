import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int result;
    static int N;
    static char[][] mapNormal;
    static char[][] mapBlind;
    static Boolean[][] visitedNormal;
    static Boolean[][] visitedBlind;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> normalQ;
    static Queue<int[]> colorBlindnessQ;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        mapNormal = new char[N][N];
        mapBlind = new char[N][N];
        visitedNormal = new Boolean[N][N];
        visitedBlind = new Boolean[N][N];

        normalQ = new LinkedList<>();
        colorBlindnessQ = new LinkedList<>();

        result = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                mapNormal[i][j] = line.charAt(j);

                if (line.charAt(j) == 'G') {
                    mapBlind[i][j] = 'R';
                } else {
                    mapBlind[i][j] = line.charAt(j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visitedNormal[i][j] = false;
                visitedBlind[i][j] = false;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    visitedNormal[i][j] = true;
                    normalQ.add(new int[]{i, j});
                    bfsNormal(normalQ, mapNormal, visitedNormal, mapNormal[i][j]);
                    result += 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result).append(" ");


        result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedBlind[i][j]) {
                    visitedBlind[i][j] = true;
                    colorBlindnessQ.add(new int[]{i, j});
                    bfsNormal(colorBlindnessQ, mapBlind, visitedBlind, mapBlind[i][j]);
                    result += 1;
                }
            }
        }

        sb.append(result);

        System.out.println(sb);
    }


    public static void bfsNormal(Queue<int[]> q, char[][] maps, Boolean[][] visitedMaps,  char color) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];


            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (maps[nx][ny] == color && !visitedMaps[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visitedMaps[nx][ny] = true;
                    }
                }
            }
        }
    }
}
