def is_prime(num):
    if num==0 or num==1:
        return False
    else:
        for n in range(2, (num//2)+1):      # math를 사용하지 않고 (num//2)+1 까지로 설정
            if num%n == 0:
                return False

        return True

def solution(numbers):
    from itertools import combinations as cb

    answer = []
    count = 0
    for i,j,z in cb(numbers,3):
        if i+j+z not in answer and is_prime(i+j+z):
            count += 1

    return count