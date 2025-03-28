class Solution{
    public int solution(String s) {
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, expand(s, i, i));     // 홀수 길이
            max = Math.max(max, expand(s, i, i + 1)); // 짝수 길이
        }

        return max;
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}