def solution(n):
    arr = list(str(n))
    arr.reverse()

    return list(map(int, arr))