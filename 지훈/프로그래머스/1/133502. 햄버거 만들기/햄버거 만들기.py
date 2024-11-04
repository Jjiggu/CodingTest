def solution(ingredient):    
    # 햄버거 만드는 재료 순서 1 - 2 - 3 - 1
    stack = []
    result = 0
    for i in ingredient:
        stack.append(i)
        if stack[-4:] == [1, 2, 3, 1]:
            result += 1
            for _ in range(4):
                stack.pop()
    
    return result