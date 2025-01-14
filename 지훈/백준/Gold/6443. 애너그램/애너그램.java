import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] word;
    static char[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            word = new int[26];

            String line = br.readLine();

            arr = new char[line.length()];

            for (int j = 0; j < line.length(); j++) {
                word[line.charAt(j) - 'a']++;
            }

            back(0, line.length());

            System.out.print(sb.toString());
        }
    }

    public static void back(int k, int maxSize) {
        if (k == maxSize) {
            for (int j = 0; j < maxSize; j++) {
                sb.append(arr[j]);
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (word[i] > 0) {
                word[i]--;
                arr[k] = (char) (i + 'a');
                back(k + 1, maxSize);
                word[i]++;
            }
        }
    }
}
