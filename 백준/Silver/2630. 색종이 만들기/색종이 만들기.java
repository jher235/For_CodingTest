import java.io.*;
import java.util.*;


public class Main {

    static int blue=0;
    static int white=0;
    static int[][] coloredPaper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());


        coloredPaper = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                coloredPaper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        countColor(1,1,n);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void countColor(int x, int y, int size){
        int color = coloredPaper[x][y];
        for(int i = x;i<x+size;i++){
            for(int j = y;j<y+size;j++){
                if(coloredPaper[i][j] != color){
                    int nextSize = size/2;
                    countColor(x,y,nextSize);
                    countColor(x+nextSize,y,nextSize);
                    countColor(x,y+nextSize,nextSize);
                    countColor(x+nextSize,y+nextSize,nextSize);
                    return;
                }
            }
        }
        if(color==1){
            blue++;
            return;
        }
        white++;
    }
}