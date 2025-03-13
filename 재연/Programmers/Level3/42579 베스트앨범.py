def solution(genres, plays):
    answer = []
    #배열에 [장르이름, 재생 횟수, 처음 인덱스]순으로 담아서 저장
    genre_play=[[genre,play,idx]for idx,(genre,play) in enumerate(zip(genres,plays))] 
    #genre_play 배열 먼저 장르 이름대로 배열하고, 재생횟수 내림차순 정렬
    genre_play=sorted(genre_play,key=lambda x: (x[0],-x[1],x[2]))
    #genre 종류 중복 없이 뽑아내기
    genre_cate=set(genres)
    play_sum=[]
    for genre in genre_cate:
        sum=0
        for i in range (len(genre_play)):
            if genre==genre_play[i][0]:
                sum+=genre_play[i][1]
        play_sum.append([genre,sum])
    
    play_sum=sorted(play_sum, key=lambda x: -x[1])
    
    for i in range(len(play_sum)):
        count=0
        for j in range(len(genre_play)):
            if play_sum[i][0]==genre_play[j][0]:
                if count==2:
                    break
                answer.append(genre_play[j][2])
                count+=1
                        
    return answer