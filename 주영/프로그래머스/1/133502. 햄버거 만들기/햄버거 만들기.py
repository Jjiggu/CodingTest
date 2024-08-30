def solution(ingredient):
    # 빵 – 야채 – 고기 - 빵 : 1 - 2 - 3
    burger = [1,2,3,1]
    stack = []
    count = 0
    for i in ingredient:
        stack.append(i)
        if stack[-4:] == burger:
            count += 1
            stack.pop()
            stack.pop()
            stack.pop()
            stack.pop()

    return count