def solution(wallpaper):
    answer = []
    y_index = []
    x_index = []
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == "#":
                x_index.append(j)
                y_index.append(i)
        
        
    answer.append(min(y_index))
    answer.append(min(x_index))
    answer.append(max(y_index) + 1)
    answer.append(max(x_index) + 1)
    
    return answer