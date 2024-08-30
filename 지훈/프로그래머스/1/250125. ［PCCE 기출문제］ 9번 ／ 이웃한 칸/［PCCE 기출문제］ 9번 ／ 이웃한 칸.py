def solution(board, h, w):
    answer = 0
    count = 0
    n = len(board)
    
    dh = [-1, 1, 0, 0] # 높이 변화(위, 아래, 왼쪽 오른쪽)
    dw = [0, 0, -1, 1] # 높이 변화(위, 아래, 왼쪽 오른쪽)
    
    ## 이런 식으로 설정하는게 더 좋은 방식인가?
    directions = [[0, -1], [0, 1], [-1, 0], [1, 0]]
    
    ## 좌표 설정
    for i in range(4):
        h_check = h + dh[i]
        w_check = w + dw[i]
        
        ## 색이 같은지 확인
        if (n > h_check >= 0) and (n > w_check >= 0):
                # if board[h][w] == board[h_check][w_check]:
                #     count += 1
                # if 사용 안하고 아래 코드처럼 처리 가능
                count += int(board[h][w] == board[h_check][w_check])
                
    
    # 답 저장
    answer = count
    
    return answer