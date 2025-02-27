import java.util.*;

class Solution {
    static List<String> ans;
    static Map<String, List<String>> map = new HashMap<>();
    static int n;

    public String[] solution(String[][] tickets) {

        ans = new LinkedList<>();
        // map = new HashMap<>();
        
        n = tickets.length;
        
        for(int i=0;i<n;i++){
            String start = tickets[i][0];
            String end = tickets[i][1];
            
            if(map.containsKey(start)){
                List<String> ends = map.get(start);
                ends.add(end);
                map.put(start, ends);
            }else{
                List<String> ends = new ArrayList<>();
                ends.add(end);
                map.put(start, ends);
            }
            
        }
        
        for(String start : map.keySet()){
            List<String> ends = map.get(start);
            Collections.sort(ends);
            map.put(start, ends);
        }
        
        String airport = "ICN";
        ans.add(airport);
        dfs(0, airport);
        
        // ans.add(airport);
        // for(int i=0;i<n;i++){
        //     List<String> destAirports = map.get(airport);
        //     airport = destAirports.remove(0);
        //     ans.add(airport);
        // }
        
        String[] answer = ans.toArray(new String[0]);
        return answer;
    }
    
    private static boolean dfs(int depth, String current){
        
        if(depth==n){
            return true;
        }
        
        List<String> ends = map.get(current);
        if (ends == null) return false; // current에 대한 도착지가 없으면 false 반환
        
        for(int i=0; i<ends.size();i++){
            String next = ends.remove(i);
            ans.add(next);
            boolean result = dfs(depth+1, next);
            if(result){
                return result;
            }
            ans.remove(ans.size()-1);
            ends.add(i, next);
        }
        return false;
    }
}