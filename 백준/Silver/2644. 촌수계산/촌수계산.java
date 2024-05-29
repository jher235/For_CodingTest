
import java.util.Scanner;

class Main {

    static int[][] arr;
    static int[] check;

    static int p1, n, m;
    static int p2;
    static int ans = -1;

    private static void search(int t, int num) {
        t++;
        check[num]=1;

        for (int i = 1; i < n + 1; i++) {
            if (arr[num][i] == 1) {
                if (i == p2) {
                    if(ans==-1) ans = t;
                    ans = (Math.min(t, ans));
                }
//               arr[num][i] =0;
                if(check[i]!=1)
                search(t, i);
            }
        }
    }

    public static void main(String[] args) {


//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        p1 = Integer.parseInt(s[0]);
        p2 = Integer.parseInt(s[1]);
        m = Integer.parseInt(sc.nextLine());

//        List<List<Integer>> arr = new LinkedList<>();
        arr = new int[n + 1][n + 1];
        check = new int[n + 1];

        for (int i = 0; i < m; i++) {
            String[] relation = sc.nextLine().split(" ");
            arr[Integer.parseInt(relation[0])][Integer.parseInt(relation[1])] = 1;
            arr[Integer.parseInt(relation[1])][Integer.parseInt(relation[0])] = 1;
        }

        search(0,p1);

        System.out.println(ans);

    }
}