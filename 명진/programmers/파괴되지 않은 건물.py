def solution(board, skill):
    answer = 0
    rows, columns = len(board), len(board[0])
    pref = [[0]*(columns+1) for _ in range(rows+1)]
    
    for t, r1, c1, r2, c2, d in skill:
        d *= (t*2-3)
        pref[r1][c1] += d
        pref[r1][c2+1] -= d
        pref[r2+1][c1] -= d
        pref[r2+1][c2+1] += d
        
    for i in range(rows):
        for j in range(columns):
            pref[i][j + 1] += pref[i][j]

    for j in range(columns):
        for i in range(rows):
            pref[i + 1][j] += pref[i][j]
            
    for r in range(rows):
        for c in range(columns):
            if board[r][c] + pref[r][c] > 0:
                answer += 1
        
    return answer