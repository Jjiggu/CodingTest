def solution(n):
    answer = 0
    three_n = ''
    
    # 3진수 변환 
    while(n > 0):
        three_n += str(n % 3)
        n = n // 3
    
    # 10진수 변환
    # for index, num in enumerate(three_n):
    #     answer += int(num) * pow(3, len(three_n) - index - 1)
    answer = int(three_n, 3)
    return answer