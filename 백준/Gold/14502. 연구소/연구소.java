import java.io.*;
import java.util.*;

public class Main {

    static int[] moveX = {1, -1, 0,0};
    static int[] moveY = {0,0,1,-1};

    static int n, m;


    static int[][] space;
    static int[][] check;

    static int count2;
    static int minCount2 = Integer.MAX_VALUE;
    static int count1 = 3;

    static List<Node> virus = new LinkedList<>();

    public static class Node{
        int y;
        int x;

        public Node(int i, int j) {
            this.y = i;
            this.x = j;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        space = new int[n][m];
        check = new int[n][m];

        for (int i=0;i<n;i++){
            stringTokenizer = new StringTokenizer(br.readLine()," ");
            for (int j=0;j<m;j++){
                int input = Integer.parseInt(stringTokenizer.nextToken());
                space[i][j] = input;
                if(input == 2){
                    virus.add(new Node(i,j));
                }
                if(input == 1){
                    count1++;
                }
            }
        }
        for (int y =0; y<n;y++){
            for (int x=0;x<m;x++){
                check[y][x] = space[y][x];
            }
        }


        for (int i =0; i< n;i++){
            for (int j=0; j<m;j++){

                if(space[i][j] != 0){
                    continue;
                }
                space[i][j] = 1;

                for (int k=i;k<n;k++){
                    for (int l = 0; l<m;l++){

                        if(space[k][l] != 0){
                            continue;
                        }
                        space[k][l] = 1;
                        for (int o=k; o<n;o++){
                            for (int p=0;p<m;p++){
                                if(space[o][p] != 0){
                                    continue;
                                }
                                space[o][p] = 1;
                                for (int y =0; y<n;y++){ //
                                    for (int x=0;x<m;x++){
                                        check[y][x] = space[y][x];
                                    }
                                }

                                count2 = 0;

                                for (Node node : virus){
                                    dfs(node.x, node.y);
                                }

                                minCount2 = Math.min(count2, minCount2);

                                space[o][p] = 0;

                            }
                        }
                        space[k][l] = 0;
                    }
                }
                space[i][j] = 0;
            }
        }

        System.out.println(n * m - count1 - minCount2);

    }

    public static void dfs(int x, int y){
            count2++;
            check[y][x] = 2;
        for (int i=0;i<4;i++){
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];

            if(nextX>=0 &&  nextX<m && nextY>=0 && nextY<n){
                if(check[nextY][nextX] == 0){
                    dfs(nextX, nextY);
                }
            }
        }
    }
}