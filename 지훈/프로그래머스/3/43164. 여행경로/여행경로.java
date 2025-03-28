import java.util.*;

class Solution {  
    static boolean[] visited;
    static List<String> answer = new ArrayList<>();
    
    /**
     * Returns a valid travel itinerary starting from "ICN" that uses all flight tickets exactly once.
     *
     * The method first sorts the provided tickets (each represented as a [departure, arrival] pair)
     * based on their destination in lexicographical order. It then initiates a depth-first search (DFS)
     * to construct an itinerary that starts at "ICN" and visits airports in an order that consumes
     * all available tickets.
     *
     * @param tickets a 2D array of flight tickets, where each sub-array consists of a departure
     *                and an arrival airport code.
     * @return an array of strings representing the travel itinerary.
     */
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        visited = new boolean[tickets.length + 1];
        
        List<String> path = new ArrayList<>();
        path.add("ICN");
        
        dfs(0, "ICN", tickets, path);
        
        return answer.toArray(new String[0]);
    }
    
    /**
     * Recursively conducts a depth-first search to build a valid travel itinerary using all flight tickets.
     * <p>
     * This method explores available tickets from the current airport, marking each as visited and adding the
     * destination to the ongoing itinerary. When the itinerary uses all tickets (i.e., when k equals the total number 
     * of tickets), the current path is saved as the final answer. The recursion stops early if a complete itinerary is found.
     *
     * @param k       the number of tickets used so far
     * @param current the current airport from which to search for the next flight
     * @param tickets the array of flight tickets represented as [departure, destination] pairs
     * @param path    the current travel itinerary being constructed
     */
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