def solution(a, b, n):
    change_coke = 0
    
    while (n >= a):
        change_coke += (n // a) * b
        left_coke = n % a
                 
        n = (n // a) * b + left_coke
    
    return change_coke