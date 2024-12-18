from collections import deque
def solution(prices):
    queue=deque(prices)
    answer = []
    while queue:
        c_price=queue.popleft()
        d=0
        for price in queue:
            d+=1
            if c_price>price:
                break
        answer.append(d)         
    return answer