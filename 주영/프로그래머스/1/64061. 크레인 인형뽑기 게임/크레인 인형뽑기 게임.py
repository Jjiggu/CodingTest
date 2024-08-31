def solution(board, moves):
    count = 0
    stack = []

    for move in moves:
        X = 0
        Y = move-1
        while board[X][Y] == 0:
            if X == len(board)-1:
                break
            X += 1
        if board[X][Y] != 0:
            stack.append(board[X][Y])

        if len(stack) > 1:
            if stack[-1]==stack[-2]:
                stack.pop(-1)
                stack.pop(-1)
                count += 2

        board[X][Y] = 0

    return count

print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
               , [1,5,3,5,1,2,1,4]))