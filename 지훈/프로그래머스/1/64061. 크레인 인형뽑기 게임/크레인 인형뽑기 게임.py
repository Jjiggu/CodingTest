def solution(board, moves):
    board_list = [[] for i in range(len(board))]
    stack = []
    result = 0
    
    for i in board[::-1]:
        for j in range(len(i)):
            if i[j] != 0:
                board_list[j].append(i[j])
            
    for index in moves:
        if len(board_list[index - 1]) != 0:
            doll = board_list[index - 1].pop()
        
            if len(stack) != 0 and stack[-1] == doll:
                stack.pop()
                result += 2
            else:
                stack.append(doll)
    
    return result
        