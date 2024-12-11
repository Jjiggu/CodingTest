def solution(participant, completion):
    
    # 해시 쓰지 않고 간단하게 풀 수 있음
    participant.sort()
    completion.sort()
    for p, c in zip(participant, completion):
        if p != c:
            return p
    return participant[-1]
    
# 효율성 테스트 통과한 코드 -> for문 사용이 너무 많음(블로그 참조한 코드)    
#     result = {}
    
#     for person in participant:
#         if person in result:
#             result[person] += 1
#         else:
#             result[person] = 1

#     for people in completion:
#         if people in result:
#             result[people] -= 1
    
#     for i in result:
#         if result[i] == 1:
#             return i
    

# 효율성 테스트 통과 못 한 코드 -> remove가 O(n)의 시간복잡도를 가짐
#     for index, element in enumerate(completion):
#         participant.remove(element)

#     return participant[0]

    
    