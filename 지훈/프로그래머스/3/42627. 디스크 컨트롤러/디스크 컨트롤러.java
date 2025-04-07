import java.util.*;

class Job {
    int reqTime;
    int workTime;

    public Job(int reqTime, int workTime) {
        this.reqTime = reqTime;
        this.workTime = workTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);  // 요청 시간 기준 정렬

        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.workTime - b.workTime);  // 작업 시간 짧은 순
        
        int time = 0;
        int total = 0;
        int idx = 0;
        int count = 0;

        while (count < jobs.length) {
            // 현재 시간까지 요청된 작업 큐에 추가
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (!pq.isEmpty()) {
                Job cur = pq.poll();
                time += cur.workTime;
                total += time - cur.reqTime;
                count++;
            } else {
                time++;  // 요청된 작업이 없으면 시간만 흐름
            }
        }

        return total / jobs.length;
    }
}
