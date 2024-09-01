def check_day(expiration_date, today):
    if expiration_date[0] > today[0]:
        return True
    if expiration_date[0] == today[0] and expiration_date[1] > today[1]:
        return True
    
    if expiration_date[0] == today[0] and expiration_date[1] == today[1] and expiration_date[2] > today[2]:
        return True
    
    return False


def solution(today, terms, privacies):
    today = list(map(int, today.split(".")))
    expiration = {i[0]:int(i[2:]) for i in terms}
    result = []
    
    for i in range(len(privacies)):
        expiration_date, term = privacies[i].split(" ")
        expiration_date = list(map(int, expiration_date.split(".")))
        expiration_date[1] += expiration[term]
        
        
        if expiration_date[1] > 12:
            if expiration_date[1] % 12 == 0:
                expiration_date[0] += (expiration_date[1] // 12) - 1
                expiration_date[1] = 12
                
            else:
                expiration_date[0] += expiration_date[1] // 12
                expiration_date[1] %= 12
        
        print(expiration_date)
        
        if check_day(expiration_date, today) == False:
            result.append(i + 1)
    
    return result