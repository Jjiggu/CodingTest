def solution(k, score):
    result = []
    tmp = []
        
    for i in range(len(score)):
        if len(tmp) < k:
            tmp.append(score[i])
            
        elif len(tmp) >= k and score[i] > min(tmp):
            tmp.remove(min(tmp))
            tmp.append(score[i])
        
        result.append(min(tmp))
        
    return result