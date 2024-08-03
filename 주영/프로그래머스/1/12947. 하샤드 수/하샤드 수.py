def solution(x):
    answer = True
    N = str(x)
    sum_n = sum([int(i) for i in N])
    if x % sum_n != 0:
        answer = False
    return answer