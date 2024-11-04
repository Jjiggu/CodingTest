def solution(X, Y):
    # 시관 초과 개선 코드
    # 공통 숫자 찾기 -> 중복된 숫자 있을 경우 체크하는 로직 필요
    same_num = set(X) & set(Y)
    
    if not same_num:
        return "-1"
    elif len(same_num) == 1 and "0" in same_num:
        return "0"

    # 중복된 숫자 있을 경우 체크
    result = [num * min(X.count(num), Y.count(num)) for num in same_num]
    
    # result 문자열을 내림차순으로 정렬하여 반환
    return "".join(sorted(result, reverse=True))


#     answer = ''
#     list_X = list(X)
#     list_Y = list(Y)
#     result = []
    
#     test = []
    
#     # X와 Y를 모두 탐색해야 해서 N^2 만큼의 시간복잡도 필요
      # 공통 숫자 찾아
#     for x in list_X:
#         if x in list_Y:
#             test.append(x)
#             list_Y.remove(x)
    
#     # 가장 큰 수(내림차순 정렬)
#     # result = sorted(list(set(list_X) & set(list_Y)), reverse=True)
#     result = sorted(test, reverse=True)
    
#     # max(list)로 최대숫자 찾기
#     if test == []:
#         return "-1"
#     else:
#         answer = "".join(result)
#         return str(int(answer))

    
    
    
