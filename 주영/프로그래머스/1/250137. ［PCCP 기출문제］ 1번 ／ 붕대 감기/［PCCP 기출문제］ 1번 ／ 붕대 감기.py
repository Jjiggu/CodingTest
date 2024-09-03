def solution(bandage, health, attacks):
    t, x, y = bandage
    max_health = health
    end_time = attacks[-1][0]
    attacks = {attack[0]:attack[1] for attack in attacks}
    
    cur_t = 0
    cur_health = health
    
    for i in range(end_time + 1):
        # 공격
        if i in attacks:
            cur_t = 0
            cur_health -= attacks[i]
            
            # 사망
            if cur_health <= 0:
                return -1
            continue
        
        # 공격받지 않음
        cur_t += 1
        cur_health += x
        
        # 추가 회복
        if cur_t == t:
            cur_health += y
            cur_t = 0
            
        cur_health = min(cur_health, max_health)
    
    return cur_health