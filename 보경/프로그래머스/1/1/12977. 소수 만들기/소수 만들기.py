import math

def solution(nums):
    answer = 0
    num_lst = []
    nums_len = len(nums)
    for i in range(nums_len-2):
        for j in range(i+1, nums_len-1):
            for k in range(j+1, nums_len):
                if is_prime(nums[i] + nums[j] + nums[k]) == True:
                    answer += 1

    return answer

def is_prime(n):
    if n == 2:
        return True
    if n <= 1:
        return False
    if n % 2 == 0:
        return False
    for n_i in range(3, int(math.sqrt(n))+1, 2):
        if n % n_i == 0:
            return False
    return True