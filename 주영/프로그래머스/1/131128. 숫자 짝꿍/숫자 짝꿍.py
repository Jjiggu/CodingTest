def solution(X, Y):
    answer = ''
    a = [0 for i in range(10)]
    b = [0 for i in range(10)]

    for i in X:
        a[int(i)] += 1

    for i in Y:
        b[int(i)] += 1

    for i in range(9,-1,-1):
        value = str(i) * min(a[i],b[i])
        answer += value

    if(len(answer) == 0):
        return '-1'

    if(answer[0] == '0'):
        return '0'


    return answer