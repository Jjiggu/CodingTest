def solution(arr, divisor):
    answer = []
    for index in arr:
        if index % divisor == 0:
            answer.append(index)
    answer.sort()

    if len(answer) == 0:
        answer.append(-1)

    return answer

print(solution([3,2,6], 10))