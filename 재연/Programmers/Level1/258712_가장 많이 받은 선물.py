def solution(friends, gifts):
    answer = 0
    gift_point={}
    gift_trade=[[0]*len(friends) for _ in range(len(friends))]
    next_year=[0]*len(friends)
    #선물 지수 담을 dic 초기화
    for friend in friends:
        gift_point[friend]=0
    for trade in gifts:
        #선물 지수 dic에 받은 사람은 -1 준 사람은 +1
        trade_people=trade.split();
        gift_point[trade_people[0]]+=1
        gift_point[trade_people[1]]-=1
        #서로 얼만큼 주고받았는지 배열에 저장
        gift_trade[friends.index(trade_people[0])][friends.index(trade_people[1])]+=1
    print(gift_trade)
    for i in range(len(friends)):
        for j in range(len(friends)):
            if i==j:
                continue
            elif gift_trade[i][j]>gift_trade[j][i]:
                next_year[i]+=1
            elif gift_trade[i][j]==gift_trade[j][i]:
                if gift_point[friends[i]]>gift_point[friends[j]]:
                    next_year[i]+=1

    answer=max(next_year)
    return answer