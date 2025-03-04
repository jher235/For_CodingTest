import java.util.*;
class Solution {
    
    
    //투포인터
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<String>(Arrays.asList(gems));
        
        for(String gem : set){
            map.put(gem, 0);
        }
        
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        
        int distinctGems = set.size();
        
        int currentGems = 0;
        
        // Set<String> currentGems = new HashSet<>();
        // int[] countGem = new int[gems.length];
        
        
        int start = 0;
        int end = 0;

        map.put(gems[start], 1);
        currentGems++;
        
        while(start<gems.length-1){
            
            if(distinctGems == currentGems){
                int diff = end - start;
                if(diff < min){
                    
                    min = diff;
                    answer[0] = start + 1;
                    answer[1] = end + 1;
                }
                
                
                int g = map.get(gems[start]) - 1;
                if(g == 0){
                    currentGems--;
                }
                map.put(gems[start], g);
                start++;
                
            }else if(distinctGems > currentGems){
                end++;
                if(end >= gems.length){
                    break;
                }
                int g = map.get(gems[end]) + 1;
                if(g == 1){
                    currentGems++;
                }
                map.put(gems[end], g);
            }
            
        }
        
        
        return answer;
    }
}