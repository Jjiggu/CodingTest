def solution(board, skill):
    n = len(board)
    m = len(board[0])
    damage = [[0] * (m + 1) for _ in range(n + 1)]

    for t, r1, c1, r2, c2, degree in skill:
        if t == 1:
            degree = -degree
        damage[r1][c1] += degree
        damage[r1][c2 + 1] -= degree
        damage[r2 + 1][c1] -= degree
        damage[r2 + 1][c2 + 1] += degree

    for i in range(n):
        for j in range(m):
            damage[i][j + 1] += damage[i][j]

    for j in range(m):
        for i in range(n):
            damage[i + 1][j] += damage[i][j]

    intact_count = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] + damage[i][j] > 0:
                intact_count += 1

    return intact_count
