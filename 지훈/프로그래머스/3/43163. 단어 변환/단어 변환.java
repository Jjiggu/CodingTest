import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] isUsed = new boolean[words.length];
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(begin, 0)); // 시작 단어와 변환 횟수(0) 초기화
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            if (current.word.equals(target)) {
                return current.count; // 목표 단어에 도달하면 변환 횟수 반환
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!isUsed[i] && checkEquals(current.word, words[i])) {
                    isUsed[i] = true;
                    queue.add(new Node(words[i], current.count + 1)); // 변환 후 큐에 추가
                }
            }
        }
        
        return 0; // target에 도달하지 못한 경우 0 반환
    }
    
    // 단어 차이가 1개 문자만 다른지 체크하는 함수
    public static boolean checkEquals(String nowWord, String comWord) {
        int cnt = 0;
        for (int i = 0; i < nowWord.length(); i++) {
            if (nowWord.charAt(i) != comWord.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1; // 한 글자만 다를 때 true
    }
    
    // BFS에서 사용할 노드 클래스
    static class Node {
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
