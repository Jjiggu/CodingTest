def solution(s):
    answer = ''
    word = ''
    number_lst = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
    word_lst = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    
    for w in s:
        if w in number_lst:
            answer += w
        else:
            word += w
            if word in word_lst:
                num = word_lst.index(word)
                answer += number_lst[num]
                word = ''
    return float(answer)