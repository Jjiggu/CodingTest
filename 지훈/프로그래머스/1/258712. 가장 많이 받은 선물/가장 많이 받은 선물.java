import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        int answer = 0;
            
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }
        
        int[] index = new int[friends.length];
        int[][] record = new int[friends.length][friends.length];
        
        for (String s : gifts) {
            String[] tmp = s.split(" ");
            index[map.get(tmp[0])]++;
            index[map.get(tmp[1])]--;
            record[map.get(tmp[0])][map.get(tmp[1])]++;
        }
        
        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for(int j = 0; j < friends.length; j++) {
                if (i == j) continue;
                if (record[i][j] > record[j][i]) cnt ++;
                else if (record[i][j] == record[j][i] && index[i] > index[j]) cnt ++;
            }
            answer = Math.max(cnt, answer);
        }
        
        return answer;
    }
}