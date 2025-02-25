import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1_000_000_007; // MOD 값 추가
    static int N, M;
    static int[][] maps;
    static long[][] dp; // 경우의 수가 크므로 long 사용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        dp = new long[N][M]; // 경우의 수 저장을 위해 long 사용

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 🔹 예외처리: 마지막 줄에 강화유리가 없으면 다리를 건널 수 없음
        boolean hasValidPath = false;
        for (int j = 0; j < M; j++) {
            if (maps[N - 1][j] == 1) {
                dp[N - 1][j] = 1; // 마지막 줄에서 강화유리(1)인 경우 출발 가능
                hasValidPath = true;
            }
        }
        if (!hasValidPath) { // 강화유리가 없으면 0 출력 후 종료
            System.out.println(0);
            return;
        }

        // 🔹 DP 테이블 채우기 (Bottom-Up)
        for (int i = N - 2; i >= 0; i--) { // 위에서 아래로 계산
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 1) { // 강화유리(1)인 경우에만 이동 가능
                    // 왼쪽 아래 (↙)
                    if (j - 1 >= 0) {
                        dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % MOD;
                    }
                    // 아래 (↓)
                    dp[i][j] = (dp[i][j] + dp[i + 1][j]) % MOD;
                    // 오른쪽 아래 (↘)
                    if (j + 1 < M) {
                        dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % MOD;
                    }
                }
            }
        }

        // 🔹 최종 결과: 0번째 줄에서 출발할 수 있는 모든 경우의 수를 MOD로 출력
        long result = 0;
        for (int j = 0; j < M; j++) {
            result = (result + dp[0][j]) % MOD;
        }

        System.out.println(result);
    }
}
