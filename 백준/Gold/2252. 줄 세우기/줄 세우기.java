import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static final int MAX_VALUE = 32001;
    static boolean[] used = new boolean[MAX_VALUE];

    static int n;
    static int m;

    static List<Integer> ans = new LinkedList<>();
    static List<Integer>[] arr = new List[MAX_VALUE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=1; i<MAX_VALUE; i++){
            arr[i] = new ArrayList<>();

        }
        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            arr[back].add(front);
        }

        for (int i=1; i<=n; i++){
            if(!used[i]){
                dfs(i);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : ans){
            stringBuilder.append(i + " ");
        }

        System.out.println(stringBuilder);
    }

    private static void dfs(int num){
        used[num] = true;
        List<Integer> list = arr[num];
        for (Integer i : list){
            if(!used[i]){
                dfs(i);
            }
        }
        ans.add(num);
    }

}