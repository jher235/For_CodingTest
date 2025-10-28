import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    private static int N;

    private static long ans = 0;

    private static long[] AB;
    private static long[] CD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][4];
        int nPow2 = N * N;
        AB = new long[nPow2];
        CD = new long[nPow2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j++] = Long.parseLong(st.nextToken());
            }
        }

        // 여기서 A + B 의 모든 경우를 AB 에 세팅하고 정렬.
        int sequence = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[sequence++] = arr[i][0] + arr[j][1];
            }
        }
        Arrays.sort(AB);

        // CD 도 정렬
        sequence = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                CD[sequence++] = arr[i][2] + arr[j][3];
            }
        }
        Arrays.sort(CD);

        // AB, CD 의 방향을 반대로 순회하며 답의 개수 찾기.
        int start = 0;
        int end = nPow2 - 1;

        while ( end >= 0 && start <  nPow2 ) {
            long sum = AB[start] + CD[end];

            if(sum == 0){

                long currentAB =  AB[start];
                long currentCD =  CD[end];
                long countSameAB = 0;
                long countSameCD = 0;
                while (start <  nPow2 && AB[start] == currentAB){
                    start++;
                    countSameAB++;
                }
                while (end >= 0 && CD[end] == currentCD){
                    end--;
                    countSameCD++;
                }

                ans += (countSameAB) * (countSameCD); // 곱으로 계산해야하네
            }else if(sum > 0){
                end--;
            }else if(sum < 0){
                start++;
            }
        }

        System.out.println(ans);

    }

}