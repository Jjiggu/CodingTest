def solution(t, p):
    # t, p 받아오기
    # t 슬라이싱하기 p길이만큼
    # 
    # 문자열 숫자열로 바꾸고 크기 비교하기
    count = 0
    print('c')
    for i in range(len(t) - len(p) + 1):
        if int(t[i:i+len(p)]) <= int(p):
            count += 1
    
    return count