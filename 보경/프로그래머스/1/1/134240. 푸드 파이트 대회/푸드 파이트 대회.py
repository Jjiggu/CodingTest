def solution(food):
    answer = []
    food_lst = []

    for i in range(1, len(food)):
        a = int(food[i])
        if a % 2 != 0:
            a -= 1
        food_lst.append(a // 2)
            
    
    answer = ''
    a = 0
    for i in food_lst: #횟수
        a += 1
        for j in range(i):
            answer += str(a)
    
    # print(answer[1:])
    temp = answer
    answer += '0'
    # print(temp[::-1])
    answer += temp[::-1]
    
        
    return answer