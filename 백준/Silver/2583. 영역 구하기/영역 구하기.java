import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static int count =0;
    public static int m,n;

    public static boolean[][] arr;

    public static List<Integer> spaceList = new LinkedList<>();
    public static int space;

    public static int[] ww = {0,1,0,-1};
    public static int[] hh = {-1,0,1,0};
    private static Queue queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        String[] slist = s.split(" ");

        n = Integer.parseInt(slist[1]);
        m = Integer.parseInt(slist[0]);
        arr = new boolean[n][m];

        int c = Integer.parseInt(slist[2]);
        for(int i=0;i<c;i++){
            s = bufferedReader.readLine();
            slist = s.split(" ");
            for(int j=Integer.parseInt(slist[0]); j<Integer.parseInt(slist[2]); j++){
                for(int k=Integer.parseInt(slist[1]); k<Integer.parseInt(slist[3]); k++){
                    arr[j][k] = true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if(!arr[i][j]){
                    count++;
                    space=1;
                    checkSpace(i,j);
                    spaceList.add(space);
                }

            }
        }

        System.out.println(count);
        spaceList.stream().sorted().forEach(i->System.out.print(i+" "));


    }

    private static void checkSpace(int w, int h){
        arr[w][h]=true;

        for(int i=0;i<4;i++){
            int newW =  w+ww[i];
            int newH = h+hh[i];
            if(0<=newW && newW<n && 0<=newH && newH<m){
                if (!arr[newW][newH]){
                    space++;
                   checkSpace(newW, newH);
                }
            }
        }
    };
}