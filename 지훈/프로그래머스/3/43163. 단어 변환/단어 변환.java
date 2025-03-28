import java.util.*;

class Solution {
    /**
     * Computes the minimum number of transformations required to convert the initial word to the target word.
     * A transformation is valid if it changes exactly one character and results in a word found in the given array.
     * The method uses a breadth-first search (BFS) approach to ensure the shortest transformation sequence is identified.
     * If the target word cannot be reached, the method returns 0.
     *
     * @param begin  the starting word for the transformation
     * @param target the desired target word
     * @param words  the array of allowed words for valid transformations, each usable only once
     * @return the minimum number of transformations needed to reach the target word, or 0 if it is unreachable
     */
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
    
    /**
     * Determines if two words differ by exactly one character.
     *
     * <p>This method compares two strings character by character and returns
     * {@code true} when exactly one character is different between them, indicating a valid single-character transformation.</p>
     *
     * @param nowWord the first word to compare
     * @param comWord the second word to compare against
     * @return {@code true} if the two words differ by exactly one character; {@code false} otherwise
     */
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
        
        /**
         * Constructs a Node instance representing a word and its transformation count.
         *
         * @param word the word at this node in the transformation sequence
         * @param count the number of transformations required to reach this word
         */
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
