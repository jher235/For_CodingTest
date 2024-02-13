import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static int weight =0;
    static int height =0;
    static String[][] arr;

    private static void findw(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[i][j].equals(".")&&arr[i][j+1].equals(".")) {
                    weight++;
                    while (!arr[i][j].equals("X") && j<n-1){
                        j++;
                    }
//                    System.out.println("1");
                }
            }
        }
    }

    private static void findh(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j][i].equals(".")&&arr[j+1][i].equals(".")) {
                    height++;
                    while (!arr[j][i].equals("X") && j<n-1){
                        j++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

//        Scanner sc = new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        arr = new String[n][n];

        for (int i=0;i<n;i++){
            arr[i] = br.readLine().split("");
        }

        findw();
        findh();
        System.out.println(weight+" "+height);

        br.close();

    }

}
