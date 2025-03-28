class Solution {
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