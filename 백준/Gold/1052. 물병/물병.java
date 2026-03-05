
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static int N, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int bc = Integer.bitCount(N);
        int ans = 0;


        while(bc >= 0){
            bc = Integer.bitCount(N);
            if(bc <= K){
                System.out.println(ans);
                return;
            }
            N += 1;
            ans++;
        }

        System.out.println(-1);
        
    }

}
