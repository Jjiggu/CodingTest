L, C = map(int, input().split())
alpha_list = sorted(list(map(str, input().split())))
is_used = [False] * (C + 1)
vowels = {'a', 'e', 'i', 'o', 'u'}

result = []

def back(cur, vowel_count, consonant_count):
    if len(result) == L:
        if vowel_count >= 1 and consonant_count >= 2:
            print("".join(result))
        return

    for i in range(cur, C):
        if not is_used[i]:
            is_used[i] = True
            result.append(alpha_list[i])

            if alpha_list[i] in vowels:
                back(i + 1, vowel_count + 1, consonant_count)
            else:
                back(i + 1, vowel_count, consonant_count + 1)

            is_used[i] = False
            result.pop()

back(0, 0, 0)