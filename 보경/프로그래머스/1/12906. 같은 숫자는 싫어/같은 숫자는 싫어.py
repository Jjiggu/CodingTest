def solution(arr):
    answer = []
    for i in range(1, len(arr)):
        if arr[i] == arr[i-1]:
            arr[i-1] = ''
    for i in arr:
        if i != '':
            answer.append(i)
    return answer

