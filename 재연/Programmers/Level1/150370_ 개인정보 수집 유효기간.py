import time;
def solution(today, terms, privacies):
    answer = []
    terms_dic={}
    today_year=int(today[0:4])
    today_month=int(today[5:7])
    today_day=int(today[8:10])
    for i in range(len(terms)):
        terms_dic[terms[i][0]]=int(terms[i][2::])
    for i in range(len(privacies)):
        sort=privacies[i][-1] #약관 종류 자르기
        term=terms_dic[sort]
        start_date_year=int(privacies[i][0:4]) #수집 일자 slice
        start_date_month=int(privacies[i][5:7])
        start_date_day=int(privacies[i][8:10])
        
        start_date_month+=term
        if start_date_month+term>12:
            start_date_year+=start_date_month//12
            start_date_month=start_date_month%12
            if start_date_month==0:
                start_date_year-=1
                start_date_month=12
        if start_date_year<today_year:
            answer.append(i+1)
        elif start_date_year==today_year:
            if start_date_month<today_month:
                answer.append(i+1)
            elif start_date_month==today_month:
                if today_day>=start_date_day:
                    answer.append(i+1)
                
            
    return answer