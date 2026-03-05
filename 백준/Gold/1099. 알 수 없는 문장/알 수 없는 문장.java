import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static Map<String, List<String>> maps = new HashMap<>();

    private static String sen;
    private static int N, K;

    private static int[] dp;

    private static int MAX_V = 99999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        sen = br.readLine();

        dp = new int[sen.length() + 1];

        for (int i = 0; i <= sen.length(); i++) {
            dp[i] = MAX_V;
        }

        dp[0] = 0;


        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            String input = br.readLine();
            String sorted = getSorted(input);

            maps.computeIfAbsent(sorted, k -> new ArrayList<>())
                .add(input);

        }

        for (int i=1; i<= sen.length(); i++){

            for (String w : maps.keySet()){
                if(i >= w.length()){ // 단어보다 길이가 길면, 그 부분만큼 잘라서 비교 후 비용 계산
                    int start = i - w.length() ;
                    String sub = sen.substring(start, i);
                    String sorted = getSorted(sub);
                    if(maps.keySet().contains(sorted)){
                        List<String> origins = maps.get(sorted);

                        int cost = Integer.MAX_VALUE;
                        for (int o= 0; o<origins.size(); o++){
                            cost = Math.min(cost, getCost(origins.get(o), sub));
                        }

                        if(dp[start] != MAX_V){
                            dp[i] = Math.min(dp[start] + cost , dp[i]);
                        }
                    }
                }
            }
            for (int j=0; j<=i; j++){

            }
        }

        if(dp[sen.length()] != MAX_V){
            System.out.println(dp[sen.length()]);
            return;
        }

        System.out.println(-1);
    }

    private static String getSorted(String input){
        char[] c = input.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

    private static int getCost(String origin, String changed){
        int cost = 0;

        for (int i=0; i<origin.length(); i++){
            if(origin.charAt(i) != changed.charAt(i)){
                cost++;
            }
        }

        return cost;
    }

}
