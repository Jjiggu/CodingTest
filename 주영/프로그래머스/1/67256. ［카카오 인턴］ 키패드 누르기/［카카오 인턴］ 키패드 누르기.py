kp = {
    1: [0, 0], 2: [0, 1], 3: [0, 2],
    4: [1, 0], 5: [1, 1], 6: [1, 2],
    7: [2, 0], 8: [2, 1], 9: [2, 2],
    "*": [3, 0], 0: [3, 1], "#": [3, 2]
}


def dist(point1, point2):
    y1, x1 = point1
    y2, x2 = point2
    return abs(y2-y1) + abs(x2-x1)


def solution(numbers, hand):
    result = ''
    lh_pos = kp["*"]
    rh_pos = kp["#"]
    
    for num in numbers:
        if num in [1, 4, 7]:
            lh_pos = kp[num]
            result += 'L'
        elif num in [3, 6, 9]:
            rh_pos = kp[num]
            result += 'R'
        else:
            if dist(rh_pos, kp[num]) < dist(lh_pos, kp[num]):
                rh_pos = kp[num]
                result += "R"
            elif dist(rh_pos, kp[num]) > dist(lh_pos, kp[num]):
                lh_pos = kp[num]
                result += 'L'
            else:
                if hand == "right":
                    rh_pos = kp[num]
                    result += "R"
                else:
                    lh_pos = kp[num]
                    result += 'L'
    return result