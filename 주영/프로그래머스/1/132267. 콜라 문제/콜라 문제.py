def solution(a, b, n):
    answer = 0
    while n >= a:
        answer += b
        n = n - a + b
    return answer