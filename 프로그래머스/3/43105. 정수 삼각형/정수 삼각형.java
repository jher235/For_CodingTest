class Solution {
    public int solution(int[][] triangle) {
        
        int[] dp = new int[triangle.length];
        
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0){ //시작과 끝은 선택지가 하나임
                    triangle[i][j] += triangle[i-1][0];
                    continue;
                }
                if(j==triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][j-1];
                    continue;
                }
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        int answer = 0;
        
        for(int j=0;j<triangle[triangle.length-1].length;j++){
            if(triangle[triangle.length-1][j] > answer){
                answer = triangle[triangle.length-1][j];
            }
        }
        
        return answer;
    }
}