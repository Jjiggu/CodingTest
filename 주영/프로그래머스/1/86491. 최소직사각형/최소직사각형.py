def solution(sizes):
    for i in sizes:
        i.sort()
    a = [i[0] for i in sizes]
    b = [i[1] for i in sizes]
    return max(a)*max(b)