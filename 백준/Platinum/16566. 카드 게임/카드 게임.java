import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    private static int N;
    private static int M;
    private static int K;

    private static int[] parents;
    private static int[] cards;
    private static int[] find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cards = new int[M];
        parents = new int[M];
        find = new int[N+1];

        // parents 초기화
        for (int i=0; i< M; ++i){
            parents[i] = i;
        }

        //card 초기화
        st = new StringTokenizer(br.readLine());
        for (int i=0; i< M; ++i){
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        // 미리 find 배열을 만들어서 사용하고자 함
        for (int i=0; i< cards[0]; ++i){
            find[i] = 0;
        }

        for (int i=1; i< M; ++i){
            for (int j= cards[i-1]; j< cards[i]; ++j){
                find[j] = i;
            }
        }

        StringBuilder ans = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()){
            ans.append(get(find[Integer.parseInt(st.nextToken())])).append("\n");
        }


        System.out.println(ans);

    }

    private static int get(int idx){
        int parentIdx = getParent(idx);
        parents[idx] = parentIdx + 1;
        return cards[parentIdx];
    }

    private static int getParent(int idx){
        if (parents[idx] == idx) return idx;
        return parents[idx] = getParent(parents[idx]);
    }

}