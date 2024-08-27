def solution(a, b, n):
    # answer = coca_re(n, a, b)
    answer = 0
    
    while n >= a:
        new_n = (n//a)*b
        answer += new_n
        n = new_n + n%a
    
    return answer
    
# def coca_re(n, a, b):
#     new_n = (n//a)*b
#     if new_n + n%a < a:
#         return new_n
#     return new_n + coca_re(new_n+n%a, a, b)