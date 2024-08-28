import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int[] diceFace = new int[6];
        int[] minFace = new int[3]; //면의 개수에 따른 최소 값. 면의 개수는 1,2,3개를 노출하는 경우만 있으므로 3면까지 저장한다.

        for (int i=0;i<3;i++){
            minFace[i] = Integer.MAX_VALUE;
        }

        for (int i=0;i<6;i++){
            diceFace[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i=0;i<6;i++){
            minFace[0] = Math.min(minFace[0], diceFace[i]);
            for(int j=i+1;j<6;j++){
                if(i+j==5){ //<A, F>, <B, E>, <C, D> 면은 정반대에 위치하기 때문에 겹칠 수 없다.
                    continue;
                }
                minFace[1] = Math.min(minFace[1], diceFace[i] + diceFace[j]);
                for (int k=j+1;k<6;k++){
                    if(i+k == 5 || j+k == 5){
                        continue;
                    }
                    minFace[2] = Math.min(minFace[2], diceFace[i] + diceFace[j] + diceFace[k]);
                }
            }
        }

        if (n==1){
            int ans = 0 ;
            int maxFace = Integer.MIN_VALUE; //주사위의 최대 면.
            for (int i=0; i<6; i++){
                maxFace = Math.max(maxFace, diceFace[i]);
                ans += diceFace[i];
            }
            ans -= maxFace;
            System.out.println(ans);
            return;
        }

        //각각 면 3개가 보이는 주사위, 면 2개가 보이는 주사위, 면 1개가 보이는 주사위를 나눠서 계산.
        long ans = minFace[2] * 4 + minFace[1] * 4 * (2*n-3) +  minFace[0] * (4 * (n-1) * (n-2) + (n-2)*(n-2));

        System.out.println(ans);
    }
}