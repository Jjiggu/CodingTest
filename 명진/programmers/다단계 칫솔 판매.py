from math import floor


def solution(enroll, referral, sellers, amounts):
    refers = {e:r for e, r in zip(enroll, referral)}
    earned = {e:0 for e in enroll}
    
    def update(seller, earn):
        while seller != "-" and earn != 0:
            giving = floor(earn/10)
            earned[seller] += earn-giving
            seller = refers[seller]
            earn = giving
    
    for seller, amount in zip(sellers, amounts):
        update(seller, amount*100)
        
    return [earned[e] for e in enroll]