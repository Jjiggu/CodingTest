# 시간초과
def solution(n, works):
    answer = 0
    if sum(works)<=n:
        answer=0
    else:
        for i in range(n):
            works.sort(reverse=True)
            works[0]-=1
        for j in range(len(works)):
            answer+=works[j]**2
    return answer
# heap으로 해결
import heapq
def solution(n, works):
    answer = 0
    if sum(works)<=n:
        answer=0
    else:
        works=[-w for w in works]
        heapq.heapify(works)
        for i in range(n):
            work=heapq.heappop(works)
            heapq.heappush(works,work+1)
        for j in range(len(works)):
            answer+=works[j]**2
    return answer