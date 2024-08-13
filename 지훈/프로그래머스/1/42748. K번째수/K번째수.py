def solution(array, commands):
    answer = []
    result = []
    
    # 배열 하나씩 뽑음
    for i, j, k in commands:
        sorted_list = sorted(array[i - 1 : j])
        result.append(sorted_list[k - 1])
    return result