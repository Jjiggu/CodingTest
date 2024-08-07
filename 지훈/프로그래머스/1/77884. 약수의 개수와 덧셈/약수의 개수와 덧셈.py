def solution(left, right):
    answer = 0
    num_count = 0
    
    for i in range(left, right + 1):
        for j in range(1, i + 1):
            if i % j == 0:
                num_count += 1
        if num_count % 2 == 0:
            answer += i
            num_count = 0
        elif num_count % 2 == 1:
            answer -= i
            num_count = 0
                
    
    return answer