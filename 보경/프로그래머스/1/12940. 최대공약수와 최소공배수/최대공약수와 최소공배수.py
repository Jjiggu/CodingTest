def solution(n, m):
    answer = []
    # 최대공약수
    max_num = 0
    for i in range(1, min(n, m)+1):
        if n % i == 0 and m % i == 0:
            max_num = i
    answer.append(max_num)
    
    # 최소공배수
    for j in range(min(n,m), n*m+1):
        if j % n == 0 and j % m == 0:
            answer.append(j)
            break
    return answer

