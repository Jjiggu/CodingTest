def solution(arr1, arr2):
    answer = []
    for arr_1, arr_2 in zip(arr1, arr2):
        temp = []
        for a1, a2 in zip(arr_1, arr_2):
            temp.append(a1+a2)
        answer.append(temp)
    return answer