def solution(n, roads, sources, destination):
    # 그래프 생성,인접 노드 정보 담기
    graph = {}
    for a, b in roads: #roads 리스트에 있는 각 도로 정보 (a, b)를 반복적으로 처리
        if a in graph:
            graph[a].append(b) #만약 a가 이미 graph에 있다면, graph[a]에 연결된 노드 리스트에 b를 추가
        else: #a가 graph에 없다면, 새로운 키 a를 graph에 생성하고, b를 값으로 갖는 리스트를 할당
            graph[a] = [b]
        if b in graph:#위 작업 반복
            graph[b].append(a)
        else:
            graph[b] = [a]

    # BFS 알고리즘[너비 우선 탐색]
    # 시작노드에서 목적지까지의 최단거리 반환
    def bfs(start): #시작노드 start:input
        distances = [-1] * (n + 1)
        distances[start] = 0 #시작 노드의 거리를 0으로 설정
        queue = [start]

        while queue:
            node = queue.pop(0)

            for neighbor in graph[node]:#현재 노드 node에 연결된 모든 이웃 노드 neighbor를 순회
                #웃 노드 neighbor의 거리가 아직 설정되지 않았다면, 현재 노드 node의 거리에 1을 더한 값을 neighbor의 거리로 설정합니다.
                if distances[neighbor] == -1:
                    distances[neighbor] = distances[node] + 1
                    queue.append(neighbor)

        return distances[destination] if distances[destination] != -1 else -1

    # 각 부대원의 최단 거리 계산
    return [bfs(source) for source in sources]
