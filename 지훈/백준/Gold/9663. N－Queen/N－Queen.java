import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int cnt = 0;
    static boolean[] isUsed1;
    static boolean[] isUsed2;
    static boolean[] isUsed3;
    static int MAX = 40;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        isUsed1 = new boolean[MAX];
        isUsed2 = new boolean[MAX];
        isUsed3 = new boolean[MAX];

        back(0);

        System.out.print(cnt);
    }


    public static void back(int k) {
        if (k == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (isUsed1[i] || isUsed2[i + k] || isUsed3[k - i + N - 1]) continue;
            isUsed1[i] = true;
            isUsed2[i + k] = true;
            isUsed3[k - i + N - 1] = true;
            back(k + 1);
            isUsed1[i] = false;
            isUsed2[i + k] = false;
            isUsed3[k - i + N - 1] = false;
        }
    }
}
