def solution(A, B):
    answer = 0
    A.sort(reverse=True)
    B.sort(reverse=True)
    for i in range(len(A)):
        if A[i]>=B[0]:
            continue
        else:
            answer+=1
            del B[0]
    return answer