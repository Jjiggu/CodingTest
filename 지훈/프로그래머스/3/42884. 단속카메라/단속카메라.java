import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        //모든 차량이 한 번은 단속용 카메라를 만나도록 하려면 최소 몇 대의 카메라를 설치해야 하는지를 return
        //종료지점 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] r1, int[] r2){
                return r1[1]-r2[1];
            }
        });
        
        int pos = Integer.MIN_VALUE;
        
        for(int[] r : routes){
            if(pos < r[0]){
                pos = r[1];
                answer++; //카메라 설치
            }
        }
        
        return answer;
    }
}