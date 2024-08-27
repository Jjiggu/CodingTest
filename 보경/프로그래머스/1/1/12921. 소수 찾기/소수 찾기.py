import math

def solution(n):
    count = 0
    for num in range(1, n+1):
        if is_prime(num) == True:
            count += 1
    return count


def is_prime(n):
    if n == 2:
        return True
    if n <= 1:
        return False
    if n % 2 == 0:
        return False
    for i in range(3, int(math.sqrt(n))+1, 2):
        if n % i == 0:
            return False
    return True