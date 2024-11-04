def solution(lottos, win_nums):
    answer = []
    unknow_num = lottos.count(0)
    correct_num = 0
    ranking = {6:1,
              5:2,
              4:3,
              3:4,
              2:5,
              1:6,
              0:6}
    
    
    for i in lottos:
        if i in win_nums:
            correct_num += 1

    return ranking[correct_num + unknow_num], ranking[correct_num]