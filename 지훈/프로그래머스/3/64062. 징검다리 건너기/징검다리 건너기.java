class Solution {
    /**
     * Determines the maximum threshold value that permits crossing the stones without exceeding the allowed consecutive skips.
     *
     * <p>This method uses a binary search over the range of possible threshold values. For each midpoint value,
     * it checks if the crossing is feasible (i.e., no segment of consecutive stones falls below the threshold for k or more positions)
     * by invoking the helper method {@code canCross}. If crossing is possible with the current threshold, the search continues with higher values;
     * otherwise, it explores lower ones.</p>
     *
     * @param stones an array representing the number of stones available at each position
     * @param k the maximum number of consecutive positions allowed with insufficient stones to safely cross
     * @return the highest threshold value that still allows crossing the stones
     */
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200_000_000;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    
    /**
         * Determines whether it is possible to cross the stones without encountering k consecutive unusable stones.
         *
         * The method iterates over each stone and increments a skip counter for stones whose value is below the 
         * threshold (mid). When a stone meets or exceeds the threshold, the skip counter is reset. If the skip 
         * counter reaches k at any point, the crossing is deemed impossible.
         *
         * @param stones an array representing the value of each stone
         * @param k the maximum number of consecutive stones that can be skipped
         * @param mid the threshold value used to determine if a stone can be used for crossing
         * @return true if crossing is possible; false otherwise
         */
    private boolean canCross(int[] stones, int k, int mid) {
        int skip = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                skip++;
                
                if (skip >= k) {
                    return false;
                }
            } else {
                skip = 0;
            }
        }
        
        return true;
    }
}