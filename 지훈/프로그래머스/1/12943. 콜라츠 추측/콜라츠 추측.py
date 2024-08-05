def solution(num):
    for count in range(1, 501):
        if num == 1:
            return 0
            break
            
        elif count == 500:
            return -1
            break
            
        elif num % 2 == 0:
            num = num / 2
            if num == 1:
                return count

        elif num % 2 == 1:
            num = (3 * num) + 1
            if num == 1:
                return count