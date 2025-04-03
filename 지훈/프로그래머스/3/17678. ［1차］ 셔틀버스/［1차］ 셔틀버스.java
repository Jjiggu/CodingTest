import java.util.*;

class Solution {
    
    static int START_TIME = 540;
    
    public String solution(int n, int t, int m, String[] timetable) {
        
        int[] time = new int[timetable.length];
        
        for (int i = 0; i < timetable.length; i++) {
            time[i] = stringToTime(timetable[i]);
        }
        
        Arrays.sort(time);
        
        int idx = 0;
        int lastCrewTime = 0;
        
        for (int i = 0; i < n; i++) {
            int depTime = START_TIME + i * t;
            int crewCnt = 0;
            
            while (idx < time.length && time[idx] <= depTime && crewCnt < m) {
                crewCnt++;
                lastCrewTime = time[idx];
                idx++;
            }
            
            if (i == n - 1) {
                if (crewCnt == m) {
                    return timeToString(lastCrewTime - 1);
                } else {
                    return timeToString(depTime);
                }
            }
            
//             for (int j = startIdx; j < time.length; j++) {
//                 if (cnt >= n * m) {
//                     System.out.println("자리 X 중간에 탑승");
//                     return timeToString(time[j] - 1);
//                 }
//                 if (avalidM > 0 && time[j] <= depTime) {
//                     avalidM--;
//                     cnt++;
//                 } else {
//                     startIdx = j;
//                     break;
//                 }
//             }
        }
        
        return "";
    }
    
    
    private int stringToTime(String t) {
        String[] arr = t.split(":");
        int result = 0;
        
        result += Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
        
        return result;
    }
    
    
    private String timeToString(int t) {
        int hour = t / 60;
        int min = t % 60;
    
        return String.format("%02d:%02d", hour, min);
    }   
}