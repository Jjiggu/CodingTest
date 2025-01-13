l,c=map(int,input().split())
letters=list(input().split())
letters.sort()

answer=[]

def back(start):
    if len(answer)==l:
        vowel=0
        for letter in answer:
            if letter in {"a","e","i","o","u"}:
                vowel+=1
        if vowel>=1 and l-vowel>=2:
            print("".join(map(str,answer)))
        return
    
    for i in range(start,c):
        answer.append(letters[i])
        back(i+1)
        answer.pop()

back(0)