def solution(s):
    arr = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    tmp = ""
    result = ""
    for i in range (len(s)):
        c = s[i]
        if(c.isnumeric()):
            result+=c
        else:
            tmp+=c
            if tmp in arr:
                result+=str(arr.index(tmp))
                tmp=""
    return int(result)