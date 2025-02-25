import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];

        back(0, 0);

        System.out.print(sb.toString());
    }


    public static void back(int k, int preNum) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (i >= preNum) {
                arr[k] = i;
                preNum = i;
                back(k + 1, preNum);
            }
        }
    }
}
