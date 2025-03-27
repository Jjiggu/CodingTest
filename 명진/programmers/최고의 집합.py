def solution(n, s):
    answer = []
    if n > s:
        return [-1]
    answer = [s//n]*n
    for i in range(1, s%n+1):
        answer[-i] += 1
    return answer