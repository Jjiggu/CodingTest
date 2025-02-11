import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A, B;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            System.out.println(binarySearch(B[i]));
        }

    }

    public static int binarySearch(int n) {
        int l = 0;
        int r = N - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (A[m] == n) {
                return 1;
            } else if (A[m] < n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return 0;
    }
}
