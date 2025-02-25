def solution(data, ext, val_ext, sort_by):
    
    data_type = {
        "code" : 0,
        "date" : 1,
        "maximum" : 2,
        "remain" : 3
    }
    
    date_list = [i for i in data if i[data_type[ext]] < val_ext]
    
    return sorted(date_list, key=lambda x:x[data_type[sort_by]])