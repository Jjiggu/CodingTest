def solution(numbers):
    answer = -1
    num_lst = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    for i in numbers:
        num_lst.remove(i)
    return sum(num_lst)