def solution(commands):
    answer = []
    group=[[(i,j) for j in range(51)] for i in range(51)]
    word=[["EMPTY"]*51 for _ in range(51)]
    for command in commands:
        command=command.split(' ')
        if command[0]=='UPDATE':
            if len(command)==4:
                r,c,value=int(command[1]),int(command[2]),command[3]
                x,y=group[r][c]
                word[x][y]=value
            elif len(command)==3:
                value1,value2=command[1],command[2]
                for i in range(1,51):
                    for j in range(1,51):
                        if word[i][j]==value1:
                            word[i][j]=value2
        elif command[0]=='MERGE':
            r1,c1,r2,c2=int(command[1]),int(command[2]),int(command[3]),int(command[4])
            x1,y1=group[r1][c1]
            x2,y2=group[r2][c2]
            if word[x1][y1]=='EMPTY':
                word[x1][y1]=word[x2][y2]
            for i in range(1,51):
                for j in range(1,51):
                    if group[i][j]==(x2,y2):
                        group[i][j]=(x1,y1)
        elif command[0]=='UNMERGE':
            r,c=int(command[1]),int(command[2])
            x,y=group[r][c]
            tmp=word[x][y]
            for i in range(1,51):
                for j in range(1,51):
                    if group[i][j]==(x,y):
                        group[i][j]=(i,j)
                        word[i][j]='EMPTY'
            word[r][c]=tmp
        elif command[0]=='PRINT':
            r,c=int(command[1]), int(command[2])
            x,y=group[r][c]
            answer.append(word[x][y])
    return answer