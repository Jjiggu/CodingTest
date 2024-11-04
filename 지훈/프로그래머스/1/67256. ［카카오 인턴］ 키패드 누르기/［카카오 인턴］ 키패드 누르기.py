def solution(numbers, hand):
    
    phone_num = {1:[0, 0],
                 2:[0, 1],
                 3:[0, 2],
                 4:[1, 0],
                 5:[1, 1],
                 6:[1, 2],
                 7:[2, 0],
                 8:[2, 1],
                 9:[2, 2],
                 "*":[3, 0],
                 0:[3, 1],
                 "#":[3, 2] }
    
    result = ''
    left_hand = phone_num["*"]
    right_hand = phone_num["#"]
    l = [1, 4, 7]
    r = [3, 6, 9]
    
    for i in numbers:
        if i in l:
            left_hand = phone_num[i]
            result += "L"
            
        elif i in r:
            right_hand = phone_num[i]
            result += "R"
            
        else:
            now_left = phone_num[i]
            now_right = phone_num[i]
            
            left_dirt = abs(int(left_hand[0]) - int(now_left[0])) + abs(int(left_hand[1]) - int(now_left[1]))
            right_dirt = abs(int(right_hand[0]) - int(now_right[0])) + abs(int(right_hand[1]) - int(now_right[1]))
            
            if left_dirt < right_dirt:
                left_hand = phone_num[i]
                result += "L"
                
            if right_dirt < left_dirt:
                right_hand = phone_num[i]
                result += "R"
            
            if left_dirt == right_dirt:
                if hand == "left":
                    left_hand = phone_num[i]
                    result += "L"
                else:
                    right_hand = phone_num[i]
                    result += "R"
    
    return result
    
    
    