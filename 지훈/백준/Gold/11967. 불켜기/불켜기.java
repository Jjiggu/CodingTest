import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static boolean[][] lights;
    static boolean[][] visited;
    static ArrayList<Room>[][] room;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Room> q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lights = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        room = new ArrayList[N + 1][N + 1];

        q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                room[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            room[x][y].add(new Room(a, b));
        }

        lights[1][1] = true;
        visited[1][1] = true;
        q.add(new Room(1, 1));
        int result = 1;

        while (!q.isEmpty()) {
            Room current = q.poll();

            // 현재 방의 스위치 작동
            for (Room r : room[current.x][current.y]) {
                if (!lights[r.x][r.y]) {
                    lights[r.x][r.y] = true;
                    result++;

                    // 새로 불이 켜진 방이 인접한 방문된 방이 있는지 확인
                    for (int i = 0; i < 4; i++) {
                        int nx = r.x + dx[i];
                        int ny = r.y + dy[i];
                        if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
                            if (visited[nx][ny]) {
                                q.add(new Room(r.x, r.y));
                                visited[r.x][r.y] = true;
                                break;
                            }
                        }
                    }
                }
            }

            // 인접한 방으로 이동
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
                    if (lights[nx][ny] && !visited[nx][ny]) {
                        q.add(new Room(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(result);
    }
}

class Room {
    int x;
    int y;

    Room(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
