def solution(id_list, report, k):
    answer = []
    reported_people = []        # 신고당한 사람 리스트
    stoped_people = []          # 정지된 사람 리스트 (신고당한 사람 중에서 정지된 사람)
    good_people = []            # 신고 잘 한 사람 리스트
    
    report = set(report)
    report = list(report)

    for i in range(len(report)):
        tmp = report[i].split(" ")
        reported_people.append(tmp[1])
    
    for i in range(len(id_list)):
        if reported_people.count(id_list[i]) >= k:
            stoped_people.append(id_list[i])
    
    for i in range(len(report)):
        tmp = report[i].split(" ")
        if stoped_people.count(tmp[1]) == 1:
            good_people.append(tmp[0])
    
    for i in range(len(id_list)):
        answer.append(good_people.count(id_list[i]))
        
    return answer