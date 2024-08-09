def solution(d, budget):
    d = sorted(d)
    current_budget = 0
    cnt = 0
    
    for i in d:
        current_budget += i
        
        if current_budget > budget:
            return cnt
        
        else:
            cnt += 1
    
    return cnt