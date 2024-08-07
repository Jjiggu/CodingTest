def solution(s):
    stack = []
    answer = True
    for i in s:
        stack.append(i)
        if len(stack) > 1 and stack[-2]+stack[-1] == '()':          
            stack.pop()
            stack.pop()

    if len(stack) != 0:
        answer = False

    return answer