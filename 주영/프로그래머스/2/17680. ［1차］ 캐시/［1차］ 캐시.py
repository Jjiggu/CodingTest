from collections import deque

def solution(cacheSize, cities):
    answer = 0
    cache = deque(); city_low = [] 
    for city in cities:
        city_low.append(city.lower()) 
    for city in city_low:
        if cacheSize == 0:
            answer += 5 * len(city_low)
            break
        elif city in cache: 
            cache.remove(city)
            cache.append(city)
            answer += 1
        else:
            if len(cache) == cacheSize: 
                cache.popleft()
                cache.append(city)
                answer += 5 
            else:
                cache.append(city) 
                answer += 5
            
    
    return answer