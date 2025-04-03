# 구글링 =>플루이드 와샬
def solution(n, results):
    answer = 0
    ranks=[[0]* n for _ in range(n)]
    
    for winner,loser in results:
        ranks[winner-1][loser-1]=1
        ranks[loser-1][winner-1]=-1
        
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if j==k:
                    continue
                if ranks[j][k]!=0:
                    continue
                if ranks[j][i]==1 and ranks[i][k]==1:
                    ranks[j][k]=1
                    ranks[k][j]=-1
    for rank in ranks:
        if rank.count(0)==1:
            answer+=1
    return answer