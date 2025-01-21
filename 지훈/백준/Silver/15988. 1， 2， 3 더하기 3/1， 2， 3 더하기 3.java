import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp;
    static final long MOD = 1000000009;
    static final int MAX = 1000000;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new long[MAX + 1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        for (int k = 0; k < N; k++) {
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append("\n");
        }
        
        System.out.print(sb);
    }
}
