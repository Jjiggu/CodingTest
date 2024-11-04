def solution(n, m, section):
    result = 0
    tmp = 0
    
    for j in section:
        if j > tmp and tmp < n:
            result += 1
            tmp = j + m - 1
    
    return result
        
    