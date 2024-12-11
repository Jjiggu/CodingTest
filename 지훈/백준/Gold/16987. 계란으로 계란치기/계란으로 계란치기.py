N = int(input())
egg_list = [list(map(int, input().split())) for _ in range(N)]
cnt = 0
is_cracked = [False] * (N + 1)

def back(start):
    global cnt

    if start == N:
        broken_count = sum(is_cracked)  # 깨진 계란 개수
        cnt = max(cnt, broken_count)
        return

    if egg_list[start][0] <= 0:
        back(start + 1)
        return

    has_hit = False

    for i in range(N):
        if i != start and not is_cracked[i]:
            has_hit = True

            egg_list[start][0] -= egg_list[i][1]
            egg_list[i][0] -= egg_list[start][1]

            if egg_list[start][0] <= 0:
                is_cracked[start] = True

            if egg_list[i][0] <= 0:
                is_cracked[i] = True

            back(start + 1)

            if egg_list[start][0] <= 0:
                is_cracked[start] = False
            if egg_list[i][0] <= 0:
                is_cracked[i] = False

            egg_list[start][0] += egg_list[i][1]
            egg_list[i][0] += egg_list[start][1]

    if not has_hit:
        back(start + 1)

back(0)
print(cnt)