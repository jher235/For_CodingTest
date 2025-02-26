import java.util.*;

class Solution {
    
    public static List<String> wordList;
    public static int ans = 0;
    
    public static Queue<Word> queue = new LinkedList<>();
        
    public static class Word{
        public int count;
        public String str;
        
        public Word(int c, String str){
            this.count = c;
            this.str = str;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        
        wordList = new ArrayList<>(Arrays.asList(words));
        
        queue.add(new Word(0, begin));
        
        while(!queue.isEmpty()){
            Word current = queue.poll();
            List<String> delList = new ArrayList<>(); //삭제할 것들을 모아서 한번에 처리
            for(String word : wordList){
                if(isChangeable(current.str, word)){
                    if(word.equals(target)){
                        return current.count + 1;
                    }
                    queue.add(new Word(current.count + 1, word));
                    delList.add(word);
                    // wordList.remove(word); //순회하면서 삭제 안됨
                }
            }
            for(String word: delList){
                wordList.remove(word);
            }
        }
        
        return ans;
    }
    
    private static boolean isChangeable(String curStr, String nextStr){
        int count =0;
        for(int i=0;i<curStr.length();i++){
            if(curStr.charAt(i) != nextStr.charAt(i)){
                count++;
                if(count>1) return false;
            }
        }
        return true;
    }
}