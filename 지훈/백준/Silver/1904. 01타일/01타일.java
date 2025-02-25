import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        if (N == 1) {
            System.out.println(1);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        System.out.print(dp[N]);
    }
}