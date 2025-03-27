import heapq

def solution(jobs):
    n = len(jobs)
    answer = 0
    jobs.sort()
    current_time = 0
    total_time = 0
    pq = []  # 우선순위 큐 생성

    while jobs or pq:
        while jobs and jobs[0][0] <= current_time:
            request_time, duration = jobs.pop(0)
            heapq.heappush(pq, (duration, request_time))
        if pq:
            duration, start_time = heapq.heappop(pq)
            end_time = current_time + duration
            total_time += end_time - start_time
            current_time = end_time
        else:
            current_time += 1
    answer = total_time // n
    return answer