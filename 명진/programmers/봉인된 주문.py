ORD_A = ord('a')
def spellToDec(spell: str)->int :
    dec = 0
    for c in spell:
        dec *= 26
        dec += ord(c) - ORD_A + 1
    return dec

def decToSpell(dec: int)->str:
    spell = ""
    while dec > 0:
        dec -= 1
        spell = chr((dec % 26) + ORD_A) + spell
        dec //= 26
    return spell

def solution(n, bans):
    bans_dec = [*map(spellToDec, bans)]
    bans_dec.sort()
    for d in bans_dec:
        if d <= n:
            n += 1
    return decToSpell(n)
