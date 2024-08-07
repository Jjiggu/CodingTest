def solution(n):
    answer = -1

    for i in range(1,n+1):
        if n / i == i:
            return (i+1)*(i+1)

    return answer