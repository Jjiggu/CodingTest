import heapq as hq


def solution(n, works):
    answer = 0
    q = [*map(lambda x:-x, works)]
    hq.heapify(q)

    for i in range(n):
        hardest = hq.heappop(q)
        if hardest >= 0:
            return 0
        hq.heappush(q, hardest+1)

    for work in q:
        answer += work**2
    return answer