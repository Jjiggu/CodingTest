def solution(n):
    arr = list(str(n))
    arr.sort(reverse=True)
    new = ''.join(map(str, arr))

    return int(new)