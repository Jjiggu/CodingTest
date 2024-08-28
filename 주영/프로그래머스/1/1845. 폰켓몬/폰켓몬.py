def solution(nums):
    num_set = len(set(nums))
    N = len(nums) / 2

    if N > num_set:
        return num_set
    else:
        return int(N)