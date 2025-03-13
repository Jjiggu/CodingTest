from bisect import bisect_right as br


def solution(A, B):
    answer = 0
    B.sort()
    for n in A:
        selected = br(B, n)
        if selected < len(B):
            del B[selected]
            answer += 1
    return answer