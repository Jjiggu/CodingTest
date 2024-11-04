def count_divisors(n):
    """
    주어진 숫자 n의 약수 개수를 반환하는 함수.
    """
    count = 0
    for i in range(1, int(n**0.5) + 1):
        if n % i == 0:
            count += 1
            if i != n // i:  # n이 완전 제곱수가 아닐 때
                count += 1
    return count


def solution(number, limit, power):
    divisors = []
    
    for i in range(1, number + 1):
        attack_power = count_divisors(i)
        
        if attack_power > limit:
            divisors.append(power)
        else:
            divisors.append(count_divisors(i))
    
    return sum(divisors)
    