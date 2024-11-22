import math
import queue
def solution(progresses, speeds):
    answer = []
    process=[]
    for i in range(len(progresses)):
        process.append(math.ceil((100 - progresses[i]) / speeds[i]))
    while process:
        done=1
        limit=process.pop(0)
        while process and process[0]<=limit:
            process.pop(0)
            done+=1
        answer.append(done)
    
    return answer