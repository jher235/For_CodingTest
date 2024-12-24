import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static String OPERATOR = "+-*/()";
    static String OPERATOR_SIGN = "+-*/";
    static char[] input;
    static Stack<Character> operatorStack = new Stack<>();
    static Queue<Character> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        input = line.toCharArray();

        StringBuilder ans = new StringBuilder();

        for (char c : input){
            queue.add(c);
        }

        while (!queue.isEmpty()){
            Character character = queue.poll();

            if(!OPERATOR.contains(String.valueOf(character))){
                ans.append(character);
                continue;
            }

            if(character=='+' || character=='-'){
                if(!operatorStack.isEmpty()){
                    Character top = operatorStack.peek();
                    while (OPERATOR_SIGN.contains(String.valueOf(top))){
                        ans.append(operatorStack.pop());
                        if(operatorStack.isEmpty()) {
                            break;
                        }
                        top = operatorStack.peek();
                    }
                }
            }

            if(character=='*' || character=='/'){
                if(!operatorStack.isEmpty()){
                    Character top = operatorStack.peek();
                    while (top=='*' || top=='/'){
                        ans.append(operatorStack.pop());
                        if(operatorStack.isEmpty()) {
                            break;
                        }
                        top = operatorStack.peek();
                    }
                }
            }

            if(character==')'){
                if(!operatorStack.isEmpty()){
                    Character top = operatorStack.peek();
                    while (top!='('){
                        ans.append(operatorStack.pop());
                        top = operatorStack.peek();
                    }
                    operatorStack.pop();
                }
                continue;
            }
            operatorStack.add(character);
        }

        while (!operatorStack.isEmpty()){
            ans.append(operatorStack.pop());
        }
        System.out.println(ans);
    }
}