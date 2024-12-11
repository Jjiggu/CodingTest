import re

def solution(new_id):
    answer = ''
    second_filter = ["-", "_", "."]
    
    new_id = new_id.lower()
    
    for i in new_id:
        if i.isdigit() or i.isalpha() or i in second_filter:
            answer += i
    
    if ".." in answer:
        # answer.replace("..", ".")
        answer = re.sub('\.+', '.', answer)
        
    if answer[0] == ".":
        answer = answer[1:] if len(answer) > 1 else "."
    
    if answer[-1] == ".":
        answer = answer[0:-1]
        
    if len(answer) == 0:
        answer += "a"
    
    if len(answer) >= 16:
        answer = answer[:15]
        
    if answer[-1] == ".":
        answer = answer[:-1]
    
    if len(answer) <= 2:
        while(len(answer) <= 2):
            answer += answer[-1]
            
    return answer