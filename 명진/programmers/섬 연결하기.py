def solution(n, costs):
    answer = 0
    par = [i for i in range(n)]
    
    def find(x):
        if par[x] == x:
            return x
        par[x] = find(par[x])
        return par[x]
    
    def union(x, y):
        x, y = find(x), find(y)
        par[x] = y

    for u, v, c in sorted(costs, key=lambda x:x[2]):
        print(u,find(u), v,find(v))
        if find(u) != find(v):
            answer += c
            union(u, v)
    
    return answer