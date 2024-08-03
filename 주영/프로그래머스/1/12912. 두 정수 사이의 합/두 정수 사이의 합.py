def solution(a, b):
    if a<b:
        N = [i for i in range(a,b+1)]
    else:
        N = [i for i in range(b,a+1)]
    return sum(N)