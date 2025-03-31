def match(user,banned):
    if len(user)!=len(banned):
        return False
    for u, b in zip(user,banned):
        if b!='*' and u!=b:
            return False
    return True

def dfs(user_id, banned_id, index, path, visited, results):
    if index==len(banned_id):
        results.add(tuple(sorted(path)))
        return
    for i, user in enumerate(user_id):
        if not visited[i] and match(user, banned_id[index]):
            visited[i]=True
            dfs(user_id, banned_id, index+1, path+[user], visited, results)
            visited[i]=False
def solution(user_id, banned_id):
    results=set()
    dfs(user_id, banned_id, 0, [], [False]*len(user_id),results)
    return len(results)