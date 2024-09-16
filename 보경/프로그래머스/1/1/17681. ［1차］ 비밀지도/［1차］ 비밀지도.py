def solution(n, arr1, arr2):
    answer = []
    
    for i in range(len(arr1)):
        map_lst = []
        w = ''
        map_lst.append(str('0000000' + bin(arr1[i])[2:])[-n:])
        map_lst.append(str('0000000' + bin(arr2[i])[2:])[-n:])
        for k in range(n):
            if map_lst[0][k] == '1' or map_lst[1][k] == '1':
                w += '#'
            else:
                w += ' '
        answer.append(w)
    return answer