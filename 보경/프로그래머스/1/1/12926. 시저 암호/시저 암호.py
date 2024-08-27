def solution(s, n):
    answer = ''
    s_lst = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j','k', 'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    S_lst = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    for w in s:
        if w == ' ':
            answer += ' '
        elif w in s_lst:
            ind = s_lst.index(w) + n
            answer += s_lst[(ind)%26]
        else:
            ind = S_lst.index(w) + n
            answer += S_lst[(ind)%26]
    return answer



# def solution(s, n):
#     lower_list = "abcdefghijklmnopqrstuvwxyz"
#     upper_list = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

#     result = []

#     for i in s:
#         if i is " ":
#             result.append(" ")
#         elif i.islower() is True:
#             new_ = lower_list.find(i) + n
#             result.append(lower_list[new_ % 26])
#         else:
#             new_ = upper_list.find(i) + n
#             result.append(upper_list[new_ % 26])
#     return "".join(result)