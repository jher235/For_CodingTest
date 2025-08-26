import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int maxPerform = 0;
    private static int minGuitar = Integer.MAX_VALUE;

    private static long[] guitars; // 64 bit


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        guitars = new long[N];

        for (int i=0;i<N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            char[] input = st.nextToken().toCharArray();
            for (int j=0;j<M;j++){
                if(input[j] == 'Y'){
                    guitars[i] |= (1L << j); // j 번째 비트를 1로 or 연산.
                }
            }
        }


        fullSearch(0, 0L, 0);

        if(maxPerform == 0){
            System.out.println(-1);
        }else {
            System.out.println(minGuitar);
        }
    }

    private static void fullSearch(int current, long perform, int guitarCount){

        int currentPerform = Long.bitCount(perform); // 현재 가능 곡 수

        // 가능 곡 수가 max 보다 클 경우
        if(currentPerform > maxPerform){
            maxPerform = currentPerform;
            minGuitar = guitarCount;
        }

        // 현재 가능 곡 수가 max 와 동일한데 기타 수가 더 적을 경우
        if(currentPerform == maxPerform && guitarCount < minGuitar){
            minGuitar = guitarCount;
        }

        if(current >= N){
            return;
        }

        // current 기타를 사용하면서 다음 기타로 넘어갈 경우
        fullSearch(current + 1, perform | guitars[current], guitarCount + 1 );

        // current 기타를 사용하지 않으면서 다음 기타로 넘어갈 경우
        fullSearch(current + 1, perform, guitarCount);
    }

}