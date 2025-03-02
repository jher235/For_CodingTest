import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        int spellSize = spell.length;
        
        for(String word : dic){
            if(word.length() < spellSize) continue;
            
            Set<String> spellSet = new HashSet<String>(Arrays.asList(spell));
            
            for(int i=0; i<word.length(); i++){
                String ch = String.valueOf(word.charAt(i));
                if(spellSet.contains(ch)){
                    spellSet.remove(ch);
                }
            }
            
            if(spellSet.isEmpty()) return 1;
        }
        return 2;
    }
}