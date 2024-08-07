def solution(A,B):
    result = 0
    
    A = sorted(A)
    B = sorted(B, reverse=True)
    
    # 최소가 되려면 가장 큰 수와 가장 작은수의 곱
    for i in range(len(A)):
        result += (A[i] * B[i])
    
    return result