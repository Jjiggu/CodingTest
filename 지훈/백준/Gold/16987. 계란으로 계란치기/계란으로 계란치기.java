import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    static int result = 0;
    static int N;
    static int[][] eggList;
    static boolean[] isBroken;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        eggList = new int[2][N];
        isBroken = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            eggList[0][i] = Integer.parseInt(st.nextToken()); // 내구도
            eggList[1][i] = Integer.parseInt(st.nextToken()); // 무게
        }

        back(0);

        System.out.print(result);
    }

    public static void back(int start) {
        if (start == N) {
            int brokenCount = 0;

            for (int i = 0; i < N; i++) {
                if (isBroken[i]) brokenCount++;
            }

            result = Math.max(result, brokenCount);
            return;
        }

        boolean anyEggBroken = false;

        for (int i = 0; i < N; i++) {
            if (i != start && !isBroken[start] && !isBroken[i]) {
                anyEggBroken = true;

                eggList[0][start] -= eggList[1][i];
                eggList[0][i] -= eggList[1][start];

                if (eggList[0][start] <= 0) isBroken[start] = true;
                if (eggList[0][i] <= 0) isBroken[i] = true;

                back(start + 1);


                if (eggList[0][start] <= 0) isBroken[start] = false;
                if (eggList[0][i] <= 0) isBroken[i] = false;

                eggList[0][start] += eggList[1][i];
                eggList[0][i] += eggList[1][start];
                }
            }
        if (!anyEggBroken) {
            back(start + 1);
        }
    }
}
