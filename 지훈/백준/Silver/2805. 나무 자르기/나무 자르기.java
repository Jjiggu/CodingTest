import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if(max < tree[i]) {
                max = tree[i]; 
            }
        }
        
        int result = binarySearch(tree, max);
        
        System.out.println(result);
    }

    public static int binarySearch(int[] tree, int max) {
        int l = 0;   
        int r = max; 

        while(l < r) {
            int m = (l + r) / 2;
            long sum = 0;

            for (int treeHeight : tree) {
                if (treeHeight > m) { 
                    sum += (treeHeight - m);
                }
            }

            if (sum < M) {
                r = m;  
            } else {
                l = m + 1; 
            }
        }

        return l - 1; 
    }
}
