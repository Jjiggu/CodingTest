def solution(stones, k):
    def check(x):
        jump = 0
        for st in stones:
            if st - x + 1 <= 0:
                jump += 1
                if jump >= k:
                    return False
            else:
                jump = 0
        return True

    l, r = 1, 200_000_000
    while l + 1 < r:
        m = (l + r) // 2
        if check(m):
            l = m
        else:
            r = m

    return l
