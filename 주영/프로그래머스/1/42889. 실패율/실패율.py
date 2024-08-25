def solution(N, stages):
    answer = []
    
    ratio = {} 
    allPlayer = len(stages) 
    
    for i in range(1,N+1):
        if allPlayer == 0: 
            ratio[i] = 0
        else:
            ratio[i] = stages.count(i)/allPlayer
            allPlayer -= stages.count(i)
        
    answer = sorted(ratio, key=lambda x : ratio[x],reverse=True)

    return answer