def solution(n, results):
    answer = 0
    g = [[0]*(n) for _ in range(n)]
    for w, l in results:
        g[w-1][l-1] = 1
    for k in range(n):
        for i in range(n):
            for j in range(n):
                if g[i][k] and g[k][j]:
                    g[i][j] = 1
    
    for i in range(n):
        cnt = 0
        for j in range(n):
            cnt += g[i][j] + g[j][i]
        if cnt == n-1:
            answer += 1
        
    
    return answer