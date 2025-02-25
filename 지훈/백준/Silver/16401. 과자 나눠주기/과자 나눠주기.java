import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] snack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snack = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snack);

        System.out.println(binarySearch());
    }

    public static int binarySearch() {
        int l = 1;
        int r = Arrays.stream(snack).max().getAsInt();
        int result = 0;

        while(l <= r) {
            int m = (l + r) / 2;
            long sum = 0;

            for (int s : snack) {
                sum += (s / m);
            }

            if (sum >= M) {
                result = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}
