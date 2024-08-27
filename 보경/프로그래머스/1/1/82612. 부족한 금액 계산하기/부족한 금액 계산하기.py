def solution(price, money, count):
    answer = 0
    for i in range(1, count+1):
        answer += price * i
    if answer - money > 0:
        return answer - money
    else:
        return 0