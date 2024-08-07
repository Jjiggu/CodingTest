def solution(numbers):
    answer = -1
    num_list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    
    for i in numbers:
        num_list.remove(i)
    
    answer = sum(num_list)
    
    return answer