def solution(answers):
    answer = [0 for i in range(3)]
    first = [1,2,3,4,5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]

    for i in range(len(answers)):
        if first[i % len(first)] == answers[i]:
            answer[0] += 1
        if second[i % len(second)] == answers[i]:
            answer[1] += 1
        if third[i % len(third)] == answers[i]:
            answer[2] += 1

    result = []
    for i in range(len(answer)):
        if(answer[i] == max(answer)):
            result.append(i+1)

    return sorted(result)
