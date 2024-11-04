def solution(s):
    answer = []
    
    answer_list = []
    copy_list = []
    
    answer_dic = {}
    
    for index, el in enumerate(s):
        if el not in answer_dic:
            answer_list.append(-1)
            copy_list.append(el)
        else:
            answer_list.append(index - answer_dic[el])
            
        answer_dic[el] = index
        
        # if i not in copy_list:
        #     copy_list.append(i)
        #     for letter in copy_list[::-1]:
        #         if letter == i:
        #             answer_list.append(letter)
        #             # answer_list.append(len(answer_list) - index)
        #             # answer_list.append(0)
        # else:    
        #     answer_list.append(-1)
        #     copy_list.append(i)
        
    
    return answer_list