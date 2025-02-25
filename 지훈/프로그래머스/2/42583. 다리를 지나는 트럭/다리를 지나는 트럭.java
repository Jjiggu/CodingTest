import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        int weightSum = 0;
        
        for (int i = 0; i < truck_weights.length; i++) {
            int w = truck_weights[i];
            
            while(true) {
                if(q.isEmpty()) {
                    q.add(w);
                    weightSum += w;
                    time++;
                    break;
                } else if (q.size() == bridge_length) {
                    weightSum -= q.poll();
                } else {
                    if (weightSum + w <= weight) {
                        q.add(w);
                        weightSum += w;
                        time++;
                        break;
                    } else {
                        q.add(0);
                        time++;
                    }
                }
            }
        }
        
        return time + bridge_length;
    }
}