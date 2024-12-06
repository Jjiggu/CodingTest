def solution(s, skip, index):
    
    alps = sorted(set("abcdefghijklmnopqrstuvwxyz") - set(skip))
    alp_nums = len(alps)
    result = ''
    
    # s에서 문자 하나씩 출력 후 +1 index번 수행
    for letter in s:
        result += alps[(alps.index(letter) + index) % alp_nums]
        
    return result