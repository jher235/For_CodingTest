import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {

    static int N;
    static int[][] arr;
    static int ansMinusOne = 0;
    static int ansZero = 0;
    static int ansPlusOne = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stringTokenizer.nextToken());
        arr = new int[N][N];

        for (int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j=0;j<N;j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        division(0, 0, N);

        System.out.println(ansMinusOne+"\n"+ansZero+"\n"+ansPlusOne);
    }

    public static void division(int startX, int startY, int length) {
        int number = arr[startY][startX];
        for (int i = startY; i < startY + length; i++) {
            for (int j = startX; j < startX + length; j++) {
                if (arr[i][j] != number) {
                    for (int k = startY; k < startY + length; k += length / 3) {
                        for (int l = startX; l < startX + length; l += length / 3) {
                            division(l, k, length / 3);
                        }
                    }
                    return;
                }
            }
        }
        if (number == -1) {
            ansMinusOne++;
        } else if (number == 0) {
            ansZero++;
        } else {
            ansPlusOne++;
        }

    }

}