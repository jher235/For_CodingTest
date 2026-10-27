import java.util.*;

class Solution {
    
    // d, l, r, u 사전순
    int[] my = new int[] {1, 0, 0, -1};
    int[] mx = new int[] {0, -1, 1, 0};
    char[] dir = new char[] {'d', 'l', 'r', 'u'};
    
    boolean[][][] visited;
    
    int n, m, k, r, c;
    StringBuilder sb = new StringBuilder();
    
    int getDist(int x1,int x2,int y1, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 -y2);
    }
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String ans = "impossible";
        
        this.n = n;
        this.m = m;
        this.k = k;
        this.r = r;
        this.c = c;
        
        int dist = getDist(x, r, y, c);
        if( dist > k || (k - dist) % 2 != 0) return ans;
        
        dfs(x, y, 0);
        return sb.toString();

    }
    
    public boolean dfs(int y, int x, int v){   // y = 행, x = 열
    if(v == k) return y == r && x == c;
    
        for(int i=0;i<4; i++){
            int ny = y + my[i];
            int nx = x + mx[i];

            if(ny < 1 || ny > n || nx < 1 || nx > m) continue;
            if(Math.abs(ny - r) + Math.abs(nx - c) > k - v - 1) continue;

            sb.append(dir[i]);
            if(dfs(ny, nx, v + 1)) return true;
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }
}