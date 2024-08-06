def solution(s):
    n = int(len(s)/2)
    if len(s) % 2 == 0:
        answer = str(s[n-1:n+1])
    else:
        answer = str(s[n])
    return answer