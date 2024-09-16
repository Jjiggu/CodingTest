def solution(answers):
    # 수포자들의 답안 패턴
    p_1 = [1, 2, 3, 4, 5]
    p_2 = [2, 1, 2, 3, 2, 4, 2, 5]
    p_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    # 각 수포자들의 점수를 저장할 리스트
    scores = [0, 0, 0]
    
    # 정답과 비교하여 각 수포자들의 점수를 계산
    for i in range(len(answers)):
        if p_1[i % len(p_1)] == answers[i]:
            scores[0] += 1
        if p_2[i % len(p_2)] == answers[i]:
            scores[1] += 1
        if p_3[i % len(p_3)] == answers[i]:
            scores[2] += 1
    
    # 가장 높은 점수 계산
    max_score = max(scores)
    
    # 가장 높은 점수를 받은 수포자(1, 2, 3번)를 결과 리스트에 담음
    result = [i + 1 for i, score in enumerate(scores) if score == max_score]
    
    return result
