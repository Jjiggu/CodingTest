N = int(input())
is_used1 = [False] * 40
is_used2 = [False] * 40
is_used3 = [False] * 40
cnt = 0

def back(cur):
    global cnt
    if cur == N:
        cnt += 1
        return

    for i in range(N):
        if is_used1[i] == True or is_used2[i + cur] == True or is_used3[i - cur + N - 1] == True:
            continue
        is_used1[i] = True
        is_used2[i + cur] = True
        is_used3[i - cur + N - 1] = True
        back(cur + 1)
        is_used1[i] = False
        is_used2[i + cur] = False
        is_used3[i - cur + N - 1] = False

back(0)
print(cnt)
