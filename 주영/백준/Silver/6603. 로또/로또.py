import itertools

while 1:
    N = list(map(int, input().split()))

    if N[0] == 0: break			# N에 0이 입력될때까지 반복
    del N[0]				# N에 처음 값(k)을 삭제

    for i in itertools.combinations(N, 6):	#combinations함수로 만들수 있는 조합생성
        print(' '.join(map(str, i)))	#문자열 형식 출력
    print()		