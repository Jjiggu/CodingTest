# def solution(n, lost, reserve):
#     answer = n
#     lost = sorted(lost)
#     reserve = sorted(reserve)
#     for num in lost:
#         if num-1 in reserve:
#             reserve.remove(num-1)
#         elif num+1 in reserve:
#             reserve.remove(num+1)
#         else:
#             answer -= 1
#     return answer

def solution(n, lost, reserve):
    # 중복된 학생(여벌 체육복이 있지만 도난당한 학생)을 먼저 처리
    lost_set = set(lost) - set(reserve)
    reserve_set = set(reserve) - set(lost)

    # 체육복을 빌려줄 수 있는지 확인하며 처리
    for num in sorted(lost_set):
        if num - 1 in reserve_set:
            reserve_set.remove(num - 1)
        elif num + 1 in reserve_set:
            reserve_set.remove(num + 1)
        else:
            n -= 1
    
    return n
