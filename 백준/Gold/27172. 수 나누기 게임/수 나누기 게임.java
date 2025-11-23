import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    private static int N;

    private static boolean[] exist;
    private static int[] score;

    private static int MAX_CARD_NUMBER = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        List<Integer> players = new ArrayList<>(N);

        exist = new boolean[MAX_CARD_NUMBER + 1];
        score = new int[MAX_CARD_NUMBER + 1];

        // exist 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int currentCard = Integer.parseInt(st.nextToken());
            players.add(currentCard);
            exist[currentCard] = true;
        }

        // 순회하며 확인
        for (int currentCard : players) {
            for (int multipleCard = currentCard * 2; multipleCard <= MAX_CARD_NUMBER; multipleCard += currentCard) {
                if(exist[multipleCard]){
                    score[currentCard]++;
                    score[multipleCard]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int card : players) {
            sb.append(score[card]).append(" ");
        }

        System.out.println(sb);
    }

}