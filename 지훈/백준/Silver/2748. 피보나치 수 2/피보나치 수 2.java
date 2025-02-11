import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = new long[N + 1];

        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }

        System.out.print(d[N]);
    }
}
