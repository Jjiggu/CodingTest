import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int cnt = 0;
    static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        back(0, 0);

        if (S == 0) {
            cnt--;
        }

        System.out.println(cnt);
    }


    public static void back(int k, int nowSum) {
        if (k == N) {
            if (nowSum == S) {
                cnt++;
            }
            return;
        }

        back(k + 1, nowSum);
        back(k + 1, nowSum + nums[k]);
    }
}
