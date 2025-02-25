import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static int[] lans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lans = new int[K];

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        long l = 1;  // 최소 길이
        long r = Arrays.stream(lans).max().getAsInt(); // 최대 길이
        long ans = 0;

        while (l <= r) {
            long m = (l + r) / 2;

            if (check(m)) {  // `m` 길이로 N개 이상 만들 수 있으면
                ans = m;  // 정답 후보 업데이트
                l = m + 1;  // 더 긴 길이를 탐색
            } else {
                r = m - 1;  // 불가능하면 길이를 줄임
            }
        }

        System.out.print(ans);
    }

    public static boolean check(long x) {
        long n = 0;

        for (int i = 0; i < K; i++) {
            n += lans[i] / x;
            if (n >= N) return true;  // 필요한 개수를 넘으면 바로 종료
        }

        return false;
    }
}
