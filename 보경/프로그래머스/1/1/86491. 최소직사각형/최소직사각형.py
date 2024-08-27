import numpy as np
def solution(sizes):
    answer = 0
    for w in sizes:
        w.sort()
    sizes = np.array(sizes)

    answer = int(max(sizes[:,0])) * int(max(sizes[:,1]))
    return answer