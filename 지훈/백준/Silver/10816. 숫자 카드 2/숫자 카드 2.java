import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());

            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }

        System.out.print(sb);
    }

    public static int lowerBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;

            if (key <= arr[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static int upperBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int m = (l + r) / 2;

            if (key < arr[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }
}
