def solution(n, m):
    answer = []
    a = []
    for i in range(1,m+1):
        if n%i == 0 and m%i == 0:
            a.append(i)

    answer.append(max(a))

    for i in range(max(n,m),n*m+1):
        if i%n == 0 and i%m == 0:
            answer.append(i)
            break

    return answer