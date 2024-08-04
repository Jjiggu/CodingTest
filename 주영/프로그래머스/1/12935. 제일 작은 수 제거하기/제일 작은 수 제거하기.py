def solution(arr):
    min_index = arr.index(min(arr))
    arr.pop(min_index)
    if len(arr) == 0:
        arr.append(-1)
    return arr