import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int newScore;
    private static int P;

    private static int[] scores;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        newScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        scores = new int[N];

        if(N == 0){
            System.out.println(1);
            return;
        }
        st = new StringTokenizer(br.readLine());

        for (int i =0; i<N; i++){
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int minScore = scores[N-1];

        if(N >= P && newScore <= minScore){
            System.out.println(-1);
            return;
        }

        int rank = 1;
        int lastScore = scores[0];
        if(lastScore <= newScore){
            System.out.println(rank);
            return;
        }

        for (int i =1; i<N; i++){
            int currentScore = scores[i];

            if(lastScore != currentScore){
                lastScore = currentScore;
                rank = i + 1;
            }

            if(currentScore <= newScore){
                System.out.println(rank);
                return;
            }

        }
        System.out.println(N + 1);

    }

}