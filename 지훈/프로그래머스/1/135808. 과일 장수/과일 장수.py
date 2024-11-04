def solution(k, m, score):
    score.sort(reverse = True)
    box_count = (len(score) // m) * m
    result = 0
    
    for i in range(0, box_count, m):
        result += m * min(score[i: i + m])
        
    return result
    