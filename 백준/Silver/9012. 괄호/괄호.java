import java.io.*;
import java.util.*;


public class Main {
    //BufferedReader는 프로그램에서 하나만
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++){
            if(judgeVPS()){ //VPS인지 판단
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    private static boolean judgeVPS() throws IOException {
        char[] inputs = br.readLine().toCharArray(); //문자 배열로 받음. 한글자씩 분리하기 위함.
        Stack<Boolean> stack = new Stack<>(); //값을 저장 시 가장 메모리를 적게 사용할 boolean 사용

        for (char input : inputs){
            if(input=='('){
                stack.add(true);
                continue;
            }
            if (input==')') {
                try {
                    stack.pop(); //만약 스택에 "("이 없어서 오류 발생 시
                }catch (Exception e){
                    return false;
                }
            }
        }

        if(stack.empty() ){
            return true;
        }
        return false;
    }
}