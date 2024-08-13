def solution(number):
    # number가 나타낼 수 있는 모든 경우의 수 구하기
    # for문 돌면서 해당 경우 다 더하기
    # count에 1더하기
    answer = 0
    for i in range(len(number)-2):
        for j in range(i+1, len(number)-1):
            for k in range(j+1, len(number)):
                if number[i] + number[j] + number[k] == 0:
                    answer += 1
        
    return answer