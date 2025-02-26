class Solution {
    public int solution(int[] money) {
        int n = money.length;
        
        int[] visitFirst = new int[n-1]; // 최초 방문 고려
        int[] nonVisitFirst = new int[n]; // 마지막 방문 고려
        
        visitFirst[0] = money[0];
        visitFirst[1] = Math.max(money[0], money[1]);
        
        for(int i=2; i<n-1; i++){
            visitFirst[i] = Math.max(visitFirst[i-1], visitFirst[i-2] + money[i]);
        }
        
        nonVisitFirst[1] = money[1];
        nonVisitFirst[2] = Math.max(money[1], money[2]);
        
        for(int i=2; i<n; i++){
            nonVisitFirst[i] = Math.max(nonVisitFirst[i-1], nonVisitFirst[i-2] + money[i]);
        }
        
        return Math.max(visitFirst[n-2], nonVisitFirst[n-1]);
    }
}