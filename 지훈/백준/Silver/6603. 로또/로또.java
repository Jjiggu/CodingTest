import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K = -1;
    static int[] S, arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(K != 0) {
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            S = new int[K + 1];
            arr = new int[K + 1];
            isUsed = new boolean[K + 1];

            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            back(0, 0);

            System.out.println(sb.toString());
        }

        System.out.println("\n");

    }


    public static void back(int n, int nowNum) {
        if (n == 6) {
            for (int j = 0; j < 6; j++) {
                sb.append(arr[j]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = n; i < K; i++) {
            if (!isUsed[i] && S[i] > nowNum) {
                arr[n] = S[i];
                isUsed[i] = true;
                back(n + 1, S[i]);
                isUsed[i] = false;
            }
        }
    }
}
