def canAfford(n, t, times):
    cnt = 0
    for time in times:
        cnt += t // time
        if cnt >= n:
            return True;
    return False

def solution(n, times):
    l, r = 1, max(times)*n
    while l + 1 < r:
        m = (l + r) // 2
        if (canAfford(n, m, times)):
            r = m
        else:
            l = m
    
    return r