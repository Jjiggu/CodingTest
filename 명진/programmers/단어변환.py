from collections import deque


def solution(begin, target, words):
    if target not in words:
        return 0

    len_w = len(begin)
    q = deque()
    q.append((begin, 0))
    while q:
        cur, dist = q.popleft()
        if cur == target:
            return dist
        for w in words:
            diff = 0
            for i in range(len_w):
                if w[i] != cur[i]:
                    diff += 1
            if diff == 1:
                q.append((w, dist+1))

    return 0