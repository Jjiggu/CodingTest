import heapq as hq


def solution(jobs):
    answer = 0
    done = cur = 0
    lastT = -1
    n = len(jobs)
    
    pq = []
    
    while done < n:
        for s, l in jobs:
            if lastT < s <= cur:
                hq.heappush(pq, [l, s])
        if pq:
            l, s = hq.heappop(pq)
            lastT = cur
            cur += l
            answer += cur - s
            done += 1
            continue
        cur += 1
    
    return answer // n