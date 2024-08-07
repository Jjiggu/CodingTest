def solution(a, b):
    answer = 1234567890
    
    dot_production = 0
    
    for i in range(len(a)):
        dot_production += a[i] * b[i]
    
    return dot_production