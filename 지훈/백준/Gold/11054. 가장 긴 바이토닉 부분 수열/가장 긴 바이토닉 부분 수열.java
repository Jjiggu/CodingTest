import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, dpAsc, dpDesc;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dpAsc = new int[N];
        dpDesc = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dpAsc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dpAsc[i] < dpAsc[j] + 1) {
                    dpAsc[i] = dpAsc[j] + 1;
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dpDesc[i] = 1;

            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && dpDesc[i] < dpDesc[j] + 1) {
                    dpDesc[i] = dpDesc[j] + 1;
                }
            }
        }

        System.out.println(findMax(dpAsc, dpDesc));

    }

    public static int findMax(int[] dpAsc, int[] dpDesc) {
        int maxLength = 0;

        for (int i = 0; i < N; i++) {
            if (maxLength < dpAsc[i] + dpDesc[i]) {
                maxLength = dpAsc[i] + dpDesc[i];
            }
        }

        return maxLength - 1;
    }
}
