import java.util.*;
class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
 
        int answer = 0;
        for(int i=1;i<=order.length;i++){
            if(order[answer]!= i){
   
                stack.add(i);
            }else if(order[answer]== i){
                answer++;
              
                // 일치할 경우 컨테이너에 쌓인 짐을 순서에 맞게 뺄 수 있는지 확인
                if(!stack.isEmpty()){
                    int peek = stack.peek();
                    while(peek == order[answer]){
                        
                        answer++;
                        stack.pop();
                        
                        if(!stack.isEmpty()){
                            peek = stack.peek();
                        }else{
                            break;
                        }
                       
                    }
                }

            }
        }
        
        return answer;
    }
}