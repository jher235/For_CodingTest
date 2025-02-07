import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static int N;
    public static int S;
    public static int D;
    public static boolean[] check;

    public static List<Integer>[] tree;

    public static int ans = 0;

    //트리 구조 == 이어진 하위 노드 끼리 연결될 수 가 없음. 이동 거리 * 2를 함.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());
        D = Integer.parseInt(stringTokenizer.nextToken());

        check = new boolean[N+1];
        tree = new ArrayList[N+1];
        for (int i=0;i<=N;i++){
            tree[i] = new ArrayList<>();
        }

        for (int i=1;i<N;i++){ //2 ~ N 번째 줄까지
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        check[S] = true;
        dfs(S);
        
        // 음수가 되지 않도록 Math.max(0,)를 붙여줘야 함...
        System.out.println(Math.max(0, (ans-1) * 2)); // 출발 지점 방문을 제외 == -1
    }

    public static int dfs(int currentNode) {
        int max = 0;
        for (int nextNode : tree[currentNode]) {
            if (!check[nextNode]) {
                check[nextNode] = true;
                max = Math.max(max, dfs(nextNode)); // 이어진 노드의 최고 깊이 depth을 보고 이게 D를 넘어가면 ans를 1증가시키고자 함
            }
        }
        max++; // 현재 깊이 1을 더해줌.
        // 이 노드를 최종적으로 방문해야 하는 가를 ( 현재 노드의 최대 depth > D)로 판단하는 것
        if (max > D) ans++;
        return max;
    }
}