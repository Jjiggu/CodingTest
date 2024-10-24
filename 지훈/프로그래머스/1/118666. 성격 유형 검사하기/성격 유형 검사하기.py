def solution(survey, choices):
    answer = ''
    
    # 지표별 점수 
    score = {"R":0, 
             "T":0,
             "C":0,
             "F":0,
             "J":0,
             "M":0,
             "A":0,
             "N":0            
            }
    
    for mbti, num in zip(survey, choices):
        if num > 4:
            score[mbti[1]] += num % 4
        if num < 4:
            score[mbti[0]] += 4 - num 
    
    answer += 'R' if score['R'] >= score['T'] else 'T'
    answer += 'C' if score['C'] >= score['F'] else 'F'
    answer += 'J' if score['J'] >= score['M'] else 'M'
    answer += 'A' if score['A'] >= score['N'] else 'N'
    
    return answer
            
    