def solution(babbling):
    result = 0
    possible_list = ["aya", "ye", "woo", "ma"]
    
    for i in range(len(babbling)):
        for word in possible_list:
            if word * 2 not in babbling[i]:
                babbling[i] = babbling[i].replace(word, "*")
                
        if all(char == "*" for char in babbling[i]):
            result += 1
        
    return result