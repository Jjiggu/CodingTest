def solution(food):
    first_man = ''

    for i in range(1, len(food)):
        num_food = food[i] // 2
        first_man += str(i) * num_food
    
    second_man = first_man[::-1]
    
    
    return first_man + "0" + second_man