def solution(name, yearning, photo):
    answer = []
    dic = {}
    for n in range(len(name)):
        dic[name[n]] = yearning[n]

    for i in photo:
        sum = 0
        for j in i:
            if j in dic:
                sum += dic[j]
        answer.append(sum)
    return answer