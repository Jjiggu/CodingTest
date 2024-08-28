def solution(lottos, win_nums):

    win=[6,6,5,4,3,2,1]

    cnt = lottos.count(0)
    answer = 0
    for x in win_nums:
        if x in lottos:
            answer += 1
    return win[cnt + answer],win[answer]