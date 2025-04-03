# 레퍼 참고
def solution(n, t, m, timetable):
    answer = ''
    timetable=[int(time[:2])*60+int(time[3:]) for time in timetable]
    timetable.sort()
    
    busTime=[9*60+t*i for i in range(n)]
    
    i=0
    for bt in busTime:
        cnt=0
        while cnt<m and i<len(timetable) and timetable[i]<=bt:
            i+=1
            cnt+=1
        if cnt<m:
            answer=bt
        else:
            answer=timetable[i-1]-1    
    return str(answer//60).zfill(2)+":"+str(answer%60).zfill(2)