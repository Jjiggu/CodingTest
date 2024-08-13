def solution(tickets):
    tickets.sort(reverse=True)  # 사전 순으로 정렬 (역순)
    routes = {}  # 경로를 저장할 딕셔너리

    for a, b in tickets:
        if a in routes:
            routes[a].append(b)
        else:
            routes[a] = [b]

    for r in routes:
        routes[r].sort(reverse=True)  # 목적지를 역순으로 정렬

    stack = ["ICN"]
    answer = []

    while stack:
        top = stack[-1]
        if top not in routes or len(routes[top]) == 0:
            answer.append(stack.pop())
        else:
            stack.append(routes[top].pop())

    return answer[::-1]



# def solution(tickets):
#     answer = []
#     answer.append("ICN")
#     road = []
    
#     while len(answer) == len(tickets)+1:
#         temp = []
#         for i, [a,b] in enumerate(tickets):
#             if answer[-1] == a:
#                 temp.append([i, a, b])
#         temp = sorted(temp,key= lambda x : [x[2]])
#         i, a, b = temp[0]
#         answer.append(b)
#         tickets.remove(tickets[i])
        
#     return answer

# # def solution(tickets):
# #     answer = ['ICN']
# #     count = [0]
    
# #     if dfs(count, tickets, answer) == True:
# #         return answer
    
# #     return answer

# # def dfs(count, tickets, answer):
# #     if count[0] == len(tickets)+1:
# #         if len(answer) == len(tickets)+1:
# #             return False
# #         else:
# #             return True
# #     temp = []
# #     for i, [a,b] in enumerate(tickets):
# #         if answer[-1] == a:
# #             temp.append([i, a, b])
# #     temp = sorted(temp,key= lambda x : [x[2]])
    
# #     for i, a, b in temp:
# #         dfs(count, tickets, answer)