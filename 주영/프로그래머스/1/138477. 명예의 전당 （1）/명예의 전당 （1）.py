def solution(k, score):
    record = []
    answer = []
    for i in score:
        if len(record) < k:
            record.append(i)
        else:
            if record[-1] < i:
                record.pop()
                record.append(i)
        record.sort(reverse=True)
        answer.append(record[-1])

    return answer