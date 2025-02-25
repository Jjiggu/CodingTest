import math

def is_prime(num):
    for i in range (2, int(math.sqrt(num)) + 1):
    	if num % i == 0:
        	return False
    return True
    
    
def solution(n, k):
    result = 0
    
    if k == 10:
        num = str(n)  
    else:
        num = ""
        temp = n
        
        while temp > 0:
            temp, mod = divmod(temp, k)
            num += str(mod)
        
        num = num[::-1]
    
    # 0 단위로 슬라이스 해서 소수 판별해야 할 듯?
    prime = num.split("0")
    prime_list = [prime_num for prime_num in prime if prime_num and is_prime(int(prime_num))]
    
    for j in prime_list:
        if j != '1':
            result += 1
    
    return result