def solution(number, limit, power):
    answer = []
    for i in range(1,number+1):
        count = 0
        for j in range(1, int(i**(1/2)) + 1):
            if i % j == 0:
                count += 1
                if j**2 != i:
                    count += 1
            if count > limit:
                count = power
                break
        answer.append(count)

    return sum(answer)