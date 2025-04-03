def solution(a):
    answer = 2
    if len(a)<=2:
        return len(a)
    
    left=a[0]
    right=a[-1]
    
    for i in range(1,len(a)-1):
        if left>a[i]:
            left=a[i]
            answer+=1
        if right>a[-1-i]:
            right=a[-1-i]
            answer+=1
    if left==right:
        return answer-1
    return answer