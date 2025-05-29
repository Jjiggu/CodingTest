import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSec(play_time.split(":"));
        int advTime = timeToSec(adv_time.split(":"));

        long[] timeline = new long[playTime + 2];

        for (String log : logs) {
            String[] tmp = log.split("-");
            int start = timeToSec(tmp[0].split(":"));
            int end = timeToSec(tmp[1].split(":"));

            timeline[start] += 1;
            timeline[end] -= 1;
        }

        
        for (int i = 1; i <= playTime; i++) {
            timeline[i] += timeline[i - 1];
        }

        
        for (int i = 1; i <= playTime; i++) {
            timeline[i] += timeline[i - 1];
        }

        
        long maxView = timeline[advTime - 1];
        int startTime = 0;

        for (int i = advTime; i <= playTime; i++) {
            long currentView = timeline[i] - timeline[i - advTime];
            if (currentView > maxView) {
                maxView = currentView;
                startTime = i - advTime + 1;
            }
        }

        return secToTime(startTime);
    }
    

    public int timeToSec(String[] timeArr) {
        int[] units = {3600, 60, 1};
        int sec = 0;
        for (int i = 0; i < timeArr.length; i++) {
            sec += Integer.parseInt(timeArr[i]) * units[i];
        }
        return sec;
    }
    

    public String secToTime(int sec) {
        int hour = sec / 3600;
        sec %= 3600;
        int min = sec / 60;
        sec %= 60;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }
}
