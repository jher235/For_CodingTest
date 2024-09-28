import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        //문제의 핵심은 이등변 삼각형이라는 것... 따라서 모든 지점에 케이블을 까는 것이 비용이 더 적게들 수 밖에 없다.
        long ans=0;
        int prePoint = Integer.parseInt(stringTokenizer.nextToken());
        while (stringTokenizer.hasMoreElements()){
            int point = Integer.parseInt(stringTokenizer.nextToken()); //다음 지점 높이 가져옴
            ans += (long) (Math.pow(prePoint+point ,2) + Math.pow(Math.abs(prePoint-point),2)); //피타고라스를 사용하여 (거리 제곱 + 높이 제곱)을 계산
            prePoint = point;
        }

        System.out.println(ans);
    }

}