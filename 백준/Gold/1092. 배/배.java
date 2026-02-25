import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;


class Main{
    private static int N, M;

    private static int[] ships;

    private static List<Integer> goods;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());
        ships = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N;i++){
            ships[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ships);

        M = Integer.parseInt(br.readLine());
        goods = new ArrayList<>(M);
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M;i++){
            goods.add(Integer.parseInt(st.nextToken()));
        }

        goods.sort(Comparator.reverseOrder());

        if(ships[N-1] < goods.get(0)){
            System.out.println(-1);
            return;
        }

        int round = 0;
        while (!goods.isEmpty()){
            round++;

            int goodsNum = 0;
            for (int i = N-1; i>=0; i--){
                if(goods.isEmpty() || goodsNum >= goods.size()){
                    break;
                }

                while (goods.get(goodsNum) > ships[i]){
                    goodsNum++;

                    if(goodsNum >= goods.size()){
                        break;
                    }
                }

                if(goodsNum >= goods.size()){
                    break;
                }
                
                goods.remove(goodsNum);

                if(goodsNum >= goods.size()){
                    break;
                }
            }

        }
        System.out.println(round);

    }
}