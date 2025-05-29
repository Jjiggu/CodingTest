class Solution {
    public int solution(int n, int[] cores) {
        
        if (n <= cores.length) {
            return n;
        }

        long startTime = findStartTime((long)n - cores.length, cores);


        long processedBefore = cores.length;  
        for (int core : cores) {
            processedBefore += (startTime - 1) / core;
        }

    
        long leftTaskCnt = (long)n - processedBefore;

    
        for (int i = 0; i < cores.length; i++) {
            if (startTime % cores[i] == 0) {
                leftTaskCnt--;
                if (leftTaskCnt == 0) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    
    private long findStartTime(long taskCount, int[] cores) {
        long left = 0;
        long right = 1_000_000_000;
        long answer = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canProcess(mid, taskCount, cores)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    
    private boolean canProcess(long time, long taskCount, int[] cores) {
        long done = 0;
        for (int core : cores) {
            done += time / core;
            if (done >= taskCount) return true; 
        }
        
        return false;
    }
}
