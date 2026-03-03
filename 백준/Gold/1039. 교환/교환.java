import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;


class Main{

    private static String N;
    private static int K;
    private static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = st.nextToken();
        K = Integer.parseInt(st.nextToken());


        Set<String> set = new HashSet<>();

        for (int i=0; i<N.length(); i++){
            for (int j=i+1; j<N.length(); j++){
                swapAndAdd(set, N, i, j);
            }
        }

        if(N.length() < 2 || set.isEmpty()){
            System.out.println(-1);
            return;
        }

        for (int i=0; i<K-1; i++){
            Set<String> nextSet = new HashSet<>();
            
            set.forEach(
                cur -> {
                    for (int j=0; j<N.length(); j++){
                        for (int k=j+1; k<N.length(); k++){
                            swapAndAdd(nextSet, cur, j, k);
                        }
                    }
                }
            );

            set = nextSet;
        }


        set.forEach(
            cur ->{
                ans = Math.max(ans, Integer.parseInt(cur));
            }
        );

        System.out.println(ans);
    }

    private static void swapAndAdd(Collection<String> queue, String data, int i, int j){
        char[] c = data.toCharArray();

        if((i == 0 || j == 0) && (c[i] == '0' || c[j] == '0')){
            return;
        }

        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;

        queue.add(String.valueOf(c));
    }

}
