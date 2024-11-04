def solution(players, callings):
    answer = []
    index_dict = {players[i]:i for i in range(len(players))}
    
    for i in callings:
        now_index = index_dict[i]
        pre_index = now_index - 1
        
        tmp = players[now_index]
        players[now_index] = players[now_index - 1]
        players[now_index - 1] = tmp
        
        index_dict[i] = now_index - 1
        index_dict[players[now_index]] = now_index
        
        
        
    return players