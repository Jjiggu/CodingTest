def solution(n, arr1, arr2):
    result = []
    binary_arr1 = []
    binary_arr2 = []
    and_result = []
    
    for ar1, ar2 in zip(arr1, arr2):
        binary_arr1 = format(ar1, 'b')
        binary_arr2 = format(ar2, 'b')
        
        and_result = format(int(binary_arr1, 2) | int(binary_arr2, 2), 'b')
        
        result.append(and_result.rjust(n, '0').replace('1', '#').replace('0', ' '))
    
    return result