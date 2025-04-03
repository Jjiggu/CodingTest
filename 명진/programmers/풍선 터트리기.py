def solution(a):
    n = len(a)
    # min from Left, Right
    mL = [*a]
    mR = [*a]
    for i in range(1, n):
        mL[i] = min(mL[i-1], mL[i])
    for i in range(n-2, -1, -1):
        mR[i] = min(mR[i+1], mR[i])

    return n - sum([int(a[i] > mL[i] and a[i] > mR[i]) for i in range(n)])