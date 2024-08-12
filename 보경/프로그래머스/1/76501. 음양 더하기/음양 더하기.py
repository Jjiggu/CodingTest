def solution(absolutes, signs):
    answer = 0
    index = 0
    for i in signs:
        if i == True: # "true"라 하면 틀림
            answer += absolutes[index]
        elif i == False: #"false"라 하면 틀림
            answer -= absolutes[index]
        index += 1
    return answer