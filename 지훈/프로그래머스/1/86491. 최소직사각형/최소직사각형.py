def solution(sizes):
    sorted_sizes = [sorted(i, reverse=True) for i in sizes]
    
    max_w = max(sub_arr[0] for sub_arr in sorted_sizes)
    max_h = max(sub_arr[1] for sub_arr in sorted_sizes)
    
    return max_w * max_h