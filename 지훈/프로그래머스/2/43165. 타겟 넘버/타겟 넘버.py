def solution(numbers, target):
    result = [0]
    
    for i in range(len(numbers)):
        tmp = []
        for j in range(len(result)):
            tmp.append(result[j] + numbers[i])
            tmp.append(result[j] - numbers[i])        
        result = tmp
    
    return result.count(target)