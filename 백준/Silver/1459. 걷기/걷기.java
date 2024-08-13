import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(input);

        long x = Integer.parseInt(stringTokenizer.nextToken());
        long y = Integer.parseInt(stringTokenizer.nextToken());
        int w = Integer.parseInt(stringTokenizer.nextToken());
        int s = Integer.parseInt(stringTokenizer.nextToken());

        long maxCoordinate = Math.max(x, y);
        long minCoordinate = Math.min(x, y);

        if(w*2<s){//한 블록을 대각선으로 이동하는 것 보다 가로,세로로 2칸 이동하는 게 비용이 더 적은 경우
            System.out.println((x+y)*w);
            return;
        }

        if(w>s){// 대각선 이동이 한칸 이동하는 것 보다 비용이 더 적은 경우

            if((x+y)%2==0){ //칸 이동이 짝수일 때
                System.out.println(maxCoordinate*s);
                return;
            }

            //칸 이동이 홀수일 때, 대각선으로 전부 이동하다가 마지막 한칸 이동
            System.out.println(--maxCoordinate*s+w);
            return;
        }

        //대각선 이동이 한칸 이동 보단 비용이 많지만, 2칸 이동보단 비용이 적은 경우
        System.out.println(minCoordinate*s + (maxCoordinate - minCoordinate)*w);
    }
}