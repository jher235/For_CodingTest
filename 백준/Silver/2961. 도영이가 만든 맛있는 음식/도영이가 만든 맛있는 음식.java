import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int ans = Integer.MAX_VALUE;

    private static int[][] ingredients;


    // 버튼은 동시에 누르는 거네.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        ingredients = new int[N][2];

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken());
            ingredients[i][1] = Integer.parseInt(st.nextToken());
        }

        solve(0, 1, 0, 0);

        System.out.println(ans);
    }

    private static void solve(int idx, int currentS, int currentB, int count){

        if(count != 0){ // 재료 선택 개수가 0이라면 계산 안하도록
            int balance = Math.abs(currentS - currentB);
            ans = Math.min(balance, ans);
        }

        if(idx >= N){
            return;
        }

        solve(idx+1, currentS, currentB, count);
        solve(idx+1, currentS * ingredients[idx][0], currentB + ingredients[idx][1], count+1);
        
    }
    
}