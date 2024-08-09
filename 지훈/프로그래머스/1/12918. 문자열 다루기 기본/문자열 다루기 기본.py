from string import ascii_lowercase
def solution(s):
#     answer = True
#     alphabet_list = list(ascii_lowercase)
#     s = s.lower()
    
#     if len(s) == 4 or len(s) == 6:
#         for i in s:
#             if i in alphabet_list:
#                 return False
#                 break
#     else:
#         return False
                
#     return True

    try:
        int(s)
    except:
        return False
    return len(s) == 4 or len(s) == 6 
