import java.util.*; 

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // int[] ans = {};
        
        int day = 0;
        
        // int cnt = 0;
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<progresses.length;i++){
            int curP = progresses[i];
            int curS = speeds[i];
            
            int cnt = 0;
            
            while(100 > curP + curS * day){
                day++;
                
                if(100 <= curP + curS * day){
                    cnt++;
                    
                    i++;
                    while(i  < progresses.length){
       
                        int nextP = progresses[i];
                        int nextS = speeds[i];
                        if(100 <= nextP + nextS * day){
                            cnt++;
                        }else{
                            i--;
                            break;
                        }
                        i++;
                    }
                }
            }
            
            ans.add(cnt);
        }
        
      
        return ans.stream().mapToInt(i -> i).toArray();
    }
    
    
    void show(){
        
    }
}