def solution(strings, n):
    strings.sort(key = lambda x: (x[n], x))
    answer = strings.copy()
    return answer