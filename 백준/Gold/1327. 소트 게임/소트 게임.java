import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Permutation{
        private int count;
        private String num;

        public Permutation(int count, String num) {
            this.count = count;
            this.num = num;
        }
    }

    public static final HashSet<String> set = new HashSet<String>();

    public static int N, K;
    public static String ans;

    private static int bfs(String numbers){
        Queue<Permutation> queue = new LinkedList<>();

        queue.add(new Permutation(0, numbers));

        while (!queue.isEmpty()){
            Permutation permutation = queue.poll();

            if(permutation.num.equals(ans)){
                return permutation.count;
            }

            for (int i=0; i<=N-K;i++){
                char[] chars = permutation.num.toCharArray();

                for (int j=0; j<(K/2); j++){
                    char tmp = chars[i+j];
                    chars[i+j] = chars[i+K-1-j];
                    chars[i+ K-1 -j] = tmp;
                }
                String nextString = new String(chars);

                // System.out.println(nextString);

                if(!set.contains(nextString)){
                    set.add(nextString);
                    queue.add(new Permutation(permutation.count + 1, nextString));
                }

            }
        }

        return -1;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i=1; i<=N; i++){
            sb.append(i);
        }
        ans = sb.toString();

        st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        while (st.hasMoreTokens()){
            sb.append(st.nextToken());
        }
        String numbers = sb.toString();
        set.add(numbers);

        System.out.println(bfs(numbers));

    }


}