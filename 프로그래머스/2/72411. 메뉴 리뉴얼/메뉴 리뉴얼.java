import java.util.*;

class Solution {
    
    char start = 'A';
    char end = 'Z';
    
    List<Set<String>> cus;
    
    Set<String> cnt = new HashSet<>(); // 한번 사용된걸 저장하는 곳
    Set<String> ans = new HashSet<>(); // 두번 이상 사용된걸 저장하는 곳
    
    int[] course;
    
    Map<String, Integer> map = new HashMap<>();
    
    public String[] solution(String[] orders, int[] course) {
        
        this.course = course;
   
        
       
        
        for(int i=0 ; i< orders.length;i++){
            
            char[] order = orders[i].toCharArray();
            Arrays.sort(order);
            
            StringBuilder sb = new StringBuilder();
            for(int c : course){
                dfs(order, 0, c, sb);
            }
   
        }
        
        for(int c : course){
            int max = 0;
            for(Map.Entry<String, Integer> me : map.entrySet()) {
                if(me.getKey().length() == c){
                    max = Math.max(max, me.getValue());
                }
            }  
            if(max < 2) continue;
            for(Map.Entry<String, Integer> me : map.entrySet()) {
                if(me.getKey().length() == c && me.getValue() == max){
                    ans.add(me.getKey());
                }
            }  
        }
           
        
        
       
        return ans.stream().sorted().toArray(String[]::new); //하 이거 계속 까먹네
    }
    
    // 백트래킹으로?
    
    
            /*
        현재 코스 a
        다음 코스 b 하나
        앞글자부터 비교하면서
        2글자가 선택지에 있으면
            저장
            그리고 바로 3번째 글자를 찾으로 넘어감.
            3번째가 선택지에 있으면 저장
                4번째로
        이렇게 한 다음에 b의 다음 글자로 넘어가서 위 과정 반복
        그 다음에 다음코스 c로 넘어가서 위 과정 반복 
        이렇게 백트래킹?
        */
    
    // 첫번째 단어 두번째 단어
    void dfs(char[] order, int start, int len, StringBuilder sb){
       
        // course에 들어간다면?
        if(sb.length() == len){
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), 1);
            }else{
                map.put(sb.toString(), map.get(sb.toString()) + 1);
            }
            return;
        }
        
        for(int i = start; i< order.length ;i++){
            sb.append(order[i]);
            dfs(order, i+1, len, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }

}