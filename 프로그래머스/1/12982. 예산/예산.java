import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        
        for(int num : d){
            if(budget < num){
                break;
            }
            budget -= num;
            answer++;
        }
        
        return answer;
    }
}