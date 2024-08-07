def solution(s):
    s = s.split(" ")
    sorted_s = sorted([int(i) for i in s])  # 굳이 정렬 안해도 될 듯

    return f"{sorted_s[0]} {sorted_s[-1]}"
    # return f"{min(sorted_s)} {max(sorted_s)}"