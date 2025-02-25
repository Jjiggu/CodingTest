def solution(keymap, targets):
    answer = []
    alp_key = dict()
    
    for row in keymap:
        for idx, alp in enumerate(row):
            if(alp in alp_key) and (idx + 1) > alp_key[alp]:
                continue
            
            alp_key[alp] = idx + 1
    # tagerts 에서 하나 꺼내옴
    for target in targets:
        total_index = 0
        for word in target:
            # tagets의 원소와 keymap에 있는 원소 반복문 돌리면서 확인
            # 찾으면 카운트 증가 다 돌았는데 못찾으면 -1 반환
            if word in alp_key:
                total_index += alp_key[word]
            else:
                total_index = -1
                break
        answer.append(total_index)
                
    return answer