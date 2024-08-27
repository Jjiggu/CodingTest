def solution(numbers):
    answer = []
    for i in range(len(numbers)):
        for j in range(len(numbers) - i):
            if i == len(numbers)-j or i == j == 0:
                continue
            n = numbers[i] + numbers[(-1)*j]
            if n in answer:
                continue
            answer.append(n)
    answer = sorted(answer)
    return answer