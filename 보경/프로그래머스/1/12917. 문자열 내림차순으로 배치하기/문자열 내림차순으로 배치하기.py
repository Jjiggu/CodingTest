def solution(s):
    answer = ''
    s_new = sorted(s, reverse = True)
    for word in s_new:
        answer += word
    return answer