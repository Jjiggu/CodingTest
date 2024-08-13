from collections import deque

def is_on_boundary(x, y, rect):
    for x1, y1, x2, y2 in rect:
        if (x == x1 or x == x2) and y1 <= y <= y2:
            return True
        if (y == y1 or y == y2) and x1 <= x <= x2:
            return True
    return False

def is_inside(x, y, rect):
    for x1, y1, x2, y2 in rect:
        if x1 < x < x2 and y1 < y < y2:
            return True
    return False

def solution(rectangle, characterX, characterY, itemX, itemY):
    # 좌표 평면을 2배로 확대
    rect = [(2*x1, 2*y1, 2*x2, 2*y2) for x1, y1, x2, y2 in rectangle]
    cx, cy = 2 * characterX, 2 * characterY
    ix, iy = 2 * itemX, 2 * itemY
    
    # 방향 벡터: 상, 하, 좌, 우
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    # BFS 초기 설정
    queue = deque([(cx, cy, 0)])
    visited = set()
    visited.add((cx, cy))
    
    while queue:
        x, y, dist = queue.popleft()
        
        # 아이템에 도달했을 경우
        if (x, y) == (ix, iy):
            return dist // 2  # 원래 크기로 돌려주기 위해 2로 나눔
        
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            
            if (nx, ny) not in visited and is_on_boundary(nx, ny, rect) and not is_inside(nx, ny, rect):
                visited.add((nx, ny))
                queue.append((nx, ny, dist + 1))

    return -1  # 도달할 수 없는 경우 (문제 조건에서는 발생하지 않음)
