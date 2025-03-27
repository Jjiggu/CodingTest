from math import ceil


def solution(n, stations, w):
    cnt = 0
    coverage = 2 * w + 1
    left = 1
    for s in stations:
        right = max(s - w, left)
        cnt += ceil((right - left)/coverage)
        left = s + w + 1
    if left <= n:
        cnt += ceil((n - left + 1)/coverage)

    return cnt