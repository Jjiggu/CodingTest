def solution(t, p):
    answer = 0
    a = []
    n = len(p)
    for i in range(len(t)-n+1):
        a.append(t[i:i+n])
        if int(t[i:i + n]) <= int(p):
            answer += 1

    return answer