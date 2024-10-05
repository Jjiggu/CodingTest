class Solution {
  public String solution(String s) {

        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String index : array) {
            cnt = index.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? index.toLowerCase() : index.toUpperCase(); 
        }
      return answer;
  }
}