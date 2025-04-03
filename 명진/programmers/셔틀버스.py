def timeToMin(time:str):
    h, m = map(int, time.split(':'))
    return h*60+m

def minToTime(n:int):
    h, m = n//60, n%60
    return f"{h:02d}:{m:02d}"

def solution(n, t, m, timetable):
    times = [timeToMin(time) for time in timetable]
    times.sort()
    
    i = 0
    arrival = con = 9*60
    while n:
        aboard = 0
        while aboard < m and i < len(times):
            if times[i] > arrival:
                break
            i+=1
            aboard+=1
        con = arrival if aboard < m else times[i-1]-1
        arrival += t
        n-=1
    
    
    return minToTime(con)