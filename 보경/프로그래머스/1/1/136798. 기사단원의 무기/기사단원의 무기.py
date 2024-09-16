def get_power(num, limit, power):
    count = 0
    for j in range(1, int(num ** 0.5) + 1):
        if num % j == 0:
            count += 2
    if num ** 0.5 % 1 == 0:
        count -= 1
        
    # count = 0
    # n_h = int(num**(1/2))
    # for i in range(1, n_h+1):
    #     if num % i == 0:
    #         count += 2
    # if num**(1/2) % 1 == 0:
    #     count -=1
    
    return count

def solution(number, limit, power):
    answer = 0
    for num in range(1, number+1):
        n_power = get_power(num, limit, power)
        if n_power > limit:
            answer += power
        else:
            answer += n_power
        
    return answer