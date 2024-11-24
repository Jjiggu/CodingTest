from collections import deque
def solution(bridge_length, weight, truck_weights):
    
    answer = 0
    bridge=deque([0]*bridge_length)
    waiting=deque(truck_weights)
    bridge_weight=0
    
    while waiting:
        answer+=1
        bridge_weight-=bridge.popleft()
        
        if bridge_weight+waiting[0]<=weight:
            truck=waiting.popleft()
            bridge.append(truck)
            bridge_weight+=truck
        else:
            bridge.append(0)
    
    answer+=bridge_length
    return answer