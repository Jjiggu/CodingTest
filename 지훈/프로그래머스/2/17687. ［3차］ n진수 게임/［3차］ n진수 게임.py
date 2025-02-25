def solution(n, t, m, p):
    answer = ''
    result = ""
    text_list = []
    hex_dict = {k:v for k,v in zip(range(16),"0123456789ABCDEF")}
    
    # 숫자 말하는 순서 : (p + (m * 현재턴(0~t-1)))
    # 숫자 진수로 변환 -> m * (t-1) 까지
    
    max_num = m * t
    rev_base = ''
    
    for i in range(max_num):
        num = i
        rev_base = ''
        
        if num == 0:
            rev_base += "0"
        while i > 0:
            i, mod = divmod(i, n)
            
            rev_base += hex_dict[mod]

        answer += "".join(rev_base[::-1])

    for j in range(t):
        result += answer[p + (m * j) - 1]
    
    
    return result