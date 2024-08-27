def solution(keymap, targets):
    answer = []
    
    dic = {}
    for i in range(len(keymap)):
        word = keymap[i]
        for j in range(len(word)):
            if word[j] not in dic.keys():
                dic[word[j]] = j + 1
            else:
                if dic[word[j]] > j:
                    dic[word[j]] = j + 1
    
    for i in range(len(targets)):
        target = targets[i]
        result = 0
        for j in range(len(target)):
            if target[j] in dic:
                result += dic[target[j]]
            else:
                result = -1
                break
                
        answer.append(result)
                    
    return answer