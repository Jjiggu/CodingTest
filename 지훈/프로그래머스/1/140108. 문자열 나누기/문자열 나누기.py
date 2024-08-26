def solution(s):
    answer = 0
    
    count = 0
    other_count =0
    
    first_letter = ""
    s_list = []
    
    for i in s:
        if first_letter == "":
            first_letter = i
            count += 1
            continue
        
        if i == first_letter:
            count += 1
        else:
            other_count += 1
            
        if count == other_count:
            first_letter = ""
            answer += 1
            count = 0
            other_count =0
            
    if first_letter != "":
        answer += 1

        
        # if s[i] == first_letter:
        #     count += 1
        #     if count == other_count:
        #         first_letter = s[i + 1]
        #         all_count += 1
        #         break   
        # elif s[i] != first_letter:
        #     other_count += 1
        #     if count == other_count:
        #         first_letter = s[i + 1]
        #         all_count += 1
        #         break   
        
        
    
    return answer