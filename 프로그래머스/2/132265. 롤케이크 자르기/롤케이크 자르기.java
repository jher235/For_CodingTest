
import java.util.*;
import java.util.stream.*;

class Solution {
    static int answer = 0;
    public int solution(int[] topping) {
        
        int[] first = new int[10001];
        int[] second = new int[10001];
        int firstCount = 0;
        int secondCount = 0;
        
        for(int t : topping){
            second[t]++;
            if(second[t] == 1){
                secondCount++;
            }
        }
                
        for(int t : topping){
            second[t]--;
            first[t]++;
            if(first[t] == 1){
                firstCount++;
            }
            if(second[t] == 0){
                secondCount--;
            }
            if(firstCount == secondCount){
                answer++;
            }
            
            if(firstCount > secondCount){
                break;
            }
        }
        return answer;
    }
    
}