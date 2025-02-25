def solution(dartResult):

    squares = {
        "S": 1,
        "D": 2,
        "T": 3,
    }
    scores = []
    temp = ""
    for char in dartResult:
        if char.isdigit():
            temp += char  # 문자가 숫자일 때 더해서 임시 저장
        elif char.isalpha():
            # 문자가 S, D, T 일때 임시 저장한 변수를 정수화 해서 제곱하고 삽입
            scores.append(pow(int(temp), squares[char]))
            temp = ""  # 임시 저장 변수 초기화
        elif char == "*":
            if len(scores) > 1:  # 현재 점수와 바로 이전 점수에 스타상 적용
                scores[-2] *= 2
            scores[-1] *= 2
        elif char == "#":  # 현재 점수에 아차상 적용
            scores[-1] *= -1

    # 모두 더한 점수를 출력
    answer = sum(scores)
    return answer