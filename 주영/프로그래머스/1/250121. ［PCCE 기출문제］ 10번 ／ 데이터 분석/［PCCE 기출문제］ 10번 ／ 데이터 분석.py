def solution(data, ext, val_ext, sort_by):
    type_dic = {'code': 0 , 'date' : 1 , 'maximum' : 2, 'remain' :3}
    data = sorted(data, key = lambda x : x[type_dic[sort_by]])
    answer = []
    for val in data:
        if val[type_dic[ext]] <val_ext:
            answer.append(val)
    return answer