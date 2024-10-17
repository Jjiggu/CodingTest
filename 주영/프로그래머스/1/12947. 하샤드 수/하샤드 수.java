class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int ha_num = ha(x);
        if(x%ha_num != 0){
            answer = false;
        }
        return answer;
    }
    public int ha(int n){
        int answer = 0;
        
        while(n > 0){
            answer += n%10;
            n/=10;
        }
        return answer;
    }
}