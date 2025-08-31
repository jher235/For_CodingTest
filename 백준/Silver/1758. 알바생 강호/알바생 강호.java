import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static long ans = 0;

    private static List<Integer> tips;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tips = new ArrayList<>(N);

        for (int i=0; i<N; i++){
            tips.add(Integer.parseInt(br.readLine()));
        }

        tips.sort((o1, o2) -> o2 - o1);

        for (int i=0; i<N; i++){
            int tip = tips.get(i);

            if(tip < i){
                break;
            }
            ans += tip - i;

        }

        System.out.println(ans);

    }

}