def solution(routes):
    count = 0
    routes.sort(key = lambda x:x[1])
    cam = -30001
    for [enter, exit] in routes:
        if enter > cam:
            count += 1
            cam = exit
    return count