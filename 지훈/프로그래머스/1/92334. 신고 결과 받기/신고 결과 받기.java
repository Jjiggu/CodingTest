import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> idIndex = new HashMap<>();
        Map<String, List<String>> reportMap = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
            reportMap.put(id_list[i], new ArrayList<>());
        }
        
        for (String reported : report) {
            String[] tmp = reported.split(" ");
            if (!reportMap.get(tmp[1]).contains(tmp[0])) {
                reportMap.get(tmp[1]).add(tmp[0]);
            }       
        }
        
        for (String id : reportMap.keySet()) {
            if (k <= reportMap.get(id).size()) {
                for (String reporter : reportMap.get(id)) {
                    answer[idIndex.get(reporter)]++;
                }
            }
        }
        
        return answer;
        
    }
}