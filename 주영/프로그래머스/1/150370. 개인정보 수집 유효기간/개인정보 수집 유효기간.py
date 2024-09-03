def solution(today, terms, privacies):
    d ={}
    answer = []
    today_lst = list(map(int,today.split('.'))) # 오늘 날짜 리스트로 변환
    
    for term in terms: # 약관종류와 개월수 딕셔너리로 저장
        n, m = term.split()
        d[n] = int(m)*28 # 한 달 일 수 곱해줌
    
    for i in range(len(privacies)):
        date, s = privacies[i].split()
        date_lst = list(map(int, date.split('.'))) # 수집일자 리스트로 변환
        year = (today_lst[0] - date_lst[0])*336 # 연도 차이에 일 수 곱해주기
        month = (today_lst[1] - date_lst[1])*28 # 달 수 차이에 일 수 곱해주기
        day = today_lst[2] - date_lst[2]
        total = year+month+day
        if d[s] <= total:
            answer.append(i+1)
    return answer