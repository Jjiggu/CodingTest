import java.util.*;

class Solution {  
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        visited = new boolean[tickets.length + 1];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs(0, "ICN", tickets, path);
        
        return answer.toArray(new String[0]);
    }
    
    private void dfs(int k, String current, String[][] tickets, List<String> path) {
        if (k == tickets.length) {
            answer = new ArrayList<>(path);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++){
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(k + 1, tickets[i][1], tickets, path);
                
                if (!answer.isEmpty()) return;
                
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}