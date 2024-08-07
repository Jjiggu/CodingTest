def solution(x):
    hashadnum = sum([int(i) for i in str(x)])
    
    if x % hashadnum == 0:
        return True
    else:
        return False