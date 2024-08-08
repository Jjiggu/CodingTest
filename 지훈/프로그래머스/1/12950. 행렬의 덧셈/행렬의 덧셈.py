import numpy as np

def solution(arr1, arr2):
    answer = [[]]
    
    A = np.array(arr1)
    B = np.array(arr2)
    
    answer = A + B
    
    return answer.tolist()