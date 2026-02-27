import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
  
        Map<String, String> name = new HashMap<>();
        
        
        int changeCount = 0;
        for(int i = record.length-1; i>= 0; i-- ) {
            String [] input = record[i].split(" ");
            
            if(input[0].equals("Change")){
                changeCount++;
            }
                
            if (input[0].equals("Change") || input[0].equals("Enter")){
                if (!name.containsKey(input[1])){
                    name.put(input[1], input[2]);
                }
            }
        }
        
        
        String[] answer = new String[record.length - changeCount];
        int idx = 0;
        
        for(int i=0; i< record.length; i++){
            String [] input = record[i].split(" ");
                
            if(input[0].equals("Change")){
                continue;
            }
            
            if (input[0].equals("Enter")){
                if (name.containsKey(input[1])){
                    answer[idx] = name.get(input[1]) + "님이 들어왔습니다.";
                }else{
                    answer[idx] = input[2] + "님이 들어왔습니다.";
                    name.put(input[1], input[2]);
                }
            }
            
            if (input[0].equals("Leave")){
                if (name.containsKey(input[1])){
                    answer[idx] = name.get(input[1]) + "님이 나갔습니다.";  
                }
            }
            
            idx++;
        }
        
        return answer;
    }
}