def solution(s):
    s_list = s.split(" ")
    result = []
    
    for word in s_list:
        letter = ""
        for i in range(len(word)):
            if i % 2 == 0:
                letter += word[i].upper()
            else:
                letter += word[i].lower()
        
        result.append(letter)
    
    return " ".join(result)
