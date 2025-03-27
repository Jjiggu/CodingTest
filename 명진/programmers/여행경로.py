from collections import deque


def solution(tickets):
    answer = []
    tickets.sort()
    numTickets = len(tickets)
    
    used = [False]*numTickets
    def dfs(path):
        if len(path) == numTickets+1:
            answer.append(path)
            return
        for i in range(numTickets):
            arr, dst = tickets[i]
            if arr == path[-1] and not used[i]:
                used[i] = True
                dfs(path+[dst])
                used[i] = False
    dfs(["ICN"])
    return answer[0]