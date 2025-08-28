import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, D, K;
    private static int ans = 0;

    private static int[] students;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        students = new int[N];

        // 풀 수 있는 문제 여부를 비트로 계산
        for (int i=0; i< N; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()){
                int canSolve = Integer.parseInt(st.nextToken());
                students[i] |= (1 << canSolve);
            }

        }

        // for (int student : students){
        //     System.out.println(Integer.toBinaryString(student));
        // }

        selectProblems(0, 0);

        System.out.println(ans);
    }

    private static void selectProblems(int idx, int problemBit){

        int currentProblemCount = Integer.bitCount(problemBit);

        // 최대 문제 수일 경우
        if(currentProblemCount == K){
            ans = Math.max(ans, countSolveAbleStudents(problemBit));
            return;
        }

        // 풀 수 있는 문제 수 전부 순회한 경우. 이 부분을 위에서 실행하면 안됨. D 번째를 고려못하고 끝나버려서 답이 틀리게 됨 
        if(idx > D || currentProblemCount > K){
            return;
        }

        selectProblems(idx+1, problemBit);
        selectProblems(idx+1, problemBit | (1 << idx));
    }

    private static int countSolveAbleStudents(int problemBit){
        int count = 0;
        for (int student : students){
            if(problemBit == (problemBit | student)){
                count++;
            }
        }

        // System.out.println("curBit: "+ Integer.toBinaryString(problemBit) + ", cnt: " + count);
        return count;
    }

}