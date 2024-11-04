def solution(cards1, cards2, goal):
    result = "No"
    test = []
    
    for i in goal:
        if len(cards1) != 0: 
            if cards1[0] == i:
                a = cards1.pop(0)
                test.append(a)
                
        if len(cards2) != 0:
            if cards2[0] == i:
                b = cards2.pop(0)
                test.append(b)
        
    if test == goal:
        return "Yes"
    else:
        return "No"
    