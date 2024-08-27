def solution(nums):
    N = len(nums)//2 # 가질 수 있는 폰켓몬 수
    p_num = len(list(set(nums))) # 폰켓몬 종류 수
    
    if N < p_num:
        return N
    else:
        return p_num
    