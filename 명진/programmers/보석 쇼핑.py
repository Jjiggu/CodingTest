def solution(gems):
    al, ar = 0, len(gems)-1
    numGems = len(set(gems))
    gemCounts = {gems[0]:1}
    l = r = 0
    while l < len(gems) and r < len(gems):
        if len(gemCounts) == numGems:
            if r - l < ar - al:
                ar, al = r, l
            gemCounts[gems[l]] -= 1
            if gemCounts[gems[l]] == 0:
                del gemCounts[gems[l]]
            l += 1
            continue
        r+=1
        if r == len(gems):
            break
        gemCounts[gems[r]] = gemCounts.get(gems[r], 0) + 1
    return [al+1, ar+1]