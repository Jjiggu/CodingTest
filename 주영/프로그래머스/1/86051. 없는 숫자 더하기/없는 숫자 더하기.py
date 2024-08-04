def solution(numbers):
    answer = 0
    numbers.sort()
    a = [False] * 10

    for i in numbers: # 1~7
        a[i] = True

    for i in range(len(a)):
        if a[i] == False: answer += i

    return answer