def solution(n, computers):
    group = [i for i in range(n)]
    for i in range(n):
        for j in range(n):
            if computers[i][j]:
                for k in range(n):
                    if group[k] == group[i]:
                        group[k] = group[j]
    return len({*group})