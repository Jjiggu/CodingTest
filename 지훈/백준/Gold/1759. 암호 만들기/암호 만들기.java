import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] charList;
    static char[] arr;
    static List<Character> vowelList = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        charList = new char[C];
        arr = new char[L];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            charList[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(charList);

        back(0, 0, 0, 0);

        System.out.println(sb.toString());

    }


    public static void back(int k, int lastIdx, int vowelsCnt, int consonantsCnt) {
        if (k == L){
            if (vowelsCnt >= 1 && consonantsCnt >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }

        for (int j = lastIdx; j < C; j++) {
            arr[k] = charList[j];

            if (vowelList.contains(charList[j])) {
                back(k + 1, j + 1, vowelsCnt + 1, consonantsCnt);
            } else {
                back(k + 1, j + 1, vowelsCnt, consonantsCnt + 1);
            }
        }
    }
}
