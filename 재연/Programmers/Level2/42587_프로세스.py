from collections import deque
def solution(priorities, location):
    process=deque([(j,i) for i, j in enumerate(priorities)])
    #index와 그 값 process에 저장 process=(값, 초기 인덱스)
    answer = 0
    
    while process: 
        a=process.popleft() #대기 프로세스 순서대로 검사
        if process and a[0]<max(process)[0]: #나온 수가 대기 프로세스 최댓값보다 작으면 다시 queue에 넣음
            process.append(a)
        else: 
            answer+=1 #작지 않으면 answer값 하나씩 증가시키기
            if location==a[1]: #찾으려던 location의 값과 같으면 루프 중단
                break
    
    return answer