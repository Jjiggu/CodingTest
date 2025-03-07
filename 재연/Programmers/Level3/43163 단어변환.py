from collections import deque

def solution(n, computers):
    answer = 0
    visited=[0 for i in range(n)]
    
    def bfs(i):
        q=deque()
        q.append(i)
        while q:
            i=q.popleft()
            visited[i]=1
            for j in range(n):
                if computers[i][j] and not visited[j]:
                    q.append(j)
                    
    for i in range(n):
        if not visited[i]:
            bfs(i)
            answer+=1
    
    return answer