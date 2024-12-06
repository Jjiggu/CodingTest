def solution(n, lost, reserve):
    # 배열 정렬
    lost = sorted(lost)
    reserve = sorted(reserve)
    
    # 여분 체육복 가져 온 학생 중 도난당한 학생 확인
    for pos in reserve[:]:
        if pos in lost:
            reserve.remove(pos)
            lost.remove(pos)
    
    # 체육복 빌려주기
    for i in reserve:
        if i-1 in lost:
            lost.remove(i-1)
        elif i + 1 in lost:
            lost.remove(i+1)
    
    return n - len(lost)
    