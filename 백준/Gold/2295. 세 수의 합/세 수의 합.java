import java.io.*;
import java.util.*;


public class Main {

    static int N;
    static int U;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        arr = new int[N];

        for (int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                int minus = arr[i] - arr[j];
                Integer value = map.get(minus);
                if(value != null){
                    if(value < arr[i]){
                        map.put(minus, arr[i]);
                    }
                }
                map.put(minus, arr[i]);
            }
        }

        int ans =0;
        for (int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                int sum = arr[i] + arr[j];
                Integer value = map.get(sum);
                if(value != null){
                    ans = Math.max(value, ans);
                }
            }
        }

        System.out.println(ans);

    }

}