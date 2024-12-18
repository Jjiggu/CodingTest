# 시간초과 해결 어떻게?
def solution(id_list, report, k):
    answer = []
    result={}
    report_set=set(report) #report에서 중복 신고는 취급 안하므로 중복 제거
    blocked=[]
    # dictionary 초기화
    for id in id_list:
        result[id]=0
    for i in range (len(id_list)):
        result[id_list[i]]=0;
    # 신고당한 횟수 계산
    for report_individual in report_set:
        name=report_individual.split()
        result[name[1]]+=1
    #정지당한 사람만 Listing
    for id in id_list:
        if result[id]>=k:
            blocked.append(id)
    #정지당한 user의 수에 ++
    for i in range(len(id_list)):
        report_success=0
        for report_individaul in report_set:
            name=report_individaul.split()
            if name[0]==id_list[i] and name[1] in blocked:
                report_success+=1
        answer.append(report_success)
    return answer