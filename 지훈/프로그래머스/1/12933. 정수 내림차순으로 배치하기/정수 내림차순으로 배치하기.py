def solution(n):
    result = sorted(list(str(n)), reverse=True)
    
    return int("".join(result))