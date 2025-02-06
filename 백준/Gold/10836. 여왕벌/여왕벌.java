import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static int M;
    public static int N;

    public static int[] hive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        // 2차원 배열을 사용하지 않아도됨. -> 각 행의 가장 맨 위 값을 그대로 가져갈 수 밖에 없음. (0, 1, 2순으로 증가하므로,,, 왼쪽이 오른쪽보다 커질 수가 없음.)
        hive = new int[2*M-1];
        Arrays.fill(hive, 1);

        for (int i=0;i<N;i++) {
            stringTokenizer = new StringTokenizer(br.readLine(), " ");

            int current = 0;
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                for (int k = 0; k < num; k++) {
                    hive[current] += j;
                    current++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i=M-1;i>=0;i--){
            stringBuilder.append(hive[i]).append(" ");
            for (int j=M;j<2*M-1;j++){
                stringBuilder.append(hive[j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}