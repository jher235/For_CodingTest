import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


class Main{
    private static int N;
    private static int[] dp;

//    private static int[] tree;

    private static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            if(number<0) continue;

            tree.get(number).add(i);
            dp[number]++;
        }


        // 거꾸로 돌면서
        for (int i = N-1; i >= 0 ; i--) {
            List<Integer> edges = tree.get(i);

            if(edges.isEmpty()) continue;

            List<Integer> values = edges.stream()
                .map(edge -> dp[edge])
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

            int maxValue = Integer.MIN_VALUE;
            for (int j = 0; j < values.size(); j++){
                maxValue = Math.max(values.get(j) + j + 1, maxValue);
            }
            dp[i] = maxValue;
        }

        System.out.println(dp[0]);

    }

}