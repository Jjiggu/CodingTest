def solution(board, moves):
    from collections import deque
    stack=[]
    answer = 0 
    for i in range (len(moves)):
        line=moves[i]-1
        for j in range(len(board)):
            if board[j][line]!=0:
                if stack:
                    if stack[-1]==board[j][line]:
                        stack.pop()
                        answer+=2
                        board[j][line]=0
                        break
                    else:
                        stack.append(board[j][line])
                        board[j][line]=0
                        break
                else:
                    stack.append(board[j][line])
                    board[j][line]=0
                    break
    return answer