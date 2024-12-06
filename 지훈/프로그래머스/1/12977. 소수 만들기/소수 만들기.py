from itertools import combinations
def solution(nums):
    answer = 0
    
    for i in combinations(nums, 3):
        prime_number = sum(i)
        cnt = 0    
        
        for i in range(1, int(prime_number**0.5 + 1)):
            if prime_number % i == 0:
                cnt += 1
                           
        if cnt == 1:
            answer += 1   

    return answer