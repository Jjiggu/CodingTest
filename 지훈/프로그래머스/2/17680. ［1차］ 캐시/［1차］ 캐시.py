from collections import deque

def solution(cacheSize, cities):
    answer = 0
    q = deque(maxlen=cacheSize)
    
    
    
    for i in cities:
        i = i.lower()
        # 캐시 miss인 경우
        if i in q:
            answer += 1
            q.remove(i)
            q.append(i)
        else:
            # cache miss
            answer += 5
            q.append(i)
    print(q)
    return answer