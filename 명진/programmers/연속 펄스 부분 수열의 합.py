def solution(sequence):
    n = len(sequence)
    dp = [[sequence[i] * (1 if i % 2 else -1) for i in range(n)]]
    dp += [[sequence[i] * (-1 if i % 2 else 1) for i in range(n)]]

    answer = max(sequence[0], -sequence[0])
    for i in range(2):
        for j in range(1, n):
            dp[i][j] += max(0, dp[i][j-1])
            answer = max(answer, dp[i][j])

    return answer