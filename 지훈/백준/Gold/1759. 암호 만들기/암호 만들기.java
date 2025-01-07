import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] charList;  // char 배열로 변경
    static char[] arr;       // char 배열로 변경
    static List<Character> vowelList = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // L: 만들 자음+모음의 길이, C: 주어진 문자 개수
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        charList = new char[C];  // char 배열로 선언
        arr = new char[L];       // char 배열로 선언

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {  // C번 반복
            charList[i] = st.nextToken().charAt(0);  // char로 처리
        }

        // charList 배열을 사전순으로 정렬
        Arrays.sort(charList);  // char 배열을 오름차순 정렬

        // 백트래킹을 시작
        back(0, 0, 0, 0);

        // 결과 출력
        System.out.print(sb.toString());  // StringBuilder를 사용하여 출력
    }

    public static void back(int k, int lastIdx, int vowelsCnt, int consonantsCnt) {
        // L개의 문자로 완성되었을 때, 조건 만족 시 결과 추가
        if (k == L) {
            // 조건: 최소 1개의 모음과 최소 2개의 자음이 있어야 한다.
            if (vowelsCnt >= 1 && consonantsCnt >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(arr[i]);
                }
                sb.append("\n");
            }
            return;
        }

        // 문자 조합을 만들어 가면서 재귀 호출
        for (int j = lastIdx; j < C; j++) {
            arr[k] = charList[j];  // 문자 선택

            // 선택한 문자가 모음인지 자음인지 판단하여 카운트
            if (vowelList.contains(charList[j])) {
                vowelsCnt++;
            } else {
                consonantsCnt++;
            }

            // 다음 문자를 선택할 때, 현재 문자보다 사전순으로 더 큰 문자만 선택하도록 보장
            back(k + 1, j + 1, vowelsCnt, consonantsCnt);

            // 상태 복원: 선택한 문자가 모음인지 자음인지에 따라 카운트 값 복원
            if (vowelList.contains(charList[j])) {
                vowelsCnt--;
            } else {
                consonantsCnt--;
            }
        }
    }
}
