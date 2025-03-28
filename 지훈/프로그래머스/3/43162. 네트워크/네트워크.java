import java.util.*;

class Solution {        
    /**
     * Computes the number of connected networks in a group of computers.
     *
     * <p>This method processes an adjacency matrix where a value of 1 at computers[i][j] indicates a direct
     * connection between computer i and computer j. A breadth-first search is initiated from each unvisited computer,
     * marking all reachable computers as visited and thereby counting one connected component per traversal.
     *
     * @param n the number of computers in the network
     * @param computers a 2D matrix representing network connections, where a value of 1 implies a direct connection
     * @return the total number of connected networks
     */
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, i, visited);
                result++;   
            }
        }
        
        return result;
    }
    
    /**
     * Performs a breadth-first search to mark all computers in the same network as visited.
     *
     * <p>This method starts from the specified computer index and iteratively visits all directly connected
     * computers using a queue, ensuring that each reachable computer from the starting point is marked as visited
     * in the given array.</p>
     *
     * @param computers the adjacency matrix representing network connections, where a value of 1 indicates a direct connection
     *                  between two computers.
     * @param nowNum the index of the starting computer for the search.
     * @param visited an array tracking which computers have been visited.
     */
    public void bfs(int[][] computers, int nowNum, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(nowNum);
        visited[nowNum] = true;
        
        while (!q.isEmpty()) {
            int num = q.poll();
            
            for (int i = 0; i < computers.length; i++) {
                if (i != num && computers[num][i] == 1) {
                    if (!visited[i]) {
                        visited[i] = true;
                        q.add(i);
                    }
                }
            }
        }
    }
}