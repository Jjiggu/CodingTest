class Solution {
    /**
     * Computes the minimum number of additional base stations required to cover the entire region.
     *
     * <p>The region from 1 to n must be fully covered, where each existing station covers 
     * the area from (position - w) to (position + w). This method identifies any gaps in coverage,
     * both between stations and at the ends of the region, and calculates the number of extra stations
     * needed to fill these gaps using a helper method.</p>
     *
     * @param n the total number of positions in the region
     * @param stations the positions of the existing base stations
     * @param w the coverage range to one side of each station (each station covers 2*w + 1 positions)
     * @return the minimum number of additional base stations required for complete coverage
     */
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int begin = 1;
        
        for(int i = 0; i < stations.length; i++) {
            if(begin < stations[i] - w) {
                answer += bsearch(begin, stations[i] - w - 1, w);   
            }
            
            begin = stations[i] + w + 1;
        }
        
        if(stations[stations.length - 1] + w < n) {
            answer += bsearch(stations[stations.length - 1] + w + 1, n, w);
        }

        return answer;
    }
    
    
    /**
     * Computes the minimum number of additional base stations required to cover a specified gap.
     *
     * <p>This method determines the number of extra stations needed to fill the uncovered range from 
     * {@code begin} to {@code end} (inclusive), given that each station covers a span of 
     * {@code 2 * w + 1} contiguous units. It divides the gap length by the station's coverage width, 
     * incrementing the count if there is any remainder.
     *
     * @param begin the starting index of the gap to be covered
     * @param end the ending index of the gap to be covered
     * @param w the coverage range to one side from a station. Each station covers a total of {@code 2 * w + 1} units
     * @return the minimum number of additional stations required to cover the specified gap
     */
    public int bsearch(int begin, int end, int w) {
        int res = (end - begin + 1) / (2 * w + 1);
        
        if((end - begin + 1) % (2 * w + 1) > 0) res++;
        
        return res;
    }
}