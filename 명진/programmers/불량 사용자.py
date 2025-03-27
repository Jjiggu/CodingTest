def canBeMapped(uid, bid):
    if len(bid) != len(uid):
        return False
    for i in range(len(uid)):
        if bid[i] == '*':
            continue
        if bid[i] != uid[i]:
            return False
    return True


def bitCheck(bits, i):
    return bits & (1 << i)


def solution(user_id, banned_id):
    lenId = len(banned_id)
    mappedIds = set()

    def backtrack(k, ids_bits):
        if k == lenId:
            mappedIds.add(ids_bits)
            return
        for i in range(len(user_id)):
            if bitCheck(ids_bits, i):
                continue
            if canBeMapped(user_id[i], banned_id[k]):
                ids_bits ^= 1 << i
                backtrack(k+1, ids_bits)
                ids_bits &= ~(1 << i)
    backtrack(0, 0)
    return len(mappedIds)