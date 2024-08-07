def solution(n):
    sqrt = int(n ** (1/2))
    
    if sqrt ** 2 == n:
        return int((sqrt + 1) ** 2)
    else:
        return -1