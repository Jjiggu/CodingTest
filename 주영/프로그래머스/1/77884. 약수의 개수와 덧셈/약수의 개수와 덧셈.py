def solution(left, right):
    answer = 0
    def sol(n):
        count = 0
        for i in range(1,n):
            if n % i == 0:
                count += 1
        if count % 2:
            return True
        else:
            return False

    for i in range(left, right+1):
        if sol(i):
            answer += i
        else:
            answer -= i

    return answer