def solution(a, b):
    answer = 0
    for a_i, b_i in zip(a, b):
        answer += a_i*b_i
    return answer