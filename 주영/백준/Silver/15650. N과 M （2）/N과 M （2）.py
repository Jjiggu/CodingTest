N, M = map(int,input().split())

result = [0]*M
isused = [False]*(N+1) # n까지의 자연수가 필요한거니까 인덱스 0부터이므로 n+1개


def recursive(level, num):
    if level == M:
        for i in range(0, M):
            print(result[i], end = ' ') 
        print('')
        return         #재귀에서 빠져나오려면 return 해줘야 함

    
        
    
    for i in range(num, N+1):
        result[level] = i
        recursive(level+1, i+1)
        

recursive(0,1)
