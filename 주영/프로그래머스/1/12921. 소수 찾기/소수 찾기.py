def solution(n):
    answer=0
    # 1. 배열을 생성하여 값을 초기화 한다. 모든 수가 소수(True)인 것으로 초기화,
    array=[True for i in range(n+1)]
    
    # 약수의 성질에 따라 가운데 약수(제곱근)까지만 확인해도 됨
    for i in range(2,int(n**(1/2))+1):
        if array[i]==True: # i가 소수인 경우
        	# 2. 특정 숫자의 배수에 해당하는 숫자들을 지운다. (i를 제외한 모든 배수를 지우기)
            j = 2
            while i * j <= n:
            	# 배수들을 지워주는 과정
                array[i*j] = False
                j += 1
    # 4. 남아있는 숫자들(True값인 것들만) 개수를 세준다.
    for i in range(2,n+1):
        if array[i]:
            answer+=1

    return answer