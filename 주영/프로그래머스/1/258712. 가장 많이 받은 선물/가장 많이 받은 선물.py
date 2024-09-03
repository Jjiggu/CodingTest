def solution(friends, gifts):
    friends_cnt = len(friends)
    gift_score = [0] * friends_cnt
    answer = [0] * friends_cnt
    gift_lists = [[0] * friends_cnt for i in range(friends_cnt)]
    
    for now in gifts:   # 주고받은 선물
        give, get = now.split(' ')
        give, get = friends.index(give), friends.index(get)
        gift_lists[give][get] += 1
        
    reverse_gift_lists = list(map(list, zip(*gift_lists)))

    
    for temp in range(friends_cnt): # 선물 지수
        gift_score[temp] = sum(gift_lists[temp]) - sum(reverse_gift_lists[temp])
        
    
    for i in range(friends_cnt):
        for j in range(i, friends_cnt):
            if gift_lists[i][j] > gift_lists[j][i]:
                answer[i] += 1
            elif gift_lists[i][j] < gift_lists[j][i]:
                answer[j] += 1
            else:
                if gift_score[i] > gift_score[j]:
                    answer[i] += 1
                elif gift_score[i] < gift_score[j]:
                    answer[j] += 1
                    
    
    return max(answer)