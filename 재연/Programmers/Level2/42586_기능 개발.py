import math
import queue
def solution(progresses, speeds):
    answer = []
    process=queue.Queue()
    for i in range(len(progresses)):
        process.push(math.ceil((100-progresses[i]/speeds[i])))
    while(process):
        for i in range(process.qsize()):
            
                    
    
    # return answer
# while process로 감싸서
# 상단에서 가장 앞의 수를 저장해서
# 비교해서 그 수보다 작으면 pop하기
# 더 큰 수를 마주하는 순간 멈추고 answer에 값 저장
# 큐가 비워질때까지 반복