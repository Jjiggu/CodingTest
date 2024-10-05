class Solution {
    public int measure(int num){
        int count = 0;
        for (int i = 1; i<=num; i++){
            if(num % i == 0){
                count++;
            }
        }
        
        if(count % 2 == 0){
            return num;
        }else{
            return -num;
        }
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i<= right; i++){
            answer += measure(i);
        }
        return answer;
    }
}