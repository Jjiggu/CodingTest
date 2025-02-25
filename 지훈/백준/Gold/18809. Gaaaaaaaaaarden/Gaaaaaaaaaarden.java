import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, G, R;
    static int result = 0;
    static int cnt;
    static int[][] maps;
    static boolean[] isUsed;
    static Queue<int[]> greenQ, redQ;
    static List<int[]> plantAble, greenList, redList;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        greenQ = new LinkedList<>();
        redQ = new LinkedList<>();
        plantAble = new ArrayList<>();
        greenList = new ArrayList<>();
        redList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 2) {
                    plantAble.add(new int[]{i, j});
                }
            }
        }
        isUsed = new boolean[plantAble.size()];

        back(0, 0, 0);

        System.out.println(result);
    }

    public static void back(int g, int r, int nowIdx) {
        if (g == G && r == R) {
            result = Math.max(result, bfs(greenList, redList));
            return;
        }

        for (int i = nowIdx; i < plantAble.size(); i++) {
            int x = plantAble.get(i)[0];
            int y = plantAble.get(i)[1];

            if (!isUsed[i]){
                if (g < G) {
                    isUsed[i] = true;
                    greenList.add(new int[]{x, y});
                    back(g + 1, r, i + 1);
                    greenList.remove(greenList.size() - 1);
                    isUsed[i] = false;
                }


                if (r < R) {
                    isUsed[i] = true;
                    redList.add(new int[]{x, y});
                    back(g, r + 1, i + 1);
                    redList.remove(redList.size() - 1); // 마지막 요소 제거
                    isUsed[i] = false;
                }
            }
        }
    }

    public static int bfs(List<int[]> greenList, List<int[]> redList) {
        int[][] time = new int[N][M];
        int[][] state = new int[N][M]; // 1 : G 배양액, 2 : R 배양액, 0 : 아무것도 x, -1 : 꽃 핀 상태
        cnt = 0;

        Queue<int[]> greenQ = new LinkedList<>();
        Queue<int[]> redQ = new LinkedList<>();

        for (int[] nowg : greenList) {
            greenQ.add(new int[]{nowg[0], nowg[1]});
            state[nowg[0]][nowg[1]] = 1;
            time[nowg[0]][nowg[1]] = 0;
        }

        for (int[] nowr : redList) {
            redQ.add(new int[]{nowr[0], nowr[1]});
            state[nowr[0]][nowr[1]] = 2;
            time[nowr[0]][nowr[1]] = 0;
        }

        while (!greenQ.isEmpty() || !redQ.isEmpty()) {
            int gqLen = greenQ.size();

            for (int i = 0; i < gqLen; i++) {
                int[] now = greenQ.poll();
                int x = now[0];
                int y = now[1];

                if (state[x][y] == -1) continue;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (maps[nx][ny] != 0 && state[nx][ny] == 0) {
                            state[nx][ny] = 1;
                            time[nx][ny] = time[x][y] + 1;
                            greenQ.add(new int[]{nx, ny});
                        } else if (state[nx][ny] == 2 && time[nx][ny] == time[x][y] + 1) {
                            state[nx][ny] = -1;
                            cnt++;
                        }
                    }
                }
            }

            int rqLen = redQ.size();

            for (int i = 0; i < rqLen; i++) {
                int[] now = redQ.poll();
                int x = now[0];
                int y = now[1];

                if (state[x][y] == -1) continue;

                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (maps[nx][ny] != 0 && state[nx][ny] == 0) {
                            state[nx][ny] = 2;
                            time[nx][ny] = time[x][y] + 1;
                            redQ.add(new int[]{nx, ny});
                        } else if (state[nx][ny] == 1 && time[nx][ny] == time[x][y] + 1) {
                            state[nx][ny] = -1;
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
