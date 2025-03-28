class Solution{
    /**
     * Computes the length of the longest palindromic substring in the specified string.
     *
     * <p>This method iterates through the string, considering each character as the center of a potential
     * palindrome and expanding outward to check for both odd and even length palindromes. It returns the
     * maximum palindrome length found.
     *
     * @param s the string in which to search for palindromic substrings
     * @return the length of the longest palindromic substring
     */
    public int solution(String s) {
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, expand(s, i, i));     // 홀수 길이
            max = Math.max(max, expand(s, i, i + 1)); // 짝수 길이
        }

        return max;
    }

    /**
     * Expands from the given center indices to determine the length of the palindromic substring.
     *
     * <p>This method expands outward from the indices provided as <code>left</code> and <code>right</code> while the characters
     * at these indices are equal and within the bounds of the string. The length of the palindrome is calculated as the difference
     * between the final indices after expansion, adjusted by one.
     *
     * @param s the input string to search within
     * @param left the starting left index for expansion
     * @param right the starting right index for expansion
     * @return the length of the palindromic substring found by the expansion
     */
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}