def solution(s):
    answer = ''
    t = s.split(' ')
    print(t)
    for i in t:
        for j in range(len(i)):
            if j&1==0:
                answer += i[j].upper()
            else:
                answer += i[j].lower()
        answer += ' '

    return answer[:-1]



# def solution(s):
#     answer = ''
#     s_lst = s.split(' ')
    
#     for s_p in s_lst: 
#         for i, word in enumerate(s_p):
#             if i % 2 == 0:
#                 answer += word.upper()
#             else:
#                 answer += word.lower()
#         answer += ' '

#     return answer.rstrip()