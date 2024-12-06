def solution(N, stages):
    
    # 실패율 = 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    # N = 전체 스테이지 수, N + 1은 N번째 스테이지까지 클리어 한 사용자
    # stages = 사용자가 멈춰있는 스테이지의 번호
    # 클리어 하지 못한 플레이어의 수 = 스테이지 번호보다 작거나 같은 수를 가진 플레이어
    # 스테이지에 도달 한 플레이어의 수 = 스테이지 번호보다 큰 수를 가진 플레이어

    result = []
    stage_dict = {i : 0 for i in range(1, N + 1)}
    
    for i in range(1, N + 1):
        nonclear = 0
        clear = 0
        for j in stages:
            if j == i:
                nonclear += 1
            if j >= i:
                clear += 1
        
        if clear == 0:
            stage_dict[i] = 0    
        else:
            stage_dict[i] = nonclear / clear
    
    result = sorted(stage_dict.items(), reverse=True, key = lambda x:x[1])
    
    print(result)
    return list(floor[0] for floor in result)