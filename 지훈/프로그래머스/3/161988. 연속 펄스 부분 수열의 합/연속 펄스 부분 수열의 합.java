class Solution {
    /**
 * Computes the maximum sum obtainable by alternately adding and subtracting elements from the given sequence.
 *
 * <p>This method iterates over the input array while applying two alternating sign patterns. For one pattern,
 * elements at even indices are subtracted and those at odd indices are added; for the other, the roles are reversed.
 * At each step, it updates running totals that represent the best sums achievable under each pattern and ultimately
 * returns the highest sum computed.
 *
 * @param sequence the array of integers to process
 * @return the maximum alternating-sign subsequence sum
 */
public long solution(int[] sequence) {
        long maxSum = Long.MIN_VALUE;
        long evenSum = 0, oddSum = 0;

        for (int i = 0; i < sequence.length; i++) {
            int pulseEven = (i % 2 == 0) ? -1 : 1;
            int pulseOdd  = (i % 2 == 0) ? 1 : -1;

            evenSum = Math.max(sequence[i] * pulseEven, evenSum + sequence[i] * pulseEven);
            oddSum  = Math.max(sequence[i] * pulseOdd, oddSum + sequence[i] * pulseOdd);

            maxSum = Math.max(maxSum, Math.max(evenSum, oddSum));
        }

        return maxSum;
}

}