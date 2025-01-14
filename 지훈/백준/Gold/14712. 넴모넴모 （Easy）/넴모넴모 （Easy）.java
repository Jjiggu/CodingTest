import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maps;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N + 1][M + 1];

        back(0);

        System.out.println(result);
    }

    public static void back(int cnt) {
        // 목표 지점에 도달했을 때 결과를 계산
        if (cnt == N * M) {
            result++;
            return;
        }

        int x = cnt % M + 1;
        int y = cnt / M + 1;

        if (maps[y - 1][x] == 1 && maps[y][x - 1] == 1 && maps[y - 1][x - 1] == 1) {
            back(cnt + 1);
        } else {
            back(cnt + 1);
            maps[y][x] = 1;
            back(cnt + 1);
            maps[y][x] = 0;
        }
    }
}
