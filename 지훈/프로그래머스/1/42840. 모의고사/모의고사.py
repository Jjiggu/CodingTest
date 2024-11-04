def solution(answers):
    first_supo = "12345"
    second_supo = "21232425"
    third_supo = "3311224455"
    
    correct_list = [0, 0, 0]
    result = []
    
    for i in range(len(answers)):
        if answers[i] == int(first_supo[i % len(first_supo)]):
            correct_list[0] += 1
            
        if answers[i] == int(second_supo[i % len(second_supo)]):
            correct_list[1] += 1
            
        if answers[i] == int(third_supo[i % len(third_supo)]):
            correct_list[2] += 1
    
    for i in range(len(correct_list)):
        if correct_list[i] == max(correct_list):
            result.append(i + 1)
    
    return result
    