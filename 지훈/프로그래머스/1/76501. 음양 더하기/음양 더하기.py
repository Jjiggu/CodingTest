def solution(absolutes, signs):
    result = 0
    
    for index, value in enumerate(signs):
        if value == False: # false인 경우 -1을 곱하여 음수로 만든 후 result에 더함
            result += absolutes[index] * (-1)
        else:
            result += absolutes[index] # true인 경우 그냥 result에 더함
            
    return result