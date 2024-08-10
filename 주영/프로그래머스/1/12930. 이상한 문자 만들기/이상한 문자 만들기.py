def solution(s):
    answer = []
    s = s.split(' ')
    for i in range(len(s)):
        n = list(s[i])
        temp = ''
        for j in range(len(n)):
            if j % 2 == 0:
                temp += n[j].upper()
            else:
                temp += n[j].lower()
        answer.append(temp)

    return ' '.join(answer)