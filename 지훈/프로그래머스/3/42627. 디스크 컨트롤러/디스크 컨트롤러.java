import java.util.*;

class Job {
    int reqTime;
    int workTime;

    /**
     * Constructs a new Job with the specified request time and work duration.
     *
     * @param reqTime the time at which the job is requested
     * @param workTime the duration required to complete the job
     */
    public Job(int reqTime, int workTime) {
        this.reqTime = reqTime;
        this.workTime = workTime;
    }
}

class Solution {
    /**
     * Calculates the average waiting time for processing a set of jobs using a Shortest Job First (SJF) approach.
     *
     * <p>The method first sorts the jobs by their request times. It then processes jobs by adding those whose
     * request times are up to the current time into a priority queue prioritized by work times. If jobs are available,
     * it executes the one with the shortest work time, updates the current time and the total waiting time, and counts the job
     * as completed. If no jobs are available, it increments the time until a job is ready. Finally, the method returns the
     * average waiting time for all jobs.
     *
     * @param jobs a 2D array where each sub-array contains two integers representing a job's request time and work time
     * @return the average waiting time for all jobs
     */
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
