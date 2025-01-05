import java.io.*;

public class Main {
    static int[] gate;
    static int g, p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        gate = new int[g+1];

        //배열 초기화
        for (int i=0;i<=g;i++){
            gate[i] = i;
        }

        for (int i=0;i<p;i++){
            int airplane = Integer.parseInt(br.readLine());

            int parent = findParent(airplane);
            if(parent == 0){
                System.out.println(i);
                return;
            }
            union(parent-1, parent);
        }

        // 모든 경로를 도킹할 수 있는 경우.....
        System.out.println(p);

    }

    public static int findParent(int input){
        if(input == gate[input]){
            return input;
        } else{
            return gate[input] = findParent(gate[input]); //경로 압축을 하지 않으면 시간초과 발생
        }
    }

    public static void union(int a, int b){
        int parentOfA = findParent(a);
        int parentOfB = findParent(b);

        if(parentOfA < parentOfB){
            gate[b] = parentOfA;
        }else{
            gate[a] = parentOfB;
        }
    }


}