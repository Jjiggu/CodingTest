import java.util.*;

class Solution {    
    
    private int[] parent;
    
    /**
     * Calculates the minimum cost to connect all nodes.
     *
     * <p>This method initializes a union-find structure, sorts the connection cost array in ascending order,
     * and then iteratively connects nodes (using union-find) that are not already connected. It accumulates
     * the cost of each connection to ensure that the overall cost is minimized.
     *
     * @param n the number of nodes
     * @param costs a 2D array where each entry [node1, node2, cost] represents a connection between two nodes and its cost
     * @return the minimum total cost required to connect all nodes
     */
    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < costs.length; i++) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    
    /**
     * Finds and returns the representative of the set that contains the specified node, applying path compression.
     *
     * <p>This method recursively finds the root of the node and updates the parent pointer for efficient future queries.</p>
     *
     * @param a the node whose set representative is to be determined
     * @return the representative (root) of the set containing the node
     */
    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }else return parent[a] = find(parent[a]);
    }
    
    
    /**
     * Unites the sets containing the specified nodes.
     *
     * <p>This method finds the root parent of each node using the union-find structure. If the two nodes
     * belong to different sets, it merges them by linking the root of the second node to the root of the first.</p>
     *
     * @param a the first node to union
     * @param b the second node to union
     */
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a != b) {
            parent[b] = a;
        }
    }
}