import math
def solution(progresses, speeds):
    answer = []
    process=[]
    limit=math.ceil((100 - progresses[0]) / speeds[0])
    done=0
    # 반복문 한번만 쓰도록 수정한 코드
    for i in range(len(progresses)):
        left=math.ceil((100 - progresses[i]) / speeds[i])
        done+=1
        if i==0 or limit<left:
            process.append(math.ceil((100 - progresses[i]) / speeds[i]))
            if i!=0:
                answer.append(done-1)
                limit=math.ceil((100 - progresses[i]) / speeds[i])
                done=1
        else:
            continue
    if left:
        answer.append(done)
    #2중 반복문 쓰던 코드 
#     while process:
#         done=1
#         limit=process.pop(0)
#         while process and process[0]<=limit:
#             process.pop(0)
#             done+=1
#         answer.append(done)
    
    return answer