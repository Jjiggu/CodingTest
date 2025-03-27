def solution(routes):
    answer = 1
#    차가 나오는 지점을 기준으로 오름차순 정렬
    routes.sort(key=lambda x:x[1])
# 작은 수를 기준으로 검사
    section=routes[0]
    for i in range(1,len(routes)):
#         나오는 지점이 가장 작은 아이보다 차가 들어가는 지점이 크면 카메라 수 늘리기, 기준 변경
        if routes[i][0]>section[1]:
            answer+=1
            section=routes[i]
    return answer