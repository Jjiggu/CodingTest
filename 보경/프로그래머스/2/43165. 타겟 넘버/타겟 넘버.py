# def solution(numbers, target):
#     count = 0
#     num = numbers[0]
#     i = 0
#     for v in [-1, 1]:
#         dfs(i, v*num, numbers, target)
#     return count

# def dfs(i, num, numbers, target):
#     if i == len(numbers)-1:
#         if num == target:
#             count += 1
#             return True
#         return False
#     i += 1
#     dfs(i, num + numbers[i], numbers, target)
#     dfs(i, num - numbers[i], numbers, target)


def solution(numbers, target):
    count = [0]  # count를 리스트로 정의하여 참조 가능하게 만듭니다.
    dfs(0, 0, numbers, target, count)  # 초기값을 0으로 설정
    return count[0]

def dfs(i, num, numbers, target, count):
    if i == len(numbers):
        if num == target:
            count[0] += 1
        return
    
    # 현재 인덱스의 숫자를 더하거나 빼는 두 가지 경우의 수를 재귀적으로 탐색
    dfs(i + 1, num + numbers[i], numbers, target, count)
    dfs(i + 1, num - numbers[i], numbers, target, count)
