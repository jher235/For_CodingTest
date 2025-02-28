class Solution {
    // 총 4번의 비교가 있음. change에서 첫번째 row를 뒤집고 행 -> 열, 열 -> 행으로 뒤집기
    // 그냥 change에서 행 -> 열, 열 -> 행으로 뒤집기 이렇게 4개 중 가장 작은 값을 반환
    public int solution(int[][] beginning, int[][] target) {
        
        boolean[][] change = new boolean[target.length][target[0].length];
        
        for(int i=0;i<target.length; i++){
            for(int j=0; j<target[0].length; j++){
                change[i][j] = beginning[i][j] != target[i][j];
            }
        }
        
        
        // 깊은 복사
        boolean[][] changeCopy = new boolean[target.length][target[0].length];
        for(int i=0;i<target.length; i++){
            for(int j=0; j<target[0].length; j++){
                changeCopy[i][j] = change[i][j];
            }
        }
        for(int j=0; j<target[0].length; j++){
            changeCopy[0][j] = !change[0][j];
        }
         

        int reverseRowCount = rowFirst(changeCopy);
        if(reverseRowCount == -1){
            return -1;
        }
        
        for(int i=0;i<target.length; i++){
            for(int j=0; j<target[0].length; j++){
                changeCopy[i][j] = change[i][j];
            }
        }
        for(int j=0; j<target[0].length; j++){
            changeCopy[0][j] = !change[0][j];
        }
        
        int reverseColumnCount = columnFirst(changeCopy);
        
        int reverseAns = Math.min(reverseRowCount + 1, reverseColumnCount + 1);
        
        
        for(int i=0;i<target.length; i++){
            for(int j=0; j<target[0].length; j++){
                changeCopy[i][j] = change[i][j];
            }
        }
   
        
        int rowFirstCount = rowFirst(change);
        if(rowFirstCount == -1){
            return -1;
        }
        
        int columnFirstCount = columnFirst(changeCopy);
        
        
        return Math.min(Math.min(rowFirstCount, columnFirstCount), reverseAns);
    }
    
    private static int rowFirst(boolean[][] change){
        int count = 0;
        for(int i=0;i<change.length; i++){
            if(change[i][0]){
                for(int j=0;j<change[0].length;j++){
                    change[i][j] = !change[i][j];
                }
                count++;
            }
        }
        
        for(int i=0;i<change[0].length; i++){
            if(change[0][i]){
                for(int j=0;j<change.length;j++){
                    change[j][i] = !change[j][i];
                }
                count++;
            }
        }
        
        for(int i=0;i<change.length; i++){
            for(int j=0; j<change[0].length; j++){
                if(change[i][j]){
                    return -1;
                }
            }
        }
        return count;
        
    }
    
    private static int columnFirst(boolean[][] change){
        int count = 0;
        
        for(int i=0;i<change[0].length; i++){
            if(change[0][i]){
                for(int j=0;j<change.length;j++){
                    change[j][i] = !change[j][i];
                }
                count++;
            }
        }
        
        for(int i=0;i<change.length; i++){
            if(change[i][0]){
                for(int j=0;j<change[0].length;j++){
                    change[i][j] = !change[i][j];
                }
                count++;
            }
        }
        

        for(int i=0;i<change.length; i++){
            for(int j=0; j<change[0].length; j++){
                if(change[i][j]){
                    return -1;
                }
            }
        }
        return count;
        
    }
    
    
}