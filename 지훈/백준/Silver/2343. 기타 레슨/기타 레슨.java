import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] lesson;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lesson = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            sum += lesson[i];
        }

        int l = Arrays.stream(lesson).max().getAsInt();
        int r = sum;

        System.out.print(binarySearch(l, r));
    }

    public static int binarySearch(int l, int r) {

        while(l <= r) {
            int m = (l + r) / 2;
            int cnt = 1;
            long sum = 0;

            for (int s : lesson) {
                sum += s;

                if (sum > m) {
                    sum = s;
                    cnt++;
                }
            }

            if (cnt > M) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }
}
