class Solution {
    public int[] solution(String[] wallpaper) {

        int maxCol, minCol;
            
        int maxRow = maxCol = Integer.MIN_VALUE;
        int minRow = minCol = Integer.MAX_VALUE;
        
        for(int i=0; i<wallpaper.length;i++){
            // for(char c : wallpaper)
            for(int j=0; j<wallpaper[i].length();j++){
                char c = wallpaper[i].charAt(j);
                if(c=='#'){
                    maxRow = Math.max(i, maxRow);
                    maxCol = Math.max(j, maxCol);
                    minRow = Math.min(i, minRow);
                    minCol = Math.min(j, minCol);
                }
            }
        }
        
        
        int[] answer = {minRow, minCol, maxRow+1, maxCol+1};
        
        return answer;
    }
}