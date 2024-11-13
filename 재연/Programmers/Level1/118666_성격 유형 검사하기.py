def solution(survey, choices):
    answer = ''
    reply={'R':0,'T':0,'C':0,'F':0,'J':0,'M':0,'A':0,'N':0}
    key=['R','T','C','F','J','M','A','N']
    for i in range(len(survey)):
        if choices[i]>4:
            reply[survey[i][1]]+=abs(4-choices[i])
        elif choices[i]<4:
            reply[survey[i][0]]+=abs(4-choices[i])
#             1,7=>3점, 2,6=>2점 3,5=>1점
    for i in range(0,8,2):
        if reply[key[i]]==reply[key[i+1]]:
            answer+=key[i]
        elif reply[key[i]]>reply[key[i+1]]:
            answer+=key[i]
        else:
            answer+=key[i+1]
    return answer