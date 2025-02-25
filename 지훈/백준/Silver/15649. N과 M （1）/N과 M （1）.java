import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int result;
    static int N, M;
    static int[] arr;
    static boolean[] isUsed;
    static int MAX = 10;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[MAX];
        isUsed = new boolean[MAX];

        back(0);
    }


    public static void back(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                back(k + 1);
                isUsed[i] = false;
            }
        }
    }
}
