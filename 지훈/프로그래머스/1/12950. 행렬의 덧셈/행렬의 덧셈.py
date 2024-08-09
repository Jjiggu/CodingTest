import numpy as np

def solution(arr1, arr2):
    answer = [[]]
    
    A = np.array(arr1)
    B = np.array(arr2)
    
    answer = A + B
    
    return answer.tolist()

    # result = [[c + d for c, d in zip(ar1, ar2)] for ar1, ar2 in zip(arr1, arr2)]
    #
    # return result