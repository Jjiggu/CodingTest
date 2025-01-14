import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[] nums;
    static int[] arr;
    static int MAX = 8;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        nums = new int[N];
        arr = new int[MAX];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        back(0);

        System.out.print(sb.toString());
    }


    public static void back(int k) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[k] = nums[i];
            back(k + 1);
        }
    }
}
