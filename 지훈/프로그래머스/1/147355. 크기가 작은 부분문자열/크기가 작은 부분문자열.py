def solution(t, p):
    part_t_list = []
    result = 0
    
    for i in range(len(t) - len(p) + 1):
        part_t_list.append(int(t[i:i + len(p)]))
        
        if int(t[i:i + len(p)]) <= int(p):
            result += 1
            
    return result
