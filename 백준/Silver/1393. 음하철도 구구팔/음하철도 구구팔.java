import java.io.*;
import java.util.*;


public class Main {
    private static int endPointX, endPointY;
    private static int startPointX, startPointY;
    private static int moveX, moveY;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        endPointX = Integer.parseInt(stringTokenizer.nextToken());
        endPointY = Integer.parseInt(stringTokenizer.nextToken());

        stringTokenizer = new StringTokenizer(br.readLine());

        startPointX = Integer.parseInt(stringTokenizer.nextToken());
        startPointY = Integer.parseInt(stringTokenizer.nextToken());

        moveX = Integer.parseInt(stringTokenizer.nextToken());
        moveY = Integer.parseInt(stringTokenizer.nextToken());

        optimization(); // 증가하는 dx, dy를 가장 작은 수로 나타냄.
        findJumpingPoint(); // 최소 거리 지점을 찾아내어 출력

    }

    private static void optimization(){
        if(moveY == 0){ //0이라면 가장 작은 수인 1씩 이동하도록 할 수 있다. 이때 기존 값의 부호를 고려해줘야 한다. 
            if(moveX>0){    
                moveX = 1;
                return;
            }
            moveX = -1;
            return;
        }
        if(moveX == 0){
            if(moveY > 0){
                moveY = 1;
                return;
            }
            moveY = -1;
            return;
        }
        int i=2;

        while (true){
            if(i>moveX || i>moveY){ //나누는 수보다 이동 수가 더 커졌다면 더 이상 나눌 수 없으므로 리턴.
                return;
            }
            if (moveX % i == 0 && moveY % i == 0 ){ //i가 dx, dy의 공약수라면 나눔.
                moveX /= i;
                moveY /= i;
                continue;
            }
            i++; //나뉘지 않는 수라면 증가.
        }

    }

    private static void findJumpingPoint(){
        Double preDistance = Double.MAX_VALUE;
        int currentPointX = startPointX;
        int currentPointY = startPointY;

        while (true){
            Double currentDistance = Math.pow((endPointX - currentPointX), 2) + Math.pow((endPointY - currentPointY), 2); // 피타고라스 정리. 루트는 생략.
            if(preDistance <= currentDistance){  //직선에서 최소 거리를 구하는 것이므로 거리가 최소가 된 이후에는 다시 늘어날 것임을 이용함.
                System.out.println((currentPointX - moveX) +" "+ (currentPointY - moveY));
                return;
            }
            preDistance = currentDistance;
            currentPointX += moveX;
            currentPointY += moveY;
        }
    }
}