def solution(s):
    answer = 0
    lst = []
    count_lst = []
    
    for w in s:
        if not lst:
            lst.append(w)
            count_lst.append(1)
            count_lst.append(0)
        else:
            if w == lst[0]:
                count_lst[0] += 1
                lst.append(w)
            else:
                count_lst[1] += 1
                lst.append(w)
        
        if count_lst[0] == count_lst[1]:
            answer += 1
            lst = []
            count_lst = []
    
    if lst:
        answer += 1
    
    return answer