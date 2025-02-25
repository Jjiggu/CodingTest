def solution(board, h, w):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    result = 0
    color = board[h][w]
    
    for i in range(4):
        nx = h + dx[i]
        ny = w + dy[i]
        
        if 0 <= nx < len(board) and 0 <= ny < len(board):
            if board[nx][ny] == color:
                result += 1
                
    return result