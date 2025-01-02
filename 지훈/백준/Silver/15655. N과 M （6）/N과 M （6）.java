import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[] nums;
    static int[] arr;
    static boolean[] isUsed;
    static int MAX = 10;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        nums = new int[N];
        arr = new int[MAX];
        isUsed = new boolean[MAX];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        back(0, 0);
    }


    public static void back(int k, int nowNum) {
        if (k == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
            return;
        }

        for (int i = k; i < N; i++) {
            if (!isUsed[i] && nowNum <= nums[i]) {
                arr[k] = nums[i];
                isUsed[i] = true;
                nowNum = nums[i];
                back(k + 1, nowNum);
                isUsed[i] = false;
            }
        }
    }
}
