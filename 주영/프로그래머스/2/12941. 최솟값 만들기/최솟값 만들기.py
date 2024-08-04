def solution(A, B):

    A.sort()
    B.sort()
    answer_List = []
    for i in range(len(A)):
        num = A[i] * B[- (1+i)]
        answer_List.append(num)
    print(answer_List)
    return sum(answer_List)